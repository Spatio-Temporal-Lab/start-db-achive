build cupid-db server docker image

1. build server jar

```shell
mvn package -pl cupid-db-server -am -DskipTests -Dcheckstyle.skip
```

2. copy `cupid-db.jar` to current dir
   
3. build image

```shell
docker build -t cupid-db-server:1.0.0 .
```

4. run image and test

```shell
docker run --name cupid-db -p 8000:8000 -d cupid-db-server:1.0.0
```

5. deploy to dockerhub

```shell
docker tag cupid-db-server:1.0.0 spatiotemporallab/cupid-db-server:1.0.0
docker push spatiotemporallab/cupid-db-server:1.0.0
```
