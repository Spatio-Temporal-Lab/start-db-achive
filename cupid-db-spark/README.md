# cupid-spark本地测试

## 启动spark集群

进入 docker/spark-dev ,查看README启动spark standalone集群。

## 打包

```shell
mvn package -pl cupid-db-spark -am -Dmaven.test.skip=true
```

## 上传到spark能读到的地方

因为是本地，docker挂载了本地目录，位于 docker/spark-dev/apps, 复制jar包到这个目录

## 提交测试

进入 spark-master 容器内：

```shell
docker exec -it spark-dev-spark-master-1 bash
```

运行测试命令

```shell
spark-submit  \
--class org.urbcomp.cupid.db.spark.CupidSparkDriver \
--master spark://spark-master:7077  \
--deploy-mode client \
--driver-memory 1g \
--executor-cores 1 \
--executor-memory 1g \
--num-executors 1 \
 /opt/spark-apps/cupid-db-spark.jar 参数TODO
```

后面的参数 TODO。



