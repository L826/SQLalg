package compiladores.sqlalg;

import java.util.ArrayList;
import java.util.List;

/*
 * Gerador de código SQL
 * Só passará aqui se o código em SQLalg não tiver erros
 */
public class SqlalgGeradorSql extends SqlalgBaseVisitor<Void> {
    StringBuilder saida;
    List<TabelaDeSimbolos> tabela;

    public SqlalgGeradorSql() {
        saida = new StringBuilder(); //criação da lista de String e lista de tabelas
        this.tabela = new ArrayList<>();
    }
    
    @Override
    public Void visitPrograma(SqlalgParser.ProgramaContext ctx) {
        ctx.corpo().comando().forEach(comando -> visitComando(comando));
        return null;
    }
    
    @Override
    public Void visitCriacao(SqlalgParser.CriacaoContext ctx) { //CREATE TABLE
        String strTipo;
        int i;
        
        saida.append("CREATE TABLE IF NOT EXISTS " + ctx.VARIAVEL(0).getText() + "(\n");
        for (i = 0; i < ctx.tipo().size(); i++) {
            strTipo = ctx.tipo(i).getText();
            if (strTipo.contains("literal["))
                strTipo = "literal"; //adaptação do tipo da variável para o switch
            else if (strTipo.contains("caractere["))
                strTipo = "caractere"; //adaptação do tipo da variável para o switch
            switch (strTipo) { //verifica o tipo da variável e modifica para o seu correspondente em SQL
                case "inteiro":
                    strTipo = "INT";
                    break;
                case "real":
                    strTipo = "FLOAT";
                    break;
                case "literal":
                    strTipo = "VARCHAR";
                    break;
                case "caractere":
                    strTipo = "CHAR";
                    break;
                case "data":
                    strTipo = "DATE";
                    break;
                case "hora":
                    strTipo = "TIME";
                    break;
                case "data_hora":
                    strTipo = "DATETIME";
                    break;    
            }
            saida.append("  " +ctx.VARIAVEL(i+1) + " " + strTipo);
            if (ctx.tipo(i).NUM_INT() != null)
                saida.append("(" + ctx.tipo(i).NUM_INT().getText() + ")");
            saida.append(",\n");
        }
        //escrita da chave primária
        saida.append("  CONSTRAINT " + ctx.VARIAVEL(i+1) + " PRIMARY KEY (");
        i += 2;
        saida.append(ctx.VARIAVEL(i));
        if (ctx.mais_var(0).VARIAVEL() != null)
            for(var nomeVar : ctx.mais_var(0).VARIAVEL())
                saida.append(", " + nomeVar.getText());
        saida.append(")");
        i++;
        if (ctx.getText().contains("chave_estrangeira")) { //tratamento de chaves estrangeiras. Cada chave estrangeira contém obrigatoriamente 4 VARIAVEL 
                
            int j = 1; //mais_var equivale a chave_estrangeiro*2 + 1
            //representação do ctx.VARIAVEL(i) ao ctx.VARIAVEL(i+3): nome da chave estrangeira, nome da variável, nome da tabela estrangeira, variável da tabela estrangeira
            while (j < ctx.mais_var().size() - 1) {
                saida.append(",\n  CONSTRAINT " + ctx.VARIAVEL(i).getText() + " FOREIGN KEY (" + ctx.VARIAVEL(i+1).getText());
                if (ctx.mais_var(j).VARIAVEL() != null)
                    for(var nomeVar : ctx.mais_var(j).VARIAVEL())
                        saida.append(", " + nomeVar.getText());
                
                saida.append(") REFERENCES " + ctx.VARIAVEL(i+2).getText() + "(" + ctx.VARIAVEL(i+3));
                if (ctx.mais_var(j+1).VARIAVEL() != null)
                    for(var nomeVar : ctx.mais_var(j+1).VARIAVEL())
                        saida.append(", " + nomeVar.getText());
                saida.append(")");
                
                j += 2; //aumenta em 2 para verificar a existência dos mais_var
                if (i + 4 < ctx.VARIAVEL().size())
                    i += 4; //uma chave estrangeira obrigatoriamente contém 4 VARIAVEL segundo a gramática

            }
        }
        saida.append("\n);\n\n");
        
        return null;
    }
    
