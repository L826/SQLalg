package compiladores.sqlalg;

import compiladores.sqlalg.TabelaDeSimbolos.TipoChave;
import compiladores.sqlalg.TabelaDeSimbolos.TipoSqlalg;
import java.util.ArrayList;
import java.util.List;

public class SqlalgSemantico extends SqlalgBaseVisitor<Void>{
    List<TabelaDeSimbolos> listaTabela; //tabela de símbolos principal, guarda todas as variáveis do algoritmo de entrada
    List<String> literalLista; //lista de variáveis CHAR e VARCHAR
    List<String> literalTam; //lista contendo o tamanho de cada variável armazenada em literalLista
    
    @Override
    public Void visitPrograma(SqlalgParser.ProgramaContext ctx) { //função inicial da classe, é chamada no Principal
        listaTabela = new ArrayList<TabelaDeSimbolos>(); //criação das variáveis globais da classe
        literalLista = new ArrayList<>();
        literalTam = new ArrayList<>();
        return super.visitPrograma(ctx);
    }
    
    @Override
    public Void visitCriacao(SqlalgParser.CriacaoContext ctx) {
        int i, k;
        TabelaDeSimbolos tabela = new TabelaDeSimbolos(); //criação de tabela
        String strTipo;
        TipoSqlalg tipoVar = TipoSqlalg.invalido;
        tabela.nome = ctx.VARIAVEL(0).getText();
        for (i = 0; i < ctx.tipo().size(); i++) { //cada tipo contém uma variável. Se tiver 2 tipos seguidos ocorre erro sintático
            strTipo = ctx.tipo(i).getText();
            if (strTipo.contains("literal[")) //adaptação do tipo da variável para o switch
                strTipo = "literal";
            else if (strTipo.contains("caractere[")) //adaptação do tipo da variável para o switch
                strTipo = "caractere";
            
            switch (strTipo) { //verifica o tipo da variável
                case "inteiro":
                    tipoVar = TipoSqlalg.inteiro;
                    break;
                case "real":
                    tipoVar = TipoSqlalg.real;
                    break;
                case "literal":
                    tipoVar = TipoSqlalg.literal;
                    break;
                case "caractere":
                    tipoVar = TipoSqlalg.caractere;
                    break;
                case "data":
                    tipoVar = TipoSqlalg.data;
                    break;
                case "hora":
                    tipoVar = TipoSqlalg.hora;
                    break;
                case "data_hora":
                    tipoVar = TipoSqlalg.data_hora;
                    break;    
            }
            if (tipoVar == TipoSqlalg.invalido)
                SqlalgSemanticoUtils.adicionarErroSemantico(ctx.VARIAVEL(i+1).getSymbol(), "variavel " + ctx.VARIAVEL(i+1).getText() + " possui um tipo invalido");
            if (tipoVar == TipoSqlalg.literal || tipoVar == TipoSqlalg.caractere) {
                literalLista.add(ctx.VARIAVEL(i+1).getText()); //adiciona variável no literalLista
                literalTam.add(ctx.tipo(i).NUM_INT().getText()); //guarda o tamanho da variável
            }
            tabela.adicionar(ctx.VARIAVEL(i+1).getText(), tipoVar); //adiciona tabela na variável
        }        
        
        if (!ctx.getText().contains("chave_primaria"))
            SqlalgSemanticoUtils.adicionarErroSemantico(ctx.VARIAVEL(i+1).getSymbol(), "tabela nao possui chave primaria");
        else
            tabela.adicionar(ctx.VARIAVEL(i+1).getText(), TipoChave.primaria);
        
        i += 2; // ctx.VARIAVEL(i) vai representar a variável que é uma chave primária
        if (!tabela.existe(ctx.VARIAVEL(i).getText()))
            SqlalgSemanticoUtils.adicionarErroSemantico(ctx.VARIAVEL(i).getSymbol(), "variavel " + ctx.VARIAVEL(i).getText() + " nao existe");
        i = ctx.VARIAVEL().size() - i - 1; //i vai representar quantas variáveis estão indicadas em chaves entrangeiras. Sempre é múltiplo de 4
        
        if (ctx.getText().contains("chave_estrangeira")) { //tratamento de chaves estrangeiras. Cada chave estrangeira contém obrigatoriamente 4 VARIAVEL 
            if (ctx.VARIAVEL().size()%4 == 0) // alteração de i para que VARIAVEL(i) seja a tabela referenciada
                i += 2;
            if (ctx.VARIAVEL().size()%4 == 1) // alteração de i para que VARIAVEL(i) seja a tabela referenciada
                i--;
            if (ctx.VARIAVEL().size()%4 == 3) // alteração de i para que VARIAVEL(i) seja a tabela referenciada
                i++;
                
            int j = 1; //mais_var equivale a chave_estrangeiro*2 + 1
            
            while (j < ctx.mais_var().size() - 1) {
                if (ctx.mais_var(j).VARIAVEL().size() != ctx.mais_var(j+1).VARIAVEL().size()) {
                    //verifica se os mais_var da chave estrangeira possuem o mesmo número de variáveis
                    SqlalgSemanticoUtils.adicionarErroSemantico(ctx.mais_var(j).start, "numero de variaveis incompativel para chave estrangeira");
                    j = ctx.mais_var().size(); //força fim de repetição
                }
                else if (SqlalgSemanticoUtils.existeTabela(listaTabela, ctx.VARIAVEL(i).getText()) == null) {
                    SqlalgSemanticoUtils.adicionarErroSemantico(ctx.VARIAVEL(i).getSymbol(), "tabela " + ctx.VARIAVEL(i).getText() + " mencionada na chave estrangeira nao existe");
                    j = ctx.mais_var().size(); //força fim de repetição                        
                }
                else if (!tabela.existe(ctx.VARIAVEL(i-1).getText())) {
                    SqlalgSemanticoUtils.adicionarErroSemantico(ctx.VARIAVEL(i-1).getSymbol(), "variavel " + ctx.VARIAVEL(i-1).getText() + " mencionada na chave estrangeira nao existe");
                    j = ctx.mais_var().size(); //força fim de repetição
                }
                else if (tabela.verificarTipo(ctx.VARIAVEL(i-1).getText()) != SqlalgSemanticoUtils.ordemTipo(listaTabela, ctx.VARIAVEL(i).getText(), ctx.VARIAVEL(i+1).getText())) { //falta tratamento de inteiro como real
                    SqlalgSemanticoUtils.adicionarErroSemantico(ctx.VARIAVEL(i).getSymbol(), "variaveis " + ctx.VARIAVEL(i-1).getText() + " e " + ctx.VARIAVEL(i+1).getText() +  " tem tipos diferentes");
                    j = ctx.mais_var().size(); //força fim de repetição                        
                }
                else if (ctx.mais_var(j).VARIAVEL().size() > 0) {
                    int num = ctx.mais_var(j).VARIAVEL().size();
                    k = 0;
                    do {//tratamento de erro para mais_var
                        if (!tabela.existe(ctx.mais_var(j).VARIAVEL(k).getText())) {
                            SqlalgSemanticoUtils.adicionarErroSemantico(ctx.mais_var(j).VARIAVEL(k).getSymbol(), "variavel " + ctx.mais_var(j).VARIAVEL(k).getText() + " mencionada na chave estrangeira nao existe");
                            j = ctx.mais_var().size(); //força fim de repetição
                        }
                        else if (tabela.verificarTipo(ctx.mais_var(j).VARIAVEL(k).getText()) != SqlalgSemanticoUtils.ordemTipo(listaTabela, ctx.VARIAVEL(i).getText(), ctx.mais_var(j+1).VARIAVEL(k).getText())) {
                            SqlalgSemanticoUtils.adicionarErroSemantico(ctx.VARIAVEL(i).getSymbol(), "variaveis " + ctx.mais_var(j).VARIAVEL(k).getText() + " e " + ctx.mais_var(j+1).VARIAVEL(k).getText() + " tem tipos diferentes");
                            j = ctx.mais_var().size(); //força fim de repetição
                        }
                        k++;
                    } while (k < num);
                }
                
                j += 2; //aumenta em 2 para verificar a existência dos mais_var
                if (i + 4 < ctx.VARIAVEL().size())
                    i += 4; //uma chave estrangeira obrigatoriamente contém 4 VARIAVEL segundo a gramática
            }
            
        }
        listaTabela.add(tabela); //adiciona tabela criada na lista de tabelas
        return super.visitCriacao(ctx);
    }

