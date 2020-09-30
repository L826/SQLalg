package compiladores.sqlalg;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;

public class SqlalgErrorListener implements ANTLRErrorListener {

    private static final List<String> saida = new ArrayList<>();
    //cria uma variável privada que vai guardar o texto de erro que vai ser escrito no arquivo .txt
    
    @Override
    public void syntaxError(Recognizer<?, ?> rcgnzr, Object o, int i, int i1, String string, RecognitionException re) {
        Token tk = (Token) o;
        String text = tk.getText();

        if (text.equals("<EOF>")) { //Permite que EOF não seja verificado pela gramática
            text = "EOF";
        }

        if (SqlalgLexer.VOCABULARY.getDisplayName(tk.getType()).equals("'{'")) { //se o token for um comentário sem } no final
            saida.add("Linha " + i + ": comentario nao fechado"); //guarda o texto de erro em saida
            return; //encerra o tratamento desse erro
        }
        
        else if (SqlalgLexer.VOCABULARY.getDisplayName(tk.getType()).equals("ANY")) { //se for um símbolo não identificado em LaLexer.g4
            saida.add("Linha " + i + ": " + text + " - simbolo nao identificado"); //guarda o texto de erro em saida
            return; //encerra o tratamento desse erro
        }
        
        //quando falta um símbolo ( ] , ) ")
        saida.add("Linha " + i + ": erro de sintaxe proximo a " + text); //guarda o texto de erro sintático

    }

    public List<String> getTexto() {
        return saida; //Permite que a variável criada aqui seja usada em outras classes
    }

    @Override
    public void reportAmbiguity(Parser parser, DFA dfa, int i, int i1, boolean bln, BitSet bitset, ATNConfigSet atncs) {
        //Não implementado aqui
    }

    @Override
    public void reportAttemptingFullContext(Parser parser, DFA dfa, int i, int i1, BitSet bitset, ATNConfigSet atncs) {
        //Não implementado aqui
    }

    @Override
    public void reportContextSensitivity(Parser parser, DFA dfa, int i, int i1, int i2, ATNConfigSet atncs) {
        //Não implementado aqui
    }
}
