# how to build the hbase docker image with geomesa coprocessor

1.download the hbase binary [hbase-2.2.7-bin.tar.gz](http://archive.apache.org/dist/hbase/)

2.download the geomesa coprocessor jar [geomesa-hbase-distributed-runtime-hbase2_2.12-3.2.2.jar](https://github.com/locationtech/geomesa/releases)

3.write the [Dockerfile](./Dockerfile)

4.copy `hbase-2.2.7-bin.tar.gz`, `geomesa-hbase-distributed-runtime-hbase2_2.12-3.2.2.jar` to the same dir of Dockerfile

5.build the image

```shell
docker build -t geomesa-hbase .
```

6.run hbase container

```shell
docker run --hostname geomesa-hbase-local --name geomesa-hbase -p 2181:2181 -p 16020:16020 -p 16000:16000 -d geomesa-hbase
```

if you want to bind your own geomesa-coprocessor, use docker volume cmd to bind your jar:

```shell
docker run --hostname geomesa-hbase-local \
 --name geomesa-hbase \
 -p 2181:2181 -p 16020:16020 -p 16000:16000 \ 
 -v /your-local-geomesa-coprocessor.jar:/usr/local/hbase-2.2.7/lib/geomesa-hbase-runtime-3.2.2.jar \ 
 -d geomesa-hbase
```

7.one more thing, add the host mapping below to your hosts, otherwise you cannot access the hostname `geomesa-hbase-local` that the hbase bind in container 

```shell
127.0.0.1 geomesa-hbase-local
```

# upload the image to dockerhub

```shell
docker tag geomesa-hbase spatiotemporallab/geomesa-hbase
docker push spatiotemporallab/geomesa-hbase
```






