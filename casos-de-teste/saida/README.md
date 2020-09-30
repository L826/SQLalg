# Formato de saída:
A saída será um arquivo contendo uma mensagem de erro ou um código em SQL. As mensagens de erro vão aparecer no arquivo no seguinte formato: `Linha <numero_da_linha>: <texto_de_erro>`.

Caso de erro léxico:
```
  Linha ??: comentario nao fechado
  Linha ??: ? - simbolo nao identificado
```

Caso de erro sintático:
```
  Linha ??: erro de sintaxe proximo a <termo>
```

Os erros semânticos possuem textos específicos para cada tipo de erro. Os erros detectados pelo compilador são:
### Criação de tabela:
* Tabela sem chave primária
* Número de variáveis referenciadas incompatível com o número de variáveis na chave estrangeira
* Tipo de variável incompatível com a variável referenciada na chave estrangeira
* Uso de variável não instanciada na chave primária ou estrangeira
* Referência de chave estrangeira com tabela inexistente
* Variável referenciada não existe na tabela mencionada
### Inserção de dados na tabela:
* Tabela inexistente
* Variável não existe na tabela
* Inserção de dados com tipo incompatível com a variável
* Falta de uma das variáveis da tabela na inserção
* Cadeia de tamanho maior que o esperado (variável do tipo literal ou caractere)
* Cadeia de tamanho menor que o esperado (variável do tipo caractere)
### Apresentação da tabela na tela (seleção):
* Tabela inexistente
* Variável não existe na tabela
* Uso de agregação em tipos que não são números
* Tabela mencionada na condição não é a mesma da tabela a ser mostrada
### Atualização de tabela:
* Tabela inexistente
* Variável não existe na tabela
* Comparação entre tipos de dados diferentes
* Atualização de dados da tabela para tipos incompatíveis
* Tabela mencionada na condição não é a mesma da tabela a ser atualizada
### Exclusão de tabela:
* Tabela inexistente
* Variável não existe na tabela
* Comparação entre tipos de dados diferentes
