/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author victo
 */
public class Conexao {
    
 public static String status = "Não conectado!";
 
    //MÃ©todo Construtor da Classe
    public Conexao() { 
    }
    public static java.sql.Connection getConexaoMySQL() throws SQLException 
    {
        Connection connection = null;          //atributo do tipo Connection
        try 
        {
            
            String driverName = "com.mysql.jdbc.Driver";                        
            Class.forName(driverName);

          //Configurando a nossa conexÃ£o com um banco de dados//
          //String serverName = "localhost:3306";    //caminho do servidor do BD
          //String mydatabase ="ayurvedese";        //nome do seu banco de dados
            String url = "jdbc:mysql://localhost:3306/academia?zeroDateTimeBehavior=convertToNull";
            String username = "root";        //nome de um usuÃ¡rio de seu BD      
            String password = "";      //sua senha de acesso
            connection = DriverManager.getConnection(url, username, password);
            //Testa sua conexÃ£o//  
            if (connection != null) {
                status = "STATUS--->Conectado com sucesso!";
                //JOptionPane.showMessageDialog(null, status);
            } else {
                status = "STATUS--->Não foi possivel realizar conexão";
                JOptionPane.showMessageDialog(null, status);
            }
            return connection;
        } 
        catch (ClassNotFoundException e) 
        {  
            System.out.println("O driver expecificado nao foi encontrado.");
            return null;
        } 
        catch (SQLException e) 
        { 
        
            System.out.println("Nao foi possivel conectar ao Banco de Dados.");
            return null;
        }
    }
    
    
    public static String statusConection() {
        return status;
    }
    
    
    public static boolean FecharConexao() {
        try {
            Conexao.getConexaoMySQL().close();
            status = "Conexão fechada!";
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    
    //MÃ©todo que reinicia sua conexÃ£o//
    public static java.sql.Connection ReiniciarConexao() throws SQLException {
        FecharConexao();
        return Conexao.getConexaoMySQL();
    }
    
}
