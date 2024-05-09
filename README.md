# Sistema-Biblioteca

Este é um projeto de Sistema de Biblioteca desenvolvido como parte de um exercício para praticar conceitos como MVC, JDBC, Git, Maven e Spring CLI. O sistema permite cadastrar livros, listar livros, emprestar livros e devolver livros, utilizando uma interface de linha de comando (CLI).

Tecnologias Utilizadas:
Java
JDBC (Java Database Connectivity)
Maven
Git
MySQL (ou outro banco de dados suportado)
Spring CLI
Estrutura do Projeto
O projeto segue a arquitetura MVC (Model-View-Controller) para manter a separação de responsabilidades e facilitar a manutenção do código.

Model: As classes que representam os dados do sistema, como Livro e Emprestimo.
View: A interação com o usuário é realizada via CLI (Command Line Interface), que não é abordada neste README, mas pode ser implementada conforme necessário.
Controller: A lógica de negócios é tratada na classe BibliotecaController, responsável por interagir com o modelo e o banco de dados.
Configuração do Ambiente
Antes de executar o sistema, certifique-se de ter as seguintes dependências instaladas e configuradas em sua máquina:

Java Development Kit (JDK)
Maven
Git
MySQL (ou outro banco de dados suportado)
Além disso, você precisará configurar um banco de dados com as tabelas apropriadas para armazenar informações sobre os livros e empréstimos.