    @Override
    public Void visitInsercao(SqlalgParser.InsercaoContext ctx) { //INSERT
        String dado;

        saida.append("INSERT INTO " + ctx.VARIAVEL(0).getText() + "(" + ctx.VARIAVEL(1).getText());
        for(var nomeVar : ctx.mais_dado().VARIAVEL())
            saida.append(", " + nomeVar.getText());
        //dado modificado para escrita em SQL
        dado = escritaDado(ctx.dado().getText());
        
        saida.append(") VALUES (" + dado);
        
        for(var dadoVar : ctx.mais_dado().dado()) {
            dado = escritaDado(dadoVar.getText()); //dado modificado para escrita em SQL
            saida.append(", " + dado);
        }
        saida.append(");\n\n");
        return null;
    }
    
    @Override
    public Void visitSelecao(SqlalgParser.SelecaoContext ctx) { //SELECT
        if (ctx.getText().contains("escreva_tudo_de"))
            saida.append("SELECT * FROM " + ctx.VARIAVEL(0).getText());
        else if (ctx.contador() != null || ctx.agregacao() != null) {
            saida.append("SELECT ");
            if (ctx.contador() != null) //aceita qualquer tipo de variável
                saida.append("COUNT(" + ctx.contador().VARIAVEL().getText() + ") FROM " + ctx.VARIAVEL(0).getText());
            else { //só aceita INT ou FLOAT
                if (ctx.agregacao().getText().contains("minimo"))
                    saida.append("MIN("); 
                else if (ctx.agregacao().getText().contains("maximo"))
                    saida.append("MAX(");
                else if (ctx.agregacao().getText().contains("media"))
                    saida.append("AVG(");
                else if (ctx.agregacao().getText().contains("soma"))
                    saida.append("SUM(");
                saida.append(ctx.agregacao().VARIAVEL().getText() + ") FROM " + ctx.VARIAVEL(0).getText());
            }
        }
        else {
            saida.append("SELECT ");
            if (ctx.VARIAVEL(1) != null) {
                saida.append(ctx.VARIAVEL(1).getText());
                for (int i = 0; i < ctx.mais_var().VARIAVEL().size(); i+=2)
                    saida.append(", " + ctx.mais_var().VARIAVEL(i+1).getText());
            }
            else
                saida.append("SELECT *");
            
            if (ctx.condicao() != null && ctx.condicao().VARIAVEL(2) != null && !ctx.condicao().VARIAVEL(2).getText().equals(ctx.VARIAVEL(0).getText()))
                saida.append(" FROM " + ctx.VARIAVEL(0).getText() + ", " + ctx.condicao().VARIAVEL(2).getText());
            else
                saida.append(" FROM " + ctx.VARIAVEL(0).getText());
        }
        
        if (ctx.condicao() != null) //WHERE
            visitCondicao(ctx.condicao());
        
        if (ctx.agrupa() != null) { //muda a ordem das linhas ao mostrar na tela
            if (ctx.agrupa().getText().contains("agrupado"))
                saida.append(" GROUP BY " + ctx.agrupa().VARIAVEL().getText());
            else
                saida.append(" ORDER BY " + ctx.agrupa().VARIAVEL().getText());
        }

        saida.append(";\n\n");
            
        return null;
    }
    
    @Override
    public Void visitSubselecao(SqlalgParser.SubselecaoContext ctx) { //SELECT dentro do WHERE
        saida.append("("); //subseleção é igual à seleção, mas não possui agrupa
        if (ctx.getText().contains("escreva_tudo_de"))
            saida.append("SELECT * FROM " + ctx.VARIAVEL(0).getText());
        else if (ctx.contador() != null || ctx.agregacao() != null) {
            saida.append("SELECT ");
            if (ctx.contador() != null)
                saida.append("COUNT(" + ctx.contador().VARIAVEL().getText() + ") FROM " + ctx.VARIAVEL(0).getText());
            else {
                if (ctx.agregacao().getText().contains("minimo"))
                    saida.append("MIN("); 
                else if (ctx.agregacao().getText().contains("maximo"))
                    saida.append("MAX(");
                else if (ctx.agregacao().getText().contains("media"))
                    saida.append("AVG(");
                else if (ctx.agregacao().getText().contains("soma"))
                    saida.append("SUM(");
                saida.append(ctx.agregacao().VARIAVEL().getText() + ") FROM " + ctx.VARIAVEL(0).getText());
            }
        }
        else {
            saida.append("SELECT ");
            if (ctx.VARIAVEL(1) != null) {
                saida.append(ctx.VARIAVEL(1).getText());
                for (int i = 0; i < ctx.mais_var().VARIAVEL().size(); i+=2)
                    saida.append(", " + ctx.mais_var().VARIAVEL(i+1).getText());
            }
            else
                saida.append("SELECT *");
            saida.append(" FROM " + ctx.VARIAVEL(0).getText());
        }
        
        if (ctx.condicao() != null)
            visitCondicao(ctx.condicao());
        //como está dentro de um comando, não tem ;
        saida.append(")");
            
        return null;
    }
    
