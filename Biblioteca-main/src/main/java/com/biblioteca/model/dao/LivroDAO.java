package  com.biblioteca.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.biblioteca.config.DBConfig;
import com.biblioteca.model.entity.AbstractEntity;
import com.biblioteca.model.entity.Livro;

public class LivroDAO implements IDAO {

  private static final String INSERT_QUERY = "INSERT INTO livro (titulo, autor) VALUES (?, ?)";

  private static final String UPDATE_QUERY = "UPDATE livro SET titulo=?, autor=? WHERE id=?";

  private static final String DELETE_QUERY = "DELETE FROM livro WHERE id=?";

  private static final String SELECT_QUERY = "SELECT * FROM livro";

  private static final String SELECT_BY_ID_QUERY = "SELECT * FROM livro WHERE id=?";

  @Override
  public void cadastrar(AbstractEntity entidade) {
    Livro livro = (Livro) entidade;
    try (Connection conn = DBConfig.getConnection();
        PreparedStatement stmt = conn.prepareStatement(INSERT_QUERY)) {
      stmt.setString(1, livro.getTitulo());
      stmt.setString(2, livro.getAutor());
      stmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void atualizar(AbstractEntity entidade) {
    Livro livro = (Livro) entidade;
    try (Connection conn = DBConfig.getConnection();
        PreparedStatement stmt = conn.prepareStatement(UPDATE_QUERY)) {
      stmt.setString(1, livro.getTitulo());
      stmt.setString(2, livro.getAutor());
      stmt.setInt(3, livro.getId());
      stmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void excluir(int id) {
    try (Connection conn = DBConfig.getConnection();
        PreparedStatement stmt = conn.prepareStatement(DELETE_QUERY)) {
      stmt.setInt(1, id);
      stmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public AbstractEntity buscar(int id) {
    Livro livro = null;
    try (Connection conn = DBConfig.getConnection();
        PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID_QUERY)) {
      stmt.setInt(1, id);
      try (ResultSet rs = stmt.executeQuery()) {
        if (rs.next()) {
          livro = new Livro(rs.getInt("id"), rs.getString("titulo"), rs.getString("autor") );
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return livro;
  }

  @Override
  public List<AbstractEntity> listar() {
    List<AbstractEntity> livros = new ArrayList<>();
    try (Connection conn = DBConfig.getConnection();
        PreparedStatement stmt = conn.prepareStatement(SELECT_QUERY);
        ResultSet rs = stmt.executeQuery()) {
      while (rs.next()) {
        Livro livro = new Livro(rs.getInt("id"), rs.getString("titulo"), rs.getString("autor"));
        livros.add(livro);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return livros;
  }

  public boolean isEmprestado(int id) {
    Livro livro = (Livro) buscar(id);
    return livro != null && livro.isEmprestado(); 
}


public void setEmprestado(int idLivro, boolean emprestado) {
  String sql = "UPDATE Livro SET emprestado = ? WHERE id = ?";

  try (Connection conexao = DBConfig.getConnection();
       PreparedStatement pstmt = conexao.prepareStatement(sql)) {
      pstmt.setBoolean(1, emprestado);
      pstmt.setInt(2, idLivro);
      pstmt.executeUpdate();
  } catch (SQLException e) {
      e.printStackTrace();
  }
}

@Override
public void emprestar(int id) {
  // TODO Auto-generated method stub
  throw new UnsupportedOperationException("Unimplemented method 'emprestar'");
}

@Override
public void devolver(int id) {
  // TODO Auto-generated method stub
  throw new UnsupportedOperationException("Unimplemented method 'devolver'");
}

}
