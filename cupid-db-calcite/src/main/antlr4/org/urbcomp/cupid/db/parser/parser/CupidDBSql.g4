/*
 * Copyright 2022 ST-Lab
 *
 * This program is free software; you can redistribute it and/or modify it under the terms of the
 * GNU General Public License version 2 as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 */

grammar CupidDBSql;

program : stmt T_SEMICOLON? EOF;

stmt :
       createDatabaseStmt
     | createTableStmt
     | createIndexStmt
     | describeStmt
     | dropDatabaseStmt
     | dropTableStmt
     | dropTableIndexStmt
     | truncateStmt
     | useStmt
     | showDatabasesStmt
     | showTablesStmt
     | showCreateTableStmt
     | showStatusStmt
     | showIndexStmt
     | insertStmt
     | updateStmt
     | deleteStmt
     | selectStmt
     | createUserStmt
     ;

dbDotTable:
    (db=(L_ID | T_DEFAULT | T_MUL) T_DOT)? table=(T_MUL | T_DEFAULT | L_ID)
    ;

userDotDbDotTable:
    dbDotTable
    | (user=L_ID T_DOT)? dbDotTable
    ;

assignmentStmtItem :
       assignmentStmtSingleItem
     | assignmentStmtMultipleItem
     | assignmentStmtSelectItem
     ;

assignmentStmtSingleItem :
       ident T_COLON? T_EQUAL expr
     | T_OPEN_P ident T_CLOSE_P T_COLON? T_EQUAL expr
     ;

assignmentStmtMultipleItem :
       T_OPEN_P ident (T_COMMA ident)* T_CLOSE_P T_COLON? T_EQUAL T_OPEN_P expr (T_COMMA expr)* T_CLOSE_P
     ;

assignmentStmtSelectItem :
       (ident | (T_OPEN_P ident (T_COMMA ident)* T_CLOSE_P)) T_COLON? T_EQUAL T_OPEN_P selectStmt T_CLOSE_P
     ;

showCreateTableStmt :
       T_SHOW T_CREATE T_TABLE relation=ident
     ;

showStatusStmt :
       T_SHOW T_STATUS
     ;

showIndexStmt :
       T_SHOW T_INDEX T_FROM tableName (T_FROM dbName=L_ID)?
     ;

createTableStmt :
       T_CREATE T_TABLE (T_IF T_NOT T_EXISTS)? table_name create_table_preoptions? create_table_definition
     ;

createUserStmt :
      T_CREATE T_USER user_name T_IDENTIFIED T_BY password=string
    ;


create_table_definition :
      (T_AS? T_OPEN_P selectStmt T_CLOSE_P | T_AS? selectStmt | T_OPEN_P create_table_columns T_CLOSE_P | T_LIKE table_name) create_table_options?
     ;

create_table_columns :
       create_table_columns_item (T_COMMA create_table_columns_item)*
     ;

create_table_columns_item :
       column_name dtype dtype_attr* create_table_column_inline_cons*
     | (T_CONSTRAINT qident)? create_table_column_cons
     | (T_SPATIAL|T_ATTRIBUTE) T_INDEX ident? key_list
     ;

key_list:
    T_OPEN_P qident (T_COMMA qident)* T_CLOSE_P
;

column_name :
       qident
     ;

create_table_column_inline_cons :
       dtype_default
     | T_NOT? T_NULL
     | T_PRIMARY T_KEY
     | T_UNIQUE
     | T_REFERENCES table_name T_OPEN_P qident T_CLOSE_P create_table_fk_action*
     | T_IDENTITY T_OPEN_P L_INT (T_COMMA L_INT)* T_CLOSE_P
     | T_AUTO_INCREMENT
     | T_ENABLE
     ;

create_table_column_cons :
       T_PRIMARY T_KEY T_CLUSTERED? T_OPEN_P qident (T_ASC | T_DESC)? (T_COMMA qident (T_ASC | T_DESC)?)* T_CLOSE_P T_ENABLE?
     | T_FOREIGN T_KEY T_OPEN_P qident (T_COMMA qident)* T_CLOSE_P T_REFERENCES table_name T_OPEN_P qident (T_COMMA qident)* T_CLOSE_P create_table_fk_action*
    ;

create_table_fk_action :
       T_ON (T_UPDATE | T_DELETE) (T_NO T_ACTION | T_RESTRICT | T_SET T_NULL | T_SET T_DEFAULT | T_CASCADE)
     ;

create_table_preoptions :
      create_table_preoptions_item+
     ;

create_table_preoptions_item :
        T_COMMA create_table_preoptions_td_item
     ;

create_table_preoptions_td_item :
       T_NO? (T_LOG | T_FALLBACK)
     ;

create_table_options :
       create_table_options_item+
     ;

create_table_options_item :
       T_ON T_COMMIT (T_DELETE | T_PRESERVE) T_ROWS
     | create_table_options_mysql_item
     ;

create_table_options_mysql_item :
       T_AUTO_INCREMENT T_EQUAL? expr
     | T_COMMENT T_EQUAL? expr
     | T_DEFAULT? (T_CHARACTER T_SET | T_CHARSET) T_EQUAL? expr
     | T_ENGINE T_EQUAL? expr
     ;

createIndexStmt :     // CREATE INDEX statement
       T_CREATE T_UNIQUE? T_INDEX ident T_ON tableName T_OPEN_P createIndexCol (T_COMMA createIndexCol)* T_CLOSE_P
     ;

createIndexCol :
       ident (T_ASC | T_DESC)?
     ;

dropTableIndexStmt :
        T_DROP T_INDEX indexName=L_ID T_ON tableName
     ;

dtype_default :
       T_COLON? T_EQUAL expr
     | T_WITH? T_DEFAULT expr?
     ;

showTablesStmt :
        T_SHOW T_TABLES
     ;

dtype_attr :
       T_NOT? T_NULL
     | T_CHARACTER T_SET ident
     | T_NOT? (T_CASESPECIFIC | T_CS)
     ;

dtype :                  // Data types
       T_DATETIME
     | T_DOUBLE
     | T_FLOAT
     | T_INT
     | T_INTEGER
     | T_STRING
     | T_TIMESTAMP
     | T_LONG
     | T_BOOLEAN
     | T_BOOL
     | T_BINARY
     | T_GEOMETRY
     | T_POINT
     | T_LINESTRING
     | T_POLYGON
     | T_MULTIPOINT
     | T_MULTILINESTRING
     | T_MULTIPOLYGON
     | T_GEOMETRYCOLLECTION
     | T_TRAJECTORY
     | T_ROADSEGMENT
     | T_ROADNETWORK
     | ident ('%' (T_TYPE | T_ROWTYPE))?             // User-defined or derived data type
     ;

