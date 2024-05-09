package com.biblioteca;

import java.util.List;
import java.util.Scanner;

import com.biblioteca.controller.LivroController;
import com.biblioteca.model.entity.Livro;
import com.biblioteca.view.LivroView;

public class SistemaBiblioteca {
  private LivroController livroController;
  private LivroView livroView;
  private Scanner scanner;

  public SistemaBiblioteca(LivroController livroController, LivroView livroView, Scanner scanner) {
    this.livroController = livroController;
    this.livroView = livroView;
    this.scanner = scanner;
  }

  public void iniciar() {
    int opcao;
    do {
      mostrarMenu();
      opcao = scanner.nextInt();
      switch (opcao) {
        case 1:
          cadastrarLivro();
          break;
        case 2:
          listarLivros();
          break;
        case 3:
          emprestarLivro();
          break;
        case 4:
          devolverLivro();
          break;
        case 5:
          atualizarLivro();
          break;
        case 6:
        buscarLivro();
          break;
        case 7:
        excluirLivro();
          break;
        case 0:
          livroView.mostrarMensagem("Saindo do sistema...");
          break;
        default:
          livroView.mostrarMensagem("Opção inválida!");
          break;
      }
    } while (opcao != 0);
  }

  private void mostrarMenu() {
    livroView.mostrarMensagem("Escolha uma opção:");
    livroView.mostrarMensagem("*****         Menu        *****");
    livroView.mostrarMensagem("*****  1. Cadastrar Livro *****");
    livroView.mostrarMensagem("*****  2. Listar Livros   *****");
    livroView.mostrarMensagem("*****  3. Emprestar Livro *****");
    livroView.mostrarMensagem("*****  4. Devolver Livro  *****");
    livroView.mostrarMensagem("*****  5. Atualizar Livro *****");
    livroView.mostrarMensagem("*****  6. Buscar Livro   *****");
    livroView.mostrarMensagem("*****  7. Excluir Livro   *****");
    livroView.mostrarMensagem("*****  0. Sair            *****");
  }

  private void cadastrarLivro() {
    scanner.nextLine(); // Limpar o buffer do scanner
    livroView.mostrarMensagem("Digite o título do livro:");
    String titulo = scanner.nextLine();
    livroView.mostrarMensagem("Digite o autor do livro:");
    String autor = scanner.nextLine();

    Livro novoLivro = new Livro(titulo, autor);
    String retorno = livroController.cadastrarLivro(novoLivro);
    livroView.mostrarMensagem(retorno);
  }

  private void listarLivros() {
    livroView.mostrarMensagem("*** Livros Cadastrados ***");
    List<Livro> livros = livroController.listarLivros();
    livroView.mostrarListaLivros(livros);
    livroView.mostrarMensagem("**************************");
  }

  private void atualizarLivro() {
    livroView.mostrarMensagem("Digite o ID do livro a ser atualizado:");
    int id = scanner.nextInt();
    Livro livro = livroController.buscarLivro(id);
    if (livro != null) {
      scanner.nextLine(); // Limpar o buffer do scanner
      livroView.mostrarMensagem("Digite o novo título do livro:");
      String titulo = scanner.nextLine();
      livro.setTitulo(titulo);
      livroView.mostrarMensagem("Digite o novo autor do livro:");
      String autor = scanner.nextLine();
      livro.setAutor(autor);
      livroView.mostrarMensagem("Digite o novo número de páginas do livro:");
      String retorno = livroController.atualizarLivro(livro);
      livroView.mostrarMensagem(retorno);
    } else {
      livroView.mostrarMensagem("Livro não encontrado!");
    }
  }

  private void excluirLivro() {
    livroView.mostrarMensagem("Digite o ID do livro a ser excluído:");
    int id = scanner.nextInt();
    String retorno = livroController.excluirLivro(id);
    livroView.mostrarMensagem(retorno);
  }

  private void buscarLivro() {
    livroView.mostrarMensagem("Digite o ID do livro a ser buscado:");
    int id = scanner.nextInt();
    Livro livro = livroController.buscarLivro(id);
    if (livro != null) {
      livroView.mostrarDetalhesLivro(livro);
    } else {
      livroView.mostrarMensagem("Livro não encontrado!");
    }
  }

  private void devolverLivro() {
    livroView.mostrarMensagem("Digite o ID do livro a ser devolvido:");
    int id = scanner.nextInt();
    Livro livro = livroController.buscarLivro(id);
    if (livro != null) {
      // Alterar o status do livro para disponível para empréstimo
      livro.setStatus("Disponível para Empréstimo");
      livroController.atualizarLivro(livro);
      livroView.mostrarMensagem("Livro devolvido com sucesso!");
    } else {
      livroView.mostrarMensagem("Livro não encontrado!");
    }
  }

  private void emprestarLivro() {
    livroView.mostrarMensagem("Digite o ID do livro a ser emprestado:");
    int id = scanner.nextInt();
    // String retorno = livroController.emprestarLivro(id);
    // livroView.mostrarMensagem(retorno);
    Livro livro = livroController.buscarLivro(id);
    if (livro != null) {
      // Alterar o status do livro para emprestado
      livro.setStatus("Emprestado");
      livroController.atualizarLivro(livro);
      livroView.mostrarMensagem("Livro emprestado com sucesso!");
    } else {
      livroView.mostrarMensagem("Livro não encontrado!");
    }

  }

}