    @Override
    public Void visitInsercao(SqlalgParser.InsercaoContext ctx) {
        if (SqlalgSemanticoUtils.existeTabela(listaTabela, ctx.VARIAVEL(0).getText()) == null)
            SqlalgSemanticoUtils.adicionarErroSemantico(ctx.VARIAVEL(0).getSymbol(), "tabela " + ctx.VARIAVEL(0).getText() + " mencionada na insercao nao existe");
        else { //tabela mencionada no INSERT existe, então vai verificar as variáveis e seus respectivos dados
            TabelaDeSimbolos tabela = SqlalgSemanticoUtils.existeTabela(listaTabela, ctx.VARIAVEL(0).getText());
            if (!SqlalgSemanticoUtils.existeVariavel(listaTabela, tabela.nome, ctx.VARIAVEL(1).getText()))
                SqlalgSemanticoUtils.adicionarErroSemantico(ctx.VARIAVEL(1).getSymbol(), "variavel " + ctx.VARIAVEL(1).getText() + " mencionada na insercao nao existe");
            else if (tabela.numVar-1 != ctx.mais_dado().VARIAVEL().size()) 
                SqlalgSemanticoUtils.adicionarErroSemantico(ctx.VARIAVEL(1).getSymbol(), "numero de variaveis incompativel com a tabela " + ctx.VARIAVEL(0).getText());
            else {
                TipoSqlalg tipoVar = SqlalgSemanticoUtils.ordemTipo(listaTabela, tabela.nome, ctx.VARIAVEL(1).getText());
                String strTipo = tipoVar.name();
                boolean erro = false;
                erro = SqlalgSemanticoUtils.verificarTipo(strTipo, ctx.VARIAVEL(1).getText(), ctx.dado(), literalLista, literalTam);
               
                if (erro) //tipo de dado incompatível com a variável
                    SqlalgSemanticoUtils.adicionarErroSemantico(ctx.dado().start, "dado " + ctx.dado().getText() + " possui um tipo incompativel");
            }
            
            for (int i = 0; i < ctx.mais_dado().VARIAVEL().size(); i++) {
                if (!SqlalgSemanticoUtils.existeVariavel(listaTabela, tabela.nome, ctx.mais_dado().VARIAVEL(i).getText()))
                    SqlalgSemanticoUtils.adicionarErroSemantico(ctx.mais_dado().VARIAVEL(i).getSymbol(), "variavel " + ctx.mais_dado().VARIAVEL(i).getText() + " mencionada na insercao nao existe");
                else { //tabela existe, verificação das variáveis e seus respectivos dados
                    TipoSqlalg tipoVar = SqlalgSemanticoUtils.ordemTipo(listaTabela, tabela.nome, ctx.mais_dado().VARIAVEL(i).getText());
                    String strTipo = tipoVar.name();

                    boolean erro = false;
                    erro = SqlalgSemanticoUtils.verificarTipo(strTipo, ctx.mais_dado().VARIAVEL(i).getText(), ctx.mais_dado().dado(i), literalLista, literalTam);

                    if (erro) //tipo de dado incompatível com a variável
                        SqlalgSemanticoUtils.adicionarErroSemantico(ctx.mais_dado().dado(i).start, "dado " + ctx.mais_dado().dado(i).getText() + " possui um tipo incompativel");
                }    
            }
                        
        }    
        return super.visitInsercao(ctx);
    }
    