dtypeLen :             // Data type length or size specification
       T_OPEN_P (L_INT | T_MAX) (T_CHAR | T_BYTE)? (T_COMMA L_INT)? T_CLOSE_P
     ;

createDatabaseStmt :
      T_CREATE (T_DATABASE | T_SCHEMA) (T_IF T_NOT T_EXISTS)? dbName=L_ID createDatabaseOption*
    ;

showDatabasesStmt :
      T_SHOW T_DATABASES
    ;

dropDatabaseStmt :
      T_DROP (T_DATABASE | T_SCHEMA) (T_IF T_EXISTS)? dbName=L_ID
    ;

createDatabaseOption :
      T_COMMENT expr
    | T_LOCATION expr
    ;

dropTableStmt :             // DROP statement
       T_DROP T_TABLE (T_IF T_EXISTS)? tableName
     ;

insertStmt :           // INSERT statement
       T_INSERT (T_OVERWRITE T_TABLE | T_INTO T_TABLE?) tableName insertStmtCols? (selectStmt | insertStmtRows)
     ;

insertStmtCols :
       T_OPEN_P ident (T_COMMA ident)* T_CLOSE_P
     ;

insertStmtRows :
       T_VALUES insertStmtRow (T_COMMA insertStmtRow)*
     ;

insertStmtRow:
       T_OPEN_P expr (T_COMMA expr)* T_CLOSE_P
     ;

truncateStmt :
       T_TRUNCATE T_TABLE? ident
     ;

useStmt :              // USE statement
       T_USE dbName=(L_ID | T_DEFAULT)
     ;

selectStmt :            // SELECT statement
       cteSelectStmt? fullselectStmt
     ;

cteSelectStmt :
       T_WITH cteSelectStmtItem (T_COMMA cteSelectStmtItem)*
     ;

cteSelectStmtItem :
       ident cteSelectCols? T_AS T_OPEN_P fullselectStmt T_CLOSE_P
     ;

cteSelectCols :
       T_OPEN_P ident (T_COMMA ident)* T_CLOSE_P
     ;

fullselectStmt :
       fullselectStmtItem (fullselectSetClause fullselectStmtItem)*
      | T_OPEN_P fullselectStmt T_CLOSE_P
     ;

fullselectStmtItem :
       subselectStmt
     | T_OPEN_P fullselectStmt T_CLOSE_P
     ;

fullselectSetClause :
       T_UNION T_ALL?
     | T_EXCEPT T_ALL?
     | T_INTERSECT T_ALL?
     ;

subselectStmt :
       (T_SELECT | T_SEL)
       selectList
       intoClause?
       fromClause?
       whereClause?
       groupByClause?
       (havingClause | qualifyClause)?
       orderByClause?
       selectOptions?
     ;

selectList :
       selectListSet? selectListLimit? selectListItem (T_COMMA selectListItem)*
     ;

selectListSet :
       T_ALL
     | T_DISTINCT
     ;

selectListLimit :
       T_TOP expr
     ;

selectListItem :
       ((ident T_EQUAL)? expr selectListAlias? | selectListAsterisk)
     ;

selectListAlias :
       T_AS? ident
     | T_AS? T_OPEN_P ident (T_COMMA ident)* T_CLOSE_P
     | T_OPEN_P T_TITLE L_S_STRING T_CLOSE_P
     ;

selectListAsterisk :
       (L_ID T_DOT)? T_MUL
     ;

intoClause :
       T_INTO ident (T_COMMA ident)*
     ;

fromClause :
       T_FROM fromTableClause (fromJoinClause)*
     ;

fromTableClause :
       fromTableNameClause
     | fromSubselectClause
     | fromTableValuesClause
     ;

fromTableNameClause :
       tableName fromAliasClause? sampleClause?
     ;

fromSubselectClause :
       T_OPEN_P selectStmt T_CLOSE_P fromAliasClause?
     ;

fromJoinClause :
       T_COMMA fromTableClause
     | fromJoinTypeClause fromTableClause T_ON boolExpr
     ;

fromJoinTypeClause :
       T_INNER? T_JOIN
     | (T_LEFT | T_RIGHT | T_FULL) T_OUTER? T_JOIN
     ;

fromTableValuesClause:
       T_TABLE T_OPEN_P T_VALUES fromTableValuesRow (T_COMMA fromTableValuesRow)* T_CLOSE_P fromAliasClause?
     ;

fromTableValuesRow:
       expr
     | T_OPEN_P expr (T_COMMA expr)* T_CLOSE_P
     ;

fromAliasClause :
       {!_input.LT(1).getText().equalsIgnoreCase("EXEC") &&
        !_input.LT(1).getText().equalsIgnoreCase("EXECUTE") &&
        !_input.LT(1).getText().equalsIgnoreCase("INNER") &&
        !_input.LT(1).getText().equalsIgnoreCase("LEFT") &&
        !_input.LT(1).getText().equalsIgnoreCase("GROUP") &&
        !_input.LT(1).getText().equalsIgnoreCase("ORDER") &&
        !_input.LT(1).getText().equalsIgnoreCase("LIMIT") &&
        !_input.LT(1).getText().equalsIgnoreCase("WITH")}?
       T_AS? ident (T_OPEN_P L_ID (T_COMMA L_ID)* T_CLOSE_P)?
     ;

tableName :
       ident
     ;

whereClause :
       T_WHERE boolExpr
     ;

groupByClause :
       T_GROUP T_BY expr (T_COMMA expr)*
     ;

havingClause :
       T_HAVING boolExpr
     ;

qualifyClause :
       T_QUALIFY boolExpr
     ;

orderByClause :
       T_ORDER T_BY orderByClauseItem (T_COMMA orderByClauseItem)*
     ;

orderByClauseItem :
        expr (T_ASC | T_DESC)?
     ;

sampleClause :
        T_TABLESAMPLE T_OPEN_P L_INT T_PERCENT T_CLOSE_P
     ;

selectOptions :
       selectOptionsItem+
     ;

selectOptionsItem :
       T_LIMIT expr
     | T_WITH (T_RR | T_RS | T_CS | T_UR) (T_USE T_AND T_KEEP (T_EXCLUSIVE | T_UPDATE) T_LOCKS)?
     ;

updateStmt :                              // UPDATE statement
       T_UPDATE updateTable T_SET updateAssignment whereClause? updateUpsert?
     ;

updateAssignment :
       assignmentStmtItem (T_COMMA assignmentStmtItem)*
     ;

updateTable :
       (tableName fromClause? | T_OPEN_P selectStmt T_CLOSE_P) (T_AS? ident)?
     ;

updateUpsert :
       T_ELSE insertStmt
     ;

deleteStmt :
       T_DELETE T_FROM? tableName deleteAlias? (whereClause | T_ALL)?
     ;

