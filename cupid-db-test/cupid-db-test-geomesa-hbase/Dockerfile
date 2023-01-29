FROM java:8-jdk

ENV HBASE_VERSION=2.2.7
ENV BASE_DIR=/usr/local
ENV HBASE_HOME=${BASE_DIR}/hbase-${HBASE_VERSION}

# online version
#RUN cd ${BASE_DIR} \
#    && curl -fSL "http://archive.apache.org/dist/hbase/${HBASE_VERSION}/hbase-${HBASE_VERSION}-bin.tar.gz" -o hbase.tar.gz \
#    && tar xfvz hbase.tar.gz \
#    && rm -rf hbase.tar.gz

# local version
WORKDIR ${BASE_DIR}
ADD hbase-${HBASE_VERSION}-bin.tar.gz .
# default geomesa coprocessor
COPY geomesa-hbase-distributed-runtime-hbase2_2.12-3.2.2.jar ${HBASE_HOME}/lib/

EXPOSE 2181 16010 16020 16000

# keep waiting
ENTRYPOINT ${HBASE_HOME}/bin/start-hbase.sh && tail -f /dev/null


# docker build -t geomesa-hbase .
# docker run --hostname geomesa-hbase-local --name geomesa-hbase -p 2181:2181 -p 16020:16020 -p 16000:16000 -v /your-local-geomesa-coprocessor.jar:/usr/local/hbase-2.2.7/lib/geomesa-hbase-runtime-3.2.2.jar -d geomesa-hbase
# docker run --hostname geomesa-hbase-local --name geomesa-hbase -p 2181:2181 -p 16020:16020 -p 16000:16000 -d geomesa-hbase

