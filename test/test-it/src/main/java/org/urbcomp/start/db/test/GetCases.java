package org.urbcomp.start.db.test;
import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

public class GetCases {

    public static ArrayList<String> getSqlCaseXMLs() {
        // 读取 cases的文件列表
        String casePath = Objects.requireNonNull(GetCases.class.getClassLoader().getResource("cases")).getPath();
        String[] foldList = new File(casePath).list();
        ArrayList<String> caseFileList = new ArrayList<>();
        if(foldList != null) {
            for (String fold : foldList) {
                String foldPath = casePath + File.separator + fold;
                caseFileList.addAll(getFilesInFold(foldPath));
            }
        }else {
            System.out.println("文件内容为空");
        }
        return caseFileList;
    }

    // 传入文件夹名称, 返回文件夹下的文件路径列表, 不包括文件夹
    public static ArrayList<String> getFilesInFold(String foldPath){
        String[] fileList =  new File(foldPath).list();
        ArrayList<String> fileArrayList = new ArrayList<>();
        if (fileList != null) {
            for (String fileName : fileList) {
                File file = new File(foldPath + File.separator + fileName);
                if (file.isFile() && !file.isDirectory()){
                    fileArrayList.add(file.getPath());
                }
            }
        }
        return fileArrayList;
    }
}
