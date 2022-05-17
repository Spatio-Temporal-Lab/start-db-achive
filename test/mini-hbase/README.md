# build hbase image

1. package jar

```shell
cd test/mini-hbase
mvn package -DskipTests=true
```

2. build docker image

```shell
cd test/mini-hbase
docker build -t mini-hbase .
```

check image
```shell
docker images
REPOSITORY            TAG         IMAGE ID       CREATED          SIZE
mini-hbase            latest      2f6f3ffd20cd   33 seconds ago   666MB
```

3. upload to dockerhub, you may need a docker account

eg. my username is jimolonely1234, we need to create a repository on dockerhub first, [check the doc](https://docs.docker.com/docker-hub/repos/).
```shell
docker tag mini-hbase jimolonely1234/mini-hbase
docker push jimolonely1234/mini-hbase

Using default tag: latest
The push refers to repository [docker.io/jimolonely1234/mini-hbase]
dfed319e5fb6: Pushed
33e63e14c803: Pushed
8292a10d7604: Pushed
3b2356b88239: Pushed
a7934564e6b9: Pushed
1b7cceb6a07c: Pushed
b274e8788e0c: Pushed
78658088978a: Pushed
latest: digest: sha256:b053ee1fdcef8011330fb547bb2b5a2c88af8a367931fc1ae1269259bb468883 size: 2010
```


# TODO Problem

hostname in docker is random string, access from host can not find the hostname.

```shell
java.net.UnknownHostException: can not resolve ea26a9a315e8,35147,1652446891874
```



