
Our cmd is based on [sqlline](https://github.com/julianhyde/sqlline), and the sqlline is based on [jline](https://github.com/jline/jline3).

# package

```shell
mvn package -pl cmd -am -DskipTests=true
```

# usage

```shell
D:\workspace\git\start-db\cmd\target>java -jar start-db-cmd.jar
sqlline version 1.12.0
start-db> !list
No active connections
start-db> !connect jdbc:start-db:url=http://127.0.0.1:8000
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Enter username for jdbc:start-db:url=http://127.0.0.1:8000:
Enter password for jdbc:start-db:url=http://127.0.0.1:8000:
Transaction isolation level TRANSACTION_REPEATABLE_READ is not supported. Default (TRANSACTION_NONE) will be used instead.
start-db> select count(1) from citibike_tripdata;
+--------+
| EXPR$0 |
+--------+
| 0      |
+--------+
1 row selected (0.252 seconds)
start-db> !exit
```

