// Generated from compiladores\sqlalg\Sqlalg.g4 by ANTLR 4.8
package compiladores.sqlalg;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SqlalgParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, CADEIA=40, VARIAVEL=41, NUM_INT=42, NUM_REAL=43, HORA=44, DATA=45, 
		DATAHORA=46, WS=47, COMENTARIO=48, COMENTARIO_ABERTO=49, ANY=50;
	public static final int
		RULE_programa = 0, RULE_criacao = 1, RULE_tipo = 2, RULE_insercao = 3, 
		RULE_dado = 4, RULE_selecao = 5, RULE_subselecao = 6, RULE_atualizacao = 7, 
		RULE_mais_dado = 8, RULE_mais_var = 9, RULE_condicao = 10, RULE_agregacao = 11, 
		RULE_contador = 12, RULE_agrupa = 13, RULE_op = 14, RULE_deleta = 15, 
		RULE_comando = 16, RULE_corpo = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "criacao", "tipo", "insercao", "dado", "selecao", "subselecao", 
			"atualizacao", "mais_dado", "mais_var", "condicao", "agregacao", "contador", 
			"agrupa", "op", "deleta", "comando", "corpo"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'algoritmo'", "'fim_algoritmo'", "'cria'", "'('", "','", "'chave_primaria'", 
			"')'", "'chave_estrangeira'", "'de'", "'inteiro'", "'literal'", "'['", 
			"']'", "'real'", "'caractere'", "'data'", "'hora'", "'data_hora'", "'insere'", 
			"'='", "'escreva'", "'.'", "'se'", "'escreva_tudo_de'", "'atualiza'", 
			"'media'", "'maximo'", "'minimo'", "'soma'", "'contador'", "'agrupado'", 
			"'ordenado'", "'<>'", "'<='", "'>='", "'<'", "'>'", "'deleta'", "'descarta'", 
			null, null, null, null, null, null, null, null, null, "'{'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "CADEIA", "VARIAVEL", "NUM_INT", "NUM_REAL", 
			"HORA", "DATA", "DATAHORA", "WS", "COMENTARIO", "COMENTARIO_ABERTO", 
			"ANY"
		};
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
	public String getGrammarFileName() { return "Sqlalg.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SqlalgParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramaContext extends ParserRuleContext {
		public CorpoContext corpo() {
			return getRuleContext(CorpoContext.class,0);
		}
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlalgListener ) ((SqlalgListener)listener).enterPrograma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlalgListener ) ((SqlalgListener)listener).exitPrograma(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlalgVisitor ) return ((SqlalgVisitor<? extends T>)visitor).visitPrograma(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			match(T__0);
			setState(37);
			corpo();
			setState(38);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CriacaoContext extends ParserRuleContext {
		public List<TerminalNode> VARIAVEL() { return getTokens(SqlalgParser.VARIAVEL); }
		public TerminalNode VARIAVEL(int i) {
			return getToken(SqlalgParser.VARIAVEL, i);
		}
		public List<TipoContext> tipo() {
			return getRuleContexts(TipoContext.class);
		}
		public TipoContext tipo(int i) {
			return getRuleContext(TipoContext.class,i);
		}
		public List<Mais_varContext> mais_var() {
			return getRuleContexts(Mais_varContext.class);
		}
		public Mais_varContext mais_var(int i) {
			return getRuleContext(Mais_varContext.class,i);
		}
		public CriacaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_criacao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlalgListener ) ((SqlalgListener)listener).enterCriacao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlalgListener ) ((SqlalgListener)listener).exitCriacao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlalgVisitor ) return ((SqlalgVisitor<? extends T>)visitor).visitCriacao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CriacaoContext criacao() throws RecognitionException {
		CriacaoContext _localctx = new CriacaoContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_criacao);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			match(T__2);
			setState(41);
			match(VARIAVEL);
			setState(42);
			match(T__3);
			setState(43);
			tipo();
			setState(44);
			match(VARIAVEL);
			setState(51);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(45);
					match(T__4);
					setState(46);
					tipo();
					setState(47);
					match(VARIAVEL);
					}
					} 
				}
				setState(53);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(54);
			match(T__4);
			setState(55);
			match(T__5);
			setState(56);
			match(VARIAVEL);
			setState(57);
			match(T__3);
			setState(58);
			match(VARIAVEL);
			setState(60);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(59);
				mais_var();
				}
				break;
			}
			setState(62);
			match(T__6);
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(63);
				match(T__4);
				setState(64);
				match(T__7);
				setState(65);
				match(VARIAVEL);
				setState(66);
				match(T__3);
				setState(67);
				match(VARIAVEL);
				setState(69);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(68);
					mais_var();
					}
					break;
				}
				setState(71);
				match(T__6);
				setState(72);
				match(T__8);
				setState(73);
				match(VARIAVEL);
				setState(74);
				match(T__3);
				setState(75);
				match(VARIAVEL);
				setState(77);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
				case 1:
					{
					setState(76);
					mais_var();
					}
					break;
				}
				setState(79);
				match(T__6);
				}
				}
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(85);
			match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TipoContext extends ParserRuleContext {
		public TerminalNode NUM_INT() { return getToken(SqlalgParser.NUM_INT, 0); }
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlalgListener ) ((SqlalgListener)listener).enterTipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlalgListener ) ((SqlalgListener)listener).exitTipo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlalgVisitor ) return ((SqlalgVisitor<? extends T>)visitor).visitTipo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_tipo);
		try {
			setState(100);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
				enterOuterAlt(_localctx, 1);
				{
				setState(87);
				match(T__9);
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(88);
				match(T__10);
				setState(89);
				match(T__11);
				setState(90);
				match(NUM_INT);
				setState(91);
				match(T__12);
				}
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 3);
				{
				setState(92);
				match(T__13);
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(93);
				match(T__14);
				setState(94);
				match(T__11);
				setState(95);
				match(NUM_INT);
				setState(96);
				match(T__12);
				}
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 5);
				{
				setState(97);
				match(T__15);
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 6);
				{
				setState(98);
				match(T__16);
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 7);
				{
				setState(99);
				match(T__17);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InsercaoContext extends ParserRuleContext {
		public List<TerminalNode> VARIAVEL() { return getTokens(SqlalgParser.VARIAVEL); }
		public TerminalNode VARIAVEL(int i) {
			return getToken(SqlalgParser.VARIAVEL, i);
		}
		public DadoContext dado() {
			return getRuleContext(DadoContext.class,0);
		}
		public Mais_dadoContext mais_dado() {
			return getRuleContext(Mais_dadoContext.class,0);
		}
		public InsercaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insercao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlalgListener ) ((SqlalgListener)listener).enterInsercao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlalgListener ) ((SqlalgListener)listener).exitInsercao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlalgVisitor ) return ((SqlalgVisitor<? extends T>)visitor).visitInsercao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InsercaoContext insercao() throws RecognitionException {
		InsercaoContext _localctx = new InsercaoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_insercao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			match(T__18);
			setState(103);
			match(VARIAVEL);
			setState(104);
			match(T__3);
			setState(105);
			match(VARIAVEL);
			setState(106);
			match(T__19);
			setState(107);
			dado();
			setState(109);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(108);
				mais_dado();
				}
				break;
			}
			setState(111);
			match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DadoContext extends ParserRuleContext {
		public TerminalNode NUM_INT() { return getToken(SqlalgParser.NUM_INT, 0); }
		public TerminalNode NUM_REAL() { return getToken(SqlalgParser.NUM_REAL, 0); }
		public TerminalNode CADEIA() { return getToken(SqlalgParser.CADEIA, 0); }
		public TerminalNode DATA() { return getToken(SqlalgParser.DATA, 0); }
		public TerminalNode HORA() { return getToken(SqlalgParser.HORA, 0); }
		public TerminalNode DATAHORA() { return getToken(SqlalgParser.DATAHORA, 0); }
		public DadoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dado; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlalgListener ) ((SqlalgListener)listener).enterDado(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlalgListener ) ((SqlalgListener)listener).exitDado(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlalgVisitor ) return ((SqlalgVisitor<? extends T>)visitor).visitDado(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DadoContext dado() throws RecognitionException {
		DadoContext _localctx = new DadoContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_dado);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CADEIA) | (1L << NUM_INT) | (1L << NUM_REAL) | (1L << HORA) | (1L << DATA) | (1L << DATAHORA))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelecaoContext extends ParserRuleContext {
		public List<TerminalNode> VARIAVEL() { return getTokens(SqlalgParser.VARIAVEL); }
		public TerminalNode VARIAVEL(int i) {
			return getToken(SqlalgParser.VARIAVEL, i);
		}
		public CondicaoContext condicao() {
			return getRuleContext(CondicaoContext.class,0);
		}
		public Mais_varContext mais_var() {
			return getRuleContext(Mais_varContext.class,0);
		}
		public AgrupaContext agrupa() {
			return getRuleContext(AgrupaContext.class,0);
		}
		public AgregacaoContext agregacao() {
			return getRuleContext(AgregacaoContext.class,0);
		}
		public ContadorContext contador() {
			return getRuleContext(ContadorContext.class,0);
		}
		public SelecaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selecao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlalgListener ) ((SqlalgListener)listener).enterSelecao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlalgListener ) ((SqlalgListener)listener).exitSelecao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlalgVisitor ) return ((SqlalgVisitor<? extends T>)visitor).visitSelecao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelecaoContext selecao() throws RecognitionException {
		SelecaoContext _localctx = new SelecaoContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_selecao);
		int _la;
		try {
			setState(148);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(115);
				match(T__20);
				setState(116);
				match(VARIAVEL);
				setState(119);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__21) {
					{
					setState(117);
					match(T__21);
					setState(118);
					match(VARIAVEL);
					}
				}

				setState(122);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
				case 1:
					{
					setState(121);
					mais_var();
					}
					break;
				}
				setState(124);
				match(T__22);
				setState(125);
				condicao();
				setState(127);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__30 || _la==T__31) {
					{
					setState(126);
					agrupa();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(129);
				match(T__23);
				setState(130);
				match(VARIAVEL);
				setState(132);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__30 || _la==T__31) {
					{
					setState(131);
					agrupa();
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(134);
				match(T__20);
				setState(137);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__25:
				case T__26:
				case T__27:
				case T__28:
					{
					setState(135);
					agregacao();
					}
					break;
				case T__29:
					{
					setState(136);
					contador();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(139);
				match(T__8);
				setState(140);
				match(VARIAVEL);
				setState(143);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__22) {
					{
					setState(141);
					match(T__22);
					setState(142);
					condicao();
					}
				}

				setState(146);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__30 || _la==T__31) {
					{
					setState(145);
					agrupa();
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SubselecaoContext extends ParserRuleContext {
		public List<TerminalNode> VARIAVEL() { return getTokens(SqlalgParser.VARIAVEL); }
		public TerminalNode VARIAVEL(int i) {
			return getToken(SqlalgParser.VARIAVEL, i);
		}
		public CondicaoContext condicao() {
			return getRuleContext(CondicaoContext.class,0);
		}
		public Mais_varContext mais_var() {
			return getRuleContext(Mais_varContext.class,0);
		}
		public AgregacaoContext agregacao() {
			return getRuleContext(AgregacaoContext.class,0);
		}
		public ContadorContext contador() {
			return getRuleContext(ContadorContext.class,0);
		}
		public SubselecaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subselecao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlalgListener ) ((SqlalgListener)listener).enterSubselecao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlalgListener ) ((SqlalgListener)listener).exitSubselecao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlalgVisitor ) return ((SqlalgVisitor<? extends T>)visitor).visitSubselecao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubselecaoContext subselecao() throws RecognitionException {
		SubselecaoContext _localctx = new SubselecaoContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_subselecao);
		int _la;
		try {
			setState(174);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(150);
				match(T__20);
				setState(151);
				match(VARIAVEL);
				setState(154);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__21) {
					{
					setState(152);
					match(T__21);
					setState(153);
					match(VARIAVEL);
					}
				}

				setState(157);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					{
					setState(156);
					mais_var();
					}
					break;
				}
				setState(159);
				match(T__22);
				setState(160);
				condicao();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(161);
				match(T__23);
				setState(162);
				match(VARIAVEL);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(163);
				match(T__20);
				setState(166);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__25:
				case T__26:
				case T__27:
				case T__28:
					{
					setState(164);
					agregacao();
					}
					break;
				case T__29:
					{
					setState(165);
					contador();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(168);
				match(T__8);
				setState(169);
				match(VARIAVEL);
				setState(172);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__22) {
					{
					setState(170);
					match(T__22);
					setState(171);
					condicao();
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtualizacaoContext extends ParserRuleContext {
		public List<TerminalNode> VARIAVEL() { return getTokens(SqlalgParser.VARIAVEL); }
		public TerminalNode VARIAVEL(int i) {
			return getToken(SqlalgParser.VARIAVEL, i);
		}
		public DadoContext dado() {
			return getRuleContext(DadoContext.class,0);
		}
		public Mais_dadoContext mais_dado() {
			return getRuleContext(Mais_dadoContext.class,0);
		}
		public CondicaoContext condicao() {
			return getRuleContext(CondicaoContext.class,0);
		}
		public AtualizacaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atualizacao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlalgListener ) ((SqlalgListener)listener).enterAtualizacao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlalgListener ) ((SqlalgListener)listener).exitAtualizacao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlalgVisitor ) return ((SqlalgVisitor<? extends T>)visitor).visitAtualizacao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtualizacaoContext atualizacao() throws RecognitionException {
		AtualizacaoContext _localctx = new AtualizacaoContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_atualizacao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			match(T__24);
			setState(177);
			match(VARIAVEL);
			setState(178);
			match(T__3);
			setState(179);
			match(VARIAVEL);
			setState(180);
			match(T__19);
			setState(181);
			dado();
			setState(183);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(182);
				mais_dado();
				}
				break;
			}
			setState(185);
			match(T__6);
			setState(188);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__22) {
				{
				setState(186);
				match(T__22);
				setState(187);
				condicao();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Mais_dadoContext extends ParserRuleContext {
		public List<TerminalNode> VARIAVEL() { return getTokens(SqlalgParser.VARIAVEL); }
		public TerminalNode VARIAVEL(int i) {
			return getToken(SqlalgParser.VARIAVEL, i);
		}
		public List<DadoContext> dado() {
			return getRuleContexts(DadoContext.class);
		}
		public DadoContext dado(int i) {
			return getRuleContext(DadoContext.class,i);
		}
		public Mais_dadoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mais_dado; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlalgListener ) ((SqlalgListener)listener).enterMais_dado(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlalgListener ) ((SqlalgListener)listener).exitMais_dado(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlalgVisitor ) return ((SqlalgVisitor<? extends T>)visitor).visitMais_dado(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Mais_dadoContext mais_dado() throws RecognitionException {
		Mais_dadoContext _localctx = new Mais_dadoContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_mais_dado);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(190);
				match(T__4);
				setState(191);
				match(VARIAVEL);
				setState(192);
				match(T__19);
				setState(193);
				dado();
				}
				}
				setState(198);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Mais_varContext extends ParserRuleContext {
		public List<TerminalNode> VARIAVEL() { return getTokens(SqlalgParser.VARIAVEL); }
		public TerminalNode VARIAVEL(int i) {
			return getToken(SqlalgParser.VARIAVEL, i);
		}
		public Mais_varContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mais_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlalgListener ) ((SqlalgListener)listener).enterMais_var(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlalgListener ) ((SqlalgListener)listener).exitMais_var(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlalgVisitor ) return ((SqlalgVisitor<? extends T>)visitor).visitMais_var(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Mais_varContext mais_var() throws RecognitionException {
		Mais_varContext _localctx = new Mais_varContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_mais_var);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(199);
				match(T__4);
				setState(200);
				match(VARIAVEL);
				setState(203);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__21) {
					{
					setState(201);
					match(T__21);
					setState(202);
					match(VARIAVEL);
					}
				}

				}
				}
				setState(209);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CondicaoContext extends ParserRuleContext {
		public List<TerminalNode> VARIAVEL() { return getTokens(SqlalgParser.VARIAVEL); }
		public TerminalNode VARIAVEL(int i) {
			return getToken(SqlalgParser.VARIAVEL, i);
		}
		public OpContext op() {
			return getRuleContext(OpContext.class,0);
		}
		public DadoContext dado() {
			return getRuleContext(DadoContext.class,0);
		}
		public SubselecaoContext subselecao() {
			return getRuleContext(SubselecaoContext.class,0);
		}
		public CondicaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condicao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlalgListener ) ((SqlalgListener)listener).enterCondicao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlalgListener ) ((SqlalgListener)listener).exitCondicao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlalgVisitor ) return ((SqlalgVisitor<? extends T>)visitor).visitCondicao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondicaoContext condicao() throws RecognitionException {
		CondicaoContext _localctx = new CondicaoContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_condicao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			match(VARIAVEL);
			setState(211);
			match(T__21);
			setState(212);
			match(VARIAVEL);
			setState(213);
			op();
			setState(219);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CADEIA:
			case NUM_INT:
			case NUM_REAL:
			case HORA:
			case DATA:
			case DATAHORA:
				{
				setState(214);
				dado();
				}
				break;
			case T__20:
			case T__23:
				{
				setState(215);
				subselecao();
				}
				break;
			case VARIAVEL:
				{
				setState(216);
				match(VARIAVEL);
				setState(217);
				match(T__21);
				setState(218);
				match(VARIAVEL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AgregacaoContext extends ParserRuleContext {
		public TerminalNode VARIAVEL() { return getToken(SqlalgParser.VARIAVEL, 0); }
		public AgregacaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_agregacao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlalgListener ) ((SqlalgListener)listener).enterAgregacao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlalgListener ) ((SqlalgListener)listener).exitAgregacao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlalgVisitor ) return ((SqlalgVisitor<? extends T>)visitor).visitAgregacao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AgregacaoContext agregacao() throws RecognitionException {
		AgregacaoContext _localctx = new AgregacaoContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_agregacao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(222);
			match(T__3);
			setState(223);
			match(VARIAVEL);
			setState(224);
			match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ContadorContext extends ParserRuleContext {
		public TerminalNode VARIAVEL() { return getToken(SqlalgParser.VARIAVEL, 0); }
		public ContadorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_contador; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlalgListener ) ((SqlalgListener)listener).enterContador(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlalgListener ) ((SqlalgListener)listener).exitContador(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlalgVisitor ) return ((SqlalgVisitor<? extends T>)visitor).visitContador(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContadorContext contador() throws RecognitionException {
		ContadorContext _localctx = new ContadorContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_contador);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			match(T__29);
			setState(227);
			match(T__3);
			setState(228);
			match(VARIAVEL);
			setState(229);
			match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AgrupaContext extends ParserRuleContext {
		public TerminalNode VARIAVEL() { return getToken(SqlalgParser.VARIAVEL, 0); }
		public AgrupaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_agrupa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlalgListener ) ((SqlalgListener)listener).enterAgrupa(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlalgListener ) ((SqlalgListener)listener).exitAgrupa(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlalgVisitor ) return ((SqlalgVisitor<? extends T>)visitor).visitAgrupa(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AgrupaContext agrupa() throws RecognitionException {
		AgrupaContext _localctx = new AgrupaContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_agrupa);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			_la = _input.LA(1);
			if ( !(_la==T__30 || _la==T__31) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(232);
			match(VARIAVEL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OpContext extends ParserRuleContext {
		public OpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlalgListener ) ((SqlalgListener)listener).enterOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlalgListener ) ((SqlalgListener)listener).exitOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlalgVisitor ) return ((SqlalgVisitor<? extends T>)visitor).visitOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OpContext op() throws RecognitionException {
		OpContext _localctx = new OpContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__19) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeletaContext extends ParserRuleContext {
		public TerminalNode VARIAVEL() { return getToken(SqlalgParser.VARIAVEL, 0); }
		public CondicaoContext condicao() {
			return getRuleContext(CondicaoContext.class,0);
		}
		public DeletaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deleta; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlalgListener ) ((SqlalgListener)listener).enterDeleta(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlalgListener ) ((SqlalgListener)listener).exitDeleta(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlalgVisitor ) return ((SqlalgVisitor<? extends T>)visitor).visitDeleta(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeletaContext deleta() throws RecognitionException {
		DeletaContext _localctx = new DeletaContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_deleta);
		int _la;
		try {
			setState(244);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__37:
				enterOuterAlt(_localctx, 1);
				{
				setState(236);
				match(T__37);
				setState(237);
				match(VARIAVEL);
				setState(240);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__22) {
					{
					setState(238);
					match(T__22);
					setState(239);
					condicao();
					}
				}

				}
				break;
			case T__38:
				enterOuterAlt(_localctx, 2);
				{
				setState(242);
				match(T__38);
				setState(243);
				match(VARIAVEL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComandoContext extends ParserRuleContext {
		public CriacaoContext criacao() {
			return getRuleContext(CriacaoContext.class,0);
		}
		public InsercaoContext insercao() {
			return getRuleContext(InsercaoContext.class,0);
		}
		public SelecaoContext selecao() {
			return getRuleContext(SelecaoContext.class,0);
		}
		public AtualizacaoContext atualizacao() {
			return getRuleContext(AtualizacaoContext.class,0);
		}
		public DeletaContext deleta() {
			return getRuleContext(DeletaContext.class,0);
		}
		public ComandoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comando; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlalgListener ) ((SqlalgListener)listener).enterComando(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlalgListener ) ((SqlalgListener)listener).exitComando(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlalgVisitor ) return ((SqlalgVisitor<? extends T>)visitor).visitComando(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComandoContext comando() throws RecognitionException {
		ComandoContext _localctx = new ComandoContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_comando);
		try {
			setState(251);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(246);
				criacao();
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 2);
				{
				setState(247);
				insercao();
				}
				break;
			case T__20:
			case T__23:
				enterOuterAlt(_localctx, 3);
				{
				setState(248);
				selecao();
				}
				break;
			case T__24:
				enterOuterAlt(_localctx, 4);
				{
				setState(249);
				atualizacao();
				}
				break;
			case T__37:
			case T__38:
				enterOuterAlt(_localctx, 5);
				{
				setState(250);
				deleta();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CorpoContext extends ParserRuleContext {
		public List<ComandoContext> comando() {
			return getRuleContexts(ComandoContext.class);
		}
		public ComandoContext comando(int i) {
			return getRuleContext(ComandoContext.class,i);
		}
		public CorpoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_corpo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlalgListener ) ((SqlalgListener)listener).enterCorpo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlalgListener ) ((SqlalgListener)listener).exitCorpo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlalgVisitor ) return ((SqlalgVisitor<? extends T>)visitor).visitCorpo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CorpoContext corpo() throws RecognitionException {
		CorpoContext _localctx = new CorpoContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_corpo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__18) | (1L << T__20) | (1L << T__23) | (1L << T__24) | (1L << T__37) | (1L << T__38))) != 0)) {
				{
				{
				setState(253);
				comando();
				}
				}
				setState(258);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\64\u0106\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3\64"+
		"\n\3\f\3\16\3\67\13\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3?\n\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\5\3H\n\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3P\n\3\3\3\7\3S\n\3\f"+
		"\3\16\3V\13\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\5\4g\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5p\n\5\3\5\3\5\3\6\3\6\3\7"+
		"\3\7\3\7\3\7\5\7z\n\7\3\7\5\7}\n\7\3\7\3\7\3\7\5\7\u0082\n\7\3\7\3\7\3"+
		"\7\5\7\u0087\n\7\3\7\3\7\3\7\5\7\u008c\n\7\3\7\3\7\3\7\3\7\5\7\u0092\n"+
		"\7\3\7\5\7\u0095\n\7\5\7\u0097\n\7\3\b\3\b\3\b\3\b\5\b\u009d\n\b\3\b\5"+
		"\b\u00a0\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00a9\n\b\3\b\3\b\3\b\3\b"+
		"\5\b\u00af\n\b\5\b\u00b1\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00ba\n\t"+
		"\3\t\3\t\3\t\5\t\u00bf\n\t\3\n\3\n\3\n\3\n\7\n\u00c5\n\n\f\n\16\n\u00c8"+
		"\13\n\3\13\3\13\3\13\3\13\5\13\u00ce\n\13\7\13\u00d0\n\13\f\13\16\13\u00d3"+
		"\13\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00de\n\f\3\r\3\r\3\r\3"+
		"\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\21"+
		"\3\21\5\21\u00f3\n\21\3\21\3\21\5\21\u00f7\n\21\3\22\3\22\3\22\3\22\3"+
		"\22\5\22\u00fe\n\22\3\23\7\23\u0101\n\23\f\23\16\23\u0104\13\23\3\23\2"+
		"\2\24\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$\2\6\4\2**,\60\3\2\34"+
		"\37\3\2!\"\4\2\26\26#\'\2\u011c\2&\3\2\2\2\4*\3\2\2\2\6f\3\2\2\2\bh\3"+
		"\2\2\2\ns\3\2\2\2\f\u0096\3\2\2\2\16\u00b0\3\2\2\2\20\u00b2\3\2\2\2\22"+
		"\u00c6\3\2\2\2\24\u00d1\3\2\2\2\26\u00d4\3\2\2\2\30\u00df\3\2\2\2\32\u00e4"+
		"\3\2\2\2\34\u00e9\3\2\2\2\36\u00ec\3\2\2\2 \u00f6\3\2\2\2\"\u00fd\3\2"+
		"\2\2$\u0102\3\2\2\2&\'\7\3\2\2\'(\5$\23\2()\7\4\2\2)\3\3\2\2\2*+\7\5\2"+
		"\2+,\7+\2\2,-\7\6\2\2-.\5\6\4\2.\65\7+\2\2/\60\7\7\2\2\60\61\5\6\4\2\61"+
		"\62\7+\2\2\62\64\3\2\2\2\63/\3\2\2\2\64\67\3\2\2\2\65\63\3\2\2\2\65\66"+
		"\3\2\2\2\668\3\2\2\2\67\65\3\2\2\289\7\7\2\29:\7\b\2\2:;\7+\2\2;<\7\6"+
		"\2\2<>\7+\2\2=?\5\24\13\2>=\3\2\2\2>?\3\2\2\2?@\3\2\2\2@T\7\t\2\2AB\7"+
		"\7\2\2BC\7\n\2\2CD\7+\2\2DE\7\6\2\2EG\7+\2\2FH\5\24\13\2GF\3\2\2\2GH\3"+
		"\2\2\2HI\3\2\2\2IJ\7\t\2\2JK\7\13\2\2KL\7+\2\2LM\7\6\2\2MO\7+\2\2NP\5"+
		"\24\13\2ON\3\2\2\2OP\3\2\2\2PQ\3\2\2\2QS\7\t\2\2RA\3\2\2\2SV\3\2\2\2T"+
		"R\3\2\2\2TU\3\2\2\2UW\3\2\2\2VT\3\2\2\2WX\7\t\2\2X\5\3\2\2\2Yg\7\f\2\2"+
		"Z[\7\r\2\2[\\\7\16\2\2\\]\7,\2\2]g\7\17\2\2^g\7\20\2\2_`\7\21\2\2`a\7"+
		"\16\2\2ab\7,\2\2bg\7\17\2\2cg\7\22\2\2dg\7\23\2\2eg\7\24\2\2fY\3\2\2\2"+
		"fZ\3\2\2\2f^\3\2\2\2f_\3\2\2\2fc\3\2\2\2fd\3\2\2\2fe\3\2\2\2g\7\3\2\2"+
		"\2hi\7\25\2\2ij\7+\2\2jk\7\6\2\2kl\7+\2\2lm\7\26\2\2mo\5\n\6\2np\5\22"+
		"\n\2on\3\2\2\2op\3\2\2\2pq\3\2\2\2qr\7\t\2\2r\t\3\2\2\2st\t\2\2\2t\13"+
		"\3\2\2\2uv\7\27\2\2vy\7+\2\2wx\7\30\2\2xz\7+\2\2yw\3\2\2\2yz\3\2\2\2z"+
		"|\3\2\2\2{}\5\24\13\2|{\3\2\2\2|}\3\2\2\2}~\3\2\2\2~\177\7\31\2\2\177"+
		"\u0081\5\26\f\2\u0080\u0082\5\34\17\2\u0081\u0080\3\2\2\2\u0081\u0082"+
		"\3\2\2\2\u0082\u0097\3\2\2\2\u0083\u0084\7\32\2\2\u0084\u0086\7+\2\2\u0085"+
		"\u0087\5\34\17\2\u0086\u0085\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0097\3"+
		"\2\2\2\u0088\u008b\7\27\2\2\u0089\u008c\5\30\r\2\u008a\u008c\5\32\16\2"+
		"\u008b\u0089\3\2\2\2\u008b\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008e"+
		"\7\13\2\2\u008e\u0091\7+\2\2\u008f\u0090\7\31\2\2\u0090\u0092\5\26\f\2"+
		"\u0091\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0094\3\2\2\2\u0093\u0095"+
		"\5\34\17\2\u0094\u0093\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0097\3\2\2\2"+
		"\u0096u\3\2\2\2\u0096\u0083\3\2\2\2\u0096\u0088\3\2\2\2\u0097\r\3\2\2"+
		"\2\u0098\u0099\7\27\2\2\u0099\u009c\7+\2\2\u009a\u009b\7\30\2\2\u009b"+
		"\u009d\7+\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009f\3\2"+
		"\2\2\u009e\u00a0\5\24\13\2\u009f\u009e\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0"+
		"\u00a1\3\2\2\2\u00a1\u00a2\7\31\2\2\u00a2\u00b1\5\26\f\2\u00a3\u00a4\7"+
		"\32\2\2\u00a4\u00b1\7+\2\2\u00a5\u00a8\7\27\2\2\u00a6\u00a9\5\30\r\2\u00a7"+
		"\u00a9\5\32\16\2\u00a8\u00a6\3\2\2\2\u00a8\u00a7\3\2\2\2\u00a9\u00aa\3"+
		"\2\2\2\u00aa\u00ab\7\13\2\2\u00ab\u00ae\7+\2\2\u00ac\u00ad\7\31\2\2\u00ad"+
		"\u00af\5\26\f\2\u00ae\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b1\3"+
		"\2\2\2\u00b0\u0098\3\2\2\2\u00b0\u00a3\3\2\2\2\u00b0\u00a5\3\2\2\2\u00b1"+
		"\17\3\2\2\2\u00b2\u00b3\7\33\2\2\u00b3\u00b4\7+\2\2\u00b4\u00b5\7\6\2"+
		"\2\u00b5\u00b6\7+\2\2\u00b6\u00b7\7\26\2\2\u00b7\u00b9\5\n\6\2\u00b8\u00ba"+
		"\5\22\n\2\u00b9\u00b8\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bb\3\2\2\2"+
		"\u00bb\u00be\7\t\2\2\u00bc\u00bd\7\31\2\2\u00bd\u00bf\5\26\f\2\u00be\u00bc"+
		"\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\21\3\2\2\2\u00c0\u00c1\7\7\2\2\u00c1"+
		"\u00c2\7+\2\2\u00c2\u00c3\7\26\2\2\u00c3\u00c5\5\n\6\2\u00c4\u00c0\3\2"+
		"\2\2\u00c5\u00c8\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7"+
		"\23\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c9\u00ca\7\7\2\2\u00ca\u00cd\7+\2\2"+
		"\u00cb\u00cc\7\30\2\2\u00cc\u00ce\7+\2\2\u00cd\u00cb\3\2\2\2\u00cd\u00ce"+
		"\3\2\2\2\u00ce\u00d0\3\2\2\2\u00cf\u00c9\3\2\2\2\u00d0\u00d3\3\2\2\2\u00d1"+
		"\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\25\3\2\2\2\u00d3\u00d1\3\2\2"+
		"\2\u00d4\u00d5\7+\2\2\u00d5\u00d6\7\30\2\2\u00d6\u00d7\7+\2\2\u00d7\u00dd"+
		"\5\36\20\2\u00d8\u00de\5\n\6\2\u00d9\u00de\5\16\b\2\u00da\u00db\7+\2\2"+
		"\u00db\u00dc\7\30\2\2\u00dc\u00de\7+\2\2\u00dd\u00d8\3\2\2\2\u00dd\u00d9"+
		"\3\2\2\2\u00dd\u00da\3\2\2\2\u00de\27\3\2\2\2\u00df\u00e0\t\3\2\2\u00e0"+
		"\u00e1\7\6\2\2\u00e1\u00e2\7+\2\2\u00e2\u00e3\7\t\2\2\u00e3\31\3\2\2\2"+
		"\u00e4\u00e5\7 \2\2\u00e5\u00e6\7\6\2\2\u00e6\u00e7\7+\2\2\u00e7\u00e8"+
		"\7\t\2\2\u00e8\33\3\2\2\2\u00e9\u00ea\t\4\2\2\u00ea\u00eb\7+\2\2\u00eb"+
		"\35\3\2\2\2\u00ec\u00ed\t\5\2\2\u00ed\37\3\2\2\2\u00ee\u00ef\7(\2\2\u00ef"+
		"\u00f2\7+\2\2\u00f0\u00f1\7\31\2\2\u00f1\u00f3\5\26\f\2\u00f2\u00f0\3"+
		"\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f7\3\2\2\2\u00f4\u00f5\7)\2\2\u00f5"+
		"\u00f7\7+\2\2\u00f6\u00ee\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f7!\3\2\2\2\u00f8"+
		"\u00fe\5\4\3\2\u00f9\u00fe\5\b\5\2\u00fa\u00fe\5\f\7\2\u00fb\u00fe\5\20"+
		"\t\2\u00fc\u00fe\5 \21\2\u00fd\u00f8\3\2\2\2\u00fd\u00f9\3\2\2\2\u00fd"+
		"\u00fa\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fd\u00fc\3\2\2\2\u00fe#\3\2\2\2"+
		"\u00ff\u0101\5\"\22\2\u0100\u00ff\3\2\2\2\u0101\u0104\3\2\2\2\u0102\u0100"+
		"\3\2\2\2\u0102\u0103\3\2\2\2\u0103%\3\2\2\2\u0104\u0102\3\2\2\2 \65>G"+
		"OTfoy|\u0081\u0086\u008b\u0091\u0094\u0096\u009c\u009f\u00a8\u00ae\u00b0"+
		"\u00b9\u00be\u00c6\u00cd\u00d1\u00dd\u00f2\u00f6\u00fd\u0102";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}