    @Override
    public Void visitSelecao(SqlalgParser.SelecaoContext ctx) {
        if (ctx.getText().contains("escreva_tudo_de")) { //caso SELECT * FROM
            if (SqlalgSemanticoUtils.existeTabela(listaTabela, ctx.VARIAVEL(0).getText()) == null)
               SqlalgSemanticoUtils.adicionarErroSemantico(ctx.VARIAVEL(0).getSymbol(), "tabela " + ctx.VARIAVEL(0).getText() + " mencionada na selecao nao existe");
        }
        
        else if (ctx.contador() != null || ctx.agregacao() != null) { //caso com agregação
            if (SqlalgSemanticoUtils.existeTabela(listaTabela, ctx.VARIAVEL(0).getText()) == null)
                SqlalgSemanticoUtils.adicionarErroSemantico(ctx.VARIAVEL(0).getSymbol(), "tabela " + ctx.VARIAVEL(0).getText() + " mencionada na selecao nao existe");
            
            else if (ctx.agregacao() != null && !SqlalgSemanticoUtils.existeVariavel(listaTabela, ctx.VARIAVEL(0).getText(), ctx.agregacao().VARIAVEL().getText()))
                SqlalgSemanticoUtils.adicionarErroSemantico(ctx.agregacao().VARIAVEL().getSymbol(), "variavel " + ctx.agregacao().VARIAVEL().getText() + " mencionada na selecao nao existe na tabela " + ctx.VARIAVEL(0).getText());
            
            else if ((ctx.agregacao() != null) && //AVG, MAX, MIN e SUM só fazem agregação com valores numéricos
                    (SqlalgSemanticoUtils.ordemTipo(listaTabela, ctx.VARIAVEL(0).getText(), ctx.agregacao().VARIAVEL().getText()) != TipoSqlalg.inteiro &&
                    SqlalgSemanticoUtils.ordemTipo(listaTabela, ctx.VARIAVEL(0).getText(), ctx.agregacao().VARIAVEL().getText()) != TipoSqlalg.real))
                SqlalgSemanticoUtils.adicionarErroSemantico(ctx.agregacao().VARIAVEL().getSymbol(), "variavel " + ctx.agregacao().VARIAVEL().getText() + " da selecao nao pode ser usada na agregacao");
            
            else if (ctx.contador() != null && !SqlalgSemanticoUtils.existeVariavel(listaTabela, ctx.VARIAVEL(0).getText(), ctx.contador().VARIAVEL().getText()))
                SqlalgSemanticoUtils.adicionarErroSemantico(ctx.contador().VARIAVEL().getSymbol(), "variavel " + ctx.contador().VARIAVEL().getText() + " mencionada na selecao nao existe na tabela " + ctx.VARIAVEL(0).getText());
           
            else if (ctx.condicao() != null && !SqlalgSemanticoUtils.existeVariavel(listaTabela, ctx.condicao().VARIAVEL(0).getText(), ctx.condicao().VARIAVEL(1).getText()))
                SqlalgSemanticoUtils.adicionarErroSemantico(ctx.condicao().VARIAVEL(1).getSymbol(), "variavel " + ctx.condicao().VARIAVEL(1).getText() + " mencionada na selecao nao existe na tabela " + ctx.condicao().VARIAVEL(0).getText());

            else if (ctx.condicao() != null && !ctx.condicao().VARIAVEL(0).getText().equals(ctx.VARIAVEL(0).getText()))
                SqlalgSemanticoUtils.adicionarErroSemantico(ctx.condicao().VARIAVEL(0).getSymbol(), "tabelas " + ctx.VARIAVEL(0).getText() + " e " +ctx.condicao().VARIAVEL(0).getText() + " sao diferentes");
        }
    
        else { //caso SELECT ... FROM ... WHERE ...
            if (SqlalgSemanticoUtils.existeTabela(listaTabela, ctx.VARIAVEL(0).getText()) == null)
                SqlalgSemanticoUtils.adicionarErroSemantico(ctx.VARIAVEL(0).getSymbol(), "tabela " + ctx.VARIAVEL(0).getText() + " mencionada na selecao nao existe");
            
            else if (ctx.VARIAVEL(1) != null && !SqlalgSemanticoUtils.existeVariavel(listaTabela, ctx.VARIAVEL(0).getText(), ctx.VARIAVEL(1).getText()))
                SqlalgSemanticoUtils.adicionarErroSemantico(ctx.VARIAVEL(1).getSymbol(), "variavel " + ctx.VARIAVEL(1).getText() + " mencionada na selecao nao existe na tabela " + ctx.VARIAVEL(1).getText());
            
            else if (ctx.mais_var().VARIAVEL().size() > 0 && ctx.mais_var().VARIAVEL().size() % 2 == 0) {
                for(int i = 0; i < ctx.mais_var().VARIAVEL().size(); i+=2) { //obrigatoriamente o formato deve ser tabela.variavel
                    if (SqlalgSemanticoUtils.existeTabela(listaTabela, ctx.mais_var().VARIAVEL(i).getText()) == null) {
                        SqlalgSemanticoUtils.adicionarErroSemantico(ctx.mais_var().VARIAVEL(i).getSymbol(), "tabela " + ctx.mais_var().VARIAVEL(i).getText() + " mencionada na selecao nao existe");
                        i = ctx.mais_var().VARIAVEL().size();
                    } //verifica se a variável de mais_var pertence à tabela mencionada antes
                    else if (!SqlalgSemanticoUtils.existeVariavel(listaTabela, ctx.mais_var().VARIAVEL(i).getText(), ctx.mais_var().VARIAVEL(i+1).getText())) {
                        SqlalgSemanticoUtils.adicionarErroSemantico(ctx.mais_var().VARIAVEL(i).getSymbol(), "variavel " + ctx.mais_var().VARIAVEL(i).getText() + " mencionada na selecao nao existe na tabela " + ctx.mais_var().VARIAVEL(i+1).getText());
                        i = ctx.mais_var().VARIAVEL().size();
                    }
                }
            }
            
            //se as tabelas são diferentes
            else if (!ctx.condicao().VARIAVEL(0).getText().equals(ctx.VARIAVEL(0).getText())) 
                SqlalgSemanticoUtils.adicionarErroSemantico(ctx.condicao().VARIAVEL(0).getSymbol(), "tabelas " + ctx.condicao().VARIAVEL(0).getText() + " e " + ctx.VARIAVEL(0).getText() + " sao diferentes");
            
            //se a variável da condição não existe na tabela
            else if (!SqlalgSemanticoUtils.existeVariavel(listaTabela, ctx.condicao().VARIAVEL(0).getText(), ctx.condicao().VARIAVEL(1).getText()))
                SqlalgSemanticoUtils.adicionarErroSemantico(ctx.condicao().VARIAVEL(1).getSymbol(), "variavel " + ctx.condicao().VARIAVEL(1).getText() + " mencionada na selecao nao existe na tabela " + ctx.condicao().VARIAVEL(0).getText());                        
        }
        
        //se a variável escrita no agrupa não existe
        if (ctx.agrupa() != null && !SqlalgSemanticoUtils.existeVariavel(listaTabela, ctx.VARIAVEL(0).getText(), ctx.agrupa().VARIAVEL().getText()))
            SqlalgSemanticoUtils.adicionarErroSemantico(ctx.agrupa().VARIAVEL().getSymbol(), "variavel " + ctx.agrupa().VARIAVEL().getText() + " mencionada na selecao nao existe na tabela " + ctx.VARIAVEL(0).getText());
            
        return super.visitSelecao(ctx);
    }
    