deleteAlias :
       {!_input.LT(1).getText().equalsIgnoreCase("ALL")}?
       T_AS? ident
     ;

describeStmt :
       (T_DESCRIBE | T_DESC) (T_TABLE | T_VIEW)? userDotDbDotTable
     ;

boolExpr :                               // Boolean condition
       T_NOT? T_OPEN_P boolExpr T_CLOSE_P
     | boolExpr boolExprLogicalOperator boolExpr
     | boolExprAtom
     ;

boolExprAtom :
      boolExprUnary
    | boolExprBinary
    | expr
    ;

boolExprUnary :
      expr T_IS T_NOT? T_NULL
    | expr T_BETWEEN expr T_AND expr
    | T_NOT? T_EXISTS T_OPEN_P selectStmt T_CLOSE_P
    | boolExprSingleIn
    | boolExprMultiIn
    ;

boolExprSingleIn :
      expr T_NOT? T_IN T_OPEN_P ((expr (T_COMMA expr)*) | selectStmt) T_CLOSE_P
    ;

boolExprMultiIn :
      T_OPEN_P expr (T_COMMA expr)* T_CLOSE_P T_NOT? T_IN T_OPEN_P selectStmt T_CLOSE_P
    ;

boolExprBinary :
       expr boolExprBinaryOperator expr
     ;

boolExprLogicalOperator :
       T_AND
     | T_OR
     ;

boolExprBinaryOperator :
       T_EQUAL
     | T_EQUAL2
     | T_NOTEQUAL
     | T_NOTEQUAL2
     | T_LESS
     | T_LESSEQUAL
     | T_GREATER
     | T_GREATEREQUAL
     | T_NOT? (T_LIKE | T_RLIKE | T_REGEXP)
     ;

expr :
       expr intervalItem
     | expr T_MUL expr
     | expr T_DIV expr
     | expr T_ADD expr
     | expr T_SUB expr
     | T_OPEN_P selectStmt T_CLOSE_P
     | T_OPEN_P expr T_CLOSE_P
     | exprInterval
     | exprConcat
     | exprCase
     | exprCursorAttribute
     | exprAggWindowFunc
     | exprSpecFunc
     | exprFunc
     | exprAtom
     ;

exprAtom :
       dateLiteral
     | timestampLiteral
     | boolLiteral
     | ident
     | string
     | decNumber
     | intNumber
     | nullConst
     ;

exprInterval :
       T_INTERVAL expr intervalItem
     ;
intervalItem :
       T_DAY
     | T_DAYS
     | T_MICROSECOND
     | T_MICROSECONDS
     | T_SECOND
     | T_SECONDS
     ;

exprConcat :                  // String concatenation operator
       exprConcatItem (T_PIPE | T_CONCAT) exprConcatItem ((T_PIPE | T_CONCAT) exprConcatItem)*
     ;

exprConcatItem :
       T_OPEN_P expr T_CLOSE_P
     | exprCase
     | exprAggWindowFunc
     | exprSpecFunc
     | exprFunc
     | exprAtom
     ;

exprCase :                    // CASE expression
       exprCaseSimple
     | exprCaseSearched
     ;

exprCaseSimple :
       T_CASE expr (T_WHEN expr T_THEN expr)+ (T_ELSE expr)? T_END
     ;

exprCaseSearched :
       T_CASE exprCaseItem+ (T_ELSE boolExpr)? T_END
     ;

exprCaseItem :
       T_WHEN whenExpr=boolExpr T_THEN thenExpr=boolExpr
     ;

exprCursorAttribute :
      ident '%' (T_ISOPEN | T_FOUND | T_NOTFOUND)
    ;

exprAggWindowFunc :
       T_AVG T_OPEN_P exprFuncAllDistinct? expr T_CLOSE_P exprFuncOverClause?
     | T_COUNT T_OPEN_P ((exprFuncAllDistinct? expr) | T_MUL) T_CLOSE_P exprFuncOverClause?
     | T_COUNT_BIG T_OPEN_P ((exprFuncAllDistinct? expr) | T_MUL) T_CLOSE_P exprFuncOverClause?
     | T_CUME_DIST T_OPEN_P T_CLOSE_P exprFuncOverClause
     | T_DENSE_RANK T_OPEN_P T_CLOSE_P exprFuncOverClause
     | T_FIRST_VALUE T_OPEN_P expr T_CLOSE_P exprFuncOverClause
     | T_LAG T_OPEN_P expr (T_COMMA expr (T_COMMA expr)?)? T_CLOSE_P exprFuncOverClause
     | T_LAST_VALUE T_OPEN_P expr T_CLOSE_P exprFuncOverClause
     | T_LEAD T_OPEN_P expr (T_COMMA expr (T_COMMA expr)?)? T_CLOSE_P exprFuncOverClause
     | T_MAX T_OPEN_P exprFuncAllDistinct? expr T_CLOSE_P exprFuncOverClause?
     | T_MIN T_OPEN_P exprFuncAllDistinct? expr T_CLOSE_P exprFuncOverClause?
     | T_RANK T_OPEN_P T_CLOSE_P exprFuncOverClause
     | T_ROW_NUMBER T_OPEN_P T_CLOSE_P exprFuncOverClause
     | T_STDEV T_OPEN_P exprFuncAllDistinct? expr T_CLOSE_P exprFuncOverClause?
     | T_SUM T_OPEN_P exprFuncAllDistinct? expr T_CLOSE_P exprFuncOverClause?
     | T_VAR T_OPEN_P exprFuncAllDistinct? expr T_CLOSE_P exprFuncOverClause?
     | T_VARIANCE T_OPEN_P exprFuncAllDistinct? expr T_CLOSE_P exprFuncOverClause?
     ;

exprFuncAllDistinct :
       T_ALL
     | T_DISTINCT
     ;

exprFuncOverClause :
       T_OVER T_OPEN_P exprFuncPartitionByClause? orderByClause? T_CLOSE_P
     ;

exprFuncPartitionByClause :
       T_PARTITION T_BY expr (T_COMMA expr)*
     ;

