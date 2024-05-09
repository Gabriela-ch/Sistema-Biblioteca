package  com.biblioteca.view;

import java.util.List;

import com.biblioteca.model.entity.Livro;

public class LivroView {
  public void mostrarDetalhesLivro(Livro livro) {
    System.out.println("Detalhes do livro:");
    System.out.println("ID: " + livro.getId());
    System.out.println("Título: " + livro.getTitulo());
    System.out.println("Autor: " + livro.getAutor());
  }

  public void mostrarListaLivros(List<Livro> livros) {
    System.out.println("Lista de livros:");
    for (Livro livro : livros) {
      System.out.println("ID: " + livro.getId() + ", Título: " + livro.getTitulo()+ livro.getStatus());
    }
  }

  public void mostrarMensagem(String mensagem) {
    System.out.println(mensagem);
  }
}
