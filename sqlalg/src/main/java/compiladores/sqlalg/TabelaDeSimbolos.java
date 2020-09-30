package compiladores.sqlalg;

import java.util.HashMap;
import java.util.Map;
/*
 * Cada tabela de símbolos representa uma tabela em SQL
 * ele deve conter para cada variável uma lista de valores
*/

public class TabelaDeSimbolos {

    public enum TipoSqlalg {
        literal, caractere, inteiro, real, data, hora, data_hora, invalido
    } //VARCHAR   CHAR        INT    FLOAT DATE  TIME  DATETIME
    
    public enum TipoChave {
        primaria, estrangeira, invalido
    } //tipo de chave (PRIMARYKEY ou FOREIGNKEY)
    
    class EntradaTabelaDeSimbolos {
        String nome;
        TipoSqlalg tipo;
        TipoChave chave;
        int endereco;
         
        private EntradaTabelaDeSimbolos(String nome, TipoSqlalg tipo) {
            this.nome = nome;
            this.tipo = tipo;
        }
        
        private EntradaTabelaDeSimbolos(String nome, int endereco) {
            this.nome = nome;
            this.endereco = endereco;
        }

        private EntradaTabelaDeSimbolos(String nome, TipoChave chave) {
            this.nome = nome;
            this.chave = chave;
        }
    }
    
    private Map<String, EntradaTabelaDeSimbolos> tabela;
    public String nome; //nome da tabela
    public int numVar; //número de variáveis que a tabela tem
    
    public TabelaDeSimbolos() {
        this.tabela= new HashMap<>();
        this.nome = new String();
        numVar = 0;
    }
    
    public void adicionar(String nome, TipoSqlalg tipo) {
        numVar++; //incrementa o número de variáveis
        tabela.put(nome, new EntradaTabelaDeSimbolos(nome, tipo));
    }
    
    public void adicionar(String nome, int endereco) {
        numVar++; //incrementa o número de variáveis
        tabela.put(nome, new EntradaTabelaDeSimbolos(nome, endereco));
    }

    public void adicionar(String nome, TipoChave chave) {
        tabela.put(nome, new EntradaTabelaDeSimbolos(nome, chave));
    }
    public boolean existe(String nome) { //verifica se a variável existe
        return tabela.containsKey(nome);
    }
    
    public TipoSqlalg verificarTipo(String nome) { //verifica o tipo da variável
        return tabela.get(nome).tipo;
    }
    
    public TipoChave verificarChave(String nome) { //verifica a chave da variável
        return tabela.get(nome).chave;
    }   
       
    public int verificarEndereco(String nome) {
        return tabela.get(nome).endereco;
    }
    
    public void deletaVar(String nome) { //exclui variável da tabela
        tabela.remove(nome);
    }    
}

