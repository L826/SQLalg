grammar Sqlalg;

programa: 'algoritmo' corpo 'fim_algoritmo' ;

criacao: 'cria' VARIAVEL '(' tipo VARIAVEL (',' tipo VARIAVEL)* ',' 'chave_primaria' VARIAVEL '(' VARIAVEL mais_var? ')' (',' 'chave_estrangeira' VARIAVEL '(' VARIAVEL mais_var? ')' 'de' VARIAVEL '(' VARIAVEL mais_var? ')')* ')' ;
//CREATE TABLE cria tabela

tipo: 'inteiro' | ('literal' '[' NUM_INT ']') | 'real' | ('caractere' '[' NUM_INT ']') | 'data' | 'hora' | 'data_hora' ;

insercao: 'insere' VARIAVEL '(' VARIAVEL '=' dado mais_dado? ')' ;
//INSERT escreve dados na tabela criada

dado: NUM_INT | NUM_REAL | CADEIA | DATA | HORA | DATAHORA;

selecao: 'escreva' VARIAVEL ('.' VARIAVEL)? mais_var? 'se' condicao agrupa? | 'escreva_tudo_de' VARIAVEL agrupa? | 'escreva' (agregacao|contador) 'de' VARIAVEL ('se' condicao)? agrupa?;
//SELECT mostra tabela na tela

subselecao: 'escreva' VARIAVEL ('.' VARIAVEL)? mais_var? 'se' condicao | 'escreva_tudo_de' VARIAVEL | 'escreva' (agregacao|contador) 'de' VARIAVEL ('se' condicao)?;
//SELECT dentro de SELECT

atualizacao: 'atualiza' VARIAVEL '(' VARIAVEL '=' dado mais_dado? ')' ('se' condicao)?;
//UPDATE

mais_dado: (',' VARIAVEL '=' dado)*;

mais_var: (',' VARIAVEL ('.' VARIAVEL)?)*;

condicao: VARIAVEL '.' VARIAVEL op (dado | subselecao | VARIAVEL '.' VARIAVEL);
//sempre compara a mesma variável de diferentes tabelas

agregacao: ('media'|'maximo'|'minimo'|'soma') '(' VARIAVEL ')' ;
//AVG - MIN - MAX - SUM

contador: 'contador' '(' VARIAVEL ')';
//COUNT

agrupa: ('agrupado'|'ordenado') VARIAVEL;
//GROUP BY - ORDER BY

op: '=' | '<>' | '<=' | '>=' | '<' | '>' ;

deleta: 'deleta' VARIAVEL ('se' condicao)? | 'descarta' VARIAVEL ;
//DELETE ou DROP exclui tabela ou linhas da tabela

comando: criacao | insercao | selecao | atualizacao | deleta;

corpo: comando*;
//permite que os comandos venham em qualquer ordem no programa SQL

CADEIA: '"' ~('\n' | '"')* '"';

VARIAVEL: ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;

NUM_INT: ('+'|'-')? ('0'..'9')+;

NUM_REAL: ('+'|'-')? ('0'..'9')+ '.' ('0'..'9')+;

HORA: ('0'..'2') ('0'..'9') ':' ('0'..'5') ('0'..'9') (':' ('0'..'5') ('0'..'9'))?;
//de 00:00:00 a 23:59:59

DATA: ('0'..'3') ('0'..'9') '/' ('0'..'1') ('0'..'9') '/' ('0'..'9') ('0'..'9') ('0'..'9') ('0'..'9');
//de 01/01/XXXX a 31/12/XXXX

DATAHORA: ('0'..'3') ('0'..'9') '/' ('0'..'1') ('0'..'9') '/' ('0'..'9') ('0'..'9') ('0'..'9') ('0'..'9') ' ' ('0'..'2') ('0'..'9') ':' ('0'..'5') ('0'..'9') (':' ('0'..'5') ('0'..'9'))?;

WS: (' ' | '\t' | '\r' | '\n') -> skip;
//espaço em branco, vai ser ignorado

COMENTARIO: ('{' ~('\n' | '}')* '}') -> skip;
//comentários do código SQLalg, vai ser ignorado

COMENTARIO_ABERTO : '{' ;
// Detecta comentários não fechados

ANY : . ;
// Detecta símbolos não identificados como $, @...
