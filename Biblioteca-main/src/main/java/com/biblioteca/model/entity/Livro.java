package  com.biblioteca.model.entity;

public class Livro extends AbstractEntity {

  private String titulo;

  private String autor;

  private String status;


  private boolean emprestado;

  public Livro(String autor, String titulo) {
    this.titulo = titulo;
    this.autor = autor;
  }

  public Livro(int id, String titulo, String autor) {
    super.setId(id);
    this.titulo = titulo;
    this.autor = autor;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getAutor() {
    return autor;
  }

  public void setAutor(String autor) {
    this.autor = autor;
  }

public boolean isEmprestado() {
    return emprestado;
}

public void setEmprestado(boolean b) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'setEmprestado'");
}

  public String setStatus(String status){
    return status;
  }

  public String getStatus(){
    return status;
  }




}
