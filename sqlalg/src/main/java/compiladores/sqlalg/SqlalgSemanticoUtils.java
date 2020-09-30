package compiladores.sqlalg;

import compiladores.sqlalg.TabelaDeSimbolos.TipoChave;
import compiladores.sqlalg.TabelaDeSimbolos.TipoSqlalg;
import java.util.ArrayList;
import java.util.List;
import org.antlr.v4.runtime.Token;

/** O objetivo dessa classe é criar a lista de erros em String
 *  e fazer verificações na TabelaDeSimbolos 
 */
public class SqlalgSemanticoUtils {
    
    public static List<String> errosSemanticos = new ArrayList<>(); //lista de erros que apareceram no algoritmo
    public static boolean erro = false; //variável usada para verificar se há erros

    public static void adicionarErroSemantico(Token t, String mensagem) {
        int linha = t.getLine();
        errosSemanticos.add(String.format("Linha %d: %s", linha, mensagem)); //escreve a mensagem de erro na lista
        erro = true; //ocorreu erro, gerador de arquivo SQL não será chamado
    }
    
    //função para verificar se existe a tabela de nome nomeTabela
    public static TabelaDeSimbolos existeTabela(List<TabelaDeSimbolos> lista, String nomeTabela) {
        for (var tabela : lista) {
            if (tabela.nome == null ? nomeTabela == null : tabela.nome.equals(nomeTabela))
                return tabela;
        }
        return null;
    }
    
    //função para verificar se existe a variável na tabela
    public static boolean existeVariavel(List<TabelaDeSimbolos> lista, String nomeTabela, String variavel) {
        if (existeTabela(lista, nomeTabela) != null) {
            TabelaDeSimbolos tabela = existeTabela(lista, nomeTabela);
            if (tabela.existe(variavel))
                return true;
        }
        return false;
    }
    
    //função para detectar a presença de chave primária na tabela
    public static boolean existePrimaria(List<TabelaDeSimbolos> lista, String nomeTabela, String variavel) {
        if (existeTabela(lista, nomeTabela) != null) {
            TabelaDeSimbolos tabela = existeTabela(lista, nomeTabela);
            if (existeVariavel(lista, nomeTabela, variavel))
                if (tabela.verificarChave(variavel) == TipoChave.primaria)
                    return true;
        }
        return false;
    }
    
    //funcão para indicar qual o tipo da variavel na tabela
    public static TipoSqlalg ordemTipo(List<TabelaDeSimbolos> lista, String nomeTabela, String variavel) {
        if (existeTabela(lista, nomeTabela) != null) {
            TabelaDeSimbolos tabela = existeTabela(lista, nomeTabela);
            //retorna o tipo da variavel
            if (existeVariavel(lista, nomeTabela, variavel))
                if (tabela.verificarTipo(variavel) != null)
                    return tabela.verificarTipo(variavel);            
        }
        return TipoSqlalg.invalido;
    }
    
    public static boolean comparaTipo(List<TabelaDeSimbolos> lista, String nomeTabela1, String nomeTabela2, String v1, String v2) {
        if (existeVariavel(lista, nomeTabela1, v1) && existeVariavel(lista, nomeTabela2, v2)) {
            TabelaDeSimbolos tabela1 = existeTabela(lista, nomeTabela1);
            TabelaDeSimbolos tabela2 = existeTabela(lista, nomeTabela2);
            
            if (tabela1.verificarTipo(v1) == tabela2.verificarTipo(v2))
                return true;
        }
        return false; 
    }
    
    //função para verificar se o dado atribuído à variável é compatível com o tipo da variável
    public static boolean verificarTipo(String strTipo, String variavel, SqlalgParser.DadoContext dado, List<String> literal, List<String> tamanho) {
        boolean erro = false;
        //verifica tipo de dado e compara com o tipo de variável, se for incompatível erro = true
        switch (strTipo) {
            case "inteiro":
                if (dado.NUM_INT() == null)
                    erro = true;
                break;
                
            case "real": //um número inteiro também é real
                if (dado.NUM_INT() == null && dado.NUM_REAL() == null)
                    erro = true;
                break;
                
            case "literal": //cadeia deve ter tamanho menor ou igual ao tamanho permitido pela variável
                if (dado.CADEIA() == null)
                    erro = true;
                //literal.indexOf pega a posição x onde está escrito variavel e usa essa posição pra pegar o dado da lista tamanho
                else if (valorInt(tamanho.get(literal.indexOf(variavel))) < dado.getText().length() - 2)
                    adicionarErroSemantico(dado.start, "dado " + dado.getText() + " possui cadeia de caracteres com tamanho maior que " + valorInt(tamanho.get(literal.indexOf(variavel))));
                break; //caso de erro especial: apresenta mensagem de erro diferente
            
            case "caractere": //cadeia deve ter tamanho igual ao tamanho permitido pela variável
                if (dado.CADEIA() == null)
                    erro = true;
                //literal.indexOf pega a posição x onde está escrito variavel e usa essa posição pra pegar o dado da lista tamanho
                else if (valorInt(tamanho.get(literal.indexOf(variavel))) != dado.getText().length() - 2)
                    adicionarErroSemantico(dado.start, "dado " + dado.getText() + " possui cadeia de caracteres de tamanho diferente de " + valorInt(tamanho.get(literal.indexOf(variavel))));
                break; //caso de erro especial: apresenta mensagem de erro diferente
            
            case "data": //formato DD/MM/YYYY
                if (dado.DATA() == null)
                    erro = true;
                break;
            
            case "hora": //formato HH:MM ou HH:MM:SS
                if (dado.HORA() == null)
                    erro = true;
                break;
            
            case "data_hora":
                if (dado.DATAHORA() == null)
                    erro = true;
                break;    
            }
        
        return erro;
    }
    
    public static int valorInt(String texto) {
        /*
            Essa função vai converter o valor de NUMINT da
            cadeia para um número inteiro
            Ela vai ser utilizada para verificar se o tamanho
            da cadeia é compatível com o valor dado entre [ ]
        */
        int valor = 0;
        
        for (int i = 1; i <= texto.length(); i++) {
            switch (texto.charAt(texto.length()-i)) {
                case '0':
                    valor += 0 * Math.pow(10,i-1);
                    break;
                case '1':
                    valor += 1 * Math.pow(10,i-1);
                    break;
                case '2':
                    valor += 2 * Math.pow(10,i-1);
                    break;
                case '3':
                    valor += 3 * Math.pow(10,i-1);
                    break;
                case '4':
                    valor += 4 * Math.pow(10,i-1);
                    break;
                case '5':
                    valor += 5 * Math.pow(10,i-1);
                    break;
                case '6':
                    valor += 6 * Math.pow(10,i-1);
                    break;
                case '7':
                    valor += 7 * Math.pow(10,i-1);
                    break;
                case '8':
                    valor += 8 * Math.pow(10,i-1);
                    break;
                case '9':
                    valor += 9 * Math.pow(10,i-1);
                    break;
            }
        }
        return valor;
    }
}
