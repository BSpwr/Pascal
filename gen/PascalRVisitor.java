// Generated from /Users/Faux/IdeaProjects/Pascal/src/PascalR.g4 by ANTLR 4.8

  import java.io.*;
  import java.util.*;
  import java.util.stream.IntStream;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PascalRParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PascalRVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PascalRParser#debug}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDebug(PascalRParser.DebugContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalRParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(PascalRParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalRParser#programHeading}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgramHeading(PascalRParser.ProgramHeadingContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalRParser#programImports}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgramImports(PascalRParser.ProgramImportsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalRParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(PascalRParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalRParser#identifierList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierList(PascalRParser.IdentifierListContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalRParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(PascalRParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalRParser#comment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComment(PascalRParser.CommentContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalRParser#typeLab}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeLab(PascalRParser.TypeLabContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalRParser#varLab}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarLab(PascalRParser.VarLabContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalRParser#constLab}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstLab(PascalRParser.ConstLabContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalRParser#progLab}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgLab(PascalRParser.ProgLabContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalRParser#typeDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDef(PascalRParser.TypeDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalRParser#typeType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeType(PascalRParser.TypeTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalRParser#varDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDef(PascalRParser.VarDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalRParser#varList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarList(PascalRParser.VarListContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalRParser#varType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarType(PascalRParser.VarTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalRParser#arrayAlloc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAlloc(PascalRParser.ArrayAllocContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalRParser#range}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRange(PascalRParser.RangeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalRParser#constDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstDef(PascalRParser.ConstDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalRParser#implementation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImplementation(PascalRParser.ImplementationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalRParser#singleStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleStatement(PascalRParser.SingleStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalRParser#branch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBranch(PascalRParser.BranchContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalRParser#cases}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCases(PascalRParser.CasesContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalRParser#caseList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseList(PascalRParser.CaseListContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalRParser#caseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseStatement(PascalRParser.CaseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalRParser#elseCase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseCase(PascalRParser.ElseCaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalRParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(PascalRParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalRParser#args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgs(PascalRParser.ArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalRParser#writeln}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWriteln(PascalRParser.WritelnContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalRParser#writelnFunc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWritelnFunc(PascalRParser.WritelnFuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalRParser#readln}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadln(PascalRParser.ReadlnContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalRParser#readlnFunc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadlnFunc(PascalRParser.ReadlnFuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalRParser#sqrt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSqrt(PascalRParser.SqrtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalRParser#ln}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLn(PascalRParser.LnContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalRParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp(PascalRParser.ExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalRParser#sine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSine(PascalRParser.SineContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalRParser#cosine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCosine(PascalRParser.CosineContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalRParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(PascalRParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalRParser#string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(PascalRParser.StringContext ctx);
}