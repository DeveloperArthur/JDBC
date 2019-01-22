package br.com.crud.model;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Dao {

    private String servidor;
    private String banco;
    private String usuario;
    private String senha;
    protected PreparedStatement stmt;
    protected Connection conn;

    public Dao() {
        this.servidor = "localhost:3306";
        this.banco = "cruddb";
        this.usuario = "root";
        this.senha = "";
    }

    public void conectar() {
        String url = "jdbc:mysql://" + servidor + "/" + banco;
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            try {
                conn = (Connection) DriverManager.getConnection(url, usuario, senha);
            } catch (SQLException ex) {
                Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
