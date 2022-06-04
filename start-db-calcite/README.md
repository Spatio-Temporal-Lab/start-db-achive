# START DB CALCITE

## ANTLR generate sources from g4 files

ANTLR parser is auto generated with maven plugin `antlr4-maven-plugin`.
The grammar file for START-DB is `src/main/antlr4/<generated-package-name>/StartDBSql.g4`.

After update this file, you need to run

```
mvn generate-sources
```

for generate the latest parser code which is s located at `src/main/java/<generated-package-name>/`.

In IDE, you may need to refresh (IntelliJ idea mvn reload) reference to the latest parser code.
