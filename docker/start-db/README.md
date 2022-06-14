build start-db server docker image

1. build server jar

```shell
mvn package -pl start-db-server -am -DskipTests -Dcheckstyle.skip
```

2. build image

```shell
docker build -t start-db-server:1.0.0 .
```
