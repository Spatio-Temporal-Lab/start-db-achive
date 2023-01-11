build start-db server docker image

1. build server jar

```shell
mvn package -pl start-db-server -am -DskipTests -Dcheckstyle.skip
```

2. copy `start-db.jar` to current dir
   
3. build image

```shell
docker build -t start-db-server:1.0.0 .
```

4. run image and test

```shell
docker run --name start-db -p 8000:8000 -d start-db-server:1.0.0
```

5. deploy to dockerhub

```shell
docker tag start-db-server:1.0.0 spatiotemporallab/start-db-server:1.0.0
docker push spatiotemporallab/start-db-server:1.0.0
```
