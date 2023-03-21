
Our cmd is based on [sqlline](https://github.com/julianhyde/sqlline), and the sqlline is based on [jline](https://github.com/jline/jline3).

# package

```shell
mvn package -pl cupid-db-cmd -am -DskipTests=true -Dcheckstyle.skip
```

# usage

```shell
D:\workspace\git\cupid-db\cmd\target>java -jar cupid-db-cmd.jar -u cupid_db -p cupid-db -r jdbc:cupid-db:url=http://127.0.0.1:8000
sqlline version 1.12.0
Transaction isolation level TRANSACTION_REPEATABLE_READ is not supported. Default (TRANSACTION_NONE) will be used instead.
cupid-db> select count(1) from citibike_tripdata;
+--------+
| EXPR$0 |
+--------+
| 0      |
+--------+
1 row selected (0.252 seconds)
cupid-db> !exit
```

# source

execute multi insert from a file.

```shell
0: jdbc:cupid-db:url=http://127.0.0.1:8000> !source D:\workspace\git\cupid-db\cupid-db-cmd\src\test\resources\t_test_update.sql
Have inserted 64 lines.
insert finished.
```
