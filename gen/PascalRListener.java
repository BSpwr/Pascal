// Generated from /Users/Faux/IdeaProjects/Pascal/src/PascalR.g4 by ANTLR 4.8

  import java.io.*;
  import java.util.*;
  import java.util.stream.IntStream;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PascalRParser}.
 */
public interface PascalRListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PascalRParser#debug}.
	 * @param ctx the parse tree
	 */
	void enterDebug(PascalRParser.DebugContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalRParser#debug}.
	 * @param ctx the parse tree
	 */
	void exitDebug(PascalRParser.DebugContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalRParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(PascalRParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalRParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(PascalRParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalRParser#programHeading}.
	 * @param ctx the parse tree
	 */
	void enterProgramHeading(PascalRParser.ProgramHeadingContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalRParser#programHeading}.
	 * @param ctx the parse tree
	 */
	void exitProgramHeading(PascalRParser.ProgramHeadingContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalRParser#programImports}.
	 * @param ctx the parse tree
	 */
	void enterProgramImports(PascalRParser.ProgramImportsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalRParser#programImports}.
	 * @param ctx the parse tree
	 */
	void exitProgramImports(PascalRParser.ProgramImportsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalRParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(PascalRParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalRParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(PascalRParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalRParser#identifierList}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierList(PascalRParser.IdentifierListContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalRParser#identifierList}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierList(PascalRParser.IdentifierListContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalRParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(PascalRParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalRParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(PascalRParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalRParser#comment}.
	 * @param ctx the parse tree
	 */
	void enterComment(PascalRParser.CommentContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalRParser#comment}.
	 * @param ctx the parse tree
	 */
	void exitComment(PascalRParser.CommentContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalRParser#typeLab}.
	 * @param ctx the parse tree
	 */
	void enterTypeLab(PascalRParser.TypeLabContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalRParser#typeLab}.
	 * @param ctx the parse tree
	 */
	void exitTypeLab(PascalRParser.TypeLabContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalRParser#varLab}.
	 * @param ctx the parse tree
	 */
	void enterVarLab(PascalRParser.VarLabContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalRParser#varLab}.
	 * @param ctx the parse tree
	 */
	void exitVarLab(PascalRParser.VarLabContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalRParser#constLab}.
	 * @param ctx the parse tree
	 */
	void enterConstLab(PascalRParser.ConstLabContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalRParser#constLab}.
	 * @param ctx the parse tree
	 */
	void exitConstLab(PascalRParser.ConstLabContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalRParser#progLab}.
	 * @param ctx the parse tree
	 */
	void enterProgLab(PascalRParser.ProgLabContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalRParser#progLab}.
	 * @param ctx the parse tree
	 */
	void exitProgLab(PascalRParser.ProgLabContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalRParser#typeDef}.
	 * @param ctx the parse tree
	 */
	void enterTypeDef(PascalRParser.TypeDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalRParser#typeDef}.
	 * @param ctx the parse tree
	 */
	void exitTypeDef(PascalRParser.TypeDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalRParser#typeType}.
	 * @param ctx the parse tree
	 */
	void enterTypeType(PascalRParser.TypeTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalRParser#typeType}.
	 * @param ctx the parse tree
	 */
	void exitTypeType(PascalRParser.TypeTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalRParser#varDef}.
	 * @param ctx the parse tree
	 */
	void enterVarDef(PascalRParser.VarDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalRParser#varDef}.
	 * @param ctx the parse tree
	 */
	void exitVarDef(PascalRParser.VarDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalRParser#varList}.
	 * @param ctx the parse tree
	 */
	void enterVarList(PascalRParser.VarListContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalRParser#varList}.
	 * @param ctx the parse tree
	 */
	void exitVarList(PascalRParser.VarListContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalRParser#varType}.
	 * @param ctx the parse tree
	 */
	void enterVarType(PascalRParser.VarTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalRParser#varType}.
	 * @param ctx the parse tree
	 */
	void exitVarType(PascalRParser.VarTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalRParser#arrayAlloc}.
	 * @param ctx the parse tree
	 */
	void enterArrayAlloc(PascalRParser.ArrayAllocContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalRParser#arrayAlloc}.
	 * @param ctx the parse tree
	 */
	void exitArrayAlloc(PascalRParser.ArrayAllocContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalRParser#range}.
	 * @param ctx the parse tree
	 */
	void enterRange(PascalRParser.RangeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalRParser#range}.
	 * @param ctx the parse tree
	 */
	void exitRange(PascalRParser.RangeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalRParser#constDef}.
	 * @param ctx the parse tree
	 */
	void enterConstDef(PascalRParser.ConstDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalRParser#constDef}.
	 * @param ctx the parse tree
	 */
	void exitConstDef(PascalRParser.ConstDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalRParser#implementation}.
	 * @param ctx the parse tree
	 */
	void enterImplementation(PascalRParser.ImplementationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalRParser#implementation}.
	 * @param ctx the parse tree
	 */
	void exitImplementation(PascalRParser.ImplementationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalRParser#singleStatement}.
	 * @param ctx the parse tree
	 */
	void enterSingleStatement(PascalRParser.SingleStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalRParser#singleStatement}.
	 * @param ctx the parse tree
	 */
	void exitSingleStatement(PascalRParser.SingleStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalRParser#branch}.
	 * @param ctx the parse tree
	 */
	void enterBranch(PascalRParser.BranchContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalRParser#branch}.
	 * @param ctx the parse tree
	 */
	void exitBranch(PascalRParser.BranchContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalRParser#cases}.
	 * @param ctx the parse tree
	 */
	void enterCases(PascalRParser.CasesContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalRParser#cases}.
	 * @param ctx the parse tree
	 */
	void exitCases(PascalRParser.CasesContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalRParser#caseList}.
	 * @param ctx the parse tree
	 */
	void enterCaseList(PascalRParser.CaseListContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalRParser#caseList}.
	 * @param ctx the parse tree
	 */
	void exitCaseList(PascalRParser.CaseListContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalRParser#caseStatement}.
	 * @param ctx the parse tree
	 */
	void enterCaseStatement(PascalRParser.CaseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalRParser#caseStatement}.
	 * @param ctx the parse tree
	 */
	void exitCaseStatement(PascalRParser.CaseStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalRParser#elseCase}.
	 * @param ctx the parse tree
	 */
	void enterElseCase(PascalRParser.ElseCaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalRParser#elseCase}.
	 * @param ctx the parse tree
	 */
	void exitElseCase(PascalRParser.ElseCaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalRParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(PascalRParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalRParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(PascalRParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalRParser#args}.
	 * @param ctx the parse tree
	 */
	void enterArgs(PascalRParser.ArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalRParser#args}.
	 * @param ctx the parse tree
	 */
	void exitArgs(PascalRParser.ArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalRParser#writeln}.
	 * @param ctx the parse tree
	 */
	void enterWriteln(PascalRParser.WritelnContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalRParser#writeln}.
	 * @param ctx the parse tree
	 */
	void exitWriteln(PascalRParser.WritelnContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalRParser#writelnFunc}.
	 * @param ctx the parse tree
	 */
	void enterWritelnFunc(PascalRParser.WritelnFuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalRParser#writelnFunc}.
	 * @param ctx the parse tree
	 */
	void exitWritelnFunc(PascalRParser.WritelnFuncContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalRParser#readln}.
	 * @param ctx the parse tree
	 */
	void enterReadln(PascalRParser.ReadlnContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalRParser#readln}.
	 * @param ctx the parse tree
	 */
	void exitReadln(PascalRParser.ReadlnContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalRParser#readlnFunc}.
	 * @param ctx the parse tree
	 */
	void enterReadlnFunc(PascalRParser.ReadlnFuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalRParser#readlnFunc}.
	 * @param ctx the parse tree
	 */
	void exitReadlnFunc(PascalRParser.ReadlnFuncContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalRParser#sqrt}.
	 * @param ctx the parse tree
	 */
	void enterSqrt(PascalRParser.SqrtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalRParser#sqrt}.
	 * @param ctx the parse tree
	 */
	void exitSqrt(PascalRParser.SqrtContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalRParser#ln}.
	 * @param ctx the parse tree
	 */
	void enterLn(PascalRParser.LnContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalRParser#ln}.
	 * @param ctx the parse tree
	 */
	void exitLn(PascalRParser.LnContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalRParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExp(PascalRParser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalRParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExp(PascalRParser.ExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalRParser#sine}.
	 * @param ctx the parse tree
	 */
	void enterSine(PascalRParser.SineContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalRParser#sine}.
	 * @param ctx the parse tree
	 */
	void exitSine(PascalRParser.SineContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalRParser#cosine}.
	 * @param ctx the parse tree
	 */
	void enterCosine(PascalRParser.CosineContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalRParser#cosine}.
	 * @param ctx the parse tree
	 */
	void exitCosine(PascalRParser.CosineContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalRParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(PascalRParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalRParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(PascalRParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalRParser#string}.
	 * @param ctx the parse tree
	 */
	void enterString(PascalRParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalRParser#string}.
	 * @param ctx the parse tree
	 */
	void exitString(PascalRParser.StringContext ctx);
}