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

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link StartDBSqlParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface StartDBSqlVisitor<T> extends ParseTreeVisitor<T> {
    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#program}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitProgram(StartDBSqlParser.ProgramContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#stmt}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitStmt(StartDBSqlParser.StmtContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#dbDotTable}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDbDotTable(StartDBSqlParser.DbDotTableContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#userDotDbDotTable}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitUserDotDbDotTable(StartDBSqlParser.UserDotDbDotTableContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#assignmentStmtItem}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAssignmentStmtItem(StartDBSqlParser.AssignmentStmtItemContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#assignmentStmtSingleItem}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAssignmentStmtSingleItem(StartDBSqlParser.AssignmentStmtSingleItemContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#assignmentStmtMultipleItem}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAssignmentStmtMultipleItem(StartDBSqlParser.AssignmentStmtMultipleItemContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#assignmentStmtSelectItem}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAssignmentStmtSelectItem(StartDBSqlParser.AssignmentStmtSelectItemContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#showCreateTableStmt}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitShowCreateTableStmt(StartDBSqlParser.ShowCreateTableStmtContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#showStatusStmt}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitShowStatusStmt(StartDBSqlParser.ShowStatusStmtContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#createTableStmt}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCreateTableStmt(StartDBSqlParser.CreateTableStmtContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#createUserStmt}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCreateUserStmt(StartDBSqlParser.CreateUserStmtContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#create_table_definition}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCreate_table_definition(StartDBSqlParser.Create_table_definitionContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#create_table_columns}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCreate_table_columns(StartDBSqlParser.Create_table_columnsContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#create_table_columns_item}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCreate_table_columns_item(StartDBSqlParser.Create_table_columns_itemContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#column_name}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitColumn_name(StartDBSqlParser.Column_nameContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#create_table_column_inline_cons}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCreate_table_column_inline_cons(
        StartDBSqlParser.Create_table_column_inline_consContext ctx
    );

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#create_table_column_cons}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCreate_table_column_cons(StartDBSqlParser.Create_table_column_consContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#create_table_fk_action}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCreate_table_fk_action(StartDBSqlParser.Create_table_fk_actionContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#create_table_preoptions}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCreate_table_preoptions(StartDBSqlParser.Create_table_preoptionsContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#create_table_preoptions_item}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCreate_table_preoptions_item(StartDBSqlParser.Create_table_preoptions_itemContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#create_table_preoptions_td_item}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCreate_table_preoptions_td_item(
        StartDBSqlParser.Create_table_preoptions_td_itemContext ctx
    );

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#create_table_options}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCreate_table_options(StartDBSqlParser.Create_table_optionsContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#create_table_options_item}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCreate_table_options_item(StartDBSqlParser.Create_table_options_itemContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#create_table_options_mysql_item}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCreate_table_options_mysql_item(
        StartDBSqlParser.Create_table_options_mysql_itemContext ctx
    );

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#createIndexStmt}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCreateIndexStmt(StartDBSqlParser.CreateIndexStmtContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#createIndexCol}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCreateIndexCol(StartDBSqlParser.CreateIndexColContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#dropTableIndexStmt}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDropTableIndexStmt(StartDBSqlParser.DropTableIndexStmtContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#dtype_default}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDtype_default(StartDBSqlParser.Dtype_defaultContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#showTablesStmt}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitShowTablesStmt(StartDBSqlParser.ShowTablesStmtContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#dtype_attr}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDtype_attr(StartDBSqlParser.Dtype_attrContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#dtype}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDtype(StartDBSqlParser.DtypeContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#dtypeLen}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDtypeLen(StartDBSqlParser.DtypeLenContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#createDatabaseStmt}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCreateDatabaseStmt(StartDBSqlParser.CreateDatabaseStmtContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#showDatabasesStmt}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitShowDatabasesStmt(StartDBSqlParser.ShowDatabasesStmtContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#dropDatabaseStmt}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDropDatabaseStmt(StartDBSqlParser.DropDatabaseStmtContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#createDatabaseOption}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCreateDatabaseOption(StartDBSqlParser.CreateDatabaseOptionContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#dropTableStmt}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDropTableStmt(StartDBSqlParser.DropTableStmtContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#insertStmt}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitInsertStmt(StartDBSqlParser.InsertStmtContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#insertStmtCols}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitInsertStmtCols(StartDBSqlParser.InsertStmtColsContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#insertStmtRows}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitInsertStmtRows(StartDBSqlParser.InsertStmtRowsContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#insertStmtRow}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitInsertStmtRow(StartDBSqlParser.InsertStmtRowContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#truncateStmt}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitTruncateStmt(StartDBSqlParser.TruncateStmtContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#useStmt}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitUseStmt(StartDBSqlParser.UseStmtContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#selectStmt}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSelectStmt(StartDBSqlParser.SelectStmtContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#cteSelectStmt}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCteSelectStmt(StartDBSqlParser.CteSelectStmtContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#cteSelectStmtItem}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCteSelectStmtItem(StartDBSqlParser.CteSelectStmtItemContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#cteSelectCols}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCteSelectCols(StartDBSqlParser.CteSelectColsContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#fullselectStmt}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFullselectStmt(StartDBSqlParser.FullselectStmtContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#fullselectStmtItem}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFullselectStmtItem(StartDBSqlParser.FullselectStmtItemContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#fullselectSetClause}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFullselectSetClause(StartDBSqlParser.FullselectSetClauseContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#subselectStmt}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSubselectStmt(StartDBSqlParser.SubselectStmtContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#selectList}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSelectList(StartDBSqlParser.SelectListContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#selectListSet}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSelectListSet(StartDBSqlParser.SelectListSetContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#selectListLimit}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSelectListLimit(StartDBSqlParser.SelectListLimitContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#selectListItem}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSelectListItem(StartDBSqlParser.SelectListItemContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#selectListAlias}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSelectListAlias(StartDBSqlParser.SelectListAliasContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#selectListAsterisk}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSelectListAsterisk(StartDBSqlParser.SelectListAsteriskContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#intoClause}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitIntoClause(StartDBSqlParser.IntoClauseContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#fromClause}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFromClause(StartDBSqlParser.FromClauseContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#fromTableClause}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFromTableClause(StartDBSqlParser.FromTableClauseContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#fromTableNameClause}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFromTableNameClause(StartDBSqlParser.FromTableNameClauseContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#fromSubselectClause}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFromSubselectClause(StartDBSqlParser.FromSubselectClauseContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#fromJoinClause}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFromJoinClause(StartDBSqlParser.FromJoinClauseContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#fromJoinTypeClause}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFromJoinTypeClause(StartDBSqlParser.FromJoinTypeClauseContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#fromTableValuesClause}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFromTableValuesClause(StartDBSqlParser.FromTableValuesClauseContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#fromTableValuesRow}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFromTableValuesRow(StartDBSqlParser.FromTableValuesRowContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#fromAliasClause}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFromAliasClause(StartDBSqlParser.FromAliasClauseContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#tableName}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitTableName(StartDBSqlParser.TableNameContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#whereClause}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitWhereClause(StartDBSqlParser.WhereClauseContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#groupByClause}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitGroupByClause(StartDBSqlParser.GroupByClauseContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#havingClause}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitHavingClause(StartDBSqlParser.HavingClauseContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#qualifyClause}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitQualifyClause(StartDBSqlParser.QualifyClauseContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#orderByClause}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitOrderByClause(StartDBSqlParser.OrderByClauseContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#orderByClauseItem}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitOrderByClauseItem(StartDBSqlParser.OrderByClauseItemContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#sampleClause}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSampleClause(StartDBSqlParser.SampleClauseContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#selectOptions}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSelectOptions(StartDBSqlParser.SelectOptionsContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#selectOptionsItem}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSelectOptionsItem(StartDBSqlParser.SelectOptionsItemContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#updateStmt}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitUpdateStmt(StartDBSqlParser.UpdateStmtContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#updateAssignment}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitUpdateAssignment(StartDBSqlParser.UpdateAssignmentContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#updateTable}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitUpdateTable(StartDBSqlParser.UpdateTableContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#updateUpsert}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitUpdateUpsert(StartDBSqlParser.UpdateUpsertContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#deleteStmt}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDeleteStmt(StartDBSqlParser.DeleteStmtContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#deleteAlias}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDeleteAlias(StartDBSqlParser.DeleteAliasContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#describeStmt}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDescribeStmt(StartDBSqlParser.DescribeStmtContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#boolExpr}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitBoolExpr(StartDBSqlParser.BoolExprContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#boolExprAtom}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitBoolExprAtom(StartDBSqlParser.BoolExprAtomContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#boolExprUnary}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitBoolExprUnary(StartDBSqlParser.BoolExprUnaryContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#boolExprSingleIn}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitBoolExprSingleIn(StartDBSqlParser.BoolExprSingleInContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#boolExprMultiIn}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitBoolExprMultiIn(StartDBSqlParser.BoolExprMultiInContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#boolExprBinary}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitBoolExprBinary(StartDBSqlParser.BoolExprBinaryContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#boolExprLogicalOperator}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitBoolExprLogicalOperator(StartDBSqlParser.BoolExprLogicalOperatorContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#boolExprBinaryOperator}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitBoolExprBinaryOperator(StartDBSqlParser.BoolExprBinaryOperatorContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#expr}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExpr(StartDBSqlParser.ExprContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#exprAtom}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExprAtom(StartDBSqlParser.ExprAtomContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#exprInterval}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExprInterval(StartDBSqlParser.ExprIntervalContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#intervalItem}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitIntervalItem(StartDBSqlParser.IntervalItemContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#exprConcat}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExprConcat(StartDBSqlParser.ExprConcatContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#exprConcatItem}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExprConcatItem(StartDBSqlParser.ExprConcatItemContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#exprCase}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExprCase(StartDBSqlParser.ExprCaseContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#exprCaseSimple}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExprCaseSimple(StartDBSqlParser.ExprCaseSimpleContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#exprCaseSearched}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExprCaseSearched(StartDBSqlParser.ExprCaseSearchedContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#exprCaseItem}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExprCaseItem(StartDBSqlParser.ExprCaseItemContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#exprCursorAttribute}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExprCursorAttribute(StartDBSqlParser.ExprCursorAttributeContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#exprAggWindowFunc}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExprAggWindowFunc(StartDBSqlParser.ExprAggWindowFuncContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#exprFuncAllDistinct}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExprFuncAllDistinct(StartDBSqlParser.ExprFuncAllDistinctContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#exprFuncOverClause}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExprFuncOverClause(StartDBSqlParser.ExprFuncOverClauseContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#exprFuncPartitionByClause}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExprFuncPartitionByClause(StartDBSqlParser.ExprFuncPartitionByClauseContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#exprSpecFunc}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExprSpecFunc(StartDBSqlParser.ExprSpecFuncContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#exprFunc}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExprFunc(StartDBSqlParser.ExprFuncContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#exprFuncParams}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExprFuncParams(StartDBSqlParser.ExprFuncParamsContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#funcParam}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFuncParam(StartDBSqlParser.FuncParamContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#table_name}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitTable_name(StartDBSqlParser.Table_nameContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#user_name}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitUser_name(StartDBSqlParser.User_nameContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#qident}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitQident(StartDBSqlParser.QidentContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#dateLiteral}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDateLiteral(StartDBSqlParser.DateLiteralContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#timestampLiteral}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitTimestampLiteral(StartDBSqlParser.TimestampLiteralContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#ident}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitIdent(StartDBSqlParser.IdentContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#identItem}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitIdentItem(StartDBSqlParser.IdentItemContext ctx);

    /**
     * Visit a parse tree produced by the {@code singleQuotedString}
     * labeled alternative in {@link StartDBSqlParser#string}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSingleQuotedString(StartDBSqlParser.SingleQuotedStringContext ctx);

    /**
     * Visit a parse tree produced by the {@code doubleQuotedString}
     * labeled alternative in {@link StartDBSqlParser#string}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDoubleQuotedString(StartDBSqlParser.DoubleQuotedStringContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#intNumber}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitIntNumber(StartDBSqlParser.IntNumberContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#decNumber}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDecNumber(StartDBSqlParser.DecNumberContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#boolLiteral}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitBoolLiteral(StartDBSqlParser.BoolLiteralContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#nullConst}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitNullConst(StartDBSqlParser.NullConstContext ctx);

    /**
     * Visit a parse tree produced by {@link StartDBSqlParser#nonReservedWords}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitNonReservedWords(StartDBSqlParser.NonReservedWordsContext ctx);
}
