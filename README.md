Fui submetido a uma avaliação pratica, com objetivo de trabalhar em uma empresa como desenvolvedor Java. O desafio foi concluído e estou deixando a resposta registrada para consulta futura.

# Avaliação Java

Esse teste tem como objetivo classificar os melhores candidatos para o ingresso em nossa Fábrica de Software, ele é composto por duas questões:

* Sequência de Fibonacci - dentro da pasta "fibonacci"
* Cadastro de Clientes - dentro da pasta "cliente"

Cada questão já possui uma estrutura base criada através do Maven 3.6.3 e Java 8 que **NÃO DEVE SER ALTERADA**, como por exemplo, a classe principal "App.java" e as configurações do arquivo "pom.xml", caso necessário você é livre para adicionar dependências ao projeto. Dentro de cada questão existe um arquivo README.md com a descrição do que deve ser feito, leia-o com atenção, pois cada questão possui um objetivo em particular.

Em cada README.md possui uma explicação detalhada de cada questão, além de exemplificar as entradas e saídas, para gerar o JAR de cada questão você pode utilizar o seguinte comando Maven:

    mvn clean compile assembly:single

Será maior pontuada as questões que tiverem maior organização do código, padrões de projeto, estratégia adotada, performance, dentre outras boas práticas de programação. Sendo um diferencial a criação de testes unitários utilizando o JUnit 4.

## Observações

A questão "Fibonacci" já está pronta e poderá ser usada como exemplo para a construção das demais questões, lembrando que a organização e divisão em camadas do seu código é livre, apenas mantenha a estrutura base entregue como está.

Todas as entradas e saída devem estar no formato da questão, não é necessário se preocupar com tratamento de erros da entrada.

Boa Prova!
