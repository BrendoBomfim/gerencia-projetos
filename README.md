# Gerenciador de Projetos e Tarefas

Este é um aplicativo web de gerenciamento de projetos e tarefas. Ele permite aos usuários visualizar, adicionar, editar e excluir projetos e suas respectivas tarefas.

## Tecnologias Utilizadas

- **Java Server Faces (JSF)** com **RichFaces** para a camada de apresentação.
- **Spring Framework** para a camada de negócio e injeção de dependência.
- **Hibernate** para mapeamento objeto-relacional (ORM) e acesso ao banco de dados.
- **HQL (Hibernate Query Language)** para consultas ao banco de dados.
- **PostgreSQL** como banco de dados.
- **Jetty** como servidor da aplicação.

## Pré-requisitos

- JDK 11 ou superior
- Apache Maven
- PostgreSQL

## Instalação

1. Clone este repositório para sua máquina local:
   ```
   git clone https://github.com/BrendoBomfim/gerenciador-projetos.git
   ```

2. Importe o projeto em sua IDE Java como um projeto Maven.

3. Certifique-se de ter o PostgreSQL instalado e configurado localmente.

4. Crie um banco de dados chamado `project-management` no PostgreSQL.

5. Configure as informações de conexão com o banco de dados no arquivo `src/main/resources/META-INF/applicationContext.xml`.

6. Execute a aplicação. Certifique-se de que o servidor de aplicação está configurado corretamente em sua IDE.

## Execução

Após seguir os passos de instalação, inicie a aplicação com os seguintes comandos:
```
mvn clean install
mvn jetty:run
```

Após o servidor inicializar, acesse-a em seu navegador utilizando o seguinte endereço:
```
http://localhost:8080
```
