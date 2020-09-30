// Generated from compiladores\sqlalg\Sqlalg.g4 by ANTLR 4.8
package compiladores.sqlalg;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SqlalgParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SqlalgVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SqlalgParser#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(SqlalgParser.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlalgParser#criacao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCriacao(SqlalgParser.CriacaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlalgParser#tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo(SqlalgParser.TipoContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlalgParser#insercao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsercao(SqlalgParser.InsercaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlalgParser#dado}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDado(SqlalgParser.DadoContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlalgParser#selecao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelecao(SqlalgParser.SelecaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlalgParser#subselecao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubselecao(SqlalgParser.SubselecaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlalgParser#atualizacao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtualizacao(SqlalgParser.AtualizacaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlalgParser#mais_dado}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMais_dado(SqlalgParser.Mais_dadoContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlalgParser#mais_var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMais_var(SqlalgParser.Mais_varContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlalgParser#condicao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondicao(SqlalgParser.CondicaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlalgParser#agregacao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAgregacao(SqlalgParser.AgregacaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlalgParser#contador}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContador(SqlalgParser.ContadorContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlalgParser#agrupa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAgrupa(SqlalgParser.AgrupaContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlalgParser#op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp(SqlalgParser.OpContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlalgParser#deleta}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeleta(SqlalgParser.DeletaContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlalgParser#comando}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComando(SqlalgParser.ComandoContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlalgParser#corpo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCorpo(SqlalgParser.CorpoContext ctx);
}