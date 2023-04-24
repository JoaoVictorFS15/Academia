/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author victo
 */
public class instrutores {
    private int Id;
    private String Nome;
    private int Telefone;
    private String Endereco;
    private String Bairro;

    public instrutores(int Id, String Nome, int Telefone, String Endereco, String Bairro) {
        this.Id = Id;
        this.Nome = Nome;
        this.Telefone = Telefone;
        this.Endereco = Endereco;
        this.Bairro = Bairro;
    }
    

    public instrutores() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public int getTelefone() {
        return Telefone;
    }

    public void setTelefone(int Telefone) {
        this.Telefone = Telefone;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String Bairro) {
        this.Bairro = Bairro;
    }
    
    public void cadastrar (String pNome,int pTelefone, String pEndereco, String pBairro) throws SQLException
    {
        Connection con = Conexao.getConexaoMySQL();
        PreparedStatement st = null;
        st = con.prepareStatement("insert into instrutores (Nome,Telefone,Endereco,Bairro) values (?,?,?,?)");
        st.setString(1, pNome);
        st.setInt(2,pTelefone);
        st.setString(3, pEndereco);
        st.setString(4, pBairro);
        try {
            st.executeUpdate();
        }
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally{
            con.close();
        }
    }
   // int pId ,String pNome,int pTelefone, String pEndereco, String pBairro
    public void atualizar (instrutores pInstrutores) throws SQLException
    {
        Connection con = Conexao.getConexaoMySQL();
        PreparedStatement st = null;
        st = con.prepareStatement("update instrutores  set Nome  = ?,  Telefone = ?,  Endereco = ?, Bairro = ? where Id = ? ");
        st.setInt(5,pInstrutores.getId());
        st.setString(1, pInstrutores.getNome());
        st.setInt(2, pInstrutores.getTelefone());
        st.setString(3,pInstrutores.getEndereco());
        st.setString(4,pInstrutores.getBairro());
       
        
        try {
            st.executeUpdate();
        }
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally{
            con.close();
        }
    }
    
    public void excluir (instrutores pInstruores) throws SQLException
    {
        Connection con = Conexao.getConexaoMySQL();
        PreparedStatement st = null;
        st = con.prepareStatement("delete from instrutores where Id = ?");
        st.setInt(1, pInstruores.getId());
        
        try {
            st.executeUpdate();
        }
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally{
            con.close();
        }
    }
    
    public ArrayList ler() throws SQLException
    {
        ArrayList Instrutores = new ArrayList();
        Connection con = Conexao.getConexaoMySQL();
        
        try {
            PreparedStatement st = null;
            //Precisamos guardar o resultado em um resultset
            ResultSet rs = null;
            st = con.prepareStatement("SELECT * FROM instrutores ");
            rs = st.executeQuery();

            while (rs.next()) 
            {
                instrutores ins = new instrutores();

                ins.setId(rs.getInt("Id"));
                ins.setNome(rs.getString("Nome"));
                ins.setTelefone(rs.getInt("Telefone"));
                ins.setEndereco(rs.getString("Endereco"));
                ins.setBairro(rs.getString("Bairro"));

                Instrutores.add(ins);
            }
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage());
        }
        finally
        {
            Conexao.FecharConexao();
        }
        return Instrutores;
    }
    
    public instrutores ler(int pId) throws SQLException
    {
        Connection con = Conexao.getConexaoMySQL();
        instrutores ins = new instrutores();
        try {
            PreparedStatement st = null;
            //Precisamos guardar o resultado em um resultset
            ResultSet rs = null;
            st = con.prepareStatement("SELECT * FROM instrutores where Id = ?");
            st.setInt(1, pId);
            rs = st.executeQuery();

            while (rs.next()) 
            {
                ins = new instrutores();

               ins.setId(rs.getInt("Id"));
                ins.setNome(rs.getString("Nome"));
                ins.setTelefone(rs.getInt("Telefone"));
                ins.setEndereco(rs.getString("Endereco"));
                ins.setBairro(rs.getString("Bairro"));
            }
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage());
        }
        finally
        {
            Conexao.FecharConexao();
        }
        return ins;
    }
    
     @Override
    public String toString()
    {
        return getNome();
    }
}
