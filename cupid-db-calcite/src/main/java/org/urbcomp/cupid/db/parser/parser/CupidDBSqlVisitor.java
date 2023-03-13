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

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CupidDBSqlParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CupidDBSqlVisitor<T> extends ParseTreeVisitor<T> {
    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#program}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitProgram(CupidDBSqlParser.ProgramContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#stmt}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitStmt(CupidDBSqlParser.StmtContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#dbDotTable}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDbDotTable(CupidDBSqlParser.DbDotTableContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#userDotDbDotTable}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitUserDotDbDotTable(CupidDBSqlParser.UserDotDbDotTableContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#assignmentStmtItem}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAssignmentStmtItem(CupidDBSqlParser.AssignmentStmtItemContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#assignmentStmtSingleItem}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAssignmentStmtSingleItem(CupidDBSqlParser.AssignmentStmtSingleItemContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#assignmentStmtMultipleItem}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAssignmentStmtMultipleItem(CupidDBSqlParser.AssignmentStmtMultipleItemContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#assignmentStmtSelectItem}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAssignmentStmtSelectItem(CupidDBSqlParser.AssignmentStmtSelectItemContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#showCreateTableStmt}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitShowCreateTableStmt(CupidDBSqlParser.ShowCreateTableStmtContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#showStatusStmt}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitShowStatusStmt(CupidDBSqlParser.ShowStatusStmtContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#showIndexStmt}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitShowIndexStmt(CupidDBSqlParser.ShowIndexStmtContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#createTableStmt}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCreateTableStmt(CupidDBSqlParser.CreateTableStmtContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#createUserStmt}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCreateUserStmt(CupidDBSqlParser.CreateUserStmtContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#create_table_definition}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCreate_table_definition(CupidDBSqlParser.Create_table_definitionContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#create_table_columns}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCreate_table_columns(CupidDBSqlParser.Create_table_columnsContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#create_table_columns_item}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCreate_table_columns_item(CupidDBSqlParser.Create_table_columns_itemContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#key_list}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitKey_list(CupidDBSqlParser.Key_listContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#column_name}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitColumn_name(CupidDBSqlParser.Column_nameContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#create_table_column_inline_cons}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCreate_table_column_inline_cons(
        CupidDBSqlParser.Create_table_column_inline_consContext ctx
    );

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#create_table_column_cons}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCreate_table_column_cons(CupidDBSqlParser.Create_table_column_consContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#create_table_fk_action}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCreate_table_fk_action(CupidDBSqlParser.Create_table_fk_actionContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#create_table_preoptions}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCreate_table_preoptions(CupidDBSqlParser.Create_table_preoptionsContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#create_table_preoptions_item}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCreate_table_preoptions_item(CupidDBSqlParser.Create_table_preoptions_itemContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#create_table_preoptions_td_item}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCreate_table_preoptions_td_item(
        CupidDBSqlParser.Create_table_preoptions_td_itemContext ctx
    );

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#create_table_options}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCreate_table_options(CupidDBSqlParser.Create_table_optionsContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#create_table_options_item}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCreate_table_options_item(CupidDBSqlParser.Create_table_options_itemContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#create_table_options_mysql_item}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCreate_table_options_mysql_item(
        CupidDBSqlParser.Create_table_options_mysql_itemContext ctx
    );

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#createIndexStmt}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCreateIndexStmt(CupidDBSqlParser.CreateIndexStmtContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#createIndexCol}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCreateIndexCol(CupidDBSqlParser.CreateIndexColContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#dropTableIndexStmt}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDropTableIndexStmt(CupidDBSqlParser.DropTableIndexStmtContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#dtype_default}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDtype_default(CupidDBSqlParser.Dtype_defaultContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#showTablesStmt}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitShowTablesStmt(CupidDBSqlParser.ShowTablesStmtContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#dtype_attr}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDtype_attr(CupidDBSqlParser.Dtype_attrContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#dtype}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDtype(CupidDBSqlParser.DtypeContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#dtypeLen}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDtypeLen(CupidDBSqlParser.DtypeLenContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#createDatabaseStmt}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCreateDatabaseStmt(CupidDBSqlParser.CreateDatabaseStmtContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#showDatabasesStmt}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitShowDatabasesStmt(CupidDBSqlParser.ShowDatabasesStmtContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#dropDatabaseStmt}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDropDatabaseStmt(CupidDBSqlParser.DropDatabaseStmtContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#createDatabaseOption}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCreateDatabaseOption(CupidDBSqlParser.CreateDatabaseOptionContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#dropTableStmt}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDropTableStmt(CupidDBSqlParser.DropTableStmtContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#insertStmt}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitInsertStmt(CupidDBSqlParser.InsertStmtContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#insertStmtCols}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitInsertStmtCols(CupidDBSqlParser.InsertStmtColsContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#insertStmtRows}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitInsertStmtRows(CupidDBSqlParser.InsertStmtRowsContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#insertStmtRow}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitInsertStmtRow(CupidDBSqlParser.InsertStmtRowContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#truncateStmt}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitTruncateStmt(CupidDBSqlParser.TruncateStmtContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#useStmt}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitUseStmt(CupidDBSqlParser.UseStmtContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#selectStmt}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSelectStmt(CupidDBSqlParser.SelectStmtContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#cteSelectStmt}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCteSelectStmt(CupidDBSqlParser.CteSelectStmtContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#cteSelectStmtItem}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCteSelectStmtItem(CupidDBSqlParser.CteSelectStmtItemContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#cteSelectCols}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCteSelectCols(CupidDBSqlParser.CteSelectColsContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#fullselectStmt}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFullselectStmt(CupidDBSqlParser.FullselectStmtContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#fullselectStmtItem}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFullselectStmtItem(CupidDBSqlParser.FullselectStmtItemContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#fullselectSetClause}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFullselectSetClause(CupidDBSqlParser.FullselectSetClauseContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#subselectStmt}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSubselectStmt(CupidDBSqlParser.SubselectStmtContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#selectList}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSelectList(CupidDBSqlParser.SelectListContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#selectListSet}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSelectListSet(CupidDBSqlParser.SelectListSetContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#selectListLimit}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSelectListLimit(CupidDBSqlParser.SelectListLimitContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#selectListItem}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSelectListItem(CupidDBSqlParser.SelectListItemContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#selectListAlias}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSelectListAlias(CupidDBSqlParser.SelectListAliasContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#selectListAsterisk}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSelectListAsterisk(CupidDBSqlParser.SelectListAsteriskContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#intoClause}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitIntoClause(CupidDBSqlParser.IntoClauseContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#fromClause}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFromClause(CupidDBSqlParser.FromClauseContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#fromTableClause}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFromTableClause(CupidDBSqlParser.FromTableClauseContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#fromTableNameClause}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFromTableNameClause(CupidDBSqlParser.FromTableNameClauseContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#fromSubselectClause}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFromSubselectClause(CupidDBSqlParser.FromSubselectClauseContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#fromJoinClause}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFromJoinClause(CupidDBSqlParser.FromJoinClauseContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#fromJoinTypeClause}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFromJoinTypeClause(CupidDBSqlParser.FromJoinTypeClauseContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#fromTableValuesClause}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFromTableValuesClause(CupidDBSqlParser.FromTableValuesClauseContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#fromTableValuesRow}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFromTableValuesRow(CupidDBSqlParser.FromTableValuesRowContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#fromAliasClause}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFromAliasClause(CupidDBSqlParser.FromAliasClauseContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#tableName}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitTableName(CupidDBSqlParser.TableNameContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#whereClause}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitWhereClause(CupidDBSqlParser.WhereClauseContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#groupByClause}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitGroupByClause(CupidDBSqlParser.GroupByClauseContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#havingClause}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitHavingClause(CupidDBSqlParser.HavingClauseContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#qualifyClause}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitQualifyClause(CupidDBSqlParser.QualifyClauseContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#orderByClause}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitOrderByClause(CupidDBSqlParser.OrderByClauseContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#orderByClauseItem}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitOrderByClauseItem(CupidDBSqlParser.OrderByClauseItemContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#sampleClause}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSampleClause(CupidDBSqlParser.SampleClauseContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#selectOptions}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSelectOptions(CupidDBSqlParser.SelectOptionsContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#selectOptionsItem}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSelectOptionsItem(CupidDBSqlParser.SelectOptionsItemContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#updateStmt}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitUpdateStmt(CupidDBSqlParser.UpdateStmtContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#updateAssignment}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitUpdateAssignment(CupidDBSqlParser.UpdateAssignmentContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#updateTable}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitUpdateTable(CupidDBSqlParser.UpdateTableContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#updateUpsert}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitUpdateUpsert(CupidDBSqlParser.UpdateUpsertContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#deleteStmt}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDeleteStmt(CupidDBSqlParser.DeleteStmtContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#deleteAlias}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDeleteAlias(CupidDBSqlParser.DeleteAliasContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#describeStmt}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDescribeStmt(CupidDBSqlParser.DescribeStmtContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#boolExpr}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitBoolExpr(CupidDBSqlParser.BoolExprContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#boolExprAtom}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitBoolExprAtom(CupidDBSqlParser.BoolExprAtomContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#boolExprUnary}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitBoolExprUnary(CupidDBSqlParser.BoolExprUnaryContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#boolExprSingleIn}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitBoolExprSingleIn(CupidDBSqlParser.BoolExprSingleInContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#boolExprMultiIn}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitBoolExprMultiIn(CupidDBSqlParser.BoolExprMultiInContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#boolExprBinary}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitBoolExprBinary(CupidDBSqlParser.BoolExprBinaryContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#boolExprLogicalOperator}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitBoolExprLogicalOperator(CupidDBSqlParser.BoolExprLogicalOperatorContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#boolExprBinaryOperator}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitBoolExprBinaryOperator(CupidDBSqlParser.BoolExprBinaryOperatorContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#expr}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExpr(CupidDBSqlParser.ExprContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#exprAtom}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExprAtom(CupidDBSqlParser.ExprAtomContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#exprInterval}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExprInterval(CupidDBSqlParser.ExprIntervalContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#intervalItem}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitIntervalItem(CupidDBSqlParser.IntervalItemContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#exprConcat}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExprConcat(CupidDBSqlParser.ExprConcatContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#exprConcatItem}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExprConcatItem(CupidDBSqlParser.ExprConcatItemContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#exprCase}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExprCase(CupidDBSqlParser.ExprCaseContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#exprCaseSimple}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExprCaseSimple(CupidDBSqlParser.ExprCaseSimpleContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#exprCaseSearched}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExprCaseSearched(CupidDBSqlParser.ExprCaseSearchedContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#exprCaseItem}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExprCaseItem(CupidDBSqlParser.ExprCaseItemContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#exprCursorAttribute}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExprCursorAttribute(CupidDBSqlParser.ExprCursorAttributeContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#exprAggWindowFunc}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExprAggWindowFunc(CupidDBSqlParser.ExprAggWindowFuncContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#exprFuncAllDistinct}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExprFuncAllDistinct(CupidDBSqlParser.ExprFuncAllDistinctContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#exprFuncOverClause}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExprFuncOverClause(CupidDBSqlParser.ExprFuncOverClauseContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#exprFuncPartitionByClause}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExprFuncPartitionByClause(CupidDBSqlParser.ExprFuncPartitionByClauseContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#exprSpecFunc}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExprSpecFunc(CupidDBSqlParser.ExprSpecFuncContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#exprFunc}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExprFunc(CupidDBSqlParser.ExprFuncContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#exprFuncParams}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExprFuncParams(CupidDBSqlParser.ExprFuncParamsContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#funcParam}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFuncParam(CupidDBSqlParser.FuncParamContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#table_name}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitTable_name(CupidDBSqlParser.Table_nameContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#user_name}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitUser_name(CupidDBSqlParser.User_nameContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#qident}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitQident(CupidDBSqlParser.QidentContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#dateLiteral}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDateLiteral(CupidDBSqlParser.DateLiteralContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#timestampLiteral}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitTimestampLiteral(CupidDBSqlParser.TimestampLiteralContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#ident}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitIdent(CupidDBSqlParser.IdentContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#identItem}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitIdentItem(CupidDBSqlParser.IdentItemContext ctx);

    /**
     * Visit a parse tree produced by the {@code singleQuotedString}
     * labeled alternative in {@link CupidDBSqlParser#string}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSingleQuotedString(CupidDBSqlParser.SingleQuotedStringContext ctx);

    /**
     * Visit a parse tree produced by the {@code doubleQuotedString}
     * labeled alternative in {@link CupidDBSqlParser#string}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDoubleQuotedString(CupidDBSqlParser.DoubleQuotedStringContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#intNumber}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitIntNumber(CupidDBSqlParser.IntNumberContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#decNumber}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDecNumber(CupidDBSqlParser.DecNumberContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#boolLiteral}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitBoolLiteral(CupidDBSqlParser.BoolLiteralContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#nullConst}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitNullConst(CupidDBSqlParser.NullConstContext ctx);

    /**
     * Visit a parse tree produced by {@link CupidDBSqlParser#nonReservedWords}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitNonReservedWords(CupidDBSqlParser.NonReservedWordsContext ctx);
}
