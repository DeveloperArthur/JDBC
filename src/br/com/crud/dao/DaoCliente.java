package br.com.crud.dao;
 
import br.com.crud.model.Cliente;
import br.com.crud.model.Dao;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
 
public class DaoCliente extends Dao{
    
    public boolean cadastrarCliente(Cliente cli){
        String comando = "insert into clientes (nome,cpf, genero,telefone,idade,endereco,cidade,estado,cep) values (?,?,?,?,?,?,?,?,?)";
        this.conectar();
        try {
            this.stmt = (PreparedStatement) this.conn.prepareStatement(comando);
            this.stmt.setString(1, cli.getNome());
            this.stmt.setString(2, cli.getCpf());
            this.stmt.setString(3, cli.getGenero());
            this.stmt.setString(4, cli.getTelefone());
            this.stmt.setInt(5, cli.getIdade());
            this.stmt.setString(6, cli.getEndereco());
            this.stmt.setString(7, cli.getCidade());
            this.stmt.setString(8, cli.getEstado());
            this.stmt.setString(9, cli.getCep());
            this.stmt.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
          return true; 
        
    }
    
  public Cliente buscarCliente(int id){
        String comando = "select * from clientes where id = ?";
        Cliente cli = new Cliente();
        this.conectar();
        try {
            this.stmt = (PreparedStatement) this.conn.prepareStatement(comando);
            this.stmt.setInt(1, id);
 
            ResultSet rs = this.stmt.executeQuery();
            if(rs.next()){
                cli.setId(rs.getInt("id"));
                cli.setNome(rs.getString("nome"));
                cli.setCpf(rs.getString("cpf"));
                cli.setGenero(rs.getString("genero"));
                cli.setTelefone(rs.getString("telefone"));
                cli.setIdade(rs.getInt("idade"));
                cli.setEndereco(rs.getString("endereco"));
                cli.setCidade(rs.getString("cidade"));
                cli.setEstado(rs.getString("estado"));
                cli.setCep(rs.getString("cep"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
          return cli;    
    }
    
  public boolean excluirCliente(int id){
        String comando = "delete from clientes where id = ?";    
        this.conectar();
        try {
            this.stmt = (PreparedStatement) this.conn.prepareStatement(comando);
            this.stmt.setInt(1, id);
            this.stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
          return true;    
    }
  
  public boolean atualizarCliente(Cliente cli){
        String comando = "update clientes set nome = ?,cpf =?, genero=?,telefone=?,idade=?,endereco=?,cidade=?,estado=?,cep=? where id = ?";
        this.conectar();
        try {
            this.stmt = (PreparedStatement) this.conn.prepareStatement(comando);
            this.stmt.setString(1, cli.getNome());
            this.stmt.setString(2, cli.getCpf());
            this.stmt.setString(3, cli.getGenero());
            this.stmt.setString(4, cli.getTelefone());
            this.stmt.setInt(5, cli.getIdade());
            this.stmt.setString(6, cli.getEndereco());
            this.stmt.setString(7, cli.getCidade());
            this.stmt.setString(8, cli.getEstado());
            this.stmt.setString(9, cli.getCep());
            this.stmt.setInt(10, cli.getId());
            this.stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
          return true; 
        
    }
  
  
}