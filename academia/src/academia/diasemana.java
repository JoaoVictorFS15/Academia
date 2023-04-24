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
public class diasemana {
    private int iddiasemana;
    private String nome;
    

    public diasemana(int iddiasemana, String nome) {
        this.iddiasemana = iddiasemana;
        this.nome = nome;
    }

    public diasemana() {
    }

    public int getIddiasemana() {
        return iddiasemana;
    }

    public void setIddiasemana(int iddiasemana) {
        this.iddiasemana = iddiasemana;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
     public void cadastrar (String pNome) throws SQLException
    {
        Connection con = Conexao.getConexaoMySQL();
        PreparedStatement st = null;
        st = con.prepareStatement("insert into diasemana (Nome) values (?)");
        st.setString(1, pNome);
       
       
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
    public void atualizar (diasemana pDiaSemana) throws SQLException
    {
        Connection con = Conexao.getConexaoMySQL();
        PreparedStatement st = null;
        st = con.prepareStatement("update diasemana  set Nome  = ? where iddiasemana = ? ");
        st.setInt(2,pDiaSemana.getIddiasemana());
        st.setString(1, pDiaSemana.getNome());
      
       
        
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
    
    public void excluir (diasemana pDiaSemana) throws SQLException
    {
        Connection con = Conexao.getConexaoMySQL();
        PreparedStatement st = null;
        st = con.prepareStatement("delete from diasemana where iddiasemana = ?");
        st.setInt(1, pDiaSemana.getIddiasemana());
        
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
        ArrayList DiaSemana = new ArrayList();
        Connection con = Conexao.getConexaoMySQL();
        
        try {
            PreparedStatement st = null;
            //Precisamos guardar o resultado em um resultset
            ResultSet rs = null;
            st = con.prepareStatement("SELECT * FROM diasemana ");
            rs = st.executeQuery();

            while (rs.next()) 
            {
                diasemana dia = new diasemana();

                dia.setIddiasemana(rs.getInt("iddiasemana"));
                dia.setNome(rs.getString("Nome"));
               

           DiaSemana.add(dia);
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
        return DiaSemana;
    }
    
    public diasemana ler(int pIdDia) throws SQLException
    {
        Connection con = Conexao.getConexaoMySQL();
      diasemana dia = new diasemana();
        try {
            PreparedStatement st = null;
            //Precisamos guardar o resultado em um resultset
            ResultSet rs = null;
            st = con.prepareStatement("SELECT * FROM diasemana where iddiasemana = ?");
            st.setInt(1, pIdDia);
            rs = st.executeQuery();

            while (rs.next()) 
            {
                dia = new diasemana();

               dia.setIddiasemana(rs.getInt("iddiasemana"));
                dia.setNome(rs.getString("Nome"));
                
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
        return dia;
    }
     @Override
    public String toString()
    {
        return getNome();
    }
    
}