exprSpecFunc :
       T_ACTIVITY_COUNT
     | T_CAST T_OPEN_P expr T_AS  dtype dtypeLen? T_CLOSE_P
     | T_COUNT T_OPEN_P (expr | T_MUL) T_CLOSE_P
     | T_CURRENT_DATE | T_CURRENT T_DATE | T_CURRENT_TIME | T_PI
     | (T_CURRENT_TIMESTAMP | T_CURRENT T_TIMESTAMP) (T_OPEN_P expr T_CLOSE_P)?
     | T_CURRENT_USER | T_CURRENT T_USER
     | T_MAX_PART_STRING T_OPEN_P expr (T_COMMA expr (T_COMMA expr T_EQUAL expr)*)? T_CLOSE_P
     | T_MIN_PART_STRING T_OPEN_P expr (T_COMMA expr (T_COMMA expr T_EQUAL expr)*)? T_CLOSE_P
     | T_MAX_PART_INT T_OPEN_P expr (T_COMMA expr (T_COMMA expr T_EQUAL expr)*)? T_CLOSE_P
     | T_MIN_PART_INT T_OPEN_P expr (T_COMMA expr (T_COMMA expr T_EQUAL expr)*)? T_CLOSE_P
     | T_MAX_PART_DATE T_OPEN_P expr (T_COMMA expr (T_COMMA expr T_EQUAL expr)*)? T_CLOSE_P
     | T_MIN_PART_DATE T_OPEN_P expr (T_COMMA expr (T_COMMA expr T_EQUAL expr)*)? T_CLOSE_P
     | T_PART_COUNT T_OPEN_P expr (T_COMMA expr T_EQUAL expr)* T_CLOSE_P
     | T_PART_LOC T_OPEN_P expr (T_COMMA expr T_EQUAL expr)+ (T_COMMA expr)? T_CLOSE_P
     | T_SUBSTRING T_OPEN_P expr T_FROM expr (T_FOR expr)? T_CLOSE_P
     | T_SYSDATE
     | T_USER
     ;

exprFunc :
       ident T_OPEN_P exprFuncParams? T_CLOSE_P
     ;

exprFuncParams :
       funcParam (T_COMMA funcParam)*
     ;

funcParam :
     | {!_input.LT(1).getText().equalsIgnoreCase("INTO")}? (ident T_EQUAL T_GREATER?)? expr
     |  T_MUL
     ;

table_name :
       qident
     ;

user_name :
    ident
    ;


qident :                                  // qualified identifier e.g: table_name.col_name or db_name._table_name
       ident ('.'ident)*
     ;

/*---------------------------- third party parser----------------------------*/

dateLiteral :                             // DATE 'YYYY-MM-DD' literal
       T_DATE string
     ;

timestampLiteral :                       // TIMESTAMP 'YYYY-MM-DD HH:MI:SS.FFF' literal
       T_TIMESTAMP string
     ;

ident :
       T_SUB? identItem (T_DOT identItem)*
     ;

identItem :
      L_ID | nonReservedWords
     ;

string :                                   // String literal (single or double quoted)
       L_S_STRING                          # singleQuotedString
     | L_D_STRING                          # doubleQuotedString
     ;

intNumber :                               // Integer (positive or negative)
     (T_SUB | T_ADD)? L_INT
     ;

decNumber :                               // Decimal number (positive or negative)
     (T_SUB | T_ADD)? L_DEC
     ;

boolLiteral :                            // Boolean literal
       T_TRUE
     | T_FALSE
     ;

nullConst :                              // NULL constant
       T_NULL
     ;

