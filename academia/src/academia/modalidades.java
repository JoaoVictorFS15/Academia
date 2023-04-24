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
public class modalidades {
    private int Id;
    private String Descricao;
    private String Nome;

    public modalidades(int Id, String Descricao, String Nome) {
        this.Id = Id;
        this.Descricao = Descricao;
        this.Nome = Nome;
    }

    public modalidades() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    


    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }
    public void cadastrar (String pNome, String pDescricao) throws SQLException
    {
        Connection con = Conexao.getConexaoMySQL();
        PreparedStatement st = null;
        st = con.prepareStatement("insert into modalidades (Descricao,Nome) values (?,?)");
        st.setString(2, pNome);
        st.setString(1,pDescricao);
       
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
   
    public void atualizar (modalidades pModalidades) throws SQLException
    {
        Connection con = Conexao.getConexaoMySQL();
        PreparedStatement st = null;
        st = con.prepareStatement("update modalidades  set Descricao  = ?,  Nome = ? where Id = ? ");
        st.setInt(3,pModalidades.getId());
        st.setString(2, pModalidades.getNome());
        st.setString(1,pModalidades.getDescricao());
       
        
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
    
    public void excluir (modalidades pModalidades) throws SQLException
    {
        Connection con = Conexao.getConexaoMySQL();
        PreparedStatement st = null;
        st = con.prepareStatement("delete from modalidades where Id= ?");
        st.setInt(1, pModalidades.getId());
        
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
        ArrayList Modalidades = new ArrayList();
        Connection con = Conexao.getConexaoMySQL();
        
        try {
            PreparedStatement st = null;
            //Precisamos guardar o resultado em um resultset
            ResultSet rs = null;
            st = con.prepareStatement("SELECT * FROM modalidades ");
            rs = st.executeQuery();

            while (rs.next()) 
            {
                modalidades mod = new modalidades();

                mod.setId(rs.getInt("Id"));
                mod.setNome(rs.getString("Nome"));
                mod.setDescricao(rs.getString("Descricao"));

            Modalidades.add(mod);
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
        return Modalidades;
    }
    
    public modalidades ler(int pId) throws SQLException
    {
        Connection con = Conexao.getConexaoMySQL();
       modalidades mod = new modalidades();
        try {
            PreparedStatement st = null;
            //Precisamos guardar o resultado em um resultset
            ResultSet rs = null;
            st = con.prepareStatement("SELECT * FROM modalidades where Id = ?");
            st.setInt(1, pId);
            rs = st.executeQuery();

            while (rs.next()) 
            {
                mod = new modalidades();

               mod.setId(rs.getInt("Id"));
                mod.setNome(rs.getString("Nome"));
                mod.setDescricao(rs.getString("Descricao"));
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
        return mod;
    }
     @Override
    public String toString()
    {
        return getNome();
    }
    
}
