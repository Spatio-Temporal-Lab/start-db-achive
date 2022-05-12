FROM maven:3.8-jdk-8
ADD mini-hbase mini-hbase
ENTRYPOINT ["mvn", "test","exec:java", "-f","mini-hbase/pom.xml"]
EXPOSE 2000-20000