nonReservedWords :                      // Tokens that are not reserved words and can be used as identifiers
       T_ACTION
     | T_ACTIVITY_COUNT
     | T_ADD2
     | T_ALL
     | T_ALLOCATE
     | T_ALTER
     | T_AND
     | T_ANSI_NULLS
     | T_ANSI_PADDING
     | T_AS
     | T_ASC
     | T_ASSOCIATE
     | T_AT
     | T_AVG
     | T_BATCHSIZE
     | T_BEGIN
     | T_BETWEEN
     | T_BIGINT
     | T_BINARY_DOUBLE
     | T_BINARY_FLOAT
     | T_BIT
     | T_BODY
     | T_BREAK
     | T_BY
     | T_BYTE
     | T_CALL
     | T_CALLER
     | T_CASCADE
     | T_CASE
     | T_CASESPECIFIC
     | T_CAST
     | T_CHAR
     | T_CHARACTER
     | T_CHARSET
     | T_CLIENT
     | T_CLOSE
     | T_CLUSTERED
     | T_CMP
     | T_COLLECT
     | T_COLLECTION
     | T_COLUMN
     | T_COMMENT
     | T_COMPRESS
     | T_CONSTANT
     | T_COPY
     | T_COMMIT
     | T_CONCAT
     | T_CONDITION
     | T_CONSTRAINT
     | T_CONTINUE
     | T_COUNT
     | T_COUNT_BIG
     | T_CREATION
     | T_CREATOR
     | T_CS
     | T_CUME_DIST
     | T_CURRENT
     | T_CURRENT_DATE
     | T_CURRENT_TIME
     | T_PI
     | T_CURRENT_SCHEMA
     | T_CURRENT_TIMESTAMP
     | T_CURRENT_USER
     | T_CURSOR
     | T_DATA
     | T_DATABASE
     | T_DATE
     | T_DATETIME
     | T_DAY
     | T_DAYS
     | T_DEC
     | T_DECIMAL
     | T_DECLARE
     | T_DEFAULT
     | T_DEFERRED
     | T_DEFINED
     | T_DEFINER
     | T_DEFINITION
     | T_DELETE
     | T_DELIMITED
     | T_DELIMITER
     | T_DENSE_RANK
     | T_DESC
     | T_DESCRIBE
     | T_DIAGNOSTICS
     | T_DIR
     | T_DIRECTORY
     | T_DISTINCT
     | T_DISTRIBUTE
     | T_DO
     | T_DOUBLE
     | T_DOWNLOAD
     | T_DROP
     | T_DYNAMIC
     // T_ELSE reserved word
     // T_ELSEIF reserved word
     // T_ELSIF reserved word
     // T_END reserved word
     | T_ENABLE
     | T_ENGINE
     | T_ESCAPED
     | T_EXCEPT
     | T_EXEC
     | T_EXECUTE
     | T_EXCEPTION
     | T_EXCLUSIVE
     | T_EXISTS
     | T_EXIT
     | T_FALLBACK
     | T_FALSE
     | T_FETCH
     | T_FIELDS
     | T_FILE
     | T_FILES
     | T_FIRST_VALUE
     | T_FLOAT
     | T_FOR
     | T_FOREIGN
     | T_FORMAT
     | T_FOUND
     | T_FROM
     | T_FULL
     | T_FUNCTION
     | T_GET
     | T_GLOBAL
     | T_GO
     | T_GRANT
     | T_GROUP
     | T_HANDLER
     | T_HASH
     | T_HAVING
     | T_HOST
     | T_IDENTITY
     | T_IF
     | T_IGNORE
     | T_IMMEDIATE
     | T_IN
     | T_INCLUDE
     | T_INDEX
     | T_INITRANS
     | T_INNER
     | T_INOUT
     | T_INSERT
     | T_INT
     | T_INT2
     | T_INT4
     | T_INT8
     | T_INTEGER
     | T_INTERSECT
     | T_INTERVAL
     | T_INTO
     | T_INVOKER
     | T_ITEMS
     | T_IS
     | T_ISOPEN
     | T_JOIN
     | T_KEEP
     | T_KEY
     | T_KEYS
     | T_LAG
     | T_LANGUAGE
     | T_LAST_VALUE
     | T_LEAD
     | T_LEAVE
     | T_LEFT
     | T_LIKE
     | T_LIMIT
     | T_LINES
     | T_LOCAL
     | T_LOCATION
     | T_LOCATOR
     | T_LOCATORS
     | T_LOCKS
     | T_LOG
     | T_LOGGED
     | T_LOGGING
     | T_LOOP
     | T_MAP
     | T_MATCHED
     | T_MAX
     | T_MAXTRANS
     | T_MERGE
     | T_MESSAGE_TEXT
     | T_MICROSECOND
     | T_MICROSECONDS
     | T_MIN
     | T_MULTISET
     | T_NCHAR
     | T_NEW
     | T_NVARCHAR
     | T_NO
     | T_NOCOMPRESS
     | T_NOCOUNT
     | T_NOLOGGING
     | T_NONE
     | T_NOT
     | T_NOTFOUND
     // T_NULL reserved word
     | T_NUMERIC
     | T_NUMBER
     | T_OBJECT
     | T_OFF
     | T_ON
     | T_ONLY
     | T_OPEN
     | T_OR
     | T_ORDER
     | T_OUT
     | T_OUTER
     | T_OVER
     | T_OVERWRITE
     | T_OWNER
     | T_PACKAGE
     | T_PART_COUNT
     | T_PART_LOC
     | T_PARTITION
     | T_PCTFREE
     | T_PCTUSED
     | T_PRECISION
     | T_PRESERVE
     | T_PRIMARY
     | T_PRINT
     | T_PROC
     | T_PROCEDURE
     | T_PWD
     | T_QUALIFY
     | T_QUERY_BAND
     | T_QUIT
     | T_QUOTED_IDENTIFIER
     | T_RAISE
     | T_RANK
     | T_REAL
     | T_REFERENCES
     | T_REGEXP
     | T_RR
     | T_REPLACE
     | T_RESIGNAL
     | T_RESTRICT
     | T_RESULT
     | T_RESULT_SET_LOCATOR
     | T_RETURN
     | T_RETURNS
     | T_REVERSE
     | T_RIGHT
     | T_RLIKE
     | T_RS
     | T_ROLE
     | T_ROLLBACK
     | T_ROW
     | T_ROWS
     | T_ROW_COUNT
     | T_ROW_NUMBER
     | T_SCHEMA
     | T_SECOND
     | T_SECONDS
     | T_SECURITY
     | T_SEGMENT
     | T_SEL
     | T_SELECT
     | T_SESSION
     | T_SESSIONS
     | T_SET
     | T_SETS
     | T_SIGNAL
     | T_SIMPLE_DOUBLE
     | T_SIMPLE_FLOAT
     | T_SMALLDATETIME
     | T_SMALLINT
     | T_SQL
     | T_SQLEXCEPTION
     | T_SQLINSERT
     | T_SQLSTATE
     | T_SQLWARNING
     | T_STATS
     | T_STATISTICS
     | T_STEP
     | T_STDEV
     | T_STORAGE
     | T_STORE
     | T_STORED
     | T_STRING
     | T_SUBDIR
     | T_SUBSTRING
     | T_SUM
     | T_SUMMARY
     | T_SYSDATE
     | T_SYS_REFCURSOR
     | T_TABLE
     | T_TABLESPACE
     | T_TEMPORARY
     | T_TERMINATED
     | T_TEXTIMAGE_ON
     | T_THEN
     | T_TIMESTAMP
     | T_TITLE
     | T_TO
     | T_TOP
     | T_TRANSACTION
     | T_TRIM
     | T_TRUE
     | T_TRUNCATE
     // T_UNION reserved word
     | T_UNIQUE
     | T_UPDATE
     | T_UR
     | T_USE
     | T_USER
     | T_USING
     | T_VALUE
     | T_VALUES
     | T_VAR
     | T_VARCHAR
     | T_VARCHAR2
     | T_VARYING
     | T_VARIANCE
     | T_VOLATILE
     // T_WHEN reserved word
     // T_WHERE reserved word
     | T_WHILE
     | T_WITH
     | T_WITHOUT
     | T_WORK
     | T_XACT_ABORT
     | T_XML
     | T_YES
     ;

