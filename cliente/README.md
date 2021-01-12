# Cadastro de Cliente

Essa questão tem como objetivo provar sua capacidade de utilizar abstração, herança e polimorfismo. Nela você terá de fazer um aplicativo do console que deve ler e imprimir **EXTRITAMENTE** como demonstrado nos exemplos. Também será necessário salvar, deletar e obter dados em memória, utilize boas práticas de programção para separar as responsabilidades em camadas.

Essa aplicação deve possuir as seguintes entidades com tais atributos:

- **Cliente:** ID, Nome, Cidade;
- **Compra:** Cliente, Data, Valor, Valor Imposto.

As Compras realizadas em cidades cuja última letra for "a" terão 10% de imposto nas compras, as cidades cuja última letra for "o" terão 20% de imposto nas compras e as demais não terão imposto calculado nas compras.

O Cliente passa a ter o status de "Especial" se possuir mais de R$ 1.000,00 em compras.

## Opções de Entrada do Console

As entradas a seguir são exemplos de utilização da aplicação que só será encerrada quando o usuário utilizar a última opção (9).

### 1. Listar Clientes

Essa opção deve listar todos os seus Clientes cadastrados em memória no seguinte formato, pela ordem de inclusão dos dados. Exemplo:

    > java -jar cliente/target/cliente-1.0-SNAPSHOT.jar
    > 1
    > 2; 0; João; Vila Velha
    Cliente 0 incluído
    > 1
    | 0 | João | Vila Velha |
    > 9

### 2. Incluir Cliente

Essa opção deve incluir um Cliente em sua base de dados em memória, como mostrado acima no exemplo anterior, a inclusão segue o seguinte formato:

**2; \<ID-Cliente>; \<Nome-Cliente>; \<Cidade-Cliente>**

Deve produzir a seguinte saída:

**Cliente \<ID-Cliente> incluído**

Exemplo:

    > java -jar cliente/target/cliente-1.0-SNAPSHOT.jar
    > 2; 0; João; Vila Velha
    Cliente 0 incluído
    > 9

### 3. Alterar Cliente

Essa opção deve alterar um Cliente previamente cadastrado em sua base de dados em memória, seguindo o formato abaixo:

**3; \<ID-Cliente-Ja-Cadastrado>; \<Novo-Nome-Cliente>; \<Nova-Cidade-Cliente>**

Deve produzir a seguinte saída:

**Cliente \<ID-Cliente-Ja-Cadastrado> alterado**

Exemplo:

    > java -jar cliente/target/cliente-1.0-SNAPSHOT.jar
    > 2; 0; João; Vila Velha
    Cliente 0 incluído
    > 3; 0; Thiago; Ouro Preto
    Cliente 0 alterado
    > 1
    | 0 | Thiago | Ouro Preto |
    > 9

### 4. Excluir Cliente

Essa opção deve excluir um Cliente previamente cadastrado em sua base de dados em memória, seguindo o formato abaixo:

**4; \<ID-Cliente-Ja-Cadastrado>**

Deve produzir a seguinte saída:

**Cliente \<ID-Cliente-Ja-Cadastrado> excluído**

Exemplo:

    > java -jar cliente/target/cliente-1.0-SNAPSHOT.jar
    > 2; 0; João; Vila Velha
    Cliente 0 incluído
    > 2; 1; Thiago; Ouro Preto
    Cliente 1 incluído
    > 4; 0
    Cliente 0 excluído
    > 1
    | 1 | Thiago | Ouro Preto |
    > 9

### 5. Consultar Cliente

Essa opção deve imprimir os dados de um Cliente previamente cadastrado, passando o ID pelo console, seguindo o seguinte formato:

**5; \<ID-Cliente-Ja-Cadastrado>**

Deve produzir a seguinte saída:

**\<ID-Cliente> \<Nome-Cliente> \<Cidade-Cliente>**

Exemplo:

    > java -jar cliente/target/cliente-1.0-SNAPSHOT.jar
    > 2; 0; João; Vila Velha
    Cliente 0 incluído
    > 5; 0
    0 João Vila Velha
    > 9

### 6. Incluir Compra

Essa opção deve incluir uma Compra na base associada a um Cliente previamente cadastrado, deve ser utilizado o seguinte formato para a inclusão:

**6; \<ID-Cliente-Ja-Cadastrado>; \<Data-Compra>; \<Valor-Compra>**

**OBS:** O parâmetro **\<Data-Compra>** deve estar no seguinte formato: **dd/mm/aaaa** e o **\<Valor-Compra>** deve estar no seguinte formato: **999.999,99**.

Deve produzir a seguinte saída:

Exemplo:

    > java -jar cliente/target/cliente-1.0-SNAPSHOT.jar
    > 2; 0; João; Vila Velha
    Cliente 0 incluído
    > 6; 0; 12/12/2020; 1.310,00
    Compra para o cliente 0 incluída
    > 9

### 7. Listar Compras

Essa opção deve listar todas as Compras cadastradas na base em ordem de inclusão dos dados no seguinte formato. Exemplo:

    > java -jar cliente/target/cliente-1.0-SNAPSHOT.jar
    > 2; 0; João; Vila Velha
    Cliente 0 incluído
    > 6; 0; 12/12/2020; 1.310,00
    Compra para o cliente 0 incluída
    > 7
    | 0 | João | 12/12/2020 | R$ 1.310,00 | R$ 131,00 |
    | Total Compras: R$ 1.310,00 |
    > 9

### 8. Listar Clientes "Especiais"

Lembrando um Cliente é Especial se possuir mais de R$ 1.000,00 em compras. Essa opção deve listar os seguintes dados no seguinte formato: ID e Nome do Cliente, Total de Compras. Total Compras é o somatório de todas as compras do Cliente. A tabela deve estar ordenada de forma decrescente pelo Total de Compras. Exemplo:

    > java -jar cliente/target/cliente-1.0-SNAPSHOT.jar
    > 2; 0; João; Vila Velha
    Cliente 0 incluído
    > 6; 0; 12/12/2020; 1.310,00
    Compra para o cliente 0 incluída
    > 8
    | 0 | João | R$ 1.310,00 |
    > 9

### 9. Sair da Aplicação

Essa opção como já foi mostrado em todos os outros exemplos anteriores deve sair do aplicativo de console.

# LEMBRANDO NOVAMENTE

Todas as entradas e saída devem estar no formato da questão, não é necessário se preocupar com tratamento de erros da entrada.

Boa Prova!
