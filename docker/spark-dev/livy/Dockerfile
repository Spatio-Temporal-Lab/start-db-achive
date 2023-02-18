FROM eclipse/ubuntu_jdk8:latest

ENV BASE_HOME /usr

# HADOOP
#ENV HADOOP_VERSION 3.2.3
#ENV HADOOP_HOME /usr/hadoop-$HADOOP_VERSION
#ENV HADOOP_CONF_DIR=$HADOOP_HOME/etc/hadoop
#ENV PATH $PATH:$HADOOP_HOME/bin
#
#ADD ./$HADOOP_HOME.tar.gz $BASE_HOME

# SPARK
ENV SPARK_VERSION 3.0.2
ENV SPARK_PACKAGE spark-${SPARK_VERSION}-bin-hadoop3.2
ENV SPARK_HOME $BASE_HOME/$SPARK_PACKAGE
ENV SPARK_DIST_CLASSPATH="$HADOOP_HOME/etc/hadoop/*:$HADOOP_HOME/share/hadoop/common/lib/*:$HADOOP_HOME/share/hadoop/common/*:$HADOOP_HOME/share/hadoop/hdfs/*:$HADOOP_HOME/share/hadoop/hdfs/lib/*:$HADOOP_HOME/share/hadoop/hdfs/*:$HADOOP_HOME/share/hadoop/yarn/lib/*:$HADOOP_HOME/share/hadoop/yarn/*:$HADOOP_HOME/share/hadoop/mapreduce/lib/*:$HADOOP_HOME/share/hadoop/mapreduce/*:$HADOOP_HOME/share/hadoop/tools/lib/*"
ENV PATH $PATH:${SPARK_HOME}/bin

ADD ./$SPARK_PACKAGE.tgz $BASE_HOME

ENV LIVY_BUILD_VERSION 0.7.1-incubating
ENV LIVY_PACKAGE apache-livy-$LIVY_BUILD_VERSION-bin
ENV LIVY_HOME $BASE_HOME/$LIVY_PACKAGE
ENV LIVY_LOG $LIVY_HOME/logs

ADD ./$LIVY_PACKAGE.tar.gz $BASE_HOME
COPY ./livy.conf $LIVY_HOME/conf/
RUN mkdir -p $LIVY_LOG

ENTRYPOINT $LIVY_HOME/bin/livy-server


