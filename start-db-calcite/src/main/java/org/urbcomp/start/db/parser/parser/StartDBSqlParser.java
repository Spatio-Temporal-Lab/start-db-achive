/*
 * This file is inherited from Apache Calcite and modifed by ST-Lab under apache license.
 * You can find the original code from
 *
 * https://github.com/apache/calcite
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to you under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.urbcomp.start.db.parser.parser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({ "all", "warnings", "unchecked", "unused", "cast" })
public class StartDBSqlParser extends Parser {
    static {
        RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION);
    }

    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
        new PredictionContextCache();
    public static final int T__0 = 1, T_ACTION = 2, T_ADD2 = 3, T_ALL = 4, T_ALLOCATE = 5, T_ALTER =
        6, T_AND = 7, T_ANSI_NULLS = 8, T_ANSI_PADDING = 9, T_AS = 10, T_ASC = 11, T_ASSOCIATE = 12,
        T_AT = 13, T_AUTO = 14, T_AUTO_INCREMENT = 15, T_AVG = 16, T_BATCHSIZE = 17, T_BEGIN = 18,
        T_BETWEEN = 19, T_BIGINT = 20, T_BINARY_DOUBLE = 21, T_BINARY_FLOAT = 22, T_BINARY_INTEGER =
            23, T_BIT = 24, T_BODY = 25, T_BREAK = 26, T_BUILD = 27, T_BY = 28, T_BYTE = 29,
        T_CALL = 30, T_CALLER = 31, T_CASCADE = 32, T_CASE = 33, T_CASESPECIFIC = 34, T_CAST = 35,
        T_CHAR = 36, T_CHARACTER = 37, T_CHARSET = 38, T_CLIENT = 39, T_CLOSE = 40, T_CLUSTERED =
            41, T_CMP = 42, T_COLLECT = 43, T_COLLECTION = 44, T_COLUMN = 45, T_COMMENT = 46,
        T_CONFIG = 47, T_CONSTANT = 48, T_COMMIT = 49, T_COMPRESS = 50, T_CONCAT = 51, T_CONDITION =
            52, T_CONSTRAINT = 53, T_CONTINUE = 54, T_COPY = 55, T_COUNT = 56, T_COUNT_BIG = 57,
        T_CREATE = 58, T_CREATION = 59, T_CREATOR = 60, T_CS = 61, T_CURRENT = 62,
        T_CURRENT_SCHEMA = 63, T_CURSOR = 64, T_DATABASE = 65, T_DATABASES = 66, T_DATA = 67,
        T_DATE = 68, T_DATETIME = 69, T_DAY = 70, T_DAYS = 71, T_DEC = 72, T_DECIMAL = 73,
        T_DECLARE = 74, T_DEFAULT = 75, T_DEFERRED = 76, T_DEFINED = 77, T_DEFINER = 78,
        T_DEFINITION = 79, T_DELETE = 80, T_DELIMITED = 81, T_DELIMITER = 82, T_DESC = 83,
        T_DESCRIBE = 84, T_DIAGNOSTICS = 85, T_DIR = 86, T_DIRECTORY = 87, T_DISTINCT = 88,
        T_DISTRIBUTE = 89, T_DO = 90, T_DOUBLE = 91, T_DOWNLOAD = 92, T_DROP = 93, T_DYNAMIC = 94,
        T_ELSE = 95, T_ELSEIF = 96, T_ELSIF = 97, T_ENABLE = 98, T_END = 99, T_ENGINE = 100,
        T_ESCAPED = 101, T_EXCEPT = 102, T_EXEC = 103, T_EXECUTE = 104, T_EXCEPTION = 105,
        T_EXCLUSIVE = 106, T_EXISTS = 107, T_EXIT = 108, T_FALLBACK = 109, T_FALSE = 110, T_FETCH =
            111, T_FIELDS = 112, T_FILE = 113, T_FILES = 114, T_FLOAT = 115, T_FOR = 116,
        T_FOREIGN = 117, T_FORMAT = 118, T_FOUND = 119, T_FROM = 120, T_FULL = 121, T_FUNCTION =
            122, T_GET = 123, T_GLOBAL = 124, T_GO = 125, T_GRANT = 126, T_GRANTS = 127, T_GROUP =
                128, T_HANDLER = 129, T_HASH = 130, T_HAVING = 131, T_HOST = 132, T_IDENTITY = 133,
        T_IDENTIFIED = 134, T_IF = 135, T_IGNORE = 136, T_IMMEDIATE = 137, T_IN = 138, T_INCLUDE =
            139, T_INCREMENT = 140, T_INDEX = 141, T_INITRANS = 142, T_INNER = 143, T_INOUT = 144,
        T_INSERT = 145, T_INT = 146, T_INT2 = 147, T_INT4 = 148, T_INT8 = 149, T_INTEGER = 150,
        T_INTERSECT = 151, T_INTERVAL = 152, T_INTO = 153, T_INVOKER = 154, T_IS = 155, T_ISOPEN =
            156, T_ITEMS = 157, T_JOIN = 158, T_KEEP = 159, T_KILL = 160, T_KEY = 161, T_KEYS = 162,
        T_KV_SEARCH = 163, T_LANGUAGE = 164, T_LEAVE = 165, T_LEFT = 166, T_LIKE = 167, T_LIMIT =
            168, T_LINES = 169, T_LOAD = 170, T_LOCAL = 171, T_LOCATION = 172, T_LOCATOR = 173,
        T_LOCATORS = 174, T_LOCKS = 175, T_LOG = 176, T_LOGGED = 177, T_LOGGING = 178, T_LOOP = 179,
        T_MAP = 180, T_MATCHED = 181, T_MAX = 182, T_MAXTRANS = 183, T_MERGE = 184, T_MESSAGE_TEXT =
            185, T_MICROSECOND = 186, T_MICROSECONDS = 187, T_MIN = 188, T_MULTISET = 189, T_NCHAR =
                190, T_NEW = 191, T_NVARCHAR = 192, T_NO = 193, T_NOCOUNT = 194, T_NOCOMPRESS = 195,
        T_NOLOGGING = 196, T_NONE = 197, T_NOT = 198, T_NOTFOUND = 199, T_NULL = 200, T_NUMERIC =
            201, T_NUMBER = 202, T_OBJECT = 203, T_OFF = 204, T_ON = 205, T_ONLY = 206, T_OPEN =
                207, T_OR = 208, T_ORDER = 209, T_OUT = 210, T_OUTER = 211, T_OVER = 212,
        T_OVERWRITE = 213, T_OWNER = 214, T_PACKAGE = 215, T_PARTITION = 216, T_PASSWORD = 217,
        T_PCTFREE = 218, T_PCTUSED = 219, T_PERCENT = 220, T_PLS_INTEGER = 221, T_PRECISION = 222,
        T_PRESERVE = 223, T_PRIVILEGES = 224, T_PRIMARY = 225, T_PRINT = 226, T_PROC = 227,
        T_PROCEDURE = 228, T_PYRAMID = 229, T_PYRAMIDS = 230, T_QUERY = 231, T_QUERIES = 232,
        T_QUALIFY = 233, T_QUERY_BAND = 234, T_QUIT = 235, T_QUOTED_IDENTIFIER = 236, T_RAISE = 237,
        T_REAL = 238, T_REFERENCES = 239, T_REGEXP = 240, T_RENAME = 241, T_REPLACE = 242,
        T_RESIGNAL = 243, T_RESTRICT = 244, T_RESULT = 245, T_RESULT_SET_LOCATOR = 246, T_RETURN =
            247, T_RETURNS = 248, T_REVERSE = 249, T_REVOKE = 250, T_RIGHT = 251, T_RLIKE = 252,
        T_ROLE = 253, T_ROLLBACK = 254, T_ROW = 255, T_ROWS = 256, T_ROWTYPE = 257, T_ROW_COUNT =
            258, T_RR = 259, T_RS = 260, T_PWD = 261, T_TRIM = 262, T_TABLESAMPLE = 263, T_SCHEMA =
                264, T_SECOND = 265, T_SECONDS = 266, T_SECURITY = 267, T_SEGMENT = 268, T_SEL =
                    269, T_SELECT = 270, T_SET = 271, T_SESSION = 272, T_SESSIONS = 273, T_SETS =
                        274, T_SHOW = 275, T_SIGNAL = 276, T_SIMPLE_DOUBLE = 277, T_SIMPLE_FLOAT =
                            278, T_SIMPLE_INTEGER = 279, T_SMALLDATETIME = 280, T_SMALLINT = 281,
        T_SQL = 282, T_SQLEXCEPTION = 283, T_SQLINSERT = 284, T_SQLSTATE = 285, T_SQLWARNING = 286,
        T_SRID = 287, T_STATS = 288, T_STATISTICS = 289, T_STATUS = 290, T_STEP = 291, T_STORAGE =
            292, T_STORE = 293, T_STORED = 294, T_STRING = 295, T_SUBDIR = 296, T_SUBSTRING = 297,
        T_SUM = 298, T_SUMMARY = 299, T_SYS_REFCURSOR = 300, T_TABLE = 301, T_TILE = 302, T_VIEW =
            303, T_TABLES = 304, T_VIEWS = 305, T_TABLESPACE = 306, T_TEMPORARY = 307,
        T_TERMINATED = 308, T_TEXTIMAGE_ON = 309, T_THEN = 310, T_TIMESTAMP = 311, T_TINYINT = 312,
        T_TITLE = 313, T_TO = 314, T_TOP = 315, T_TRANSACTION = 316, T_TRUE = 317, T_TRUNCATE = 318,
        T_TYPE = 319, T_UNION = 320, T_UNIQUE = 321, T_UPDATE = 322, T_UR = 323, T_USE = 324,
        T_USING = 325, T_VALUE = 326, T_VALUES = 327, T_VAR = 328, T_VARCHAR = 329, T_VARCHAR2 =
            330, T_VARYING = 331, T_VOLATILE = 332, T_WHEN = 333, T_WHERE = 334, T_WHILE = 335,
        T_WITH = 336, T_WITHOUT = 337, T_WORK = 338, T_XACT_ABORT = 339, T_XML = 340, T_YES = 341,
        T_ACTIVITY_COUNT = 342, T_CUME_DIST = 343, T_CURRENT_DATE = 344, T_CURRENT_TIME = 345,
        T_PI = 346, T_CURRENT_TIMESTAMP = 347, T_CURRENT_USER = 348, T_DENSE_RANK = 349,
        T_FIRST_VALUE = 350, T_LAG = 351, T_LAST_VALUE = 352, T_LEAD = 353, T_MAX_PART_STRING = 354,
        T_MIN_PART_STRING = 355, T_MAX_PART_INT = 356, T_MIN_PART_INT = 357, T_MAX_PART_DATE = 358,
        T_MIN_PART_DATE = 359, T_PART_COUNT = 360, T_PART_LOC = 361, T_RANK = 362, T_ROW_NUMBER =
            363, T_STDEV = 364, T_SYSDATE = 365, T_VARIANCE = 366, T_USER = 367, T_METADATA = 368,
        T_LONG = 369, T_BOOLEAN = 370, T_BOOL = 371, T_BINARY = 372, T_GEOMETRY = 373, T_POINT =
            374, T_LINESTRING = 375, T_POLYGON = 376, T_MULTIPOINT = 377, T_MULTILINESTRING = 378,
        T_MULTIPOLYGON = 379, T_GEOMETRYCOLLECTION = 380, T_TRAJECTORY = 381, T_ROADSEGMENT = 382,
        T_ROADNETWORK = 383, T_ADD = 384, T_COLON = 385, T_COMMA = 386, T_PIPE = 387, T_DIV = 388,
        T_DOT = 389, T_DOT2 = 390, T_EQUAL = 391, T_EQUAL2 = 392, T_NOTEQUAL = 393, T_NOTEQUAL2 =
            394, T_GREATER = 395, T_GREATEREQUAL = 396, T_LESS = 397, T_LESSEQUAL = 398, T_MUL =
                399, T_OPEN_B = 400, T_OPEN_P = 401, T_OPEN_SB = 402, T_CLOSE_B = 403, T_CLOSE_P =
                    404, T_CLOSE_SB = 405, T_SEMICOLON = 406, T_SUB = 407, L_ID = 408, L_S_STRING =
                        409, L_D_STRING = 410, L_INT = 411, L_DEC = 412, L_WS = 413, L_M_COMMENT =
                            414, L_S_COMMENT = 415, L_FILE = 416;
    public static final int RULE_program = 0, RULE_stmt = 1, RULE_dbDotTable = 2,
        RULE_userDotDbDotTable = 3, RULE_assignmentStmtItem = 4, RULE_assignmentStmtSingleItem = 5,
        RULE_assignmentStmtMultipleItem = 6, RULE_assignmentStmtSelectItem = 7,
        RULE_showCreateTableStmt = 8, RULE_showStatusStmt = 9, RULE_createTableStmt = 10,
        RULE_createUserStmt = 11, RULE_create_table_definition = 12, RULE_create_table_columns = 13,
        RULE_create_table_columns_item = 14, RULE_column_name = 15,
        RULE_create_table_column_inline_cons = 16, RULE_create_table_column_cons = 17,
        RULE_create_table_fk_action = 18, RULE_create_table_preoptions = 19,
        RULE_create_table_preoptions_item = 20, RULE_create_table_preoptions_td_item = 21,
        RULE_create_table_options = 22, RULE_create_table_options_item = 23,
        RULE_create_table_options_mysql_item = 24, RULE_createIndexStmt = 25, RULE_createIndexCol =
            26, RULE_dtype_default = 27, RULE_showTablesStmt = 28, RULE_dtype_attr = 29,
        RULE_dtype = 30, RULE_dtypeLen = 31, RULE_createDatabaseStmt = 32, RULE_showDatabasesStmt =
            33, RULE_dropDatabaseStmt = 34, RULE_createDatabaseOption = 35, RULE_dropTableStmt = 36,
        RULE_insertStmt = 37, RULE_insertStmtCols = 38, RULE_insertStmtRows = 39,
        RULE_insertStmtRow = 40, RULE_truncateStmt = 41, RULE_useStmt = 42, RULE_selectStmt = 43,
        RULE_cteSelectStmt = 44, RULE_cteSelectStmtItem = 45, RULE_cteSelectCols = 46,
        RULE_fullselectStmt = 47, RULE_fullselectStmtItem = 48, RULE_fullselectSetClause = 49,
        RULE_subselectStmt = 50, RULE_selectList = 51, RULE_selectListSet = 52,
        RULE_selectListLimit = 53, RULE_selectListItem = 54, RULE_selectListAlias = 55,
        RULE_selectListAsterisk = 56, RULE_intoClause = 57, RULE_fromClause = 58,
        RULE_fromTableClause = 59, RULE_fromTableNameClause = 60, RULE_fromSubselectClause = 61,
        RULE_fromJoinClause = 62, RULE_fromJoinTypeClause = 63, RULE_fromTableValuesClause = 64,
        RULE_fromTableValuesRow = 65, RULE_fromAliasClause = 66, RULE_tableName = 67,
        RULE_whereClause = 68, RULE_groupByClause = 69, RULE_havingClause = 70, RULE_qualifyClause =
            71, RULE_orderByClause = 72, RULE_orderByClauseItem = 73, RULE_sampleClause = 74,
        RULE_selectOptions = 75, RULE_selectOptionsItem = 76, RULE_updateStmt = 77,
        RULE_updateAssignment = 78, RULE_updateTable = 79, RULE_updateUpsert = 80, RULE_deleteStmt =
            81, RULE_deleteAlias = 82, RULE_describeStmt = 83, RULE_boolExpr = 84,
        RULE_boolExprAtom = 85, RULE_boolExprUnary = 86, RULE_boolExprSingleIn = 87,
        RULE_boolExprMultiIn = 88, RULE_boolExprBinary = 89, RULE_boolExprLogicalOperator = 90,
        RULE_boolExprBinaryOperator = 91, RULE_expr = 92, RULE_exprAtom = 93, RULE_exprInterval =
            94, RULE_intervalItem = 95, RULE_exprConcat = 96, RULE_exprConcatItem = 97,
        RULE_exprCase = 98, RULE_exprCaseSimple = 99, RULE_exprCaseSearched = 100,
        RULE_exprCaseItem = 101, RULE_exprCursorAttribute = 102, RULE_exprAggWindowFunc = 103,
        RULE_exprFuncAllDistinct = 104, RULE_exprFuncOverClause = 105,
        RULE_exprFuncPartitionByClause = 106, RULE_exprSpecFunc = 107, RULE_exprFunc = 108,
        RULE_exprFuncParams = 109, RULE_funcParam = 110, RULE_table_name = 111, RULE_user_name =
            112, RULE_qident = 113, RULE_dateLiteral = 114, RULE_timestampLiteral = 115,
        RULE_ident = 116, RULE_identItem = 117, RULE_string = 118, RULE_intNumber = 119,
        RULE_decNumber = 120, RULE_boolLiteral = 121, RULE_nullConst = 122, RULE_nonReservedWords =
            123;

    private static String[] makeRuleNames() {
        return new String[] {
            "program",
            "stmt",
            "dbDotTable",
            "userDotDbDotTable",
            "assignmentStmtItem",
            "assignmentStmtSingleItem",
            "assignmentStmtMultipleItem",
            "assignmentStmtSelectItem",
            "showCreateTableStmt",
            "showStatusStmt",
            "createTableStmt",
            "createUserStmt",
            "create_table_definition",
            "create_table_columns",
            "create_table_columns_item",
            "column_name",
            "create_table_column_inline_cons",
            "create_table_column_cons",
            "create_table_fk_action",
            "create_table_preoptions",
            "create_table_preoptions_item",
            "create_table_preoptions_td_item",
            "create_table_options",
            "create_table_options_item",
            "create_table_options_mysql_item",
            "createIndexStmt",
            "createIndexCol",
            "dtype_default",
            "showTablesStmt",
            "dtype_attr",
            "dtype",
            "dtypeLen",
            "createDatabaseStmt",
            "showDatabasesStmt",
            "dropDatabaseStmt",
            "createDatabaseOption",
            "dropTableStmt",
            "insertStmt",
            "insertStmtCols",
            "insertStmtRows",
            "insertStmtRow",
            "truncateStmt",
            "useStmt",
            "selectStmt",
            "cteSelectStmt",
            "cteSelectStmtItem",
            "cteSelectCols",
            "fullselectStmt",
            "fullselectStmtItem",
            "fullselectSetClause",
            "subselectStmt",
            "selectList",
            "selectListSet",
            "selectListLimit",
            "selectListItem",
            "selectListAlias",
            "selectListAsterisk",
            "intoClause",
            "fromClause",
            "fromTableClause",
            "fromTableNameClause",
            "fromSubselectClause",
            "fromJoinClause",
            "fromJoinTypeClause",
            "fromTableValuesClause",
            "fromTableValuesRow",
            "fromAliasClause",
            "tableName",
            "whereClause",
            "groupByClause",
            "havingClause",
            "qualifyClause",
            "orderByClause",
            "orderByClauseItem",
            "sampleClause",
            "selectOptions",
            "selectOptionsItem",
            "updateStmt",
            "updateAssignment",
            "updateTable",
            "updateUpsert",
            "deleteStmt",
            "deleteAlias",
            "describeStmt",
            "boolExpr",
            "boolExprAtom",
            "boolExprUnary",
            "boolExprSingleIn",
            "boolExprMultiIn",
            "boolExprBinary",
            "boolExprLogicalOperator",
            "boolExprBinaryOperator",
            "expr",
            "exprAtom",
            "exprInterval",
            "intervalItem",
            "exprConcat",
            "exprConcatItem",
            "exprCase",
            "exprCaseSimple",
            "exprCaseSearched",
            "exprCaseItem",
            "exprCursorAttribute",
            "exprAggWindowFunc",
            "exprFuncAllDistinct",
            "exprFuncOverClause",
            "exprFuncPartitionByClause",
            "exprSpecFunc",
            "exprFunc",
            "exprFuncParams",
            "funcParam",
            "table_name",
            "user_name",
            "qident",
            "dateLiteral",
            "timestampLiteral",
            "ident",
            "identItem",
            "string",
            "intNumber",
            "decNumber",
            "boolLiteral",
            "nullConst",
            "nonReservedWords" };
    }

    public static final String[] ruleNames = makeRuleNames();

    private static String[] makeLiteralNames() {
        return new String[] {
            null,
            "'%'",
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            "'+'",
            "':'",
            "','",
            "'||'",
            "'/'",
            "'.'",
            "'..'",
            "'='",
            "'=='",
            "'<>'",
            "'!='",
            "'>'",
            "'>='",
            "'<'",
            "'<='",
            "'*'",
            "'{'",
            "'('",
            "'['",
            "'}'",
            "')'",
            "']'",
            "';'",
            "'-'" };
    }

    private static final String[] _LITERAL_NAMES = makeLiteralNames();

    private static String[] makeSymbolicNames() {
        return new String[] {
            null,
            null,
            "T_ACTION",
            "T_ADD2",
            "T_ALL",
            "T_ALLOCATE",
            "T_ALTER",
            "T_AND",
            "T_ANSI_NULLS",
            "T_ANSI_PADDING",
            "T_AS",
            "T_ASC",
            "T_ASSOCIATE",
            "T_AT",
            "T_AUTO",
            "T_AUTO_INCREMENT",
            "T_AVG",
            "T_BATCHSIZE",
            "T_BEGIN",
            "T_BETWEEN",
            "T_BIGINT",
            "T_BINARY_DOUBLE",
            "T_BINARY_FLOAT",
            "T_BINARY_INTEGER",
            "T_BIT",
            "T_BODY",
            "T_BREAK",
            "T_BUILD",
            "T_BY",
            "T_BYTE",
            "T_CALL",
            "T_CALLER",
            "T_CASCADE",
            "T_CASE",
            "T_CASESPECIFIC",
            "T_CAST",
            "T_CHAR",
            "T_CHARACTER",
            "T_CHARSET",
            "T_CLIENT",
            "T_CLOSE",
            "T_CLUSTERED",
            "T_CMP",
            "T_COLLECT",
            "T_COLLECTION",
            "T_COLUMN",
            "T_COMMENT",
            "T_CONFIG",
            "T_CONSTANT",
            "T_COMMIT",
            "T_COMPRESS",
            "T_CONCAT",
            "T_CONDITION",
            "T_CONSTRAINT",
            "T_CONTINUE",
            "T_COPY",
            "T_COUNT",
            "T_COUNT_BIG",
            "T_CREATE",
            "T_CREATION",
            "T_CREATOR",
            "T_CS",
            "T_CURRENT",
            "T_CURRENT_SCHEMA",
            "T_CURSOR",
            "T_DATABASE",
            "T_DATABASES",
            "T_DATA",
            "T_DATE",
            "T_DATETIME",
            "T_DAY",
            "T_DAYS",
            "T_DEC",
            "T_DECIMAL",
            "T_DECLARE",
            "T_DEFAULT",
            "T_DEFERRED",
            "T_DEFINED",
            "T_DEFINER",
            "T_DEFINITION",
            "T_DELETE",
            "T_DELIMITED",
            "T_DELIMITER",
            "T_DESC",
            "T_DESCRIBE",
            "T_DIAGNOSTICS",
            "T_DIR",
            "T_DIRECTORY",
            "T_DISTINCT",
            "T_DISTRIBUTE",
            "T_DO",
            "T_DOUBLE",
            "T_DOWNLOAD",
            "T_DROP",
            "T_DYNAMIC",
            "T_ELSE",
            "T_ELSEIF",
            "T_ELSIF",
            "T_ENABLE",
            "T_END",
            "T_ENGINE",
            "T_ESCAPED",
            "T_EXCEPT",
            "T_EXEC",
            "T_EXECUTE",
            "T_EXCEPTION",
            "T_EXCLUSIVE",
            "T_EXISTS",
            "T_EXIT",
            "T_FALLBACK",
            "T_FALSE",
            "T_FETCH",
            "T_FIELDS",
            "T_FILE",
            "T_FILES",
            "T_FLOAT",
            "T_FOR",
            "T_FOREIGN",
            "T_FORMAT",
            "T_FOUND",
            "T_FROM",
            "T_FULL",
            "T_FUNCTION",
            "T_GET",
            "T_GLOBAL",
            "T_GO",
            "T_GRANT",
            "T_GRANTS",
            "T_GROUP",
            "T_HANDLER",
            "T_HASH",
            "T_HAVING",
            "T_HOST",
            "T_IDENTITY",
            "T_IDENTIFIED",
            "T_IF",
            "T_IGNORE",
            "T_IMMEDIATE",
            "T_IN",
            "T_INCLUDE",
            "T_INCREMENT",
            "T_INDEX",
            "T_INITRANS",
            "T_INNER",
            "T_INOUT",
            "T_INSERT",
            "T_INT",
            "T_INT2",
            "T_INT4",
            "T_INT8",
            "T_INTEGER",
            "T_INTERSECT",
            "T_INTERVAL",
            "T_INTO",
            "T_INVOKER",
            "T_IS",
            "T_ISOPEN",
            "T_ITEMS",
            "T_JOIN",
            "T_KEEP",
            "T_KILL",
            "T_KEY",
            "T_KEYS",
            "T_KV_SEARCH",
            "T_LANGUAGE",
            "T_LEAVE",
            "T_LEFT",
            "T_LIKE",
            "T_LIMIT",
            "T_LINES",
            "T_LOAD",
            "T_LOCAL",
            "T_LOCATION",
            "T_LOCATOR",
            "T_LOCATORS",
            "T_LOCKS",
            "T_LOG",
            "T_LOGGED",
            "T_LOGGING",
            "T_LOOP",
            "T_MAP",
            "T_MATCHED",
            "T_MAX",
            "T_MAXTRANS",
            "T_MERGE",
            "T_MESSAGE_TEXT",
            "T_MICROSECOND",
            "T_MICROSECONDS",
            "T_MIN",
            "T_MULTISET",
            "T_NCHAR",
            "T_NEW",
            "T_NVARCHAR",
            "T_NO",
            "T_NOCOUNT",
            "T_NOCOMPRESS",
            "T_NOLOGGING",
            "T_NONE",
            "T_NOT",
            "T_NOTFOUND",
            "T_NULL",
            "T_NUMERIC",
            "T_NUMBER",
            "T_OBJECT",
            "T_OFF",
            "T_ON",
            "T_ONLY",
            "T_OPEN",
            "T_OR",
            "T_ORDER",
            "T_OUT",
            "T_OUTER",
            "T_OVER",
            "T_OVERWRITE",
            "T_OWNER",
            "T_PACKAGE",
            "T_PARTITION",
            "T_PASSWORD",
            "T_PCTFREE",
            "T_PCTUSED",
            "T_PERCENT",
            "T_PLS_INTEGER",
            "T_PRECISION",
            "T_PRESERVE",
            "T_PRIVILEGES",
            "T_PRIMARY",
            "T_PRINT",
            "T_PROC",
            "T_PROCEDURE",
            "T_PYRAMID",
            "T_PYRAMIDS",
            "T_QUERY",
            "T_QUERIES",
            "T_QUALIFY",
            "T_QUERY_BAND",
            "T_QUIT",
            "T_QUOTED_IDENTIFIER",
            "T_RAISE",
            "T_REAL",
            "T_REFERENCES",
            "T_REGEXP",
            "T_RENAME",
            "T_REPLACE",
            "T_RESIGNAL",
            "T_RESTRICT",
            "T_RESULT",
            "T_RESULT_SET_LOCATOR",
            "T_RETURN",
            "T_RETURNS",
            "T_REVERSE",
            "T_REVOKE",
            "T_RIGHT",
            "T_RLIKE",
            "T_ROLE",
            "T_ROLLBACK",
            "T_ROW",
            "T_ROWS",
            "T_ROWTYPE",
            "T_ROW_COUNT",
            "T_RR",
            "T_RS",
            "T_PWD",
            "T_TRIM",
            "T_TABLESAMPLE",
            "T_SCHEMA",
            "T_SECOND",
            "T_SECONDS",
            "T_SECURITY",
            "T_SEGMENT",
            "T_SEL",
            "T_SELECT",
            "T_SET",
            "T_SESSION",
            "T_SESSIONS",
            "T_SETS",
            "T_SHOW",
            "T_SIGNAL",
            "T_SIMPLE_DOUBLE",
            "T_SIMPLE_FLOAT",
            "T_SIMPLE_INTEGER",
            "T_SMALLDATETIME",
            "T_SMALLINT",
            "T_SQL",
            "T_SQLEXCEPTION",
            "T_SQLINSERT",
            "T_SQLSTATE",
            "T_SQLWARNING",
            "T_SRID",
            "T_STATS",
            "T_STATISTICS",
            "T_STATUS",
            "T_STEP",
            "T_STORAGE",
            "T_STORE",
            "T_STORED",
            "T_STRING",
            "T_SUBDIR",
            "T_SUBSTRING",
            "T_SUM",
            "T_SUMMARY",
            "T_SYS_REFCURSOR",
            "T_TABLE",
            "T_TILE",
            "T_VIEW",
            "T_TABLES",
            "T_VIEWS",
            "T_TABLESPACE",
            "T_TEMPORARY",
            "T_TERMINATED",
            "T_TEXTIMAGE_ON",
            "T_THEN",
            "T_TIMESTAMP",
            "T_TINYINT",
            "T_TITLE",
            "T_TO",
            "T_TOP",
            "T_TRANSACTION",
            "T_TRUE",
            "T_TRUNCATE",
            "T_TYPE",
            "T_UNION",
            "T_UNIQUE",
            "T_UPDATE",
            "T_UR",
            "T_USE",
            "T_USING",
            "T_VALUE",
            "T_VALUES",
            "T_VAR",
            "T_VARCHAR",
            "T_VARCHAR2",
            "T_VARYING",
            "T_VOLATILE",
            "T_WHEN",
            "T_WHERE",
            "T_WHILE",
            "T_WITH",
            "T_WITHOUT",
            "T_WORK",
            "T_XACT_ABORT",
            "T_XML",
            "T_YES",
            "T_ACTIVITY_COUNT",
            "T_CUME_DIST",
            "T_CURRENT_DATE",
            "T_CURRENT_TIME",
            "T_PI",
            "T_CURRENT_TIMESTAMP",
            "T_CURRENT_USER",
            "T_DENSE_RANK",
            "T_FIRST_VALUE",
            "T_LAG",
            "T_LAST_VALUE",
            "T_LEAD",
            "T_MAX_PART_STRING",
            "T_MIN_PART_STRING",
            "T_MAX_PART_INT",
            "T_MIN_PART_INT",
            "T_MAX_PART_DATE",
            "T_MIN_PART_DATE",
            "T_PART_COUNT",
            "T_PART_LOC",
            "T_RANK",
            "T_ROW_NUMBER",
            "T_STDEV",
            "T_SYSDATE",
            "T_VARIANCE",
            "T_USER",
            "T_METADATA",
            "T_LONG",
            "T_BOOLEAN",
            "T_BOOL",
            "T_BINARY",
            "T_GEOMETRY",
            "T_POINT",
            "T_LINESTRING",
            "T_POLYGON",
            "T_MULTIPOINT",
            "T_MULTILINESTRING",
            "T_MULTIPOLYGON",
            "T_GEOMETRYCOLLECTION",
            "T_TRAJECTORY",
            "T_ROADSEGMENT",
            "T_ROADNETWORK",
            "T_ADD",
            "T_COLON",
            "T_COMMA",
            "T_PIPE",
            "T_DIV",
            "T_DOT",
            "T_DOT2",
            "T_EQUAL",
            "T_EQUAL2",
            "T_NOTEQUAL",
            "T_NOTEQUAL2",
            "T_GREATER",
            "T_GREATEREQUAL",
            "T_LESS",
            "T_LESSEQUAL",
            "T_MUL",
            "T_OPEN_B",
            "T_OPEN_P",
            "T_OPEN_SB",
            "T_CLOSE_B",
            "T_CLOSE_P",
            "T_CLOSE_SB",
            "T_SEMICOLON",
            "T_SUB",
            "L_ID",
            "L_S_STRING",
            "L_D_STRING",
            "L_INT",
            "L_DEC",
            "L_WS",
            "L_M_COMMENT",
            "L_S_COMMENT",
            "L_FILE" };
    }

    private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
    public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

    /**
     * @deprecated Use {@link #VOCABULARY} instead.
     */
    @Deprecated
    public static final String[] tokenNames;
    static {
        tokenNames = new String[_SYMBOLIC_NAMES.length];
        for (int i = 0; i < tokenNames.length; i++) {
            tokenNames[i] = VOCABULARY.getLiteralName(i);
            if (tokenNames[i] == null) {
                tokenNames[i] = VOCABULARY.getSymbolicName(i);
            }

            if (tokenNames[i] == null) {
                tokenNames[i] = "<INVALID>";
            }
        }
    }

    @Override
    @Deprecated
    public String[] getTokenNames() {
        return tokenNames;
    }

    @Override

    public Vocabulary getVocabulary() {
        return VOCABULARY;
    }

    @Override
    public String getGrammarFileName() {
        return "StartDBSql.g4";
    }

    @Override
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    public StartDBSqlParser(TokenStream input) {
        super(input);
        _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    public static class ProgramContext extends ParserRuleContext {
        public StmtContext stmt() {
            return getRuleContext(StmtContext.class, 0);
        }

        public TerminalNode EOF() {
            return getToken(StartDBSqlParser.EOF, 0);
        }

        public TerminalNode T_SEMICOLON() {
            return getToken(StartDBSqlParser.T_SEMICOLON, 0);
        }

        public ProgramContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_program;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitProgram(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ProgramContext program() throws RecognitionException {
        ProgramContext _localctx = new ProgramContext(_ctx, getState());
        enterRule(_localctx, 0, RULE_program);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(248);
                stmt();
                setState(250);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_SEMICOLON) {
                    {
                        setState(249);
                        match(T_SEMICOLON);
                    }
                }

                setState(252);
                match(EOF);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class StmtContext extends ParserRuleContext {
        public CreateDatabaseStmtContext createDatabaseStmt() {
            return getRuleContext(CreateDatabaseStmtContext.class, 0);
        }

        public CreateTableStmtContext createTableStmt() {
            return getRuleContext(CreateTableStmtContext.class, 0);
        }

        public CreateIndexStmtContext createIndexStmt() {
            return getRuleContext(CreateIndexStmtContext.class, 0);
        }

        public DescribeStmtContext describeStmt() {
            return getRuleContext(DescribeStmtContext.class, 0);
        }

        public DropDatabaseStmtContext dropDatabaseStmt() {
            return getRuleContext(DropDatabaseStmtContext.class, 0);
        }

        public DropTableStmtContext dropTableStmt() {
            return getRuleContext(DropTableStmtContext.class, 0);
        }

        public TruncateStmtContext truncateStmt() {
            return getRuleContext(TruncateStmtContext.class, 0);
        }

        public UseStmtContext useStmt() {
            return getRuleContext(UseStmtContext.class, 0);
        }

        public ShowDatabasesStmtContext showDatabasesStmt() {
            return getRuleContext(ShowDatabasesStmtContext.class, 0);
        }

        public ShowTablesStmtContext showTablesStmt() {
            return getRuleContext(ShowTablesStmtContext.class, 0);
        }

        public ShowCreateTableStmtContext showCreateTableStmt() {
            return getRuleContext(ShowCreateTableStmtContext.class, 0);
        }

        public ShowStatusStmtContext showStatusStmt() {
            return getRuleContext(ShowStatusStmtContext.class, 0);
        }

        public InsertStmtContext insertStmt() {
            return getRuleContext(InsertStmtContext.class, 0);
        }

        public UpdateStmtContext updateStmt() {
            return getRuleContext(UpdateStmtContext.class, 0);
        }

        public DeleteStmtContext deleteStmt() {
            return getRuleContext(DeleteStmtContext.class, 0);
        }

        public SelectStmtContext selectStmt() {
            return getRuleContext(SelectStmtContext.class, 0);
        }

        public CreateUserStmtContext createUserStmt() {
            return getRuleContext(CreateUserStmtContext.class, 0);
        }

        public StmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_stmt;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitStmt(this);
            else return visitor.visitChildren(this);
        }
    }

    public final StmtContext stmt() throws RecognitionException {
        StmtContext _localctx = new StmtContext(_ctx, getState());
        enterRule(_localctx, 2, RULE_stmt);
        try {
            setState(271);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 1, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1); {
                    setState(254);
                    createDatabaseStmt();
                }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2); {
                    setState(255);
                    createTableStmt();
                }
                    break;
                case 3:
                    enterOuterAlt(_localctx, 3); {
                    setState(256);
                    createIndexStmt();
                }
                    break;
                case 4:
                    enterOuterAlt(_localctx, 4); {
                    setState(257);
                    describeStmt();
                }
                    break;
                case 5:
                    enterOuterAlt(_localctx, 5); {
                    setState(258);
                    dropDatabaseStmt();
                }
                    break;
                case 6:
                    enterOuterAlt(_localctx, 6); {
                    setState(259);
                    dropTableStmt();
                }
                    break;
                case 7:
                    enterOuterAlt(_localctx, 7); {
                    setState(260);
                    truncateStmt();
                }
                    break;
                case 8:
                    enterOuterAlt(_localctx, 8); {
                    setState(261);
                    useStmt();
                }
                    break;
                case 9:
                    enterOuterAlt(_localctx, 9); {
                    setState(262);
                    showDatabasesStmt();
                }
                    break;
                case 10:
                    enterOuterAlt(_localctx, 10); {
                    setState(263);
                    showTablesStmt();
                }
                    break;
                case 11:
                    enterOuterAlt(_localctx, 11); {
                    setState(264);
                    showCreateTableStmt();
                }
                    break;
                case 12:
                    enterOuterAlt(_localctx, 12); {
                    setState(265);
                    showStatusStmt();
                }
                    break;
                case 13:
                    enterOuterAlt(_localctx, 13); {
                    setState(266);
                    insertStmt();
                }
                    break;
                case 14:
                    enterOuterAlt(_localctx, 14); {
                    setState(267);
                    updateStmt();
                }
                    break;
                case 15:
                    enterOuterAlt(_localctx, 15); {
                    setState(268);
                    deleteStmt();
                }
                    break;
                case 16:
                    enterOuterAlt(_localctx, 16); {
                    setState(269);
                    selectStmt();
                }
                    break;
                case 17:
                    enterOuterAlt(_localctx, 17); {
                    setState(270);
                    createUserStmt();
                }
                    break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class DbDotTableContext extends ParserRuleContext {
        public Token db;
        public Token table;

        public List<TerminalNode> T_MUL() {
            return getTokens(StartDBSqlParser.T_MUL);
        }

        public TerminalNode T_MUL(int i) {
            return getToken(StartDBSqlParser.T_MUL, i);
        }

        public List<TerminalNode> T_DEFAULT() {
            return getTokens(StartDBSqlParser.T_DEFAULT);
        }

        public TerminalNode T_DEFAULT(int i) {
            return getToken(StartDBSqlParser.T_DEFAULT, i);
        }

        public List<TerminalNode> L_ID() {
            return getTokens(StartDBSqlParser.L_ID);
        }

        public TerminalNode L_ID(int i) {
            return getToken(StartDBSqlParser.L_ID, i);
        }

        public TerminalNode T_DOT() {
            return getToken(StartDBSqlParser.T_DOT, 0);
        }

        public DbDotTableContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_dbDotTable;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitDbDotTable(this);
            else return visitor.visitChildren(this);
        }
    }

    public final DbDotTableContext dbDotTable() throws RecognitionException {
        DbDotTableContext _localctx = new DbDotTableContext(_ctx, getState());
        enterRule(_localctx, 4, RULE_dbDotTable);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(275);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 2, _ctx)) {
                    case 1: {
                        setState(273);
                        ((DbDotTableContext) _localctx).db = _input.LT(1);
                        _la = _input.LA(1);
                        if (!(_la == T_DEFAULT || _la == T_MUL || _la == L_ID)) {
                            ((DbDotTableContext) _localctx).db = (Token) _errHandler.recoverInline(
                                this
                            );
                        } else {
                            if (_input.LA(1) == Token.EOF) matchedEOF = true;
                            _errHandler.reportMatch(this);
                            consume();
                        }
                        setState(274);
                        match(T_DOT);
                    }
                        break;
                }
                setState(277);
                ((DbDotTableContext) _localctx).table = _input.LT(1);
                _la = _input.LA(1);
                if (!(_la == T_DEFAULT || _la == T_MUL || _la == L_ID)) {
                    ((DbDotTableContext) _localctx).table = (Token) _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class UserDotDbDotTableContext extends ParserRuleContext {
        public Token user;

        public DbDotTableContext dbDotTable() {
            return getRuleContext(DbDotTableContext.class, 0);
        }

        public TerminalNode T_DOT() {
            return getToken(StartDBSqlParser.T_DOT, 0);
        }

        public TerminalNode L_ID() {
            return getToken(StartDBSqlParser.L_ID, 0);
        }

        public UserDotDbDotTableContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_userDotDbDotTable;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitUserDotDbDotTable(this);
            else return visitor.visitChildren(this);
        }
    }

    public final UserDotDbDotTableContext userDotDbDotTable() throws RecognitionException {
        UserDotDbDotTableContext _localctx = new UserDotDbDotTableContext(_ctx, getState());
        enterRule(_localctx, 6, RULE_userDotDbDotTable);
        try {
            setState(285);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 4, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1); {
                    setState(279);
                    dbDotTable();
                }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2); {
                    setState(282);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 3, _ctx)) {
                        case 1: {
                            setState(280);
                            ((UserDotDbDotTableContext) _localctx).user = match(L_ID);
                            setState(281);
                            match(T_DOT);
                        }
                            break;
                    }
                    setState(284);
                    dbDotTable();
                }
                    break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class AssignmentStmtItemContext extends ParserRuleContext {
        public AssignmentStmtSingleItemContext assignmentStmtSingleItem() {
            return getRuleContext(AssignmentStmtSingleItemContext.class, 0);
        }

        public AssignmentStmtMultipleItemContext assignmentStmtMultipleItem() {
            return getRuleContext(AssignmentStmtMultipleItemContext.class, 0);
        }

        public AssignmentStmtSelectItemContext assignmentStmtSelectItem() {
            return getRuleContext(AssignmentStmtSelectItemContext.class, 0);
        }

        public AssignmentStmtItemContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_assignmentStmtItem;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitAssignmentStmtItem(this);
            else return visitor.visitChildren(this);
        }
    }

    public final AssignmentStmtItemContext assignmentStmtItem() throws RecognitionException {
        AssignmentStmtItemContext _localctx = new AssignmentStmtItemContext(_ctx, getState());
        enterRule(_localctx, 8, RULE_assignmentStmtItem);
        try {
            setState(290);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 5, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1); {
                    setState(287);
                    assignmentStmtSingleItem();
                }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2); {
                    setState(288);
                    assignmentStmtMultipleItem();
                }
                    break;
                case 3:
                    enterOuterAlt(_localctx, 3); {
                    setState(289);
                    assignmentStmtSelectItem();
                }
                    break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class AssignmentStmtSingleItemContext extends ParserRuleContext {
        public IdentContext ident() {
            return getRuleContext(IdentContext.class, 0);
        }

        public TerminalNode T_EQUAL() {
            return getToken(StartDBSqlParser.T_EQUAL, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode T_COLON() {
            return getToken(StartDBSqlParser.T_COLON, 0);
        }

        public TerminalNode T_OPEN_P() {
            return getToken(StartDBSqlParser.T_OPEN_P, 0);
        }

        public TerminalNode T_CLOSE_P() {
            return getToken(StartDBSqlParser.T_CLOSE_P, 0);
        }

        public AssignmentStmtSingleItemContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_assignmentStmtSingleItem;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitAssignmentStmtSingleItem(this);
            else return visitor.visitChildren(this);
        }
    }

    public final AssignmentStmtSingleItemContext assignmentStmtSingleItem()
        throws RecognitionException {
        AssignmentStmtSingleItemContext _localctx = new AssignmentStmtSingleItemContext(
            _ctx,
            getState()
        );
        enterRule(_localctx, 10, RULE_assignmentStmtSingleItem);
        int _la;
        try {
            setState(308);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T_ACTION:
                case T_ADD2:
                case T_ALL:
                case T_ALLOCATE:
                case T_ALTER:
                case T_AND:
                case T_ANSI_NULLS:
                case T_ANSI_PADDING:
                case T_AS:
                case T_ASC:
                case T_ASSOCIATE:
                case T_AT:
                case T_AVG:
                case T_BATCHSIZE:
                case T_BEGIN:
                case T_BETWEEN:
                case T_BIGINT:
                case T_BINARY_DOUBLE:
                case T_BINARY_FLOAT:
                case T_BIT:
                case T_BODY:
                case T_BREAK:
                case T_BY:
                case T_BYTE:
                case T_CALL:
                case T_CALLER:
                case T_CASCADE:
                case T_CASE:
                case T_CASESPECIFIC:
                case T_CAST:
                case T_CHAR:
                case T_CHARACTER:
                case T_CHARSET:
                case T_CLIENT:
                case T_CLOSE:
                case T_CLUSTERED:
                case T_CMP:
                case T_COLLECT:
                case T_COLLECTION:
                case T_COLUMN:
                case T_COMMENT:
                case T_CONSTANT:
                case T_COMMIT:
                case T_COMPRESS:
                case T_CONCAT:
                case T_CONDITION:
                case T_CONSTRAINT:
                case T_CONTINUE:
                case T_COPY:
                case T_COUNT:
                case T_COUNT_BIG:
                case T_CREATION:
                case T_CREATOR:
                case T_CS:
                case T_CURRENT:
                case T_CURRENT_SCHEMA:
                case T_CURSOR:
                case T_DATABASE:
                case T_DATA:
                case T_DATE:
                case T_DATETIME:
                case T_DAY:
                case T_DAYS:
                case T_DEC:
                case T_DECIMAL:
                case T_DECLARE:
                case T_DEFAULT:
                case T_DEFERRED:
                case T_DEFINED:
                case T_DEFINER:
                case T_DEFINITION:
                case T_DELETE:
                case T_DELIMITED:
                case T_DELIMITER:
                case T_DESC:
                case T_DESCRIBE:
                case T_DIAGNOSTICS:
                case T_DIR:
                case T_DIRECTORY:
                case T_DISTINCT:
                case T_DISTRIBUTE:
                case T_DO:
                case T_DOUBLE:
                case T_DOWNLOAD:
                case T_DROP:
                case T_DYNAMIC:
                case T_ENABLE:
                case T_ENGINE:
                case T_ESCAPED:
                case T_EXCEPT:
                case T_EXEC:
                case T_EXECUTE:
                case T_EXCEPTION:
                case T_EXCLUSIVE:
                case T_EXISTS:
                case T_EXIT:
                case T_FALLBACK:
                case T_FALSE:
                case T_FETCH:
                case T_FIELDS:
                case T_FILE:
                case T_FILES:
                case T_FLOAT:
                case T_FOR:
                case T_FOREIGN:
                case T_FORMAT:
                case T_FOUND:
                case T_FROM:
                case T_FULL:
                case T_FUNCTION:
                case T_GET:
                case T_GLOBAL:
                case T_GO:
                case T_GRANT:
                case T_GROUP:
                case T_HANDLER:
                case T_HASH:
                case T_HAVING:
                case T_HOST:
                case T_IDENTITY:
                case T_IF:
                case T_IGNORE:
                case T_IMMEDIATE:
                case T_IN:
                case T_INCLUDE:
                case T_INDEX:
                case T_INITRANS:
                case T_INNER:
                case T_INOUT:
                case T_INSERT:
                case T_INT:
                case T_INT2:
                case T_INT4:
                case T_INT8:
                case T_INTEGER:
                case T_INTERSECT:
                case T_INTERVAL:
                case T_INTO:
                case T_INVOKER:
                case T_IS:
                case T_ISOPEN:
                case T_ITEMS:
                case T_JOIN:
                case T_KEEP:
                case T_KEY:
                case T_KEYS:
                case T_LANGUAGE:
                case T_LEAVE:
                case T_LEFT:
                case T_LIKE:
                case T_LIMIT:
                case T_LINES:
                case T_LOCAL:
                case T_LOCATION:
                case T_LOCATOR:
                case T_LOCATORS:
                case T_LOCKS:
                case T_LOG:
                case T_LOGGED:
                case T_LOGGING:
                case T_LOOP:
                case T_MAP:
                case T_MATCHED:
                case T_MAX:
                case T_MAXTRANS:
                case T_MERGE:
                case T_MESSAGE_TEXT:
                case T_MICROSECOND:
                case T_MICROSECONDS:
                case T_MIN:
                case T_MULTISET:
                case T_NCHAR:
                case T_NEW:
                case T_NVARCHAR:
                case T_NO:
                case T_NOCOUNT:
                case T_NOCOMPRESS:
                case T_NOLOGGING:
                case T_NONE:
                case T_NOT:
                case T_NOTFOUND:
                case T_NUMERIC:
                case T_NUMBER:
                case T_OBJECT:
                case T_OFF:
                case T_ON:
                case T_ONLY:
                case T_OPEN:
                case T_OR:
                case T_ORDER:
                case T_OUT:
                case T_OUTER:
                case T_OVER:
                case T_OVERWRITE:
                case T_OWNER:
                case T_PACKAGE:
                case T_PARTITION:
                case T_PCTFREE:
                case T_PCTUSED:
                case T_PRECISION:
                case T_PRESERVE:
                case T_PRIMARY:
                case T_PRINT:
                case T_PROC:
                case T_PROCEDURE:
                case T_QUALIFY:
                case T_QUERY_BAND:
                case T_QUIT:
                case T_QUOTED_IDENTIFIER:
                case T_RAISE:
                case T_REAL:
                case T_REFERENCES:
                case T_REGEXP:
                case T_REPLACE:
                case T_RESIGNAL:
                case T_RESTRICT:
                case T_RESULT:
                case T_RESULT_SET_LOCATOR:
                case T_RETURN:
                case T_RETURNS:
                case T_REVERSE:
                case T_RIGHT:
                case T_RLIKE:
                case T_ROLE:
                case T_ROLLBACK:
                case T_ROW:
                case T_ROWS:
                case T_ROW_COUNT:
                case T_RR:
                case T_RS:
                case T_PWD:
                case T_TRIM:
                case T_SCHEMA:
                case T_SECOND:
                case T_SECONDS:
                case T_SECURITY:
                case T_SEGMENT:
                case T_SEL:
                case T_SELECT:
                case T_SET:
                case T_SESSION:
                case T_SESSIONS:
                case T_SETS:
                case T_SIGNAL:
                case T_SIMPLE_DOUBLE:
                case T_SIMPLE_FLOAT:
                case T_SMALLDATETIME:
                case T_SMALLINT:
                case T_SQL:
                case T_SQLEXCEPTION:
                case T_SQLINSERT:
                case T_SQLSTATE:
                case T_SQLWARNING:
                case T_STATS:
                case T_STATISTICS:
                case T_STEP:
                case T_STORAGE:
                case T_STORE:
                case T_STORED:
                case T_STRING:
                case T_SUBDIR:
                case T_SUBSTRING:
                case T_SUM:
                case T_SUMMARY:
                case T_SYS_REFCURSOR:
                case T_TABLE:
                case T_TABLESPACE:
                case T_TEMPORARY:
                case T_TERMINATED:
                case T_TEXTIMAGE_ON:
                case T_THEN:
                case T_TIMESTAMP:
                case T_TITLE:
                case T_TO:
                case T_TOP:
                case T_TRANSACTION:
                case T_TRUE:
                case T_TRUNCATE:
                case T_UNIQUE:
                case T_UPDATE:
                case T_UR:
                case T_USE:
                case T_USING:
                case T_VALUE:
                case T_VALUES:
                case T_VAR:
                case T_VARCHAR:
                case T_VARCHAR2:
                case T_VARYING:
                case T_VOLATILE:
                case T_WHILE:
                case T_WITH:
                case T_WITHOUT:
                case T_WORK:
                case T_XACT_ABORT:
                case T_XML:
                case T_YES:
                case T_ACTIVITY_COUNT:
                case T_CUME_DIST:
                case T_CURRENT_DATE:
                case T_CURRENT_TIME:
                case T_PI:
                case T_CURRENT_TIMESTAMP:
                case T_CURRENT_USER:
                case T_DENSE_RANK:
                case T_FIRST_VALUE:
                case T_LAG:
                case T_LAST_VALUE:
                case T_LEAD:
                case T_PART_COUNT:
                case T_PART_LOC:
                case T_RANK:
                case T_ROW_NUMBER:
                case T_STDEV:
                case T_SYSDATE:
                case T_VARIANCE:
                case T_USER:
                case T_SUB:
                case L_ID:
                    enterOuterAlt(_localctx, 1); {
                    setState(292);
                    ident();
                    setState(294);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_COLON) {
                        {
                            setState(293);
                            match(T_COLON);
                        }
                    }

                    setState(296);
                    match(T_EQUAL);
                    setState(297);
                    expr(0);
                }
                    break;
                case T_OPEN_P:
                    enterOuterAlt(_localctx, 2); {
                    setState(299);
                    match(T_OPEN_P);
                    setState(300);
                    ident();
                    setState(301);
                    match(T_CLOSE_P);
                    setState(303);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_COLON) {
                        {
                            setState(302);
                            match(T_COLON);
                        }
                    }

                    setState(305);
                    match(T_EQUAL);
                    setState(306);
                    expr(0);
                }
                    break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class AssignmentStmtMultipleItemContext extends ParserRuleContext {
        public List<TerminalNode> T_OPEN_P() {
            return getTokens(StartDBSqlParser.T_OPEN_P);
        }

        public TerminalNode T_OPEN_P(int i) {
            return getToken(StartDBSqlParser.T_OPEN_P, i);
        }

        public List<IdentContext> ident() {
            return getRuleContexts(IdentContext.class);
        }

        public IdentContext ident(int i) {
            return getRuleContext(IdentContext.class, i);
        }

        public List<TerminalNode> T_CLOSE_P() {
            return getTokens(StartDBSqlParser.T_CLOSE_P);
        }

        public TerminalNode T_CLOSE_P(int i) {
            return getToken(StartDBSqlParser.T_CLOSE_P, i);
        }

        public TerminalNode T_EQUAL() {
            return getToken(StartDBSqlParser.T_EQUAL, 0);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public List<TerminalNode> T_COMMA() {
            return getTokens(StartDBSqlParser.T_COMMA);
        }

        public TerminalNode T_COMMA(int i) {
            return getToken(StartDBSqlParser.T_COMMA, i);
        }

        public TerminalNode T_COLON() {
            return getToken(StartDBSqlParser.T_COLON, 0);
        }

        public AssignmentStmtMultipleItemContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_assignmentStmtMultipleItem;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitAssignmentStmtMultipleItem(this);
            else return visitor.visitChildren(this);
        }
    }

    public final AssignmentStmtMultipleItemContext assignmentStmtMultipleItem()
        throws RecognitionException {
        AssignmentStmtMultipleItemContext _localctx = new AssignmentStmtMultipleItemContext(
            _ctx,
            getState()
        );
        enterRule(_localctx, 12, RULE_assignmentStmtMultipleItem);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(310);
                match(T_OPEN_P);
                setState(311);
                ident();
                setState(316);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T_COMMA) {
                    {
                        {
                            setState(312);
                            match(T_COMMA);
                            setState(313);
                            ident();
                        }
                    }
                    setState(318);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(319);
                match(T_CLOSE_P);
                setState(321);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_COLON) {
                    {
                        setState(320);
                        match(T_COLON);
                    }
                }

                setState(323);
                match(T_EQUAL);
                setState(324);
                match(T_OPEN_P);
                setState(325);
                expr(0);
                setState(330);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T_COMMA) {
                    {
                        {
                            setState(326);
                            match(T_COMMA);
                            setState(327);
                            expr(0);
                        }
                    }
                    setState(332);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(333);
                match(T_CLOSE_P);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class AssignmentStmtSelectItemContext extends ParserRuleContext {
        public TerminalNode T_EQUAL() {
            return getToken(StartDBSqlParser.T_EQUAL, 0);
        }

        public List<TerminalNode> T_OPEN_P() {
            return getTokens(StartDBSqlParser.T_OPEN_P);
        }

        public TerminalNode T_OPEN_P(int i) {
            return getToken(StartDBSqlParser.T_OPEN_P, i);
        }

        public SelectStmtContext selectStmt() {
            return getRuleContext(SelectStmtContext.class, 0);
        }

        public List<TerminalNode> T_CLOSE_P() {
            return getTokens(StartDBSqlParser.T_CLOSE_P);
        }

        public TerminalNode T_CLOSE_P(int i) {
            return getToken(StartDBSqlParser.T_CLOSE_P, i);
        }

        public List<IdentContext> ident() {
            return getRuleContexts(IdentContext.class);
        }

        public IdentContext ident(int i) {
            return getRuleContext(IdentContext.class, i);
        }

        public TerminalNode T_COLON() {
            return getToken(StartDBSqlParser.T_COLON, 0);
        }

        public List<TerminalNode> T_COMMA() {
            return getTokens(StartDBSqlParser.T_COMMA);
        }

        public TerminalNode T_COMMA(int i) {
            return getToken(StartDBSqlParser.T_COMMA, i);
        }

        public AssignmentStmtSelectItemContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_assignmentStmtSelectItem;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitAssignmentStmtSelectItem(this);
            else return visitor.visitChildren(this);
        }
    }

    public final AssignmentStmtSelectItemContext assignmentStmtSelectItem()
        throws RecognitionException {
        AssignmentStmtSelectItemContext _localctx = new AssignmentStmtSelectItemContext(
            _ctx,
            getState()
        );
        enterRule(_localctx, 14, RULE_assignmentStmtSelectItem);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(347);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case T_ACTION:
                    case T_ADD2:
                    case T_ALL:
                    case T_ALLOCATE:
                    case T_ALTER:
                    case T_AND:
                    case T_ANSI_NULLS:
                    case T_ANSI_PADDING:
                    case T_AS:
                    case T_ASC:
                    case T_ASSOCIATE:
                    case T_AT:
                    case T_AVG:
                    case T_BATCHSIZE:
                    case T_BEGIN:
                    case T_BETWEEN:
                    case T_BIGINT:
                    case T_BINARY_DOUBLE:
                    case T_BINARY_FLOAT:
                    case T_BIT:
                    case T_BODY:
                    case T_BREAK:
                    case T_BY:
                    case T_BYTE:
                    case T_CALL:
                    case T_CALLER:
                    case T_CASCADE:
                    case T_CASE:
                    case T_CASESPECIFIC:
                    case T_CAST:
                    case T_CHAR:
                    case T_CHARACTER:
                    case T_CHARSET:
                    case T_CLIENT:
                    case T_CLOSE:
                    case T_CLUSTERED:
                    case T_CMP:
                    case T_COLLECT:
                    case T_COLLECTION:
                    case T_COLUMN:
                    case T_COMMENT:
                    case T_CONSTANT:
                    case T_COMMIT:
                    case T_COMPRESS:
                    case T_CONCAT:
                    case T_CONDITION:
                    case T_CONSTRAINT:
                    case T_CONTINUE:
                    case T_COPY:
                    case T_COUNT:
                    case T_COUNT_BIG:
                    case T_CREATION:
                    case T_CREATOR:
                    case T_CS:
                    case T_CURRENT:
                    case T_CURRENT_SCHEMA:
                    case T_CURSOR:
                    case T_DATABASE:
                    case T_DATA:
                    case T_DATE:
                    case T_DATETIME:
                    case T_DAY:
                    case T_DAYS:
                    case T_DEC:
                    case T_DECIMAL:
                    case T_DECLARE:
                    case T_DEFAULT:
                    case T_DEFERRED:
                    case T_DEFINED:
                    case T_DEFINER:
                    case T_DEFINITION:
                    case T_DELETE:
                    case T_DELIMITED:
                    case T_DELIMITER:
                    case T_DESC:
                    case T_DESCRIBE:
                    case T_DIAGNOSTICS:
                    case T_DIR:
                    case T_DIRECTORY:
                    case T_DISTINCT:
                    case T_DISTRIBUTE:
                    case T_DO:
                    case T_DOUBLE:
                    case T_DOWNLOAD:
                    case T_DROP:
                    case T_DYNAMIC:
                    case T_ENABLE:
                    case T_ENGINE:
                    case T_ESCAPED:
                    case T_EXCEPT:
                    case T_EXEC:
                    case T_EXECUTE:
                    case T_EXCEPTION:
                    case T_EXCLUSIVE:
                    case T_EXISTS:
                    case T_EXIT:
                    case T_FALLBACK:
                    case T_FALSE:
                    case T_FETCH:
                    case T_FIELDS:
                    case T_FILE:
                    case T_FILES:
                    case T_FLOAT:
                    case T_FOR:
                    case T_FOREIGN:
                    case T_FORMAT:
                    case T_FOUND:
                    case T_FROM:
                    case T_FULL:
                    case T_FUNCTION:
                    case T_GET:
                    case T_GLOBAL:
                    case T_GO:
                    case T_GRANT:
                    case T_GROUP:
                    case T_HANDLER:
                    case T_HASH:
                    case T_HAVING:
                    case T_HOST:
                    case T_IDENTITY:
                    case T_IF:
                    case T_IGNORE:
                    case T_IMMEDIATE:
                    case T_IN:
                    case T_INCLUDE:
                    case T_INDEX:
                    case T_INITRANS:
                    case T_INNER:
                    case T_INOUT:
                    case T_INSERT:
                    case T_INT:
                    case T_INT2:
                    case T_INT4:
                    case T_INT8:
                    case T_INTEGER:
                    case T_INTERSECT:
                    case T_INTERVAL:
                    case T_INTO:
                    case T_INVOKER:
                    case T_IS:
                    case T_ISOPEN:
                    case T_ITEMS:
                    case T_JOIN:
                    case T_KEEP:
                    case T_KEY:
                    case T_KEYS:
                    case T_LANGUAGE:
                    case T_LEAVE:
                    case T_LEFT:
                    case T_LIKE:
                    case T_LIMIT:
                    case T_LINES:
                    case T_LOCAL:
                    case T_LOCATION:
                    case T_LOCATOR:
                    case T_LOCATORS:
                    case T_LOCKS:
                    case T_LOG:
                    case T_LOGGED:
                    case T_LOGGING:
                    case T_LOOP:
                    case T_MAP:
                    case T_MATCHED:
                    case T_MAX:
                    case T_MAXTRANS:
                    case T_MERGE:
                    case T_MESSAGE_TEXT:
                    case T_MICROSECOND:
                    case T_MICROSECONDS:
                    case T_MIN:
                    case T_MULTISET:
                    case T_NCHAR:
                    case T_NEW:
                    case T_NVARCHAR:
                    case T_NO:
                    case T_NOCOUNT:
                    case T_NOCOMPRESS:
                    case T_NOLOGGING:
                    case T_NONE:
                    case T_NOT:
                    case T_NOTFOUND:
                    case T_NUMERIC:
                    case T_NUMBER:
                    case T_OBJECT:
                    case T_OFF:
                    case T_ON:
                    case T_ONLY:
                    case T_OPEN:
                    case T_OR:
                    case T_ORDER:
                    case T_OUT:
                    case T_OUTER:
                    case T_OVER:
                    case T_OVERWRITE:
                    case T_OWNER:
                    case T_PACKAGE:
                    case T_PARTITION:
                    case T_PCTFREE:
                    case T_PCTUSED:
                    case T_PRECISION:
                    case T_PRESERVE:
                    case T_PRIMARY:
                    case T_PRINT:
                    case T_PROC:
                    case T_PROCEDURE:
                    case T_QUALIFY:
                    case T_QUERY_BAND:
                    case T_QUIT:
                    case T_QUOTED_IDENTIFIER:
                    case T_RAISE:
                    case T_REAL:
                    case T_REFERENCES:
                    case T_REGEXP:
                    case T_REPLACE:
                    case T_RESIGNAL:
                    case T_RESTRICT:
                    case T_RESULT:
                    case T_RESULT_SET_LOCATOR:
                    case T_RETURN:
                    case T_RETURNS:
                    case T_REVERSE:
                    case T_RIGHT:
                    case T_RLIKE:
                    case T_ROLE:
                    case T_ROLLBACK:
                    case T_ROW:
                    case T_ROWS:
                    case T_ROW_COUNT:
                    case T_RR:
                    case T_RS:
                    case T_PWD:
                    case T_TRIM:
                    case T_SCHEMA:
                    case T_SECOND:
                    case T_SECONDS:
                    case T_SECURITY:
                    case T_SEGMENT:
                    case T_SEL:
                    case T_SELECT:
                    case T_SET:
                    case T_SESSION:
                    case T_SESSIONS:
                    case T_SETS:
                    case T_SIGNAL:
                    case T_SIMPLE_DOUBLE:
                    case T_SIMPLE_FLOAT:
                    case T_SMALLDATETIME:
                    case T_SMALLINT:
                    case T_SQL:
                    case T_SQLEXCEPTION:
                    case T_SQLINSERT:
                    case T_SQLSTATE:
                    case T_SQLWARNING:
                    case T_STATS:
                    case T_STATISTICS:
                    case T_STEP:
                    case T_STORAGE:
                    case T_STORE:
                    case T_STORED:
                    case T_STRING:
                    case T_SUBDIR:
                    case T_SUBSTRING:
                    case T_SUM:
                    case T_SUMMARY:
                    case T_SYS_REFCURSOR:
                    case T_TABLE:
                    case T_TABLESPACE:
                    case T_TEMPORARY:
                    case T_TERMINATED:
                    case T_TEXTIMAGE_ON:
                    case T_THEN:
                    case T_TIMESTAMP:
                    case T_TITLE:
                    case T_TO:
                    case T_TOP:
                    case T_TRANSACTION:
                    case T_TRUE:
                    case T_TRUNCATE:
                    case T_UNIQUE:
                    case T_UPDATE:
                    case T_UR:
                    case T_USE:
                    case T_USING:
                    case T_VALUE:
                    case T_VALUES:
                    case T_VAR:
                    case T_VARCHAR:
                    case T_VARCHAR2:
                    case T_VARYING:
                    case T_VOLATILE:
                    case T_WHILE:
                    case T_WITH:
                    case T_WITHOUT:
                    case T_WORK:
                    case T_XACT_ABORT:
                    case T_XML:
                    case T_YES:
                    case T_ACTIVITY_COUNT:
                    case T_CUME_DIST:
                    case T_CURRENT_DATE:
                    case T_CURRENT_TIME:
                    case T_PI:
                    case T_CURRENT_TIMESTAMP:
                    case T_CURRENT_USER:
                    case T_DENSE_RANK:
                    case T_FIRST_VALUE:
                    case T_LAG:
                    case T_LAST_VALUE:
                    case T_LEAD:
                    case T_PART_COUNT:
                    case T_PART_LOC:
                    case T_RANK:
                    case T_ROW_NUMBER:
                    case T_STDEV:
                    case T_SYSDATE:
                    case T_VARIANCE:
                    case T_USER:
                    case T_SUB:
                    case L_ID: {
                        setState(335);
                        ident();
                    }
                        break;
                    case T_OPEN_P: {
                        {
                            setState(336);
                            match(T_OPEN_P);
                            setState(337);
                            ident();
                            setState(342);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                            while (_la == T_COMMA) {
                                {
                                    {
                                        setState(338);
                                        match(T_COMMA);
                                        setState(339);
                                        ident();
                                    }
                                }
                                setState(344);
                                _errHandler.sync(this);
                                _la = _input.LA(1);
                            }
                            setState(345);
                            match(T_CLOSE_P);
                        }
                    }
                        break;
                    default:
                        throw new NoViableAltException(this);
                }
                setState(350);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_COLON) {
                    {
                        setState(349);
                        match(T_COLON);
                    }
                }

                setState(352);
                match(T_EQUAL);
                setState(353);
                match(T_OPEN_P);
                setState(354);
                selectStmt();
                setState(355);
                match(T_CLOSE_P);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ShowCreateTableStmtContext extends ParserRuleContext {
        public IdentContext relation;

        public TerminalNode T_SHOW() {
            return getToken(StartDBSqlParser.T_SHOW, 0);
        }

        public TerminalNode T_CREATE() {
            return getToken(StartDBSqlParser.T_CREATE, 0);
        }

        public TerminalNode T_TABLE() {
            return getToken(StartDBSqlParser.T_TABLE, 0);
        }

        public IdentContext ident() {
            return getRuleContext(IdentContext.class, 0);
        }

        public ShowCreateTableStmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_showCreateTableStmt;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitShowCreateTableStmt(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ShowCreateTableStmtContext showCreateTableStmt() throws RecognitionException {
        ShowCreateTableStmtContext _localctx = new ShowCreateTableStmtContext(_ctx, getState());
        enterRule(_localctx, 16, RULE_showCreateTableStmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(357);
                match(T_SHOW);
                setState(358);
                match(T_CREATE);
                setState(359);
                match(T_TABLE);
                setState(360);
                ((ShowCreateTableStmtContext) _localctx).relation = ident();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ShowStatusStmtContext extends ParserRuleContext {
        public TerminalNode T_SHOW() {
            return getToken(StartDBSqlParser.T_SHOW, 0);
        }

        public TerminalNode T_STATUS() {
            return getToken(StartDBSqlParser.T_STATUS, 0);
        }

        public ShowStatusStmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_showStatusStmt;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitShowStatusStmt(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ShowStatusStmtContext showStatusStmt() throws RecognitionException {
        ShowStatusStmtContext _localctx = new ShowStatusStmtContext(_ctx, getState());
        enterRule(_localctx, 18, RULE_showStatusStmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(362);
                match(T_SHOW);
                setState(363);
                match(T_STATUS);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class CreateTableStmtContext extends ParserRuleContext {
        public TerminalNode T_CREATE() {
            return getToken(StartDBSqlParser.T_CREATE, 0);
        }

        public TerminalNode T_TABLE() {
            return getToken(StartDBSqlParser.T_TABLE, 0);
        }

        public Table_nameContext table_name() {
            return getRuleContext(Table_nameContext.class, 0);
        }

        public Create_table_definitionContext create_table_definition() {
            return getRuleContext(Create_table_definitionContext.class, 0);
        }

        public TerminalNode T_IF() {
            return getToken(StartDBSqlParser.T_IF, 0);
        }

        public TerminalNode T_NOT() {
            return getToken(StartDBSqlParser.T_NOT, 0);
        }

        public TerminalNode T_EXISTS() {
            return getToken(StartDBSqlParser.T_EXISTS, 0);
        }

        public Create_table_preoptionsContext create_table_preoptions() {
            return getRuleContext(Create_table_preoptionsContext.class, 0);
        }

        public CreateTableStmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_createTableStmt;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitCreateTableStmt(this);
            else return visitor.visitChildren(this);
        }
    }

    public final CreateTableStmtContext createTableStmt() throws RecognitionException {
        CreateTableStmtContext _localctx = new CreateTableStmtContext(_ctx, getState());
        enterRule(_localctx, 20, RULE_createTableStmt);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(365);
                match(T_CREATE);
                setState(366);
                match(T_TABLE);
                setState(370);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 15, _ctx)) {
                    case 1: {
                        setState(367);
                        match(T_IF);
                        setState(368);
                        match(T_NOT);
                        setState(369);
                        match(T_EXISTS);
                    }
                        break;
                }
                setState(372);
                table_name();
                setState(374);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_COMMA) {
                    {
                        setState(373);
                        create_table_preoptions();
                    }
                }

                setState(376);
                create_table_definition();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class CreateUserStmtContext extends ParserRuleContext {
        public StringContext password;

        public TerminalNode T_CREATE() {
            return getToken(StartDBSqlParser.T_CREATE, 0);
        }

        public TerminalNode T_USER() {
            return getToken(StartDBSqlParser.T_USER, 0);
        }

        public User_nameContext user_name() {
            return getRuleContext(User_nameContext.class, 0);
        }

        public TerminalNode T_IDENTIFIED() {
            return getToken(StartDBSqlParser.T_IDENTIFIED, 0);
        }

        public TerminalNode T_BY() {
            return getToken(StartDBSqlParser.T_BY, 0);
        }

        public StringContext string() {
            return getRuleContext(StringContext.class, 0);
        }

        public CreateUserStmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_createUserStmt;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitCreateUserStmt(this);
            else return visitor.visitChildren(this);
        }
    }

    public final CreateUserStmtContext createUserStmt() throws RecognitionException {
        CreateUserStmtContext _localctx = new CreateUserStmtContext(_ctx, getState());
        enterRule(_localctx, 22, RULE_createUserStmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(378);
                match(T_CREATE);
                setState(379);
                match(T_USER);
                setState(380);
                user_name();
                setState(381);
                match(T_IDENTIFIED);
                setState(382);
                match(T_BY);
                setState(383);
                ((CreateUserStmtContext) _localctx).password = string();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class Create_table_definitionContext extends ParserRuleContext {
        public TerminalNode T_OPEN_P() {
            return getToken(StartDBSqlParser.T_OPEN_P, 0);
        }

        public SelectStmtContext selectStmt() {
            return getRuleContext(SelectStmtContext.class, 0);
        }

        public TerminalNode T_CLOSE_P() {
            return getToken(StartDBSqlParser.T_CLOSE_P, 0);
        }

        public Create_table_columnsContext create_table_columns() {
            return getRuleContext(Create_table_columnsContext.class, 0);
        }

        public TerminalNode T_LIKE() {
            return getToken(StartDBSqlParser.T_LIKE, 0);
        }

        public Table_nameContext table_name() {
            return getRuleContext(Table_nameContext.class, 0);
        }

        public Create_table_optionsContext create_table_options() {
            return getRuleContext(Create_table_optionsContext.class, 0);
        }

        public TerminalNode T_AS() {
            return getToken(StartDBSqlParser.T_AS, 0);
        }

        public Create_table_definitionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_create_table_definition;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitCreate_table_definition(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Create_table_definitionContext create_table_definition()
        throws RecognitionException {
        Create_table_definitionContext _localctx = new Create_table_definitionContext(
            _ctx,
            getState()
        );
        enterRule(_localctx, 24, RULE_create_table_definition);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(402);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 19, _ctx)) {
                    case 1: {
                        setState(386);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        if (_la == T_AS) {
                            {
                                setState(385);
                                match(T_AS);
                            }
                        }

                        setState(388);
                        match(T_OPEN_P);
                        setState(389);
                        selectStmt();
                        setState(390);
                        match(T_CLOSE_P);
                    }
                        break;
                    case 2: {
                        setState(393);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        if (_la == T_AS) {
                            {
                                setState(392);
                                match(T_AS);
                            }
                        }

                        setState(395);
                        selectStmt();
                    }
                        break;
                    case 3: {
                        setState(396);
                        match(T_OPEN_P);
                        setState(397);
                        create_table_columns();
                        setState(398);
                        match(T_CLOSE_P);
                    }
                        break;
                    case 4: {
                        setState(400);
                        match(T_LIKE);
                        setState(401);
                        table_name();
                    }
                        break;
                }
                setState(405);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if ((((_la) & ~0x3f) == 0
                    && ((1L << _la) & ((1L << T_AUTO_INCREMENT) | (1L << T_CHARACTER) | (1L
                        << T_CHARSET) | (1L << T_COMMENT))) != 0)
                    || _la == T_DEFAULT
                    || _la == T_ENGINE
                    || _la == T_ON) {
                    {
                        setState(404);
                        create_table_options();
                    }
                }

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class Create_table_columnsContext extends ParserRuleContext {
        public List<Create_table_columns_itemContext> create_table_columns_item() {
            return getRuleContexts(Create_table_columns_itemContext.class);
        }

        public Create_table_columns_itemContext create_table_columns_item(int i) {
            return getRuleContext(Create_table_columns_itemContext.class, i);
        }

        public List<TerminalNode> T_COMMA() {
            return getTokens(StartDBSqlParser.T_COMMA);
        }

        public TerminalNode T_COMMA(int i) {
            return getToken(StartDBSqlParser.T_COMMA, i);
        }

        public Create_table_columnsContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_create_table_columns;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitCreate_table_columns(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Create_table_columnsContext create_table_columns() throws RecognitionException {
        Create_table_columnsContext _localctx = new Create_table_columnsContext(_ctx, getState());
        enterRule(_localctx, 26, RULE_create_table_columns);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(407);
                create_table_columns_item();
                setState(412);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T_COMMA) {
                    {
                        {
                            setState(408);
                            match(T_COMMA);
                            setState(409);
                            create_table_columns_item();
                        }
                    }
                    setState(414);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class Create_table_columns_itemContext extends ParserRuleContext {
        public Column_nameContext column_name() {
            return getRuleContext(Column_nameContext.class, 0);
        }

        public DtypeContext dtype() {
            return getRuleContext(DtypeContext.class, 0);
        }

        public List<Dtype_attrContext> dtype_attr() {
            return getRuleContexts(Dtype_attrContext.class);
        }

        public Dtype_attrContext dtype_attr(int i) {
            return getRuleContext(Dtype_attrContext.class, i);
        }

        public List<Create_table_column_inline_consContext> create_table_column_inline_cons() {
            return getRuleContexts(Create_table_column_inline_consContext.class);
        }

        public Create_table_column_inline_consContext create_table_column_inline_cons(int i) {
            return getRuleContext(Create_table_column_inline_consContext.class, i);
        }

        public Create_table_column_consContext create_table_column_cons() {
            return getRuleContext(Create_table_column_consContext.class, 0);
        }

        public TerminalNode T_CONSTRAINT() {
            return getToken(StartDBSqlParser.T_CONSTRAINT, 0);
        }

        public QidentContext qident() {
            return getRuleContext(QidentContext.class, 0);
        }

        public Create_table_columns_itemContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_create_table_columns_item;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitCreate_table_columns_item(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Create_table_columns_itemContext create_table_columns_item()
        throws RecognitionException {
        Create_table_columns_itemContext _localctx = new Create_table_columns_itemContext(
            _ctx,
            getState()
        );
        enterRule(_localctx, 28, RULE_create_table_columns_item);
        int _la;
        try {
            int _alt;
            setState(434);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 25, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1); {
                    setState(415);
                    column_name();
                    setState(416);
                    dtype();
                    setState(420);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 22, _ctx);
                    while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                        if (_alt == 1) {
                            {
                                {
                                    setState(417);
                                    dtype_attr();
                                }
                            }
                        }
                        setState(422);
                        _errHandler.sync(this);
                        _alt = getInterpreter().adaptivePredict(_input, 22, _ctx);
                    }
                    setState(426);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == T_AUTO_INCREMENT
                        || ((((_la - 75)) & ~0x3f) == 0
                            && ((1L << (_la - 75)) & ((1L << (T_DEFAULT - 75)) | (1L << (T_ENABLE
                                - 75)) | (1L << (T_IDENTITY - 75)))) != 0)
                        || ((((_la - 198)) & ~0x3f) == 0
                            && ((1L << (_la - 198)) & ((1L << (T_NOT - 198)) | (1L << (T_NULL
                                - 198)) | (1L << (T_PRIMARY - 198)) | (1L << (T_REFERENCES
                                    - 198)))) != 0)
                        || _la == T_UNIQUE
                        || _la == T_WITH
                        || _la == T_COLON
                        || _la == T_EQUAL) {
                        {
                            {
                                setState(423);
                                create_table_column_inline_cons();
                            }
                        }
                        setState(428);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2); {
                    setState(431);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_CONSTRAINT) {
                        {
                            setState(429);
                            match(T_CONSTRAINT);
                            setState(430);
                            qident();
                        }
                    }

                    setState(433);
                    create_table_column_cons();
                }
                    break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class Column_nameContext extends ParserRuleContext {
        public QidentContext qident() {
            return getRuleContext(QidentContext.class, 0);
        }

        public Column_nameContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_column_name;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitColumn_name(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Column_nameContext column_name() throws RecognitionException {
        Column_nameContext _localctx = new Column_nameContext(_ctx, getState());
        enterRule(_localctx, 30, RULE_column_name);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(436);
                qident();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class Create_table_column_inline_consContext extends ParserRuleContext {
        public Dtype_defaultContext dtype_default() {
            return getRuleContext(Dtype_defaultContext.class, 0);
        }

        public TerminalNode T_NULL() {
            return getToken(StartDBSqlParser.T_NULL, 0);
        }

        public TerminalNode T_NOT() {
            return getToken(StartDBSqlParser.T_NOT, 0);
        }

        public TerminalNode T_PRIMARY() {
            return getToken(StartDBSqlParser.T_PRIMARY, 0);
        }

        public TerminalNode T_KEY() {
            return getToken(StartDBSqlParser.T_KEY, 0);
        }

        public TerminalNode T_UNIQUE() {
            return getToken(StartDBSqlParser.T_UNIQUE, 0);
        }

        public TerminalNode T_REFERENCES() {
            return getToken(StartDBSqlParser.T_REFERENCES, 0);
        }

        public Table_nameContext table_name() {
            return getRuleContext(Table_nameContext.class, 0);
        }

        public TerminalNode T_OPEN_P() {
            return getToken(StartDBSqlParser.T_OPEN_P, 0);
        }

        public QidentContext qident() {
            return getRuleContext(QidentContext.class, 0);
        }

        public TerminalNode T_CLOSE_P() {
            return getToken(StartDBSqlParser.T_CLOSE_P, 0);
        }

        public List<Create_table_fk_actionContext> create_table_fk_action() {
            return getRuleContexts(Create_table_fk_actionContext.class);
        }

        public Create_table_fk_actionContext create_table_fk_action(int i) {
            return getRuleContext(Create_table_fk_actionContext.class, i);
        }

        public TerminalNode T_IDENTITY() {
            return getToken(StartDBSqlParser.T_IDENTITY, 0);
        }

        public List<TerminalNode> L_INT() {
            return getTokens(StartDBSqlParser.L_INT);
        }

        public TerminalNode L_INT(int i) {
            return getToken(StartDBSqlParser.L_INT, i);
        }

        public List<TerminalNode> T_COMMA() {
            return getTokens(StartDBSqlParser.T_COMMA);
        }

        public TerminalNode T_COMMA(int i) {
            return getToken(StartDBSqlParser.T_COMMA, i);
        }

        public TerminalNode T_AUTO_INCREMENT() {
            return getToken(StartDBSqlParser.T_AUTO_INCREMENT, 0);
        }

        public TerminalNode T_ENABLE() {
            return getToken(StartDBSqlParser.T_ENABLE, 0);
        }

        public Create_table_column_inline_consContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_create_table_column_inline_cons;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitCreate_table_column_inline_cons(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Create_table_column_inline_consContext create_table_column_inline_cons()
        throws RecognitionException {
        Create_table_column_inline_consContext _localctx =
            new Create_table_column_inline_consContext(_ctx, getState());
        enterRule(_localctx, 32, RULE_create_table_column_inline_cons);
        int _la;
        try {
            setState(470);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T_DEFAULT:
                case T_WITH:
                case T_COLON:
                case T_EQUAL:
                    enterOuterAlt(_localctx, 1); {
                    setState(438);
                    dtype_default();
                }
                    break;
                case T_NOT:
                case T_NULL:
                    enterOuterAlt(_localctx, 2); {
                    setState(440);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_NOT) {
                        {
                            setState(439);
                            match(T_NOT);
                        }
                    }

                    setState(442);
                    match(T_NULL);
                }
                    break;
                case T_PRIMARY:
                    enterOuterAlt(_localctx, 3); {
                    setState(443);
                    match(T_PRIMARY);
                    setState(444);
                    match(T_KEY);
                }
                    break;
                case T_UNIQUE:
                    enterOuterAlt(_localctx, 4); {
                    setState(445);
                    match(T_UNIQUE);
                }
                    break;
                case T_REFERENCES:
                    enterOuterAlt(_localctx, 5); {
                    setState(446);
                    match(T_REFERENCES);
                    setState(447);
                    table_name();
                    setState(448);
                    match(T_OPEN_P);
                    setState(449);
                    qident();
                    setState(450);
                    match(T_CLOSE_P);
                    setState(454);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == T_ON) {
                        {
                            {
                                setState(451);
                                create_table_fk_action();
                            }
                        }
                        setState(456);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                }
                    break;
                case T_IDENTITY:
                    enterOuterAlt(_localctx, 6); {
                    setState(457);
                    match(T_IDENTITY);
                    setState(458);
                    match(T_OPEN_P);
                    setState(459);
                    match(L_INT);
                    setState(464);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == T_COMMA) {
                        {
                            {
                                setState(460);
                                match(T_COMMA);
                                setState(461);
                                match(L_INT);
                            }
                        }
                        setState(466);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                    setState(467);
                    match(T_CLOSE_P);
                }
                    break;
                case T_AUTO_INCREMENT:
                    enterOuterAlt(_localctx, 7); {
                    setState(468);
                    match(T_AUTO_INCREMENT);
                }
                    break;
                case T_ENABLE:
                    enterOuterAlt(_localctx, 8); {
                    setState(469);
                    match(T_ENABLE);
                }
                    break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class Create_table_column_consContext extends ParserRuleContext {
        public TerminalNode T_PRIMARY() {
            return getToken(StartDBSqlParser.T_PRIMARY, 0);
        }

        public TerminalNode T_KEY() {
            return getToken(StartDBSqlParser.T_KEY, 0);
        }

        public List<TerminalNode> T_OPEN_P() {
            return getTokens(StartDBSqlParser.T_OPEN_P);
        }

        public TerminalNode T_OPEN_P(int i) {
            return getToken(StartDBSqlParser.T_OPEN_P, i);
        }

        public List<QidentContext> qident() {
            return getRuleContexts(QidentContext.class);
        }

        public QidentContext qident(int i) {
            return getRuleContext(QidentContext.class, i);
        }

        public List<TerminalNode> T_CLOSE_P() {
            return getTokens(StartDBSqlParser.T_CLOSE_P);
        }

        public TerminalNode T_CLOSE_P(int i) {
            return getToken(StartDBSqlParser.T_CLOSE_P, i);
        }

        public TerminalNode T_CLUSTERED() {
            return getToken(StartDBSqlParser.T_CLUSTERED, 0);
        }

        public List<TerminalNode> T_COMMA() {
            return getTokens(StartDBSqlParser.T_COMMA);
        }

        public TerminalNode T_COMMA(int i) {
            return getToken(StartDBSqlParser.T_COMMA, i);
        }

        public TerminalNode T_ENABLE() {
            return getToken(StartDBSqlParser.T_ENABLE, 0);
        }

        public List<TerminalNode> T_ASC() {
            return getTokens(StartDBSqlParser.T_ASC);
        }

        public TerminalNode T_ASC(int i) {
            return getToken(StartDBSqlParser.T_ASC, i);
        }

        public List<TerminalNode> T_DESC() {
            return getTokens(StartDBSqlParser.T_DESC);
        }

        public TerminalNode T_DESC(int i) {
            return getToken(StartDBSqlParser.T_DESC, i);
        }

        public TerminalNode T_FOREIGN() {
            return getToken(StartDBSqlParser.T_FOREIGN, 0);
        }

        public TerminalNode T_REFERENCES() {
            return getToken(StartDBSqlParser.T_REFERENCES, 0);
        }

        public Table_nameContext table_name() {
            return getRuleContext(Table_nameContext.class, 0);
        }

        public List<Create_table_fk_actionContext> create_table_fk_action() {
            return getRuleContexts(Create_table_fk_actionContext.class);
        }

        public Create_table_fk_actionContext create_table_fk_action(int i) {
            return getRuleContext(Create_table_fk_actionContext.class, i);
        }

        public Create_table_column_consContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_create_table_column_cons;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitCreate_table_column_cons(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Create_table_column_consContext create_table_column_cons()
        throws RecognitionException {
        Create_table_column_consContext _localctx = new Create_table_column_consContext(
            _ctx,
            getState()
        );
        enterRule(_localctx, 34, RULE_create_table_column_cons);
        int _la;
        try {
            setState(526);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T_PRIMARY:
                    enterOuterAlt(_localctx, 1); {
                    setState(472);
                    match(T_PRIMARY);
                    setState(473);
                    match(T_KEY);
                    setState(475);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_CLUSTERED) {
                        {
                            setState(474);
                            match(T_CLUSTERED);
                        }
                    }

                    setState(477);
                    match(T_OPEN_P);
                    setState(478);
                    qident();
                    setState(480);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_ASC || _la == T_DESC) {
                        {
                            setState(479);
                            _la = _input.LA(1);
                            if (!(_la == T_ASC || _la == T_DESC)) {
                                _errHandler.recoverInline(this);
                            } else {
                                if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                _errHandler.reportMatch(this);
                                consume();
                            }
                        }
                    }

                    setState(489);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == T_COMMA) {
                        {
                            {
                                setState(482);
                                match(T_COMMA);
                                setState(483);
                                qident();
                                setState(485);
                                _errHandler.sync(this);
                                _la = _input.LA(1);
                                if (_la == T_ASC || _la == T_DESC) {
                                    {
                                        setState(484);
                                        _la = _input.LA(1);
                                        if (!(_la == T_ASC || _la == T_DESC)) {
                                            _errHandler.recoverInline(this);
                                        } else {
                                            if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                            _errHandler.reportMatch(this);
                                            consume();
                                        }
                                    }
                                }

                            }
                        }
                        setState(491);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                    setState(492);
                    match(T_CLOSE_P);
                    setState(494);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_ENABLE) {
                        {
                            setState(493);
                            match(T_ENABLE);
                        }
                    }

                }
                    break;
                case T_FOREIGN:
                    enterOuterAlt(_localctx, 2); {
                    setState(496);
                    match(T_FOREIGN);
                    setState(497);
                    match(T_KEY);
                    setState(498);
                    match(T_OPEN_P);
                    setState(499);
                    qident();
                    setState(504);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == T_COMMA) {
                        {
                            {
                                setState(500);
                                match(T_COMMA);
                                setState(501);
                                qident();
                            }
                        }
                        setState(506);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                    setState(507);
                    match(T_CLOSE_P);
                    setState(508);
                    match(T_REFERENCES);
                    setState(509);
                    table_name();
                    setState(510);
                    match(T_OPEN_P);
                    setState(511);
                    qident();
                    setState(516);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == T_COMMA) {
                        {
                            {
                                setState(512);
                                match(T_COMMA);
                                setState(513);
                                qident();
                            }
                        }
                        setState(518);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                    setState(519);
                    match(T_CLOSE_P);
                    setState(523);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == T_ON) {
                        {
                            {
                                setState(520);
                                create_table_fk_action();
                            }
                        }
                        setState(525);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                }
                    break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class Create_table_fk_actionContext extends ParserRuleContext {
        public TerminalNode T_ON() {
            return getToken(StartDBSqlParser.T_ON, 0);
        }

        public TerminalNode T_UPDATE() {
            return getToken(StartDBSqlParser.T_UPDATE, 0);
        }

        public TerminalNode T_DELETE() {
            return getToken(StartDBSqlParser.T_DELETE, 0);
        }

        public TerminalNode T_NO() {
            return getToken(StartDBSqlParser.T_NO, 0);
        }

        public TerminalNode T_ACTION() {
            return getToken(StartDBSqlParser.T_ACTION, 0);
        }

        public TerminalNode T_RESTRICT() {
            return getToken(StartDBSqlParser.T_RESTRICT, 0);
        }

        public TerminalNode T_SET() {
            return getToken(StartDBSqlParser.T_SET, 0);
        }

        public TerminalNode T_NULL() {
            return getToken(StartDBSqlParser.T_NULL, 0);
        }

        public TerminalNode T_DEFAULT() {
            return getToken(StartDBSqlParser.T_DEFAULT, 0);
        }

        public TerminalNode T_CASCADE() {
            return getToken(StartDBSqlParser.T_CASCADE, 0);
        }

        public Create_table_fk_actionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_create_table_fk_action;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitCreate_table_fk_action(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Create_table_fk_actionContext create_table_fk_action()
        throws RecognitionException {
        Create_table_fk_actionContext _localctx = new Create_table_fk_actionContext(
            _ctx,
            getState()
        );
        enterRule(_localctx, 36, RULE_create_table_fk_action);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(528);
                match(T_ON);
                setState(529);
                _la = _input.LA(1);
                if (!(_la == T_DELETE || _la == T_UPDATE)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
                setState(538);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 39, _ctx)) {
                    case 1: {
                        setState(530);
                        match(T_NO);
                        setState(531);
                        match(T_ACTION);
                    }
                        break;
                    case 2: {
                        setState(532);
                        match(T_RESTRICT);
                    }
                        break;
                    case 3: {
                        setState(533);
                        match(T_SET);
                        setState(534);
                        match(T_NULL);
                    }
                        break;
                    case 4: {
                        setState(535);
                        match(T_SET);
                        setState(536);
                        match(T_DEFAULT);
                    }
                        break;
                    case 5: {
                        setState(537);
                        match(T_CASCADE);
                    }
                        break;
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class Create_table_preoptionsContext extends ParserRuleContext {
        public List<Create_table_preoptions_itemContext> create_table_preoptions_item() {
            return getRuleContexts(Create_table_preoptions_itemContext.class);
        }

        public Create_table_preoptions_itemContext create_table_preoptions_item(int i) {
            return getRuleContext(Create_table_preoptions_itemContext.class, i);
        }

        public Create_table_preoptionsContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_create_table_preoptions;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitCreate_table_preoptions(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Create_table_preoptionsContext create_table_preoptions()
        throws RecognitionException {
        Create_table_preoptionsContext _localctx = new Create_table_preoptionsContext(
            _ctx,
            getState()
        );
        enterRule(_localctx, 38, RULE_create_table_preoptions);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(541);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        {
                            setState(540);
                            create_table_preoptions_item();
                        }
                    }
                    setState(543);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                } while (_la == T_COMMA);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class Create_table_preoptions_itemContext extends ParserRuleContext {
        public TerminalNode T_COMMA() {
            return getToken(StartDBSqlParser.T_COMMA, 0);
        }

        public Create_table_preoptions_td_itemContext create_table_preoptions_td_item() {
            return getRuleContext(Create_table_preoptions_td_itemContext.class, 0);
        }

        public Create_table_preoptions_itemContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_create_table_preoptions_item;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitCreate_table_preoptions_item(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Create_table_preoptions_itemContext create_table_preoptions_item()
        throws RecognitionException {
        Create_table_preoptions_itemContext _localctx = new Create_table_preoptions_itemContext(
            _ctx,
            getState()
        );
        enterRule(_localctx, 40, RULE_create_table_preoptions_item);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(545);
                match(T_COMMA);
                setState(546);
                create_table_preoptions_td_item();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class Create_table_preoptions_td_itemContext extends ParserRuleContext {
        public TerminalNode T_LOG() {
            return getToken(StartDBSqlParser.T_LOG, 0);
        }

        public TerminalNode T_FALLBACK() {
            return getToken(StartDBSqlParser.T_FALLBACK, 0);
        }

        public TerminalNode T_NO() {
            return getToken(StartDBSqlParser.T_NO, 0);
        }

        public Create_table_preoptions_td_itemContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_create_table_preoptions_td_item;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitCreate_table_preoptions_td_item(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Create_table_preoptions_td_itemContext create_table_preoptions_td_item()
        throws RecognitionException {
        Create_table_preoptions_td_itemContext _localctx =
            new Create_table_preoptions_td_itemContext(_ctx, getState());
        enterRule(_localctx, 42, RULE_create_table_preoptions_td_item);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(549);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_NO) {
                    {
                        setState(548);
                        match(T_NO);
                    }
                }

                setState(551);
                _la = _input.LA(1);
                if (!(_la == T_FALLBACK || _la == T_LOG)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class Create_table_optionsContext extends ParserRuleContext {
        public List<Create_table_options_itemContext> create_table_options_item() {
            return getRuleContexts(Create_table_options_itemContext.class);
        }

        public Create_table_options_itemContext create_table_options_item(int i) {
            return getRuleContext(Create_table_options_itemContext.class, i);
        }

        public Create_table_optionsContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_create_table_options;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitCreate_table_options(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Create_table_optionsContext create_table_options() throws RecognitionException {
        Create_table_optionsContext _localctx = new Create_table_optionsContext(_ctx, getState());
        enterRule(_localctx, 44, RULE_create_table_options);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(554);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        {
                            setState(553);
                            create_table_options_item();
                        }
                    }
                    setState(556);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                } while ((((_la) & ~0x3f) == 0
                    && ((1L << _la) & ((1L << T_AUTO_INCREMENT) | (1L << T_CHARACTER) | (1L
                        << T_CHARSET) | (1L << T_COMMENT))) != 0)
                    || _la == T_DEFAULT
                    || _la == T_ENGINE
                    || _la == T_ON);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class Create_table_options_itemContext extends ParserRuleContext {
        public TerminalNode T_ON() {
            return getToken(StartDBSqlParser.T_ON, 0);
        }

        public TerminalNode T_COMMIT() {
            return getToken(StartDBSqlParser.T_COMMIT, 0);
        }

        public TerminalNode T_ROWS() {
            return getToken(StartDBSqlParser.T_ROWS, 0);
        }

        public TerminalNode T_DELETE() {
            return getToken(StartDBSqlParser.T_DELETE, 0);
        }

        public TerminalNode T_PRESERVE() {
            return getToken(StartDBSqlParser.T_PRESERVE, 0);
        }

        public Create_table_options_mysql_itemContext create_table_options_mysql_item() {
            return getRuleContext(Create_table_options_mysql_itemContext.class, 0);
        }

        public Create_table_options_itemContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_create_table_options_item;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitCreate_table_options_item(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Create_table_options_itemContext create_table_options_item()
        throws RecognitionException {
        Create_table_options_itemContext _localctx = new Create_table_options_itemContext(
            _ctx,
            getState()
        );
        enterRule(_localctx, 46, RULE_create_table_options_item);
        int _la;
        try {
            setState(563);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T_ON:
                    enterOuterAlt(_localctx, 1); {
                    setState(558);
                    match(T_ON);
                    setState(559);
                    match(T_COMMIT);
                    setState(560);
                    _la = _input.LA(1);
                    if (!(_la == T_DELETE || _la == T_PRESERVE)) {
                        _errHandler.recoverInline(this);
                    } else {
                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                        _errHandler.reportMatch(this);
                        consume();
                    }
                    setState(561);
                    match(T_ROWS);
                }
                    break;
                case T_AUTO_INCREMENT:
                case T_CHARACTER:
                case T_CHARSET:
                case T_COMMENT:
                case T_DEFAULT:
                case T_ENGINE:
                    enterOuterAlt(_localctx, 2); {
                    setState(562);
                    create_table_options_mysql_item();
                }
                    break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class Create_table_options_mysql_itemContext extends ParserRuleContext {
        public TerminalNode T_AUTO_INCREMENT() {
            return getToken(StartDBSqlParser.T_AUTO_INCREMENT, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode T_EQUAL() {
            return getToken(StartDBSqlParser.T_EQUAL, 0);
        }

        public TerminalNode T_COMMENT() {
            return getToken(StartDBSqlParser.T_COMMENT, 0);
        }

        public TerminalNode T_CHARACTER() {
            return getToken(StartDBSqlParser.T_CHARACTER, 0);
        }

        public TerminalNode T_SET() {
            return getToken(StartDBSqlParser.T_SET, 0);
        }

        public TerminalNode T_CHARSET() {
            return getToken(StartDBSqlParser.T_CHARSET, 0);
        }

        public TerminalNode T_DEFAULT() {
            return getToken(StartDBSqlParser.T_DEFAULT, 0);
        }

        public TerminalNode T_ENGINE() {
            return getToken(StartDBSqlParser.T_ENGINE, 0);
        }

        public Create_table_options_mysql_itemContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_create_table_options_mysql_item;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitCreate_table_options_mysql_item(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Create_table_options_mysql_itemContext create_table_options_mysql_item()
        throws RecognitionException {
        Create_table_options_mysql_itemContext _localctx =
            new Create_table_options_mysql_itemContext(_ctx, getState());
        enterRule(_localctx, 48, RULE_create_table_options_mysql_item);
        int _la;
        try {
            setState(592);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T_AUTO_INCREMENT:
                    enterOuterAlt(_localctx, 1); {
                    setState(565);
                    match(T_AUTO_INCREMENT);
                    setState(567);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_EQUAL) {
                        {
                            setState(566);
                            match(T_EQUAL);
                        }
                    }

                    setState(569);
                    expr(0);
                }
                    break;
                case T_COMMENT:
                    enterOuterAlt(_localctx, 2); {
                    setState(570);
                    match(T_COMMENT);
                    setState(572);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_EQUAL) {
                        {
                            setState(571);
                            match(T_EQUAL);
                        }
                    }

                    setState(574);
                    expr(0);
                }
                    break;
                case T_CHARACTER:
                case T_CHARSET:
                case T_DEFAULT:
                    enterOuterAlt(_localctx, 3); {
                    setState(576);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_DEFAULT) {
                        {
                            setState(575);
                            match(T_DEFAULT);
                        }
                    }

                    setState(581);
                    _errHandler.sync(this);
                    switch (_input.LA(1)) {
                        case T_CHARACTER: {
                            setState(578);
                            match(T_CHARACTER);
                            setState(579);
                            match(T_SET);
                        }
                            break;
                        case T_CHARSET: {
                            setState(580);
                            match(T_CHARSET);
                        }
                            break;
                        default:
                            throw new NoViableAltException(this);
                    }
                    setState(584);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_EQUAL) {
                        {
                            setState(583);
                            match(T_EQUAL);
                        }
                    }

                    setState(586);
                    expr(0);
                }
                    break;
                case T_ENGINE:
                    enterOuterAlt(_localctx, 4); {
                    setState(587);
                    match(T_ENGINE);
                    setState(589);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_EQUAL) {
                        {
                            setState(588);
                            match(T_EQUAL);
                        }
                    }

                    setState(591);
                    expr(0);
                }
                    break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class CreateIndexStmtContext extends ParserRuleContext {
        public TerminalNode T_CREATE() {
            return getToken(StartDBSqlParser.T_CREATE, 0);
        }

        public TerminalNode T_INDEX() {
            return getToken(StartDBSqlParser.T_INDEX, 0);
        }

        public IdentContext ident() {
            return getRuleContext(IdentContext.class, 0);
        }

        public TerminalNode T_ON() {
            return getToken(StartDBSqlParser.T_ON, 0);
        }

        public TableNameContext tableName() {
            return getRuleContext(TableNameContext.class, 0);
        }

        public TerminalNode T_OPEN_P() {
            return getToken(StartDBSqlParser.T_OPEN_P, 0);
        }

        public List<CreateIndexColContext> createIndexCol() {
            return getRuleContexts(CreateIndexColContext.class);
        }

        public CreateIndexColContext createIndexCol(int i) {
            return getRuleContext(CreateIndexColContext.class, i);
        }

        public TerminalNode T_CLOSE_P() {
            return getToken(StartDBSqlParser.T_CLOSE_P, 0);
        }

        public TerminalNode T_UNIQUE() {
            return getToken(StartDBSqlParser.T_UNIQUE, 0);
        }

        public List<TerminalNode> T_COMMA() {
            return getTokens(StartDBSqlParser.T_COMMA);
        }

        public TerminalNode T_COMMA(int i) {
            return getToken(StartDBSqlParser.T_COMMA, i);
        }

        public CreateIndexStmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_createIndexStmt;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitCreateIndexStmt(this);
            else return visitor.visitChildren(this);
        }
    }

    public final CreateIndexStmtContext createIndexStmt() throws RecognitionException {
        CreateIndexStmtContext _localctx = new CreateIndexStmtContext(_ctx, getState());
        enterRule(_localctx, 50, RULE_createIndexStmt);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(594);
                match(T_CREATE);
                setState(596);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_UNIQUE) {
                    {
                        setState(595);
                        match(T_UNIQUE);
                    }
                }

                setState(598);
                match(T_INDEX);
                setState(599);
                ident();
                setState(600);
                match(T_ON);
                setState(601);
                tableName();
                setState(602);
                match(T_OPEN_P);
                setState(603);
                createIndexCol();
                setState(608);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T_COMMA) {
                    {
                        {
                            setState(604);
                            match(T_COMMA);
                            setState(605);
                            createIndexCol();
                        }
                    }
                    setState(610);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(611);
                match(T_CLOSE_P);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class CreateIndexColContext extends ParserRuleContext {
        public IdentContext ident() {
            return getRuleContext(IdentContext.class, 0);
        }

        public TerminalNode T_ASC() {
            return getToken(StartDBSqlParser.T_ASC, 0);
        }

        public TerminalNode T_DESC() {
            return getToken(StartDBSqlParser.T_DESC, 0);
        }

        public CreateIndexColContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_createIndexCol;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitCreateIndexCol(this);
            else return visitor.visitChildren(this);
        }
    }

    public final CreateIndexColContext createIndexCol() throws RecognitionException {
        CreateIndexColContext _localctx = new CreateIndexColContext(_ctx, getState());
        enterRule(_localctx, 52, RULE_createIndexCol);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(613);
                ident();
                setState(615);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_ASC || _la == T_DESC) {
                    {
                        setState(614);
                        _la = _input.LA(1);
                        if (!(_la == T_ASC || _la == T_DESC)) {
                            _errHandler.recoverInline(this);
                        } else {
                            if (_input.LA(1) == Token.EOF) matchedEOF = true;
                            _errHandler.reportMatch(this);
                            consume();
                        }
                    }
                }

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class Dtype_defaultContext extends ParserRuleContext {
        public TerminalNode T_EQUAL() {
            return getToken(StartDBSqlParser.T_EQUAL, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode T_COLON() {
            return getToken(StartDBSqlParser.T_COLON, 0);
        }

        public TerminalNode T_DEFAULT() {
            return getToken(StartDBSqlParser.T_DEFAULT, 0);
        }

        public TerminalNode T_WITH() {
            return getToken(StartDBSqlParser.T_WITH, 0);
        }

        public Dtype_defaultContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_dtype_default;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitDtype_default(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Dtype_defaultContext dtype_default() throws RecognitionException {
        Dtype_defaultContext _localctx = new Dtype_defaultContext(_ctx, getState());
        enterRule(_localctx, 54, RULE_dtype_default);
        int _la;
        try {
            setState(629);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T_COLON:
                case T_EQUAL:
                    enterOuterAlt(_localctx, 1); {
                    setState(618);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_COLON) {
                        {
                            setState(617);
                            match(T_COLON);
                        }
                    }

                    setState(620);
                    match(T_EQUAL);
                    setState(621);
                    expr(0);
                }
                    break;
                case T_DEFAULT:
                case T_WITH:
                    enterOuterAlt(_localctx, 2); {
                    setState(623);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_WITH) {
                        {
                            setState(622);
                            match(T_WITH);
                        }
                    }

                    setState(625);
                    match(T_DEFAULT);
                    setState(627);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 56, _ctx)) {
                        case 1: {
                            setState(626);
                            expr(0);
                        }
                            break;
                    }
                }
                    break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ShowTablesStmtContext extends ParserRuleContext {
        public TerminalNode T_SHOW() {
            return getToken(StartDBSqlParser.T_SHOW, 0);
        }

        public TerminalNode T_TABLES() {
            return getToken(StartDBSqlParser.T_TABLES, 0);
        }

        public ShowTablesStmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_showTablesStmt;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitShowTablesStmt(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ShowTablesStmtContext showTablesStmt() throws RecognitionException {
        ShowTablesStmtContext _localctx = new ShowTablesStmtContext(_ctx, getState());
        enterRule(_localctx, 56, RULE_showTablesStmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(631);
                match(T_SHOW);
                setState(632);
                match(T_TABLES);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class Dtype_attrContext extends ParserRuleContext {
        public TerminalNode T_NULL() {
            return getToken(StartDBSqlParser.T_NULL, 0);
        }

        public TerminalNode T_NOT() {
            return getToken(StartDBSqlParser.T_NOT, 0);
        }

        public TerminalNode T_CHARACTER() {
            return getToken(StartDBSqlParser.T_CHARACTER, 0);
        }

        public TerminalNode T_SET() {
            return getToken(StartDBSqlParser.T_SET, 0);
        }

        public IdentContext ident() {
            return getRuleContext(IdentContext.class, 0);
        }

        public TerminalNode T_CASESPECIFIC() {
            return getToken(StartDBSqlParser.T_CASESPECIFIC, 0);
        }

        public TerminalNode T_CS() {
            return getToken(StartDBSqlParser.T_CS, 0);
        }

        public Dtype_attrContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_dtype_attr;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitDtype_attr(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Dtype_attrContext dtype_attr() throws RecognitionException {
        Dtype_attrContext _localctx = new Dtype_attrContext(_ctx, getState());
        enterRule(_localctx, 58, RULE_dtype_attr);
        int _la;
        try {
            setState(645);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 60, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1); {
                    setState(635);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_NOT) {
                        {
                            setState(634);
                            match(T_NOT);
                        }
                    }

                    setState(637);
                    match(T_NULL);
                }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2); {
                    setState(638);
                    match(T_CHARACTER);
                    setState(639);
                    match(T_SET);
                    setState(640);
                    ident();
                }
                    break;
                case 3:
                    enterOuterAlt(_localctx, 3); {
                    setState(642);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_NOT) {
                        {
                            setState(641);
                            match(T_NOT);
                        }
                    }

                    setState(644);
                    _la = _input.LA(1);
                    if (!(_la == T_CASESPECIFIC || _la == T_CS)) {
                        _errHandler.recoverInline(this);
                    } else {
                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                        _errHandler.reportMatch(this);
                        consume();
                    }
                }
                    break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class DtypeContext extends ParserRuleContext {
        public TerminalNode T_DATETIME() {
            return getToken(StartDBSqlParser.T_DATETIME, 0);
        }

        public TerminalNode T_DOUBLE() {
            return getToken(StartDBSqlParser.T_DOUBLE, 0);
        }

        public TerminalNode T_FLOAT() {
            return getToken(StartDBSqlParser.T_FLOAT, 0);
        }

        public TerminalNode T_INT() {
            return getToken(StartDBSqlParser.T_INT, 0);
        }

        public TerminalNode T_INTEGER() {
            return getToken(StartDBSqlParser.T_INTEGER, 0);
        }

        public TerminalNode T_STRING() {
            return getToken(StartDBSqlParser.T_STRING, 0);
        }

        public TerminalNode T_TIMESTAMP() {
            return getToken(StartDBSqlParser.T_TIMESTAMP, 0);
        }

        public TerminalNode T_LONG() {
            return getToken(StartDBSqlParser.T_LONG, 0);
        }

        public TerminalNode T_BOOLEAN() {
            return getToken(StartDBSqlParser.T_BOOLEAN, 0);
        }

        public TerminalNode T_BOOL() {
            return getToken(StartDBSqlParser.T_BOOL, 0);
        }

        public TerminalNode T_BINARY() {
            return getToken(StartDBSqlParser.T_BINARY, 0);
        }

        public TerminalNode T_GEOMETRY() {
            return getToken(StartDBSqlParser.T_GEOMETRY, 0);
        }

        public TerminalNode T_POINT() {
            return getToken(StartDBSqlParser.T_POINT, 0);
        }

        public TerminalNode T_LINESTRING() {
            return getToken(StartDBSqlParser.T_LINESTRING, 0);
        }

        public TerminalNode T_POLYGON() {
            return getToken(StartDBSqlParser.T_POLYGON, 0);
        }

        public TerminalNode T_MULTIPOINT() {
            return getToken(StartDBSqlParser.T_MULTIPOINT, 0);
        }

        public TerminalNode T_MULTILINESTRING() {
            return getToken(StartDBSqlParser.T_MULTILINESTRING, 0);
        }

        public TerminalNode T_MULTIPOLYGON() {
            return getToken(StartDBSqlParser.T_MULTIPOLYGON, 0);
        }

        public TerminalNode T_GEOMETRYCOLLECTION() {
            return getToken(StartDBSqlParser.T_GEOMETRYCOLLECTION, 0);
        }

        public TerminalNode T_TRAJECTORY() {
            return getToken(StartDBSqlParser.T_TRAJECTORY, 0);
        }

        public TerminalNode T_ROADSEGMENT() {
            return getToken(StartDBSqlParser.T_ROADSEGMENT, 0);
        }

        public TerminalNode T_ROADNETWORK() {
            return getToken(StartDBSqlParser.T_ROADNETWORK, 0);
        }

        public IdentContext ident() {
            return getRuleContext(IdentContext.class, 0);
        }

        public TerminalNode T_TYPE() {
            return getToken(StartDBSqlParser.T_TYPE, 0);
        }

        public TerminalNode T_ROWTYPE() {
            return getToken(StartDBSqlParser.T_ROWTYPE, 0);
        }

        public DtypeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_dtype;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitDtype(this);
            else return visitor.visitChildren(this);
        }
    }

    public final DtypeContext dtype() throws RecognitionException {
        DtypeContext _localctx = new DtypeContext(_ctx, getState());
        enterRule(_localctx, 60, RULE_dtype);
        int _la;
        try {
            setState(674);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 62, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1); {
                    setState(647);
                    match(T_DATETIME);
                }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2); {
                    setState(648);
                    match(T_DOUBLE);
                }
                    break;
                case 3:
                    enterOuterAlt(_localctx, 3); {
                    setState(649);
                    match(T_FLOAT);
                }
                    break;
                case 4:
                    enterOuterAlt(_localctx, 4); {
                    setState(650);
                    match(T_INT);
                }
                    break;
                case 5:
                    enterOuterAlt(_localctx, 5); {
                    setState(651);
                    match(T_INTEGER);
                }
                    break;
                case 6:
                    enterOuterAlt(_localctx, 6); {
                    setState(652);
                    match(T_STRING);
                }
                    break;
                case 7:
                    enterOuterAlt(_localctx, 7); {
                    setState(653);
                    match(T_TIMESTAMP);
                }
                    break;
                case 8:
                    enterOuterAlt(_localctx, 8); {
                    setState(654);
                    match(T_LONG);
                }
                    break;
                case 9:
                    enterOuterAlt(_localctx, 9); {
                    setState(655);
                    match(T_BOOLEAN);
                }
                    break;
                case 10:
                    enterOuterAlt(_localctx, 10); {
                    setState(656);
                    match(T_BOOL);
                }
                    break;
                case 11:
                    enterOuterAlt(_localctx, 11); {
                    setState(657);
                    match(T_BINARY);
                }
                    break;
                case 12:
                    enterOuterAlt(_localctx, 12); {
                    setState(658);
                    match(T_GEOMETRY);
                }
                    break;
                case 13:
                    enterOuterAlt(_localctx, 13); {
                    setState(659);
                    match(T_POINT);
                }
                    break;
                case 14:
                    enterOuterAlt(_localctx, 14); {
                    setState(660);
                    match(T_LINESTRING);
                }
                    break;
                case 15:
                    enterOuterAlt(_localctx, 15); {
                    setState(661);
                    match(T_POLYGON);
                }
                    break;
                case 16:
                    enterOuterAlt(_localctx, 16); {
                    setState(662);
                    match(T_MULTIPOINT);
                }
                    break;
                case 17:
                    enterOuterAlt(_localctx, 17); {
                    setState(663);
                    match(T_MULTILINESTRING);
                }
                    break;
                case 18:
                    enterOuterAlt(_localctx, 18); {
                    setState(664);
                    match(T_MULTIPOLYGON);
                }
                    break;
                case 19:
                    enterOuterAlt(_localctx, 19); {
                    setState(665);
                    match(T_GEOMETRYCOLLECTION);
                }
                    break;
                case 20:
                    enterOuterAlt(_localctx, 20); {
                    setState(666);
                    match(T_TRAJECTORY);
                }
                    break;
                case 21:
                    enterOuterAlt(_localctx, 21); {
                    setState(667);
                    match(T_ROADSEGMENT);
                }
                    break;
                case 22:
                    enterOuterAlt(_localctx, 22); {
                    setState(668);
                    match(T_ROADNETWORK);
                }
                    break;
                case 23:
                    enterOuterAlt(_localctx, 23); {
                    setState(669);
                    ident();
                    setState(672);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T__0) {
                        {
                            setState(670);
                            match(T__0);
                            setState(671);
                            _la = _input.LA(1);
                            if (!(_la == T_ROWTYPE || _la == T_TYPE)) {
                                _errHandler.recoverInline(this);
                            } else {
                                if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                _errHandler.reportMatch(this);
                                consume();
                            }
                        }
                    }

                }
                    break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class DtypeLenContext extends ParserRuleContext {
        public TerminalNode T_OPEN_P() {
            return getToken(StartDBSqlParser.T_OPEN_P, 0);
        }

        public TerminalNode T_CLOSE_P() {
            return getToken(StartDBSqlParser.T_CLOSE_P, 0);
        }

        public List<TerminalNode> L_INT() {
            return getTokens(StartDBSqlParser.L_INT);
        }

        public TerminalNode L_INT(int i) {
            return getToken(StartDBSqlParser.L_INT, i);
        }

        public TerminalNode T_MAX() {
            return getToken(StartDBSqlParser.T_MAX, 0);
        }

        public TerminalNode T_COMMA() {
            return getToken(StartDBSqlParser.T_COMMA, 0);
        }

        public TerminalNode T_CHAR() {
            return getToken(StartDBSqlParser.T_CHAR, 0);
        }

        public TerminalNode T_BYTE() {
            return getToken(StartDBSqlParser.T_BYTE, 0);
        }

        public DtypeLenContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_dtypeLen;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitDtypeLen(this);
            else return visitor.visitChildren(this);
        }
    }

    public final DtypeLenContext dtypeLen() throws RecognitionException {
        DtypeLenContext _localctx = new DtypeLenContext(_ctx, getState());
        enterRule(_localctx, 62, RULE_dtypeLen);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(676);
                match(T_OPEN_P);
                setState(677);
                _la = _input.LA(1);
                if (!(_la == T_MAX || _la == L_INT)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
                setState(679);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_BYTE || _la == T_CHAR) {
                    {
                        setState(678);
                        _la = _input.LA(1);
                        if (!(_la == T_BYTE || _la == T_CHAR)) {
                            _errHandler.recoverInline(this);
                        } else {
                            if (_input.LA(1) == Token.EOF) matchedEOF = true;
                            _errHandler.reportMatch(this);
                            consume();
                        }
                    }
                }

                setState(683);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_COMMA) {
                    {
                        setState(681);
                        match(T_COMMA);
                        setState(682);
                        match(L_INT);
                    }
                }

                setState(685);
                match(T_CLOSE_P);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class CreateDatabaseStmtContext extends ParserRuleContext {
        public Token dbName;

        public TerminalNode T_CREATE() {
            return getToken(StartDBSqlParser.T_CREATE, 0);
        }

        public TerminalNode T_DATABASE() {
            return getToken(StartDBSqlParser.T_DATABASE, 0);
        }

        public TerminalNode T_SCHEMA() {
            return getToken(StartDBSqlParser.T_SCHEMA, 0);
        }

        public TerminalNode L_ID() {
            return getToken(StartDBSqlParser.L_ID, 0);
        }

        public TerminalNode T_IF() {
            return getToken(StartDBSqlParser.T_IF, 0);
        }

        public TerminalNode T_NOT() {
            return getToken(StartDBSqlParser.T_NOT, 0);
        }

        public TerminalNode T_EXISTS() {
            return getToken(StartDBSqlParser.T_EXISTS, 0);
        }

        public List<CreateDatabaseOptionContext> createDatabaseOption() {
            return getRuleContexts(CreateDatabaseOptionContext.class);
        }

        public CreateDatabaseOptionContext createDatabaseOption(int i) {
            return getRuleContext(CreateDatabaseOptionContext.class, i);
        }

        public CreateDatabaseStmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_createDatabaseStmt;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitCreateDatabaseStmt(this);
            else return visitor.visitChildren(this);
        }
    }

    public final CreateDatabaseStmtContext createDatabaseStmt() throws RecognitionException {
        CreateDatabaseStmtContext _localctx = new CreateDatabaseStmtContext(_ctx, getState());
        enterRule(_localctx, 64, RULE_createDatabaseStmt);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(687);
                match(T_CREATE);
                setState(688);
                _la = _input.LA(1);
                if (!(_la == T_DATABASE || _la == T_SCHEMA)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
                setState(692);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_IF) {
                    {
                        setState(689);
                        match(T_IF);
                        setState(690);
                        match(T_NOT);
                        setState(691);
                        match(T_EXISTS);
                    }
                }

                setState(694);
                ((CreateDatabaseStmtContext) _localctx).dbName = match(L_ID);
                setState(698);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T_COMMENT || _la == T_LOCATION) {
                    {
                        {
                            setState(695);
                            createDatabaseOption();
                        }
                    }
                    setState(700);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ShowDatabasesStmtContext extends ParserRuleContext {
        public TerminalNode T_SHOW() {
            return getToken(StartDBSqlParser.T_SHOW, 0);
        }

        public TerminalNode T_DATABASES() {
            return getToken(StartDBSqlParser.T_DATABASES, 0);
        }

        public ShowDatabasesStmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_showDatabasesStmt;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitShowDatabasesStmt(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ShowDatabasesStmtContext showDatabasesStmt() throws RecognitionException {
        ShowDatabasesStmtContext _localctx = new ShowDatabasesStmtContext(_ctx, getState());
        enterRule(_localctx, 66, RULE_showDatabasesStmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(701);
                match(T_SHOW);
                setState(702);
                match(T_DATABASES);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class DropDatabaseStmtContext extends ParserRuleContext {
        public Token dbName;

        public TerminalNode T_DROP() {
            return getToken(StartDBSqlParser.T_DROP, 0);
        }

        public TerminalNode T_DATABASE() {
            return getToken(StartDBSqlParser.T_DATABASE, 0);
        }

        public TerminalNode T_SCHEMA() {
            return getToken(StartDBSqlParser.T_SCHEMA, 0);
        }

        public TerminalNode L_ID() {
            return getToken(StartDBSqlParser.L_ID, 0);
        }

        public TerminalNode T_IF() {
            return getToken(StartDBSqlParser.T_IF, 0);
        }

        public TerminalNode T_EXISTS() {
            return getToken(StartDBSqlParser.T_EXISTS, 0);
        }

        public DropDatabaseStmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_dropDatabaseStmt;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitDropDatabaseStmt(this);
            else return visitor.visitChildren(this);
        }
    }

    public final DropDatabaseStmtContext dropDatabaseStmt() throws RecognitionException {
        DropDatabaseStmtContext _localctx = new DropDatabaseStmtContext(_ctx, getState());
        enterRule(_localctx, 68, RULE_dropDatabaseStmt);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(704);
                match(T_DROP);
                setState(705);
                _la = _input.LA(1);
                if (!(_la == T_DATABASE || _la == T_SCHEMA)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
                setState(708);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_IF) {
                    {
                        setState(706);
                        match(T_IF);
                        setState(707);
                        match(T_EXISTS);
                    }
                }

                setState(710);
                ((DropDatabaseStmtContext) _localctx).dbName = match(L_ID);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class CreateDatabaseOptionContext extends ParserRuleContext {
        public TerminalNode T_COMMENT() {
            return getToken(StartDBSqlParser.T_COMMENT, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode T_LOCATION() {
            return getToken(StartDBSqlParser.T_LOCATION, 0);
        }

        public CreateDatabaseOptionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_createDatabaseOption;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitCreateDatabaseOption(this);
            else return visitor.visitChildren(this);
        }
    }

    public final CreateDatabaseOptionContext createDatabaseOption() throws RecognitionException {
        CreateDatabaseOptionContext _localctx = new CreateDatabaseOptionContext(_ctx, getState());
        enterRule(_localctx, 70, RULE_createDatabaseOption);
        try {
            setState(716);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T_COMMENT:
                    enterOuterAlt(_localctx, 1); {
                    setState(712);
                    match(T_COMMENT);
                    setState(713);
                    expr(0);
                }
                    break;
                case T_LOCATION:
                    enterOuterAlt(_localctx, 2); {
                    setState(714);
                    match(T_LOCATION);
                    setState(715);
                    expr(0);
                }
                    break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class DropTableStmtContext extends ParserRuleContext {
        public TerminalNode T_DROP() {
            return getToken(StartDBSqlParser.T_DROP, 0);
        }

        public TerminalNode T_TABLE() {
            return getToken(StartDBSqlParser.T_TABLE, 0);
        }

        public TableNameContext tableName() {
            return getRuleContext(TableNameContext.class, 0);
        }

        public TerminalNode T_IF() {
            return getToken(StartDBSqlParser.T_IF, 0);
        }

        public TerminalNode T_EXISTS() {
            return getToken(StartDBSqlParser.T_EXISTS, 0);
        }

        public DropTableStmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_dropTableStmt;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitDropTableStmt(this);
            else return visitor.visitChildren(this);
        }
    }

    public final DropTableStmtContext dropTableStmt() throws RecognitionException {
        DropTableStmtContext _localctx = new DropTableStmtContext(_ctx, getState());
        enterRule(_localctx, 72, RULE_dropTableStmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(718);
                match(T_DROP);
                setState(719);
                match(T_TABLE);
                setState(722);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 69, _ctx)) {
                    case 1: {
                        setState(720);
                        match(T_IF);
                        setState(721);
                        match(T_EXISTS);
                    }
                        break;
                }
                setState(724);
                tableName();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class InsertStmtContext extends ParserRuleContext {
        public TerminalNode T_INSERT() {
            return getToken(StartDBSqlParser.T_INSERT, 0);
        }

        public TableNameContext tableName() {
            return getRuleContext(TableNameContext.class, 0);
        }

        public TerminalNode T_OVERWRITE() {
            return getToken(StartDBSqlParser.T_OVERWRITE, 0);
        }

        public TerminalNode T_TABLE() {
            return getToken(StartDBSqlParser.T_TABLE, 0);
        }

        public TerminalNode T_INTO() {
            return getToken(StartDBSqlParser.T_INTO, 0);
        }

        public SelectStmtContext selectStmt() {
            return getRuleContext(SelectStmtContext.class, 0);
        }

        public InsertStmtRowsContext insertStmtRows() {
            return getRuleContext(InsertStmtRowsContext.class, 0);
        }

        public InsertStmtColsContext insertStmtCols() {
            return getRuleContext(InsertStmtColsContext.class, 0);
        }

        public InsertStmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_insertStmt;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitInsertStmt(this);
            else return visitor.visitChildren(this);
        }
    }

    public final InsertStmtContext insertStmt() throws RecognitionException {
        InsertStmtContext _localctx = new InsertStmtContext(_ctx, getState());
        enterRule(_localctx, 74, RULE_insertStmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(726);
                match(T_INSERT);
                setState(733);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case T_OVERWRITE: {
                        setState(727);
                        match(T_OVERWRITE);
                        setState(728);
                        match(T_TABLE);
                    }
                        break;
                    case T_INTO: {
                        setState(729);
                        match(T_INTO);
                        setState(731);
                        _errHandler.sync(this);
                        switch (getInterpreter().adaptivePredict(_input, 70, _ctx)) {
                            case 1: {
                                setState(730);
                                match(T_TABLE);
                            }
                                break;
                        }
                    }
                        break;
                    default:
                        throw new NoViableAltException(this);
                }
                setState(735);
                tableName();
                setState(737);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 72, _ctx)) {
                    case 1: {
                        setState(736);
                        insertStmtCols();
                    }
                        break;
                }
                setState(741);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case T_SEL:
                    case T_SELECT:
                    case T_WITH:
                    case T_OPEN_P: {
                        setState(739);
                        selectStmt();
                    }
                        break;
                    case T_VALUES: {
                        setState(740);
                        insertStmtRows();
                    }
                        break;
                    default:
                        throw new NoViableAltException(this);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class InsertStmtColsContext extends ParserRuleContext {
        public TerminalNode T_OPEN_P() {
            return getToken(StartDBSqlParser.T_OPEN_P, 0);
        }

        public List<IdentContext> ident() {
            return getRuleContexts(IdentContext.class);
        }

        public IdentContext ident(int i) {
            return getRuleContext(IdentContext.class, i);
        }

        public TerminalNode T_CLOSE_P() {
            return getToken(StartDBSqlParser.T_CLOSE_P, 0);
        }

        public List<TerminalNode> T_COMMA() {
            return getTokens(StartDBSqlParser.T_COMMA);
        }

        public TerminalNode T_COMMA(int i) {
            return getToken(StartDBSqlParser.T_COMMA, i);
        }

        public InsertStmtColsContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_insertStmtCols;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitInsertStmtCols(this);
            else return visitor.visitChildren(this);
        }
    }

    public final InsertStmtColsContext insertStmtCols() throws RecognitionException {
        InsertStmtColsContext _localctx = new InsertStmtColsContext(_ctx, getState());
        enterRule(_localctx, 76, RULE_insertStmtCols);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(743);
                match(T_OPEN_P);
                setState(744);
                ident();
                setState(749);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T_COMMA) {
                    {
                        {
                            setState(745);
                            match(T_COMMA);
                            setState(746);
                            ident();
                        }
                    }
                    setState(751);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(752);
                match(T_CLOSE_P);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class InsertStmtRowsContext extends ParserRuleContext {
        public TerminalNode T_VALUES() {
            return getToken(StartDBSqlParser.T_VALUES, 0);
        }

        public List<InsertStmtRowContext> insertStmtRow() {
            return getRuleContexts(InsertStmtRowContext.class);
        }

        public InsertStmtRowContext insertStmtRow(int i) {
            return getRuleContext(InsertStmtRowContext.class, i);
        }

        public List<TerminalNode> T_COMMA() {
            return getTokens(StartDBSqlParser.T_COMMA);
        }

        public TerminalNode T_COMMA(int i) {
            return getToken(StartDBSqlParser.T_COMMA, i);
        }

        public InsertStmtRowsContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_insertStmtRows;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitInsertStmtRows(this);
            else return visitor.visitChildren(this);
        }
    }

    public final InsertStmtRowsContext insertStmtRows() throws RecognitionException {
        InsertStmtRowsContext _localctx = new InsertStmtRowsContext(_ctx, getState());
        enterRule(_localctx, 78, RULE_insertStmtRows);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(754);
                match(T_VALUES);
                setState(755);
                insertStmtRow();
                setState(760);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T_COMMA) {
                    {
                        {
                            setState(756);
                            match(T_COMMA);
                            setState(757);
                            insertStmtRow();
                        }
                    }
                    setState(762);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class InsertStmtRowContext extends ParserRuleContext {
        public TerminalNode T_OPEN_P() {
            return getToken(StartDBSqlParser.T_OPEN_P, 0);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode T_CLOSE_P() {
            return getToken(StartDBSqlParser.T_CLOSE_P, 0);
        }

        public List<TerminalNode> T_COMMA() {
            return getTokens(StartDBSqlParser.T_COMMA);
        }

        public TerminalNode T_COMMA(int i) {
            return getToken(StartDBSqlParser.T_COMMA, i);
        }

        public InsertStmtRowContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_insertStmtRow;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitInsertStmtRow(this);
            else return visitor.visitChildren(this);
        }
    }

    public final InsertStmtRowContext insertStmtRow() throws RecognitionException {
        InsertStmtRowContext _localctx = new InsertStmtRowContext(_ctx, getState());
        enterRule(_localctx, 80, RULE_insertStmtRow);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(763);
                match(T_OPEN_P);
                setState(764);
                expr(0);
                setState(769);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T_COMMA) {
                    {
                        {
                            setState(765);
                            match(T_COMMA);
                            setState(766);
                            expr(0);
                        }
                    }
                    setState(771);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(772);
                match(T_CLOSE_P);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class TruncateStmtContext extends ParserRuleContext {
        public TerminalNode T_TRUNCATE() {
            return getToken(StartDBSqlParser.T_TRUNCATE, 0);
        }

        public IdentContext ident() {
            return getRuleContext(IdentContext.class, 0);
        }

        public TerminalNode T_TABLE() {
            return getToken(StartDBSqlParser.T_TABLE, 0);
        }

        public TruncateStmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_truncateStmt;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitTruncateStmt(this);
            else return visitor.visitChildren(this);
        }
    }

    public final TruncateStmtContext truncateStmt() throws RecognitionException {
        TruncateStmtContext _localctx = new TruncateStmtContext(_ctx, getState());
        enterRule(_localctx, 82, RULE_truncateStmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(774);
                match(T_TRUNCATE);
                setState(776);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 77, _ctx)) {
                    case 1: {
                        setState(775);
                        match(T_TABLE);
                    }
                        break;
                }
                setState(778);
                ident();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class UseStmtContext extends ParserRuleContext {
        public Token dbName;

        public TerminalNode T_USE() {
            return getToken(StartDBSqlParser.T_USE, 0);
        }

        public TerminalNode L_ID() {
            return getToken(StartDBSqlParser.L_ID, 0);
        }

        public TerminalNode T_DEFAULT() {
            return getToken(StartDBSqlParser.T_DEFAULT, 0);
        }

        public UseStmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_useStmt;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitUseStmt(this);
            else return visitor.visitChildren(this);
        }
    }

    public final UseStmtContext useStmt() throws RecognitionException {
        UseStmtContext _localctx = new UseStmtContext(_ctx, getState());
        enterRule(_localctx, 84, RULE_useStmt);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(780);
                match(T_USE);
                setState(781);
                ((UseStmtContext) _localctx).dbName = _input.LT(1);
                _la = _input.LA(1);
                if (!(_la == T_DEFAULT || _la == L_ID)) {
                    ((UseStmtContext) _localctx).dbName = (Token) _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class SelectStmtContext extends ParserRuleContext {
        public FullselectStmtContext fullselectStmt() {
            return getRuleContext(FullselectStmtContext.class, 0);
        }

        public CteSelectStmtContext cteSelectStmt() {
            return getRuleContext(CteSelectStmtContext.class, 0);
        }

        public SelectStmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_selectStmt;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitSelectStmt(this);
            else return visitor.visitChildren(this);
        }
    }

    public final SelectStmtContext selectStmt() throws RecognitionException {
        SelectStmtContext _localctx = new SelectStmtContext(_ctx, getState());
        enterRule(_localctx, 86, RULE_selectStmt);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(784);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_WITH) {
                    {
                        setState(783);
                        cteSelectStmt();
                    }
                }

                setState(786);
                fullselectStmt();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class CteSelectStmtContext extends ParserRuleContext {
        public TerminalNode T_WITH() {
            return getToken(StartDBSqlParser.T_WITH, 0);
        }

        public List<CteSelectStmtItemContext> cteSelectStmtItem() {
            return getRuleContexts(CteSelectStmtItemContext.class);
        }

        public CteSelectStmtItemContext cteSelectStmtItem(int i) {
            return getRuleContext(CteSelectStmtItemContext.class, i);
        }

        public List<TerminalNode> T_COMMA() {
            return getTokens(StartDBSqlParser.T_COMMA);
        }

        public TerminalNode T_COMMA(int i) {
            return getToken(StartDBSqlParser.T_COMMA, i);
        }

        public CteSelectStmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_cteSelectStmt;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitCteSelectStmt(this);
            else return visitor.visitChildren(this);
        }
    }

    public final CteSelectStmtContext cteSelectStmt() throws RecognitionException {
        CteSelectStmtContext _localctx = new CteSelectStmtContext(_ctx, getState());
        enterRule(_localctx, 88, RULE_cteSelectStmt);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(788);
                match(T_WITH);
                setState(789);
                cteSelectStmtItem();
                setState(794);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T_COMMA) {
                    {
                        {
                            setState(790);
                            match(T_COMMA);
                            setState(791);
                            cteSelectStmtItem();
                        }
                    }
                    setState(796);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class CteSelectStmtItemContext extends ParserRuleContext {
        public IdentContext ident() {
            return getRuleContext(IdentContext.class, 0);
        }

        public TerminalNode T_AS() {
            return getToken(StartDBSqlParser.T_AS, 0);
        }

        public TerminalNode T_OPEN_P() {
            return getToken(StartDBSqlParser.T_OPEN_P, 0);
        }

        public FullselectStmtContext fullselectStmt() {
            return getRuleContext(FullselectStmtContext.class, 0);
        }

        public TerminalNode T_CLOSE_P() {
            return getToken(StartDBSqlParser.T_CLOSE_P, 0);
        }

        public CteSelectColsContext cteSelectCols() {
            return getRuleContext(CteSelectColsContext.class, 0);
        }

        public CteSelectStmtItemContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_cteSelectStmtItem;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitCteSelectStmtItem(this);
            else return visitor.visitChildren(this);
        }
    }

    public final CteSelectStmtItemContext cteSelectStmtItem() throws RecognitionException {
        CteSelectStmtItemContext _localctx = new CteSelectStmtItemContext(_ctx, getState());
        enterRule(_localctx, 90, RULE_cteSelectStmtItem);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(797);
                ident();
                setState(799);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_OPEN_P) {
                    {
                        setState(798);
                        cteSelectCols();
                    }
                }

                setState(801);
                match(T_AS);
                setState(802);
                match(T_OPEN_P);
                setState(803);
                fullselectStmt();
                setState(804);
                match(T_CLOSE_P);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class CteSelectColsContext extends ParserRuleContext {
        public TerminalNode T_OPEN_P() {
            return getToken(StartDBSqlParser.T_OPEN_P, 0);
        }

        public List<IdentContext> ident() {
            return getRuleContexts(IdentContext.class);
        }

        public IdentContext ident(int i) {
            return getRuleContext(IdentContext.class, i);
        }

        public TerminalNode T_CLOSE_P() {
            return getToken(StartDBSqlParser.T_CLOSE_P, 0);
        }

        public List<TerminalNode> T_COMMA() {
            return getTokens(StartDBSqlParser.T_COMMA);
        }

        public TerminalNode T_COMMA(int i) {
            return getToken(StartDBSqlParser.T_COMMA, i);
        }

        public CteSelectColsContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_cteSelectCols;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitCteSelectCols(this);
            else return visitor.visitChildren(this);
        }
    }

    public final CteSelectColsContext cteSelectCols() throws RecognitionException {
        CteSelectColsContext _localctx = new CteSelectColsContext(_ctx, getState());
        enterRule(_localctx, 92, RULE_cteSelectCols);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(806);
                match(T_OPEN_P);
                setState(807);
                ident();
                setState(812);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T_COMMA) {
                    {
                        {
                            setState(808);
                            match(T_COMMA);
                            setState(809);
                            ident();
                        }
                    }
                    setState(814);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(815);
                match(T_CLOSE_P);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class FullselectStmtContext extends ParserRuleContext {
        public List<FullselectStmtItemContext> fullselectStmtItem() {
            return getRuleContexts(FullselectStmtItemContext.class);
        }

        public FullselectStmtItemContext fullselectStmtItem(int i) {
            return getRuleContext(FullselectStmtItemContext.class, i);
        }

        public List<FullselectSetClauseContext> fullselectSetClause() {
            return getRuleContexts(FullselectSetClauseContext.class);
        }

        public FullselectSetClauseContext fullselectSetClause(int i) {
            return getRuleContext(FullselectSetClauseContext.class, i);
        }

        public TerminalNode T_OPEN_P() {
            return getToken(StartDBSqlParser.T_OPEN_P, 0);
        }

        public FullselectStmtContext fullselectStmt() {
            return getRuleContext(FullselectStmtContext.class, 0);
        }

        public TerminalNode T_CLOSE_P() {
            return getToken(StartDBSqlParser.T_CLOSE_P, 0);
        }

        public FullselectStmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_fullselectStmt;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitFullselectStmt(this);
            else return visitor.visitChildren(this);
        }
    }

    public final FullselectStmtContext fullselectStmt() throws RecognitionException {
        FullselectStmtContext _localctx = new FullselectStmtContext(_ctx, getState());
        enterRule(_localctx, 94, RULE_fullselectStmt);
        int _la;
        try {
            setState(830);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 83, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1); {
                    setState(817);
                    fullselectStmtItem();
                    setState(823);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == T_EXCEPT || _la == T_INTERSECT || _la == T_UNION) {
                        {
                            {
                                setState(818);
                                fullselectSetClause();
                                setState(819);
                                fullselectStmtItem();
                            }
                        }
                        setState(825);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2); {
                    setState(826);
                    match(T_OPEN_P);
                    setState(827);
                    fullselectStmt();
                    setState(828);
                    match(T_CLOSE_P);
                }
                    break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class FullselectStmtItemContext extends ParserRuleContext {
        public SubselectStmtContext subselectStmt() {
            return getRuleContext(SubselectStmtContext.class, 0);
        }

        public TerminalNode T_OPEN_P() {
            return getToken(StartDBSqlParser.T_OPEN_P, 0);
        }

        public FullselectStmtContext fullselectStmt() {
            return getRuleContext(FullselectStmtContext.class, 0);
        }

        public TerminalNode T_CLOSE_P() {
            return getToken(StartDBSqlParser.T_CLOSE_P, 0);
        }

        public FullselectStmtItemContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_fullselectStmtItem;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitFullselectStmtItem(this);
            else return visitor.visitChildren(this);
        }
    }

    public final FullselectStmtItemContext fullselectStmtItem() throws RecognitionException {
        FullselectStmtItemContext _localctx = new FullselectStmtItemContext(_ctx, getState());
        enterRule(_localctx, 96, RULE_fullselectStmtItem);
        try {
            setState(837);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T_SEL:
                case T_SELECT:
                    enterOuterAlt(_localctx, 1); {
                    setState(832);
                    subselectStmt();
                }
                    break;
                case T_OPEN_P:
                    enterOuterAlt(_localctx, 2); {
                    setState(833);
                    match(T_OPEN_P);
                    setState(834);
                    fullselectStmt();
                    setState(835);
                    match(T_CLOSE_P);
                }
                    break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class FullselectSetClauseContext extends ParserRuleContext {
        public TerminalNode T_UNION() {
            return getToken(StartDBSqlParser.T_UNION, 0);
        }

        public TerminalNode T_ALL() {
            return getToken(StartDBSqlParser.T_ALL, 0);
        }

        public TerminalNode T_EXCEPT() {
            return getToken(StartDBSqlParser.T_EXCEPT, 0);
        }

        public TerminalNode T_INTERSECT() {
            return getToken(StartDBSqlParser.T_INTERSECT, 0);
        }

        public FullselectSetClauseContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_fullselectSetClause;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitFullselectSetClause(this);
            else return visitor.visitChildren(this);
        }
    }

    public final FullselectSetClauseContext fullselectSetClause() throws RecognitionException {
        FullselectSetClauseContext _localctx = new FullselectSetClauseContext(_ctx, getState());
        enterRule(_localctx, 98, RULE_fullselectSetClause);
        int _la;
        try {
            setState(851);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T_UNION:
                    enterOuterAlt(_localctx, 1); {
                    setState(839);
                    match(T_UNION);
                    setState(841);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_ALL) {
                        {
                            setState(840);
                            match(T_ALL);
                        }
                    }

                }
                    break;
                case T_EXCEPT:
                    enterOuterAlt(_localctx, 2); {
                    setState(843);
                    match(T_EXCEPT);
                    setState(845);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_ALL) {
                        {
                            setState(844);
                            match(T_ALL);
                        }
                    }

                }
                    break;
                case T_INTERSECT:
                    enterOuterAlt(_localctx, 3); {
                    setState(847);
                    match(T_INTERSECT);
                    setState(849);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_ALL) {
                        {
                            setState(848);
                            match(T_ALL);
                        }
                    }

                }
                    break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class SubselectStmtContext extends ParserRuleContext {
        public SelectListContext selectList() {
            return getRuleContext(SelectListContext.class, 0);
        }

        public TerminalNode T_SELECT() {
            return getToken(StartDBSqlParser.T_SELECT, 0);
        }

        public TerminalNode T_SEL() {
            return getToken(StartDBSqlParser.T_SEL, 0);
        }

        public IntoClauseContext intoClause() {
            return getRuleContext(IntoClauseContext.class, 0);
        }

        public FromClauseContext fromClause() {
            return getRuleContext(FromClauseContext.class, 0);
        }

        public WhereClauseContext whereClause() {
            return getRuleContext(WhereClauseContext.class, 0);
        }

        public GroupByClauseContext groupByClause() {
            return getRuleContext(GroupByClauseContext.class, 0);
        }

        public HavingClauseContext havingClause() {
            return getRuleContext(HavingClauseContext.class, 0);
        }

        public QualifyClauseContext qualifyClause() {
            return getRuleContext(QualifyClauseContext.class, 0);
        }

        public OrderByClauseContext orderByClause() {
            return getRuleContext(OrderByClauseContext.class, 0);
        }

        public SelectOptionsContext selectOptions() {
            return getRuleContext(SelectOptionsContext.class, 0);
        }

        public SubselectStmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_subselectStmt;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitSubselectStmt(this);
            else return visitor.visitChildren(this);
        }
    }

    public final SubselectStmtContext subselectStmt() throws RecognitionException {
        SubselectStmtContext _localctx = new SubselectStmtContext(_ctx, getState());
        enterRule(_localctx, 100, RULE_subselectStmt);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(853);
                _la = _input.LA(1);
                if (!(_la == T_SEL || _la == T_SELECT)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
                setState(854);
                selectList();
                setState(856);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_INTO) {
                    {
                        setState(855);
                        intoClause();
                    }
                }

                setState(859);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_FROM) {
                    {
                        setState(858);
                        fromClause();
                    }
                }

                setState(862);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_WHERE) {
                    {
                        setState(861);
                        whereClause();
                    }
                }

                setState(865);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_GROUP) {
                    {
                        setState(864);
                        groupByClause();
                    }
                }

                setState(869);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case T_HAVING: {
                        setState(867);
                        havingClause();
                    }
                        break;
                    case T_QUALIFY: {
                        setState(868);
                        qualifyClause();
                    }
                        break;
                    case EOF:
                    case T_AUTO_INCREMENT:
                    case T_CHARACTER:
                    case T_CHARSET:
                    case T_COMMENT:
                    case T_DEFAULT:
                    case T_ENGINE:
                    case T_EXCEPT:
                    case T_INTERSECT:
                    case T_LIMIT:
                    case T_ON:
                    case T_ORDER:
                    case T_UNION:
                    case T_WITH:
                    case T_CLOSE_P:
                    case T_SEMICOLON:
                        break;
                    default:
                        break;
                }
                setState(872);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_ORDER) {
                    {
                        setState(871);
                        orderByClause();
                    }
                }

                setState(875);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_LIMIT || _la == T_WITH) {
                    {
                        setState(874);
                        selectOptions();
                    }
                }

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class SelectListContext extends ParserRuleContext {
        public List<SelectListItemContext> selectListItem() {
            return getRuleContexts(SelectListItemContext.class);
        }

        public SelectListItemContext selectListItem(int i) {
            return getRuleContext(SelectListItemContext.class, i);
        }

        public SelectListSetContext selectListSet() {
            return getRuleContext(SelectListSetContext.class, 0);
        }

        public SelectListLimitContext selectListLimit() {
            return getRuleContext(SelectListLimitContext.class, 0);
        }

        public List<TerminalNode> T_COMMA() {
            return getTokens(StartDBSqlParser.T_COMMA);
        }

        public TerminalNode T_COMMA(int i) {
            return getToken(StartDBSqlParser.T_COMMA, i);
        }

        public SelectListContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_selectList;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitSelectList(this);
            else return visitor.visitChildren(this);
        }
    }

    public final SelectListContext selectList() throws RecognitionException {
        SelectListContext _localctx = new SelectListContext(_ctx, getState());
        enterRule(_localctx, 102, RULE_selectList);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(878);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 96, _ctx)) {
                    case 1: {
                        setState(877);
                        selectListSet();
                    }
                        break;
                }
                setState(881);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 97, _ctx)) {
                    case 1: {
                        setState(880);
                        selectListLimit();
                    }
                        break;
                }
                setState(883);
                selectListItem();
                setState(888);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T_COMMA) {
                    {
                        {
                            setState(884);
                            match(T_COMMA);
                            setState(885);
                            selectListItem();
                        }
                    }
                    setState(890);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class SelectListSetContext extends ParserRuleContext {
        public TerminalNode T_ALL() {
            return getToken(StartDBSqlParser.T_ALL, 0);
        }

        public TerminalNode T_DISTINCT() {
            return getToken(StartDBSqlParser.T_DISTINCT, 0);
        }

        public SelectListSetContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_selectListSet;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitSelectListSet(this);
            else return visitor.visitChildren(this);
        }
    }

    public final SelectListSetContext selectListSet() throws RecognitionException {
        SelectListSetContext _localctx = new SelectListSetContext(_ctx, getState());
        enterRule(_localctx, 104, RULE_selectListSet);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(891);
                _la = _input.LA(1);
                if (!(_la == T_ALL || _la == T_DISTINCT)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class SelectListLimitContext extends ParserRuleContext {
        public TerminalNode T_TOP() {
            return getToken(StartDBSqlParser.T_TOP, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public SelectListLimitContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_selectListLimit;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitSelectListLimit(this);
            else return visitor.visitChildren(this);
        }
    }

    public final SelectListLimitContext selectListLimit() throws RecognitionException {
        SelectListLimitContext _localctx = new SelectListLimitContext(_ctx, getState());
        enterRule(_localctx, 106, RULE_selectListLimit);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(893);
                match(T_TOP);
                setState(894);
                expr(0);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class SelectListItemContext extends ParserRuleContext {
        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public SelectListAsteriskContext selectListAsterisk() {
            return getRuleContext(SelectListAsteriskContext.class, 0);
        }

        public IdentContext ident() {
            return getRuleContext(IdentContext.class, 0);
        }

        public TerminalNode T_EQUAL() {
            return getToken(StartDBSqlParser.T_EQUAL, 0);
        }

        public SelectListAliasContext selectListAlias() {
            return getRuleContext(SelectListAliasContext.class, 0);
        }

        public SelectListItemContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_selectListItem;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitSelectListItem(this);
            else return visitor.visitChildren(this);
        }
    }

    public final SelectListItemContext selectListItem() throws RecognitionException {
        SelectListItemContext _localctx = new SelectListItemContext(_ctx, getState());
        enterRule(_localctx, 108, RULE_selectListItem);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(906);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 101, _ctx)) {
                    case 1: {
                        setState(899);
                        _errHandler.sync(this);
                        switch (getInterpreter().adaptivePredict(_input, 99, _ctx)) {
                            case 1: {
                                setState(896);
                                ident();
                                setState(897);
                                match(T_EQUAL);
                            }
                                break;
                        }
                        setState(901);
                        expr(0);
                        setState(903);
                        _errHandler.sync(this);
                        switch (getInterpreter().adaptivePredict(_input, 100, _ctx)) {
                            case 1: {
                                setState(902);
                                selectListAlias();
                            }
                                break;
                        }
                    }
                        break;
                    case 2: {
                        setState(905);
                        selectListAsterisk();
                    }
                        break;
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class SelectListAliasContext extends ParserRuleContext {
        public List<IdentContext> ident() {
            return getRuleContexts(IdentContext.class);
        }

        public IdentContext ident(int i) {
            return getRuleContext(IdentContext.class, i);
        }

        public TerminalNode T_AS() {
            return getToken(StartDBSqlParser.T_AS, 0);
        }

        public TerminalNode T_OPEN_P() {
            return getToken(StartDBSqlParser.T_OPEN_P, 0);
        }

        public TerminalNode T_CLOSE_P() {
            return getToken(StartDBSqlParser.T_CLOSE_P, 0);
        }

        public List<TerminalNode> T_COMMA() {
            return getTokens(StartDBSqlParser.T_COMMA);
        }

        public TerminalNode T_COMMA(int i) {
            return getToken(StartDBSqlParser.T_COMMA, i);
        }

        public TerminalNode T_TITLE() {
            return getToken(StartDBSqlParser.T_TITLE, 0);
        }

        public TerminalNode L_S_STRING() {
            return getToken(StartDBSqlParser.L_S_STRING, 0);
        }

        public SelectListAliasContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_selectListAlias;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitSelectListAlias(this);
            else return visitor.visitChildren(this);
        }
    }

    public final SelectListAliasContext selectListAlias() throws RecognitionException {
        SelectListAliasContext _localctx = new SelectListAliasContext(_ctx, getState());
        enterRule(_localctx, 110, RULE_selectListAlias);
        int _la;
        try {
            setState(930);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 105, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1); {
                    setState(909);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 102, _ctx)) {
                        case 1: {
                            setState(908);
                            match(T_AS);
                        }
                            break;
                    }
                    setState(911);
                    ident();
                }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2); {
                    setState(913);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_AS) {
                        {
                            setState(912);
                            match(T_AS);
                        }
                    }

                    setState(915);
                    match(T_OPEN_P);
                    setState(916);
                    ident();
                    setState(921);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == T_COMMA) {
                        {
                            {
                                setState(917);
                                match(T_COMMA);
                                setState(918);
                                ident();
                            }
                        }
                        setState(923);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                    setState(924);
                    match(T_CLOSE_P);
                }
                    break;
                case 3:
                    enterOuterAlt(_localctx, 3); {
                    setState(926);
                    match(T_OPEN_P);
                    setState(927);
                    match(T_TITLE);
                    setState(928);
                    match(L_S_STRING);
                    setState(929);
                    match(T_CLOSE_P);
                }
                    break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class SelectListAsteriskContext extends ParserRuleContext {
        public TerminalNode T_MUL() {
            return getToken(StartDBSqlParser.T_MUL, 0);
        }

        public TerminalNode L_ID() {
            return getToken(StartDBSqlParser.L_ID, 0);
        }

        public TerminalNode T_DOT() {
            return getToken(StartDBSqlParser.T_DOT, 0);
        }

        public SelectListAsteriskContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_selectListAsterisk;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitSelectListAsterisk(this);
            else return visitor.visitChildren(this);
        }
    }

    public final SelectListAsteriskContext selectListAsterisk() throws RecognitionException {
        SelectListAsteriskContext _localctx = new SelectListAsteriskContext(_ctx, getState());
        enterRule(_localctx, 112, RULE_selectListAsterisk);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(934);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == L_ID) {
                    {
                        setState(932);
                        match(L_ID);
                        setState(933);
                        match(T_DOT);
                    }
                }

                setState(936);
                match(T_MUL);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class IntoClauseContext extends ParserRuleContext {
        public TerminalNode T_INTO() {
            return getToken(StartDBSqlParser.T_INTO, 0);
        }

        public List<IdentContext> ident() {
            return getRuleContexts(IdentContext.class);
        }

        public IdentContext ident(int i) {
            return getRuleContext(IdentContext.class, i);
        }

        public List<TerminalNode> T_COMMA() {
            return getTokens(StartDBSqlParser.T_COMMA);
        }

        public TerminalNode T_COMMA(int i) {
            return getToken(StartDBSqlParser.T_COMMA, i);
        }

        public IntoClauseContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_intoClause;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitIntoClause(this);
            else return visitor.visitChildren(this);
        }
    }

    public final IntoClauseContext intoClause() throws RecognitionException {
        IntoClauseContext _localctx = new IntoClauseContext(_ctx, getState());
        enterRule(_localctx, 114, RULE_intoClause);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(938);
                match(T_INTO);
                setState(939);
                ident();
                setState(944);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T_COMMA) {
                    {
                        {
                            setState(940);
                            match(T_COMMA);
                            setState(941);
                            ident();
                        }
                    }
                    setState(946);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class FromClauseContext extends ParserRuleContext {
        public TerminalNode T_FROM() {
            return getToken(StartDBSqlParser.T_FROM, 0);
        }

        public FromTableClauseContext fromTableClause() {
            return getRuleContext(FromTableClauseContext.class, 0);
        }

        public List<FromJoinClauseContext> fromJoinClause() {
            return getRuleContexts(FromJoinClauseContext.class);
        }

        public FromJoinClauseContext fromJoinClause(int i) {
            return getRuleContext(FromJoinClauseContext.class, i);
        }

        public FromClauseContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_fromClause;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitFromClause(this);
            else return visitor.visitChildren(this);
        }
    }

    public final FromClauseContext fromClause() throws RecognitionException {
        FromClauseContext _localctx = new FromClauseContext(_ctx, getState());
        enterRule(_localctx, 116, RULE_fromClause);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(947);
                match(T_FROM);
                setState(948);
                fromTableClause();
                setState(952);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 108, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            {
                                setState(949);
                                fromJoinClause();
                            }
                        }
                    }
                    setState(954);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 108, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class FromTableClauseContext extends ParserRuleContext {
        public FromTableNameClauseContext fromTableNameClause() {
            return getRuleContext(FromTableNameClauseContext.class, 0);
        }

        public FromSubselectClauseContext fromSubselectClause() {
            return getRuleContext(FromSubselectClauseContext.class, 0);
        }

        public FromTableValuesClauseContext fromTableValuesClause() {
            return getRuleContext(FromTableValuesClauseContext.class, 0);
        }

        public FromTableClauseContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_fromTableClause;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitFromTableClause(this);
            else return visitor.visitChildren(this);
        }
    }

    public final FromTableClauseContext fromTableClause() throws RecognitionException {
        FromTableClauseContext _localctx = new FromTableClauseContext(_ctx, getState());
        enterRule(_localctx, 118, RULE_fromTableClause);
        try {
            setState(958);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 109, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1); {
                    setState(955);
                    fromTableNameClause();
                }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2); {
                    setState(956);
                    fromSubselectClause();
                }
                    break;
                case 3:
                    enterOuterAlt(_localctx, 3); {
                    setState(957);
                    fromTableValuesClause();
                }
                    break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class FromTableNameClauseContext extends ParserRuleContext {
        public TableNameContext tableName() {
            return getRuleContext(TableNameContext.class, 0);
        }

        public FromAliasClauseContext fromAliasClause() {
            return getRuleContext(FromAliasClauseContext.class, 0);
        }

        public SampleClauseContext sampleClause() {
            return getRuleContext(SampleClauseContext.class, 0);
        }

        public FromTableNameClauseContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_fromTableNameClause;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitFromTableNameClause(this);
            else return visitor.visitChildren(this);
        }
    }

    public final FromTableNameClauseContext fromTableNameClause() throws RecognitionException {
        FromTableNameClauseContext _localctx = new FromTableNameClauseContext(_ctx, getState());
        enterRule(_localctx, 120, RULE_fromTableNameClause);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(960);
                tableName();
                setState(962);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 110, _ctx)) {
                    case 1: {
                        setState(961);
                        fromAliasClause();
                    }
                        break;
                }
                setState(965);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_TABLESAMPLE) {
                    {
                        setState(964);
                        sampleClause();
                    }
                }

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class FromSubselectClauseContext extends ParserRuleContext {
        public TerminalNode T_OPEN_P() {
            return getToken(StartDBSqlParser.T_OPEN_P, 0);
        }

        public SelectStmtContext selectStmt() {
            return getRuleContext(SelectStmtContext.class, 0);
        }

        public TerminalNode T_CLOSE_P() {
            return getToken(StartDBSqlParser.T_CLOSE_P, 0);
        }

        public FromAliasClauseContext fromAliasClause() {
            return getRuleContext(FromAliasClauseContext.class, 0);
        }

        public FromSubselectClauseContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_fromSubselectClause;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitFromSubselectClause(this);
            else return visitor.visitChildren(this);
        }
    }

    public final FromSubselectClauseContext fromSubselectClause() throws RecognitionException {
        FromSubselectClauseContext _localctx = new FromSubselectClauseContext(_ctx, getState());
        enterRule(_localctx, 122, RULE_fromSubselectClause);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(967);
                match(T_OPEN_P);
                setState(968);
                selectStmt();
                setState(969);
                match(T_CLOSE_P);
                setState(971);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 112, _ctx)) {
                    case 1: {
                        setState(970);
                        fromAliasClause();
                    }
                        break;
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class FromJoinClauseContext extends ParserRuleContext {
        public TerminalNode T_COMMA() {
            return getToken(StartDBSqlParser.T_COMMA, 0);
        }

        public FromTableClauseContext fromTableClause() {
            return getRuleContext(FromTableClauseContext.class, 0);
        }

        public FromJoinTypeClauseContext fromJoinTypeClause() {
            return getRuleContext(FromJoinTypeClauseContext.class, 0);
        }

        public TerminalNode T_ON() {
            return getToken(StartDBSqlParser.T_ON, 0);
        }

        public BoolExprContext boolExpr() {
            return getRuleContext(BoolExprContext.class, 0);
        }

        public FromJoinClauseContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_fromJoinClause;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitFromJoinClause(this);
            else return visitor.visitChildren(this);
        }
    }

    public final FromJoinClauseContext fromJoinClause() throws RecognitionException {
        FromJoinClauseContext _localctx = new FromJoinClauseContext(_ctx, getState());
        enterRule(_localctx, 124, RULE_fromJoinClause);
        try {
            setState(980);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T_COMMA:
                    enterOuterAlt(_localctx, 1); {
                    setState(973);
                    match(T_COMMA);
                    setState(974);
                    fromTableClause();
                }
                    break;
                case T_FULL:
                case T_INNER:
                case T_JOIN:
                case T_LEFT:
                case T_RIGHT:
                    enterOuterAlt(_localctx, 2); {
                    setState(975);
                    fromJoinTypeClause();
                    setState(976);
                    fromTableClause();
                    setState(977);
                    match(T_ON);
                    setState(978);
                    boolExpr(0);
                }
                    break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class FromJoinTypeClauseContext extends ParserRuleContext {
        public TerminalNode T_JOIN() {
            return getToken(StartDBSqlParser.T_JOIN, 0);
        }

        public TerminalNode T_INNER() {
            return getToken(StartDBSqlParser.T_INNER, 0);
        }

        public TerminalNode T_LEFT() {
            return getToken(StartDBSqlParser.T_LEFT, 0);
        }

        public TerminalNode T_RIGHT() {
            return getToken(StartDBSqlParser.T_RIGHT, 0);
        }

        public TerminalNode T_FULL() {
            return getToken(StartDBSqlParser.T_FULL, 0);
        }

        public TerminalNode T_OUTER() {
            return getToken(StartDBSqlParser.T_OUTER, 0);
        }

        public FromJoinTypeClauseContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_fromJoinTypeClause;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitFromJoinTypeClause(this);
            else return visitor.visitChildren(this);
        }
    }

    public final FromJoinTypeClauseContext fromJoinTypeClause() throws RecognitionException {
        FromJoinTypeClauseContext _localctx = new FromJoinTypeClauseContext(_ctx, getState());
        enterRule(_localctx, 126, RULE_fromJoinTypeClause);
        int _la;
        try {
            setState(991);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T_INNER:
                case T_JOIN:
                    enterOuterAlt(_localctx, 1); {
                    setState(983);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_INNER) {
                        {
                            setState(982);
                            match(T_INNER);
                        }
                    }

                    setState(985);
                    match(T_JOIN);
                }
                    break;
                case T_FULL:
                case T_LEFT:
                case T_RIGHT:
                    enterOuterAlt(_localctx, 2); {
                    setState(986);
                    _la = _input.LA(1);
                    if (!(_la == T_FULL || _la == T_LEFT || _la == T_RIGHT)) {
                        _errHandler.recoverInline(this);
                    } else {
                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                        _errHandler.reportMatch(this);
                        consume();
                    }
                    setState(988);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_OUTER) {
                        {
                            setState(987);
                            match(T_OUTER);
                        }
                    }

                    setState(990);
                    match(T_JOIN);
                }
                    break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class FromTableValuesClauseContext extends ParserRuleContext {
        public TerminalNode T_TABLE() {
            return getToken(StartDBSqlParser.T_TABLE, 0);
        }

        public TerminalNode T_OPEN_P() {
            return getToken(StartDBSqlParser.T_OPEN_P, 0);
        }

        public TerminalNode T_VALUES() {
            return getToken(StartDBSqlParser.T_VALUES, 0);
        }

        public List<FromTableValuesRowContext> fromTableValuesRow() {
            return getRuleContexts(FromTableValuesRowContext.class);
        }

        public FromTableValuesRowContext fromTableValuesRow(int i) {
            return getRuleContext(FromTableValuesRowContext.class, i);
        }

        public TerminalNode T_CLOSE_P() {
            return getToken(StartDBSqlParser.T_CLOSE_P, 0);
        }

        public List<TerminalNode> T_COMMA() {
            return getTokens(StartDBSqlParser.T_COMMA);
        }

        public TerminalNode T_COMMA(int i) {
            return getToken(StartDBSqlParser.T_COMMA, i);
        }

        public FromAliasClauseContext fromAliasClause() {
            return getRuleContext(FromAliasClauseContext.class, 0);
        }

        public FromTableValuesClauseContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_fromTableValuesClause;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitFromTableValuesClause(this);
            else return visitor.visitChildren(this);
        }
    }

    public final FromTableValuesClauseContext fromTableValuesClause() throws RecognitionException {
        FromTableValuesClauseContext _localctx = new FromTableValuesClauseContext(_ctx, getState());
        enterRule(_localctx, 128, RULE_fromTableValuesClause);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(993);
                match(T_TABLE);
                setState(994);
                match(T_OPEN_P);
                setState(995);
                match(T_VALUES);
                setState(996);
                fromTableValuesRow();
                setState(1001);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T_COMMA) {
                    {
                        {
                            setState(997);
                            match(T_COMMA);
                            setState(998);
                            fromTableValuesRow();
                        }
                    }
                    setState(1003);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(1004);
                match(T_CLOSE_P);
                setState(1006);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 118, _ctx)) {
                    case 1: {
                        setState(1005);
                        fromAliasClause();
                    }
                        break;
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class FromTableValuesRowContext extends ParserRuleContext {
        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode T_OPEN_P() {
            return getToken(StartDBSqlParser.T_OPEN_P, 0);
        }

        public TerminalNode T_CLOSE_P() {
            return getToken(StartDBSqlParser.T_CLOSE_P, 0);
        }

        public List<TerminalNode> T_COMMA() {
            return getTokens(StartDBSqlParser.T_COMMA);
        }

        public TerminalNode T_COMMA(int i) {
            return getToken(StartDBSqlParser.T_COMMA, i);
        }

        public FromTableValuesRowContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_fromTableValuesRow;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitFromTableValuesRow(this);
            else return visitor.visitChildren(this);
        }
    }

    public final FromTableValuesRowContext fromTableValuesRow() throws RecognitionException {
        FromTableValuesRowContext _localctx = new FromTableValuesRowContext(_ctx, getState());
        enterRule(_localctx, 130, RULE_fromTableValuesRow);
        int _la;
        try {
            setState(1020);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 120, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1); {
                    setState(1008);
                    expr(0);
                }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2); {
                    setState(1009);
                    match(T_OPEN_P);
                    setState(1010);
                    expr(0);
                    setState(1015);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == T_COMMA) {
                        {
                            {
                                setState(1011);
                                match(T_COMMA);
                                setState(1012);
                                expr(0);
                            }
                        }
                        setState(1017);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                    setState(1018);
                    match(T_CLOSE_P);
                }
                    break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class FromAliasClauseContext extends ParserRuleContext {
        public IdentContext ident() {
            return getRuleContext(IdentContext.class, 0);
        }

        public TerminalNode T_AS() {
            return getToken(StartDBSqlParser.T_AS, 0);
        }

        public TerminalNode T_OPEN_P() {
            return getToken(StartDBSqlParser.T_OPEN_P, 0);
        }

        public List<TerminalNode> L_ID() {
            return getTokens(StartDBSqlParser.L_ID);
        }

        public TerminalNode L_ID(int i) {
            return getToken(StartDBSqlParser.L_ID, i);
        }

        public TerminalNode T_CLOSE_P() {
            return getToken(StartDBSqlParser.T_CLOSE_P, 0);
        }

        public List<TerminalNode> T_COMMA() {
            return getTokens(StartDBSqlParser.T_COMMA);
        }

        public TerminalNode T_COMMA(int i) {
            return getToken(StartDBSqlParser.T_COMMA, i);
        }

        public FromAliasClauseContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_fromAliasClause;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitFromAliasClause(this);
            else return visitor.visitChildren(this);
        }
    }

    public final FromAliasClauseContext fromAliasClause() throws RecognitionException {
        FromAliasClauseContext _localctx = new FromAliasClauseContext(_ctx, getState());
        enterRule(_localctx, 132, RULE_fromAliasClause);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1022);
                if (!(!_input.LT(1).getText().equalsIgnoreCase("EXEC")
                    && !_input.LT(1).getText().equalsIgnoreCase("EXECUTE")
                    && !_input.LT(1).getText().equalsIgnoreCase("INNER")
                    && !_input.LT(1).getText().equalsIgnoreCase("LEFT")
                    && !_input.LT(1).getText().equalsIgnoreCase("GROUP")
                    && !_input.LT(1).getText().equalsIgnoreCase("ORDER")
                    && !_input.LT(1).getText().equalsIgnoreCase("LIMIT")
                    && !_input.LT(1).getText().equalsIgnoreCase("WITH")))
                    throw new FailedPredicateException(
                        this,
                        "!_input.LT(1).getText().equalsIgnoreCase(\"EXEC\") &&\r\n        !_input.LT(1).getText().equalsIgnoreCase(\"EXECUTE\") &&\r\n        !_input.LT(1).getText().equalsIgnoreCase(\"INNER\") &&\r\n        !_input.LT(1).getText().equalsIgnoreCase(\"LEFT\") &&\r\n        !_input.LT(1).getText().equalsIgnoreCase(\"GROUP\") &&\r\n        !_input.LT(1).getText().equalsIgnoreCase(\"ORDER\") &&\r\n        !_input.LT(1).getText().equalsIgnoreCase(\"LIMIT\") &&\r\n        !_input.LT(1).getText().equalsIgnoreCase(\"WITH\")"
                    );
                setState(1024);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 121, _ctx)) {
                    case 1: {
                        setState(1023);
                        match(T_AS);
                    }
                        break;
                }
                setState(1026);
                ident();
                setState(1037);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_OPEN_P) {
                    {
                        setState(1027);
                        match(T_OPEN_P);
                        setState(1028);
                        match(L_ID);
                        setState(1033);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        while (_la == T_COMMA) {
                            {
                                {
                                    setState(1029);
                                    match(T_COMMA);
                                    setState(1030);
                                    match(L_ID);
                                }
                            }
                            setState(1035);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                        }
                        setState(1036);
                        match(T_CLOSE_P);
                    }
                }

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class TableNameContext extends ParserRuleContext {
        public IdentContext ident() {
            return getRuleContext(IdentContext.class, 0);
        }

        public TableNameContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_tableName;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitTableName(this);
            else return visitor.visitChildren(this);
        }
    }

    public final TableNameContext tableName() throws RecognitionException {
        TableNameContext _localctx = new TableNameContext(_ctx, getState());
        enterRule(_localctx, 134, RULE_tableName);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1039);
                ident();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class WhereClauseContext extends ParserRuleContext {
        public TerminalNode T_WHERE() {
            return getToken(StartDBSqlParser.T_WHERE, 0);
        }

        public BoolExprContext boolExpr() {
            return getRuleContext(BoolExprContext.class, 0);
        }

        public WhereClauseContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_whereClause;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitWhereClause(this);
            else return visitor.visitChildren(this);
        }
    }

    public final WhereClauseContext whereClause() throws RecognitionException {
        WhereClauseContext _localctx = new WhereClauseContext(_ctx, getState());
        enterRule(_localctx, 136, RULE_whereClause);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1041);
                match(T_WHERE);
                setState(1042);
                boolExpr(0);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class GroupByClauseContext extends ParserRuleContext {
        public TerminalNode T_GROUP() {
            return getToken(StartDBSqlParser.T_GROUP, 0);
        }

        public TerminalNode T_BY() {
            return getToken(StartDBSqlParser.T_BY, 0);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public List<TerminalNode> T_COMMA() {
            return getTokens(StartDBSqlParser.T_COMMA);
        }

        public TerminalNode T_COMMA(int i) {
            return getToken(StartDBSqlParser.T_COMMA, i);
        }

        public GroupByClauseContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_groupByClause;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitGroupByClause(this);
            else return visitor.visitChildren(this);
        }
    }

    public final GroupByClauseContext groupByClause() throws RecognitionException {
        GroupByClauseContext _localctx = new GroupByClauseContext(_ctx, getState());
        enterRule(_localctx, 138, RULE_groupByClause);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1044);
                match(T_GROUP);
                setState(1045);
                match(T_BY);
                setState(1046);
                expr(0);
                setState(1051);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T_COMMA) {
                    {
                        {
                            setState(1047);
                            match(T_COMMA);
                            setState(1048);
                            expr(0);
                        }
                    }
                    setState(1053);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class HavingClauseContext extends ParserRuleContext {
        public TerminalNode T_HAVING() {
            return getToken(StartDBSqlParser.T_HAVING, 0);
        }

        public BoolExprContext boolExpr() {
            return getRuleContext(BoolExprContext.class, 0);
        }

        public HavingClauseContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_havingClause;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitHavingClause(this);
            else return visitor.visitChildren(this);
        }
    }

    public final HavingClauseContext havingClause() throws RecognitionException {
        HavingClauseContext _localctx = new HavingClauseContext(_ctx, getState());
        enterRule(_localctx, 140, RULE_havingClause);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1054);
                match(T_HAVING);
                setState(1055);
                boolExpr(0);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class QualifyClauseContext extends ParserRuleContext {
        public TerminalNode T_QUALIFY() {
            return getToken(StartDBSqlParser.T_QUALIFY, 0);
        }

        public BoolExprContext boolExpr() {
            return getRuleContext(BoolExprContext.class, 0);
        }

        public QualifyClauseContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_qualifyClause;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitQualifyClause(this);
            else return visitor.visitChildren(this);
        }
    }

    public final QualifyClauseContext qualifyClause() throws RecognitionException {
        QualifyClauseContext _localctx = new QualifyClauseContext(_ctx, getState());
        enterRule(_localctx, 142, RULE_qualifyClause);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1057);
                match(T_QUALIFY);
                setState(1058);
                boolExpr(0);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class OrderByClauseContext extends ParserRuleContext {
        public TerminalNode T_ORDER() {
            return getToken(StartDBSqlParser.T_ORDER, 0);
        }

        public TerminalNode T_BY() {
            return getToken(StartDBSqlParser.T_BY, 0);
        }

        public List<OrderByClauseItemContext> orderByClauseItem() {
            return getRuleContexts(OrderByClauseItemContext.class);
        }

        public OrderByClauseItemContext orderByClauseItem(int i) {
            return getRuleContext(OrderByClauseItemContext.class, i);
        }

        public List<TerminalNode> T_COMMA() {
            return getTokens(StartDBSqlParser.T_COMMA);
        }

        public TerminalNode T_COMMA(int i) {
            return getToken(StartDBSqlParser.T_COMMA, i);
        }

        public OrderByClauseContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_orderByClause;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitOrderByClause(this);
            else return visitor.visitChildren(this);
        }
    }

    public final OrderByClauseContext orderByClause() throws RecognitionException {
        OrderByClauseContext _localctx = new OrderByClauseContext(_ctx, getState());
        enterRule(_localctx, 144, RULE_orderByClause);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1060);
                match(T_ORDER);
                setState(1061);
                match(T_BY);
                setState(1062);
                orderByClauseItem();
                setState(1067);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T_COMMA) {
                    {
                        {
                            setState(1063);
                            match(T_COMMA);
                            setState(1064);
                            orderByClauseItem();
                        }
                    }
                    setState(1069);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class OrderByClauseItemContext extends ParserRuleContext {
        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode T_ASC() {
            return getToken(StartDBSqlParser.T_ASC, 0);
        }

        public TerminalNode T_DESC() {
            return getToken(StartDBSqlParser.T_DESC, 0);
        }

        public OrderByClauseItemContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_orderByClauseItem;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitOrderByClauseItem(this);
            else return visitor.visitChildren(this);
        }
    }

    public final OrderByClauseItemContext orderByClauseItem() throws RecognitionException {
        OrderByClauseItemContext _localctx = new OrderByClauseItemContext(_ctx, getState());
        enterRule(_localctx, 146, RULE_orderByClauseItem);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1070);
                expr(0);
                setState(1072);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_ASC || _la == T_DESC) {
                    {
                        setState(1071);
                        _la = _input.LA(1);
                        if (!(_la == T_ASC || _la == T_DESC)) {
                            _errHandler.recoverInline(this);
                        } else {
                            if (_input.LA(1) == Token.EOF) matchedEOF = true;
                            _errHandler.reportMatch(this);
                            consume();
                        }
                    }
                }

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class SampleClauseContext extends ParserRuleContext {
        public TerminalNode T_TABLESAMPLE() {
            return getToken(StartDBSqlParser.T_TABLESAMPLE, 0);
        }

        public TerminalNode T_OPEN_P() {
            return getToken(StartDBSqlParser.T_OPEN_P, 0);
        }

        public TerminalNode L_INT() {
            return getToken(StartDBSqlParser.L_INT, 0);
        }

        public TerminalNode T_PERCENT() {
            return getToken(StartDBSqlParser.T_PERCENT, 0);
        }

        public TerminalNode T_CLOSE_P() {
            return getToken(StartDBSqlParser.T_CLOSE_P, 0);
        }

        public SampleClauseContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_sampleClause;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitSampleClause(this);
            else return visitor.visitChildren(this);
        }
    }

    public final SampleClauseContext sampleClause() throws RecognitionException {
        SampleClauseContext _localctx = new SampleClauseContext(_ctx, getState());
        enterRule(_localctx, 148, RULE_sampleClause);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1074);
                match(T_TABLESAMPLE);
                setState(1075);
                match(T_OPEN_P);
                setState(1076);
                match(L_INT);
                setState(1077);
                match(T_PERCENT);
                setState(1078);
                match(T_CLOSE_P);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class SelectOptionsContext extends ParserRuleContext {
        public List<SelectOptionsItemContext> selectOptionsItem() {
            return getRuleContexts(SelectOptionsItemContext.class);
        }

        public SelectOptionsItemContext selectOptionsItem(int i) {
            return getRuleContext(SelectOptionsItemContext.class, i);
        }

        public SelectOptionsContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_selectOptions;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitSelectOptions(this);
            else return visitor.visitChildren(this);
        }
    }

    public final SelectOptionsContext selectOptions() throws RecognitionException {
        SelectOptionsContext _localctx = new SelectOptionsContext(_ctx, getState());
        enterRule(_localctx, 150, RULE_selectOptions);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1081);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        {
                            setState(1080);
                            selectOptionsItem();
                        }
                    }
                    setState(1083);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                } while (_la == T_LIMIT || _la == T_WITH);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class SelectOptionsItemContext extends ParserRuleContext {
        public TerminalNode T_LIMIT() {
            return getToken(StartDBSqlParser.T_LIMIT, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode T_WITH() {
            return getToken(StartDBSqlParser.T_WITH, 0);
        }

        public TerminalNode T_RR() {
            return getToken(StartDBSqlParser.T_RR, 0);
        }

        public TerminalNode T_RS() {
            return getToken(StartDBSqlParser.T_RS, 0);
        }

        public TerminalNode T_CS() {
            return getToken(StartDBSqlParser.T_CS, 0);
        }

        public TerminalNode T_UR() {
            return getToken(StartDBSqlParser.T_UR, 0);
        }

        public TerminalNode T_USE() {
            return getToken(StartDBSqlParser.T_USE, 0);
        }

        public TerminalNode T_AND() {
            return getToken(StartDBSqlParser.T_AND, 0);
        }

        public TerminalNode T_KEEP() {
            return getToken(StartDBSqlParser.T_KEEP, 0);
        }

        public TerminalNode T_LOCKS() {
            return getToken(StartDBSqlParser.T_LOCKS, 0);
        }

        public TerminalNode T_EXCLUSIVE() {
            return getToken(StartDBSqlParser.T_EXCLUSIVE, 0);
        }

        public TerminalNode T_UPDATE() {
            return getToken(StartDBSqlParser.T_UPDATE, 0);
        }

        public SelectOptionsItemContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_selectOptionsItem;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitSelectOptionsItem(this);
            else return visitor.visitChildren(this);
        }
    }

    public final SelectOptionsItemContext selectOptionsItem() throws RecognitionException {
        SelectOptionsItemContext _localctx = new SelectOptionsItemContext(_ctx, getState());
        enterRule(_localctx, 152, RULE_selectOptionsItem);
        int _la;
        try {
            setState(1096);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T_LIMIT:
                    enterOuterAlt(_localctx, 1); {
                    setState(1085);
                    match(T_LIMIT);
                    setState(1086);
                    expr(0);
                }
                    break;
                case T_WITH:
                    enterOuterAlt(_localctx, 2); {
                    setState(1087);
                    match(T_WITH);
                    setState(1088);
                    _la = _input.LA(1);
                    if (!(_la == T_CS || _la == T_RR || _la == T_RS || _la == T_UR)) {
                        _errHandler.recoverInline(this);
                    } else {
                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                        _errHandler.reportMatch(this);
                        consume();
                    }
                    setState(1094);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_USE) {
                        {
                            setState(1089);
                            match(T_USE);
                            setState(1090);
                            match(T_AND);
                            setState(1091);
                            match(T_KEEP);
                            setState(1092);
                            _la = _input.LA(1);
                            if (!(_la == T_EXCLUSIVE || _la == T_UPDATE)) {
                                _errHandler.recoverInline(this);
                            } else {
                                if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                _errHandler.reportMatch(this);
                                consume();
                            }
                            setState(1093);
                            match(T_LOCKS);
                        }
                    }

                }
                    break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class UpdateStmtContext extends ParserRuleContext {
        public TerminalNode T_UPDATE() {
            return getToken(StartDBSqlParser.T_UPDATE, 0);
        }

        public UpdateTableContext updateTable() {
            return getRuleContext(UpdateTableContext.class, 0);
        }

        public TerminalNode T_SET() {
            return getToken(StartDBSqlParser.T_SET, 0);
        }

        public UpdateAssignmentContext updateAssignment() {
            return getRuleContext(UpdateAssignmentContext.class, 0);
        }

        public WhereClauseContext whereClause() {
            return getRuleContext(WhereClauseContext.class, 0);
        }

        public UpdateUpsertContext updateUpsert() {
            return getRuleContext(UpdateUpsertContext.class, 0);
        }

        public UpdateStmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_updateStmt;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitUpdateStmt(this);
            else return visitor.visitChildren(this);
        }
    }

    public final UpdateStmtContext updateStmt() throws RecognitionException {
        UpdateStmtContext _localctx = new UpdateStmtContext(_ctx, getState());
        enterRule(_localctx, 154, RULE_updateStmt);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1098);
                match(T_UPDATE);
                setState(1099);
                updateTable();
                setState(1100);
                match(T_SET);
                setState(1101);
                updateAssignment();
                setState(1103);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_WHERE) {
                    {
                        setState(1102);
                        whereClause();
                    }
                }

                setState(1106);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_ELSE) {
                    {
                        setState(1105);
                        updateUpsert();
                    }
                }

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class UpdateAssignmentContext extends ParserRuleContext {
        public List<AssignmentStmtItemContext> assignmentStmtItem() {
            return getRuleContexts(AssignmentStmtItemContext.class);
        }

        public AssignmentStmtItemContext assignmentStmtItem(int i) {
            return getRuleContext(AssignmentStmtItemContext.class, i);
        }

        public List<TerminalNode> T_COMMA() {
            return getTokens(StartDBSqlParser.T_COMMA);
        }

        public TerminalNode T_COMMA(int i) {
            return getToken(StartDBSqlParser.T_COMMA, i);
        }

        public UpdateAssignmentContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_updateAssignment;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitUpdateAssignment(this);
            else return visitor.visitChildren(this);
        }
    }

    public final UpdateAssignmentContext updateAssignment() throws RecognitionException {
        UpdateAssignmentContext _localctx = new UpdateAssignmentContext(_ctx, getState());
        enterRule(_localctx, 156, RULE_updateAssignment);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1108);
                assignmentStmtItem();
                setState(1113);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T_COMMA) {
                    {
                        {
                            setState(1109);
                            match(T_COMMA);
                            setState(1110);
                            assignmentStmtItem();
                        }
                    }
                    setState(1115);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class UpdateTableContext extends ParserRuleContext {
        public TableNameContext tableName() {
            return getRuleContext(TableNameContext.class, 0);
        }

        public TerminalNode T_OPEN_P() {
            return getToken(StartDBSqlParser.T_OPEN_P, 0);
        }

        public SelectStmtContext selectStmt() {
            return getRuleContext(SelectStmtContext.class, 0);
        }

        public TerminalNode T_CLOSE_P() {
            return getToken(StartDBSqlParser.T_CLOSE_P, 0);
        }

        public IdentContext ident() {
            return getRuleContext(IdentContext.class, 0);
        }

        public FromClauseContext fromClause() {
            return getRuleContext(FromClauseContext.class, 0);
        }

        public TerminalNode T_AS() {
            return getToken(StartDBSqlParser.T_AS, 0);
        }

        public UpdateTableContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_updateTable;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitUpdateTable(this);
            else return visitor.visitChildren(this);
        }
    }

    public final UpdateTableContext updateTable() throws RecognitionException {
        UpdateTableContext _localctx = new UpdateTableContext(_ctx, getState());
        enterRule(_localctx, 158, RULE_updateTable);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1124);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case T_ACTION:
                    case T_ADD2:
                    case T_ALL:
                    case T_ALLOCATE:
                    case T_ALTER:
                    case T_AND:
                    case T_ANSI_NULLS:
                    case T_ANSI_PADDING:
                    case T_AS:
                    case T_ASC:
                    case T_ASSOCIATE:
                    case T_AT:
                    case T_AVG:
                    case T_BATCHSIZE:
                    case T_BEGIN:
                    case T_BETWEEN:
                    case T_BIGINT:
                    case T_BINARY_DOUBLE:
                    case T_BINARY_FLOAT:
                    case T_BIT:
                    case T_BODY:
                    case T_BREAK:
                    case T_BY:
                    case T_BYTE:
                    case T_CALL:
                    case T_CALLER:
                    case T_CASCADE:
                    case T_CASE:
                    case T_CASESPECIFIC:
                    case T_CAST:
                    case T_CHAR:
                    case T_CHARACTER:
                    case T_CHARSET:
                    case T_CLIENT:
                    case T_CLOSE:
                    case T_CLUSTERED:
                    case T_CMP:
                    case T_COLLECT:
                    case T_COLLECTION:
                    case T_COLUMN:
                    case T_COMMENT:
                    case T_CONSTANT:
                    case T_COMMIT:
                    case T_COMPRESS:
                    case T_CONCAT:
                    case T_CONDITION:
                    case T_CONSTRAINT:
                    case T_CONTINUE:
                    case T_COPY:
                    case T_COUNT:
                    case T_COUNT_BIG:
                    case T_CREATION:
                    case T_CREATOR:
                    case T_CS:
                    case T_CURRENT:
                    case T_CURRENT_SCHEMA:
                    case T_CURSOR:
                    case T_DATABASE:
                    case T_DATA:
                    case T_DATE:
                    case T_DATETIME:
                    case T_DAY:
                    case T_DAYS:
                    case T_DEC:
                    case T_DECIMAL:
                    case T_DECLARE:
                    case T_DEFAULT:
                    case T_DEFERRED:
                    case T_DEFINED:
                    case T_DEFINER:
                    case T_DEFINITION:
                    case T_DELETE:
                    case T_DELIMITED:
                    case T_DELIMITER:
                    case T_DESC:
                    case T_DESCRIBE:
                    case T_DIAGNOSTICS:
                    case T_DIR:
                    case T_DIRECTORY:
                    case T_DISTINCT:
                    case T_DISTRIBUTE:
                    case T_DO:
                    case T_DOUBLE:
                    case T_DOWNLOAD:
                    case T_DROP:
                    case T_DYNAMIC:
                    case T_ENABLE:
                    case T_ENGINE:
                    case T_ESCAPED:
                    case T_EXCEPT:
                    case T_EXEC:
                    case T_EXECUTE:
                    case T_EXCEPTION:
                    case T_EXCLUSIVE:
                    case T_EXISTS:
                    case T_EXIT:
                    case T_FALLBACK:
                    case T_FALSE:
                    case T_FETCH:
                    case T_FIELDS:
                    case T_FILE:
                    case T_FILES:
                    case T_FLOAT:
                    case T_FOR:
                    case T_FOREIGN:
                    case T_FORMAT:
                    case T_FOUND:
                    case T_FROM:
                    case T_FULL:
                    case T_FUNCTION:
                    case T_GET:
                    case T_GLOBAL:
                    case T_GO:
                    case T_GRANT:
                    case T_GROUP:
                    case T_HANDLER:
                    case T_HASH:
                    case T_HAVING:
                    case T_HOST:
                    case T_IDENTITY:
                    case T_IF:
                    case T_IGNORE:
                    case T_IMMEDIATE:
                    case T_IN:
                    case T_INCLUDE:
                    case T_INDEX:
                    case T_INITRANS:
                    case T_INNER:
                    case T_INOUT:
                    case T_INSERT:
                    case T_INT:
                    case T_INT2:
                    case T_INT4:
                    case T_INT8:
                    case T_INTEGER:
                    case T_INTERSECT:
                    case T_INTERVAL:
                    case T_INTO:
                    case T_INVOKER:
                    case T_IS:
                    case T_ISOPEN:
                    case T_ITEMS:
                    case T_JOIN:
                    case T_KEEP:
                    case T_KEY:
                    case T_KEYS:
                    case T_LANGUAGE:
                    case T_LEAVE:
                    case T_LEFT:
                    case T_LIKE:
                    case T_LIMIT:
                    case T_LINES:
                    case T_LOCAL:
                    case T_LOCATION:
                    case T_LOCATOR:
                    case T_LOCATORS:
                    case T_LOCKS:
                    case T_LOG:
                    case T_LOGGED:
                    case T_LOGGING:
                    case T_LOOP:
                    case T_MAP:
                    case T_MATCHED:
                    case T_MAX:
                    case T_MAXTRANS:
                    case T_MERGE:
                    case T_MESSAGE_TEXT:
                    case T_MICROSECOND:
                    case T_MICROSECONDS:
                    case T_MIN:
                    case T_MULTISET:
                    case T_NCHAR:
                    case T_NEW:
                    case T_NVARCHAR:
                    case T_NO:
                    case T_NOCOUNT:
                    case T_NOCOMPRESS:
                    case T_NOLOGGING:
                    case T_NONE:
                    case T_NOT:
                    case T_NOTFOUND:
                    case T_NUMERIC:
                    case T_NUMBER:
                    case T_OBJECT:
                    case T_OFF:
                    case T_ON:
                    case T_ONLY:
                    case T_OPEN:
                    case T_OR:
                    case T_ORDER:
                    case T_OUT:
                    case T_OUTER:
                    case T_OVER:
                    case T_OVERWRITE:
                    case T_OWNER:
                    case T_PACKAGE:
                    case T_PARTITION:
                    case T_PCTFREE:
                    case T_PCTUSED:
                    case T_PRECISION:
                    case T_PRESERVE:
                    case T_PRIMARY:
                    case T_PRINT:
                    case T_PROC:
                    case T_PROCEDURE:
                    case T_QUALIFY:
                    case T_QUERY_BAND:
                    case T_QUIT:
                    case T_QUOTED_IDENTIFIER:
                    case T_RAISE:
                    case T_REAL:
                    case T_REFERENCES:
                    case T_REGEXP:
                    case T_REPLACE:
                    case T_RESIGNAL:
                    case T_RESTRICT:
                    case T_RESULT:
                    case T_RESULT_SET_LOCATOR:
                    case T_RETURN:
                    case T_RETURNS:
                    case T_REVERSE:
                    case T_RIGHT:
                    case T_RLIKE:
                    case T_ROLE:
                    case T_ROLLBACK:
                    case T_ROW:
                    case T_ROWS:
                    case T_ROW_COUNT:
                    case T_RR:
                    case T_RS:
                    case T_PWD:
                    case T_TRIM:
                    case T_SCHEMA:
                    case T_SECOND:
                    case T_SECONDS:
                    case T_SECURITY:
                    case T_SEGMENT:
                    case T_SEL:
                    case T_SELECT:
                    case T_SET:
                    case T_SESSION:
                    case T_SESSIONS:
                    case T_SETS:
                    case T_SIGNAL:
                    case T_SIMPLE_DOUBLE:
                    case T_SIMPLE_FLOAT:
                    case T_SMALLDATETIME:
                    case T_SMALLINT:
                    case T_SQL:
                    case T_SQLEXCEPTION:
                    case T_SQLINSERT:
                    case T_SQLSTATE:
                    case T_SQLWARNING:
                    case T_STATS:
                    case T_STATISTICS:
                    case T_STEP:
                    case T_STORAGE:
                    case T_STORE:
                    case T_STORED:
                    case T_STRING:
                    case T_SUBDIR:
                    case T_SUBSTRING:
                    case T_SUM:
                    case T_SUMMARY:
                    case T_SYS_REFCURSOR:
                    case T_TABLE:
                    case T_TABLESPACE:
                    case T_TEMPORARY:
                    case T_TERMINATED:
                    case T_TEXTIMAGE_ON:
                    case T_THEN:
                    case T_TIMESTAMP:
                    case T_TITLE:
                    case T_TO:
                    case T_TOP:
                    case T_TRANSACTION:
                    case T_TRUE:
                    case T_TRUNCATE:
                    case T_UNIQUE:
                    case T_UPDATE:
                    case T_UR:
                    case T_USE:
                    case T_USING:
                    case T_VALUE:
                    case T_VALUES:
                    case T_VAR:
                    case T_VARCHAR:
                    case T_VARCHAR2:
                    case T_VARYING:
                    case T_VOLATILE:
                    case T_WHILE:
                    case T_WITH:
                    case T_WITHOUT:
                    case T_WORK:
                    case T_XACT_ABORT:
                    case T_XML:
                    case T_YES:
                    case T_ACTIVITY_COUNT:
                    case T_CUME_DIST:
                    case T_CURRENT_DATE:
                    case T_CURRENT_TIME:
                    case T_PI:
                    case T_CURRENT_TIMESTAMP:
                    case T_CURRENT_USER:
                    case T_DENSE_RANK:
                    case T_FIRST_VALUE:
                    case T_LAG:
                    case T_LAST_VALUE:
                    case T_LEAD:
                    case T_PART_COUNT:
                    case T_PART_LOC:
                    case T_RANK:
                    case T_ROW_NUMBER:
                    case T_STDEV:
                    case T_SYSDATE:
                    case T_VARIANCE:
                    case T_USER:
                    case T_SUB:
                    case L_ID: {
                        setState(1116);
                        tableName();
                        setState(1118);
                        _errHandler.sync(this);
                        switch (getInterpreter().adaptivePredict(_input, 133, _ctx)) {
                            case 1: {
                                setState(1117);
                                fromClause();
                            }
                                break;
                        }
                    }
                        break;
                    case T_OPEN_P: {
                        setState(1120);
                        match(T_OPEN_P);
                        setState(1121);
                        selectStmt();
                        setState(1122);
                        match(T_CLOSE_P);
                    }
                        break;
                    default:
                        throw new NoViableAltException(this);
                }
                setState(1130);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 136, _ctx)) {
                    case 1: {
                        setState(1127);
                        _errHandler.sync(this);
                        switch (getInterpreter().adaptivePredict(_input, 135, _ctx)) {
                            case 1: {
                                setState(1126);
                                match(T_AS);
                            }
                                break;
                        }
                        setState(1129);
                        ident();
                    }
                        break;
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class UpdateUpsertContext extends ParserRuleContext {
        public TerminalNode T_ELSE() {
            return getToken(StartDBSqlParser.T_ELSE, 0);
        }

        public InsertStmtContext insertStmt() {
            return getRuleContext(InsertStmtContext.class, 0);
        }

        public UpdateUpsertContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_updateUpsert;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitUpdateUpsert(this);
            else return visitor.visitChildren(this);
        }
    }

    public final UpdateUpsertContext updateUpsert() throws RecognitionException {
        UpdateUpsertContext _localctx = new UpdateUpsertContext(_ctx, getState());
        enterRule(_localctx, 160, RULE_updateUpsert);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1132);
                match(T_ELSE);
                setState(1133);
                insertStmt();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class DeleteStmtContext extends ParserRuleContext {
        public TerminalNode T_DELETE() {
            return getToken(StartDBSqlParser.T_DELETE, 0);
        }

        public TableNameContext tableName() {
            return getRuleContext(TableNameContext.class, 0);
        }

        public TerminalNode T_FROM() {
            return getToken(StartDBSqlParser.T_FROM, 0);
        }

        public DeleteAliasContext deleteAlias() {
            return getRuleContext(DeleteAliasContext.class, 0);
        }

        public WhereClauseContext whereClause() {
            return getRuleContext(WhereClauseContext.class, 0);
        }

        public TerminalNode T_ALL() {
            return getToken(StartDBSqlParser.T_ALL, 0);
        }

        public DeleteStmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_deleteStmt;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitDeleteStmt(this);
            else return visitor.visitChildren(this);
        }
    }

    public final DeleteStmtContext deleteStmt() throws RecognitionException {
        DeleteStmtContext _localctx = new DeleteStmtContext(_ctx, getState());
        enterRule(_localctx, 162, RULE_deleteStmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1135);
                match(T_DELETE);
                setState(1137);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 137, _ctx)) {
                    case 1: {
                        setState(1136);
                        match(T_FROM);
                    }
                        break;
                }
                setState(1139);
                tableName();
                setState(1141);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 138, _ctx)) {
                    case 1: {
                        setState(1140);
                        deleteAlias();
                    }
                        break;
                }
                setState(1145);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case T_WHERE: {
                        setState(1143);
                        whereClause();
                    }
                        break;
                    case T_ALL: {
                        setState(1144);
                        match(T_ALL);
                    }
                        break;
                    case EOF:
                    case T_SEMICOLON:
                        break;
                    default:
                        break;
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class DeleteAliasContext extends ParserRuleContext {
        public IdentContext ident() {
            return getRuleContext(IdentContext.class, 0);
        }

        public TerminalNode T_AS() {
            return getToken(StartDBSqlParser.T_AS, 0);
        }

        public DeleteAliasContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_deleteAlias;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitDeleteAlias(this);
            else return visitor.visitChildren(this);
        }
    }

    public final DeleteAliasContext deleteAlias() throws RecognitionException {
        DeleteAliasContext _localctx = new DeleteAliasContext(_ctx, getState());
        enterRule(_localctx, 164, RULE_deleteAlias);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1147);
                if (!(!_input.LT(1).getText().equalsIgnoreCase("ALL")))
                    throw new FailedPredicateException(
                        this,
                        "!_input.LT(1).getText().equalsIgnoreCase(\"ALL\")"
                    );
                setState(1149);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 140, _ctx)) {
                    case 1: {
                        setState(1148);
                        match(T_AS);
                    }
                        break;
                }
                setState(1151);
                ident();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class DescribeStmtContext extends ParserRuleContext {
        public UserDotDbDotTableContext userDotDbDotTable() {
            return getRuleContext(UserDotDbDotTableContext.class, 0);
        }

        public TerminalNode T_DESCRIBE() {
            return getToken(StartDBSqlParser.T_DESCRIBE, 0);
        }

        public TerminalNode T_DESC() {
            return getToken(StartDBSqlParser.T_DESC, 0);
        }

        public TerminalNode T_TABLE() {
            return getToken(StartDBSqlParser.T_TABLE, 0);
        }

        public TerminalNode T_VIEW() {
            return getToken(StartDBSqlParser.T_VIEW, 0);
        }

        public DescribeStmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_describeStmt;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitDescribeStmt(this);
            else return visitor.visitChildren(this);
        }
    }

    public final DescribeStmtContext describeStmt() throws RecognitionException {
        DescribeStmtContext _localctx = new DescribeStmtContext(_ctx, getState());
        enterRule(_localctx, 166, RULE_describeStmt);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1153);
                _la = _input.LA(1);
                if (!(_la == T_DESC || _la == T_DESCRIBE)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
                setState(1155);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_TABLE || _la == T_VIEW) {
                    {
                        setState(1154);
                        _la = _input.LA(1);
                        if (!(_la == T_TABLE || _la == T_VIEW)) {
                            _errHandler.recoverInline(this);
                        } else {
                            if (_input.LA(1) == Token.EOF) matchedEOF = true;
                            _errHandler.reportMatch(this);
                            consume();
                        }
                    }
                }

                setState(1157);
                userDotDbDotTable();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class BoolExprContext extends ParserRuleContext {
        public TerminalNode T_OPEN_P() {
            return getToken(StartDBSqlParser.T_OPEN_P, 0);
        }

        public List<BoolExprContext> boolExpr() {
            return getRuleContexts(BoolExprContext.class);
        }

        public BoolExprContext boolExpr(int i) {
            return getRuleContext(BoolExprContext.class, i);
        }

        public TerminalNode T_CLOSE_P() {
            return getToken(StartDBSqlParser.T_CLOSE_P, 0);
        }

        public TerminalNode T_NOT() {
            return getToken(StartDBSqlParser.T_NOT, 0);
        }

        public BoolExprAtomContext boolExprAtom() {
            return getRuleContext(BoolExprAtomContext.class, 0);
        }

        public BoolExprLogicalOperatorContext boolExprLogicalOperator() {
            return getRuleContext(BoolExprLogicalOperatorContext.class, 0);
        }

        public BoolExprContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_boolExpr;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitBoolExpr(this);
            else return visitor.visitChildren(this);
        }
    }

    public final BoolExprContext boolExpr() throws RecognitionException {
        return boolExpr(0);
    }

    private BoolExprContext boolExpr(int _p) throws RecognitionException {
        ParserRuleContext _parentctx = _ctx;
        int _parentState = getState();
        BoolExprContext _localctx = new BoolExprContext(_ctx, _parentState);
        BoolExprContext _prevctx = _localctx;
        int _startState = 168;
        enterRecursionRule(_localctx, 168, RULE_boolExpr, _p);
        int _la;
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(1168);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 143, _ctx)) {
                    case 1: {
                        setState(1161);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        if (_la == T_NOT) {
                            {
                                setState(1160);
                                match(T_NOT);
                            }
                        }

                        setState(1163);
                        match(T_OPEN_P);
                        setState(1164);
                        boolExpr(0);
                        setState(1165);
                        match(T_CLOSE_P);
                    }
                        break;
                    case 2: {
                        setState(1167);
                        boolExprAtom();
                    }
                        break;
                }
                _ctx.stop = _input.LT(-1);
                setState(1176);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 144, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        if (_parseListeners != null) triggerExitRuleEvent();
                        _prevctx = _localctx;
                        {
                            {
                                _localctx = new BoolExprContext(_parentctx, _parentState);
                                pushNewRecursionContext(_localctx, _startState, RULE_boolExpr);
                                setState(1170);
                                if (!(precpred(_ctx, 2))) throw new FailedPredicateException(
                                    this,
                                    "precpred(_ctx, 2)"
                                );
                                setState(1171);
                                boolExprLogicalOperator();
                                setState(1172);
                                boolExpr(3);
                            }
                        }
                    }
                    setState(1178);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 144, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            unrollRecursionContexts(_parentctx);
        }
        return _localctx;
    }

    public static class BoolExprAtomContext extends ParserRuleContext {
        public BoolExprUnaryContext boolExprUnary() {
            return getRuleContext(BoolExprUnaryContext.class, 0);
        }

        public BoolExprBinaryContext boolExprBinary() {
            return getRuleContext(BoolExprBinaryContext.class, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public BoolExprAtomContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_boolExprAtom;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitBoolExprAtom(this);
            else return visitor.visitChildren(this);
        }
    }

    public final BoolExprAtomContext boolExprAtom() throws RecognitionException {
        BoolExprAtomContext _localctx = new BoolExprAtomContext(_ctx, getState());
        enterRule(_localctx, 170, RULE_boolExprAtom);
        try {
            setState(1182);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 145, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1); {
                    setState(1179);
                    boolExprUnary();
                }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2); {
                    setState(1180);
                    boolExprBinary();
                }
                    break;
                case 3:
                    enterOuterAlt(_localctx, 3); {
                    setState(1181);
                    expr(0);
                }
                    break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class BoolExprUnaryContext extends ParserRuleContext {
        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode T_IS() {
            return getToken(StartDBSqlParser.T_IS, 0);
        }

        public TerminalNode T_NULL() {
            return getToken(StartDBSqlParser.T_NULL, 0);
        }

        public TerminalNode T_NOT() {
            return getToken(StartDBSqlParser.T_NOT, 0);
        }

        public TerminalNode T_BETWEEN() {
            return getToken(StartDBSqlParser.T_BETWEEN, 0);
        }

        public TerminalNode T_AND() {
            return getToken(StartDBSqlParser.T_AND, 0);
        }

        public TerminalNode T_EXISTS() {
            return getToken(StartDBSqlParser.T_EXISTS, 0);
        }

        public TerminalNode T_OPEN_P() {
            return getToken(StartDBSqlParser.T_OPEN_P, 0);
        }

        public SelectStmtContext selectStmt() {
            return getRuleContext(SelectStmtContext.class, 0);
        }

        public TerminalNode T_CLOSE_P() {
            return getToken(StartDBSqlParser.T_CLOSE_P, 0);
        }

        public BoolExprSingleInContext boolExprSingleIn() {
            return getRuleContext(BoolExprSingleInContext.class, 0);
        }

        public BoolExprMultiInContext boolExprMultiIn() {
            return getRuleContext(BoolExprMultiInContext.class, 0);
        }

        public BoolExprUnaryContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_boolExprUnary;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitBoolExprUnary(this);
            else return visitor.visitChildren(this);
        }
    }

    public final BoolExprUnaryContext boolExprUnary() throws RecognitionException {
        BoolExprUnaryContext _localctx = new BoolExprUnaryContext(_ctx, getState());
        enterRule(_localctx, 172, RULE_boolExprUnary);
        int _la;
        try {
            setState(1207);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 148, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1); {
                    setState(1184);
                    expr(0);
                    setState(1185);
                    match(T_IS);
                    setState(1187);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_NOT) {
                        {
                            setState(1186);
                            match(T_NOT);
                        }
                    }

                    setState(1189);
                    match(T_NULL);
                }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2); {
                    setState(1191);
                    expr(0);
                    setState(1192);
                    match(T_BETWEEN);
                    setState(1193);
                    expr(0);
                    setState(1194);
                    match(T_AND);
                    setState(1195);
                    expr(0);
                }
                    break;
                case 3:
                    enterOuterAlt(_localctx, 3); {
                    setState(1198);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_NOT) {
                        {
                            setState(1197);
                            match(T_NOT);
                        }
                    }

                    setState(1200);
                    match(T_EXISTS);
                    setState(1201);
                    match(T_OPEN_P);
                    setState(1202);
                    selectStmt();
                    setState(1203);
                    match(T_CLOSE_P);
                }
                    break;
                case 4:
                    enterOuterAlt(_localctx, 4); {
                    setState(1205);
                    boolExprSingleIn();
                }
                    break;
                case 5:
                    enterOuterAlt(_localctx, 5); {
                    setState(1206);
                    boolExprMultiIn();
                }
                    break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class BoolExprSingleInContext extends ParserRuleContext {
        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode T_IN() {
            return getToken(StartDBSqlParser.T_IN, 0);
        }

        public TerminalNode T_OPEN_P() {
            return getToken(StartDBSqlParser.T_OPEN_P, 0);
        }

        public TerminalNode T_CLOSE_P() {
            return getToken(StartDBSqlParser.T_CLOSE_P, 0);
        }

        public SelectStmtContext selectStmt() {
            return getRuleContext(SelectStmtContext.class, 0);
        }

        public TerminalNode T_NOT() {
            return getToken(StartDBSqlParser.T_NOT, 0);
        }

        public List<TerminalNode> T_COMMA() {
            return getTokens(StartDBSqlParser.T_COMMA);
        }

        public TerminalNode T_COMMA(int i) {
            return getToken(StartDBSqlParser.T_COMMA, i);
        }

        public BoolExprSingleInContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_boolExprSingleIn;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitBoolExprSingleIn(this);
            else return visitor.visitChildren(this);
        }
    }

    public final BoolExprSingleInContext boolExprSingleIn() throws RecognitionException {
        BoolExprSingleInContext _localctx = new BoolExprSingleInContext(_ctx, getState());
        enterRule(_localctx, 174, RULE_boolExprSingleIn);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1209);
                expr(0);
                setState(1211);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_NOT) {
                    {
                        setState(1210);
                        match(T_NOT);
                    }
                }

                setState(1213);
                match(T_IN);
                setState(1214);
                match(T_OPEN_P);
                setState(1224);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 151, _ctx)) {
                    case 1: {
                        {
                            setState(1215);
                            expr(0);
                            setState(1220);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                            while (_la == T_COMMA) {
                                {
                                    {
                                        setState(1216);
                                        match(T_COMMA);
                                        setState(1217);
                                        expr(0);
                                    }
                                }
                                setState(1222);
                                _errHandler.sync(this);
                                _la = _input.LA(1);
                            }
                        }
                    }
                        break;
                    case 2: {
                        setState(1223);
                        selectStmt();
                    }
                        break;
                }
                setState(1226);
                match(T_CLOSE_P);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class BoolExprMultiInContext extends ParserRuleContext {
        public List<TerminalNode> T_OPEN_P() {
            return getTokens(StartDBSqlParser.T_OPEN_P);
        }

        public TerminalNode T_OPEN_P(int i) {
            return getToken(StartDBSqlParser.T_OPEN_P, i);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public List<TerminalNode> T_CLOSE_P() {
            return getTokens(StartDBSqlParser.T_CLOSE_P);
        }

        public TerminalNode T_CLOSE_P(int i) {
            return getToken(StartDBSqlParser.T_CLOSE_P, i);
        }

        public TerminalNode T_IN() {
            return getToken(StartDBSqlParser.T_IN, 0);
        }

        public SelectStmtContext selectStmt() {
            return getRuleContext(SelectStmtContext.class, 0);
        }

        public List<TerminalNode> T_COMMA() {
            return getTokens(StartDBSqlParser.T_COMMA);
        }

        public TerminalNode T_COMMA(int i) {
            return getToken(StartDBSqlParser.T_COMMA, i);
        }

        public TerminalNode T_NOT() {
            return getToken(StartDBSqlParser.T_NOT, 0);
        }

        public BoolExprMultiInContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_boolExprMultiIn;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitBoolExprMultiIn(this);
            else return visitor.visitChildren(this);
        }
    }

    public final BoolExprMultiInContext boolExprMultiIn() throws RecognitionException {
        BoolExprMultiInContext _localctx = new BoolExprMultiInContext(_ctx, getState());
        enterRule(_localctx, 176, RULE_boolExprMultiIn);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1228);
                match(T_OPEN_P);
                setState(1229);
                expr(0);
                setState(1234);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T_COMMA) {
                    {
                        {
                            setState(1230);
                            match(T_COMMA);
                            setState(1231);
                            expr(0);
                        }
                    }
                    setState(1236);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(1237);
                match(T_CLOSE_P);
                setState(1239);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_NOT) {
                    {
                        setState(1238);
                        match(T_NOT);
                    }
                }

                setState(1241);
                match(T_IN);
                setState(1242);
                match(T_OPEN_P);
                setState(1243);
                selectStmt();
                setState(1244);
                match(T_CLOSE_P);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class BoolExprBinaryContext extends ParserRuleContext {
        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public BoolExprBinaryOperatorContext boolExprBinaryOperator() {
            return getRuleContext(BoolExprBinaryOperatorContext.class, 0);
        }

        public BoolExprBinaryContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_boolExprBinary;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitBoolExprBinary(this);
            else return visitor.visitChildren(this);
        }
    }

    public final BoolExprBinaryContext boolExprBinary() throws RecognitionException {
        BoolExprBinaryContext _localctx = new BoolExprBinaryContext(_ctx, getState());
        enterRule(_localctx, 178, RULE_boolExprBinary);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1246);
                expr(0);
                setState(1247);
                boolExprBinaryOperator();
                setState(1248);
                expr(0);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class BoolExprLogicalOperatorContext extends ParserRuleContext {
        public TerminalNode T_AND() {
            return getToken(StartDBSqlParser.T_AND, 0);
        }

        public TerminalNode T_OR() {
            return getToken(StartDBSqlParser.T_OR, 0);
        }

        public BoolExprLogicalOperatorContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_boolExprLogicalOperator;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitBoolExprLogicalOperator(this);
            else return visitor.visitChildren(this);
        }
    }

    public final BoolExprLogicalOperatorContext boolExprLogicalOperator()
        throws RecognitionException {
        BoolExprLogicalOperatorContext _localctx = new BoolExprLogicalOperatorContext(
            _ctx,
            getState()
        );
        enterRule(_localctx, 180, RULE_boolExprLogicalOperator);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1250);
                _la = _input.LA(1);
                if (!(_la == T_AND || _la == T_OR)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class BoolExprBinaryOperatorContext extends ParserRuleContext {
        public TerminalNode T_EQUAL() {
            return getToken(StartDBSqlParser.T_EQUAL, 0);
        }

        public TerminalNode T_EQUAL2() {
            return getToken(StartDBSqlParser.T_EQUAL2, 0);
        }

        public TerminalNode T_NOTEQUAL() {
            return getToken(StartDBSqlParser.T_NOTEQUAL, 0);
        }

        public TerminalNode T_NOTEQUAL2() {
            return getToken(StartDBSqlParser.T_NOTEQUAL2, 0);
        }

        public TerminalNode T_LESS() {
            return getToken(StartDBSqlParser.T_LESS, 0);
        }

        public TerminalNode T_LESSEQUAL() {
            return getToken(StartDBSqlParser.T_LESSEQUAL, 0);
        }

        public TerminalNode T_GREATER() {
            return getToken(StartDBSqlParser.T_GREATER, 0);
        }

        public TerminalNode T_GREATEREQUAL() {
            return getToken(StartDBSqlParser.T_GREATEREQUAL, 0);
        }

        public TerminalNode T_LIKE() {
            return getToken(StartDBSqlParser.T_LIKE, 0);
        }

        public TerminalNode T_RLIKE() {
            return getToken(StartDBSqlParser.T_RLIKE, 0);
        }

        public TerminalNode T_REGEXP() {
            return getToken(StartDBSqlParser.T_REGEXP, 0);
        }

        public TerminalNode T_NOT() {
            return getToken(StartDBSqlParser.T_NOT, 0);
        }

        public BoolExprBinaryOperatorContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_boolExprBinaryOperator;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitBoolExprBinaryOperator(this);
            else return visitor.visitChildren(this);
        }
    }

    public final BoolExprBinaryOperatorContext boolExprBinaryOperator()
        throws RecognitionException {
        BoolExprBinaryOperatorContext _localctx = new BoolExprBinaryOperatorContext(
            _ctx,
            getState()
        );
        enterRule(_localctx, 182, RULE_boolExprBinaryOperator);
        int _la;
        try {
            setState(1264);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T_EQUAL:
                    enterOuterAlt(_localctx, 1); {
                    setState(1252);
                    match(T_EQUAL);
                }
                    break;
                case T_EQUAL2:
                    enterOuterAlt(_localctx, 2); {
                    setState(1253);
                    match(T_EQUAL2);
                }
                    break;
                case T_NOTEQUAL:
                    enterOuterAlt(_localctx, 3); {
                    setState(1254);
                    match(T_NOTEQUAL);
                }
                    break;
                case T_NOTEQUAL2:
                    enterOuterAlt(_localctx, 4); {
                    setState(1255);
                    match(T_NOTEQUAL2);
                }
                    break;
                case T_LESS:
                    enterOuterAlt(_localctx, 5); {
                    setState(1256);
                    match(T_LESS);
                }
                    break;
                case T_LESSEQUAL:
                    enterOuterAlt(_localctx, 6); {
                    setState(1257);
                    match(T_LESSEQUAL);
                }
                    break;
                case T_GREATER:
                    enterOuterAlt(_localctx, 7); {
                    setState(1258);
                    match(T_GREATER);
                }
                    break;
                case T_GREATEREQUAL:
                    enterOuterAlt(_localctx, 8); {
                    setState(1259);
                    match(T_GREATEREQUAL);
                }
                    break;
                case T_LIKE:
                case T_NOT:
                case T_REGEXP:
                case T_RLIKE:
                    enterOuterAlt(_localctx, 9); {
                    setState(1261);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_NOT) {
                        {
                            setState(1260);
                            match(T_NOT);
                        }
                    }

                    setState(1263);
                    _la = _input.LA(1);
                    if (!(_la == T_LIKE || _la == T_REGEXP || _la == T_RLIKE)) {
                        _errHandler.recoverInline(this);
                    } else {
                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                        _errHandler.reportMatch(this);
                        consume();
                    }
                }
                    break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ExprContext extends ParserRuleContext {
        public TerminalNode T_OPEN_P() {
            return getToken(StartDBSqlParser.T_OPEN_P, 0);
        }

        public SelectStmtContext selectStmt() {
            return getRuleContext(SelectStmtContext.class, 0);
        }

        public TerminalNode T_CLOSE_P() {
            return getToken(StartDBSqlParser.T_CLOSE_P, 0);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public ExprIntervalContext exprInterval() {
            return getRuleContext(ExprIntervalContext.class, 0);
        }

        public ExprConcatContext exprConcat() {
            return getRuleContext(ExprConcatContext.class, 0);
        }

        public ExprCaseContext exprCase() {
            return getRuleContext(ExprCaseContext.class, 0);
        }

        public ExprCursorAttributeContext exprCursorAttribute() {
            return getRuleContext(ExprCursorAttributeContext.class, 0);
        }

        public ExprAggWindowFuncContext exprAggWindowFunc() {
            return getRuleContext(ExprAggWindowFuncContext.class, 0);
        }

        public ExprSpecFuncContext exprSpecFunc() {
            return getRuleContext(ExprSpecFuncContext.class, 0);
        }

        public ExprFuncContext exprFunc() {
            return getRuleContext(ExprFuncContext.class, 0);
        }

        public ExprAtomContext exprAtom() {
            return getRuleContext(ExprAtomContext.class, 0);
        }

        public TerminalNode T_MUL() {
            return getToken(StartDBSqlParser.T_MUL, 0);
        }

        public TerminalNode T_DIV() {
            return getToken(StartDBSqlParser.T_DIV, 0);
        }

        public TerminalNode T_ADD() {
            return getToken(StartDBSqlParser.T_ADD, 0);
        }

        public TerminalNode T_SUB() {
            return getToken(StartDBSqlParser.T_SUB, 0);
        }

        public IntervalItemContext intervalItem() {
            return getRuleContext(IntervalItemContext.class, 0);
        }

        public ExprContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_expr;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitExpr(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ExprContext expr() throws RecognitionException {
        return expr(0);
    }

    private ExprContext expr(int _p) throws RecognitionException {
        ParserRuleContext _parentctx = _ctx;
        int _parentState = getState();
        ExprContext _localctx = new ExprContext(_ctx, _parentState);
        ExprContext _prevctx = _localctx;
        int _startState = 184;
        enterRecursionRule(_localctx, 184, RULE_expr, _p);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(1283);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 156, _ctx)) {
                    case 1: {
                        setState(1267);
                        match(T_OPEN_P);
                        setState(1268);
                        selectStmt();
                        setState(1269);
                        match(T_CLOSE_P);
                    }
                        break;
                    case 2: {
                        setState(1271);
                        match(T_OPEN_P);
                        setState(1272);
                        expr(0);
                        setState(1273);
                        match(T_CLOSE_P);
                    }
                        break;
                    case 3: {
                        setState(1275);
                        exprInterval();
                    }
                        break;
                    case 4: {
                        setState(1276);
                        exprConcat();
                    }
                        break;
                    case 5: {
                        setState(1277);
                        exprCase();
                    }
                        break;
                    case 6: {
                        setState(1278);
                        exprCursorAttribute();
                    }
                        break;
                    case 7: {
                        setState(1279);
                        exprAggWindowFunc();
                    }
                        break;
                    case 8: {
                        setState(1280);
                        exprSpecFunc();
                    }
                        break;
                    case 9: {
                        setState(1281);
                        exprFunc();
                    }
                        break;
                    case 10: {
                        setState(1282);
                        exprAtom();
                    }
                        break;
                }
                _ctx.stop = _input.LT(-1);
                setState(1301);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 158, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        if (_parseListeners != null) triggerExitRuleEvent();
                        _prevctx = _localctx;
                        {
                            setState(1299);
                            _errHandler.sync(this);
                            switch (getInterpreter().adaptivePredict(_input, 157, _ctx)) {
                                case 1: {
                                    _localctx = new ExprContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr);
                                    setState(1285);
                                    if (!(precpred(_ctx, 14))) throw new FailedPredicateException(
                                        this,
                                        "precpred(_ctx, 14)"
                                    );
                                    setState(1286);
                                    match(T_MUL);
                                    setState(1287);
                                    expr(15);
                                }
                                    break;
                                case 2: {
                                    _localctx = new ExprContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr);
                                    setState(1288);
                                    if (!(precpred(_ctx, 13))) throw new FailedPredicateException(
                                        this,
                                        "precpred(_ctx, 13)"
                                    );
                                    setState(1289);
                                    match(T_DIV);
                                    setState(1290);
                                    expr(14);
                                }
                                    break;
                                case 3: {
                                    _localctx = new ExprContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr);
                                    setState(1291);
                                    if (!(precpred(_ctx, 12))) throw new FailedPredicateException(
                                        this,
                                        "precpred(_ctx, 12)"
                                    );
                                    setState(1292);
                                    match(T_ADD);
                                    setState(1293);
                                    expr(13);
                                }
                                    break;
                                case 4: {
                                    _localctx = new ExprContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr);
                                    setState(1294);
                                    if (!(precpred(_ctx, 11))) throw new FailedPredicateException(
                                        this,
                                        "precpred(_ctx, 11)"
                                    );
                                    setState(1295);
                                    match(T_SUB);
                                    setState(1296);
                                    expr(12);
                                }
                                    break;
                                case 5: {
                                    _localctx = new ExprContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr);
                                    setState(1297);
                                    if (!(precpred(_ctx, 15))) throw new FailedPredicateException(
                                        this,
                                        "precpred(_ctx, 15)"
                                    );
                                    setState(1298);
                                    intervalItem();
                                }
                                    break;
                            }
                        }
                    }
                    setState(1303);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 158, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            unrollRecursionContexts(_parentctx);
        }
        return _localctx;
    }

    public static class ExprAtomContext extends ParserRuleContext {
        public DateLiteralContext dateLiteral() {
            return getRuleContext(DateLiteralContext.class, 0);
        }

        public TimestampLiteralContext timestampLiteral() {
            return getRuleContext(TimestampLiteralContext.class, 0);
        }

        public BoolLiteralContext boolLiteral() {
            return getRuleContext(BoolLiteralContext.class, 0);
        }

        public IdentContext ident() {
            return getRuleContext(IdentContext.class, 0);
        }

        public StringContext string() {
            return getRuleContext(StringContext.class, 0);
        }

        public DecNumberContext decNumber() {
            return getRuleContext(DecNumberContext.class, 0);
        }

        public IntNumberContext intNumber() {
            return getRuleContext(IntNumberContext.class, 0);
        }

        public NullConstContext nullConst() {
            return getRuleContext(NullConstContext.class, 0);
        }

        public ExprAtomContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_exprAtom;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitExprAtom(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ExprAtomContext exprAtom() throws RecognitionException {
        ExprAtomContext _localctx = new ExprAtomContext(_ctx, getState());
        enterRule(_localctx, 186, RULE_exprAtom);
        try {
            setState(1312);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 159, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1); {
                    setState(1304);
                    dateLiteral();
                }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2); {
                    setState(1305);
                    timestampLiteral();
                }
                    break;
                case 3:
                    enterOuterAlt(_localctx, 3); {
                    setState(1306);
                    boolLiteral();
                }
                    break;
                case 4:
                    enterOuterAlt(_localctx, 4); {
                    setState(1307);
                    ident();
                }
                    break;
                case 5:
                    enterOuterAlt(_localctx, 5); {
                    setState(1308);
                    string();
                }
                    break;
                case 6:
                    enterOuterAlt(_localctx, 6); {
                    setState(1309);
                    decNumber();
                }
                    break;
                case 7:
                    enterOuterAlt(_localctx, 7); {
                    setState(1310);
                    intNumber();
                }
                    break;
                case 8:
                    enterOuterAlt(_localctx, 8); {
                    setState(1311);
                    nullConst();
                }
                    break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ExprIntervalContext extends ParserRuleContext {
        public TerminalNode T_INTERVAL() {
            return getToken(StartDBSqlParser.T_INTERVAL, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public IntervalItemContext intervalItem() {
            return getRuleContext(IntervalItemContext.class, 0);
        }

        public ExprIntervalContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_exprInterval;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitExprInterval(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ExprIntervalContext exprInterval() throws RecognitionException {
        ExprIntervalContext _localctx = new ExprIntervalContext(_ctx, getState());
        enterRule(_localctx, 188, RULE_exprInterval);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1314);
                match(T_INTERVAL);
                setState(1315);
                expr(0);
                setState(1316);
                intervalItem();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class IntervalItemContext extends ParserRuleContext {
        public TerminalNode T_DAY() {
            return getToken(StartDBSqlParser.T_DAY, 0);
        }

        public TerminalNode T_DAYS() {
            return getToken(StartDBSqlParser.T_DAYS, 0);
        }

        public TerminalNode T_MICROSECOND() {
            return getToken(StartDBSqlParser.T_MICROSECOND, 0);
        }

        public TerminalNode T_MICROSECONDS() {
            return getToken(StartDBSqlParser.T_MICROSECONDS, 0);
        }

        public TerminalNode T_SECOND() {
            return getToken(StartDBSqlParser.T_SECOND, 0);
        }

        public TerminalNode T_SECONDS() {
            return getToken(StartDBSqlParser.T_SECONDS, 0);
        }

        public IntervalItemContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_intervalItem;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitIntervalItem(this);
            else return visitor.visitChildren(this);
        }
    }

    public final IntervalItemContext intervalItem() throws RecognitionException {
        IntervalItemContext _localctx = new IntervalItemContext(_ctx, getState());
        enterRule(_localctx, 190, RULE_intervalItem);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1318);
                _la = _input.LA(1);
                if (!(_la == T_DAY
                    || _la == T_DAYS
                    || _la == T_MICROSECOND
                    || _la == T_MICROSECONDS
                    || _la == T_SECOND
                    || _la == T_SECONDS)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ExprConcatContext extends ParserRuleContext {
        public List<ExprConcatItemContext> exprConcatItem() {
            return getRuleContexts(ExprConcatItemContext.class);
        }

        public ExprConcatItemContext exprConcatItem(int i) {
            return getRuleContext(ExprConcatItemContext.class, i);
        }

        public List<TerminalNode> T_PIPE() {
            return getTokens(StartDBSqlParser.T_PIPE);
        }

        public TerminalNode T_PIPE(int i) {
            return getToken(StartDBSqlParser.T_PIPE, i);
        }

        public List<TerminalNode> T_CONCAT() {
            return getTokens(StartDBSqlParser.T_CONCAT);
        }

        public TerminalNode T_CONCAT(int i) {
            return getToken(StartDBSqlParser.T_CONCAT, i);
        }

        public ExprConcatContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_exprConcat;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitExprConcat(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ExprConcatContext exprConcat() throws RecognitionException {
        ExprConcatContext _localctx = new ExprConcatContext(_ctx, getState());
        enterRule(_localctx, 192, RULE_exprConcat);
        int _la;
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(1320);
                exprConcatItem();
                setState(1321);
                _la = _input.LA(1);
                if (!(_la == T_CONCAT || _la == T_PIPE)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
                setState(1322);
                exprConcatItem();
                setState(1327);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 160, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            {
                                setState(1323);
                                _la = _input.LA(1);
                                if (!(_la == T_CONCAT || _la == T_PIPE)) {
                                    _errHandler.recoverInline(this);
                                } else {
                                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                    _errHandler.reportMatch(this);
                                    consume();
                                }
                                setState(1324);
                                exprConcatItem();
                            }
                        }
                    }
                    setState(1329);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 160, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ExprConcatItemContext extends ParserRuleContext {
        public TerminalNode T_OPEN_P() {
            return getToken(StartDBSqlParser.T_OPEN_P, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode T_CLOSE_P() {
            return getToken(StartDBSqlParser.T_CLOSE_P, 0);
        }

        public ExprCaseContext exprCase() {
            return getRuleContext(ExprCaseContext.class, 0);
        }

        public ExprAggWindowFuncContext exprAggWindowFunc() {
            return getRuleContext(ExprAggWindowFuncContext.class, 0);
        }

        public ExprSpecFuncContext exprSpecFunc() {
            return getRuleContext(ExprSpecFuncContext.class, 0);
        }

        public ExprFuncContext exprFunc() {
            return getRuleContext(ExprFuncContext.class, 0);
        }

        public ExprAtomContext exprAtom() {
            return getRuleContext(ExprAtomContext.class, 0);
        }

        public ExprConcatItemContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_exprConcatItem;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitExprConcatItem(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ExprConcatItemContext exprConcatItem() throws RecognitionException {
        ExprConcatItemContext _localctx = new ExprConcatItemContext(_ctx, getState());
        enterRule(_localctx, 194, RULE_exprConcatItem);
        try {
            setState(1339);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 161, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1); {
                    setState(1330);
                    match(T_OPEN_P);
                    setState(1331);
                    expr(0);
                    setState(1332);
                    match(T_CLOSE_P);
                }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2); {
                    setState(1334);
                    exprCase();
                }
                    break;
                case 3:
                    enterOuterAlt(_localctx, 3); {
                    setState(1335);
                    exprAggWindowFunc();
                }
                    break;
                case 4:
                    enterOuterAlt(_localctx, 4); {
                    setState(1336);
                    exprSpecFunc();
                }
                    break;
                case 5:
                    enterOuterAlt(_localctx, 5); {
                    setState(1337);
                    exprFunc();
                }
                    break;
                case 6:
                    enterOuterAlt(_localctx, 6); {
                    setState(1338);
                    exprAtom();
                }
                    break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ExprCaseContext extends ParserRuleContext {
        public ExprCaseSimpleContext exprCaseSimple() {
            return getRuleContext(ExprCaseSimpleContext.class, 0);
        }

        public ExprCaseSearchedContext exprCaseSearched() {
            return getRuleContext(ExprCaseSearchedContext.class, 0);
        }

        public ExprCaseContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_exprCase;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitExprCase(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ExprCaseContext exprCase() throws RecognitionException {
        ExprCaseContext _localctx = new ExprCaseContext(_ctx, getState());
        enterRule(_localctx, 196, RULE_exprCase);
        try {
            setState(1343);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 162, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1); {
                    setState(1341);
                    exprCaseSimple();
                }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2); {
                    setState(1342);
                    exprCaseSearched();
                }
                    break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ExprCaseSimpleContext extends ParserRuleContext {
        public TerminalNode T_CASE() {
            return getToken(StartDBSqlParser.T_CASE, 0);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode T_END() {
            return getToken(StartDBSqlParser.T_END, 0);
        }

        public List<TerminalNode> T_WHEN() {
            return getTokens(StartDBSqlParser.T_WHEN);
        }

        public TerminalNode T_WHEN(int i) {
            return getToken(StartDBSqlParser.T_WHEN, i);
        }

        public List<TerminalNode> T_THEN() {
            return getTokens(StartDBSqlParser.T_THEN);
        }

        public TerminalNode T_THEN(int i) {
            return getToken(StartDBSqlParser.T_THEN, i);
        }

        public TerminalNode T_ELSE() {
            return getToken(StartDBSqlParser.T_ELSE, 0);
        }

        public ExprCaseSimpleContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_exprCaseSimple;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitExprCaseSimple(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ExprCaseSimpleContext exprCaseSimple() throws RecognitionException {
        ExprCaseSimpleContext _localctx = new ExprCaseSimpleContext(_ctx, getState());
        enterRule(_localctx, 198, RULE_exprCaseSimple);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1345);
                match(T_CASE);
                setState(1346);
                expr(0);
                setState(1352);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        {
                            setState(1347);
                            match(T_WHEN);
                            setState(1348);
                            expr(0);
                            setState(1349);
                            match(T_THEN);
                            setState(1350);
                            expr(0);
                        }
                    }
                    setState(1354);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                } while (_la == T_WHEN);
                setState(1358);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_ELSE) {
                    {
                        setState(1356);
                        match(T_ELSE);
                        setState(1357);
                        expr(0);
                    }
                }

                setState(1360);
                match(T_END);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ExprCaseSearchedContext extends ParserRuleContext {
        public TerminalNode T_CASE() {
            return getToken(StartDBSqlParser.T_CASE, 0);
        }

        public TerminalNode T_END() {
            return getToken(StartDBSqlParser.T_END, 0);
        }

        public List<ExprCaseItemContext> exprCaseItem() {
            return getRuleContexts(ExprCaseItemContext.class);
        }

        public ExprCaseItemContext exprCaseItem(int i) {
            return getRuleContext(ExprCaseItemContext.class, i);
        }

        public TerminalNode T_ELSE() {
            return getToken(StartDBSqlParser.T_ELSE, 0);
        }

        public BoolExprContext boolExpr() {
            return getRuleContext(BoolExprContext.class, 0);
        }

        public ExprCaseSearchedContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_exprCaseSearched;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitExprCaseSearched(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ExprCaseSearchedContext exprCaseSearched() throws RecognitionException {
        ExprCaseSearchedContext _localctx = new ExprCaseSearchedContext(_ctx, getState());
        enterRule(_localctx, 200, RULE_exprCaseSearched);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1362);
                match(T_CASE);
                setState(1364);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        {
                            setState(1363);
                            exprCaseItem();
                        }
                    }
                    setState(1366);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                } while (_la == T_WHEN);
                setState(1370);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_ELSE) {
                    {
                        setState(1368);
                        match(T_ELSE);
                        setState(1369);
                        boolExpr(0);
                    }
                }

                setState(1372);
                match(T_END);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ExprCaseItemContext extends ParserRuleContext {
        public BoolExprContext whenExpr;
        public BoolExprContext thenExpr;

        public TerminalNode T_WHEN() {
            return getToken(StartDBSqlParser.T_WHEN, 0);
        }

        public TerminalNode T_THEN() {
            return getToken(StartDBSqlParser.T_THEN, 0);
        }

        public List<BoolExprContext> boolExpr() {
            return getRuleContexts(BoolExprContext.class);
        }

        public BoolExprContext boolExpr(int i) {
            return getRuleContext(BoolExprContext.class, i);
        }

        public ExprCaseItemContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_exprCaseItem;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitExprCaseItem(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ExprCaseItemContext exprCaseItem() throws RecognitionException {
        ExprCaseItemContext _localctx = new ExprCaseItemContext(_ctx, getState());
        enterRule(_localctx, 202, RULE_exprCaseItem);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1374);
                match(T_WHEN);
                setState(1375);
                ((ExprCaseItemContext) _localctx).whenExpr = boolExpr(0);
                setState(1376);
                match(T_THEN);
                setState(1377);
                ((ExprCaseItemContext) _localctx).thenExpr = boolExpr(0);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ExprCursorAttributeContext extends ParserRuleContext {
        public IdentContext ident() {
            return getRuleContext(IdentContext.class, 0);
        }

        public TerminalNode T_ISOPEN() {
            return getToken(StartDBSqlParser.T_ISOPEN, 0);
        }

        public TerminalNode T_FOUND() {
            return getToken(StartDBSqlParser.T_FOUND, 0);
        }

        public TerminalNode T_NOTFOUND() {
            return getToken(StartDBSqlParser.T_NOTFOUND, 0);
        }

        public ExprCursorAttributeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_exprCursorAttribute;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitExprCursorAttribute(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ExprCursorAttributeContext exprCursorAttribute() throws RecognitionException {
        ExprCursorAttributeContext _localctx = new ExprCursorAttributeContext(_ctx, getState());
        enterRule(_localctx, 204, RULE_exprCursorAttribute);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1379);
                ident();
                setState(1380);
                match(T__0);
                setState(1381);
                _la = _input.LA(1);
                if (!(_la == T_FOUND || _la == T_ISOPEN || _la == T_NOTFOUND)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ExprAggWindowFuncContext extends ParserRuleContext {
        public TerminalNode T_AVG() {
            return getToken(StartDBSqlParser.T_AVG, 0);
        }

        public TerminalNode T_OPEN_P() {
            return getToken(StartDBSqlParser.T_OPEN_P, 0);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode T_CLOSE_P() {
            return getToken(StartDBSqlParser.T_CLOSE_P, 0);
        }

        public ExprFuncAllDistinctContext exprFuncAllDistinct() {
            return getRuleContext(ExprFuncAllDistinctContext.class, 0);
        }

        public ExprFuncOverClauseContext exprFuncOverClause() {
            return getRuleContext(ExprFuncOverClauseContext.class, 0);
        }

        public TerminalNode T_COUNT() {
            return getToken(StartDBSqlParser.T_COUNT, 0);
        }

        public TerminalNode T_MUL() {
            return getToken(StartDBSqlParser.T_MUL, 0);
        }

        public TerminalNode T_COUNT_BIG() {
            return getToken(StartDBSqlParser.T_COUNT_BIG, 0);
        }

        public TerminalNode T_CUME_DIST() {
            return getToken(StartDBSqlParser.T_CUME_DIST, 0);
        }

        public TerminalNode T_DENSE_RANK() {
            return getToken(StartDBSqlParser.T_DENSE_RANK, 0);
        }

        public TerminalNode T_FIRST_VALUE() {
            return getToken(StartDBSqlParser.T_FIRST_VALUE, 0);
        }

        public TerminalNode T_LAG() {
            return getToken(StartDBSqlParser.T_LAG, 0);
        }

        public List<TerminalNode> T_COMMA() {
            return getTokens(StartDBSqlParser.T_COMMA);
        }

        public TerminalNode T_COMMA(int i) {
            return getToken(StartDBSqlParser.T_COMMA, i);
        }

        public TerminalNode T_LAST_VALUE() {
            return getToken(StartDBSqlParser.T_LAST_VALUE, 0);
        }

        public TerminalNode T_LEAD() {
            return getToken(StartDBSqlParser.T_LEAD, 0);
        }

        public TerminalNode T_MAX() {
            return getToken(StartDBSqlParser.T_MAX, 0);
        }

        public TerminalNode T_MIN() {
            return getToken(StartDBSqlParser.T_MIN, 0);
        }

        public TerminalNode T_RANK() {
            return getToken(StartDBSqlParser.T_RANK, 0);
        }

        public TerminalNode T_ROW_NUMBER() {
            return getToken(StartDBSqlParser.T_ROW_NUMBER, 0);
        }

        public TerminalNode T_STDEV() {
            return getToken(StartDBSqlParser.T_STDEV, 0);
        }

        public TerminalNode T_SUM() {
            return getToken(StartDBSqlParser.T_SUM, 0);
        }

        public TerminalNode T_VAR() {
            return getToken(StartDBSqlParser.T_VAR, 0);
        }

        public TerminalNode T_VARIANCE() {
            return getToken(StartDBSqlParser.T_VARIANCE, 0);
        }

        public ExprAggWindowFuncContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_exprAggWindowFunc;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitExprAggWindowFunc(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ExprAggWindowFuncContext exprAggWindowFunc() throws RecognitionException {
        ExprAggWindowFuncContext _localctx = new ExprAggWindowFuncContext(_ctx, getState());
        enterRule(_localctx, 206, RULE_exprAggWindowFunc);
        int _la;
        try {
            setState(1535);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T_AVG:
                    enterOuterAlt(_localctx, 1); {
                    setState(1383);
                    match(T_AVG);
                    setState(1384);
                    match(T_OPEN_P);
                    setState(1386);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 167, _ctx)) {
                        case 1: {
                            setState(1385);
                            exprFuncAllDistinct();
                        }
                            break;
                    }
                    setState(1388);
                    expr(0);
                    setState(1389);
                    match(T_CLOSE_P);
                    setState(1391);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 168, _ctx)) {
                        case 1: {
                            setState(1390);
                            exprFuncOverClause();
                        }
                            break;
                    }
                }
                    break;
                case T_COUNT:
                    enterOuterAlt(_localctx, 2); {
                    setState(1393);
                    match(T_COUNT);
                    setState(1394);
                    match(T_OPEN_P);
                    setState(1400);
                    _errHandler.sync(this);
                    switch (_input.LA(1)) {
                        case T_ACTION:
                        case T_ADD2:
                        case T_ALL:
                        case T_ALLOCATE:
                        case T_ALTER:
                        case T_AND:
                        case T_ANSI_NULLS:
                        case T_ANSI_PADDING:
                        case T_AS:
                        case T_ASC:
                        case T_ASSOCIATE:
                        case T_AT:
                        case T_AVG:
                        case T_BATCHSIZE:
                        case T_BEGIN:
                        case T_BETWEEN:
                        case T_BIGINT:
                        case T_BINARY_DOUBLE:
                        case T_BINARY_FLOAT:
                        case T_BIT:
                        case T_BODY:
                        case T_BREAK:
                        case T_BY:
                        case T_BYTE:
                        case T_CALL:
                        case T_CALLER:
                        case T_CASCADE:
                        case T_CASE:
                        case T_CASESPECIFIC:
                        case T_CAST:
                        case T_CHAR:
                        case T_CHARACTER:
                        case T_CHARSET:
                        case T_CLIENT:
                        case T_CLOSE:
                        case T_CLUSTERED:
                        case T_CMP:
                        case T_COLLECT:
                        case T_COLLECTION:
                        case T_COLUMN:
                        case T_COMMENT:
                        case T_CONSTANT:
                        case T_COMMIT:
                        case T_COMPRESS:
                        case T_CONCAT:
                        case T_CONDITION:
                        case T_CONSTRAINT:
                        case T_CONTINUE:
                        case T_COPY:
                        case T_COUNT:
                        case T_COUNT_BIG:
                        case T_CREATION:
                        case T_CREATOR:
                        case T_CS:
                        case T_CURRENT:
                        case T_CURRENT_SCHEMA:
                        case T_CURSOR:
                        case T_DATABASE:
                        case T_DATA:
                        case T_DATE:
                        case T_DATETIME:
                        case T_DAY:
                        case T_DAYS:
                        case T_DEC:
                        case T_DECIMAL:
                        case T_DECLARE:
                        case T_DEFAULT:
                        case T_DEFERRED:
                        case T_DEFINED:
                        case T_DEFINER:
                        case T_DEFINITION:
                        case T_DELETE:
                        case T_DELIMITED:
                        case T_DELIMITER:
                        case T_DESC:
                        case T_DESCRIBE:
                        case T_DIAGNOSTICS:
                        case T_DIR:
                        case T_DIRECTORY:
                        case T_DISTINCT:
                        case T_DISTRIBUTE:
                        case T_DO:
                        case T_DOUBLE:
                        case T_DOWNLOAD:
                        case T_DROP:
                        case T_DYNAMIC:
                        case T_ENABLE:
                        case T_ENGINE:
                        case T_ESCAPED:
                        case T_EXCEPT:
                        case T_EXEC:
                        case T_EXECUTE:
                        case T_EXCEPTION:
                        case T_EXCLUSIVE:
                        case T_EXISTS:
                        case T_EXIT:
                        case T_FALLBACK:
                        case T_FALSE:
                        case T_FETCH:
                        case T_FIELDS:
                        case T_FILE:
                        case T_FILES:
                        case T_FLOAT:
                        case T_FOR:
                        case T_FOREIGN:
                        case T_FORMAT:
                        case T_FOUND:
                        case T_FROM:
                        case T_FULL:
                        case T_FUNCTION:
                        case T_GET:
                        case T_GLOBAL:
                        case T_GO:
                        case T_GRANT:
                        case T_GROUP:
                        case T_HANDLER:
                        case T_HASH:
                        case T_HAVING:
                        case T_HOST:
                        case T_IDENTITY:
                        case T_IF:
                        case T_IGNORE:
                        case T_IMMEDIATE:
                        case T_IN:
                        case T_INCLUDE:
                        case T_INDEX:
                        case T_INITRANS:
                        case T_INNER:
                        case T_INOUT:
                        case T_INSERT:
                        case T_INT:
                        case T_INT2:
                        case T_INT4:
                        case T_INT8:
                        case T_INTEGER:
                        case T_INTERSECT:
                        case T_INTERVAL:
                        case T_INTO:
                        case T_INVOKER:
                        case T_IS:
                        case T_ISOPEN:
                        case T_ITEMS:
                        case T_JOIN:
                        case T_KEEP:
                        case T_KEY:
                        case T_KEYS:
                        case T_LANGUAGE:
                        case T_LEAVE:
                        case T_LEFT:
                        case T_LIKE:
                        case T_LIMIT:
                        case T_LINES:
                        case T_LOCAL:
                        case T_LOCATION:
                        case T_LOCATOR:
                        case T_LOCATORS:
                        case T_LOCKS:
                        case T_LOG:
                        case T_LOGGED:
                        case T_LOGGING:
                        case T_LOOP:
                        case T_MAP:
                        case T_MATCHED:
                        case T_MAX:
                        case T_MAXTRANS:
                        case T_MERGE:
                        case T_MESSAGE_TEXT:
                        case T_MICROSECOND:
                        case T_MICROSECONDS:
                        case T_MIN:
                        case T_MULTISET:
                        case T_NCHAR:
                        case T_NEW:
                        case T_NVARCHAR:
                        case T_NO:
                        case T_NOCOUNT:
                        case T_NOCOMPRESS:
                        case T_NOLOGGING:
                        case T_NONE:
                        case T_NOT:
                        case T_NOTFOUND:
                        case T_NULL:
                        case T_NUMERIC:
                        case T_NUMBER:
                        case T_OBJECT:
                        case T_OFF:
                        case T_ON:
                        case T_ONLY:
                        case T_OPEN:
                        case T_OR:
                        case T_ORDER:
                        case T_OUT:
                        case T_OUTER:
                        case T_OVER:
                        case T_OVERWRITE:
                        case T_OWNER:
                        case T_PACKAGE:
                        case T_PARTITION:
                        case T_PCTFREE:
                        case T_PCTUSED:
                        case T_PRECISION:
                        case T_PRESERVE:
                        case T_PRIMARY:
                        case T_PRINT:
                        case T_PROC:
                        case T_PROCEDURE:
                        case T_QUALIFY:
                        case T_QUERY_BAND:
                        case T_QUIT:
                        case T_QUOTED_IDENTIFIER:
                        case T_RAISE:
                        case T_REAL:
                        case T_REFERENCES:
                        case T_REGEXP:
                        case T_REPLACE:
                        case T_RESIGNAL:
                        case T_RESTRICT:
                        case T_RESULT:
                        case T_RESULT_SET_LOCATOR:
                        case T_RETURN:
                        case T_RETURNS:
                        case T_REVERSE:
                        case T_RIGHT:
                        case T_RLIKE:
                        case T_ROLE:
                        case T_ROLLBACK:
                        case T_ROW:
                        case T_ROWS:
                        case T_ROW_COUNT:
                        case T_RR:
                        case T_RS:
                        case T_PWD:
                        case T_TRIM:
                        case T_SCHEMA:
                        case T_SECOND:
                        case T_SECONDS:
                        case T_SECURITY:
                        case T_SEGMENT:
                        case T_SEL:
                        case T_SELECT:
                        case T_SET:
                        case T_SESSION:
                        case T_SESSIONS:
                        case T_SETS:
                        case T_SIGNAL:
                        case T_SIMPLE_DOUBLE:
                        case T_SIMPLE_FLOAT:
                        case T_SMALLDATETIME:
                        case T_SMALLINT:
                        case T_SQL:
                        case T_SQLEXCEPTION:
                        case T_SQLINSERT:
                        case T_SQLSTATE:
                        case T_SQLWARNING:
                        case T_STATS:
                        case T_STATISTICS:
                        case T_STEP:
                        case T_STORAGE:
                        case T_STORE:
                        case T_STORED:
                        case T_STRING:
                        case T_SUBDIR:
                        case T_SUBSTRING:
                        case T_SUM:
                        case T_SUMMARY:
                        case T_SYS_REFCURSOR:
                        case T_TABLE:
                        case T_TABLESPACE:
                        case T_TEMPORARY:
                        case T_TERMINATED:
                        case T_TEXTIMAGE_ON:
                        case T_THEN:
                        case T_TIMESTAMP:
                        case T_TITLE:
                        case T_TO:
                        case T_TOP:
                        case T_TRANSACTION:
                        case T_TRUE:
                        case T_TRUNCATE:
                        case T_UNIQUE:
                        case T_UPDATE:
                        case T_UR:
                        case T_USE:
                        case T_USING:
                        case T_VALUE:
                        case T_VALUES:
                        case T_VAR:
                        case T_VARCHAR:
                        case T_VARCHAR2:
                        case T_VARYING:
                        case T_VOLATILE:
                        case T_WHILE:
                        case T_WITH:
                        case T_WITHOUT:
                        case T_WORK:
                        case T_XACT_ABORT:
                        case T_XML:
                        case T_YES:
                        case T_ACTIVITY_COUNT:
                        case T_CUME_DIST:
                        case T_CURRENT_DATE:
                        case T_CURRENT_TIME:
                        case T_PI:
                        case T_CURRENT_TIMESTAMP:
                        case T_CURRENT_USER:
                        case T_DENSE_RANK:
                        case T_FIRST_VALUE:
                        case T_LAG:
                        case T_LAST_VALUE:
                        case T_LEAD:
                        case T_MAX_PART_STRING:
                        case T_MIN_PART_STRING:
                        case T_MAX_PART_INT:
                        case T_MIN_PART_INT:
                        case T_MAX_PART_DATE:
                        case T_MIN_PART_DATE:
                        case T_PART_COUNT:
                        case T_PART_LOC:
                        case T_RANK:
                        case T_ROW_NUMBER:
                        case T_STDEV:
                        case T_SYSDATE:
                        case T_VARIANCE:
                        case T_USER:
                        case T_ADD:
                        case T_OPEN_P:
                        case T_SUB:
                        case L_ID:
                        case L_S_STRING:
                        case L_D_STRING:
                        case L_INT:
                        case L_DEC: {
                            {
                                setState(1396);
                                _errHandler.sync(this);
                                switch (getInterpreter().adaptivePredict(_input, 169, _ctx)) {
                                    case 1: {
                                        setState(1395);
                                        exprFuncAllDistinct();
                                    }
                                        break;
                                }
                                setState(1398);
                                expr(0);
                            }
                        }
                            break;
                        case T_MUL: {
                            setState(1399);
                            match(T_MUL);
                        }
                            break;
                        default:
                            throw new NoViableAltException(this);
                    }
                    setState(1402);
                    match(T_CLOSE_P);
                    setState(1404);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 171, _ctx)) {
                        case 1: {
                            setState(1403);
                            exprFuncOverClause();
                        }
                            break;
                    }
                }
                    break;
                case T_COUNT_BIG:
                    enterOuterAlt(_localctx, 3); {
                    setState(1406);
                    match(T_COUNT_BIG);
                    setState(1407);
                    match(T_OPEN_P);
                    setState(1413);
                    _errHandler.sync(this);
                    switch (_input.LA(1)) {
                        case T_ACTION:
                        case T_ADD2:
                        case T_ALL:
                        case T_ALLOCATE:
                        case T_ALTER:
                        case T_AND:
                        case T_ANSI_NULLS:
                        case T_ANSI_PADDING:
                        case T_AS:
                        case T_ASC:
                        case T_ASSOCIATE:
                        case T_AT:
                        case T_AVG:
                        case T_BATCHSIZE:
                        case T_BEGIN:
                        case T_BETWEEN:
                        case T_BIGINT:
                        case T_BINARY_DOUBLE:
                        case T_BINARY_FLOAT:
                        case T_BIT:
                        case T_BODY:
                        case T_BREAK:
                        case T_BY:
                        case T_BYTE:
                        case T_CALL:
                        case T_CALLER:
                        case T_CASCADE:
                        case T_CASE:
                        case T_CASESPECIFIC:
                        case T_CAST:
                        case T_CHAR:
                        case T_CHARACTER:
                        case T_CHARSET:
                        case T_CLIENT:
                        case T_CLOSE:
                        case T_CLUSTERED:
                        case T_CMP:
                        case T_COLLECT:
                        case T_COLLECTION:
                        case T_COLUMN:
                        case T_COMMENT:
                        case T_CONSTANT:
                        case T_COMMIT:
                        case T_COMPRESS:
                        case T_CONCAT:
                        case T_CONDITION:
                        case T_CONSTRAINT:
                        case T_CONTINUE:
                        case T_COPY:
                        case T_COUNT:
                        case T_COUNT_BIG:
                        case T_CREATION:
                        case T_CREATOR:
                        case T_CS:
                        case T_CURRENT:
                        case T_CURRENT_SCHEMA:
                        case T_CURSOR:
                        case T_DATABASE:
                        case T_DATA:
                        case T_DATE:
                        case T_DATETIME:
                        case T_DAY:
                        case T_DAYS:
                        case T_DEC:
                        case T_DECIMAL:
                        case T_DECLARE:
                        case T_DEFAULT:
                        case T_DEFERRED:
                        case T_DEFINED:
                        case T_DEFINER:
                        case T_DEFINITION:
                        case T_DELETE:
                        case T_DELIMITED:
                        case T_DELIMITER:
                        case T_DESC:
                        case T_DESCRIBE:
                        case T_DIAGNOSTICS:
                        case T_DIR:
                        case T_DIRECTORY:
                        case T_DISTINCT:
                        case T_DISTRIBUTE:
                        case T_DO:
                        case T_DOUBLE:
                        case T_DOWNLOAD:
                        case T_DROP:
                        case T_DYNAMIC:
                        case T_ENABLE:
                        case T_ENGINE:
                        case T_ESCAPED:
                        case T_EXCEPT:
                        case T_EXEC:
                        case T_EXECUTE:
                        case T_EXCEPTION:
                        case T_EXCLUSIVE:
                        case T_EXISTS:
                        case T_EXIT:
                        case T_FALLBACK:
                        case T_FALSE:
                        case T_FETCH:
                        case T_FIELDS:
                        case T_FILE:
                        case T_FILES:
                        case T_FLOAT:
                        case T_FOR:
                        case T_FOREIGN:
                        case T_FORMAT:
                        case T_FOUND:
                        case T_FROM:
                        case T_FULL:
                        case T_FUNCTION:
                        case T_GET:
                        case T_GLOBAL:
                        case T_GO:
                        case T_GRANT:
                        case T_GROUP:
                        case T_HANDLER:
                        case T_HASH:
                        case T_HAVING:
                        case T_HOST:
                        case T_IDENTITY:
                        case T_IF:
                        case T_IGNORE:
                        case T_IMMEDIATE:
                        case T_IN:
                        case T_INCLUDE:
                        case T_INDEX:
                        case T_INITRANS:
                        case T_INNER:
                        case T_INOUT:
                        case T_INSERT:
                        case T_INT:
                        case T_INT2:
                        case T_INT4:
                        case T_INT8:
                        case T_INTEGER:
                        case T_INTERSECT:
                        case T_INTERVAL:
                        case T_INTO:
                        case T_INVOKER:
                        case T_IS:
                        case T_ISOPEN:
                        case T_ITEMS:
                        case T_JOIN:
                        case T_KEEP:
                        case T_KEY:
                        case T_KEYS:
                        case T_LANGUAGE:
                        case T_LEAVE:
                        case T_LEFT:
                        case T_LIKE:
                        case T_LIMIT:
                        case T_LINES:
                        case T_LOCAL:
                        case T_LOCATION:
                        case T_LOCATOR:
                        case T_LOCATORS:
                        case T_LOCKS:
                        case T_LOG:
                        case T_LOGGED:
                        case T_LOGGING:
                        case T_LOOP:
                        case T_MAP:
                        case T_MATCHED:
                        case T_MAX:
                        case T_MAXTRANS:
                        case T_MERGE:
                        case T_MESSAGE_TEXT:
                        case T_MICROSECOND:
                        case T_MICROSECONDS:
                        case T_MIN:
                        case T_MULTISET:
                        case T_NCHAR:
                        case T_NEW:
                        case T_NVARCHAR:
                        case T_NO:
                        case T_NOCOUNT:
                        case T_NOCOMPRESS:
                        case T_NOLOGGING:
                        case T_NONE:
                        case T_NOT:
                        case T_NOTFOUND:
                        case T_NULL:
                        case T_NUMERIC:
                        case T_NUMBER:
                        case T_OBJECT:
                        case T_OFF:
                        case T_ON:
                        case T_ONLY:
                        case T_OPEN:
                        case T_OR:
                        case T_ORDER:
                        case T_OUT:
                        case T_OUTER:
                        case T_OVER:
                        case T_OVERWRITE:
                        case T_OWNER:
                        case T_PACKAGE:
                        case T_PARTITION:
                        case T_PCTFREE:
                        case T_PCTUSED:
                        case T_PRECISION:
                        case T_PRESERVE:
                        case T_PRIMARY:
                        case T_PRINT:
                        case T_PROC:
                        case T_PROCEDURE:
                        case T_QUALIFY:
                        case T_QUERY_BAND:
                        case T_QUIT:
                        case T_QUOTED_IDENTIFIER:
                        case T_RAISE:
                        case T_REAL:
                        case T_REFERENCES:
                        case T_REGEXP:
                        case T_REPLACE:
                        case T_RESIGNAL:
                        case T_RESTRICT:
                        case T_RESULT:
                        case T_RESULT_SET_LOCATOR:
                        case T_RETURN:
                        case T_RETURNS:
                        case T_REVERSE:
                        case T_RIGHT:
                        case T_RLIKE:
                        case T_ROLE:
                        case T_ROLLBACK:
                        case T_ROW:
                        case T_ROWS:
                        case T_ROW_COUNT:
                        case T_RR:
                        case T_RS:
                        case T_PWD:
                        case T_TRIM:
                        case T_SCHEMA:
                        case T_SECOND:
                        case T_SECONDS:
                        case T_SECURITY:
                        case T_SEGMENT:
                        case T_SEL:
                        case T_SELECT:
                        case T_SET:
                        case T_SESSION:
                        case T_SESSIONS:
                        case T_SETS:
                        case T_SIGNAL:
                        case T_SIMPLE_DOUBLE:
                        case T_SIMPLE_FLOAT:
                        case T_SMALLDATETIME:
                        case T_SMALLINT:
                        case T_SQL:
                        case T_SQLEXCEPTION:
                        case T_SQLINSERT:
                        case T_SQLSTATE:
                        case T_SQLWARNING:
                        case T_STATS:
                        case T_STATISTICS:
                        case T_STEP:
                        case T_STORAGE:
                        case T_STORE:
                        case T_STORED:
                        case T_STRING:
                        case T_SUBDIR:
                        case T_SUBSTRING:
                        case T_SUM:
                        case T_SUMMARY:
                        case T_SYS_REFCURSOR:
                        case T_TABLE:
                        case T_TABLESPACE:
                        case T_TEMPORARY:
                        case T_TERMINATED:
                        case T_TEXTIMAGE_ON:
                        case T_THEN:
                        case T_TIMESTAMP:
                        case T_TITLE:
                        case T_TO:
                        case T_TOP:
                        case T_TRANSACTION:
                        case T_TRUE:
                        case T_TRUNCATE:
                        case T_UNIQUE:
                        case T_UPDATE:
                        case T_UR:
                        case T_USE:
                        case T_USING:
                        case T_VALUE:
                        case T_VALUES:
                        case T_VAR:
                        case T_VARCHAR:
                        case T_VARCHAR2:
                        case T_VARYING:
                        case T_VOLATILE:
                        case T_WHILE:
                        case T_WITH:
                        case T_WITHOUT:
                        case T_WORK:
                        case T_XACT_ABORT:
                        case T_XML:
                        case T_YES:
                        case T_ACTIVITY_COUNT:
                        case T_CUME_DIST:
                        case T_CURRENT_DATE:
                        case T_CURRENT_TIME:
                        case T_PI:
                        case T_CURRENT_TIMESTAMP:
                        case T_CURRENT_USER:
                        case T_DENSE_RANK:
                        case T_FIRST_VALUE:
                        case T_LAG:
                        case T_LAST_VALUE:
                        case T_LEAD:
                        case T_MAX_PART_STRING:
                        case T_MIN_PART_STRING:
                        case T_MAX_PART_INT:
                        case T_MIN_PART_INT:
                        case T_MAX_PART_DATE:
                        case T_MIN_PART_DATE:
                        case T_PART_COUNT:
                        case T_PART_LOC:
                        case T_RANK:
                        case T_ROW_NUMBER:
                        case T_STDEV:
                        case T_SYSDATE:
                        case T_VARIANCE:
                        case T_USER:
                        case T_ADD:
                        case T_OPEN_P:
                        case T_SUB:
                        case L_ID:
                        case L_S_STRING:
                        case L_D_STRING:
                        case L_INT:
                        case L_DEC: {
                            {
                                setState(1409);
                                _errHandler.sync(this);
                                switch (getInterpreter().adaptivePredict(_input, 172, _ctx)) {
                                    case 1: {
                                        setState(1408);
                                        exprFuncAllDistinct();
                                    }
                                        break;
                                }
                                setState(1411);
                                expr(0);
                            }
                        }
                            break;
                        case T_MUL: {
                            setState(1412);
                            match(T_MUL);
                        }
                            break;
                        default:
                            throw new NoViableAltException(this);
                    }
                    setState(1415);
                    match(T_CLOSE_P);
                    setState(1417);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 174, _ctx)) {
                        case 1: {
                            setState(1416);
                            exprFuncOverClause();
                        }
                            break;
                    }
                }
                    break;
                case T_CUME_DIST:
                    enterOuterAlt(_localctx, 4); {
                    setState(1419);
                    match(T_CUME_DIST);
                    setState(1420);
                    match(T_OPEN_P);
                    setState(1421);
                    match(T_CLOSE_P);
                    setState(1422);
                    exprFuncOverClause();
                }
                    break;
                case T_DENSE_RANK:
                    enterOuterAlt(_localctx, 5); {
                    setState(1423);
                    match(T_DENSE_RANK);
                    setState(1424);
                    match(T_OPEN_P);
                    setState(1425);
                    match(T_CLOSE_P);
                    setState(1426);
                    exprFuncOverClause();
                }
                    break;
                case T_FIRST_VALUE:
                    enterOuterAlt(_localctx, 6); {
                    setState(1427);
                    match(T_FIRST_VALUE);
                    setState(1428);
                    match(T_OPEN_P);
                    setState(1429);
                    expr(0);
                    setState(1430);
                    match(T_CLOSE_P);
                    setState(1431);
                    exprFuncOverClause();
                }
                    break;
                case T_LAG:
                    enterOuterAlt(_localctx, 7); {
                    setState(1433);
                    match(T_LAG);
                    setState(1434);
                    match(T_OPEN_P);
                    setState(1435);
                    expr(0);
                    setState(1442);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_COMMA) {
                        {
                            setState(1436);
                            match(T_COMMA);
                            setState(1437);
                            expr(0);
                            setState(1440);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                            if (_la == T_COMMA) {
                                {
                                    setState(1438);
                                    match(T_COMMA);
                                    setState(1439);
                                    expr(0);
                                }
                            }

                        }
                    }

                    setState(1444);
                    match(T_CLOSE_P);
                    setState(1445);
                    exprFuncOverClause();
                }
                    break;
                case T_LAST_VALUE:
                    enterOuterAlt(_localctx, 8); {
                    setState(1447);
                    match(T_LAST_VALUE);
                    setState(1448);
                    match(T_OPEN_P);
                    setState(1449);
                    expr(0);
                    setState(1450);
                    match(T_CLOSE_P);
                    setState(1451);
                    exprFuncOverClause();
                }
                    break;
                case T_LEAD:
                    enterOuterAlt(_localctx, 9); {
                    setState(1453);
                    match(T_LEAD);
                    setState(1454);
                    match(T_OPEN_P);
                    setState(1455);
                    expr(0);
                    setState(1462);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_COMMA) {
                        {
                            setState(1456);
                            match(T_COMMA);
                            setState(1457);
                            expr(0);
                            setState(1460);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                            if (_la == T_COMMA) {
                                {
                                    setState(1458);
                                    match(T_COMMA);
                                    setState(1459);
                                    expr(0);
                                }
                            }

                        }
                    }

                    setState(1464);
                    match(T_CLOSE_P);
                    setState(1465);
                    exprFuncOverClause();
                }
                    break;
                case T_MAX:
                    enterOuterAlt(_localctx, 10); {
                    setState(1467);
                    match(T_MAX);
                    setState(1468);
                    match(T_OPEN_P);
                    setState(1470);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 179, _ctx)) {
                        case 1: {
                            setState(1469);
                            exprFuncAllDistinct();
                        }
                            break;
                    }
                    setState(1472);
                    expr(0);
                    setState(1473);
                    match(T_CLOSE_P);
                    setState(1475);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 180, _ctx)) {
                        case 1: {
                            setState(1474);
                            exprFuncOverClause();
                        }
                            break;
                    }
                }
                    break;
                case T_MIN:
                    enterOuterAlt(_localctx, 11); {
                    setState(1477);
                    match(T_MIN);
                    setState(1478);
                    match(T_OPEN_P);
                    setState(1480);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 181, _ctx)) {
                        case 1: {
                            setState(1479);
                            exprFuncAllDistinct();
                        }
                            break;
                    }
                    setState(1482);
                    expr(0);
                    setState(1483);
                    match(T_CLOSE_P);
                    setState(1485);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 182, _ctx)) {
                        case 1: {
                            setState(1484);
                            exprFuncOverClause();
                        }
                            break;
                    }
                }
                    break;
                case T_RANK:
                    enterOuterAlt(_localctx, 12); {
                    setState(1487);
                    match(T_RANK);
                    setState(1488);
                    match(T_OPEN_P);
                    setState(1489);
                    match(T_CLOSE_P);
                    setState(1490);
                    exprFuncOverClause();
                }
                    break;
                case T_ROW_NUMBER:
                    enterOuterAlt(_localctx, 13); {
                    setState(1491);
                    match(T_ROW_NUMBER);
                    setState(1492);
                    match(T_OPEN_P);
                    setState(1493);
                    match(T_CLOSE_P);
                    setState(1494);
                    exprFuncOverClause();
                }
                    break;
                case T_STDEV:
                    enterOuterAlt(_localctx, 14); {
                    setState(1495);
                    match(T_STDEV);
                    setState(1496);
                    match(T_OPEN_P);
                    setState(1498);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 183, _ctx)) {
                        case 1: {
                            setState(1497);
                            exprFuncAllDistinct();
                        }
                            break;
                    }
                    setState(1500);
                    expr(0);
                    setState(1501);
                    match(T_CLOSE_P);
                    setState(1503);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 184, _ctx)) {
                        case 1: {
                            setState(1502);
                            exprFuncOverClause();
                        }
                            break;
                    }
                }
                    break;
                case T_SUM:
                    enterOuterAlt(_localctx, 15); {
                    setState(1505);
                    match(T_SUM);
                    setState(1506);
                    match(T_OPEN_P);
                    setState(1508);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 185, _ctx)) {
                        case 1: {
                            setState(1507);
                            exprFuncAllDistinct();
                        }
                            break;
                    }
                    setState(1510);
                    expr(0);
                    setState(1511);
                    match(T_CLOSE_P);
                    setState(1513);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 186, _ctx)) {
                        case 1: {
                            setState(1512);
                            exprFuncOverClause();
                        }
                            break;
                    }
                }
                    break;
                case T_VAR:
                    enterOuterAlt(_localctx, 16); {
                    setState(1515);
                    match(T_VAR);
                    setState(1516);
                    match(T_OPEN_P);
                    setState(1518);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 187, _ctx)) {
                        case 1: {
                            setState(1517);
                            exprFuncAllDistinct();
                        }
                            break;
                    }
                    setState(1520);
                    expr(0);
                    setState(1521);
                    match(T_CLOSE_P);
                    setState(1523);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 188, _ctx)) {
                        case 1: {
                            setState(1522);
                            exprFuncOverClause();
                        }
                            break;
                    }
                }
                    break;
                case T_VARIANCE:
                    enterOuterAlt(_localctx, 17); {
                    setState(1525);
                    match(T_VARIANCE);
                    setState(1526);
                    match(T_OPEN_P);
                    setState(1528);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 189, _ctx)) {
                        case 1: {
                            setState(1527);
                            exprFuncAllDistinct();
                        }
                            break;
                    }
                    setState(1530);
                    expr(0);
                    setState(1531);
                    match(T_CLOSE_P);
                    setState(1533);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 190, _ctx)) {
                        case 1: {
                            setState(1532);
                            exprFuncOverClause();
                        }
                            break;
                    }
                }
                    break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ExprFuncAllDistinctContext extends ParserRuleContext {
        public TerminalNode T_ALL() {
            return getToken(StartDBSqlParser.T_ALL, 0);
        }

        public TerminalNode T_DISTINCT() {
            return getToken(StartDBSqlParser.T_DISTINCT, 0);
        }

        public ExprFuncAllDistinctContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_exprFuncAllDistinct;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitExprFuncAllDistinct(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ExprFuncAllDistinctContext exprFuncAllDistinct() throws RecognitionException {
        ExprFuncAllDistinctContext _localctx = new ExprFuncAllDistinctContext(_ctx, getState());
        enterRule(_localctx, 208, RULE_exprFuncAllDistinct);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1537);
                _la = _input.LA(1);
                if (!(_la == T_ALL || _la == T_DISTINCT)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ExprFuncOverClauseContext extends ParserRuleContext {
        public TerminalNode T_OVER() {
            return getToken(StartDBSqlParser.T_OVER, 0);
        }

        public TerminalNode T_OPEN_P() {
            return getToken(StartDBSqlParser.T_OPEN_P, 0);
        }

        public TerminalNode T_CLOSE_P() {
            return getToken(StartDBSqlParser.T_CLOSE_P, 0);
        }

        public ExprFuncPartitionByClauseContext exprFuncPartitionByClause() {
            return getRuleContext(ExprFuncPartitionByClauseContext.class, 0);
        }

        public OrderByClauseContext orderByClause() {
            return getRuleContext(OrderByClauseContext.class, 0);
        }

        public ExprFuncOverClauseContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_exprFuncOverClause;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitExprFuncOverClause(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ExprFuncOverClauseContext exprFuncOverClause() throws RecognitionException {
        ExprFuncOverClauseContext _localctx = new ExprFuncOverClauseContext(_ctx, getState());
        enterRule(_localctx, 210, RULE_exprFuncOverClause);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1539);
                match(T_OVER);
                setState(1540);
                match(T_OPEN_P);
                setState(1542);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_PARTITION) {
                    {
                        setState(1541);
                        exprFuncPartitionByClause();
                    }
                }

                setState(1545);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_ORDER) {
                    {
                        setState(1544);
                        orderByClause();
                    }
                }

                setState(1547);
                match(T_CLOSE_P);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ExprFuncPartitionByClauseContext extends ParserRuleContext {
        public TerminalNode T_PARTITION() {
            return getToken(StartDBSqlParser.T_PARTITION, 0);
        }

        public TerminalNode T_BY() {
            return getToken(StartDBSqlParser.T_BY, 0);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public List<TerminalNode> T_COMMA() {
            return getTokens(StartDBSqlParser.T_COMMA);
        }

        public TerminalNode T_COMMA(int i) {
            return getToken(StartDBSqlParser.T_COMMA, i);
        }

        public ExprFuncPartitionByClauseContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_exprFuncPartitionByClause;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitExprFuncPartitionByClause(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ExprFuncPartitionByClauseContext exprFuncPartitionByClause()
        throws RecognitionException {
        ExprFuncPartitionByClauseContext _localctx = new ExprFuncPartitionByClauseContext(
            _ctx,
            getState()
        );
        enterRule(_localctx, 212, RULE_exprFuncPartitionByClause);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1549);
                match(T_PARTITION);
                setState(1550);
                match(T_BY);
                setState(1551);
                expr(0);
                setState(1556);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T_COMMA) {
                    {
                        {
                            setState(1552);
                            match(T_COMMA);
                            setState(1553);
                            expr(0);
                        }
                    }
                    setState(1558);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ExprSpecFuncContext extends ParserRuleContext {
        public TerminalNode T_ACTIVITY_COUNT() {
            return getToken(StartDBSqlParser.T_ACTIVITY_COUNT, 0);
        }

        public TerminalNode T_CAST() {
            return getToken(StartDBSqlParser.T_CAST, 0);
        }

        public TerminalNode T_OPEN_P() {
            return getToken(StartDBSqlParser.T_OPEN_P, 0);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode T_AS() {
            return getToken(StartDBSqlParser.T_AS, 0);
        }

        public DtypeContext dtype() {
            return getRuleContext(DtypeContext.class, 0);
        }

        public TerminalNode T_CLOSE_P() {
            return getToken(StartDBSqlParser.T_CLOSE_P, 0);
        }

        public DtypeLenContext dtypeLen() {
            return getRuleContext(DtypeLenContext.class, 0);
        }

        public TerminalNode T_COUNT() {
            return getToken(StartDBSqlParser.T_COUNT, 0);
        }

        public TerminalNode T_MUL() {
            return getToken(StartDBSqlParser.T_MUL, 0);
        }

        public TerminalNode T_CURRENT_DATE() {
            return getToken(StartDBSqlParser.T_CURRENT_DATE, 0);
        }

        public TerminalNode T_CURRENT() {
            return getToken(StartDBSqlParser.T_CURRENT, 0);
        }

        public TerminalNode T_DATE() {
            return getToken(StartDBSqlParser.T_DATE, 0);
        }

        public TerminalNode T_CURRENT_TIME() {
            return getToken(StartDBSqlParser.T_CURRENT_TIME, 0);
        }

        public TerminalNode T_PI() {
            return getToken(StartDBSqlParser.T_PI, 0);
        }

        public TerminalNode T_CURRENT_TIMESTAMP() {
            return getToken(StartDBSqlParser.T_CURRENT_TIMESTAMP, 0);
        }

        public TerminalNode T_TIMESTAMP() {
            return getToken(StartDBSqlParser.T_TIMESTAMP, 0);
        }

        public TerminalNode T_CURRENT_USER() {
            return getToken(StartDBSqlParser.T_CURRENT_USER, 0);
        }

        public TerminalNode T_USER() {
            return getToken(StartDBSqlParser.T_USER, 0);
        }

        public TerminalNode T_MAX_PART_STRING() {
            return getToken(StartDBSqlParser.T_MAX_PART_STRING, 0);
        }

        public List<TerminalNode> T_COMMA() {
            return getTokens(StartDBSqlParser.T_COMMA);
        }

        public TerminalNode T_COMMA(int i) {
            return getToken(StartDBSqlParser.T_COMMA, i);
        }

        public List<TerminalNode> T_EQUAL() {
            return getTokens(StartDBSqlParser.T_EQUAL);
        }

        public TerminalNode T_EQUAL(int i) {
            return getToken(StartDBSqlParser.T_EQUAL, i);
        }

        public TerminalNode T_MIN_PART_STRING() {
            return getToken(StartDBSqlParser.T_MIN_PART_STRING, 0);
        }

        public TerminalNode T_MAX_PART_INT() {
            return getToken(StartDBSqlParser.T_MAX_PART_INT, 0);
        }

        public TerminalNode T_MIN_PART_INT() {
            return getToken(StartDBSqlParser.T_MIN_PART_INT, 0);
        }

        public TerminalNode T_MAX_PART_DATE() {
            return getToken(StartDBSqlParser.T_MAX_PART_DATE, 0);
        }

        public TerminalNode T_MIN_PART_DATE() {
            return getToken(StartDBSqlParser.T_MIN_PART_DATE, 0);
        }

        public TerminalNode T_PART_COUNT() {
            return getToken(StartDBSqlParser.T_PART_COUNT, 0);
        }

        public TerminalNode T_PART_LOC() {
            return getToken(StartDBSqlParser.T_PART_LOC, 0);
        }

        public TerminalNode T_SUBSTRING() {
            return getToken(StartDBSqlParser.T_SUBSTRING, 0);
        }

        public TerminalNode T_FROM() {
            return getToken(StartDBSqlParser.T_FROM, 0);
        }

        public TerminalNode T_FOR() {
            return getToken(StartDBSqlParser.T_FOR, 0);
        }

        public TerminalNode T_SYSDATE() {
            return getToken(StartDBSqlParser.T_SYSDATE, 0);
        }

        public ExprSpecFuncContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_exprSpecFunc;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitExprSpecFunc(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ExprSpecFuncContext exprSpecFunc() throws RecognitionException {
        ExprSpecFuncContext _localctx = new ExprSpecFuncContext(_ctx, getState());
        enterRule(_localctx, 214, RULE_exprSpecFunc);
        int _la;
        try {
            int _alt;
            setState(1756);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 215, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1); {
                    setState(1559);
                    match(T_ACTIVITY_COUNT);
                }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2); {
                    setState(1560);
                    match(T_CAST);
                    setState(1561);
                    match(T_OPEN_P);
                    setState(1562);
                    expr(0);
                    setState(1563);
                    match(T_AS);
                    setState(1564);
                    dtype();
                    setState(1566);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_OPEN_P) {
                        {
                            setState(1565);
                            dtypeLen();
                        }
                    }

                    setState(1568);
                    match(T_CLOSE_P);
                }
                    break;
                case 3:
                    enterOuterAlt(_localctx, 3); {
                    setState(1570);
                    match(T_COUNT);
                    setState(1571);
                    match(T_OPEN_P);
                    setState(1574);
                    _errHandler.sync(this);
                    switch (_input.LA(1)) {
                        case T_ACTION:
                        case T_ADD2:
                        case T_ALL:
                        case T_ALLOCATE:
                        case T_ALTER:
                        case T_AND:
                        case T_ANSI_NULLS:
                        case T_ANSI_PADDING:
                        case T_AS:
                        case T_ASC:
                        case T_ASSOCIATE:
                        case T_AT:
                        case T_AVG:
                        case T_BATCHSIZE:
                        case T_BEGIN:
                        case T_BETWEEN:
                        case T_BIGINT:
                        case T_BINARY_DOUBLE:
                        case T_BINARY_FLOAT:
                        case T_BIT:
                        case T_BODY:
                        case T_BREAK:
                        case T_BY:
                        case T_BYTE:
                        case T_CALL:
                        case T_CALLER:
                        case T_CASCADE:
                        case T_CASE:
                        case T_CASESPECIFIC:
                        case T_CAST:
                        case T_CHAR:
                        case T_CHARACTER:
                        case T_CHARSET:
                        case T_CLIENT:
                        case T_CLOSE:
                        case T_CLUSTERED:
                        case T_CMP:
                        case T_COLLECT:
                        case T_COLLECTION:
                        case T_COLUMN:
                        case T_COMMENT:
                        case T_CONSTANT:
                        case T_COMMIT:
                        case T_COMPRESS:
                        case T_CONCAT:
                        case T_CONDITION:
                        case T_CONSTRAINT:
                        case T_CONTINUE:
                        case T_COPY:
                        case T_COUNT:
                        case T_COUNT_BIG:
                        case T_CREATION:
                        case T_CREATOR:
                        case T_CS:
                        case T_CURRENT:
                        case T_CURRENT_SCHEMA:
                        case T_CURSOR:
                        case T_DATABASE:
                        case T_DATA:
                        case T_DATE:
                        case T_DATETIME:
                        case T_DAY:
                        case T_DAYS:
                        case T_DEC:
                        case T_DECIMAL:
                        case T_DECLARE:
                        case T_DEFAULT:
                        case T_DEFERRED:
                        case T_DEFINED:
                        case T_DEFINER:
                        case T_DEFINITION:
                        case T_DELETE:
                        case T_DELIMITED:
                        case T_DELIMITER:
                        case T_DESC:
                        case T_DESCRIBE:
                        case T_DIAGNOSTICS:
                        case T_DIR:
                        case T_DIRECTORY:
                        case T_DISTINCT:
                        case T_DISTRIBUTE:
                        case T_DO:
                        case T_DOUBLE:
                        case T_DOWNLOAD:
                        case T_DROP:
                        case T_DYNAMIC:
                        case T_ENABLE:
                        case T_ENGINE:
                        case T_ESCAPED:
                        case T_EXCEPT:
                        case T_EXEC:
                        case T_EXECUTE:
                        case T_EXCEPTION:
                        case T_EXCLUSIVE:
                        case T_EXISTS:
                        case T_EXIT:
                        case T_FALLBACK:
                        case T_FALSE:
                        case T_FETCH:
                        case T_FIELDS:
                        case T_FILE:
                        case T_FILES:
                        case T_FLOAT:
                        case T_FOR:
                        case T_FOREIGN:
                        case T_FORMAT:
                        case T_FOUND:
                        case T_FROM:
                        case T_FULL:
                        case T_FUNCTION:
                        case T_GET:
                        case T_GLOBAL:
                        case T_GO:
                        case T_GRANT:
                        case T_GROUP:
                        case T_HANDLER:
                        case T_HASH:
                        case T_HAVING:
                        case T_HOST:
                        case T_IDENTITY:
                        case T_IF:
                        case T_IGNORE:
                        case T_IMMEDIATE:
                        case T_IN:
                        case T_INCLUDE:
                        case T_INDEX:
                        case T_INITRANS:
                        case T_INNER:
                        case T_INOUT:
                        case T_INSERT:
                        case T_INT:
                        case T_INT2:
                        case T_INT4:
                        case T_INT8:
                        case T_INTEGER:
                        case T_INTERSECT:
                        case T_INTERVAL:
                        case T_INTO:
                        case T_INVOKER:
                        case T_IS:
                        case T_ISOPEN:
                        case T_ITEMS:
                        case T_JOIN:
                        case T_KEEP:
                        case T_KEY:
                        case T_KEYS:
                        case T_LANGUAGE:
                        case T_LEAVE:
                        case T_LEFT:
                        case T_LIKE:
                        case T_LIMIT:
                        case T_LINES:
                        case T_LOCAL:
                        case T_LOCATION:
                        case T_LOCATOR:
                        case T_LOCATORS:
                        case T_LOCKS:
                        case T_LOG:
                        case T_LOGGED:
                        case T_LOGGING:
                        case T_LOOP:
                        case T_MAP:
                        case T_MATCHED:
                        case T_MAX:
                        case T_MAXTRANS:
                        case T_MERGE:
                        case T_MESSAGE_TEXT:
                        case T_MICROSECOND:
                        case T_MICROSECONDS:
                        case T_MIN:
                        case T_MULTISET:
                        case T_NCHAR:
                        case T_NEW:
                        case T_NVARCHAR:
                        case T_NO:
                        case T_NOCOUNT:
                        case T_NOCOMPRESS:
                        case T_NOLOGGING:
                        case T_NONE:
                        case T_NOT:
                        case T_NOTFOUND:
                        case T_NULL:
                        case T_NUMERIC:
                        case T_NUMBER:
                        case T_OBJECT:
                        case T_OFF:
                        case T_ON:
                        case T_ONLY:
                        case T_OPEN:
                        case T_OR:
                        case T_ORDER:
                        case T_OUT:
                        case T_OUTER:
                        case T_OVER:
                        case T_OVERWRITE:
                        case T_OWNER:
                        case T_PACKAGE:
                        case T_PARTITION:
                        case T_PCTFREE:
                        case T_PCTUSED:
                        case T_PRECISION:
                        case T_PRESERVE:
                        case T_PRIMARY:
                        case T_PRINT:
                        case T_PROC:
                        case T_PROCEDURE:
                        case T_QUALIFY:
                        case T_QUERY_BAND:
                        case T_QUIT:
                        case T_QUOTED_IDENTIFIER:
                        case T_RAISE:
                        case T_REAL:
                        case T_REFERENCES:
                        case T_REGEXP:
                        case T_REPLACE:
                        case T_RESIGNAL:
                        case T_RESTRICT:
                        case T_RESULT:
                        case T_RESULT_SET_LOCATOR:
                        case T_RETURN:
                        case T_RETURNS:
                        case T_REVERSE:
                        case T_RIGHT:
                        case T_RLIKE:
                        case T_ROLE:
                        case T_ROLLBACK:
                        case T_ROW:
                        case T_ROWS:
                        case T_ROW_COUNT:
                        case T_RR:
                        case T_RS:
                        case T_PWD:
                        case T_TRIM:
                        case T_SCHEMA:
                        case T_SECOND:
                        case T_SECONDS:
                        case T_SECURITY:
                        case T_SEGMENT:
                        case T_SEL:
                        case T_SELECT:
                        case T_SET:
                        case T_SESSION:
                        case T_SESSIONS:
                        case T_SETS:
                        case T_SIGNAL:
                        case T_SIMPLE_DOUBLE:
                        case T_SIMPLE_FLOAT:
                        case T_SMALLDATETIME:
                        case T_SMALLINT:
                        case T_SQL:
                        case T_SQLEXCEPTION:
                        case T_SQLINSERT:
                        case T_SQLSTATE:
                        case T_SQLWARNING:
                        case T_STATS:
                        case T_STATISTICS:
                        case T_STEP:
                        case T_STORAGE:
                        case T_STORE:
                        case T_STORED:
                        case T_STRING:
                        case T_SUBDIR:
                        case T_SUBSTRING:
                        case T_SUM:
                        case T_SUMMARY:
                        case T_SYS_REFCURSOR:
                        case T_TABLE:
                        case T_TABLESPACE:
                        case T_TEMPORARY:
                        case T_TERMINATED:
                        case T_TEXTIMAGE_ON:
                        case T_THEN:
                        case T_TIMESTAMP:
                        case T_TITLE:
                        case T_TO:
                        case T_TOP:
                        case T_TRANSACTION:
                        case T_TRUE:
                        case T_TRUNCATE:
                        case T_UNIQUE:
                        case T_UPDATE:
                        case T_UR:
                        case T_USE:
                        case T_USING:
                        case T_VALUE:
                        case T_VALUES:
                        case T_VAR:
                        case T_VARCHAR:
                        case T_VARCHAR2:
                        case T_VARYING:
                        case T_VOLATILE:
                        case T_WHILE:
                        case T_WITH:
                        case T_WITHOUT:
                        case T_WORK:
                        case T_XACT_ABORT:
                        case T_XML:
                        case T_YES:
                        case T_ACTIVITY_COUNT:
                        case T_CUME_DIST:
                        case T_CURRENT_DATE:
                        case T_CURRENT_TIME:
                        case T_PI:
                        case T_CURRENT_TIMESTAMP:
                        case T_CURRENT_USER:
                        case T_DENSE_RANK:
                        case T_FIRST_VALUE:
                        case T_LAG:
                        case T_LAST_VALUE:
                        case T_LEAD:
                        case T_MAX_PART_STRING:
                        case T_MIN_PART_STRING:
                        case T_MAX_PART_INT:
                        case T_MIN_PART_INT:
                        case T_MAX_PART_DATE:
                        case T_MIN_PART_DATE:
                        case T_PART_COUNT:
                        case T_PART_LOC:
                        case T_RANK:
                        case T_ROW_NUMBER:
                        case T_STDEV:
                        case T_SYSDATE:
                        case T_VARIANCE:
                        case T_USER:
                        case T_ADD:
                        case T_OPEN_P:
                        case T_SUB:
                        case L_ID:
                        case L_S_STRING:
                        case L_D_STRING:
                        case L_INT:
                        case L_DEC: {
                            setState(1572);
                            expr(0);
                        }
                            break;
                        case T_MUL: {
                            setState(1573);
                            match(T_MUL);
                        }
                            break;
                        default:
                            throw new NoViableAltException(this);
                    }
                    setState(1576);
                    match(T_CLOSE_P);
                }
                    break;
                case 4:
                    enterOuterAlt(_localctx, 4); {
                    setState(1577);
                    match(T_CURRENT_DATE);
                }
                    break;
                case 5:
                    enterOuterAlt(_localctx, 5); {
                    setState(1578);
                    match(T_CURRENT);
                    setState(1579);
                    match(T_DATE);
                }
                    break;
                case 6:
                    enterOuterAlt(_localctx, 6); {
                    setState(1580);
                    match(T_CURRENT_TIME);
                }
                    break;
                case 7:
                    enterOuterAlt(_localctx, 7); {
                    setState(1581);
                    match(T_PI);
                }
                    break;
                case 8:
                    enterOuterAlt(_localctx, 8); {
                    setState(1585);
                    _errHandler.sync(this);
                    switch (_input.LA(1)) {
                        case T_CURRENT_TIMESTAMP: {
                            setState(1582);
                            match(T_CURRENT_TIMESTAMP);
                        }
                            break;
                        case T_CURRENT: {
                            setState(1583);
                            match(T_CURRENT);
                            setState(1584);
                            match(T_TIMESTAMP);
                        }
                            break;
                        default:
                            throw new NoViableAltException(this);
                    }
                    setState(1591);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 198, _ctx)) {
                        case 1: {
                            setState(1587);
                            match(T_OPEN_P);
                            setState(1588);
                            expr(0);
                            setState(1589);
                            match(T_CLOSE_P);
                        }
                            break;
                    }
                }
                    break;
                case 9:
                    enterOuterAlt(_localctx, 9); {
                    setState(1593);
                    match(T_CURRENT_USER);
                }
                    break;
                case 10:
                    enterOuterAlt(_localctx, 10); {
                    setState(1594);
                    match(T_CURRENT);
                    setState(1595);
                    match(T_USER);
                }
                    break;
                case 11:
                    enterOuterAlt(_localctx, 11); {
                    setState(1596);
                    match(T_MAX_PART_STRING);
                    setState(1597);
                    match(T_OPEN_P);
                    setState(1598);
                    expr(0);
                    setState(1611);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_COMMA) {
                        {
                            setState(1599);
                            match(T_COMMA);
                            setState(1600);
                            expr(0);
                            setState(1608);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                            while (_la == T_COMMA) {
                                {
                                    {
                                        setState(1601);
                                        match(T_COMMA);
                                        setState(1602);
                                        expr(0);
                                        setState(1603);
                                        match(T_EQUAL);
                                        setState(1604);
                                        expr(0);
                                    }
                                }
                                setState(1610);
                                _errHandler.sync(this);
                                _la = _input.LA(1);
                            }
                        }
                    }

                    setState(1613);
                    match(T_CLOSE_P);
                }
                    break;
                case 12:
                    enterOuterAlt(_localctx, 12); {
                    setState(1615);
                    match(T_MIN_PART_STRING);
                    setState(1616);
                    match(T_OPEN_P);
                    setState(1617);
                    expr(0);
                    setState(1630);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_COMMA) {
                        {
                            setState(1618);
                            match(T_COMMA);
                            setState(1619);
                            expr(0);
                            setState(1627);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                            while (_la == T_COMMA) {
                                {
                                    {
                                        setState(1620);
                                        match(T_COMMA);
                                        setState(1621);
                                        expr(0);
                                        setState(1622);
                                        match(T_EQUAL);
                                        setState(1623);
                                        expr(0);
                                    }
                                }
                                setState(1629);
                                _errHandler.sync(this);
                                _la = _input.LA(1);
                            }
                        }
                    }

                    setState(1632);
                    match(T_CLOSE_P);
                }
                    break;
                case 13:
                    enterOuterAlt(_localctx, 13); {
                    setState(1634);
                    match(T_MAX_PART_INT);
                    setState(1635);
                    match(T_OPEN_P);
                    setState(1636);
                    expr(0);
                    setState(1649);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_COMMA) {
                        {
                            setState(1637);
                            match(T_COMMA);
                            setState(1638);
                            expr(0);
                            setState(1646);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                            while (_la == T_COMMA) {
                                {
                                    {
                                        setState(1639);
                                        match(T_COMMA);
                                        setState(1640);
                                        expr(0);
                                        setState(1641);
                                        match(T_EQUAL);
                                        setState(1642);
                                        expr(0);
                                    }
                                }
                                setState(1648);
                                _errHandler.sync(this);
                                _la = _input.LA(1);
                            }
                        }
                    }

                    setState(1651);
                    match(T_CLOSE_P);
                }
                    break;
                case 14:
                    enterOuterAlt(_localctx, 14); {
                    setState(1653);
                    match(T_MIN_PART_INT);
                    setState(1654);
                    match(T_OPEN_P);
                    setState(1655);
                    expr(0);
                    setState(1668);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_COMMA) {
                        {
                            setState(1656);
                            match(T_COMMA);
                            setState(1657);
                            expr(0);
                            setState(1665);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                            while (_la == T_COMMA) {
                                {
                                    {
                                        setState(1658);
                                        match(T_COMMA);
                                        setState(1659);
                                        expr(0);
                                        setState(1660);
                                        match(T_EQUAL);
                                        setState(1661);
                                        expr(0);
                                    }
                                }
                                setState(1667);
                                _errHandler.sync(this);
                                _la = _input.LA(1);
                            }
                        }
                    }

                    setState(1670);
                    match(T_CLOSE_P);
                }
                    break;
                case 15:
                    enterOuterAlt(_localctx, 15); {
                    setState(1672);
                    match(T_MAX_PART_DATE);
                    setState(1673);
                    match(T_OPEN_P);
                    setState(1674);
                    expr(0);
                    setState(1687);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_COMMA) {
                        {
                            setState(1675);
                            match(T_COMMA);
                            setState(1676);
                            expr(0);
                            setState(1684);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                            while (_la == T_COMMA) {
                                {
                                    {
                                        setState(1677);
                                        match(T_COMMA);
                                        setState(1678);
                                        expr(0);
                                        setState(1679);
                                        match(T_EQUAL);
                                        setState(1680);
                                        expr(0);
                                    }
                                }
                                setState(1686);
                                _errHandler.sync(this);
                                _la = _input.LA(1);
                            }
                        }
                    }

                    setState(1689);
                    match(T_CLOSE_P);
                }
                    break;
                case 16:
                    enterOuterAlt(_localctx, 16); {
                    setState(1691);
                    match(T_MIN_PART_DATE);
                    setState(1692);
                    match(T_OPEN_P);
                    setState(1693);
                    expr(0);
                    setState(1706);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_COMMA) {
                        {
                            setState(1694);
                            match(T_COMMA);
                            setState(1695);
                            expr(0);
                            setState(1703);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                            while (_la == T_COMMA) {
                                {
                                    {
                                        setState(1696);
                                        match(T_COMMA);
                                        setState(1697);
                                        expr(0);
                                        setState(1698);
                                        match(T_EQUAL);
                                        setState(1699);
                                        expr(0);
                                    }
                                }
                                setState(1705);
                                _errHandler.sync(this);
                                _la = _input.LA(1);
                            }
                        }
                    }

                    setState(1708);
                    match(T_CLOSE_P);
                }
                    break;
                case 17:
                    enterOuterAlt(_localctx, 17); {
                    setState(1710);
                    match(T_PART_COUNT);
                    setState(1711);
                    match(T_OPEN_P);
                    setState(1712);
                    expr(0);
                    setState(1720);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == T_COMMA) {
                        {
                            {
                                setState(1713);
                                match(T_COMMA);
                                setState(1714);
                                expr(0);
                                setState(1715);
                                match(T_EQUAL);
                                setState(1716);
                                expr(0);
                            }
                        }
                        setState(1722);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                    setState(1723);
                    match(T_CLOSE_P);
                }
                    break;
                case 18:
                    enterOuterAlt(_localctx, 18); {
                    setState(1725);
                    match(T_PART_LOC);
                    setState(1726);
                    match(T_OPEN_P);
                    setState(1727);
                    expr(0);
                    setState(1733);
                    _errHandler.sync(this);
                    _alt = 1;
                    do {
                        switch (_alt) {
                            case 1: {
                                {
                                    setState(1728);
                                    match(T_COMMA);
                                    setState(1729);
                                    expr(0);
                                    setState(1730);
                                    match(T_EQUAL);
                                    setState(1731);
                                    expr(0);
                                }
                            }
                                break;
                            default:
                                throw new NoViableAltException(this);
                        }
                        setState(1735);
                        _errHandler.sync(this);
                        _alt = getInterpreter().adaptivePredict(_input, 212, _ctx);
                    } while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER);
                    setState(1739);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_COMMA) {
                        {
                            setState(1737);
                            match(T_COMMA);
                            setState(1738);
                            expr(0);
                        }
                    }

                    setState(1741);
                    match(T_CLOSE_P);
                }
                    break;
                case 19:
                    enterOuterAlt(_localctx, 19); {
                    setState(1743);
                    match(T_SUBSTRING);
                    setState(1744);
                    match(T_OPEN_P);
                    setState(1745);
                    expr(0);
                    setState(1746);
                    match(T_FROM);
                    setState(1747);
                    expr(0);
                    setState(1750);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_FOR) {
                        {
                            setState(1748);
                            match(T_FOR);
                            setState(1749);
                            expr(0);
                        }
                    }

                    setState(1752);
                    match(T_CLOSE_P);
                }
                    break;
                case 20:
                    enterOuterAlt(_localctx, 20); {
                    setState(1754);
                    match(T_SYSDATE);
                }
                    break;
                case 21:
                    enterOuterAlt(_localctx, 21); {
                    setState(1755);
                    match(T_USER);
                }
                    break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ExprFuncContext extends ParserRuleContext {
        public IdentContext ident() {
            return getRuleContext(IdentContext.class, 0);
        }

        public TerminalNode T_OPEN_P() {
            return getToken(StartDBSqlParser.T_OPEN_P, 0);
        }

        public TerminalNode T_CLOSE_P() {
            return getToken(StartDBSqlParser.T_CLOSE_P, 0);
        }

        public ExprFuncParamsContext exprFuncParams() {
            return getRuleContext(ExprFuncParamsContext.class, 0);
        }

        public ExprFuncContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_exprFunc;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitExprFunc(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ExprFuncContext exprFunc() throws RecognitionException {
        ExprFuncContext _localctx = new ExprFuncContext(_ctx, getState());
        enterRule(_localctx, 216, RULE_exprFunc);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1758);
                ident();
                setState(1759);
                match(T_OPEN_P);
                setState(1761);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 216, _ctx)) {
                    case 1: {
                        setState(1760);
                        exprFuncParams();
                    }
                        break;
                }
                setState(1763);
                match(T_CLOSE_P);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ExprFuncParamsContext extends ParserRuleContext {
        public List<FuncParamContext> funcParam() {
            return getRuleContexts(FuncParamContext.class);
        }

        public FuncParamContext funcParam(int i) {
            return getRuleContext(FuncParamContext.class, i);
        }

        public List<TerminalNode> T_COMMA() {
            return getTokens(StartDBSqlParser.T_COMMA);
        }

        public TerminalNode T_COMMA(int i) {
            return getToken(StartDBSqlParser.T_COMMA, i);
        }

        public ExprFuncParamsContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_exprFuncParams;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitExprFuncParams(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ExprFuncParamsContext exprFuncParams() throws RecognitionException {
        ExprFuncParamsContext _localctx = new ExprFuncParamsContext(_ctx, getState());
        enterRule(_localctx, 218, RULE_exprFuncParams);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1765);
                funcParam();
                setState(1770);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T_COMMA) {
                    {
                        {
                            setState(1766);
                            match(T_COMMA);
                            setState(1767);
                            funcParam();
                        }
                    }
                    setState(1772);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class FuncParamContext extends ParserRuleContext {
        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public IdentContext ident() {
            return getRuleContext(IdentContext.class, 0);
        }

        public TerminalNode T_EQUAL() {
            return getToken(StartDBSqlParser.T_EQUAL, 0);
        }

        public TerminalNode T_GREATER() {
            return getToken(StartDBSqlParser.T_GREATER, 0);
        }

        public TerminalNode T_MUL() {
            return getToken(StartDBSqlParser.T_MUL, 0);
        }

        public FuncParamContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_funcParam;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitFuncParam(this);
            else return visitor.visitChildren(this);
        }
    }

    public final FuncParamContext funcParam() throws RecognitionException {
        FuncParamContext _localctx = new FuncParamContext(_ctx, getState());
        enterRule(_localctx, 220, RULE_funcParam);
        int _la;
        try {
            setState(1784);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 220, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1); {}
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2); {
                    setState(1774);
                    if (!(!_input.LT(1).getText().equalsIgnoreCase("INTO")))
                        throw new FailedPredicateException(
                            this,
                            "!_input.LT(1).getText().equalsIgnoreCase(\"INTO\")"
                        );
                    setState(1780);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 219, _ctx)) {
                        case 1: {
                            setState(1775);
                            ident();
                            setState(1776);
                            match(T_EQUAL);
                            setState(1778);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                            if (_la == T_GREATER) {
                                {
                                    setState(1777);
                                    match(T_GREATER);
                                }
                            }

                        }
                            break;
                    }
                    setState(1782);
                    expr(0);
                }
                    break;
                case 3:
                    enterOuterAlt(_localctx, 3); {
                    setState(1783);
                    match(T_MUL);
                }
                    break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class Table_nameContext extends ParserRuleContext {
        public QidentContext qident() {
            return getRuleContext(QidentContext.class, 0);
        }

        public Table_nameContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_table_name;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitTable_name(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Table_nameContext table_name() throws RecognitionException {
        Table_nameContext _localctx = new Table_nameContext(_ctx, getState());
        enterRule(_localctx, 222, RULE_table_name);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1786);
                qident();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class User_nameContext extends ParserRuleContext {
        public IdentContext ident() {
            return getRuleContext(IdentContext.class, 0);
        }

        public User_nameContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_user_name;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitUser_name(this);
            else return visitor.visitChildren(this);
        }
    }

    public final User_nameContext user_name() throws RecognitionException {
        User_nameContext _localctx = new User_nameContext(_ctx, getState());
        enterRule(_localctx, 224, RULE_user_name);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1788);
                ident();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class QidentContext extends ParserRuleContext {
        public List<IdentContext> ident() {
            return getRuleContexts(IdentContext.class);
        }

        public IdentContext ident(int i) {
            return getRuleContext(IdentContext.class, i);
        }

        public List<TerminalNode> T_DOT() {
            return getTokens(StartDBSqlParser.T_DOT);
        }

        public TerminalNode T_DOT(int i) {
            return getToken(StartDBSqlParser.T_DOT, i);
        }

        public QidentContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_qident;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitQident(this);
            else return visitor.visitChildren(this);
        }
    }

    public final QidentContext qident() throws RecognitionException {
        QidentContext _localctx = new QidentContext(_ctx, getState());
        enterRule(_localctx, 226, RULE_qident);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1790);
                ident();
                setState(1795);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T_DOT) {
                    {
                        {
                            setState(1791);
                            match(T_DOT);
                            setState(1792);
                            ident();
                        }
                    }
                    setState(1797);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class DateLiteralContext extends ParserRuleContext {
        public TerminalNode T_DATE() {
            return getToken(StartDBSqlParser.T_DATE, 0);
        }

        public StringContext string() {
            return getRuleContext(StringContext.class, 0);
        }

        public DateLiteralContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_dateLiteral;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitDateLiteral(this);
            else return visitor.visitChildren(this);
        }
    }

    public final DateLiteralContext dateLiteral() throws RecognitionException {
        DateLiteralContext _localctx = new DateLiteralContext(_ctx, getState());
        enterRule(_localctx, 228, RULE_dateLiteral);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1798);
                match(T_DATE);
                setState(1799);
                string();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class TimestampLiteralContext extends ParserRuleContext {
        public TerminalNode T_TIMESTAMP() {
            return getToken(StartDBSqlParser.T_TIMESTAMP, 0);
        }

        public StringContext string() {
            return getRuleContext(StringContext.class, 0);
        }

        public TimestampLiteralContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_timestampLiteral;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitTimestampLiteral(this);
            else return visitor.visitChildren(this);
        }
    }

    public final TimestampLiteralContext timestampLiteral() throws RecognitionException {
        TimestampLiteralContext _localctx = new TimestampLiteralContext(_ctx, getState());
        enterRule(_localctx, 230, RULE_timestampLiteral);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1801);
                match(T_TIMESTAMP);
                setState(1802);
                string();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class IdentContext extends ParserRuleContext {
        public List<IdentItemContext> identItem() {
            return getRuleContexts(IdentItemContext.class);
        }

        public IdentItemContext identItem(int i) {
            return getRuleContext(IdentItemContext.class, i);
        }

        public TerminalNode T_SUB() {
            return getToken(StartDBSqlParser.T_SUB, 0);
        }

        public List<TerminalNode> T_DOT() {
            return getTokens(StartDBSqlParser.T_DOT);
        }

        public TerminalNode T_DOT(int i) {
            return getToken(StartDBSqlParser.T_DOT, i);
        }

        public IdentContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_ident;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitIdent(this);
            else return visitor.visitChildren(this);
        }
    }

    public final IdentContext ident() throws RecognitionException {
        IdentContext _localctx = new IdentContext(_ctx, getState());
        enterRule(_localctx, 232, RULE_ident);
        int _la;
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(1805);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_SUB) {
                    {
                        setState(1804);
                        match(T_SUB);
                    }
                }

                setState(1807);
                identItem();
                setState(1812);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 223, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            {
                                setState(1808);
                                match(T_DOT);
                                setState(1809);
                                identItem();
                            }
                        }
                    }
                    setState(1814);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 223, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class IdentItemContext extends ParserRuleContext {
        public TerminalNode L_ID() {
            return getToken(StartDBSqlParser.L_ID, 0);
        }

        public NonReservedWordsContext nonReservedWords() {
            return getRuleContext(NonReservedWordsContext.class, 0);
        }

        public IdentItemContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_identItem;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitIdentItem(this);
            else return visitor.visitChildren(this);
        }
    }

    public final IdentItemContext identItem() throws RecognitionException {
        IdentItemContext _localctx = new IdentItemContext(_ctx, getState());
        enterRule(_localctx, 234, RULE_identItem);
        try {
            setState(1817);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case L_ID:
                    enterOuterAlt(_localctx, 1); {
                    setState(1815);
                    match(L_ID);
                }
                    break;
                case T_ACTION:
                case T_ADD2:
                case T_ALL:
                case T_ALLOCATE:
                case T_ALTER:
                case T_AND:
                case T_ANSI_NULLS:
                case T_ANSI_PADDING:
                case T_AS:
                case T_ASC:
                case T_ASSOCIATE:
                case T_AT:
                case T_AVG:
                case T_BATCHSIZE:
                case T_BEGIN:
                case T_BETWEEN:
                case T_BIGINT:
                case T_BINARY_DOUBLE:
                case T_BINARY_FLOAT:
                case T_BIT:
                case T_BODY:
                case T_BREAK:
                case T_BY:
                case T_BYTE:
                case T_CALL:
                case T_CALLER:
                case T_CASCADE:
                case T_CASE:
                case T_CASESPECIFIC:
                case T_CAST:
                case T_CHAR:
                case T_CHARACTER:
                case T_CHARSET:
                case T_CLIENT:
                case T_CLOSE:
                case T_CLUSTERED:
                case T_CMP:
                case T_COLLECT:
                case T_COLLECTION:
                case T_COLUMN:
                case T_COMMENT:
                case T_CONSTANT:
                case T_COMMIT:
                case T_COMPRESS:
                case T_CONCAT:
                case T_CONDITION:
                case T_CONSTRAINT:
                case T_CONTINUE:
                case T_COPY:
                case T_COUNT:
                case T_COUNT_BIG:
                case T_CREATION:
                case T_CREATOR:
                case T_CS:
                case T_CURRENT:
                case T_CURRENT_SCHEMA:
                case T_CURSOR:
                case T_DATABASE:
                case T_DATA:
                case T_DATE:
                case T_DATETIME:
                case T_DAY:
                case T_DAYS:
                case T_DEC:
                case T_DECIMAL:
                case T_DECLARE:
                case T_DEFAULT:
                case T_DEFERRED:
                case T_DEFINED:
                case T_DEFINER:
                case T_DEFINITION:
                case T_DELETE:
                case T_DELIMITED:
                case T_DELIMITER:
                case T_DESC:
                case T_DESCRIBE:
                case T_DIAGNOSTICS:
                case T_DIR:
                case T_DIRECTORY:
                case T_DISTINCT:
                case T_DISTRIBUTE:
                case T_DO:
                case T_DOUBLE:
                case T_DOWNLOAD:
                case T_DROP:
                case T_DYNAMIC:
                case T_ENABLE:
                case T_ENGINE:
                case T_ESCAPED:
                case T_EXCEPT:
                case T_EXEC:
                case T_EXECUTE:
                case T_EXCEPTION:
                case T_EXCLUSIVE:
                case T_EXISTS:
                case T_EXIT:
                case T_FALLBACK:
                case T_FALSE:
                case T_FETCH:
                case T_FIELDS:
                case T_FILE:
                case T_FILES:
                case T_FLOAT:
                case T_FOR:
                case T_FOREIGN:
                case T_FORMAT:
                case T_FOUND:
                case T_FROM:
                case T_FULL:
                case T_FUNCTION:
                case T_GET:
                case T_GLOBAL:
                case T_GO:
                case T_GRANT:
                case T_GROUP:
                case T_HANDLER:
                case T_HASH:
                case T_HAVING:
                case T_HOST:
                case T_IDENTITY:
                case T_IF:
                case T_IGNORE:
                case T_IMMEDIATE:
                case T_IN:
                case T_INCLUDE:
                case T_INDEX:
                case T_INITRANS:
                case T_INNER:
                case T_INOUT:
                case T_INSERT:
                case T_INT:
                case T_INT2:
                case T_INT4:
                case T_INT8:
                case T_INTEGER:
                case T_INTERSECT:
                case T_INTERVAL:
                case T_INTO:
                case T_INVOKER:
                case T_IS:
                case T_ISOPEN:
                case T_ITEMS:
                case T_JOIN:
                case T_KEEP:
                case T_KEY:
                case T_KEYS:
                case T_LANGUAGE:
                case T_LEAVE:
                case T_LEFT:
                case T_LIKE:
                case T_LIMIT:
                case T_LINES:
                case T_LOCAL:
                case T_LOCATION:
                case T_LOCATOR:
                case T_LOCATORS:
                case T_LOCKS:
                case T_LOG:
                case T_LOGGED:
                case T_LOGGING:
                case T_LOOP:
                case T_MAP:
                case T_MATCHED:
                case T_MAX:
                case T_MAXTRANS:
                case T_MERGE:
                case T_MESSAGE_TEXT:
                case T_MICROSECOND:
                case T_MICROSECONDS:
                case T_MIN:
                case T_MULTISET:
                case T_NCHAR:
                case T_NEW:
                case T_NVARCHAR:
                case T_NO:
                case T_NOCOUNT:
                case T_NOCOMPRESS:
                case T_NOLOGGING:
                case T_NONE:
                case T_NOT:
                case T_NOTFOUND:
                case T_NUMERIC:
                case T_NUMBER:
                case T_OBJECT:
                case T_OFF:
                case T_ON:
                case T_ONLY:
                case T_OPEN:
                case T_OR:
                case T_ORDER:
                case T_OUT:
                case T_OUTER:
                case T_OVER:
                case T_OVERWRITE:
                case T_OWNER:
                case T_PACKAGE:
                case T_PARTITION:
                case T_PCTFREE:
                case T_PCTUSED:
                case T_PRECISION:
                case T_PRESERVE:
                case T_PRIMARY:
                case T_PRINT:
                case T_PROC:
                case T_PROCEDURE:
                case T_QUALIFY:
                case T_QUERY_BAND:
                case T_QUIT:
                case T_QUOTED_IDENTIFIER:
                case T_RAISE:
                case T_REAL:
                case T_REFERENCES:
                case T_REGEXP:
                case T_REPLACE:
                case T_RESIGNAL:
                case T_RESTRICT:
                case T_RESULT:
                case T_RESULT_SET_LOCATOR:
                case T_RETURN:
                case T_RETURNS:
                case T_REVERSE:
                case T_RIGHT:
                case T_RLIKE:
                case T_ROLE:
                case T_ROLLBACK:
                case T_ROW:
                case T_ROWS:
                case T_ROW_COUNT:
                case T_RR:
                case T_RS:
                case T_PWD:
                case T_TRIM:
                case T_SCHEMA:
                case T_SECOND:
                case T_SECONDS:
                case T_SECURITY:
                case T_SEGMENT:
                case T_SEL:
                case T_SELECT:
                case T_SET:
                case T_SESSION:
                case T_SESSIONS:
                case T_SETS:
                case T_SIGNAL:
                case T_SIMPLE_DOUBLE:
                case T_SIMPLE_FLOAT:
                case T_SMALLDATETIME:
                case T_SMALLINT:
                case T_SQL:
                case T_SQLEXCEPTION:
                case T_SQLINSERT:
                case T_SQLSTATE:
                case T_SQLWARNING:
                case T_STATS:
                case T_STATISTICS:
                case T_STEP:
                case T_STORAGE:
                case T_STORE:
                case T_STORED:
                case T_STRING:
                case T_SUBDIR:
                case T_SUBSTRING:
                case T_SUM:
                case T_SUMMARY:
                case T_SYS_REFCURSOR:
                case T_TABLE:
                case T_TABLESPACE:
                case T_TEMPORARY:
                case T_TERMINATED:
                case T_TEXTIMAGE_ON:
                case T_THEN:
                case T_TIMESTAMP:
                case T_TITLE:
                case T_TO:
                case T_TOP:
                case T_TRANSACTION:
                case T_TRUE:
                case T_TRUNCATE:
                case T_UNIQUE:
                case T_UPDATE:
                case T_UR:
                case T_USE:
                case T_USING:
                case T_VALUE:
                case T_VALUES:
                case T_VAR:
                case T_VARCHAR:
                case T_VARCHAR2:
                case T_VARYING:
                case T_VOLATILE:
                case T_WHILE:
                case T_WITH:
                case T_WITHOUT:
                case T_WORK:
                case T_XACT_ABORT:
                case T_XML:
                case T_YES:
                case T_ACTIVITY_COUNT:
                case T_CUME_DIST:
                case T_CURRENT_DATE:
                case T_CURRENT_TIME:
                case T_PI:
                case T_CURRENT_TIMESTAMP:
                case T_CURRENT_USER:
                case T_DENSE_RANK:
                case T_FIRST_VALUE:
                case T_LAG:
                case T_LAST_VALUE:
                case T_LEAD:
                case T_PART_COUNT:
                case T_PART_LOC:
                case T_RANK:
                case T_ROW_NUMBER:
                case T_STDEV:
                case T_SYSDATE:
                case T_VARIANCE:
                case T_USER:
                    enterOuterAlt(_localctx, 2); {
                    setState(1816);
                    nonReservedWords();
                }
                    break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class StringContext extends ParserRuleContext {
        public StringContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_string;
        }

        public StringContext() {}

        public void copyFrom(StringContext ctx) {
            super.copyFrom(ctx);
        }
    }

    public static class SingleQuotedStringContext extends StringContext {
        public TerminalNode L_S_STRING() {
            return getToken(StartDBSqlParser.L_S_STRING, 0);
        }

        public SingleQuotedStringContext(StringContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitSingleQuotedString(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class DoubleQuotedStringContext extends StringContext {
        public TerminalNode L_D_STRING() {
            return getToken(StartDBSqlParser.L_D_STRING, 0);
        }

        public DoubleQuotedStringContext(StringContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitDoubleQuotedString(this);
            else return visitor.visitChildren(this);
        }
    }

    public final StringContext string() throws RecognitionException {
        StringContext _localctx = new StringContext(_ctx, getState());
        enterRule(_localctx, 236, RULE_string);
        try {
            setState(1821);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case L_S_STRING:
                    _localctx = new SingleQuotedStringContext(_localctx);
                    enterOuterAlt(_localctx, 1); {
                    setState(1819);
                    match(L_S_STRING);
                }
                    break;
                case L_D_STRING:
                    _localctx = new DoubleQuotedStringContext(_localctx);
                    enterOuterAlt(_localctx, 2); {
                    setState(1820);
                    match(L_D_STRING);
                }
                    break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class IntNumberContext extends ParserRuleContext {
        public TerminalNode L_INT() {
            return getToken(StartDBSqlParser.L_INT, 0);
        }

        public TerminalNode T_SUB() {
            return getToken(StartDBSqlParser.T_SUB, 0);
        }

        public TerminalNode T_ADD() {
            return getToken(StartDBSqlParser.T_ADD, 0);
        }

        public IntNumberContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_intNumber;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitIntNumber(this);
            else return visitor.visitChildren(this);
        }
    }

    public final IntNumberContext intNumber() throws RecognitionException {
        IntNumberContext _localctx = new IntNumberContext(_ctx, getState());
        enterRule(_localctx, 238, RULE_intNumber);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1824);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_ADD || _la == T_SUB) {
                    {
                        setState(1823);
                        _la = _input.LA(1);
                        if (!(_la == T_ADD || _la == T_SUB)) {
                            _errHandler.recoverInline(this);
                        } else {
                            if (_input.LA(1) == Token.EOF) matchedEOF = true;
                            _errHandler.reportMatch(this);
                            consume();
                        }
                    }
                }

                setState(1826);
                match(L_INT);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class DecNumberContext extends ParserRuleContext {
        public TerminalNode L_DEC() {
            return getToken(StartDBSqlParser.L_DEC, 0);
        }

        public TerminalNode T_SUB() {
            return getToken(StartDBSqlParser.T_SUB, 0);
        }

        public TerminalNode T_ADD() {
            return getToken(StartDBSqlParser.T_ADD, 0);
        }

        public DecNumberContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_decNumber;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitDecNumber(this);
            else return visitor.visitChildren(this);
        }
    }

    public final DecNumberContext decNumber() throws RecognitionException {
        DecNumberContext _localctx = new DecNumberContext(_ctx, getState());
        enterRule(_localctx, 240, RULE_decNumber);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1829);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_ADD || _la == T_SUB) {
                    {
                        setState(1828);
                        _la = _input.LA(1);
                        if (!(_la == T_ADD || _la == T_SUB)) {
                            _errHandler.recoverInline(this);
                        } else {
                            if (_input.LA(1) == Token.EOF) matchedEOF = true;
                            _errHandler.reportMatch(this);
                            consume();
                        }
                    }
                }

                setState(1831);
                match(L_DEC);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class BoolLiteralContext extends ParserRuleContext {
        public TerminalNode T_TRUE() {
            return getToken(StartDBSqlParser.T_TRUE, 0);
        }

        public TerminalNode T_FALSE() {
            return getToken(StartDBSqlParser.T_FALSE, 0);
        }

        public BoolLiteralContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_boolLiteral;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitBoolLiteral(this);
            else return visitor.visitChildren(this);
        }
    }

    public final BoolLiteralContext boolLiteral() throws RecognitionException {
        BoolLiteralContext _localctx = new BoolLiteralContext(_ctx, getState());
        enterRule(_localctx, 242, RULE_boolLiteral);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1833);
                _la = _input.LA(1);
                if (!(_la == T_FALSE || _la == T_TRUE)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class NullConstContext extends ParserRuleContext {
        public TerminalNode T_NULL() {
            return getToken(StartDBSqlParser.T_NULL, 0);
        }

        public NullConstContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_nullConst;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitNullConst(this);
            else return visitor.visitChildren(this);
        }
    }

    public final NullConstContext nullConst() throws RecognitionException {
        NullConstContext _localctx = new NullConstContext(_ctx, getState());
        enterRule(_localctx, 244, RULE_nullConst);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1835);
                match(T_NULL);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class NonReservedWordsContext extends ParserRuleContext {
        public TerminalNode T_ACTION() {
            return getToken(StartDBSqlParser.T_ACTION, 0);
        }

        public TerminalNode T_ACTIVITY_COUNT() {
            return getToken(StartDBSqlParser.T_ACTIVITY_COUNT, 0);
        }

        public TerminalNode T_ADD2() {
            return getToken(StartDBSqlParser.T_ADD2, 0);
        }

        public TerminalNode T_ALL() {
            return getToken(StartDBSqlParser.T_ALL, 0);
        }

        public TerminalNode T_ALLOCATE() {
            return getToken(StartDBSqlParser.T_ALLOCATE, 0);
        }

        public TerminalNode T_ALTER() {
            return getToken(StartDBSqlParser.T_ALTER, 0);
        }

        public TerminalNode T_AND() {
            return getToken(StartDBSqlParser.T_AND, 0);
        }

        public TerminalNode T_ANSI_NULLS() {
            return getToken(StartDBSqlParser.T_ANSI_NULLS, 0);
        }

        public TerminalNode T_ANSI_PADDING() {
            return getToken(StartDBSqlParser.T_ANSI_PADDING, 0);
        }

        public TerminalNode T_AS() {
            return getToken(StartDBSqlParser.T_AS, 0);
        }

        public TerminalNode T_ASC() {
            return getToken(StartDBSqlParser.T_ASC, 0);
        }

        public TerminalNode T_ASSOCIATE() {
            return getToken(StartDBSqlParser.T_ASSOCIATE, 0);
        }

        public TerminalNode T_AT() {
            return getToken(StartDBSqlParser.T_AT, 0);
        }

        public TerminalNode T_AVG() {
            return getToken(StartDBSqlParser.T_AVG, 0);
        }

        public TerminalNode T_BATCHSIZE() {
            return getToken(StartDBSqlParser.T_BATCHSIZE, 0);
        }

        public TerminalNode T_BEGIN() {
            return getToken(StartDBSqlParser.T_BEGIN, 0);
        }

        public TerminalNode T_BETWEEN() {
            return getToken(StartDBSqlParser.T_BETWEEN, 0);
        }

        public TerminalNode T_BIGINT() {
            return getToken(StartDBSqlParser.T_BIGINT, 0);
        }

        public TerminalNode T_BINARY_DOUBLE() {
            return getToken(StartDBSqlParser.T_BINARY_DOUBLE, 0);
        }

        public TerminalNode T_BINARY_FLOAT() {
            return getToken(StartDBSqlParser.T_BINARY_FLOAT, 0);
        }

        public TerminalNode T_BIT() {
            return getToken(StartDBSqlParser.T_BIT, 0);
        }

        public TerminalNode T_BODY() {
            return getToken(StartDBSqlParser.T_BODY, 0);
        }

        public TerminalNode T_BREAK() {
            return getToken(StartDBSqlParser.T_BREAK, 0);
        }

        public TerminalNode T_BY() {
            return getToken(StartDBSqlParser.T_BY, 0);
        }

        public TerminalNode T_BYTE() {
            return getToken(StartDBSqlParser.T_BYTE, 0);
        }

        public TerminalNode T_CALL() {
            return getToken(StartDBSqlParser.T_CALL, 0);
        }

        public TerminalNode T_CALLER() {
            return getToken(StartDBSqlParser.T_CALLER, 0);
        }

        public TerminalNode T_CASCADE() {
            return getToken(StartDBSqlParser.T_CASCADE, 0);
        }

        public TerminalNode T_CASE() {
            return getToken(StartDBSqlParser.T_CASE, 0);
        }

        public TerminalNode T_CASESPECIFIC() {
            return getToken(StartDBSqlParser.T_CASESPECIFIC, 0);
        }

        public TerminalNode T_CAST() {
            return getToken(StartDBSqlParser.T_CAST, 0);
        }

        public TerminalNode T_CHAR() {
            return getToken(StartDBSqlParser.T_CHAR, 0);
        }

        public TerminalNode T_CHARACTER() {
            return getToken(StartDBSqlParser.T_CHARACTER, 0);
        }

        public TerminalNode T_CHARSET() {
            return getToken(StartDBSqlParser.T_CHARSET, 0);
        }

        public TerminalNode T_CLIENT() {
            return getToken(StartDBSqlParser.T_CLIENT, 0);
        }

        public TerminalNode T_CLOSE() {
            return getToken(StartDBSqlParser.T_CLOSE, 0);
        }

        public TerminalNode T_CLUSTERED() {
            return getToken(StartDBSqlParser.T_CLUSTERED, 0);
        }

        public TerminalNode T_CMP() {
            return getToken(StartDBSqlParser.T_CMP, 0);
        }

        public TerminalNode T_COLLECT() {
            return getToken(StartDBSqlParser.T_COLLECT, 0);
        }

        public TerminalNode T_COLLECTION() {
            return getToken(StartDBSqlParser.T_COLLECTION, 0);
        }

        public TerminalNode T_COLUMN() {
            return getToken(StartDBSqlParser.T_COLUMN, 0);
        }

        public TerminalNode T_COMMENT() {
            return getToken(StartDBSqlParser.T_COMMENT, 0);
        }

        public TerminalNode T_COMPRESS() {
            return getToken(StartDBSqlParser.T_COMPRESS, 0);
        }

        public TerminalNode T_CONSTANT() {
            return getToken(StartDBSqlParser.T_CONSTANT, 0);
        }

        public TerminalNode T_COPY() {
            return getToken(StartDBSqlParser.T_COPY, 0);
        }

        public TerminalNode T_COMMIT() {
            return getToken(StartDBSqlParser.T_COMMIT, 0);
        }

        public TerminalNode T_CONCAT() {
            return getToken(StartDBSqlParser.T_CONCAT, 0);
        }

        public TerminalNode T_CONDITION() {
            return getToken(StartDBSqlParser.T_CONDITION, 0);
        }

        public TerminalNode T_CONSTRAINT() {
            return getToken(StartDBSqlParser.T_CONSTRAINT, 0);
        }

        public TerminalNode T_CONTINUE() {
            return getToken(StartDBSqlParser.T_CONTINUE, 0);
        }

        public TerminalNode T_COUNT() {
            return getToken(StartDBSqlParser.T_COUNT, 0);
        }

        public TerminalNode T_COUNT_BIG() {
            return getToken(StartDBSqlParser.T_COUNT_BIG, 0);
        }

        public TerminalNode T_CREATION() {
            return getToken(StartDBSqlParser.T_CREATION, 0);
        }

        public TerminalNode T_CREATOR() {
            return getToken(StartDBSqlParser.T_CREATOR, 0);
        }

        public TerminalNode T_CS() {
            return getToken(StartDBSqlParser.T_CS, 0);
        }

        public TerminalNode T_CUME_DIST() {
            return getToken(StartDBSqlParser.T_CUME_DIST, 0);
        }

        public TerminalNode T_CURRENT() {
            return getToken(StartDBSqlParser.T_CURRENT, 0);
        }

        public TerminalNode T_CURRENT_DATE() {
            return getToken(StartDBSqlParser.T_CURRENT_DATE, 0);
        }

        public TerminalNode T_CURRENT_TIME() {
            return getToken(StartDBSqlParser.T_CURRENT_TIME, 0);
        }

        public TerminalNode T_PI() {
            return getToken(StartDBSqlParser.T_PI, 0);
        }

        public TerminalNode T_CURRENT_SCHEMA() {
            return getToken(StartDBSqlParser.T_CURRENT_SCHEMA, 0);
        }

        public TerminalNode T_CURRENT_TIMESTAMP() {
            return getToken(StartDBSqlParser.T_CURRENT_TIMESTAMP, 0);
        }

        public TerminalNode T_CURRENT_USER() {
            return getToken(StartDBSqlParser.T_CURRENT_USER, 0);
        }

        public TerminalNode T_CURSOR() {
            return getToken(StartDBSqlParser.T_CURSOR, 0);
        }

        public TerminalNode T_DATA() {
            return getToken(StartDBSqlParser.T_DATA, 0);
        }

        public TerminalNode T_DATABASE() {
            return getToken(StartDBSqlParser.T_DATABASE, 0);
        }

        public TerminalNode T_DATE() {
            return getToken(StartDBSqlParser.T_DATE, 0);
        }

        public TerminalNode T_DATETIME() {
            return getToken(StartDBSqlParser.T_DATETIME, 0);
        }

        public TerminalNode T_DAY() {
            return getToken(StartDBSqlParser.T_DAY, 0);
        }

        public TerminalNode T_DAYS() {
            return getToken(StartDBSqlParser.T_DAYS, 0);
        }

        public TerminalNode T_DEC() {
            return getToken(StartDBSqlParser.T_DEC, 0);
        }

        public TerminalNode T_DECIMAL() {
            return getToken(StartDBSqlParser.T_DECIMAL, 0);
        }

        public TerminalNode T_DECLARE() {
            return getToken(StartDBSqlParser.T_DECLARE, 0);
        }

        public TerminalNode T_DEFAULT() {
            return getToken(StartDBSqlParser.T_DEFAULT, 0);
        }

        public TerminalNode T_DEFERRED() {
            return getToken(StartDBSqlParser.T_DEFERRED, 0);
        }

        public TerminalNode T_DEFINED() {
            return getToken(StartDBSqlParser.T_DEFINED, 0);
        }

        public TerminalNode T_DEFINER() {
            return getToken(StartDBSqlParser.T_DEFINER, 0);
        }

        public TerminalNode T_DEFINITION() {
            return getToken(StartDBSqlParser.T_DEFINITION, 0);
        }

        public TerminalNode T_DELETE() {
            return getToken(StartDBSqlParser.T_DELETE, 0);
        }

        public TerminalNode T_DELIMITED() {
            return getToken(StartDBSqlParser.T_DELIMITED, 0);
        }

        public TerminalNode T_DELIMITER() {
            return getToken(StartDBSqlParser.T_DELIMITER, 0);
        }

        public TerminalNode T_DENSE_RANK() {
            return getToken(StartDBSqlParser.T_DENSE_RANK, 0);
        }

        public TerminalNode T_DESC() {
            return getToken(StartDBSqlParser.T_DESC, 0);
        }

        public TerminalNode T_DESCRIBE() {
            return getToken(StartDBSqlParser.T_DESCRIBE, 0);
        }

        public TerminalNode T_DIAGNOSTICS() {
            return getToken(StartDBSqlParser.T_DIAGNOSTICS, 0);
        }

        public TerminalNode T_DIR() {
            return getToken(StartDBSqlParser.T_DIR, 0);
        }

        public TerminalNode T_DIRECTORY() {
            return getToken(StartDBSqlParser.T_DIRECTORY, 0);
        }

        public TerminalNode T_DISTINCT() {
            return getToken(StartDBSqlParser.T_DISTINCT, 0);
        }

        public TerminalNode T_DISTRIBUTE() {
            return getToken(StartDBSqlParser.T_DISTRIBUTE, 0);
        }

        public TerminalNode T_DO() {
            return getToken(StartDBSqlParser.T_DO, 0);
        }

        public TerminalNode T_DOUBLE() {
            return getToken(StartDBSqlParser.T_DOUBLE, 0);
        }

        public TerminalNode T_DOWNLOAD() {
            return getToken(StartDBSqlParser.T_DOWNLOAD, 0);
        }

        public TerminalNode T_DROP() {
            return getToken(StartDBSqlParser.T_DROP, 0);
        }

        public TerminalNode T_DYNAMIC() {
            return getToken(StartDBSqlParser.T_DYNAMIC, 0);
        }

        public TerminalNode T_ENABLE() {
            return getToken(StartDBSqlParser.T_ENABLE, 0);
        }

        public TerminalNode T_ENGINE() {
            return getToken(StartDBSqlParser.T_ENGINE, 0);
        }

        public TerminalNode T_ESCAPED() {
            return getToken(StartDBSqlParser.T_ESCAPED, 0);
        }

        public TerminalNode T_EXCEPT() {
            return getToken(StartDBSqlParser.T_EXCEPT, 0);
        }

        public TerminalNode T_EXEC() {
            return getToken(StartDBSqlParser.T_EXEC, 0);
        }

        public TerminalNode T_EXECUTE() {
            return getToken(StartDBSqlParser.T_EXECUTE, 0);
        }

        public TerminalNode T_EXCEPTION() {
            return getToken(StartDBSqlParser.T_EXCEPTION, 0);
        }

        public TerminalNode T_EXCLUSIVE() {
            return getToken(StartDBSqlParser.T_EXCLUSIVE, 0);
        }

        public TerminalNode T_EXISTS() {
            return getToken(StartDBSqlParser.T_EXISTS, 0);
        }

        public TerminalNode T_EXIT() {
            return getToken(StartDBSqlParser.T_EXIT, 0);
        }

        public TerminalNode T_FALLBACK() {
            return getToken(StartDBSqlParser.T_FALLBACK, 0);
        }

        public TerminalNode T_FALSE() {
            return getToken(StartDBSqlParser.T_FALSE, 0);
        }

        public TerminalNode T_FETCH() {
            return getToken(StartDBSqlParser.T_FETCH, 0);
        }

        public TerminalNode T_FIELDS() {
            return getToken(StartDBSqlParser.T_FIELDS, 0);
        }

        public TerminalNode T_FILE() {
            return getToken(StartDBSqlParser.T_FILE, 0);
        }

        public TerminalNode T_FILES() {
            return getToken(StartDBSqlParser.T_FILES, 0);
        }

        public TerminalNode T_FIRST_VALUE() {
            return getToken(StartDBSqlParser.T_FIRST_VALUE, 0);
        }

        public TerminalNode T_FLOAT() {
            return getToken(StartDBSqlParser.T_FLOAT, 0);
        }

        public TerminalNode T_FOR() {
            return getToken(StartDBSqlParser.T_FOR, 0);
        }

        public TerminalNode T_FOREIGN() {
            return getToken(StartDBSqlParser.T_FOREIGN, 0);
        }

        public TerminalNode T_FORMAT() {
            return getToken(StartDBSqlParser.T_FORMAT, 0);
        }

        public TerminalNode T_FOUND() {
            return getToken(StartDBSqlParser.T_FOUND, 0);
        }

        public TerminalNode T_FROM() {
            return getToken(StartDBSqlParser.T_FROM, 0);
        }

        public TerminalNode T_FULL() {
            return getToken(StartDBSqlParser.T_FULL, 0);
        }

        public TerminalNode T_FUNCTION() {
            return getToken(StartDBSqlParser.T_FUNCTION, 0);
        }

        public TerminalNode T_GET() {
            return getToken(StartDBSqlParser.T_GET, 0);
        }

        public TerminalNode T_GLOBAL() {
            return getToken(StartDBSqlParser.T_GLOBAL, 0);
        }

        public TerminalNode T_GO() {
            return getToken(StartDBSqlParser.T_GO, 0);
        }

        public TerminalNode T_GRANT() {
            return getToken(StartDBSqlParser.T_GRANT, 0);
        }

        public TerminalNode T_GROUP() {
            return getToken(StartDBSqlParser.T_GROUP, 0);
        }

        public TerminalNode T_HANDLER() {
            return getToken(StartDBSqlParser.T_HANDLER, 0);
        }

        public TerminalNode T_HASH() {
            return getToken(StartDBSqlParser.T_HASH, 0);
        }

        public TerminalNode T_HAVING() {
            return getToken(StartDBSqlParser.T_HAVING, 0);
        }

        public TerminalNode T_HOST() {
            return getToken(StartDBSqlParser.T_HOST, 0);
        }

        public TerminalNode T_IDENTITY() {
            return getToken(StartDBSqlParser.T_IDENTITY, 0);
        }

        public TerminalNode T_IF() {
            return getToken(StartDBSqlParser.T_IF, 0);
        }

        public TerminalNode T_IGNORE() {
            return getToken(StartDBSqlParser.T_IGNORE, 0);
        }

        public TerminalNode T_IMMEDIATE() {
            return getToken(StartDBSqlParser.T_IMMEDIATE, 0);
        }

        public TerminalNode T_IN() {
            return getToken(StartDBSqlParser.T_IN, 0);
        }

        public TerminalNode T_INCLUDE() {
            return getToken(StartDBSqlParser.T_INCLUDE, 0);
        }

        public TerminalNode T_INDEX() {
            return getToken(StartDBSqlParser.T_INDEX, 0);
        }

        public TerminalNode T_INITRANS() {
            return getToken(StartDBSqlParser.T_INITRANS, 0);
        }

        public TerminalNode T_INNER() {
            return getToken(StartDBSqlParser.T_INNER, 0);
        }

        public TerminalNode T_INOUT() {
            return getToken(StartDBSqlParser.T_INOUT, 0);
        }

        public TerminalNode T_INSERT() {
            return getToken(StartDBSqlParser.T_INSERT, 0);
        }

        public TerminalNode T_INT() {
            return getToken(StartDBSqlParser.T_INT, 0);
        }

        public TerminalNode T_INT2() {
            return getToken(StartDBSqlParser.T_INT2, 0);
        }

        public TerminalNode T_INT4() {
            return getToken(StartDBSqlParser.T_INT4, 0);
        }

        public TerminalNode T_INT8() {
            return getToken(StartDBSqlParser.T_INT8, 0);
        }

        public TerminalNode T_INTEGER() {
            return getToken(StartDBSqlParser.T_INTEGER, 0);
        }

        public TerminalNode T_INTERSECT() {
            return getToken(StartDBSqlParser.T_INTERSECT, 0);
        }

        public TerminalNode T_INTERVAL() {
            return getToken(StartDBSqlParser.T_INTERVAL, 0);
        }

        public TerminalNode T_INTO() {
            return getToken(StartDBSqlParser.T_INTO, 0);
        }

        public TerminalNode T_INVOKER() {
            return getToken(StartDBSqlParser.T_INVOKER, 0);
        }

        public TerminalNode T_ITEMS() {
            return getToken(StartDBSqlParser.T_ITEMS, 0);
        }

        public TerminalNode T_IS() {
            return getToken(StartDBSqlParser.T_IS, 0);
        }

        public TerminalNode T_ISOPEN() {
            return getToken(StartDBSqlParser.T_ISOPEN, 0);
        }

        public TerminalNode T_JOIN() {
            return getToken(StartDBSqlParser.T_JOIN, 0);
        }

        public TerminalNode T_KEEP() {
            return getToken(StartDBSqlParser.T_KEEP, 0);
        }

        public TerminalNode T_KEY() {
            return getToken(StartDBSqlParser.T_KEY, 0);
        }

        public TerminalNode T_KEYS() {
            return getToken(StartDBSqlParser.T_KEYS, 0);
        }

        public TerminalNode T_LAG() {
            return getToken(StartDBSqlParser.T_LAG, 0);
        }

        public TerminalNode T_LANGUAGE() {
            return getToken(StartDBSqlParser.T_LANGUAGE, 0);
        }

        public TerminalNode T_LAST_VALUE() {
            return getToken(StartDBSqlParser.T_LAST_VALUE, 0);
        }

        public TerminalNode T_LEAD() {
            return getToken(StartDBSqlParser.T_LEAD, 0);
        }

        public TerminalNode T_LEAVE() {
            return getToken(StartDBSqlParser.T_LEAVE, 0);
        }

        public TerminalNode T_LEFT() {
            return getToken(StartDBSqlParser.T_LEFT, 0);
        }

        public TerminalNode T_LIKE() {
            return getToken(StartDBSqlParser.T_LIKE, 0);
        }

        public TerminalNode T_LIMIT() {
            return getToken(StartDBSqlParser.T_LIMIT, 0);
        }

        public TerminalNode T_LINES() {
            return getToken(StartDBSqlParser.T_LINES, 0);
        }

        public TerminalNode T_LOCAL() {
            return getToken(StartDBSqlParser.T_LOCAL, 0);
        }

        public TerminalNode T_LOCATION() {
            return getToken(StartDBSqlParser.T_LOCATION, 0);
        }

        public TerminalNode T_LOCATOR() {
            return getToken(StartDBSqlParser.T_LOCATOR, 0);
        }

        public TerminalNode T_LOCATORS() {
            return getToken(StartDBSqlParser.T_LOCATORS, 0);
        }

        public TerminalNode T_LOCKS() {
            return getToken(StartDBSqlParser.T_LOCKS, 0);
        }

        public TerminalNode T_LOG() {
            return getToken(StartDBSqlParser.T_LOG, 0);
        }

        public TerminalNode T_LOGGED() {
            return getToken(StartDBSqlParser.T_LOGGED, 0);
        }

        public TerminalNode T_LOGGING() {
            return getToken(StartDBSqlParser.T_LOGGING, 0);
        }

        public TerminalNode T_LOOP() {
            return getToken(StartDBSqlParser.T_LOOP, 0);
        }

        public TerminalNode T_MAP() {
            return getToken(StartDBSqlParser.T_MAP, 0);
        }

        public TerminalNode T_MATCHED() {
            return getToken(StartDBSqlParser.T_MATCHED, 0);
        }

        public TerminalNode T_MAX() {
            return getToken(StartDBSqlParser.T_MAX, 0);
        }

        public TerminalNode T_MAXTRANS() {
            return getToken(StartDBSqlParser.T_MAXTRANS, 0);
        }

        public TerminalNode T_MERGE() {
            return getToken(StartDBSqlParser.T_MERGE, 0);
        }

        public TerminalNode T_MESSAGE_TEXT() {
            return getToken(StartDBSqlParser.T_MESSAGE_TEXT, 0);
        }

        public TerminalNode T_MICROSECOND() {
            return getToken(StartDBSqlParser.T_MICROSECOND, 0);
        }

        public TerminalNode T_MICROSECONDS() {
            return getToken(StartDBSqlParser.T_MICROSECONDS, 0);
        }

        public TerminalNode T_MIN() {
            return getToken(StartDBSqlParser.T_MIN, 0);
        }

        public TerminalNode T_MULTISET() {
            return getToken(StartDBSqlParser.T_MULTISET, 0);
        }

        public TerminalNode T_NCHAR() {
            return getToken(StartDBSqlParser.T_NCHAR, 0);
        }

        public TerminalNode T_NEW() {
            return getToken(StartDBSqlParser.T_NEW, 0);
        }

        public TerminalNode T_NVARCHAR() {
            return getToken(StartDBSqlParser.T_NVARCHAR, 0);
        }

        public TerminalNode T_NO() {
            return getToken(StartDBSqlParser.T_NO, 0);
        }

        public TerminalNode T_NOCOMPRESS() {
            return getToken(StartDBSqlParser.T_NOCOMPRESS, 0);
        }

        public TerminalNode T_NOCOUNT() {
            return getToken(StartDBSqlParser.T_NOCOUNT, 0);
        }

        public TerminalNode T_NOLOGGING() {
            return getToken(StartDBSqlParser.T_NOLOGGING, 0);
        }

        public TerminalNode T_NONE() {
            return getToken(StartDBSqlParser.T_NONE, 0);
        }

        public TerminalNode T_NOT() {
            return getToken(StartDBSqlParser.T_NOT, 0);
        }

        public TerminalNode T_NOTFOUND() {
            return getToken(StartDBSqlParser.T_NOTFOUND, 0);
        }

        public TerminalNode T_NUMERIC() {
            return getToken(StartDBSqlParser.T_NUMERIC, 0);
        }

        public TerminalNode T_NUMBER() {
            return getToken(StartDBSqlParser.T_NUMBER, 0);
        }

        public TerminalNode T_OBJECT() {
            return getToken(StartDBSqlParser.T_OBJECT, 0);
        }

        public TerminalNode T_OFF() {
            return getToken(StartDBSqlParser.T_OFF, 0);
        }

        public TerminalNode T_ON() {
            return getToken(StartDBSqlParser.T_ON, 0);
        }

        public TerminalNode T_ONLY() {
            return getToken(StartDBSqlParser.T_ONLY, 0);
        }

        public TerminalNode T_OPEN() {
            return getToken(StartDBSqlParser.T_OPEN, 0);
        }

        public TerminalNode T_OR() {
            return getToken(StartDBSqlParser.T_OR, 0);
        }

        public TerminalNode T_ORDER() {
            return getToken(StartDBSqlParser.T_ORDER, 0);
        }

        public TerminalNode T_OUT() {
            return getToken(StartDBSqlParser.T_OUT, 0);
        }

        public TerminalNode T_OUTER() {
            return getToken(StartDBSqlParser.T_OUTER, 0);
        }

        public TerminalNode T_OVER() {
            return getToken(StartDBSqlParser.T_OVER, 0);
        }

        public TerminalNode T_OVERWRITE() {
            return getToken(StartDBSqlParser.T_OVERWRITE, 0);
        }

        public TerminalNode T_OWNER() {
            return getToken(StartDBSqlParser.T_OWNER, 0);
        }

        public TerminalNode T_PACKAGE() {
            return getToken(StartDBSqlParser.T_PACKAGE, 0);
        }

        public TerminalNode T_PART_COUNT() {
            return getToken(StartDBSqlParser.T_PART_COUNT, 0);
        }

        public TerminalNode T_PART_LOC() {
            return getToken(StartDBSqlParser.T_PART_LOC, 0);
        }

        public TerminalNode T_PARTITION() {
            return getToken(StartDBSqlParser.T_PARTITION, 0);
        }

        public TerminalNode T_PCTFREE() {
            return getToken(StartDBSqlParser.T_PCTFREE, 0);
        }

        public TerminalNode T_PCTUSED() {
            return getToken(StartDBSqlParser.T_PCTUSED, 0);
        }

        public TerminalNode T_PRECISION() {
            return getToken(StartDBSqlParser.T_PRECISION, 0);
        }

        public TerminalNode T_PRESERVE() {
            return getToken(StartDBSqlParser.T_PRESERVE, 0);
        }

        public TerminalNode T_PRIMARY() {
            return getToken(StartDBSqlParser.T_PRIMARY, 0);
        }

        public TerminalNode T_PRINT() {
            return getToken(StartDBSqlParser.T_PRINT, 0);
        }

        public TerminalNode T_PROC() {
            return getToken(StartDBSqlParser.T_PROC, 0);
        }

        public TerminalNode T_PROCEDURE() {
            return getToken(StartDBSqlParser.T_PROCEDURE, 0);
        }

        public TerminalNode T_PWD() {
            return getToken(StartDBSqlParser.T_PWD, 0);
        }

        public TerminalNode T_QUALIFY() {
            return getToken(StartDBSqlParser.T_QUALIFY, 0);
        }

        public TerminalNode T_QUERY_BAND() {
            return getToken(StartDBSqlParser.T_QUERY_BAND, 0);
        }

        public TerminalNode T_QUIT() {
            return getToken(StartDBSqlParser.T_QUIT, 0);
        }

        public TerminalNode T_QUOTED_IDENTIFIER() {
            return getToken(StartDBSqlParser.T_QUOTED_IDENTIFIER, 0);
        }

        public TerminalNode T_RAISE() {
            return getToken(StartDBSqlParser.T_RAISE, 0);
        }

        public TerminalNode T_RANK() {
            return getToken(StartDBSqlParser.T_RANK, 0);
        }

        public TerminalNode T_REAL() {
            return getToken(StartDBSqlParser.T_REAL, 0);
        }

        public TerminalNode T_REFERENCES() {
            return getToken(StartDBSqlParser.T_REFERENCES, 0);
        }

        public TerminalNode T_REGEXP() {
            return getToken(StartDBSqlParser.T_REGEXP, 0);
        }

        public TerminalNode T_RR() {
            return getToken(StartDBSqlParser.T_RR, 0);
        }

        public TerminalNode T_REPLACE() {
            return getToken(StartDBSqlParser.T_REPLACE, 0);
        }

        public TerminalNode T_RESIGNAL() {
            return getToken(StartDBSqlParser.T_RESIGNAL, 0);
        }

        public TerminalNode T_RESTRICT() {
            return getToken(StartDBSqlParser.T_RESTRICT, 0);
        }

        public TerminalNode T_RESULT() {
            return getToken(StartDBSqlParser.T_RESULT, 0);
        }

        public TerminalNode T_RESULT_SET_LOCATOR() {
            return getToken(StartDBSqlParser.T_RESULT_SET_LOCATOR, 0);
        }

        public TerminalNode T_RETURN() {
            return getToken(StartDBSqlParser.T_RETURN, 0);
        }

        public TerminalNode T_RETURNS() {
            return getToken(StartDBSqlParser.T_RETURNS, 0);
        }

        public TerminalNode T_REVERSE() {
            return getToken(StartDBSqlParser.T_REVERSE, 0);
        }

        public TerminalNode T_RIGHT() {
            return getToken(StartDBSqlParser.T_RIGHT, 0);
        }

        public TerminalNode T_RLIKE() {
            return getToken(StartDBSqlParser.T_RLIKE, 0);
        }

        public TerminalNode T_RS() {
            return getToken(StartDBSqlParser.T_RS, 0);
        }

        public TerminalNode T_ROLE() {
            return getToken(StartDBSqlParser.T_ROLE, 0);
        }

        public TerminalNode T_ROLLBACK() {
            return getToken(StartDBSqlParser.T_ROLLBACK, 0);
        }

        public TerminalNode T_ROW() {
            return getToken(StartDBSqlParser.T_ROW, 0);
        }

        public TerminalNode T_ROWS() {
            return getToken(StartDBSqlParser.T_ROWS, 0);
        }

        public TerminalNode T_ROW_COUNT() {
            return getToken(StartDBSqlParser.T_ROW_COUNT, 0);
        }

        public TerminalNode T_ROW_NUMBER() {
            return getToken(StartDBSqlParser.T_ROW_NUMBER, 0);
        }

        public TerminalNode T_SCHEMA() {
            return getToken(StartDBSqlParser.T_SCHEMA, 0);
        }

        public TerminalNode T_SECOND() {
            return getToken(StartDBSqlParser.T_SECOND, 0);
        }

        public TerminalNode T_SECONDS() {
            return getToken(StartDBSqlParser.T_SECONDS, 0);
        }

        public TerminalNode T_SECURITY() {
            return getToken(StartDBSqlParser.T_SECURITY, 0);
        }

        public TerminalNode T_SEGMENT() {
            return getToken(StartDBSqlParser.T_SEGMENT, 0);
        }

        public TerminalNode T_SEL() {
            return getToken(StartDBSqlParser.T_SEL, 0);
        }

        public TerminalNode T_SELECT() {
            return getToken(StartDBSqlParser.T_SELECT, 0);
        }

        public TerminalNode T_SESSION() {
            return getToken(StartDBSqlParser.T_SESSION, 0);
        }

        public TerminalNode T_SESSIONS() {
            return getToken(StartDBSqlParser.T_SESSIONS, 0);
        }

        public TerminalNode T_SET() {
            return getToken(StartDBSqlParser.T_SET, 0);
        }

        public TerminalNode T_SETS() {
            return getToken(StartDBSqlParser.T_SETS, 0);
        }

        public TerminalNode T_SIGNAL() {
            return getToken(StartDBSqlParser.T_SIGNAL, 0);
        }

        public TerminalNode T_SIMPLE_DOUBLE() {
            return getToken(StartDBSqlParser.T_SIMPLE_DOUBLE, 0);
        }

        public TerminalNode T_SIMPLE_FLOAT() {
            return getToken(StartDBSqlParser.T_SIMPLE_FLOAT, 0);
        }

        public TerminalNode T_SMALLDATETIME() {
            return getToken(StartDBSqlParser.T_SMALLDATETIME, 0);
        }

        public TerminalNode T_SMALLINT() {
            return getToken(StartDBSqlParser.T_SMALLINT, 0);
        }

        public TerminalNode T_SQL() {
            return getToken(StartDBSqlParser.T_SQL, 0);
        }

        public TerminalNode T_SQLEXCEPTION() {
            return getToken(StartDBSqlParser.T_SQLEXCEPTION, 0);
        }

        public TerminalNode T_SQLINSERT() {
            return getToken(StartDBSqlParser.T_SQLINSERT, 0);
        }

        public TerminalNode T_SQLSTATE() {
            return getToken(StartDBSqlParser.T_SQLSTATE, 0);
        }

        public TerminalNode T_SQLWARNING() {
            return getToken(StartDBSqlParser.T_SQLWARNING, 0);
        }

        public TerminalNode T_STATS() {
            return getToken(StartDBSqlParser.T_STATS, 0);
        }

        public TerminalNode T_STATISTICS() {
            return getToken(StartDBSqlParser.T_STATISTICS, 0);
        }

        public TerminalNode T_STEP() {
            return getToken(StartDBSqlParser.T_STEP, 0);
        }

        public TerminalNode T_STDEV() {
            return getToken(StartDBSqlParser.T_STDEV, 0);
        }

        public TerminalNode T_STORAGE() {
            return getToken(StartDBSqlParser.T_STORAGE, 0);
        }

        public TerminalNode T_STORE() {
            return getToken(StartDBSqlParser.T_STORE, 0);
        }

        public TerminalNode T_STORED() {
            return getToken(StartDBSqlParser.T_STORED, 0);
        }

        public TerminalNode T_STRING() {
            return getToken(StartDBSqlParser.T_STRING, 0);
        }

        public TerminalNode T_SUBDIR() {
            return getToken(StartDBSqlParser.T_SUBDIR, 0);
        }

        public TerminalNode T_SUBSTRING() {
            return getToken(StartDBSqlParser.T_SUBSTRING, 0);
        }

        public TerminalNode T_SUM() {
            return getToken(StartDBSqlParser.T_SUM, 0);
        }

        public TerminalNode T_SUMMARY() {
            return getToken(StartDBSqlParser.T_SUMMARY, 0);
        }

        public TerminalNode T_SYSDATE() {
            return getToken(StartDBSqlParser.T_SYSDATE, 0);
        }

        public TerminalNode T_SYS_REFCURSOR() {
            return getToken(StartDBSqlParser.T_SYS_REFCURSOR, 0);
        }

        public TerminalNode T_TABLE() {
            return getToken(StartDBSqlParser.T_TABLE, 0);
        }

        public TerminalNode T_TABLESPACE() {
            return getToken(StartDBSqlParser.T_TABLESPACE, 0);
        }

        public TerminalNode T_TEMPORARY() {
            return getToken(StartDBSqlParser.T_TEMPORARY, 0);
        }

        public TerminalNode T_TERMINATED() {
            return getToken(StartDBSqlParser.T_TERMINATED, 0);
        }

        public TerminalNode T_TEXTIMAGE_ON() {
            return getToken(StartDBSqlParser.T_TEXTIMAGE_ON, 0);
        }

        public TerminalNode T_THEN() {
            return getToken(StartDBSqlParser.T_THEN, 0);
        }

        public TerminalNode T_TIMESTAMP() {
            return getToken(StartDBSqlParser.T_TIMESTAMP, 0);
        }

        public TerminalNode T_TITLE() {
            return getToken(StartDBSqlParser.T_TITLE, 0);
        }

        public TerminalNode T_TO() {
            return getToken(StartDBSqlParser.T_TO, 0);
        }

        public TerminalNode T_TOP() {
            return getToken(StartDBSqlParser.T_TOP, 0);
        }

        public TerminalNode T_TRANSACTION() {
            return getToken(StartDBSqlParser.T_TRANSACTION, 0);
        }

        public TerminalNode T_TRIM() {
            return getToken(StartDBSqlParser.T_TRIM, 0);
        }

        public TerminalNode T_TRUE() {
            return getToken(StartDBSqlParser.T_TRUE, 0);
        }

        public TerminalNode T_TRUNCATE() {
            return getToken(StartDBSqlParser.T_TRUNCATE, 0);
        }

        public TerminalNode T_UNIQUE() {
            return getToken(StartDBSqlParser.T_UNIQUE, 0);
        }

        public TerminalNode T_UPDATE() {
            return getToken(StartDBSqlParser.T_UPDATE, 0);
        }

        public TerminalNode T_UR() {
            return getToken(StartDBSqlParser.T_UR, 0);
        }

        public TerminalNode T_USE() {
            return getToken(StartDBSqlParser.T_USE, 0);
        }

        public TerminalNode T_USER() {
            return getToken(StartDBSqlParser.T_USER, 0);
        }

        public TerminalNode T_USING() {
            return getToken(StartDBSqlParser.T_USING, 0);
        }

        public TerminalNode T_VALUE() {
            return getToken(StartDBSqlParser.T_VALUE, 0);
        }

        public TerminalNode T_VALUES() {
            return getToken(StartDBSqlParser.T_VALUES, 0);
        }

        public TerminalNode T_VAR() {
            return getToken(StartDBSqlParser.T_VAR, 0);
        }

        public TerminalNode T_VARCHAR() {
            return getToken(StartDBSqlParser.T_VARCHAR, 0);
        }

        public TerminalNode T_VARCHAR2() {
            return getToken(StartDBSqlParser.T_VARCHAR2, 0);
        }

        public TerminalNode T_VARYING() {
            return getToken(StartDBSqlParser.T_VARYING, 0);
        }

        public TerminalNode T_VARIANCE() {
            return getToken(StartDBSqlParser.T_VARIANCE, 0);
        }

        public TerminalNode T_VOLATILE() {
            return getToken(StartDBSqlParser.T_VOLATILE, 0);
        }

        public TerminalNode T_WHILE() {
            return getToken(StartDBSqlParser.T_WHILE, 0);
        }

        public TerminalNode T_WITH() {
            return getToken(StartDBSqlParser.T_WITH, 0);
        }

        public TerminalNode T_WITHOUT() {
            return getToken(StartDBSqlParser.T_WITHOUT, 0);
        }

        public TerminalNode T_WORK() {
            return getToken(StartDBSqlParser.T_WORK, 0);
        }

        public TerminalNode T_XACT_ABORT() {
            return getToken(StartDBSqlParser.T_XACT_ABORT, 0);
        }

        public TerminalNode T_XML() {
            return getToken(StartDBSqlParser.T_XML, 0);
        }

        public TerminalNode T_YES() {
            return getToken(StartDBSqlParser.T_YES, 0);
        }

        public NonReservedWordsContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_nonReservedWords;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof StartDBSqlVisitor) return ((StartDBSqlVisitor<
                ? extends T>) visitor).visitNonReservedWords(this);
            else return visitor.visitChildren(this);
        }
    }

    public final NonReservedWordsContext nonReservedWords() throws RecognitionException {
        NonReservedWordsContext _localctx = new NonReservedWordsContext(_ctx, getState());
        enterRule(_localctx, 246, RULE_nonReservedWords);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1837);
                _la = _input.LA(1);
                if (!((((_la) & ~0x3f) == 0
                    && ((1L << _la) & ((1L << T_ACTION) | (1L << T_ADD2) | (1L << T_ALL) | (1L
                        << T_ALLOCATE) | (1L << T_ALTER) | (1L << T_AND) | (1L << T_ANSI_NULLS)
                        | (1L << T_ANSI_PADDING) | (1L << T_AS) | (1L << T_ASC) | (1L
                            << T_ASSOCIATE) | (1L << T_AT) | (1L << T_AVG) | (1L << T_BATCHSIZE)
                        | (1L << T_BEGIN) | (1L << T_BETWEEN) | (1L << T_BIGINT) | (1L
                            << T_BINARY_DOUBLE) | (1L << T_BINARY_FLOAT) | (1L << T_BIT) | (1L
                                << T_BODY) | (1L << T_BREAK) | (1L << T_BY) | (1L << T_BYTE) | (1L
                                    << T_CALL) | (1L << T_CALLER) | (1L << T_CASCADE) | (1L
                                        << T_CASE) | (1L << T_CASESPECIFIC) | (1L << T_CAST) | (1L
                                            << T_CHAR) | (1L << T_CHARACTER) | (1L << T_CHARSET)
                        | (1L << T_CLIENT) | (1L << T_CLOSE) | (1L << T_CLUSTERED) | (1L << T_CMP)
                        | (1L << T_COLLECT) | (1L << T_COLLECTION) | (1L << T_COLUMN) | (1L
                            << T_COMMENT) | (1L << T_CONSTANT) | (1L << T_COMMIT) | (1L
                                << T_COMPRESS) | (1L << T_CONCAT) | (1L << T_CONDITION) | (1L
                                    << T_CONSTRAINT) | (1L << T_CONTINUE) | (1L << T_COPY) | (1L
                                        << T_COUNT) | (1L << T_COUNT_BIG) | (1L << T_CREATION) | (1L
                                            << T_CREATOR) | (1L << T_CS) | (1L << T_CURRENT) | (1L
                                                << T_CURRENT_SCHEMA))) != 0)
                    || ((((_la - 64)) & ~0x3f) == 0
                        && ((1L << (_la - 64)) & ((1L << (T_CURSOR - 64)) | (1L << (T_DATABASE
                            - 64)) | (1L << (T_DATA - 64)) | (1L << (T_DATE - 64)) | (1L
                                << (T_DATETIME - 64)) | (1L << (T_DAY - 64)) | (1L << (T_DAYS - 64))
                            | (1L << (T_DEC - 64)) | (1L << (T_DECIMAL - 64)) | (1L << (T_DECLARE
                                - 64)) | (1L << (T_DEFAULT - 64)) | (1L << (T_DEFERRED - 64)) | (1L
                                    << (T_DEFINED - 64)) | (1L << (T_DEFINER - 64)) | (1L
                                        << (T_DEFINITION - 64)) | (1L << (T_DELETE - 64)) | (1L
                                            << (T_DELIMITED - 64)) | (1L << (T_DELIMITER - 64))
                            | (1L << (T_DESC - 64)) | (1L << (T_DESCRIBE - 64)) | (1L
                                << (T_DIAGNOSTICS - 64)) | (1L << (T_DIR - 64)) | (1L
                                    << (T_DIRECTORY - 64)) | (1L << (T_DISTINCT - 64)) | (1L
                                        << (T_DISTRIBUTE - 64)) | (1L << (T_DO - 64)) | (1L
                                            << (T_DOUBLE - 64)) | (1L << (T_DOWNLOAD - 64)) | (1L
                                                << (T_DROP - 64)) | (1L << (T_DYNAMIC - 64)) | (1L
                                                    << (T_ENABLE - 64)) | (1L << (T_ENGINE - 64))
                            | (1L << (T_ESCAPED - 64)) | (1L << (T_EXCEPT - 64)) | (1L << (T_EXEC
                                - 64)) | (1L << (T_EXECUTE - 64)) | (1L << (T_EXCEPTION - 64)) | (1L
                                    << (T_EXCLUSIVE - 64)) | (1L << (T_EXISTS - 64)) | (1L
                                        << (T_EXIT - 64)) | (1L << (T_FALLBACK - 64)) | (1L
                                            << (T_FALSE - 64)) | (1L << (T_FETCH - 64)) | (1L
                                                << (T_FIELDS - 64)) | (1L << (T_FILE - 64)) | (1L
                                                    << (T_FILES - 64)) | (1L << (T_FLOAT - 64))
                            | (1L << (T_FOR - 64)) | (1L << (T_FOREIGN - 64)) | (1L << (T_FORMAT
                                - 64)) | (1L << (T_FOUND - 64)) | (1L << (T_FROM - 64)) | (1L
                                    << (T_FULL - 64)) | (1L << (T_FUNCTION - 64)) | (1L << (T_GET
                                        - 64)) | (1L << (T_GLOBAL - 64)) | (1L << (T_GO - 64)) | (1L
                                            << (T_GRANT - 64)))) != 0)
                    || ((((_la - 128)) & ~0x3f) == 0
                        && ((1L << (_la - 128)) & ((1L << (T_GROUP - 128)) | (1L << (T_HANDLER
                            - 128)) | (1L << (T_HASH - 128)) | (1L << (T_HAVING - 128)) | (1L
                                << (T_HOST - 128)) | (1L << (T_IDENTITY - 128)) | (1L << (T_IF
                                    - 128)) | (1L << (T_IGNORE - 128)) | (1L << (T_IMMEDIATE - 128))
                            | (1L << (T_IN - 128)) | (1L << (T_INCLUDE - 128)) | (1L << (T_INDEX
                                - 128)) | (1L << (T_INITRANS - 128)) | (1L << (T_INNER - 128)) | (1L
                                    << (T_INOUT - 128)) | (1L << (T_INSERT - 128)) | (1L << (T_INT
                                        - 128)) | (1L << (T_INT2 - 128)) | (1L << (T_INT4 - 128))
                            | (1L << (T_INT8 - 128)) | (1L << (T_INTEGER - 128)) | (1L
                                << (T_INTERSECT - 128)) | (1L << (T_INTERVAL - 128)) | (1L
                                    << (T_INTO - 128)) | (1L << (T_INVOKER - 128)) | (1L << (T_IS
                                        - 128)) | (1L << (T_ISOPEN - 128)) | (1L << (T_ITEMS - 128))
                            | (1L << (T_JOIN - 128)) | (1L << (T_KEEP - 128)) | (1L << (T_KEY
                                - 128)) | (1L << (T_KEYS - 128)) | (1L << (T_LANGUAGE - 128)) | (1L
                                    << (T_LEAVE - 128)) | (1L << (T_LEFT - 128)) | (1L << (T_LIKE
                                        - 128)) | (1L << (T_LIMIT - 128)) | (1L << (T_LINES - 128))
                            | (1L << (T_LOCAL - 128)) | (1L << (T_LOCATION - 128)) | (1L
                                << (T_LOCATOR - 128)) | (1L << (T_LOCATORS - 128)) | (1L << (T_LOCKS
                                    - 128)) | (1L << (T_LOG - 128)) | (1L << (T_LOGGED - 128)) | (1L
                                        << (T_LOGGING - 128)) | (1L << (T_LOOP - 128)) | (1L
                                            << (T_MAP - 128)) | (1L << (T_MATCHED - 128)) | (1L
                                                << (T_MAX - 128)) | (1L << (T_MAXTRANS - 128)) | (1L
                                                    << (T_MERGE - 128)) | (1L << (T_MESSAGE_TEXT
                                                        - 128)) | (1L << (T_MICROSECOND - 128))
                            | (1L << (T_MICROSECONDS - 128)) | (1L << (T_MIN - 128)) | (1L
                                << (T_MULTISET - 128)) | (1L << (T_NCHAR - 128)) | (1L << (T_NEW
                                    - 128)))) != 0)
                    || ((((_la - 192)) & ~0x3f) == 0
                        && ((1L << (_la - 192)) & ((1L << (T_NVARCHAR - 192)) | (1L << (T_NO - 192))
                            | (1L << (T_NOCOUNT - 192)) | (1L << (T_NOCOMPRESS - 192)) | (1L
                                << (T_NOLOGGING - 192)) | (1L << (T_NONE - 192)) | (1L << (T_NOT
                                    - 192)) | (1L << (T_NOTFOUND - 192)) | (1L << (T_NUMERIC - 192))
                            | (1L << (T_NUMBER - 192)) | (1L << (T_OBJECT - 192)) | (1L << (T_OFF
                                - 192)) | (1L << (T_ON - 192)) | (1L << (T_ONLY - 192)) | (1L
                                    << (T_OPEN - 192)) | (1L << (T_OR - 192)) | (1L << (T_ORDER
                                        - 192)) | (1L << (T_OUT - 192)) | (1L << (T_OUTER - 192))
                            | (1L << (T_OVER - 192)) | (1L << (T_OVERWRITE - 192)) | (1L << (T_OWNER
                                - 192)) | (1L << (T_PACKAGE - 192)) | (1L << (T_PARTITION - 192))
                            | (1L << (T_PCTFREE - 192)) | (1L << (T_PCTUSED - 192)) | (1L
                                << (T_PRECISION - 192)) | (1L << (T_PRESERVE - 192)) | (1L
                                    << (T_PRIMARY - 192)) | (1L << (T_PRINT - 192)) | (1L << (T_PROC
                                        - 192)) | (1L << (T_PROCEDURE - 192)) | (1L << (T_QUALIFY
                                            - 192)) | (1L << (T_QUERY_BAND - 192)) | (1L << (T_QUIT
                                                - 192)) | (1L << (T_QUOTED_IDENTIFIER - 192)) | (1L
                                                    << (T_RAISE - 192)) | (1L << (T_REAL - 192))
                            | (1L << (T_REFERENCES - 192)) | (1L << (T_REGEXP - 192)) | (1L
                                << (T_REPLACE - 192)) | (1L << (T_RESIGNAL - 192)) | (1L
                                    << (T_RESTRICT - 192)) | (1L << (T_RESULT - 192)) | (1L
                                        << (T_RESULT_SET_LOCATOR - 192)) | (1L << (T_RETURN - 192))
                            | (1L << (T_RETURNS - 192)) | (1L << (T_REVERSE - 192)) | (1L
                                << (T_RIGHT - 192)) | (1L << (T_RLIKE - 192)) | (1L << (T_ROLE
                                    - 192)) | (1L << (T_ROLLBACK - 192)) | (1L << (T_ROW
                                        - 192)))) != 0)
                    || ((((_la - 256)) & ~0x3f) == 0
                        && ((1L << (_la - 256)) & ((1L << (T_ROWS - 256)) | (1L << (T_ROW_COUNT
                            - 256)) | (1L << (T_RR - 256)) | (1L << (T_RS - 256)) | (1L << (T_PWD
                                - 256)) | (1L << (T_TRIM - 256)) | (1L << (T_SCHEMA - 256)) | (1L
                                    << (T_SECOND - 256)) | (1L << (T_SECONDS - 256)) | (1L
                                        << (T_SECURITY - 256)) | (1L << (T_SEGMENT - 256)) | (1L
                                            << (T_SEL - 256)) | (1L << (T_SELECT - 256)) | (1L
                                                << (T_SET - 256)) | (1L << (T_SESSION - 256)) | (1L
                                                    << (T_SESSIONS - 256)) | (1L << (T_SETS - 256))
                            | (1L << (T_SIGNAL - 256)) | (1L << (T_SIMPLE_DOUBLE - 256)) | (1L
                                << (T_SIMPLE_FLOAT - 256)) | (1L << (T_SMALLDATETIME - 256)) | (1L
                                    << (T_SMALLINT - 256)) | (1L << (T_SQL - 256)) | (1L
                                        << (T_SQLEXCEPTION - 256)) | (1L << (T_SQLINSERT - 256))
                            | (1L << (T_SQLSTATE - 256)) | (1L << (T_SQLWARNING - 256)) | (1L
                                << (T_STATS - 256)) | (1L << (T_STATISTICS - 256)) | (1L << (T_STEP
                                    - 256)) | (1L << (T_STORAGE - 256)) | (1L << (T_STORE - 256))
                            | (1L << (T_STORED - 256)) | (1L << (T_STRING - 256)) | (1L << (T_SUBDIR
                                - 256)) | (1L << (T_SUBSTRING - 256)) | (1L << (T_SUM - 256)) | (1L
                                    << (T_SUMMARY - 256)) | (1L << (T_SYS_REFCURSOR - 256)) | (1L
                                        << (T_TABLE - 256)) | (1L << (T_TABLESPACE - 256)) | (1L
                                            << (T_TEMPORARY - 256)) | (1L << (T_TERMINATED - 256))
                            | (1L << (T_TEXTIMAGE_ON - 256)) | (1L << (T_THEN - 256)) | (1L
                                << (T_TIMESTAMP - 256)) | (1L << (T_TITLE - 256)) | (1L << (T_TO
                                    - 256)) | (1L << (T_TOP - 256)) | (1L << (T_TRANSACTION - 256))
                            | (1L << (T_TRUE - 256)) | (1L << (T_TRUNCATE - 256)))) != 0)
                    || ((((_la - 321)) & ~0x3f) == 0
                        && ((1L << (_la - 321)) & ((1L << (T_UNIQUE - 321)) | (1L << (T_UPDATE
                            - 321)) | (1L << (T_UR - 321)) | (1L << (T_USE - 321)) | (1L << (T_USING
                                - 321)) | (1L << (T_VALUE - 321)) | (1L << (T_VALUES - 321)) | (1L
                                    << (T_VAR - 321)) | (1L << (T_VARCHAR - 321)) | (1L
                                        << (T_VARCHAR2 - 321)) | (1L << (T_VARYING - 321)) | (1L
                                            << (T_VOLATILE - 321)) | (1L << (T_WHILE - 321)) | (1L
                                                << (T_WITH - 321)) | (1L << (T_WITHOUT - 321)) | (1L
                                                    << (T_WORK - 321)) | (1L << (T_XACT_ABORT
                                                        - 321)) | (1L << (T_XML - 321)) | (1L
                                                            << (T_YES - 321)) | (1L
                                                                << (T_ACTIVITY_COUNT - 321)) | (1L
                                                                    << (T_CUME_DIST - 321)) | (1L
                                                                        << (T_CURRENT_DATE - 321))
                            | (1L << (T_CURRENT_TIME - 321)) | (1L << (T_PI - 321)) | (1L
                                << (T_CURRENT_TIMESTAMP - 321)) | (1L << (T_CURRENT_USER - 321))
                            | (1L << (T_DENSE_RANK - 321)) | (1L << (T_FIRST_VALUE - 321)) | (1L
                                << (T_LAG - 321)) | (1L << (T_LAST_VALUE - 321)) | (1L << (T_LEAD
                                    - 321)) | (1L << (T_PART_COUNT - 321)) | (1L << (T_PART_LOC
                                        - 321)) | (1L << (T_RANK - 321)) | (1L << (T_ROW_NUMBER
                                            - 321)) | (1L << (T_STDEV - 321)) | (1L << (T_SYSDATE
                                                - 321)) | (1L << (T_VARIANCE - 321)) | (1L
                                                    << (T_USER - 321)))) != 0))) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
        switch (ruleIndex) {
            case 66:
                return fromAliasClause_sempred((FromAliasClauseContext) _localctx, predIndex);
            case 82:
                return deleteAlias_sempred((DeleteAliasContext) _localctx, predIndex);
            case 84:
                return boolExpr_sempred((BoolExprContext) _localctx, predIndex);
            case 92:
                return expr_sempred((ExprContext) _localctx, predIndex);
            case 110:
                return funcParam_sempred((FuncParamContext) _localctx, predIndex);
        }
        return true;
    }

    private boolean fromAliasClause_sempred(FromAliasClauseContext _localctx, int predIndex) {
        switch (predIndex) {
            case 0:
                return !_input.LT(1).getText().equalsIgnoreCase("EXEC")
                    && !_input.LT(1).getText().equalsIgnoreCase("EXECUTE")
                    && !_input.LT(1).getText().equalsIgnoreCase("INNER")
                    && !_input.LT(1).getText().equalsIgnoreCase("LEFT")
                    && !_input.LT(1).getText().equalsIgnoreCase("GROUP")
                    && !_input.LT(1).getText().equalsIgnoreCase("ORDER")
                    && !_input.LT(1).getText().equalsIgnoreCase("LIMIT")
                    && !_input.LT(1).getText().equalsIgnoreCase("WITH");
        }
        return true;
    }

    private boolean deleteAlias_sempred(DeleteAliasContext _localctx, int predIndex) {
        switch (predIndex) {
            case 1:
                return !_input.LT(1).getText().equalsIgnoreCase("ALL");
        }
        return true;
    }

    private boolean boolExpr_sempred(BoolExprContext _localctx, int predIndex) {
        switch (predIndex) {
            case 2:
                return precpred(_ctx, 2);
        }
        return true;
    }

    private boolean expr_sempred(ExprContext _localctx, int predIndex) {
        switch (predIndex) {
            case 3:
                return precpred(_ctx, 14);
            case 4:
                return precpred(_ctx, 13);
            case 5:
                return precpred(_ctx, 12);
            case 6:
                return precpred(_ctx, 11);
            case 7:
                return precpred(_ctx, 15);
        }
        return true;
    }

    private boolean funcParam_sempred(FuncParamContext _localctx, int predIndex) {
        switch (predIndex) {
            case 8:
                return !_input.LT(1).getText().equalsIgnoreCase("INTO");
        }
        return true;
    }

    public static final String _serializedATN =
        "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\u01a2\u0732\4\2\t"
            + "\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"
            + "\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"
            + "\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"
            + "\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"
            + "\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"
            + ",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"
            + "\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="
            + "\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"
            + "\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"
            + "\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_\4"
            + "`\t`\4a\ta\4b\tb\4c\tc\4d\td\4e\te\4f\tf\4g\tg\4h\th\4i\ti\4j\tj\4k\t"
            + "k\4l\tl\4m\tm\4n\tn\4o\to\4p\tp\4q\tq\4r\tr\4s\ts\4t\tt\4u\tu\4v\tv\4"
            + "w\tw\4x\tx\4y\ty\4z\tz\4{\t{\4|\t|\4}\t}\3\2\3\2\5\2\u00fd\n\2\3\2\3\2"
            + "\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5"
            + "\3\u0112\n\3\3\4\3\4\5\4\u0116\n\4\3\4\3\4\3\5\3\5\3\5\5\5\u011d\n\5\3"
            + "\5\5\5\u0120\n\5\3\6\3\6\3\6\5\6\u0125\n\6\3\7\3\7\5\7\u0129\n\7\3\7\3"
            + "\7\3\7\3\7\3\7\3\7\3\7\5\7\u0132\n\7\3\7\3\7\3\7\5\7\u0137\n\7\3\b\3\b"
            + "\3\b\3\b\7\b\u013d\n\b\f\b\16\b\u0140\13\b\3\b\3\b\5\b\u0144\n\b\3\b\3"
            + "\b\3\b\3\b\3\b\7\b\u014b\n\b\f\b\16\b\u014e\13\b\3\b\3\b\3\t\3\t\3\t\3"
            + "\t\3\t\7\t\u0157\n\t\f\t\16\t\u015a\13\t\3\t\3\t\5\t\u015e\n\t\3\t\5\t"
            + "\u0161\n\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\f"
            + "\3\f\3\f\3\f\3\f\5\f\u0175\n\f\3\f\3\f\5\f\u0179\n\f\3\f\3\f\3\r\3\r\3"
            + "\r\3\r\3\r\3\r\3\r\3\16\5\16\u0185\n\16\3\16\3\16\3\16\3\16\3\16\5\16"
            + "\u018c\n\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u0195\n\16\3\16\5"
            + "\16\u0198\n\16\3\17\3\17\3\17\7\17\u019d\n\17\f\17\16\17\u01a0\13\17\3"
            + "\20\3\20\3\20\7\20\u01a5\n\20\f\20\16\20\u01a8\13\20\3\20\7\20\u01ab\n"
            + "\20\f\20\16\20\u01ae\13\20\3\20\3\20\5\20\u01b2\n\20\3\20\5\20\u01b5\n"
            + "\20\3\21\3\21\3\22\3\22\5\22\u01bb\n\22\3\22\3\22\3\22\3\22\3\22\3\22"
            + "\3\22\3\22\3\22\3\22\7\22\u01c7\n\22\f\22\16\22\u01ca\13\22\3\22\3\22"
            + "\3\22\3\22\3\22\7\22\u01d1\n\22\f\22\16\22\u01d4\13\22\3\22\3\22\3\22"
            + "\5\22\u01d9\n\22\3\23\3\23\3\23\5\23\u01de\n\23\3\23\3\23\3\23\5\23\u01e3"
            + "\n\23\3\23\3\23\3\23\5\23\u01e8\n\23\7\23\u01ea\n\23\f\23\16\23\u01ed"
            + "\13\23\3\23\3\23\5\23\u01f1\n\23\3\23\3\23\3\23\3\23\3\23\3\23\7\23\u01f9"
            + "\n\23\f\23\16\23\u01fc\13\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\7\23\u0205"
            + "\n\23\f\23\16\23\u0208\13\23\3\23\3\23\7\23\u020c\n\23\f\23\16\23\u020f"
            + "\13\23\5\23\u0211\n\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3"
            + "\24\5\24\u021d\n\24\3\25\6\25\u0220\n\25\r\25\16\25\u0221\3\26\3\26\3"
            + "\26\3\27\5\27\u0228\n\27\3\27\3\27\3\30\6\30\u022d\n\30\r\30\16\30\u022e"
            + "\3\31\3\31\3\31\3\31\3\31\5\31\u0236\n\31\3\32\3\32\5\32\u023a\n\32\3"
            + "\32\3\32\3\32\5\32\u023f\n\32\3\32\3\32\5\32\u0243\n\32\3\32\3\32\3\32"
            + "\5\32\u0248\n\32\3\32\5\32\u024b\n\32\3\32\3\32\3\32\5\32\u0250\n\32\3"
            + "\32\5\32\u0253\n\32\3\33\3\33\5\33\u0257\n\33\3\33\3\33\3\33\3\33\3\33"
            + "\3\33\3\33\3\33\7\33\u0261\n\33\f\33\16\33\u0264\13\33\3\33\3\33\3\34"
            + "\3\34\5\34\u026a\n\34\3\35\5\35\u026d\n\35\3\35\3\35\3\35\5\35\u0272\n"
            + "\35\3\35\3\35\5\35\u0276\n\35\5\35\u0278\n\35\3\36\3\36\3\36\3\37\5\37"
            + "\u027e\n\37\3\37\3\37\3\37\3\37\3\37\5\37\u0285\n\37\3\37\5\37\u0288\n"
            + "\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 "
            + "\3 \3 \3 \5 \u02a3\n \5 \u02a5\n \3!\3!\3!\5!\u02aa\n!\3!\3!\5!\u02ae"
            + "\n!\3!\3!\3\"\3\"\3\"\3\"\3\"\5\"\u02b7\n\"\3\"\3\"\7\"\u02bb\n\"\f\""
            + "\16\"\u02be\13\"\3#\3#\3#\3$\3$\3$\3$\5$\u02c7\n$\3$\3$\3%\3%\3%\3%\5"
            + "%\u02cf\n%\3&\3&\3&\3&\5&\u02d5\n&\3&\3&\3\'\3\'\3\'\3\'\3\'\5\'\u02de"
            + "\n\'\5\'\u02e0\n\'\3\'\3\'\5\'\u02e4\n\'\3\'\3\'\5\'\u02e8\n\'\3(\3(\3"
            + "(\3(\7(\u02ee\n(\f(\16(\u02f1\13(\3(\3(\3)\3)\3)\3)\7)\u02f9\n)\f)\16"
            + ")\u02fc\13)\3*\3*\3*\3*\7*\u0302\n*\f*\16*\u0305\13*\3*\3*\3+\3+\5+\u030b"
            + "\n+\3+\3+\3,\3,\3,\3-\5-\u0313\n-\3-\3-\3.\3.\3.\3.\7.\u031b\n.\f.\16"
            + ".\u031e\13.\3/\3/\5/\u0322\n/\3/\3/\3/\3/\3/\3\60\3\60\3\60\3\60\7\60"
            + "\u032d\n\60\f\60\16\60\u0330\13\60\3\60\3\60\3\61\3\61\3\61\3\61\7\61"
            + "\u0338\n\61\f\61\16\61\u033b\13\61\3\61\3\61\3\61\3\61\5\61\u0341\n\61"
            + "\3\62\3\62\3\62\3\62\3\62\5\62\u0348\n\62\3\63\3\63\5\63\u034c\n\63\3"
            + "\63\3\63\5\63\u0350\n\63\3\63\3\63\5\63\u0354\n\63\5\63\u0356\n\63\3\64"
            + "\3\64\3\64\5\64\u035b\n\64\3\64\5\64\u035e\n\64\3\64\5\64\u0361\n\64\3"
            + "\64\5\64\u0364\n\64\3\64\3\64\5\64\u0368\n\64\3\64\5\64\u036b\n\64\3\64"
            + "\5\64\u036e\n\64\3\65\5\65\u0371\n\65\3\65\5\65\u0374\n\65\3\65\3\65\3"
            + "\65\7\65\u0379\n\65\f\65\16\65\u037c\13\65\3\66\3\66\3\67\3\67\3\67\3"
            + "8\38\38\58\u0386\n8\38\38\58\u038a\n8\38\58\u038d\n8\39\59\u0390\n9\3"
            + "9\39\59\u0394\n9\39\39\39\39\79\u039a\n9\f9\169\u039d\139\39\39\39\39"
            + "\39\39\59\u03a5\n9\3:\3:\5:\u03a9\n:\3:\3:\3;\3;\3;\3;\7;\u03b1\n;\f;"
            + "\16;\u03b4\13;\3<\3<\3<\7<\u03b9\n<\f<\16<\u03bc\13<\3=\3=\3=\5=\u03c1"
            + "\n=\3>\3>\5>\u03c5\n>\3>\5>\u03c8\n>\3?\3?\3?\3?\5?\u03ce\n?\3@\3@\3@"
            + "\3@\3@\3@\3@\5@\u03d7\n@\3A\5A\u03da\nA\3A\3A\3A\5A\u03df\nA\3A\5A\u03e2"
            + "\nA\3B\3B\3B\3B\3B\3B\7B\u03ea\nB\fB\16B\u03ed\13B\3B\3B\5B\u03f1\nB\3"
            + "C\3C\3C\3C\3C\7C\u03f8\nC\fC\16C\u03fb\13C\3C\3C\5C\u03ff\nC\3D\3D\5D"
            + "\u0403\nD\3D\3D\3D\3D\3D\7D\u040a\nD\fD\16D\u040d\13D\3D\5D\u0410\nD\3"
            + "E\3E\3F\3F\3F\3G\3G\3G\3G\3G\7G\u041c\nG\fG\16G\u041f\13G\3H\3H\3H\3I"
            + "\3I\3I\3J\3J\3J\3J\3J\7J\u042c\nJ\fJ\16J\u042f\13J\3K\3K\5K\u0433\nK\3"
            + "L\3L\3L\3L\3L\3L\3M\6M\u043c\nM\rM\16M\u043d\3N\3N\3N\3N\3N\3N\3N\3N\3"
            + "N\5N\u0449\nN\5N\u044b\nN\3O\3O\3O\3O\3O\5O\u0452\nO\3O\5O\u0455\nO\3"
            + "P\3P\3P\7P\u045a\nP\fP\16P\u045d\13P\3Q\3Q\5Q\u0461\nQ\3Q\3Q\3Q\3Q\5Q"
            + "\u0467\nQ\3Q\5Q\u046a\nQ\3Q\5Q\u046d\nQ\3R\3R\3R\3S\3S\5S\u0474\nS\3S"
            + "\3S\5S\u0478\nS\3S\3S\5S\u047c\nS\3T\3T\5T\u0480\nT\3T\3T\3U\3U\5U\u0486"
            + "\nU\3U\3U\3V\3V\5V\u048c\nV\3V\3V\3V\3V\3V\5V\u0493\nV\3V\3V\3V\3V\7V"
            + "\u0499\nV\fV\16V\u049c\13V\3W\3W\3W\5W\u04a1\nW\3X\3X\3X\5X\u04a6\nX\3"
            + "X\3X\3X\3X\3X\3X\3X\3X\3X\5X\u04b1\nX\3X\3X\3X\3X\3X\3X\3X\5X\u04ba\n"
            + "X\3Y\3Y\5Y\u04be\nY\3Y\3Y\3Y\3Y\3Y\7Y\u04c5\nY\fY\16Y\u04c8\13Y\3Y\5Y"
            + "\u04cb\nY\3Y\3Y\3Z\3Z\3Z\3Z\7Z\u04d3\nZ\fZ\16Z\u04d6\13Z\3Z\3Z\5Z\u04da"
            + "\nZ\3Z\3Z\3Z\3Z\3Z\3[\3[\3[\3[\3\\\3\\\3]\3]\3]\3]\3]\3]\3]\3]\3]\5]\u04f0"
            + "\n]\3]\5]\u04f3\n]\3^\3^\3^\3^\3^\3^\3^\3^\3^\3^\3^\3^\3^\3^\3^\3^\3^"
            + "\5^\u0506\n^\3^\3^\3^\3^\3^\3^\3^\3^\3^\3^\3^\3^\3^\3^\7^\u0516\n^\f^"
            + "\16^\u0519\13^\3_\3_\3_\3_\3_\3_\3_\3_\5_\u0523\n_\3`\3`\3`\3`\3a\3a\3"
            + "b\3b\3b\3b\3b\7b\u0530\nb\fb\16b\u0533\13b\3c\3c\3c\3c\3c\3c\3c\3c\3c"
            + "\5c\u053e\nc\3d\3d\5d\u0542\nd\3e\3e\3e\3e\3e\3e\3e\6e\u054b\ne\re\16"
            + "e\u054c\3e\3e\5e\u0551\ne\3e\3e\3f\3f\6f\u0557\nf\rf\16f\u0558\3f\3f\5"
            + "f\u055d\nf\3f\3f\3g\3g\3g\3g\3g\3h\3h\3h\3h\3i\3i\3i\5i\u056d\ni\3i\3"
            + "i\3i\5i\u0572\ni\3i\3i\3i\5i\u0577\ni\3i\3i\5i\u057b\ni\3i\3i\5i\u057f"
            + "\ni\3i\3i\3i\5i\u0584\ni\3i\3i\5i\u0588\ni\3i\3i\5i\u058c\ni\3i\3i\3i"
            + "\3i\3i\3i\3i\3i\3i\3i\3i\3i\3i\3i\3i\3i\3i\3i\3i\3i\3i\5i\u05a3\ni\5i"
            + "\u05a5\ni\3i\3i\3i\3i\3i\3i\3i\3i\3i\3i\3i\3i\3i\3i\3i\3i\5i\u05b7\ni"
            + "\5i\u05b9\ni\3i\3i\3i\3i\3i\3i\5i\u05c1\ni\3i\3i\3i\5i\u05c6\ni\3i\3i"
            + "\3i\5i\u05cb\ni\3i\3i\3i\5i\u05d0\ni\3i\3i\3i\3i\3i\3i\3i\3i\3i\3i\3i"
            + "\5i\u05dd\ni\3i\3i\3i\5i\u05e2\ni\3i\3i\3i\5i\u05e7\ni\3i\3i\3i\5i\u05ec"
            + "\ni\3i\3i\3i\5i\u05f1\ni\3i\3i\3i\5i\u05f6\ni\3i\3i\3i\5i\u05fb\ni\3i"
            + "\3i\3i\5i\u0600\ni\5i\u0602\ni\3j\3j\3k\3k\3k\5k\u0609\nk\3k\5k\u060c"
            + "\nk\3k\3k\3l\3l\3l\3l\3l\7l\u0615\nl\fl\16l\u0618\13l\3m\3m\3m\3m\3m\3"
            + "m\3m\5m\u0621\nm\3m\3m\3m\3m\3m\3m\5m\u0629\nm\3m\3m\3m\3m\3m\3m\3m\3"
            + "m\3m\5m\u0634\nm\3m\3m\3m\3m\5m\u063a\nm\3m\3m\3m\3m\3m\3m\3m\3m\3m\3"
            + "m\3m\3m\3m\7m\u0649\nm\fm\16m\u064c\13m\5m\u064e\nm\3m\3m\3m\3m\3m\3m"
            + "\3m\3m\3m\3m\3m\3m\7m\u065c\nm\fm\16m\u065f\13m\5m\u0661\nm\3m\3m\3m\3"
            + "m\3m\3m\3m\3m\3m\3m\3m\3m\7m\u066f\nm\fm\16m\u0672\13m\5m\u0674\nm\3m"
            + "\3m\3m\3m\3m\3m\3m\3m\3m\3m\3m\3m\7m\u0682\nm\fm\16m\u0685\13m\5m\u0687"
            + "\nm\3m\3m\3m\3m\3m\3m\3m\3m\3m\3m\3m\3m\7m\u0695\nm\fm\16m\u0698\13m\5"
            + "m\u069a\nm\3m\3m\3m\3m\3m\3m\3m\3m\3m\3m\3m\3m\7m\u06a8\nm\fm\16m\u06ab"
            + "\13m\5m\u06ad\nm\3m\3m\3m\3m\3m\3m\3m\3m\3m\3m\7m\u06b9\nm\fm\16m\u06bc"
            + "\13m\3m\3m\3m\3m\3m\3m\3m\3m\3m\3m\6m\u06c8\nm\rm\16m\u06c9\3m\3m\5m\u06ce"
            + "\nm\3m\3m\3m\3m\3m\3m\3m\3m\3m\5m\u06d9\nm\3m\3m\3m\3m\5m\u06df\nm\3n"
            + "\3n\3n\5n\u06e4\nn\3n\3n\3o\3o\3o\7o\u06eb\no\fo\16o\u06ee\13o\3p\3p\3"
            + "p\3p\3p\5p\u06f5\np\5p\u06f7\np\3p\3p\5p\u06fb\np\3q\3q\3r\3r\3s\3s\3"
            + "s\7s\u0704\ns\fs\16s\u0707\13s\3t\3t\3t\3u\3u\3u\3v\5v\u0710\nv\3v\3v"
            + "\3v\7v\u0715\nv\fv\16v\u0718\13v\3w\3w\5w\u071c\nw\3x\3x\5x\u0720\nx\3"
            + "y\5y\u0723\ny\3y\3y\3z\5z\u0728\nz\3z\3z\3{\3{\3|\3|\3}\3}\3}\2\4\u00aa"
            + "\u00ba~\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:"
            + "<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a"
            + "\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u009a\u009c\u009e\u00a0\u00a2"
            + "\u00a4\u00a6\u00a8\u00aa\u00ac\u00ae\u00b0\u00b2\u00b4\u00b6\u00b8\u00ba"
            + "\u00bc\u00be\u00c0\u00c2\u00c4\u00c6\u00c8\u00ca\u00cc\u00ce\u00d0\u00d2"
            + "\u00d4\u00d6\u00d8\u00da\u00dc\u00de\u00e0\u00e2\u00e4\u00e6\u00e8\u00ea"
            + "\u00ec\u00ee\u00f0\u00f2\u00f4\u00f6\u00f8\2\34\5\2MM\u0191\u0191\u019a"
            + "\u019a\4\2\r\rUU\4\2RR\u0144\u0144\4\2oo\u00b2\u00b2\4\2RR\u00e1\u00e1"
            + "\4\2$$??\4\2\u0103\u0103\u0141\u0141\4\2\u00b8\u00b8\u019d\u019d\4\2\37"
            + "\37&&\4\2CC\u010a\u010a\4\2MM\u019a\u019a\3\2\u010f\u0110\4\2\6\6ZZ\5"
            + "\2{{\u00a8\u00a8\u00fd\u00fd\5\2??\u0105\u0106\u0145\u0145\4\2ll\u0144"
            + "\u0144\3\2UV\4\2\u012f\u012f\u0131\u0131\4\2\t\t\u00d2\u00d2\5\2\u00a9"
            + "\u00a9\u00f2\u00f2\u00fe\u00fe\5\2HI\u00bc\u00bd\u010b\u010c\4\2\65\65"
            + "\u0185\u0185\5\2yy\u009e\u009e\u00c9\u00c9\4\2\u0182\u0182\u0199\u0199"
            + "\4\2pp\u013f\u013f#\2\4\17\22\30\32\34\36\60\62;=CE`ddf\u0080\u0082\u0087"
            + "\u0089\u008d\u008f\u00a1\u00a3\u00a4\u00a6\u00ab\u00ad\u00c9\u00cb\u00da"
            + "\u00dc\u00dd\u00e0\u00e1\u00e3\u00e6\u00eb\u00f2\u00f4\u00fb\u00fd\u0102"
            + "\u0104\u0108\u010a\u0114\u0116\u0118\u011a\u0120\u0122\u0123\u0125\u012f"
            + "\u0134\u0139\u013b\u0140\u0143\u014e\u0151\u0163\u016a\u0171\2\u0814\2"
            + "\u00fa\3\2\2\2\4\u0111\3\2\2\2\6\u0115\3\2\2\2\b\u011f\3\2\2\2\n\u0124"
            + "\3\2\2\2\f\u0136\3\2\2\2\16\u0138\3\2\2\2\20\u015d\3\2\2\2\22\u0167\3"
            + "\2\2\2\24\u016c\3\2\2\2\26\u016f\3\2\2\2\30\u017c\3\2\2\2\32\u0194\3\2"
            + "\2\2\34\u0199\3\2\2\2\36\u01b4\3\2\2\2 \u01b6\3\2\2\2\"\u01d8\3\2\2\2"
            + "$\u0210\3\2\2\2&\u0212\3\2\2\2(\u021f\3\2\2\2*\u0223\3\2\2\2,\u0227\3"
            + "\2\2\2.\u022c\3\2\2\2\60\u0235\3\2\2\2\62\u0252\3\2\2\2\64\u0254\3\2\2"
            + "\2\66\u0267\3\2\2\28\u0277\3\2\2\2:\u0279\3\2\2\2<\u0287\3\2\2\2>\u02a4"
            + "\3\2\2\2@\u02a6\3\2\2\2B\u02b1\3\2\2\2D\u02bf\3\2\2\2F\u02c2\3\2\2\2H"
            + "\u02ce\3\2\2\2J\u02d0\3\2\2\2L\u02d8\3\2\2\2N\u02e9\3\2\2\2P\u02f4\3\2"
            + "\2\2R\u02fd\3\2\2\2T\u0308\3\2\2\2V\u030e\3\2\2\2X\u0312\3\2\2\2Z\u0316"
            + "\3\2\2\2\\\u031f\3\2\2\2^\u0328\3\2\2\2`\u0340\3\2\2\2b\u0347\3\2\2\2"
            + "d\u0355\3\2\2\2f\u0357\3\2\2\2h\u0370\3\2\2\2j\u037d\3\2\2\2l\u037f\3"
            + "\2\2\2n\u038c\3\2\2\2p\u03a4\3\2\2\2r\u03a8\3\2\2\2t\u03ac\3\2\2\2v\u03b5"
            + "\3\2\2\2x\u03c0\3\2\2\2z\u03c2\3\2\2\2|\u03c9\3\2\2\2~\u03d6\3\2\2\2\u0080"
            + "\u03e1\3\2\2\2\u0082\u03e3\3\2\2\2\u0084\u03fe\3\2\2\2\u0086\u0400\3\2"
            + "\2\2\u0088\u0411\3\2\2\2\u008a\u0413\3\2\2\2\u008c\u0416\3\2\2\2\u008e"
            + "\u0420\3\2\2\2\u0090\u0423\3\2\2\2\u0092\u0426\3\2\2\2\u0094\u0430\3\2"
            + "\2\2\u0096\u0434\3\2\2\2\u0098\u043b\3\2\2\2\u009a\u044a\3\2\2\2\u009c"
            + "\u044c\3\2\2\2\u009e\u0456\3\2\2\2\u00a0\u0466\3\2\2\2\u00a2\u046e\3\2"
            + "\2\2\u00a4\u0471\3\2\2\2\u00a6\u047d\3\2\2\2\u00a8\u0483\3\2\2\2\u00aa"
            + "\u0492\3\2\2\2\u00ac\u04a0\3\2\2\2\u00ae\u04b9\3\2\2\2\u00b0\u04bb\3\2"
            + "\2\2\u00b2\u04ce\3\2\2\2\u00b4\u04e0\3\2\2\2\u00b6\u04e4\3\2\2\2\u00b8"
            + "\u04f2\3\2\2\2\u00ba\u0505\3\2\2\2\u00bc\u0522\3\2\2\2\u00be\u0524\3\2"
            + "\2\2\u00c0\u0528\3\2\2\2\u00c2\u052a\3\2\2\2\u00c4\u053d\3\2\2\2\u00c6"
            + "\u0541\3\2\2\2\u00c8\u0543\3\2\2\2\u00ca\u0554\3\2\2\2\u00cc\u0560\3\2"
            + "\2\2\u00ce\u0565\3\2\2\2\u00d0\u0601\3\2\2\2\u00d2\u0603\3\2\2\2\u00d4"
            + "\u0605\3\2\2\2\u00d6\u060f\3\2\2\2\u00d8\u06de\3\2\2\2\u00da\u06e0\3\2"
            + "\2\2\u00dc\u06e7\3\2\2\2\u00de\u06fa\3\2\2\2\u00e0\u06fc\3\2\2\2\u00e2"
            + "\u06fe\3\2\2\2\u00e4\u0700\3\2\2\2\u00e6\u0708\3\2\2\2\u00e8\u070b\3\2"
            + "\2\2\u00ea\u070f\3\2\2\2\u00ec\u071b\3\2\2\2\u00ee\u071f\3\2\2\2\u00f0"
            + "\u0722\3\2\2\2\u00f2\u0727\3\2\2\2\u00f4\u072b\3\2\2\2\u00f6\u072d\3\2"
            + "\2\2\u00f8\u072f\3\2\2\2\u00fa\u00fc\5\4\3\2\u00fb\u00fd\7\u0198\2\2\u00fc"
            + "\u00fb\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\u00ff\7\2"
            + "\2\3\u00ff\3\3\2\2\2\u0100\u0112\5B\"\2\u0101\u0112\5\26\f\2\u0102\u0112"
            + "\5\64\33\2\u0103\u0112\5\u00a8U\2\u0104\u0112\5F$\2\u0105\u0112\5J&\2"
            + "\u0106\u0112\5T+\2\u0107\u0112\5V,\2\u0108\u0112\5D#\2\u0109\u0112\5:"
            + "\36\2\u010a\u0112\5\22\n\2\u010b\u0112\5\24\13\2\u010c\u0112\5L\'\2\u010d"
            + "\u0112\5\u009cO\2\u010e\u0112\5\u00a4S\2\u010f\u0112\5X-\2\u0110\u0112"
            + "\5\30\r\2\u0111\u0100\3\2\2\2\u0111\u0101\3\2\2\2\u0111\u0102\3\2\2\2"
            + "\u0111\u0103\3\2\2\2\u0111\u0104\3\2\2\2\u0111\u0105\3\2\2\2\u0111\u0106"
            + "\3\2\2\2\u0111\u0107\3\2\2\2\u0111\u0108\3\2\2\2\u0111\u0109\3\2\2\2\u0111"
            + "\u010a\3\2\2\2\u0111\u010b\3\2\2\2\u0111\u010c\3\2\2\2\u0111\u010d\3\2"
            + "\2\2\u0111\u010e\3\2\2\2\u0111\u010f\3\2\2\2\u0111\u0110\3\2\2\2\u0112"
            + "\5\3\2\2\2\u0113\u0114\t\2\2\2\u0114\u0116\7\u0187\2\2\u0115\u0113\3\2"
            + "\2\2\u0115\u0116\3\2\2\2\u0116\u0117\3\2\2\2\u0117\u0118\t\2\2\2\u0118"
            + "\7\3\2\2\2\u0119\u0120\5\6\4\2\u011a\u011b\7\u019a\2\2\u011b\u011d\7\u0187"
            + "\2\2\u011c\u011a\3\2\2\2\u011c\u011d\3\2\2\2\u011d\u011e\3\2\2\2\u011e"
            + "\u0120\5\6\4\2\u011f\u0119\3\2\2\2\u011f\u011c\3\2\2\2\u0120\t\3\2\2\2"
            + "\u0121\u0125\5\f\7\2\u0122\u0125\5\16\b\2\u0123\u0125\5\20\t\2\u0124\u0121"
            + "\3\2\2\2\u0124\u0122\3\2\2\2\u0124\u0123\3\2\2\2\u0125\13\3\2\2\2\u0126"
            + "\u0128\5\u00eav\2\u0127\u0129\7\u0183\2\2\u0128\u0127\3\2\2\2\u0128\u0129"
            + "\3\2\2\2\u0129\u012a\3\2\2\2\u012a\u012b\7\u0189\2\2\u012b\u012c\5\u00ba"
            + "^\2\u012c\u0137\3\2\2\2\u012d\u012e\7\u0193\2\2\u012e\u012f\5\u00eav\2"
            + "\u012f\u0131\7\u0196\2\2\u0130\u0132\7\u0183\2\2\u0131\u0130\3\2\2\2\u0131"
            + "\u0132\3\2\2\2\u0132\u0133\3\2\2\2\u0133\u0134\7\u0189\2\2\u0134\u0135"
            + "\5\u00ba^\2\u0135\u0137\3\2\2\2\u0136\u0126\3\2\2\2\u0136\u012d\3\2\2"
            + "\2\u0137\r\3\2\2\2\u0138\u0139\7\u0193\2\2\u0139\u013e\5\u00eav\2\u013a"
            + "\u013b\7\u0184\2\2\u013b\u013d\5\u00eav\2\u013c\u013a\3\2\2\2\u013d\u0140"
            + "\3\2\2\2\u013e\u013c\3\2\2\2\u013e\u013f\3\2\2\2\u013f\u0141\3\2\2\2\u0140"
            + "\u013e\3\2\2\2\u0141\u0143\7\u0196\2\2\u0142\u0144\7\u0183\2\2\u0143\u0142"
            + "\3\2\2\2\u0143\u0144\3\2\2\2\u0144\u0145\3\2\2\2\u0145\u0146\7\u0189\2"
            + "\2\u0146\u0147\7\u0193\2\2\u0147\u014c\5\u00ba^\2\u0148\u0149\7\u0184"
            + "\2\2\u0149\u014b\5\u00ba^\2\u014a\u0148\3\2\2\2\u014b\u014e\3\2\2\2\u014c"
            + "\u014a\3\2\2\2\u014c\u014d\3\2\2\2\u014d\u014f\3\2\2\2\u014e\u014c\3\2"
            + "\2\2\u014f\u0150\7\u0196\2\2\u0150\17\3\2\2\2\u0151\u015e\5\u00eav\2\u0152"
            + "\u0153\7\u0193\2\2\u0153\u0158\5\u00eav\2\u0154\u0155\7\u0184\2\2\u0155"
            + "\u0157\5\u00eav\2\u0156\u0154\3\2\2\2\u0157\u015a\3\2\2\2\u0158\u0156"
            + "\3\2\2\2\u0158\u0159\3\2\2\2\u0159\u015b\3\2\2\2\u015a\u0158\3\2\2\2\u015b"
            + "\u015c\7\u0196\2\2\u015c\u015e\3\2\2\2\u015d\u0151\3\2\2\2\u015d\u0152"
            + "\3\2\2\2\u015e\u0160\3\2\2\2\u015f\u0161\7\u0183\2\2\u0160\u015f\3\2\2"
            + "\2\u0160\u0161\3\2\2\2\u0161\u0162\3\2\2\2\u0162\u0163\7\u0189\2\2\u0163"
            + "\u0164\7\u0193\2\2\u0164\u0165\5X-\2\u0165\u0166\7\u0196\2\2\u0166\21"
            + "\3\2\2\2\u0167\u0168\7\u0115\2\2\u0168\u0169\7<\2\2\u0169\u016a\7\u012f"
            + "\2\2\u016a\u016b\5\u00eav\2\u016b\23\3\2\2\2\u016c\u016d\7\u0115\2\2\u016d"
            + "\u016e\7\u0124\2\2\u016e\25\3\2\2\2\u016f\u0170\7<\2\2\u0170\u0174\7\u012f"
            + "\2\2\u0171\u0172\7\u0089\2\2\u0172\u0173\7\u00c8\2\2\u0173\u0175\7m\2"
            + "\2\u0174\u0171\3\2\2\2\u0174\u0175\3\2\2\2\u0175\u0176\3\2\2\2\u0176\u0178"
            + "\5\u00e0q\2\u0177\u0179\5(\25\2\u0178\u0177\3\2\2\2\u0178\u0179\3\2\2"
            + "\2\u0179\u017a\3\2\2\2\u017a\u017b\5\32\16\2\u017b\27\3\2\2\2\u017c\u017d"
            + "\7<\2\2\u017d\u017e\7\u0171\2\2\u017e\u017f\5\u00e2r\2\u017f\u0180\7\u0088"
            + "\2\2\u0180\u0181\7\36\2\2\u0181\u0182\5\u00eex\2\u0182\31\3\2\2\2\u0183"
            + "\u0185\7\f\2\2\u0184\u0183\3\2\2\2\u0184\u0185\3\2\2\2\u0185\u0186\3\2"
            + "\2\2\u0186\u0187\7\u0193\2\2\u0187\u0188\5X-\2\u0188\u0189\7\u0196\2\2"
            + "\u0189\u0195\3\2\2\2\u018a\u018c\7\f\2\2\u018b\u018a\3\2\2\2\u018b\u018c"
            + "\3\2\2\2\u018c\u018d\3\2\2\2\u018d\u0195\5X-\2\u018e\u018f\7\u0193\2\2"
            + "\u018f\u0190\5\34\17\2\u0190\u0191\7\u0196\2\2\u0191\u0195\3\2\2\2\u0192"
            + "\u0193\7\u00a9\2\2\u0193\u0195\5\u00e0q\2\u0194\u0184\3\2\2\2\u0194\u018b"
            + "\3\2\2\2\u0194\u018e\3\2\2\2\u0194\u0192\3\2\2\2\u0195\u0197\3\2\2\2\u0196"
            + "\u0198\5.\30\2\u0197\u0196\3\2\2\2\u0197\u0198\3\2\2\2\u0198\33\3\2\2"
            + "\2\u0199\u019e\5\36\20\2\u019a\u019b\7\u0184\2\2\u019b\u019d\5\36\20\2"
            + "\u019c\u019a\3\2\2\2\u019d\u01a0\3\2\2\2\u019e\u019c\3\2\2\2\u019e\u019f"
            + "\3\2\2\2\u019f\35\3\2\2\2\u01a0\u019e\3\2\2\2\u01a1\u01a2\5 \21\2\u01a2"
            + "\u01a6\5> \2\u01a3\u01a5\5<\37\2\u01a4\u01a3\3\2\2\2\u01a5\u01a8\3\2\2"
            + "\2\u01a6\u01a4\3\2\2\2\u01a6\u01a7\3\2\2\2\u01a7\u01ac\3\2\2\2\u01a8\u01a6"
            + "\3\2\2\2\u01a9\u01ab\5\"\22\2\u01aa\u01a9\3\2\2\2\u01ab\u01ae\3\2\2\2"
            + "\u01ac\u01aa\3\2\2\2\u01ac\u01ad\3\2\2\2\u01ad\u01b5\3\2\2\2\u01ae\u01ac"
            + "\3\2\2\2\u01af\u01b0\7\67\2\2\u01b0\u01b2\5\u00e4s\2\u01b1\u01af\3\2\2"
            + "\2\u01b1\u01b2\3\2\2\2\u01b2\u01b3\3\2\2\2\u01b3\u01b5\5$\23\2\u01b4\u01a1"
            + "\3\2\2\2\u01b4\u01b1\3\2\2\2\u01b5\37\3\2\2\2\u01b6\u01b7\5\u00e4s\2\u01b7"
            + "!\3\2\2\2\u01b8\u01d9\58\35\2\u01b9\u01bb\7\u00c8\2\2\u01ba\u01b9\3\2"
            + "\2\2\u01ba\u01bb\3\2\2\2\u01bb\u01bc\3\2\2\2\u01bc\u01d9\7\u00ca\2\2\u01bd"
            + "\u01be\7\u00e3\2\2\u01be\u01d9\7\u00a3\2\2\u01bf\u01d9\7\u0143\2\2\u01c0"
            + "\u01c1\7\u00f1\2\2\u01c1\u01c2\5\u00e0q\2\u01c2\u01c3\7\u0193\2\2\u01c3"
            + "\u01c4\5\u00e4s\2\u01c4\u01c8\7\u0196\2\2\u01c5\u01c7\5&\24\2\u01c6\u01c5"
            + "\3\2\2\2\u01c7\u01ca\3\2\2\2\u01c8\u01c6\3\2\2\2\u01c8\u01c9\3\2\2\2\u01c9"
            + "\u01d9\3\2\2\2\u01ca\u01c8\3\2\2\2\u01cb\u01cc\7\u0087\2\2\u01cc\u01cd"
            + "\7\u0193\2\2\u01cd\u01d2\7\u019d\2\2\u01ce\u01cf\7\u0184\2\2\u01cf\u01d1"
            + "\7\u019d\2\2\u01d0\u01ce\3\2\2\2\u01d1\u01d4\3\2\2\2\u01d2\u01d0\3\2\2"
            + "\2\u01d2\u01d3\3\2\2\2\u01d3\u01d5\3\2\2\2\u01d4\u01d2\3\2\2\2\u01d5\u01d9"
            + "\7\u0196\2\2\u01d6\u01d9\7\21\2\2\u01d7\u01d9\7d\2\2\u01d8\u01b8\3\2\2"
            + "\2\u01d8\u01ba\3\2\2\2\u01d8\u01bd\3\2\2\2\u01d8\u01bf\3\2\2\2\u01d8\u01c0"
            + "\3\2\2\2\u01d8\u01cb\3\2\2\2\u01d8\u01d6\3\2\2\2\u01d8\u01d7\3\2\2\2\u01d9"
            + "#\3\2\2\2\u01da\u01db\7\u00e3\2\2\u01db\u01dd\7\u00a3\2\2\u01dc\u01de"
            + "\7+\2\2\u01dd\u01dc\3\2\2\2\u01dd\u01de\3\2\2\2\u01de\u01df\3\2\2\2\u01df"
            + "\u01e0\7\u0193\2\2\u01e0\u01e2\5\u00e4s\2\u01e1\u01e3\t\3\2\2\u01e2\u01e1"
            + "\3\2\2\2\u01e2\u01e3\3\2\2\2\u01e3\u01eb\3\2\2\2\u01e4\u01e5\7\u0184\2"
            + "\2\u01e5\u01e7\5\u00e4s\2\u01e6\u01e8\t\3\2\2\u01e7\u01e6\3\2\2\2\u01e7"
            + "\u01e8\3\2\2\2\u01e8\u01ea\3\2\2\2\u01e9\u01e4\3\2\2\2\u01ea\u01ed\3\2"
            + "\2\2\u01eb\u01e9\3\2\2\2\u01eb\u01ec\3\2\2\2\u01ec\u01ee\3\2\2\2\u01ed"
            + "\u01eb\3\2\2\2\u01ee\u01f0\7\u0196\2\2\u01ef\u01f1\7d\2\2\u01f0\u01ef"
            + "\3\2\2\2\u01f0\u01f1\3\2\2\2\u01f1\u0211\3\2\2\2\u01f2\u01f3\7w\2\2\u01f3"
            + "\u01f4\7\u00a3\2\2\u01f4\u01f5\7\u0193\2\2\u01f5\u01fa\5\u00e4s\2\u01f6"
            + "\u01f7\7\u0184\2\2\u01f7\u01f9\5\u00e4s\2\u01f8\u01f6\3\2\2\2\u01f9\u01fc"
            + "\3\2\2\2\u01fa\u01f8\3\2\2\2\u01fa\u01fb\3\2\2\2\u01fb\u01fd\3\2\2\2\u01fc"
            + "\u01fa\3\2\2\2\u01fd\u01fe\7\u0196\2\2\u01fe\u01ff\7\u00f1\2\2\u01ff\u0200"
            + "\5\u00e0q\2\u0200\u0201\7\u0193\2\2\u0201\u0206\5\u00e4s\2\u0202\u0203"
            + "\7\u0184\2\2\u0203\u0205\5\u00e4s\2\u0204\u0202\3\2\2\2\u0205\u0208\3"
            + "\2\2\2\u0206\u0204\3\2\2\2\u0206\u0207\3\2\2\2\u0207\u0209\3\2\2\2\u0208"
            + "\u0206\3\2\2\2\u0209\u020d\7\u0196\2\2\u020a\u020c\5&\24\2\u020b\u020a"
            + "\3\2\2\2\u020c\u020f\3\2\2\2\u020d\u020b\3\2\2\2\u020d\u020e\3\2\2\2\u020e"
            + "\u0211\3\2\2\2\u020f\u020d\3\2\2\2\u0210\u01da\3\2\2\2\u0210\u01f2\3\2"
            + "\2\2\u0211%\3\2\2\2\u0212\u0213\7\u00cf\2\2\u0213\u021c\t\4\2\2\u0214"
            + "\u0215\7\u00c3\2\2\u0215\u021d\7\4\2\2\u0216\u021d\7\u00f6\2\2\u0217\u0218"
            + "\7\u0111\2\2\u0218\u021d\7\u00ca\2\2\u0219\u021a\7\u0111\2\2\u021a\u021d"
            + "\7M\2\2\u021b\u021d\7\"\2\2\u021c\u0214\3\2\2\2\u021c\u0216\3\2\2\2\u021c"
            + "\u0217\3\2\2\2\u021c\u0219\3\2\2\2\u021c\u021b\3\2\2\2\u021d\'\3\2\2\2"
            + "\u021e\u0220\5*\26\2\u021f\u021e\3\2\2\2\u0220\u0221\3\2\2\2\u0221\u021f"
            + "\3\2\2\2\u0221\u0222\3\2\2\2\u0222)\3\2\2\2\u0223\u0224\7\u0184\2\2\u0224"
            + "\u0225\5,\27\2\u0225+\3\2\2\2\u0226\u0228\7\u00c3\2\2\u0227\u0226\3\2"
            + "\2\2\u0227\u0228\3\2\2\2\u0228\u0229\3\2\2\2\u0229\u022a\t\5\2\2\u022a"
            + "-\3\2\2\2\u022b\u022d\5\60\31\2\u022c\u022b\3\2\2\2\u022d\u022e\3\2\2"
            + "\2\u022e\u022c\3\2\2\2\u022e\u022f\3\2\2\2\u022f/\3\2\2\2\u0230\u0231"
            + "\7\u00cf\2\2\u0231\u0232\7\63\2\2\u0232\u0233\t\6\2\2\u0233\u0236\7\u0102"
            + "\2\2\u0234\u0236\5\62\32\2\u0235\u0230\3\2\2\2\u0235\u0234\3\2\2\2\u0236"
            + "\61\3\2\2\2\u0237\u0239\7\21\2\2\u0238\u023a\7\u0189\2\2\u0239\u0238\3"
            + "\2\2\2\u0239\u023a\3\2\2\2\u023a\u023b\3\2\2\2\u023b\u0253\5\u00ba^\2"
            + "\u023c\u023e\7\60\2\2\u023d\u023f\7\u0189\2\2\u023e\u023d\3\2\2\2\u023e"
            + "\u023f\3\2\2\2\u023f\u0240\3\2\2\2\u0240\u0253\5\u00ba^\2\u0241\u0243"
            + "\7M\2\2\u0242\u0241\3\2\2\2\u0242\u0243\3\2\2\2\u0243\u0247\3\2\2\2\u0244"
            + "\u0245\7\'\2\2\u0245\u0248\7\u0111\2\2\u0246\u0248\7(\2\2\u0247\u0244"
            + "\3\2\2\2\u0247\u0246\3\2\2\2\u0248\u024a\3\2\2\2\u0249\u024b\7\u0189\2"
            + "\2\u024a\u0249\3\2\2\2\u024a\u024b\3\2\2\2\u024b\u024c\3\2\2\2\u024c\u0253"
            + "\5\u00ba^\2\u024d\u024f\7f\2\2\u024e\u0250\7\u0189\2\2\u024f\u024e\3\2"
            + "\2\2\u024f\u0250\3\2\2\2\u0250\u0251\3\2\2\2\u0251\u0253\5\u00ba^\2\u0252"
            + "\u0237\3\2\2\2\u0252\u023c\3\2\2\2\u0252\u0242\3\2\2\2\u0252\u024d\3\2"
            + "\2\2\u0253\63\3\2\2\2\u0254\u0256\7<\2\2\u0255\u0257\7\u0143\2\2\u0256"
            + "\u0255\3\2\2\2\u0256\u0257\3\2\2\2\u0257\u0258\3\2\2\2\u0258\u0259\7\u008f"
            + "\2\2\u0259\u025a\5\u00eav\2\u025a\u025b\7\u00cf\2\2\u025b\u025c\5\u0088"
            + "E\2\u025c\u025d\7\u0193\2\2\u025d\u0262\5\66\34\2\u025e\u025f\7\u0184"
            + "\2\2\u025f\u0261\5\66\34\2\u0260\u025e\3\2\2\2\u0261\u0264\3\2\2\2\u0262"
            + "\u0260\3\2\2\2\u0262\u0263\3\2\2\2\u0263\u0265\3\2\2\2\u0264\u0262\3\2"
            + "\2\2\u0265\u0266\7\u0196\2\2\u0266\65\3\2\2\2\u0267\u0269\5\u00eav\2\u0268"
            + "\u026a\t\3\2\2\u0269\u0268\3\2\2\2\u0269\u026a\3\2\2\2\u026a\67\3\2\2"
            + "\2\u026b\u026d\7\u0183\2\2\u026c\u026b\3\2\2\2\u026c\u026d\3\2\2\2\u026d"
            + "\u026e\3\2\2\2\u026e\u026f\7\u0189\2\2\u026f\u0278\5\u00ba^\2\u0270\u0272"
            + "\7\u0152\2\2\u0271\u0270\3\2\2\2\u0271\u0272\3\2\2\2\u0272\u0273\3\2\2"
            + "\2\u0273\u0275\7M\2\2\u0274\u0276\5\u00ba^\2\u0275\u0274\3\2\2\2\u0275"
            + "\u0276\3\2\2\2\u0276\u0278\3\2\2\2\u0277\u026c\3\2\2\2\u0277\u0271\3\2"
            + "\2\2\u02789\3\2\2\2\u0279\u027a\7\u0115\2\2\u027a\u027b\7\u0132\2\2\u027b"
            + ";\3\2\2\2\u027c\u027e\7\u00c8\2\2\u027d\u027c\3\2\2\2\u027d\u027e\3\2"
            + "\2\2\u027e\u027f\3\2\2\2\u027f\u0288\7\u00ca\2\2\u0280\u0281\7\'\2\2\u0281"
            + "\u0282\7\u0111\2\2\u0282\u0288\5\u00eav\2\u0283\u0285\7\u00c8\2\2\u0284"
            + "\u0283\3\2\2\2\u0284\u0285\3\2\2\2\u0285\u0286\3\2\2\2\u0286\u0288\t\7"
            + "\2\2\u0287\u027d\3\2\2\2\u0287\u0280\3\2\2\2\u0287\u0284\3\2\2\2\u0288"
            + "=\3\2\2\2\u0289\u02a5\7G\2\2\u028a\u02a5\7]\2\2\u028b\u02a5\7u\2\2\u028c"
            + "\u02a5\7\u0094\2\2\u028d\u02a5\7\u0098\2\2\u028e\u02a5\7\u0129\2\2\u028f"
            + "\u02a5\7\u0139\2\2\u0290\u02a5\7\u0173\2\2\u0291\u02a5\7\u0174\2\2\u0292"
            + "\u02a5\7\u0175\2\2\u0293\u02a5\7\u0176\2\2\u0294\u02a5\7\u0177\2\2\u0295"
            + "\u02a5\7\u0178\2\2\u0296\u02a5\7\u0179\2\2\u0297\u02a5\7\u017a\2\2\u0298"
            + "\u02a5\7\u017b\2\2\u0299\u02a5\7\u017c\2\2\u029a\u02a5\7\u017d\2\2\u029b"
            + "\u02a5\7\u017e\2\2\u029c\u02a5\7\u017f\2\2\u029d\u02a5\7\u0180\2\2\u029e"
            + "\u02a5\7\u0181\2\2\u029f\u02a2\5\u00eav\2\u02a0\u02a1\7\3\2\2\u02a1\u02a3"
            + "\t\b\2\2\u02a2\u02a0\3\2\2\2\u02a2\u02a3\3\2\2\2\u02a3\u02a5\3\2\2\2\u02a4"
            + "\u0289\3\2\2\2\u02a4\u028a\3\2\2\2\u02a4\u028b\3\2\2\2\u02a4\u028c\3\2"
            + "\2\2\u02a4\u028d\3\2\2\2\u02a4\u028e\3\2\2\2\u02a4\u028f\3\2\2\2\u02a4"
            + "\u0290\3\2\2\2\u02a4\u0291\3\2\2\2\u02a4\u0292\3\2\2\2\u02a4\u0293\3\2"
            + "\2\2\u02a4\u0294\3\2\2\2\u02a4\u0295\3\2\2\2\u02a4\u0296\3\2\2\2\u02a4"
            + "\u0297\3\2\2\2\u02a4\u0298\3\2\2\2\u02a4\u0299\3\2\2\2\u02a4\u029a\3\2"
            + "\2\2\u02a4\u029b\3\2\2\2\u02a4\u029c\3\2\2\2\u02a4\u029d\3\2\2\2\u02a4"
            + "\u029e\3\2\2\2\u02a4\u029f\3\2\2\2\u02a5?\3\2\2\2\u02a6\u02a7\7\u0193"
            + "\2\2\u02a7\u02a9\t\t\2\2\u02a8\u02aa\t\n\2\2\u02a9\u02a8\3\2\2\2\u02a9"
            + "\u02aa\3\2\2\2\u02aa\u02ad\3\2\2\2\u02ab\u02ac\7\u0184\2\2\u02ac\u02ae"
            + "\7\u019d\2\2\u02ad\u02ab\3\2\2\2\u02ad\u02ae\3\2\2\2\u02ae\u02af\3\2\2"
            + "\2\u02af\u02b0\7\u0196\2\2\u02b0A\3\2\2\2\u02b1\u02b2\7<\2\2\u02b2\u02b6"
            + "\t\13\2\2\u02b3\u02b4\7\u0089\2\2\u02b4\u02b5\7\u00c8\2\2\u02b5\u02b7"
            + "\7m\2\2\u02b6\u02b3\3\2\2\2\u02b6\u02b7\3\2\2\2\u02b7\u02b8\3\2\2\2\u02b8"
            + "\u02bc\7\u019a\2\2\u02b9\u02bb\5H%\2\u02ba\u02b9\3\2\2\2\u02bb\u02be\3"
            + "\2\2\2\u02bc\u02ba\3\2\2\2\u02bc\u02bd\3\2\2\2\u02bdC\3\2\2\2\u02be\u02bc"
            + "\3\2\2\2\u02bf\u02c0\7\u0115\2\2\u02c0\u02c1\7D\2\2\u02c1E\3\2\2\2\u02c2"
            + "\u02c3\7_\2\2\u02c3\u02c6\t\13\2\2\u02c4\u02c5\7\u0089\2\2\u02c5\u02c7"
            + "\7m\2\2\u02c6\u02c4\3\2\2\2\u02c6\u02c7\3\2\2\2\u02c7\u02c8\3\2\2\2\u02c8"
            + "\u02c9\7\u019a\2\2\u02c9G\3\2\2\2\u02ca\u02cb\7\60\2\2\u02cb\u02cf\5\u00ba"
            + "^\2\u02cc\u02cd\7\u00ae\2\2\u02cd\u02cf\5\u00ba^\2\u02ce\u02ca\3\2\2\2"
            + "\u02ce\u02cc\3\2\2\2\u02cfI\3\2\2\2\u02d0\u02d1\7_\2\2\u02d1\u02d4\7\u012f"
            + "\2\2\u02d2\u02d3\7\u0089\2\2\u02d3\u02d5\7m\2\2\u02d4\u02d2\3\2\2\2\u02d4"
            + "\u02d5\3\2\2\2\u02d5\u02d6\3\2\2\2\u02d6\u02d7\5\u0088E\2\u02d7K\3\2\2"
            + "\2\u02d8\u02df\7\u0093\2\2\u02d9\u02da\7\u00d7\2\2\u02da\u02e0\7\u012f"
            + "\2\2\u02db\u02dd\7\u009b\2\2\u02dc\u02de\7\u012f\2\2\u02dd\u02dc\3\2\2"
            + "\2\u02dd\u02de\3\2\2\2\u02de\u02e0\3\2\2\2\u02df\u02d9\3\2\2\2\u02df\u02db"
            + "\3\2\2\2\u02e0\u02e1\3\2\2\2\u02e1\u02e3\5\u0088E\2\u02e2\u02e4\5N(\2"
            + "\u02e3\u02e2\3\2\2\2\u02e3\u02e4\3\2\2\2\u02e4\u02e7\3\2\2\2\u02e5\u02e8"
            + "\5X-\2\u02e6\u02e8\5P)\2\u02e7\u02e5\3\2\2\2\u02e7\u02e6\3\2\2\2\u02e8"
            + "M\3\2\2\2\u02e9\u02ea\7\u0193\2\2\u02ea\u02ef\5\u00eav\2\u02eb\u02ec\7"
            + "\u0184\2\2\u02ec\u02ee\5\u00eav\2\u02ed\u02eb\3\2\2\2\u02ee\u02f1\3\2"
            + "\2\2\u02ef\u02ed\3\2\2\2\u02ef\u02f0\3\2\2\2\u02f0\u02f2\3\2\2\2\u02f1"
            + "\u02ef\3\2\2\2\u02f2\u02f3\7\u0196\2\2\u02f3O\3\2\2\2\u02f4\u02f5\7\u0149"
            + "\2\2\u02f5\u02fa\5R*\2\u02f6\u02f7\7\u0184\2\2\u02f7\u02f9\5R*\2\u02f8"
            + "\u02f6\3\2\2\2\u02f9\u02fc\3\2\2\2\u02fa\u02f8\3\2\2\2\u02fa\u02fb\3\2"
            + "\2\2\u02fbQ\3\2\2\2\u02fc\u02fa\3\2\2\2\u02fd\u02fe\7\u0193\2\2\u02fe"
            + "\u0303\5\u00ba^\2\u02ff\u0300\7\u0184\2\2\u0300\u0302\5\u00ba^\2\u0301"
            + "\u02ff\3\2\2\2\u0302\u0305\3\2\2\2\u0303\u0301\3\2\2\2\u0303\u0304\3\2"
            + "\2\2\u0304\u0306\3\2\2\2\u0305\u0303\3\2\2\2\u0306\u0307\7\u0196\2\2\u0307"
            + "S\3\2\2\2\u0308\u030a\7\u0140\2\2\u0309\u030b\7\u012f\2\2\u030a\u0309"
            + "\3\2\2\2\u030a\u030b\3\2\2\2\u030b\u030c\3\2\2\2\u030c\u030d\5\u00eav"
            + "\2\u030dU\3\2\2\2\u030e\u030f\7\u0146\2\2\u030f\u0310\t\f\2\2\u0310W\3"
            + "\2\2\2\u0311\u0313\5Z.\2\u0312\u0311\3\2\2\2\u0312\u0313\3\2\2\2\u0313"
            + "\u0314\3\2\2\2\u0314\u0315\5`\61\2\u0315Y\3\2\2\2\u0316\u0317\7\u0152"
            + "\2\2\u0317\u031c\5\\/\2\u0318\u0319\7\u0184\2\2\u0319\u031b\5\\/\2\u031a"
            + "\u0318\3\2\2\2\u031b\u031e\3\2\2\2\u031c\u031a\3\2\2\2\u031c\u031d\3\2"
            + "\2\2\u031d[\3\2\2\2\u031e\u031c\3\2\2\2\u031f\u0321\5\u00eav\2\u0320\u0322"
            + "\5^\60\2\u0321\u0320\3\2\2\2\u0321\u0322\3\2\2\2\u0322\u0323\3\2\2\2\u0323"
            + "\u0324\7\f\2\2\u0324\u0325\7\u0193\2\2\u0325\u0326\5`\61\2\u0326\u0327"
            + "\7\u0196\2\2\u0327]\3\2\2\2\u0328\u0329\7\u0193\2\2\u0329\u032e\5\u00ea"
            + "v\2\u032a\u032b\7\u0184\2\2\u032b\u032d\5\u00eav\2\u032c\u032a\3\2\2\2"
            + "\u032d\u0330\3\2\2\2\u032e\u032c\3\2\2\2\u032e\u032f\3\2\2\2\u032f\u0331"
            + "\3\2\2\2\u0330\u032e\3\2\2\2\u0331\u0332\7\u0196\2\2\u0332_\3\2\2\2\u0333"
            + "\u0339\5b\62\2\u0334\u0335\5d\63\2\u0335\u0336\5b\62\2\u0336\u0338\3\2"
            + "\2\2\u0337\u0334\3\2\2\2\u0338\u033b\3\2\2\2\u0339\u0337\3\2\2\2\u0339"
            + "\u033a\3\2\2\2\u033a\u0341\3\2\2\2\u033b\u0339\3\2\2\2\u033c\u033d\7\u0193"
            + "\2\2\u033d\u033e\5`\61\2\u033e\u033f\7\u0196\2\2\u033f\u0341\3\2\2\2\u0340"
            + "\u0333\3\2\2\2\u0340\u033c\3\2\2\2\u0341a\3\2\2\2\u0342\u0348\5f\64\2"
            + "\u0343\u0344\7\u0193\2\2\u0344\u0345\5`\61\2\u0345\u0346\7\u0196\2\2\u0346"
            + "\u0348\3\2\2\2\u0347\u0342\3\2\2\2\u0347\u0343\3\2\2\2\u0348c\3\2\2\2"
            + "\u0349\u034b\7\u0142\2\2\u034a\u034c\7\6\2\2\u034b\u034a\3\2\2\2\u034b"
            + "\u034c\3\2\2\2\u034c\u0356\3\2\2\2\u034d\u034f\7h\2\2\u034e\u0350\7\6"
            + "\2\2\u034f\u034e\3\2\2\2\u034f\u0350\3\2\2\2\u0350\u0356\3\2\2\2\u0351"
            + "\u0353\7\u0099\2\2\u0352\u0354\7\6\2\2\u0353\u0352\3\2\2\2\u0353\u0354"
            + "\3\2\2\2\u0354\u0356\3\2\2\2\u0355\u0349\3\2\2\2\u0355\u034d\3\2\2\2\u0355"
            + "\u0351\3\2\2\2\u0356e\3\2\2\2\u0357\u0358\t\r\2\2\u0358\u035a\5h\65\2"
            + "\u0359\u035b\5t;\2\u035a\u0359\3\2\2\2\u035a\u035b\3\2\2\2\u035b\u035d"
            + "\3\2\2\2\u035c\u035e\5v<\2\u035d\u035c\3\2\2\2\u035d\u035e\3\2\2\2\u035e"
            + "\u0360\3\2\2\2\u035f\u0361\5\u008aF\2\u0360\u035f\3\2\2\2\u0360\u0361"
            + "\3\2\2\2\u0361\u0363\3\2\2\2\u0362\u0364\5\u008cG\2\u0363\u0362\3\2\2"
            + "\2\u0363\u0364\3\2\2\2\u0364\u0367\3\2\2\2\u0365\u0368\5\u008eH\2\u0366"
            + "\u0368\5\u0090I\2\u0367\u0365\3\2\2\2\u0367\u0366\3\2\2\2\u0367\u0368"
            + "\3\2\2\2\u0368\u036a\3\2\2\2\u0369\u036b\5\u0092J\2\u036a\u0369\3\2\2"
            + "\2\u036a\u036b\3\2\2\2\u036b\u036d\3\2\2\2\u036c\u036e\5\u0098M\2\u036d"
            + "\u036c\3\2\2\2\u036d\u036e\3\2\2\2\u036eg\3\2\2\2\u036f\u0371\5j\66\2"
            + "\u0370\u036f\3\2\2\2\u0370\u0371\3\2\2\2\u0371\u0373\3\2\2\2\u0372\u0374"
            + "\5l\67\2\u0373\u0372\3\2\2\2\u0373\u0374\3\2\2\2\u0374\u0375\3\2\2\2\u0375"
            + "\u037a\5n8\2\u0376\u0377\7\u0184\2\2\u0377\u0379\5n8\2\u0378\u0376\3\2"
            + "\2\2\u0379\u037c\3\2\2\2\u037a\u0378\3\2\2\2\u037a\u037b\3\2\2\2\u037b"
            + "i\3\2\2\2\u037c\u037a\3\2\2\2\u037d\u037e\t\16\2\2\u037ek\3\2\2\2\u037f"
            + "\u0380\7\u013d\2\2\u0380\u0381\5\u00ba^\2\u0381m\3\2\2\2\u0382\u0383\5"
            + "\u00eav\2\u0383\u0384\7\u0189\2\2\u0384\u0386\3\2\2\2\u0385\u0382\3\2"
            + "\2\2\u0385\u0386\3\2\2\2\u0386\u0387\3\2\2\2\u0387\u0389\5\u00ba^\2\u0388"
            + "\u038a\5p9\2\u0389\u0388\3\2\2\2\u0389\u038a\3\2\2\2\u038a\u038d\3\2\2"
            + "\2\u038b\u038d\5r:\2\u038c\u0385\3\2\2\2\u038c\u038b\3\2\2\2\u038do\3"
            + "\2\2\2\u038e\u0390\7\f\2\2\u038f\u038e\3\2\2\2\u038f\u0390\3\2\2\2\u0390"
            + "\u0391\3\2\2\2\u0391\u03a5\5\u00eav\2\u0392\u0394\7\f\2\2\u0393\u0392"
            + "\3\2\2\2\u0393\u0394\3\2\2\2\u0394\u0395\3\2\2\2\u0395\u0396\7\u0193\2"
            + "\2\u0396\u039b\5\u00eav\2\u0397\u0398\7\u0184\2\2\u0398\u039a\5\u00ea"
            + "v\2\u0399\u0397\3\2\2\2\u039a\u039d\3\2\2\2\u039b\u0399\3\2\2\2\u039b"
            + "\u039c\3\2\2\2\u039c\u039e\3\2\2\2\u039d\u039b\3\2\2\2\u039e\u039f\7\u0196"
            + "\2\2\u039f\u03a5\3\2\2\2\u03a0\u03a1\7\u0193\2\2\u03a1\u03a2\7\u013b\2"
            + "\2\u03a2\u03a3\7\u019b\2\2\u03a3\u03a5\7\u0196\2\2\u03a4\u038f\3\2\2\2"
            + "\u03a4\u0393\3\2\2\2\u03a4\u03a0\3\2\2\2\u03a5q\3\2\2\2\u03a6\u03a7\7"
            + "\u019a\2\2\u03a7\u03a9\7\u0187\2\2\u03a8\u03a6\3\2\2\2\u03a8\u03a9\3\2"
            + "\2\2\u03a9\u03aa\3\2\2\2\u03aa\u03ab\7\u0191\2\2\u03abs\3\2\2\2\u03ac"
            + "\u03ad\7\u009b\2\2\u03ad\u03b2\5\u00eav\2\u03ae\u03af\7\u0184\2\2\u03af"
            + "\u03b1\5\u00eav\2\u03b0\u03ae\3\2\2\2\u03b1\u03b4\3\2\2\2\u03b2\u03b0"
            + "\3\2\2\2\u03b2\u03b3\3\2\2\2\u03b3u\3\2\2\2\u03b4\u03b2\3\2\2\2\u03b5"
            + "\u03b6\7z\2\2\u03b6\u03ba\5x=\2\u03b7\u03b9\5~@\2\u03b8\u03b7\3\2\2\2"
            + "\u03b9\u03bc\3\2\2\2\u03ba\u03b8\3\2\2\2\u03ba\u03bb\3\2\2\2\u03bbw\3"
            + "\2\2\2\u03bc\u03ba\3\2\2\2\u03bd\u03c1\5z>\2\u03be\u03c1\5|?\2\u03bf\u03c1"
            + "\5\u0082B\2\u03c0\u03bd\3\2\2\2\u03c0\u03be\3\2\2\2\u03c0\u03bf\3\2\2"
            + "\2\u03c1y\3\2\2\2\u03c2\u03c4\5\u0088E\2\u03c3\u03c5\5\u0086D\2\u03c4"
            + "\u03c3\3\2\2\2\u03c4\u03c5\3\2\2\2\u03c5\u03c7\3\2\2\2\u03c6\u03c8\5\u0096"
            + "L\2\u03c7\u03c6\3\2\2\2\u03c7\u03c8\3\2\2\2\u03c8{\3\2\2\2\u03c9\u03ca"
            + "\7\u0193\2\2\u03ca\u03cb\5X-\2\u03cb\u03cd\7\u0196\2\2\u03cc\u03ce\5\u0086"
            + "D\2\u03cd\u03cc\3\2\2\2\u03cd\u03ce\3\2\2\2\u03ce}\3\2\2\2\u03cf\u03d0"
            + "\7\u0184\2\2\u03d0\u03d7\5x=\2\u03d1\u03d2\5\u0080A\2\u03d2\u03d3\5x="
            + "\2\u03d3\u03d4\7\u00cf\2\2\u03d4\u03d5\5\u00aaV\2\u03d5\u03d7\3\2\2\2"
            + "\u03d6\u03cf\3\2\2\2\u03d6\u03d1\3\2\2\2\u03d7\177\3\2\2\2\u03d8\u03da"
            + "\7\u0091\2\2\u03d9\u03d8\3\2\2\2\u03d9\u03da\3\2\2\2\u03da\u03db\3\2\2"
            + "\2\u03db\u03e2\7\u00a0\2\2\u03dc\u03de\t\17\2\2\u03dd\u03df\7\u00d5\2"
            + "\2\u03de\u03dd\3\2\2\2\u03de\u03df\3\2\2\2\u03df\u03e0\3\2\2\2\u03e0\u03e2"
            + "\7\u00a0\2\2\u03e1\u03d9\3\2\2\2\u03e1\u03dc\3\2\2\2\u03e2\u0081\3\2\2"
            + "\2\u03e3\u03e4\7\u012f\2\2\u03e4\u03e5\7\u0193\2\2\u03e5\u03e6\7\u0149"
            + "\2\2\u03e6\u03eb\5\u0084C\2\u03e7\u03e8\7\u0184\2\2\u03e8\u03ea\5\u0084"
            + "C\2\u03e9\u03e7\3\2\2\2\u03ea\u03ed\3\2\2\2\u03eb\u03e9\3\2\2\2\u03eb"
            + "\u03ec\3\2\2\2\u03ec\u03ee\3\2\2\2\u03ed\u03eb\3\2\2\2\u03ee\u03f0\7\u0196"
            + "\2\2\u03ef\u03f1\5\u0086D\2\u03f0\u03ef\3\2\2\2\u03f0\u03f1\3\2\2\2\u03f1"
            + "\u0083\3\2\2\2\u03f2\u03ff\5\u00ba^\2\u03f3\u03f4\7\u0193\2\2\u03f4\u03f9"
            + "\5\u00ba^\2\u03f5\u03f6\7\u0184\2\2\u03f6\u03f8\5\u00ba^\2\u03f7\u03f5"
            + "\3\2\2\2\u03f8\u03fb\3\2\2\2\u03f9\u03f7\3\2\2\2\u03f9\u03fa\3\2\2\2\u03fa"
            + "\u03fc\3\2\2\2\u03fb\u03f9\3\2\2\2\u03fc\u03fd\7\u0196\2\2\u03fd\u03ff"
            + "\3\2\2\2\u03fe\u03f2\3\2\2\2\u03fe\u03f3\3\2\2\2\u03ff\u0085\3\2\2\2\u0400"
            + "\u0402\6D\2\2\u0401\u0403\7\f\2\2\u0402\u0401\3\2\2\2\u0402\u0403\3\2"
            + "\2\2\u0403\u0404\3\2\2\2\u0404\u040f\5\u00eav\2\u0405\u0406\7\u0193\2"
            + "\2\u0406\u040b\7\u019a\2\2\u0407\u0408\7\u0184\2\2\u0408\u040a\7\u019a"
            + "\2\2\u0409\u0407\3\2\2\2\u040a\u040d\3\2\2\2\u040b\u0409\3\2\2\2\u040b"
            + "\u040c\3\2\2\2\u040c\u040e\3\2\2\2\u040d\u040b\3\2\2\2\u040e\u0410\7\u0196"
            + "\2\2\u040f\u0405\3\2\2\2\u040f\u0410\3\2\2\2\u0410\u0087\3\2\2\2\u0411"
            + "\u0412\5\u00eav\2\u0412\u0089\3\2\2\2\u0413\u0414\7\u0150\2\2\u0414\u0415"
            + "\5\u00aaV\2\u0415\u008b\3\2\2\2\u0416\u0417\7\u0082\2\2\u0417\u0418\7"
            + "\36\2\2\u0418\u041d\5\u00ba^\2\u0419\u041a\7\u0184\2\2\u041a\u041c\5\u00ba"
            + "^\2\u041b\u0419\3\2\2\2\u041c\u041f\3\2\2\2\u041d\u041b\3\2\2\2\u041d"
            + "\u041e\3\2\2\2\u041e\u008d\3\2\2\2\u041f\u041d\3\2\2\2\u0420\u0421\7\u0085"
            + "\2\2\u0421\u0422\5\u00aaV\2\u0422\u008f\3\2\2\2\u0423\u0424\7\u00eb\2"
            + "\2\u0424\u0425\5\u00aaV\2\u0425\u0091\3\2\2\2\u0426\u0427\7\u00d3\2\2"
            + "\u0427\u0428\7\36\2\2\u0428\u042d\5\u0094K\2\u0429\u042a\7\u0184\2\2\u042a"
            + "\u042c\5\u0094K\2\u042b\u0429\3\2\2\2\u042c\u042f\3\2\2\2\u042d\u042b"
            + "\3\2\2\2\u042d\u042e\3\2\2\2\u042e\u0093\3\2\2\2\u042f\u042d\3\2\2\2\u0430"
            + "\u0432\5\u00ba^\2\u0431\u0433\t\3\2\2\u0432\u0431\3\2\2\2\u0432\u0433"
            + "\3\2\2\2\u0433\u0095\3\2\2\2\u0434\u0435\7\u0109\2\2\u0435\u0436\7\u0193"
            + "\2\2\u0436\u0437\7\u019d\2\2\u0437\u0438\7\u00de\2\2\u0438\u0439\7\u0196"
            + "\2\2\u0439\u0097\3\2\2\2\u043a\u043c\5\u009aN\2\u043b\u043a\3\2\2\2\u043c"
            + "\u043d\3\2\2\2\u043d\u043b\3\2\2\2\u043d\u043e\3\2\2\2\u043e\u0099\3\2"
            + "\2\2\u043f\u0440\7\u00aa\2\2\u0440\u044b\5\u00ba^\2\u0441\u0442\7\u0152"
            + "\2\2\u0442\u0448\t\20\2\2\u0443\u0444\7\u0146\2\2\u0444\u0445\7\t\2\2"
            + "\u0445\u0446\7\u00a1\2\2\u0446\u0447\t\21\2\2\u0447\u0449\7\u00b1\2\2"
            + "\u0448\u0443\3\2\2\2\u0448\u0449\3\2\2\2\u0449\u044b\3\2\2\2\u044a\u043f"
            + "\3\2\2\2\u044a\u0441\3\2\2\2\u044b\u009b\3\2\2\2\u044c\u044d\7\u0144\2"
            + "\2\u044d\u044e\5\u00a0Q\2\u044e\u044f\7\u0111\2\2\u044f\u0451\5\u009e"
            + "P\2\u0450\u0452\5\u008aF\2\u0451\u0450\3\2\2\2\u0451\u0452\3\2\2\2\u0452"
            + "\u0454\3\2\2\2\u0453\u0455\5\u00a2R\2\u0454\u0453\3\2\2\2\u0454\u0455"
            + "\3\2\2\2\u0455\u009d\3\2\2\2\u0456\u045b\5\n\6\2\u0457\u0458\7\u0184\2"
            + "\2\u0458\u045a\5\n\6\2\u0459\u0457\3\2\2\2\u045a\u045d\3\2\2\2\u045b\u0459"
            + "\3\2\2\2\u045b\u045c\3\2\2\2\u045c\u009f\3\2\2\2\u045d\u045b\3\2\2\2\u045e"
            + "\u0460\5\u0088E\2\u045f\u0461\5v<\2\u0460\u045f\3\2\2\2\u0460\u0461\3"
            + "\2\2\2\u0461\u0467\3\2\2\2\u0462\u0463\7\u0193\2\2\u0463\u0464\5X-\2\u0464"
            + "\u0465\7\u0196\2\2\u0465\u0467\3\2\2\2\u0466\u045e\3\2\2\2\u0466\u0462"
            + "\3\2\2\2\u0467\u046c\3\2\2\2\u0468\u046a\7\f\2\2\u0469\u0468\3\2\2\2\u0469"
            + "\u046a\3\2\2\2\u046a\u046b\3\2\2\2\u046b\u046d\5\u00eav\2\u046c\u0469"
            + "\3\2\2\2\u046c\u046d\3\2\2\2\u046d\u00a1\3\2\2\2\u046e\u046f\7a\2\2\u046f"
            + "\u0470\5L\'\2\u0470\u00a3\3\2\2\2\u0471\u0473\7R\2\2\u0472\u0474\7z\2"
            + "\2\u0473\u0472\3\2\2\2\u0473\u0474\3\2\2\2\u0474\u0475\3\2\2\2\u0475\u0477"
            + "\5\u0088E\2\u0476\u0478\5\u00a6T\2\u0477\u0476\3\2\2\2\u0477\u0478\3\2"
            + "\2\2\u0478\u047b\3\2\2\2\u0479\u047c\5\u008aF\2\u047a\u047c\7\6\2\2\u047b"
            + "\u0479\3\2\2\2\u047b\u047a\3\2\2\2\u047b\u047c\3\2\2\2\u047c\u00a5\3\2"
            + "\2\2\u047d\u047f\6T\3\2\u047e\u0480\7\f\2\2\u047f\u047e\3\2\2\2\u047f"
            + "\u0480\3\2\2\2\u0480\u0481\3\2\2\2\u0481\u0482\5\u00eav\2\u0482\u00a7"
            + "\3\2\2\2\u0483\u0485\t\22\2\2\u0484\u0486\t\23\2\2\u0485\u0484\3\2\2\2"
            + "\u0485\u0486\3\2\2\2\u0486\u0487\3\2\2\2\u0487\u0488\5\b\5\2\u0488\u00a9"
            + "\3\2\2\2\u0489\u048b\bV\1\2\u048a\u048c\7\u00c8\2\2\u048b\u048a\3\2\2"
            + "\2\u048b\u048c\3\2\2\2\u048c\u048d\3\2\2\2\u048d\u048e\7\u0193\2\2\u048e"
            + "\u048f\5\u00aaV\2\u048f\u0490\7\u0196\2\2\u0490\u0493\3\2\2\2\u0491\u0493"
            + "\5\u00acW\2\u0492\u0489\3\2\2\2\u0492\u0491\3\2\2\2\u0493\u049a\3\2\2"
            + "\2\u0494\u0495\f\4\2\2\u0495\u0496\5\u00b6\\\2\u0496\u0497\5\u00aaV\5"
            + "\u0497\u0499\3\2\2\2\u0498\u0494\3\2\2\2\u0499\u049c\3\2\2\2\u049a\u0498"
            + "\3\2\2\2\u049a\u049b\3\2\2\2\u049b\u00ab\3\2\2\2\u049c\u049a\3\2\2\2\u049d"
            + "\u04a1\5\u00aeX\2\u049e\u04a1\5\u00b4[\2\u049f\u04a1\5\u00ba^\2\u04a0"
            + "\u049d\3\2\2\2\u04a0\u049e\3\2\2\2\u04a0\u049f\3\2\2\2\u04a1\u00ad\3\2"
            + "\2\2\u04a2\u04a3\5\u00ba^\2\u04a3\u04a5\7\u009d\2\2\u04a4\u04a6\7\u00c8"
            + "\2\2\u04a5\u04a4\3\2\2\2\u04a5\u04a6\3\2\2\2\u04a6\u04a7\3\2\2\2\u04a7"
            + "\u04a8\7\u00ca\2\2\u04a8\u04ba\3\2\2\2\u04a9\u04aa\5\u00ba^\2\u04aa\u04ab"
            + "\7\25\2\2\u04ab\u04ac\5\u00ba^\2\u04ac\u04ad\7\t\2\2\u04ad\u04ae\5\u00ba"
            + "^\2\u04ae\u04ba\3\2\2\2\u04af\u04b1\7\u00c8\2\2\u04b0\u04af\3\2\2\2\u04b0"
            + "\u04b1\3\2\2\2\u04b1\u04b2\3\2\2\2\u04b2\u04b3\7m\2\2\u04b3\u04b4\7\u0193"
            + "\2\2\u04b4\u04b5\5X-\2\u04b5\u04b6\7\u0196\2\2\u04b6\u04ba\3\2\2\2\u04b7"
            + "\u04ba\5\u00b0Y\2\u04b8\u04ba\5\u00b2Z\2\u04b9\u04a2\3\2\2\2\u04b9\u04a9"
            + "\3\2\2\2\u04b9\u04b0\3\2\2\2\u04b9\u04b7\3\2\2\2\u04b9\u04b8\3\2\2\2\u04ba"
            + "\u00af\3\2\2\2\u04bb\u04bd\5\u00ba^\2\u04bc\u04be\7\u00c8\2\2\u04bd\u04bc"
            + "\3\2\2\2\u04bd\u04be\3\2\2\2\u04be\u04bf\3\2\2\2\u04bf\u04c0\7\u008c\2"
            + "\2\u04c0\u04ca\7\u0193\2\2\u04c1\u04c6\5\u00ba^\2\u04c2\u04c3\7\u0184"
            + "\2\2\u04c3\u04c5\5\u00ba^\2\u04c4\u04c2\3\2\2\2\u04c5\u04c8\3\2\2\2\u04c6"
            + "\u04c4\3\2\2\2\u04c6\u04c7\3\2\2\2\u04c7\u04cb\3\2\2\2\u04c8\u04c6\3\2"
            + "\2\2\u04c9\u04cb\5X-\2\u04ca\u04c1\3\2\2\2\u04ca\u04c9\3\2\2\2\u04cb\u04cc"
            + "\3\2\2\2\u04cc\u04cd\7\u0196\2\2\u04cd\u00b1\3\2\2\2\u04ce\u04cf\7\u0193"
            + "\2\2\u04cf\u04d4\5\u00ba^\2\u04d0\u04d1\7\u0184\2\2\u04d1\u04d3\5\u00ba"
            + "^\2\u04d2\u04d0\3\2\2\2\u04d3\u04d6\3\2\2\2\u04d4\u04d2\3\2\2\2\u04d4"
            + "\u04d5\3\2\2\2\u04d5\u04d7\3\2\2\2\u04d6\u04d4\3\2\2\2\u04d7\u04d9\7\u0196"
            + "\2\2\u04d8\u04da\7\u00c8\2\2\u04d9\u04d8\3\2\2\2\u04d9\u04da\3\2\2\2\u04da"
            + "\u04db\3\2\2\2\u04db\u04dc\7\u008c\2\2\u04dc\u04dd\7\u0193\2\2\u04dd\u04de"
            + "\5X-\2\u04de\u04df\7\u0196\2\2\u04df\u00b3\3\2\2\2\u04e0\u04e1\5\u00ba"
            + "^\2\u04e1\u04e2\5\u00b8]\2\u04e2\u04e3\5\u00ba^\2\u04e3\u00b5\3\2\2\2"
            + "\u04e4\u04e5\t\24\2\2\u04e5\u00b7\3\2\2\2\u04e6\u04f3\7\u0189\2\2\u04e7"
            + "\u04f3\7\u018a\2\2\u04e8\u04f3\7\u018b\2\2\u04e9\u04f3\7\u018c\2\2\u04ea"
            + "\u04f3\7\u018f\2\2\u04eb\u04f3\7\u0190\2\2\u04ec\u04f3\7\u018d\2\2\u04ed"
            + "\u04f3\7\u018e\2\2\u04ee\u04f0\7\u00c8\2\2\u04ef\u04ee\3\2\2\2\u04ef\u04f0"
            + "\3\2\2\2\u04f0\u04f1\3\2\2\2\u04f1\u04f3\t\25\2\2\u04f2\u04e6\3\2\2\2"
            + "\u04f2\u04e7\3\2\2\2\u04f2\u04e8\3\2\2\2\u04f2\u04e9\3\2\2\2\u04f2\u04ea"
            + "\3\2\2\2\u04f2\u04eb\3\2\2\2\u04f2\u04ec\3\2\2\2\u04f2\u04ed\3\2\2\2\u04f2"
            + "\u04ef\3\2\2\2\u04f3\u00b9\3\2\2\2\u04f4\u04f5\b^\1\2\u04f5\u04f6\7\u0193"
            + "\2\2\u04f6\u04f7\5X-\2\u04f7\u04f8\7\u0196\2\2\u04f8\u0506\3\2\2\2\u04f9"
            + "\u04fa\7\u0193\2\2\u04fa\u04fb\5\u00ba^\2\u04fb\u04fc\7\u0196\2\2\u04fc"
            + "\u0506\3\2\2\2\u04fd\u0506\5\u00be`\2\u04fe\u0506\5\u00c2b\2\u04ff\u0506"
            + "\5\u00c6d\2\u0500\u0506\5\u00ceh\2\u0501\u0506\5\u00d0i\2\u0502\u0506"
            + "\5\u00d8m\2\u0503\u0506\5\u00dan\2\u0504\u0506\5\u00bc_\2\u0505\u04f4"
            + "\3\2\2\2\u0505\u04f9\3\2\2\2\u0505\u04fd\3\2\2\2\u0505\u04fe\3\2\2\2\u0505"
            + "\u04ff\3\2\2\2\u0505\u0500\3\2\2\2\u0505\u0501\3\2\2\2\u0505\u0502\3\2"
            + "\2\2\u0505\u0503\3\2\2\2\u0505\u0504\3\2\2\2\u0506\u0517\3\2\2\2\u0507"
            + "\u0508\f\20\2\2\u0508\u0509\7\u0191\2\2\u0509\u0516\5\u00ba^\21\u050a"
            + "\u050b\f\17\2\2\u050b\u050c\7\u0186\2\2\u050c\u0516\5\u00ba^\20\u050d"
            + "\u050e\f\16\2\2\u050e\u050f\7\u0182\2\2\u050f\u0516\5\u00ba^\17\u0510"
            + "\u0511\f\r\2\2\u0511\u0512\7\u0199\2\2\u0512\u0516\5\u00ba^\16\u0513\u0514"
            + "\f\21\2\2\u0514\u0516\5\u00c0a\2\u0515\u0507\3\2\2\2\u0515\u050a\3\2\2"
            + "\2\u0515\u050d\3\2\2\2\u0515\u0510\3\2\2\2\u0515\u0513\3\2\2\2\u0516\u0519"
            + "\3\2\2\2\u0517\u0515\3\2\2\2\u0517\u0518\3\2\2\2\u0518\u00bb\3\2\2\2\u0519"
            + "\u0517\3\2\2\2\u051a\u0523\5\u00e6t\2\u051b\u0523\5\u00e8u\2\u051c\u0523"
            + "\5\u00f4{\2\u051d\u0523\5\u00eav\2\u051e\u0523\5\u00eex\2\u051f\u0523"
            + "\5\u00f2z\2\u0520\u0523\5\u00f0y\2\u0521\u0523\5\u00f6|\2\u0522\u051a"
            + "\3\2\2\2\u0522\u051b\3\2\2\2\u0522\u051c\3\2\2\2\u0522\u051d\3\2\2\2\u0522"
            + "\u051e\3\2\2\2\u0522\u051f\3\2\2\2\u0522\u0520\3\2\2\2\u0522\u0521\3\2"
            + "\2\2\u0523\u00bd\3\2\2\2\u0524\u0525\7\u009a\2\2\u0525\u0526\5\u00ba^"
            + "\2\u0526\u0527\5\u00c0a\2\u0527\u00bf\3\2\2\2\u0528\u0529\t\26\2\2\u0529"
            + "\u00c1\3\2\2\2\u052a\u052b\5\u00c4c\2\u052b\u052c\t\27\2\2\u052c\u0531"
            + "\5\u00c4c\2\u052d\u052e\t\27\2\2\u052e\u0530\5\u00c4c\2\u052f\u052d\3"
            + "\2\2\2\u0530\u0533\3\2\2\2\u0531\u052f\3\2\2\2\u0531\u0532\3\2\2\2\u0532"
            + "\u00c3\3\2\2\2\u0533\u0531\3\2\2\2\u0534\u0535\7\u0193\2\2\u0535\u0536"
            + "\5\u00ba^\2\u0536\u0537\7\u0196\2\2\u0537\u053e\3\2\2\2\u0538\u053e\5"
            + "\u00c6d\2\u0539\u053e\5\u00d0i\2\u053a\u053e\5\u00d8m\2\u053b\u053e\5"
            + "\u00dan\2\u053c\u053e\5\u00bc_\2\u053d\u0534\3\2\2\2\u053d\u0538\3\2\2"
            + "\2\u053d\u0539\3\2\2\2\u053d\u053a\3\2\2\2\u053d\u053b\3\2\2\2\u053d\u053c"
            + "\3\2\2\2\u053e\u00c5\3\2\2\2\u053f\u0542\5\u00c8e\2\u0540\u0542\5\u00ca"
            + "f\2\u0541\u053f\3\2\2\2\u0541\u0540\3\2\2\2\u0542\u00c7\3\2\2\2\u0543"
            + "\u0544\7#\2\2\u0544\u054a\5\u00ba^\2\u0545\u0546\7\u014f\2\2\u0546\u0547"
            + "\5\u00ba^\2\u0547\u0548\7\u0138\2\2\u0548\u0549\5\u00ba^\2\u0549\u054b"
            + "\3\2\2\2\u054a\u0545\3\2\2\2\u054b\u054c\3\2\2\2\u054c\u054a\3\2\2\2\u054c"
            + "\u054d\3\2\2\2\u054d\u0550\3\2\2\2\u054e\u054f\7a\2\2\u054f\u0551\5\u00ba"
            + "^\2\u0550\u054e\3\2\2\2\u0550\u0551\3\2\2\2\u0551\u0552\3\2\2\2\u0552"
            + "\u0553\7e\2\2\u0553\u00c9\3\2\2\2\u0554\u0556\7#\2\2\u0555\u0557\5\u00cc"
            + "g\2\u0556\u0555\3\2\2\2\u0557\u0558\3\2\2\2\u0558\u0556\3\2\2\2\u0558"
            + "\u0559\3\2\2\2\u0559\u055c\3\2\2\2\u055a\u055b\7a\2\2\u055b\u055d\5\u00aa"
            + "V\2\u055c\u055a\3\2\2\2\u055c\u055d\3\2\2\2\u055d\u055e\3\2\2\2\u055e"
            + "\u055f\7e\2\2\u055f\u00cb\3\2\2\2\u0560\u0561\7\u014f\2\2\u0561\u0562"
            + "\5\u00aaV\2\u0562\u0563\7\u0138\2\2\u0563\u0564\5\u00aaV\2\u0564\u00cd"
            + "\3\2\2\2\u0565\u0566\5\u00eav\2\u0566\u0567\7\3\2\2\u0567\u0568\t\30\2"
            + "\2\u0568\u00cf\3\2\2\2\u0569\u056a\7\22\2\2\u056a\u056c\7\u0193\2\2\u056b"
            + "\u056d\5\u00d2j\2\u056c\u056b\3\2\2\2\u056c\u056d\3\2\2\2\u056d\u056e"
            + "\3\2\2\2\u056e\u056f\5\u00ba^\2\u056f\u0571\7\u0196\2\2\u0570\u0572\5"
            + "\u00d4k\2\u0571\u0570\3\2\2\2\u0571\u0572\3\2\2\2\u0572\u0602\3\2\2\2"
            + "\u0573\u0574\7:\2\2\u0574\u057a\7\u0193\2\2\u0575\u0577\5\u00d2j\2\u0576"
            + "\u0575\3\2\2\2\u0576\u0577\3\2\2\2\u0577\u0578\3\2\2\2\u0578\u057b\5\u00ba"
            + "^\2\u0579\u057b\7\u0191\2\2\u057a\u0576\3\2\2\2\u057a\u0579\3\2\2\2\u057b"
            + "\u057c\3\2\2\2\u057c\u057e\7\u0196\2\2\u057d\u057f\5\u00d4k\2\u057e\u057d"
            + "\3\2\2\2\u057e\u057f\3\2\2\2\u057f\u0602\3\2\2\2\u0580\u0581\7;\2\2\u0581"
            + "\u0587\7\u0193\2\2\u0582\u0584\5\u00d2j\2\u0583\u0582\3\2\2\2\u0583\u0584"
            + "\3\2\2\2\u0584\u0585\3\2\2\2\u0585\u0588\5\u00ba^\2\u0586\u0588\7\u0191"
            + "\2\2\u0587\u0583\3\2\2\2\u0587\u0586\3\2\2\2\u0588\u0589\3\2\2\2\u0589"
            + "\u058b\7\u0196\2\2\u058a\u058c\5\u00d4k\2\u058b\u058a\3\2\2\2\u058b\u058c"
            + "\3\2\2\2\u058c\u0602\3\2\2\2\u058d\u058e\7\u0159\2\2\u058e\u058f\7\u0193"
            + "\2\2\u058f\u0590\7\u0196\2\2\u0590\u0602\5\u00d4k\2\u0591\u0592\7\u015f"
            + "\2\2\u0592\u0593\7\u0193\2\2\u0593\u0594\7\u0196\2\2\u0594\u0602\5\u00d4"
            + "k\2\u0595\u0596\7\u0160\2\2\u0596\u0597\7\u0193\2\2\u0597\u0598\5\u00ba"
            + "^\2\u0598\u0599\7\u0196\2\2\u0599\u059a\5\u00d4k\2\u059a\u0602\3\2\2\2"
            + "\u059b\u059c\7\u0161\2\2\u059c\u059d\7\u0193\2\2\u059d\u05a4\5\u00ba^"
            + "\2\u059e\u059f\7\u0184\2\2\u059f\u05a2\5\u00ba^\2\u05a0\u05a1\7\u0184"
            + "\2\2\u05a1\u05a3\5\u00ba^\2\u05a2\u05a0\3\2\2\2\u05a2\u05a3\3\2\2\2\u05a3"
            + "\u05a5\3\2\2\2\u05a4\u059e\3\2\2\2\u05a4\u05a5\3\2\2\2\u05a5\u05a6\3\2"
            + "\2\2\u05a6\u05a7\7\u0196\2\2\u05a7\u05a8\5\u00d4k\2\u05a8\u0602\3\2\2"
            + "\2\u05a9\u05aa\7\u0162\2\2\u05aa\u05ab\7\u0193\2\2\u05ab\u05ac\5\u00ba"
            + "^\2\u05ac\u05ad\7\u0196\2\2\u05ad\u05ae\5\u00d4k\2\u05ae\u0602\3\2\2\2"
            + "\u05af\u05b0\7\u0163\2\2\u05b0\u05b1\7\u0193\2\2\u05b1\u05b8\5\u00ba^"
            + "\2\u05b2\u05b3\7\u0184\2\2\u05b3\u05b6\5\u00ba^\2\u05b4\u05b5\7\u0184"
            + "\2\2\u05b5\u05b7\5\u00ba^\2\u05b6\u05b4\3\2\2\2\u05b6\u05b7\3\2\2\2\u05b7"
            + "\u05b9\3\2\2\2\u05b8\u05b2\3\2\2\2\u05b8\u05b9\3\2\2\2\u05b9\u05ba\3\2"
            + "\2\2\u05ba\u05bb\7\u0196\2\2\u05bb\u05bc\5\u00d4k\2\u05bc\u0602\3\2\2"
            + "\2\u05bd\u05be\7\u00b8\2\2\u05be\u05c0\7\u0193\2\2\u05bf\u05c1\5\u00d2"
            + "j\2\u05c0\u05bf\3\2\2\2\u05c0\u05c1\3\2\2\2\u05c1\u05c2\3\2\2\2\u05c2"
            + "\u05c3\5\u00ba^\2\u05c3\u05c5\7\u0196\2\2\u05c4\u05c6\5\u00d4k\2\u05c5"
            + "\u05c4\3\2\2\2\u05c5\u05c6\3\2\2\2\u05c6\u0602\3\2\2\2\u05c7\u05c8\7\u00be"
            + "\2\2\u05c8\u05ca\7\u0193\2\2\u05c9\u05cb\5\u00d2j\2\u05ca\u05c9\3\2\2"
            + "\2\u05ca\u05cb\3\2\2\2\u05cb\u05cc\3\2\2\2\u05cc\u05cd\5\u00ba^\2\u05cd"
            + "\u05cf\7\u0196\2\2\u05ce\u05d0\5\u00d4k\2\u05cf\u05ce\3\2\2\2\u05cf\u05d0"
            + "\3\2\2\2\u05d0\u0602\3\2\2\2\u05d1\u05d2\7\u016c\2\2\u05d2\u05d3\7\u0193"
            + "\2\2\u05d3\u05d4\7\u0196\2\2\u05d4\u0602\5\u00d4k\2\u05d5\u05d6\7\u016d"
            + "\2\2\u05d6\u05d7\7\u0193\2\2\u05d7\u05d8\7\u0196\2\2\u05d8\u0602\5\u00d4"
            + "k\2\u05d9\u05da\7\u016e\2\2\u05da\u05dc\7\u0193\2\2\u05db\u05dd\5\u00d2"
            + "j\2\u05dc\u05db\3\2\2\2\u05dc\u05dd\3\2\2\2\u05dd\u05de\3\2\2\2\u05de"
            + "\u05df\5\u00ba^\2\u05df\u05e1\7\u0196\2\2\u05e0\u05e2\5\u00d4k\2\u05e1"
            + "\u05e0\3\2\2\2\u05e1\u05e2\3\2\2\2\u05e2\u0602\3\2\2\2\u05e3\u05e4\7\u012c"
            + "\2\2\u05e4\u05e6\7\u0193\2\2\u05e5\u05e7\5\u00d2j\2\u05e6\u05e5\3\2\2"
            + "\2\u05e6\u05e7\3\2\2\2\u05e7\u05e8\3\2\2\2\u05e8\u05e9\5\u00ba^\2\u05e9"
            + "\u05eb\7\u0196\2\2\u05ea\u05ec\5\u00d4k\2\u05eb\u05ea\3\2\2\2\u05eb\u05ec"
            + "\3\2\2\2\u05ec\u0602\3\2\2\2\u05ed\u05ee\7\u014a\2\2\u05ee\u05f0\7\u0193"
            + "\2\2\u05ef\u05f1\5\u00d2j\2\u05f0\u05ef\3\2\2\2\u05f0\u05f1\3\2\2\2\u05f1"
            + "\u05f2\3\2\2\2\u05f2\u05f3\5\u00ba^\2\u05f3\u05f5\7\u0196\2\2\u05f4\u05f6"
            + "\5\u00d4k\2\u05f5\u05f4\3\2\2\2\u05f5\u05f6\3\2\2\2\u05f6\u0602\3\2\2"
            + "\2\u05f7\u05f8\7\u0170\2\2\u05f8\u05fa\7\u0193\2\2\u05f9\u05fb\5\u00d2"
            + "j\2\u05fa\u05f9\3\2\2\2\u05fa\u05fb\3\2\2\2\u05fb\u05fc\3\2\2\2\u05fc"
            + "\u05fd\5\u00ba^\2\u05fd\u05ff\7\u0196\2\2\u05fe\u0600\5\u00d4k\2\u05ff"
            + "\u05fe\3\2\2\2\u05ff\u0600\3\2\2\2\u0600\u0602\3\2\2\2\u0601\u0569\3\2"
            + "\2\2\u0601\u0573\3\2\2\2\u0601\u0580\3\2\2\2\u0601\u058d\3\2\2\2\u0601"
            + "\u0591\3\2\2\2\u0601\u0595\3\2\2\2\u0601\u059b\3\2\2\2\u0601\u05a9\3\2"
            + "\2\2\u0601\u05af\3\2\2\2\u0601\u05bd\3\2\2\2\u0601\u05c7\3\2\2\2\u0601"
            + "\u05d1\3\2\2\2\u0601\u05d5\3\2\2\2\u0601\u05d9\3\2\2\2\u0601\u05e3\3\2"
            + "\2\2\u0601\u05ed\3\2\2\2\u0601\u05f7\3\2\2\2\u0602\u00d1\3\2\2\2\u0603"
            + "\u0604\t\16\2\2\u0604\u00d3\3\2\2\2\u0605\u0606\7\u00d6\2\2\u0606\u0608"
            + "\7\u0193\2\2\u0607\u0609\5\u00d6l\2\u0608\u0607\3\2\2\2\u0608\u0609\3"
            + "\2\2\2\u0609\u060b\3\2\2\2\u060a\u060c\5\u0092J\2\u060b\u060a\3\2\2\2"
            + "\u060b\u060c\3\2\2\2\u060c\u060d\3\2\2\2\u060d\u060e\7\u0196\2\2\u060e"
            + "\u00d5\3\2\2\2\u060f\u0610\7\u00da\2\2\u0610\u0611\7\36\2\2\u0611\u0616"
            + "\5\u00ba^\2\u0612\u0613\7\u0184\2\2\u0613\u0615\5\u00ba^\2\u0614\u0612"
            + "\3\2\2\2\u0615\u0618\3\2\2\2\u0616\u0614\3\2\2\2\u0616\u0617\3\2\2\2\u0617"
            + "\u00d7\3\2\2\2\u0618\u0616\3\2\2\2\u0619\u06df\7\u0158\2\2\u061a\u061b"
            + "\7%\2\2\u061b\u061c\7\u0193\2\2\u061c\u061d\5\u00ba^\2\u061d\u061e\7\f"
            + "\2\2\u061e\u0620\5> \2\u061f\u0621\5@!\2\u0620\u061f\3\2\2\2\u0620\u0621"
            + "\3\2\2\2\u0621\u0622\3\2\2\2\u0622\u0623\7\u0196\2\2\u0623\u06df\3\2\2"
            + "\2\u0624\u0625\7:\2\2\u0625\u0628\7\u0193\2\2\u0626\u0629\5\u00ba^\2\u0627"
            + "\u0629\7\u0191\2\2\u0628\u0626\3\2\2\2\u0628\u0627\3\2\2\2\u0629\u062a"
            + "\3\2\2\2\u062a\u06df\7\u0196\2\2\u062b\u06df\7\u015a\2\2\u062c\u062d\7"
            + "@\2\2\u062d\u06df\7F\2\2\u062e\u06df\7\u015b\2\2\u062f\u06df\7\u015c\2"
            + "\2\u0630\u0634\7\u015d\2\2\u0631\u0632\7@\2\2\u0632\u0634\7\u0139\2\2"
            + "\u0633\u0630\3\2\2\2\u0633\u0631\3\2\2\2\u0634\u0639\3\2\2\2\u0635\u0636"
            + "\7\u0193\2\2\u0636\u0637\5\u00ba^\2\u0637\u0638\7\u0196\2\2\u0638\u063a"
            + "\3\2\2\2\u0639\u0635\3\2\2\2\u0639\u063a\3\2\2\2\u063a\u06df\3\2\2\2\u063b"
            + "\u06df\7\u015e\2\2\u063c\u063d\7@\2\2\u063d\u06df\7\u0171\2\2\u063e\u063f"
            + "\7\u0164\2\2\u063f\u0640\7\u0193\2\2\u0640\u064d\5\u00ba^\2\u0641\u0642"
            + "\7\u0184\2\2\u0642\u064a\5\u00ba^\2\u0643\u0644\7\u0184\2\2\u0644\u0645"
            + "\5\u00ba^\2\u0645\u0646\7\u0189\2\2\u0646\u0647\5\u00ba^\2\u0647\u0649"
            + "\3\2\2\2\u0648\u0643\3\2\2\2\u0649\u064c\3\2\2\2\u064a\u0648\3\2\2\2\u064a"
            + "\u064b\3\2\2\2\u064b\u064e\3\2\2\2\u064c\u064a\3\2\2\2\u064d\u0641\3\2"
            + "\2\2\u064d\u064e\3\2\2\2\u064e\u064f\3\2\2\2\u064f\u0650\7\u0196\2\2\u0650"
            + "\u06df\3\2\2\2\u0651\u0652\7\u0165\2\2\u0652\u0653\7\u0193\2\2\u0653\u0660"
            + "\5\u00ba^\2\u0654\u0655\7\u0184\2\2\u0655\u065d\5\u00ba^\2\u0656\u0657"
            + "\7\u0184\2\2\u0657\u0658\5\u00ba^\2\u0658\u0659\7\u0189\2\2\u0659\u065a"
            + "\5\u00ba^\2\u065a\u065c\3\2\2\2\u065b\u0656\3\2\2\2\u065c\u065f\3\2\2"
            + "\2\u065d\u065b\3\2\2\2\u065d\u065e\3\2\2\2\u065e\u0661\3\2\2\2\u065f\u065d"
            + "\3\2\2\2\u0660\u0654\3\2\2\2\u0660\u0661\3\2\2\2\u0661\u0662\3\2\2\2\u0662"
            + "\u0663\7\u0196\2\2\u0663\u06df\3\2\2\2\u0664\u0665\7\u0166\2\2\u0665\u0666"
            + "\7\u0193\2\2\u0666\u0673\5\u00ba^\2\u0667\u0668\7\u0184\2\2\u0668\u0670"
            + "\5\u00ba^\2\u0669\u066a\7\u0184\2\2\u066a\u066b\5\u00ba^\2\u066b\u066c"
            + "\7\u0189\2\2\u066c\u066d\5\u00ba^\2\u066d\u066f\3\2\2\2\u066e\u0669\3"
            + "\2\2\2\u066f\u0672\3\2\2\2\u0670\u066e\3\2\2\2\u0670\u0671\3\2\2\2\u0671"
            + "\u0674\3\2\2\2\u0672\u0670\3\2\2\2\u0673\u0667\3\2\2\2\u0673\u0674\3\2"
            + "\2\2\u0674\u0675\3\2\2\2\u0675\u0676\7\u0196\2\2\u0676\u06df\3\2\2\2\u0677"
            + "\u0678\7\u0167\2\2\u0678\u0679\7\u0193\2\2\u0679\u0686\5\u00ba^\2\u067a"
            + "\u067b\7\u0184\2\2\u067b\u0683\5\u00ba^\2\u067c\u067d\7\u0184\2\2\u067d"
            + "\u067e\5\u00ba^\2\u067e\u067f\7\u0189\2\2\u067f\u0680\5\u00ba^\2\u0680"
            + "\u0682\3\2\2\2\u0681\u067c\3\2\2\2\u0682\u0685\3\2\2\2\u0683\u0681\3\2"
            + "\2\2\u0683\u0684\3\2\2\2\u0684\u0687\3\2\2\2\u0685\u0683\3\2\2\2\u0686"
            + "\u067a\3\2\2\2\u0686\u0687\3\2\2\2\u0687\u0688\3\2\2\2\u0688\u0689\7\u0196"
            + "\2\2\u0689\u06df\3\2\2\2\u068a\u068b\7\u0168\2\2\u068b\u068c\7\u0193\2"
            + "\2\u068c\u0699\5\u00ba^\2\u068d\u068e\7\u0184\2\2\u068e\u0696\5\u00ba"
            + "^\2\u068f\u0690\7\u0184\2\2\u0690\u0691\5\u00ba^\2\u0691\u0692\7\u0189"
            + "\2\2\u0692\u0693\5\u00ba^\2\u0693\u0695\3\2\2\2\u0694\u068f\3\2\2\2\u0695"
            + "\u0698\3\2\2\2\u0696\u0694\3\2\2\2\u0696\u0697\3\2\2\2\u0697\u069a\3\2"
            + "\2\2\u0698\u0696\3\2\2\2\u0699\u068d\3\2\2\2\u0699\u069a\3\2\2\2\u069a"
            + "\u069b\3\2\2\2\u069b\u069c\7\u0196\2\2\u069c\u06df\3\2\2\2\u069d\u069e"
            + "\7\u0169\2\2\u069e\u069f\7\u0193\2\2\u069f\u06ac\5\u00ba^\2\u06a0\u06a1"
            + "\7\u0184\2\2\u06a1\u06a9\5\u00ba^\2\u06a2\u06a3\7\u0184\2\2\u06a3\u06a4"
            + "\5\u00ba^\2\u06a4\u06a5\7\u0189\2\2\u06a5\u06a6\5\u00ba^\2\u06a6\u06a8"
            + "\3\2\2\2\u06a7\u06a2\3\2\2\2\u06a8\u06ab\3\2\2\2\u06a9\u06a7\3\2\2\2\u06a9"
            + "\u06aa\3\2\2\2\u06aa\u06ad\3\2\2\2\u06ab\u06a9\3\2\2\2\u06ac\u06a0\3\2"
            + "\2\2\u06ac\u06ad\3\2\2\2\u06ad\u06ae\3\2\2\2\u06ae\u06af\7\u0196\2\2\u06af"
            + "\u06df\3\2\2\2\u06b0\u06b1\7\u016a\2\2\u06b1\u06b2\7\u0193\2\2\u06b2\u06ba"
            + "\5\u00ba^\2\u06b3\u06b4\7\u0184\2\2\u06b4\u06b5\5\u00ba^\2\u06b5\u06b6"
            + "\7\u0189\2\2\u06b6\u06b7\5\u00ba^\2\u06b7\u06b9\3\2\2\2\u06b8\u06b3\3"
            + "\2\2\2\u06b9\u06bc\3\2\2\2\u06ba\u06b8\3\2\2\2\u06ba\u06bb\3\2\2\2\u06bb"
            + "\u06bd\3\2\2\2\u06bc\u06ba\3\2\2\2\u06bd\u06be\7\u0196\2\2\u06be\u06df"
            + "\3\2\2\2\u06bf\u06c0\7\u016b\2\2\u06c0\u06c1\7\u0193\2\2\u06c1\u06c7\5"
            + "\u00ba^\2\u06c2\u06c3\7\u0184\2\2\u06c3\u06c4\5\u00ba^\2\u06c4\u06c5\7"
            + "\u0189\2\2\u06c5\u06c6\5\u00ba^\2\u06c6\u06c8\3\2\2\2\u06c7\u06c2\3\2"
            + "\2\2\u06c8\u06c9\3\2\2\2\u06c9\u06c7\3\2\2\2\u06c9\u06ca\3\2\2\2\u06ca"
            + "\u06cd\3\2\2\2\u06cb\u06cc\7\u0184\2\2\u06cc\u06ce\5\u00ba^\2\u06cd\u06cb"
            + "\3\2\2\2\u06cd\u06ce\3\2\2\2\u06ce\u06cf\3\2\2\2\u06cf\u06d0\7\u0196\2"
            + "\2\u06d0\u06df\3\2\2\2\u06d1\u06d2\7\u012b\2\2\u06d2\u06d3\7\u0193\2\2"
            + "\u06d3\u06d4\5\u00ba^\2\u06d4\u06d5\7z\2\2\u06d5\u06d8\5\u00ba^\2\u06d6"
            + "\u06d7\7v\2\2\u06d7\u06d9\5\u00ba^\2\u06d8\u06d6\3\2\2\2\u06d8\u06d9\3"
            + "\2\2\2\u06d9\u06da\3\2\2\2\u06da\u06db\7\u0196\2\2\u06db\u06df\3\2\2\2"
            + "\u06dc\u06df\7\u016f\2\2\u06dd\u06df\7\u0171\2\2\u06de\u0619\3\2\2\2\u06de"
            + "\u061a\3\2\2\2\u06de\u0624\3\2\2\2\u06de\u062b\3\2\2\2\u06de\u062c\3\2"
            + "\2\2\u06de\u062e\3\2\2\2\u06de\u062f\3\2\2\2\u06de\u0633\3\2\2\2\u06de"
            + "\u063b\3\2\2\2\u06de\u063c\3\2\2\2\u06de\u063e\3\2\2\2\u06de\u0651\3\2"
            + "\2\2\u06de\u0664\3\2\2\2\u06de\u0677\3\2\2\2\u06de\u068a\3\2\2\2\u06de"
            + "\u069d\3\2\2\2\u06de\u06b0\3\2\2\2\u06de\u06bf\3\2\2\2\u06de\u06d1\3\2"
            + "\2\2\u06de\u06dc\3\2\2\2\u06de\u06dd\3\2\2\2\u06df\u00d9\3\2\2\2\u06e0"
            + "\u06e1\5\u00eav\2\u06e1\u06e3\7\u0193\2\2\u06e2\u06e4\5\u00dco\2\u06e3"
            + "\u06e2\3\2\2\2\u06e3\u06e4\3\2\2\2\u06e4\u06e5\3\2\2\2\u06e5\u06e6\7\u0196"
            + "\2\2\u06e6\u00db\3\2\2\2\u06e7\u06ec\5\u00dep\2\u06e8\u06e9\7\u0184\2"
            + "\2\u06e9\u06eb\5\u00dep\2\u06ea\u06e8\3\2\2\2\u06eb\u06ee\3\2\2\2\u06ec"
            + "\u06ea\3\2\2\2\u06ec\u06ed\3\2\2\2\u06ed\u00dd\3\2\2\2\u06ee\u06ec\3\2"
            + "\2\2\u06ef\u06fb\3\2\2\2\u06f0\u06f6\6p\n\2\u06f1\u06f2\5\u00eav\2\u06f2"
            + "\u06f4\7\u0189\2\2\u06f3\u06f5\7\u018d\2\2\u06f4\u06f3\3\2\2\2\u06f4\u06f5"
            + "\3\2\2\2\u06f5\u06f7\3\2\2\2\u06f6\u06f1\3\2\2\2\u06f6\u06f7\3\2\2\2\u06f7"
            + "\u06f8\3\2\2\2\u06f8\u06fb\5\u00ba^\2\u06f9\u06fb\7\u0191\2\2\u06fa\u06ef"
            + "\3\2\2\2\u06fa\u06f0\3\2\2\2\u06fa\u06f9\3\2\2\2\u06fb\u00df\3\2\2\2\u06fc"
            + "\u06fd\5\u00e4s\2\u06fd\u00e1\3\2\2\2\u06fe\u06ff\5\u00eav\2\u06ff\u00e3"
            + "\3\2\2\2\u0700\u0705\5\u00eav\2\u0701\u0702\7\u0187\2\2\u0702\u0704\5"
            + "\u00eav\2\u0703\u0701\3\2\2\2\u0704\u0707\3\2\2\2\u0705\u0703\3\2\2\2"
            + "\u0705\u0706\3\2\2\2\u0706\u00e5\3\2\2\2\u0707\u0705\3\2\2\2\u0708\u0709"
            + "\7F\2\2\u0709\u070a\5\u00eex\2\u070a\u00e7\3\2\2\2\u070b\u070c\7\u0139"
            + "\2\2\u070c\u070d\5\u00eex\2\u070d\u00e9\3\2\2\2\u070e\u0710\7\u0199\2"
            + "\2\u070f\u070e\3\2\2\2\u070f\u0710\3\2\2\2\u0710\u0711\3\2\2\2\u0711\u0716"
            + "\5\u00ecw\2\u0712\u0713\7\u0187\2\2\u0713\u0715\5\u00ecw\2\u0714\u0712"
            + "\3\2\2\2\u0715\u0718\3\2\2\2\u0716\u0714\3\2\2\2\u0716\u0717\3\2\2\2\u0717"
            + "\u00eb\3\2\2\2\u0718\u0716\3\2\2\2\u0719\u071c\7\u019a\2\2\u071a\u071c"
            + "\5\u00f8}\2\u071b\u0719\3\2\2\2\u071b\u071a\3\2\2\2\u071c\u00ed\3\2\2"
            + "\2\u071d\u0720\7\u019b\2\2\u071e\u0720\7\u019c\2\2\u071f\u071d\3\2\2\2"
            + "\u071f\u071e\3\2\2\2\u0720\u00ef\3\2\2\2\u0721\u0723\t\31\2\2\u0722\u0721"
            + "\3\2\2\2\u0722\u0723\3\2\2\2\u0723\u0724\3\2\2\2\u0724\u0725\7\u019d\2"
            + "\2\u0725\u00f1\3\2\2\2\u0726\u0728\t\31\2\2\u0727\u0726\3\2\2\2\u0727"
            + "\u0728\3\2\2\2\u0728\u0729\3\2\2\2\u0729\u072a\7\u019e\2\2\u072a\u00f3"
            + "\3\2\2\2\u072b\u072c\t\32\2\2\u072c\u00f5\3\2\2\2\u072d\u072e\7\u00ca"
            + "\2\2\u072e\u00f7\3\2\2\2\u072f\u0730\t\33\2\2\u0730\u00f9\3\2\2\2\u00e6"
            + "\u00fc\u0111\u0115\u011c\u011f\u0124\u0128\u0131\u0136\u013e\u0143\u014c"
            + "\u0158\u015d\u0160\u0174\u0178\u0184\u018b\u0194\u0197\u019e\u01a6\u01ac"
            + "\u01b1\u01b4\u01ba\u01c8\u01d2\u01d8\u01dd\u01e2\u01e7\u01eb\u01f0\u01fa"
            + "\u0206\u020d\u0210\u021c\u0221\u0227\u022e\u0235\u0239\u023e\u0242\u0247"
            + "\u024a\u024f\u0252\u0256\u0262\u0269\u026c\u0271\u0275\u0277\u027d\u0284"
            + "\u0287\u02a2\u02a4\u02a9\u02ad\u02b6\u02bc\u02c6\u02ce\u02d4\u02dd\u02df"
            + "\u02e3\u02e7\u02ef\u02fa\u0303\u030a\u0312\u031c\u0321\u032e\u0339\u0340"
            + "\u0347\u034b\u034f\u0353\u0355\u035a\u035d\u0360\u0363\u0367\u036a\u036d"
            + "\u0370\u0373\u037a\u0385\u0389\u038c\u038f\u0393\u039b\u03a4\u03a8\u03b2"
            + "\u03ba\u03c0\u03c4\u03c7\u03cd\u03d6\u03d9\u03de\u03e1\u03eb\u03f0\u03f9"
            + "\u03fe\u0402\u040b\u040f\u041d\u042d\u0432\u043d\u0448\u044a\u0451\u0454"
            + "\u045b\u0460\u0466\u0469\u046c\u0473\u0477\u047b\u047f\u0485\u048b\u0492"
            + "\u049a\u04a0\u04a5\u04b0\u04b9\u04bd\u04c6\u04ca\u04d4\u04d9\u04ef\u04f2"
            + "\u0505\u0515\u0517\u0522\u0531\u053d\u0541\u054c\u0550\u0558\u055c\u056c"
            + "\u0571\u0576\u057a\u057e\u0583\u0587\u058b\u05a2\u05a4\u05b6\u05b8\u05c0"
            + "\u05c5\u05ca\u05cf\u05dc\u05e1\u05e6\u05eb\u05f0\u05f5\u05fa\u05ff\u0601"
            + "\u0608\u060b\u0616\u0620\u0628\u0633\u0639\u064a\u064d\u065d\u0660\u0670"
            + "\u0673\u0683\u0686\u0696\u0699\u06a9\u06ac\u06ba\u06c9\u06cd\u06d8\u06de"
            + "\u06e3\u06ec\u06f4\u06f6\u06fa\u0705\u070f\u0716\u071b\u071f\u0722\u0727";
    public static final ATN _ATN = new ATNDeserializer().deserialize(_serializedATN.toCharArray());
    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}
