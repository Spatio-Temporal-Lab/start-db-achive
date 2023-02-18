# 用docker搭建一个spark standalone集群

来自：https://dev.to/mvillarrealb/creating-a-spark-standalone-cluster-with-docker-and-docker-compose-2021-update-6l4

构建镜像：

**先进入livy目录构建livy镜像，后面稳定后上传仓库**

```shell
docker build -t cluster-apache-spark:3.0.2 .
```

启动集群
```shell
docker-compose -f docker-compose-custom.yml up -d 
```


别人打好的镜像: https://hub.docker.com/layers/monokultur/cluster-apache-spark/3.0.2/images/sha256-c0fa759844eec9d6fa5406de66f5893ead8bfc701246bc722dcb7c028efab049?context=explore


```shell
docker-compose -f docker-compose.yml up -d 
```

启动好后，可以访问 http://localhost:8080/ 查看master的web页面。

2个worker节点的地址是：http://localhost:8081/，http://localhost:8082/

## 测试

### 进入容器测试

```shell
docker exec -it spark-dev-spark-master-1 bash

./bin/spark-submit \
  --class org.apache.spark.examples.SparkPi \
  --master spark://spark-master:7077 \
  --deploy-mode client \
  --executor-memory 1G \
  --total-executor-cores 1 \
  /opt/spark/examples/jars/spark-examples_2.12-3.0.2.jar
```

### 本机测试

本机和docker网络不通，无法从本地submit提交。

bin/spark-submit --class org.apache.spark.examples.SparkPi --master spark://localhost:7077 --deploy-mode client --executor-memory 1G --total-executor-cores 1 D:\software\spark-3.0.2-bin-hadoop3.2\examples\jars\spark-examples_2.12-3.0.2.jar

### livy测试

访问 http://localhost:8998/进入livy界面

```shell
# CREATING A LIVY SESSION
curl -X POST -d '{"kind": "spark","driverMemory":"512M","executorMemory":"512M"}' -H "Content-Type: application/json" http://localhost:8998/sessions/

# SUBMITTING A SIMPLE LOGIC TO TEST SPARK SHELL
curl -X POST -d '{"code": "1 + 1"}' -H "Content-Type: application/json" http://localhost:8998/sessions/0/statements

# SUBMITTING A SPARK CODE
curl -X POST -d '{"code": "val data = Array(1,2,3); sc.parallelize(data).count"}' -H "Content-Type: application/json" http://localhost:8998/sessions/0/statements
```