    @Override
    public Void visitDeleta(SqlalgParser.DeletaContext ctx) {
        TabelaDeSimbolos tabela = new TabelaDeSimbolos();

        if (SqlalgSemanticoUtils.existeTabela(listaTabela, ctx.VARIAVEL().getText()) == null)
            SqlalgSemanticoUtils.adicionarErroSemantico(ctx.VARIAVEL().getSymbol(), "tabela " + ctx.VARIAVEL().getText() + " mencionada no deleta nao existe");
        else if (ctx.condicao() != null) { //testa condições para deletar linhas da tabela
            if (!SqlalgSemanticoUtils.existeVariavel(listaTabela, ctx.VARIAVEL().getText(), ctx.condicao().VARIAVEL(1).getText()))
                SqlalgSemanticoUtils.adicionarErroSemantico(ctx.condicao().VARIAVEL(0).getSymbol(), "variavel " + ctx.condicao().VARIAVEL(1).getText() + " mencionada no deleta nao existe na tabela " + ctx.VARIAVEL().getText());
            else if(!ctx.VARIAVEL().getText().equals(ctx.condicao().VARIAVEL(0).getText()))
                SqlalgSemanticoUtils.adicionarErroSemantico(ctx.condicao().VARIAVEL(0).getSymbol(), "apenas dados da tabela " + ctx.VARIAVEL().getText() + " devem ser comparados no deleta");
            else if (ctx.condicao().VARIAVEL(2) != null && !ctx.VARIAVEL().getText().equals(ctx.condicao().VARIAVEL(2)))
                SqlalgSemanticoUtils.adicionarErroSemantico(ctx.condicao().VARIAVEL(0).getSymbol(), "apenas dados da tabela " + ctx.VARIAVEL().getText() + " devem ser comparados no deleta");
        }
      
        else { //caso sem erros, tabela será removida
            tabela = SqlalgSemanticoUtils.existeTabela(listaTabela, ctx.VARIAVEL().getText());
            listaTabela.remove(tabela);
        }
        return super.visitDeleta(ctx);
    }
    