// Lexer rules
T_ACTION          : A C T I O N ;
T_ADD2            : A D D ;
T_ALL             : A L L ;
T_ALLOCATE        : A L L O C A T E ;
T_ALTER           : A L T E R ;
T_AND             : A N D ;
T_ANSI_NULLS      : A N S I '_' N U L L S ;
T_ANSI_PADDING    : A N S I '_' P A D D I N G ;
T_AS              : A S ;
T_ASC             : A S C ;
T_ASSOCIATE       : A S S O C I A T E ;
T_AT              : A T ;
T_ATTRIBUTE       : A T T R I B U T E;
T_AUTO            : A U T O ;
T_AUTO_INCREMENT  : A U T O I N C R E M E N T;
T_AVG             : A V G ;
T_BATCHSIZE       : B A T C H S I Z E ;
T_BEGIN           : B E G I N ;
T_BETWEEN         : B E T W E E N ;
T_BIGINT          : B I G I N T ;
T_BINARY_DOUBLE   : B I N A R Y '_' D O U B L E ;
T_BINARY_FLOAT    : B I N A R Y '_' F L O A T ;
T_BINARY_INTEGER  : B I N A R Y '_' I N T E G E R ;
T_BIT             : B I T ;
T_BODY            : B O D Y ;
T_BREAK           : B R E A K ;
T_BUILD           : B U I L D ;
T_BY              : B Y ;
T_BYTE            : B Y T E ;
T_CALL            : C A L L ;
T_CALLER          : C A L L E R ;
T_CASCADE         : C A S C A D E ;
T_CASE            : C A S E ;
T_CASESPECIFIC    : C A S E S P E C I F I C ;
T_CAST            : C A S T ;
T_CHAR            : C H A R ;
T_CHARACTER       : C H A R A C T E R ;
T_CHARSET         : C H A R S E T ;
T_CLIENT          : C L I E N T ;
T_CLOSE           : C L O S E ;
T_CLUSTERED       : C L U S T E R E D;
T_CMP             : C M P ;
T_COLLECT         : C O L L E C T ;
T_COLLECTION      : C O L L E C T I O N ;
T_COLUMN          : C O L U M N ;
T_COMMENT         : C O M M E N T;
T_CONFIG          : C O N F I G ;
T_CONSTANT        : C O N S T A N T ;
T_COMMIT          : C O M M I T ;
T_COMPRESS        : C O M P R E S S ;
T_CONCAT          : C O N C A T;
T_CONDITION       : C O N D I T I O N ;
T_CONSTRAINT      : C O N S T R A I N T ;
T_CONTINUE        : C O N T I N U E ;
T_COPY            : C O P Y ;
T_COUNT           : C O U N T ;
T_COUNT_BIG       : C O U N T '_' B I G;
T_CREATE          : C R E A T E ;
T_CREATION        : C R E A T I O N ;
T_CREATOR         : C R E A T O R ;
T_CS              : C S;
T_CURRENT         : C U R R E N T ;
T_CURRENT_SCHEMA  : C U R R E N T '_' S C H E M A ;
T_CURSOR          : C U R S O R ;
T_DATABASE        : D A T A B A S E ;
T_DATABASES       : D A T A B A S E S ;
T_DATA            : D A T A ;
T_DATE            : D A T E ;
T_DATETIME        : D A T E T I M E ;
T_DAY             : D A Y ;
T_DAYS            : D A Y S ;
T_DEC             : D E C ;
T_DECIMAL         : D E C I M A L ;
T_DECLARE         : D E C L A R E ;
T_DEFAULT         : D E F A U L T ;
T_DEFERRED        : D E F E R R E D ;
T_DEFINED         : D E F I N E D ;
T_DEFINER         : D E F I N E R ;
T_DEFINITION      : D E F I N I T I O N ;
T_DELETE          : D E L E T E ;
T_DELIMITED       : D E L I M I T E D ;
T_DELIMITER       : D E L I M I T E R ;
T_DESC            : D E S C ;
T_DESCRIBE        : D E S C R I B E ;
T_DIAGNOSTICS     : D I A G N O S T I C S ;
T_DIR             : D I R ;
T_DIRECTORY       : D I R E C T O R Y ;
T_DISTINCT        : D I S T I N C T ;
T_DISTRIBUTE      : D I S T R I B U T E ;
T_DO              : D O ;
T_DOUBLE          : D O U B L E ;
T_DOWNLOAD        : D O W N L O A D;
T_DROP            : D R O P ;
T_DYNAMIC         : D Y N A M I C ;
T_ELSE            : E L S E ;
T_ELSEIF          : E L S E I F ;
T_ELSIF           : E L S I F ;
T_ENABLE          : E N A B L E ;
T_END             : E N D ;
T_ENGINE          : E N G I N E ;
T_ESCAPED         : E S C A P E D ;
T_EXCEPT          : E X C E P T ;
T_EXEC            : E X E C ;
T_EXECUTE         : E X E C U T E ;
T_EXCEPTION       : E X C E P T I O N ;
T_EXCLUSIVE       : E X C L U S I V E ;
T_EXISTS          : E X I S T S ;
T_EXIT            : E X I T ;
T_FALLBACK        : F A L L B A C K ;
T_FALSE           : F A L S E ;
T_FETCH           : F E T C H ;
T_FIELDS          : F I E L D S ;
T_FILE            : F I L E ;
T_FILES           : F I L E S ;
T_FLOAT           : F L O A T ;
T_FOR             : F O R ;
T_FOREIGN         : F O R E I G N ;
T_FORMAT          : F O R M A T ;
T_FOUND           : F O U N D ;
T_FROM            : F R O M ;
T_FULL            : F U L L ;
T_FUNCTION        : F U N C T I O N ;
T_GET             : G E T ;
T_GLOBAL          : G L O B A L ;
T_GO              : G O ;
T_GRANT           : G R A N T ;
T_GRANTS          : G R A N T S ;
T_GROUP           : G R O U P ;
T_HANDLER         : H A N D L E R ;
T_HASH            : H A S H ;
T_HAVING          : H A V I N G ;
T_HOST            : H O S T ;
T_IDENTITY        : I D E N T I T Y ;
T_IDENTIFIED      : I D E N T I F I E D ;
T_IF              : I F ;
T_IGNORE          : I G N O R E ;
T_IMMEDIATE       : I M M E D I A T E ;
T_IN              : I N ;
T_INCLUDE         : I N C L U D E ;
T_INCREMENT       : I N C R E M E N T ;
T_INDEX           : I N D E X ;
T_INITRANS        : I N I T R A N S ;
T_INNER           : I N N E R ;
T_INOUT           : I N O U T;
T_INSERT          : I N S E R T ;
T_INT             : I N T ;
T_INT2            : I N T '2';
T_INT4            : I N T '4';
T_INT8            : I N T '8';
T_INTEGER         : I N T E G E R ;
T_INTERSECT       : I N T E R S E C T ;
T_INTERVAL        : I N T E R V A L ;
T_INTO            : I N T O ;
T_INVOKER         : I N V O K E R ;
T_IS              : I S ;
T_ISOPEN          : I S O P E N ;
T_ITEMS           : I T E M S ;
T_JOIN            : J O I N ;
T_KEEP            : K E E P;
T_KILL            : K I L L;
T_KEY             : K E Y ;
T_KEYS            : K E Y S ;
T_KV_SEARCH       : K V '_' S E A R C H;
T_LANGUAGE        : L A N G U A G E ;
T_LEAVE           : L E A V E ;
T_LEFT            : L E F T ;
T_LIKE            : L I K E ;
T_LIMIT           : L I M I T ;
T_LINES           : L I N E S ;
T_LOAD            : L O A D ;
T_LOCAL           : L O C A L ;
T_LOCATION        : L O C A T I O N ;
T_LOCATOR         : L O C A T O R ;
T_LOCATORS        : L O C A T O R S ;
T_LOCKS           : L O C K S ;
T_LOG             : L O G ;
T_LOGGED          : L O G G E D ;
T_LOGGING         : L O G G I N G ;
T_LOOP            : L O O P ;
T_MAP             : M A P ;
T_MATCHED         : M A T C H E D ;
T_MAX             : M A X ;
T_MAXTRANS        : M A X T R A N S ;
T_MERGE           : M E R G E ;
T_MESSAGE_TEXT    : M E S S A G E '_' T E X T ;
T_MICROSECOND     : M I C R O S E C O N D ;
T_MICROSECONDS    : M I C R O S E C O N D S;
T_MIN             : M I N ;
T_MULTISET        : M U L T I S E T ;
T_NCHAR           : N C H A R ;
T_NEW             : N E W ;
T_NVARCHAR        : N V A R C H A R ;
T_NO              : N O ;
T_NOCOUNT         : N O C O U N T ;
T_NOCOMPRESS      : N O C O M P R E S S ;
T_NOLOGGING       : N O L O G G I N G ;
T_NONE            : N O N E ;
T_NOT             : N O T ;
T_NOTFOUND        : N O T F O U N D ;
T_NULL            : N U L L ;
T_NUMERIC         : N U M E R I C ;
T_NUMBER          : N U M B E R ;
T_OBJECT          : O B J E C T ;
T_OFF             : O F F ;
T_ON              : O N ;
T_ONLY            : O N L Y ;
T_OPEN            : O P E N ;
T_OR              : O R ;
T_ORDER           : O R D E R;
T_OUT             : O U T ;
T_OUTER           : O U T E R ;
T_OVER            : O V E R ;
T_OVERWRITE       : O V E R W R I T E ;
T_OWNER           : O W N E R ;
T_PACKAGE         : P A C K A G E ;
T_PARTITION       : P A R T I T I O N ;
T_PASSWORD        : P A S S W O R D ;
T_PCTFREE         : P C T F R E E ;
T_PCTUSED         : P C T U S E D ;
T_PERCENT         : P E R C E N T ;
T_PLS_INTEGER     : P L S '_' I N T E G E R ;
T_PRECISION       : P R E C I S I O N ;
T_PRESERVE        : P R E S E R V E ;
T_PRIVILEGES      : P R I V I L E G E S ;
T_PRIMARY         : P R I M A R Y ;
T_PRINT           : P R I N T ;
T_PROC            : P R O C ;
T_PROCEDURE       : P R O C E D U R E ;
T_PYRAMID         : P Y R A M I D ;
T_PYRAMIDS         : P Y R A M I D S ;
T_QUERY           : Q U E R Y ;
T_QUERIES         : Q U E R I E S ;
T_QUALIFY         : Q U A L I F Y ;
T_QUERY_BAND      : Q U E R Y '_' B A N D ;
T_QUIT            : Q U I T ;
T_QUOTED_IDENTIFIER : Q U O T E D '_' I D E N T I F I E R ;
T_RAISE           : R A I S E ;
T_REAL            : R E A L ;
T_REFERENCES      : R E F E R E N C E S ;
T_REGEXP          : R E G E X P ;
T_RENAME          : R E N A M E ;
T_REPLACE         : R E P L A C E ;
T_RESIGNAL        : R E S I G N A L ;
T_RESTRICT        : R E S T R I C T ;
T_RESULT          : R E S U L T ;
T_RESULT_SET_LOCATOR : R E S U L T '_' S E T '_' L O C A T O R ;
T_RETURN          : R E T U R N ;
T_RETURNS         : R E T U R N S ;
T_REVERSE         : R E V E R S E ;
T_REVOKE          : R E V O K E ;
T_RIGHT           : R I G H T ;
T_RLIKE           : R L I K E ;
T_ROLE            : R O L E ;
T_ROLLBACK        : R O L L B A C K ;
T_ROW             : R O W ;
T_ROWS            : R O W S ;
T_ROWTYPE         : R O W T Y P E ;
T_ROW_COUNT       : R O W '_' C O U N T ;
T_RR              : R R;
T_RS              : R S ;
T_PWD             : P W D ;
T_TRIM            : T R I M ;
T_TABLESAMPLE     : T A B L E S A M P L E ;
T_SCHEMA          : S C H E M A ;
T_SECOND          : S E C O N D ;
T_SECONDS         : S E C O N D S;
T_SECURITY        : S E C U R I T Y ;
T_SEGMENT         : S E G M E N T ;
T_SEL             : S E L ;
T_SELECT          : S E L E C T ;
T_SET             : S E T ;
T_SESSION         : S E S S I O N ;
T_SESSIONS        : S E S S I O N S ;
T_SETS            : S E T S;
T_SHOW            : S H O W ;
T_SIGNAL          : S I G N A L ;
T_SIMPLE_DOUBLE   : S I M P L E '_' D O U B L E ;
T_SIMPLE_FLOAT    : S I M P L E '_' F L O A T ;
T_SIMPLE_INTEGER  : S I M P L E '_' I N T E G E R ;
T_SMALLDATETIME   : S M A L L D A T E T I M E ;
T_SMALLINT        : S M A L L I N T ;
T_SQL             : S Q L ;
T_SQLEXCEPTION    : S Q L E X C E P T I O N ;
T_SQLINSERT       : S Q L I N S E R T ;
T_SQLSTATE        : S Q L S T A T E ;
T_SQLWARNING      : S Q L W A R N I N G ;
T_SRID            : S R I D ;
T_STATS           : S T A T S ;
T_STATISTICS      : S T A T I S T I C S ;
T_STATUS          : S T A T U S ;
T_STEP            : S T E P ;
T_STORAGE         : S T O R A G E ;
T_STORE           : S T O R E;
T_STORED          : S T O R E D ;
T_STRING          : S T R I N G ;
T_SUBDIR          : S U B D I R ;
T_SUBSTRING       : S U B S T R I N G ;
T_SUM             : S U M ;
T_SUMMARY         : S U M M A R Y ;
T_SYS_REFCURSOR   : S Y S '_' R E F C U R S O R ;
T_SPATIAL         : S P A T I A L;
T_TABLE           : T A B L E ;
T_TILE            : T I L E ;
T_VIEW            : V I E W ;
T_TABLES          : T A B L E S ;
T_VIEWS           : V I E W S ;
T_TABLESPACE      : T A B L E S P A C E ;
T_TEMPORARY       : T E M P O R A R Y ;
T_TERMINATED      : T E R M I N A T E D ;
T_TEXTIMAGE_ON    : T E X T I M A G E '_' O N ;
T_THEN            : T H E N ;
T_TIMESTAMP       : T I M E S T A M P ;
T_TINYINT         : T I N Y I N T ;
T_TITLE           : T I T L E ;
T_TO              : T O ;
T_TOP             : T O P ;
T_TRANSACTION     : T R A N S A C T I O N ;
T_TRUE            : T R U E ;
T_TRUNCATE        : T R U N C A T E;
T_TYPE            : T Y P E ;
T_UNION           : U N I O N ;
T_UNIQUE          : U N I Q U E ;
T_UPDATE          : U P D A T E ;
T_UR              : U R ;
T_USE             : U S E ;
T_USING           : U S I N G ;
T_VALUE           : V A L U E ;
T_VALUES          : V A L U E S ;
T_VAR             : V A R ;
T_VARCHAR         : V A R C H A R ;
T_VARCHAR2        : V A R C H A R '2' ;
T_VARYING         : V A R Y I N G ;
T_VOLATILE        : V O L A T I L E ;
T_WHEN            : W H E N ;
T_WHERE           : W H E R E ;
T_WHILE           : W H I L E ;
T_WITH            : W I T H ;
T_WITHOUT         : W I T H O U T ;
T_WORK            : W O R K ;
T_XACT_ABORT      : X A C T '_' A B O R T ;
T_XML             : X M L ;
T_YES             : Y E S ;