    @Override
    public Void visitAtualizacao(SqlalgParser.AtualizacaoContext ctx) { //UPDATE
        String dado;
        
        saida.append("UPDATE " + ctx.VARIAVEL(0).getText());
        dado = escritaDado(ctx.dado().getText()); //dado modificado para escrita em SQL              
        saida.append(" SET " + ctx.VARIAVEL(1).getText() + " = " + dado);
        
        for (int i = 0; i < ctx.mais_dado().VARIAVEL().size(); i++) {
            dado = escritaDado(ctx.mais_dado().VARIAVEL(i).getText()); //dado modificado para escrita em SQL
            
            saida.append(", " + ctx.mais_dado().VARIAVEL(i).getText() + " = " + dado);
        }
        if (ctx.condicao() != null)
            visitCondicao(ctx.condicao());
        saida.append(";\n\n");
        return null;
    }
    
    @Override
    public Void visitDeleta(SqlalgParser.DeletaContext ctx) { //DROP ou DELETE
        if (ctx.getText().contains("deleta"))
            saida.append("DELETE FROM ");
        else if (ctx.getText().contains("descarta"))
            saida.append("DROP TABLE ");
        
        saida.append(ctx.VARIAVEL().getText());
        if (ctx.condicao() != null) //condição será aplicada para restringir DELETE
            visitCondicao(ctx.condicao());
        
        saida.append(";\n\n");
        return null;
    }
    
    @Override
    public Void visitCondicao(SqlalgParser.CondicaoContext ctx) { //WHERE
        String dado;
        
        saida.append(" WHERE " + ctx.VARIAVEL(1).getText() + " " + ctx.op().getText() + " ");
        if (ctx.subselecao() != null)
            visitSubselecao(ctx.subselecao());
        else if (ctx.dado() != null) {
            dado = escritaDado(ctx.dado().getText()); //dado modificado para escrita em SQL
            
            saida.append(dado);
        }
        else //caso tabela1.var1 = tabela2.var2
            saida.append(ctx.VARIAVEL(2).getText() + "." + ctx.VARIAVEL(3).getText());
        return null;
    }
    
    public String escritaDado(String texto) {
        if (texto.contains("/") && texto.contains(":")) { //DATAHORA
            String dia = texto.substring(0, 2);
            String mes = texto.substring(3, 5);
            String ano = texto.substring(6, 10);
            String hora;
            if (texto.length() < 18) //adiciona os segundos para se adaptar ao SQL
                hora = texto.substring(11, 16) + ":00";
            else 
                hora = texto.substring(11, 19); 
            //muda ordem DD/MM/YYYY para YYYY-MM-DD
            return "'" + ano + "-" + mes + "-" + dia + " " + hora + "'";
        }
        else if (texto.contains("/")) { //DATA
            String dia = texto.substring(0, 2);
            String mes = texto.substring(3, 5);
            String ano = texto.substring(6, 10); 
            //muda ordem DD/MM/YYYY para YYYY-MM-DD
            return "'" + ano + "-" + mes + "-" + dia + "'";
        }
        else if (texto.contains(":")) { //HORA
            if (texto.length() < 6) //não contém segundos
                return "'" + texto + ":00'"; //adiciona os segundos para se adaptar ao SQL
            else
                return "'" + texto + "'";
        }
        else if (texto.contains("\"")) //converte " das cadeias para '
            return texto.replaceAll("\"","'");
        else
            return texto;
    }
}