    @Override
    public Void visitCondicao(SqlalgParser.CondicaoContext ctx) { //WHERE
        if (ctx.subselecao() != null && //caso ... WHERE var = (SELECT...);
        !SqlalgSemanticoUtils.comparaTipo(listaTabela, ctx.VARIAVEL(0).getText(), ctx.subselecao().VARIAVEL(0).getText(), ctx.VARIAVEL(1).getText(), ctx.subselecao().VARIAVEL(1).getText()))
            SqlalgSemanticoUtils.adicionarErroSemantico(ctx.VARIAVEL(1).getSymbol(), "variavel " + ctx.VARIAVEL(0).getText() + "." + ctx.VARIAVEL(1).getText() + " nao e compativel com " + ctx.subselecao().VARIAVEL(0).getText() + "." + ctx.subselecao().VARIAVEL(1).getText());
        
        else if (ctx.VARIAVEL().size() == 4) { //WHERE tabela1.var1 = tabela2.var2
            //se a segunda variável da condição não existe na segunda tabela
            if (!SqlalgSemanticoUtils.existeVariavel(listaTabela, ctx.VARIAVEL(2).getText(), ctx.VARIAVEL(3).getText()))
                SqlalgSemanticoUtils.adicionarErroSemantico(ctx.VARIAVEL(3).getSymbol(), "variavel " + ctx.VARIAVEL(3).getText() + " mencionada na selecao nao existe na tabela " + ctx.VARIAVEL(2).getText());
            
            //tabela1.var1 = tabela2.var2 mas var1 e var2 são de tipos diferentes
            else if (!SqlalgSemanticoUtils.comparaTipo(listaTabela, ctx.VARIAVEL(0).getText(), ctx.VARIAVEL(2).getText(), ctx.VARIAVEL(1).getText(), ctx.VARIAVEL(3).getText()))//variáveis de tipo diferentes
                SqlalgSemanticoUtils.adicionarErroSemantico(ctx.VARIAVEL(3).getSymbol(), "variaveis " + ctx.VARIAVEL(1).getText() + " e " + ctx.VARIAVEL(3).getText() + " sao de tipos incompativeis");
        }
        
        else if (ctx.dado() != null){ //verificação de tipo de variável com dado
            TipoSqlalg tipoVar = SqlalgSemanticoUtils.ordemTipo(listaTabela, ctx.VARIAVEL(0).getText(), ctx.VARIAVEL(1).getText());
            String strTipo = tipoVar.name();

            boolean erro = false;
            erro = SqlalgSemanticoUtils.verificarTipo(strTipo, ctx.VARIAVEL(1).getText(), ctx.dado(), literalLista, literalTam);
                       
            if (erro) //tipo de dado incompatível com a variável
                SqlalgSemanticoUtils.adicionarErroSemantico(ctx.dado().start, "dado " + ctx.dado().getText() + " possui um tipo incompativel");
        }
        
        return super.visitCondicao(ctx);
    }
    
