// Generated from compiladores\sqlalg\Sqlalg.g4 by ANTLR 4.8
package compiladores.sqlalg;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SqlalgParser}.
 */
public interface SqlalgListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SqlalgParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(SqlalgParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlalgParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(SqlalgParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlalgParser#criacao}.
	 * @param ctx the parse tree
	 */
	void enterCriacao(SqlalgParser.CriacaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlalgParser#criacao}.
	 * @param ctx the parse tree
	 */
	void exitCriacao(SqlalgParser.CriacaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlalgParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(SqlalgParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlalgParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(SqlalgParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlalgParser#insercao}.
	 * @param ctx the parse tree
	 */
	void enterInsercao(SqlalgParser.InsercaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlalgParser#insercao}.
	 * @param ctx the parse tree
	 */
	void exitInsercao(SqlalgParser.InsercaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlalgParser#dado}.
	 * @param ctx the parse tree
	 */
	void enterDado(SqlalgParser.DadoContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlalgParser#dado}.
	 * @param ctx the parse tree
	 */
	void exitDado(SqlalgParser.DadoContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlalgParser#selecao}.
	 * @param ctx the parse tree
	 */
	void enterSelecao(SqlalgParser.SelecaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlalgParser#selecao}.
	 * @param ctx the parse tree
	 */
	void exitSelecao(SqlalgParser.SelecaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlalgParser#subselecao}.
	 * @param ctx the parse tree
	 */
	void enterSubselecao(SqlalgParser.SubselecaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlalgParser#subselecao}.
	 * @param ctx the parse tree
	 */
	void exitSubselecao(SqlalgParser.SubselecaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlalgParser#atualizacao}.
	 * @param ctx the parse tree
	 */
	void enterAtualizacao(SqlalgParser.AtualizacaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlalgParser#atualizacao}.
	 * @param ctx the parse tree
	 */
	void exitAtualizacao(SqlalgParser.AtualizacaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlalgParser#mais_dado}.
	 * @param ctx the parse tree
	 */
	void enterMais_dado(SqlalgParser.Mais_dadoContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlalgParser#mais_dado}.
	 * @param ctx the parse tree
	 */
	void exitMais_dado(SqlalgParser.Mais_dadoContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlalgParser#mais_var}.
	 * @param ctx the parse tree
	 */
	void enterMais_var(SqlalgParser.Mais_varContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlalgParser#mais_var}.
	 * @param ctx the parse tree
	 */
	void exitMais_var(SqlalgParser.Mais_varContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlalgParser#condicao}.
	 * @param ctx the parse tree
	 */
	void enterCondicao(SqlalgParser.CondicaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlalgParser#condicao}.
	 * @param ctx the parse tree
	 */
	void exitCondicao(SqlalgParser.CondicaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlalgParser#agregacao}.
	 * @param ctx the parse tree
	 */
	void enterAgregacao(SqlalgParser.AgregacaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlalgParser#agregacao}.
	 * @param ctx the parse tree
	 */
	void exitAgregacao(SqlalgParser.AgregacaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlalgParser#contador}.
	 * @param ctx the parse tree
	 */
	void enterContador(SqlalgParser.ContadorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlalgParser#contador}.
	 * @param ctx the parse tree
	 */
	void exitContador(SqlalgParser.ContadorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlalgParser#agrupa}.
	 * @param ctx the parse tree
	 */
	void enterAgrupa(SqlalgParser.AgrupaContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlalgParser#agrupa}.
	 * @param ctx the parse tree
	 */
	void exitAgrupa(SqlalgParser.AgrupaContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlalgParser#op}.
	 * @param ctx the parse tree
	 */
	void enterOp(SqlalgParser.OpContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlalgParser#op}.
	 * @param ctx the parse tree
	 */
	void exitOp(SqlalgParser.OpContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlalgParser#deleta}.
	 * @param ctx the parse tree
	 */
	void enterDeleta(SqlalgParser.DeletaContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlalgParser#deleta}.
	 * @param ctx the parse tree
	 */
	void exitDeleta(SqlalgParser.DeletaContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlalgParser#comando}.
	 * @param ctx the parse tree
	 */
	void enterComando(SqlalgParser.ComandoContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlalgParser#comando}.
	 * @param ctx the parse tree
	 */
	void exitComando(SqlalgParser.ComandoContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlalgParser#corpo}.
	 * @param ctx the parse tree
	 */
	void enterCorpo(SqlalgParser.CorpoContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlalgParser#corpo}.
	 * @param ctx the parse tree
	 */
	void exitCorpo(SqlalgParser.CorpoContext ctx);
}