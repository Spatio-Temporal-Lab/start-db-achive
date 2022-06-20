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
        RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION);
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
        RULE_create_table_definition = 11, RULE_create_table_columns = 12,
        RULE_create_table_columns_item = 13, RULE_column_name = 14,
        RULE_create_table_column_inline_cons = 15, RULE_create_table_column_cons = 16,
        RULE_create_table_fk_action = 17, RULE_create_table_preoptions = 18,
        RULE_create_table_preoptions_item = 19, RULE_create_table_preoptions_td_item = 20,
        RULE_create_table_options = 21, RULE_create_table_options_item = 22,
        RULE_create_table_options_mysql_item = 23, RULE_dtype_default = 24, RULE_showTablesStmt =
            25, RULE_dtype_attr = 26, RULE_dtype = 27, RULE_dtypeLen = 28, RULE_createDatabaseStmt =
                29, RULE_showDatabasesStmt = 30, RULE_dropDatabaseStmt = 31,
        RULE_createDatabaseOption = 32, RULE_dropTableStmt = 33, RULE_insertStmt = 34,
        RULE_insertStmtCols = 35, RULE_insertStmtRows = 36, RULE_insertStmtRow = 37,
        RULE_truncateStmt = 38, RULE_useStmt = 39, RULE_selectStmt = 40, RULE_cteSelectStmt = 41,
        RULE_cteSelectStmtItem = 42, RULE_cteSelectCols = 43, RULE_fullselectStmt = 44,
        RULE_fullselectStmtItem = 45, RULE_fullselectSetClause = 46, RULE_subselectStmt = 47,
        RULE_selectList = 48, RULE_selectListSet = 49, RULE_selectListLimit = 50,
        RULE_selectListItem = 51, RULE_selectListAlias = 52, RULE_selectListAsterisk = 53,
        RULE_intoClause = 54, RULE_fromClause = 55, RULE_fromTableClause = 56,
        RULE_fromTableNameClause = 57, RULE_fromSubselectClause = 58, RULE_fromJoinClause = 59,
        RULE_fromJoinTypeClause = 60, RULE_fromTableValuesClause = 61, RULE_fromTableValuesRow = 62,
        RULE_fromAliasClause = 63, RULE_tableName = 64, RULE_whereClause = 65, RULE_groupByClause =
            66, RULE_havingClause = 67, RULE_qualifyClause = 68, RULE_orderByClause = 69,
        RULE_orderByClauseItem = 70, RULE_sampleClause = 71, RULE_selectOptions = 72,
        RULE_selectOptionsItem = 73, RULE_updateStmt = 74, RULE_updateAssignment = 75,
        RULE_updateTable = 76, RULE_updateUpsert = 77, RULE_deleteStmt = 78, RULE_deleteAlias = 79,
        RULE_describeStmt = 80, RULE_boolExpr = 81, RULE_boolExprAtom = 82, RULE_boolExprUnary = 83,
        RULE_boolExprSingleIn = 84, RULE_boolExprMultiIn = 85, RULE_boolExprBinary = 86,
        RULE_boolExprLogicalOperator = 87, RULE_boolExprBinaryOperator = 88, RULE_expr = 89,
        RULE_exprAtom = 90, RULE_exprInterval = 91, RULE_intervalItem = 92, RULE_exprConcat = 93,
        RULE_exprConcatItem = 94, RULE_exprCase = 95, RULE_exprCaseSimple = 96,
        RULE_exprCaseSearched = 97, RULE_exprCaseItem = 98, RULE_exprCursorAttribute = 99,
        RULE_exprAggWindowFunc = 100, RULE_exprFuncAllDistinct = 101, RULE_exprFuncOverClause = 102,
        RULE_exprFuncPartitionByClause = 103, RULE_exprSpecFunc = 104, RULE_exprFunc = 105,
        RULE_exprFuncParams = 106, RULE_funcParam = 107, RULE_table_name = 108, RULE_qident = 109,
        RULE_dateLiteral = 110, RULE_timestampLiteral = 111, RULE_ident = 112, RULE_identItem = 113,
        RULE_string = 114, RULE_intNumber = 115, RULE_decNumber = 116, RULE_boolLiteral = 117,
        RULE_nullConst = 118, RULE_nonReservedWords = 119;

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
                setState(240);
                stmt();
                setState(242);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_SEMICOLON) {
                    {
                        setState(241);
                        match(T_SEMICOLON);
                    }
                }

                setState(244);
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
            setState(261);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 1, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1); {
                    setState(246);
                    createDatabaseStmt();
                }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2); {
                    setState(247);
                    createTableStmt();
                }
                    break;
                case 3:
                    enterOuterAlt(_localctx, 3); {
                    setState(248);
                    describeStmt();
                }
                    break;
                case 4:
                    enterOuterAlt(_localctx, 4); {
                    setState(249);
                    dropDatabaseStmt();
                }
                    break;
                case 5:
                    enterOuterAlt(_localctx, 5); {
                    setState(250);
                    dropTableStmt();
                }
                    break;
                case 6:
                    enterOuterAlt(_localctx, 6); {
                    setState(251);
                    truncateStmt();
                }
                    break;
                case 7:
                    enterOuterAlt(_localctx, 7); {
                    setState(252);
                    useStmt();
                }
                    break;
                case 8:
                    enterOuterAlt(_localctx, 8); {
                    setState(253);
                    showDatabasesStmt();
                }
                    break;
                case 9:
                    enterOuterAlt(_localctx, 9); {
                    setState(254);
                    showTablesStmt();
                }
                    break;
                case 10:
                    enterOuterAlt(_localctx, 10); {
                    setState(255);
                    showCreateTableStmt();
                }
                    break;
                case 11:
                    enterOuterAlt(_localctx, 11); {
                    setState(256);
                    showStatusStmt();
                }
                    break;
                case 12:
                    enterOuterAlt(_localctx, 12); {
                    setState(257);
                    insertStmt();
                }
                    break;
                case 13:
                    enterOuterAlt(_localctx, 13); {
                    setState(258);
                    updateStmt();
                }
                    break;
                case 14:
                    enterOuterAlt(_localctx, 14); {
                    setState(259);
                    deleteStmt();
                }
                    break;
                case 15:
                    enterOuterAlt(_localctx, 15); {
                    setState(260);
                    selectStmt();
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
                setState(265);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 2, _ctx)) {
                    case 1: {
                        setState(263);
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
                        setState(264);
                        match(T_DOT);
                    }
                        break;
                }
                setState(267);
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
            setState(275);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 4, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1); {
                    setState(269);
                    dbDotTable();
                }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2); {
                    setState(272);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 3, _ctx)) {
                        case 1: {
                            setState(270);
                            ((UserDotDbDotTableContext) _localctx).user = match(L_ID);
                            setState(271);
                            match(T_DOT);
                        }
                            break;
                    }
                    setState(274);
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
            setState(280);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 5, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1); {
                    setState(277);
                    assignmentStmtSingleItem();
                }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2); {
                    setState(278);
                    assignmentStmtMultipleItem();
                }
                    break;
                case 3:
                    enterOuterAlt(_localctx, 3); {
                    setState(279);
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
            setState(298);
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
                    setState(282);
                    ident();
                    setState(284);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_COLON) {
                        {
                            setState(283);
                            match(T_COLON);
                        }
                    }

                    setState(286);
                    match(T_EQUAL);
                    setState(287);
                    expr(0);
                }
                    break;
                case T_OPEN_P:
                    enterOuterAlt(_localctx, 2); {
                    setState(289);
                    match(T_OPEN_P);
                    setState(290);
                    ident();
                    setState(291);
                    match(T_CLOSE_P);
                    setState(293);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_COLON) {
                        {
                            setState(292);
                            match(T_COLON);
                        }
                    }

                    setState(295);
                    match(T_EQUAL);
                    setState(296);
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
                setState(300);
                match(T_OPEN_P);
                setState(301);
                ident();
                setState(306);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T_COMMA) {
                    {
                        {
                            setState(302);
                            match(T_COMMA);
                            setState(303);
                            ident();
                        }
                    }
                    setState(308);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(309);
                match(T_CLOSE_P);
                setState(311);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_COLON) {
                    {
                        setState(310);
                        match(T_COLON);
                    }
                }

                setState(313);
                match(T_EQUAL);
                setState(314);
                match(T_OPEN_P);
                setState(315);
                expr(0);
                setState(320);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T_COMMA) {
                    {
                        {
                            setState(316);
                            match(T_COMMA);
                            setState(317);
                            expr(0);
                        }
                    }
                    setState(322);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(323);
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
                setState(337);
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
                        setState(325);
                        ident();
                    }
                        break;
                    case T_OPEN_P: {
                        {
                            setState(326);
                            match(T_OPEN_P);
                            setState(327);
                            ident();
                            setState(332);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                            while (_la == T_COMMA) {
                                {
                                    {
                                        setState(328);
                                        match(T_COMMA);
                                        setState(329);
                                        ident();
                                    }
                                }
                                setState(334);
                                _errHandler.sync(this);
                                _la = _input.LA(1);
                            }
                            setState(335);
                            match(T_CLOSE_P);
                        }
                    }
                        break;
                    default:
                        throw new NoViableAltException(this);
                }
                setState(340);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_COLON) {
                    {
                        setState(339);
                        match(T_COLON);
                    }
                }

                setState(342);
                match(T_EQUAL);
                setState(343);
                match(T_OPEN_P);
                setState(344);
                selectStmt();
                setState(345);
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
                setState(347);
                match(T_SHOW);
                setState(348);
                match(T_CREATE);
                setState(349);
                match(T_TABLE);
                setState(350);
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
                setState(352);
                match(T_SHOW);
                setState(353);
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
                setState(355);
                match(T_CREATE);
                setState(356);
                match(T_TABLE);
                setState(360);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 15, _ctx)) {
                    case 1: {
                        setState(357);
                        match(T_IF);
                        setState(358);
                        match(T_NOT);
                        setState(359);
                        match(T_EXISTS);
                    }
                        break;
                }
                setState(362);
                table_name();
                setState(364);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_COMMA) {
                    {
                        setState(363);
                        create_table_preoptions();
                    }
                }

                setState(366);
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
        enterRule(_localctx, 22, RULE_create_table_definition);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(385);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 19, _ctx)) {
                    case 1: {
                        setState(369);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        if (_la == T_AS) {
                            {
                                setState(368);
                                match(T_AS);
                            }
                        }

                        setState(371);
                        match(T_OPEN_P);
                        setState(372);
                        selectStmt();
                        setState(373);
                        match(T_CLOSE_P);
                    }
                        break;
                    case 2: {
                        setState(376);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        if (_la == T_AS) {
                            {
                                setState(375);
                                match(T_AS);
                            }
                        }

                        setState(378);
                        selectStmt();
                    }
                        break;
                    case 3: {
                        setState(379);
                        match(T_OPEN_P);
                        setState(380);
                        create_table_columns();
                        setState(381);
                        match(T_CLOSE_P);
                    }
                        break;
                    case 4: {
                        setState(383);
                        match(T_LIKE);
                        setState(384);
                        table_name();
                    }
                        break;
                }
                setState(388);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if ((((_la) & ~0x3f) == 0
                    && ((1L << _la) & ((1L << T_AUTO_INCREMENT) | (1L << T_CHARACTER) | (1L
                        << T_CHARSET) | (1L << T_COMMENT))) != 0)
                    || _la == T_DEFAULT
                    || _la == T_ENGINE
                    || _la == T_ON) {
                    {
                        setState(387);
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
        enterRule(_localctx, 24, RULE_create_table_columns);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(390);
                create_table_columns_item();
                setState(395);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T_COMMA) {
                    {
                        {
                            setState(391);
                            match(T_COMMA);
                            setState(392);
                            create_table_columns_item();
                        }
                    }
                    setState(397);
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
        enterRule(_localctx, 26, RULE_create_table_columns_item);
        int _la;
        try {
            int _alt;
            setState(417);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 25, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1); {
                    setState(398);
                    column_name();
                    setState(399);
                    dtype();
                    setState(403);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 22, _ctx);
                    while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                        if (_alt == 1) {
                            {
                                {
                                    setState(400);
                                    dtype_attr();
                                }
                            }
                        }
                        setState(405);
                        _errHandler.sync(this);
                        _alt = getInterpreter().adaptivePredict(_input, 22, _ctx);
                    }
                    setState(409);
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
                                setState(406);
                                create_table_column_inline_cons();
                            }
                        }
                        setState(411);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2); {
                    setState(414);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_CONSTRAINT) {
                        {
                            setState(412);
                            match(T_CONSTRAINT);
                            setState(413);
                            qident();
                        }
                    }

                    setState(416);
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
        enterRule(_localctx, 28, RULE_column_name);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(419);
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
        enterRule(_localctx, 30, RULE_create_table_column_inline_cons);
        int _la;
        try {
            setState(453);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T_DEFAULT:
                case T_WITH:
                case T_COLON:
                case T_EQUAL:
                    enterOuterAlt(_localctx, 1); {
                    setState(421);
                    dtype_default();
                }
                    break;
                case T_NOT:
                case T_NULL:
                    enterOuterAlt(_localctx, 2); {
                    setState(423);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_NOT) {
                        {
                            setState(422);
                            match(T_NOT);
                        }
                    }

                    setState(425);
                    match(T_NULL);
                }
                    break;
                case T_PRIMARY:
                    enterOuterAlt(_localctx, 3); {
                    setState(426);
                    match(T_PRIMARY);
                    setState(427);
                    match(T_KEY);
                }
                    break;
                case T_UNIQUE:
                    enterOuterAlt(_localctx, 4); {
                    setState(428);
                    match(T_UNIQUE);
                }
                    break;
                case T_REFERENCES:
                    enterOuterAlt(_localctx, 5); {
                    setState(429);
                    match(T_REFERENCES);
                    setState(430);
                    table_name();
                    setState(431);
                    match(T_OPEN_P);
                    setState(432);
                    qident();
                    setState(433);
                    match(T_CLOSE_P);
                    setState(437);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == T_ON) {
                        {
                            {
                                setState(434);
                                create_table_fk_action();
                            }
                        }
                        setState(439);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                }
                    break;
                case T_IDENTITY:
                    enterOuterAlt(_localctx, 6); {
                    setState(440);
                    match(T_IDENTITY);
                    setState(441);
                    match(T_OPEN_P);
                    setState(442);
                    match(L_INT);
                    setState(447);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == T_COMMA) {
                        {
                            {
                                setState(443);
                                match(T_COMMA);
                                setState(444);
                                match(L_INT);
                            }
                        }
                        setState(449);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                    setState(450);
                    match(T_CLOSE_P);
                }
                    break;
                case T_AUTO_INCREMENT:
                    enterOuterAlt(_localctx, 7); {
                    setState(451);
                    match(T_AUTO_INCREMENT);
                }
                    break;
                case T_ENABLE:
                    enterOuterAlt(_localctx, 8); {
                    setState(452);
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
        enterRule(_localctx, 32, RULE_create_table_column_cons);
        int _la;
        try {
            setState(509);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T_PRIMARY:
                    enterOuterAlt(_localctx, 1); {
                    setState(455);
                    match(T_PRIMARY);
                    setState(456);
                    match(T_KEY);
                    setState(458);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_CLUSTERED) {
                        {
                            setState(457);
                            match(T_CLUSTERED);
                        }
                    }

                    setState(460);
                    match(T_OPEN_P);
                    setState(461);
                    qident();
                    setState(463);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_ASC || _la == T_DESC) {
                        {
                            setState(462);
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

                    setState(472);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == T_COMMA) {
                        {
                            {
                                setState(465);
                                match(T_COMMA);
                                setState(466);
                                qident();
                                setState(468);
                                _errHandler.sync(this);
                                _la = _input.LA(1);
                                if (_la == T_ASC || _la == T_DESC) {
                                    {
                                        setState(467);
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
                        setState(474);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                    setState(475);
                    match(T_CLOSE_P);
                    setState(477);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_ENABLE) {
                        {
                            setState(476);
                            match(T_ENABLE);
                        }
                    }

                }
                    break;
                case T_FOREIGN:
                    enterOuterAlt(_localctx, 2); {
                    setState(479);
                    match(T_FOREIGN);
                    setState(480);
                    match(T_KEY);
                    setState(481);
                    match(T_OPEN_P);
                    setState(482);
                    qident();
                    setState(487);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == T_COMMA) {
                        {
                            {
                                setState(483);
                                match(T_COMMA);
                                setState(484);
                                qident();
                            }
                        }
                        setState(489);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                    setState(490);
                    match(T_CLOSE_P);
                    setState(491);
                    match(T_REFERENCES);
                    setState(492);
                    table_name();
                    setState(493);
                    match(T_OPEN_P);
                    setState(494);
                    qident();
                    setState(499);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == T_COMMA) {
                        {
                            {
                                setState(495);
                                match(T_COMMA);
                                setState(496);
                                qident();
                            }
                        }
                        setState(501);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                    setState(502);
                    match(T_CLOSE_P);
                    setState(506);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == T_ON) {
                        {
                            {
                                setState(503);
                                create_table_fk_action();
                            }
                        }
                        setState(508);
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
        enterRule(_localctx, 34, RULE_create_table_fk_action);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(511);
                match(T_ON);
                setState(512);
                _la = _input.LA(1);
                if (!(_la == T_DELETE || _la == T_UPDATE)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
                setState(521);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 39, _ctx)) {
                    case 1: {
                        setState(513);
                        match(T_NO);
                        setState(514);
                        match(T_ACTION);
                    }
                        break;
                    case 2: {
                        setState(515);
                        match(T_RESTRICT);
                    }
                        break;
                    case 3: {
                        setState(516);
                        match(T_SET);
                        setState(517);
                        match(T_NULL);
                    }
                        break;
                    case 4: {
                        setState(518);
                        match(T_SET);
                        setState(519);
                        match(T_DEFAULT);
                    }
                        break;
                    case 5: {
                        setState(520);
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
        enterRule(_localctx, 36, RULE_create_table_preoptions);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(524);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        {
                            setState(523);
                            create_table_preoptions_item();
                        }
                    }
                    setState(526);
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
        enterRule(_localctx, 38, RULE_create_table_preoptions_item);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(528);
                match(T_COMMA);
                setState(529);
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
        enterRule(_localctx, 40, RULE_create_table_preoptions_td_item);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(532);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_NO) {
                    {
                        setState(531);
                        match(T_NO);
                    }
                }

                setState(534);
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
        enterRule(_localctx, 42, RULE_create_table_options);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(537);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        {
                            setState(536);
                            create_table_options_item();
                        }
                    }
                    setState(539);
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
        enterRule(_localctx, 44, RULE_create_table_options_item);
        int _la;
        try {
            setState(546);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T_ON:
                    enterOuterAlt(_localctx, 1); {
                    setState(541);
                    match(T_ON);
                    setState(542);
                    match(T_COMMIT);
                    setState(543);
                    _la = _input.LA(1);
                    if (!(_la == T_DELETE || _la == T_PRESERVE)) {
                        _errHandler.recoverInline(this);
                    } else {
                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                        _errHandler.reportMatch(this);
                        consume();
                    }
                    setState(544);
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
                    setState(545);
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
        enterRule(_localctx, 46, RULE_create_table_options_mysql_item);
        int _la;
        try {
            setState(575);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T_AUTO_INCREMENT:
                    enterOuterAlt(_localctx, 1); {
                    setState(548);
                    match(T_AUTO_INCREMENT);
                    setState(550);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_EQUAL) {
                        {
                            setState(549);
                            match(T_EQUAL);
                        }
                    }

                    setState(552);
                    expr(0);
                }
                    break;
                case T_COMMENT:
                    enterOuterAlt(_localctx, 2); {
                    setState(553);
                    match(T_COMMENT);
                    setState(555);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_EQUAL) {
                        {
                            setState(554);
                            match(T_EQUAL);
                        }
                    }

                    setState(557);
                    expr(0);
                }
                    break;
                case T_CHARACTER:
                case T_CHARSET:
                case T_DEFAULT:
                    enterOuterAlt(_localctx, 3); {
                    setState(559);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_DEFAULT) {
                        {
                            setState(558);
                            match(T_DEFAULT);
                        }
                    }

                    setState(564);
                    _errHandler.sync(this);
                    switch (_input.LA(1)) {
                        case T_CHARACTER: {
                            setState(561);
                            match(T_CHARACTER);
                            setState(562);
                            match(T_SET);
                        }
                            break;
                        case T_CHARSET: {
                            setState(563);
                            match(T_CHARSET);
                        }
                            break;
                        default:
                            throw new NoViableAltException(this);
                    }
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
                case T_ENGINE:
                    enterOuterAlt(_localctx, 4); {
                    setState(570);
                    match(T_ENGINE);
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
        enterRule(_localctx, 48, RULE_dtype_default);
        int _la;
        try {
            setState(589);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T_COLON:
                case T_EQUAL:
                    enterOuterAlt(_localctx, 1); {
                    setState(578);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_COLON) {
                        {
                            setState(577);
                            match(T_COLON);
                        }
                    }

                    setState(580);
                    match(T_EQUAL);
                    setState(581);
                    expr(0);
                }
                    break;
                case T_DEFAULT:
                case T_WITH:
                    enterOuterAlt(_localctx, 2); {
                    setState(583);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_WITH) {
                        {
                            setState(582);
                            match(T_WITH);
                        }
                    }

                    setState(585);
                    match(T_DEFAULT);
                    setState(587);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 53, _ctx)) {
                        case 1: {
                            setState(586);
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
        enterRule(_localctx, 50, RULE_showTablesStmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(591);
                match(T_SHOW);
                setState(592);
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
        enterRule(_localctx, 52, RULE_dtype_attr);
        int _la;
        try {
            setState(605);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 57, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1); {
                    setState(595);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_NOT) {
                        {
                            setState(594);
                            match(T_NOT);
                        }
                    }

                    setState(597);
                    match(T_NULL);
                }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2); {
                    setState(598);
                    match(T_CHARACTER);
                    setState(599);
                    match(T_SET);
                    setState(600);
                    ident();
                }
                    break;
                case 3:
                    enterOuterAlt(_localctx, 3); {
                    setState(602);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_NOT) {
                        {
                            setState(601);
                            match(T_NOT);
                        }
                    }

                    setState(604);
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
        enterRule(_localctx, 54, RULE_dtype);
        int _la;
        try {
            setState(634);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 59, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1); {
                    setState(607);
                    match(T_DATETIME);
                }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2); {
                    setState(608);
                    match(T_DOUBLE);
                }
                    break;
                case 3:
                    enterOuterAlt(_localctx, 3); {
                    setState(609);
                    match(T_FLOAT);
                }
                    break;
                case 4:
                    enterOuterAlt(_localctx, 4); {
                    setState(610);
                    match(T_INT);
                }
                    break;
                case 5:
                    enterOuterAlt(_localctx, 5); {
                    setState(611);
                    match(T_INTEGER);
                }
                    break;
                case 6:
                    enterOuterAlt(_localctx, 6); {
                    setState(612);
                    match(T_STRING);
                }
                    break;
                case 7:
                    enterOuterAlt(_localctx, 7); {
                    setState(613);
                    match(T_TIMESTAMP);
                }
                    break;
                case 8:
                    enterOuterAlt(_localctx, 8); {
                    setState(614);
                    match(T_LONG);
                }
                    break;
                case 9:
                    enterOuterAlt(_localctx, 9); {
                    setState(615);
                    match(T_BOOLEAN);
                }
                    break;
                case 10:
                    enterOuterAlt(_localctx, 10); {
                    setState(616);
                    match(T_BOOL);
                }
                    break;
                case 11:
                    enterOuterAlt(_localctx, 11); {
                    setState(617);
                    match(T_BINARY);
                }
                    break;
                case 12:
                    enterOuterAlt(_localctx, 12); {
                    setState(618);
                    match(T_GEOMETRY);
                }
                    break;
                case 13:
                    enterOuterAlt(_localctx, 13); {
                    setState(619);
                    match(T_POINT);
                }
                    break;
                case 14:
                    enterOuterAlt(_localctx, 14); {
                    setState(620);
                    match(T_LINESTRING);
                }
                    break;
                case 15:
                    enterOuterAlt(_localctx, 15); {
                    setState(621);
                    match(T_POLYGON);
                }
                    break;
                case 16:
                    enterOuterAlt(_localctx, 16); {
                    setState(622);
                    match(T_MULTIPOINT);
                }
                    break;
                case 17:
                    enterOuterAlt(_localctx, 17); {
                    setState(623);
                    match(T_MULTILINESTRING);
                }
                    break;
                case 18:
                    enterOuterAlt(_localctx, 18); {
                    setState(624);
                    match(T_MULTIPOLYGON);
                }
                    break;
                case 19:
                    enterOuterAlt(_localctx, 19); {
                    setState(625);
                    match(T_GEOMETRYCOLLECTION);
                }
                    break;
                case 20:
                    enterOuterAlt(_localctx, 20); {
                    setState(626);
                    match(T_TRAJECTORY);
                }
                    break;
                case 21:
                    enterOuterAlt(_localctx, 21); {
                    setState(627);
                    match(T_ROADSEGMENT);
                }
                    break;
                case 22:
                    enterOuterAlt(_localctx, 22); {
                    setState(628);
                    match(T_ROADNETWORK);
                }
                    break;
                case 23:
                    enterOuterAlt(_localctx, 23); {
                    setState(629);
                    ident();
                    setState(632);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T__0) {
                        {
                            setState(630);
                            match(T__0);
                            setState(631);
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
        enterRule(_localctx, 56, RULE_dtypeLen);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(636);
                match(T_OPEN_P);
                setState(637);
                _la = _input.LA(1);
                if (!(_la == T_MAX || _la == L_INT)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
                setState(639);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_BYTE || _la == T_CHAR) {
                    {
                        setState(638);
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

                setState(643);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_COMMA) {
                    {
                        setState(641);
                        match(T_COMMA);
                        setState(642);
                        match(L_INT);
                    }
                }

                setState(645);
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
        enterRule(_localctx, 58, RULE_createDatabaseStmt);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(647);
                match(T_CREATE);
                setState(648);
                _la = _input.LA(1);
                if (!(_la == T_DATABASE || _la == T_SCHEMA)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
                setState(652);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_IF) {
                    {
                        setState(649);
                        match(T_IF);
                        setState(650);
                        match(T_NOT);
                        setState(651);
                        match(T_EXISTS);
                    }
                }

                setState(654);
                ((CreateDatabaseStmtContext) _localctx).dbName = match(L_ID);
                setState(658);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T_COMMENT || _la == T_LOCATION) {
                    {
                        {
                            setState(655);
                            createDatabaseOption();
                        }
                    }
                    setState(660);
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
        enterRule(_localctx, 60, RULE_showDatabasesStmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(661);
                match(T_SHOW);
                setState(662);
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
        enterRule(_localctx, 62, RULE_dropDatabaseStmt);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(664);
                match(T_DROP);
                setState(665);
                _la = _input.LA(1);
                if (!(_la == T_DATABASE || _la == T_SCHEMA)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
                setState(668);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_IF) {
                    {
                        setState(666);
                        match(T_IF);
                        setState(667);
                        match(T_EXISTS);
                    }
                }

                setState(670);
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
        enterRule(_localctx, 64, RULE_createDatabaseOption);
        try {
            setState(676);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T_COMMENT:
                    enterOuterAlt(_localctx, 1); {
                    setState(672);
                    match(T_COMMENT);
                    setState(673);
                    expr(0);
                }
                    break;
                case T_LOCATION:
                    enterOuterAlt(_localctx, 2); {
                    setState(674);
                    match(T_LOCATION);
                    setState(675);
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
        enterRule(_localctx, 66, RULE_dropTableStmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(678);
                match(T_DROP);
                setState(679);
                match(T_TABLE);
                setState(682);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 66, _ctx)) {
                    case 1: {
                        setState(680);
                        match(T_IF);
                        setState(681);
                        match(T_EXISTS);
                    }
                        break;
                }
                setState(684);
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
        enterRule(_localctx, 68, RULE_insertStmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(686);
                match(T_INSERT);
                setState(693);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case T_OVERWRITE: {
                        setState(687);
                        match(T_OVERWRITE);
                        setState(688);
                        match(T_TABLE);
                    }
                        break;
                    case T_INTO: {
                        setState(689);
                        match(T_INTO);
                        setState(691);
                        _errHandler.sync(this);
                        switch (getInterpreter().adaptivePredict(_input, 67, _ctx)) {
                            case 1: {
                                setState(690);
                                match(T_TABLE);
                            }
                                break;
                        }
                    }
                        break;
                    default:
                        throw new NoViableAltException(this);
                }
                setState(695);
                tableName();
                setState(697);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 69, _ctx)) {
                    case 1: {
                        setState(696);
                        insertStmtCols();
                    }
                        break;
                }
                setState(701);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case T_SEL:
                    case T_SELECT:
                    case T_WITH:
                    case T_OPEN_P: {
                        setState(699);
                        selectStmt();
                    }
                        break;
                    case T_VALUES: {
                        setState(700);
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
        enterRule(_localctx, 70, RULE_insertStmtCols);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(703);
                match(T_OPEN_P);
                setState(704);
                ident();
                setState(709);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T_COMMA) {
                    {
                        {
                            setState(705);
                            match(T_COMMA);
                            setState(706);
                            ident();
                        }
                    }
                    setState(711);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(712);
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
        enterRule(_localctx, 72, RULE_insertStmtRows);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(714);
                match(T_VALUES);
                setState(715);
                insertStmtRow();
                setState(720);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T_COMMA) {
                    {
                        {
                            setState(716);
                            match(T_COMMA);
                            setState(717);
                            insertStmtRow();
                        }
                    }
                    setState(722);
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
        enterRule(_localctx, 74, RULE_insertStmtRow);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(723);
                match(T_OPEN_P);
                setState(724);
                expr(0);
                setState(729);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T_COMMA) {
                    {
                        {
                            setState(725);
                            match(T_COMMA);
                            setState(726);
                            expr(0);
                        }
                    }
                    setState(731);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
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
        enterRule(_localctx, 76, RULE_truncateStmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(734);
                match(T_TRUNCATE);
                setState(736);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 74, _ctx)) {
                    case 1: {
                        setState(735);
                        match(T_TABLE);
                    }
                        break;
                }
                setState(738);
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
        enterRule(_localctx, 78, RULE_useStmt);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(740);
                match(T_USE);
                setState(741);
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
        enterRule(_localctx, 80, RULE_selectStmt);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(744);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_WITH) {
                    {
                        setState(743);
                        cteSelectStmt();
                    }
                }

                setState(746);
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
        enterRule(_localctx, 82, RULE_cteSelectStmt);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(748);
                match(T_WITH);
                setState(749);
                cteSelectStmtItem();
                setState(754);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T_COMMA) {
                    {
                        {
                            setState(750);
                            match(T_COMMA);
                            setState(751);
                            cteSelectStmtItem();
                        }
                    }
                    setState(756);
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
        enterRule(_localctx, 84, RULE_cteSelectStmtItem);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(757);
                ident();
                setState(759);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_OPEN_P) {
                    {
                        setState(758);
                        cteSelectCols();
                    }
                }

                setState(761);
                match(T_AS);
                setState(762);
                match(T_OPEN_P);
                setState(763);
                fullselectStmt();
                setState(764);
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
        enterRule(_localctx, 86, RULE_cteSelectCols);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(766);
                match(T_OPEN_P);
                setState(767);
                ident();
                setState(772);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T_COMMA) {
                    {
                        {
                            setState(768);
                            match(T_COMMA);
                            setState(769);
                            ident();
                        }
                    }
                    setState(774);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(775);
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
        enterRule(_localctx, 88, RULE_fullselectStmt);
        int _la;
        try {
            setState(790);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 80, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1); {
                    setState(777);
                    fullselectStmtItem();
                    setState(783);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == T_EXCEPT || _la == T_INTERSECT || _la == T_UNION) {
                        {
                            {
                                setState(778);
                                fullselectSetClause();
                                setState(779);
                                fullselectStmtItem();
                            }
                        }
                        setState(785);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2); {
                    setState(786);
                    match(T_OPEN_P);
                    setState(787);
                    fullselectStmt();
                    setState(788);
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
        enterRule(_localctx, 90, RULE_fullselectStmtItem);
        try {
            setState(797);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T_SEL:
                case T_SELECT:
                    enterOuterAlt(_localctx, 1); {
                    setState(792);
                    subselectStmt();
                }
                    break;
                case T_OPEN_P:
                    enterOuterAlt(_localctx, 2); {
                    setState(793);
                    match(T_OPEN_P);
                    setState(794);
                    fullselectStmt();
                    setState(795);
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
        enterRule(_localctx, 92, RULE_fullselectSetClause);
        int _la;
        try {
            setState(811);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T_UNION:
                    enterOuterAlt(_localctx, 1); {
                    setState(799);
                    match(T_UNION);
                    setState(801);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_ALL) {
                        {
                            setState(800);
                            match(T_ALL);
                        }
                    }

                }
                    break;
                case T_EXCEPT:
                    enterOuterAlt(_localctx, 2); {
                    setState(803);
                    match(T_EXCEPT);
                    setState(805);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_ALL) {
                        {
                            setState(804);
                            match(T_ALL);
                        }
                    }

                }
                    break;
                case T_INTERSECT:
                    enterOuterAlt(_localctx, 3); {
                    setState(807);
                    match(T_INTERSECT);
                    setState(809);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_ALL) {
                        {
                            setState(808);
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
        enterRule(_localctx, 94, RULE_subselectStmt);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(813);
                _la = _input.LA(1);
                if (!(_la == T_SEL || _la == T_SELECT)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
                setState(814);
                selectList();
                setState(816);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_INTO) {
                    {
                        setState(815);
                        intoClause();
                    }
                }

                setState(819);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_FROM) {
                    {
                        setState(818);
                        fromClause();
                    }
                }

                setState(822);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_WHERE) {
                    {
                        setState(821);
                        whereClause();
                    }
                }

                setState(825);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_GROUP) {
                    {
                        setState(824);
                        groupByClause();
                    }
                }

                setState(829);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case T_HAVING: {
                        setState(827);
                        havingClause();
                    }
                        break;
                    case T_QUALIFY: {
                        setState(828);
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
                setState(832);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_ORDER) {
                    {
                        setState(831);
                        orderByClause();
                    }
                }

                setState(835);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_LIMIT || _la == T_WITH) {
                    {
                        setState(834);
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
        enterRule(_localctx, 96, RULE_selectList);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(838);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 93, _ctx)) {
                    case 1: {
                        setState(837);
                        selectListSet();
                    }
                        break;
                }
                setState(841);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 94, _ctx)) {
                    case 1: {
                        setState(840);
                        selectListLimit();
                    }
                        break;
                }
                setState(843);
                selectListItem();
                setState(848);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T_COMMA) {
                    {
                        {
                            setState(844);
                            match(T_COMMA);
                            setState(845);
                            selectListItem();
                        }
                    }
                    setState(850);
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
        enterRule(_localctx, 98, RULE_selectListSet);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(851);
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
        enterRule(_localctx, 100, RULE_selectListLimit);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(853);
                match(T_TOP);
                setState(854);
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
        enterRule(_localctx, 102, RULE_selectListItem);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(866);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 98, _ctx)) {
                    case 1: {
                        setState(859);
                        _errHandler.sync(this);
                        switch (getInterpreter().adaptivePredict(_input, 96, _ctx)) {
                            case 1: {
                                setState(856);
                                ident();
                                setState(857);
                                match(T_EQUAL);
                            }
                                break;
                        }
                        setState(861);
                        expr(0);
                        setState(863);
                        _errHandler.sync(this);
                        switch (getInterpreter().adaptivePredict(_input, 97, _ctx)) {
                            case 1: {
                                setState(862);
                                selectListAlias();
                            }
                                break;
                        }
                    }
                        break;
                    case 2: {
                        setState(865);
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
        enterRule(_localctx, 104, RULE_selectListAlias);
        int _la;
        try {
            setState(890);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 102, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1); {
                    setState(869);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 99, _ctx)) {
                        case 1: {
                            setState(868);
                            match(T_AS);
                        }
                            break;
                    }
                    setState(871);
                    ident();
                }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2); {
                    setState(873);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_AS) {
                        {
                            setState(872);
                            match(T_AS);
                        }
                    }

                    setState(875);
                    match(T_OPEN_P);
                    setState(876);
                    ident();
                    setState(881);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == T_COMMA) {
                        {
                            {
                                setState(877);
                                match(T_COMMA);
                                setState(878);
                                ident();
                            }
                        }
                        setState(883);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                    setState(884);
                    match(T_CLOSE_P);
                }
                    break;
                case 3:
                    enterOuterAlt(_localctx, 3); {
                    setState(886);
                    match(T_OPEN_P);
                    setState(887);
                    match(T_TITLE);
                    setState(888);
                    match(L_S_STRING);
                    setState(889);
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
        enterRule(_localctx, 106, RULE_selectListAsterisk);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(894);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == L_ID) {
                    {
                        setState(892);
                        match(L_ID);
                        setState(893);
                        match(T_DOT);
                    }
                }

                setState(896);
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
        enterRule(_localctx, 108, RULE_intoClause);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(898);
                match(T_INTO);
                setState(899);
                ident();
                setState(904);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T_COMMA) {
                    {
                        {
                            setState(900);
                            match(T_COMMA);
                            setState(901);
                            ident();
                        }
                    }
                    setState(906);
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
        enterRule(_localctx, 110, RULE_fromClause);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(907);
                match(T_FROM);
                setState(908);
                fromTableClause();
                setState(912);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 105, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            {
                                setState(909);
                                fromJoinClause();
                            }
                        }
                    }
                    setState(914);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 105, _ctx);
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
        enterRule(_localctx, 112, RULE_fromTableClause);
        try {
            setState(918);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 106, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1); {
                    setState(915);
                    fromTableNameClause();
                }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2); {
                    setState(916);
                    fromSubselectClause();
                }
                    break;
                case 3:
                    enterOuterAlt(_localctx, 3); {
                    setState(917);
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
        enterRule(_localctx, 114, RULE_fromTableNameClause);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(920);
                tableName();
                setState(922);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 107, _ctx)) {
                    case 1: {
                        setState(921);
                        fromAliasClause();
                    }
                        break;
                }
                setState(925);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_TABLESAMPLE) {
                    {
                        setState(924);
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
        enterRule(_localctx, 116, RULE_fromSubselectClause);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(927);
                match(T_OPEN_P);
                setState(928);
                selectStmt();
                setState(929);
                match(T_CLOSE_P);
                setState(931);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 109, _ctx)) {
                    case 1: {
                        setState(930);
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
        enterRule(_localctx, 118, RULE_fromJoinClause);
        try {
            setState(940);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T_COMMA:
                    enterOuterAlt(_localctx, 1); {
                    setState(933);
                    match(T_COMMA);
                    setState(934);
                    fromTableClause();
                }
                    break;
                case T_FULL:
                case T_INNER:
                case T_JOIN:
                case T_LEFT:
                case T_RIGHT:
                    enterOuterAlt(_localctx, 2); {
                    setState(935);
                    fromJoinTypeClause();
                    setState(936);
                    fromTableClause();
                    setState(937);
                    match(T_ON);
                    setState(938);
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
        enterRule(_localctx, 120, RULE_fromJoinTypeClause);
        int _la;
        try {
            setState(951);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T_INNER:
                case T_JOIN:
                    enterOuterAlt(_localctx, 1); {
                    setState(943);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_INNER) {
                        {
                            setState(942);
                            match(T_INNER);
                        }
                    }

                    setState(945);
                    match(T_JOIN);
                }
                    break;
                case T_FULL:
                case T_LEFT:
                case T_RIGHT:
                    enterOuterAlt(_localctx, 2); {
                    setState(946);
                    _la = _input.LA(1);
                    if (!(_la == T_FULL || _la == T_LEFT || _la == T_RIGHT)) {
                        _errHandler.recoverInline(this);
                    } else {
                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                        _errHandler.reportMatch(this);
                        consume();
                    }
                    setState(948);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_OUTER) {
                        {
                            setState(947);
                            match(T_OUTER);
                        }
                    }

                    setState(950);
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
        enterRule(_localctx, 122, RULE_fromTableValuesClause);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(953);
                match(T_TABLE);
                setState(954);
                match(T_OPEN_P);
                setState(955);
                match(T_VALUES);
                setState(956);
                fromTableValuesRow();
                setState(961);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T_COMMA) {
                    {
                        {
                            setState(957);
                            match(T_COMMA);
                            setState(958);
                            fromTableValuesRow();
                        }
                    }
                    setState(963);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(964);
                match(T_CLOSE_P);
                setState(966);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 115, _ctx)) {
                    case 1: {
                        setState(965);
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
        enterRule(_localctx, 124, RULE_fromTableValuesRow);
        int _la;
        try {
            setState(980);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 117, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1); {
                    setState(968);
                    expr(0);
                }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2); {
                    setState(969);
                    match(T_OPEN_P);
                    setState(970);
                    expr(0);
                    setState(975);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == T_COMMA) {
                        {
                            {
                                setState(971);
                                match(T_COMMA);
                                setState(972);
                                expr(0);
                            }
                        }
                        setState(977);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                    setState(978);
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
        enterRule(_localctx, 126, RULE_fromAliasClause);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(982);
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
                setState(984);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 118, _ctx)) {
                    case 1: {
                        setState(983);
                        match(T_AS);
                    }
                        break;
                }
                setState(986);
                ident();
                setState(997);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_OPEN_P) {
                    {
                        setState(987);
                        match(T_OPEN_P);
                        setState(988);
                        match(L_ID);
                        setState(993);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        while (_la == T_COMMA) {
                            {
                                {
                                    setState(989);
                                    match(T_COMMA);
                                    setState(990);
                                    match(L_ID);
                                }
                            }
                            setState(995);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                        }
                        setState(996);
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
        enterRule(_localctx, 128, RULE_tableName);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(999);
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
        enterRule(_localctx, 130, RULE_whereClause);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1001);
                match(T_WHERE);
                setState(1002);
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
        enterRule(_localctx, 132, RULE_groupByClause);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1004);
                match(T_GROUP);
                setState(1005);
                match(T_BY);
                setState(1006);
                expr(0);
                setState(1011);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T_COMMA) {
                    {
                        {
                            setState(1007);
                            match(T_COMMA);
                            setState(1008);
                            expr(0);
                        }
                    }
                    setState(1013);
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
        enterRule(_localctx, 134, RULE_havingClause);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1014);
                match(T_HAVING);
                setState(1015);
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
        enterRule(_localctx, 136, RULE_qualifyClause);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1017);
                match(T_QUALIFY);
                setState(1018);
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
        enterRule(_localctx, 138, RULE_orderByClause);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1020);
                match(T_ORDER);
                setState(1021);
                match(T_BY);
                setState(1022);
                orderByClauseItem();
                setState(1027);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T_COMMA) {
                    {
                        {
                            setState(1023);
                            match(T_COMMA);
                            setState(1024);
                            orderByClauseItem();
                        }
                    }
                    setState(1029);
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
        enterRule(_localctx, 140, RULE_orderByClauseItem);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1030);
                expr(0);
                setState(1032);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_ASC || _la == T_DESC) {
                    {
                        setState(1031);
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
        enterRule(_localctx, 142, RULE_sampleClause);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1034);
                match(T_TABLESAMPLE);
                setState(1035);
                match(T_OPEN_P);
                setState(1036);
                match(L_INT);
                setState(1037);
                match(T_PERCENT);
                setState(1038);
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
        enterRule(_localctx, 144, RULE_selectOptions);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1041);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        {
                            setState(1040);
                            selectOptionsItem();
                        }
                    }
                    setState(1043);
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
        enterRule(_localctx, 146, RULE_selectOptionsItem);
        int _la;
        try {
            setState(1056);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T_LIMIT:
                    enterOuterAlt(_localctx, 1); {
                    setState(1045);
                    match(T_LIMIT);
                    setState(1046);
                    expr(0);
                }
                    break;
                case T_WITH:
                    enterOuterAlt(_localctx, 2); {
                    setState(1047);
                    match(T_WITH);
                    setState(1048);
                    _la = _input.LA(1);
                    if (!(_la == T_CS || _la == T_RR || _la == T_RS || _la == T_UR)) {
                        _errHandler.recoverInline(this);
                    } else {
                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                        _errHandler.reportMatch(this);
                        consume();
                    }
                    setState(1054);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_USE) {
                        {
                            setState(1049);
                            match(T_USE);
                            setState(1050);
                            match(T_AND);
                            setState(1051);
                            match(T_KEEP);
                            setState(1052);
                            _la = _input.LA(1);
                            if (!(_la == T_EXCLUSIVE || _la == T_UPDATE)) {
                                _errHandler.recoverInline(this);
                            } else {
                                if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                _errHandler.reportMatch(this);
                                consume();
                            }
                            setState(1053);
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
        enterRule(_localctx, 148, RULE_updateStmt);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1058);
                match(T_UPDATE);
                setState(1059);
                updateTable();
                setState(1060);
                match(T_SET);
                setState(1061);
                updateAssignment();
                setState(1063);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_WHERE) {
                    {
                        setState(1062);
                        whereClause();
                    }
                }

                setState(1066);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_ELSE) {
                    {
                        setState(1065);
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
        enterRule(_localctx, 150, RULE_updateAssignment);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1068);
                assignmentStmtItem();
                setState(1073);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T_COMMA) {
                    {
                        {
                            setState(1069);
                            match(T_COMMA);
                            setState(1070);
                            assignmentStmtItem();
                        }
                    }
                    setState(1075);
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
        enterRule(_localctx, 152, RULE_updateTable);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1084);
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
                        setState(1076);
                        tableName();
                        setState(1078);
                        _errHandler.sync(this);
                        switch (getInterpreter().adaptivePredict(_input, 130, _ctx)) {
                            case 1: {
                                setState(1077);
                                fromClause();
                            }
                                break;
                        }
                    }
                        break;
                    case T_OPEN_P: {
                        setState(1080);
                        match(T_OPEN_P);
                        setState(1081);
                        selectStmt();
                        setState(1082);
                        match(T_CLOSE_P);
                    }
                        break;
                    default:
                        throw new NoViableAltException(this);
                }
                setState(1090);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 133, _ctx)) {
                    case 1: {
                        setState(1087);
                        _errHandler.sync(this);
                        switch (getInterpreter().adaptivePredict(_input, 132, _ctx)) {
                            case 1: {
                                setState(1086);
                                match(T_AS);
                            }
                                break;
                        }
                        setState(1089);
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
        enterRule(_localctx, 154, RULE_updateUpsert);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1092);
                match(T_ELSE);
                setState(1093);
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
        enterRule(_localctx, 156, RULE_deleteStmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1095);
                match(T_DELETE);
                setState(1097);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 134, _ctx)) {
                    case 1: {
                        setState(1096);
                        match(T_FROM);
                    }
                        break;
                }
                setState(1099);
                tableName();
                setState(1101);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 135, _ctx)) {
                    case 1: {
                        setState(1100);
                        deleteAlias();
                    }
                        break;
                }
                setState(1105);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case T_WHERE: {
                        setState(1103);
                        whereClause();
                    }
                        break;
                    case T_ALL: {
                        setState(1104);
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
        enterRule(_localctx, 158, RULE_deleteAlias);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1107);
                if (!(!_input.LT(1).getText().equalsIgnoreCase("ALL")))
                    throw new FailedPredicateException(
                        this,
                        "!_input.LT(1).getText().equalsIgnoreCase(\"ALL\")"
                    );
                setState(1109);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 137, _ctx)) {
                    case 1: {
                        setState(1108);
                        match(T_AS);
                    }
                        break;
                }
                setState(1111);
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
        enterRule(_localctx, 160, RULE_describeStmt);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1113);
                _la = _input.LA(1);
                if (!(_la == T_DESC || _la == T_DESCRIBE)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
                setState(1115);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_TABLE || _la == T_VIEW) {
                    {
                        setState(1114);
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

                setState(1117);
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
        int _startState = 162;
        enterRecursionRule(_localctx, 162, RULE_boolExpr, _p);
        int _la;
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(1128);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 140, _ctx)) {
                    case 1: {
                        setState(1121);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        if (_la == T_NOT) {
                            {
                                setState(1120);
                                match(T_NOT);
                            }
                        }

                        setState(1123);
                        match(T_OPEN_P);
                        setState(1124);
                        boolExpr(0);
                        setState(1125);
                        match(T_CLOSE_P);
                    }
                        break;
                    case 2: {
                        setState(1127);
                        boolExprAtom();
                    }
                        break;
                }
                _ctx.stop = _input.LT(-1);
                setState(1136);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 141, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        if (_parseListeners != null) triggerExitRuleEvent();
                        _prevctx = _localctx;
                        {
                            {
                                _localctx = new BoolExprContext(_parentctx, _parentState);
                                pushNewRecursionContext(_localctx, _startState, RULE_boolExpr);
                                setState(1130);
                                if (!(precpred(_ctx, 2))) throw new FailedPredicateException(
                                    this,
                                    "precpred(_ctx, 2)"
                                );
                                setState(1131);
                                boolExprLogicalOperator();
                                setState(1132);
                                boolExpr(3);
                            }
                        }
                    }
                    setState(1138);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 141, _ctx);
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
        enterRule(_localctx, 164, RULE_boolExprAtom);
        try {
            setState(1142);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 142, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1); {
                    setState(1139);
                    boolExprUnary();
                }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2); {
                    setState(1140);
                    boolExprBinary();
                }
                    break;
                case 3:
                    enterOuterAlt(_localctx, 3); {
                    setState(1141);
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
        enterRule(_localctx, 166, RULE_boolExprUnary);
        int _la;
        try {
            setState(1167);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 145, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1); {
                    setState(1144);
                    expr(0);
                    setState(1145);
                    match(T_IS);
                    setState(1147);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_NOT) {
                        {
                            setState(1146);
                            match(T_NOT);
                        }
                    }

                    setState(1149);
                    match(T_NULL);
                }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2); {
                    setState(1151);
                    expr(0);
                    setState(1152);
                    match(T_BETWEEN);
                    setState(1153);
                    expr(0);
                    setState(1154);
                    match(T_AND);
                    setState(1155);
                    expr(0);
                }
                    break;
                case 3:
                    enterOuterAlt(_localctx, 3); {
                    setState(1158);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_NOT) {
                        {
                            setState(1157);
                            match(T_NOT);
                        }
                    }

                    setState(1160);
                    match(T_EXISTS);
                    setState(1161);
                    match(T_OPEN_P);
                    setState(1162);
                    selectStmt();
                    setState(1163);
                    match(T_CLOSE_P);
                }
                    break;
                case 4:
                    enterOuterAlt(_localctx, 4); {
                    setState(1165);
                    boolExprSingleIn();
                }
                    break;
                case 5:
                    enterOuterAlt(_localctx, 5); {
                    setState(1166);
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
        enterRule(_localctx, 168, RULE_boolExprSingleIn);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1169);
                expr(0);
                setState(1171);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_NOT) {
                    {
                        setState(1170);
                        match(T_NOT);
                    }
                }

                setState(1173);
                match(T_IN);
                setState(1174);
                match(T_OPEN_P);
                setState(1184);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 148, _ctx)) {
                    case 1: {
                        {
                            setState(1175);
                            expr(0);
                            setState(1180);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                            while (_la == T_COMMA) {
                                {
                                    {
                                        setState(1176);
                                        match(T_COMMA);
                                        setState(1177);
                                        expr(0);
                                    }
                                }
                                setState(1182);
                                _errHandler.sync(this);
                                _la = _input.LA(1);
                            }
                        }
                    }
                        break;
                    case 2: {
                        setState(1183);
                        selectStmt();
                    }
                        break;
                }
                setState(1186);
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
        enterRule(_localctx, 170, RULE_boolExprMultiIn);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1188);
                match(T_OPEN_P);
                setState(1189);
                expr(0);
                setState(1194);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T_COMMA) {
                    {
                        {
                            setState(1190);
                            match(T_COMMA);
                            setState(1191);
                            expr(0);
                        }
                    }
                    setState(1196);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(1197);
                match(T_CLOSE_P);
                setState(1199);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_NOT) {
                    {
                        setState(1198);
                        match(T_NOT);
                    }
                }

                setState(1201);
                match(T_IN);
                setState(1202);
                match(T_OPEN_P);
                setState(1203);
                selectStmt();
                setState(1204);
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
        enterRule(_localctx, 172, RULE_boolExprBinary);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1206);
                expr(0);
                setState(1207);
                boolExprBinaryOperator();
                setState(1208);
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
        enterRule(_localctx, 174, RULE_boolExprLogicalOperator);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1210);
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
        enterRule(_localctx, 176, RULE_boolExprBinaryOperator);
        int _la;
        try {
            setState(1224);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T_EQUAL:
                    enterOuterAlt(_localctx, 1); {
                    setState(1212);
                    match(T_EQUAL);
                }
                    break;
                case T_EQUAL2:
                    enterOuterAlt(_localctx, 2); {
                    setState(1213);
                    match(T_EQUAL2);
                }
                    break;
                case T_NOTEQUAL:
                    enterOuterAlt(_localctx, 3); {
                    setState(1214);
                    match(T_NOTEQUAL);
                }
                    break;
                case T_NOTEQUAL2:
                    enterOuterAlt(_localctx, 4); {
                    setState(1215);
                    match(T_NOTEQUAL2);
                }
                    break;
                case T_LESS:
                    enterOuterAlt(_localctx, 5); {
                    setState(1216);
                    match(T_LESS);
                }
                    break;
                case T_LESSEQUAL:
                    enterOuterAlt(_localctx, 6); {
                    setState(1217);
                    match(T_LESSEQUAL);
                }
                    break;
                case T_GREATER:
                    enterOuterAlt(_localctx, 7); {
                    setState(1218);
                    match(T_GREATER);
                }
                    break;
                case T_GREATEREQUAL:
                    enterOuterAlt(_localctx, 8); {
                    setState(1219);
                    match(T_GREATEREQUAL);
                }
                    break;
                case T_LIKE:
                case T_NOT:
                case T_REGEXP:
                case T_RLIKE:
                    enterOuterAlt(_localctx, 9); {
                    setState(1221);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_NOT) {
                        {
                            setState(1220);
                            match(T_NOT);
                        }
                    }

                    setState(1223);
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
        int _startState = 178;
        enterRecursionRule(_localctx, 178, RULE_expr, _p);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(1243);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 153, _ctx)) {
                    case 1: {
                        setState(1227);
                        match(T_OPEN_P);
                        setState(1228);
                        selectStmt();
                        setState(1229);
                        match(T_CLOSE_P);
                    }
                        break;
                    case 2: {
                        setState(1231);
                        match(T_OPEN_P);
                        setState(1232);
                        expr(0);
                        setState(1233);
                        match(T_CLOSE_P);
                    }
                        break;
                    case 3: {
                        setState(1235);
                        exprInterval();
                    }
                        break;
                    case 4: {
                        setState(1236);
                        exprConcat();
                    }
                        break;
                    case 5: {
                        setState(1237);
                        exprCase();
                    }
                        break;
                    case 6: {
                        setState(1238);
                        exprCursorAttribute();
                    }
                        break;
                    case 7: {
                        setState(1239);
                        exprAggWindowFunc();
                    }
                        break;
                    case 8: {
                        setState(1240);
                        exprSpecFunc();
                    }
                        break;
                    case 9: {
                        setState(1241);
                        exprFunc();
                    }
                        break;
                    case 10: {
                        setState(1242);
                        exprAtom();
                    }
                        break;
                }
                _ctx.stop = _input.LT(-1);
                setState(1261);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 155, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        if (_parseListeners != null) triggerExitRuleEvent();
                        _prevctx = _localctx;
                        {
                            setState(1259);
                            _errHandler.sync(this);
                            switch (getInterpreter().adaptivePredict(_input, 154, _ctx)) {
                                case 1: {
                                    _localctx = new ExprContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr);
                                    setState(1245);
                                    if (!(precpred(_ctx, 14))) throw new FailedPredicateException(
                                        this,
                                        "precpred(_ctx, 14)"
                                    );
                                    setState(1246);
                                    match(T_MUL);
                                    setState(1247);
                                    expr(15);
                                }
                                    break;
                                case 2: {
                                    _localctx = new ExprContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr);
                                    setState(1248);
                                    if (!(precpred(_ctx, 13))) throw new FailedPredicateException(
                                        this,
                                        "precpred(_ctx, 13)"
                                    );
                                    setState(1249);
                                    match(T_DIV);
                                    setState(1250);
                                    expr(14);
                                }
                                    break;
                                case 3: {
                                    _localctx = new ExprContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr);
                                    setState(1251);
                                    if (!(precpred(_ctx, 12))) throw new FailedPredicateException(
                                        this,
                                        "precpred(_ctx, 12)"
                                    );
                                    setState(1252);
                                    match(T_ADD);
                                    setState(1253);
                                    expr(13);
                                }
                                    break;
                                case 4: {
                                    _localctx = new ExprContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr);
                                    setState(1254);
                                    if (!(precpred(_ctx, 11))) throw new FailedPredicateException(
                                        this,
                                        "precpred(_ctx, 11)"
                                    );
                                    setState(1255);
                                    match(T_SUB);
                                    setState(1256);
                                    expr(12);
                                }
                                    break;
                                case 5: {
                                    _localctx = new ExprContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr);
                                    setState(1257);
                                    if (!(precpred(_ctx, 15))) throw new FailedPredicateException(
                                        this,
                                        "precpred(_ctx, 15)"
                                    );
                                    setState(1258);
                                    intervalItem();
                                }
                                    break;
                            }
                        }
                    }
                    setState(1263);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 155, _ctx);
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
        enterRule(_localctx, 180, RULE_exprAtom);
        try {
            setState(1272);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 156, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1); {
                    setState(1264);
                    dateLiteral();
                }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2); {
                    setState(1265);
                    timestampLiteral();
                }
                    break;
                case 3:
                    enterOuterAlt(_localctx, 3); {
                    setState(1266);
                    boolLiteral();
                }
                    break;
                case 4:
                    enterOuterAlt(_localctx, 4); {
                    setState(1267);
                    ident();
                }
                    break;
                case 5:
                    enterOuterAlt(_localctx, 5); {
                    setState(1268);
                    string();
                }
                    break;
                case 6:
                    enterOuterAlt(_localctx, 6); {
                    setState(1269);
                    decNumber();
                }
                    break;
                case 7:
                    enterOuterAlt(_localctx, 7); {
                    setState(1270);
                    intNumber();
                }
                    break;
                case 8:
                    enterOuterAlt(_localctx, 8); {
                    setState(1271);
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
        enterRule(_localctx, 182, RULE_exprInterval);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1274);
                match(T_INTERVAL);
                setState(1275);
                expr(0);
                setState(1276);
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
        enterRule(_localctx, 184, RULE_intervalItem);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1278);
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
        enterRule(_localctx, 186, RULE_exprConcat);
        int _la;
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(1280);
                exprConcatItem();
                setState(1281);
                _la = _input.LA(1);
                if (!(_la == T_CONCAT || _la == T_PIPE)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
                setState(1282);
                exprConcatItem();
                setState(1287);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 157, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            {
                                setState(1283);
                                _la = _input.LA(1);
                                if (!(_la == T_CONCAT || _la == T_PIPE)) {
                                    _errHandler.recoverInline(this);
                                } else {
                                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                    _errHandler.reportMatch(this);
                                    consume();
                                }
                                setState(1284);
                                exprConcatItem();
                            }
                        }
                    }
                    setState(1289);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 157, _ctx);
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
        enterRule(_localctx, 188, RULE_exprConcatItem);
        try {
            setState(1299);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 158, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1); {
                    setState(1290);
                    match(T_OPEN_P);
                    setState(1291);
                    expr(0);
                    setState(1292);
                    match(T_CLOSE_P);
                }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2); {
                    setState(1294);
                    exprCase();
                }
                    break;
                case 3:
                    enterOuterAlt(_localctx, 3); {
                    setState(1295);
                    exprAggWindowFunc();
                }
                    break;
                case 4:
                    enterOuterAlt(_localctx, 4); {
                    setState(1296);
                    exprSpecFunc();
                }
                    break;
                case 5:
                    enterOuterAlt(_localctx, 5); {
                    setState(1297);
                    exprFunc();
                }
                    break;
                case 6:
                    enterOuterAlt(_localctx, 6); {
                    setState(1298);
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
        enterRule(_localctx, 190, RULE_exprCase);
        try {
            setState(1303);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 159, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1); {
                    setState(1301);
                    exprCaseSimple();
                }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2); {
                    setState(1302);
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
        enterRule(_localctx, 192, RULE_exprCaseSimple);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1305);
                match(T_CASE);
                setState(1306);
                expr(0);
                setState(1312);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        {
                            setState(1307);
                            match(T_WHEN);
                            setState(1308);
                            expr(0);
                            setState(1309);
                            match(T_THEN);
                            setState(1310);
                            expr(0);
                        }
                    }
                    setState(1314);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                } while (_la == T_WHEN);
                setState(1318);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_ELSE) {
                    {
                        setState(1316);
                        match(T_ELSE);
                        setState(1317);
                        expr(0);
                    }
                }

                setState(1320);
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
        enterRule(_localctx, 194, RULE_exprCaseSearched);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1322);
                match(T_CASE);
                setState(1324);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        {
                            setState(1323);
                            exprCaseItem();
                        }
                    }
                    setState(1326);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                } while (_la == T_WHEN);
                setState(1330);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_ELSE) {
                    {
                        setState(1328);
                        match(T_ELSE);
                        setState(1329);
                        boolExpr(0);
                    }
                }

                setState(1332);
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
        enterRule(_localctx, 196, RULE_exprCaseItem);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1334);
                match(T_WHEN);
                setState(1335);
                ((ExprCaseItemContext) _localctx).whenExpr = boolExpr(0);
                setState(1336);
                match(T_THEN);
                setState(1337);
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
        enterRule(_localctx, 198, RULE_exprCursorAttribute);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1339);
                ident();
                setState(1340);
                match(T__0);
                setState(1341);
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
        enterRule(_localctx, 200, RULE_exprAggWindowFunc);
        int _la;
        try {
            setState(1495);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T_AVG:
                    enterOuterAlt(_localctx, 1); {
                    setState(1343);
                    match(T_AVG);
                    setState(1344);
                    match(T_OPEN_P);
                    setState(1346);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 164, _ctx)) {
                        case 1: {
                            setState(1345);
                            exprFuncAllDistinct();
                        }
                            break;
                    }
                    setState(1348);
                    expr(0);
                    setState(1349);
                    match(T_CLOSE_P);
                    setState(1351);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 165, _ctx)) {
                        case 1: {
                            setState(1350);
                            exprFuncOverClause();
                        }
                            break;
                    }
                }
                    break;
                case T_COUNT:
                    enterOuterAlt(_localctx, 2); {
                    setState(1353);
                    match(T_COUNT);
                    setState(1354);
                    match(T_OPEN_P);
                    setState(1360);
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
                                setState(1356);
                                _errHandler.sync(this);
                                switch (getInterpreter().adaptivePredict(_input, 166, _ctx)) {
                                    case 1: {
                                        setState(1355);
                                        exprFuncAllDistinct();
                                    }
                                        break;
                                }
                                setState(1358);
                                expr(0);
                            }
                        }
                            break;
                        case T_MUL: {
                            setState(1359);
                            match(T_MUL);
                        }
                            break;
                        default:
                            throw new NoViableAltException(this);
                    }
                    setState(1362);
                    match(T_CLOSE_P);
                    setState(1364);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 168, _ctx)) {
                        case 1: {
                            setState(1363);
                            exprFuncOverClause();
                        }
                            break;
                    }
                }
                    break;
                case T_COUNT_BIG:
                    enterOuterAlt(_localctx, 3); {
                    setState(1366);
                    match(T_COUNT_BIG);
                    setState(1367);
                    match(T_OPEN_P);
                    setState(1373);
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
                                setState(1369);
                                _errHandler.sync(this);
                                switch (getInterpreter().adaptivePredict(_input, 169, _ctx)) {
                                    case 1: {
                                        setState(1368);
                                        exprFuncAllDistinct();
                                    }
                                        break;
                                }
                                setState(1371);
                                expr(0);
                            }
                        }
                            break;
                        case T_MUL: {
                            setState(1372);
                            match(T_MUL);
                        }
                            break;
                        default:
                            throw new NoViableAltException(this);
                    }
                    setState(1375);
                    match(T_CLOSE_P);
                    setState(1377);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 171, _ctx)) {
                        case 1: {
                            setState(1376);
                            exprFuncOverClause();
                        }
                            break;
                    }
                }
                    break;
                case T_CUME_DIST:
                    enterOuterAlt(_localctx, 4); {
                    setState(1379);
                    match(T_CUME_DIST);
                    setState(1380);
                    match(T_OPEN_P);
                    setState(1381);
                    match(T_CLOSE_P);
                    setState(1382);
                    exprFuncOverClause();
                }
                    break;
                case T_DENSE_RANK:
                    enterOuterAlt(_localctx, 5); {
                    setState(1383);
                    match(T_DENSE_RANK);
                    setState(1384);
                    match(T_OPEN_P);
                    setState(1385);
                    match(T_CLOSE_P);
                    setState(1386);
                    exprFuncOverClause();
                }
                    break;
                case T_FIRST_VALUE:
                    enterOuterAlt(_localctx, 6); {
                    setState(1387);
                    match(T_FIRST_VALUE);
                    setState(1388);
                    match(T_OPEN_P);
                    setState(1389);
                    expr(0);
                    setState(1390);
                    match(T_CLOSE_P);
                    setState(1391);
                    exprFuncOverClause();
                }
                    break;
                case T_LAG:
                    enterOuterAlt(_localctx, 7); {
                    setState(1393);
                    match(T_LAG);
                    setState(1394);
                    match(T_OPEN_P);
                    setState(1395);
                    expr(0);
                    setState(1402);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_COMMA) {
                        {
                            setState(1396);
                            match(T_COMMA);
                            setState(1397);
                            expr(0);
                            setState(1400);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                            if (_la == T_COMMA) {
                                {
                                    setState(1398);
                                    match(T_COMMA);
                                    setState(1399);
                                    expr(0);
                                }
                            }

                        }
                    }

                    setState(1404);
                    match(T_CLOSE_P);
                    setState(1405);
                    exprFuncOverClause();
                }
                    break;
                case T_LAST_VALUE:
                    enterOuterAlt(_localctx, 8); {
                    setState(1407);
                    match(T_LAST_VALUE);
                    setState(1408);
                    match(T_OPEN_P);
                    setState(1409);
                    expr(0);
                    setState(1410);
                    match(T_CLOSE_P);
                    setState(1411);
                    exprFuncOverClause();
                }
                    break;
                case T_LEAD:
                    enterOuterAlt(_localctx, 9); {
                    setState(1413);
                    match(T_LEAD);
                    setState(1414);
                    match(T_OPEN_P);
                    setState(1415);
                    expr(0);
                    setState(1422);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_COMMA) {
                        {
                            setState(1416);
                            match(T_COMMA);
                            setState(1417);
                            expr(0);
                            setState(1420);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                            if (_la == T_COMMA) {
                                {
                                    setState(1418);
                                    match(T_COMMA);
                                    setState(1419);
                                    expr(0);
                                }
                            }

                        }
                    }

                    setState(1424);
                    match(T_CLOSE_P);
                    setState(1425);
                    exprFuncOverClause();
                }
                    break;
                case T_MAX:
                    enterOuterAlt(_localctx, 10); {
                    setState(1427);
                    match(T_MAX);
                    setState(1428);
                    match(T_OPEN_P);
                    setState(1430);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 176, _ctx)) {
                        case 1: {
                            setState(1429);
                            exprFuncAllDistinct();
                        }
                            break;
                    }
                    setState(1432);
                    expr(0);
                    setState(1433);
                    match(T_CLOSE_P);
                    setState(1435);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 177, _ctx)) {
                        case 1: {
                            setState(1434);
                            exprFuncOverClause();
                        }
                            break;
                    }
                }
                    break;
                case T_MIN:
                    enterOuterAlt(_localctx, 11); {
                    setState(1437);
                    match(T_MIN);
                    setState(1438);
                    match(T_OPEN_P);
                    setState(1440);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 178, _ctx)) {
                        case 1: {
                            setState(1439);
                            exprFuncAllDistinct();
                        }
                            break;
                    }
                    setState(1442);
                    expr(0);
                    setState(1443);
                    match(T_CLOSE_P);
                    setState(1445);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 179, _ctx)) {
                        case 1: {
                            setState(1444);
                            exprFuncOverClause();
                        }
                            break;
                    }
                }
                    break;
                case T_RANK:
                    enterOuterAlt(_localctx, 12); {
                    setState(1447);
                    match(T_RANK);
                    setState(1448);
                    match(T_OPEN_P);
                    setState(1449);
                    match(T_CLOSE_P);
                    setState(1450);
                    exprFuncOverClause();
                }
                    break;
                case T_ROW_NUMBER:
                    enterOuterAlt(_localctx, 13); {
                    setState(1451);
                    match(T_ROW_NUMBER);
                    setState(1452);
                    match(T_OPEN_P);
                    setState(1453);
                    match(T_CLOSE_P);
                    setState(1454);
                    exprFuncOverClause();
                }
                    break;
                case T_STDEV:
                    enterOuterAlt(_localctx, 14); {
                    setState(1455);
                    match(T_STDEV);
                    setState(1456);
                    match(T_OPEN_P);
                    setState(1458);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 180, _ctx)) {
                        case 1: {
                            setState(1457);
                            exprFuncAllDistinct();
                        }
                            break;
                    }
                    setState(1460);
                    expr(0);
                    setState(1461);
                    match(T_CLOSE_P);
                    setState(1463);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 181, _ctx)) {
                        case 1: {
                            setState(1462);
                            exprFuncOverClause();
                        }
                            break;
                    }
                }
                    break;
                case T_SUM:
                    enterOuterAlt(_localctx, 15); {
                    setState(1465);
                    match(T_SUM);
                    setState(1466);
                    match(T_OPEN_P);
                    setState(1468);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 182, _ctx)) {
                        case 1: {
                            setState(1467);
                            exprFuncAllDistinct();
                        }
                            break;
                    }
                    setState(1470);
                    expr(0);
                    setState(1471);
                    match(T_CLOSE_P);
                    setState(1473);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 183, _ctx)) {
                        case 1: {
                            setState(1472);
                            exprFuncOverClause();
                        }
                            break;
                    }
                }
                    break;
                case T_VAR:
                    enterOuterAlt(_localctx, 16); {
                    setState(1475);
                    match(T_VAR);
                    setState(1476);
                    match(T_OPEN_P);
                    setState(1478);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 184, _ctx)) {
                        case 1: {
                            setState(1477);
                            exprFuncAllDistinct();
                        }
                            break;
                    }
                    setState(1480);
                    expr(0);
                    setState(1481);
                    match(T_CLOSE_P);
                    setState(1483);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 185, _ctx)) {
                        case 1: {
                            setState(1482);
                            exprFuncOverClause();
                        }
                            break;
                    }
                }
                    break;
                case T_VARIANCE:
                    enterOuterAlt(_localctx, 17); {
                    setState(1485);
                    match(T_VARIANCE);
                    setState(1486);
                    match(T_OPEN_P);
                    setState(1488);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 186, _ctx)) {
                        case 1: {
                            setState(1487);
                            exprFuncAllDistinct();
                        }
                            break;
                    }
                    setState(1490);
                    expr(0);
                    setState(1491);
                    match(T_CLOSE_P);
                    setState(1493);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 187, _ctx)) {
                        case 1: {
                            setState(1492);
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
        enterRule(_localctx, 202, RULE_exprFuncAllDistinct);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1497);
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
        enterRule(_localctx, 204, RULE_exprFuncOverClause);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1499);
                match(T_OVER);
                setState(1500);
                match(T_OPEN_P);
                setState(1502);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_PARTITION) {
                    {
                        setState(1501);
                        exprFuncPartitionByClause();
                    }
                }

                setState(1505);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_ORDER) {
                    {
                        setState(1504);
                        orderByClause();
                    }
                }

                setState(1507);
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
        enterRule(_localctx, 206, RULE_exprFuncPartitionByClause);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1509);
                match(T_PARTITION);
                setState(1510);
                match(T_BY);
                setState(1511);
                expr(0);
                setState(1516);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T_COMMA) {
                    {
                        {
                            setState(1512);
                            match(T_COMMA);
                            setState(1513);
                            expr(0);
                        }
                    }
                    setState(1518);
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
        enterRule(_localctx, 208, RULE_exprSpecFunc);
        int _la;
        try {
            int _alt;
            setState(1716);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 212, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1); {
                    setState(1519);
                    match(T_ACTIVITY_COUNT);
                }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2); {
                    setState(1520);
                    match(T_CAST);
                    setState(1521);
                    match(T_OPEN_P);
                    setState(1522);
                    expr(0);
                    setState(1523);
                    match(T_AS);
                    setState(1524);
                    dtype();
                    setState(1526);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_OPEN_P) {
                        {
                            setState(1525);
                            dtypeLen();
                        }
                    }

                    setState(1528);
                    match(T_CLOSE_P);
                }
                    break;
                case 3:
                    enterOuterAlt(_localctx, 3); {
                    setState(1530);
                    match(T_COUNT);
                    setState(1531);
                    match(T_OPEN_P);
                    setState(1534);
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
                            setState(1532);
                            expr(0);
                        }
                            break;
                        case T_MUL: {
                            setState(1533);
                            match(T_MUL);
                        }
                            break;
                        default:
                            throw new NoViableAltException(this);
                    }
                    setState(1536);
                    match(T_CLOSE_P);
                }
                    break;
                case 4:
                    enterOuterAlt(_localctx, 4); {
                    setState(1537);
                    match(T_CURRENT_DATE);
                }
                    break;
                case 5:
                    enterOuterAlt(_localctx, 5); {
                    setState(1538);
                    match(T_CURRENT);
                    setState(1539);
                    match(T_DATE);
                }
                    break;
                case 6:
                    enterOuterAlt(_localctx, 6); {
                    setState(1540);
                    match(T_CURRENT_TIME);
                }
                    break;
                case 7:
                    enterOuterAlt(_localctx, 7); {
                    setState(1541);
                    match(T_PI);
                }
                    break;
                case 8:
                    enterOuterAlt(_localctx, 8); {
                    setState(1545);
                    _errHandler.sync(this);
                    switch (_input.LA(1)) {
                        case T_CURRENT_TIMESTAMP: {
                            setState(1542);
                            match(T_CURRENT_TIMESTAMP);
                        }
                            break;
                        case T_CURRENT: {
                            setState(1543);
                            match(T_CURRENT);
                            setState(1544);
                            match(T_TIMESTAMP);
                        }
                            break;
                        default:
                            throw new NoViableAltException(this);
                    }
                    setState(1551);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 195, _ctx)) {
                        case 1: {
                            setState(1547);
                            match(T_OPEN_P);
                            setState(1548);
                            expr(0);
                            setState(1549);
                            match(T_CLOSE_P);
                        }
                            break;
                    }
                }
                    break;
                case 9:
                    enterOuterAlt(_localctx, 9); {
                    setState(1553);
                    match(T_CURRENT_USER);
                }
                    break;
                case 10:
                    enterOuterAlt(_localctx, 10); {
                    setState(1554);
                    match(T_CURRENT);
                    setState(1555);
                    match(T_USER);
                }
                    break;
                case 11:
                    enterOuterAlt(_localctx, 11); {
                    setState(1556);
                    match(T_MAX_PART_STRING);
                    setState(1557);
                    match(T_OPEN_P);
                    setState(1558);
                    expr(0);
                    setState(1571);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_COMMA) {
                        {
                            setState(1559);
                            match(T_COMMA);
                            setState(1560);
                            expr(0);
                            setState(1568);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                            while (_la == T_COMMA) {
                                {
                                    {
                                        setState(1561);
                                        match(T_COMMA);
                                        setState(1562);
                                        expr(0);
                                        setState(1563);
                                        match(T_EQUAL);
                                        setState(1564);
                                        expr(0);
                                    }
                                }
                                setState(1570);
                                _errHandler.sync(this);
                                _la = _input.LA(1);
                            }
                        }
                    }

                    setState(1573);
                    match(T_CLOSE_P);
                }
                    break;
                case 12:
                    enterOuterAlt(_localctx, 12); {
                    setState(1575);
                    match(T_MIN_PART_STRING);
                    setState(1576);
                    match(T_OPEN_P);
                    setState(1577);
                    expr(0);
                    setState(1590);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_COMMA) {
                        {
                            setState(1578);
                            match(T_COMMA);
                            setState(1579);
                            expr(0);
                            setState(1587);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                            while (_la == T_COMMA) {
                                {
                                    {
                                        setState(1580);
                                        match(T_COMMA);
                                        setState(1581);
                                        expr(0);
                                        setState(1582);
                                        match(T_EQUAL);
                                        setState(1583);
                                        expr(0);
                                    }
                                }
                                setState(1589);
                                _errHandler.sync(this);
                                _la = _input.LA(1);
                            }
                        }
                    }

                    setState(1592);
                    match(T_CLOSE_P);
                }
                    break;
                case 13:
                    enterOuterAlt(_localctx, 13); {
                    setState(1594);
                    match(T_MAX_PART_INT);
                    setState(1595);
                    match(T_OPEN_P);
                    setState(1596);
                    expr(0);
                    setState(1609);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_COMMA) {
                        {
                            setState(1597);
                            match(T_COMMA);
                            setState(1598);
                            expr(0);
                            setState(1606);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                            while (_la == T_COMMA) {
                                {
                                    {
                                        setState(1599);
                                        match(T_COMMA);
                                        setState(1600);
                                        expr(0);
                                        setState(1601);
                                        match(T_EQUAL);
                                        setState(1602);
                                        expr(0);
                                    }
                                }
                                setState(1608);
                                _errHandler.sync(this);
                                _la = _input.LA(1);
                            }
                        }
                    }

                    setState(1611);
                    match(T_CLOSE_P);
                }
                    break;
                case 14:
                    enterOuterAlt(_localctx, 14); {
                    setState(1613);
                    match(T_MIN_PART_INT);
                    setState(1614);
                    match(T_OPEN_P);
                    setState(1615);
                    expr(0);
                    setState(1628);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_COMMA) {
                        {
                            setState(1616);
                            match(T_COMMA);
                            setState(1617);
                            expr(0);
                            setState(1625);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                            while (_la == T_COMMA) {
                                {
                                    {
                                        setState(1618);
                                        match(T_COMMA);
                                        setState(1619);
                                        expr(0);
                                        setState(1620);
                                        match(T_EQUAL);
                                        setState(1621);
                                        expr(0);
                                    }
                                }
                                setState(1627);
                                _errHandler.sync(this);
                                _la = _input.LA(1);
                            }
                        }
                    }

                    setState(1630);
                    match(T_CLOSE_P);
                }
                    break;
                case 15:
                    enterOuterAlt(_localctx, 15); {
                    setState(1632);
                    match(T_MAX_PART_DATE);
                    setState(1633);
                    match(T_OPEN_P);
                    setState(1634);
                    expr(0);
                    setState(1647);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_COMMA) {
                        {
                            setState(1635);
                            match(T_COMMA);
                            setState(1636);
                            expr(0);
                            setState(1644);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                            while (_la == T_COMMA) {
                                {
                                    {
                                        setState(1637);
                                        match(T_COMMA);
                                        setState(1638);
                                        expr(0);
                                        setState(1639);
                                        match(T_EQUAL);
                                        setState(1640);
                                        expr(0);
                                    }
                                }
                                setState(1646);
                                _errHandler.sync(this);
                                _la = _input.LA(1);
                            }
                        }
                    }

                    setState(1649);
                    match(T_CLOSE_P);
                }
                    break;
                case 16:
                    enterOuterAlt(_localctx, 16); {
                    setState(1651);
                    match(T_MIN_PART_DATE);
                    setState(1652);
                    match(T_OPEN_P);
                    setState(1653);
                    expr(0);
                    setState(1666);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_COMMA) {
                        {
                            setState(1654);
                            match(T_COMMA);
                            setState(1655);
                            expr(0);
                            setState(1663);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                            while (_la == T_COMMA) {
                                {
                                    {
                                        setState(1656);
                                        match(T_COMMA);
                                        setState(1657);
                                        expr(0);
                                        setState(1658);
                                        match(T_EQUAL);
                                        setState(1659);
                                        expr(0);
                                    }
                                }
                                setState(1665);
                                _errHandler.sync(this);
                                _la = _input.LA(1);
                            }
                        }
                    }

                    setState(1668);
                    match(T_CLOSE_P);
                }
                    break;
                case 17:
                    enterOuterAlt(_localctx, 17); {
                    setState(1670);
                    match(T_PART_COUNT);
                    setState(1671);
                    match(T_OPEN_P);
                    setState(1672);
                    expr(0);
                    setState(1680);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == T_COMMA) {
                        {
                            {
                                setState(1673);
                                match(T_COMMA);
                                setState(1674);
                                expr(0);
                                setState(1675);
                                match(T_EQUAL);
                                setState(1676);
                                expr(0);
                            }
                        }
                        setState(1682);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                    setState(1683);
                    match(T_CLOSE_P);
                }
                    break;
                case 18:
                    enterOuterAlt(_localctx, 18); {
                    setState(1685);
                    match(T_PART_LOC);
                    setState(1686);
                    match(T_OPEN_P);
                    setState(1687);
                    expr(0);
                    setState(1693);
                    _errHandler.sync(this);
                    _alt = 1;
                    do {
                        switch (_alt) {
                            case 1: {
                                {
                                    setState(1688);
                                    match(T_COMMA);
                                    setState(1689);
                                    expr(0);
                                    setState(1690);
                                    match(T_EQUAL);
                                    setState(1691);
                                    expr(0);
                                }
                            }
                                break;
                            default:
                                throw new NoViableAltException(this);
                        }
                        setState(1695);
                        _errHandler.sync(this);
                        _alt = getInterpreter().adaptivePredict(_input, 209, _ctx);
                    } while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER);
                    setState(1699);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_COMMA) {
                        {
                            setState(1697);
                            match(T_COMMA);
                            setState(1698);
                            expr(0);
                        }
                    }

                    setState(1701);
                    match(T_CLOSE_P);
                }
                    break;
                case 19:
                    enterOuterAlt(_localctx, 19); {
                    setState(1703);
                    match(T_SUBSTRING);
                    setState(1704);
                    match(T_OPEN_P);
                    setState(1705);
                    expr(0);
                    setState(1706);
                    match(T_FROM);
                    setState(1707);
                    expr(0);
                    setState(1710);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T_FOR) {
                        {
                            setState(1708);
                            match(T_FOR);
                            setState(1709);
                            expr(0);
                        }
                    }

                    setState(1712);
                    match(T_CLOSE_P);
                }
                    break;
                case 20:
                    enterOuterAlt(_localctx, 20); {
                    setState(1714);
                    match(T_SYSDATE);
                }
                    break;
                case 21:
                    enterOuterAlt(_localctx, 21); {
                    setState(1715);
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
        enterRule(_localctx, 210, RULE_exprFunc);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1718);
                ident();
                setState(1719);
                match(T_OPEN_P);
                setState(1721);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 213, _ctx)) {
                    case 1: {
                        setState(1720);
                        exprFuncParams();
                    }
                        break;
                }
                setState(1723);
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
        enterRule(_localctx, 212, RULE_exprFuncParams);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1725);
                funcParam();
                setState(1730);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T_COMMA) {
                    {
                        {
                            setState(1726);
                            match(T_COMMA);
                            setState(1727);
                            funcParam();
                        }
                    }
                    setState(1732);
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
        enterRule(_localctx, 214, RULE_funcParam);
        int _la;
        try {
            setState(1744);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 217, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1); {}
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2); {
                    setState(1734);
                    if (!(!_input.LT(1).getText().equalsIgnoreCase("INTO")))
                        throw new FailedPredicateException(
                            this,
                            "!_input.LT(1).getText().equalsIgnoreCase(\"INTO\")"
                        );
                    setState(1740);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 216, _ctx)) {
                        case 1: {
                            setState(1735);
                            ident();
                            setState(1736);
                            match(T_EQUAL);
                            setState(1738);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                            if (_la == T_GREATER) {
                                {
                                    setState(1737);
                                    match(T_GREATER);
                                }
                            }

                        }
                            break;
                    }
                    setState(1742);
                    expr(0);
                }
                    break;
                case 3:
                    enterOuterAlt(_localctx, 3); {
                    setState(1743);
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
        enterRule(_localctx, 216, RULE_table_name);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1746);
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
        enterRule(_localctx, 218, RULE_qident);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1748);
                ident();
                setState(1753);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T_DOT) {
                    {
                        {
                            setState(1749);
                            match(T_DOT);
                            setState(1750);
                            ident();
                        }
                    }
                    setState(1755);
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
        enterRule(_localctx, 220, RULE_dateLiteral);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1756);
                match(T_DATE);
                setState(1757);
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
        enterRule(_localctx, 222, RULE_timestampLiteral);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1759);
                match(T_TIMESTAMP);
                setState(1760);
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
        enterRule(_localctx, 224, RULE_ident);
        int _la;
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(1763);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_SUB) {
                    {
                        setState(1762);
                        match(T_SUB);
                    }
                }

                setState(1765);
                identItem();
                setState(1770);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 220, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            {
                                setState(1766);
                                match(T_DOT);
                                setState(1767);
                                identItem();
                            }
                        }
                    }
                    setState(1772);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 220, _ctx);
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
        enterRule(_localctx, 226, RULE_identItem);
        try {
            setState(1775);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case L_ID:
                    enterOuterAlt(_localctx, 1); {
                    setState(1773);
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
                    setState(1774);
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
        enterRule(_localctx, 228, RULE_string);
        try {
            setState(1779);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case L_S_STRING:
                    _localctx = new SingleQuotedStringContext(_localctx);
                    enterOuterAlt(_localctx, 1); {
                    setState(1777);
                    match(L_S_STRING);
                }
                    break;
                case L_D_STRING:
                    _localctx = new DoubleQuotedStringContext(_localctx);
                    enterOuterAlt(_localctx, 2); {
                    setState(1778);
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
        enterRule(_localctx, 230, RULE_intNumber);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1782);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_ADD || _la == T_SUB) {
                    {
                        setState(1781);
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

                setState(1784);
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
        enterRule(_localctx, 232, RULE_decNumber);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1787);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T_ADD || _la == T_SUB) {
                    {
                        setState(1786);
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

                setState(1789);
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
        enterRule(_localctx, 234, RULE_boolLiteral);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1791);
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
        enterRule(_localctx, 236, RULE_nullConst);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1793);
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
        enterRule(_localctx, 238, RULE_nonReservedWords);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1795);
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
            case 63:
                return fromAliasClause_sempred((FromAliasClauseContext) _localctx, predIndex);
            case 79:
                return deleteAlias_sempred((DeleteAliasContext) _localctx, predIndex);
            case 81:
                return boolExpr_sempred((BoolExprContext) _localctx, predIndex);
            case 89:
                return expr_sempred((ExprContext) _localctx, predIndex);
            case 107:
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
        "\u0004\u0001\u01a0\u0706\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"
            + "\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"
            + "\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"
            + "\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"
            + "\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"
            + "\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"
            + "\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007"
            + "\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007"
            + "\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007"
            + "\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007"
            + "\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007"
            + "\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007"
            + "\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007"
            + ",\u0002-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u0007"
            + "1\u00022\u00072\u00023\u00073\u00024\u00074\u00025\u00075\u00026\u0007"
            + "6\u00027\u00077\u00028\u00078\u00029\u00079\u0002:\u0007:\u0002;\u0007"
            + ";\u0002<\u0007<\u0002=\u0007=\u0002>\u0007>\u0002?\u0007?\u0002@\u0007"
            + "@\u0002A\u0007A\u0002B\u0007B\u0002C\u0007C\u0002D\u0007D\u0002E\u0007"
            + "E\u0002F\u0007F\u0002G\u0007G\u0002H\u0007H\u0002I\u0007I\u0002J\u0007"
            + "J\u0002K\u0007K\u0002L\u0007L\u0002M\u0007M\u0002N\u0007N\u0002O\u0007"
            + "O\u0002P\u0007P\u0002Q\u0007Q\u0002R\u0007R\u0002S\u0007S\u0002T\u0007"
            + "T\u0002U\u0007U\u0002V\u0007V\u0002W\u0007W\u0002X\u0007X\u0002Y\u0007"
            + "Y\u0002Z\u0007Z\u0002[\u0007[\u0002\\\u0007\\\u0002]\u0007]\u0002^\u0007"
            + "^\u0002_\u0007_\u0002`\u0007`\u0002a\u0007a\u0002b\u0007b\u0002c\u0007"
            + "c\u0002d\u0007d\u0002e\u0007e\u0002f\u0007f\u0002g\u0007g\u0002h\u0007"
            + "h\u0002i\u0007i\u0002j\u0007j\u0002k\u0007k\u0002l\u0007l\u0002m\u0007"
            + "m\u0002n\u0007n\u0002o\u0007o\u0002p\u0007p\u0002q\u0007q\u0002r\u0007"
            + "r\u0002s\u0007s\u0002t\u0007t\u0002u\u0007u\u0002v\u0007v\u0002w\u0007"
            + "w\u0001\u0000\u0001\u0000\u0003\u0000\u00f3\b\u0000\u0001\u0000\u0001"
            + "\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"
            + "\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"
            + "\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001\u0106\b\u0001\u0001"
            + "\u0002\u0001\u0002\u0003\u0002\u010a\b\u0002\u0001\u0002\u0001\u0002\u0001"
            + "\u0003\u0001\u0003\u0001\u0003\u0003\u0003\u0111\b\u0003\u0001\u0003\u0003"
            + "\u0003\u0114\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u0119"
            + "\b\u0004\u0001\u0005\u0001\u0005\u0003\u0005\u011d\b\u0005\u0001\u0005"
            + "\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"
            + "\u0003\u0005\u0126\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005"
            + "\u012b\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006"
            + "\u0131\b\u0006\n\u0006\f\u0006\u0134\t\u0006\u0001\u0006\u0001\u0006\u0003"
            + "\u0006\u0138\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"
            + "\u0006\u0005\u0006\u013f\b\u0006\n\u0006\f\u0006\u0142\t\u0006\u0001\u0006"
            + "\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"
            + "\u0005\u0007\u014b\b\u0007\n\u0007\f\u0007\u014e\t\u0007\u0001\u0007\u0001"
            + "\u0007\u0003\u0007\u0152\b\u0007\u0001\u0007\u0003\u0007\u0155\b\u0007"
            + "\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001"
            + "\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001"
            + "\n\u0001\n\u0001\n\u0003\n\u0169\b\n\u0001\n\u0001\n\u0003\n\u016d\b\n"
            + "\u0001\n\u0001\n\u0001\u000b\u0003\u000b\u0172\b\u000b\u0001\u000b\u0001"
            + "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u0179\b\u000b\u0001"
            + "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"
            + "\u000b\u0003\u000b\u0182\b\u000b\u0001\u000b\u0003\u000b\u0185\b\u000b"
            + "\u0001\f\u0001\f\u0001\f\u0005\f\u018a\b\f\n\f\f\f\u018d\t\f\u0001\r\u0001"
            + "\r\u0001\r\u0005\r\u0192\b\r\n\r\f\r\u0195\t\r\u0001\r\u0005\r\u0198\b"
            + "\r\n\r\f\r\u019b\t\r\u0001\r\u0001\r\u0003\r\u019f\b\r\u0001\r\u0003\r"
            + "\u01a2\b\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0003\u000f"
            + "\u01a8\b\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"
            + "\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f"
            + "\u01b4\b\u000f\n\u000f\f\u000f\u01b7\t\u000f\u0001\u000f\u0001\u000f\u0001"
            + "\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u01be\b\u000f\n\u000f\f\u000f"
            + "\u01c1\t\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u01c6\b"
            + "\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u01cb\b\u0010\u0001"
            + "\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u01d0\b\u0010\u0001\u0010\u0001"
            + "\u0010\u0001\u0010\u0003\u0010\u01d5\b\u0010\u0005\u0010\u01d7\b\u0010"
            + "\n\u0010\f\u0010\u01da\t\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u01de"
            + "\b\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"
            + "\u0010\u0005\u0010\u01e6\b\u0010\n\u0010\f\u0010\u01e9\t\u0010\u0001\u0010"
            + "\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"
            + "\u0005\u0010\u01f2\b\u0010\n\u0010\f\u0010\u01f5\t\u0010\u0001\u0010\u0001"
            + "\u0010\u0005\u0010\u01f9\b\u0010\n\u0010\f\u0010\u01fc\t\u0010\u0003\u0010"
            + "\u01fe\b\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"
            + "\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011"
            + "\u020a\b\u0011\u0001\u0012\u0004\u0012\u020d\b\u0012\u000b\u0012\f\u0012"
            + "\u020e\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0003\u0014\u0215"
            + "\b\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0004\u0015\u021a\b\u0015"
            + "\u000b\u0015\f\u0015\u021b\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"
            + "\u0001\u0016\u0003\u0016\u0223\b\u0016\u0001\u0017\u0001\u0017\u0003\u0017"
            + "\u0227\b\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u022c\b"
            + "\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u0230\b\u0017\u0001\u0017\u0001"
            + "\u0017\u0001\u0017\u0003\u0017\u0235\b\u0017\u0001\u0017\u0003\u0017\u0238"
            + "\b\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u023d\b\u0017"
            + "\u0001\u0017\u0003\u0017\u0240\b\u0017\u0001\u0018\u0003\u0018\u0243\b"
            + "\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0003\u0018\u0248\b\u0018\u0001"
            + "\u0018\u0001\u0018\u0003\u0018\u024c\b\u0018\u0003\u0018\u024e\b\u0018"
            + "\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u001a\u0003\u001a\u0254\b\u001a"
            + "\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0003\u001a"
            + "\u025b\b\u001a\u0001\u001a\u0003\u001a\u025e\b\u001a\u0001\u001b\u0001"
            + "\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001"
            + "\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001"
            + "\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001"
            + "\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0003"
            + "\u001b\u0279\b\u001b\u0003\u001b\u027b\b\u001b\u0001\u001c\u0001\u001c"
            + "\u0001\u001c\u0003\u001c\u0280\b\u001c\u0001\u001c\u0001\u001c\u0003\u001c"
            + "\u0284\b\u001c\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001d"
            + "\u0001\u001d\u0001\u001d\u0003\u001d\u028d\b\u001d\u0001\u001d\u0001\u001d"
            + "\u0005\u001d\u0291\b\u001d\n\u001d\f\u001d\u0294\t\u001d\u0001\u001e\u0001"
            + "\u001e\u0001\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0003"
            + "\u001f\u029d\b\u001f\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001 \u0001"
            + " \u0003 \u02a5\b \u0001!\u0001!\u0001!\u0001!\u0003!\u02ab\b!\u0001!\u0001"
            + "!\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0003\"\u02b4\b\"\u0003\"\u02b6"
            + "\b\"\u0001\"\u0001\"\u0003\"\u02ba\b\"\u0001\"\u0001\"\u0003\"\u02be\b"
            + "\"\u0001#\u0001#\u0001#\u0001#\u0005#\u02c4\b#\n#\f#\u02c7\t#\u0001#\u0001"
            + "#\u0001$\u0001$\u0001$\u0001$\u0005$\u02cf\b$\n$\f$\u02d2\t$\u0001%\u0001"
            + "%\u0001%\u0001%\u0005%\u02d8\b%\n%\f%\u02db\t%\u0001%\u0001%\u0001&\u0001"
            + "&\u0003&\u02e1\b&\u0001&\u0001&\u0001\'\u0001\'\u0001\'\u0001(\u0003("
            + "\u02e9\b(\u0001(\u0001(\u0001)\u0001)\u0001)\u0001)\u0005)\u02f1\b)\n"
            + ")\f)\u02f4\t)\u0001*\u0001*\u0003*\u02f8\b*\u0001*\u0001*\u0001*\u0001"
            + "*\u0001*\u0001+\u0001+\u0001+\u0001+\u0005+\u0303\b+\n+\f+\u0306\t+\u0001"
            + "+\u0001+\u0001,\u0001,\u0001,\u0001,\u0005,\u030e\b,\n,\f,\u0311\t,\u0001"
            + ",\u0001,\u0001,\u0001,\u0003,\u0317\b,\u0001-\u0001-\u0001-\u0001-\u0001"
            + "-\u0003-\u031e\b-\u0001.\u0001.\u0003.\u0322\b.\u0001.\u0001.\u0003.\u0326"
            + "\b.\u0001.\u0001.\u0003.\u032a\b.\u0003.\u032c\b.\u0001/\u0001/\u0001"
            + "/\u0003/\u0331\b/\u0001/\u0003/\u0334\b/\u0001/\u0003/\u0337\b/\u0001"
            + "/\u0003/\u033a\b/\u0001/\u0001/\u0003/\u033e\b/\u0001/\u0003/\u0341\b"
            + "/\u0001/\u0003/\u0344\b/\u00010\u00030\u0347\b0\u00010\u00030\u034a\b"
            + "0\u00010\u00010\u00010\u00050\u034f\b0\n0\f0\u0352\t0\u00011\u00011\u0001"
            + "2\u00012\u00012\u00013\u00013\u00013\u00033\u035c\b3\u00013\u00013\u0003"
            + "3\u0360\b3\u00013\u00033\u0363\b3\u00014\u00034\u0366\b4\u00014\u0001"
            + "4\u00034\u036a\b4\u00014\u00014\u00014\u00014\u00054\u0370\b4\n4\f4\u0373"
            + "\t4\u00014\u00014\u00014\u00014\u00014\u00014\u00034\u037b\b4\u00015\u0001"
            + "5\u00035\u037f\b5\u00015\u00015\u00016\u00016\u00016\u00016\u00056\u0387"
            + "\b6\n6\f6\u038a\t6\u00017\u00017\u00017\u00057\u038f\b7\n7\f7\u0392\t"
            + "7\u00018\u00018\u00018\u00038\u0397\b8\u00019\u00019\u00039\u039b\b9\u0001"
            + "9\u00039\u039e\b9\u0001:\u0001:\u0001:\u0001:\u0003:\u03a4\b:\u0001;\u0001"
            + ";\u0001;\u0001;\u0001;\u0001;\u0001;\u0003;\u03ad\b;\u0001<\u0003<\u03b0"
            + "\b<\u0001<\u0001<\u0001<\u0003<\u03b5\b<\u0001<\u0003<\u03b8\b<\u0001"
            + "=\u0001=\u0001=\u0001=\u0001=\u0001=\u0005=\u03c0\b=\n=\f=\u03c3\t=\u0001"
            + "=\u0001=\u0003=\u03c7\b=\u0001>\u0001>\u0001>\u0001>\u0001>\u0005>\u03ce"
            + "\b>\n>\f>\u03d1\t>\u0001>\u0001>\u0003>\u03d5\b>\u0001?\u0001?\u0003?"
            + "\u03d9\b?\u0001?\u0001?\u0001?\u0001?\u0001?\u0005?\u03e0\b?\n?\f?\u03e3"
            + "\t?\u0001?\u0003?\u03e6\b?\u0001@\u0001@\u0001A\u0001A\u0001A\u0001B\u0001"
            + "B\u0001B\u0001B\u0001B\u0005B\u03f2\bB\nB\fB\u03f5\tB\u0001C\u0001C\u0001"
            + "C\u0001D\u0001D\u0001D\u0001E\u0001E\u0001E\u0001E\u0001E\u0005E\u0402"
            + "\bE\nE\fE\u0405\tE\u0001F\u0001F\u0003F\u0409\bF\u0001G\u0001G\u0001G"
            + "\u0001G\u0001G\u0001G\u0001H\u0004H\u0412\bH\u000bH\fH\u0413\u0001I\u0001"
            + "I\u0001I\u0001I\u0001I\u0001I\u0001I\u0001I\u0001I\u0003I\u041f\bI\u0003"
            + "I\u0421\bI\u0001J\u0001J\u0001J\u0001J\u0001J\u0003J\u0428\bJ\u0001J\u0003"
            + "J\u042b\bJ\u0001K\u0001K\u0001K\u0005K\u0430\bK\nK\fK\u0433\tK\u0001L"
            + "\u0001L\u0003L\u0437\bL\u0001L\u0001L\u0001L\u0001L\u0003L\u043d\bL\u0001"
            + "L\u0003L\u0440\bL\u0001L\u0003L\u0443\bL\u0001M\u0001M\u0001M\u0001N\u0001"
            + "N\u0003N\u044a\bN\u0001N\u0001N\u0003N\u044e\bN\u0001N\u0001N\u0003N\u0452"
            + "\bN\u0001O\u0001O\u0003O\u0456\bO\u0001O\u0001O\u0001P\u0001P\u0003P\u045c"
            + "\bP\u0001P\u0001P\u0001Q\u0001Q\u0003Q\u0462\bQ\u0001Q\u0001Q\u0001Q\u0001"
            + "Q\u0001Q\u0003Q\u0469\bQ\u0001Q\u0001Q\u0001Q\u0001Q\u0005Q\u046f\bQ\n"
            + "Q\fQ\u0472\tQ\u0001R\u0001R\u0001R\u0003R\u0477\bR\u0001S\u0001S\u0001"
            + "S\u0003S\u047c\bS\u0001S\u0001S\u0001S\u0001S\u0001S\u0001S\u0001S\u0001"
            + "S\u0001S\u0003S\u0487\bS\u0001S\u0001S\u0001S\u0001S\u0001S\u0001S\u0001"
            + "S\u0003S\u0490\bS\u0001T\u0001T\u0003T\u0494\bT\u0001T\u0001T\u0001T\u0001"
            + "T\u0001T\u0005T\u049b\bT\nT\fT\u049e\tT\u0001T\u0003T\u04a1\bT\u0001T"
            + "\u0001T\u0001U\u0001U\u0001U\u0001U\u0005U\u04a9\bU\nU\fU\u04ac\tU\u0001"
            + "U\u0001U\u0003U\u04b0\bU\u0001U\u0001U\u0001U\u0001U\u0001U\u0001V\u0001"
            + "V\u0001V\u0001V\u0001W\u0001W\u0001X\u0001X\u0001X\u0001X\u0001X\u0001"
            + "X\u0001X\u0001X\u0001X\u0003X\u04c6\bX\u0001X\u0003X\u04c9\bX\u0001Y\u0001"
            + "Y\u0001Y\u0001Y\u0001Y\u0001Y\u0001Y\u0001Y\u0001Y\u0001Y\u0001Y\u0001"
            + "Y\u0001Y\u0001Y\u0001Y\u0001Y\u0001Y\u0003Y\u04dc\bY\u0001Y\u0001Y\u0001"
            + "Y\u0001Y\u0001Y\u0001Y\u0001Y\u0001Y\u0001Y\u0001Y\u0001Y\u0001Y\u0001"
            + "Y\u0001Y\u0005Y\u04ec\bY\nY\fY\u04ef\tY\u0001Z\u0001Z\u0001Z\u0001Z\u0001"
            + "Z\u0001Z\u0001Z\u0001Z\u0003Z\u04f9\bZ\u0001[\u0001[\u0001[\u0001[\u0001"
            + "\\\u0001\\\u0001]\u0001]\u0001]\u0001]\u0001]\u0005]\u0506\b]\n]\f]\u0509"
            + "\t]\u0001^\u0001^\u0001^\u0001^\u0001^\u0001^\u0001^\u0001^\u0001^\u0003"
            + "^\u0514\b^\u0001_\u0001_\u0003_\u0518\b_\u0001`\u0001`\u0001`\u0001`\u0001"
            + "`\u0001`\u0001`\u0004`\u0521\b`\u000b`\f`\u0522\u0001`\u0001`\u0003`\u0527"
            + "\b`\u0001`\u0001`\u0001a\u0001a\u0004a\u052d\ba\u000ba\fa\u052e\u0001"
            + "a\u0001a\u0003a\u0533\ba\u0001a\u0001a\u0001b\u0001b\u0001b\u0001b\u0001"
            + "b\u0001c\u0001c\u0001c\u0001c\u0001d\u0001d\u0001d\u0003d\u0543\bd\u0001"
            + "d\u0001d\u0001d\u0003d\u0548\bd\u0001d\u0001d\u0001d\u0003d\u054d\bd\u0001"
            + "d\u0001d\u0003d\u0551\bd\u0001d\u0001d\u0003d\u0555\bd\u0001d\u0001d\u0001"
            + "d\u0003d\u055a\bd\u0001d\u0001d\u0003d\u055e\bd\u0001d\u0001d\u0003d\u0562"
            + "\bd\u0001d\u0001d\u0001d\u0001d\u0001d\u0001d\u0001d\u0001d\u0001d\u0001"
            + "d\u0001d\u0001d\u0001d\u0001d\u0001d\u0001d\u0001d\u0001d\u0001d\u0001"
            + "d\u0001d\u0003d\u0579\bd\u0003d\u057b\bd\u0001d\u0001d\u0001d\u0001d\u0001"
            + "d\u0001d\u0001d\u0001d\u0001d\u0001d\u0001d\u0001d\u0001d\u0001d\u0001"
            + "d\u0001d\u0003d\u058d\bd\u0003d\u058f\bd\u0001d\u0001d\u0001d\u0001d\u0001"
            + "d\u0001d\u0003d\u0597\bd\u0001d\u0001d\u0001d\u0003d\u059c\bd\u0001d\u0001"
            + "d\u0001d\u0003d\u05a1\bd\u0001d\u0001d\u0001d\u0003d\u05a6\bd\u0001d\u0001"
            + "d\u0001d\u0001d\u0001d\u0001d\u0001d\u0001d\u0001d\u0001d\u0001d\u0003"
            + "d\u05b3\bd\u0001d\u0001d\u0001d\u0003d\u05b8\bd\u0001d\u0001d\u0001d\u0003"
            + "d\u05bd\bd\u0001d\u0001d\u0001d\u0003d\u05c2\bd\u0001d\u0001d\u0001d\u0003"
            + "d\u05c7\bd\u0001d\u0001d\u0001d\u0003d\u05cc\bd\u0001d\u0001d\u0001d\u0003"
            + "d\u05d1\bd\u0001d\u0001d\u0001d\u0003d\u05d6\bd\u0003d\u05d8\bd\u0001"
            + "e\u0001e\u0001f\u0001f\u0001f\u0003f\u05df\bf\u0001f\u0003f\u05e2\bf\u0001"
            + "f\u0001f\u0001g\u0001g\u0001g\u0001g\u0001g\u0005g\u05eb\bg\ng\fg\u05ee"
            + "\tg\u0001h\u0001h\u0001h\u0001h\u0001h\u0001h\u0001h\u0003h\u05f7\bh\u0001"
            + "h\u0001h\u0001h\u0001h\u0001h\u0001h\u0003h\u05ff\bh\u0001h\u0001h\u0001"
            + "h\u0001h\u0001h\u0001h\u0001h\u0001h\u0001h\u0003h\u060a\bh\u0001h\u0001"
            + "h\u0001h\u0001h\u0003h\u0610\bh\u0001h\u0001h\u0001h\u0001h\u0001h\u0001"
            + "h\u0001h\u0001h\u0001h\u0001h\u0001h\u0001h\u0001h\u0005h\u061f\bh\nh"
            + "\fh\u0622\th\u0003h\u0624\bh\u0001h\u0001h\u0001h\u0001h\u0001h\u0001"
            + "h\u0001h\u0001h\u0001h\u0001h\u0001h\u0001h\u0005h\u0632\bh\nh\fh\u0635"
            + "\th\u0003h\u0637\bh\u0001h\u0001h\u0001h\u0001h\u0001h\u0001h\u0001h\u0001"
            + "h\u0001h\u0001h\u0001h\u0001h\u0005h\u0645\bh\nh\fh\u0648\th\u0003h\u064a"
            + "\bh\u0001h\u0001h\u0001h\u0001h\u0001h\u0001h\u0001h\u0001h\u0001h\u0001"
            + "h\u0001h\u0001h\u0005h\u0658\bh\nh\fh\u065b\th\u0003h\u065d\bh\u0001h"
            + "\u0001h\u0001h\u0001h\u0001h\u0001h\u0001h\u0001h\u0001h\u0001h\u0001"
            + "h\u0001h\u0005h\u066b\bh\nh\fh\u066e\th\u0003h\u0670\bh\u0001h\u0001h"
            + "\u0001h\u0001h\u0001h\u0001h\u0001h\u0001h\u0001h\u0001h\u0001h\u0001"
            + "h\u0005h\u067e\bh\nh\fh\u0681\th\u0003h\u0683\bh\u0001h\u0001h\u0001h"
            + "\u0001h\u0001h\u0001h\u0001h\u0001h\u0001h\u0001h\u0005h\u068f\bh\nh\f"
            + "h\u0692\th\u0001h\u0001h\u0001h\u0001h\u0001h\u0001h\u0001h\u0001h\u0001"
            + "h\u0001h\u0004h\u069e\bh\u000bh\fh\u069f\u0001h\u0001h\u0003h\u06a4\b"
            + "h\u0001h\u0001h\u0001h\u0001h\u0001h\u0001h\u0001h\u0001h\u0001h\u0003"
            + "h\u06af\bh\u0001h\u0001h\u0001h\u0001h\u0003h\u06b5\bh\u0001i\u0001i\u0001"
            + "i\u0003i\u06ba\bi\u0001i\u0001i\u0001j\u0001j\u0001j\u0005j\u06c1\bj\n"
            + "j\fj\u06c4\tj\u0001k\u0001k\u0001k\u0001k\u0001k\u0003k\u06cb\bk\u0003"
            + "k\u06cd\bk\u0001k\u0001k\u0003k\u06d1\bk\u0001l\u0001l\u0001m\u0001m\u0001"
            + "m\u0005m\u06d8\bm\nm\fm\u06db\tm\u0001n\u0001n\u0001n\u0001o\u0001o\u0001"
            + "o\u0001p\u0003p\u06e4\bp\u0001p\u0001p\u0001p\u0005p\u06e9\bp\np\fp\u06ec"
            + "\tp\u0001q\u0001q\u0003q\u06f0\bq\u0001r\u0001r\u0003r\u06f4\br\u0001"
            + "s\u0003s\u06f7\bs\u0001s\u0001s\u0001t\u0003t\u06fc\bt\u0001t\u0001t\u0001"
            + "u\u0001u\u0001v\u0001v\u0001w\u0001w\u0001w\u0000\u0002\u00a2\u00b2x\u0000"
            + "\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c"
            + "\u001e \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084"
            + "\u0086\u0088\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u009a\u009c"
            + "\u009e\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac\u00ae\u00b0\u00b2\u00b4"
            + "\u00b6\u00b8\u00ba\u00bc\u00be\u00c0\u00c2\u00c4\u00c6\u00c8\u00ca\u00cc"
            + "\u00ce\u00d0\u00d2\u00d4\u00d6\u00d8\u00da\u00dc\u00de\u00e0\u00e2\u00e4"
            + "\u00e6\u00e8\u00ea\u00ec\u00ee\u0000\u001a\u0003\u0000KK\u018f\u018f\u0198"
            + "\u0198\u0002\u0000\u000b\u000bSS\u0002\u0000PP\u0142\u0142\u0002\u0000"
            + "mm\u00b0\u00b0\u0002\u0000PP\u00df\u00df\u0002\u0000\"\"==\u0002\u0000"
            + "\u0101\u0101\u013f\u013f\u0002\u0000\u00b6\u00b6\u019b\u019b\u0002\u0000"
            + "\u001d\u001d$$\u0002\u0000AA\u0108\u0108\u0002\u0000KK\u0198\u0198\u0001"
            + "\u0000\u010d\u010e\u0002\u0000\u0004\u0004XX\u0003\u0000yy\u00a6\u00a6"
            + "\u00fb\u00fb\u0003\u0000==\u0103\u0104\u0143\u0143\u0002\u0000jj\u0142"
            + "\u0142\u0001\u0000ST\u0002\u0000\u012d\u012d\u012f\u012f\u0002\u0000\u0007"
            + "\u0007\u00d0\u00d0\u0003\u0000\u00a7\u00a7\u00f0\u00f0\u00fc\u00fc\u0003"
            + "\u0000FG\u00ba\u00bb\u0109\u010a\u0002\u000033\u0183\u0183\u0003\u0000"
            + "ww\u009c\u009c\u00c7\u00c7\u0002\u0000\u0180\u0180\u0197\u0197\u0002\u0000"
            + "nn\u013d\u013d!\u0000\u0002\r\u0010\u0016\u0018\u001a\u001c.09;AC^bbd"
            + "~\u0080\u0085\u0087\u008b\u008d\u009f\u00a1\u00a2\u00a4\u00a9\u00ab\u00c7"
            + "\u00c9\u00d8\u00da\u00db\u00de\u00df\u00e1\u00e4\u00e9\u00f0\u00f2\u00f9"
            + "\u00fb\u0100\u0102\u0106\u0108\u0112\u0114\u0116\u0118\u011e\u0120\u0121"
            + "\u0123\u012d\u0132\u0137\u0139\u013e\u0141\u014c\u014f\u0161\u0168\u016f"
            + "\u07e7\u0000\u00f0\u0001\u0000\u0000\u0000\u0002\u0105\u0001\u0000\u0000"
            + "\u0000\u0004\u0109\u0001\u0000\u0000\u0000\u0006\u0113\u0001\u0000\u0000"
            + "\u0000\b\u0118\u0001\u0000\u0000\u0000\n\u012a\u0001\u0000\u0000\u0000"
            + "\f\u012c\u0001\u0000\u0000\u0000\u000e\u0151\u0001\u0000\u0000\u0000\u0010"
            + "\u015b\u0001\u0000\u0000\u0000\u0012\u0160\u0001\u0000\u0000\u0000\u0014"
            + "\u0163\u0001\u0000\u0000\u0000\u0016\u0181\u0001\u0000\u0000\u0000\u0018"
            + "\u0186\u0001\u0000\u0000\u0000\u001a\u01a1\u0001\u0000\u0000\u0000\u001c"
            + "\u01a3\u0001\u0000\u0000\u0000\u001e\u01c5\u0001\u0000\u0000\u0000 \u01fd"
            + "\u0001\u0000\u0000\u0000\"\u01ff\u0001\u0000\u0000\u0000$\u020c\u0001"
            + "\u0000\u0000\u0000&\u0210\u0001\u0000\u0000\u0000(\u0214\u0001\u0000\u0000"
            + "\u0000*\u0219\u0001\u0000\u0000\u0000,\u0222\u0001\u0000\u0000\u0000."
            + "\u023f\u0001\u0000\u0000\u00000\u024d\u0001\u0000\u0000\u00002\u024f\u0001"
            + "\u0000\u0000\u00004\u025d\u0001\u0000\u0000\u00006\u027a\u0001\u0000\u0000"
            + "\u00008\u027c\u0001\u0000\u0000\u0000:\u0287\u0001\u0000\u0000\u0000<"
            + "\u0295\u0001\u0000\u0000\u0000>\u0298\u0001\u0000\u0000\u0000@\u02a4\u0001"
            + "\u0000\u0000\u0000B\u02a6\u0001\u0000\u0000\u0000D\u02ae\u0001\u0000\u0000"
            + "\u0000F\u02bf\u0001\u0000\u0000\u0000H\u02ca\u0001\u0000\u0000\u0000J"
            + "\u02d3\u0001\u0000\u0000\u0000L\u02de\u0001\u0000\u0000\u0000N\u02e4\u0001"
            + "\u0000\u0000\u0000P\u02e8\u0001\u0000\u0000\u0000R\u02ec\u0001\u0000\u0000"
            + "\u0000T\u02f5\u0001\u0000\u0000\u0000V\u02fe\u0001\u0000\u0000\u0000X"
            + "\u0316\u0001\u0000\u0000\u0000Z\u031d\u0001\u0000\u0000\u0000\\\u032b"
            + "\u0001\u0000\u0000\u0000^\u032d\u0001\u0000\u0000\u0000`\u0346\u0001\u0000"
            + "\u0000\u0000b\u0353\u0001\u0000\u0000\u0000d\u0355\u0001\u0000\u0000\u0000"
            + "f\u0362\u0001\u0000\u0000\u0000h\u037a\u0001\u0000\u0000\u0000j\u037e"
            + "\u0001\u0000\u0000\u0000l\u0382\u0001\u0000\u0000\u0000n\u038b\u0001\u0000"
            + "\u0000\u0000p\u0396\u0001\u0000\u0000\u0000r\u0398\u0001\u0000\u0000\u0000"
            + "t\u039f\u0001\u0000\u0000\u0000v\u03ac\u0001\u0000\u0000\u0000x\u03b7"
            + "\u0001\u0000\u0000\u0000z\u03b9\u0001\u0000\u0000\u0000|\u03d4\u0001\u0000"
            + "\u0000\u0000~\u03d6\u0001\u0000\u0000\u0000\u0080\u03e7\u0001\u0000\u0000"
            + "\u0000\u0082\u03e9\u0001\u0000\u0000\u0000\u0084\u03ec\u0001\u0000\u0000"
            + "\u0000\u0086\u03f6\u0001\u0000\u0000\u0000\u0088\u03f9\u0001\u0000\u0000"
            + "\u0000\u008a\u03fc\u0001\u0000\u0000\u0000\u008c\u0406\u0001\u0000\u0000"
            + "\u0000\u008e\u040a\u0001\u0000\u0000\u0000\u0090\u0411\u0001\u0000\u0000"
            + "\u0000\u0092\u0420\u0001\u0000\u0000\u0000\u0094\u0422\u0001\u0000\u0000"
            + "\u0000\u0096\u042c\u0001\u0000\u0000\u0000\u0098\u043c\u0001\u0000\u0000"
            + "\u0000\u009a\u0444\u0001\u0000\u0000\u0000\u009c\u0447\u0001\u0000\u0000"
            + "\u0000\u009e\u0453\u0001\u0000\u0000\u0000\u00a0\u0459\u0001\u0000\u0000"
            + "\u0000\u00a2\u0468\u0001\u0000\u0000\u0000\u00a4\u0476\u0001\u0000\u0000"
            + "\u0000\u00a6\u048f\u0001\u0000\u0000\u0000\u00a8\u0491\u0001\u0000\u0000"
            + "\u0000\u00aa\u04a4\u0001\u0000\u0000\u0000\u00ac\u04b6\u0001\u0000\u0000"
            + "\u0000\u00ae\u04ba\u0001\u0000\u0000\u0000\u00b0\u04c8\u0001\u0000\u0000"
            + "\u0000\u00b2\u04db\u0001\u0000\u0000\u0000\u00b4\u04f8\u0001\u0000\u0000"
            + "\u0000\u00b6\u04fa\u0001\u0000\u0000\u0000\u00b8\u04fe\u0001\u0000\u0000"
            + "\u0000\u00ba\u0500\u0001\u0000\u0000\u0000\u00bc\u0513\u0001\u0000\u0000"
            + "\u0000\u00be\u0517\u0001\u0000\u0000\u0000\u00c0\u0519\u0001\u0000\u0000"
            + "\u0000\u00c2\u052a\u0001\u0000\u0000\u0000\u00c4\u0536\u0001\u0000\u0000"
            + "\u0000\u00c6\u053b\u0001\u0000\u0000\u0000\u00c8\u05d7\u0001\u0000\u0000"
            + "\u0000\u00ca\u05d9\u0001\u0000\u0000\u0000\u00cc\u05db\u0001\u0000\u0000"
            + "\u0000\u00ce\u05e5\u0001\u0000\u0000\u0000\u00d0\u06b4\u0001\u0000\u0000"
            + "\u0000\u00d2\u06b6\u0001\u0000\u0000\u0000\u00d4\u06bd\u0001\u0000\u0000"
            + "\u0000\u00d6\u06d0\u0001\u0000\u0000\u0000\u00d8\u06d2\u0001\u0000\u0000"
            + "\u0000\u00da\u06d4\u0001\u0000\u0000\u0000\u00dc\u06dc\u0001\u0000\u0000"
            + "\u0000\u00de\u06df\u0001\u0000\u0000\u0000\u00e0\u06e3\u0001\u0000\u0000"
            + "\u0000\u00e2\u06ef\u0001\u0000\u0000\u0000\u00e4\u06f3\u0001\u0000\u0000"
            + "\u0000\u00e6\u06f6\u0001\u0000\u0000\u0000\u00e8\u06fb\u0001\u0000\u0000"
            + "\u0000\u00ea\u06ff\u0001\u0000\u0000\u0000\u00ec\u0701\u0001\u0000\u0000"
            + "\u0000\u00ee\u0703\u0001\u0000\u0000\u0000\u00f0\u00f2\u0003\u0002\u0001"
            + "\u0000\u00f1\u00f3\u0005\u0196\u0000\u0000\u00f2\u00f1\u0001\u0000\u0000"
            + "\u0000\u00f2\u00f3\u0001\u0000\u0000\u0000\u00f3\u00f4\u0001\u0000\u0000"
            + "\u0000\u00f4\u00f5\u0005\u0000\u0000\u0001\u00f5\u0001\u0001\u0000\u0000"
            + "\u0000\u00f6\u0106\u0003:\u001d\u0000\u00f7\u0106\u0003\u0014\n\u0000"
            + "\u00f8\u0106\u0003\u00a0P\u0000\u00f9\u0106\u0003>\u001f\u0000\u00fa\u0106"
            + "\u0003B!\u0000\u00fb\u0106\u0003L&\u0000\u00fc\u0106\u0003N\'\u0000\u00fd"
            + "\u0106\u0003<\u001e\u0000\u00fe\u0106\u00032\u0019\u0000\u00ff\u0106\u0003"
            + "\u0010\b\u0000\u0100\u0106\u0003\u0012\t\u0000\u0101\u0106\u0003D\"\u0000"
            + "\u0102\u0106\u0003\u0094J\u0000\u0103\u0106\u0003\u009cN\u0000\u0104\u0106"
            + "\u0003P(\u0000\u0105\u00f6\u0001\u0000\u0000\u0000\u0105\u00f7\u0001\u0000"
            + "\u0000\u0000\u0105\u00f8\u0001\u0000\u0000\u0000\u0105\u00f9\u0001\u0000"
            + "\u0000\u0000\u0105\u00fa\u0001\u0000\u0000\u0000\u0105\u00fb\u0001\u0000"
            + "\u0000\u0000\u0105\u00fc\u0001\u0000\u0000\u0000\u0105\u00fd\u0001\u0000"
            + "\u0000\u0000\u0105\u00fe\u0001\u0000\u0000\u0000\u0105\u00ff\u0001\u0000"
            + "\u0000\u0000\u0105\u0100\u0001\u0000\u0000\u0000\u0105\u0101\u0001\u0000"
            + "\u0000\u0000\u0105\u0102\u0001\u0000\u0000\u0000\u0105\u0103\u0001\u0000"
            + "\u0000\u0000\u0105\u0104\u0001\u0000\u0000\u0000\u0106\u0003\u0001\u0000"
            + "\u0000\u0000\u0107\u0108\u0007\u0000\u0000\u0000\u0108\u010a\u0005\u0185"
            + "\u0000\u0000\u0109\u0107\u0001\u0000\u0000\u0000\u0109\u010a\u0001\u0000"
            + "\u0000\u0000\u010a\u010b\u0001\u0000\u0000\u0000\u010b\u010c\u0007\u0000"
            + "\u0000\u0000\u010c\u0005\u0001\u0000\u0000\u0000\u010d\u0114\u0003\u0004"
            + "\u0002\u0000\u010e\u010f\u0005\u0198\u0000\u0000\u010f\u0111\u0005\u0185"
            + "\u0000\u0000\u0110\u010e\u0001\u0000\u0000\u0000\u0110\u0111\u0001\u0000"
            + "\u0000\u0000\u0111\u0112\u0001\u0000\u0000\u0000\u0112\u0114\u0003\u0004"
            + "\u0002\u0000\u0113\u010d\u0001\u0000\u0000\u0000\u0113\u0110\u0001\u0000"
            + "\u0000\u0000\u0114\u0007\u0001\u0000\u0000\u0000\u0115\u0119\u0003\n\u0005"
            + "\u0000\u0116\u0119\u0003\f\u0006\u0000\u0117\u0119\u0003\u000e\u0007\u0000"
            + "\u0118\u0115\u0001\u0000\u0000\u0000\u0118\u0116\u0001\u0000\u0000\u0000"
            + "\u0118\u0117\u0001\u0000\u0000\u0000\u0119\t\u0001\u0000\u0000\u0000\u011a"
            + "\u011c\u0003\u00e0p\u0000\u011b\u011d\u0005\u0181\u0000\u0000\u011c\u011b"
            + "\u0001\u0000\u0000\u0000\u011c\u011d\u0001\u0000\u0000\u0000\u011d\u011e"
            + "\u0001\u0000\u0000\u0000\u011e\u011f\u0005\u0187\u0000\u0000\u011f\u0120"
            + "\u0003\u00b2Y\u0000\u0120\u012b\u0001\u0000\u0000\u0000\u0121\u0122\u0005"
            + "\u0191\u0000\u0000\u0122\u0123\u0003\u00e0p\u0000\u0123\u0125\u0005\u0194"
            + "\u0000\u0000\u0124\u0126\u0005\u0181\u0000\u0000\u0125\u0124\u0001\u0000"
            + "\u0000\u0000\u0125\u0126\u0001\u0000\u0000\u0000\u0126\u0127\u0001\u0000"
            + "\u0000\u0000\u0127\u0128\u0005\u0187\u0000\u0000\u0128\u0129\u0003\u00b2"
            + "Y\u0000\u0129\u012b\u0001\u0000\u0000\u0000\u012a\u011a\u0001\u0000\u0000"
            + "\u0000\u012a\u0121\u0001\u0000\u0000\u0000\u012b\u000b\u0001\u0000\u0000"
            + "\u0000\u012c\u012d\u0005\u0191\u0000\u0000\u012d\u0132\u0003\u00e0p\u0000"
            + "\u012e\u012f\u0005\u0182\u0000\u0000\u012f\u0131\u0003\u00e0p\u0000\u0130"
            + "\u012e\u0001\u0000\u0000\u0000\u0131\u0134\u0001\u0000\u0000\u0000\u0132"
            + "\u0130\u0001\u0000\u0000\u0000\u0132\u0133\u0001\u0000\u0000\u0000\u0133"
            + "\u0135\u0001\u0000\u0000\u0000\u0134\u0132\u0001\u0000\u0000\u0000\u0135"
            + "\u0137\u0005\u0194\u0000\u0000\u0136\u0138\u0005\u0181\u0000\u0000\u0137"
            + "\u0136\u0001\u0000\u0000\u0000\u0137\u0138\u0001\u0000\u0000\u0000\u0138"
            + "\u0139\u0001\u0000\u0000\u0000\u0139\u013a\u0005\u0187\u0000\u0000\u013a"
            + "\u013b\u0005\u0191\u0000\u0000\u013b\u0140\u0003\u00b2Y\u0000\u013c\u013d"
            + "\u0005\u0182\u0000\u0000\u013d\u013f\u0003\u00b2Y\u0000\u013e\u013c\u0001"
            + "\u0000\u0000\u0000\u013f\u0142\u0001\u0000\u0000\u0000\u0140\u013e\u0001"
            + "\u0000\u0000\u0000\u0140\u0141\u0001\u0000\u0000\u0000\u0141\u0143\u0001"
            + "\u0000\u0000\u0000\u0142\u0140\u0001\u0000\u0000\u0000\u0143\u0144\u0005"
            + "\u0194\u0000\u0000\u0144\r\u0001\u0000\u0000\u0000\u0145\u0152\u0003\u00e0"
            + "p\u0000\u0146\u0147\u0005\u0191\u0000\u0000\u0147\u014c\u0003\u00e0p\u0000"
            + "\u0148\u0149\u0005\u0182\u0000\u0000\u0149\u014b\u0003\u00e0p\u0000\u014a"
            + "\u0148\u0001\u0000\u0000\u0000\u014b\u014e\u0001\u0000\u0000\u0000\u014c"
            + "\u014a\u0001\u0000\u0000\u0000\u014c\u014d\u0001\u0000\u0000\u0000\u014d"
            + "\u014f\u0001\u0000\u0000\u0000\u014e\u014c\u0001\u0000\u0000\u0000\u014f"
            + "\u0150\u0005\u0194\u0000\u0000\u0150\u0152\u0001\u0000\u0000\u0000\u0151"
            + "\u0145\u0001\u0000\u0000\u0000\u0151\u0146\u0001\u0000\u0000\u0000\u0152"
            + "\u0154\u0001\u0000\u0000\u0000\u0153\u0155\u0005\u0181\u0000\u0000\u0154"
            + "\u0153\u0001\u0000\u0000\u0000\u0154\u0155\u0001\u0000\u0000\u0000\u0155"
            + "\u0156\u0001\u0000\u0000\u0000\u0156\u0157\u0005\u0187\u0000\u0000\u0157"
            + "\u0158\u0005\u0191\u0000\u0000\u0158\u0159\u0003P(\u0000\u0159\u015a\u0005"
            + "\u0194\u0000\u0000\u015a\u000f\u0001\u0000\u0000\u0000\u015b\u015c\u0005"
            + "\u0113\u0000\u0000\u015c\u015d\u0005:\u0000\u0000\u015d\u015e\u0005\u012d"
            + "\u0000\u0000\u015e\u015f\u0003\u00e0p\u0000\u015f\u0011\u0001\u0000\u0000"
            + "\u0000\u0160\u0161\u0005\u0113\u0000\u0000\u0161\u0162\u0005\u0122\u0000"
            + "\u0000\u0162\u0013\u0001\u0000\u0000\u0000\u0163\u0164\u0005:\u0000\u0000"
            + "\u0164\u0168\u0005\u012d\u0000\u0000\u0165\u0166\u0005\u0087\u0000\u0000"
            + "\u0166\u0167\u0005\u00c6\u0000\u0000\u0167\u0169\u0005k\u0000\u0000\u0168"
            + "\u0165\u0001\u0000\u0000\u0000\u0168\u0169\u0001\u0000\u0000\u0000\u0169"
            + "\u016a\u0001\u0000\u0000\u0000\u016a\u016c\u0003\u00d8l\u0000\u016b\u016d"
            + "\u0003$\u0012\u0000\u016c\u016b\u0001\u0000\u0000\u0000\u016c\u016d\u0001"
            + "\u0000\u0000\u0000\u016d\u016e\u0001\u0000\u0000\u0000\u016e\u016f\u0003"
            + "\u0016\u000b\u0000\u016f\u0015\u0001\u0000\u0000\u0000\u0170\u0172\u0005"
            + "\n\u0000\u0000\u0171\u0170\u0001\u0000\u0000\u0000\u0171\u0172\u0001\u0000"
            + "\u0000\u0000\u0172\u0173\u0001\u0000\u0000\u0000\u0173\u0174\u0005\u0191"
            + "\u0000\u0000\u0174\u0175\u0003P(\u0000\u0175\u0176\u0005\u0194\u0000\u0000"
            + "\u0176\u0182\u0001\u0000\u0000\u0000\u0177\u0179\u0005\n\u0000\u0000\u0178"
            + "\u0177\u0001\u0000\u0000\u0000\u0178\u0179\u0001\u0000\u0000\u0000\u0179"
            + "\u017a\u0001\u0000\u0000\u0000\u017a\u0182\u0003P(\u0000\u017b\u017c\u0005"
            + "\u0191\u0000\u0000\u017c\u017d\u0003\u0018\f\u0000\u017d\u017e\u0005\u0194"
            + "\u0000\u0000\u017e\u0182\u0001\u0000\u0000\u0000\u017f\u0180\u0005\u00a7"
            + "\u0000\u0000\u0180\u0182\u0003\u00d8l\u0000\u0181\u0171\u0001\u0000\u0000"
            + "\u0000\u0181\u0178\u0001\u0000\u0000\u0000\u0181\u017b\u0001\u0000\u0000"
            + "\u0000\u0181\u017f\u0001\u0000\u0000\u0000\u0182\u0184\u0001\u0000\u0000"
            + "\u0000\u0183\u0185\u0003*\u0015\u0000\u0184\u0183\u0001\u0000\u0000\u0000"
            + "\u0184\u0185\u0001\u0000\u0000\u0000\u0185\u0017\u0001\u0000\u0000\u0000"
            + "\u0186\u018b\u0003\u001a\r\u0000\u0187\u0188\u0005\u0182\u0000\u0000\u0188"
            + "\u018a\u0003\u001a\r\u0000\u0189\u0187\u0001\u0000\u0000\u0000\u018a\u018d"
            + "\u0001\u0000\u0000\u0000\u018b\u0189\u0001\u0000\u0000\u0000\u018b\u018c"
            + "\u0001\u0000\u0000\u0000\u018c\u0019\u0001\u0000\u0000\u0000\u018d\u018b"
            + "\u0001\u0000\u0000\u0000\u018e\u018f\u0003\u001c\u000e\u0000\u018f\u0193"
            + "\u00036\u001b\u0000\u0190\u0192\u00034\u001a\u0000\u0191\u0190\u0001\u0000"
            + "\u0000\u0000\u0192\u0195\u0001\u0000\u0000\u0000\u0193\u0191\u0001\u0000"
            + "\u0000\u0000\u0193\u0194\u0001\u0000\u0000\u0000\u0194\u0199\u0001\u0000"
            + "\u0000\u0000\u0195\u0193\u0001\u0000\u0000\u0000\u0196\u0198\u0003\u001e"
            + "\u000f\u0000\u0197\u0196\u0001\u0000\u0000\u0000\u0198\u019b\u0001\u0000"
            + "\u0000\u0000\u0199\u0197\u0001\u0000\u0000\u0000\u0199\u019a\u0001\u0000"
            + "\u0000\u0000\u019a\u01a2\u0001\u0000\u0000\u0000\u019b\u0199\u0001\u0000"
            + "\u0000\u0000\u019c\u019d\u00055\u0000\u0000\u019d\u019f\u0003\u00dam\u0000"
            + "\u019e\u019c\u0001\u0000\u0000\u0000\u019e\u019f\u0001\u0000\u0000\u0000"
            + "\u019f\u01a0\u0001\u0000\u0000\u0000\u01a0\u01a2\u0003 \u0010\u0000\u01a1"
            + "\u018e\u0001\u0000\u0000\u0000\u01a1\u019e\u0001\u0000\u0000\u0000\u01a2"
            + "\u001b\u0001\u0000\u0000\u0000\u01a3\u01a4\u0003\u00dam\u0000\u01a4\u001d"
            + "\u0001\u0000\u0000\u0000\u01a5\u01c6\u00030\u0018\u0000\u01a6\u01a8\u0005"
            + "\u00c6\u0000\u0000\u01a7\u01a6\u0001\u0000\u0000\u0000\u01a7\u01a8\u0001"
            + "\u0000\u0000\u0000\u01a8\u01a9\u0001\u0000\u0000\u0000\u01a9\u01c6\u0005"
            + "\u00c8\u0000\u0000\u01aa\u01ab\u0005\u00e1\u0000\u0000\u01ab\u01c6\u0005"
            + "\u00a1\u0000\u0000\u01ac\u01c6\u0005\u0141\u0000\u0000\u01ad\u01ae\u0005"
            + "\u00ef\u0000\u0000\u01ae\u01af\u0003\u00d8l\u0000\u01af\u01b0\u0005\u0191"
            + "\u0000\u0000\u01b0\u01b1\u0003\u00dam\u0000\u01b1\u01b5\u0005\u0194\u0000"
            + "\u0000\u01b2\u01b4\u0003\"\u0011\u0000\u01b3\u01b2\u0001\u0000\u0000\u0000"
            + "\u01b4\u01b7\u0001\u0000\u0000\u0000\u01b5\u01b3\u0001\u0000\u0000\u0000"
            + "\u01b5\u01b6\u0001\u0000\u0000\u0000\u01b6\u01c6\u0001\u0000\u0000\u0000"
            + "\u01b7\u01b5\u0001\u0000\u0000\u0000\u01b8\u01b9\u0005\u0085\u0000\u0000"
            + "\u01b9\u01ba\u0005\u0191\u0000\u0000\u01ba\u01bf\u0005\u019b\u0000\u0000"
            + "\u01bb\u01bc\u0005\u0182\u0000\u0000\u01bc\u01be\u0005\u019b\u0000\u0000"
            + "\u01bd\u01bb\u0001\u0000\u0000\u0000\u01be\u01c1\u0001\u0000\u0000\u0000"
            + "\u01bf\u01bd\u0001\u0000\u0000\u0000\u01bf\u01c0\u0001\u0000\u0000\u0000"
            + "\u01c0\u01c2\u0001\u0000\u0000\u0000\u01c1\u01bf\u0001\u0000\u0000\u0000"
            + "\u01c2\u01c6\u0005\u0194\u0000\u0000\u01c3\u01c6\u0005\u000f\u0000\u0000"
            + "\u01c4\u01c6\u0005b\u0000\u0000\u01c5\u01a5\u0001\u0000\u0000\u0000\u01c5"
            + "\u01a7\u0001\u0000\u0000\u0000\u01c5\u01aa\u0001\u0000\u0000\u0000\u01c5"
            + "\u01ac\u0001\u0000\u0000\u0000\u01c5\u01ad\u0001\u0000\u0000\u0000\u01c5"
            + "\u01b8\u0001\u0000\u0000\u0000\u01c5\u01c3\u0001\u0000\u0000\u0000\u01c5"
            + "\u01c4\u0001\u0000\u0000\u0000\u01c6\u001f\u0001\u0000\u0000\u0000\u01c7"
            + "\u01c8\u0005\u00e1\u0000\u0000\u01c8\u01ca\u0005\u00a1\u0000\u0000\u01c9"
            + "\u01cb\u0005)\u0000\u0000\u01ca\u01c9\u0001\u0000\u0000\u0000\u01ca\u01cb"
            + "\u0001\u0000\u0000\u0000\u01cb\u01cc\u0001\u0000\u0000\u0000\u01cc\u01cd"
            + "\u0005\u0191\u0000\u0000\u01cd\u01cf\u0003\u00dam\u0000\u01ce\u01d0\u0007"
            + "\u0001\u0000\u0000\u01cf\u01ce\u0001\u0000\u0000\u0000\u01cf\u01d0\u0001"
            + "\u0000\u0000\u0000\u01d0\u01d8\u0001\u0000\u0000\u0000\u01d1\u01d2\u0005"
            + "\u0182\u0000\u0000\u01d2\u01d4\u0003\u00dam\u0000\u01d3\u01d5\u0007\u0001"
            + "\u0000\u0000\u01d4\u01d3\u0001\u0000\u0000\u0000\u01d4\u01d5\u0001\u0000"
            + "\u0000\u0000\u01d5\u01d7\u0001\u0000\u0000\u0000\u01d6\u01d1\u0001\u0000"
            + "\u0000\u0000\u01d7\u01da\u0001\u0000\u0000\u0000\u01d8\u01d6\u0001\u0000"
            + "\u0000\u0000\u01d8\u01d9\u0001\u0000\u0000\u0000\u01d9\u01db\u0001\u0000"
            + "\u0000\u0000\u01da\u01d8\u0001\u0000\u0000\u0000\u01db\u01dd\u0005\u0194"
            + "\u0000\u0000\u01dc\u01de\u0005b\u0000\u0000\u01dd\u01dc\u0001\u0000\u0000"
            + "\u0000\u01dd\u01de\u0001\u0000\u0000\u0000\u01de\u01fe\u0001\u0000\u0000"
            + "\u0000\u01df\u01e0\u0005u\u0000\u0000\u01e0\u01e1\u0005\u00a1\u0000\u0000"
            + "\u01e1\u01e2\u0005\u0191\u0000\u0000\u01e2\u01e7\u0003\u00dam\u0000\u01e3"
            + "\u01e4\u0005\u0182\u0000\u0000\u01e4\u01e6\u0003\u00dam\u0000\u01e5\u01e3"
            + "\u0001\u0000\u0000\u0000\u01e6\u01e9\u0001\u0000\u0000\u0000\u01e7\u01e5"
            + "\u0001\u0000\u0000\u0000\u01e7\u01e8\u0001\u0000\u0000\u0000\u01e8\u01ea"
            + "\u0001\u0000\u0000\u0000\u01e9\u01e7\u0001\u0000\u0000\u0000\u01ea\u01eb"
            + "\u0005\u0194\u0000\u0000\u01eb\u01ec\u0005\u00ef\u0000\u0000\u01ec\u01ed"
            + "\u0003\u00d8l\u0000\u01ed\u01ee\u0005\u0191\u0000\u0000\u01ee\u01f3\u0003"
            + "\u00dam\u0000\u01ef\u01f0\u0005\u0182\u0000\u0000\u01f0\u01f2\u0003\u00da"
            + "m\u0000\u01f1\u01ef\u0001\u0000\u0000\u0000\u01f2\u01f5\u0001\u0000\u0000"
            + "\u0000\u01f3\u01f1\u0001\u0000\u0000\u0000\u01f3\u01f4\u0001\u0000\u0000"
            + "\u0000\u01f4\u01f6\u0001\u0000\u0000\u0000\u01f5\u01f3\u0001\u0000\u0000"
            + "\u0000\u01f6\u01fa\u0005\u0194\u0000\u0000\u01f7\u01f9\u0003\"\u0011\u0000"
            + "\u01f8\u01f7\u0001\u0000\u0000\u0000\u01f9\u01fc\u0001\u0000\u0000\u0000"
            + "\u01fa\u01f8\u0001\u0000\u0000\u0000\u01fa\u01fb\u0001\u0000\u0000\u0000"
            + "\u01fb\u01fe\u0001\u0000\u0000\u0000\u01fc\u01fa\u0001\u0000\u0000\u0000"
            + "\u01fd\u01c7\u0001\u0000\u0000\u0000\u01fd\u01df\u0001\u0000\u0000\u0000"
            + "\u01fe!\u0001\u0000\u0000\u0000\u01ff\u0200\u0005\u00cd\u0000\u0000\u0200"
            + "\u0209\u0007\u0002\u0000\u0000\u0201\u0202\u0005\u00c1\u0000\u0000\u0202"
            + "\u020a\u0005\u0002\u0000\u0000\u0203\u020a\u0005\u00f4\u0000\u0000\u0204"
            + "\u0205\u0005\u010f\u0000\u0000\u0205\u020a\u0005\u00c8\u0000\u0000\u0206"
            + "\u0207\u0005\u010f\u0000\u0000\u0207\u020a\u0005K\u0000\u0000\u0208\u020a"
            + "\u0005 \u0000\u0000\u0209\u0201\u0001\u0000\u0000\u0000\u0209\u0203\u0001"
            + "\u0000\u0000\u0000\u0209\u0204\u0001\u0000\u0000\u0000\u0209\u0206\u0001"
            + "\u0000\u0000\u0000\u0209\u0208\u0001\u0000\u0000\u0000\u020a#\u0001\u0000"
            + "\u0000\u0000\u020b\u020d\u0003&\u0013\u0000\u020c\u020b\u0001\u0000\u0000"
            + "\u0000\u020d\u020e\u0001\u0000\u0000\u0000\u020e\u020c\u0001\u0000\u0000"
            + "\u0000\u020e\u020f\u0001\u0000\u0000\u0000\u020f%\u0001\u0000\u0000\u0000"
            + "\u0210\u0211\u0005\u0182\u0000\u0000\u0211\u0212\u0003(\u0014\u0000\u0212"
            + "\'\u0001\u0000\u0000\u0000\u0213\u0215\u0005\u00c1\u0000\u0000\u0214\u0213"
            + "\u0001\u0000\u0000\u0000\u0214\u0215\u0001\u0000\u0000\u0000\u0215\u0216"
            + "\u0001\u0000\u0000\u0000\u0216\u0217\u0007\u0003\u0000\u0000\u0217)\u0001"
            + "\u0000\u0000\u0000\u0218\u021a\u0003,\u0016\u0000\u0219\u0218\u0001\u0000"
            + "\u0000\u0000\u021a\u021b\u0001\u0000\u0000\u0000\u021b\u0219\u0001\u0000"
            + "\u0000\u0000\u021b\u021c\u0001\u0000\u0000\u0000\u021c+\u0001\u0000\u0000"
            + "\u0000\u021d\u021e\u0005\u00cd\u0000\u0000\u021e\u021f\u00051\u0000\u0000"
            + "\u021f\u0220\u0007\u0004\u0000\u0000\u0220\u0223\u0005\u0100\u0000\u0000"
            + "\u0221\u0223\u0003.\u0017\u0000\u0222\u021d\u0001\u0000\u0000\u0000\u0222"
            + "\u0221\u0001\u0000\u0000\u0000\u0223-\u0001\u0000\u0000\u0000\u0224\u0226"
            + "\u0005\u000f\u0000\u0000\u0225\u0227\u0005\u0187\u0000\u0000\u0226\u0225"
            + "\u0001\u0000\u0000\u0000\u0226\u0227\u0001\u0000\u0000\u0000\u0227\u0228"
            + "\u0001\u0000\u0000\u0000\u0228\u0240\u0003\u00b2Y\u0000\u0229\u022b\u0005"
            + ".\u0000\u0000\u022a\u022c\u0005\u0187\u0000\u0000\u022b\u022a\u0001\u0000"
            + "\u0000\u0000\u022b\u022c\u0001\u0000\u0000\u0000\u022c\u022d\u0001\u0000"
            + "\u0000\u0000\u022d\u0240\u0003\u00b2Y\u0000\u022e\u0230\u0005K\u0000\u0000"
            + "\u022f\u022e\u0001\u0000\u0000\u0000\u022f\u0230\u0001\u0000\u0000\u0000"
            + "\u0230\u0234\u0001\u0000\u0000\u0000\u0231\u0232\u0005%\u0000\u0000\u0232"
            + "\u0235\u0005\u010f\u0000\u0000\u0233\u0235\u0005&\u0000\u0000\u0234\u0231"
            + "\u0001\u0000\u0000\u0000\u0234\u0233\u0001\u0000\u0000\u0000\u0235\u0237"
            + "\u0001\u0000\u0000\u0000\u0236\u0238\u0005\u0187\u0000\u0000\u0237\u0236"
            + "\u0001\u0000\u0000\u0000\u0237\u0238\u0001\u0000\u0000\u0000\u0238\u0239"
            + "\u0001\u0000\u0000\u0000\u0239\u0240\u0003\u00b2Y\u0000\u023a\u023c\u0005"
            + "d\u0000\u0000\u023b\u023d\u0005\u0187\u0000\u0000\u023c\u023b\u0001\u0000"
            + "\u0000\u0000\u023c\u023d\u0001\u0000\u0000\u0000\u023d\u023e\u0001\u0000"
            + "\u0000\u0000\u023e\u0240\u0003\u00b2Y\u0000\u023f\u0224\u0001\u0000\u0000"
            + "\u0000\u023f\u0229\u0001\u0000\u0000\u0000\u023f\u022f\u0001\u0000\u0000"
            + "\u0000\u023f\u023a\u0001\u0000\u0000\u0000\u0240/\u0001\u0000\u0000\u0000"
            + "\u0241\u0243\u0005\u0181\u0000\u0000\u0242\u0241\u0001\u0000\u0000\u0000"
            + "\u0242\u0243\u0001\u0000\u0000\u0000\u0243\u0244\u0001\u0000\u0000\u0000"
            + "\u0244\u0245\u0005\u0187\u0000\u0000\u0245\u024e\u0003\u00b2Y\u0000\u0246"
            + "\u0248\u0005\u0150\u0000\u0000\u0247\u0246\u0001\u0000\u0000\u0000\u0247"
            + "\u0248\u0001\u0000\u0000\u0000\u0248\u0249\u0001\u0000\u0000\u0000\u0249"
            + "\u024b\u0005K\u0000\u0000\u024a\u024c\u0003\u00b2Y\u0000\u024b\u024a\u0001"
            + "\u0000\u0000\u0000\u024b\u024c\u0001\u0000\u0000\u0000\u024c\u024e\u0001"
            + "\u0000\u0000\u0000\u024d\u0242\u0001\u0000\u0000\u0000\u024d\u0247\u0001"
            + "\u0000\u0000\u0000\u024e1\u0001\u0000\u0000\u0000\u024f\u0250\u0005\u0113"
            + "\u0000\u0000\u0250\u0251\u0005\u0130\u0000\u0000\u02513\u0001\u0000\u0000"
            + "\u0000\u0252\u0254\u0005\u00c6\u0000\u0000\u0253\u0252\u0001\u0000\u0000"
            + "\u0000\u0253\u0254\u0001\u0000\u0000\u0000\u0254\u0255\u0001\u0000\u0000"
            + "\u0000\u0255\u025e\u0005\u00c8\u0000\u0000\u0256\u0257\u0005%\u0000\u0000"
            + "\u0257\u0258\u0005\u010f\u0000\u0000\u0258\u025e\u0003\u00e0p\u0000\u0259"
            + "\u025b\u0005\u00c6\u0000\u0000\u025a\u0259\u0001\u0000\u0000\u0000\u025a"
            + "\u025b\u0001\u0000\u0000\u0000\u025b\u025c\u0001\u0000\u0000\u0000\u025c"
            + "\u025e\u0007\u0005\u0000\u0000\u025d\u0253\u0001\u0000\u0000\u0000\u025d"
            + "\u0256\u0001\u0000\u0000\u0000\u025d\u025a\u0001\u0000\u0000\u0000\u025e"
            + "5\u0001\u0000\u0000\u0000\u025f\u027b\u0005E\u0000\u0000\u0260\u027b\u0005"
            + "[\u0000\u0000\u0261\u027b\u0005s\u0000\u0000\u0262\u027b\u0005\u0092\u0000"
            + "\u0000\u0263\u027b\u0005\u0096\u0000\u0000\u0264\u027b\u0005\u0127\u0000"
            + "\u0000\u0265\u027b\u0005\u0137\u0000\u0000\u0266\u027b\u0005\u0171\u0000"
            + "\u0000\u0267\u027b\u0005\u0172\u0000\u0000\u0268\u027b\u0005\u0173\u0000"
            + "\u0000\u0269\u027b\u0005\u0174\u0000\u0000\u026a\u027b\u0005\u0175\u0000"
            + "\u0000\u026b\u027b\u0005\u0176\u0000\u0000\u026c\u027b\u0005\u0177\u0000"
            + "\u0000\u026d\u027b\u0005\u0178\u0000\u0000\u026e\u027b\u0005\u0179\u0000"
            + "\u0000\u026f\u027b\u0005\u017a\u0000\u0000\u0270\u027b\u0005\u017b\u0000"
            + "\u0000\u0271\u027b\u0005\u017c\u0000\u0000\u0272\u027b\u0005\u017d\u0000"
            + "\u0000\u0273\u027b\u0005\u017e\u0000\u0000\u0274\u027b\u0005\u017f\u0000"
            + "\u0000\u0275\u0278\u0003\u00e0p\u0000\u0276\u0277\u0005\u0001\u0000\u0000"
            + "\u0277\u0279\u0007\u0006\u0000\u0000\u0278\u0276\u0001\u0000\u0000\u0000"
            + "\u0278\u0279\u0001\u0000\u0000\u0000\u0279\u027b\u0001\u0000\u0000\u0000"
            + "\u027a\u025f\u0001\u0000\u0000\u0000\u027a\u0260\u0001\u0000\u0000\u0000"
            + "\u027a\u0261\u0001\u0000\u0000\u0000\u027a\u0262\u0001\u0000\u0000\u0000"
            + "\u027a\u0263\u0001\u0000\u0000\u0000\u027a\u0264\u0001\u0000\u0000\u0000"
            + "\u027a\u0265\u0001\u0000\u0000\u0000\u027a\u0266\u0001\u0000\u0000\u0000"
            + "\u027a\u0267\u0001\u0000\u0000\u0000\u027a\u0268\u0001\u0000\u0000\u0000"
            + "\u027a\u0269\u0001\u0000\u0000\u0000\u027a\u026a\u0001\u0000\u0000\u0000"
            + "\u027a\u026b\u0001\u0000\u0000\u0000\u027a\u026c\u0001\u0000\u0000\u0000"
            + "\u027a\u026d\u0001\u0000\u0000\u0000\u027a\u026e\u0001\u0000\u0000\u0000"
            + "\u027a\u026f\u0001\u0000\u0000\u0000\u027a\u0270\u0001\u0000\u0000\u0000"
            + "\u027a\u0271\u0001\u0000\u0000\u0000\u027a\u0272\u0001\u0000\u0000\u0000"
            + "\u027a\u0273\u0001\u0000\u0000\u0000\u027a\u0274\u0001\u0000\u0000\u0000"
            + "\u027a\u0275\u0001\u0000\u0000\u0000\u027b7\u0001\u0000\u0000\u0000\u027c"
            + "\u027d\u0005\u0191\u0000\u0000\u027d\u027f\u0007\u0007\u0000\u0000\u027e"
            + "\u0280\u0007\b\u0000\u0000\u027f\u027e\u0001\u0000\u0000\u0000\u027f\u0280"
            + "\u0001\u0000\u0000\u0000\u0280\u0283\u0001\u0000\u0000\u0000\u0281\u0282"
            + "\u0005\u0182\u0000\u0000\u0282\u0284\u0005\u019b\u0000\u0000\u0283\u0281"
            + "\u0001\u0000\u0000\u0000\u0283\u0284\u0001\u0000\u0000\u0000\u0284\u0285"
            + "\u0001\u0000\u0000\u0000\u0285\u0286\u0005\u0194\u0000\u0000\u02869\u0001"
            + "\u0000\u0000\u0000\u0287\u0288\u0005:\u0000\u0000\u0288\u028c\u0007\t"
            + "\u0000\u0000\u0289\u028a\u0005\u0087\u0000\u0000\u028a\u028b\u0005\u00c6"
            + "\u0000\u0000\u028b\u028d\u0005k\u0000\u0000\u028c\u0289\u0001\u0000\u0000"
            + "\u0000\u028c\u028d\u0001\u0000\u0000\u0000\u028d\u028e\u0001\u0000\u0000"
            + "\u0000\u028e\u0292\u0005\u0198\u0000\u0000\u028f\u0291\u0003@ \u0000\u0290"
            + "\u028f\u0001\u0000\u0000\u0000\u0291\u0294\u0001\u0000\u0000\u0000\u0292"
            + "\u0290\u0001\u0000\u0000\u0000\u0292\u0293\u0001\u0000\u0000\u0000\u0293"
            + ";\u0001\u0000\u0000\u0000\u0294\u0292\u0001\u0000\u0000\u0000\u0295\u0296"
            + "\u0005\u0113\u0000\u0000\u0296\u0297\u0005B\u0000\u0000\u0297=\u0001\u0000"
            + "\u0000\u0000\u0298\u0299\u0005]\u0000\u0000\u0299\u029c\u0007\t\u0000"
            + "\u0000\u029a\u029b\u0005\u0087\u0000\u0000\u029b\u029d\u0005k\u0000\u0000"
            + "\u029c\u029a\u0001\u0000\u0000\u0000\u029c\u029d\u0001\u0000\u0000\u0000"
            + "\u029d\u029e\u0001\u0000\u0000\u0000\u029e\u029f\u0005\u0198\u0000\u0000"
            + "\u029f?\u0001\u0000\u0000\u0000\u02a0\u02a1\u0005.\u0000\u0000\u02a1\u02a5"
            + "\u0003\u00b2Y\u0000\u02a2\u02a3\u0005\u00ac\u0000\u0000\u02a3\u02a5\u0003"
            + "\u00b2Y\u0000\u02a4\u02a0\u0001\u0000\u0000\u0000\u02a4\u02a2\u0001\u0000"
            + "\u0000\u0000\u02a5A\u0001\u0000\u0000\u0000\u02a6\u02a7\u0005]\u0000\u0000"
            + "\u02a7\u02aa\u0005\u012d\u0000\u0000\u02a8\u02a9\u0005\u0087\u0000\u0000"
            + "\u02a9\u02ab\u0005k\u0000\u0000\u02aa\u02a8\u0001\u0000\u0000\u0000\u02aa"
            + "\u02ab\u0001\u0000\u0000\u0000\u02ab\u02ac\u0001\u0000\u0000\u0000\u02ac"
            + "\u02ad\u0003\u0080@\u0000\u02adC\u0001\u0000\u0000\u0000\u02ae\u02b5\u0005"
            + "\u0091\u0000\u0000\u02af\u02b0\u0005\u00d5\u0000\u0000\u02b0\u02b6\u0005"
            + "\u012d\u0000\u0000\u02b1\u02b3\u0005\u0099\u0000\u0000\u02b2\u02b4\u0005"
            + "\u012d\u0000\u0000\u02b3\u02b2\u0001\u0000\u0000\u0000\u02b3\u02b4\u0001"
            + "\u0000\u0000\u0000\u02b4\u02b6\u0001\u0000\u0000\u0000\u02b5\u02af\u0001"
            + "\u0000\u0000\u0000\u02b5\u02b1\u0001\u0000\u0000\u0000\u02b6\u02b7\u0001"
            + "\u0000\u0000\u0000\u02b7\u02b9\u0003\u0080@\u0000\u02b8\u02ba\u0003F#"
            + "\u0000\u02b9\u02b8\u0001\u0000\u0000\u0000\u02b9\u02ba\u0001\u0000\u0000"
            + "\u0000\u02ba\u02bd\u0001\u0000\u0000\u0000\u02bb\u02be\u0003P(\u0000\u02bc"
            + "\u02be\u0003H$\u0000\u02bd\u02bb\u0001\u0000\u0000\u0000\u02bd\u02bc\u0001"
            + "\u0000\u0000\u0000\u02beE\u0001\u0000\u0000\u0000\u02bf\u02c0\u0005\u0191"
            + "\u0000\u0000\u02c0\u02c5\u0003\u00e0p\u0000\u02c1\u02c2\u0005\u0182\u0000"
            + "\u0000\u02c2\u02c4\u0003\u00e0p\u0000\u02c3\u02c1\u0001\u0000\u0000\u0000"
            + "\u02c4\u02c7\u0001\u0000\u0000\u0000\u02c5\u02c3\u0001\u0000\u0000\u0000"
            + "\u02c5\u02c6\u0001\u0000\u0000\u0000\u02c6\u02c8\u0001\u0000\u0000\u0000"
            + "\u02c7\u02c5\u0001\u0000\u0000\u0000\u02c8\u02c9\u0005\u0194\u0000\u0000"
            + "\u02c9G\u0001\u0000\u0000\u0000\u02ca\u02cb\u0005\u0147\u0000\u0000\u02cb"
            + "\u02d0\u0003J%\u0000\u02cc\u02cd\u0005\u0182\u0000\u0000\u02cd\u02cf\u0003"
            + "J%\u0000\u02ce\u02cc\u0001\u0000\u0000\u0000\u02cf\u02d2\u0001\u0000\u0000"
            + "\u0000\u02d0\u02ce\u0001\u0000\u0000\u0000\u02d0\u02d1\u0001\u0000\u0000"
            + "\u0000\u02d1I\u0001\u0000\u0000\u0000\u02d2\u02d0\u0001\u0000\u0000\u0000"
            + "\u02d3\u02d4\u0005\u0191\u0000\u0000\u02d4\u02d9\u0003\u00b2Y\u0000\u02d5"
            + "\u02d6\u0005\u0182\u0000\u0000\u02d6\u02d8\u0003\u00b2Y\u0000\u02d7\u02d5"
            + "\u0001\u0000\u0000\u0000\u02d8\u02db\u0001\u0000\u0000\u0000\u02d9\u02d7"
            + "\u0001\u0000\u0000\u0000\u02d9\u02da\u0001\u0000\u0000\u0000\u02da\u02dc"
            + "\u0001\u0000\u0000\u0000\u02db\u02d9\u0001\u0000\u0000\u0000\u02dc\u02dd"
            + "\u0005\u0194\u0000\u0000\u02ddK\u0001\u0000\u0000\u0000\u02de\u02e0\u0005"
            + "\u013e\u0000\u0000\u02df\u02e1\u0005\u012d\u0000\u0000\u02e0\u02df\u0001"
            + "\u0000\u0000\u0000\u02e0\u02e1\u0001\u0000\u0000\u0000\u02e1\u02e2\u0001"
            + "\u0000\u0000\u0000\u02e2\u02e3\u0003\u00e0p\u0000\u02e3M\u0001\u0000\u0000"
            + "\u0000\u02e4\u02e5\u0005\u0144\u0000\u0000\u02e5\u02e6\u0007\n\u0000\u0000"
            + "\u02e6O\u0001\u0000\u0000\u0000\u02e7\u02e9\u0003R)\u0000\u02e8\u02e7"
            + "\u0001\u0000\u0000\u0000\u02e8\u02e9\u0001\u0000\u0000\u0000\u02e9\u02ea"
            + "\u0001\u0000\u0000\u0000\u02ea\u02eb\u0003X,\u0000\u02ebQ\u0001\u0000"
            + "\u0000\u0000\u02ec\u02ed\u0005\u0150\u0000\u0000\u02ed\u02f2\u0003T*\u0000"
            + "\u02ee\u02ef\u0005\u0182\u0000\u0000\u02ef\u02f1\u0003T*\u0000\u02f0\u02ee"
            + "\u0001\u0000\u0000\u0000\u02f1\u02f4\u0001\u0000\u0000\u0000\u02f2\u02f0"
            + "\u0001\u0000\u0000\u0000\u02f2\u02f3\u0001\u0000\u0000\u0000\u02f3S\u0001"
            + "\u0000\u0000\u0000\u02f4\u02f2\u0001\u0000\u0000\u0000\u02f5\u02f7\u0003"
            + "\u00e0p\u0000\u02f6\u02f8\u0003V+\u0000\u02f7\u02f6\u0001\u0000\u0000"
            + "\u0000\u02f7\u02f8\u0001\u0000\u0000\u0000\u02f8\u02f9\u0001\u0000\u0000"
            + "\u0000\u02f9\u02fa\u0005\n\u0000\u0000\u02fa\u02fb\u0005\u0191\u0000\u0000"
            + "\u02fb\u02fc\u0003X,\u0000\u02fc\u02fd\u0005\u0194\u0000\u0000\u02fdU"
            + "\u0001\u0000\u0000\u0000\u02fe\u02ff\u0005\u0191\u0000\u0000\u02ff\u0304"
            + "\u0003\u00e0p\u0000\u0300\u0301\u0005\u0182\u0000\u0000\u0301\u0303\u0003"
            + "\u00e0p\u0000\u0302\u0300\u0001\u0000\u0000\u0000\u0303\u0306\u0001\u0000"
            + "\u0000\u0000\u0304\u0302\u0001\u0000\u0000\u0000\u0304\u0305\u0001\u0000"
            + "\u0000\u0000\u0305\u0307\u0001\u0000\u0000\u0000\u0306\u0304\u0001\u0000"
            + "\u0000\u0000\u0307\u0308\u0005\u0194\u0000\u0000\u0308W\u0001\u0000\u0000"
            + "\u0000\u0309\u030f\u0003Z-\u0000\u030a\u030b\u0003\\.\u0000\u030b\u030c"
            + "\u0003Z-\u0000\u030c\u030e\u0001\u0000\u0000\u0000\u030d\u030a\u0001\u0000"
            + "\u0000\u0000\u030e\u0311\u0001\u0000\u0000\u0000\u030f\u030d\u0001\u0000"
            + "\u0000\u0000\u030f\u0310\u0001\u0000\u0000\u0000\u0310\u0317\u0001\u0000"
            + "\u0000\u0000\u0311\u030f\u0001\u0000\u0000\u0000\u0312\u0313\u0005\u0191"
            + "\u0000\u0000\u0313\u0314\u0003X,\u0000\u0314\u0315\u0005\u0194\u0000\u0000"
            + "\u0315\u0317\u0001\u0000\u0000\u0000\u0316\u0309\u0001\u0000\u0000\u0000"
            + "\u0316\u0312\u0001\u0000\u0000\u0000\u0317Y\u0001\u0000\u0000\u0000\u0318"
            + "\u031e\u0003^/\u0000\u0319\u031a\u0005\u0191\u0000\u0000\u031a\u031b\u0003"
            + "X,\u0000\u031b\u031c\u0005\u0194\u0000\u0000\u031c\u031e\u0001\u0000\u0000"
            + "\u0000\u031d\u0318\u0001\u0000\u0000\u0000\u031d\u0319\u0001\u0000\u0000"
            + "\u0000\u031e[\u0001\u0000\u0000\u0000\u031f\u0321\u0005\u0140\u0000\u0000"
            + "\u0320\u0322\u0005\u0004\u0000\u0000\u0321\u0320\u0001\u0000\u0000\u0000"
            + "\u0321\u0322\u0001\u0000\u0000\u0000\u0322\u032c\u0001\u0000\u0000\u0000"
            + "\u0323\u0325\u0005f\u0000\u0000\u0324\u0326\u0005\u0004\u0000\u0000\u0325"
            + "\u0324\u0001\u0000\u0000\u0000\u0325\u0326\u0001\u0000\u0000\u0000\u0326"
            + "\u032c\u0001\u0000\u0000\u0000\u0327\u0329\u0005\u0097\u0000\u0000\u0328"
            + "\u032a\u0005\u0004\u0000\u0000\u0329\u0328\u0001\u0000\u0000\u0000\u0329"
            + "\u032a\u0001\u0000\u0000\u0000\u032a\u032c\u0001\u0000\u0000\u0000\u032b"
            + "\u031f\u0001\u0000\u0000\u0000\u032b\u0323\u0001\u0000\u0000\u0000\u032b"
            + "\u0327\u0001\u0000\u0000\u0000\u032c]\u0001\u0000\u0000\u0000\u032d\u032e"
            + "\u0007\u000b\u0000\u0000\u032e\u0330\u0003`0\u0000\u032f\u0331\u0003l"
            + "6\u0000\u0330\u032f\u0001\u0000\u0000\u0000\u0330\u0331\u0001\u0000\u0000"
            + "\u0000\u0331\u0333\u0001\u0000\u0000\u0000\u0332\u0334\u0003n7\u0000\u0333"
            + "\u0332\u0001\u0000\u0000\u0000\u0333\u0334\u0001\u0000\u0000\u0000\u0334"
            + "\u0336\u0001\u0000\u0000\u0000\u0335\u0337\u0003\u0082A\u0000\u0336\u0335"
            + "\u0001\u0000\u0000\u0000\u0336\u0337\u0001\u0000\u0000\u0000\u0337\u0339"
            + "\u0001\u0000\u0000\u0000\u0338\u033a\u0003\u0084B\u0000\u0339\u0338\u0001"
            + "\u0000\u0000\u0000\u0339\u033a\u0001\u0000\u0000\u0000\u033a\u033d\u0001"
            + "\u0000\u0000\u0000\u033b\u033e\u0003\u0086C\u0000\u033c\u033e\u0003\u0088"
            + "D\u0000\u033d\u033b\u0001\u0000\u0000\u0000\u033d\u033c\u0001\u0000\u0000"
            + "\u0000\u033d\u033e\u0001\u0000\u0000\u0000\u033e\u0340\u0001\u0000\u0000"
            + "\u0000\u033f\u0341\u0003\u008aE\u0000\u0340\u033f\u0001\u0000\u0000\u0000"
            + "\u0340\u0341\u0001\u0000\u0000\u0000\u0341\u0343\u0001\u0000\u0000\u0000"
            + "\u0342\u0344\u0003\u0090H\u0000\u0343\u0342\u0001\u0000\u0000\u0000\u0343"
            + "\u0344\u0001\u0000\u0000\u0000\u0344_\u0001\u0000\u0000\u0000\u0345\u0347"
            + "\u0003b1\u0000\u0346\u0345\u0001\u0000\u0000\u0000\u0346\u0347\u0001\u0000"
            + "\u0000\u0000\u0347\u0349\u0001\u0000\u0000\u0000\u0348\u034a\u0003d2\u0000"
            + "\u0349\u0348\u0001\u0000\u0000\u0000\u0349\u034a\u0001\u0000\u0000\u0000"
            + "\u034a\u034b\u0001\u0000\u0000\u0000\u034b\u0350\u0003f3\u0000\u034c\u034d"
            + "\u0005\u0182\u0000\u0000\u034d\u034f\u0003f3\u0000\u034e\u034c\u0001\u0000"
            + "\u0000\u0000\u034f\u0352\u0001\u0000\u0000\u0000\u0350\u034e\u0001\u0000"
            + "\u0000\u0000\u0350\u0351\u0001\u0000\u0000\u0000\u0351a\u0001\u0000\u0000"
            + "\u0000\u0352\u0350\u0001\u0000\u0000\u0000\u0353\u0354\u0007\f\u0000\u0000"
            + "\u0354c\u0001\u0000\u0000\u0000\u0355\u0356\u0005\u013b\u0000\u0000\u0356"
            + "\u0357\u0003\u00b2Y\u0000\u0357e\u0001\u0000\u0000\u0000\u0358\u0359\u0003"
            + "\u00e0p\u0000\u0359\u035a\u0005\u0187\u0000\u0000\u035a\u035c\u0001\u0000"
            + "\u0000\u0000\u035b\u0358\u0001\u0000\u0000\u0000\u035b\u035c\u0001\u0000"
            + "\u0000\u0000\u035c\u035d\u0001\u0000\u0000\u0000\u035d\u035f\u0003\u00b2"
            + "Y\u0000\u035e\u0360\u0003h4\u0000\u035f\u035e\u0001\u0000\u0000\u0000"
            + "\u035f\u0360\u0001\u0000\u0000\u0000\u0360\u0363\u0001\u0000\u0000\u0000"
            + "\u0361\u0363\u0003j5\u0000\u0362\u035b\u0001\u0000\u0000\u0000\u0362\u0361"
            + "\u0001\u0000\u0000\u0000\u0363g\u0001\u0000\u0000\u0000\u0364\u0366\u0005"
            + "\n\u0000\u0000\u0365\u0364\u0001\u0000\u0000\u0000\u0365\u0366\u0001\u0000"
            + "\u0000\u0000\u0366\u0367\u0001\u0000\u0000\u0000\u0367\u037b\u0003\u00e0"
            + "p\u0000\u0368\u036a\u0005\n\u0000\u0000\u0369\u0368\u0001\u0000\u0000"
            + "\u0000\u0369\u036a\u0001\u0000\u0000\u0000\u036a\u036b\u0001\u0000\u0000"
            + "\u0000\u036b\u036c\u0005\u0191\u0000\u0000\u036c\u0371\u0003\u00e0p\u0000"
            + "\u036d\u036e\u0005\u0182\u0000\u0000\u036e\u0370\u0003\u00e0p\u0000\u036f"
            + "\u036d\u0001\u0000\u0000\u0000\u0370\u0373\u0001\u0000\u0000\u0000\u0371"
            + "\u036f\u0001\u0000\u0000\u0000\u0371\u0372\u0001\u0000\u0000\u0000\u0372"
            + "\u0374\u0001\u0000\u0000\u0000\u0373\u0371\u0001\u0000\u0000\u0000\u0374"
            + "\u0375\u0005\u0194\u0000\u0000\u0375\u037b\u0001\u0000\u0000\u0000\u0376"
            + "\u0377\u0005\u0191\u0000\u0000\u0377\u0378\u0005\u0139\u0000\u0000\u0378"
            + "\u0379\u0005\u0199\u0000\u0000\u0379\u037b\u0005\u0194\u0000\u0000\u037a"
            + "\u0365\u0001\u0000\u0000\u0000\u037a\u0369\u0001\u0000\u0000\u0000\u037a"
            + "\u0376\u0001\u0000\u0000\u0000\u037bi\u0001\u0000\u0000\u0000\u037c\u037d"
            + "\u0005\u0198\u0000\u0000\u037d\u037f\u0005\u0185\u0000\u0000\u037e\u037c"
            + "\u0001\u0000\u0000\u0000\u037e\u037f\u0001\u0000\u0000\u0000\u037f\u0380"
            + "\u0001\u0000\u0000\u0000\u0380\u0381\u0005\u018f\u0000\u0000\u0381k\u0001"
            + "\u0000\u0000\u0000\u0382\u0383\u0005\u0099\u0000\u0000\u0383\u0388\u0003"
            + "\u00e0p\u0000\u0384\u0385\u0005\u0182\u0000\u0000\u0385\u0387\u0003\u00e0"
            + "p\u0000\u0386\u0384\u0001\u0000\u0000\u0000\u0387\u038a\u0001\u0000\u0000"
            + "\u0000\u0388\u0386\u0001\u0000\u0000\u0000\u0388\u0389\u0001\u0000\u0000"
            + "\u0000\u0389m\u0001\u0000\u0000\u0000\u038a\u0388\u0001\u0000\u0000\u0000"
            + "\u038b\u038c\u0005x\u0000\u0000\u038c\u0390\u0003p8\u0000\u038d\u038f"
            + "\u0003v;\u0000\u038e\u038d\u0001\u0000\u0000\u0000\u038f\u0392\u0001\u0000"
            + "\u0000\u0000\u0390\u038e\u0001\u0000\u0000\u0000\u0390\u0391\u0001\u0000"
            + "\u0000\u0000\u0391o\u0001\u0000\u0000\u0000\u0392\u0390\u0001\u0000\u0000"
            + "\u0000\u0393\u0397\u0003r9\u0000\u0394\u0397\u0003t:\u0000\u0395\u0397"
            + "\u0003z=\u0000\u0396\u0393\u0001\u0000\u0000\u0000\u0396\u0394\u0001\u0000"
            + "\u0000\u0000\u0396\u0395\u0001\u0000\u0000\u0000\u0397q\u0001\u0000\u0000"
            + "\u0000\u0398\u039a\u0003\u0080@\u0000\u0399\u039b\u0003~?\u0000\u039a"
            + "\u0399\u0001\u0000\u0000\u0000\u039a\u039b\u0001\u0000\u0000\u0000\u039b"
            + "\u039d\u0001\u0000\u0000\u0000\u039c\u039e\u0003\u008eG\u0000\u039d\u039c"
            + "\u0001\u0000\u0000\u0000\u039d\u039e\u0001\u0000\u0000\u0000\u039es\u0001"
            + "\u0000\u0000\u0000\u039f\u03a0\u0005\u0191\u0000\u0000\u03a0\u03a1\u0003"
            + "P(\u0000\u03a1\u03a3\u0005\u0194\u0000\u0000\u03a2\u03a4\u0003~?\u0000"
            + "\u03a3\u03a2\u0001\u0000\u0000\u0000\u03a3\u03a4\u0001\u0000\u0000\u0000"
            + "\u03a4u\u0001\u0000\u0000\u0000\u03a5\u03a6\u0005\u0182\u0000\u0000\u03a6"
            + "\u03ad\u0003p8\u0000\u03a7\u03a8\u0003x<\u0000\u03a8\u03a9\u0003p8\u0000"
            + "\u03a9\u03aa\u0005\u00cd\u0000\u0000\u03aa\u03ab\u0003\u00a2Q\u0000\u03ab"
            + "\u03ad\u0001\u0000\u0000\u0000\u03ac\u03a5\u0001\u0000\u0000\u0000\u03ac"
            + "\u03a7\u0001\u0000\u0000\u0000\u03adw\u0001\u0000\u0000\u0000\u03ae\u03b0"
            + "\u0005\u008f\u0000\u0000\u03af\u03ae\u0001\u0000\u0000\u0000\u03af\u03b0"
            + "\u0001\u0000\u0000\u0000\u03b0\u03b1\u0001\u0000\u0000\u0000\u03b1\u03b8"
            + "\u0005\u009e\u0000\u0000\u03b2\u03b4\u0007\r\u0000\u0000\u03b3\u03b5\u0005"
            + "\u00d3\u0000\u0000\u03b4\u03b3\u0001\u0000\u0000\u0000\u03b4\u03b5\u0001"
            + "\u0000\u0000\u0000\u03b5\u03b6\u0001\u0000\u0000\u0000\u03b6\u03b8\u0005"
            + "\u009e\u0000\u0000\u03b7\u03af\u0001\u0000\u0000\u0000\u03b7\u03b2\u0001"
            + "\u0000\u0000\u0000\u03b8y\u0001\u0000\u0000\u0000\u03b9\u03ba\u0005\u012d"
            + "\u0000\u0000\u03ba\u03bb\u0005\u0191\u0000\u0000\u03bb\u03bc\u0005\u0147"
            + "\u0000\u0000\u03bc\u03c1\u0003|>\u0000\u03bd\u03be\u0005\u0182\u0000\u0000"
            + "\u03be\u03c0\u0003|>\u0000\u03bf\u03bd\u0001\u0000\u0000\u0000\u03c0\u03c3"
            + "\u0001\u0000\u0000\u0000\u03c1\u03bf\u0001\u0000\u0000\u0000\u03c1\u03c2"
            + "\u0001\u0000\u0000\u0000\u03c2\u03c4\u0001\u0000\u0000\u0000\u03c3\u03c1"
            + "\u0001\u0000\u0000\u0000\u03c4\u03c6\u0005\u0194\u0000\u0000\u03c5\u03c7"
            + "\u0003~?\u0000\u03c6\u03c5\u0001\u0000\u0000\u0000\u03c6\u03c7\u0001\u0000"
            + "\u0000\u0000\u03c7{\u0001\u0000\u0000\u0000\u03c8\u03d5\u0003\u00b2Y\u0000"
            + "\u03c9\u03ca\u0005\u0191\u0000\u0000\u03ca\u03cf\u0003\u00b2Y\u0000\u03cb"
            + "\u03cc\u0005\u0182\u0000\u0000\u03cc\u03ce\u0003\u00b2Y\u0000\u03cd\u03cb"
            + "\u0001\u0000\u0000\u0000\u03ce\u03d1\u0001\u0000\u0000\u0000\u03cf\u03cd"
            + "\u0001\u0000\u0000\u0000\u03cf\u03d0\u0001\u0000\u0000\u0000\u03d0\u03d2"
            + "\u0001\u0000\u0000\u0000\u03d1\u03cf\u0001\u0000\u0000\u0000\u03d2\u03d3"
            + "\u0005\u0194\u0000\u0000\u03d3\u03d5\u0001\u0000\u0000\u0000\u03d4\u03c8"
            + "\u0001\u0000\u0000\u0000\u03d4\u03c9\u0001\u0000\u0000\u0000\u03d5}\u0001"
            + "\u0000\u0000\u0000\u03d6\u03d8\u0004?\u0000\u0000\u03d7\u03d9\u0005\n"
            + "\u0000\u0000\u03d8\u03d7\u0001\u0000\u0000\u0000\u03d8\u03d9\u0001\u0000"
            + "\u0000\u0000\u03d9\u03da\u0001\u0000\u0000\u0000\u03da\u03e5\u0003\u00e0"
            + "p\u0000\u03db\u03dc\u0005\u0191\u0000\u0000\u03dc\u03e1\u0005\u0198\u0000"
            + "\u0000\u03dd\u03de\u0005\u0182\u0000\u0000\u03de\u03e0\u0005\u0198\u0000"
            + "\u0000\u03df\u03dd\u0001\u0000\u0000\u0000\u03e0\u03e3\u0001\u0000\u0000"
            + "\u0000\u03e1\u03df\u0001\u0000\u0000\u0000\u03e1\u03e2\u0001\u0000\u0000"
            + "\u0000\u03e2\u03e4\u0001\u0000\u0000\u0000\u03e3\u03e1\u0001\u0000\u0000"
            + "\u0000\u03e4\u03e6\u0005\u0194\u0000\u0000\u03e5\u03db\u0001\u0000\u0000"
            + "\u0000\u03e5\u03e6\u0001\u0000\u0000\u0000\u03e6\u007f\u0001\u0000\u0000"
            + "\u0000\u03e7\u03e8\u0003\u00e0p\u0000\u03e8\u0081\u0001\u0000\u0000\u0000"
            + "\u03e9\u03ea\u0005\u014e\u0000\u0000\u03ea\u03eb\u0003\u00a2Q\u0000\u03eb"
            + "\u0083\u0001\u0000\u0000\u0000\u03ec\u03ed\u0005\u0080\u0000\u0000\u03ed"
            + "\u03ee\u0005\u001c\u0000\u0000\u03ee\u03f3\u0003\u00b2Y\u0000\u03ef\u03f0"
            + "\u0005\u0182\u0000\u0000\u03f0\u03f2\u0003\u00b2Y\u0000\u03f1\u03ef\u0001"
            + "\u0000\u0000\u0000\u03f2\u03f5\u0001\u0000\u0000\u0000\u03f3\u03f1\u0001"
            + "\u0000\u0000\u0000\u03f3\u03f4\u0001\u0000\u0000\u0000\u03f4\u0085\u0001"
            + "\u0000\u0000\u0000\u03f5\u03f3\u0001\u0000\u0000\u0000\u03f6\u03f7\u0005"
            + "\u0083\u0000\u0000\u03f7\u03f8\u0003\u00a2Q\u0000\u03f8\u0087\u0001\u0000"
            + "\u0000\u0000\u03f9\u03fa\u0005\u00e9\u0000\u0000\u03fa\u03fb\u0003\u00a2"
            + "Q\u0000\u03fb\u0089\u0001\u0000\u0000\u0000\u03fc\u03fd\u0005\u00d1\u0000"
            + "\u0000\u03fd\u03fe\u0005\u001c\u0000\u0000\u03fe\u0403\u0003\u008cF\u0000"
            + "\u03ff\u0400\u0005\u0182\u0000\u0000\u0400\u0402\u0003\u008cF\u0000\u0401"
            + "\u03ff\u0001\u0000\u0000\u0000\u0402\u0405\u0001\u0000\u0000\u0000\u0403"
            + "\u0401\u0001\u0000\u0000\u0000\u0403\u0404\u0001\u0000\u0000\u0000\u0404"
            + "\u008b\u0001\u0000\u0000\u0000\u0405\u0403\u0001\u0000\u0000\u0000\u0406"
            + "\u0408\u0003\u00b2Y\u0000\u0407\u0409\u0007\u0001\u0000\u0000\u0408\u0407"
            + "\u0001\u0000\u0000\u0000\u0408\u0409\u0001\u0000\u0000\u0000\u0409\u008d"
            + "\u0001\u0000\u0000\u0000\u040a\u040b\u0005\u0107\u0000\u0000\u040b\u040c"
            + "\u0005\u0191\u0000\u0000\u040c\u040d\u0005\u019b\u0000\u0000\u040d\u040e"
            + "\u0005\u00dc\u0000\u0000\u040e\u040f\u0005\u0194\u0000\u0000\u040f\u008f"
            + "\u0001\u0000\u0000\u0000\u0410\u0412\u0003\u0092I\u0000\u0411\u0410\u0001"
            + "\u0000\u0000\u0000\u0412\u0413\u0001\u0000\u0000\u0000\u0413\u0411\u0001"
            + "\u0000\u0000\u0000\u0413\u0414\u0001\u0000\u0000\u0000\u0414\u0091\u0001"
            + "\u0000\u0000\u0000\u0415\u0416\u0005\u00a8\u0000\u0000\u0416\u0421\u0003"
            + "\u00b2Y\u0000\u0417\u0418\u0005\u0150\u0000\u0000\u0418\u041e\u0007\u000e"
            + "\u0000\u0000\u0419\u041a\u0005\u0144\u0000\u0000\u041a\u041b\u0005\u0007"
            + "\u0000\u0000\u041b\u041c\u0005\u009f\u0000\u0000\u041c\u041d\u0007\u000f"
            + "\u0000\u0000\u041d\u041f\u0005\u00af\u0000\u0000\u041e\u0419\u0001\u0000"
            + "\u0000\u0000\u041e\u041f\u0001\u0000\u0000\u0000\u041f\u0421\u0001\u0000"
            + "\u0000\u0000\u0420\u0415\u0001\u0000\u0000\u0000\u0420\u0417\u0001\u0000"
            + "\u0000\u0000\u0421\u0093\u0001\u0000\u0000\u0000\u0422\u0423\u0005\u0142"
            + "\u0000\u0000\u0423\u0424\u0003\u0098L\u0000\u0424\u0425\u0005\u010f\u0000"
            + "\u0000\u0425\u0427\u0003\u0096K\u0000\u0426\u0428\u0003\u0082A\u0000\u0427"
            + "\u0426\u0001\u0000\u0000\u0000\u0427\u0428\u0001\u0000\u0000\u0000\u0428"
            + "\u042a\u0001\u0000\u0000\u0000\u0429\u042b\u0003\u009aM\u0000\u042a\u0429"
            + "\u0001\u0000\u0000\u0000\u042a\u042b\u0001\u0000\u0000\u0000\u042b\u0095"
            + "\u0001\u0000\u0000\u0000\u042c\u0431\u0003\b\u0004\u0000\u042d\u042e\u0005"
            + "\u0182\u0000\u0000\u042e\u0430\u0003\b\u0004\u0000\u042f\u042d\u0001\u0000"
            + "\u0000\u0000\u0430\u0433\u0001\u0000\u0000\u0000\u0431\u042f\u0001\u0000"
            + "\u0000\u0000\u0431\u0432\u0001\u0000\u0000\u0000\u0432\u0097\u0001\u0000"
            + "\u0000\u0000\u0433\u0431\u0001\u0000\u0000\u0000\u0434\u0436\u0003\u0080"
            + "@\u0000\u0435\u0437\u0003n7\u0000\u0436\u0435\u0001\u0000\u0000\u0000"
            + "\u0436\u0437\u0001\u0000\u0000\u0000\u0437\u043d\u0001\u0000\u0000\u0000"
            + "\u0438\u0439\u0005\u0191\u0000\u0000\u0439\u043a\u0003P(\u0000\u043a\u043b"
            + "\u0005\u0194\u0000\u0000\u043b\u043d\u0001\u0000\u0000\u0000\u043c\u0434"
            + "\u0001\u0000\u0000\u0000\u043c\u0438\u0001\u0000\u0000\u0000\u043d\u0442"
            + "\u0001\u0000\u0000\u0000\u043e\u0440\u0005\n\u0000\u0000\u043f\u043e\u0001"
            + "\u0000\u0000\u0000\u043f\u0440\u0001\u0000\u0000\u0000\u0440\u0441\u0001"
            + "\u0000\u0000\u0000\u0441\u0443\u0003\u00e0p\u0000\u0442\u043f\u0001\u0000"
            + "\u0000\u0000\u0442\u0443\u0001\u0000\u0000\u0000\u0443\u0099\u0001\u0000"
            + "\u0000\u0000\u0444\u0445\u0005_\u0000\u0000\u0445\u0446\u0003D\"\u0000"
            + "\u0446\u009b\u0001\u0000\u0000\u0000\u0447\u0449\u0005P\u0000\u0000\u0448"
            + "\u044a\u0005x\u0000\u0000\u0449\u0448\u0001\u0000\u0000\u0000\u0449\u044a"
            + "\u0001\u0000\u0000\u0000\u044a\u044b\u0001\u0000\u0000\u0000\u044b\u044d"
            + "\u0003\u0080@\u0000\u044c\u044e\u0003\u009eO\u0000\u044d\u044c\u0001\u0000"
            + "\u0000\u0000\u044d\u044e\u0001\u0000\u0000\u0000\u044e\u0451\u0001\u0000"
            + "\u0000\u0000\u044f\u0452\u0003\u0082A\u0000\u0450\u0452\u0005\u0004\u0000"
            + "\u0000\u0451\u044f\u0001\u0000\u0000\u0000\u0451\u0450\u0001\u0000\u0000"
            + "\u0000\u0451\u0452\u0001\u0000\u0000\u0000\u0452\u009d\u0001\u0000\u0000"
            + "\u0000\u0453\u0455\u0004O\u0001\u0000\u0454\u0456\u0005\n\u0000\u0000"
            + "\u0455\u0454\u0001\u0000\u0000\u0000\u0455\u0456\u0001\u0000\u0000\u0000"
            + "\u0456\u0457\u0001\u0000\u0000\u0000\u0457\u0458\u0003\u00e0p\u0000\u0458"
            + "\u009f\u0001\u0000\u0000\u0000\u0459\u045b\u0007\u0010\u0000\u0000\u045a"
            + "\u045c\u0007\u0011\u0000\u0000\u045b\u045a\u0001\u0000\u0000\u0000\u045b"
            + "\u045c\u0001\u0000\u0000\u0000\u045c\u045d\u0001\u0000\u0000\u0000\u045d"
            + "\u045e\u0003\u0006\u0003\u0000\u045e\u00a1\u0001\u0000\u0000\u0000\u045f"
            + "\u0461\u0006Q\uffff\uffff\u0000\u0460\u0462\u0005\u00c6\u0000\u0000\u0461"
            + "\u0460\u0001\u0000\u0000\u0000\u0461\u0462\u0001\u0000\u0000\u0000\u0462"
            + "\u0463\u0001\u0000\u0000\u0000\u0463\u0464\u0005\u0191\u0000\u0000\u0464"
            + "\u0465\u0003\u00a2Q\u0000\u0465\u0466\u0005\u0194\u0000\u0000\u0466\u0469"
            + "\u0001\u0000\u0000\u0000\u0467\u0469\u0003\u00a4R\u0000\u0468\u045f\u0001"
            + "\u0000\u0000\u0000\u0468\u0467\u0001\u0000\u0000\u0000\u0469\u0470\u0001"
            + "\u0000\u0000\u0000\u046a\u046b\n\u0002\u0000\u0000\u046b\u046c\u0003\u00ae"
            + "W\u0000\u046c\u046d\u0003\u00a2Q\u0003\u046d\u046f\u0001\u0000\u0000\u0000"
            + "\u046e\u046a\u0001\u0000\u0000\u0000\u046f\u0472\u0001\u0000\u0000\u0000"
            + "\u0470\u046e\u0001\u0000\u0000\u0000\u0470\u0471\u0001\u0000\u0000\u0000"
            + "\u0471\u00a3\u0001\u0000\u0000\u0000\u0472\u0470\u0001\u0000\u0000\u0000"
            + "\u0473\u0477\u0003\u00a6S\u0000\u0474\u0477\u0003\u00acV\u0000\u0475\u0477"
            + "\u0003\u00b2Y\u0000\u0476\u0473\u0001\u0000\u0000\u0000\u0476\u0474\u0001"
            + "\u0000\u0000\u0000\u0476\u0475\u0001\u0000\u0000\u0000\u0477\u00a5\u0001"
            + "\u0000\u0000\u0000\u0478\u0479\u0003\u00b2Y\u0000\u0479\u047b\u0005\u009b"
            + "\u0000\u0000\u047a\u047c\u0005\u00c6\u0000\u0000\u047b\u047a\u0001\u0000"
            + "\u0000\u0000\u047b\u047c\u0001\u0000\u0000\u0000\u047c\u047d\u0001\u0000"
            + "\u0000\u0000\u047d\u047e\u0005\u00c8\u0000\u0000\u047e\u0490\u0001\u0000"
            + "\u0000\u0000\u047f\u0480\u0003\u00b2Y\u0000\u0480\u0481\u0005\u0013\u0000"
            + "\u0000\u0481\u0482\u0003\u00b2Y\u0000\u0482\u0483\u0005\u0007\u0000\u0000"
            + "\u0483\u0484\u0003\u00b2Y\u0000\u0484\u0490\u0001\u0000\u0000\u0000\u0485"
            + "\u0487\u0005\u00c6\u0000\u0000\u0486\u0485\u0001\u0000\u0000\u0000\u0486"
            + "\u0487\u0001\u0000\u0000\u0000\u0487\u0488\u0001\u0000\u0000\u0000\u0488"
            + "\u0489\u0005k\u0000\u0000\u0489\u048a\u0005\u0191\u0000\u0000\u048a\u048b"
            + "\u0003P(\u0000\u048b\u048c\u0005\u0194\u0000\u0000\u048c\u0490\u0001\u0000"
            + "\u0000\u0000\u048d\u0490\u0003\u00a8T\u0000\u048e\u0490\u0003\u00aaU\u0000"
            + "\u048f\u0478\u0001\u0000\u0000\u0000\u048f\u047f\u0001\u0000\u0000\u0000"
            + "\u048f\u0486\u0001\u0000\u0000\u0000\u048f\u048d\u0001\u0000\u0000\u0000"
            + "\u048f\u048e\u0001\u0000\u0000\u0000\u0490\u00a7\u0001\u0000\u0000\u0000"
            + "\u0491\u0493\u0003\u00b2Y\u0000\u0492\u0494\u0005\u00c6\u0000\u0000\u0493"
            + "\u0492\u0001\u0000\u0000\u0000\u0493\u0494\u0001\u0000\u0000\u0000\u0494"
            + "\u0495\u0001\u0000\u0000\u0000\u0495\u0496\u0005\u008a\u0000\u0000\u0496"
            + "\u04a0\u0005\u0191\u0000\u0000\u0497\u049c\u0003\u00b2Y\u0000\u0498\u0499"
            + "\u0005\u0182\u0000\u0000\u0499\u049b\u0003\u00b2Y\u0000\u049a\u0498\u0001"
            + "\u0000\u0000\u0000\u049b\u049e\u0001\u0000\u0000\u0000\u049c\u049a\u0001"
            + "\u0000\u0000\u0000\u049c\u049d\u0001\u0000\u0000\u0000\u049d\u04a1\u0001"
            + "\u0000\u0000\u0000\u049e\u049c\u0001\u0000\u0000\u0000\u049f\u04a1\u0003"
            + "P(\u0000\u04a0\u0497\u0001\u0000\u0000\u0000\u04a0\u049f\u0001\u0000\u0000"
            + "\u0000\u04a1\u04a2\u0001\u0000\u0000\u0000\u04a2\u04a3\u0005\u0194\u0000"
            + "\u0000\u04a3\u00a9\u0001\u0000\u0000\u0000\u04a4\u04a5\u0005\u0191\u0000"
            + "\u0000\u04a5\u04aa\u0003\u00b2Y\u0000\u04a6\u04a7\u0005\u0182\u0000\u0000"
            + "\u04a7\u04a9\u0003\u00b2Y\u0000\u04a8\u04a6\u0001\u0000\u0000\u0000\u04a9"
            + "\u04ac\u0001\u0000\u0000\u0000\u04aa\u04a8\u0001\u0000\u0000\u0000\u04aa"
            + "\u04ab\u0001\u0000\u0000\u0000\u04ab\u04ad\u0001\u0000\u0000\u0000\u04ac"
            + "\u04aa\u0001\u0000\u0000\u0000\u04ad\u04af\u0005\u0194\u0000\u0000\u04ae"
            + "\u04b0\u0005\u00c6\u0000\u0000\u04af\u04ae\u0001\u0000\u0000\u0000\u04af"
            + "\u04b0\u0001\u0000\u0000\u0000\u04b0\u04b1\u0001\u0000\u0000\u0000\u04b1"
            + "\u04b2\u0005\u008a\u0000\u0000\u04b2\u04b3\u0005\u0191\u0000\u0000\u04b3"
            + "\u04b4\u0003P(\u0000\u04b4\u04b5\u0005\u0194\u0000\u0000\u04b5\u00ab\u0001"
            + "\u0000\u0000\u0000\u04b6\u04b7\u0003\u00b2Y\u0000\u04b7\u04b8\u0003\u00b0"
            + "X\u0000\u04b8\u04b9\u0003\u00b2Y\u0000\u04b9\u00ad\u0001\u0000\u0000\u0000"
            + "\u04ba\u04bb\u0007\u0012\u0000\u0000\u04bb\u00af\u0001\u0000\u0000\u0000"
            + "\u04bc\u04c9\u0005\u0187\u0000\u0000\u04bd\u04c9\u0005\u0188\u0000\u0000"
            + "\u04be\u04c9\u0005\u0189\u0000\u0000\u04bf\u04c9\u0005\u018a\u0000\u0000"
            + "\u04c0\u04c9\u0005\u018d\u0000\u0000\u04c1\u04c9\u0005\u018e\u0000\u0000"
            + "\u04c2\u04c9\u0005\u018b\u0000\u0000\u04c3\u04c9\u0005\u018c\u0000\u0000"
            + "\u04c4\u04c6\u0005\u00c6\u0000\u0000\u04c5\u04c4\u0001\u0000\u0000\u0000"
            + "\u04c5\u04c6\u0001\u0000\u0000\u0000\u04c6\u04c7\u0001\u0000\u0000\u0000"
            + "\u04c7\u04c9\u0007\u0013\u0000\u0000\u04c8\u04bc\u0001\u0000\u0000\u0000"
            + "\u04c8\u04bd\u0001\u0000\u0000\u0000\u04c8\u04be\u0001\u0000\u0000\u0000"
            + "\u04c8\u04bf\u0001\u0000\u0000\u0000\u04c8\u04c0\u0001\u0000\u0000\u0000"
            + "\u04c8\u04c1\u0001\u0000\u0000\u0000\u04c8\u04c2\u0001\u0000\u0000\u0000"
            + "\u04c8\u04c3\u0001\u0000\u0000\u0000\u04c8\u04c5\u0001\u0000\u0000\u0000"
            + "\u04c9\u00b1\u0001\u0000\u0000\u0000\u04ca\u04cb\u0006Y\uffff\uffff\u0000"
            + "\u04cb\u04cc\u0005\u0191\u0000\u0000\u04cc\u04cd\u0003P(\u0000\u04cd\u04ce"
            + "\u0005\u0194\u0000\u0000\u04ce\u04dc\u0001\u0000\u0000\u0000\u04cf\u04d0"
            + "\u0005\u0191\u0000\u0000\u04d0\u04d1\u0003\u00b2Y\u0000\u04d1\u04d2\u0005"
            + "\u0194\u0000\u0000\u04d2\u04dc\u0001\u0000\u0000\u0000\u04d3\u04dc\u0003"
            + "\u00b6[\u0000\u04d4\u04dc\u0003\u00ba]\u0000\u04d5\u04dc\u0003\u00be_"
            + "\u0000\u04d6\u04dc\u0003\u00c6c\u0000\u04d7\u04dc\u0003\u00c8d\u0000\u04d8"
            + "\u04dc\u0003\u00d0h\u0000\u04d9\u04dc\u0003\u00d2i\u0000\u04da\u04dc\u0003"
            + "\u00b4Z\u0000\u04db\u04ca\u0001\u0000\u0000\u0000\u04db\u04cf\u0001\u0000"
            + "\u0000\u0000\u04db\u04d3\u0001\u0000\u0000\u0000\u04db\u04d4\u0001\u0000"
            + "\u0000\u0000\u04db\u04d5\u0001\u0000\u0000\u0000\u04db\u04d6\u0001\u0000"
            + "\u0000\u0000\u04db\u04d7\u0001\u0000\u0000\u0000\u04db\u04d8\u0001\u0000"
            + "\u0000\u0000\u04db\u04d9\u0001\u0000\u0000\u0000\u04db\u04da\u0001\u0000"
            + "\u0000\u0000\u04dc\u04ed\u0001\u0000\u0000\u0000\u04dd\u04de\n\u000e\u0000"
            + "\u0000\u04de\u04df\u0005\u018f\u0000\u0000\u04df\u04ec\u0003\u00b2Y\u000f"
            + "\u04e0\u04e1\n\r\u0000\u0000\u04e1\u04e2\u0005\u0184\u0000\u0000\u04e2"
            + "\u04ec\u0003\u00b2Y\u000e\u04e3\u04e4\n\f\u0000\u0000\u04e4\u04e5\u0005"
            + "\u0180\u0000\u0000\u04e5\u04ec\u0003\u00b2Y\r\u04e6\u04e7\n\u000b\u0000"
            + "\u0000\u04e7\u04e8\u0005\u0197\u0000\u0000\u04e8\u04ec\u0003\u00b2Y\f"
            + "\u04e9\u04ea\n\u000f\u0000\u0000\u04ea\u04ec\u0003\u00b8\\\u0000\u04eb"
            + "\u04dd\u0001\u0000\u0000\u0000\u04eb\u04e0\u0001\u0000\u0000\u0000\u04eb"
            + "\u04e3\u0001\u0000\u0000\u0000\u04eb\u04e6\u0001\u0000\u0000\u0000\u04eb"
            + "\u04e9\u0001\u0000\u0000\u0000\u04ec\u04ef\u0001\u0000\u0000\u0000\u04ed"
            + "\u04eb\u0001\u0000\u0000\u0000\u04ed\u04ee\u0001\u0000\u0000\u0000\u04ee"
            + "\u00b3\u0001\u0000\u0000\u0000\u04ef\u04ed\u0001\u0000\u0000\u0000\u04f0"
            + "\u04f9\u0003\u00dcn\u0000\u04f1\u04f9\u0003\u00deo\u0000\u04f2\u04f9\u0003"
            + "\u00eau\u0000\u04f3\u04f9\u0003\u00e0p\u0000\u04f4\u04f9\u0003\u00e4r"
            + "\u0000\u04f5\u04f9\u0003\u00e8t\u0000\u04f6\u04f9\u0003\u00e6s\u0000\u04f7"
            + "\u04f9\u0003\u00ecv\u0000\u04f8\u04f0\u0001\u0000\u0000\u0000\u04f8\u04f1"
            + "\u0001\u0000\u0000\u0000\u04f8\u04f2\u0001\u0000\u0000\u0000\u04f8\u04f3"
            + "\u0001\u0000\u0000\u0000\u04f8\u04f4\u0001\u0000\u0000\u0000\u04f8\u04f5"
            + "\u0001\u0000\u0000\u0000\u04f8\u04f6\u0001\u0000\u0000\u0000\u04f8\u04f7"
            + "\u0001\u0000\u0000\u0000\u04f9\u00b5\u0001\u0000\u0000\u0000\u04fa\u04fb"
            + "\u0005\u0098\u0000\u0000\u04fb\u04fc\u0003\u00b2Y\u0000\u04fc\u04fd\u0003"
            + "\u00b8\\\u0000\u04fd\u00b7\u0001\u0000\u0000\u0000\u04fe\u04ff\u0007\u0014"
            + "\u0000\u0000\u04ff\u00b9\u0001\u0000\u0000\u0000\u0500\u0501\u0003\u00bc"
            + "^\u0000\u0501\u0502\u0007\u0015\u0000\u0000\u0502\u0507\u0003\u00bc^\u0000"
            + "\u0503\u0504\u0007\u0015\u0000\u0000\u0504\u0506\u0003\u00bc^\u0000\u0505"
            + "\u0503\u0001\u0000\u0000\u0000\u0506\u0509\u0001\u0000\u0000\u0000\u0507"
            + "\u0505\u0001\u0000\u0000\u0000\u0507\u0508\u0001\u0000\u0000\u0000\u0508"
            + "\u00bb\u0001\u0000\u0000\u0000\u0509\u0507\u0001\u0000\u0000\u0000\u050a"
            + "\u050b\u0005\u0191\u0000\u0000\u050b\u050c\u0003\u00b2Y\u0000\u050c\u050d"
            + "\u0005\u0194\u0000\u0000\u050d\u0514\u0001\u0000\u0000\u0000\u050e\u0514"
            + "\u0003\u00be_\u0000\u050f\u0514\u0003\u00c8d\u0000\u0510\u0514\u0003\u00d0"
            + "h\u0000\u0511\u0514\u0003\u00d2i\u0000\u0512\u0514\u0003\u00b4Z\u0000"
            + "\u0513\u050a\u0001\u0000\u0000\u0000\u0513\u050e\u0001\u0000\u0000\u0000"
            + "\u0513\u050f\u0001\u0000\u0000\u0000\u0513\u0510\u0001\u0000\u0000\u0000"
            + "\u0513\u0511\u0001\u0000\u0000\u0000\u0513\u0512\u0001\u0000\u0000\u0000"
            + "\u0514\u00bd\u0001\u0000\u0000\u0000\u0515\u0518\u0003\u00c0`\u0000\u0516"
            + "\u0518\u0003\u00c2a\u0000\u0517\u0515\u0001\u0000\u0000\u0000\u0517\u0516"
            + "\u0001\u0000\u0000\u0000\u0518\u00bf\u0001\u0000\u0000\u0000\u0519\u051a"
            + "\u0005!\u0000\u0000\u051a\u0520\u0003\u00b2Y\u0000\u051b\u051c\u0005\u014d"
            + "\u0000\u0000\u051c\u051d\u0003\u00b2Y\u0000\u051d\u051e\u0005\u0136\u0000"
            + "\u0000\u051e\u051f\u0003\u00b2Y\u0000\u051f\u0521\u0001\u0000\u0000\u0000"
            + "\u0520\u051b\u0001\u0000\u0000\u0000\u0521\u0522\u0001\u0000\u0000\u0000"
            + "\u0522\u0520\u0001\u0000\u0000\u0000\u0522\u0523\u0001\u0000\u0000\u0000"
            + "\u0523\u0526\u0001\u0000\u0000\u0000\u0524\u0525\u0005_\u0000\u0000\u0525"
            + "\u0527\u0003\u00b2Y\u0000\u0526\u0524\u0001\u0000\u0000\u0000\u0526\u0527"
            + "\u0001\u0000\u0000\u0000\u0527\u0528\u0001\u0000\u0000\u0000\u0528\u0529"
            + "\u0005c\u0000\u0000\u0529\u00c1\u0001\u0000\u0000\u0000\u052a\u052c\u0005"
            + "!\u0000\u0000\u052b\u052d\u0003\u00c4b\u0000\u052c\u052b\u0001\u0000\u0000"
            + "\u0000\u052d\u052e\u0001\u0000\u0000\u0000\u052e\u052c\u0001\u0000\u0000"
            + "\u0000\u052e\u052f\u0001\u0000\u0000\u0000\u052f\u0532\u0001\u0000\u0000"
            + "\u0000\u0530\u0531\u0005_\u0000\u0000\u0531\u0533\u0003\u00a2Q\u0000\u0532"
            + "\u0530\u0001\u0000\u0000\u0000\u0532\u0533\u0001\u0000\u0000\u0000\u0533"
            + "\u0534\u0001\u0000\u0000\u0000\u0534\u0535\u0005c\u0000\u0000\u0535\u00c3"
            + "\u0001\u0000\u0000\u0000\u0536\u0537\u0005\u014d\u0000\u0000\u0537\u0538"
            + "\u0003\u00a2Q\u0000\u0538\u0539\u0005\u0136\u0000\u0000\u0539\u053a\u0003"
            + "\u00a2Q\u0000\u053a\u00c5\u0001\u0000\u0000\u0000\u053b\u053c\u0003\u00e0"
            + "p\u0000\u053c\u053d\u0005\u0001\u0000\u0000\u053d\u053e\u0007\u0016\u0000"
            + "\u0000\u053e\u00c7\u0001\u0000\u0000\u0000\u053f\u0540\u0005\u0010\u0000"
            + "\u0000\u0540\u0542\u0005\u0191\u0000\u0000\u0541\u0543\u0003\u00cae\u0000"
            + "\u0542\u0541\u0001\u0000\u0000\u0000\u0542\u0543\u0001\u0000\u0000\u0000"
            + "\u0543\u0544\u0001\u0000\u0000\u0000\u0544\u0545\u0003\u00b2Y\u0000\u0545"
            + "\u0547\u0005\u0194\u0000\u0000\u0546\u0548\u0003\u00ccf\u0000\u0547\u0546"
            + "\u0001\u0000\u0000\u0000\u0547\u0548\u0001\u0000\u0000\u0000\u0548\u05d8"
            + "\u0001\u0000\u0000\u0000\u0549\u054a\u00058\u0000\u0000\u054a\u0550\u0005"
            + "\u0191\u0000\u0000\u054b\u054d\u0003\u00cae\u0000\u054c\u054b\u0001\u0000"
            + "\u0000\u0000\u054c\u054d\u0001\u0000\u0000\u0000\u054d\u054e\u0001\u0000"
            + "\u0000\u0000\u054e\u0551\u0003\u00b2Y\u0000\u054f\u0551\u0005\u018f\u0000"
            + "\u0000\u0550\u054c\u0001\u0000\u0000\u0000\u0550\u054f\u0001\u0000\u0000"
            + "\u0000\u0551\u0552\u0001\u0000\u0000\u0000\u0552\u0554\u0005\u0194\u0000"
            + "\u0000\u0553\u0555\u0003\u00ccf\u0000\u0554\u0553\u0001\u0000\u0000\u0000"
            + "\u0554\u0555\u0001\u0000\u0000\u0000\u0555\u05d8\u0001\u0000\u0000\u0000"
            + "\u0556\u0557\u00059\u0000\u0000\u0557\u055d\u0005\u0191\u0000\u0000\u0558"
            + "\u055a\u0003\u00cae\u0000\u0559\u0558\u0001\u0000\u0000\u0000\u0559\u055a"
            + "\u0001\u0000\u0000\u0000\u055a\u055b\u0001\u0000\u0000\u0000\u055b\u055e"
            + "\u0003\u00b2Y\u0000\u055c\u055e\u0005\u018f\u0000\u0000\u055d\u0559\u0001"
            + "\u0000\u0000\u0000\u055d\u055c\u0001\u0000\u0000\u0000\u055e\u055f\u0001"
            + "\u0000\u0000\u0000\u055f\u0561\u0005\u0194\u0000\u0000\u0560\u0562\u0003"
            + "\u00ccf\u0000\u0561\u0560\u0001\u0000\u0000\u0000\u0561\u0562\u0001\u0000"
            + "\u0000\u0000\u0562\u05d8\u0001\u0000\u0000\u0000\u0563\u0564\u0005\u0157"
            + "\u0000\u0000\u0564\u0565\u0005\u0191\u0000\u0000\u0565\u0566\u0005\u0194"
            + "\u0000\u0000\u0566\u05d8\u0003\u00ccf\u0000\u0567\u0568\u0005\u015d\u0000"
            + "\u0000\u0568\u0569\u0005\u0191\u0000\u0000\u0569\u056a\u0005\u0194\u0000"
            + "\u0000\u056a\u05d8\u0003\u00ccf\u0000\u056b\u056c\u0005\u015e\u0000\u0000"
            + "\u056c\u056d\u0005\u0191\u0000\u0000\u056d\u056e\u0003\u00b2Y\u0000\u056e"
            + "\u056f\u0005\u0194\u0000\u0000\u056f\u0570\u0003\u00ccf\u0000\u0570\u05d8"
            + "\u0001\u0000\u0000\u0000\u0571\u0572\u0005\u015f\u0000\u0000\u0572\u0573"
            + "\u0005\u0191\u0000\u0000\u0573\u057a\u0003\u00b2Y\u0000\u0574\u0575\u0005"
            + "\u0182\u0000\u0000\u0575\u0578\u0003\u00b2Y\u0000\u0576\u0577\u0005\u0182"
            + "\u0000\u0000\u0577\u0579\u0003\u00b2Y\u0000\u0578\u0576\u0001\u0000\u0000"
            + "\u0000\u0578\u0579\u0001\u0000\u0000\u0000\u0579\u057b\u0001\u0000\u0000"
            + "\u0000\u057a\u0574\u0001\u0000\u0000\u0000\u057a\u057b\u0001\u0000\u0000"
            + "\u0000\u057b\u057c\u0001\u0000\u0000\u0000\u057c\u057d\u0005\u0194\u0000"
            + "\u0000\u057d\u057e\u0003\u00ccf\u0000\u057e\u05d8\u0001\u0000\u0000\u0000"
            + "\u057f\u0580\u0005\u0160\u0000\u0000\u0580\u0581\u0005\u0191\u0000\u0000"
            + "\u0581\u0582\u0003\u00b2Y\u0000\u0582\u0583\u0005\u0194\u0000\u0000\u0583"
            + "\u0584\u0003\u00ccf\u0000\u0584\u05d8\u0001\u0000\u0000\u0000\u0585\u0586"
            + "\u0005\u0161\u0000\u0000\u0586\u0587\u0005\u0191\u0000\u0000\u0587\u058e"
            + "\u0003\u00b2Y\u0000\u0588\u0589\u0005\u0182\u0000\u0000\u0589\u058c\u0003"
            + "\u00b2Y\u0000\u058a\u058b\u0005\u0182\u0000\u0000\u058b\u058d\u0003\u00b2"
            + "Y\u0000\u058c\u058a\u0001\u0000\u0000\u0000\u058c\u058d\u0001\u0000\u0000"
            + "\u0000\u058d\u058f\u0001\u0000\u0000\u0000\u058e\u0588\u0001\u0000\u0000"
            + "\u0000\u058e\u058f\u0001\u0000\u0000\u0000\u058f\u0590\u0001\u0000\u0000"
            + "\u0000\u0590\u0591\u0005\u0194\u0000\u0000\u0591\u0592\u0003\u00ccf\u0000"
            + "\u0592\u05d8\u0001\u0000\u0000\u0000\u0593\u0594\u0005\u00b6\u0000\u0000"
            + "\u0594\u0596\u0005\u0191\u0000\u0000\u0595\u0597\u0003\u00cae\u0000\u0596"
            + "\u0595\u0001\u0000\u0000\u0000\u0596\u0597\u0001\u0000\u0000\u0000\u0597"
            + "\u0598\u0001\u0000\u0000\u0000\u0598\u0599\u0003\u00b2Y\u0000\u0599\u059b"
            + "\u0005\u0194\u0000\u0000\u059a\u059c\u0003\u00ccf\u0000\u059b\u059a\u0001"
            + "\u0000\u0000\u0000\u059b\u059c\u0001\u0000\u0000\u0000\u059c\u05d8\u0001"
            + "\u0000\u0000\u0000\u059d\u059e\u0005\u00bc\u0000\u0000\u059e\u05a0\u0005"
            + "\u0191\u0000\u0000\u059f\u05a1\u0003\u00cae\u0000\u05a0\u059f\u0001\u0000"
            + "\u0000\u0000\u05a0\u05a1\u0001\u0000\u0000\u0000\u05a1\u05a2\u0001\u0000"
            + "\u0000\u0000\u05a2\u05a3\u0003\u00b2Y\u0000\u05a3\u05a5\u0005\u0194\u0000"
            + "\u0000\u05a4\u05a6\u0003\u00ccf\u0000\u05a5\u05a4\u0001\u0000\u0000\u0000"
            + "\u05a5\u05a6\u0001\u0000\u0000\u0000\u05a6\u05d8\u0001\u0000\u0000\u0000"
            + "\u05a7\u05a8\u0005\u016a\u0000\u0000\u05a8\u05a9\u0005\u0191\u0000\u0000"
            + "\u05a9\u05aa\u0005\u0194\u0000\u0000\u05aa\u05d8\u0003\u00ccf\u0000\u05ab"
            + "\u05ac\u0005\u016b\u0000\u0000\u05ac\u05ad\u0005\u0191\u0000\u0000\u05ad"
            + "\u05ae\u0005\u0194\u0000\u0000\u05ae\u05d8\u0003\u00ccf\u0000\u05af\u05b0"
            + "\u0005\u016c\u0000\u0000\u05b0\u05b2\u0005\u0191\u0000\u0000\u05b1\u05b3"
            + "\u0003\u00cae\u0000\u05b2\u05b1\u0001\u0000\u0000\u0000\u05b2\u05b3\u0001"
            + "\u0000\u0000\u0000\u05b3\u05b4\u0001\u0000\u0000\u0000\u05b4\u05b5\u0003"
            + "\u00b2Y\u0000\u05b5\u05b7\u0005\u0194\u0000\u0000\u05b6\u05b8\u0003\u00cc"
            + "f\u0000\u05b7\u05b6\u0001\u0000\u0000\u0000\u05b7\u05b8\u0001\u0000\u0000"
            + "\u0000\u05b8\u05d8\u0001\u0000\u0000\u0000\u05b9\u05ba\u0005\u012a\u0000"
            + "\u0000\u05ba\u05bc\u0005\u0191\u0000\u0000\u05bb\u05bd\u0003\u00cae\u0000"
            + "\u05bc\u05bb\u0001\u0000\u0000\u0000\u05bc\u05bd\u0001\u0000\u0000\u0000"
            + "\u05bd\u05be\u0001\u0000\u0000\u0000\u05be\u05bf\u0003\u00b2Y\u0000\u05bf"
            + "\u05c1\u0005\u0194\u0000\u0000\u05c0\u05c2\u0003\u00ccf\u0000\u05c1\u05c0"
            + "\u0001\u0000\u0000\u0000\u05c1\u05c2\u0001\u0000\u0000\u0000\u05c2\u05d8"
            + "\u0001\u0000\u0000\u0000\u05c3\u05c4\u0005\u0148\u0000\u0000\u05c4\u05c6"
            + "\u0005\u0191\u0000\u0000\u05c5\u05c7\u0003\u00cae\u0000\u05c6\u05c5\u0001"
            + "\u0000\u0000\u0000\u05c6\u05c7\u0001\u0000\u0000\u0000\u05c7\u05c8\u0001"
            + "\u0000\u0000\u0000\u05c8\u05c9\u0003\u00b2Y\u0000\u05c9\u05cb\u0005\u0194"
            + "\u0000\u0000\u05ca\u05cc\u0003\u00ccf\u0000\u05cb\u05ca\u0001\u0000\u0000"
            + "\u0000\u05cb\u05cc\u0001\u0000\u0000\u0000\u05cc\u05d8\u0001\u0000\u0000"
            + "\u0000\u05cd\u05ce\u0005\u016e\u0000\u0000\u05ce\u05d0\u0005\u0191\u0000"
            + "\u0000\u05cf\u05d1\u0003\u00cae\u0000\u05d0\u05cf\u0001\u0000\u0000\u0000"
            + "\u05d0\u05d1\u0001\u0000\u0000\u0000\u05d1\u05d2\u0001\u0000\u0000\u0000"
            + "\u05d2\u05d3\u0003\u00b2Y\u0000\u05d3\u05d5\u0005\u0194\u0000\u0000\u05d4"
            + "\u05d6\u0003\u00ccf\u0000\u05d5\u05d4\u0001\u0000\u0000\u0000\u05d5\u05d6"
            + "\u0001\u0000\u0000\u0000\u05d6\u05d8\u0001\u0000\u0000\u0000\u05d7\u053f"
            + "\u0001\u0000\u0000\u0000\u05d7\u0549\u0001\u0000\u0000\u0000\u05d7\u0556"
            + "\u0001\u0000\u0000\u0000\u05d7\u0563\u0001\u0000\u0000\u0000\u05d7\u0567"
            + "\u0001\u0000\u0000\u0000\u05d7\u056b\u0001\u0000\u0000\u0000\u05d7\u0571"
            + "\u0001\u0000\u0000\u0000\u05d7\u057f\u0001\u0000\u0000\u0000\u05d7\u0585"
            + "\u0001\u0000\u0000\u0000\u05d7\u0593\u0001\u0000\u0000\u0000\u05d7\u059d"
            + "\u0001\u0000\u0000\u0000\u05d7\u05a7\u0001\u0000\u0000\u0000\u05d7\u05ab"
            + "\u0001\u0000\u0000\u0000\u05d7\u05af\u0001\u0000\u0000\u0000\u05d7\u05b9"
            + "\u0001\u0000\u0000\u0000\u05d7\u05c3\u0001\u0000\u0000\u0000\u05d7\u05cd"
            + "\u0001\u0000\u0000\u0000\u05d8\u00c9\u0001\u0000\u0000\u0000\u05d9\u05da"
            + "\u0007\f\u0000\u0000\u05da\u00cb\u0001\u0000\u0000\u0000\u05db\u05dc\u0005"
            + "\u00d4\u0000\u0000\u05dc\u05de\u0005\u0191\u0000\u0000\u05dd\u05df\u0003"
            + "\u00ceg\u0000\u05de\u05dd\u0001\u0000\u0000\u0000\u05de\u05df\u0001\u0000"
            + "\u0000\u0000\u05df\u05e1\u0001\u0000\u0000\u0000\u05e0\u05e2\u0003\u008a"
            + "E\u0000\u05e1\u05e0\u0001\u0000\u0000\u0000\u05e1\u05e2\u0001\u0000\u0000"
            + "\u0000\u05e2\u05e3\u0001\u0000\u0000\u0000\u05e3\u05e4\u0005\u0194\u0000"
            + "\u0000\u05e4\u00cd\u0001\u0000\u0000\u0000\u05e5\u05e6\u0005\u00d8\u0000"
            + "\u0000\u05e6\u05e7\u0005\u001c\u0000\u0000\u05e7\u05ec\u0003\u00b2Y\u0000"
            + "\u05e8\u05e9\u0005\u0182\u0000\u0000\u05e9\u05eb\u0003\u00b2Y\u0000\u05ea"
            + "\u05e8\u0001\u0000\u0000\u0000\u05eb\u05ee\u0001\u0000\u0000\u0000\u05ec"
            + "\u05ea\u0001\u0000\u0000\u0000\u05ec\u05ed\u0001\u0000\u0000\u0000\u05ed"
            + "\u00cf\u0001\u0000\u0000\u0000\u05ee\u05ec\u0001\u0000\u0000\u0000\u05ef"
            + "\u06b5\u0005\u0156\u0000\u0000\u05f0\u05f1\u0005#\u0000\u0000\u05f1\u05f2"
            + "\u0005\u0191\u0000\u0000\u05f2\u05f3\u0003\u00b2Y\u0000\u05f3\u05f4\u0005"
            + "\n\u0000\u0000\u05f4\u05f6\u00036\u001b\u0000\u05f5\u05f7\u00038\u001c"
            + "\u0000\u05f6\u05f5\u0001\u0000\u0000\u0000\u05f6\u05f7\u0001\u0000\u0000"
            + "\u0000\u05f7\u05f8\u0001\u0000\u0000\u0000\u05f8\u05f9\u0005\u0194\u0000"
            + "\u0000\u05f9\u06b5\u0001\u0000\u0000\u0000\u05fa\u05fb\u00058\u0000\u0000"
            + "\u05fb\u05fe\u0005\u0191\u0000\u0000\u05fc\u05ff\u0003\u00b2Y\u0000\u05fd"
            + "\u05ff\u0005\u018f\u0000\u0000\u05fe\u05fc\u0001\u0000\u0000\u0000\u05fe"
            + "\u05fd\u0001\u0000\u0000\u0000\u05ff\u0600\u0001\u0000\u0000\u0000\u0600"
            + "\u06b5\u0005\u0194\u0000\u0000\u0601\u06b5\u0005\u0158\u0000\u0000\u0602"
            + "\u0603\u0005>\u0000\u0000\u0603\u06b5\u0005D\u0000\u0000\u0604\u06b5\u0005"
            + "\u0159\u0000\u0000\u0605\u06b5\u0005\u015a\u0000\u0000\u0606\u060a\u0005"
            + "\u015b\u0000\u0000\u0607\u0608\u0005>\u0000\u0000\u0608\u060a\u0005\u0137"
            + "\u0000\u0000\u0609\u0606\u0001\u0000\u0000\u0000\u0609\u0607\u0001\u0000"
            + "\u0000\u0000\u060a\u060f\u0001\u0000\u0000\u0000\u060b\u060c\u0005\u0191"
            + "\u0000\u0000\u060c\u060d\u0003\u00b2Y\u0000\u060d\u060e\u0005\u0194\u0000"
            + "\u0000\u060e\u0610\u0001\u0000\u0000\u0000\u060f\u060b\u0001\u0000\u0000"
            + "\u0000\u060f\u0610\u0001\u0000\u0000\u0000\u0610\u06b5\u0001\u0000\u0000"
            + "\u0000\u0611\u06b5\u0005\u015c\u0000\u0000\u0612\u0613\u0005>\u0000\u0000"
            + "\u0613\u06b5\u0005\u016f\u0000\u0000\u0614\u0615\u0005\u0162\u0000\u0000"
            + "\u0615\u0616\u0005\u0191\u0000\u0000\u0616\u0623\u0003\u00b2Y\u0000\u0617"
            + "\u0618\u0005\u0182\u0000\u0000\u0618\u0620\u0003\u00b2Y\u0000\u0619\u061a"
            + "\u0005\u0182\u0000\u0000\u061a\u061b\u0003\u00b2Y\u0000\u061b\u061c\u0005"
            + "\u0187\u0000\u0000\u061c\u061d\u0003\u00b2Y\u0000\u061d\u061f\u0001\u0000"
            + "\u0000\u0000\u061e\u0619\u0001\u0000\u0000\u0000\u061f\u0622\u0001\u0000"
            + "\u0000\u0000\u0620\u061e\u0001\u0000\u0000\u0000\u0620\u0621\u0001\u0000"
            + "\u0000\u0000\u0621\u0624\u0001\u0000\u0000\u0000\u0622\u0620\u0001\u0000"
            + "\u0000\u0000\u0623\u0617\u0001\u0000\u0000\u0000\u0623\u0624\u0001\u0000"
            + "\u0000\u0000\u0624\u0625\u0001\u0000\u0000\u0000\u0625\u0626\u0005\u0194"
            + "\u0000\u0000\u0626\u06b5\u0001\u0000\u0000\u0000\u0627\u0628\u0005\u0163"
            + "\u0000\u0000\u0628\u0629\u0005\u0191\u0000\u0000\u0629\u0636\u0003\u00b2"
            + "Y\u0000\u062a\u062b\u0005\u0182\u0000\u0000\u062b\u0633\u0003\u00b2Y\u0000"
            + "\u062c\u062d\u0005\u0182\u0000\u0000\u062d\u062e\u0003\u00b2Y\u0000\u062e"
            + "\u062f\u0005\u0187\u0000\u0000\u062f\u0630\u0003\u00b2Y\u0000\u0630\u0632"
            + "\u0001\u0000\u0000\u0000\u0631\u062c\u0001\u0000\u0000\u0000\u0632\u0635"
            + "\u0001\u0000\u0000\u0000\u0633\u0631\u0001\u0000\u0000\u0000\u0633\u0634"
            + "\u0001\u0000\u0000\u0000\u0634\u0637\u0001\u0000\u0000\u0000\u0635\u0633"
            + "\u0001\u0000\u0000\u0000\u0636\u062a\u0001\u0000\u0000\u0000\u0636\u0637"
            + "\u0001\u0000\u0000\u0000\u0637\u0638\u0001\u0000\u0000\u0000\u0638\u0639"
            + "\u0005\u0194\u0000\u0000\u0639\u06b5\u0001\u0000\u0000\u0000\u063a\u063b"
            + "\u0005\u0164\u0000\u0000\u063b\u063c\u0005\u0191\u0000\u0000\u063c\u0649"
            + "\u0003\u00b2Y\u0000\u063d\u063e\u0005\u0182\u0000\u0000\u063e\u0646\u0003"
            + "\u00b2Y\u0000\u063f\u0640\u0005\u0182\u0000\u0000\u0640\u0641\u0003\u00b2"
            + "Y\u0000\u0641\u0642\u0005\u0187\u0000\u0000\u0642\u0643\u0003\u00b2Y\u0000"
            + "\u0643\u0645\u0001\u0000\u0000\u0000\u0644\u063f\u0001\u0000\u0000\u0000"
            + "\u0645\u0648\u0001\u0000\u0000\u0000\u0646\u0644\u0001\u0000\u0000\u0000"
            + "\u0646\u0647\u0001\u0000\u0000\u0000\u0647\u064a\u0001\u0000\u0000\u0000"
            + "\u0648\u0646\u0001\u0000\u0000\u0000\u0649\u063d\u0001\u0000\u0000\u0000"
            + "\u0649\u064a\u0001\u0000\u0000\u0000\u064a\u064b\u0001\u0000\u0000\u0000"
            + "\u064b\u064c\u0005\u0194\u0000\u0000\u064c\u06b5\u0001\u0000\u0000\u0000"
            + "\u064d\u064e\u0005\u0165\u0000\u0000\u064e\u064f\u0005\u0191\u0000\u0000"
            + "\u064f\u065c\u0003\u00b2Y\u0000\u0650\u0651\u0005\u0182\u0000\u0000\u0651"
            + "\u0659\u0003\u00b2Y\u0000\u0652\u0653\u0005\u0182\u0000\u0000\u0653\u0654"
            + "\u0003\u00b2Y\u0000\u0654\u0655\u0005\u0187\u0000\u0000\u0655\u0656\u0003"
            + "\u00b2Y\u0000\u0656\u0658\u0001\u0000\u0000\u0000\u0657\u0652\u0001\u0000"
            + "\u0000\u0000\u0658\u065b\u0001\u0000\u0000\u0000\u0659\u0657\u0001\u0000"
            + "\u0000\u0000\u0659\u065a\u0001\u0000\u0000\u0000\u065a\u065d\u0001\u0000"
            + "\u0000\u0000\u065b\u0659\u0001\u0000\u0000\u0000\u065c\u0650\u0001\u0000"
            + "\u0000\u0000\u065c\u065d\u0001\u0000\u0000\u0000\u065d\u065e\u0001\u0000"
            + "\u0000\u0000\u065e\u065f\u0005\u0194\u0000\u0000\u065f\u06b5\u0001\u0000"
            + "\u0000\u0000\u0660\u0661\u0005\u0166\u0000\u0000\u0661\u0662\u0005\u0191"
            + "\u0000\u0000\u0662\u066f\u0003\u00b2Y\u0000\u0663\u0664\u0005\u0182\u0000"
            + "\u0000\u0664\u066c\u0003\u00b2Y\u0000\u0665\u0666\u0005\u0182\u0000\u0000"
            + "\u0666\u0667\u0003\u00b2Y\u0000\u0667\u0668\u0005\u0187\u0000\u0000\u0668"
            + "\u0669\u0003\u00b2Y\u0000\u0669\u066b\u0001\u0000\u0000\u0000\u066a\u0665"
            + "\u0001\u0000\u0000\u0000\u066b\u066e\u0001\u0000\u0000\u0000\u066c\u066a"
            + "\u0001\u0000\u0000\u0000\u066c\u066d\u0001\u0000\u0000\u0000\u066d\u0670"
            + "\u0001\u0000\u0000\u0000\u066e\u066c\u0001\u0000\u0000\u0000\u066f\u0663"
            + "\u0001\u0000\u0000\u0000\u066f\u0670\u0001\u0000\u0000\u0000\u0670\u0671"
            + "\u0001\u0000\u0000\u0000\u0671\u0672\u0005\u0194\u0000\u0000\u0672\u06b5"
            + "\u0001\u0000\u0000\u0000\u0673\u0674\u0005\u0167\u0000\u0000\u0674\u0675"
            + "\u0005\u0191\u0000\u0000\u0675\u0682\u0003\u00b2Y\u0000\u0676\u0677\u0005"
            + "\u0182\u0000\u0000\u0677\u067f\u0003\u00b2Y\u0000\u0678\u0679\u0005\u0182"
            + "\u0000\u0000\u0679\u067a\u0003\u00b2Y\u0000\u067a\u067b\u0005\u0187\u0000"
            + "\u0000\u067b\u067c\u0003\u00b2Y\u0000\u067c\u067e\u0001\u0000\u0000\u0000"
            + "\u067d\u0678\u0001\u0000\u0000\u0000\u067e\u0681\u0001\u0000\u0000\u0000"
            + "\u067f\u067d\u0001\u0000\u0000\u0000\u067f\u0680\u0001\u0000\u0000\u0000"
            + "\u0680\u0683\u0001\u0000\u0000\u0000\u0681\u067f\u0001\u0000\u0000\u0000"
            + "\u0682\u0676\u0001\u0000\u0000\u0000\u0682\u0683\u0001\u0000\u0000\u0000"
            + "\u0683\u0684\u0001\u0000\u0000\u0000\u0684\u0685\u0005\u0194\u0000\u0000"
            + "\u0685\u06b5\u0001\u0000\u0000\u0000\u0686\u0687\u0005\u0168\u0000\u0000"
            + "\u0687\u0688\u0005\u0191\u0000\u0000\u0688\u0690\u0003\u00b2Y\u0000\u0689"
            + "\u068a\u0005\u0182\u0000\u0000\u068a\u068b\u0003\u00b2Y\u0000\u068b\u068c"
            + "\u0005\u0187\u0000\u0000\u068c\u068d\u0003\u00b2Y\u0000\u068d\u068f\u0001"
            + "\u0000\u0000\u0000\u068e\u0689\u0001\u0000\u0000\u0000\u068f\u0692\u0001"
            + "\u0000\u0000\u0000\u0690\u068e\u0001\u0000\u0000\u0000\u0690\u0691\u0001"
            + "\u0000\u0000\u0000\u0691\u0693\u0001\u0000\u0000\u0000\u0692\u0690\u0001"
            + "\u0000\u0000\u0000\u0693\u0694\u0005\u0194\u0000\u0000\u0694\u06b5\u0001"
            + "\u0000\u0000\u0000\u0695\u0696\u0005\u0169\u0000\u0000\u0696\u0697\u0005"
            + "\u0191\u0000\u0000\u0697\u069d\u0003\u00b2Y\u0000\u0698\u0699\u0005\u0182"
            + "\u0000\u0000\u0699\u069a\u0003\u00b2Y\u0000\u069a\u069b\u0005\u0187\u0000"
            + "\u0000\u069b\u069c\u0003\u00b2Y\u0000\u069c\u069e\u0001\u0000\u0000\u0000"
            + "\u069d\u0698\u0001\u0000\u0000\u0000\u069e\u069f\u0001\u0000\u0000\u0000"
            + "\u069f\u069d\u0001\u0000\u0000\u0000\u069f\u06a0\u0001\u0000\u0000\u0000"
            + "\u06a0\u06a3\u0001\u0000\u0000\u0000\u06a1\u06a2\u0005\u0182\u0000\u0000"
            + "\u06a2\u06a4\u0003\u00b2Y\u0000\u06a3\u06a1\u0001\u0000\u0000\u0000\u06a3"
            + "\u06a4\u0001\u0000\u0000\u0000\u06a4\u06a5\u0001\u0000\u0000\u0000\u06a5"
            + "\u06a6\u0005\u0194\u0000\u0000\u06a6\u06b5\u0001\u0000\u0000\u0000\u06a7"
            + "\u06a8\u0005\u0129\u0000\u0000\u06a8\u06a9\u0005\u0191\u0000\u0000\u06a9"
            + "\u06aa\u0003\u00b2Y\u0000\u06aa\u06ab\u0005x\u0000\u0000\u06ab\u06ae\u0003"
            + "\u00b2Y\u0000\u06ac\u06ad\u0005t\u0000\u0000\u06ad\u06af\u0003\u00b2Y"
            + "\u0000\u06ae\u06ac\u0001\u0000\u0000\u0000\u06ae\u06af\u0001\u0000\u0000"
            + "\u0000\u06af\u06b0\u0001\u0000\u0000\u0000\u06b0\u06b1\u0005\u0194\u0000"
            + "\u0000\u06b1\u06b5\u0001\u0000\u0000\u0000\u06b2\u06b5\u0005\u016d\u0000"
            + "\u0000\u06b3\u06b5\u0005\u016f\u0000\u0000\u06b4\u05ef\u0001\u0000\u0000"
            + "\u0000\u06b4\u05f0\u0001\u0000\u0000\u0000\u06b4\u05fa\u0001\u0000\u0000"
            + "\u0000\u06b4\u0601\u0001\u0000\u0000\u0000\u06b4\u0602\u0001\u0000\u0000"
            + "\u0000\u06b4\u0604\u0001\u0000\u0000\u0000\u06b4\u0605\u0001\u0000\u0000"
            + "\u0000\u06b4\u0609\u0001\u0000\u0000\u0000\u06b4\u0611\u0001\u0000\u0000"
            + "\u0000\u06b4\u0612\u0001\u0000\u0000\u0000\u06b4\u0614\u0001\u0000\u0000"
            + "\u0000\u06b4\u0627\u0001\u0000\u0000\u0000\u06b4\u063a\u0001\u0000\u0000"
            + "\u0000\u06b4\u064d\u0001\u0000\u0000\u0000\u06b4\u0660\u0001\u0000\u0000"
            + "\u0000\u06b4\u0673\u0001\u0000\u0000\u0000\u06b4\u0686\u0001\u0000\u0000"
            + "\u0000\u06b4\u0695\u0001\u0000\u0000\u0000\u06b4\u06a7\u0001\u0000\u0000"
            + "\u0000\u06b4\u06b2\u0001\u0000\u0000\u0000\u06b4\u06b3\u0001\u0000\u0000"
            + "\u0000\u06b5\u00d1\u0001\u0000\u0000\u0000\u06b6\u06b7\u0003\u00e0p\u0000"
            + "\u06b7\u06b9\u0005\u0191\u0000\u0000\u06b8\u06ba\u0003\u00d4j\u0000\u06b9"
            + "\u06b8\u0001\u0000\u0000\u0000\u06b9\u06ba\u0001\u0000\u0000\u0000\u06ba"
            + "\u06bb\u0001\u0000\u0000\u0000\u06bb\u06bc\u0005\u0194\u0000\u0000\u06bc"
            + "\u00d3\u0001\u0000\u0000\u0000\u06bd\u06c2\u0003\u00d6k\u0000\u06be\u06bf"
            + "\u0005\u0182\u0000\u0000\u06bf\u06c1\u0003\u00d6k\u0000\u06c0\u06be\u0001"
            + "\u0000\u0000\u0000\u06c1\u06c4\u0001\u0000\u0000\u0000\u06c2\u06c0\u0001"
            + "\u0000\u0000\u0000\u06c2\u06c3\u0001\u0000\u0000\u0000\u06c3\u00d5\u0001"
            + "\u0000\u0000\u0000\u06c4\u06c2\u0001\u0000\u0000\u0000\u06c5\u06d1\u0001"
            + "\u0000\u0000\u0000\u06c6\u06cc\u0004k\b\u0000\u06c7\u06c8\u0003\u00e0"
            + "p\u0000\u06c8\u06ca\u0005\u0187\u0000\u0000\u06c9\u06cb\u0005\u018b\u0000"
            + "\u0000\u06ca\u06c9\u0001\u0000\u0000\u0000\u06ca\u06cb\u0001\u0000\u0000"
            + "\u0000\u06cb\u06cd\u0001\u0000\u0000\u0000\u06cc\u06c7\u0001\u0000\u0000"
            + "\u0000\u06cc\u06cd\u0001\u0000\u0000\u0000\u06cd\u06ce\u0001\u0000\u0000"
            + "\u0000\u06ce\u06d1\u0003\u00b2Y\u0000\u06cf\u06d1\u0005\u018f\u0000\u0000"
            + "\u06d0\u06c5\u0001\u0000\u0000\u0000\u06d0\u06c6\u0001\u0000\u0000\u0000"
            + "\u06d0\u06cf\u0001\u0000\u0000\u0000\u06d1\u00d7\u0001\u0000\u0000\u0000"
            + "\u06d2\u06d3\u0003\u00dam\u0000\u06d3\u00d9\u0001\u0000\u0000\u0000\u06d4"
            + "\u06d9\u0003\u00e0p\u0000\u06d5\u06d6\u0005\u0185\u0000\u0000\u06d6\u06d8"
            + "\u0003\u00e0p\u0000\u06d7\u06d5\u0001\u0000\u0000\u0000\u06d8\u06db\u0001"
            + "\u0000\u0000\u0000\u06d9\u06d7\u0001\u0000\u0000\u0000\u06d9\u06da\u0001"
            + "\u0000\u0000\u0000\u06da\u00db\u0001\u0000\u0000\u0000\u06db\u06d9\u0001"
            + "\u0000\u0000\u0000\u06dc\u06dd\u0005D\u0000\u0000\u06dd\u06de\u0003\u00e4"
            + "r\u0000\u06de\u00dd\u0001\u0000\u0000\u0000\u06df\u06e0\u0005\u0137\u0000"
            + "\u0000\u06e0\u06e1\u0003\u00e4r\u0000\u06e1\u00df\u0001\u0000\u0000\u0000"
            + "\u06e2\u06e4\u0005\u0197\u0000\u0000\u06e3\u06e2\u0001\u0000\u0000\u0000"
            + "\u06e3\u06e4\u0001\u0000\u0000\u0000\u06e4\u06e5\u0001\u0000\u0000\u0000"
            + "\u06e5\u06ea\u0003\u00e2q\u0000\u06e6\u06e7\u0005\u0185\u0000\u0000\u06e7"
            + "\u06e9\u0003\u00e2q\u0000\u06e8\u06e6\u0001\u0000\u0000\u0000\u06e9\u06ec"
            + "\u0001\u0000\u0000\u0000\u06ea\u06e8\u0001\u0000\u0000\u0000\u06ea\u06eb"
            + "\u0001\u0000\u0000\u0000\u06eb\u00e1\u0001\u0000\u0000\u0000\u06ec\u06ea"
            + "\u0001\u0000\u0000\u0000\u06ed\u06f0\u0005\u0198\u0000\u0000\u06ee\u06f0"
            + "\u0003\u00eew\u0000\u06ef\u06ed\u0001\u0000\u0000\u0000\u06ef\u06ee\u0001"
            + "\u0000\u0000\u0000\u06f0\u00e3\u0001\u0000\u0000\u0000\u06f1\u06f4\u0005"
            + "\u0199\u0000\u0000\u06f2\u06f4\u0005\u019a\u0000\u0000\u06f3\u06f1\u0001"
            + "\u0000\u0000\u0000\u06f3\u06f2\u0001\u0000\u0000\u0000\u06f4\u00e5\u0001"
            + "\u0000\u0000\u0000\u06f5\u06f7\u0007\u0017\u0000\u0000\u06f6\u06f5\u0001"
            + "\u0000\u0000\u0000\u06f6\u06f7\u0001\u0000\u0000\u0000\u06f7\u06f8\u0001"
            + "\u0000\u0000\u0000\u06f8\u06f9\u0005\u019b\u0000\u0000\u06f9\u00e7\u0001"
            + "\u0000\u0000\u0000\u06fa\u06fc\u0007\u0017\u0000\u0000\u06fb\u06fa\u0001"
            + "\u0000\u0000\u0000\u06fb\u06fc\u0001\u0000\u0000\u0000\u06fc\u06fd\u0001"
            + "\u0000\u0000\u0000\u06fd\u06fe\u0005\u019c\u0000\u0000\u06fe\u00e9\u0001"
            + "\u0000\u0000\u0000\u06ff\u0700\u0007\u0018\u0000\u0000\u0700\u00eb\u0001"
            + "\u0000\u0000\u0000\u0701\u0702\u0005\u00c8\u0000\u0000\u0702\u00ed\u0001"
            + "\u0000\u0000\u0000\u0703\u0704\u0007\u0019\u0000\u0000\u0704\u00ef\u0001"
            + "\u0000\u0000\u0000\u00e1\u00f2\u0105\u0109\u0110\u0113\u0118\u011c\u0125"
            + "\u012a\u0132\u0137\u0140\u014c\u0151\u0154\u0168\u016c\u0171\u0178\u0181"
            + "\u0184\u018b\u0193\u0199\u019e\u01a1\u01a7\u01b5\u01bf\u01c5\u01ca\u01cf"
            + "\u01d4\u01d8\u01dd\u01e7\u01f3\u01fa\u01fd\u0209\u020e\u0214\u021b\u0222"
            + "\u0226\u022b\u022f\u0234\u0237\u023c\u023f\u0242\u0247\u024b\u024d\u0253"
            + "\u025a\u025d\u0278\u027a\u027f\u0283\u028c\u0292\u029c\u02a4\u02aa\u02b3"
            + "\u02b5\u02b9\u02bd\u02c5\u02d0\u02d9\u02e0\u02e8\u02f2\u02f7\u0304\u030f"
            + "\u0316\u031d\u0321\u0325\u0329\u032b\u0330\u0333\u0336\u0339\u033d\u0340"
            + "\u0343\u0346\u0349\u0350\u035b\u035f\u0362\u0365\u0369\u0371\u037a\u037e"
            + "\u0388\u0390\u0396\u039a\u039d\u03a3\u03ac\u03af\u03b4\u03b7\u03c1\u03c6"
            + "\u03cf\u03d4\u03d8\u03e1\u03e5\u03f3\u0403\u0408\u0413\u041e\u0420\u0427"
            + "\u042a\u0431\u0436\u043c\u043f\u0442\u0449\u044d\u0451\u0455\u045b\u0461"
            + "\u0468\u0470\u0476\u047b\u0486\u048f\u0493\u049c\u04a0\u04aa\u04af\u04c5"
            + "\u04c8\u04db\u04eb\u04ed\u04f8\u0507\u0513\u0517\u0522\u0526\u052e\u0532"
            + "\u0542\u0547\u054c\u0550\u0554\u0559\u055d\u0561\u0578\u057a\u058c\u058e"
            + "\u0596\u059b\u05a0\u05a5\u05b2\u05b7\u05bc\u05c1\u05c6\u05cb\u05d0\u05d5"
            + "\u05d7\u05de\u05e1\u05ec\u05f6\u05fe\u0609\u060f\u0620\u0623\u0633\u0636"
            + "\u0646\u0649\u0659\u065c\u066c\u066f\u067f\u0682\u0690\u069f\u06a3\u06ae"
            + "\u06b4\u06b9\u06c2\u06ca\u06cc\u06d0\u06d9\u06e3\u06ea\u06ef\u06f3\u06f6"
            + "\u06fb";
    public static final ATN _ATN = new ATNDeserializer().deserialize(_serializedATN.toCharArray());
    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}