    @Override //visitSubselecao e visitSelecao são iguais, exceto pelo agrupa
    public Void visitSubselecao(SqlalgParser.SubselecaoContext ctx) {
        if (ctx.getText().contains("escreva_tudo_de")) {
            if (SqlalgSemanticoUtils.existeTabela(listaTabela, ctx.VARIAVEL(0).getText()) == null)
               SqlalgSemanticoUtils.adicionarErroSemantico(ctx.VARIAVEL(0).getSymbol(), "tabela " + ctx.VARIAVEL(0).getText() + " mencionada na selecao nao existe");
        }
        
        else if (ctx.contador() != null || ctx.agregacao() != null) {
            if (SqlalgSemanticoUtils.existeTabela(listaTabela, ctx.VARIAVEL(0).getText()) == null)
                SqlalgSemanticoUtils.adicionarErroSemantico(ctx.VARIAVEL(0).getSymbol(), "tabela " + ctx.VARIAVEL(0).getText() + " mencionada na selecao nao existe");
            
            else if (ctx.agregacao() != null && !SqlalgSemanticoUtils.existeVariavel(listaTabela, ctx.VARIAVEL(0).getText(), ctx.agregacao().VARIAVEL().getText()))
                SqlalgSemanticoUtils.adicionarErroSemantico(ctx.agregacao().VARIAVEL().getSymbol(), "variavel " + ctx.agregacao().VARIAVEL().getText() + " mencionada na selecao nao existe na tabela " + ctx.VARIAVEL(0).getText());
            
            else if ((ctx.agregacao() != null) && //AVG, MAX, MIN e SUM só fazem agregação com valores numéricos
                    (SqlalgSemanticoUtils.ordemTipo(listaTabela, ctx.VARIAVEL(0).getText(), ctx.agregacao().VARIAVEL().getText()) != TipoSqlalg.inteiro &&
                    SqlalgSemanticoUtils.ordemTipo(listaTabela, ctx.VARIAVEL(0).getText(), ctx.agregacao().VARIAVEL().getText()) != TipoSqlalg.real))
                SqlalgSemanticoUtils.adicionarErroSemantico(ctx.agregacao().VARIAVEL().getSymbol(), "variavel " + ctx.agregacao().VARIAVEL().getText() + " da selecao nao pode ser usada na agregacao");
            
            else if (ctx.contador() != null && !SqlalgSemanticoUtils.existeVariavel(listaTabela, ctx.VARIAVEL(0).getText(), ctx.contador().VARIAVEL().getText()))
                SqlalgSemanticoUtils.adicionarErroSemantico(ctx.contador().VARIAVEL().getSymbol(), "variavel " + ctx.contador().VARIAVEL().getText() + " mencionada na selecao nao existe na tabela " + ctx.VARIAVEL(0).getText());
           
            else if (ctx.condicao() != null && !SqlalgSemanticoUtils.existeVariavel(listaTabela, ctx.condicao().VARIAVEL(0).getText(), ctx.condicao().VARIAVEL(1).getText()))
                SqlalgSemanticoUtils.adicionarErroSemantico(ctx.condicao().VARIAVEL(1).getSymbol(), "variavel " + ctx.condicao().VARIAVEL(1).getText() + " mencionada na selecao nao existe na tabela " + ctx.condicao().VARIAVEL(0).getText());

            else if (ctx.condicao() != null && !ctx.condicao().VARIAVEL(0).getText().equals(ctx.VARIAVEL(0).getText()))
                SqlalgSemanticoUtils.adicionarErroSemantico(ctx.condicao().VARIAVEL(0).getSymbol(), "tabelas " + ctx.VARIAVEL(0).getText() + " e " +ctx.condicao().VARIAVEL(0).getText() + " sao diferentes");
        }
    
        else {
            if (SqlalgSemanticoUtils.existeTabela(listaTabela, ctx.VARIAVEL(0).getText()) == null)
                SqlalgSemanticoUtils.adicionarErroSemantico(ctx.VARIAVEL(0).getSymbol(), "tabela " + ctx.VARIAVEL(0).getText() + " mencionada na selecao nao existe");
            
            else if (ctx.VARIAVEL(1) != null && !SqlalgSemanticoUtils.existeVariavel(listaTabela, ctx.VARIAVEL(0).getText(), ctx.VARIAVEL(1).getText()))
                SqlalgSemanticoUtils.adicionarErroSemantico(ctx.VARIAVEL(1).getSymbol(), "variavel " + ctx.VARIAVEL(1).getText() + " mencionada na selecao nao existe na tabela " + ctx.VARIAVEL(1).getText());
            
            else if (ctx.mais_var().VARIAVEL().size() > 0 && ctx.mais_var().VARIAVEL().size() % 2 == 0) {
                for(int i = 0; i < ctx.mais_var().VARIAVEL().size(); i+=2) { //obrigatoriamente o formato deve ser tabela.variavel
                    if (SqlalgSemanticoUtils.existeTabela(listaTabela, ctx.mais_var().VARIAVEL(i).getText()) == null) {
                        SqlalgSemanticoUtils.adicionarErroSemantico(ctx.mais_var().VARIAVEL(i).getSymbol(), "tabela " + ctx.mais_var().VARIAVEL(i).getText() + " mencionada na selecao nao existe");
                        i = ctx.mais_var().VARIAVEL().size();
                    }
                    else if (!SqlalgSemanticoUtils.existeVariavel(listaTabela, ctx.mais_var().VARIAVEL(i).getText(), ctx.mais_var().VARIAVEL(i+1).getText())) {
                        SqlalgSemanticoUtils.adicionarErroSemantico(ctx.mais_var().VARIAVEL(i).getSymbol(), "variavel " + ctx.mais_var().VARIAVEL(i).getText() + " mencionada na selecao nao existe na tabela " + ctx.mais_var().VARIAVEL(i+1).getText());
                        i = ctx.mais_var().VARIAVEL().size();
                    }
                }
            }
            
            //se as tabelas são diferentes
            else if (!ctx.condicao().VARIAVEL(0).getText().equals(ctx.VARIAVEL(0).getText())) 
                SqlalgSemanticoUtils.adicionarErroSemantico(ctx.condicao().VARIAVEL(0).getSymbol(), "tabelas " + ctx.condicao().VARIAVEL(0).getText() + " e " + ctx.VARIAVEL(0).getText() + " sao diferentes");
            
            //se a variável da condição não existe na tabela
            else if (!SqlalgSemanticoUtils.existeVariavel(listaTabela, ctx.condicao().VARIAVEL(0).getText(), ctx.condicao().VARIAVEL(1).getText()))
                SqlalgSemanticoUtils.adicionarErroSemantico(ctx.condicao().VARIAVEL(1).getSymbol(), "variavel " + ctx.condicao().VARIAVEL(1).getText() + " mencionada na selecao nao existe na tabela " + ctx.condicao().VARIAVEL(0).getText());                        
        }
       
        return super.visitSubselecao(ctx);
    }
    
