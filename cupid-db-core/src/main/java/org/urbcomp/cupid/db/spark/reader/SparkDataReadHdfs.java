/* 
 * Copyright (C) 2022  ST-Lab
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.urbcomp.cupid.db.spark.reader;

import com.fasterxml.jackson.core.type.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocatedFileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.RemoteIterator;
import org.apache.hadoop.hbase.exceptions.IllegalArgumentIOException;
import org.urbcomp.cupid.db.config.DynamicConfig;
import org.urbcomp.cupid.db.datatype.DataConvertFactory;
import org.urbcomp.cupid.db.datatype.DataTypeField;
import org.urbcomp.cupid.db.infra.MetadataResult;
import org.urbcomp.cupid.db.spark.ISparkDataRead;
import org.urbcomp.cupid.db.util.JacksonUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jimo
 **/
@Slf4j
public class SparkDataReadHdfs implements ISparkDataRead {

    @Override
    public <T> MetadataResult<T> read(String sqlId) {
        try {
            final FileSystem fs = getFileSystem();
            final String basePath = DynamicConfig.getSparkHdfsResultPath();
            String schemaPathDir = basePath + DynamicConfig.getResultSchemaName(sqlId);
            String dataPathDir = basePath + DynamicConfig.getResultDataName(sqlId);
            final List<DataTypeField> fields = readFields(fs, schemaPathDir);
            List<Object[]> data = readData(fs, dataPathDir, fields);

            return (MetadataResult<T>) MetadataResult.buildResult(
                fields.stream().map(DataTypeField::getName).toArray(String[]::new),
                data
            );
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Object[]> readData(FileSystem fs, String dataPathDir, List<DataTypeField> fields)
        throws IOException {
        final List<String> dataLines = readHdfsFile(fs, dataPathDir);
        List<Object[]> data = new ArrayList<>(Math.max(1, dataLines.size()));

        for (String line : dataLines) {
            final String[] items = line.split(DynamicConfig.getHdfsDataSplitter());
            Object[] row = deserializeToRow(items, fields);
            data.add(row);
        }
        return data;
    }

    /**
     * 根据数据类型反序列化为原始类型
     */
    private Object[] deserializeToRow(String[] items, List<DataTypeField> fields) {
        if (fields.isEmpty() || items.length != fields.size()) {
            log.error("data and schema is inconsistent:{}<->{}", items, fields);
            throw new IllegalArgumentException("data and schema is inconsistent");
        }
        Object[] row = new Object[items.length];
        for (int i = 0; i < items.length; i++) {
            row[i] = DataConvertFactory.convert(items[0], fields.get(i));
        }
        return row;
    }

    private List<DataTypeField> readFields(FileSystem fs, String schemaPathDir) throws IOException {
        final List<String> fieldLine = readHdfsFile(fs, schemaPathDir);
        if (fieldLine.isEmpty()) {
            throw new RuntimeException("Schema is empty: " + schemaPathDir);
        }
        final String schemaJson = fieldLine.get(0);
        return JacksonUtil.MAPPER.readValue(schemaJson, new TypeReference<List<DataTypeField>>() {
        });
    }

    private List<String> readHdfsFile(FileSystem fs, String pathDir) throws IOException {
        final RemoteIterator<LocatedFileStatus> files = fs.listFiles(new Path(pathDir), false);
        Path path = null;
        while (files.hasNext()) {
            final LocatedFileStatus file = files.next();
            if (file.isFile() && file.getPath().getName().startsWith("part")) {
                path = file.getPath();
                break;
            }
        }
        if (path == null) {
            throw new IllegalArgumentIOException("hdfs result not exist: " + pathDir);
        }
        log.info("Read HDFS result:{}", path);
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(fs.open(path)))) {
            final String line = br.readLine();
            lines.add(line);
        }
        return lines;
    }

    private FileSystem getFileSystem() throws IOException, URISyntaxException {
        Configuration conf = new Configuration();
        String hdfsPath = DynamicConfig.getHdfsPath();
        System.setProperty("HADOOP_USER_NAME", DynamicConfig.getHadoopUser());
        return FileSystem.get(new URI(hdfsPath), conf);
    }
}
