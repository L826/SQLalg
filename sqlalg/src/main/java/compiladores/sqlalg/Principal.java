package compiladores.sqlalg;

import compiladores.sqlalg.SqlalgParser.ProgramaContext;
import java.io.IOException;
import java.io.PrintWriter;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;

public class Principal {
public static void main(String args[]) throws IOException {
        SqlalgErrorListener erro = new SqlalgErrorListener(); //variável que guarda os erros de compilação
        CharStream cs = CharStreams.fromFileName(args[0]); //args[0] contém o endereço do arquivo de entrada
        String saida = args[1]; //args[1] vai conter o endereço do arquivo de saida

        PrintWriter x = new PrintWriter(saida); //criação de arquivo para leitura no endereço guardado em saida
        SqlalgLexer lexer = new SqlalgLexer(cs); //lexer para verificação de erros léxicos


        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SqlalgParser parser = new SqlalgParser(tokens); //parser para verificação de erros sintáticos
        
        lexer.removeErrorListeners(); //remove as mensagens padrão de erro no terminal
        lexer.addErrorListener(erro); //modifica a forma de apontar erro com o que está na classe SqlalgErrorListener
        parser.removeErrorListeners(); //remove as mensagens padrão de erro no terminal
        parser.addErrorListener(erro); //modifica a forma de apontar erro com o que está na classe SqlalgErrorListener

        ProgramaContext arvore = parser.programa(); //roda o programa inteiro
        
        erro.getTexto().forEach((s) -> x.printf("%s\n", s)); //escreve no arquivo x os erros léxicos e sintáticos
        if (erro.getTexto().isEmpty()) {
            SqlalgSemantico ls = new SqlalgSemantico(); //verificação de erros semânticos        
            ls.visitPrograma(arvore); //roda o programa novamente pra procurar erros semânticos
            SqlalgSemanticoUtils.errosSemanticos.forEach((s) -> x.printf("%s\n", s)); //escreve no arquivo x os erros detectados
            
            if (!SqlalgSemanticoUtils.erro) { // se não tiver erros, entra no gerador de arquivo SQL
                SqlalgGeradorSql lgc = new SqlalgGeradorSql(); //classe responsável por gerar código em SQL
                lgc.visitPrograma(arvore); //visita o programa para escrita de código
                x.print(lgc.saida.toString()); //escreve o código no arquivo x
            }
        }
        x.close(); //fecha o arquivo
    }    
}
