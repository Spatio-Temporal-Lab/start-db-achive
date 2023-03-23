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

package org.urbcomp.cupid.db.parser.parser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({ "all", "warnings", "unchecked", "unused", "cast" })
public class CupidDBSqlParser extends Parser {
    static {
        RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION);
    }

    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
        new PredictionContextCache();
    public static final int T__0 = 1, T_ACTION = 2, T_ADD2 = 3, T_ALL = 4, T_ALLOCATE = 5, T_ALTER =
        6, T_AND = 7, T_ANSI_NULLS = 8, T_ANSI_PADDING = 9, T_AS = 10, T_ASC = 11, T_ASSOCIATE = 12,
        T_AT = 13, T_ATTRIBUTE = 14, T_AUTO = 15, T_AUTO_INCREMENT = 16, T_AVG = 17, T_BATCHSIZE =
            18, T_BEGIN = 19, T_BETWEEN = 20, T_BIGINT = 21, T_BINARY_DOUBLE = 22, T_BINARY_FLOAT =
                23, T_BINARY_INTEGER = 24, T_BIT = 25, T_BODY = 26, T_BREAK = 27, T_BUILD = 28,
        T_BY = 29, T_BYTE = 30, T_CALL = 31, T_CALLER = 32, T_CASCADE = 33, T_CASE = 34,
        T_CASESPECIFIC = 35, T_CAST = 36, T_CHAR = 37, T_CHARACTER = 38, T_CHARSET = 39, T_CLIENT =
            40, T_CLOSE = 41, T_CLUSTERED = 42, T_CMP = 43, T_COLLECT = 44, T_COLLECTION = 45,
        T_COLUMN = 46, T_COMMENT = 47, T_CONFIG = 48, T_CONSTANT = 49, T_COMMIT = 50, T_COMPRESS =
            51, T_CONCAT = 52, T_CONDITION = 53, T_CONSTRAINT = 54, T_CONTINUE = 55, T_COPY = 56,
        T_COUNT = 57, T_COUNT_BIG = 58, T_CREATE = 59, T_CREATION = 60, T_CREATOR = 61, T_CS = 62,
        T_CURRENT = 63, T_CURRENT_SCHEMA = 64, T_CURSOR = 65, T_DATABASE = 66, T_DATABASES = 67,
        T_DATA = 68, T_DATE = 69, T_DATETIME = 70, T_DAY = 71, T_DAYS = 72, T_DEC = 73, T_DECIMAL =
            74, T_DECLARE = 75, T_DEFAULT = 76, T_DEFERRED = 77, T_DEFINED = 78, T_DEFINER = 79,
        T_DEFINITION = 80, T_DELETE = 81, T_DELIMITED = 82, T_DELIMITER = 83, T_DESC = 84,
        T_DESCRIBE = 85, T_DIAGNOSTICS = 86, T_DIR = 87, T_DIRECTORY = 88, T_DISTINCT = 89,
        T_DISTRIBUTE = 90, T_DO = 91, T_DOUBLE = 92, T_DOWNLOAD = 93, T_DROP = 94, T_DYNAMIC = 95,
        T_ELSE = 96, T_ELSEIF = 97, T_ELSIF = 98, T_ENABLE = 99, T_END = 100, T_ENGINE = 101,
        T_ESCAPED = 102, T_EXCEPT = 103, T_EXEC = 104, T_EXECUTE = 105, T_EXCEPTION = 106,
        T_EXCLUSIVE = 107, T_EXISTS = 108, T_EXIT = 109, T_FALLBACK = 110, T_FALSE = 111, T_FETCH =
            112, T_FIELDS = 113, T_FILE = 114, T_FILES = 115, T_FLOAT = 116, T_FOR = 117,
        T_FOREIGN = 118, T_FORMAT = 119, T_FOUND = 120, T_FROM = 121, T_FULL = 122, T_FUNCTION =
            123, T_GET = 124, T_GLOBAL = 125, T_GO = 126, T_GRANT = 127, T_GRANTS = 128, T_GROUP =
                129, T_HANDLER = 130, T_HASH = 131, T_HAVING = 132, T_HOST = 133, T_IDENTITY = 134,
        T_IDENTIFIED = 135, T_IF = 136, T_IGNORE = 137, T_IMMEDIATE = 138, T_IN = 139, T_INCLUDE =
            140, T_INCREMENT = 141, T_INDEX = 142, T_INITRANS = 143, T_INNER = 144, T_INOUT = 145,
        T_INSERT = 146, T_INT = 147, T_INT2 = 148, T_INT4 = 149, T_INT8 = 150, T_INTEGER = 151,
        T_INTERSECT = 152, T_INTERVAL = 153, T_INTO = 154, T_INVOKER = 155, T_IS = 156, T_ISOPEN =
            157, T_ITEMS = 158, T_JOIN = 159, T_KEEP = 160, T_KILL = 161, T_KEY = 162, T_KEYS = 163,
        T_KV_SEARCH = 164, T_LANGUAGE = 165, T_LEAVE = 166, T_LEFT = 167, T_LIKE = 168, T_LIMIT =
            169, T_LINES = 170, T_LOAD = 171, T_LOCAL = 172, T_LOCATION = 173, T_LOCATOR = 174,
        T_LOCATORS = 175, T_LOCKS = 176, T_LOG = 177, T_LOGGED = 178, T_LOGGING = 179, T_LOOP = 180,
        T_MAP = 181, T_MATCHED = 182, T_MAX = 183, T_MAXTRANS = 184, T_MERGE = 185, T_MESSAGE_TEXT =
            186, T_MICROSECOND = 187, T_MICROSECONDS = 188, T_MIN = 189, T_MULTISET = 190, T_NCHAR =
                191, T_NEW = 192, T_NVARCHAR = 193, T_NO = 194, T_NOCOUNT = 195, T_NOCOMPRESS = 196,
        T_NOLOGGING = 197, T_NONE = 198, T_NOT = 199, T_NOTFOUND = 200, T_NULL = 201, T_NUMERIC =
            202, T_NUMBER = 203, T_OBJECT = 204, T_OFF = 205, T_ON = 206, T_ONLY = 207, T_OPEN =
                208, T_OR = 209, T_ORDER = 210, T_OUT = 211, T_OUTER = 212, T_OVER = 213,
        T_OVERWRITE = 214, T_OWNER = 215, T_PACKAGE = 216, T_PARTITION = 217, T_PASSWORD = 218,
        T_PCTFREE = 219, T_PCTUSED = 220, T_PERCENT = 221, T_PLS_INTEGER = 222, T_PRECISION = 223,
        T_PRESERVE = 224, T_PRIVILEGES = 225, T_PRIMARY = 226, T_PRINT = 227, T_PROC = 228,
        T_PROCEDURE = 229, T_PYRAMID = 230, T_PYRAMIDS = 231, T_QUERY = 232, T_QUERIES = 233,
        T_QUALIFY = 234, T_QUERY_BAND = 235, T_QUIT = 236, T_QUOTED_IDENTIFIER = 237, T_RAISE = 238,
        T_REAL = 239, T_REFERENCES = 240, T_REGEXP = 241, T_RENAME = 242, T_REPLACE = 243,
        T_RESIGNAL = 244, T_RESTRICT = 245, T_RESULT = 246, T_RESULT_SET_LOCATOR = 247, T_RETURN =
            248, T_RETURNS = 249, T_REVERSE = 250, T_REVOKE = 251, T_RIGHT = 252, T_RLIKE = 253,
        T_ROLE = 254, T_ROLLBACK = 255, T_ROW = 256, T_ROWS = 257, T_ROWTYPE = 258, T_ROW_COUNT =
            259, T_RR = 260, T_RS = 261, T_PWD = 262, T_TRIM = 263, T_TABLESAMPLE = 264, T_SCHEMA =
                265, T_SECOND = 266, T_SECONDS = 267, T_SECURITY = 268, T_SEGMENT = 269, T_SEL =
                    270, T_SELECT = 271, T_SET = 272, T_SESSION = 273, T_SESSIONS = 274, T_SETS =
                        275, T_SHOW = 276, T_SIGNAL = 277, T_SIMPLE_DOUBLE = 278, T_SIMPLE_FLOAT =
                            279, T_SIMPLE_INTEGER = 280, T_SMALLDATETIME = 281, T_SMALLINT = 282,
        T_SQL = 283, T_SQLEXCEPTION = 284, T_SQLINSERT = 285, T_SQLSTATE = 286, T_SQLWARNING = 287,
        T_SRID = 288, T_STATS = 289, T_STATISTICS = 290, T_STATUS = 291, T_STEP = 292, T_STORAGE =
            293, T_STORE = 294, T_STORED = 295, T_STRING = 296, T_SUBDIR = 297, T_SUBSTRING = 298,
        T_SUM = 299, T_SUMMARY = 300, T_SYS_REFCURSOR = 301, T_SPATIAL = 302, T_TABLE = 303,
        T_TILE = 304, T_VIEW = 305, T_TABLES = 306, T_VIEWS = 307, T_TABLESPACE = 308, T_TEMPORARY =
            309, T_TERMINATED = 310, T_TEXTIMAGE_ON = 311, T_THEN = 312, T_TIMESTAMP = 313,
        T_TINYINT = 314, T_TITLE = 315, T_TO = 316, T_TOP = 317, T_TRANSACTION = 318, T_TRUE = 319,
        T_TRUNCATE = 320, T_TYPE = 321, T_UNION = 322, T_UNIQUE = 323, T_UPDATE = 324, T_UR = 325,
        T_USE = 326, T_USING = 327, T_VALUE = 328, T_VALUES = 329, T_VAR = 330, T_VARCHAR = 331,
        T_VARCHAR2 = 332, T_VARYING = 333, T_VOLATILE = 334, T_WHEN = 335, T_WHERE = 336, T_WHILE =
            337, T_WITH = 338, T_WITHOUT = 339, T_WORK = 340, T_XACT_ABORT = 341, T_XML = 342,
        T_YES = 343, T_ACTIVITY_COUNT = 344, T_CUME_DIST = 345, T_CURRENT_DATE = 346,
        T_CURRENT_TIME = 347, T_PI = 348, T_CURRENT_TIMESTAMP = 349, T_CURRENT_USER = 350,
        T_DENSE_RANK = 351, T_FIRST_VALUE = 352, T_LAG = 353, T_LAST_VALUE = 354, T_LEAD = 355,
        T_MAX_PART_STRING = 356, T_MIN_PART_STRING = 357, T_MAX_PART_INT = 358, T_MIN_PART_INT =
            359, T_MAX_PART_DATE = 360, T_MIN_PART_DATE = 361, T_PART_COUNT = 362, T_PART_LOC = 363,
        T_RANK = 364, T_ROW_NUMBER = 365, T_STDEV = 366, T_SYSDATE = 367, T_VARIANCE = 368, T_USER =
            369, T_METADATA = 370, T_LONG = 371, T_BOOLEAN = 372, T_BOOL = 373, T_BINARY = 374,
        T_GEOMETRY = 375, T_POINT = 376, T_LINESTRING = 377, T_POLYGON = 378, T_MULTIPOINT = 379,
        T_MULTILINESTRING = 380, T_MULTIPOLYGON = 381, T_GEOMETRYCOLLECTION = 382, T_TRAJECTORY =
            383, T_ROADSEGMENT = 384, T_ROADNETWORK = 385, T_ADD = 386, T_COLON = 387, T_COMMA =
                388, T_PIPE = 389, T_DIV = 390, T_DOT = 391, T_DOT2 = 392, T_EQUAL = 393, T_EQUAL2 =
                    394, T_NOTEQUAL = 395, T_NOTEQUAL2 = 396, T_GREATER = 397, T_GREATEREQUAL = 398,
        T_LESS = 399, T_LESSEQUAL = 400, T_MUL = 401, T_OPEN_B = 402, T_OPEN_P = 403, T_OPEN_SB =
            404, T_CLOSE_B = 405, T_CLOSE_P = 406, T_CLOSE_SB = 407, T_SEMICOLON = 408, T_SUB = 409,
        L_ID = 410, L_S_STRING = 411, L_D_STRING = 412, L_INT = 413, L_DEC = 414, L_WS = 415,
        L_M_COMMENT = 416, L_S_COMMENT = 417, L_FILE = 418;
    public static final int RULE_program = 0, RULE_stmt = 1, RULE_dbDotTable = 2,
        RULE_userDotDbDotTable = 3, RULE_assignmentStmtItem = 4, RULE_assignmentStmtSingleItem = 5,
        RULE_assignmentStmtMultipleItem = 6, RULE_assignmentStmtSelectItem = 7,
        RULE_showCreateTableStmt = 8, RULE_showStatusStmt = 9, RULE_showIndexStmt = 10,
        RULE_createTableStmt = 11, RULE_createUserStmt = 12, RULE_create_table_definition = 13,
        RULE_create_table_columns = 14, RULE_create_table_columns_item = 15, RULE_key_list = 16,
        RULE_index_type_decl = 17, RULE_column_name = 18, RULE_create_table_column_inline_cons = 19,
        RULE_create_table_column_cons = 20, RULE_create_table_fk_action = 21,
        RULE_create_table_preoptions = 22, RULE_create_table_preoptions_item = 23,
        RULE_create_table_preoptions_td_item = 24, RULE_create_table_options = 25,
        RULE_create_table_options_item = 26, RULE_create_table_options_mysql_item = 27,
        RULE_createIndexStmt = 28, RULE_createIndexCol = 29, RULE_dropTableIndexStmt = 30,
        RULE_dtype_default = 31, RULE_showTablesStmt = 32, RULE_dtype_attr = 33, RULE_dtype = 34,
        RULE_dtypeLen = 35, RULE_createDatabaseStmt = 36, RULE_showDatabasesStmt = 37,
        RULE_dropDatabaseStmt = 38, RULE_createDatabaseOption = 39, RULE_dropTableStmt = 40,
        RULE_insertStmt = 41, RULE_insertStmtCols = 42, RULE_insertStmtRows = 43,
        RULE_insertStmtRow = 44, RULE_truncateStmt = 45, RULE_useStmt = 46, RULE_selectStmt = 47,
        RULE_cteSelectStmt = 48, RULE_cteSelectStmtItem = 49, RULE_cteSelectCols = 50,
        RULE_fullselectStmt = 51, RULE_fullselectStmtItem = 52, RULE_fullselectSetClause = 53,
        RULE_subselectStmt = 54, RULE_selectList = 55, RULE_selectListSet = 56,
        RULE_selectListLimit = 57, RULE_selectListItem = 58, RULE_selectListAlias = 59,
        RULE_selectListAsterisk = 60, RULE_intoClause = 61, RULE_fromClause = 62,
        RULE_fromTableClause = 63, RULE_fromTableNameClause = 64, RULE_fromSubselectClause = 65,
        RULE_fromJoinClause = 66, RULE_fromJoinTypeClause = 67, RULE_fromTableValuesClause = 68,
        RULE_fromTableValuesRow = 69, RULE_fromAliasClause = 70, RULE_tableName = 71,
        RULE_whereClause = 72, RULE_groupByClause = 73, RULE_havingClause = 74, RULE_qualifyClause =
            75, RULE_orderByClause = 76, RULE_orderByClauseItem = 77, RULE_sampleClause = 78,
        RULE_selectOptions = 79, RULE_selectOptionsItem = 80, RULE_updateStmt = 81,
        RULE_updateAssignment = 82, RULE_updateTable = 83, RULE_updateUpsert = 84, RULE_deleteStmt =
            85, RULE_deleteAlias = 86, RULE_describeStmt = 87, RULE_boolExpr = 88,
        RULE_boolExprAtom = 89, RULE_boolExprUnary = 90, RULE_boolExprSingleIn = 91,
        RULE_boolExprMultiIn = 92, RULE_boolExprBinary = 93, RULE_boolExprLogicalOperator = 94,
        RULE_boolExprBinaryOperator = 95, RULE_expr = 96, RULE_exprAtom = 97, RULE_exprInterval =
            98, RULE_intervalItem = 99, RULE_exprConcat = 100, RULE_exprConcatItem = 101,
        RULE_exprCase = 102, RULE_exprCaseSimple = 103, RULE_exprCaseSearched = 104,
        RULE_exprCaseItem = 105, RULE_exprCursorAttribute = 106, RULE_exprAggWindowFunc = 107,
        RULE_exprFuncAllDistinct = 108, RULE_exprFuncOverClause = 109,
        RULE_exprFuncPartitionByClause = 110, RULE_exprSpecFunc = 111, RULE_exprFunc = 112,
        RULE_exprFuncParams = 113, RULE_funcParam = 114, RULE_table_name = 115, RULE_user_name =
            116, RULE_qident = 117, RULE_dateLiteral = 118, RULE_timestampLiteral = 119,
        RULE_ident = 120, RULE_identItem = 121, RULE_string = 122, RULE_intNumber = 123,
        RULE_decNumber = 124, RULE_boolLiteral = 125, RULE_nullConst = 126, RULE_nonReservedWords =
            127;

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
            "showIndexStmt",
            "createTableStmt",
            "createUserStmt",
            "create_table_definition",
            "create_table_columns",
            "create_table_columns_item",
            "key_list",
            "index_type_decl",
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
            "dropTableIndexStmt",
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
            "T_ATTRIBUTE",
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
            "T_SPATIAL",
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
        return "CupidDBSql.g4";
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

    public CupidDBSqlParser(TokenStream input) {
        super(input);
        _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    public static class ProgramContext extends ParserRuleContext {
        public StmtContext stmt() {
            return getRuleContext(StmtContext.class, 0);
        }

        public TerminalNode EOF() {
            return getToken(CupidDBSqlParser.EOF, 0);
        }

        public TerminalNode T_SEMICOLON() {
            return getToken(CupidDBSqlParser.T_SEMICOLON, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
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
                setState(256);
                stmt();
                setState(258);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_SEMICOLON) {
                    {
                        setState(257);
                        match(T_SEMICOLON);
                    }
                }

                setState(260);
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

        public DropTableIndexStmtContext dropTableIndexStmt() {
            return getRuleContext(DropTableIndexStmtContext.class, 0);
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

        public ShowIndexStmtContext showIndexStmt() {
            return getRuleContext(ShowIndexStmtContext.class, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitStmt(this);
            else return visitor.visitChildren(this);
        }
    }

    public final StmtContext stmt() throws RecognitionException {
        StmtContext _localctx = new StmtContext(_ctx, getState());
        enterRule(_localctx, 2, RULE_stmt);
        try {
            setState(281);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 1, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1); {
                    setState(262);
                    createDatabaseStmt();
                }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2); {
                    setState(263);
                    createTableStmt();
                }
                    break;
                case 3:
                    enterOuterAlt(_localctx, 3); {
                    setState(264);
                    createIndexStmt();
                }
                    break;
                case 4:
                    enterOuterAlt(_localctx, 4); {
                    setState(265);
                    describeStmt();
                }
                    break;
                case 5:
                    enterOuterAlt(_localctx, 5); {
                    setState(266);
                    dropDatabaseStmt();
                }
                    break;
                case 6:
                    enterOuterAlt(_localctx, 6); {
                    setState(267);
                    dropTableStmt();
                }
                    break;
                case 7:
                    enterOuterAlt(_localctx, 7); {
                    setState(268);
                    dropTableIndexStmt();
                }
                    break;
                case 8:
                    enterOuterAlt(_localctx, 8); {
                    setState(269);
                    truncateStmt();
                }
                    break;
                case 9:
                    enterOuterAlt(_localctx, 9); {
                    setState(270);
                    useStmt();
                }
                    break;
                case 10:
                    enterOuterAlt(_localctx, 10); {
                    setState(271);
                    showDatabasesStmt();
                }
                    break;
                case 11:
                    enterOuterAlt(_localctx, 11); {
                    setState(272);
                    showTablesStmt();
                }
                    break;
                case 12:
                    enterOuterAlt(_localctx, 12); {
                    setState(273);
                    showCreateTableStmt();
                }
                    break;
                case 13:
                    enterOuterAlt(_localctx, 13); {
                    setState(274);
                    showStatusStmt();
                }
                    break;
                case 14:
                    enterOuterAlt(_localctx, 14); {
                    setState(275);
                    showIndexStmt();
                }
                    break;
                case 15:
                    enterOuterAlt(_localctx, 15); {
                    setState(276);
                    insertStmt();
                }
                    break;
                case 16:
                    enterOuterAlt(_localctx, 16); {
                    setState(277);
                    updateStmt();
                }
                    break;
                case 17:
                    enterOuterAlt(_localctx, 17); {
                    setState(278);
                    deleteStmt();
                }
                    break;
                case 18:
                    enterOuterAlt(_localctx, 18); {
                    setState(279);
                    selectStmt();
                }
                    break;
                case 19:
                    enterOuterAlt(_localctx, 19); {
                    setState(280);
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
            return getTokens(CupidDBSqlParser.T_MUL);
        }

        public TerminalNode T_MUL(int i) {
            return getToken(CupidDBSqlParser.T_MUL, i);
        }

        public List<TerminalNode> T_DEFAULT() {
            return getTokens(CupidDBSqlParser.T_DEFAULT);
        }

        public TerminalNode T_DEFAULT(int i) {
            return getToken(CupidDBSqlParser.T_DEFAULT, i);
        }

        public List<TerminalNode> L_ID() {
            return getTokens(CupidDBSqlParser.L_ID);
        }

        public TerminalNode L_ID(int i) {
            return getToken(CupidDBSqlParser.L_ID, i);
        }

        public TerminalNode T_DOT() {
            return getToken(CupidDBSqlParser.T_DOT, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
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
                setState(285);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 2, _ctx)) {
                    case 1: {
                        setState(283);
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
                        setState(284);
                        match(T_DOT);
                    }
                        break;
                }
                setState(287);
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
            return getToken(CupidDBSqlParser.T_DOT, 0);
        }

        public TerminalNode L_ID() {
            return getToken(CupidDBSqlParser.L_ID, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitUserDotDbDotTable(this);
            else return visitor.visitChildren(this);
        }
    }

    public final UserDotDbDotTableContext userDotDbDotTable() throws RecognitionException {
        UserDotDbDotTableContext _localctx = new UserDotDbDotTableContext(_ctx, getState());
        enterRule(_localctx, 6, RULE_userDotDbDotTable);
        try {
            setState(295);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 4, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1); {
                    setState(289);
                    dbDotTable();
                }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2); {
                    setState(292);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 3, _ctx)) {
                        case 1: {
                            setState(290);
                            ((UserDotDbDotTableContext) _localctx).user = match(L_ID);
                            setState(291);
                            match(T_DOT);
                        }
                            break;
                    }
                    setState(294);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitAssignmentStmtItem(this);
            else return visitor.visitChildren(this);
        }
    }

    public final AssignmentStmtItemContext assignmentStmtItem() throws RecognitionException {
        AssignmentStmtItemContext _localctx = new AssignmentStmtItemContext(_ctx, getState());
        enterRule(_localctx, 8, RULE_assignmentStmtItem);
        try {
            setState(300);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 5, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1); {
                    setState(297);
                    assignmentStmtSingleItem();
                }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2); {
                    setState(298);
                    assignmentStmtMultipleItem();
                }
                    break;
                case 3:
                    enterOuterAlt(_localctx, 3); {
                    setState(299);
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
            return getToken(CupidDBSqlParser.T_EQUAL, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode T_COLON() {
            return getToken(CupidDBSqlParser.T_COLON, 0);
        }

        public TerminalNode T_OPEN_P() {
            return getToken(CupidDBSqlParser.T_OPEN_P, 0);
        }

        public TerminalNode T_CLOSE_P() {
            return getToken(CupidDBSqlParser.T_CLOSE_P, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
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
            setState(318);
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
                    setState(302);
                    ident();
                    setState(304);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_COLON) {
                        {
                            setState(303);
                            match(T_COLON);
                        }
                    }

                    setState(306);
                    match(T_EQUAL);
                    setState(307);
                    expr(0);
                }
                    break;
                case T_OPEN_P:
                    enterOuterAlt(_localctx, 2); {
                    setState(309);
                    match(T_OPEN_P);
                    setState(310);
                    ident();
                    setState(311);
                    match(T_CLOSE_P);
                    setState(313);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_COLON) {
                        {
                            setState(312);
                            match(T_COLON);
                        }
                    }

                    setState(315);
                    match(T_EQUAL);
                    setState(316);
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
            return getTokens(CupidDBSqlParser.T_OPEN_P);
        }

        public TerminalNode T_OPEN_P(int i) {
            return getToken(CupidDBSqlParser.T_OPEN_P, i);
        }

        public List<IdentContext> ident() {
            return getRuleContexts(IdentContext.class);
        }

        public IdentContext ident(int i) {
            return getRuleContext(IdentContext.class, i);
        }

        public List<TerminalNode> T_CLOSE_P() {
            return getTokens(CupidDBSqlParser.T_CLOSE_P);
        }

        public TerminalNode T_CLOSE_P(int i) {
            return getToken(CupidDBSqlParser.T_CLOSE_P, i);
        }

        public TerminalNode T_EQUAL() {
            return getToken(CupidDBSqlParser.T_EQUAL, 0);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public List<TerminalNode> T_COMMA() {
            return getTokens(CupidDBSqlParser.T_COMMA);
        }

        public TerminalNode T_COMMA(int i) {
            return getToken(CupidDBSqlParser.T_COMMA, i);
        }

        public TerminalNode T_COLON() {
            return getToken(CupidDBSqlParser.T_COLON, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
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
                setState(320);
                match(T_OPEN_P);
                setState(321);
                ident();
                setState(326);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T_COMMA) {
                    {
                        {
                            setState(322);
                            match(T_COMMA);
                            setState(323);
                            ident();
                        }
                    }
                    setState(328);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(329);
                match(T_CLOSE_P);
                setState(331);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_COLON) {
                    {
                        setState(330);
                        match(T_COLON);
                    }
                }

                setState(333);
                match(T_EQUAL);
                setState(334);
                match(T_OPEN_P);
                setState(335);
                expr(0);
                setState(340);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T_COMMA) {
                    {
                        {
                            setState(336);
                            match(T_COMMA);
                            setState(337);
                            expr(0);
                        }
                    }
                    setState(342);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(343);
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
            return getToken(CupidDBSqlParser.T_EQUAL, 0);
        }

        public List<TerminalNode> T_OPEN_P() {
            return getTokens(CupidDBSqlParser.T_OPEN_P);
        }

        public TerminalNode T_OPEN_P(int i) {
            return getToken(CupidDBSqlParser.T_OPEN_P, i);
        }

        public SelectStmtContext selectStmt() {
            return getRuleContext(SelectStmtContext.class, 0);
        }

        public List<TerminalNode> T_CLOSE_P() {
            return getTokens(CupidDBSqlParser.T_CLOSE_P);
        }

        public TerminalNode T_CLOSE_P(int i) {
            return getToken(CupidDBSqlParser.T_CLOSE_P, i);
        }

        public List<IdentContext> ident() {
            return getRuleContexts(IdentContext.class);
        }

        public IdentContext ident(int i) {
            return getRuleContext(IdentContext.class, i);
        }

        public TerminalNode T_COLON() {
            return getToken(CupidDBSqlParser.T_COLON, 0);
        }

        public List<TerminalNode> T_COMMA() {
            return getTokens(CupidDBSqlParser.T_COMMA);
        }

        public TerminalNode T_COMMA(int i) {
            return getToken(CupidDBSqlParser.T_COMMA, i);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
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
                setState(357);
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
                        setState(345);
                        ident();
                    }
                        break;
                    case T_OPEN_P: {
                        {
                            setState(346);
                            match(T_OPEN_P);
                            setState(347);
                            ident();
                            setState(352);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                            while (_la == T_COMMA) {
                                {
                                    {
                                        setState(348);
                                        match(T_COMMA);
                                        setState(349);
                                        ident();
                                    }
                                }
                                setState(354);
                                _errHandler.sync(this);
                                _la = _input.LA(1);
                            }
                            setState(355);
                            match(T_CLOSE_P);
                        }
                    }
                        break;
                    default:
                        throw new NoViableAltException(this);
                }
                setState(360);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_COLON) {
                    {
                        setState(359);
                        match(T_COLON);
                    }
                }

                setState(362);
                match(T_EQUAL);
                setState(363);
                match(T_OPEN_P);
                setState(364);
                selectStmt();
                setState(365);
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
            return getToken(CupidDBSqlParser.T_SHOW, 0);
        }

        public TerminalNode T_CREATE() {
            return getToken(CupidDBSqlParser.T_CREATE, 0);
        }

        public TerminalNode T_TABLE() {
            return getToken(CupidDBSqlParser.T_TABLE, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
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
                setState(367);
                match(T_SHOW);
                setState(368);
                match(T_CREATE);
                setState(369);
                match(T_TABLE);
                setState(370);
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
            return getToken(CupidDBSqlParser.T_SHOW, 0);
        }

        public TerminalNode T_STATUS() {
            return getToken(CupidDBSqlParser.T_STATUS, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
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
                setState(372);
                match(T_SHOW);
                setState(373);
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

    public static class ShowIndexStmtContext extends ParserRuleContext {
        public Token dbName;

        public TerminalNode T_SHOW() {
            return getToken(CupidDBSqlParser.T_SHOW, 0);
        }

        public TerminalNode T_INDEX() {
            return getToken(CupidDBSqlParser.T_INDEX, 0);
        }

        public List<TerminalNode> T_FROM() {
            return getTokens(CupidDBSqlParser.T_FROM);
        }

        public TerminalNode T_FROM(int i) {
            return getToken(CupidDBSqlParser.T_FROM, i);
        }

        public TableNameContext tableName() {
            return getRuleContext(TableNameContext.class, 0);
        }

        public TerminalNode L_ID() {
            return getToken(CupidDBSqlParser.L_ID, 0);
        }

        public ShowIndexStmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_showIndexStmt;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitShowIndexStmt(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ShowIndexStmtContext showIndexStmt() throws RecognitionException {
        ShowIndexStmtContext _localctx = new ShowIndexStmtContext(_ctx, getState());
        enterRule(_localctx, 20, RULE_showIndexStmt);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(375);
                match(T_SHOW);
                setState(376);
                match(T_INDEX);
                setState(377);
                match(T_FROM);
                setState(378);
                tableName();
                setState(381);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_FROM) {
                    {
                        setState(379);
                        match(T_FROM);
                        setState(380);
                        ((ShowIndexStmtContext) _localctx).dbName = match(L_ID);
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

    public static class CreateTableStmtContext extends ParserRuleContext {
        public TerminalNode T_CREATE() {
            return getToken(CupidDBSqlParser.T_CREATE, 0);
        }

        public TerminalNode T_TABLE() {
            return getToken(CupidDBSqlParser.T_TABLE, 0);
        }

        public Table_nameContext table_name() {
            return getRuleContext(Table_nameContext.class, 0);
        }

        public Create_table_definitionContext create_table_definition() {
            return getRuleContext(Create_table_definitionContext.class, 0);
        }

        public TerminalNode T_IF() {
            return getToken(CupidDBSqlParser.T_IF, 0);
        }

        public TerminalNode T_NOT() {
            return getToken(CupidDBSqlParser.T_NOT, 0);
        }

        public TerminalNode T_EXISTS() {
            return getToken(CupidDBSqlParser.T_EXISTS, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitCreateTableStmt(this);
            else return visitor.visitChildren(this);
        }
    }

    public final CreateTableStmtContext createTableStmt() throws RecognitionException {
        CreateTableStmtContext _localctx = new CreateTableStmtContext(_ctx, getState());
        enterRule(_localctx, 22, RULE_createTableStmt);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(383);
                match(T_CREATE);
                setState(384);
                match(T_TABLE);
                setState(388);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 16, _ctx)) {
                    case 1: {
                        setState(385);
                        match(T_IF);
                        setState(386);
                        match(T_NOT);
                        setState(387);
                        match(T_EXISTS);
                    }
                        break;
                }
                setState(390);
                table_name();
                setState(392);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_COMMA) {
                    {
                        setState(391);
                        create_table_preoptions();
                    }
                }

                setState(394);
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
            return getToken(CupidDBSqlParser.T_CREATE, 0);
        }

        public TerminalNode T_USER() {
            return getToken(CupidDBSqlParser.T_USER, 0);
        }

        public User_nameContext user_name() {
            return getRuleContext(User_nameContext.class, 0);
        }

        public TerminalNode T_IDENTIFIED() {
            return getToken(CupidDBSqlParser.T_IDENTIFIED, 0);
        }

        public TerminalNode T_BY() {
            return getToken(CupidDBSqlParser.T_BY, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitCreateUserStmt(this);
            else return visitor.visitChildren(this);
        }
    }

    public final CreateUserStmtContext createUserStmt() throws RecognitionException {
        CreateUserStmtContext _localctx = new CreateUserStmtContext(_ctx, getState());
        enterRule(_localctx, 24, RULE_createUserStmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(396);
                match(T_CREATE);
                setState(397);
                match(T_USER);
                setState(398);
                user_name();
                setState(399);
                match(T_IDENTIFIED);
                setState(400);
                match(T_BY);
                setState(401);
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
            return getToken(CupidDBSqlParser.T_OPEN_P, 0);
        }

        public SelectStmtContext selectStmt() {
            return getRuleContext(SelectStmtContext.class, 0);
        }

        public TerminalNode T_CLOSE_P() {
            return getToken(CupidDBSqlParser.T_CLOSE_P, 0);
        }

        public Create_table_columnsContext create_table_columns() {
            return getRuleContext(Create_table_columnsContext.class, 0);
        }

        public TerminalNode T_LIKE() {
            return getToken(CupidDBSqlParser.T_LIKE, 0);
        }

        public Table_nameContext table_name() {
            return getRuleContext(Table_nameContext.class, 0);
        }

        public Create_table_optionsContext create_table_options() {
            return getRuleContext(Create_table_optionsContext.class, 0);
        }

        public TerminalNode T_AS() {
            return getToken(CupidDBSqlParser.T_AS, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
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
        enterRule(_localctx, 26, RULE_create_table_definition);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(420);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 20, _ctx)) {
                    case 1: {
                        setState(404);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        if (_la == T_AS) {
                            {
                                setState(403);
                                match(T_AS);
                            }
                        }

                        setState(406);
                        match(T_OPEN_P);
                        setState(407);
                        selectStmt();
                        setState(408);
                        match(T_CLOSE_P);
                    }
                        break;
                    case 2: {
                        setState(411);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        if (_la == T_AS) {
                            {
                                setState(410);
                                match(T_AS);
                            }
                        }

                        setState(413);
                        selectStmt();
                    }
                        break;
                    case 3: {
                        setState(414);
                        match(T_OPEN_P);
                        setState(415);
                        create_table_columns();
                        setState(416);
                        match(T_CLOSE_P);
                    }
                        break;
                    case 4: {
                        setState(418);
                        match(T_LIKE);
                        setState(419);
                        table_name();
                    }
                        break;
                }
                setState(423);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if ((((_la) & ~0x3f) == 0
                    && ((1L << _la) & ((1L << T_AUTO_INCREMENT) | (1L << T_CHARACTER) | (1L
                        << T_CHARSET) | (1L << T_COMMENT))) != 0)
                    || _la == T_DEFAULT
                    || _la == T_ENGINE
                    || _la == T_ON) {
                    {
                        setState(422);
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
            return getTokens(CupidDBSqlParser.T_COMMA);
        }

        public TerminalNode T_COMMA(int i) {
            return getToken(CupidDBSqlParser.T_COMMA, i);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitCreate_table_columns(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Create_table_columnsContext create_table_columns() throws RecognitionException {
        Create_table_columnsContext _localctx = new Create_table_columnsContext(_ctx, getState());
        enterRule(_localctx, 28, RULE_create_table_columns);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(425);
                create_table_columns_item();
                setState(430);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T_COMMA) {
                    {
                        {
                            setState(426);
                            match(T_COMMA);
                            setState(427);
                            create_table_columns_item();
                        }
                    }
                    setState(432);
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
            return getToken(CupidDBSqlParser.T_CONSTRAINT, 0);
        }

        public QidentContext qident() {
            return getRuleContext(QidentContext.class, 0);
        }

        public TerminalNode T_INDEX() {
            return getToken(CupidDBSqlParser.T_INDEX, 0);
        }

        public Key_listContext key_list() {
            return getRuleContext(Key_listContext.class, 0);
        }

        public TerminalNode T_SPATIAL() {
            return getToken(CupidDBSqlParser.T_SPATIAL, 0);
        }

        public TerminalNode T_ATTRIBUTE() {
            return getToken(CupidDBSqlParser.T_ATTRIBUTE, 0);
        }

        public IdentContext ident() {
            return getRuleContext(IdentContext.class, 0);
        }

        public Index_type_declContext index_type_decl() {
            return getRuleContext(Index_type_declContext.class, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
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
        enterRule(_localctx, 30, RULE_create_table_columns_item);
        int _la;
        try {
            int _alt;
            setState(461);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 28, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1); {
                    setState(433);
                    column_name();
                    setState(434);
                    dtype();
                    setState(438);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 23, _ctx);
                    while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                        if (_alt == 1) {
                            {
                                {
                                    setState(435);
                                    dtype_attr();
                                }
                            }
                        }
                        setState(440);
                        _errHandler.sync(this);
                        _alt = getInterpreter().adaptivePredict(_input, 23, _ctx);
                    }
                    setState(444);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == T_AUTO_INCREMENT
                        || ((((_la - 76)) & ~0x3f) == 0
                            && ((1L << (_la - 76)) & ((1L << (T_DEFAULT - 76)) | (1L << (T_ENABLE
                                - 76)) | (1L << (T_IDENTITY - 76)))) != 0)
                        || ((((_la - 199)) & ~0x3f) == 0
                            && ((1L << (_la - 199)) & ((1L << (T_NOT - 199)) | (1L << (T_NULL
                                - 199)) | (1L << (T_PRIMARY - 199)) | (1L << (T_REFERENCES
                                    - 199)))) != 0)
                        || _la == T_UNIQUE
                        || _la == T_WITH
                        || _la == T_COLON
                        || _la == T_EQUAL) {
                        {
                            {
                                setState(441);
                                create_table_column_inline_cons();
                            }
                        }
                        setState(446);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2); {
                    setState(449);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_CONSTRAINT) {
                        {
                            setState(447);
                            match(T_CONSTRAINT);
                            setState(448);
                            qident();
                        }
                    }

                    setState(451);
                    create_table_column_cons();
                }
                    break;
                case 3:
                    enterOuterAlt(_localctx, 3); {
                    setState(452);
                    _la = _input.LA(1);
                    if (!(_la == T_ATTRIBUTE || _la == T_SPATIAL)) {
                        _errHandler.recoverInline(this);
                    } else {
                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                        _errHandler.reportMatch(this);
                        consume();
                    }
                    setState(453);
                    match(T_INDEX);
                    setState(455);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if ((((_la) & ~0x3f) == 0
                        && ((1L << _la) & ((1L << T_ACTION) | (1L << T_ADD2) | (1L << T_ALL) | (1L
                            << T_ALLOCATE) | (1L << T_ALTER) | (1L << T_AND) | (1L << T_ANSI_NULLS)
                            | (1L << T_ANSI_PADDING) | (1L << T_AS) | (1L << T_ASC) | (1L
                                << T_ASSOCIATE) | (1L << T_AT) | (1L << T_AVG) | (1L << T_BATCHSIZE)
                            | (1L << T_BEGIN) | (1L << T_BETWEEN) | (1L << T_BIGINT) | (1L
                                << T_BINARY_DOUBLE) | (1L << T_BINARY_FLOAT) | (1L << T_BIT) | (1L
                                    << T_BODY) | (1L << T_BREAK) | (1L << T_BY) | (1L << T_BYTE)
                            | (1L << T_CALL) | (1L << T_CALLER) | (1L << T_CASCADE) | (1L << T_CASE)
                            | (1L << T_CASESPECIFIC) | (1L << T_CAST) | (1L << T_CHAR) | (1L
                                << T_CHARACTER) | (1L << T_CHARSET) | (1L << T_CLIENT) | (1L
                                    << T_CLOSE) | (1L << T_CLUSTERED) | (1L << T_CMP) | (1L
                                        << T_COLLECT) | (1L << T_COLLECTION) | (1L << T_COLUMN)
                            | (1L << T_COMMENT) | (1L << T_CONSTANT) | (1L << T_COMMIT) | (1L
                                << T_COMPRESS) | (1L << T_CONCAT) | (1L << T_CONDITION) | (1L
                                    << T_CONSTRAINT) | (1L << T_CONTINUE) | (1L << T_COPY) | (1L
                                        << T_COUNT) | (1L << T_COUNT_BIG) | (1L << T_CREATION) | (1L
                                            << T_CREATOR) | (1L << T_CS) | (1L << T_CURRENT))) != 0)
                        || ((((_la - 64)) & ~0x3f) == 0
                            && ((1L << (_la - 64)) & ((1L << (T_CURRENT_SCHEMA - 64)) | (1L
                                << (T_CURSOR - 64)) | (1L << (T_DATABASE - 64)) | (1L << (T_DATA
                                    - 64)) | (1L << (T_DATE - 64)) | (1L << (T_DATETIME - 64)) | (1L
                                        << (T_DAY - 64)) | (1L << (T_DAYS - 64)) | (1L << (T_DEC
                                            - 64)) | (1L << (T_DECIMAL - 64)) | (1L << (T_DECLARE
                                                - 64)) | (1L << (T_DEFAULT - 64)) | (1L
                                                    << (T_DEFERRED - 64)) | (1L << (T_DEFINED - 64))
                                | (1L << (T_DEFINER - 64)) | (1L << (T_DEFINITION - 64)) | (1L
                                    << (T_DELETE - 64)) | (1L << (T_DELIMITED - 64)) | (1L
                                        << (T_DELIMITER - 64)) | (1L << (T_DESC - 64)) | (1L
                                            << (T_DESCRIBE - 64)) | (1L << (T_DIAGNOSTICS - 64))
                                | (1L << (T_DIR - 64)) | (1L << (T_DIRECTORY - 64)) | (1L
                                    << (T_DISTINCT - 64)) | (1L << (T_DISTRIBUTE - 64)) | (1L
                                        << (T_DO - 64)) | (1L << (T_DOUBLE - 64)) | (1L
                                            << (T_DOWNLOAD - 64)) | (1L << (T_DROP - 64)) | (1L
                                                << (T_DYNAMIC - 64)) | (1L << (T_ENABLE - 64)) | (1L
                                                    << (T_ENGINE - 64)) | (1L << (T_ESCAPED - 64))
                                | (1L << (T_EXCEPT - 64)) | (1L << (T_EXEC - 64)) | (1L
                                    << (T_EXECUTE - 64)) | (1L << (T_EXCEPTION - 64)) | (1L
                                        << (T_EXCLUSIVE - 64)) | (1L << (T_EXISTS - 64)) | (1L
                                            << (T_EXIT - 64)) | (1L << (T_FALLBACK - 64)) | (1L
                                                << (T_FALSE - 64)) | (1L << (T_FETCH - 64)) | (1L
                                                    << (T_FIELDS - 64)) | (1L << (T_FILE - 64))
                                | (1L << (T_FILES - 64)) | (1L << (T_FLOAT - 64)) | (1L << (T_FOR
                                    - 64)) | (1L << (T_FOREIGN - 64)) | (1L << (T_FORMAT - 64))
                                | (1L << (T_FOUND - 64)) | (1L << (T_FROM - 64)) | (1L << (T_FULL
                                    - 64)) | (1L << (T_FUNCTION - 64)) | (1L << (T_GET - 64)) | (1L
                                        << (T_GLOBAL - 64)) | (1L << (T_GO - 64)) | (1L << (T_GRANT
                                            - 64)))) != 0)
                        || ((((_la - 129)) & ~0x3f) == 0
                            && ((1L << (_la - 129)) & ((1L << (T_GROUP - 129)) | (1L << (T_HANDLER
                                - 129)) | (1L << (T_HASH - 129)) | (1L << (T_HAVING - 129)) | (1L
                                    << (T_HOST - 129)) | (1L << (T_IDENTITY - 129)) | (1L << (T_IF
                                        - 129)) | (1L << (T_IGNORE - 129)) | (1L << (T_IMMEDIATE
                                            - 129)) | (1L << (T_IN - 129)) | (1L << (T_INCLUDE
                                                - 129)) | (1L << (T_INDEX - 129)) | (1L
                                                    << (T_INITRANS - 129)) | (1L << (T_INNER - 129))
                                | (1L << (T_INOUT - 129)) | (1L << (T_INSERT - 129)) | (1L << (T_INT
                                    - 129)) | (1L << (T_INT2 - 129)) | (1L << (T_INT4 - 129)) | (1L
                                        << (T_INT8 - 129)) | (1L << (T_INTEGER - 129)) | (1L
                                            << (T_INTERSECT - 129)) | (1L << (T_INTERVAL - 129))
                                | (1L << (T_INTO - 129)) | (1L << (T_INVOKER - 129)) | (1L << (T_IS
                                    - 129)) | (1L << (T_ISOPEN - 129)) | (1L << (T_ITEMS - 129))
                                | (1L << (T_JOIN - 129)) | (1L << (T_KEEP - 129)) | (1L << (T_KEY
                                    - 129)) | (1L << (T_KEYS - 129)) | (1L << (T_LANGUAGE - 129))
                                | (1L << (T_LEAVE - 129)) | (1L << (T_LEFT - 129)) | (1L << (T_LIKE
                                    - 129)) | (1L << (T_LIMIT - 129)) | (1L << (T_LINES - 129))
                                | (1L << (T_LOCAL - 129)) | (1L << (T_LOCATION - 129)) | (1L
                                    << (T_LOCATOR - 129)) | (1L << (T_LOCATORS - 129)) | (1L
                                        << (T_LOCKS - 129)) | (1L << (T_LOG - 129)) | (1L
                                            << (T_LOGGED - 129)) | (1L << (T_LOGGING - 129)) | (1L
                                                << (T_LOOP - 129)) | (1L << (T_MAP - 129)) | (1L
                                                    << (T_MATCHED - 129)) | (1L << (T_MAX - 129))
                                | (1L << (T_MAXTRANS - 129)) | (1L << (T_MERGE - 129)) | (1L
                                    << (T_MESSAGE_TEXT - 129)) | (1L << (T_MICROSECOND - 129)) | (1L
                                        << (T_MICROSECONDS - 129)) | (1L << (T_MIN - 129)) | (1L
                                            << (T_MULTISET - 129)) | (1L << (T_NCHAR - 129)) | (1L
                                                << (T_NEW - 129)))) != 0)
                        || ((((_la - 193)) & ~0x3f) == 0
                            && ((1L << (_la - 193)) & ((1L << (T_NVARCHAR - 193)) | (1L << (T_NO
                                - 193)) | (1L << (T_NOCOUNT - 193)) | (1L << (T_NOCOMPRESS - 193))
                                | (1L << (T_NOLOGGING - 193)) | (1L << (T_NONE - 193)) | (1L
                                    << (T_NOT - 193)) | (1L << (T_NOTFOUND - 193)) | (1L
                                        << (T_NUMERIC - 193)) | (1L << (T_NUMBER - 193)) | (1L
                                            << (T_OBJECT - 193)) | (1L << (T_OFF - 193)) | (1L
                                                << (T_ON - 193)) | (1L << (T_ONLY - 193)) | (1L
                                                    << (T_OPEN - 193)) | (1L << (T_OR - 193)) | (1L
                                                        << (T_ORDER - 193)) | (1L << (T_OUT - 193))
                                | (1L << (T_OUTER - 193)) | (1L << (T_OVER - 193)) | (1L
                                    << (T_OVERWRITE - 193)) | (1L << (T_OWNER - 193)) | (1L
                                        << (T_PACKAGE - 193)) | (1L << (T_PARTITION - 193)) | (1L
                                            << (T_PCTFREE - 193)) | (1L << (T_PCTUSED - 193)) | (1L
                                                << (T_PRECISION - 193)) | (1L << (T_PRESERVE - 193))
                                | (1L << (T_PRIMARY - 193)) | (1L << (T_PRINT - 193)) | (1L
                                    << (T_PROC - 193)) | (1L << (T_PROCEDURE - 193)) | (1L
                                        << (T_QUALIFY - 193)) | (1L << (T_QUERY_BAND - 193)) | (1L
                                            << (T_QUIT - 193)) | (1L << (T_QUOTED_IDENTIFIER - 193))
                                | (1L << (T_RAISE - 193)) | (1L << (T_REAL - 193)) | (1L
                                    << (T_REFERENCES - 193)) | (1L << (T_REGEXP - 193)) | (1L
                                        << (T_REPLACE - 193)) | (1L << (T_RESIGNAL - 193)) | (1L
                                            << (T_RESTRICT - 193)) | (1L << (T_RESULT - 193)) | (1L
                                                << (T_RESULT_SET_LOCATOR - 193)) | (1L << (T_RETURN
                                                    - 193)) | (1L << (T_RETURNS - 193)) | (1L
                                                        << (T_REVERSE - 193)) | (1L << (T_RIGHT
                                                            - 193)) | (1L << (T_RLIKE - 193)) | (1L
                                                                << (T_ROLE - 193)) | (1L
                                                                    << (T_ROLLBACK - 193)) | (1L
                                                                        << (T_ROW - 193)))) != 0)
                        || ((((_la - 257)) & ~0x3f) == 0
                            && ((1L << (_la - 257)) & ((1L << (T_ROWS - 257)) | (1L << (T_ROW_COUNT
                                - 257)) | (1L << (T_RR - 257)) | (1L << (T_RS - 257)) | (1L
                                    << (T_PWD - 257)) | (1L << (T_TRIM - 257)) | (1L << (T_SCHEMA
                                        - 257)) | (1L << (T_SECOND - 257)) | (1L << (T_SECONDS
                                            - 257)) | (1L << (T_SECURITY - 257)) | (1L << (T_SEGMENT
                                                - 257)) | (1L << (T_SEL - 257)) | (1L << (T_SELECT
                                                    - 257)) | (1L << (T_SET - 257)) | (1L
                                                        << (T_SESSION - 257)) | (1L << (T_SESSIONS
                                                            - 257)) | (1L << (T_SETS - 257)) | (1L
                                                                << (T_SIGNAL - 257)) | (1L
                                                                    << (T_SIMPLE_DOUBLE - 257))
                                | (1L << (T_SIMPLE_FLOAT - 257)) | (1L << (T_SMALLDATETIME - 257))
                                | (1L << (T_SMALLINT - 257)) | (1L << (T_SQL - 257)) | (1L
                                    << (T_SQLEXCEPTION - 257)) | (1L << (T_SQLINSERT - 257)) | (1L
                                        << (T_SQLSTATE - 257)) | (1L << (T_SQLWARNING - 257)) | (1L
                                            << (T_STATS - 257)) | (1L << (T_STATISTICS - 257)) | (1L
                                                << (T_STEP - 257)) | (1L << (T_STORAGE - 257)) | (1L
                                                    << (T_STORE - 257)) | (1L << (T_STORED - 257))
                                | (1L << (T_STRING - 257)) | (1L << (T_SUBDIR - 257)) | (1L
                                    << (T_SUBSTRING - 257)) | (1L << (T_SUM - 257)) | (1L
                                        << (T_SUMMARY - 257)) | (1L << (T_SYS_REFCURSOR - 257))
                                | (1L << (T_TABLE - 257)) | (1L << (T_TABLESPACE - 257)) | (1L
                                    << (T_TEMPORARY - 257)) | (1L << (T_TERMINATED - 257)) | (1L
                                        << (T_TEXTIMAGE_ON - 257)) | (1L << (T_THEN - 257)) | (1L
                                            << (T_TIMESTAMP - 257)) | (1L << (T_TITLE - 257)) | (1L
                                                << (T_TO - 257)) | (1L << (T_TOP - 257)) | (1L
                                                    << (T_TRANSACTION - 257)) | (1L << (T_TRUE
                                                        - 257)) | (1L << (T_TRUNCATE - 257)))) != 0)
                        || ((((_la - 323)) & ~0x3f) == 0
                            && ((1L << (_la - 323)) & ((1L << (T_UNIQUE - 323)) | (1L << (T_UPDATE
                                - 323)) | (1L << (T_UR - 323)) | (1L << (T_USE - 323)) | (1L
                                    << (T_USING - 323)) | (1L << (T_VALUE - 323)) | (1L << (T_VALUES
                                        - 323)) | (1L << (T_VAR - 323)) | (1L << (T_VARCHAR - 323))
                                | (1L << (T_VARCHAR2 - 323)) | (1L << (T_VARYING - 323)) | (1L
                                    << (T_VOLATILE - 323)) | (1L << (T_WHILE - 323)) | (1L
                                        << (T_WITH - 323)) | (1L << (T_WITHOUT - 323)) | (1L
                                            << (T_WORK - 323)) | (1L << (T_XACT_ABORT - 323)) | (1L
                                                << (T_XML - 323)) | (1L << (T_YES - 323)) | (1L
                                                    << (T_ACTIVITY_COUNT - 323)) | (1L
                                                        << (T_CUME_DIST - 323)) | (1L
                                                            << (T_CURRENT_DATE - 323)) | (1L
                                                                << (T_CURRENT_TIME - 323)) | (1L
                                                                    << (T_PI - 323)) | (1L
                                                                        << (T_CURRENT_TIMESTAMP
                                                                            - 323)) | (1L
                                                                                << (T_CURRENT_USER
                                                                                    - 323)) | (1L
                                                                                        << (T_DENSE_RANK
                                                                                            - 323))
                                | (1L << (T_FIRST_VALUE - 323)) | (1L << (T_LAG - 323)) | (1L
                                    << (T_LAST_VALUE - 323)) | (1L << (T_LEAD - 323)) | (1L
                                        << (T_PART_COUNT - 323)) | (1L << (T_PART_LOC - 323)) | (1L
                                            << (T_RANK - 323)) | (1L << (T_ROW_NUMBER - 323)) | (1L
                                                << (T_STDEV - 323)) | (1L << (T_SYSDATE - 323))
                                | (1L << (T_VARIANCE - 323)) | (1L << (T_USER - 323)))) != 0)
                        || _la == T_SUB
                        || _la == L_ID) {
                        {
                            setState(454);
                            ident();
                        }
                    }

                    setState(457);
                    key_list();
                    setState(459);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_TYPE) {
                        {
                            setState(458);
                            index_type_decl();
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

    public static class Key_listContext extends ParserRuleContext {
        public TerminalNode T_OPEN_P() {
            return getToken(CupidDBSqlParser.T_OPEN_P, 0);
        }

        public List<QidentContext> qident() {
            return getRuleContexts(QidentContext.class);
        }

        public QidentContext qident(int i) {
            return getRuleContext(QidentContext.class, i);
        }

        public TerminalNode T_CLOSE_P() {
            return getToken(CupidDBSqlParser.T_CLOSE_P, 0);
        }

        public List<TerminalNode> T_COMMA() {
            return getTokens(CupidDBSqlParser.T_COMMA);
        }

        public TerminalNode T_COMMA(int i) {
            return getToken(CupidDBSqlParser.T_COMMA, i);
        }

        public Key_listContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_key_list;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitKey_list(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Key_listContext key_list() throws RecognitionException {
        Key_listContext _localctx = new Key_listContext(_ctx, getState());
        enterRule(_localctx, 32, RULE_key_list);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(463);
                match(T_OPEN_P);
                setState(464);
                qident();
                setState(469);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T_COMMA) {
                    {
                        {
                            setState(465);
                            match(T_COMMA);
                            setState(466);
                            qident();
                        }
                    }
                    setState(471);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(472);
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

    public static class Index_type_declContext extends ParserRuleContext {
        public TerminalNode T_TYPE() {
            return getToken(CupidDBSqlParser.T_TYPE, 0);
        }

        public IdentContext ident() {
            return getRuleContext(IdentContext.class, 0);
        }

        public Index_type_declContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_index_type_decl;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitIndex_type_decl(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Index_type_declContext index_type_decl() throws RecognitionException {
        Index_type_declContext _localctx = new Index_type_declContext(_ctx, getState());
        enterRule(_localctx, 34, RULE_index_type_decl);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(474);
                match(T_TYPE);
                setState(475);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitColumn_name(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Column_nameContext column_name() throws RecognitionException {
        Column_nameContext _localctx = new Column_nameContext(_ctx, getState());
        enterRule(_localctx, 36, RULE_column_name);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(477);
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
            return getToken(CupidDBSqlParser.T_NULL, 0);
        }

        public TerminalNode T_NOT() {
            return getToken(CupidDBSqlParser.T_NOT, 0);
        }

        public TerminalNode T_PRIMARY() {
            return getToken(CupidDBSqlParser.T_PRIMARY, 0);
        }

        public TerminalNode T_KEY() {
            return getToken(CupidDBSqlParser.T_KEY, 0);
        }

        public TerminalNode T_UNIQUE() {
            return getToken(CupidDBSqlParser.T_UNIQUE, 0);
        }

        public TerminalNode T_REFERENCES() {
            return getToken(CupidDBSqlParser.T_REFERENCES, 0);
        }

        public Table_nameContext table_name() {
            return getRuleContext(Table_nameContext.class, 0);
        }

        public TerminalNode T_OPEN_P() {
            return getToken(CupidDBSqlParser.T_OPEN_P, 0);
        }

        public QidentContext qident() {
            return getRuleContext(QidentContext.class, 0);
        }

        public TerminalNode T_CLOSE_P() {
            return getToken(CupidDBSqlParser.T_CLOSE_P, 0);
        }

        public List<Create_table_fk_actionContext> create_table_fk_action() {
            return getRuleContexts(Create_table_fk_actionContext.class);
        }

        public Create_table_fk_actionContext create_table_fk_action(int i) {
            return getRuleContext(Create_table_fk_actionContext.class, i);
        }

        public TerminalNode T_IDENTITY() {
            return getToken(CupidDBSqlParser.T_IDENTITY, 0);
        }

        public List<TerminalNode> L_INT() {
            return getTokens(CupidDBSqlParser.L_INT);
        }

        public TerminalNode L_INT(int i) {
            return getToken(CupidDBSqlParser.L_INT, i);
        }

        public List<TerminalNode> T_COMMA() {
            return getTokens(CupidDBSqlParser.T_COMMA);
        }

        public TerminalNode T_COMMA(int i) {
            return getToken(CupidDBSqlParser.T_COMMA, i);
        }

        public TerminalNode T_AUTO_INCREMENT() {
            return getToken(CupidDBSqlParser.T_AUTO_INCREMENT, 0);
        }

        public TerminalNode T_ENABLE() {
            return getToken(CupidDBSqlParser.T_ENABLE, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitCreate_table_column_inline_cons(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Create_table_column_inline_consContext create_table_column_inline_cons()
        throws RecognitionException {
        Create_table_column_inline_consContext _localctx =
            new Create_table_column_inline_consContext(_ctx, getState());
        enterRule(_localctx, 38, RULE_create_table_column_inline_cons);
        int _la;
        try {
            setState(511);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T_DEFAULT:
                case T_WITH:
                case T_COLON:
                case T_EQUAL:
                    enterOuterAlt(_localctx, 1); {
                    setState(479);
                    dtype_default();
                }
                    break;
                case T_NOT:
                case T_NULL:
                    enterOuterAlt(_localctx, 2); {
                    setState(481);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_NOT) {
                        {
                            setState(480);
                            match(T_NOT);
                        }
                    }

                    setState(483);
                    match(T_NULL);
                }
                    break;
                case T_PRIMARY:
                    enterOuterAlt(_localctx, 3); {
                    setState(484);
                    match(T_PRIMARY);
                    setState(485);
                    match(T_KEY);
                }
                    break;
                case T_UNIQUE:
                    enterOuterAlt(_localctx, 4); {
                    setState(486);
                    match(T_UNIQUE);
                }
                    break;
                case T_REFERENCES:
                    enterOuterAlt(_localctx, 5); {
                    setState(487);
                    match(T_REFERENCES);
                    setState(488);
                    table_name();
                    setState(489);
                    match(T_OPEN_P);
                    setState(490);
                    qident();
                    setState(491);
                    match(T_CLOSE_P);
                    setState(495);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == T_ON) {
                        {
                            {
                                setState(492);
                                create_table_fk_action();
                            }
                        }
                        setState(497);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                }
                    break;
                case T_IDENTITY:
                    enterOuterAlt(_localctx, 6); {
                    setState(498);
                    match(T_IDENTITY);
                    setState(499);
                    match(T_OPEN_P);
                    setState(500);
                    match(L_INT);
                    setState(505);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == T_COMMA) {
                        {
                            {
                                setState(501);
                                match(T_COMMA);
                                setState(502);
                                match(L_INT);
                            }
                        }
                        setState(507);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                    setState(508);
                    match(T_CLOSE_P);
                }
                    break;
                case T_AUTO_INCREMENT:
                    enterOuterAlt(_localctx, 7); {
                    setState(509);
                    match(T_AUTO_INCREMENT);
                }
                    break;
                case T_ENABLE:
                    enterOuterAlt(_localctx, 8); {
                    setState(510);
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
            return getToken(CupidDBSqlParser.T_PRIMARY, 0);
        }

        public TerminalNode T_KEY() {
            return getToken(CupidDBSqlParser.T_KEY, 0);
        }

        public List<TerminalNode> T_OPEN_P() {
            return getTokens(CupidDBSqlParser.T_OPEN_P);
        }

        public TerminalNode T_OPEN_P(int i) {
            return getToken(CupidDBSqlParser.T_OPEN_P, i);
        }

        public List<QidentContext> qident() {
            return getRuleContexts(QidentContext.class);
        }

        public QidentContext qident(int i) {
            return getRuleContext(QidentContext.class, i);
        }

        public List<TerminalNode> T_CLOSE_P() {
            return getTokens(CupidDBSqlParser.T_CLOSE_P);
        }

        public TerminalNode T_CLOSE_P(int i) {
            return getToken(CupidDBSqlParser.T_CLOSE_P, i);
        }

        public TerminalNode T_CLUSTERED() {
            return getToken(CupidDBSqlParser.T_CLUSTERED, 0);
        }

        public List<TerminalNode> T_COMMA() {
            return getTokens(CupidDBSqlParser.T_COMMA);
        }

        public TerminalNode T_COMMA(int i) {
            return getToken(CupidDBSqlParser.T_COMMA, i);
        }

        public TerminalNode T_ENABLE() {
            return getToken(CupidDBSqlParser.T_ENABLE, 0);
        }

        public List<TerminalNode> T_ASC() {
            return getTokens(CupidDBSqlParser.T_ASC);
        }

        public TerminalNode T_ASC(int i) {
            return getToken(CupidDBSqlParser.T_ASC, i);
        }

        public List<TerminalNode> T_DESC() {
            return getTokens(CupidDBSqlParser.T_DESC);
        }

        public TerminalNode T_DESC(int i) {
            return getToken(CupidDBSqlParser.T_DESC, i);
        }

        public TerminalNode T_FOREIGN() {
            return getToken(CupidDBSqlParser.T_FOREIGN, 0);
        }

        public TerminalNode T_REFERENCES() {
            return getToken(CupidDBSqlParser.T_REFERENCES, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
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
        enterRule(_localctx, 40, RULE_create_table_column_cons);
        int _la;
        try {
            setState(567);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T_PRIMARY:
                    enterOuterAlt(_localctx, 1); {
                    setState(513);
                    match(T_PRIMARY);
                    setState(514);
                    match(T_KEY);
                    setState(516);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_CLUSTERED) {
                        {
                            setState(515);
                            match(T_CLUSTERED);
                        }
                    }

                    setState(518);
                    match(T_OPEN_P);
                    setState(519);
                    qident();
                    setState(521);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_ASC || _la == T_DESC) {
                        {
                            setState(520);
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

                    setState(530);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == T_COMMA) {
                        {
                            {
                                setState(523);
                                match(T_COMMA);
                                setState(524);
                                qident();
                                setState(526);
                                _errHandler.sync(this);
                                _la = _input.LA(1);
                                if (_la == T_ASC || _la == T_DESC) {
                                    {
                                        setState(525);
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
                        setState(532);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                    setState(533);
                    match(T_CLOSE_P);
                    setState(535);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_ENABLE) {
                        {
                            setState(534);
                            match(T_ENABLE);
                        }
                    }

                }
                    break;
                case T_FOREIGN:
                    enterOuterAlt(_localctx, 2); {
                    setState(537);
                    match(T_FOREIGN);
                    setState(538);
                    match(T_KEY);
                    setState(539);
                    match(T_OPEN_P);
                    setState(540);
                    qident();
                    setState(545);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == T_COMMA) {
                        {
                            {
                                setState(541);
                                match(T_COMMA);
                                setState(542);
                                qident();
                            }
                        }
                        setState(547);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                    setState(548);
                    match(T_CLOSE_P);
                    setState(549);
                    match(T_REFERENCES);
                    setState(550);
                    table_name();
                    setState(551);
                    match(T_OPEN_P);
                    setState(552);
                    qident();
                    setState(557);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == T_COMMA) {
                        {
                            {
                                setState(553);
                                match(T_COMMA);
                                setState(554);
                                qident();
                            }
                        }
                        setState(559);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                    setState(560);
                    match(T_CLOSE_P);
                    setState(564);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == T_ON) {
                        {
                            {
                                setState(561);
                                create_table_fk_action();
                            }
                        }
                        setState(566);
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
            return getToken(CupidDBSqlParser.T_ON, 0);
        }

        public TerminalNode T_UPDATE() {
            return getToken(CupidDBSqlParser.T_UPDATE, 0);
        }

        public TerminalNode T_DELETE() {
            return getToken(CupidDBSqlParser.T_DELETE, 0);
        }

        public TerminalNode T_NO() {
            return getToken(CupidDBSqlParser.T_NO, 0);
        }

        public TerminalNode T_ACTION() {
            return getToken(CupidDBSqlParser.T_ACTION, 0);
        }

        public TerminalNode T_RESTRICT() {
            return getToken(CupidDBSqlParser.T_RESTRICT, 0);
        }

        public TerminalNode T_SET() {
            return getToken(CupidDBSqlParser.T_SET, 0);
        }

        public TerminalNode T_NULL() {
            return getToken(CupidDBSqlParser.T_NULL, 0);
        }

        public TerminalNode T_DEFAULT() {
            return getToken(CupidDBSqlParser.T_DEFAULT, 0);
        }

        public TerminalNode T_CASCADE() {
            return getToken(CupidDBSqlParser.T_CASCADE, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
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
        enterRule(_localctx, 42, RULE_create_table_fk_action);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(569);
                match(T_ON);
                setState(570);
                _la = _input.LA(1);
                if (!(_la == T_DELETE || _la == T_UPDATE)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
                setState(579);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 43, _ctx)) {
                    case 1: {
                        setState(571);
                        match(T_NO);
                        setState(572);
                        match(T_ACTION);
                    }
                        break;
                    case 2: {
                        setState(573);
                        match(T_RESTRICT);
                    }
                        break;
                    case 3: {
                        setState(574);
                        match(T_SET);
                        setState(575);
                        match(T_NULL);
                    }
                        break;
                    case 4: {
                        setState(576);
                        match(T_SET);
                        setState(577);
                        match(T_DEFAULT);
                    }
                        break;
                    case 5: {
                        setState(578);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
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
        enterRule(_localctx, 44, RULE_create_table_preoptions);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(582);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        {
                            setState(581);
                            create_table_preoptions_item();
                        }
                    }
                    setState(584);
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
            return getToken(CupidDBSqlParser.T_COMMA, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
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
        enterRule(_localctx, 46, RULE_create_table_preoptions_item);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(586);
                match(T_COMMA);
                setState(587);
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
            return getToken(CupidDBSqlParser.T_LOG, 0);
        }

        public TerminalNode T_FALLBACK() {
            return getToken(CupidDBSqlParser.T_FALLBACK, 0);
        }

        public TerminalNode T_NO() {
            return getToken(CupidDBSqlParser.T_NO, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitCreate_table_preoptions_td_item(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Create_table_preoptions_td_itemContext create_table_preoptions_td_item()
        throws RecognitionException {
        Create_table_preoptions_td_itemContext _localctx =
            new Create_table_preoptions_td_itemContext(_ctx, getState());
        enterRule(_localctx, 48, RULE_create_table_preoptions_td_item);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(590);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_NO) {
                    {
                        setState(589);
                        match(T_NO);
                    }
                }

                setState(592);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitCreate_table_options(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Create_table_optionsContext create_table_options() throws RecognitionException {
        Create_table_optionsContext _localctx = new Create_table_optionsContext(_ctx, getState());
        enterRule(_localctx, 50, RULE_create_table_options);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(595);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        {
                            setState(594);
                            create_table_options_item();
                        }
                    }
                    setState(597);
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
            return getToken(CupidDBSqlParser.T_ON, 0);
        }

        public TerminalNode T_COMMIT() {
            return getToken(CupidDBSqlParser.T_COMMIT, 0);
        }

        public TerminalNode T_ROWS() {
            return getToken(CupidDBSqlParser.T_ROWS, 0);
        }

        public TerminalNode T_DELETE() {
            return getToken(CupidDBSqlParser.T_DELETE, 0);
        }

        public TerminalNode T_PRESERVE() {
            return getToken(CupidDBSqlParser.T_PRESERVE, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
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
        enterRule(_localctx, 52, RULE_create_table_options_item);
        int _la;
        try {
            setState(604);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T_ON:
                    enterOuterAlt(_localctx, 1); {
                    setState(599);
                    match(T_ON);
                    setState(600);
                    match(T_COMMIT);
                    setState(601);
                    _la = _input.LA(1);
                    if (!(_la == T_DELETE || _la == T_PRESERVE)) {
                        _errHandler.recoverInline(this);
                    } else {
                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                        _errHandler.reportMatch(this);
                        consume();
                    }
                    setState(602);
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
                    setState(603);
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
            return getToken(CupidDBSqlParser.T_AUTO_INCREMENT, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode T_EQUAL() {
            return getToken(CupidDBSqlParser.T_EQUAL, 0);
        }

        public TerminalNode T_COMMENT() {
            return getToken(CupidDBSqlParser.T_COMMENT, 0);
        }

        public TerminalNode T_CHARACTER() {
            return getToken(CupidDBSqlParser.T_CHARACTER, 0);
        }

        public TerminalNode T_SET() {
            return getToken(CupidDBSqlParser.T_SET, 0);
        }

        public TerminalNode T_CHARSET() {
            return getToken(CupidDBSqlParser.T_CHARSET, 0);
        }

        public TerminalNode T_DEFAULT() {
            return getToken(CupidDBSqlParser.T_DEFAULT, 0);
        }

        public TerminalNode T_ENGINE() {
            return getToken(CupidDBSqlParser.T_ENGINE, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitCreate_table_options_mysql_item(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Create_table_options_mysql_itemContext create_table_options_mysql_item()
        throws RecognitionException {
        Create_table_options_mysql_itemContext _localctx =
            new Create_table_options_mysql_itemContext(_ctx, getState());
        enterRule(_localctx, 54, RULE_create_table_options_mysql_item);
        int _la;
        try {
            setState(633);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T_AUTO_INCREMENT:
                    enterOuterAlt(_localctx, 1); {
                    setState(606);
                    match(T_AUTO_INCREMENT);
                    setState(608);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_EQUAL) {
                        {
                            setState(607);
                            match(T_EQUAL);
                        }
                    }

                    setState(610);
                    expr(0);
                }
                    break;
                case T_COMMENT:
                    enterOuterAlt(_localctx, 2); {
                    setState(611);
                    match(T_COMMENT);
                    setState(613);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_EQUAL) {
                        {
                            setState(612);
                            match(T_EQUAL);
                        }
                    }

                    setState(615);
                    expr(0);
                }
                    break;
                case T_CHARACTER:
                case T_CHARSET:
                case T_DEFAULT:
                    enterOuterAlt(_localctx, 3); {
                    setState(617);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_DEFAULT) {
                        {
                            setState(616);
                            match(T_DEFAULT);
                        }
                    }

                    setState(622);
                    _errHandler.sync(this);
                    switch (_input.LA(1)) {
                        case T_CHARACTER: {
                            setState(619);
                            match(T_CHARACTER);
                            setState(620);
                            match(T_SET);
                        }
                            break;
                        case T_CHARSET: {
                            setState(621);
                            match(T_CHARSET);
                        }
                            break;
                        default:
                            throw new NoViableAltException(this);
                    }
                    setState(625);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_EQUAL) {
                        {
                            setState(624);
                            match(T_EQUAL);
                        }
                    }

                    setState(627);
                    expr(0);
                }
                    break;
                case T_ENGINE:
                    enterOuterAlt(_localctx, 4); {
                    setState(628);
                    match(T_ENGINE);
                    setState(630);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_EQUAL) {
                        {
                            setState(629);
                            match(T_EQUAL);
                        }
                    }

                    setState(632);
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
            return getToken(CupidDBSqlParser.T_CREATE, 0);
        }

        public TerminalNode T_INDEX() {
            return getToken(CupidDBSqlParser.T_INDEX, 0);
        }

        public IdentContext ident() {
            return getRuleContext(IdentContext.class, 0);
        }

        public TerminalNode T_ON() {
            return getToken(CupidDBSqlParser.T_ON, 0);
        }

        public TableNameContext tableName() {
            return getRuleContext(TableNameContext.class, 0);
        }

        public TerminalNode T_OPEN_P() {
            return getToken(CupidDBSqlParser.T_OPEN_P, 0);
        }

        public List<CreateIndexColContext> createIndexCol() {
            return getRuleContexts(CreateIndexColContext.class);
        }

        public CreateIndexColContext createIndexCol(int i) {
            return getRuleContext(CreateIndexColContext.class, i);
        }

        public TerminalNode T_CLOSE_P() {
            return getToken(CupidDBSqlParser.T_CLOSE_P, 0);
        }

        public TerminalNode T_UNIQUE() {
            return getToken(CupidDBSqlParser.T_UNIQUE, 0);
        }

        public List<TerminalNode> T_COMMA() {
            return getTokens(CupidDBSqlParser.T_COMMA);
        }

        public TerminalNode T_COMMA(int i) {
            return getToken(CupidDBSqlParser.T_COMMA, i);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitCreateIndexStmt(this);
            else return visitor.visitChildren(this);
        }
    }

    public final CreateIndexStmtContext createIndexStmt() throws RecognitionException {
        CreateIndexStmtContext _localctx = new CreateIndexStmtContext(_ctx, getState());
        enterRule(_localctx, 56, RULE_createIndexStmt);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(635);
                match(T_CREATE);
                setState(637);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_UNIQUE) {
                    {
                        setState(636);
                        match(T_UNIQUE);
                    }
                }

                setState(639);
                match(T_INDEX);
                setState(640);
                ident();
                setState(641);
                match(T_ON);
                setState(642);
                tableName();
                setState(643);
                match(T_OPEN_P);
                setState(644);
                createIndexCol();
                setState(649);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T_COMMA) {
                    {
                        {
                            setState(645);
                            match(T_COMMA);
                            setState(646);
                            createIndexCol();
                        }
                    }
                    setState(651);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(652);
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
            return getToken(CupidDBSqlParser.T_ASC, 0);
        }

        public TerminalNode T_DESC() {
            return getToken(CupidDBSqlParser.T_DESC, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitCreateIndexCol(this);
            else return visitor.visitChildren(this);
        }
    }

    public final CreateIndexColContext createIndexCol() throws RecognitionException {
        CreateIndexColContext _localctx = new CreateIndexColContext(_ctx, getState());
        enterRule(_localctx, 58, RULE_createIndexCol);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(654);
                ident();
                setState(656);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_ASC || _la == T_DESC) {
                    {
                        setState(655);
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

    public static class DropTableIndexStmtContext extends ParserRuleContext {
        public Token indexName;

        public TerminalNode T_DROP() {
            return getToken(CupidDBSqlParser.T_DROP, 0);
        }

        public TerminalNode T_INDEX() {
            return getToken(CupidDBSqlParser.T_INDEX, 0);
        }

        public TerminalNode T_ON() {
            return getToken(CupidDBSqlParser.T_ON, 0);
        }

        public TableNameContext tableName() {
            return getRuleContext(TableNameContext.class, 0);
        }

        public TerminalNode L_ID() {
            return getToken(CupidDBSqlParser.L_ID, 0);
        }

        public DropTableIndexStmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_dropTableIndexStmt;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitDropTableIndexStmt(this);
            else return visitor.visitChildren(this);
        }
    }

    public final DropTableIndexStmtContext dropTableIndexStmt() throws RecognitionException {
        DropTableIndexStmtContext _localctx = new DropTableIndexStmtContext(_ctx, getState());
        enterRule(_localctx, 60, RULE_dropTableIndexStmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(658);
                match(T_DROP);
                setState(659);
                match(T_INDEX);
                setState(660);
                ((DropTableIndexStmtContext) _localctx).indexName = match(L_ID);
                setState(661);
                match(T_ON);
                setState(662);
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

    public static class Dtype_defaultContext extends ParserRuleContext {
        public TerminalNode T_EQUAL() {
            return getToken(CupidDBSqlParser.T_EQUAL, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode T_COLON() {
            return getToken(CupidDBSqlParser.T_COLON, 0);
        }

        public TerminalNode T_DEFAULT() {
            return getToken(CupidDBSqlParser.T_DEFAULT, 0);
        }

        public TerminalNode T_WITH() {
            return getToken(CupidDBSqlParser.T_WITH, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitDtype_default(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Dtype_defaultContext dtype_default() throws RecognitionException {
        Dtype_defaultContext _localctx = new Dtype_defaultContext(_ctx, getState());
        enterRule(_localctx, 62, RULE_dtype_default);
        int _la;
        try {
            setState(676);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T_COLON:
                case T_EQUAL:
                    enterOuterAlt(_localctx, 1); {
                    setState(665);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_COLON) {
                        {
                            setState(664);
                            match(T_COLON);
                        }
                    }

                    setState(667);
                    match(T_EQUAL);
                    setState(668);
                    expr(0);
                }
                    break;
                case T_DEFAULT:
                case T_WITH:
                    enterOuterAlt(_localctx, 2); {
                    setState(670);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_WITH) {
                        {
                            setState(669);
                            match(T_WITH);
                        }
                    }

                    setState(672);
                    match(T_DEFAULT);
                    setState(674);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 60, _ctx)) {
                        case 1: {
                            setState(673);
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
            return getToken(CupidDBSqlParser.T_SHOW, 0);
        }

        public TerminalNode T_TABLES() {
            return getToken(CupidDBSqlParser.T_TABLES, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitShowTablesStmt(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ShowTablesStmtContext showTablesStmt() throws RecognitionException {
        ShowTablesStmtContext _localctx = new ShowTablesStmtContext(_ctx, getState());
        enterRule(_localctx, 64, RULE_showTablesStmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(678);
                match(T_SHOW);
                setState(679);
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
            return getToken(CupidDBSqlParser.T_NULL, 0);
        }

        public TerminalNode T_NOT() {
            return getToken(CupidDBSqlParser.T_NOT, 0);
        }

        public TerminalNode T_CHARACTER() {
            return getToken(CupidDBSqlParser.T_CHARACTER, 0);
        }

        public TerminalNode T_SET() {
            return getToken(CupidDBSqlParser.T_SET, 0);
        }

        public IdentContext ident() {
            return getRuleContext(IdentContext.class, 0);
        }

        public TerminalNode T_CASESPECIFIC() {
            return getToken(CupidDBSqlParser.T_CASESPECIFIC, 0);
        }

        public TerminalNode T_CS() {
            return getToken(CupidDBSqlParser.T_CS, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitDtype_attr(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Dtype_attrContext dtype_attr() throws RecognitionException {
        Dtype_attrContext _localctx = new Dtype_attrContext(_ctx, getState());
        enterRule(_localctx, 66, RULE_dtype_attr);
        int _la;
        try {
            setState(692);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 64, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1); {
                    setState(682);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_NOT) {
                        {
                            setState(681);
                            match(T_NOT);
                        }
                    }

                    setState(684);
                    match(T_NULL);
                }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2); {
                    setState(685);
                    match(T_CHARACTER);
                    setState(686);
                    match(T_SET);
                    setState(687);
                    ident();
                }
                    break;
                case 3:
                    enterOuterAlt(_localctx, 3); {
                    setState(689);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_NOT) {
                        {
                            setState(688);
                            match(T_NOT);
                        }
                    }

                    setState(691);
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
            return getToken(CupidDBSqlParser.T_DATETIME, 0);
        }

        public TerminalNode T_DOUBLE() {
            return getToken(CupidDBSqlParser.T_DOUBLE, 0);
        }

        public TerminalNode T_FLOAT() {
            return getToken(CupidDBSqlParser.T_FLOAT, 0);
        }

        public TerminalNode T_INT() {
            return getToken(CupidDBSqlParser.T_INT, 0);
        }

        public TerminalNode T_INTEGER() {
            return getToken(CupidDBSqlParser.T_INTEGER, 0);
        }

        public TerminalNode T_STRING() {
            return getToken(CupidDBSqlParser.T_STRING, 0);
        }

        public TerminalNode T_TIMESTAMP() {
            return getToken(CupidDBSqlParser.T_TIMESTAMP, 0);
        }

        public TerminalNode T_LONG() {
            return getToken(CupidDBSqlParser.T_LONG, 0);
        }

        public TerminalNode T_BOOLEAN() {
            return getToken(CupidDBSqlParser.T_BOOLEAN, 0);
        }

        public TerminalNode T_BOOL() {
            return getToken(CupidDBSqlParser.T_BOOL, 0);
        }

        public TerminalNode T_BINARY() {
            return getToken(CupidDBSqlParser.T_BINARY, 0);
        }

        public TerminalNode T_GEOMETRY() {
            return getToken(CupidDBSqlParser.T_GEOMETRY, 0);
        }

        public TerminalNode T_POINT() {
            return getToken(CupidDBSqlParser.T_POINT, 0);
        }

        public TerminalNode T_LINESTRING() {
            return getToken(CupidDBSqlParser.T_LINESTRING, 0);
        }

        public TerminalNode T_POLYGON() {
            return getToken(CupidDBSqlParser.T_POLYGON, 0);
        }

        public TerminalNode T_MULTIPOINT() {
            return getToken(CupidDBSqlParser.T_MULTIPOINT, 0);
        }

        public TerminalNode T_MULTILINESTRING() {
            return getToken(CupidDBSqlParser.T_MULTILINESTRING, 0);
        }

        public TerminalNode T_MULTIPOLYGON() {
            return getToken(CupidDBSqlParser.T_MULTIPOLYGON, 0);
        }

        public TerminalNode T_GEOMETRYCOLLECTION() {
            return getToken(CupidDBSqlParser.T_GEOMETRYCOLLECTION, 0);
        }

        public TerminalNode T_TRAJECTORY() {
            return getToken(CupidDBSqlParser.T_TRAJECTORY, 0);
        }

        public TerminalNode T_ROADSEGMENT() {
            return getToken(CupidDBSqlParser.T_ROADSEGMENT, 0);
        }

        public TerminalNode T_ROADNETWORK() {
            return getToken(CupidDBSqlParser.T_ROADNETWORK, 0);
        }

        public IdentContext ident() {
            return getRuleContext(IdentContext.class, 0);
        }

        public TerminalNode T_TYPE() {
            return getToken(CupidDBSqlParser.T_TYPE, 0);
        }

        public TerminalNode T_ROWTYPE() {
            return getToken(CupidDBSqlParser.T_ROWTYPE, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitDtype(this);
            else return visitor.visitChildren(this);
        }
    }

    public final DtypeContext dtype() throws RecognitionException {
        DtypeContext _localctx = new DtypeContext(_ctx, getState());
        enterRule(_localctx, 68, RULE_dtype);
        int _la;
        try {
            setState(721);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 66, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1); {
                    setState(694);
                    match(T_DATETIME);
                }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2); {
                    setState(695);
                    match(T_DOUBLE);
                }
                    break;
                case 3:
                    enterOuterAlt(_localctx, 3); {
                    setState(696);
                    match(T_FLOAT);
                }
                    break;
                case 4:
                    enterOuterAlt(_localctx, 4); {
                    setState(697);
                    match(T_INT);
                }
                    break;
                case 5:
                    enterOuterAlt(_localctx, 5); {
                    setState(698);
                    match(T_INTEGER);
                }
                    break;
                case 6:
                    enterOuterAlt(_localctx, 6); {
                    setState(699);
                    match(T_STRING);
                }
                    break;
                case 7:
                    enterOuterAlt(_localctx, 7); {
                    setState(700);
                    match(T_TIMESTAMP);
                }
                    break;
                case 8:
                    enterOuterAlt(_localctx, 8); {
                    setState(701);
                    match(T_LONG);
                }
                    break;
                case 9:
                    enterOuterAlt(_localctx, 9); {
                    setState(702);
                    match(T_BOOLEAN);
                }
                    break;
                case 10:
                    enterOuterAlt(_localctx, 10); {
                    setState(703);
                    match(T_BOOL);
                }
                    break;
                case 11:
                    enterOuterAlt(_localctx, 11); {
                    setState(704);
                    match(T_BINARY);
                }
                    break;
                case 12:
                    enterOuterAlt(_localctx, 12); {
                    setState(705);
                    match(T_GEOMETRY);
                }
                    break;
                case 13:
                    enterOuterAlt(_localctx, 13); {
                    setState(706);
                    match(T_POINT);
                }
                    break;
                case 14:
                    enterOuterAlt(_localctx, 14); {
                    setState(707);
                    match(T_LINESTRING);
                }
                    break;
                case 15:
                    enterOuterAlt(_localctx, 15); {
                    setState(708);
                    match(T_POLYGON);
                }
                    break;
                case 16:
                    enterOuterAlt(_localctx, 16); {
                    setState(709);
                    match(T_MULTIPOINT);
                }
                    break;
                case 17:
                    enterOuterAlt(_localctx, 17); {
                    setState(710);
                    match(T_MULTILINESTRING);
                }
                    break;
                case 18:
                    enterOuterAlt(_localctx, 18); {
                    setState(711);
                    match(T_MULTIPOLYGON);
                }
                    break;
                case 19:
                    enterOuterAlt(_localctx, 19); {
                    setState(712);
                    match(T_GEOMETRYCOLLECTION);
                }
                    break;
                case 20:
                    enterOuterAlt(_localctx, 20); {
                    setState(713);
                    match(T_TRAJECTORY);
                }
                    break;
                case 21:
                    enterOuterAlt(_localctx, 21); {
                    setState(714);
                    match(T_ROADSEGMENT);
                }
                    break;
                case 22:
                    enterOuterAlt(_localctx, 22); {
                    setState(715);
                    match(T_ROADNETWORK);
                }
                    break;
                case 23:
                    enterOuterAlt(_localctx, 23); {
                    setState(716);
                    ident();
                    setState(719);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T__0) {
                        {
                            setState(717);
                            match(T__0);
                            setState(718);
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
            return getToken(CupidDBSqlParser.T_OPEN_P, 0);
        }

        public TerminalNode T_CLOSE_P() {
            return getToken(CupidDBSqlParser.T_CLOSE_P, 0);
        }

        public List<TerminalNode> L_INT() {
            return getTokens(CupidDBSqlParser.L_INT);
        }

        public TerminalNode L_INT(int i) {
            return getToken(CupidDBSqlParser.L_INT, i);
        }

        public TerminalNode T_MAX() {
            return getToken(CupidDBSqlParser.T_MAX, 0);
        }

        public TerminalNode T_COMMA() {
            return getToken(CupidDBSqlParser.T_COMMA, 0);
        }

        public TerminalNode T_CHAR() {
            return getToken(CupidDBSqlParser.T_CHAR, 0);
        }

        public TerminalNode T_BYTE() {
            return getToken(CupidDBSqlParser.T_BYTE, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitDtypeLen(this);
            else return visitor.visitChildren(this);
        }
    }

    public final DtypeLenContext dtypeLen() throws RecognitionException {
        DtypeLenContext _localctx = new DtypeLenContext(_ctx, getState());
        enterRule(_localctx, 70, RULE_dtypeLen);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(723);
                match(T_OPEN_P);
                setState(724);
                _la = _input.LA(1);
                if (!(_la == T_MAX || _la == L_INT)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
                setState(726);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_BYTE || _la == T_CHAR) {
                    {
                        setState(725);
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

                setState(730);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_COMMA) {
                    {
                        setState(728);
                        match(T_COMMA);
                        setState(729);
                        match(L_INT);
                    }
                }

                setState(732);
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
            return getToken(CupidDBSqlParser.T_CREATE, 0);
        }

        public TerminalNode T_DATABASE() {
            return getToken(CupidDBSqlParser.T_DATABASE, 0);
        }

        public TerminalNode T_SCHEMA() {
            return getToken(CupidDBSqlParser.T_SCHEMA, 0);
        }

        public TerminalNode L_ID() {
            return getToken(CupidDBSqlParser.L_ID, 0);
        }

        public TerminalNode T_IF() {
            return getToken(CupidDBSqlParser.T_IF, 0);
        }

        public TerminalNode T_NOT() {
            return getToken(CupidDBSqlParser.T_NOT, 0);
        }

        public TerminalNode T_EXISTS() {
            return getToken(CupidDBSqlParser.T_EXISTS, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitCreateDatabaseStmt(this);
            else return visitor.visitChildren(this);
        }
    }

    public final CreateDatabaseStmtContext createDatabaseStmt() throws RecognitionException {
        CreateDatabaseStmtContext _localctx = new CreateDatabaseStmtContext(_ctx, getState());
        enterRule(_localctx, 72, RULE_createDatabaseStmt);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(734);
                match(T_CREATE);
                setState(735);
                _la = _input.LA(1);
                if (!(_la == T_DATABASE || _la == T_SCHEMA)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
                setState(739);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_IF) {
                    {
                        setState(736);
                        match(T_IF);
                        setState(737);
                        match(T_NOT);
                        setState(738);
                        match(T_EXISTS);
                    }
                }

                setState(741);
                ((CreateDatabaseStmtContext) _localctx).dbName = match(L_ID);
                setState(745);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T_COMMENT || _la == T_LOCATION) {
                    {
                        {
                            setState(742);
                            createDatabaseOption();
                        }
                    }
                    setState(747);
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
            return getToken(CupidDBSqlParser.T_SHOW, 0);
        }

        public TerminalNode T_DATABASES() {
            return getToken(CupidDBSqlParser.T_DATABASES, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitShowDatabasesStmt(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ShowDatabasesStmtContext showDatabasesStmt() throws RecognitionException {
        ShowDatabasesStmtContext _localctx = new ShowDatabasesStmtContext(_ctx, getState());
        enterRule(_localctx, 74, RULE_showDatabasesStmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(748);
                match(T_SHOW);
                setState(749);
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
            return getToken(CupidDBSqlParser.T_DROP, 0);
        }

        public TerminalNode T_DATABASE() {
            return getToken(CupidDBSqlParser.T_DATABASE, 0);
        }

        public TerminalNode T_SCHEMA() {
            return getToken(CupidDBSqlParser.T_SCHEMA, 0);
        }

        public TerminalNode L_ID() {
            return getToken(CupidDBSqlParser.L_ID, 0);
        }

        public TerminalNode T_IF() {
            return getToken(CupidDBSqlParser.T_IF, 0);
        }

        public TerminalNode T_EXISTS() {
            return getToken(CupidDBSqlParser.T_EXISTS, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitDropDatabaseStmt(this);
            else return visitor.visitChildren(this);
        }
    }

    public final DropDatabaseStmtContext dropDatabaseStmt() throws RecognitionException {
        DropDatabaseStmtContext _localctx = new DropDatabaseStmtContext(_ctx, getState());
        enterRule(_localctx, 76, RULE_dropDatabaseStmt);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(751);
                match(T_DROP);
                setState(752);
                _la = _input.LA(1);
                if (!(_la == T_DATABASE || _la == T_SCHEMA)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
                setState(755);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_IF) {
                    {
                        setState(753);
                        match(T_IF);
                        setState(754);
                        match(T_EXISTS);
                    }
                }

                setState(757);
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
            return getToken(CupidDBSqlParser.T_COMMENT, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode T_LOCATION() {
            return getToken(CupidDBSqlParser.T_LOCATION, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitCreateDatabaseOption(this);
            else return visitor.visitChildren(this);
        }
    }

    public final CreateDatabaseOptionContext createDatabaseOption() throws RecognitionException {
        CreateDatabaseOptionContext _localctx = new CreateDatabaseOptionContext(_ctx, getState());
        enterRule(_localctx, 78, RULE_createDatabaseOption);
        try {
            setState(763);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T_COMMENT:
                    enterOuterAlt(_localctx, 1); {
                    setState(759);
                    match(T_COMMENT);
                    setState(760);
                    expr(0);
                }
                    break;
                case T_LOCATION:
                    enterOuterAlt(_localctx, 2); {
                    setState(761);
                    match(T_LOCATION);
                    setState(762);
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
            return getToken(CupidDBSqlParser.T_DROP, 0);
        }

        public TerminalNode T_TABLE() {
            return getToken(CupidDBSqlParser.T_TABLE, 0);
        }

        public TableNameContext tableName() {
            return getRuleContext(TableNameContext.class, 0);
        }

        public TerminalNode T_IF() {
            return getToken(CupidDBSqlParser.T_IF, 0);
        }

        public TerminalNode T_EXISTS() {
            return getToken(CupidDBSqlParser.T_EXISTS, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitDropTableStmt(this);
            else return visitor.visitChildren(this);
        }
    }

    public final DropTableStmtContext dropTableStmt() throws RecognitionException {
        DropTableStmtContext _localctx = new DropTableStmtContext(_ctx, getState());
        enterRule(_localctx, 80, RULE_dropTableStmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(765);
                match(T_DROP);
                setState(766);
                match(T_TABLE);
                setState(769);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 73, _ctx)) {
                    case 1: {
                        setState(767);
                        match(T_IF);
                        setState(768);
                        match(T_EXISTS);
                    }
                        break;
                }
                setState(771);
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
            return getToken(CupidDBSqlParser.T_INSERT, 0);
        }

        public TableNameContext tableName() {
            return getRuleContext(TableNameContext.class, 0);
        }

        public TerminalNode T_OVERWRITE() {
            return getToken(CupidDBSqlParser.T_OVERWRITE, 0);
        }

        public TerminalNode T_TABLE() {
            return getToken(CupidDBSqlParser.T_TABLE, 0);
        }

        public TerminalNode T_INTO() {
            return getToken(CupidDBSqlParser.T_INTO, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitInsertStmt(this);
            else return visitor.visitChildren(this);
        }
    }

    public final InsertStmtContext insertStmt() throws RecognitionException {
        InsertStmtContext _localctx = new InsertStmtContext(_ctx, getState());
        enterRule(_localctx, 82, RULE_insertStmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(773);
                match(T_INSERT);
                setState(780);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case T_OVERWRITE: {
                        setState(774);
                        match(T_OVERWRITE);
                        setState(775);
                        match(T_TABLE);
                    }
                        break;
                    case T_INTO: {
                        setState(776);
                        match(T_INTO);
                        setState(778);
                        _errHandler.sync(this);
                        switch (getInterpreter().adaptivePredict(_input, 74, _ctx)) {
                            case 1: {
                                setState(777);
                                match(T_TABLE);
                            }
                                break;
                        }
                    }
                        break;
                    default:
                        throw new NoViableAltException(this);
                }
                setState(782);
                tableName();
                setState(784);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 76, _ctx)) {
                    case 1: {
                        setState(783);
                        insertStmtCols();
                    }
                        break;
                }
                setState(788);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case T_SEL:
                    case T_SELECT:
                    case T_WITH:
                    case T_OPEN_P: {
                        setState(786);
                        selectStmt();
                    }
                        break;
                    case T_VALUES: {
                        setState(787);
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
            return getToken(CupidDBSqlParser.T_OPEN_P, 0);
        }

        public List<IdentContext> ident() {
            return getRuleContexts(IdentContext.class);
        }

        public IdentContext ident(int i) {
            return getRuleContext(IdentContext.class, i);
        }

        public TerminalNode T_CLOSE_P() {
            return getToken(CupidDBSqlParser.T_CLOSE_P, 0);
        }

        public List<TerminalNode> T_COMMA() {
            return getTokens(CupidDBSqlParser.T_COMMA);
        }

        public TerminalNode T_COMMA(int i) {
            return getToken(CupidDBSqlParser.T_COMMA, i);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitInsertStmtCols(this);
            else return visitor.visitChildren(this);
        }
    }

    public final InsertStmtColsContext insertStmtCols() throws RecognitionException {
        InsertStmtColsContext _localctx = new InsertStmtColsContext(_ctx, getState());
        enterRule(_localctx, 84, RULE_insertStmtCols);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(790);
                match(T_OPEN_P);
                setState(791);
                ident();
                setState(796);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T_COMMA) {
                    {
                        {
                            setState(792);
                            match(T_COMMA);
                            setState(793);
                            ident();
                        }
                    }
                    setState(798);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(799);
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
            return getToken(CupidDBSqlParser.T_VALUES, 0);
        }

        public List<InsertStmtRowContext> insertStmtRow() {
            return getRuleContexts(InsertStmtRowContext.class);
        }

        public InsertStmtRowContext insertStmtRow(int i) {
            return getRuleContext(InsertStmtRowContext.class, i);
        }

        public List<TerminalNode> T_COMMA() {
            return getTokens(CupidDBSqlParser.T_COMMA);
        }

        public TerminalNode T_COMMA(int i) {
            return getToken(CupidDBSqlParser.T_COMMA, i);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitInsertStmtRows(this);
            else return visitor.visitChildren(this);
        }
    }

    public final InsertStmtRowsContext insertStmtRows() throws RecognitionException {
        InsertStmtRowsContext _localctx = new InsertStmtRowsContext(_ctx, getState());
        enterRule(_localctx, 86, RULE_insertStmtRows);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(801);
                match(T_VALUES);
                setState(802);
                insertStmtRow();
                setState(807);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T_COMMA) {
                    {
                        {
                            setState(803);
                            match(T_COMMA);
                            setState(804);
                            insertStmtRow();
                        }
                    }
                    setState(809);
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
            return getToken(CupidDBSqlParser.T_OPEN_P, 0);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode T_CLOSE_P() {
            return getToken(CupidDBSqlParser.T_CLOSE_P, 0);
        }

        public List<TerminalNode> T_COMMA() {
            return getTokens(CupidDBSqlParser.T_COMMA);
        }

        public TerminalNode T_COMMA(int i) {
            return getToken(CupidDBSqlParser.T_COMMA, i);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitInsertStmtRow(this);
            else return visitor.visitChildren(this);
        }
    }

    public final InsertStmtRowContext insertStmtRow() throws RecognitionException {
        InsertStmtRowContext _localctx = new InsertStmtRowContext(_ctx, getState());
        enterRule(_localctx, 88, RULE_insertStmtRow);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(810);
                match(T_OPEN_P);
                setState(811);
                expr(0);
                setState(816);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T_COMMA) {
                    {
                        {
                            setState(812);
                            match(T_COMMA);
                            setState(813);
                            expr(0);
                        }
                    }
                    setState(818);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(819);
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
            return getToken(CupidDBSqlParser.T_TRUNCATE, 0);
        }

        public IdentContext ident() {
            return getRuleContext(IdentContext.class, 0);
        }

        public TerminalNode T_TABLE() {
            return getToken(CupidDBSqlParser.T_TABLE, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitTruncateStmt(this);
            else return visitor.visitChildren(this);
        }
    }

    public final TruncateStmtContext truncateStmt() throws RecognitionException {
        TruncateStmtContext _localctx = new TruncateStmtContext(_ctx, getState());
        enterRule(_localctx, 90, RULE_truncateStmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(821);
                match(T_TRUNCATE);
                setState(823);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 81, _ctx)) {
                    case 1: {
                        setState(822);
                        match(T_TABLE);
                    }
                        break;
                }
                setState(825);
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
            return getToken(CupidDBSqlParser.T_USE, 0);
        }

        public TerminalNode L_ID() {
            return getToken(CupidDBSqlParser.L_ID, 0);
        }

        public TerminalNode T_DEFAULT() {
            return getToken(CupidDBSqlParser.T_DEFAULT, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitUseStmt(this);
            else return visitor.visitChildren(this);
        }
    }

    public final UseStmtContext useStmt() throws RecognitionException {
        UseStmtContext _localctx = new UseStmtContext(_ctx, getState());
        enterRule(_localctx, 92, RULE_useStmt);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(827);
                match(T_USE);
                setState(828);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitSelectStmt(this);
            else return visitor.visitChildren(this);
        }
    }

    public final SelectStmtContext selectStmt() throws RecognitionException {
        SelectStmtContext _localctx = new SelectStmtContext(_ctx, getState());
        enterRule(_localctx, 94, RULE_selectStmt);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(831);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_WITH) {
                    {
                        setState(830);
                        cteSelectStmt();
                    }
                }

                setState(833);
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
            return getToken(CupidDBSqlParser.T_WITH, 0);
        }

        public List<CteSelectStmtItemContext> cteSelectStmtItem() {
            return getRuleContexts(CteSelectStmtItemContext.class);
        }

        public CteSelectStmtItemContext cteSelectStmtItem(int i) {
            return getRuleContext(CteSelectStmtItemContext.class, i);
        }

        public List<TerminalNode> T_COMMA() {
            return getTokens(CupidDBSqlParser.T_COMMA);
        }

        public TerminalNode T_COMMA(int i) {
            return getToken(CupidDBSqlParser.T_COMMA, i);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitCteSelectStmt(this);
            else return visitor.visitChildren(this);
        }
    }

    public final CteSelectStmtContext cteSelectStmt() throws RecognitionException {
        CteSelectStmtContext _localctx = new CteSelectStmtContext(_ctx, getState());
        enterRule(_localctx, 96, RULE_cteSelectStmt);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(835);
                match(T_WITH);
                setState(836);
                cteSelectStmtItem();
                setState(841);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T_COMMA) {
                    {
                        {
                            setState(837);
                            match(T_COMMA);
                            setState(838);
                            cteSelectStmtItem();
                        }
                    }
                    setState(843);
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
            return getToken(CupidDBSqlParser.T_AS, 0);
        }

        public TerminalNode T_OPEN_P() {
            return getToken(CupidDBSqlParser.T_OPEN_P, 0);
        }

        public FullselectStmtContext fullselectStmt() {
            return getRuleContext(FullselectStmtContext.class, 0);
        }

        public TerminalNode T_CLOSE_P() {
            return getToken(CupidDBSqlParser.T_CLOSE_P, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitCteSelectStmtItem(this);
            else return visitor.visitChildren(this);
        }
    }

    public final CteSelectStmtItemContext cteSelectStmtItem() throws RecognitionException {
        CteSelectStmtItemContext _localctx = new CteSelectStmtItemContext(_ctx, getState());
        enterRule(_localctx, 98, RULE_cteSelectStmtItem);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(844);
                ident();
                setState(846);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_OPEN_P) {
                    {
                        setState(845);
                        cteSelectCols();
                    }
                }

                setState(848);
                match(T_AS);
                setState(849);
                match(T_OPEN_P);
                setState(850);
                fullselectStmt();
                setState(851);
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
            return getToken(CupidDBSqlParser.T_OPEN_P, 0);
        }

        public List<IdentContext> ident() {
            return getRuleContexts(IdentContext.class);
        }

        public IdentContext ident(int i) {
            return getRuleContext(IdentContext.class, i);
        }

        public TerminalNode T_CLOSE_P() {
            return getToken(CupidDBSqlParser.T_CLOSE_P, 0);
        }

        public List<TerminalNode> T_COMMA() {
            return getTokens(CupidDBSqlParser.T_COMMA);
        }

        public TerminalNode T_COMMA(int i) {
            return getToken(CupidDBSqlParser.T_COMMA, i);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitCteSelectCols(this);
            else return visitor.visitChildren(this);
        }
    }

    public final CteSelectColsContext cteSelectCols() throws RecognitionException {
        CteSelectColsContext _localctx = new CteSelectColsContext(_ctx, getState());
        enterRule(_localctx, 100, RULE_cteSelectCols);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(853);
                match(T_OPEN_P);
                setState(854);
                ident();
                setState(859);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T_COMMA) {
                    {
                        {
                            setState(855);
                            match(T_COMMA);
                            setState(856);
                            ident();
                        }
                    }
                    setState(861);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(862);
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
            return getToken(CupidDBSqlParser.T_OPEN_P, 0);
        }

        public FullselectStmtContext fullselectStmt() {
            return getRuleContext(FullselectStmtContext.class, 0);
        }

        public TerminalNode T_CLOSE_P() {
            return getToken(CupidDBSqlParser.T_CLOSE_P, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitFullselectStmt(this);
            else return visitor.visitChildren(this);
        }
    }

    public final FullselectStmtContext fullselectStmt() throws RecognitionException {
        FullselectStmtContext _localctx = new FullselectStmtContext(_ctx, getState());
        enterRule(_localctx, 102, RULE_fullselectStmt);
        int _la;
        try {
            setState(877);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 87, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1); {
                    setState(864);
                    fullselectStmtItem();
                    setState(870);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == T_EXCEPT || _la == T_INTERSECT || _la == T_UNION) {
                        {
                            {
                                setState(865);
                                fullselectSetClause();
                                setState(866);
                                fullselectStmtItem();
                            }
                        }
                        setState(872);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2); {
                    setState(873);
                    match(T_OPEN_P);
                    setState(874);
                    fullselectStmt();
                    setState(875);
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
            return getToken(CupidDBSqlParser.T_OPEN_P, 0);
        }

        public FullselectStmtContext fullselectStmt() {
            return getRuleContext(FullselectStmtContext.class, 0);
        }

        public TerminalNode T_CLOSE_P() {
            return getToken(CupidDBSqlParser.T_CLOSE_P, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitFullselectStmtItem(this);
            else return visitor.visitChildren(this);
        }
    }

    public final FullselectStmtItemContext fullselectStmtItem() throws RecognitionException {
        FullselectStmtItemContext _localctx = new FullselectStmtItemContext(_ctx, getState());
        enterRule(_localctx, 104, RULE_fullselectStmtItem);
        try {
            setState(884);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T_SEL:
                case T_SELECT:
                    enterOuterAlt(_localctx, 1); {
                    setState(879);
                    subselectStmt();
                }
                    break;
                case T_OPEN_P:
                    enterOuterAlt(_localctx, 2); {
                    setState(880);
                    match(T_OPEN_P);
                    setState(881);
                    fullselectStmt();
                    setState(882);
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
            return getToken(CupidDBSqlParser.T_UNION, 0);
        }

        public TerminalNode T_ALL() {
            return getToken(CupidDBSqlParser.T_ALL, 0);
        }

        public TerminalNode T_EXCEPT() {
            return getToken(CupidDBSqlParser.T_EXCEPT, 0);
        }

        public TerminalNode T_INTERSECT() {
            return getToken(CupidDBSqlParser.T_INTERSECT, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitFullselectSetClause(this);
            else return visitor.visitChildren(this);
        }
    }

    public final FullselectSetClauseContext fullselectSetClause() throws RecognitionException {
        FullselectSetClauseContext _localctx = new FullselectSetClauseContext(_ctx, getState());
        enterRule(_localctx, 106, RULE_fullselectSetClause);
        int _la;
        try {
            setState(898);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T_UNION:
                    enterOuterAlt(_localctx, 1); {
                    setState(886);
                    match(T_UNION);
                    setState(888);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_ALL) {
                        {
                            setState(887);
                            match(T_ALL);
                        }
                    }

                }
                    break;
                case T_EXCEPT:
                    enterOuterAlt(_localctx, 2); {
                    setState(890);
                    match(T_EXCEPT);
                    setState(892);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_ALL) {
                        {
                            setState(891);
                            match(T_ALL);
                        }
                    }

                }
                    break;
                case T_INTERSECT:
                    enterOuterAlt(_localctx, 3); {
                    setState(894);
                    match(T_INTERSECT);
                    setState(896);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_ALL) {
                        {
                            setState(895);
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
            return getToken(CupidDBSqlParser.T_SELECT, 0);
        }

        public TerminalNode T_SEL() {
            return getToken(CupidDBSqlParser.T_SEL, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitSubselectStmt(this);
            else return visitor.visitChildren(this);
        }
    }

    public final SubselectStmtContext subselectStmt() throws RecognitionException {
        SubselectStmtContext _localctx = new SubselectStmtContext(_ctx, getState());
        enterRule(_localctx, 108, RULE_subselectStmt);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(900);
                _la = _input.LA(1);
                if (!(_la == T_SEL || _la == T_SELECT)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
                setState(901);
                selectList();
                setState(903);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_INTO) {
                    {
                        setState(902);
                        intoClause();
                    }
                }

                setState(906);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_FROM) {
                    {
                        setState(905);
                        fromClause();
                    }
                }

                setState(909);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_WHERE) {
                    {
                        setState(908);
                        whereClause();
                    }
                }

                setState(912);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_GROUP) {
                    {
                        setState(911);
                        groupByClause();
                    }
                }

                setState(916);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case T_HAVING: {
                        setState(914);
                        havingClause();
                    }
                        break;
                    case T_QUALIFY: {
                        setState(915);
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
                setState(919);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_ORDER) {
                    {
                        setState(918);
                        orderByClause();
                    }
                }

                setState(922);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_LIMIT || _la == T_WITH) {
                    {
                        setState(921);
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
            return getTokens(CupidDBSqlParser.T_COMMA);
        }

        public TerminalNode T_COMMA(int i) {
            return getToken(CupidDBSqlParser.T_COMMA, i);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitSelectList(this);
            else return visitor.visitChildren(this);
        }
    }

    public final SelectListContext selectList() throws RecognitionException {
        SelectListContext _localctx = new SelectListContext(_ctx, getState());
        enterRule(_localctx, 110, RULE_selectList);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(925);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 100, _ctx)) {
                    case 1: {
                        setState(924);
                        selectListSet();
                    }
                        break;
                }
                setState(928);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 101, _ctx)) {
                    case 1: {
                        setState(927);
                        selectListLimit();
                    }
                        break;
                }
                setState(930);
                selectListItem();
                setState(935);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T_COMMA) {
                    {
                        {
                            setState(931);
                            match(T_COMMA);
                            setState(932);
                            selectListItem();
                        }
                    }
                    setState(937);
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
            return getToken(CupidDBSqlParser.T_ALL, 0);
        }

        public TerminalNode T_DISTINCT() {
            return getToken(CupidDBSqlParser.T_DISTINCT, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitSelectListSet(this);
            else return visitor.visitChildren(this);
        }
    }

    public final SelectListSetContext selectListSet() throws RecognitionException {
        SelectListSetContext _localctx = new SelectListSetContext(_ctx, getState());
        enterRule(_localctx, 112, RULE_selectListSet);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(938);
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
            return getToken(CupidDBSqlParser.T_TOP, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitSelectListLimit(this);
            else return visitor.visitChildren(this);
        }
    }

    public final SelectListLimitContext selectListLimit() throws RecognitionException {
        SelectListLimitContext _localctx = new SelectListLimitContext(_ctx, getState());
        enterRule(_localctx, 114, RULE_selectListLimit);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(940);
                match(T_TOP);
                setState(941);
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
            return getToken(CupidDBSqlParser.T_EQUAL, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitSelectListItem(this);
            else return visitor.visitChildren(this);
        }
    }

    public final SelectListItemContext selectListItem() throws RecognitionException {
        SelectListItemContext _localctx = new SelectListItemContext(_ctx, getState());
        enterRule(_localctx, 116, RULE_selectListItem);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(953);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 105, _ctx)) {
                    case 1: {
                        setState(946);
                        _errHandler.sync(this);
                        switch (getInterpreter().adaptivePredict(_input, 103, _ctx)) {
                            case 1: {
                                setState(943);
                                ident();
                                setState(944);
                                match(T_EQUAL);
                            }
                                break;
                        }
                        setState(948);
                        expr(0);
                        setState(950);
                        _errHandler.sync(this);
                        switch (getInterpreter().adaptivePredict(_input, 104, _ctx)) {
                            case 1: {
                                setState(949);
                                selectListAlias();
                            }
                                break;
                        }
                    }
                        break;
                    case 2: {
                        setState(952);
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
            return getToken(CupidDBSqlParser.T_AS, 0);
        }

        public TerminalNode T_OPEN_P() {
            return getToken(CupidDBSqlParser.T_OPEN_P, 0);
        }

        public TerminalNode T_CLOSE_P() {
            return getToken(CupidDBSqlParser.T_CLOSE_P, 0);
        }

        public List<TerminalNode> T_COMMA() {
            return getTokens(CupidDBSqlParser.T_COMMA);
        }

        public TerminalNode T_COMMA(int i) {
            return getToken(CupidDBSqlParser.T_COMMA, i);
        }

        public TerminalNode T_TITLE() {
            return getToken(CupidDBSqlParser.T_TITLE, 0);
        }

        public TerminalNode L_S_STRING() {
            return getToken(CupidDBSqlParser.L_S_STRING, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitSelectListAlias(this);
            else return visitor.visitChildren(this);
        }
    }

    public final SelectListAliasContext selectListAlias() throws RecognitionException {
        SelectListAliasContext _localctx = new SelectListAliasContext(_ctx, getState());
        enterRule(_localctx, 118, RULE_selectListAlias);
        int _la;
        try {
            setState(977);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 109, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1); {
                    setState(956);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 106, _ctx)) {
                        case 1: {
                            setState(955);
                            match(T_AS);
                        }
                            break;
                    }
                    setState(958);
                    ident();
                }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2); {
                    setState(960);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_AS) {
                        {
                            setState(959);
                            match(T_AS);
                        }
                    }

                    setState(962);
                    match(T_OPEN_P);
                    setState(963);
                    ident();
                    setState(968);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == T_COMMA) {
                        {
                            {
                                setState(964);
                                match(T_COMMA);
                                setState(965);
                                ident();
                            }
                        }
                        setState(970);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                    setState(971);
                    match(T_CLOSE_P);
                }
                    break;
                case 3:
                    enterOuterAlt(_localctx, 3); {
                    setState(973);
                    match(T_OPEN_P);
                    setState(974);
                    match(T_TITLE);
                    setState(975);
                    match(L_S_STRING);
                    setState(976);
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
            return getToken(CupidDBSqlParser.T_MUL, 0);
        }

        public TerminalNode L_ID() {
            return getToken(CupidDBSqlParser.L_ID, 0);
        }

        public TerminalNode T_DOT() {
            return getToken(CupidDBSqlParser.T_DOT, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitSelectListAsterisk(this);
            else return visitor.visitChildren(this);
        }
    }

    public final SelectListAsteriskContext selectListAsterisk() throws RecognitionException {
        SelectListAsteriskContext _localctx = new SelectListAsteriskContext(_ctx, getState());
        enterRule(_localctx, 120, RULE_selectListAsterisk);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(981);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == L_ID) {
                    {
                        setState(979);
                        match(L_ID);
                        setState(980);
                        match(T_DOT);
                    }
                }

                setState(983);
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
            return getToken(CupidDBSqlParser.T_INTO, 0);
        }

        public List<IdentContext> ident() {
            return getRuleContexts(IdentContext.class);
        }

        public IdentContext ident(int i) {
            return getRuleContext(IdentContext.class, i);
        }

        public List<TerminalNode> T_COMMA() {
            return getTokens(CupidDBSqlParser.T_COMMA);
        }

        public TerminalNode T_COMMA(int i) {
            return getToken(CupidDBSqlParser.T_COMMA, i);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitIntoClause(this);
            else return visitor.visitChildren(this);
        }
    }

    public final IntoClauseContext intoClause() throws RecognitionException {
        IntoClauseContext _localctx = new IntoClauseContext(_ctx, getState());
        enterRule(_localctx, 122, RULE_intoClause);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(985);
                match(T_INTO);
                setState(986);
                ident();
                setState(991);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T_COMMA) {
                    {
                        {
                            setState(987);
                            match(T_COMMA);
                            setState(988);
                            ident();
                        }
                    }
                    setState(993);
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
            return getToken(CupidDBSqlParser.T_FROM, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitFromClause(this);
            else return visitor.visitChildren(this);
        }
    }

    public final FromClauseContext fromClause() throws RecognitionException {
        FromClauseContext _localctx = new FromClauseContext(_ctx, getState());
        enterRule(_localctx, 124, RULE_fromClause);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(994);
                match(T_FROM);
                setState(995);
                fromTableClause();
                setState(999);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 112, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            {
                                setState(996);
                                fromJoinClause();
                            }
                        }
                    }
                    setState(1001);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 112, _ctx);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitFromTableClause(this);
            else return visitor.visitChildren(this);
        }
    }

    public final FromTableClauseContext fromTableClause() throws RecognitionException {
        FromTableClauseContext _localctx = new FromTableClauseContext(_ctx, getState());
        enterRule(_localctx, 126, RULE_fromTableClause);
        try {
            setState(1005);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 113, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1); {
                    setState(1002);
                    fromTableNameClause();
                }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2); {
                    setState(1003);
                    fromSubselectClause();
                }
                    break;
                case 3:
                    enterOuterAlt(_localctx, 3); {
                    setState(1004);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitFromTableNameClause(this);
            else return visitor.visitChildren(this);
        }
    }

    public final FromTableNameClauseContext fromTableNameClause() throws RecognitionException {
        FromTableNameClauseContext _localctx = new FromTableNameClauseContext(_ctx, getState());
        enterRule(_localctx, 128, RULE_fromTableNameClause);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1007);
                tableName();
                setState(1009);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 114, _ctx)) {
                    case 1: {
                        setState(1008);
                        fromAliasClause();
                    }
                        break;
                }
                setState(1012);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_TABLESAMPLE) {
                    {
                        setState(1011);
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
            return getToken(CupidDBSqlParser.T_OPEN_P, 0);
        }

        public SelectStmtContext selectStmt() {
            return getRuleContext(SelectStmtContext.class, 0);
        }

        public TerminalNode T_CLOSE_P() {
            return getToken(CupidDBSqlParser.T_CLOSE_P, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitFromSubselectClause(this);
            else return visitor.visitChildren(this);
        }
    }

    public final FromSubselectClauseContext fromSubselectClause() throws RecognitionException {
        FromSubselectClauseContext _localctx = new FromSubselectClauseContext(_ctx, getState());
        enterRule(_localctx, 130, RULE_fromSubselectClause);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1014);
                match(T_OPEN_P);
                setState(1015);
                selectStmt();
                setState(1016);
                match(T_CLOSE_P);
                setState(1018);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 116, _ctx)) {
                    case 1: {
                        setState(1017);
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
            return getToken(CupidDBSqlParser.T_COMMA, 0);
        }

        public FromTableClauseContext fromTableClause() {
            return getRuleContext(FromTableClauseContext.class, 0);
        }

        public FromJoinTypeClauseContext fromJoinTypeClause() {
            return getRuleContext(FromJoinTypeClauseContext.class, 0);
        }

        public TerminalNode T_ON() {
            return getToken(CupidDBSqlParser.T_ON, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitFromJoinClause(this);
            else return visitor.visitChildren(this);
        }
    }

    public final FromJoinClauseContext fromJoinClause() throws RecognitionException {
        FromJoinClauseContext _localctx = new FromJoinClauseContext(_ctx, getState());
        enterRule(_localctx, 132, RULE_fromJoinClause);
        try {
            setState(1027);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T_COMMA:
                    enterOuterAlt(_localctx, 1); {
                    setState(1020);
                    match(T_COMMA);
                    setState(1021);
                    fromTableClause();
                }
                    break;
                case T_FULL:
                case T_INNER:
                case T_JOIN:
                case T_LEFT:
                case T_RIGHT:
                    enterOuterAlt(_localctx, 2); {
                    setState(1022);
                    fromJoinTypeClause();
                    setState(1023);
                    fromTableClause();
                    setState(1024);
                    match(T_ON);
                    setState(1025);
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
            return getToken(CupidDBSqlParser.T_JOIN, 0);
        }

        public TerminalNode T_INNER() {
            return getToken(CupidDBSqlParser.T_INNER, 0);
        }

        public TerminalNode T_LEFT() {
            return getToken(CupidDBSqlParser.T_LEFT, 0);
        }

        public TerminalNode T_RIGHT() {
            return getToken(CupidDBSqlParser.T_RIGHT, 0);
        }

        public TerminalNode T_FULL() {
            return getToken(CupidDBSqlParser.T_FULL, 0);
        }

        public TerminalNode T_OUTER() {
            return getToken(CupidDBSqlParser.T_OUTER, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitFromJoinTypeClause(this);
            else return visitor.visitChildren(this);
        }
    }

    public final FromJoinTypeClauseContext fromJoinTypeClause() throws RecognitionException {
        FromJoinTypeClauseContext _localctx = new FromJoinTypeClauseContext(_ctx, getState());
        enterRule(_localctx, 134, RULE_fromJoinTypeClause);
        int _la;
        try {
            setState(1038);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T_INNER:
                case T_JOIN:
                    enterOuterAlt(_localctx, 1); {
                    setState(1030);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_INNER) {
                        {
                            setState(1029);
                            match(T_INNER);
                        }
                    }

                    setState(1032);
                    match(T_JOIN);
                }
                    break;
                case T_FULL:
                case T_LEFT:
                case T_RIGHT:
                    enterOuterAlt(_localctx, 2); {
                    setState(1033);
                    _la = _input.LA(1);
                    if (!(_la == T_FULL || _la == T_LEFT || _la == T_RIGHT)) {
                        _errHandler.recoverInline(this);
                    } else {
                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                        _errHandler.reportMatch(this);
                        consume();
                    }
                    setState(1035);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_OUTER) {
                        {
                            setState(1034);
                            match(T_OUTER);
                        }
                    }

                    setState(1037);
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
            return getToken(CupidDBSqlParser.T_TABLE, 0);
        }

        public TerminalNode T_OPEN_P() {
            return getToken(CupidDBSqlParser.T_OPEN_P, 0);
        }

        public TerminalNode T_VALUES() {
            return getToken(CupidDBSqlParser.T_VALUES, 0);
        }

        public List<FromTableValuesRowContext> fromTableValuesRow() {
            return getRuleContexts(FromTableValuesRowContext.class);
        }

        public FromTableValuesRowContext fromTableValuesRow(int i) {
            return getRuleContext(FromTableValuesRowContext.class, i);
        }

        public TerminalNode T_CLOSE_P() {
            return getToken(CupidDBSqlParser.T_CLOSE_P, 0);
        }

        public List<TerminalNode> T_COMMA() {
            return getTokens(CupidDBSqlParser.T_COMMA);
        }

        public TerminalNode T_COMMA(int i) {
            return getToken(CupidDBSqlParser.T_COMMA, i);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitFromTableValuesClause(this);
            else return visitor.visitChildren(this);
        }
    }

    public final FromTableValuesClauseContext fromTableValuesClause() throws RecognitionException {
        FromTableValuesClauseContext _localctx = new FromTableValuesClauseContext(_ctx, getState());
        enterRule(_localctx, 136, RULE_fromTableValuesClause);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1040);
                match(T_TABLE);
                setState(1041);
                match(T_OPEN_P);
                setState(1042);
                match(T_VALUES);
                setState(1043);
                fromTableValuesRow();
                setState(1048);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T_COMMA) {
                    {
                        {
                            setState(1044);
                            match(T_COMMA);
                            setState(1045);
                            fromTableValuesRow();
                        }
                    }
                    setState(1050);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(1051);
                match(T_CLOSE_P);
                setState(1053);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 122, _ctx)) {
                    case 1: {
                        setState(1052);
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
            return getToken(CupidDBSqlParser.T_OPEN_P, 0);
        }

        public TerminalNode T_CLOSE_P() {
            return getToken(CupidDBSqlParser.T_CLOSE_P, 0);
        }

        public List<TerminalNode> T_COMMA() {
            return getTokens(CupidDBSqlParser.T_COMMA);
        }

        public TerminalNode T_COMMA(int i) {
            return getToken(CupidDBSqlParser.T_COMMA, i);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitFromTableValuesRow(this);
            else return visitor.visitChildren(this);
        }
    }

    public final FromTableValuesRowContext fromTableValuesRow() throws RecognitionException {
        FromTableValuesRowContext _localctx = new FromTableValuesRowContext(_ctx, getState());
        enterRule(_localctx, 138, RULE_fromTableValuesRow);
        int _la;
        try {
            setState(1067);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 124, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1); {
                    setState(1055);
                    expr(0);
                }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2); {
                    setState(1056);
                    match(T_OPEN_P);
                    setState(1057);
                    expr(0);
                    setState(1062);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == T_COMMA) {
                        {
                            {
                                setState(1058);
                                match(T_COMMA);
                                setState(1059);
                                expr(0);
                            }
                        }
                        setState(1064);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                    setState(1065);
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
            return getToken(CupidDBSqlParser.T_AS, 0);
        }

        public TerminalNode T_OPEN_P() {
            return getToken(CupidDBSqlParser.T_OPEN_P, 0);
        }

        public List<TerminalNode> L_ID() {
            return getTokens(CupidDBSqlParser.L_ID);
        }

        public TerminalNode L_ID(int i) {
            return getToken(CupidDBSqlParser.L_ID, i);
        }

        public TerminalNode T_CLOSE_P() {
            return getToken(CupidDBSqlParser.T_CLOSE_P, 0);
        }

        public List<TerminalNode> T_COMMA() {
            return getTokens(CupidDBSqlParser.T_COMMA);
        }

        public TerminalNode T_COMMA(int i) {
            return getToken(CupidDBSqlParser.T_COMMA, i);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitFromAliasClause(this);
            else return visitor.visitChildren(this);
        }
    }

    public final FromAliasClauseContext fromAliasClause() throws RecognitionException {
        FromAliasClauseContext _localctx = new FromAliasClauseContext(_ctx, getState());
        enterRule(_localctx, 140, RULE_fromAliasClause);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1069);
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
                        "!_input.LT(1).getText().equalsIgnoreCase(\"EXEC\") &&\n        !_input.LT(1).getText().equalsIgnoreCase(\"EXECUTE\") &&\n        !_input.LT(1).getText().equalsIgnoreCase(\"INNER\") &&\n        !_input.LT(1).getText().equalsIgnoreCase(\"LEFT\") &&\n        !_input.LT(1).getText().equalsIgnoreCase(\"GROUP\") &&\n        !_input.LT(1).getText().equalsIgnoreCase(\"ORDER\") &&\n        !_input.LT(1).getText().equalsIgnoreCase(\"LIMIT\") &&\n        !_input.LT(1).getText().equalsIgnoreCase(\"WITH\")"
                    );
                setState(1071);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 125, _ctx)) {
                    case 1: {
                        setState(1070);
                        match(T_AS);
                    }
                        break;
                }
                setState(1073);
                ident();
                setState(1084);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_OPEN_P) {
                    {
                        setState(1074);
                        match(T_OPEN_P);
                        setState(1075);
                        match(L_ID);
                        setState(1080);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        while (_la == T_COMMA) {
                            {
                                {
                                    setState(1076);
                                    match(T_COMMA);
                                    setState(1077);
                                    match(L_ID);
                                }
                            }
                            setState(1082);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                        }
                        setState(1083);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitTableName(this);
            else return visitor.visitChildren(this);
        }
    }

    public final TableNameContext tableName() throws RecognitionException {
        TableNameContext _localctx = new TableNameContext(_ctx, getState());
        enterRule(_localctx, 142, RULE_tableName);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1086);
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
            return getToken(CupidDBSqlParser.T_WHERE, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitWhereClause(this);
            else return visitor.visitChildren(this);
        }
    }

    public final WhereClauseContext whereClause() throws RecognitionException {
        WhereClauseContext _localctx = new WhereClauseContext(_ctx, getState());
        enterRule(_localctx, 144, RULE_whereClause);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1088);
                match(T_WHERE);
                setState(1089);
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
            return getToken(CupidDBSqlParser.T_GROUP, 0);
        }

        public TerminalNode T_BY() {
            return getToken(CupidDBSqlParser.T_BY, 0);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public List<TerminalNode> T_COMMA() {
            return getTokens(CupidDBSqlParser.T_COMMA);
        }

        public TerminalNode T_COMMA(int i) {
            return getToken(CupidDBSqlParser.T_COMMA, i);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitGroupByClause(this);
            else return visitor.visitChildren(this);
        }
    }

    public final GroupByClauseContext groupByClause() throws RecognitionException {
        GroupByClauseContext _localctx = new GroupByClauseContext(_ctx, getState());
        enterRule(_localctx, 146, RULE_groupByClause);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1091);
                match(T_GROUP);
                setState(1092);
                match(T_BY);
                setState(1093);
                expr(0);
                setState(1098);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T_COMMA) {
                    {
                        {
                            setState(1094);
                            match(T_COMMA);
                            setState(1095);
                            expr(0);
                        }
                    }
                    setState(1100);
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
            return getToken(CupidDBSqlParser.T_HAVING, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitHavingClause(this);
            else return visitor.visitChildren(this);
        }
    }

    public final HavingClauseContext havingClause() throws RecognitionException {
        HavingClauseContext _localctx = new HavingClauseContext(_ctx, getState());
        enterRule(_localctx, 148, RULE_havingClause);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1101);
                match(T_HAVING);
                setState(1102);
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
            return getToken(CupidDBSqlParser.T_QUALIFY, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitQualifyClause(this);
            else return visitor.visitChildren(this);
        }
    }

    public final QualifyClauseContext qualifyClause() throws RecognitionException {
        QualifyClauseContext _localctx = new QualifyClauseContext(_ctx, getState());
        enterRule(_localctx, 150, RULE_qualifyClause);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1104);
                match(T_QUALIFY);
                setState(1105);
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
            return getToken(CupidDBSqlParser.T_ORDER, 0);
        }

        public TerminalNode T_BY() {
            return getToken(CupidDBSqlParser.T_BY, 0);
        }

        public List<OrderByClauseItemContext> orderByClauseItem() {
            return getRuleContexts(OrderByClauseItemContext.class);
        }

        public OrderByClauseItemContext orderByClauseItem(int i) {
            return getRuleContext(OrderByClauseItemContext.class, i);
        }

        public List<TerminalNode> T_COMMA() {
            return getTokens(CupidDBSqlParser.T_COMMA);
        }

        public TerminalNode T_COMMA(int i) {
            return getToken(CupidDBSqlParser.T_COMMA, i);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitOrderByClause(this);
            else return visitor.visitChildren(this);
        }
    }

    public final OrderByClauseContext orderByClause() throws RecognitionException {
        OrderByClauseContext _localctx = new OrderByClauseContext(_ctx, getState());
        enterRule(_localctx, 152, RULE_orderByClause);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1107);
                match(T_ORDER);
                setState(1108);
                match(T_BY);
                setState(1109);
                orderByClauseItem();
                setState(1114);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T_COMMA) {
                    {
                        {
                            setState(1110);
                            match(T_COMMA);
                            setState(1111);
                            orderByClauseItem();
                        }
                    }
                    setState(1116);
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
            return getToken(CupidDBSqlParser.T_ASC, 0);
        }

        public TerminalNode T_DESC() {
            return getToken(CupidDBSqlParser.T_DESC, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitOrderByClauseItem(this);
            else return visitor.visitChildren(this);
        }
    }

    public final OrderByClauseItemContext orderByClauseItem() throws RecognitionException {
        OrderByClauseItemContext _localctx = new OrderByClauseItemContext(_ctx, getState());
        enterRule(_localctx, 154, RULE_orderByClauseItem);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1117);
                expr(0);
                setState(1119);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_ASC || _la == T_DESC) {
                    {
                        setState(1118);
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
            return getToken(CupidDBSqlParser.T_TABLESAMPLE, 0);
        }

        public TerminalNode T_OPEN_P() {
            return getToken(CupidDBSqlParser.T_OPEN_P, 0);
        }

        public TerminalNode L_INT() {
            return getToken(CupidDBSqlParser.L_INT, 0);
        }

        public TerminalNode T_PERCENT() {
            return getToken(CupidDBSqlParser.T_PERCENT, 0);
        }

        public TerminalNode T_CLOSE_P() {
            return getToken(CupidDBSqlParser.T_CLOSE_P, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitSampleClause(this);
            else return visitor.visitChildren(this);
        }
    }

    public final SampleClauseContext sampleClause() throws RecognitionException {
        SampleClauseContext _localctx = new SampleClauseContext(_ctx, getState());
        enterRule(_localctx, 156, RULE_sampleClause);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1121);
                match(T_TABLESAMPLE);
                setState(1122);
                match(T_OPEN_P);
                setState(1123);
                match(L_INT);
                setState(1124);
                match(T_PERCENT);
                setState(1125);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitSelectOptions(this);
            else return visitor.visitChildren(this);
        }
    }

    public final SelectOptionsContext selectOptions() throws RecognitionException {
        SelectOptionsContext _localctx = new SelectOptionsContext(_ctx, getState());
        enterRule(_localctx, 158, RULE_selectOptions);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1128);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        {
                            setState(1127);
                            selectOptionsItem();
                        }
                    }
                    setState(1130);
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
            return getToken(CupidDBSqlParser.T_LIMIT, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode T_WITH() {
            return getToken(CupidDBSqlParser.T_WITH, 0);
        }

        public TerminalNode T_RR() {
            return getToken(CupidDBSqlParser.T_RR, 0);
        }

        public TerminalNode T_RS() {
            return getToken(CupidDBSqlParser.T_RS, 0);
        }

        public TerminalNode T_CS() {
            return getToken(CupidDBSqlParser.T_CS, 0);
        }

        public TerminalNode T_UR() {
            return getToken(CupidDBSqlParser.T_UR, 0);
        }

        public TerminalNode T_USE() {
            return getToken(CupidDBSqlParser.T_USE, 0);
        }

        public TerminalNode T_AND() {
            return getToken(CupidDBSqlParser.T_AND, 0);
        }

        public TerminalNode T_KEEP() {
            return getToken(CupidDBSqlParser.T_KEEP, 0);
        }

        public TerminalNode T_LOCKS() {
            return getToken(CupidDBSqlParser.T_LOCKS, 0);
        }

        public TerminalNode T_EXCLUSIVE() {
            return getToken(CupidDBSqlParser.T_EXCLUSIVE, 0);
        }

        public TerminalNode T_UPDATE() {
            return getToken(CupidDBSqlParser.T_UPDATE, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitSelectOptionsItem(this);
            else return visitor.visitChildren(this);
        }
    }

    public final SelectOptionsItemContext selectOptionsItem() throws RecognitionException {
        SelectOptionsItemContext _localctx = new SelectOptionsItemContext(_ctx, getState());
        enterRule(_localctx, 160, RULE_selectOptionsItem);
        int _la;
        try {
            setState(1143);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T_LIMIT:
                    enterOuterAlt(_localctx, 1); {
                    setState(1132);
                    match(T_LIMIT);
                    setState(1133);
                    expr(0);
                }
                    break;
                case T_WITH:
                    enterOuterAlt(_localctx, 2); {
                    setState(1134);
                    match(T_WITH);
                    setState(1135);
                    _la = _input.LA(1);
                    if (!(_la == T_CS || _la == T_RR || _la == T_RS || _la == T_UR)) {
                        _errHandler.recoverInline(this);
                    } else {
                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                        _errHandler.reportMatch(this);
                        consume();
                    }
                    setState(1141);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_USE) {
                        {
                            setState(1136);
                            match(T_USE);
                            setState(1137);
                            match(T_AND);
                            setState(1138);
                            match(T_KEEP);
                            setState(1139);
                            _la = _input.LA(1);
                            if (!(_la == T_EXCLUSIVE || _la == T_UPDATE)) {
                                _errHandler.recoverInline(this);
                            } else {
                                if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                _errHandler.reportMatch(this);
                                consume();
                            }
                            setState(1140);
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
            return getToken(CupidDBSqlParser.T_UPDATE, 0);
        }

        public UpdateTableContext updateTable() {
            return getRuleContext(UpdateTableContext.class, 0);
        }

        public TerminalNode T_SET() {
            return getToken(CupidDBSqlParser.T_SET, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitUpdateStmt(this);
            else return visitor.visitChildren(this);
        }
    }

    public final UpdateStmtContext updateStmt() throws RecognitionException {
        UpdateStmtContext _localctx = new UpdateStmtContext(_ctx, getState());
        enterRule(_localctx, 162, RULE_updateStmt);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1145);
                match(T_UPDATE);
                setState(1146);
                updateTable();
                setState(1147);
                match(T_SET);
                setState(1148);
                updateAssignment();
                setState(1150);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_WHERE) {
                    {
                        setState(1149);
                        whereClause();
                    }
                }

                setState(1153);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_ELSE) {
                    {
                        setState(1152);
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
            return getTokens(CupidDBSqlParser.T_COMMA);
        }

        public TerminalNode T_COMMA(int i) {
            return getToken(CupidDBSqlParser.T_COMMA, i);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitUpdateAssignment(this);
            else return visitor.visitChildren(this);
        }
    }

    public final UpdateAssignmentContext updateAssignment() throws RecognitionException {
        UpdateAssignmentContext _localctx = new UpdateAssignmentContext(_ctx, getState());
        enterRule(_localctx, 164, RULE_updateAssignment);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1155);
                assignmentStmtItem();
                setState(1160);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T_COMMA) {
                    {
                        {
                            setState(1156);
                            match(T_COMMA);
                            setState(1157);
                            assignmentStmtItem();
                        }
                    }
                    setState(1162);
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
            return getToken(CupidDBSqlParser.T_OPEN_P, 0);
        }

        public SelectStmtContext selectStmt() {
            return getRuleContext(SelectStmtContext.class, 0);
        }

        public TerminalNode T_CLOSE_P() {
            return getToken(CupidDBSqlParser.T_CLOSE_P, 0);
        }

        public IdentContext ident() {
            return getRuleContext(IdentContext.class, 0);
        }

        public FromClauseContext fromClause() {
            return getRuleContext(FromClauseContext.class, 0);
        }

        public TerminalNode T_AS() {
            return getToken(CupidDBSqlParser.T_AS, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitUpdateTable(this);
            else return visitor.visitChildren(this);
        }
    }

    public final UpdateTableContext updateTable() throws RecognitionException {
        UpdateTableContext _localctx = new UpdateTableContext(_ctx, getState());
        enterRule(_localctx, 166, RULE_updateTable);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1171);
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
                        setState(1163);
                        tableName();
                        setState(1165);
                        _errHandler.sync(this);
                        switch (getInterpreter().adaptivePredict(_input, 137, _ctx)) {
                            case 1: {
                                setState(1164);
                                fromClause();
                            }
                                break;
                        }
                    }
                        break;
                    case T_OPEN_P: {
                        setState(1167);
                        match(T_OPEN_P);
                        setState(1168);
                        selectStmt();
                        setState(1169);
                        match(T_CLOSE_P);
                    }
                        break;
                    default:
                        throw new NoViableAltException(this);
                }
                setState(1177);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 140, _ctx)) {
                    case 1: {
                        setState(1174);
                        _errHandler.sync(this);
                        switch (getInterpreter().adaptivePredict(_input, 139, _ctx)) {
                            case 1: {
                                setState(1173);
                                match(T_AS);
                            }
                                break;
                        }
                        setState(1176);
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
            return getToken(CupidDBSqlParser.T_ELSE, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitUpdateUpsert(this);
            else return visitor.visitChildren(this);
        }
    }

    public final UpdateUpsertContext updateUpsert() throws RecognitionException {
        UpdateUpsertContext _localctx = new UpdateUpsertContext(_ctx, getState());
        enterRule(_localctx, 168, RULE_updateUpsert);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1179);
                match(T_ELSE);
                setState(1180);
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
            return getToken(CupidDBSqlParser.T_DELETE, 0);
        }

        public TableNameContext tableName() {
            return getRuleContext(TableNameContext.class, 0);
        }

        public TerminalNode T_FROM() {
            return getToken(CupidDBSqlParser.T_FROM, 0);
        }

        public DeleteAliasContext deleteAlias() {
            return getRuleContext(DeleteAliasContext.class, 0);
        }

        public WhereClauseContext whereClause() {
            return getRuleContext(WhereClauseContext.class, 0);
        }

        public TerminalNode T_ALL() {
            return getToken(CupidDBSqlParser.T_ALL, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitDeleteStmt(this);
            else return visitor.visitChildren(this);
        }
    }

    public final DeleteStmtContext deleteStmt() throws RecognitionException {
        DeleteStmtContext _localctx = new DeleteStmtContext(_ctx, getState());
        enterRule(_localctx, 170, RULE_deleteStmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1182);
                match(T_DELETE);
                setState(1184);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 141, _ctx)) {
                    case 1: {
                        setState(1183);
                        match(T_FROM);
                    }
                        break;
                }
                setState(1186);
                tableName();
                setState(1188);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 142, _ctx)) {
                    case 1: {
                        setState(1187);
                        deleteAlias();
                    }
                        break;
                }
                setState(1192);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case T_WHERE: {
                        setState(1190);
                        whereClause();
                    }
                        break;
                    case T_ALL: {
                        setState(1191);
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
            return getToken(CupidDBSqlParser.T_AS, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitDeleteAlias(this);
            else return visitor.visitChildren(this);
        }
    }

    public final DeleteAliasContext deleteAlias() throws RecognitionException {
        DeleteAliasContext _localctx = new DeleteAliasContext(_ctx, getState());
        enterRule(_localctx, 172, RULE_deleteAlias);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1194);
                if (!(!_input.LT(1).getText().equalsIgnoreCase("ALL")))
                    throw new FailedPredicateException(
                        this,
                        "!_input.LT(1).getText().equalsIgnoreCase(\"ALL\")"
                    );
                setState(1196);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 144, _ctx)) {
                    case 1: {
                        setState(1195);
                        match(T_AS);
                    }
                        break;
                }
                setState(1198);
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
            return getToken(CupidDBSqlParser.T_DESCRIBE, 0);
        }

        public TerminalNode T_DESC() {
            return getToken(CupidDBSqlParser.T_DESC, 0);
        }

        public TerminalNode T_TABLE() {
            return getToken(CupidDBSqlParser.T_TABLE, 0);
        }

        public TerminalNode T_VIEW() {
            return getToken(CupidDBSqlParser.T_VIEW, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitDescribeStmt(this);
            else return visitor.visitChildren(this);
        }
    }

    public final DescribeStmtContext describeStmt() throws RecognitionException {
        DescribeStmtContext _localctx = new DescribeStmtContext(_ctx, getState());
        enterRule(_localctx, 174, RULE_describeStmt);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1200);
                _la = _input.LA(1);
                if (!(_la == T_DESC || _la == T_DESCRIBE)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
                setState(1202);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_TABLE || _la == T_VIEW) {
                    {
                        setState(1201);
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

                setState(1204);
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
            return getToken(CupidDBSqlParser.T_OPEN_P, 0);
        }

        public List<BoolExprContext> boolExpr() {
            return getRuleContexts(BoolExprContext.class);
        }

        public BoolExprContext boolExpr(int i) {
            return getRuleContext(BoolExprContext.class, i);
        }

        public TerminalNode T_CLOSE_P() {
            return getToken(CupidDBSqlParser.T_CLOSE_P, 0);
        }

        public TerminalNode T_NOT() {
            return getToken(CupidDBSqlParser.T_NOT, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
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
        int _startState = 176;
        enterRecursionRule(_localctx, 176, RULE_boolExpr, _p);
        int _la;
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(1215);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 147, _ctx)) {
                    case 1: {
                        setState(1208);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        if (_la == T_NOT) {
                            {
                                setState(1207);
                                match(T_NOT);
                            }
                        }

                        setState(1210);
                        match(T_OPEN_P);
                        setState(1211);
                        boolExpr(0);
                        setState(1212);
                        match(T_CLOSE_P);
                    }
                        break;
                    case 2: {
                        setState(1214);
                        boolExprAtom();
                    }
                        break;
                }
                _ctx.stop = _input.LT(-1);
                setState(1223);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 148, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        if (_parseListeners != null) triggerExitRuleEvent();
                        _prevctx = _localctx;
                        {
                            {
                                _localctx = new BoolExprContext(_parentctx, _parentState);
                                pushNewRecursionContext(_localctx, _startState, RULE_boolExpr);
                                setState(1217);
                                if (!(precpred(_ctx, 2))) throw new FailedPredicateException(
                                    this,
                                    "precpred(_ctx, 2)"
                                );
                                setState(1218);
                                boolExprLogicalOperator();
                                setState(1219);
                                boolExpr(3);
                            }
                        }
                    }
                    setState(1225);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 148, _ctx);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitBoolExprAtom(this);
            else return visitor.visitChildren(this);
        }
    }

    public final BoolExprAtomContext boolExprAtom() throws RecognitionException {
        BoolExprAtomContext _localctx = new BoolExprAtomContext(_ctx, getState());
        enterRule(_localctx, 178, RULE_boolExprAtom);
        try {
            setState(1229);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 149, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1); {
                    setState(1226);
                    boolExprUnary();
                }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2); {
                    setState(1227);
                    boolExprBinary();
                }
                    break;
                case 3:
                    enterOuterAlt(_localctx, 3); {
                    setState(1228);
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
            return getToken(CupidDBSqlParser.T_IS, 0);
        }

        public TerminalNode T_NULL() {
            return getToken(CupidDBSqlParser.T_NULL, 0);
        }

        public TerminalNode T_NOT() {
            return getToken(CupidDBSqlParser.T_NOT, 0);
        }

        public TerminalNode T_BETWEEN() {
            return getToken(CupidDBSqlParser.T_BETWEEN, 0);
        }

        public TerminalNode T_AND() {
            return getToken(CupidDBSqlParser.T_AND, 0);
        }

        public TerminalNode T_EXISTS() {
            return getToken(CupidDBSqlParser.T_EXISTS, 0);
        }

        public TerminalNode T_OPEN_P() {
            return getToken(CupidDBSqlParser.T_OPEN_P, 0);
        }

        public SelectStmtContext selectStmt() {
            return getRuleContext(SelectStmtContext.class, 0);
        }

        public TerminalNode T_CLOSE_P() {
            return getToken(CupidDBSqlParser.T_CLOSE_P, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitBoolExprUnary(this);
            else return visitor.visitChildren(this);
        }
    }

    public final BoolExprUnaryContext boolExprUnary() throws RecognitionException {
        BoolExprUnaryContext _localctx = new BoolExprUnaryContext(_ctx, getState());
        enterRule(_localctx, 180, RULE_boolExprUnary);
        int _la;
        try {
            setState(1254);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 152, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1); {
                    setState(1231);
                    expr(0);
                    setState(1232);
                    match(T_IS);
                    setState(1234);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_NOT) {
                        {
                            setState(1233);
                            match(T_NOT);
                        }
                    }

                    setState(1236);
                    match(T_NULL);
                }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2); {
                    setState(1238);
                    expr(0);
                    setState(1239);
                    match(T_BETWEEN);
                    setState(1240);
                    expr(0);
                    setState(1241);
                    match(T_AND);
                    setState(1242);
                    expr(0);
                }
                    break;
                case 3:
                    enterOuterAlt(_localctx, 3); {
                    setState(1245);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_NOT) {
                        {
                            setState(1244);
                            match(T_NOT);
                        }
                    }

                    setState(1247);
                    match(T_EXISTS);
                    setState(1248);
                    match(T_OPEN_P);
                    setState(1249);
                    selectStmt();
                    setState(1250);
                    match(T_CLOSE_P);
                }
                    break;
                case 4:
                    enterOuterAlt(_localctx, 4); {
                    setState(1252);
                    boolExprSingleIn();
                }
                    break;
                case 5:
                    enterOuterAlt(_localctx, 5); {
                    setState(1253);
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
            return getToken(CupidDBSqlParser.T_IN, 0);
        }

        public TerminalNode T_OPEN_P() {
            return getToken(CupidDBSqlParser.T_OPEN_P, 0);
        }

        public TerminalNode T_CLOSE_P() {
            return getToken(CupidDBSqlParser.T_CLOSE_P, 0);
        }

        public SelectStmtContext selectStmt() {
            return getRuleContext(SelectStmtContext.class, 0);
        }

        public TerminalNode T_NOT() {
            return getToken(CupidDBSqlParser.T_NOT, 0);
        }

        public List<TerminalNode> T_COMMA() {
            return getTokens(CupidDBSqlParser.T_COMMA);
        }

        public TerminalNode T_COMMA(int i) {
            return getToken(CupidDBSqlParser.T_COMMA, i);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitBoolExprSingleIn(this);
            else return visitor.visitChildren(this);
        }
    }

    public final BoolExprSingleInContext boolExprSingleIn() throws RecognitionException {
        BoolExprSingleInContext _localctx = new BoolExprSingleInContext(_ctx, getState());
        enterRule(_localctx, 182, RULE_boolExprSingleIn);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1256);
                expr(0);
                setState(1258);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_NOT) {
                    {
                        setState(1257);
                        match(T_NOT);
                    }
                }

                setState(1260);
                match(T_IN);
                setState(1261);
                match(T_OPEN_P);
                setState(1271);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 155, _ctx)) {
                    case 1: {
                        {
                            setState(1262);
                            expr(0);
                            setState(1267);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                            while (_la == T_COMMA) {
                                {
                                    {
                                        setState(1263);
                                        match(T_COMMA);
                                        setState(1264);
                                        expr(0);
                                    }
                                }
                                setState(1269);
                                _errHandler.sync(this);
                                _la = _input.LA(1);
                            }
                        }
                    }
                        break;
                    case 2: {
                        setState(1270);
                        selectStmt();
                    }
                        break;
                }
                setState(1273);
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
            return getTokens(CupidDBSqlParser.T_OPEN_P);
        }

        public TerminalNode T_OPEN_P(int i) {
            return getToken(CupidDBSqlParser.T_OPEN_P, i);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public List<TerminalNode> T_CLOSE_P() {
            return getTokens(CupidDBSqlParser.T_CLOSE_P);
        }

        public TerminalNode T_CLOSE_P(int i) {
            return getToken(CupidDBSqlParser.T_CLOSE_P, i);
        }

        public TerminalNode T_IN() {
            return getToken(CupidDBSqlParser.T_IN, 0);
        }

        public SelectStmtContext selectStmt() {
            return getRuleContext(SelectStmtContext.class, 0);
        }

        public List<TerminalNode> T_COMMA() {
            return getTokens(CupidDBSqlParser.T_COMMA);
        }

        public TerminalNode T_COMMA(int i) {
            return getToken(CupidDBSqlParser.T_COMMA, i);
        }

        public TerminalNode T_NOT() {
            return getToken(CupidDBSqlParser.T_NOT, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitBoolExprMultiIn(this);
            else return visitor.visitChildren(this);
        }
    }

    public final BoolExprMultiInContext boolExprMultiIn() throws RecognitionException {
        BoolExprMultiInContext _localctx = new BoolExprMultiInContext(_ctx, getState());
        enterRule(_localctx, 184, RULE_boolExprMultiIn);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1275);
                match(T_OPEN_P);
                setState(1276);
                expr(0);
                setState(1281);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T_COMMA) {
                    {
                        {
                            setState(1277);
                            match(T_COMMA);
                            setState(1278);
                            expr(0);
                        }
                    }
                    setState(1283);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(1284);
                match(T_CLOSE_P);
                setState(1286);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_NOT) {
                    {
                        setState(1285);
                        match(T_NOT);
                    }
                }

                setState(1288);
                match(T_IN);
                setState(1289);
                match(T_OPEN_P);
                setState(1290);
                selectStmt();
                setState(1291);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitBoolExprBinary(this);
            else return visitor.visitChildren(this);
        }
    }

    public final BoolExprBinaryContext boolExprBinary() throws RecognitionException {
        BoolExprBinaryContext _localctx = new BoolExprBinaryContext(_ctx, getState());
        enterRule(_localctx, 186, RULE_boolExprBinary);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1293);
                expr(0);
                setState(1294);
                boolExprBinaryOperator();
                setState(1295);
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
            return getToken(CupidDBSqlParser.T_AND, 0);
        }

        public TerminalNode T_OR() {
            return getToken(CupidDBSqlParser.T_OR, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
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
        enterRule(_localctx, 188, RULE_boolExprLogicalOperator);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1297);
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
            return getToken(CupidDBSqlParser.T_EQUAL, 0);
        }

        public TerminalNode T_EQUAL2() {
            return getToken(CupidDBSqlParser.T_EQUAL2, 0);
        }

        public TerminalNode T_NOTEQUAL() {
            return getToken(CupidDBSqlParser.T_NOTEQUAL, 0);
        }

        public TerminalNode T_NOTEQUAL2() {
            return getToken(CupidDBSqlParser.T_NOTEQUAL2, 0);
        }

        public TerminalNode T_LESS() {
            return getToken(CupidDBSqlParser.T_LESS, 0);
        }

        public TerminalNode T_LESSEQUAL() {
            return getToken(CupidDBSqlParser.T_LESSEQUAL, 0);
        }

        public TerminalNode T_GREATER() {
            return getToken(CupidDBSqlParser.T_GREATER, 0);
        }

        public TerminalNode T_GREATEREQUAL() {
            return getToken(CupidDBSqlParser.T_GREATEREQUAL, 0);
        }

        public TerminalNode T_LIKE() {
            return getToken(CupidDBSqlParser.T_LIKE, 0);
        }

        public TerminalNode T_RLIKE() {
            return getToken(CupidDBSqlParser.T_RLIKE, 0);
        }

        public TerminalNode T_REGEXP() {
            return getToken(CupidDBSqlParser.T_REGEXP, 0);
        }

        public TerminalNode T_NOT() {
            return getToken(CupidDBSqlParser.T_NOT, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
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
        enterRule(_localctx, 190, RULE_boolExprBinaryOperator);
        int _la;
        try {
            setState(1311);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T_EQUAL:
                    enterOuterAlt(_localctx, 1); {
                    setState(1299);
                    match(T_EQUAL);
                }
                    break;
                case T_EQUAL2:
                    enterOuterAlt(_localctx, 2); {
                    setState(1300);
                    match(T_EQUAL2);
                }
                    break;
                case T_NOTEQUAL:
                    enterOuterAlt(_localctx, 3); {
                    setState(1301);
                    match(T_NOTEQUAL);
                }
                    break;
                case T_NOTEQUAL2:
                    enterOuterAlt(_localctx, 4); {
                    setState(1302);
                    match(T_NOTEQUAL2);
                }
                    break;
                case T_LESS:
                    enterOuterAlt(_localctx, 5); {
                    setState(1303);
                    match(T_LESS);
                }
                    break;
                case T_LESSEQUAL:
                    enterOuterAlt(_localctx, 6); {
                    setState(1304);
                    match(T_LESSEQUAL);
                }
                    break;
                case T_GREATER:
                    enterOuterAlt(_localctx, 7); {
                    setState(1305);
                    match(T_GREATER);
                }
                    break;
                case T_GREATEREQUAL:
                    enterOuterAlt(_localctx, 8); {
                    setState(1306);
                    match(T_GREATEREQUAL);
                }
                    break;
                case T_LIKE:
                case T_NOT:
                case T_REGEXP:
                case T_RLIKE:
                    enterOuterAlt(_localctx, 9); {
                    setState(1308);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_NOT) {
                        {
                            setState(1307);
                            match(T_NOT);
                        }
                    }

                    setState(1310);
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
            return getToken(CupidDBSqlParser.T_OPEN_P, 0);
        }

        public SelectStmtContext selectStmt() {
            return getRuleContext(SelectStmtContext.class, 0);
        }

        public TerminalNode T_CLOSE_P() {
            return getToken(CupidDBSqlParser.T_CLOSE_P, 0);
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
            return getToken(CupidDBSqlParser.T_MUL, 0);
        }

        public TerminalNode T_DIV() {
            return getToken(CupidDBSqlParser.T_DIV, 0);
        }

        public TerminalNode T_ADD() {
            return getToken(CupidDBSqlParser.T_ADD, 0);
        }

        public TerminalNode T_SUB() {
            return getToken(CupidDBSqlParser.T_SUB, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
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
        int _startState = 192;
        enterRecursionRule(_localctx, 192, RULE_expr, _p);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(1330);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 160, _ctx)) {
                    case 1: {
                        setState(1314);
                        match(T_OPEN_P);
                        setState(1315);
                        selectStmt();
                        setState(1316);
                        match(T_CLOSE_P);
                    }
                        break;
                    case 2: {
                        setState(1318);
                        match(T_OPEN_P);
                        setState(1319);
                        expr(0);
                        setState(1320);
                        match(T_CLOSE_P);
                    }
                        break;
                    case 3: {
                        setState(1322);
                        exprInterval();
                    }
                        break;
                    case 4: {
                        setState(1323);
                        exprConcat();
                    }
                        break;
                    case 5: {
                        setState(1324);
                        exprCase();
                    }
                        break;
                    case 6: {
                        setState(1325);
                        exprCursorAttribute();
                    }
                        break;
                    case 7: {
                        setState(1326);
                        exprAggWindowFunc();
                    }
                        break;
                    case 8: {
                        setState(1327);
                        exprSpecFunc();
                    }
                        break;
                    case 9: {
                        setState(1328);
                        exprFunc();
                    }
                        break;
                    case 10: {
                        setState(1329);
                        exprAtom();
                    }
                        break;
                }
                _ctx.stop = _input.LT(-1);
                setState(1348);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 162, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        if (_parseListeners != null) triggerExitRuleEvent();
                        _prevctx = _localctx;
                        {
                            setState(1346);
                            _errHandler.sync(this);
                            switch (getInterpreter().adaptivePredict(_input, 161, _ctx)) {
                                case 1: {
                                    _localctx = new ExprContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr);
                                    setState(1332);
                                    if (!(precpred(_ctx, 14))) throw new FailedPredicateException(
                                        this,
                                        "precpred(_ctx, 14)"
                                    );
                                    setState(1333);
                                    match(T_MUL);
                                    setState(1334);
                                    expr(15);
                                }
                                    break;
                                case 2: {
                                    _localctx = new ExprContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr);
                                    setState(1335);
                                    if (!(precpred(_ctx, 13))) throw new FailedPredicateException(
                                        this,
                                        "precpred(_ctx, 13)"
                                    );
                                    setState(1336);
                                    match(T_DIV);
                                    setState(1337);
                                    expr(14);
                                }
                                    break;
                                case 3: {
                                    _localctx = new ExprContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr);
                                    setState(1338);
                                    if (!(precpred(_ctx, 12))) throw new FailedPredicateException(
                                        this,
                                        "precpred(_ctx, 12)"
                                    );
                                    setState(1339);
                                    match(T_ADD);
                                    setState(1340);
                                    expr(13);
                                }
                                    break;
                                case 4: {
                                    _localctx = new ExprContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr);
                                    setState(1341);
                                    if (!(precpred(_ctx, 11))) throw new FailedPredicateException(
                                        this,
                                        "precpred(_ctx, 11)"
                                    );
                                    setState(1342);
                                    match(T_SUB);
                                    setState(1343);
                                    expr(12);
                                }
                                    break;
                                case 5: {
                                    _localctx = new ExprContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr);
                                    setState(1344);
                                    if (!(precpred(_ctx, 15))) throw new FailedPredicateException(
                                        this,
                                        "precpred(_ctx, 15)"
                                    );
                                    setState(1345);
                                    intervalItem();
                                }
                                    break;
                            }
                        }
                    }
                    setState(1350);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 162, _ctx);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitExprAtom(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ExprAtomContext exprAtom() throws RecognitionException {
        ExprAtomContext _localctx = new ExprAtomContext(_ctx, getState());
        enterRule(_localctx, 194, RULE_exprAtom);
        try {
            setState(1359);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 163, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1); {
                    setState(1351);
                    dateLiteral();
                }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2); {
                    setState(1352);
                    timestampLiteral();
                }
                    break;
                case 3:
                    enterOuterAlt(_localctx, 3); {
                    setState(1353);
                    boolLiteral();
                }
                    break;
                case 4:
                    enterOuterAlt(_localctx, 4); {
                    setState(1354);
                    ident();
                }
                    break;
                case 5:
                    enterOuterAlt(_localctx, 5); {
                    setState(1355);
                    string();
                }
                    break;
                case 6:
                    enterOuterAlt(_localctx, 6); {
                    setState(1356);
                    decNumber();
                }
                    break;
                case 7:
                    enterOuterAlt(_localctx, 7); {
                    setState(1357);
                    intNumber();
                }
                    break;
                case 8:
                    enterOuterAlt(_localctx, 8); {
                    setState(1358);
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
            return getToken(CupidDBSqlParser.T_INTERVAL, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitExprInterval(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ExprIntervalContext exprInterval() throws RecognitionException {
        ExprIntervalContext _localctx = new ExprIntervalContext(_ctx, getState());
        enterRule(_localctx, 196, RULE_exprInterval);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1361);
                match(T_INTERVAL);
                setState(1362);
                expr(0);
                setState(1363);
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
            return getToken(CupidDBSqlParser.T_DAY, 0);
        }

        public TerminalNode T_DAYS() {
            return getToken(CupidDBSqlParser.T_DAYS, 0);
        }

        public TerminalNode T_MICROSECOND() {
            return getToken(CupidDBSqlParser.T_MICROSECOND, 0);
        }

        public TerminalNode T_MICROSECONDS() {
            return getToken(CupidDBSqlParser.T_MICROSECONDS, 0);
        }

        public TerminalNode T_SECOND() {
            return getToken(CupidDBSqlParser.T_SECOND, 0);
        }

        public TerminalNode T_SECONDS() {
            return getToken(CupidDBSqlParser.T_SECONDS, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitIntervalItem(this);
            else return visitor.visitChildren(this);
        }
    }

    public final IntervalItemContext intervalItem() throws RecognitionException {
        IntervalItemContext _localctx = new IntervalItemContext(_ctx, getState());
        enterRule(_localctx, 198, RULE_intervalItem);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1365);
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
            return getTokens(CupidDBSqlParser.T_PIPE);
        }

        public TerminalNode T_PIPE(int i) {
            return getToken(CupidDBSqlParser.T_PIPE, i);
        }

        public List<TerminalNode> T_CONCAT() {
            return getTokens(CupidDBSqlParser.T_CONCAT);
        }

        public TerminalNode T_CONCAT(int i) {
            return getToken(CupidDBSqlParser.T_CONCAT, i);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitExprConcat(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ExprConcatContext exprConcat() throws RecognitionException {
        ExprConcatContext _localctx = new ExprConcatContext(_ctx, getState());
        enterRule(_localctx, 200, RULE_exprConcat);
        int _la;
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(1367);
                exprConcatItem();
                setState(1368);
                _la = _input.LA(1);
                if (!(_la == T_CONCAT || _la == T_PIPE)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
                setState(1369);
                exprConcatItem();
                setState(1374);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 164, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            {
                                setState(1370);
                                _la = _input.LA(1);
                                if (!(_la == T_CONCAT || _la == T_PIPE)) {
                                    _errHandler.recoverInline(this);
                                } else {
                                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                    _errHandler.reportMatch(this);
                                    consume();
                                }
                                setState(1371);
                                exprConcatItem();
                            }
                        }
                    }
                    setState(1376);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 164, _ctx);
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
            return getToken(CupidDBSqlParser.T_OPEN_P, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode T_CLOSE_P() {
            return getToken(CupidDBSqlParser.T_CLOSE_P, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitExprConcatItem(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ExprConcatItemContext exprConcatItem() throws RecognitionException {
        ExprConcatItemContext _localctx = new ExprConcatItemContext(_ctx, getState());
        enterRule(_localctx, 202, RULE_exprConcatItem);
        try {
            setState(1386);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 165, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1); {
                    setState(1377);
                    match(T_OPEN_P);
                    setState(1378);
                    expr(0);
                    setState(1379);
                    match(T_CLOSE_P);
                }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2); {
                    setState(1381);
                    exprCase();
                }
                    break;
                case 3:
                    enterOuterAlt(_localctx, 3); {
                    setState(1382);
                    exprAggWindowFunc();
                }
                    break;
                case 4:
                    enterOuterAlt(_localctx, 4); {
                    setState(1383);
                    exprSpecFunc();
                }
                    break;
                case 5:
                    enterOuterAlt(_localctx, 5); {
                    setState(1384);
                    exprFunc();
                }
                    break;
                case 6:
                    enterOuterAlt(_localctx, 6); {
                    setState(1385);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitExprCase(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ExprCaseContext exprCase() throws RecognitionException {
        ExprCaseContext _localctx = new ExprCaseContext(_ctx, getState());
        enterRule(_localctx, 204, RULE_exprCase);
        try {
            setState(1390);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 166, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1); {
                    setState(1388);
                    exprCaseSimple();
                }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2); {
                    setState(1389);
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
            return getToken(CupidDBSqlParser.T_CASE, 0);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode T_END() {
            return getToken(CupidDBSqlParser.T_END, 0);
        }

        public List<TerminalNode> T_WHEN() {
            return getTokens(CupidDBSqlParser.T_WHEN);
        }

        public TerminalNode T_WHEN(int i) {
            return getToken(CupidDBSqlParser.T_WHEN, i);
        }

        public List<TerminalNode> T_THEN() {
            return getTokens(CupidDBSqlParser.T_THEN);
        }

        public TerminalNode T_THEN(int i) {
            return getToken(CupidDBSqlParser.T_THEN, i);
        }

        public TerminalNode T_ELSE() {
            return getToken(CupidDBSqlParser.T_ELSE, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitExprCaseSimple(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ExprCaseSimpleContext exprCaseSimple() throws RecognitionException {
        ExprCaseSimpleContext _localctx = new ExprCaseSimpleContext(_ctx, getState());
        enterRule(_localctx, 206, RULE_exprCaseSimple);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1392);
                match(T_CASE);
                setState(1393);
                expr(0);
                setState(1399);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        {
                            setState(1394);
                            match(T_WHEN);
                            setState(1395);
                            expr(0);
                            setState(1396);
                            match(T_THEN);
                            setState(1397);
                            expr(0);
                        }
                    }
                    setState(1401);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                } while (_la == T_WHEN);
                setState(1405);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_ELSE) {
                    {
                        setState(1403);
                        match(T_ELSE);
                        setState(1404);
                        expr(0);
                    }
                }

                setState(1407);
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
            return getToken(CupidDBSqlParser.T_CASE, 0);
        }

        public TerminalNode T_END() {
            return getToken(CupidDBSqlParser.T_END, 0);
        }

        public List<ExprCaseItemContext> exprCaseItem() {
            return getRuleContexts(ExprCaseItemContext.class);
        }

        public ExprCaseItemContext exprCaseItem(int i) {
            return getRuleContext(ExprCaseItemContext.class, i);
        }

        public TerminalNode T_ELSE() {
            return getToken(CupidDBSqlParser.T_ELSE, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitExprCaseSearched(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ExprCaseSearchedContext exprCaseSearched() throws RecognitionException {
        ExprCaseSearchedContext _localctx = new ExprCaseSearchedContext(_ctx, getState());
        enterRule(_localctx, 208, RULE_exprCaseSearched);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1409);
                match(T_CASE);
                setState(1411);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        {
                            setState(1410);
                            exprCaseItem();
                        }
                    }
                    setState(1413);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                } while (_la == T_WHEN);
                setState(1417);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_ELSE) {
                    {
                        setState(1415);
                        match(T_ELSE);
                        setState(1416);
                        boolExpr(0);
                    }
                }

                setState(1419);
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
            return getToken(CupidDBSqlParser.T_WHEN, 0);
        }

        public TerminalNode T_THEN() {
            return getToken(CupidDBSqlParser.T_THEN, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitExprCaseItem(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ExprCaseItemContext exprCaseItem() throws RecognitionException {
        ExprCaseItemContext _localctx = new ExprCaseItemContext(_ctx, getState());
        enterRule(_localctx, 210, RULE_exprCaseItem);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1421);
                match(T_WHEN);
                setState(1422);
                ((ExprCaseItemContext) _localctx).whenExpr = boolExpr(0);
                setState(1423);
                match(T_THEN);
                setState(1424);
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
            return getToken(CupidDBSqlParser.T_ISOPEN, 0);
        }

        public TerminalNode T_FOUND() {
            return getToken(CupidDBSqlParser.T_FOUND, 0);
        }

        public TerminalNode T_NOTFOUND() {
            return getToken(CupidDBSqlParser.T_NOTFOUND, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitExprCursorAttribute(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ExprCursorAttributeContext exprCursorAttribute() throws RecognitionException {
        ExprCursorAttributeContext _localctx = new ExprCursorAttributeContext(_ctx, getState());
        enterRule(_localctx, 212, RULE_exprCursorAttribute);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1426);
                ident();
                setState(1427);
                match(T__0);
                setState(1428);
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
            return getToken(CupidDBSqlParser.T_AVG, 0);
        }

        public TerminalNode T_OPEN_P() {
            return getToken(CupidDBSqlParser.T_OPEN_P, 0);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode T_CLOSE_P() {
            return getToken(CupidDBSqlParser.T_CLOSE_P, 0);
        }

        public ExprFuncAllDistinctContext exprFuncAllDistinct() {
            return getRuleContext(ExprFuncAllDistinctContext.class, 0);
        }

        public ExprFuncOverClauseContext exprFuncOverClause() {
            return getRuleContext(ExprFuncOverClauseContext.class, 0);
        }

        public TerminalNode T_COUNT() {
            return getToken(CupidDBSqlParser.T_COUNT, 0);
        }

        public TerminalNode T_MUL() {
            return getToken(CupidDBSqlParser.T_MUL, 0);
        }

        public TerminalNode T_COUNT_BIG() {
            return getToken(CupidDBSqlParser.T_COUNT_BIG, 0);
        }

        public TerminalNode T_CUME_DIST() {
            return getToken(CupidDBSqlParser.T_CUME_DIST, 0);
        }

        public TerminalNode T_DENSE_RANK() {
            return getToken(CupidDBSqlParser.T_DENSE_RANK, 0);
        }

        public TerminalNode T_FIRST_VALUE() {
            return getToken(CupidDBSqlParser.T_FIRST_VALUE, 0);
        }

        public TerminalNode T_LAG() {
            return getToken(CupidDBSqlParser.T_LAG, 0);
        }

        public List<TerminalNode> T_COMMA() {
            return getTokens(CupidDBSqlParser.T_COMMA);
        }

        public TerminalNode T_COMMA(int i) {
            return getToken(CupidDBSqlParser.T_COMMA, i);
        }

        public TerminalNode T_LAST_VALUE() {
            return getToken(CupidDBSqlParser.T_LAST_VALUE, 0);
        }

        public TerminalNode T_LEAD() {
            return getToken(CupidDBSqlParser.T_LEAD, 0);
        }

        public TerminalNode T_MAX() {
            return getToken(CupidDBSqlParser.T_MAX, 0);
        }

        public TerminalNode T_MIN() {
            return getToken(CupidDBSqlParser.T_MIN, 0);
        }

        public TerminalNode T_RANK() {
            return getToken(CupidDBSqlParser.T_RANK, 0);
        }

        public TerminalNode T_ROW_NUMBER() {
            return getToken(CupidDBSqlParser.T_ROW_NUMBER, 0);
        }

        public TerminalNode T_STDEV() {
            return getToken(CupidDBSqlParser.T_STDEV, 0);
        }

        public TerminalNode T_SUM() {
            return getToken(CupidDBSqlParser.T_SUM, 0);
        }

        public TerminalNode T_VAR() {
            return getToken(CupidDBSqlParser.T_VAR, 0);
        }

        public TerminalNode T_VARIANCE() {
            return getToken(CupidDBSqlParser.T_VARIANCE, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitExprAggWindowFunc(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ExprAggWindowFuncContext exprAggWindowFunc() throws RecognitionException {
        ExprAggWindowFuncContext _localctx = new ExprAggWindowFuncContext(_ctx, getState());
        enterRule(_localctx, 214, RULE_exprAggWindowFunc);
        int _la;
        try {
            setState(1582);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T_AVG:
                    enterOuterAlt(_localctx, 1); {
                    setState(1430);
                    match(T_AVG);
                    setState(1431);
                    match(T_OPEN_P);
                    setState(1433);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 171, _ctx)) {
                        case 1: {
                            setState(1432);
                            exprFuncAllDistinct();
                        }
                            break;
                    }
                    setState(1435);
                    expr(0);
                    setState(1436);
                    match(T_CLOSE_P);
                    setState(1438);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 172, _ctx)) {
                        case 1: {
                            setState(1437);
                            exprFuncOverClause();
                        }
                            break;
                    }
                }
                    break;
                case T_COUNT:
                    enterOuterAlt(_localctx, 2); {
                    setState(1440);
                    match(T_COUNT);
                    setState(1441);
                    match(T_OPEN_P);
                    setState(1447);
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
                                setState(1443);
                                _errHandler.sync(this);
                                switch (getInterpreter().adaptivePredict(_input, 173, _ctx)) {
                                    case 1: {
                                        setState(1442);
                                        exprFuncAllDistinct();
                                    }
                                        break;
                                }
                                setState(1445);
                                expr(0);
                            }
                        }
                            break;
                        case T_MUL: {
                            setState(1446);
                            match(T_MUL);
                        }
                            break;
                        default:
                            throw new NoViableAltException(this);
                    }
                    setState(1449);
                    match(T_CLOSE_P);
                    setState(1451);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 175, _ctx)) {
                        case 1: {
                            setState(1450);
                            exprFuncOverClause();
                        }
                            break;
                    }
                }
                    break;
                case T_COUNT_BIG:
                    enterOuterAlt(_localctx, 3); {
                    setState(1453);
                    match(T_COUNT_BIG);
                    setState(1454);
                    match(T_OPEN_P);
                    setState(1460);
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
                                setState(1456);
                                _errHandler.sync(this);
                                switch (getInterpreter().adaptivePredict(_input, 176, _ctx)) {
                                    case 1: {
                                        setState(1455);
                                        exprFuncAllDistinct();
                                    }
                                        break;
                                }
                                setState(1458);
                                expr(0);
                            }
                        }
                            break;
                        case T_MUL: {
                            setState(1459);
                            match(T_MUL);
                        }
                            break;
                        default:
                            throw new NoViableAltException(this);
                    }
                    setState(1462);
                    match(T_CLOSE_P);
                    setState(1464);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 178, _ctx)) {
                        case 1: {
                            setState(1463);
                            exprFuncOverClause();
                        }
                            break;
                    }
                }
                    break;
                case T_CUME_DIST:
                    enterOuterAlt(_localctx, 4); {
                    setState(1466);
                    match(T_CUME_DIST);
                    setState(1467);
                    match(T_OPEN_P);
                    setState(1468);
                    match(T_CLOSE_P);
                    setState(1469);
                    exprFuncOverClause();
                }
                    break;
                case T_DENSE_RANK:
                    enterOuterAlt(_localctx, 5); {
                    setState(1470);
                    match(T_DENSE_RANK);
                    setState(1471);
                    match(T_OPEN_P);
                    setState(1472);
                    match(T_CLOSE_P);
                    setState(1473);
                    exprFuncOverClause();
                }
                    break;
                case T_FIRST_VALUE:
                    enterOuterAlt(_localctx, 6); {
                    setState(1474);
                    match(T_FIRST_VALUE);
                    setState(1475);
                    match(T_OPEN_P);
                    setState(1476);
                    expr(0);
                    setState(1477);
                    match(T_CLOSE_P);
                    setState(1478);
                    exprFuncOverClause();
                }
                    break;
                case T_LAG:
                    enterOuterAlt(_localctx, 7); {
                    setState(1480);
                    match(T_LAG);
                    setState(1481);
                    match(T_OPEN_P);
                    setState(1482);
                    expr(0);
                    setState(1489);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_COMMA) {
                        {
                            setState(1483);
                            match(T_COMMA);
                            setState(1484);
                            expr(0);
                            setState(1487);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                            if (_la == T_COMMA) {
                                {
                                    setState(1485);
                                    match(T_COMMA);
                                    setState(1486);
                                    expr(0);
                                }
                            }

                        }
                    }

                    setState(1491);
                    match(T_CLOSE_P);
                    setState(1492);
                    exprFuncOverClause();
                }
                    break;
                case T_LAST_VALUE:
                    enterOuterAlt(_localctx, 8); {
                    setState(1494);
                    match(T_LAST_VALUE);
                    setState(1495);
                    match(T_OPEN_P);
                    setState(1496);
                    expr(0);
                    setState(1497);
                    match(T_CLOSE_P);
                    setState(1498);
                    exprFuncOverClause();
                }
                    break;
                case T_LEAD:
                    enterOuterAlt(_localctx, 9); {
                    setState(1500);
                    match(T_LEAD);
                    setState(1501);
                    match(T_OPEN_P);
                    setState(1502);
                    expr(0);
                    setState(1509);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_COMMA) {
                        {
                            setState(1503);
                            match(T_COMMA);
                            setState(1504);
                            expr(0);
                            setState(1507);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                            if (_la == T_COMMA) {
                                {
                                    setState(1505);
                                    match(T_COMMA);
                                    setState(1506);
                                    expr(0);
                                }
                            }

                        }
                    }

                    setState(1511);
                    match(T_CLOSE_P);
                    setState(1512);
                    exprFuncOverClause();
                }
                    break;
                case T_MAX:
                    enterOuterAlt(_localctx, 10); {
                    setState(1514);
                    match(T_MAX);
                    setState(1515);
                    match(T_OPEN_P);
                    setState(1517);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 183, _ctx)) {
                        case 1: {
                            setState(1516);
                            exprFuncAllDistinct();
                        }
                            break;
                    }
                    setState(1519);
                    expr(0);
                    setState(1520);
                    match(T_CLOSE_P);
                    setState(1522);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 184, _ctx)) {
                        case 1: {
                            setState(1521);
                            exprFuncOverClause();
                        }
                            break;
                    }
                }
                    break;
                case T_MIN:
                    enterOuterAlt(_localctx, 11); {
                    setState(1524);
                    match(T_MIN);
                    setState(1525);
                    match(T_OPEN_P);
                    setState(1527);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 185, _ctx)) {
                        case 1: {
                            setState(1526);
                            exprFuncAllDistinct();
                        }
                            break;
                    }
                    setState(1529);
                    expr(0);
                    setState(1530);
                    match(T_CLOSE_P);
                    setState(1532);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 186, _ctx)) {
                        case 1: {
                            setState(1531);
                            exprFuncOverClause();
                        }
                            break;
                    }
                }
                    break;
                case T_RANK:
                    enterOuterAlt(_localctx, 12); {
                    setState(1534);
                    match(T_RANK);
                    setState(1535);
                    match(T_OPEN_P);
                    setState(1536);
                    match(T_CLOSE_P);
                    setState(1537);
                    exprFuncOverClause();
                }
                    break;
                case T_ROW_NUMBER:
                    enterOuterAlt(_localctx, 13); {
                    setState(1538);
                    match(T_ROW_NUMBER);
                    setState(1539);
                    match(T_OPEN_P);
                    setState(1540);
                    match(T_CLOSE_P);
                    setState(1541);
                    exprFuncOverClause();
                }
                    break;
                case T_STDEV:
                    enterOuterAlt(_localctx, 14); {
                    setState(1542);
                    match(T_STDEV);
                    setState(1543);
                    match(T_OPEN_P);
                    setState(1545);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 187, _ctx)) {
                        case 1: {
                            setState(1544);
                            exprFuncAllDistinct();
                        }
                            break;
                    }
                    setState(1547);
                    expr(0);
                    setState(1548);
                    match(T_CLOSE_P);
                    setState(1550);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 188, _ctx)) {
                        case 1: {
                            setState(1549);
                            exprFuncOverClause();
                        }
                            break;
                    }
                }
                    break;
                case T_SUM:
                    enterOuterAlt(_localctx, 15); {
                    setState(1552);
                    match(T_SUM);
                    setState(1553);
                    match(T_OPEN_P);
                    setState(1555);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 189, _ctx)) {
                        case 1: {
                            setState(1554);
                            exprFuncAllDistinct();
                        }
                            break;
                    }
                    setState(1557);
                    expr(0);
                    setState(1558);
                    match(T_CLOSE_P);
                    setState(1560);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 190, _ctx)) {
                        case 1: {
                            setState(1559);
                            exprFuncOverClause();
                        }
                            break;
                    }
                }
                    break;
                case T_VAR:
                    enterOuterAlt(_localctx, 16); {
                    setState(1562);
                    match(T_VAR);
                    setState(1563);
                    match(T_OPEN_P);
                    setState(1565);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 191, _ctx)) {
                        case 1: {
                            setState(1564);
                            exprFuncAllDistinct();
                        }
                            break;
                    }
                    setState(1567);
                    expr(0);
                    setState(1568);
                    match(T_CLOSE_P);
                    setState(1570);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 192, _ctx)) {
                        case 1: {
                            setState(1569);
                            exprFuncOverClause();
                        }
                            break;
                    }
                }
                    break;
                case T_VARIANCE:
                    enterOuterAlt(_localctx, 17); {
                    setState(1572);
                    match(T_VARIANCE);
                    setState(1573);
                    match(T_OPEN_P);
                    setState(1575);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 193, _ctx)) {
                        case 1: {
                            setState(1574);
                            exprFuncAllDistinct();
                        }
                            break;
                    }
                    setState(1577);
                    expr(0);
                    setState(1578);
                    match(T_CLOSE_P);
                    setState(1580);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 194, _ctx)) {
                        case 1: {
                            setState(1579);
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
            return getToken(CupidDBSqlParser.T_ALL, 0);
        }

        public TerminalNode T_DISTINCT() {
            return getToken(CupidDBSqlParser.T_DISTINCT, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitExprFuncAllDistinct(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ExprFuncAllDistinctContext exprFuncAllDistinct() throws RecognitionException {
        ExprFuncAllDistinctContext _localctx = new ExprFuncAllDistinctContext(_ctx, getState());
        enterRule(_localctx, 216, RULE_exprFuncAllDistinct);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1584);
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
            return getToken(CupidDBSqlParser.T_OVER, 0);
        }

        public TerminalNode T_OPEN_P() {
            return getToken(CupidDBSqlParser.T_OPEN_P, 0);
        }

        public TerminalNode T_CLOSE_P() {
            return getToken(CupidDBSqlParser.T_CLOSE_P, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitExprFuncOverClause(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ExprFuncOverClauseContext exprFuncOverClause() throws RecognitionException {
        ExprFuncOverClauseContext _localctx = new ExprFuncOverClauseContext(_ctx, getState());
        enterRule(_localctx, 218, RULE_exprFuncOverClause);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1586);
                match(T_OVER);
                setState(1587);
                match(T_OPEN_P);
                setState(1589);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_PARTITION) {
                    {
                        setState(1588);
                        exprFuncPartitionByClause();
                    }
                }

                setState(1592);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_ORDER) {
                    {
                        setState(1591);
                        orderByClause();
                    }
                }

                setState(1594);
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
            return getToken(CupidDBSqlParser.T_PARTITION, 0);
        }

        public TerminalNode T_BY() {
            return getToken(CupidDBSqlParser.T_BY, 0);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public List<TerminalNode> T_COMMA() {
            return getTokens(CupidDBSqlParser.T_COMMA);
        }

        public TerminalNode T_COMMA(int i) {
            return getToken(CupidDBSqlParser.T_COMMA, i);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
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
        enterRule(_localctx, 220, RULE_exprFuncPartitionByClause);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1596);
                match(T_PARTITION);
                setState(1597);
                match(T_BY);
                setState(1598);
                expr(0);
                setState(1603);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T_COMMA) {
                    {
                        {
                            setState(1599);
                            match(T_COMMA);
                            setState(1600);
                            expr(0);
                        }
                    }
                    setState(1605);
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
            return getToken(CupidDBSqlParser.T_ACTIVITY_COUNT, 0);
        }

        public TerminalNode T_CAST() {
            return getToken(CupidDBSqlParser.T_CAST, 0);
        }

        public TerminalNode T_OPEN_P() {
            return getToken(CupidDBSqlParser.T_OPEN_P, 0);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode T_AS() {
            return getToken(CupidDBSqlParser.T_AS, 0);
        }

        public DtypeContext dtype() {
            return getRuleContext(DtypeContext.class, 0);
        }

        public TerminalNode T_CLOSE_P() {
            return getToken(CupidDBSqlParser.T_CLOSE_P, 0);
        }

        public DtypeLenContext dtypeLen() {
            return getRuleContext(DtypeLenContext.class, 0);
        }

        public TerminalNode T_COUNT() {
            return getToken(CupidDBSqlParser.T_COUNT, 0);
        }

        public TerminalNode T_MUL() {
            return getToken(CupidDBSqlParser.T_MUL, 0);
        }

        public TerminalNode T_CURRENT_DATE() {
            return getToken(CupidDBSqlParser.T_CURRENT_DATE, 0);
        }

        public TerminalNode T_CURRENT() {
            return getToken(CupidDBSqlParser.T_CURRENT, 0);
        }

        public TerminalNode T_DATE() {
            return getToken(CupidDBSqlParser.T_DATE, 0);
        }

        public TerminalNode T_CURRENT_TIME() {
            return getToken(CupidDBSqlParser.T_CURRENT_TIME, 0);
        }

        public TerminalNode T_PI() {
            return getToken(CupidDBSqlParser.T_PI, 0);
        }

        public TerminalNode T_CURRENT_TIMESTAMP() {
            return getToken(CupidDBSqlParser.T_CURRENT_TIMESTAMP, 0);
        }

        public TerminalNode T_TIMESTAMP() {
            return getToken(CupidDBSqlParser.T_TIMESTAMP, 0);
        }

        public TerminalNode T_CURRENT_USER() {
            return getToken(CupidDBSqlParser.T_CURRENT_USER, 0);
        }

        public TerminalNode T_USER() {
            return getToken(CupidDBSqlParser.T_USER, 0);
        }

        public TerminalNode T_MAX_PART_STRING() {
            return getToken(CupidDBSqlParser.T_MAX_PART_STRING, 0);
        }

        public List<TerminalNode> T_COMMA() {
            return getTokens(CupidDBSqlParser.T_COMMA);
        }

        public TerminalNode T_COMMA(int i) {
            return getToken(CupidDBSqlParser.T_COMMA, i);
        }

        public List<TerminalNode> T_EQUAL() {
            return getTokens(CupidDBSqlParser.T_EQUAL);
        }

        public TerminalNode T_EQUAL(int i) {
            return getToken(CupidDBSqlParser.T_EQUAL, i);
        }

        public TerminalNode T_MIN_PART_STRING() {
            return getToken(CupidDBSqlParser.T_MIN_PART_STRING, 0);
        }

        public TerminalNode T_MAX_PART_INT() {
            return getToken(CupidDBSqlParser.T_MAX_PART_INT, 0);
        }

        public TerminalNode T_MIN_PART_INT() {
            return getToken(CupidDBSqlParser.T_MIN_PART_INT, 0);
        }

        public TerminalNode T_MAX_PART_DATE() {
            return getToken(CupidDBSqlParser.T_MAX_PART_DATE, 0);
        }

        public TerminalNode T_MIN_PART_DATE() {
            return getToken(CupidDBSqlParser.T_MIN_PART_DATE, 0);
        }

        public TerminalNode T_PART_COUNT() {
            return getToken(CupidDBSqlParser.T_PART_COUNT, 0);
        }

        public TerminalNode T_PART_LOC() {
            return getToken(CupidDBSqlParser.T_PART_LOC, 0);
        }

        public TerminalNode T_SUBSTRING() {
            return getToken(CupidDBSqlParser.T_SUBSTRING, 0);
        }

        public TerminalNode T_FROM() {
            return getToken(CupidDBSqlParser.T_FROM, 0);
        }

        public TerminalNode T_FOR() {
            return getToken(CupidDBSqlParser.T_FOR, 0);
        }

        public TerminalNode T_SYSDATE() {
            return getToken(CupidDBSqlParser.T_SYSDATE, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitExprSpecFunc(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ExprSpecFuncContext exprSpecFunc() throws RecognitionException {
        ExprSpecFuncContext _localctx = new ExprSpecFuncContext(_ctx, getState());
        enterRule(_localctx, 222, RULE_exprSpecFunc);
        int _la;
        try {
            int _alt;
            setState(1803);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 219, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1); {
                    setState(1606);
                    match(T_ACTIVITY_COUNT);
                }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2); {
                    setState(1607);
                    match(T_CAST);
                    setState(1608);
                    match(T_OPEN_P);
                    setState(1609);
                    expr(0);
                    setState(1610);
                    match(T_AS);
                    setState(1611);
                    dtype();
                    setState(1613);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_OPEN_P) {
                        {
                            setState(1612);
                            dtypeLen();
                        }
                    }

                    setState(1615);
                    match(T_CLOSE_P);
                }
                    break;
                case 3:
                    enterOuterAlt(_localctx, 3); {
                    setState(1617);
                    match(T_COUNT);
                    setState(1618);
                    match(T_OPEN_P);
                    setState(1621);
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
                            setState(1619);
                            expr(0);
                        }
                            break;
                        case T_MUL: {
                            setState(1620);
                            match(T_MUL);
                        }
                            break;
                        default:
                            throw new NoViableAltException(this);
                    }
                    setState(1623);
                    match(T_CLOSE_P);
                }
                    break;
                case 4:
                    enterOuterAlt(_localctx, 4); {
                    setState(1624);
                    match(T_CURRENT_DATE);
                }
                    break;
                case 5:
                    enterOuterAlt(_localctx, 5); {
                    setState(1625);
                    match(T_CURRENT);
                    setState(1626);
                    match(T_DATE);
                }
                    break;
                case 6:
                    enterOuterAlt(_localctx, 6); {
                    setState(1627);
                    match(T_CURRENT_TIME);
                }
                    break;
                case 7:
                    enterOuterAlt(_localctx, 7); {
                    setState(1628);
                    match(T_PI);
                }
                    break;
                case 8:
                    enterOuterAlt(_localctx, 8); {
                    setState(1632);
                    _errHandler.sync(this);
                    switch (_input.LA(1)) {
                        case T_CURRENT_TIMESTAMP: {
                            setState(1629);
                            match(T_CURRENT_TIMESTAMP);
                        }
                            break;
                        case T_CURRENT: {
                            setState(1630);
                            match(T_CURRENT);
                            setState(1631);
                            match(T_TIMESTAMP);
                        }
                            break;
                        default:
                            throw new NoViableAltException(this);
                    }
                    setState(1638);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 202, _ctx)) {
                        case 1: {
                            setState(1634);
                            match(T_OPEN_P);
                            setState(1635);
                            expr(0);
                            setState(1636);
                            match(T_CLOSE_P);
                        }
                            break;
                    }
                }
                    break;
                case 9:
                    enterOuterAlt(_localctx, 9); {
                    setState(1640);
                    match(T_CURRENT_USER);
                }
                    break;
                case 10:
                    enterOuterAlt(_localctx, 10); {
                    setState(1641);
                    match(T_CURRENT);
                    setState(1642);
                    match(T_USER);
                }
                    break;
                case 11:
                    enterOuterAlt(_localctx, 11); {
                    setState(1643);
                    match(T_MAX_PART_STRING);
                    setState(1644);
                    match(T_OPEN_P);
                    setState(1645);
                    expr(0);
                    setState(1658);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_COMMA) {
                        {
                            setState(1646);
                            match(T_COMMA);
                            setState(1647);
                            expr(0);
                            setState(1655);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                            while (_la == T_COMMA) {
                                {
                                    {
                                        setState(1648);
                                        match(T_COMMA);
                                        setState(1649);
                                        expr(0);
                                        setState(1650);
                                        match(T_EQUAL);
                                        setState(1651);
                                        expr(0);
                                    }
                                }
                                setState(1657);
                                _errHandler.sync(this);
                                _la = _input.LA(1);
                            }
                        }
                    }

                    setState(1660);
                    match(T_CLOSE_P);
                }
                    break;
                case 12:
                    enterOuterAlt(_localctx, 12); {
                    setState(1662);
                    match(T_MIN_PART_STRING);
                    setState(1663);
                    match(T_OPEN_P);
                    setState(1664);
                    expr(0);
                    setState(1677);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_COMMA) {
                        {
                            setState(1665);
                            match(T_COMMA);
                            setState(1666);
                            expr(0);
                            setState(1674);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                            while (_la == T_COMMA) {
                                {
                                    {
                                        setState(1667);
                                        match(T_COMMA);
                                        setState(1668);
                                        expr(0);
                                        setState(1669);
                                        match(T_EQUAL);
                                        setState(1670);
                                        expr(0);
                                    }
                                }
                                setState(1676);
                                _errHandler.sync(this);
                                _la = _input.LA(1);
                            }
                        }
                    }

                    setState(1679);
                    match(T_CLOSE_P);
                }
                    break;
                case 13:
                    enterOuterAlt(_localctx, 13); {
                    setState(1681);
                    match(T_MAX_PART_INT);
                    setState(1682);
                    match(T_OPEN_P);
                    setState(1683);
                    expr(0);
                    setState(1696);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_COMMA) {
                        {
                            setState(1684);
                            match(T_COMMA);
                            setState(1685);
                            expr(0);
                            setState(1693);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                            while (_la == T_COMMA) {
                                {
                                    {
                                        setState(1686);
                                        match(T_COMMA);
                                        setState(1687);
                                        expr(0);
                                        setState(1688);
                                        match(T_EQUAL);
                                        setState(1689);
                                        expr(0);
                                    }
                                }
                                setState(1695);
                                _errHandler.sync(this);
                                _la = _input.LA(1);
                            }
                        }
                    }

                    setState(1698);
                    match(T_CLOSE_P);
                }
                    break;
                case 14:
                    enterOuterAlt(_localctx, 14); {
                    setState(1700);
                    match(T_MIN_PART_INT);
                    setState(1701);
                    match(T_OPEN_P);
                    setState(1702);
                    expr(0);
                    setState(1715);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_COMMA) {
                        {
                            setState(1703);
                            match(T_COMMA);
                            setState(1704);
                            expr(0);
                            setState(1712);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                            while (_la == T_COMMA) {
                                {
                                    {
                                        setState(1705);
                                        match(T_COMMA);
                                        setState(1706);
                                        expr(0);
                                        setState(1707);
                                        match(T_EQUAL);
                                        setState(1708);
                                        expr(0);
                                    }
                                }
                                setState(1714);
                                _errHandler.sync(this);
                                _la = _input.LA(1);
                            }
                        }
                    }

                    setState(1717);
                    match(T_CLOSE_P);
                }
                    break;
                case 15:
                    enterOuterAlt(_localctx, 15); {
                    setState(1719);
                    match(T_MAX_PART_DATE);
                    setState(1720);
                    match(T_OPEN_P);
                    setState(1721);
                    expr(0);
                    setState(1734);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_COMMA) {
                        {
                            setState(1722);
                            match(T_COMMA);
                            setState(1723);
                            expr(0);
                            setState(1731);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                            while (_la == T_COMMA) {
                                {
                                    {
                                        setState(1724);
                                        match(T_COMMA);
                                        setState(1725);
                                        expr(0);
                                        setState(1726);
                                        match(T_EQUAL);
                                        setState(1727);
                                        expr(0);
                                    }
                                }
                                setState(1733);
                                _errHandler.sync(this);
                                _la = _input.LA(1);
                            }
                        }
                    }

                    setState(1736);
                    match(T_CLOSE_P);
                }
                    break;
                case 16:
                    enterOuterAlt(_localctx, 16); {
                    setState(1738);
                    match(T_MIN_PART_DATE);
                    setState(1739);
                    match(T_OPEN_P);
                    setState(1740);
                    expr(0);
                    setState(1753);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_COMMA) {
                        {
                            setState(1741);
                            match(T_COMMA);
                            setState(1742);
                            expr(0);
                            setState(1750);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                            while (_la == T_COMMA) {
                                {
                                    {
                                        setState(1743);
                                        match(T_COMMA);
                                        setState(1744);
                                        expr(0);
                                        setState(1745);
                                        match(T_EQUAL);
                                        setState(1746);
                                        expr(0);
                                    }
                                }
                                setState(1752);
                                _errHandler.sync(this);
                                _la = _input.LA(1);
                            }
                        }
                    }

                    setState(1755);
                    match(T_CLOSE_P);
                }
                    break;
                case 17:
                    enterOuterAlt(_localctx, 17); {
                    setState(1757);
                    match(T_PART_COUNT);
                    setState(1758);
                    match(T_OPEN_P);
                    setState(1759);
                    expr(0);
                    setState(1767);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == T_COMMA) {
                        {
                            {
                                setState(1760);
                                match(T_COMMA);
                                setState(1761);
                                expr(0);
                                setState(1762);
                                match(T_EQUAL);
                                setState(1763);
                                expr(0);
                            }
                        }
                        setState(1769);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                    setState(1770);
                    match(T_CLOSE_P);
                }
                    break;
                case 18:
                    enterOuterAlt(_localctx, 18); {
                    setState(1772);
                    match(T_PART_LOC);
                    setState(1773);
                    match(T_OPEN_P);
                    setState(1774);
                    expr(0);
                    setState(1780);
                    _errHandler.sync(this);
                    _alt = 1;
                    do {
                        switch (_alt) {
                            case 1: {
                                {
                                    setState(1775);
                                    match(T_COMMA);
                                    setState(1776);
                                    expr(0);
                                    setState(1777);
                                    match(T_EQUAL);
                                    setState(1778);
                                    expr(0);
                                }
                            }
                                break;
                            default:
                                throw new NoViableAltException(this);
                        }
                        setState(1782);
                        _errHandler.sync(this);
                        _alt = getInterpreter().adaptivePredict(_input, 216, _ctx);
                    } while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER);
                    setState(1786);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_COMMA) {
                        {
                            setState(1784);
                            match(T_COMMA);
                            setState(1785);
                            expr(0);
                        }
                    }

                    setState(1788);
                    match(T_CLOSE_P);
                }
                    break;
                case 19:
                    enterOuterAlt(_localctx, 19); {
                    setState(1790);
                    match(T_SUBSTRING);
                    setState(1791);
                    match(T_OPEN_P);
                    setState(1792);
                    expr(0);
                    setState(1793);
                    match(T_FROM);
                    setState(1794);
                    expr(0);
                    setState(1797);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_FOR) {
                        {
                            setState(1795);
                            match(T_FOR);
                            setState(1796);
                            expr(0);
                        }
                    }

                    setState(1799);
                    match(T_CLOSE_P);
                }
                    break;
                case 20:
                    enterOuterAlt(_localctx, 20); {
                    setState(1801);
                    match(T_SYSDATE);
                }
                    break;
                case 21:
                    enterOuterAlt(_localctx, 21); {
                    setState(1802);
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
            return getToken(CupidDBSqlParser.T_OPEN_P, 0);
        }

        public TerminalNode T_CLOSE_P() {
            return getToken(CupidDBSqlParser.T_CLOSE_P, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitExprFunc(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ExprFuncContext exprFunc() throws RecognitionException {
        ExprFuncContext _localctx = new ExprFuncContext(_ctx, getState());
        enterRule(_localctx, 224, RULE_exprFunc);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1805);
                ident();
                setState(1806);
                match(T_OPEN_P);
                setState(1808);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 220, _ctx)) {
                    case 1: {
                        setState(1807);
                        exprFuncParams();
                    }
                        break;
                }
                setState(1810);
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
            return getTokens(CupidDBSqlParser.T_COMMA);
        }

        public TerminalNode T_COMMA(int i) {
            return getToken(CupidDBSqlParser.T_COMMA, i);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitExprFuncParams(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ExprFuncParamsContext exprFuncParams() throws RecognitionException {
        ExprFuncParamsContext _localctx = new ExprFuncParamsContext(_ctx, getState());
        enterRule(_localctx, 226, RULE_exprFuncParams);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1812);
                funcParam();
                setState(1817);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T_COMMA) {
                    {
                        {
                            setState(1813);
                            match(T_COMMA);
                            setState(1814);
                            funcParam();
                        }
                    }
                    setState(1819);
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
            return getToken(CupidDBSqlParser.T_EQUAL, 0);
        }

        public TerminalNode T_GREATER() {
            return getToken(CupidDBSqlParser.T_GREATER, 0);
        }

        public TerminalNode T_MUL() {
            return getToken(CupidDBSqlParser.T_MUL, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitFuncParam(this);
            else return visitor.visitChildren(this);
        }
    }

    public final FuncParamContext funcParam() throws RecognitionException {
        FuncParamContext _localctx = new FuncParamContext(_ctx, getState());
        enterRule(_localctx, 228, RULE_funcParam);
        int _la;
        try {
            setState(1831);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 224, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1); {}
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2); {
                    setState(1821);
                    if (!(!_input.LT(1).getText().equalsIgnoreCase("INTO")))
                        throw new FailedPredicateException(
                            this,
                            "!_input.LT(1).getText().equalsIgnoreCase(\"INTO\")"
                        );
                    setState(1827);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 223, _ctx)) {
                        case 1: {
                            setState(1822);
                            ident();
                            setState(1823);
                            match(T_EQUAL);
                            setState(1825);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                            if (_la == T_GREATER) {
                                {
                                    setState(1824);
                                    match(T_GREATER);
                                }
                            }

                        }
                            break;
                    }
                    setState(1829);
                    expr(0);
                }
                    break;
                case 3:
                    enterOuterAlt(_localctx, 3); {
                    setState(1830);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitTable_name(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Table_nameContext table_name() throws RecognitionException {
        Table_nameContext _localctx = new Table_nameContext(_ctx, getState());
        enterRule(_localctx, 230, RULE_table_name);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1833);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitUser_name(this);
            else return visitor.visitChildren(this);
        }
    }

    public final User_nameContext user_name() throws RecognitionException {
        User_nameContext _localctx = new User_nameContext(_ctx, getState());
        enterRule(_localctx, 232, RULE_user_name);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1835);
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
            return getTokens(CupidDBSqlParser.T_DOT);
        }

        public TerminalNode T_DOT(int i) {
            return getToken(CupidDBSqlParser.T_DOT, i);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitQident(this);
            else return visitor.visitChildren(this);
        }
    }

    public final QidentContext qident() throws RecognitionException {
        QidentContext _localctx = new QidentContext(_ctx, getState());
        enterRule(_localctx, 234, RULE_qident);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1837);
                ident();
                setState(1842);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T_DOT) {
                    {
                        {
                            setState(1838);
                            match(T_DOT);
                            setState(1839);
                            ident();
                        }
                    }
                    setState(1844);
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
            return getToken(CupidDBSqlParser.T_DATE, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitDateLiteral(this);
            else return visitor.visitChildren(this);
        }
    }

    public final DateLiteralContext dateLiteral() throws RecognitionException {
        DateLiteralContext _localctx = new DateLiteralContext(_ctx, getState());
        enterRule(_localctx, 236, RULE_dateLiteral);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1845);
                match(T_DATE);
                setState(1846);
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
            return getToken(CupidDBSqlParser.T_TIMESTAMP, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitTimestampLiteral(this);
            else return visitor.visitChildren(this);
        }
    }

    public final TimestampLiteralContext timestampLiteral() throws RecognitionException {
        TimestampLiteralContext _localctx = new TimestampLiteralContext(_ctx, getState());
        enterRule(_localctx, 238, RULE_timestampLiteral);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1848);
                match(T_TIMESTAMP);
                setState(1849);
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
            return getToken(CupidDBSqlParser.T_SUB, 0);
        }

        public List<TerminalNode> T_DOT() {
            return getTokens(CupidDBSqlParser.T_DOT);
        }

        public TerminalNode T_DOT(int i) {
            return getToken(CupidDBSqlParser.T_DOT, i);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitIdent(this);
            else return visitor.visitChildren(this);
        }
    }

    public final IdentContext ident() throws RecognitionException {
        IdentContext _localctx = new IdentContext(_ctx, getState());
        enterRule(_localctx, 240, RULE_ident);
        int _la;
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(1852);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_SUB) {
                    {
                        setState(1851);
                        match(T_SUB);
                    }
                }

                setState(1854);
                identItem();
                setState(1859);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 227, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            {
                                setState(1855);
                                match(T_DOT);
                                setState(1856);
                                identItem();
                            }
                        }
                    }
                    setState(1861);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 227, _ctx);
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
            return getToken(CupidDBSqlParser.L_ID, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitIdentItem(this);
            else return visitor.visitChildren(this);
        }
    }

    public final IdentItemContext identItem() throws RecognitionException {
        IdentItemContext _localctx = new IdentItemContext(_ctx, getState());
        enterRule(_localctx, 242, RULE_identItem);
        try {
            setState(1864);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case L_ID:
                    enterOuterAlt(_localctx, 1); {
                    setState(1862);
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
                    setState(1863);
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
            return getToken(CupidDBSqlParser.L_S_STRING, 0);
        }

        public SingleQuotedStringContext(StringContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitSingleQuotedString(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class DoubleQuotedStringContext extends StringContext {
        public TerminalNode L_D_STRING() {
            return getToken(CupidDBSqlParser.L_D_STRING, 0);
        }

        public DoubleQuotedStringContext(StringContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitDoubleQuotedString(this);
            else return visitor.visitChildren(this);
        }
    }

    public final StringContext string() throws RecognitionException {
        StringContext _localctx = new StringContext(_ctx, getState());
        enterRule(_localctx, 244, RULE_string);
        try {
            setState(1868);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case L_S_STRING:
                    _localctx = new SingleQuotedStringContext(_localctx);
                    enterOuterAlt(_localctx, 1); {
                    setState(1866);
                    match(L_S_STRING);
                }
                    break;
                case L_D_STRING:
                    _localctx = new DoubleQuotedStringContext(_localctx);
                    enterOuterAlt(_localctx, 2); {
                    setState(1867);
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
            return getToken(CupidDBSqlParser.L_INT, 0);
        }

        public TerminalNode T_SUB() {
            return getToken(CupidDBSqlParser.T_SUB, 0);
        }

        public TerminalNode T_ADD() {
            return getToken(CupidDBSqlParser.T_ADD, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitIntNumber(this);
            else return visitor.visitChildren(this);
        }
    }

    public final IntNumberContext intNumber() throws RecognitionException {
        IntNumberContext _localctx = new IntNumberContext(_ctx, getState());
        enterRule(_localctx, 246, RULE_intNumber);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1871);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_ADD || _la == T_SUB) {
                    {
                        setState(1870);
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

                setState(1873);
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
            return getToken(CupidDBSqlParser.L_DEC, 0);
        }

        public TerminalNode T_SUB() {
            return getToken(CupidDBSqlParser.T_SUB, 0);
        }

        public TerminalNode T_ADD() {
            return getToken(CupidDBSqlParser.T_ADD, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitDecNumber(this);
            else return visitor.visitChildren(this);
        }
    }

    public final DecNumberContext decNumber() throws RecognitionException {
        DecNumberContext _localctx = new DecNumberContext(_ctx, getState());
        enterRule(_localctx, 248, RULE_decNumber);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1876);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_ADD || _la == T_SUB) {
                    {
                        setState(1875);
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

                setState(1878);
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
            return getToken(CupidDBSqlParser.T_TRUE, 0);
        }

        public TerminalNode T_FALSE() {
            return getToken(CupidDBSqlParser.T_FALSE, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitBoolLiteral(this);
            else return visitor.visitChildren(this);
        }
    }

    public final BoolLiteralContext boolLiteral() throws RecognitionException {
        BoolLiteralContext _localctx = new BoolLiteralContext(_ctx, getState());
        enterRule(_localctx, 250, RULE_boolLiteral);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1880);
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
            return getToken(CupidDBSqlParser.T_NULL, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitNullConst(this);
            else return visitor.visitChildren(this);
        }
    }

    public final NullConstContext nullConst() throws RecognitionException {
        NullConstContext _localctx = new NullConstContext(_ctx, getState());
        enterRule(_localctx, 252, RULE_nullConst);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1882);
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
            return getToken(CupidDBSqlParser.T_ACTION, 0);
        }

        public TerminalNode T_ACTIVITY_COUNT() {
            return getToken(CupidDBSqlParser.T_ACTIVITY_COUNT, 0);
        }

        public TerminalNode T_ADD2() {
            return getToken(CupidDBSqlParser.T_ADD2, 0);
        }

        public TerminalNode T_ALL() {
            return getToken(CupidDBSqlParser.T_ALL, 0);
        }

        public TerminalNode T_ALLOCATE() {
            return getToken(CupidDBSqlParser.T_ALLOCATE, 0);
        }

        public TerminalNode T_ALTER() {
            return getToken(CupidDBSqlParser.T_ALTER, 0);
        }

        public TerminalNode T_AND() {
            return getToken(CupidDBSqlParser.T_AND, 0);
        }

        public TerminalNode T_ANSI_NULLS() {
            return getToken(CupidDBSqlParser.T_ANSI_NULLS, 0);
        }

        public TerminalNode T_ANSI_PADDING() {
            return getToken(CupidDBSqlParser.T_ANSI_PADDING, 0);
        }

        public TerminalNode T_AS() {
            return getToken(CupidDBSqlParser.T_AS, 0);
        }

        public TerminalNode T_ASC() {
            return getToken(CupidDBSqlParser.T_ASC, 0);
        }

        public TerminalNode T_ASSOCIATE() {
            return getToken(CupidDBSqlParser.T_ASSOCIATE, 0);
        }

        public TerminalNode T_AT() {
            return getToken(CupidDBSqlParser.T_AT, 0);
        }

        public TerminalNode T_AVG() {
            return getToken(CupidDBSqlParser.T_AVG, 0);
        }

        public TerminalNode T_BATCHSIZE() {
            return getToken(CupidDBSqlParser.T_BATCHSIZE, 0);
        }

        public TerminalNode T_BEGIN() {
            return getToken(CupidDBSqlParser.T_BEGIN, 0);
        }

        public TerminalNode T_BETWEEN() {
            return getToken(CupidDBSqlParser.T_BETWEEN, 0);
        }

        public TerminalNode T_BIGINT() {
            return getToken(CupidDBSqlParser.T_BIGINT, 0);
        }

        public TerminalNode T_BINARY_DOUBLE() {
            return getToken(CupidDBSqlParser.T_BINARY_DOUBLE, 0);
        }

        public TerminalNode T_BINARY_FLOAT() {
            return getToken(CupidDBSqlParser.T_BINARY_FLOAT, 0);
        }

        public TerminalNode T_BIT() {
            return getToken(CupidDBSqlParser.T_BIT, 0);
        }

        public TerminalNode T_BODY() {
            return getToken(CupidDBSqlParser.T_BODY, 0);
        }

        public TerminalNode T_BREAK() {
            return getToken(CupidDBSqlParser.T_BREAK, 0);
        }

        public TerminalNode T_BY() {
            return getToken(CupidDBSqlParser.T_BY, 0);
        }

        public TerminalNode T_BYTE() {
            return getToken(CupidDBSqlParser.T_BYTE, 0);
        }

        public TerminalNode T_CALL() {
            return getToken(CupidDBSqlParser.T_CALL, 0);
        }

        public TerminalNode T_CALLER() {
            return getToken(CupidDBSqlParser.T_CALLER, 0);
        }

        public TerminalNode T_CASCADE() {
            return getToken(CupidDBSqlParser.T_CASCADE, 0);
        }

        public TerminalNode T_CASE() {
            return getToken(CupidDBSqlParser.T_CASE, 0);
        }

        public TerminalNode T_CASESPECIFIC() {
            return getToken(CupidDBSqlParser.T_CASESPECIFIC, 0);
        }

        public TerminalNode T_CAST() {
            return getToken(CupidDBSqlParser.T_CAST, 0);
        }

        public TerminalNode T_CHAR() {
            return getToken(CupidDBSqlParser.T_CHAR, 0);
        }

        public TerminalNode T_CHARACTER() {
            return getToken(CupidDBSqlParser.T_CHARACTER, 0);
        }

        public TerminalNode T_CHARSET() {
            return getToken(CupidDBSqlParser.T_CHARSET, 0);
        }

        public TerminalNode T_CLIENT() {
            return getToken(CupidDBSqlParser.T_CLIENT, 0);
        }

        public TerminalNode T_CLOSE() {
            return getToken(CupidDBSqlParser.T_CLOSE, 0);
        }

        public TerminalNode T_CLUSTERED() {
            return getToken(CupidDBSqlParser.T_CLUSTERED, 0);
        }

        public TerminalNode T_CMP() {
            return getToken(CupidDBSqlParser.T_CMP, 0);
        }

        public TerminalNode T_COLLECT() {
            return getToken(CupidDBSqlParser.T_COLLECT, 0);
        }

        public TerminalNode T_COLLECTION() {
            return getToken(CupidDBSqlParser.T_COLLECTION, 0);
        }

        public TerminalNode T_COLUMN() {
            return getToken(CupidDBSqlParser.T_COLUMN, 0);
        }

        public TerminalNode T_COMMENT() {
            return getToken(CupidDBSqlParser.T_COMMENT, 0);
        }

        public TerminalNode T_COMPRESS() {
            return getToken(CupidDBSqlParser.T_COMPRESS, 0);
        }

        public TerminalNode T_CONSTANT() {
            return getToken(CupidDBSqlParser.T_CONSTANT, 0);
        }

        public TerminalNode T_COPY() {
            return getToken(CupidDBSqlParser.T_COPY, 0);
        }

        public TerminalNode T_COMMIT() {
            return getToken(CupidDBSqlParser.T_COMMIT, 0);
        }

        public TerminalNode T_CONCAT() {
            return getToken(CupidDBSqlParser.T_CONCAT, 0);
        }

        public TerminalNode T_CONDITION() {
            return getToken(CupidDBSqlParser.T_CONDITION, 0);
        }

        public TerminalNode T_CONSTRAINT() {
            return getToken(CupidDBSqlParser.T_CONSTRAINT, 0);
        }

        public TerminalNode T_CONTINUE() {
            return getToken(CupidDBSqlParser.T_CONTINUE, 0);
        }

        public TerminalNode T_COUNT() {
            return getToken(CupidDBSqlParser.T_COUNT, 0);
        }

        public TerminalNode T_COUNT_BIG() {
            return getToken(CupidDBSqlParser.T_COUNT_BIG, 0);
        }

        public TerminalNode T_CREATION() {
            return getToken(CupidDBSqlParser.T_CREATION, 0);
        }

        public TerminalNode T_CREATOR() {
            return getToken(CupidDBSqlParser.T_CREATOR, 0);
        }

        public TerminalNode T_CS() {
            return getToken(CupidDBSqlParser.T_CS, 0);
        }

        public TerminalNode T_CUME_DIST() {
            return getToken(CupidDBSqlParser.T_CUME_DIST, 0);
        }

        public TerminalNode T_CURRENT() {
            return getToken(CupidDBSqlParser.T_CURRENT, 0);
        }

        public TerminalNode T_CURRENT_DATE() {
            return getToken(CupidDBSqlParser.T_CURRENT_DATE, 0);
        }

        public TerminalNode T_CURRENT_TIME() {
            return getToken(CupidDBSqlParser.T_CURRENT_TIME, 0);
        }

        public TerminalNode T_PI() {
            return getToken(CupidDBSqlParser.T_PI, 0);
        }

        public TerminalNode T_CURRENT_SCHEMA() {
            return getToken(CupidDBSqlParser.T_CURRENT_SCHEMA, 0);
        }

        public TerminalNode T_CURRENT_TIMESTAMP() {
            return getToken(CupidDBSqlParser.T_CURRENT_TIMESTAMP, 0);
        }

        public TerminalNode T_CURRENT_USER() {
            return getToken(CupidDBSqlParser.T_CURRENT_USER, 0);
        }

        public TerminalNode T_CURSOR() {
            return getToken(CupidDBSqlParser.T_CURSOR, 0);
        }

        public TerminalNode T_DATA() {
            return getToken(CupidDBSqlParser.T_DATA, 0);
        }

        public TerminalNode T_DATABASE() {
            return getToken(CupidDBSqlParser.T_DATABASE, 0);
        }

        public TerminalNode T_DATE() {
            return getToken(CupidDBSqlParser.T_DATE, 0);
        }

        public TerminalNode T_DATETIME() {
            return getToken(CupidDBSqlParser.T_DATETIME, 0);
        }

        public TerminalNode T_DAY() {
            return getToken(CupidDBSqlParser.T_DAY, 0);
        }

        public TerminalNode T_DAYS() {
            return getToken(CupidDBSqlParser.T_DAYS, 0);
        }

        public TerminalNode T_DEC() {
            return getToken(CupidDBSqlParser.T_DEC, 0);
        }

        public TerminalNode T_DECIMAL() {
            return getToken(CupidDBSqlParser.T_DECIMAL, 0);
        }

        public TerminalNode T_DECLARE() {
            return getToken(CupidDBSqlParser.T_DECLARE, 0);
        }

        public TerminalNode T_DEFAULT() {
            return getToken(CupidDBSqlParser.T_DEFAULT, 0);
        }

        public TerminalNode T_DEFERRED() {
            return getToken(CupidDBSqlParser.T_DEFERRED, 0);
        }

        public TerminalNode T_DEFINED() {
            return getToken(CupidDBSqlParser.T_DEFINED, 0);
        }

        public TerminalNode T_DEFINER() {
            return getToken(CupidDBSqlParser.T_DEFINER, 0);
        }

        public TerminalNode T_DEFINITION() {
            return getToken(CupidDBSqlParser.T_DEFINITION, 0);
        }

        public TerminalNode T_DELETE() {
            return getToken(CupidDBSqlParser.T_DELETE, 0);
        }

        public TerminalNode T_DELIMITED() {
            return getToken(CupidDBSqlParser.T_DELIMITED, 0);
        }

        public TerminalNode T_DELIMITER() {
            return getToken(CupidDBSqlParser.T_DELIMITER, 0);
        }

        public TerminalNode T_DENSE_RANK() {
            return getToken(CupidDBSqlParser.T_DENSE_RANK, 0);
        }

        public TerminalNode T_DESC() {
            return getToken(CupidDBSqlParser.T_DESC, 0);
        }

        public TerminalNode T_DESCRIBE() {
            return getToken(CupidDBSqlParser.T_DESCRIBE, 0);
        }

        public TerminalNode T_DIAGNOSTICS() {
            return getToken(CupidDBSqlParser.T_DIAGNOSTICS, 0);
        }

        public TerminalNode T_DIR() {
            return getToken(CupidDBSqlParser.T_DIR, 0);
        }

        public TerminalNode T_DIRECTORY() {
            return getToken(CupidDBSqlParser.T_DIRECTORY, 0);
        }

        public TerminalNode T_DISTINCT() {
            return getToken(CupidDBSqlParser.T_DISTINCT, 0);
        }

        public TerminalNode T_DISTRIBUTE() {
            return getToken(CupidDBSqlParser.T_DISTRIBUTE, 0);
        }

        public TerminalNode T_DO() {
            return getToken(CupidDBSqlParser.T_DO, 0);
        }

        public TerminalNode T_DOUBLE() {
            return getToken(CupidDBSqlParser.T_DOUBLE, 0);
        }

        public TerminalNode T_DOWNLOAD() {
            return getToken(CupidDBSqlParser.T_DOWNLOAD, 0);
        }

        public TerminalNode T_DROP() {
            return getToken(CupidDBSqlParser.T_DROP, 0);
        }

        public TerminalNode T_DYNAMIC() {
            return getToken(CupidDBSqlParser.T_DYNAMIC, 0);
        }

        public TerminalNode T_ENABLE() {
            return getToken(CupidDBSqlParser.T_ENABLE, 0);
        }

        public TerminalNode T_ENGINE() {
            return getToken(CupidDBSqlParser.T_ENGINE, 0);
        }

        public TerminalNode T_ESCAPED() {
            return getToken(CupidDBSqlParser.T_ESCAPED, 0);
        }

        public TerminalNode T_EXCEPT() {
            return getToken(CupidDBSqlParser.T_EXCEPT, 0);
        }

        public TerminalNode T_EXEC() {
            return getToken(CupidDBSqlParser.T_EXEC, 0);
        }

        public TerminalNode T_EXECUTE() {
            return getToken(CupidDBSqlParser.T_EXECUTE, 0);
        }

        public TerminalNode T_EXCEPTION() {
            return getToken(CupidDBSqlParser.T_EXCEPTION, 0);
        }

        public TerminalNode T_EXCLUSIVE() {
            return getToken(CupidDBSqlParser.T_EXCLUSIVE, 0);
        }

        public TerminalNode T_EXISTS() {
            return getToken(CupidDBSqlParser.T_EXISTS, 0);
        }

        public TerminalNode T_EXIT() {
            return getToken(CupidDBSqlParser.T_EXIT, 0);
        }

        public TerminalNode T_FALLBACK() {
            return getToken(CupidDBSqlParser.T_FALLBACK, 0);
        }

        public TerminalNode T_FALSE() {
            return getToken(CupidDBSqlParser.T_FALSE, 0);
        }

        public TerminalNode T_FETCH() {
            return getToken(CupidDBSqlParser.T_FETCH, 0);
        }

        public TerminalNode T_FIELDS() {
            return getToken(CupidDBSqlParser.T_FIELDS, 0);
        }

        public TerminalNode T_FILE() {
            return getToken(CupidDBSqlParser.T_FILE, 0);
        }

        public TerminalNode T_FILES() {
            return getToken(CupidDBSqlParser.T_FILES, 0);
        }

        public TerminalNode T_FIRST_VALUE() {
            return getToken(CupidDBSqlParser.T_FIRST_VALUE, 0);
        }

        public TerminalNode T_FLOAT() {
            return getToken(CupidDBSqlParser.T_FLOAT, 0);
        }

        public TerminalNode T_FOR() {
            return getToken(CupidDBSqlParser.T_FOR, 0);
        }

        public TerminalNode T_FOREIGN() {
            return getToken(CupidDBSqlParser.T_FOREIGN, 0);
        }

        public TerminalNode T_FORMAT() {
            return getToken(CupidDBSqlParser.T_FORMAT, 0);
        }

        public TerminalNode T_FOUND() {
            return getToken(CupidDBSqlParser.T_FOUND, 0);
        }

        public TerminalNode T_FROM() {
            return getToken(CupidDBSqlParser.T_FROM, 0);
        }

        public TerminalNode T_FULL() {
            return getToken(CupidDBSqlParser.T_FULL, 0);
        }

        public TerminalNode T_FUNCTION() {
            return getToken(CupidDBSqlParser.T_FUNCTION, 0);
        }

        public TerminalNode T_GET() {
            return getToken(CupidDBSqlParser.T_GET, 0);
        }

        public TerminalNode T_GLOBAL() {
            return getToken(CupidDBSqlParser.T_GLOBAL, 0);
        }

        public TerminalNode T_GO() {
            return getToken(CupidDBSqlParser.T_GO, 0);
        }

        public TerminalNode T_GRANT() {
            return getToken(CupidDBSqlParser.T_GRANT, 0);
        }

        public TerminalNode T_GROUP() {
            return getToken(CupidDBSqlParser.T_GROUP, 0);
        }

        public TerminalNode T_HANDLER() {
            return getToken(CupidDBSqlParser.T_HANDLER, 0);
        }

        public TerminalNode T_HASH() {
            return getToken(CupidDBSqlParser.T_HASH, 0);
        }

        public TerminalNode T_HAVING() {
            return getToken(CupidDBSqlParser.T_HAVING, 0);
        }

        public TerminalNode T_HOST() {
            return getToken(CupidDBSqlParser.T_HOST, 0);
        }

        public TerminalNode T_IDENTITY() {
            return getToken(CupidDBSqlParser.T_IDENTITY, 0);
        }

        public TerminalNode T_IF() {
            return getToken(CupidDBSqlParser.T_IF, 0);
        }

        public TerminalNode T_IGNORE() {
            return getToken(CupidDBSqlParser.T_IGNORE, 0);
        }

        public TerminalNode T_IMMEDIATE() {
            return getToken(CupidDBSqlParser.T_IMMEDIATE, 0);
        }

        public TerminalNode T_IN() {
            return getToken(CupidDBSqlParser.T_IN, 0);
        }

        public TerminalNode T_INCLUDE() {
            return getToken(CupidDBSqlParser.T_INCLUDE, 0);
        }

        public TerminalNode T_INDEX() {
            return getToken(CupidDBSqlParser.T_INDEX, 0);
        }

        public TerminalNode T_INITRANS() {
            return getToken(CupidDBSqlParser.T_INITRANS, 0);
        }

        public TerminalNode T_INNER() {
            return getToken(CupidDBSqlParser.T_INNER, 0);
        }

        public TerminalNode T_INOUT() {
            return getToken(CupidDBSqlParser.T_INOUT, 0);
        }

        public TerminalNode T_INSERT() {
            return getToken(CupidDBSqlParser.T_INSERT, 0);
        }

        public TerminalNode T_INT() {
            return getToken(CupidDBSqlParser.T_INT, 0);
        }

        public TerminalNode T_INT2() {
            return getToken(CupidDBSqlParser.T_INT2, 0);
        }

        public TerminalNode T_INT4() {
            return getToken(CupidDBSqlParser.T_INT4, 0);
        }

        public TerminalNode T_INT8() {
            return getToken(CupidDBSqlParser.T_INT8, 0);
        }

        public TerminalNode T_INTEGER() {
            return getToken(CupidDBSqlParser.T_INTEGER, 0);
        }

        public TerminalNode T_INTERSECT() {
            return getToken(CupidDBSqlParser.T_INTERSECT, 0);
        }

        public TerminalNode T_INTERVAL() {
            return getToken(CupidDBSqlParser.T_INTERVAL, 0);
        }

        public TerminalNode T_INTO() {
            return getToken(CupidDBSqlParser.T_INTO, 0);
        }

        public TerminalNode T_INVOKER() {
            return getToken(CupidDBSqlParser.T_INVOKER, 0);
        }

        public TerminalNode T_ITEMS() {
            return getToken(CupidDBSqlParser.T_ITEMS, 0);
        }

        public TerminalNode T_IS() {
            return getToken(CupidDBSqlParser.T_IS, 0);
        }

        public TerminalNode T_ISOPEN() {
            return getToken(CupidDBSqlParser.T_ISOPEN, 0);
        }

        public TerminalNode T_JOIN() {
            return getToken(CupidDBSqlParser.T_JOIN, 0);
        }

        public TerminalNode T_KEEP() {
            return getToken(CupidDBSqlParser.T_KEEP, 0);
        }

        public TerminalNode T_KEY() {
            return getToken(CupidDBSqlParser.T_KEY, 0);
        }

        public TerminalNode T_KEYS() {
            return getToken(CupidDBSqlParser.T_KEYS, 0);
        }

        public TerminalNode T_LAG() {
            return getToken(CupidDBSqlParser.T_LAG, 0);
        }

        public TerminalNode T_LANGUAGE() {
            return getToken(CupidDBSqlParser.T_LANGUAGE, 0);
        }

        public TerminalNode T_LAST_VALUE() {
            return getToken(CupidDBSqlParser.T_LAST_VALUE, 0);
        }

        public TerminalNode T_LEAD() {
            return getToken(CupidDBSqlParser.T_LEAD, 0);
        }

        public TerminalNode T_LEAVE() {
            return getToken(CupidDBSqlParser.T_LEAVE, 0);
        }

        public TerminalNode T_LEFT() {
            return getToken(CupidDBSqlParser.T_LEFT, 0);
        }

        public TerminalNode T_LIKE() {
            return getToken(CupidDBSqlParser.T_LIKE, 0);
        }

        public TerminalNode T_LIMIT() {
            return getToken(CupidDBSqlParser.T_LIMIT, 0);
        }

        public TerminalNode T_LINES() {
            return getToken(CupidDBSqlParser.T_LINES, 0);
        }

        public TerminalNode T_LOCAL() {
            return getToken(CupidDBSqlParser.T_LOCAL, 0);
        }

        public TerminalNode T_LOCATION() {
            return getToken(CupidDBSqlParser.T_LOCATION, 0);
        }

        public TerminalNode T_LOCATOR() {
            return getToken(CupidDBSqlParser.T_LOCATOR, 0);
        }

        public TerminalNode T_LOCATORS() {
            return getToken(CupidDBSqlParser.T_LOCATORS, 0);
        }

        public TerminalNode T_LOCKS() {
            return getToken(CupidDBSqlParser.T_LOCKS, 0);
        }

        public TerminalNode T_LOG() {
            return getToken(CupidDBSqlParser.T_LOG, 0);
        }

        public TerminalNode T_LOGGED() {
            return getToken(CupidDBSqlParser.T_LOGGED, 0);
        }

        public TerminalNode T_LOGGING() {
            return getToken(CupidDBSqlParser.T_LOGGING, 0);
        }

        public TerminalNode T_LOOP() {
            return getToken(CupidDBSqlParser.T_LOOP, 0);
        }

        public TerminalNode T_MAP() {
            return getToken(CupidDBSqlParser.T_MAP, 0);
        }

        public TerminalNode T_MATCHED() {
            return getToken(CupidDBSqlParser.T_MATCHED, 0);
        }

        public TerminalNode T_MAX() {
            return getToken(CupidDBSqlParser.T_MAX, 0);
        }

        public TerminalNode T_MAXTRANS() {
            return getToken(CupidDBSqlParser.T_MAXTRANS, 0);
        }

        public TerminalNode T_MERGE() {
            return getToken(CupidDBSqlParser.T_MERGE, 0);
        }

        public TerminalNode T_MESSAGE_TEXT() {
            return getToken(CupidDBSqlParser.T_MESSAGE_TEXT, 0);
        }

        public TerminalNode T_MICROSECOND() {
            return getToken(CupidDBSqlParser.T_MICROSECOND, 0);
        }

        public TerminalNode T_MICROSECONDS() {
            return getToken(CupidDBSqlParser.T_MICROSECONDS, 0);
        }

        public TerminalNode T_MIN() {
            return getToken(CupidDBSqlParser.T_MIN, 0);
        }

        public TerminalNode T_MULTISET() {
            return getToken(CupidDBSqlParser.T_MULTISET, 0);
        }

        public TerminalNode T_NCHAR() {
            return getToken(CupidDBSqlParser.T_NCHAR, 0);
        }

        public TerminalNode T_NEW() {
            return getToken(CupidDBSqlParser.T_NEW, 0);
        }

        public TerminalNode T_NVARCHAR() {
            return getToken(CupidDBSqlParser.T_NVARCHAR, 0);
        }

        public TerminalNode T_NO() {
            return getToken(CupidDBSqlParser.T_NO, 0);
        }

        public TerminalNode T_NOCOMPRESS() {
            return getToken(CupidDBSqlParser.T_NOCOMPRESS, 0);
        }

        public TerminalNode T_NOCOUNT() {
            return getToken(CupidDBSqlParser.T_NOCOUNT, 0);
        }

        public TerminalNode T_NOLOGGING() {
            return getToken(CupidDBSqlParser.T_NOLOGGING, 0);
        }

        public TerminalNode T_NONE() {
            return getToken(CupidDBSqlParser.T_NONE, 0);
        }

        public TerminalNode T_NOT() {
            return getToken(CupidDBSqlParser.T_NOT, 0);
        }

        public TerminalNode T_NOTFOUND() {
            return getToken(CupidDBSqlParser.T_NOTFOUND, 0);
        }

        public TerminalNode T_NUMERIC() {
            return getToken(CupidDBSqlParser.T_NUMERIC, 0);
        }

        public TerminalNode T_NUMBER() {
            return getToken(CupidDBSqlParser.T_NUMBER, 0);
        }

        public TerminalNode T_OBJECT() {
            return getToken(CupidDBSqlParser.T_OBJECT, 0);
        }

        public TerminalNode T_OFF() {
            return getToken(CupidDBSqlParser.T_OFF, 0);
        }

        public TerminalNode T_ON() {
            return getToken(CupidDBSqlParser.T_ON, 0);
        }

        public TerminalNode T_ONLY() {
            return getToken(CupidDBSqlParser.T_ONLY, 0);
        }

        public TerminalNode T_OPEN() {
            return getToken(CupidDBSqlParser.T_OPEN, 0);
        }

        public TerminalNode T_OR() {
            return getToken(CupidDBSqlParser.T_OR, 0);
        }

        public TerminalNode T_ORDER() {
            return getToken(CupidDBSqlParser.T_ORDER, 0);
        }

        public TerminalNode T_OUT() {
            return getToken(CupidDBSqlParser.T_OUT, 0);
        }

        public TerminalNode T_OUTER() {
            return getToken(CupidDBSqlParser.T_OUTER, 0);
        }

        public TerminalNode T_OVER() {
            return getToken(CupidDBSqlParser.T_OVER, 0);
        }

        public TerminalNode T_OVERWRITE() {
            return getToken(CupidDBSqlParser.T_OVERWRITE, 0);
        }

        public TerminalNode T_OWNER() {
            return getToken(CupidDBSqlParser.T_OWNER, 0);
        }

        public TerminalNode T_PACKAGE() {
            return getToken(CupidDBSqlParser.T_PACKAGE, 0);
        }

        public TerminalNode T_PART_COUNT() {
            return getToken(CupidDBSqlParser.T_PART_COUNT, 0);
        }

        public TerminalNode T_PART_LOC() {
            return getToken(CupidDBSqlParser.T_PART_LOC, 0);
        }

        public TerminalNode T_PARTITION() {
            return getToken(CupidDBSqlParser.T_PARTITION, 0);
        }

        public TerminalNode T_PCTFREE() {
            return getToken(CupidDBSqlParser.T_PCTFREE, 0);
        }

        public TerminalNode T_PCTUSED() {
            return getToken(CupidDBSqlParser.T_PCTUSED, 0);
        }

        public TerminalNode T_PRECISION() {
            return getToken(CupidDBSqlParser.T_PRECISION, 0);
        }

        public TerminalNode T_PRESERVE() {
            return getToken(CupidDBSqlParser.T_PRESERVE, 0);
        }

        public TerminalNode T_PRIMARY() {
            return getToken(CupidDBSqlParser.T_PRIMARY, 0);
        }

        public TerminalNode T_PRINT() {
            return getToken(CupidDBSqlParser.T_PRINT, 0);
        }

        public TerminalNode T_PROC() {
            return getToken(CupidDBSqlParser.T_PROC, 0);
        }

        public TerminalNode T_PROCEDURE() {
            return getToken(CupidDBSqlParser.T_PROCEDURE, 0);
        }

        public TerminalNode T_PWD() {
            return getToken(CupidDBSqlParser.T_PWD, 0);
        }

        public TerminalNode T_QUALIFY() {
            return getToken(CupidDBSqlParser.T_QUALIFY, 0);
        }

        public TerminalNode T_QUERY_BAND() {
            return getToken(CupidDBSqlParser.T_QUERY_BAND, 0);
        }

        public TerminalNode T_QUIT() {
            return getToken(CupidDBSqlParser.T_QUIT, 0);
        }

        public TerminalNode T_QUOTED_IDENTIFIER() {
            return getToken(CupidDBSqlParser.T_QUOTED_IDENTIFIER, 0);
        }

        public TerminalNode T_RAISE() {
            return getToken(CupidDBSqlParser.T_RAISE, 0);
        }

        public TerminalNode T_RANK() {
            return getToken(CupidDBSqlParser.T_RANK, 0);
        }

        public TerminalNode T_REAL() {
            return getToken(CupidDBSqlParser.T_REAL, 0);
        }

        public TerminalNode T_REFERENCES() {
            return getToken(CupidDBSqlParser.T_REFERENCES, 0);
        }

        public TerminalNode T_REGEXP() {
            return getToken(CupidDBSqlParser.T_REGEXP, 0);
        }

        public TerminalNode T_RR() {
            return getToken(CupidDBSqlParser.T_RR, 0);
        }

        public TerminalNode T_REPLACE() {
            return getToken(CupidDBSqlParser.T_REPLACE, 0);
        }

        public TerminalNode T_RESIGNAL() {
            return getToken(CupidDBSqlParser.T_RESIGNAL, 0);
        }

        public TerminalNode T_RESTRICT() {
            return getToken(CupidDBSqlParser.T_RESTRICT, 0);
        }

        public TerminalNode T_RESULT() {
            return getToken(CupidDBSqlParser.T_RESULT, 0);
        }

        public TerminalNode T_RESULT_SET_LOCATOR() {
            return getToken(CupidDBSqlParser.T_RESULT_SET_LOCATOR, 0);
        }

        public TerminalNode T_RETURN() {
            return getToken(CupidDBSqlParser.T_RETURN, 0);
        }

        public TerminalNode T_RETURNS() {
            return getToken(CupidDBSqlParser.T_RETURNS, 0);
        }

        public TerminalNode T_REVERSE() {
            return getToken(CupidDBSqlParser.T_REVERSE, 0);
        }

        public TerminalNode T_RIGHT() {
            return getToken(CupidDBSqlParser.T_RIGHT, 0);
        }

        public TerminalNode T_RLIKE() {
            return getToken(CupidDBSqlParser.T_RLIKE, 0);
        }

        public TerminalNode T_RS() {
            return getToken(CupidDBSqlParser.T_RS, 0);
        }

        public TerminalNode T_ROLE() {
            return getToken(CupidDBSqlParser.T_ROLE, 0);
        }

        public TerminalNode T_ROLLBACK() {
            return getToken(CupidDBSqlParser.T_ROLLBACK, 0);
        }

        public TerminalNode T_ROW() {
            return getToken(CupidDBSqlParser.T_ROW, 0);
        }

        public TerminalNode T_ROWS() {
            return getToken(CupidDBSqlParser.T_ROWS, 0);
        }

        public TerminalNode T_ROW_COUNT() {
            return getToken(CupidDBSqlParser.T_ROW_COUNT, 0);
        }

        public TerminalNode T_ROW_NUMBER() {
            return getToken(CupidDBSqlParser.T_ROW_NUMBER, 0);
        }

        public TerminalNode T_SCHEMA() {
            return getToken(CupidDBSqlParser.T_SCHEMA, 0);
        }

        public TerminalNode T_SECOND() {
            return getToken(CupidDBSqlParser.T_SECOND, 0);
        }

        public TerminalNode T_SECONDS() {
            return getToken(CupidDBSqlParser.T_SECONDS, 0);
        }

        public TerminalNode T_SECURITY() {
            return getToken(CupidDBSqlParser.T_SECURITY, 0);
        }

        public TerminalNode T_SEGMENT() {
            return getToken(CupidDBSqlParser.T_SEGMENT, 0);
        }

        public TerminalNode T_SEL() {
            return getToken(CupidDBSqlParser.T_SEL, 0);
        }

        public TerminalNode T_SELECT() {
            return getToken(CupidDBSqlParser.T_SELECT, 0);
        }

        public TerminalNode T_SESSION() {
            return getToken(CupidDBSqlParser.T_SESSION, 0);
        }

        public TerminalNode T_SESSIONS() {
            return getToken(CupidDBSqlParser.T_SESSIONS, 0);
        }

        public TerminalNode T_SET() {
            return getToken(CupidDBSqlParser.T_SET, 0);
        }

        public TerminalNode T_SETS() {
            return getToken(CupidDBSqlParser.T_SETS, 0);
        }

        public TerminalNode T_SIGNAL() {
            return getToken(CupidDBSqlParser.T_SIGNAL, 0);
        }

        public TerminalNode T_SIMPLE_DOUBLE() {
            return getToken(CupidDBSqlParser.T_SIMPLE_DOUBLE, 0);
        }

        public TerminalNode T_SIMPLE_FLOAT() {
            return getToken(CupidDBSqlParser.T_SIMPLE_FLOAT, 0);
        }

        public TerminalNode T_SMALLDATETIME() {
            return getToken(CupidDBSqlParser.T_SMALLDATETIME, 0);
        }

        public TerminalNode T_SMALLINT() {
            return getToken(CupidDBSqlParser.T_SMALLINT, 0);
        }

        public TerminalNode T_SQL() {
            return getToken(CupidDBSqlParser.T_SQL, 0);
        }

        public TerminalNode T_SQLEXCEPTION() {
            return getToken(CupidDBSqlParser.T_SQLEXCEPTION, 0);
        }

        public TerminalNode T_SQLINSERT() {
            return getToken(CupidDBSqlParser.T_SQLINSERT, 0);
        }

        public TerminalNode T_SQLSTATE() {
            return getToken(CupidDBSqlParser.T_SQLSTATE, 0);
        }

        public TerminalNode T_SQLWARNING() {
            return getToken(CupidDBSqlParser.T_SQLWARNING, 0);
        }

        public TerminalNode T_STATS() {
            return getToken(CupidDBSqlParser.T_STATS, 0);
        }

        public TerminalNode T_STATISTICS() {
            return getToken(CupidDBSqlParser.T_STATISTICS, 0);
        }

        public TerminalNode T_STEP() {
            return getToken(CupidDBSqlParser.T_STEP, 0);
        }

        public TerminalNode T_STDEV() {
            return getToken(CupidDBSqlParser.T_STDEV, 0);
        }

        public TerminalNode T_STORAGE() {
            return getToken(CupidDBSqlParser.T_STORAGE, 0);
        }

        public TerminalNode T_STORE() {
            return getToken(CupidDBSqlParser.T_STORE, 0);
        }

        public TerminalNode T_STORED() {
            return getToken(CupidDBSqlParser.T_STORED, 0);
        }

        public TerminalNode T_STRING() {
            return getToken(CupidDBSqlParser.T_STRING, 0);
        }

        public TerminalNode T_SUBDIR() {
            return getToken(CupidDBSqlParser.T_SUBDIR, 0);
        }

        public TerminalNode T_SUBSTRING() {
            return getToken(CupidDBSqlParser.T_SUBSTRING, 0);
        }

        public TerminalNode T_SUM() {
            return getToken(CupidDBSqlParser.T_SUM, 0);
        }

        public TerminalNode T_SUMMARY() {
            return getToken(CupidDBSqlParser.T_SUMMARY, 0);
        }

        public TerminalNode T_SYSDATE() {
            return getToken(CupidDBSqlParser.T_SYSDATE, 0);
        }

        public TerminalNode T_SYS_REFCURSOR() {
            return getToken(CupidDBSqlParser.T_SYS_REFCURSOR, 0);
        }

        public TerminalNode T_TABLE() {
            return getToken(CupidDBSqlParser.T_TABLE, 0);
        }

        public TerminalNode T_TABLESPACE() {
            return getToken(CupidDBSqlParser.T_TABLESPACE, 0);
        }

        public TerminalNode T_TEMPORARY() {
            return getToken(CupidDBSqlParser.T_TEMPORARY, 0);
        }

        public TerminalNode T_TERMINATED() {
            return getToken(CupidDBSqlParser.T_TERMINATED, 0);
        }

        public TerminalNode T_TEXTIMAGE_ON() {
            return getToken(CupidDBSqlParser.T_TEXTIMAGE_ON, 0);
        }

        public TerminalNode T_THEN() {
            return getToken(CupidDBSqlParser.T_THEN, 0);
        }

        public TerminalNode T_TIMESTAMP() {
            return getToken(CupidDBSqlParser.T_TIMESTAMP, 0);
        }

        public TerminalNode T_TITLE() {
            return getToken(CupidDBSqlParser.T_TITLE, 0);
        }

        public TerminalNode T_TO() {
            return getToken(CupidDBSqlParser.T_TO, 0);
        }

        public TerminalNode T_TOP() {
            return getToken(CupidDBSqlParser.T_TOP, 0);
        }

        public TerminalNode T_TRANSACTION() {
            return getToken(CupidDBSqlParser.T_TRANSACTION, 0);
        }

        public TerminalNode T_TRIM() {
            return getToken(CupidDBSqlParser.T_TRIM, 0);
        }

        public TerminalNode T_TRUE() {
            return getToken(CupidDBSqlParser.T_TRUE, 0);
        }

        public TerminalNode T_TRUNCATE() {
            return getToken(CupidDBSqlParser.T_TRUNCATE, 0);
        }

        public TerminalNode T_UNIQUE() {
            return getToken(CupidDBSqlParser.T_UNIQUE, 0);
        }

        public TerminalNode T_UPDATE() {
            return getToken(CupidDBSqlParser.T_UPDATE, 0);
        }

        public TerminalNode T_UR() {
            return getToken(CupidDBSqlParser.T_UR, 0);
        }

        public TerminalNode T_USE() {
            return getToken(CupidDBSqlParser.T_USE, 0);
        }

        public TerminalNode T_USER() {
            return getToken(CupidDBSqlParser.T_USER, 0);
        }

        public TerminalNode T_USING() {
            return getToken(CupidDBSqlParser.T_USING, 0);
        }

        public TerminalNode T_VALUE() {
            return getToken(CupidDBSqlParser.T_VALUE, 0);
        }

        public TerminalNode T_VALUES() {
            return getToken(CupidDBSqlParser.T_VALUES, 0);
        }

        public TerminalNode T_VAR() {
            return getToken(CupidDBSqlParser.T_VAR, 0);
        }

        public TerminalNode T_VARCHAR() {
            return getToken(CupidDBSqlParser.T_VARCHAR, 0);
        }

        public TerminalNode T_VARCHAR2() {
            return getToken(CupidDBSqlParser.T_VARCHAR2, 0);
        }

        public TerminalNode T_VARYING() {
            return getToken(CupidDBSqlParser.T_VARYING, 0);
        }

        public TerminalNode T_VARIANCE() {
            return getToken(CupidDBSqlParser.T_VARIANCE, 0);
        }

        public TerminalNode T_VOLATILE() {
            return getToken(CupidDBSqlParser.T_VOLATILE, 0);
        }

        public TerminalNode T_WHILE() {
            return getToken(CupidDBSqlParser.T_WHILE, 0);
        }

        public TerminalNode T_WITH() {
            return getToken(CupidDBSqlParser.T_WITH, 0);
        }

        public TerminalNode T_WITHOUT() {
            return getToken(CupidDBSqlParser.T_WITHOUT, 0);
        }

        public TerminalNode T_WORK() {
            return getToken(CupidDBSqlParser.T_WORK, 0);
        }

        public TerminalNode T_XACT_ABORT() {
            return getToken(CupidDBSqlParser.T_XACT_ABORT, 0);
        }

        public TerminalNode T_XML() {
            return getToken(CupidDBSqlParser.T_XML, 0);
        }

        public TerminalNode T_YES() {
            return getToken(CupidDBSqlParser.T_YES, 0);
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
            if (visitor instanceof CupidDBSqlVisitor) return ((CupidDBSqlVisitor<
                ? extends T>) visitor).visitNonReservedWords(this);
            else return visitor.visitChildren(this);
        }
    }

    public final NonReservedWordsContext nonReservedWords() throws RecognitionException {
        NonReservedWordsContext _localctx = new NonReservedWordsContext(_ctx, getState());
        enterRule(_localctx, 254, RULE_nonReservedWords);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1884);
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
                                            << T_CREATOR) | (1L << T_CS) | (1L << T_CURRENT))) != 0)
                    || ((((_la - 64)) & ~0x3f) == 0
                        && ((1L << (_la - 64)) & ((1L << (T_CURRENT_SCHEMA - 64)) | (1L << (T_CURSOR
                            - 64)) | (1L << (T_DATABASE - 64)) | (1L << (T_DATA - 64)) | (1L
                                << (T_DATE - 64)) | (1L << (T_DATETIME - 64)) | (1L << (T_DAY - 64))
                            | (1L << (T_DAYS - 64)) | (1L << (T_DEC - 64)) | (1L << (T_DECIMAL
                                - 64)) | (1L << (T_DECLARE - 64)) | (1L << (T_DEFAULT - 64)) | (1L
                                    << (T_DEFERRED - 64)) | (1L << (T_DEFINED - 64)) | (1L
                                        << (T_DEFINER - 64)) | (1L << (T_DEFINITION - 64)) | (1L
                                            << (T_DELETE - 64)) | (1L << (T_DELIMITED - 64)) | (1L
                                                << (T_DELIMITER - 64)) | (1L << (T_DESC - 64)) | (1L
                                                    << (T_DESCRIBE - 64)) | (1L << (T_DIAGNOSTICS
                                                        - 64)) | (1L << (T_DIR - 64)) | (1L
                                                            << (T_DIRECTORY - 64)) | (1L
                                                                << (T_DISTINCT - 64)) | (1L
                                                                    << (T_DISTRIBUTE - 64)) | (1L
                                                                        << (T_DO - 64)) | (1L
                                                                            << (T_DOUBLE - 64))
                            | (1L << (T_DOWNLOAD - 64)) | (1L << (T_DROP - 64)) | (1L << (T_DYNAMIC
                                - 64)) | (1L << (T_ENABLE - 64)) | (1L << (T_ENGINE - 64)) | (1L
                                    << (T_ESCAPED - 64)) | (1L << (T_EXCEPT - 64)) | (1L << (T_EXEC
                                        - 64)) | (1L << (T_EXECUTE - 64)) | (1L << (T_EXCEPTION
                                            - 64)) | (1L << (T_EXCLUSIVE - 64)) | (1L << (T_EXISTS
                                                - 64)) | (1L << (T_EXIT - 64)) | (1L << (T_FALLBACK
                                                    - 64)) | (1L << (T_FALSE - 64)) | (1L
                                                        << (T_FETCH - 64)) | (1L << (T_FIELDS - 64))
                            | (1L << (T_FILE - 64)) | (1L << (T_FILES - 64)) | (1L << (T_FLOAT
                                - 64)) | (1L << (T_FOR - 64)) | (1L << (T_FOREIGN - 64)) | (1L
                                    << (T_FORMAT - 64)) | (1L << (T_FOUND - 64)) | (1L << (T_FROM
                                        - 64)) | (1L << (T_FULL - 64)) | (1L << (T_FUNCTION - 64))
                            | (1L << (T_GET - 64)) | (1L << (T_GLOBAL - 64)) | (1L << (T_GO - 64))
                            | (1L << (T_GRANT - 64)))) != 0)
                    || ((((_la - 129)) & ~0x3f) == 0
                        && ((1L << (_la - 129)) & ((1L << (T_GROUP - 129)) | (1L << (T_HANDLER
                            - 129)) | (1L << (T_HASH - 129)) | (1L << (T_HAVING - 129)) | (1L
                                << (T_HOST - 129)) | (1L << (T_IDENTITY - 129)) | (1L << (T_IF
                                    - 129)) | (1L << (T_IGNORE - 129)) | (1L << (T_IMMEDIATE - 129))
                            | (1L << (T_IN - 129)) | (1L << (T_INCLUDE - 129)) | (1L << (T_INDEX
                                - 129)) | (1L << (T_INITRANS - 129)) | (1L << (T_INNER - 129)) | (1L
                                    << (T_INOUT - 129)) | (1L << (T_INSERT - 129)) | (1L << (T_INT
                                        - 129)) | (1L << (T_INT2 - 129)) | (1L << (T_INT4 - 129))
                            | (1L << (T_INT8 - 129)) | (1L << (T_INTEGER - 129)) | (1L
                                << (T_INTERSECT - 129)) | (1L << (T_INTERVAL - 129)) | (1L
                                    << (T_INTO - 129)) | (1L << (T_INVOKER - 129)) | (1L << (T_IS
                                        - 129)) | (1L << (T_ISOPEN - 129)) | (1L << (T_ITEMS - 129))
                            | (1L << (T_JOIN - 129)) | (1L << (T_KEEP - 129)) | (1L << (T_KEY
                                - 129)) | (1L << (T_KEYS - 129)) | (1L << (T_LANGUAGE - 129)) | (1L
                                    << (T_LEAVE - 129)) | (1L << (T_LEFT - 129)) | (1L << (T_LIKE
                                        - 129)) | (1L << (T_LIMIT - 129)) | (1L << (T_LINES - 129))
                            | (1L << (T_LOCAL - 129)) | (1L << (T_LOCATION - 129)) | (1L
                                << (T_LOCATOR - 129)) | (1L << (T_LOCATORS - 129)) | (1L << (T_LOCKS
                                    - 129)) | (1L << (T_LOG - 129)) | (1L << (T_LOGGED - 129)) | (1L
                                        << (T_LOGGING - 129)) | (1L << (T_LOOP - 129)) | (1L
                                            << (T_MAP - 129)) | (1L << (T_MATCHED - 129)) | (1L
                                                << (T_MAX - 129)) | (1L << (T_MAXTRANS - 129)) | (1L
                                                    << (T_MERGE - 129)) | (1L << (T_MESSAGE_TEXT
                                                        - 129)) | (1L << (T_MICROSECOND - 129))
                            | (1L << (T_MICROSECONDS - 129)) | (1L << (T_MIN - 129)) | (1L
                                << (T_MULTISET - 129)) | (1L << (T_NCHAR - 129)) | (1L << (T_NEW
                                    - 129)))) != 0)
                    || ((((_la - 193)) & ~0x3f) == 0
                        && ((1L << (_la - 193)) & ((1L << (T_NVARCHAR - 193)) | (1L << (T_NO - 193))
                            | (1L << (T_NOCOUNT - 193)) | (1L << (T_NOCOMPRESS - 193)) | (1L
                                << (T_NOLOGGING - 193)) | (1L << (T_NONE - 193)) | (1L << (T_NOT
                                    - 193)) | (1L << (T_NOTFOUND - 193)) | (1L << (T_NUMERIC - 193))
                            | (1L << (T_NUMBER - 193)) | (1L << (T_OBJECT - 193)) | (1L << (T_OFF
                                - 193)) | (1L << (T_ON - 193)) | (1L << (T_ONLY - 193)) | (1L
                                    << (T_OPEN - 193)) | (1L << (T_OR - 193)) | (1L << (T_ORDER
                                        - 193)) | (1L << (T_OUT - 193)) | (1L << (T_OUTER - 193))
                            | (1L << (T_OVER - 193)) | (1L << (T_OVERWRITE - 193)) | (1L << (T_OWNER
                                - 193)) | (1L << (T_PACKAGE - 193)) | (1L << (T_PARTITION - 193))
                            | (1L << (T_PCTFREE - 193)) | (1L << (T_PCTUSED - 193)) | (1L
                                << (T_PRECISION - 193)) | (1L << (T_PRESERVE - 193)) | (1L
                                    << (T_PRIMARY - 193)) | (1L << (T_PRINT - 193)) | (1L << (T_PROC
                                        - 193)) | (1L << (T_PROCEDURE - 193)) | (1L << (T_QUALIFY
                                            - 193)) | (1L << (T_QUERY_BAND - 193)) | (1L << (T_QUIT
                                                - 193)) | (1L << (T_QUOTED_IDENTIFIER - 193)) | (1L
                                                    << (T_RAISE - 193)) | (1L << (T_REAL - 193))
                            | (1L << (T_REFERENCES - 193)) | (1L << (T_REGEXP - 193)) | (1L
                                << (T_REPLACE - 193)) | (1L << (T_RESIGNAL - 193)) | (1L
                                    << (T_RESTRICT - 193)) | (1L << (T_RESULT - 193)) | (1L
                                        << (T_RESULT_SET_LOCATOR - 193)) | (1L << (T_RETURN - 193))
                            | (1L << (T_RETURNS - 193)) | (1L << (T_REVERSE - 193)) | (1L
                                << (T_RIGHT - 193)) | (1L << (T_RLIKE - 193)) | (1L << (T_ROLE
                                    - 193)) | (1L << (T_ROLLBACK - 193)) | (1L << (T_ROW
                                        - 193)))) != 0)
                    || ((((_la - 257)) & ~0x3f) == 0
                        && ((1L << (_la - 257)) & ((1L << (T_ROWS - 257)) | (1L << (T_ROW_COUNT
                            - 257)) | (1L << (T_RR - 257)) | (1L << (T_RS - 257)) | (1L << (T_PWD
                                - 257)) | (1L << (T_TRIM - 257)) | (1L << (T_SCHEMA - 257)) | (1L
                                    << (T_SECOND - 257)) | (1L << (T_SECONDS - 257)) | (1L
                                        << (T_SECURITY - 257)) | (1L << (T_SEGMENT - 257)) | (1L
                                            << (T_SEL - 257)) | (1L << (T_SELECT - 257)) | (1L
                                                << (T_SET - 257)) | (1L << (T_SESSION - 257)) | (1L
                                                    << (T_SESSIONS - 257)) | (1L << (T_SETS - 257))
                            | (1L << (T_SIGNAL - 257)) | (1L << (T_SIMPLE_DOUBLE - 257)) | (1L
                                << (T_SIMPLE_FLOAT - 257)) | (1L << (T_SMALLDATETIME - 257)) | (1L
                                    << (T_SMALLINT - 257)) | (1L << (T_SQL - 257)) | (1L
                                        << (T_SQLEXCEPTION - 257)) | (1L << (T_SQLINSERT - 257))
                            | (1L << (T_SQLSTATE - 257)) | (1L << (T_SQLWARNING - 257)) | (1L
                                << (T_STATS - 257)) | (1L << (T_STATISTICS - 257)) | (1L << (T_STEP
                                    - 257)) | (1L << (T_STORAGE - 257)) | (1L << (T_STORE - 257))
                            | (1L << (T_STORED - 257)) | (1L << (T_STRING - 257)) | (1L << (T_SUBDIR
                                - 257)) | (1L << (T_SUBSTRING - 257)) | (1L << (T_SUM - 257)) | (1L
                                    << (T_SUMMARY - 257)) | (1L << (T_SYS_REFCURSOR - 257)) | (1L
                                        << (T_TABLE - 257)) | (1L << (T_TABLESPACE - 257)) | (1L
                                            << (T_TEMPORARY - 257)) | (1L << (T_TERMINATED - 257))
                            | (1L << (T_TEXTIMAGE_ON - 257)) | (1L << (T_THEN - 257)) | (1L
                                << (T_TIMESTAMP - 257)) | (1L << (T_TITLE - 257)) | (1L << (T_TO
                                    - 257)) | (1L << (T_TOP - 257)) | (1L << (T_TRANSACTION - 257))
                            | (1L << (T_TRUE - 257)) | (1L << (T_TRUNCATE - 257)))) != 0)
                    || ((((_la - 323)) & ~0x3f) == 0
                        && ((1L << (_la - 323)) & ((1L << (T_UNIQUE - 323)) | (1L << (T_UPDATE
                            - 323)) | (1L << (T_UR - 323)) | (1L << (T_USE - 323)) | (1L << (T_USING
                                - 323)) | (1L << (T_VALUE - 323)) | (1L << (T_VALUES - 323)) | (1L
                                    << (T_VAR - 323)) | (1L << (T_VARCHAR - 323)) | (1L
                                        << (T_VARCHAR2 - 323)) | (1L << (T_VARYING - 323)) | (1L
                                            << (T_VOLATILE - 323)) | (1L << (T_WHILE - 323)) | (1L
                                                << (T_WITH - 323)) | (1L << (T_WITHOUT - 323)) | (1L
                                                    << (T_WORK - 323)) | (1L << (T_XACT_ABORT
                                                        - 323)) | (1L << (T_XML - 323)) | (1L
                                                            << (T_YES - 323)) | (1L
                                                                << (T_ACTIVITY_COUNT - 323)) | (1L
                                                                    << (T_CUME_DIST - 323)) | (1L
                                                                        << (T_CURRENT_DATE - 323))
                            | (1L << (T_CURRENT_TIME - 323)) | (1L << (T_PI - 323)) | (1L
                                << (T_CURRENT_TIMESTAMP - 323)) | (1L << (T_CURRENT_USER - 323))
                            | (1L << (T_DENSE_RANK - 323)) | (1L << (T_FIRST_VALUE - 323)) | (1L
                                << (T_LAG - 323)) | (1L << (T_LAST_VALUE - 323)) | (1L << (T_LEAD
                                    - 323)) | (1L << (T_PART_COUNT - 323)) | (1L << (T_PART_LOC
                                        - 323)) | (1L << (T_RANK - 323)) | (1L << (T_ROW_NUMBER
                                            - 323)) | (1L << (T_STDEV - 323)) | (1L << (T_SYSDATE
                                                - 323)) | (1L << (T_VARIANCE - 323)) | (1L
                                                    << (T_USER - 323)))) != 0))) {
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
            case 70:
                return fromAliasClause_sempred((FromAliasClauseContext) _localctx, predIndex);
            case 86:
                return deleteAlias_sempred((DeleteAliasContext) _localctx, predIndex);
            case 88:
                return boolExpr_sempred((BoolExprContext) _localctx, predIndex);
            case 96:
                return expr_sempred((ExprContext) _localctx, predIndex);
            case 114:
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
        "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\u01a4\u0761\4\2\t"
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
            + "w\tw\4x\tx\4y\ty\4z\tz\4{\t{\4|\t|\4}\t}\4~\t~\4\177\t\177\4\u0080\t\u0080"
            + "\4\u0081\t\u0081\3\2\3\2\5\2\u0105\n\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3"
            + "\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\u011c\n\3\3\4"
            + "\3\4\5\4\u0120\n\4\3\4\3\4\3\5\3\5\3\5\5\5\u0127\n\5\3\5\5\5\u012a\n\5"
            + "\3\6\3\6\3\6\5\6\u012f\n\6\3\7\3\7\5\7\u0133\n\7\3\7\3\7\3\7\3\7\3\7\3"
            + "\7\3\7\5\7\u013c\n\7\3\7\3\7\3\7\5\7\u0141\n\7\3\b\3\b\3\b\3\b\7\b\u0147"
            + "\n\b\f\b\16\b\u014a\13\b\3\b\3\b\5\b\u014e\n\b\3\b\3\b\3\b\3\b\3\b\7\b"
            + "\u0155\n\b\f\b\16\b\u0158\13\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\7\t\u0161\n"
            + "\t\f\t\16\t\u0164\13\t\3\t\3\t\5\t\u0168\n\t\3\t\5\t\u016b\n\t\3\t\3\t"
            + "\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3"
            + "\f\5\f\u0180\n\f\3\r\3\r\3\r\3\r\3\r\5\r\u0187\n\r\3\r\3\r\5\r\u018b\n"
            + "\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\5\17\u0197\n\17\3\17"
            + "\3\17\3\17\3\17\3\17\5\17\u019e\n\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"
            + "\5\17\u01a7\n\17\3\17\5\17\u01aa\n\17\3\20\3\20\3\20\7\20\u01af\n\20\f"
            + "\20\16\20\u01b2\13\20\3\21\3\21\3\21\7\21\u01b7\n\21\f\21\16\21\u01ba"
            + "\13\21\3\21\7\21\u01bd\n\21\f\21\16\21\u01c0\13\21\3\21\3\21\5\21\u01c4"
            + "\n\21\3\21\3\21\3\21\3\21\5\21\u01ca\n\21\3\21\3\21\5\21\u01ce\n\21\5"
            + "\21\u01d0\n\21\3\22\3\22\3\22\3\22\7\22\u01d6\n\22\f\22\16\22\u01d9\13"
            + "\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\25\3\25\5\25\u01e4\n\25\3\25"
            + "\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\7\25\u01f0\n\25\f\25\16"
            + "\25\u01f3\13\25\3\25\3\25\3\25\3\25\3\25\7\25\u01fa\n\25\f\25\16\25\u01fd"
            + "\13\25\3\25\3\25\3\25\5\25\u0202\n\25\3\26\3\26\3\26\5\26\u0207\n\26\3"
            + "\26\3\26\3\26\5\26\u020c\n\26\3\26\3\26\3\26\5\26\u0211\n\26\7\26\u0213"
            + "\n\26\f\26\16\26\u0216\13\26\3\26\3\26\5\26\u021a\n\26\3\26\3\26\3\26"
            + "\3\26\3\26\3\26\7\26\u0222\n\26\f\26\16\26\u0225\13\26\3\26\3\26\3\26"
            + "\3\26\3\26\3\26\3\26\7\26\u022e\n\26\f\26\16\26\u0231\13\26\3\26\3\26"
            + "\7\26\u0235\n\26\f\26\16\26\u0238\13\26\5\26\u023a\n\26\3\27\3\27\3\27"
            + "\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u0246\n\27\3\30\6\30\u0249\n"
            + "\30\r\30\16\30\u024a\3\31\3\31\3\31\3\32\5\32\u0251\n\32\3\32\3\32\3\33"
            + "\6\33\u0256\n\33\r\33\16\33\u0257\3\34\3\34\3\34\3\34\3\34\5\34\u025f"
            + "\n\34\3\35\3\35\5\35\u0263\n\35\3\35\3\35\3\35\5\35\u0268\n\35\3\35\3"
            + "\35\5\35\u026c\n\35\3\35\3\35\3\35\5\35\u0271\n\35\3\35\5\35\u0274\n\35"
            + "\3\35\3\35\3\35\5\35\u0279\n\35\3\35\5\35\u027c\n\35\3\36\3\36\5\36\u0280"
            + "\n\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\7\36\u028a\n\36\f\36\16"
            + "\36\u028d\13\36\3\36\3\36\3\37\3\37\5\37\u0293\n\37\3 \3 \3 \3 \3 \3 "
            + "\3!\5!\u029c\n!\3!\3!\3!\5!\u02a1\n!\3!\3!\5!\u02a5\n!\5!\u02a7\n!\3\""
            + "\3\"\3\"\3#\5#\u02ad\n#\3#\3#\3#\3#\3#\5#\u02b4\n#\3#\5#\u02b7\n#\3$\3"
            + "$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3"
            + "$\5$\u02d2\n$\5$\u02d4\n$\3%\3%\3%\5%\u02d9\n%\3%\3%\5%\u02dd\n%\3%\3"
            + "%\3&\3&\3&\3&\3&\5&\u02e6\n&\3&\3&\7&\u02ea\n&\f&\16&\u02ed\13&\3\'\3"
            + "\'\3\'\3(\3(\3(\3(\5(\u02f6\n(\3(\3(\3)\3)\3)\3)\5)\u02fe\n)\3*\3*\3*"
            + "\3*\5*\u0304\n*\3*\3*\3+\3+\3+\3+\3+\5+\u030d\n+\5+\u030f\n+\3+\3+\5+"
            + "\u0313\n+\3+\3+\5+\u0317\n+\3,\3,\3,\3,\7,\u031d\n,\f,\16,\u0320\13,\3"
            + ",\3,\3-\3-\3-\3-\7-\u0328\n-\f-\16-\u032b\13-\3.\3.\3.\3.\7.\u0331\n."
            + "\f.\16.\u0334\13.\3.\3.\3/\3/\5/\u033a\n/\3/\3/\3\60\3\60\3\60\3\61\5"
            + "\61\u0342\n\61\3\61\3\61\3\62\3\62\3\62\3\62\7\62\u034a\n\62\f\62\16\62"
            + "\u034d\13\62\3\63\3\63\5\63\u0351\n\63\3\63\3\63\3\63\3\63\3\63\3\64\3"
            + "\64\3\64\3\64\7\64\u035c\n\64\f\64\16\64\u035f\13\64\3\64\3\64\3\65\3"
            + "\65\3\65\3\65\7\65\u0367\n\65\f\65\16\65\u036a\13\65\3\65\3\65\3\65\3"
            + "\65\5\65\u0370\n\65\3\66\3\66\3\66\3\66\3\66\5\66\u0377\n\66\3\67\3\67"
            + "\5\67\u037b\n\67\3\67\3\67\5\67\u037f\n\67\3\67\3\67\5\67\u0383\n\67\5"
            + "\67\u0385\n\67\38\38\38\58\u038a\n8\38\58\u038d\n8\38\58\u0390\n8\38\5"
            + "8\u0393\n8\38\38\58\u0397\n8\38\58\u039a\n8\38\58\u039d\n8\39\59\u03a0"
            + "\n9\39\59\u03a3\n9\39\39\39\79\u03a8\n9\f9\169\u03ab\139\3:\3:\3;\3;\3"
            + ";\3<\3<\3<\5<\u03b5\n<\3<\3<\5<\u03b9\n<\3<\5<\u03bc\n<\3=\5=\u03bf\n"
            + "=\3=\3=\5=\u03c3\n=\3=\3=\3=\3=\7=\u03c9\n=\f=\16=\u03cc\13=\3=\3=\3="
            + "\3=\3=\3=\5=\u03d4\n=\3>\3>\5>\u03d8\n>\3>\3>\3?\3?\3?\3?\7?\u03e0\n?"
            + "\f?\16?\u03e3\13?\3@\3@\3@\7@\u03e8\n@\f@\16@\u03eb\13@\3A\3A\3A\5A\u03f0"
            + "\nA\3B\3B\5B\u03f4\nB\3B\5B\u03f7\nB\3C\3C\3C\3C\5C\u03fd\nC\3D\3D\3D"
            + "\3D\3D\3D\3D\5D\u0406\nD\3E\5E\u0409\nE\3E\3E\3E\5E\u040e\nE\3E\5E\u0411"
            + "\nE\3F\3F\3F\3F\3F\3F\7F\u0419\nF\fF\16F\u041c\13F\3F\3F\5F\u0420\nF\3"
            + "G\3G\3G\3G\3G\7G\u0427\nG\fG\16G\u042a\13G\3G\3G\5G\u042e\nG\3H\3H\5H"
            + "\u0432\nH\3H\3H\3H\3H\3H\7H\u0439\nH\fH\16H\u043c\13H\3H\5H\u043f\nH\3"
            + "I\3I\3J\3J\3J\3K\3K\3K\3K\3K\7K\u044b\nK\fK\16K\u044e\13K\3L\3L\3L\3M"
            + "\3M\3M\3N\3N\3N\3N\3N\7N\u045b\nN\fN\16N\u045e\13N\3O\3O\5O\u0462\nO\3"
            + "P\3P\3P\3P\3P\3P\3Q\6Q\u046b\nQ\rQ\16Q\u046c\3R\3R\3R\3R\3R\3R\3R\3R\3"
            + "R\5R\u0478\nR\5R\u047a\nR\3S\3S\3S\3S\3S\5S\u0481\nS\3S\5S\u0484\nS\3"
            + "T\3T\3T\7T\u0489\nT\fT\16T\u048c\13T\3U\3U\5U\u0490\nU\3U\3U\3U\3U\5U"
            + "\u0496\nU\3U\5U\u0499\nU\3U\5U\u049c\nU\3V\3V\3V\3W\3W\5W\u04a3\nW\3W"
            + "\3W\5W\u04a7\nW\3W\3W\5W\u04ab\nW\3X\3X\5X\u04af\nX\3X\3X\3Y\3Y\5Y\u04b5"
            + "\nY\3Y\3Y\3Z\3Z\5Z\u04bb\nZ\3Z\3Z\3Z\3Z\3Z\5Z\u04c2\nZ\3Z\3Z\3Z\3Z\7Z"
            + "\u04c8\nZ\fZ\16Z\u04cb\13Z\3[\3[\3[\5[\u04d0\n[\3\\\3\\\3\\\5\\\u04d5"
            + "\n\\\3\\\3\\\3\\\3\\\3\\\3\\\3\\\3\\\3\\\5\\\u04e0\n\\\3\\\3\\\3\\\3\\"
            + "\3\\\3\\\3\\\5\\\u04e9\n\\\3]\3]\5]\u04ed\n]\3]\3]\3]\3]\3]\7]\u04f4\n"
            + "]\f]\16]\u04f7\13]\3]\5]\u04fa\n]\3]\3]\3^\3^\3^\3^\7^\u0502\n^\f^\16"
            + "^\u0505\13^\3^\3^\5^\u0509\n^\3^\3^\3^\3^\3^\3_\3_\3_\3_\3`\3`\3a\3a\3"
            + "a\3a\3a\3a\3a\3a\3a\5a\u051f\na\3a\5a\u0522\na\3b\3b\3b\3b\3b\3b\3b\3"
            + "b\3b\3b\3b\3b\3b\3b\3b\3b\3b\5b\u0535\nb\3b\3b\3b\3b\3b\3b\3b\3b\3b\3"
            + "b\3b\3b\3b\3b\7b\u0545\nb\fb\16b\u0548\13b\3c\3c\3c\3c\3c\3c\3c\3c\5c"
            + "\u0552\nc\3d\3d\3d\3d\3e\3e\3f\3f\3f\3f\3f\7f\u055f\nf\ff\16f\u0562\13"
            + "f\3g\3g\3g\3g\3g\3g\3g\3g\3g\5g\u056d\ng\3h\3h\5h\u0571\nh\3i\3i\3i\3"
            + "i\3i\3i\3i\6i\u057a\ni\ri\16i\u057b\3i\3i\5i\u0580\ni\3i\3i\3j\3j\6j\u0586"
            + "\nj\rj\16j\u0587\3j\3j\5j\u058c\nj\3j\3j\3k\3k\3k\3k\3k\3l\3l\3l\3l\3"
            + "m\3m\3m\5m\u059c\nm\3m\3m\3m\5m\u05a1\nm\3m\3m\3m\5m\u05a6\nm\3m\3m\5"
            + "m\u05aa\nm\3m\3m\5m\u05ae\nm\3m\3m\3m\5m\u05b3\nm\3m\3m\5m\u05b7\nm\3"
            + "m\3m\5m\u05bb\nm\3m\3m\3m\3m\3m\3m\3m\3m\3m\3m\3m\3m\3m\3m\3m\3m\3m\3"
            + "m\3m\3m\3m\5m\u05d2\nm\5m\u05d4\nm\3m\3m\3m\3m\3m\3m\3m\3m\3m\3m\3m\3"
            + "m\3m\3m\3m\3m\5m\u05e6\nm\5m\u05e8\nm\3m\3m\3m\3m\3m\3m\5m\u05f0\nm\3"
            + "m\3m\3m\5m\u05f5\nm\3m\3m\3m\5m\u05fa\nm\3m\3m\3m\5m\u05ff\nm\3m\3m\3"
            + "m\3m\3m\3m\3m\3m\3m\3m\3m\5m\u060c\nm\3m\3m\3m\5m\u0611\nm\3m\3m\3m\5"
            + "m\u0616\nm\3m\3m\3m\5m\u061b\nm\3m\3m\3m\5m\u0620\nm\3m\3m\3m\5m\u0625"
            + "\nm\3m\3m\3m\5m\u062a\nm\3m\3m\3m\5m\u062f\nm\5m\u0631\nm\3n\3n\3o\3o"
            + "\3o\5o\u0638\no\3o\5o\u063b\no\3o\3o\3p\3p\3p\3p\3p\7p\u0644\np\fp\16"
            + "p\u0647\13p\3q\3q\3q\3q\3q\3q\3q\5q\u0650\nq\3q\3q\3q\3q\3q\3q\5q\u0658"
            + "\nq\3q\3q\3q\3q\3q\3q\3q\3q\3q\5q\u0663\nq\3q\3q\3q\3q\5q\u0669\nq\3q"
            + "\3q\3q\3q\3q\3q\3q\3q\3q\3q\3q\3q\3q\7q\u0678\nq\fq\16q\u067b\13q\5q\u067d"
            + "\nq\3q\3q\3q\3q\3q\3q\3q\3q\3q\3q\3q\3q\7q\u068b\nq\fq\16q\u068e\13q\5"
            + "q\u0690\nq\3q\3q\3q\3q\3q\3q\3q\3q\3q\3q\3q\3q\7q\u069e\nq\fq\16q\u06a1"
            + "\13q\5q\u06a3\nq\3q\3q\3q\3q\3q\3q\3q\3q\3q\3q\3q\3q\7q\u06b1\nq\fq\16"
            + "q\u06b4\13q\5q\u06b6\nq\3q\3q\3q\3q\3q\3q\3q\3q\3q\3q\3q\3q\7q\u06c4\n"
            + "q\fq\16q\u06c7\13q\5q\u06c9\nq\3q\3q\3q\3q\3q\3q\3q\3q\3q\3q\3q\3q\7q"
            + "\u06d7\nq\fq\16q\u06da\13q\5q\u06dc\nq\3q\3q\3q\3q\3q\3q\3q\3q\3q\3q\7"
            + "q\u06e8\nq\fq\16q\u06eb\13q\3q\3q\3q\3q\3q\3q\3q\3q\3q\3q\6q\u06f7\nq"
            + "\rq\16q\u06f8\3q\3q\5q\u06fd\nq\3q\3q\3q\3q\3q\3q\3q\3q\3q\5q\u0708\n"
            + "q\3q\3q\3q\3q\5q\u070e\nq\3r\3r\3r\5r\u0713\nr\3r\3r\3s\3s\3s\7s\u071a"
            + "\ns\fs\16s\u071d\13s\3t\3t\3t\3t\3t\5t\u0724\nt\5t\u0726\nt\3t\3t\5t\u072a"
            + "\nt\3u\3u\3v\3v\3w\3w\3w\7w\u0733\nw\fw\16w\u0736\13w\3x\3x\3x\3y\3y\3"
            + "y\3z\5z\u073f\nz\3z\3z\3z\7z\u0744\nz\fz\16z\u0747\13z\3{\3{\5{\u074b"
            + "\n{\3|\3|\5|\u074f\n|\3}\5}\u0752\n}\3}\3}\3~\5~\u0757\n~\3~\3~\3\177"
            + "\3\177\3\u0080\3\u0080\3\u0081\3\u0081\3\u0081\2\4\u00b2\u00c2\u0082\2"
            + "\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJL"
            + "NPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a\u008c\u008e"
            + "\u0090\u0092\u0094\u0096\u0098\u009a\u009c\u009e\u00a0\u00a2\u00a4\u00a6"
            + "\u00a8\u00aa\u00ac\u00ae\u00b0\u00b2\u00b4\u00b6\u00b8\u00ba\u00bc\u00be"
            + "\u00c0\u00c2\u00c4\u00c6\u00c8\u00ca\u00cc\u00ce\u00d0\u00d2\u00d4\u00d6"
            + "\u00d8\u00da\u00dc\u00de\u00e0\u00e2\u00e4\u00e6\u00e8\u00ea\u00ec\u00ee"
            + "\u00f0\u00f2\u00f4\u00f6\u00f8\u00fa\u00fc\u00fe\u0100\2\35\5\2NN\u0193"
            + "\u0193\u019c\u019c\4\2\20\20\u0130\u0130\4\2\r\rVV\4\2SS\u0146\u0146\4"
            + "\2pp\u00b3\u00b3\4\2SS\u00e2\u00e2\4\2%%@@\4\2\u0104\u0104\u0143\u0143"
            + "\4\2\u00b9\u00b9\u019f\u019f\4\2  \'\'\4\2DD\u010b\u010b\4\2NN\u019c\u019c"
            + "\3\2\u0110\u0111\4\2\6\6[[\5\2||\u00a9\u00a9\u00fe\u00fe\5\2@@\u0106\u0107"
            + "\u0147\u0147\4\2mm\u0146\u0146\3\2VW\4\2\u0131\u0131\u0133\u0133\4\2\t"
            + "\t\u00d3\u00d3\5\2\u00aa\u00aa\u00f3\u00f3\u00ff\u00ff\5\2IJ\u00bd\u00be"
            + "\u010c\u010d\4\2\66\66\u0187\u0187\5\2zz\u009f\u009f\u00ca\u00ca\4\2\u0184"
            + "\u0184\u019b\u019b\4\2qq\u0141\u0141$\2\4\17\23\31\33\35\37\61\63<>DF"
            + "aeeg\u0081\u0083\u0088\u008a\u008e\u0090\u00a2\u00a4\u00a5\u00a7\u00ac"
            + "\u00ae\u00ca\u00cc\u00db\u00dd\u00de\u00e1\u00e2\u00e4\u00e7\u00ec\u00f3"
            + "\u00f5\u00fc\u00fe\u0103\u0105\u0109\u010b\u0115\u0117\u0119\u011b\u0121"
            + "\u0123\u0124\u0126\u012f\u0131\u0131\u0136\u013b\u013d\u0142\u0145\u0150"
            + "\u0153\u0165\u016c\u0173\2\u0846\2\u0102\3\2\2\2\4\u011b\3\2\2\2\6\u011f"
            + "\3\2\2\2\b\u0129\3\2\2\2\n\u012e\3\2\2\2\f\u0140\3\2\2\2\16\u0142\3\2"
            + "\2\2\20\u0167\3\2\2\2\22\u0171\3\2\2\2\24\u0176\3\2\2\2\26\u0179\3\2\2"
            + "\2\30\u0181\3\2\2\2\32\u018e\3\2\2\2\34\u01a6\3\2\2\2\36\u01ab\3\2\2\2"
            + " \u01cf\3\2\2\2\"\u01d1\3\2\2\2$\u01dc\3\2\2\2&\u01df\3\2\2\2(\u0201\3"
            + "\2\2\2*\u0239\3\2\2\2,\u023b\3\2\2\2.\u0248\3\2\2\2\60\u024c\3\2\2\2\62"
            + "\u0250\3\2\2\2\64\u0255\3\2\2\2\66\u025e\3\2\2\28\u027b\3\2\2\2:\u027d"
            + "\3\2\2\2<\u0290\3\2\2\2>\u0294\3\2\2\2@\u02a6\3\2\2\2B\u02a8\3\2\2\2D"
            + "\u02b6\3\2\2\2F\u02d3\3\2\2\2H\u02d5\3\2\2\2J\u02e0\3\2\2\2L\u02ee\3\2"
            + "\2\2N\u02f1\3\2\2\2P\u02fd\3\2\2\2R\u02ff\3\2\2\2T\u0307\3\2\2\2V\u0318"
            + "\3\2\2\2X\u0323\3\2\2\2Z\u032c\3\2\2\2\\\u0337\3\2\2\2^\u033d\3\2\2\2"
            + "`\u0341\3\2\2\2b\u0345\3\2\2\2d\u034e\3\2\2\2f\u0357\3\2\2\2h\u036f\3"
            + "\2\2\2j\u0376\3\2\2\2l\u0384\3\2\2\2n\u0386\3\2\2\2p\u039f\3\2\2\2r\u03ac"
            + "\3\2\2\2t\u03ae\3\2\2\2v\u03bb\3\2\2\2x\u03d3\3\2\2\2z\u03d7\3\2\2\2|"
            + "\u03db\3\2\2\2~\u03e4\3\2\2\2\u0080\u03ef\3\2\2\2\u0082\u03f1\3\2\2\2"
            + "\u0084\u03f8\3\2\2\2\u0086\u0405\3\2\2\2\u0088\u0410\3\2\2\2\u008a\u0412"
            + "\3\2\2\2\u008c\u042d\3\2\2\2\u008e\u042f\3\2\2\2\u0090\u0440\3\2\2\2\u0092"
            + "\u0442\3\2\2\2\u0094\u0445\3\2\2\2\u0096\u044f\3\2\2\2\u0098\u0452\3\2"
            + "\2\2\u009a\u0455\3\2\2\2\u009c\u045f\3\2\2\2\u009e\u0463\3\2\2\2\u00a0"
            + "\u046a\3\2\2\2\u00a2\u0479\3\2\2\2\u00a4\u047b\3\2\2\2\u00a6\u0485\3\2"
            + "\2\2\u00a8\u0495\3\2\2\2\u00aa\u049d\3\2\2\2\u00ac\u04a0\3\2\2\2\u00ae"
            + "\u04ac\3\2\2\2\u00b0\u04b2\3\2\2\2\u00b2\u04c1\3\2\2\2\u00b4\u04cf\3\2"
            + "\2\2\u00b6\u04e8\3\2\2\2\u00b8\u04ea\3\2\2\2\u00ba\u04fd\3\2\2\2\u00bc"
            + "\u050f\3\2\2\2\u00be\u0513\3\2\2\2\u00c0\u0521\3\2\2\2\u00c2\u0534\3\2"
            + "\2\2\u00c4\u0551\3\2\2\2\u00c6\u0553\3\2\2\2\u00c8\u0557\3\2\2\2\u00ca"
            + "\u0559\3\2\2\2\u00cc\u056c\3\2\2\2\u00ce\u0570\3\2\2\2\u00d0\u0572\3\2"
            + "\2\2\u00d2\u0583\3\2\2\2\u00d4\u058f\3\2\2\2\u00d6\u0594\3\2\2\2\u00d8"
            + "\u0630\3\2\2\2\u00da\u0632\3\2\2\2\u00dc\u0634\3\2\2\2\u00de\u063e\3\2"
            + "\2\2\u00e0\u070d\3\2\2\2\u00e2\u070f\3\2\2\2\u00e4\u0716\3\2\2\2\u00e6"
            + "\u0729\3\2\2\2\u00e8\u072b\3\2\2\2\u00ea\u072d\3\2\2\2\u00ec\u072f\3\2"
            + "\2\2\u00ee\u0737\3\2\2\2\u00f0\u073a\3\2\2\2\u00f2\u073e\3\2\2\2\u00f4"
            + "\u074a\3\2\2\2\u00f6\u074e\3\2\2\2\u00f8\u0751\3\2\2\2\u00fa\u0756\3\2"
            + "\2\2\u00fc\u075a\3\2\2\2\u00fe\u075c\3\2\2\2\u0100\u075e\3\2\2\2\u0102"
            + "\u0104\5\4\3\2\u0103\u0105\7\u019a\2\2\u0104\u0103\3\2\2\2\u0104\u0105"
            + "\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u0107\7\2\2\3\u0107\3\3\2\2\2\u0108"
            + "\u011c\5J&\2\u0109\u011c\5\30\r\2\u010a\u011c\5:\36\2\u010b\u011c\5\u00b0"
            + "Y\2\u010c\u011c\5N(\2\u010d\u011c\5R*\2\u010e\u011c\5> \2\u010f\u011c"
            + "\5\\/\2\u0110\u011c\5^\60\2\u0111\u011c\5L\'\2\u0112\u011c\5B\"\2\u0113"
            + "\u011c\5\22\n\2\u0114\u011c\5\24\13\2\u0115\u011c\5\26\f\2\u0116\u011c"
            + "\5T+\2\u0117\u011c\5\u00a4S\2\u0118\u011c\5\u00acW\2\u0119\u011c\5`\61"
            + "\2\u011a\u011c\5\32\16\2\u011b\u0108\3\2\2\2\u011b\u0109\3\2\2\2\u011b"
            + "\u010a\3\2\2\2\u011b\u010b\3\2\2\2\u011b\u010c\3\2\2\2\u011b\u010d\3\2"
            + "\2\2\u011b\u010e\3\2\2\2\u011b\u010f\3\2\2\2\u011b\u0110\3\2\2\2\u011b"
            + "\u0111\3\2\2\2\u011b\u0112\3\2\2\2\u011b\u0113\3\2\2\2\u011b\u0114\3\2"
            + "\2\2\u011b\u0115\3\2\2\2\u011b\u0116\3\2\2\2\u011b\u0117\3\2\2\2\u011b"
            + "\u0118\3\2\2\2\u011b\u0119\3\2\2\2\u011b\u011a\3\2\2\2\u011c\5\3\2\2\2"
            + "\u011d\u011e\t\2\2\2\u011e\u0120\7\u0189\2\2\u011f\u011d\3\2\2\2\u011f"
            + "\u0120\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u0122\t\2\2\2\u0122\7\3\2\2\2"
            + "\u0123\u012a\5\6\4\2\u0124\u0125\7\u019c\2\2\u0125\u0127\7\u0189\2\2\u0126"
            + "\u0124\3\2\2\2\u0126\u0127\3\2\2\2\u0127\u0128\3\2\2\2\u0128\u012a\5\6"
            + "\4\2\u0129\u0123\3\2\2\2\u0129\u0126\3\2\2\2\u012a\t\3\2\2\2\u012b\u012f"
            + "\5\f\7\2\u012c\u012f\5\16\b\2\u012d\u012f\5\20\t\2\u012e\u012b\3\2\2\2"
            + "\u012e\u012c\3\2\2\2\u012e\u012d\3\2\2\2\u012f\13\3\2\2\2\u0130\u0132"
            + "\5\u00f2z\2\u0131\u0133\7\u0185\2\2\u0132\u0131\3\2\2\2\u0132\u0133\3"
            + "\2\2\2\u0133\u0134\3\2\2\2\u0134\u0135\7\u018b\2\2\u0135\u0136\5\u00c2"
            + "b\2\u0136\u0141\3\2\2\2\u0137\u0138\7\u0195\2\2\u0138\u0139\5\u00f2z\2"
            + "\u0139\u013b\7\u0198\2\2\u013a\u013c\7\u0185\2\2\u013b\u013a\3\2\2\2\u013b"
            + "\u013c\3\2\2\2\u013c\u013d\3\2\2\2\u013d\u013e\7\u018b\2\2\u013e\u013f"
            + "\5\u00c2b\2\u013f\u0141\3\2\2\2\u0140\u0130\3\2\2\2\u0140\u0137\3\2\2"
            + "\2\u0141\r\3\2\2\2\u0142\u0143\7\u0195\2\2\u0143\u0148\5\u00f2z\2\u0144"
            + "\u0145\7\u0186\2\2\u0145\u0147\5\u00f2z\2\u0146\u0144\3\2\2\2\u0147\u014a"
            + "\3\2\2\2\u0148\u0146\3\2\2\2\u0148\u0149\3\2\2\2\u0149\u014b\3\2\2\2\u014a"
            + "\u0148\3\2\2\2\u014b\u014d\7\u0198\2\2\u014c\u014e\7\u0185\2\2\u014d\u014c"
            + "\3\2\2\2\u014d\u014e\3\2\2\2\u014e\u014f\3\2\2\2\u014f\u0150\7\u018b\2"
            + "\2\u0150\u0151\7\u0195\2\2\u0151\u0156\5\u00c2b\2\u0152\u0153\7\u0186"
            + "\2\2\u0153\u0155\5\u00c2b\2\u0154\u0152\3\2\2\2\u0155\u0158\3\2\2\2\u0156"
            + "\u0154\3\2\2\2\u0156\u0157\3\2\2\2\u0157\u0159\3\2\2\2\u0158\u0156\3\2"
            + "\2\2\u0159\u015a\7\u0198\2\2\u015a\17\3\2\2\2\u015b\u0168\5\u00f2z\2\u015c"
            + "\u015d\7\u0195\2\2\u015d\u0162\5\u00f2z\2\u015e\u015f\7\u0186\2\2\u015f"
            + "\u0161\5\u00f2z\2\u0160\u015e\3\2\2\2\u0161\u0164\3\2\2\2\u0162\u0160"
            + "\3\2\2\2\u0162\u0163\3\2\2\2\u0163\u0165\3\2\2\2\u0164\u0162\3\2\2\2\u0165"
            + "\u0166\7\u0198\2\2\u0166\u0168\3\2\2\2\u0167\u015b\3\2\2\2\u0167\u015c"
            + "\3\2\2\2\u0168\u016a\3\2\2\2\u0169\u016b\7\u0185\2\2\u016a\u0169\3\2\2"
            + "\2\u016a\u016b\3\2\2\2\u016b\u016c\3\2\2\2\u016c\u016d\7\u018b\2\2\u016d"
            + "\u016e\7\u0195\2\2\u016e\u016f\5`\61\2\u016f\u0170\7\u0198\2\2\u0170\21"
            + "\3\2\2\2\u0171\u0172\7\u0116\2\2\u0172\u0173\7=\2\2\u0173\u0174\7\u0131"
            + "\2\2\u0174\u0175\5\u00f2z\2\u0175\23\3\2\2\2\u0176\u0177\7\u0116\2\2\u0177"
            + "\u0178\7\u0125\2\2\u0178\25\3\2\2\2\u0179\u017a\7\u0116\2\2\u017a\u017b"
            + "\7\u0090\2\2\u017b\u017c\7{\2\2\u017c\u017f\5\u0090I\2\u017d\u017e\7{"
            + "\2\2\u017e\u0180\7\u019c\2\2\u017f\u017d\3\2\2\2\u017f\u0180\3\2\2\2\u0180"
            + "\27\3\2\2\2\u0181\u0182\7=\2\2\u0182\u0186\7\u0131\2\2\u0183\u0184\7\u008a"
            + "\2\2\u0184\u0185\7\u00c9\2\2\u0185\u0187\7n\2\2\u0186\u0183\3\2\2\2\u0186"
            + "\u0187\3\2\2\2\u0187\u0188\3\2\2\2\u0188\u018a\5\u00e8u\2\u0189\u018b"
            + "\5.\30\2\u018a\u0189\3\2\2\2\u018a\u018b\3\2\2\2\u018b\u018c\3\2\2\2\u018c"
            + "\u018d\5\34\17\2\u018d\31\3\2\2\2\u018e\u018f\7=\2\2\u018f\u0190\7\u0173"
            + "\2\2\u0190\u0191\5\u00eav\2\u0191\u0192\7\u0089\2\2\u0192\u0193\7\37\2"
            + "\2\u0193\u0194\5\u00f6|\2\u0194\33\3\2\2\2\u0195\u0197\7\f\2\2\u0196\u0195"
            + "\3\2\2\2\u0196\u0197\3\2\2\2\u0197\u0198\3\2\2\2\u0198\u0199\7\u0195\2"
            + "\2\u0199\u019a\5`\61\2\u019a\u019b\7\u0198\2\2\u019b\u01a7\3\2\2\2\u019c"
            + "\u019e\7\f\2\2\u019d\u019c\3\2\2\2\u019d\u019e\3\2\2\2\u019e\u019f\3\2"
            + "\2\2\u019f\u01a7\5`\61\2\u01a0\u01a1\7\u0195\2\2\u01a1\u01a2\5\36\20\2"
            + "\u01a2\u01a3\7\u0198\2\2\u01a3\u01a7\3\2\2\2\u01a4\u01a5\7\u00aa\2\2\u01a5"
            + "\u01a7\5\u00e8u\2\u01a6\u0196\3\2\2\2\u01a6\u019d\3\2\2\2\u01a6\u01a0"
            + "\3\2\2\2\u01a6\u01a4\3\2\2\2\u01a7\u01a9\3\2\2\2\u01a8\u01aa\5\64\33\2"
            + "\u01a9\u01a8\3\2\2\2\u01a9\u01aa\3\2\2\2\u01aa\35\3\2\2\2\u01ab\u01b0"
            + "\5 \21\2\u01ac\u01ad\7\u0186\2\2\u01ad\u01af\5 \21\2\u01ae\u01ac\3\2\2"
            + "\2\u01af\u01b2\3\2\2\2\u01b0\u01ae\3\2\2\2\u01b0\u01b1\3\2\2\2\u01b1\37"
            + "\3\2\2\2\u01b2\u01b0\3\2\2\2\u01b3\u01b4\5&\24\2\u01b4\u01b8\5F$\2\u01b5"
            + "\u01b7\5D#\2\u01b6\u01b5\3\2\2\2\u01b7\u01ba\3\2\2\2\u01b8\u01b6\3\2\2"
            + "\2\u01b8\u01b9\3\2\2\2\u01b9\u01be\3\2\2\2\u01ba\u01b8\3\2\2\2\u01bb\u01bd"
            + "\5(\25\2\u01bc\u01bb\3\2\2\2\u01bd\u01c0\3\2\2\2\u01be\u01bc\3\2\2\2\u01be"
            + "\u01bf\3\2\2\2\u01bf\u01d0\3\2\2\2\u01c0\u01be\3\2\2\2\u01c1\u01c2\78"
            + "\2\2\u01c2\u01c4\5\u00ecw\2\u01c3\u01c1\3\2\2\2\u01c3\u01c4\3\2\2\2\u01c4"
            + "\u01c5\3\2\2\2\u01c5\u01d0\5*\26\2\u01c6\u01c7\t\3\2\2\u01c7\u01c9\7\u0090"
            + "\2\2\u01c8\u01ca\5\u00f2z\2\u01c9\u01c8\3\2\2\2\u01c9\u01ca\3\2\2\2\u01ca"
            + "\u01cb\3\2\2\2\u01cb\u01cd\5\"\22\2\u01cc\u01ce\5$\23\2\u01cd\u01cc\3"
            + "\2\2\2\u01cd\u01ce\3\2\2\2\u01ce\u01d0\3\2\2\2\u01cf\u01b3\3\2\2\2\u01cf"
            + "\u01c3\3\2\2\2\u01cf\u01c6\3\2\2\2\u01d0!\3\2\2\2\u01d1\u01d2\7\u0195"
            + "\2\2\u01d2\u01d7\5\u00ecw\2\u01d3\u01d4\7\u0186\2\2\u01d4\u01d6\5\u00ec"
            + "w\2\u01d5\u01d3\3\2\2\2\u01d6\u01d9\3\2\2\2\u01d7\u01d5\3\2\2\2\u01d7"
            + "\u01d8\3\2\2\2\u01d8\u01da\3\2\2\2\u01d9\u01d7\3\2\2\2\u01da\u01db\7\u0198"
            + "\2\2\u01db#\3\2\2\2\u01dc\u01dd\7\u0143\2\2\u01dd\u01de\5\u00f2z\2\u01de"
            + "%\3\2\2\2\u01df\u01e0\5\u00ecw\2\u01e0\'\3\2\2\2\u01e1\u0202\5@!\2\u01e2"
            + "\u01e4\7\u00c9\2\2\u01e3\u01e2\3\2\2\2\u01e3\u01e4\3\2\2\2\u01e4\u01e5"
            + "\3\2\2\2\u01e5\u0202\7\u00cb\2\2\u01e6\u01e7\7\u00e4\2\2\u01e7\u0202\7"
            + "\u00a4\2\2\u01e8\u0202\7\u0145\2\2\u01e9\u01ea\7\u00f2\2\2\u01ea\u01eb"
            + "\5\u00e8u\2\u01eb\u01ec\7\u0195\2\2\u01ec\u01ed\5\u00ecw\2\u01ed\u01f1"
            + "\7\u0198\2\2\u01ee\u01f0\5,\27\2\u01ef\u01ee\3\2\2\2\u01f0\u01f3\3\2\2"
            + "\2\u01f1\u01ef\3\2\2\2\u01f1\u01f2\3\2\2\2\u01f2\u0202\3\2\2\2\u01f3\u01f1"
            + "\3\2\2\2\u01f4\u01f5\7\u0088\2\2\u01f5\u01f6\7\u0195\2\2\u01f6\u01fb\7"
            + "\u019f\2\2\u01f7\u01f8\7\u0186\2\2\u01f8\u01fa\7\u019f\2\2\u01f9\u01f7"
            + "\3\2\2\2\u01fa\u01fd\3\2\2\2\u01fb\u01f9\3\2\2\2\u01fb\u01fc\3\2\2\2\u01fc"
            + "\u01fe\3\2\2\2\u01fd\u01fb\3\2\2\2\u01fe\u0202\7\u0198\2\2\u01ff\u0202"
            + "\7\22\2\2\u0200\u0202\7e\2\2\u0201\u01e1\3\2\2\2\u0201\u01e3\3\2\2\2\u0201"
            + "\u01e6\3\2\2\2\u0201\u01e8\3\2\2\2\u0201\u01e9\3\2\2\2\u0201\u01f4\3\2"
            + "\2\2\u0201\u01ff\3\2\2\2\u0201\u0200\3\2\2\2\u0202)\3\2\2\2\u0203\u0204"
            + "\7\u00e4\2\2\u0204\u0206\7\u00a4\2\2\u0205\u0207\7,\2\2\u0206\u0205\3"
            + "\2\2\2\u0206\u0207\3\2\2\2\u0207\u0208\3\2\2\2\u0208\u0209\7\u0195\2\2"
            + "\u0209\u020b\5\u00ecw\2\u020a\u020c\t\4\2\2\u020b\u020a\3\2\2\2\u020b"
            + "\u020c\3\2\2\2\u020c\u0214\3\2\2\2\u020d\u020e\7\u0186\2\2\u020e\u0210"
            + "\5\u00ecw\2\u020f\u0211\t\4\2\2\u0210\u020f\3\2\2\2\u0210\u0211\3\2\2"
            + "\2\u0211\u0213\3\2\2\2\u0212\u020d\3\2\2\2\u0213\u0216\3\2\2\2\u0214\u0212"
            + "\3\2\2\2\u0214\u0215\3\2\2\2\u0215\u0217\3\2\2\2\u0216\u0214\3\2\2\2\u0217"
            + "\u0219\7\u0198\2\2\u0218\u021a\7e\2\2\u0219\u0218\3\2\2\2\u0219\u021a"
            + "\3\2\2\2\u021a\u023a\3\2\2\2\u021b\u021c\7x\2\2\u021c\u021d\7\u00a4\2"
            + "\2\u021d\u021e\7\u0195\2\2\u021e\u0223\5\u00ecw\2\u021f\u0220\7\u0186"
            + "\2\2\u0220\u0222\5\u00ecw\2\u0221\u021f\3\2\2\2\u0222\u0225\3\2\2\2\u0223"
            + "\u0221\3\2\2\2\u0223\u0224\3\2\2\2\u0224\u0226\3\2\2\2\u0225\u0223\3\2"
            + "\2\2\u0226\u0227\7\u0198\2\2\u0227\u0228\7\u00f2\2\2\u0228\u0229\5\u00e8"
            + "u\2\u0229\u022a\7\u0195\2\2\u022a\u022f\5\u00ecw\2\u022b\u022c\7\u0186"
            + "\2\2\u022c\u022e\5\u00ecw\2\u022d\u022b\3\2\2\2\u022e\u0231\3\2\2\2\u022f"
            + "\u022d\3\2\2\2\u022f\u0230\3\2\2\2\u0230\u0232\3\2\2\2\u0231\u022f\3\2"
            + "\2\2\u0232\u0236\7\u0198\2\2\u0233\u0235\5,\27\2\u0234\u0233\3\2\2\2\u0235"
            + "\u0238\3\2\2\2\u0236\u0234\3\2\2\2\u0236\u0237\3\2\2\2\u0237\u023a\3\2"
            + "\2\2\u0238\u0236\3\2\2\2\u0239\u0203\3\2\2\2\u0239\u021b\3\2\2\2\u023a"
            + "+\3\2\2\2\u023b\u023c\7\u00d0\2\2\u023c\u0245\t\5\2\2\u023d\u023e\7\u00c4"
            + "\2\2\u023e\u0246\7\4\2\2\u023f\u0246\7\u00f7\2\2\u0240\u0241\7\u0112\2"
            + "\2\u0241\u0246\7\u00cb\2\2\u0242\u0243\7\u0112\2\2\u0243\u0246\7N\2\2"
            + "\u0244\u0246\7#\2\2\u0245\u023d\3\2\2\2\u0245\u023f\3\2\2\2\u0245\u0240"
            + "\3\2\2\2\u0245\u0242\3\2\2\2\u0245\u0244\3\2\2\2\u0246-\3\2\2\2\u0247"
            + "\u0249\5\60\31\2\u0248\u0247\3\2\2\2\u0249\u024a\3\2\2\2\u024a\u0248\3"
            + "\2\2\2\u024a\u024b\3\2\2\2\u024b/\3\2\2\2\u024c\u024d\7\u0186\2\2\u024d"
            + "\u024e\5\62\32\2\u024e\61\3\2\2\2\u024f\u0251\7\u00c4\2\2\u0250\u024f"
            + "\3\2\2\2\u0250\u0251\3\2\2\2\u0251\u0252\3\2\2\2\u0252\u0253\t\6\2\2\u0253"
            + "\63\3\2\2\2\u0254\u0256\5\66\34\2\u0255\u0254\3\2\2\2\u0256\u0257\3\2"
            + "\2\2\u0257\u0255\3\2\2\2\u0257\u0258\3\2\2\2\u0258\65\3\2\2\2\u0259\u025a"
            + "\7\u00d0\2\2\u025a\u025b\7\64\2\2\u025b\u025c\t\7\2\2\u025c\u025f\7\u0103"
            + "\2\2\u025d\u025f\58\35\2\u025e\u0259\3\2\2\2\u025e\u025d\3\2\2\2\u025f"
            + "\67\3\2\2\2\u0260\u0262\7\22\2\2\u0261\u0263\7\u018b\2\2\u0262\u0261\3"
            + "\2\2\2\u0262\u0263\3\2\2\2\u0263\u0264\3\2\2\2\u0264\u027c\5\u00c2b\2"
            + "\u0265\u0267\7\61\2\2\u0266\u0268\7\u018b\2\2\u0267\u0266\3\2\2\2\u0267"
            + "\u0268\3\2\2\2\u0268\u0269\3\2\2\2\u0269\u027c\5\u00c2b\2\u026a\u026c"
            + "\7N\2\2\u026b\u026a\3\2\2\2\u026b\u026c\3\2\2\2\u026c\u0270\3\2\2\2\u026d"
            + "\u026e\7(\2\2\u026e\u0271\7\u0112\2\2\u026f\u0271\7)\2\2\u0270\u026d\3"
            + "\2\2\2\u0270\u026f\3\2\2\2\u0271\u0273\3\2\2\2\u0272\u0274\7\u018b\2\2"
            + "\u0273\u0272\3\2\2\2\u0273\u0274\3\2\2\2\u0274\u0275\3\2\2\2\u0275\u027c"
            + "\5\u00c2b\2\u0276\u0278\7g\2\2\u0277\u0279\7\u018b\2\2\u0278\u0277\3\2"
            + "\2\2\u0278\u0279\3\2\2\2\u0279\u027a\3\2\2\2\u027a\u027c\5\u00c2b\2\u027b"
            + "\u0260\3\2\2\2\u027b\u0265\3\2\2\2\u027b\u026b\3\2\2\2\u027b\u0276\3\2"
            + "\2\2\u027c9\3\2\2\2\u027d\u027f\7=\2\2\u027e\u0280\7\u0145\2\2\u027f\u027e"
            + "\3\2\2\2\u027f\u0280\3\2\2\2\u0280\u0281\3\2\2\2\u0281\u0282\7\u0090\2"
            + "\2\u0282\u0283\5\u00f2z\2\u0283\u0284\7\u00d0\2\2\u0284\u0285\5\u0090"
            + "I\2\u0285\u0286\7\u0195\2\2\u0286\u028b\5<\37\2\u0287\u0288\7\u0186\2"
            + "\2\u0288\u028a\5<\37\2\u0289\u0287\3\2\2\2\u028a\u028d\3\2\2\2\u028b\u0289"
            + "\3\2\2\2\u028b\u028c\3\2\2\2\u028c\u028e\3\2\2\2\u028d\u028b\3\2\2\2\u028e"
            + "\u028f\7\u0198\2\2\u028f;\3\2\2\2\u0290\u0292\5\u00f2z\2\u0291\u0293\t"
            + "\4\2\2\u0292\u0291\3\2\2\2\u0292\u0293\3\2\2\2\u0293=\3\2\2\2\u0294\u0295"
            + "\7`\2\2\u0295\u0296\7\u0090\2\2\u0296\u0297\7\u019c\2\2\u0297\u0298\7"
            + "\u00d0\2\2\u0298\u0299\5\u0090I\2\u0299?\3\2\2\2\u029a\u029c\7\u0185\2"
            + "\2\u029b\u029a\3\2\2\2\u029b\u029c\3\2\2\2\u029c\u029d\3\2\2\2\u029d\u029e"
            + "\7\u018b\2\2\u029e\u02a7\5\u00c2b\2\u029f\u02a1\7\u0154\2\2\u02a0\u029f"
            + "\3\2\2\2\u02a0\u02a1\3\2\2\2\u02a1\u02a2\3\2\2\2\u02a2\u02a4\7N\2\2\u02a3"
            + "\u02a5\5\u00c2b\2\u02a4\u02a3\3\2\2\2\u02a4\u02a5\3\2\2\2\u02a5\u02a7"
            + "\3\2\2\2\u02a6\u029b\3\2\2\2\u02a6\u02a0\3\2\2\2\u02a7A\3\2\2\2\u02a8"
            + "\u02a9\7\u0116\2\2\u02a9\u02aa\7\u0134\2\2\u02aaC\3\2\2\2\u02ab\u02ad"
            + "\7\u00c9\2\2\u02ac\u02ab\3\2\2\2\u02ac\u02ad\3\2\2\2\u02ad\u02ae\3\2\2"
            + "\2\u02ae\u02b7\7\u00cb\2\2\u02af\u02b0\7(\2\2\u02b0\u02b1\7\u0112\2\2"
            + "\u02b1\u02b7\5\u00f2z\2\u02b2\u02b4\7\u00c9\2\2\u02b3\u02b2\3\2\2\2\u02b3"
            + "\u02b4\3\2\2\2\u02b4\u02b5\3\2\2\2\u02b5\u02b7\t\b\2\2\u02b6\u02ac\3\2"
            + "\2\2\u02b6\u02af\3\2\2\2\u02b6\u02b3\3\2\2\2\u02b7E\3\2\2\2\u02b8\u02d4"
            + "\7H\2\2\u02b9\u02d4\7^\2\2\u02ba\u02d4\7v\2\2\u02bb\u02d4\7\u0095\2\2"
            + "\u02bc\u02d4\7\u0099\2\2\u02bd\u02d4\7\u012a\2\2\u02be\u02d4\7\u013b\2"
            + "\2\u02bf\u02d4\7\u0175\2\2\u02c0\u02d4\7\u0176\2\2\u02c1\u02d4\7\u0177"
            + "\2\2\u02c2\u02d4\7\u0178\2\2\u02c3\u02d4\7\u0179\2\2\u02c4\u02d4\7\u017a"
            + "\2\2\u02c5\u02d4\7\u017b\2\2\u02c6\u02d4\7\u017c\2\2\u02c7\u02d4\7\u017d"
            + "\2\2\u02c8\u02d4\7\u017e\2\2\u02c9\u02d4\7\u017f\2\2\u02ca\u02d4\7\u0180"
            + "\2\2\u02cb\u02d4\7\u0181\2\2\u02cc\u02d4\7\u0182\2\2\u02cd\u02d4\7\u0183"
            + "\2\2\u02ce\u02d1\5\u00f2z\2\u02cf\u02d0\7\3\2\2\u02d0\u02d2\t\t\2\2\u02d1"
            + "\u02cf\3\2\2\2\u02d1\u02d2\3\2\2\2\u02d2\u02d4\3\2\2\2\u02d3\u02b8\3\2"
            + "\2\2\u02d3\u02b9\3\2\2\2\u02d3\u02ba\3\2\2\2\u02d3\u02bb\3\2\2\2\u02d3"
            + "\u02bc\3\2\2\2\u02d3\u02bd\3\2\2\2\u02d3\u02be\3\2\2\2\u02d3\u02bf\3\2"
            + "\2\2\u02d3\u02c0\3\2\2\2\u02d3\u02c1\3\2\2\2\u02d3\u02c2\3\2\2\2\u02d3"
            + "\u02c3\3\2\2\2\u02d3\u02c4\3\2\2\2\u02d3\u02c5\3\2\2\2\u02d3\u02c6\3\2"
            + "\2\2\u02d3\u02c7\3\2\2\2\u02d3\u02c8\3\2\2\2\u02d3\u02c9\3\2\2\2\u02d3"
            + "\u02ca\3\2\2\2\u02d3\u02cb\3\2\2\2\u02d3\u02cc\3\2\2\2\u02d3\u02cd\3\2"
            + "\2\2\u02d3\u02ce\3\2\2\2\u02d4G\3\2\2\2\u02d5\u02d6\7\u0195\2\2\u02d6"
            + "\u02d8\t\n\2\2\u02d7\u02d9\t\13\2\2\u02d8\u02d7\3\2\2\2\u02d8\u02d9\3"
            + "\2\2\2\u02d9\u02dc\3\2\2\2\u02da\u02db\7\u0186\2\2\u02db\u02dd\7\u019f"
            + "\2\2\u02dc\u02da\3\2\2\2\u02dc\u02dd\3\2\2\2\u02dd\u02de\3\2\2\2\u02de"
            + "\u02df\7\u0198\2\2\u02dfI\3\2\2\2\u02e0\u02e1\7=\2\2\u02e1\u02e5\t\f\2"
            + "\2\u02e2\u02e3\7\u008a\2\2\u02e3\u02e4\7\u00c9\2\2\u02e4\u02e6\7n\2\2"
            + "\u02e5\u02e2\3\2\2\2\u02e5\u02e6\3\2\2\2\u02e6\u02e7\3\2\2\2\u02e7\u02eb"
            + "\7\u019c\2\2\u02e8\u02ea\5P)\2\u02e9\u02e8\3\2\2\2\u02ea\u02ed\3\2\2\2"
            + "\u02eb\u02e9\3\2\2\2\u02eb\u02ec\3\2\2\2\u02ecK\3\2\2\2\u02ed\u02eb\3"
            + "\2\2\2\u02ee\u02ef\7\u0116\2\2\u02ef\u02f0\7E\2\2\u02f0M\3\2\2\2\u02f1"
            + "\u02f2\7`\2\2\u02f2\u02f5\t\f\2\2\u02f3\u02f4\7\u008a\2\2\u02f4\u02f6"
            + "\7n\2\2\u02f5\u02f3\3\2\2\2\u02f5\u02f6\3\2\2\2\u02f6\u02f7\3\2\2\2\u02f7"
            + "\u02f8\7\u019c\2\2\u02f8O\3\2\2\2\u02f9\u02fa\7\61\2\2\u02fa\u02fe\5\u00c2"
            + "b\2\u02fb\u02fc\7\u00af\2\2\u02fc\u02fe\5\u00c2b\2\u02fd\u02f9\3\2\2\2"
            + "\u02fd\u02fb\3\2\2\2\u02feQ\3\2\2\2\u02ff\u0300\7`\2\2\u0300\u0303\7\u0131"
            + "\2\2\u0301\u0302\7\u008a\2\2\u0302\u0304\7n\2\2\u0303\u0301\3\2\2\2\u0303"
            + "\u0304\3\2\2\2\u0304\u0305\3\2\2\2\u0305\u0306\5\u0090I\2\u0306S\3\2\2"
            + "\2\u0307\u030e\7\u0094\2\2\u0308\u0309\7\u00d8\2\2\u0309\u030f\7\u0131"
            + "\2\2\u030a\u030c\7\u009c\2\2\u030b\u030d\7\u0131\2\2\u030c\u030b\3\2\2"
            + "\2\u030c\u030d\3\2\2\2\u030d\u030f\3\2\2\2\u030e\u0308\3\2\2\2\u030e\u030a"
            + "\3\2\2\2\u030f\u0310\3\2\2\2\u0310\u0312\5\u0090I\2\u0311\u0313\5V,\2"
            + "\u0312\u0311\3\2\2\2\u0312\u0313\3\2\2\2\u0313\u0316\3\2\2\2\u0314\u0317"
            + "\5`\61\2\u0315\u0317\5X-\2\u0316\u0314\3\2\2\2\u0316\u0315\3\2\2\2\u0317"
            + "U\3\2\2\2\u0318\u0319\7\u0195\2\2\u0319\u031e\5\u00f2z\2\u031a\u031b\7"
            + "\u0186\2\2\u031b\u031d\5\u00f2z\2\u031c\u031a\3\2\2\2\u031d\u0320\3\2"
            + "\2\2\u031e\u031c\3\2\2\2\u031e\u031f\3\2\2\2\u031f\u0321\3\2\2\2\u0320"
            + "\u031e\3\2\2\2\u0321\u0322\7\u0198\2\2\u0322W\3\2\2\2\u0323\u0324\7\u014b"
            + "\2\2\u0324\u0329\5Z.\2\u0325\u0326\7\u0186\2\2\u0326\u0328\5Z.\2\u0327"
            + "\u0325\3\2\2\2\u0328\u032b\3\2\2\2\u0329\u0327\3\2\2\2\u0329\u032a\3\2"
            + "\2\2\u032aY\3\2\2\2\u032b\u0329\3\2\2\2\u032c\u032d\7\u0195\2\2\u032d"
            + "\u0332\5\u00c2b\2\u032e\u032f\7\u0186\2\2\u032f\u0331\5\u00c2b\2\u0330"
            + "\u032e\3\2\2\2\u0331\u0334\3\2\2\2\u0332\u0330\3\2\2\2\u0332\u0333\3\2"
            + "\2\2\u0333\u0335\3\2\2\2\u0334\u0332\3\2\2\2\u0335\u0336\7\u0198\2\2\u0336"
            + "[\3\2\2\2\u0337\u0339\7\u0142\2\2\u0338\u033a\7\u0131\2\2\u0339\u0338"
            + "\3\2\2\2\u0339\u033a\3\2\2\2\u033a\u033b\3\2\2\2\u033b\u033c\5\u00f2z"
            + "\2\u033c]\3\2\2\2\u033d\u033e\7\u0148\2\2\u033e\u033f\t\r\2\2\u033f_\3"
            + "\2\2\2\u0340\u0342\5b\62\2\u0341\u0340\3\2\2\2\u0341\u0342\3\2\2\2\u0342"
            + "\u0343\3\2\2\2\u0343\u0344\5h\65\2\u0344a\3\2\2\2\u0345\u0346\7\u0154"
            + "\2\2\u0346\u034b\5d\63\2\u0347\u0348\7\u0186\2\2\u0348\u034a\5d\63\2\u0349"
            + "\u0347\3\2\2\2\u034a\u034d\3\2\2\2\u034b\u0349\3\2\2\2\u034b\u034c\3\2"
            + "\2\2\u034cc\3\2\2\2\u034d\u034b\3\2\2\2\u034e\u0350\5\u00f2z\2\u034f\u0351"
            + "\5f\64\2\u0350\u034f\3\2\2\2\u0350\u0351\3\2\2\2\u0351\u0352\3\2\2\2\u0352"
            + "\u0353\7\f\2\2\u0353\u0354\7\u0195\2\2\u0354\u0355\5h\65\2\u0355\u0356"
            + "\7\u0198\2\2\u0356e\3\2\2\2\u0357\u0358\7\u0195\2\2\u0358\u035d\5\u00f2"
            + "z\2\u0359\u035a\7\u0186\2\2\u035a\u035c\5\u00f2z\2\u035b\u0359\3\2\2\2"
            + "\u035c\u035f\3\2\2\2\u035d\u035b\3\2\2\2\u035d\u035e\3\2\2\2\u035e\u0360"
            + "\3\2\2\2\u035f\u035d\3\2\2\2\u0360\u0361\7\u0198\2\2\u0361g\3\2\2\2\u0362"
            + "\u0368\5j\66\2\u0363\u0364\5l\67\2\u0364\u0365\5j\66\2\u0365\u0367\3\2"
            + "\2\2\u0366\u0363\3\2\2\2\u0367\u036a\3\2\2\2\u0368\u0366\3\2\2\2\u0368"
            + "\u0369\3\2\2\2\u0369\u0370\3\2\2\2\u036a\u0368\3\2\2\2\u036b\u036c\7\u0195"
            + "\2\2\u036c\u036d\5h\65\2\u036d\u036e\7\u0198\2\2\u036e\u0370\3\2\2\2\u036f"
            + "\u0362\3\2\2\2\u036f\u036b\3\2\2\2\u0370i\3\2\2\2\u0371\u0377\5n8\2\u0372"
            + "\u0373\7\u0195\2\2\u0373\u0374\5h\65\2\u0374\u0375\7\u0198\2\2\u0375\u0377"
            + "\3\2\2\2\u0376\u0371\3\2\2\2\u0376\u0372\3\2\2\2\u0377k\3\2\2\2\u0378"
            + "\u037a\7\u0144\2\2\u0379\u037b\7\6\2\2\u037a\u0379\3\2\2\2\u037a\u037b"
            + "\3\2\2\2\u037b\u0385\3\2\2\2\u037c\u037e\7i\2\2\u037d\u037f\7\6\2\2\u037e"
            + "\u037d\3\2\2\2\u037e\u037f\3\2\2\2\u037f\u0385\3\2\2\2\u0380\u0382\7\u009a"
            + "\2\2\u0381\u0383\7\6\2\2\u0382\u0381\3\2\2\2\u0382\u0383\3\2\2\2\u0383"
            + "\u0385\3\2\2\2\u0384\u0378\3\2\2\2\u0384\u037c\3\2\2\2\u0384\u0380\3\2"
            + "\2\2\u0385m\3\2\2\2\u0386\u0387\t\16\2\2\u0387\u0389\5p9\2\u0388\u038a"
            + "\5|?\2\u0389\u0388\3\2\2\2\u0389\u038a\3\2\2\2\u038a\u038c\3\2\2\2\u038b"
            + "\u038d\5~@\2\u038c\u038b\3\2\2\2\u038c\u038d\3\2\2\2\u038d\u038f\3\2\2"
            + "\2\u038e\u0390\5\u0092J\2\u038f\u038e\3\2\2\2\u038f\u0390\3\2\2\2\u0390"
            + "\u0392\3\2\2\2\u0391\u0393\5\u0094K\2\u0392\u0391\3\2\2\2\u0392\u0393"
            + "\3\2\2\2\u0393\u0396\3\2\2\2\u0394\u0397\5\u0096L\2\u0395\u0397\5\u0098"
            + "M\2\u0396\u0394\3\2\2\2\u0396\u0395\3\2\2\2\u0396\u0397\3\2\2\2\u0397"
            + "\u0399\3\2\2\2\u0398\u039a\5\u009aN\2\u0399\u0398\3\2\2\2\u0399\u039a"
            + "\3\2\2\2\u039a\u039c\3\2\2\2\u039b\u039d\5\u00a0Q\2\u039c\u039b\3\2\2"
            + "\2\u039c\u039d\3\2\2\2\u039do\3\2\2\2\u039e\u03a0\5r:\2\u039f\u039e\3"
            + "\2\2\2\u039f\u03a0\3\2\2\2\u03a0\u03a2\3\2\2\2\u03a1\u03a3\5t;\2\u03a2"
            + "\u03a1\3\2\2\2\u03a2\u03a3\3\2\2\2\u03a3\u03a4\3\2\2\2\u03a4\u03a9\5v"
            + "<\2\u03a5\u03a6\7\u0186\2\2\u03a6\u03a8\5v<\2\u03a7\u03a5\3\2\2\2\u03a8"
            + "\u03ab\3\2\2\2\u03a9\u03a7\3\2\2\2\u03a9\u03aa\3\2\2\2\u03aaq\3\2\2\2"
            + "\u03ab\u03a9\3\2\2\2\u03ac\u03ad\t\17\2\2\u03ads\3\2\2\2\u03ae\u03af\7"
            + "\u013f\2\2\u03af\u03b0\5\u00c2b\2\u03b0u\3\2\2\2\u03b1\u03b2\5\u00f2z"
            + "\2\u03b2\u03b3\7\u018b\2\2\u03b3\u03b5\3\2\2\2\u03b4\u03b1\3\2\2\2\u03b4"
            + "\u03b5\3\2\2\2\u03b5\u03b6\3\2\2\2\u03b6\u03b8\5\u00c2b\2\u03b7\u03b9"
            + "\5x=\2\u03b8\u03b7\3\2\2\2\u03b8\u03b9\3\2\2\2\u03b9\u03bc\3\2\2\2\u03ba"
            + "\u03bc\5z>\2\u03bb\u03b4\3\2\2\2\u03bb\u03ba\3\2\2\2\u03bcw\3\2\2\2\u03bd"
            + "\u03bf\7\f\2\2\u03be\u03bd\3\2\2\2\u03be\u03bf\3\2\2\2\u03bf\u03c0\3\2"
            + "\2\2\u03c0\u03d4\5\u00f2z\2\u03c1\u03c3\7\f\2\2\u03c2\u03c1\3\2\2\2\u03c2"
            + "\u03c3\3\2\2\2\u03c3\u03c4\3\2\2\2\u03c4\u03c5\7\u0195\2\2\u03c5\u03ca"
            + "\5\u00f2z\2\u03c6\u03c7\7\u0186\2\2\u03c7\u03c9\5\u00f2z\2\u03c8\u03c6"
            + "\3\2\2\2\u03c9\u03cc\3\2\2\2\u03ca\u03c8\3\2\2\2\u03ca\u03cb\3\2\2\2\u03cb"
            + "\u03cd\3\2\2\2\u03cc\u03ca\3\2\2\2\u03cd\u03ce\7\u0198\2\2\u03ce\u03d4"
            + "\3\2\2\2\u03cf\u03d0\7\u0195\2\2\u03d0\u03d1\7\u013d\2\2\u03d1\u03d2\7"
            + "\u019d\2\2\u03d2\u03d4\7\u0198\2\2\u03d3\u03be\3\2\2\2\u03d3\u03c2\3\2"
            + "\2\2\u03d3\u03cf\3\2\2\2\u03d4y\3\2\2\2\u03d5\u03d6\7\u019c\2\2\u03d6"
            + "\u03d8\7\u0189\2\2\u03d7\u03d5\3\2\2\2\u03d7\u03d8\3\2\2\2\u03d8\u03d9"
            + "\3\2\2\2\u03d9\u03da\7\u0193\2\2\u03da{\3\2\2\2\u03db\u03dc\7\u009c\2"
            + "\2\u03dc\u03e1\5\u00f2z\2\u03dd\u03de\7\u0186\2\2\u03de\u03e0\5\u00f2"
            + "z\2\u03df\u03dd\3\2\2\2\u03e0\u03e3\3\2\2\2\u03e1\u03df\3\2\2\2\u03e1"
            + "\u03e2\3\2\2\2\u03e2}\3\2\2\2\u03e3\u03e1\3\2\2\2\u03e4\u03e5\7{\2\2\u03e5"
            + "\u03e9\5\u0080A\2\u03e6\u03e8\5\u0086D\2\u03e7\u03e6\3\2\2\2\u03e8\u03eb"
            + "\3\2\2\2\u03e9\u03e7\3\2\2\2\u03e9\u03ea\3\2\2\2\u03ea\177\3\2\2\2\u03eb"
            + "\u03e9\3\2\2\2\u03ec\u03f0\5\u0082B\2\u03ed\u03f0\5\u0084C\2\u03ee\u03f0"
            + "\5\u008aF\2\u03ef\u03ec\3\2\2\2\u03ef\u03ed\3\2\2\2\u03ef\u03ee\3\2\2"
            + "\2\u03f0\u0081\3\2\2\2\u03f1\u03f3\5\u0090I\2\u03f2\u03f4\5\u008eH\2\u03f3"
            + "\u03f2\3\2\2\2\u03f3\u03f4\3\2\2\2\u03f4\u03f6\3\2\2\2\u03f5\u03f7\5\u009e"
            + "P\2\u03f6\u03f5\3\2\2\2\u03f6\u03f7\3\2\2\2\u03f7\u0083\3\2\2\2\u03f8"
            + "\u03f9\7\u0195\2\2\u03f9\u03fa\5`\61\2\u03fa\u03fc\7\u0198\2\2\u03fb\u03fd"
            + "\5\u008eH\2\u03fc\u03fb\3\2\2\2\u03fc\u03fd\3\2\2\2\u03fd\u0085\3\2\2"
            + "\2\u03fe\u03ff\7\u0186\2\2\u03ff\u0406\5\u0080A\2\u0400\u0401\5\u0088"
            + "E\2\u0401\u0402\5\u0080A\2\u0402\u0403\7\u00d0\2\2\u0403\u0404\5\u00b2"
            + "Z\2\u0404\u0406\3\2\2\2\u0405\u03fe\3\2\2\2\u0405\u0400\3\2\2\2\u0406"
            + "\u0087\3\2\2\2\u0407\u0409\7\u0092\2\2\u0408\u0407\3\2\2\2\u0408\u0409"
            + "\3\2\2\2\u0409\u040a\3\2\2\2\u040a\u0411\7\u00a1\2\2\u040b\u040d\t\20"
            + "\2\2\u040c\u040e\7\u00d6\2\2\u040d\u040c\3\2\2\2\u040d\u040e\3\2\2\2\u040e"
            + "\u040f\3\2\2\2\u040f\u0411\7\u00a1\2\2\u0410\u0408\3\2\2\2\u0410\u040b"
            + "\3\2\2\2\u0411\u0089\3\2\2\2\u0412\u0413\7\u0131\2\2\u0413\u0414\7\u0195"
            + "\2\2\u0414\u0415\7\u014b\2\2\u0415\u041a\5\u008cG\2\u0416\u0417\7\u0186"
            + "\2\2\u0417\u0419\5\u008cG\2\u0418\u0416\3\2\2\2\u0419\u041c\3\2\2\2\u041a"
            + "\u0418\3\2\2\2\u041a\u041b\3\2\2\2\u041b\u041d\3\2\2\2\u041c\u041a\3\2"
            + "\2\2\u041d\u041f\7\u0198\2\2\u041e\u0420\5\u008eH\2\u041f\u041e\3\2\2"
            + "\2\u041f\u0420\3\2\2\2\u0420\u008b\3\2\2\2\u0421\u042e\5\u00c2b\2\u0422"
            + "\u0423\7\u0195\2\2\u0423\u0428\5\u00c2b\2\u0424\u0425\7\u0186\2\2\u0425"
            + "\u0427\5\u00c2b\2\u0426\u0424\3\2\2\2\u0427\u042a\3\2\2\2\u0428\u0426"
            + "\3\2\2\2\u0428\u0429\3\2\2\2\u0429\u042b\3\2\2\2\u042a\u0428\3\2\2\2\u042b"
            + "\u042c\7\u0198\2\2\u042c\u042e\3\2\2\2\u042d\u0421\3\2\2\2\u042d\u0422"
            + "\3\2\2\2\u042e\u008d\3\2\2\2\u042f\u0431\6H\2\2\u0430\u0432\7\f\2\2\u0431"
            + "\u0430\3\2\2\2\u0431\u0432\3\2\2\2\u0432\u0433\3\2\2\2\u0433\u043e\5\u00f2"
            + "z\2\u0434\u0435\7\u0195\2\2\u0435\u043a\7\u019c\2\2\u0436\u0437\7\u0186"
            + "\2\2\u0437\u0439\7\u019c\2\2\u0438\u0436\3\2\2\2\u0439\u043c\3\2\2\2\u043a"
            + "\u0438\3\2\2\2\u043a\u043b\3\2\2\2\u043b\u043d\3\2\2\2\u043c\u043a\3\2"
            + "\2\2\u043d\u043f\7\u0198\2\2\u043e\u0434\3\2\2\2\u043e\u043f\3\2\2\2\u043f"
            + "\u008f\3\2\2\2\u0440\u0441\5\u00f2z\2\u0441\u0091\3\2\2\2\u0442\u0443"
            + "\7\u0152\2\2\u0443\u0444\5\u00b2Z\2\u0444\u0093\3\2\2\2\u0445\u0446\7"
            + "\u0083\2\2\u0446\u0447\7\37\2\2\u0447\u044c\5\u00c2b\2\u0448\u0449\7\u0186"
            + "\2\2\u0449\u044b\5\u00c2b\2\u044a\u0448\3\2\2\2\u044b\u044e\3\2\2\2\u044c"
            + "\u044a\3\2\2\2\u044c\u044d\3\2\2\2\u044d\u0095\3\2\2\2\u044e\u044c\3\2"
            + "\2\2\u044f\u0450\7\u0086\2\2\u0450\u0451\5\u00b2Z\2\u0451\u0097\3\2\2"
            + "\2\u0452\u0453\7\u00ec\2\2\u0453\u0454\5\u00b2Z\2\u0454\u0099\3\2\2\2"
            + "\u0455\u0456\7\u00d4\2\2\u0456\u0457\7\37\2\2\u0457\u045c\5\u009cO\2\u0458"
            + "\u0459\7\u0186\2\2\u0459\u045b\5\u009cO\2\u045a\u0458\3\2\2\2\u045b\u045e"
            + "\3\2\2\2\u045c\u045a\3\2\2\2\u045c\u045d\3\2\2\2\u045d\u009b\3\2\2\2\u045e"
            + "\u045c\3\2\2\2\u045f\u0461\5\u00c2b\2\u0460\u0462\t\4\2\2\u0461\u0460"
            + "\3\2\2\2\u0461\u0462\3\2\2\2\u0462\u009d\3\2\2\2\u0463\u0464\7\u010a\2"
            + "\2\u0464\u0465\7\u0195\2\2\u0465\u0466\7\u019f\2\2\u0466\u0467\7\u00df"
            + "\2\2\u0467\u0468\7\u0198\2\2\u0468\u009f\3\2\2\2\u0469\u046b\5\u00a2R"
            + "\2\u046a\u0469\3\2\2\2\u046b\u046c\3\2\2\2\u046c\u046a\3\2\2\2\u046c\u046d"
            + "\3\2\2\2\u046d\u00a1\3\2\2\2\u046e\u046f\7\u00ab\2\2\u046f\u047a\5\u00c2"
            + "b\2\u0470\u0471\7\u0154\2\2\u0471\u0477\t\21\2\2\u0472\u0473\7\u0148\2"
            + "\2\u0473\u0474\7\t\2\2\u0474\u0475\7\u00a2\2\2\u0475\u0476\t\22\2\2\u0476"
            + "\u0478\7\u00b2\2\2\u0477\u0472\3\2\2\2\u0477\u0478\3\2\2\2\u0478\u047a"
            + "\3\2\2\2\u0479\u046e\3\2\2\2\u0479\u0470\3\2\2\2\u047a\u00a3\3\2\2\2\u047b"
            + "\u047c\7\u0146\2\2\u047c\u047d\5\u00a8U\2\u047d\u047e\7\u0112\2\2\u047e"
            + "\u0480\5\u00a6T\2\u047f\u0481\5\u0092J\2\u0480\u047f\3\2\2\2\u0480\u0481"
            + "\3\2\2\2\u0481\u0483\3\2\2\2\u0482\u0484\5\u00aaV\2\u0483\u0482\3\2\2"
            + "\2\u0483\u0484\3\2\2\2\u0484\u00a5\3\2\2\2\u0485\u048a\5\n\6\2\u0486\u0487"
            + "\7\u0186\2\2\u0487\u0489\5\n\6\2\u0488\u0486\3\2\2\2\u0489\u048c\3\2\2"
            + "\2\u048a\u0488\3\2\2\2\u048a\u048b\3\2\2\2\u048b\u00a7\3\2\2\2\u048c\u048a"
            + "\3\2\2\2\u048d\u048f\5\u0090I\2\u048e\u0490\5~@\2\u048f\u048e\3\2\2\2"
            + "\u048f\u0490\3\2\2\2\u0490\u0496\3\2\2\2\u0491\u0492\7\u0195\2\2\u0492"
            + "\u0493\5`\61\2\u0493\u0494\7\u0198\2\2\u0494\u0496\3\2\2\2\u0495\u048d"
            + "\3\2\2\2\u0495\u0491\3\2\2\2\u0496\u049b\3\2\2\2\u0497\u0499\7\f\2\2\u0498"
            + "\u0497\3\2\2\2\u0498\u0499\3\2\2\2\u0499\u049a\3\2\2\2\u049a\u049c\5\u00f2"
            + "z\2\u049b\u0498\3\2\2\2\u049b\u049c\3\2\2\2\u049c\u00a9\3\2\2\2\u049d"
            + "\u049e\7b\2\2\u049e\u049f\5T+\2\u049f\u00ab\3\2\2\2\u04a0\u04a2\7S\2\2"
            + "\u04a1\u04a3\7{\2\2\u04a2\u04a1\3\2\2\2\u04a2\u04a3\3\2\2\2\u04a3\u04a4"
            + "\3\2\2\2\u04a4\u04a6\5\u0090I\2\u04a5\u04a7\5\u00aeX\2\u04a6\u04a5\3\2"
            + "\2\2\u04a6\u04a7\3\2\2\2\u04a7\u04aa\3\2\2\2\u04a8\u04ab\5\u0092J\2\u04a9"
            + "\u04ab\7\6\2\2\u04aa\u04a8\3\2\2\2\u04aa\u04a9\3\2\2\2\u04aa\u04ab\3\2"
            + "\2\2\u04ab\u00ad\3\2\2\2\u04ac\u04ae\6X\3\2\u04ad\u04af\7\f\2\2\u04ae"
            + "\u04ad\3\2\2\2\u04ae\u04af\3\2\2\2\u04af\u04b0\3\2\2\2\u04b0\u04b1\5\u00f2"
            + "z\2\u04b1\u00af\3\2\2\2\u04b2\u04b4\t\23\2\2\u04b3\u04b5\t\24\2\2\u04b4"
            + "\u04b3\3\2\2\2\u04b4\u04b5\3\2\2\2\u04b5\u04b6\3\2\2\2\u04b6\u04b7\5\b"
            + "\5\2\u04b7\u00b1\3\2\2\2\u04b8\u04ba\bZ\1\2\u04b9\u04bb\7\u00c9\2\2\u04ba"
            + "\u04b9\3\2\2\2\u04ba\u04bb\3\2\2\2\u04bb\u04bc\3\2\2\2\u04bc\u04bd\7\u0195"
            + "\2\2\u04bd\u04be\5\u00b2Z\2\u04be\u04bf\7\u0198\2\2\u04bf\u04c2\3\2\2"
            + "\2\u04c0\u04c2\5\u00b4[\2\u04c1\u04b8\3\2\2\2\u04c1\u04c0\3\2\2\2\u04c2"
            + "\u04c9\3\2\2\2\u04c3\u04c4\f\4\2\2\u04c4\u04c5\5\u00be`\2\u04c5\u04c6"
            + "\5\u00b2Z\5\u04c6\u04c8\3\2\2\2\u04c7\u04c3\3\2\2\2\u04c8\u04cb\3\2\2"
            + "\2\u04c9\u04c7\3\2\2\2\u04c9\u04ca\3\2\2\2\u04ca\u00b3\3\2\2\2\u04cb\u04c9"
            + "\3\2\2\2\u04cc\u04d0\5\u00b6\\\2\u04cd\u04d0\5\u00bc_\2\u04ce\u04d0\5"
            + "\u00c2b\2\u04cf\u04cc\3\2\2\2\u04cf\u04cd\3\2\2\2\u04cf\u04ce\3\2\2\2"
            + "\u04d0\u00b5\3\2\2\2\u04d1\u04d2\5\u00c2b\2\u04d2\u04d4\7\u009e\2\2\u04d3"
            + "\u04d5\7\u00c9\2\2\u04d4\u04d3\3\2\2\2\u04d4\u04d5\3\2\2\2\u04d5\u04d6"
            + "\3\2\2\2\u04d6\u04d7\7\u00cb\2\2\u04d7\u04e9\3\2\2\2\u04d8\u04d9\5\u00c2"
            + "b\2\u04d9\u04da\7\26\2\2\u04da\u04db\5\u00c2b\2\u04db\u04dc\7\t\2\2\u04dc"
            + "\u04dd\5\u00c2b\2\u04dd\u04e9\3\2\2\2\u04de\u04e0\7\u00c9\2\2\u04df\u04de"
            + "\3\2\2\2\u04df\u04e0\3\2\2\2\u04e0\u04e1\3\2\2\2\u04e1\u04e2\7n\2\2\u04e2"
            + "\u04e3\7\u0195\2\2\u04e3\u04e4\5`\61\2\u04e4\u04e5\7\u0198\2\2\u04e5\u04e9"
            + "\3\2\2\2\u04e6\u04e9\5\u00b8]\2\u04e7\u04e9\5\u00ba^\2\u04e8\u04d1\3\2"
            + "\2\2\u04e8\u04d8\3\2\2\2\u04e8\u04df\3\2\2\2\u04e8\u04e6\3\2\2\2\u04e8"
            + "\u04e7\3\2\2\2\u04e9\u00b7\3\2\2\2\u04ea\u04ec\5\u00c2b\2\u04eb\u04ed"
            + "\7\u00c9\2\2\u04ec\u04eb\3\2\2\2\u04ec\u04ed\3\2\2\2\u04ed\u04ee\3\2\2"
            + "\2\u04ee\u04ef\7\u008d\2\2\u04ef\u04f9\7\u0195\2\2\u04f0\u04f5\5\u00c2"
            + "b\2\u04f1\u04f2\7\u0186\2\2\u04f2\u04f4\5\u00c2b\2\u04f3\u04f1\3\2\2\2"
            + "\u04f4\u04f7\3\2\2\2\u04f5\u04f3\3\2\2\2\u04f5\u04f6\3\2\2\2\u04f6\u04fa"
            + "\3\2\2\2\u04f7\u04f5\3\2\2\2\u04f8\u04fa\5`\61\2\u04f9\u04f0\3\2\2\2\u04f9"
            + "\u04f8\3\2\2\2\u04fa\u04fb\3\2\2\2\u04fb\u04fc\7\u0198\2\2\u04fc\u00b9"
            + "\3\2\2\2\u04fd\u04fe\7\u0195\2\2\u04fe\u0503\5\u00c2b\2\u04ff\u0500\7"
            + "\u0186\2\2\u0500\u0502\5\u00c2b\2\u0501\u04ff\3\2\2\2\u0502\u0505\3\2"
            + "\2\2\u0503\u0501\3\2\2\2\u0503\u0504\3\2\2\2\u0504\u0506\3\2\2\2\u0505"
            + "\u0503\3\2\2\2\u0506\u0508\7\u0198\2\2\u0507\u0509\7\u00c9\2\2\u0508\u0507"
            + "\3\2\2\2\u0508\u0509\3\2\2\2\u0509\u050a\3\2\2\2\u050a\u050b\7\u008d\2"
            + "\2\u050b\u050c\7\u0195\2\2\u050c\u050d\5`\61\2\u050d\u050e\7\u0198\2\2"
            + "\u050e\u00bb\3\2\2\2\u050f\u0510\5\u00c2b\2\u0510\u0511\5\u00c0a\2\u0511"
            + "\u0512\5\u00c2b\2\u0512\u00bd\3\2\2\2\u0513\u0514\t\25\2\2\u0514\u00bf"
            + "\3\2\2\2\u0515\u0522\7\u018b\2\2\u0516\u0522\7\u018c\2\2\u0517\u0522\7"
            + "\u018d\2\2\u0518\u0522\7\u018e\2\2\u0519\u0522\7\u0191\2\2\u051a\u0522"
            + "\7\u0192\2\2\u051b\u0522\7\u018f\2\2\u051c\u0522\7\u0190\2\2\u051d\u051f"
            + "\7\u00c9\2\2\u051e\u051d\3\2\2\2\u051e\u051f\3\2\2\2\u051f\u0520\3\2\2"
            + "\2\u0520\u0522\t\26\2\2\u0521\u0515\3\2\2\2\u0521\u0516\3\2\2\2\u0521"
            + "\u0517\3\2\2\2\u0521\u0518\3\2\2\2\u0521\u0519\3\2\2\2\u0521\u051a\3\2"
            + "\2\2\u0521\u051b\3\2\2\2\u0521\u051c\3\2\2\2\u0521\u051e\3\2\2\2\u0522"
            + "\u00c1\3\2\2\2\u0523\u0524\bb\1\2\u0524\u0525\7\u0195\2\2\u0525\u0526"
            + "\5`\61\2\u0526\u0527\7\u0198\2\2\u0527\u0535\3\2\2\2\u0528\u0529\7\u0195"
            + "\2\2\u0529\u052a\5\u00c2b\2\u052a\u052b\7\u0198\2\2\u052b\u0535\3\2\2"
            + "\2\u052c\u0535\5\u00c6d\2\u052d\u0535\5\u00caf\2\u052e\u0535\5\u00ceh"
            + "\2\u052f\u0535\5\u00d6l\2\u0530\u0535\5\u00d8m\2\u0531\u0535\5\u00e0q"
            + "\2\u0532\u0535\5\u00e2r\2\u0533\u0535\5\u00c4c\2\u0534\u0523\3\2\2\2\u0534"
            + "\u0528\3\2\2\2\u0534\u052c\3\2\2\2\u0534\u052d\3\2\2\2\u0534\u052e\3\2"
            + "\2\2\u0534\u052f\3\2\2\2\u0534\u0530\3\2\2\2\u0534\u0531\3\2\2\2\u0534"
            + "\u0532\3\2\2\2\u0534\u0533\3\2\2\2\u0535\u0546\3\2\2\2\u0536\u0537\f\20"
            + "\2\2\u0537\u0538\7\u0193\2\2\u0538\u0545\5\u00c2b\21\u0539\u053a\f\17"
            + "\2\2\u053a\u053b\7\u0188\2\2\u053b\u0545\5\u00c2b\20\u053c\u053d\f\16"
            + "\2\2\u053d\u053e\7\u0184\2\2\u053e\u0545\5\u00c2b\17\u053f\u0540\f\r\2"
            + "\2\u0540\u0541\7\u019b\2\2\u0541\u0545\5\u00c2b\16\u0542\u0543\f\21\2"
            + "\2\u0543\u0545\5\u00c8e\2\u0544\u0536\3\2\2\2\u0544\u0539\3\2\2\2\u0544"
            + "\u053c\3\2\2\2\u0544\u053f\3\2\2\2\u0544\u0542\3\2\2\2\u0545\u0548\3\2"
            + "\2\2\u0546\u0544\3\2\2\2\u0546\u0547\3\2\2\2\u0547\u00c3\3\2\2\2\u0548"
            + "\u0546\3\2\2\2\u0549\u0552\5\u00eex\2\u054a\u0552\5\u00f0y\2\u054b\u0552"
            + "\5\u00fc\177\2\u054c\u0552\5\u00f2z\2\u054d\u0552\5\u00f6|\2\u054e\u0552"
            + "\5\u00fa~\2\u054f\u0552\5\u00f8}\2\u0550\u0552\5\u00fe\u0080\2\u0551\u0549"
            + "\3\2\2\2\u0551\u054a\3\2\2\2\u0551\u054b\3\2\2\2\u0551\u054c\3\2\2\2\u0551"
            + "\u054d\3\2\2\2\u0551\u054e\3\2\2\2\u0551\u054f\3\2\2\2\u0551\u0550\3\2"
            + "\2\2\u0552\u00c5\3\2\2\2\u0553\u0554\7\u009b\2\2\u0554\u0555\5\u00c2b"
            + "\2\u0555\u0556\5\u00c8e\2\u0556\u00c7\3\2\2\2\u0557\u0558\t\27\2\2\u0558"
            + "\u00c9\3\2\2\2\u0559\u055a\5\u00ccg\2\u055a\u055b\t\30\2\2\u055b\u0560"
            + "\5\u00ccg\2\u055c\u055d\t\30\2\2\u055d\u055f\5\u00ccg\2\u055e\u055c\3"
            + "\2\2\2\u055f\u0562\3\2\2\2\u0560\u055e\3\2\2\2\u0560\u0561\3\2\2\2\u0561"
            + "\u00cb\3\2\2\2\u0562\u0560\3\2\2\2\u0563\u0564\7\u0195\2\2\u0564\u0565"
            + "\5\u00c2b\2\u0565\u0566\7\u0198\2\2\u0566\u056d\3\2\2\2\u0567\u056d\5"
            + "\u00ceh\2\u0568\u056d\5\u00d8m\2\u0569\u056d\5\u00e0q\2\u056a\u056d\5"
            + "\u00e2r\2\u056b\u056d\5\u00c4c\2\u056c\u0563\3\2\2\2\u056c\u0567\3\2\2"
            + "\2\u056c\u0568\3\2\2\2\u056c\u0569\3\2\2\2\u056c\u056a\3\2\2\2\u056c\u056b"
            + "\3\2\2\2\u056d\u00cd\3\2\2\2\u056e\u0571\5\u00d0i\2\u056f\u0571\5\u00d2"
            + "j\2\u0570\u056e\3\2\2\2\u0570\u056f\3\2\2\2\u0571\u00cf\3\2\2\2\u0572"
            + "\u0573\7$\2\2\u0573\u0579\5\u00c2b\2\u0574\u0575\7\u0151\2\2\u0575\u0576"
            + "\5\u00c2b\2\u0576\u0577\7\u013a\2\2\u0577\u0578\5\u00c2b\2\u0578\u057a"
            + "\3\2\2\2\u0579\u0574\3\2\2\2\u057a\u057b\3\2\2\2\u057b\u0579\3\2\2\2\u057b"
            + "\u057c\3\2\2\2\u057c\u057f\3\2\2\2\u057d\u057e\7b\2\2\u057e\u0580\5\u00c2"
            + "b\2\u057f\u057d\3\2\2\2\u057f\u0580\3\2\2\2\u0580\u0581\3\2\2\2\u0581"
            + "\u0582\7f\2\2\u0582\u00d1\3\2\2\2\u0583\u0585\7$\2\2\u0584\u0586\5\u00d4"
            + "k\2\u0585\u0584\3\2\2\2\u0586\u0587\3\2\2\2\u0587\u0585\3\2\2\2\u0587"
            + "\u0588\3\2\2\2\u0588\u058b\3\2\2\2\u0589\u058a\7b\2\2\u058a\u058c\5\u00b2"
            + "Z\2\u058b\u0589\3\2\2\2\u058b\u058c\3\2\2\2\u058c\u058d\3\2\2\2\u058d"
            + "\u058e\7f\2\2\u058e\u00d3\3\2\2\2\u058f\u0590\7\u0151\2\2\u0590\u0591"
            + "\5\u00b2Z\2\u0591\u0592\7\u013a\2\2\u0592\u0593\5\u00b2Z\2\u0593\u00d5"
            + "\3\2\2\2\u0594\u0595\5\u00f2z\2\u0595\u0596\7\3\2\2\u0596\u0597\t\31\2"
            + "\2\u0597\u00d7\3\2\2\2\u0598\u0599\7\23\2\2\u0599\u059b\7\u0195\2\2\u059a"
            + "\u059c\5\u00dan\2\u059b\u059a\3\2\2\2\u059b\u059c\3\2\2\2\u059c\u059d"
            + "\3\2\2\2\u059d\u059e\5\u00c2b\2\u059e\u05a0\7\u0198\2\2\u059f\u05a1\5"
            + "\u00dco\2\u05a0\u059f\3\2\2\2\u05a0\u05a1\3\2\2\2\u05a1\u0631\3\2\2\2"
            + "\u05a2\u05a3\7;\2\2\u05a3\u05a9\7\u0195\2\2\u05a4\u05a6\5\u00dan\2\u05a5"
            + "\u05a4\3\2\2\2\u05a5\u05a6\3\2\2\2\u05a6\u05a7\3\2\2\2\u05a7\u05aa\5\u00c2"
            + "b\2\u05a8\u05aa\7\u0193\2\2\u05a9\u05a5\3\2\2\2\u05a9\u05a8\3\2\2\2\u05aa"
            + "\u05ab\3\2\2\2\u05ab\u05ad\7\u0198\2\2\u05ac\u05ae\5\u00dco\2\u05ad\u05ac"
            + "\3\2\2\2\u05ad\u05ae\3\2\2\2\u05ae\u0631\3\2\2\2\u05af\u05b0\7<\2\2\u05b0"
            + "\u05b6\7\u0195\2\2\u05b1\u05b3\5\u00dan\2\u05b2\u05b1\3\2\2\2\u05b2\u05b3"
            + "\3\2\2\2\u05b3\u05b4\3\2\2\2\u05b4\u05b7\5\u00c2b\2\u05b5\u05b7\7\u0193"
            + "\2\2\u05b6\u05b2\3\2\2\2\u05b6\u05b5\3\2\2\2\u05b7\u05b8\3\2\2\2\u05b8"
            + "\u05ba\7\u0198\2\2\u05b9\u05bb\5\u00dco\2\u05ba\u05b9\3\2\2\2\u05ba\u05bb"
            + "\3\2\2\2\u05bb\u0631\3\2\2\2\u05bc\u05bd\7\u015b\2\2\u05bd\u05be\7\u0195"
            + "\2\2\u05be\u05bf\7\u0198\2\2\u05bf\u0631\5\u00dco\2\u05c0\u05c1\7\u0161"
            + "\2\2\u05c1\u05c2\7\u0195\2\2\u05c2\u05c3\7\u0198\2\2\u05c3\u0631\5\u00dc"
            + "o\2\u05c4\u05c5\7\u0162\2\2\u05c5\u05c6\7\u0195\2\2\u05c6\u05c7\5\u00c2"
            + "b\2\u05c7\u05c8\7\u0198\2\2\u05c8\u05c9\5\u00dco\2\u05c9\u0631\3\2\2\2"
            + "\u05ca\u05cb\7\u0163\2\2\u05cb\u05cc\7\u0195\2\2\u05cc\u05d3\5\u00c2b"
            + "\2\u05cd\u05ce\7\u0186\2\2\u05ce\u05d1\5\u00c2b\2\u05cf\u05d0\7\u0186"
            + "\2\2\u05d0\u05d2\5\u00c2b\2\u05d1\u05cf\3\2\2\2\u05d1\u05d2\3\2\2\2\u05d2"
            + "\u05d4\3\2\2\2\u05d3\u05cd\3\2\2\2\u05d3\u05d4\3\2\2\2\u05d4\u05d5\3\2"
            + "\2\2\u05d5\u05d6\7\u0198\2\2\u05d6\u05d7\5\u00dco\2\u05d7\u0631\3\2\2"
            + "\2\u05d8\u05d9\7\u0164\2\2\u05d9\u05da\7\u0195\2\2\u05da\u05db\5\u00c2"
            + "b\2\u05db\u05dc\7\u0198\2\2\u05dc\u05dd\5\u00dco\2\u05dd\u0631\3\2\2\2"
            + "\u05de\u05df\7\u0165\2\2\u05df\u05e0\7\u0195\2\2\u05e0\u05e7\5\u00c2b"
            + "\2\u05e1\u05e2\7\u0186\2\2\u05e2\u05e5\5\u00c2b\2\u05e3\u05e4\7\u0186"
            + "\2\2\u05e4\u05e6\5\u00c2b\2\u05e5\u05e3\3\2\2\2\u05e5\u05e6\3\2\2\2\u05e6"
            + "\u05e8\3\2\2\2\u05e7\u05e1\3\2\2\2\u05e7\u05e8\3\2\2\2\u05e8\u05e9\3\2"
            + "\2\2\u05e9\u05ea\7\u0198\2\2\u05ea\u05eb\5\u00dco\2\u05eb\u0631\3\2\2"
            + "\2\u05ec\u05ed\7\u00b9\2\2\u05ed\u05ef\7\u0195\2\2\u05ee\u05f0\5\u00da"
            + "n\2\u05ef\u05ee\3\2\2\2\u05ef\u05f0\3\2\2\2\u05f0\u05f1\3\2\2\2\u05f1"
            + "\u05f2\5\u00c2b\2\u05f2\u05f4\7\u0198\2\2\u05f3\u05f5\5\u00dco\2\u05f4"
            + "\u05f3\3\2\2\2\u05f4\u05f5\3\2\2\2\u05f5\u0631\3\2\2\2\u05f6\u05f7\7\u00bf"
            + "\2\2\u05f7\u05f9\7\u0195\2\2\u05f8\u05fa\5\u00dan\2\u05f9\u05f8\3\2\2"
            + "\2\u05f9\u05fa\3\2\2\2\u05fa\u05fb\3\2\2\2\u05fb\u05fc\5\u00c2b\2\u05fc"
            + "\u05fe\7\u0198\2\2\u05fd\u05ff\5\u00dco\2\u05fe\u05fd\3\2\2\2\u05fe\u05ff"
            + "\3\2\2\2\u05ff\u0631\3\2\2\2\u0600\u0601\7\u016e\2\2\u0601\u0602\7\u0195"
            + "\2\2\u0602\u0603\7\u0198\2\2\u0603\u0631\5\u00dco\2\u0604\u0605\7\u016f"
            + "\2\2\u0605\u0606\7\u0195\2\2\u0606\u0607\7\u0198\2\2\u0607\u0631\5\u00dc"
            + "o\2\u0608\u0609\7\u0170\2\2\u0609\u060b\7\u0195\2\2\u060a\u060c\5\u00da"
            + "n\2\u060b\u060a\3\2\2\2\u060b\u060c\3\2\2\2\u060c\u060d\3\2\2\2\u060d"
            + "\u060e\5\u00c2b\2\u060e\u0610\7\u0198\2\2\u060f\u0611\5\u00dco\2\u0610"
            + "\u060f\3\2\2\2\u0610\u0611\3\2\2\2\u0611\u0631\3\2\2\2\u0612\u0613\7\u012d"
            + "\2\2\u0613\u0615\7\u0195\2\2\u0614\u0616\5\u00dan\2\u0615\u0614\3\2\2"
            + "\2\u0615\u0616\3\2\2\2\u0616\u0617\3\2\2\2\u0617\u0618\5\u00c2b\2\u0618"
            + "\u061a\7\u0198\2\2\u0619\u061b\5\u00dco\2\u061a\u0619\3\2\2\2\u061a\u061b"
            + "\3\2\2\2\u061b\u0631\3\2\2\2\u061c\u061d\7\u014c\2\2\u061d\u061f\7\u0195"
            + "\2\2\u061e\u0620\5\u00dan\2\u061f\u061e\3\2\2\2\u061f\u0620\3\2\2\2\u0620"
            + "\u0621\3\2\2\2\u0621\u0622\5\u00c2b\2\u0622\u0624\7\u0198\2\2\u0623\u0625"
            + "\5\u00dco\2\u0624\u0623\3\2\2\2\u0624\u0625\3\2\2\2\u0625\u0631\3\2\2"
            + "\2\u0626\u0627\7\u0172\2\2\u0627\u0629\7\u0195\2\2\u0628\u062a\5\u00da"
            + "n\2\u0629\u0628\3\2\2\2\u0629\u062a\3\2\2\2\u062a\u062b\3\2\2\2\u062b"
            + "\u062c\5\u00c2b\2\u062c\u062e\7\u0198\2\2\u062d\u062f\5\u00dco\2\u062e"
            + "\u062d\3\2\2\2\u062e\u062f\3\2\2\2\u062f\u0631\3\2\2\2\u0630\u0598\3\2"
            + "\2\2\u0630\u05a2\3\2\2\2\u0630\u05af\3\2\2\2\u0630\u05bc\3\2\2\2\u0630"
            + "\u05c0\3\2\2\2\u0630\u05c4\3\2\2\2\u0630\u05ca\3\2\2\2\u0630\u05d8\3\2"
            + "\2\2\u0630\u05de\3\2\2\2\u0630\u05ec\3\2\2\2\u0630\u05f6\3\2\2\2\u0630"
            + "\u0600\3\2\2\2\u0630\u0604\3\2\2\2\u0630\u0608\3\2\2\2\u0630\u0612\3\2"
            + "\2\2\u0630\u061c\3\2\2\2\u0630\u0626\3\2\2\2\u0631\u00d9\3\2\2\2\u0632"
            + "\u0633\t\17\2\2\u0633\u00db\3\2\2\2\u0634\u0635\7\u00d7\2\2\u0635\u0637"
            + "\7\u0195\2\2\u0636\u0638\5\u00dep\2\u0637\u0636\3\2\2\2\u0637\u0638\3"
            + "\2\2\2\u0638\u063a\3\2\2\2\u0639\u063b\5\u009aN\2\u063a\u0639\3\2\2\2"
            + "\u063a\u063b\3\2\2\2\u063b\u063c\3\2\2\2\u063c\u063d\7\u0198\2\2\u063d"
            + "\u00dd\3\2\2\2\u063e\u063f\7\u00db\2\2\u063f\u0640\7\37\2\2\u0640\u0645"
            + "\5\u00c2b\2\u0641\u0642\7\u0186\2\2\u0642\u0644\5\u00c2b\2\u0643\u0641"
            + "\3\2\2\2\u0644\u0647\3\2\2\2\u0645\u0643\3\2\2\2\u0645\u0646\3\2\2\2\u0646"
            + "\u00df\3\2\2\2\u0647\u0645\3\2\2\2\u0648\u070e\7\u015a\2\2\u0649\u064a"
            + "\7&\2\2\u064a\u064b\7\u0195\2\2\u064b\u064c\5\u00c2b\2\u064c\u064d\7\f"
            + "\2\2\u064d\u064f\5F$\2\u064e\u0650\5H%\2\u064f\u064e\3\2\2\2\u064f\u0650"
            + "\3\2\2\2\u0650\u0651\3\2\2\2\u0651\u0652\7\u0198\2\2\u0652\u070e\3\2\2"
            + "\2\u0653\u0654\7;\2\2\u0654\u0657\7\u0195\2\2\u0655\u0658\5\u00c2b\2\u0656"
            + "\u0658\7\u0193\2\2\u0657\u0655\3\2\2\2\u0657\u0656\3\2\2\2\u0658\u0659"
            + "\3\2\2\2\u0659\u070e\7\u0198\2\2\u065a\u070e\7\u015c\2\2\u065b\u065c\7"
            + "A\2\2\u065c\u070e\7G\2\2\u065d\u070e\7\u015d\2\2\u065e\u070e\7\u015e\2"
            + "\2\u065f\u0663\7\u015f\2\2\u0660\u0661\7A\2\2\u0661\u0663\7\u013b\2\2"
            + "\u0662\u065f\3\2\2\2\u0662\u0660\3\2\2\2\u0663\u0668\3\2\2\2\u0664\u0665"
            + "\7\u0195\2\2\u0665\u0666\5\u00c2b\2\u0666\u0667\7\u0198\2\2\u0667\u0669"
            + "\3\2\2\2\u0668\u0664\3\2\2\2\u0668\u0669\3\2\2\2\u0669\u070e\3\2\2\2\u066a"
            + "\u070e\7\u0160\2\2\u066b\u066c\7A\2\2\u066c\u070e\7\u0173\2\2\u066d\u066e"
            + "\7\u0166\2\2\u066e\u066f\7\u0195\2\2\u066f\u067c\5\u00c2b\2\u0670\u0671"
            + "\7\u0186\2\2\u0671\u0679\5\u00c2b\2\u0672\u0673\7\u0186\2\2\u0673\u0674"
            + "\5\u00c2b\2\u0674\u0675\7\u018b\2\2\u0675\u0676\5\u00c2b\2\u0676\u0678"
            + "\3\2\2\2\u0677\u0672\3\2\2\2\u0678\u067b\3\2\2\2\u0679\u0677\3\2\2\2\u0679"
            + "\u067a\3\2\2\2\u067a\u067d\3\2\2\2\u067b\u0679\3\2\2\2\u067c\u0670\3\2"
            + "\2\2\u067c\u067d\3\2\2\2\u067d\u067e\3\2\2\2\u067e\u067f\7\u0198\2\2\u067f"
            + "\u070e\3\2\2\2\u0680\u0681\7\u0167\2\2\u0681\u0682\7\u0195\2\2\u0682\u068f"
            + "\5\u00c2b\2\u0683\u0684\7\u0186\2\2\u0684\u068c\5\u00c2b\2\u0685\u0686"
            + "\7\u0186\2\2\u0686\u0687\5\u00c2b\2\u0687\u0688\7\u018b\2\2\u0688\u0689"
            + "\5\u00c2b\2\u0689\u068b\3\2\2\2\u068a\u0685\3\2\2\2\u068b\u068e\3\2\2"
            + "\2\u068c\u068a\3\2\2\2\u068c\u068d\3\2\2\2\u068d\u0690\3\2\2\2\u068e\u068c"
            + "\3\2\2\2\u068f\u0683\3\2\2\2\u068f\u0690\3\2\2\2\u0690\u0691\3\2\2\2\u0691"
            + "\u0692\7\u0198\2\2\u0692\u070e\3\2\2\2\u0693\u0694\7\u0168\2\2\u0694\u0695"
            + "\7\u0195\2\2\u0695\u06a2\5\u00c2b\2\u0696\u0697\7\u0186\2\2\u0697\u069f"
            + "\5\u00c2b\2\u0698\u0699\7\u0186\2\2\u0699\u069a\5\u00c2b\2\u069a\u069b"
            + "\7\u018b\2\2\u069b\u069c\5\u00c2b\2\u069c\u069e\3\2\2\2\u069d\u0698\3"
            + "\2\2\2\u069e\u06a1\3\2\2\2\u069f\u069d\3\2\2\2\u069f\u06a0\3\2\2\2\u06a0"
            + "\u06a3\3\2\2\2\u06a1\u069f\3\2\2\2\u06a2\u0696\3\2\2\2\u06a2\u06a3\3\2"
            + "\2\2\u06a3\u06a4\3\2\2\2\u06a4\u06a5\7\u0198\2\2\u06a5\u070e\3\2\2\2\u06a6"
            + "\u06a7\7\u0169\2\2\u06a7\u06a8\7\u0195\2\2\u06a8\u06b5\5\u00c2b\2\u06a9"
            + "\u06aa\7\u0186\2\2\u06aa\u06b2\5\u00c2b\2\u06ab\u06ac\7\u0186\2\2\u06ac"
            + "\u06ad\5\u00c2b\2\u06ad\u06ae\7\u018b\2\2\u06ae\u06af\5\u00c2b\2\u06af"
            + "\u06b1\3\2\2\2\u06b0\u06ab\3\2\2\2\u06b1\u06b4\3\2\2\2\u06b2\u06b0\3\2"
            + "\2\2\u06b2\u06b3\3\2\2\2\u06b3\u06b6\3\2\2\2\u06b4\u06b2\3\2\2\2\u06b5"
            + "\u06a9\3\2\2\2\u06b5\u06b6\3\2\2\2\u06b6\u06b7\3\2\2\2\u06b7\u06b8\7\u0198"
            + "\2\2\u06b8\u070e\3\2\2\2\u06b9\u06ba\7\u016a\2\2\u06ba\u06bb\7\u0195\2"
            + "\2\u06bb\u06c8\5\u00c2b\2\u06bc\u06bd\7\u0186\2\2\u06bd\u06c5\5\u00c2"
            + "b\2\u06be\u06bf\7\u0186\2\2\u06bf\u06c0\5\u00c2b\2\u06c0\u06c1\7\u018b"
            + "\2\2\u06c1\u06c2\5\u00c2b\2\u06c2\u06c4\3\2\2\2\u06c3\u06be\3\2\2\2\u06c4"
            + "\u06c7\3\2\2\2\u06c5\u06c3\3\2\2\2\u06c5\u06c6\3\2\2\2\u06c6\u06c9\3\2"
            + "\2\2\u06c7\u06c5\3\2\2\2\u06c8\u06bc\3\2\2\2\u06c8\u06c9\3\2\2\2\u06c9"
            + "\u06ca\3\2\2\2\u06ca\u06cb\7\u0198\2\2\u06cb\u070e\3\2\2\2\u06cc\u06cd"
            + "\7\u016b\2\2\u06cd\u06ce\7\u0195\2\2\u06ce\u06db\5\u00c2b\2\u06cf\u06d0"
            + "\7\u0186\2\2\u06d0\u06d8\5\u00c2b\2\u06d1\u06d2\7\u0186\2\2\u06d2\u06d3"
            + "\5\u00c2b\2\u06d3\u06d4\7\u018b\2\2\u06d4\u06d5\5\u00c2b\2\u06d5\u06d7"
            + "\3\2\2\2\u06d6\u06d1\3\2\2\2\u06d7\u06da\3\2\2\2\u06d8\u06d6\3\2\2\2\u06d8"
            + "\u06d9\3\2\2\2\u06d9\u06dc\3\2\2\2\u06da\u06d8\3\2\2\2\u06db\u06cf\3\2"
            + "\2\2\u06db\u06dc\3\2\2\2\u06dc\u06dd\3\2\2\2\u06dd\u06de\7\u0198\2\2\u06de"
            + "\u070e\3\2\2\2\u06df\u06e0\7\u016c\2\2\u06e0\u06e1\7\u0195\2\2\u06e1\u06e9"
            + "\5\u00c2b\2\u06e2\u06e3\7\u0186\2\2\u06e3\u06e4\5\u00c2b\2\u06e4\u06e5"
            + "\7\u018b\2\2\u06e5\u06e6\5\u00c2b\2\u06e6\u06e8\3\2\2\2\u06e7\u06e2\3"
            + "\2\2\2\u06e8\u06eb\3\2\2\2\u06e9\u06e7\3\2\2\2\u06e9\u06ea\3\2\2\2\u06ea"
            + "\u06ec\3\2\2\2\u06eb\u06e9\3\2\2\2\u06ec\u06ed\7\u0198\2\2\u06ed\u070e"
            + "\3\2\2\2\u06ee\u06ef\7\u016d\2\2\u06ef\u06f0\7\u0195\2\2\u06f0\u06f6\5"
            + "\u00c2b\2\u06f1\u06f2\7\u0186\2\2\u06f2\u06f3\5\u00c2b\2\u06f3\u06f4\7"
            + "\u018b\2\2\u06f4\u06f5\5\u00c2b\2\u06f5\u06f7\3\2\2\2\u06f6\u06f1\3\2"
            + "\2\2\u06f7\u06f8\3\2\2\2\u06f8\u06f6\3\2\2\2\u06f8\u06f9\3\2\2\2\u06f9"
            + "\u06fc\3\2\2\2\u06fa\u06fb\7\u0186\2\2\u06fb\u06fd\5\u00c2b\2\u06fc\u06fa"
            + "\3\2\2\2\u06fc\u06fd\3\2\2\2\u06fd\u06fe\3\2\2\2\u06fe\u06ff\7\u0198\2"
            + "\2\u06ff\u070e\3\2\2\2\u0700\u0701\7\u012c\2\2\u0701\u0702\7\u0195\2\2"
            + "\u0702\u0703\5\u00c2b\2\u0703\u0704\7{\2\2\u0704\u0707\5\u00c2b\2\u0705"
            + "\u0706\7w\2\2\u0706\u0708\5\u00c2b\2\u0707\u0705\3\2\2\2\u0707\u0708\3"
            + "\2\2\2\u0708\u0709\3\2\2\2\u0709\u070a\7\u0198\2\2\u070a\u070e\3\2\2\2"
            + "\u070b\u070e\7\u0171\2\2\u070c\u070e\7\u0173\2\2\u070d\u0648\3\2\2\2\u070d"
            + "\u0649\3\2\2\2\u070d\u0653\3\2\2\2\u070d\u065a\3\2\2\2\u070d\u065b\3\2"
            + "\2\2\u070d\u065d\3\2\2\2\u070d\u065e\3\2\2\2\u070d\u0662\3\2\2\2\u070d"
            + "\u066a\3\2\2\2\u070d\u066b\3\2\2\2\u070d\u066d\3\2\2\2\u070d\u0680\3\2"
            + "\2\2\u070d\u0693\3\2\2\2\u070d\u06a6\3\2\2\2\u070d\u06b9\3\2\2\2\u070d"
            + "\u06cc\3\2\2\2\u070d\u06df\3\2\2\2\u070d\u06ee\3\2\2\2\u070d\u0700\3\2"
            + "\2\2\u070d\u070b\3\2\2\2\u070d\u070c\3\2\2\2\u070e\u00e1\3\2\2\2\u070f"
            + "\u0710\5\u00f2z\2\u0710\u0712\7\u0195\2\2\u0711\u0713\5\u00e4s\2\u0712"
            + "\u0711\3\2\2\2\u0712\u0713\3\2\2\2\u0713\u0714\3\2\2\2\u0714\u0715\7\u0198"
            + "\2\2\u0715\u00e3\3\2\2\2\u0716\u071b\5\u00e6t\2\u0717\u0718\7\u0186\2"
            + "\2\u0718\u071a\5\u00e6t\2\u0719\u0717\3\2\2\2\u071a\u071d\3\2\2\2\u071b"
            + "\u0719\3\2\2\2\u071b\u071c\3\2\2\2\u071c\u00e5\3\2\2\2\u071d\u071b\3\2"
            + "\2\2\u071e\u072a\3\2\2\2\u071f\u0725\6t\n\2\u0720\u0721\5\u00f2z\2\u0721"
            + "\u0723\7\u018b\2\2\u0722\u0724\7\u018f\2\2\u0723\u0722\3\2\2\2\u0723\u0724"
            + "\3\2\2\2\u0724\u0726\3\2\2\2\u0725\u0720\3\2\2\2\u0725\u0726\3\2\2\2\u0726"
            + "\u0727\3\2\2\2\u0727\u072a\5\u00c2b\2\u0728\u072a\7\u0193\2\2\u0729\u071e"
            + "\3\2\2\2\u0729\u071f\3\2\2\2\u0729\u0728\3\2\2\2\u072a\u00e7\3\2\2\2\u072b"
            + "\u072c\5\u00ecw\2\u072c\u00e9\3\2\2\2\u072d\u072e\5\u00f2z\2\u072e\u00eb"
            + "\3\2\2\2\u072f\u0734\5\u00f2z\2\u0730\u0731\7\u0189\2\2\u0731\u0733\5"
            + "\u00f2z\2\u0732\u0730\3\2\2\2\u0733\u0736\3\2\2\2\u0734\u0732\3\2\2\2"
            + "\u0734\u0735\3\2\2\2\u0735\u00ed\3\2\2\2\u0736\u0734\3\2\2\2\u0737\u0738"
            + "\7G\2\2\u0738\u0739\5\u00f6|\2\u0739\u00ef\3\2\2\2\u073a\u073b\7\u013b"
            + "\2\2\u073b\u073c\5\u00f6|\2\u073c\u00f1\3\2\2\2\u073d\u073f\7\u019b\2"
            + "\2\u073e\u073d\3\2\2\2\u073e\u073f\3\2\2\2\u073f\u0740\3\2\2\2\u0740\u0745"
            + "\5\u00f4{\2\u0741\u0742\7\u0189\2\2\u0742\u0744\5\u00f4{\2\u0743\u0741"
            + "\3\2\2\2\u0744\u0747\3\2\2\2\u0745\u0743\3\2\2\2\u0745\u0746\3\2\2\2\u0746"
            + "\u00f3\3\2\2\2\u0747\u0745\3\2\2\2\u0748\u074b\7\u019c\2\2\u0749\u074b"
            + "\5\u0100\u0081\2\u074a\u0748\3\2\2\2\u074a\u0749\3\2\2\2\u074b\u00f5\3"
            + "\2\2\2\u074c\u074f\7\u019d\2\2\u074d\u074f\7\u019e\2\2\u074e\u074c\3\2"
            + "\2\2\u074e\u074d\3\2\2\2\u074f\u00f7\3\2\2\2\u0750\u0752\t\32\2\2\u0751"
            + "\u0750\3\2\2\2\u0751\u0752\3\2\2\2\u0752\u0753\3\2\2\2\u0753\u0754\7\u019f"
            + "\2\2\u0754\u00f9\3\2\2\2\u0755\u0757\t\32\2\2\u0756\u0755\3\2\2\2\u0756"
            + "\u0757\3\2\2\2\u0757\u0758\3\2\2\2\u0758\u0759\7\u01a0\2\2\u0759\u00fb"
            + "\3\2\2\2\u075a\u075b\t\33\2\2\u075b\u00fd\3\2\2\2\u075c\u075d\7\u00cb"
            + "\2\2\u075d\u00ff\3\2\2\2\u075e\u075f\t\34\2\2\u075f\u0101\3\2\2\2\u00ea"
            + "\u0104\u011b\u011f\u0126\u0129\u012e\u0132\u013b\u0140\u0148\u014d\u0156"
            + "\u0162\u0167\u016a\u017f\u0186\u018a\u0196\u019d\u01a6\u01a9\u01b0\u01b8"
            + "\u01be\u01c3\u01c9\u01cd\u01cf\u01d7\u01e3\u01f1\u01fb\u0201\u0206\u020b"
            + "\u0210\u0214\u0219\u0223\u022f\u0236\u0239\u0245\u024a\u0250\u0257\u025e"
            + "\u0262\u0267\u026b\u0270\u0273\u0278\u027b\u027f\u028b\u0292\u029b\u02a0"
            + "\u02a4\u02a6\u02ac\u02b3\u02b6\u02d1\u02d3\u02d8\u02dc\u02e5\u02eb\u02f5"
            + "\u02fd\u0303\u030c\u030e\u0312\u0316\u031e\u0329\u0332\u0339\u0341\u034b"
            + "\u0350\u035d\u0368\u036f\u0376\u037a\u037e\u0382\u0384\u0389\u038c\u038f"
            + "\u0392\u0396\u0399\u039c\u039f\u03a2\u03a9\u03b4\u03b8\u03bb\u03be\u03c2"
            + "\u03ca\u03d3\u03d7\u03e1\u03e9\u03ef\u03f3\u03f6\u03fc\u0405\u0408\u040d"
            + "\u0410\u041a\u041f\u0428\u042d\u0431\u043a\u043e\u044c\u045c\u0461\u046c"
            + "\u0477\u0479\u0480\u0483\u048a\u048f\u0495\u0498\u049b\u04a2\u04a6\u04aa"
            + "\u04ae\u04b4\u04ba\u04c1\u04c9\u04cf\u04d4\u04df\u04e8\u04ec\u04f5\u04f9"
            + "\u0503\u0508\u051e\u0521\u0534\u0544\u0546\u0551\u0560\u056c\u0570\u057b"
            + "\u057f\u0587\u058b\u059b\u05a0\u05a5\u05a9\u05ad\u05b2\u05b6\u05ba\u05d1"
            + "\u05d3\u05e5\u05e7\u05ef\u05f4\u05f9\u05fe\u060b\u0610\u0615\u061a\u061f"
            + "\u0624\u0629\u062e\u0630\u0637\u063a\u0645\u064f\u0657\u0662\u0668\u0679"
            + "\u067c\u068c\u068f\u069f\u06a2\u06b2\u06b5\u06c5\u06c8\u06d8\u06db\u06e9"
            + "\u06f8\u06fc\u0707\u070d\u0712\u071b\u0723\u0725\u0729\u0734\u073e\u0745"
            + "\u074a\u074e\u0751\u0756";
    public static final ATN _ATN = new ATNDeserializer().deserialize(_serializedATN.toCharArray());
    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}
