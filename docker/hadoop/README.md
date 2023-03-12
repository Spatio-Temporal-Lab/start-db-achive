本地起一个单机hadoop集群用于测试。

使用镜像:[https://github.com/rancavil/hadoop-single-node-cluster](https://github.com/rancavil/hadoop-single-node-cluster)

```shell
docker pull julienlau/hadoop-single-node-cluster:3.3.3
```

启动
```shell
docker run -d --name hadoop3-dev -p 9864:9864 -p 9870:9870 -p 8088:8088 -p 9000:9000 -p 9866:9866 --hostname localhost julienlau/hadoop-single-node-cluster:3.3.3
```

启动后访问页面： http://localhost:9870/dfshealth.html#tab-overview