    @Override
    public Void visitAtualizacao(SqlalgParser.AtualizacaoContext ctx) {
        if (SqlalgSemanticoUtils.existeTabela(listaTabela, ctx.VARIAVEL(0).getText()) == null)
            SqlalgSemanticoUtils.adicionarErroSemantico(ctx.VARIAVEL(0).getSymbol(), "tabela " + ctx.VARIAVEL(0).getText() + " mencionada na atualizacao nao existe");
        
        else if (!SqlalgSemanticoUtils.existeVariavel(listaTabela, ctx.VARIAVEL(0).getText(), ctx.VARIAVEL(1).getText()))
            SqlalgSemanticoUtils.adicionarErroSemantico(ctx.VARIAVEL(1).getSymbol(), "variavel " + ctx.VARIAVEL(1).getText() + " mencionada na atualizacao nao existe na tabela " + ctx.VARIAVEL(0).getText());
        
        else { //verifica se o novo dado é do mesmo tipo que a variável
            TipoSqlalg tipoVar = SqlalgSemanticoUtils.ordemTipo(listaTabela, ctx.VARIAVEL(0).getText(), ctx.VARIAVEL(1).getText());
            String strTipo = tipoVar.name();
            boolean erro = false;
            erro = SqlalgSemanticoUtils.verificarTipo(strTipo, ctx.VARIAVEL(1).getText(), ctx.dado(), literalLista, literalTam);
            
            if (erro) //tipo de dado incompatível com a variável
                SqlalgSemanticoUtils.adicionarErroSemantico(ctx.dado().start, "dado " + ctx.dado().getText() + " possui um tipo incompativel");
        }
        
        for (int i = 0; i < ctx.mais_dado().VARIAVEL().size(); i++) {
            if (!SqlalgSemanticoUtils.existeVariavel(listaTabela, ctx.VARIAVEL(0).getText(), ctx.mais_dado().VARIAVEL(i).getText()))
                SqlalgSemanticoUtils.adicionarErroSemantico(ctx.mais_dado().VARIAVEL(i).getSymbol(), "variavel " + ctx.mais_dado().VARIAVEL(i).getText() + " mencionada na insercao nao existe");
            else { //verifica se o mais_dado.dado é do mesmo tipo do mais_dado.variavel
                TabelaDeSimbolos.TipoSqlalg tipoVar = SqlalgSemanticoUtils.ordemTipo(listaTabela, ctx.VARIAVEL(0).getText(), ctx.mais_dado().VARIAVEL(i).getText());
                String strTipo = tipoVar.name();

                boolean erro = false;
                erro = SqlalgSemanticoUtils.verificarTipo(strTipo, ctx.mais_dado().VARIAVEL(i).getText(), ctx.mais_dado().dado(i), literalLista, literalTam);

                if (erro) //tipo de dado incompatível com a variável
                    SqlalgSemanticoUtils.adicionarErroSemantico(ctx.mais_dado().dado(i).start, "dado " + ctx.mais_dado().dado(i).getText() + " possui um tipo incompativel");
            }
        }
        
        if (ctx.condicao() != null) { //caso WHERE
            if (!ctx.condicao().VARIAVEL(0).getText().equals(ctx.VARIAVEL(0).getText()))
                SqlalgSemanticoUtils.adicionarErroSemantico(ctx.condicao().VARIAVEL(0).getSymbol(), "tabelas " + ctx.VARIAVEL(0).getText() + " e " +ctx.condicao().VARIAVEL(0).getText() + " sao diferentes");
        }
        
        return super.visitAtualizacao(ctx);
    }
    
}
