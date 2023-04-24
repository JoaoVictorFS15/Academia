/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author victo
 */
public class alunos {
    private int Matricula;
    private int Telefone;
    private String Endereco;
    private String Bairro;
    private Date Data_Matricula;
    private String Nome;

    public alunos(int Matricula, int Telefone, String Endereco, String Bairro, Date Data_Matricula, String Nome) {
        this.Matricula = Matricula;
        this.Telefone = Telefone;
        this.Endereco = Endereco;
        this.Bairro = Bairro;
        this.Data_Matricula = Data_Matricula;
        this.Nome = Nome;
    }

    public alunos() {
    }

    public int getMatricula() {
        return Matricula;
    }

    public void setMatricula(int Matricula) {
        this.Matricula = Matricula;
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

    public Date getData_Matricula() {
        return Data_Matricula;
    }

    public void setData_Matricula(Date Data_Matricula) {
        this.Data_Matricula = Data_Matricula;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }
     public void cadastrar (String pNome,int pTelefone, String pEndereco, String pBairro, Date pData_Matricula) throws SQLException
    {
        Connection con = Conexao.getConexaoMySQL();
        PreparedStatement st = null;
        st = con.prepareStatement("insert into alunos (Telefone,Endereco,Bairro,Data_Matricula,Nome) values (?,?,?,?,?)");
        st.setString(5, pNome);
        st.setInt(1,pTelefone);
        st.setString(2, pEndereco);
        st.setString(3, pBairro);
        st.setDate(4,pData_Matricula);
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
    public void atualizar (String pNome,int pTelefone, String pEndereco,String pBairro,Date pDataMatricula, int pMatricula) throws SQLException
    {
        Connection con = Conexao.getConexaoMySQL();
        PreparedStatement st = null;
        st = con.prepareStatement("update alunos  set Nome  = ?,  Telefone = ?,  Endereco = ?, Bairro = ?, Data_Matricula=? where Matricula = ? ");
        
        st.setString(1, pNome);
        st.setInt(2, pTelefone);
        st.setString(3,pEndereco);
        st.setString(4,pBairro);
        st.setDate(5,pDataMatricula);
        st.setInt(6,pMatricula);
       
        
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
    
    public void excluir (alunos pAlunos) throws SQLException
    {
        Connection con = Conexao.getConexaoMySQL();
        PreparedStatement st = null;
        st = con.prepareStatement("delete from alunos where Matricula= ?");
        st.setInt(1, pAlunos.getMatricula());
        
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
        ArrayList Alunos = new ArrayList();
        Connection con = Conexao.getConexaoMySQL();
        
        try {
            PreparedStatement st = null;
            //Precisamos guardar o resultado em um resultset
            ResultSet rs = null;
            st = con.prepareStatement("SELECT * FROM alunos ");
            rs = st.executeQuery();

            while (rs.next()) 
            {
                alunos alu = new alunos();

                alu.setMatricula(rs.getInt("Matricula"));
                alu.setNome(rs.getString("Nome"));
                alu.setTelefone(rs.getInt("Telefone"));
                alu.setEndereco(rs.getString("Endereco"));
                alu.setBairro(rs.getString("Bairro"));
                alu.setData_Matricula(rs.getDate("Data_Matricula"));

                Alunos.add(alu);
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
        return Alunos;
    }
    
    public alunos ler(int pId) throws SQLException
    {
        Connection con = Conexao.getConexaoMySQL();
        alunos alu = new alunos();
        try {
            PreparedStatement st = null;
            //Precisamos guardar o resultado em um resultset
            ResultSet rs = null;
            st = con.prepareStatement("SELECT * FROM alunos where Matricula = ?");
            st.setInt(1, pId);
            rs = st.executeQuery();

            while (rs.next()) 
            {
                alu = new alunos();

               alu.setMatricula(rs.getInt("Matricula"));
                alu.setNome(rs.getString("Nome"));
                alu.setTelefone(rs.getInt("Telefone"));
                alu.setEndereco(rs.getString("Endereco"));
                alu.setBairro(rs.getString("Bairro"));
                alu.setData_Matricula(rs.getDate("Data_Matricula"));
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
        return alu;
    }
   public int i()
    {
        return getMatricula();
    }
   
        
}
