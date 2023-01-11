build ss proxy server docker image

1. build ss package

```shell
mvnw install -Prelease -T1C -DskipTests -Djacoco.skip=true -Dcheckstyle.skip=true -Drat.skip=true -Dmaven.javadoc.skip=true -B
```

2. get the package in `shardingsphere-distribution/shardingsphere-proxy-distribution/target/apache-shardingsphere-5.1.2-SNAPSHOT-shardingsphere-proxy-bin.tar.gz`

3. unzip `apache-shardingsphere-5.1.2-SNAPSHOT-shardingsphere-proxy-bin.tar.gz`

4. delete `lib/avatica-core-1.17.0.jar`, `start-db-avatica-core-1.0.0-SNAPSHOT.jar`

5. add `mysql-connector-java-5.1.47.jar`, `start-db-jdbc-driver-1.0.0-SNAPSHOT.jar`(package first) to `lib`

6. compress to zip now and rename to `ss-proxy.zip`

7. copy `ss-proxy.zip` to current directory

8. build ss-proxy image:

```shell
docker build -t ss-proxy:1.0.0 .
```

9. test

replace `192.168.0.100` to your start-db ip
```shell
docker run --add-host=start-db:192.168.0.100 -v ./conf:/usr/local/ss-proxy/conf --name ss-proxy -d -p 3307:3307 ss-proxy:1.0.0 
```

10. deploy to dockerhub

```shell
docker tag ss-proxy:1.0.0 spatiotemporallab/ss-proxy:1.0.0
docker push spatiotemporallab/ss-proxy:1.0.0
```