// Functions with specific syntax
T_ACTIVITY_COUNT       : A C T I V I T Y '_' C O U N T ;
T_CUME_DIST            : C U M E '_' D I S T ;
T_CURRENT_DATE         : C U R R E N T '_' D A T E ;
T_CURRENT_TIME         : C U R R E N T '_' T I M E ;
T_PI                   : P I ;
T_CURRENT_TIMESTAMP    : C U R R E N T '_' T I M E S T A M P ;
T_CURRENT_USER         : C U R R E N T '_' U S E R ;
T_DENSE_RANK           : D E N S E '_' R A N K ;
T_FIRST_VALUE          : F I R S T '_' V A L U E;
T_LAG                  : L A G ;
T_LAST_VALUE           : L A S T '_' V A L U E;
T_LEAD                 : L E A D ;
T_MAX_PART_STRING      : M A X '_' P A R T '_' S T R I N G ;
T_MIN_PART_STRING      : M I N '_' P A R T '_' S T R I N G ;
T_MAX_PART_INT         : M A X '_' P A R T '_' I N T ;
T_MIN_PART_INT         : M I N '_' P A R T '_' I N T ;
T_MAX_PART_DATE        : M A X '_' P A R T '_' D A T E ;
T_MIN_PART_DATE        : M I N '_' P A R T '_' D A T E ;
T_PART_COUNT           : P A R T '_' C O U N T ;
T_PART_LOC             : P A R T '_' L O C ;
T_RANK                 : R A N K ;
T_ROW_NUMBER           : R O W '_' N U M B E R;
T_STDEV                : S T D E V ;
T_SYSDATE              : S Y S D A T E ;
T_VARIANCE             : V A R I A N C E ;
T_USER                 : U S E R ;
T_METADATA             : M E T A D A T A ;

