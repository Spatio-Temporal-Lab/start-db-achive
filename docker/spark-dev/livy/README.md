
# apache livy镜像构建

https://github.com/Renien/docker-spark-livy/blob/master/Dockerfile

livy依赖于spark和hadoop环境。

要构建livy镜像的文件结构
```shell
apache-livy-0.8.0-incubating-SNAPSHOT-bin.tar.gz
Dockerfile
livy.conf
log4j.properties
spark-3.0.2-bin-hadoop3.2.tgz
```
构建
```shell
docker build -t livy .
docker tag  livy livy:0.7.1
```


# 问题

创建spark session时报错，找不到 `scala.Function0$class`.
```shell
java.lang.NoClassDefFoundError: scala/Function0$class
    at org.apache.livy.shaded.json4s.ThreadLocal.<init>(Formats.scala:311)
    at org.apache.livy.shaded.json4s.DefaultFormats$class.$init$(Formats.scala:318)
    at org.apache.livy.shaded.json4s.DefaultFormats$.<init>(Formats.scala:296)
    at org.apache.livy.shaded.json4s.DefaultFormats$.<clinit>(Formats.scala)
    at org.apache.livy.repl.Session.<init>(Session.scala:66)
    at org.apache.livy.repl.ReplDriver.initializeSparkEntries(ReplDriver.scala:41)
    at org.apache.livy.rsc.driver.RSCDriver.run(RSCDriver.java:333)
    at org.apache.livy.rsc.driver.RSCDriverBootstrapper.main(RSCDriverBootstrapper.java:93)
    at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
    at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
    at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
    at java.lang.reflect.Method.invoke(Method.java:498)
    at org.apache.spark.deploy.yarn.ApplicationMaster$$anon$2.run(ApplicationMaster.scala:684)
Caused by: java.lang.ClassNotFoundException: scala.Function0$class
    at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
    at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
    at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
    ... 13 more
```

因为livy0.7.1版本是按scala2.11打的包，我们spark3.0.2是scala2.12.

根据[livy-756](https://github.com/apache/incubator-livy/pull/300) 这个PR，支持了2.12.

打包可参考：[https://stackoverflow.com/questions/67085984/how-to-rebuild-apache-livy-with-scala-2-12](https://stackoverflow.com/questions/67085984/how-to-rebuild-apache-livy-with-scala-2-12)

注释掉几个无用但会失败的模块
```shell
    <!--<module>coverage</module>-->
    <!--<module>examples</module>-->
    <!--<module>python-api</module>-->
    <!--<module>integration-test</module>-->
```

```shell
mvn clean package -B -V -e -Pspark-3.0 -DskipTests -DskipITs -Dmaven.javadoc.skip=true
```

打包完在 assembly/target/apache-livy-0.8.0-incubating-SNAPSHOT-bin.zip

