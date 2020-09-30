# Códigos do compilador:
A gramática foi feita em ANTLR4 e contém todas as regras gramaticais do SQLalg. Ela é a base para a construção do compilador.

Os outros códigos foram feitos em Java. São 6 classes separadas em Principal, TabelaDeSimbolos, SqlalgGeradorSql e Erros:

* A classe Principal é responsável por fazer o compilador rodar no terminal. Lá o arquivo de entrada é lido e o arquivo de saída é gerado com o texto de erro ou o código em SQL.

* A classe TabelaDeSimbolos é a classe que coordena as tabelas criadas em SQL, sendo a base para verificação de erros do compilador. Cada tabela terá nome, lista de variáveis e número de variáveis. 

* A classe SqlalgGeradorSql converte o algoritmo presente no arquivo de entrada e o converte em código SQL. Essa classe só será utilizada se não houverem erros no algoritmo.

* O grupo de classe Erros é composta por SqlalgErrorListener, SqlalgSemanticoUtils e SqlalgSemantico. SqlalgErrorListener vai ser responsável por detectar erros léxicos e sintáticos no arquivo de entrada. SqlalgSemanticoUtils e SqlalgSemantico tratam dos erros semânticos do arquivo, sendo o SqlalgSemanticoUtils usado como auxiliar para verificar informações das tabelas geradas pelo algoritmo do arquivo de entrada. O SqlalgSemantico vai comparar os casos de erro e escrever o erro detectado para um StringBuilder, que será passado ao arquivo de saída.