T_LONG  : L O N G ;
T_BOOLEAN   : B O O L E A N ;
T_BOOL  : B O O L ;
T_BINARY    : B I N A R Y ;
T_GEOMETRY  : G E O M E T R Y ;
T_POINT : P O I N T ;
T_LINESTRING    : L I N E S T R I N G ;
T_POLYGON   : P O L Y G O N ;
T_MULTIPOINT    : M U L T I P O I N T ;
T_MULTILINESTRING   : M U L T I L I N E S T R I N G ;
T_MULTIPOLYGON    : M U L T I P O L Y G O N ;
T_GEOMETRYCOLLECTION  : G E O M E T R Y C O L L E C T I O N ;
T_TRAJECTORY    : T R A J E C T O R Y ;
T_ROADSEGMENT   : R O A D S E G M E N T ;
T_ROADNETWORK   : R O A D N E T W O R K ;

T_ADD          : '+' ;
T_COLON        : ':' ;
T_COMMA        : ',' ;
T_PIPE         : '||' ;
T_DIV          : '/' ;
T_DOT          : '.' ;
T_DOT2         : '..' ;
T_EQUAL        : '=' ;
T_EQUAL2       : '==' ;
T_NOTEQUAL     : '<>' ;
T_NOTEQUAL2    : '!=' ;
T_GREATER      : '>' ;
T_GREATEREQUAL : '>=' ;
T_LESS         : '<' ;
T_LESSEQUAL    : '<=' ;
T_MUL          : '*' ;
T_OPEN_B       : '{' ;
T_OPEN_P       : '(' ;
T_OPEN_SB      : '[' ;
T_CLOSE_B      : '}' ;
T_CLOSE_P      : ')' ;
T_CLOSE_SB     : ']' ;
T_SEMICOLON    : ';' ;
T_SUB          : '-' ;

L_ID        : L_ID_PART                                                // Identifier
            ;
L_S_STRING  : '\'' (('\'' '\'') | ('\\' '\'') | ~('\''))* '\''         // Single quoted string literal
            ;
L_D_STRING  : '"' (L_STR_ESC_D | .)*? '"'                              // Double quoted string literal
            ;
L_INT       : L_DIGIT+ ;                                               // Integer
L_DEC       : L_DIGIT+ '.' ~'.' L_DIGIT*                               // Decimal number
            | '.' L_DIGIT+
            ;
L_WS        : L_BLANK+ -> skip ;                                       // Whitespace
L_M_COMMENT : '/*' .*? '*/' -> channel(HIDDEN) ;                       // Multiline comment
L_S_COMMENT : ('--' | '//')  .*? '\r'? '\n' -> channel(HIDDEN) ;       // Single line comment

L_FILE      : ([a-zA-Z] ':' '\\'?)? L_ID ('\\' L_ID)*                  // File path (a/b/c Linux path causes conflicts with division operator and handled at parser level)
            ; 

//L_LABEL     : ([a-zA-Z] | L_DIGIT | '_')* ':' ;

fragment
L_ID_PART  :
             [a-zA-Z] ([a-zA-Z] | L_DIGIT | '_')*                           // Identifier part
            | '$' '{' .*? '}'
            | ('_' | '@' | '#' | '$') ([a-zA-Z] | L_DIGIT | '_' | '@' | '#' | '$')+     // (at least one char must follow special char)
            //| '"' .*? '"'                                                   // Quoted identifiers
            | '[' .*? ']'
            | '`' .*? '`'
            ;
fragment
L_STR_ESC_D :                                                          // Double quoted string escape sequence
              '""' | '\\"' 
            ;            
fragment
L_DIGIT     : [0-9]                                                    // Digit
            ;
fragment
L_BLANK     : (' ' | '\t' | '\r' | '\n')
            ;

// Support case-insensitive keywords and allowing case-sensitive identifiers
fragment A : ('a'|'A') ;
fragment B : ('b'|'B') ;
fragment C : ('c'|'C') ;
fragment D : ('d'|'D') ;
fragment E : ('e'|'E') ;
fragment F : ('f'|'F') ;
fragment G : ('g'|'G') ;
fragment H : ('h'|'H') ;
fragment I : ('i'|'I') ;
fragment J : ('j'|'J') ;
fragment K : ('k'|'K') ;
fragment L : ('l'|'L') ;
fragment M : ('m'|'M') ;
fragment N : ('n'|'N') ;
fragment O : ('o'|'O') ;
fragment P : ('p'|'P') ;
fragment Q : ('q'|'Q') ;
fragment R : ('r'|'R') ;
fragment S : ('s'|'S') ;
fragment T : ('t'|'T') ;
fragment U : ('u'|'U') ;
fragment V : ('v'|'V') ;
fragment W : ('w'|'W') ;
fragment X : ('x'|'X') ;
fragment Y : ('y'|'Y') ;
fragment Z : ('z'|'Z') ;
