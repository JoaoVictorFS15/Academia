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
public class aulas {
    private instrutores Instrutores;
   private int alunos_Matricula;
   private int turmas_Id;

    public aulas(instrutores Instrutores, int alunos_Matricula, int turmas_Id) {
        this.Instrutores = Instrutores;
        this.alunos_Matricula = alunos_Matricula;
        this.turmas_Id = turmas_Id;
    }

    public aulas() {
    }

    public instrutores getInstrutores() {
        return Instrutores;
    }

    public void setInstrutores(instrutores Instrutores) {
        this.Instrutores = Instrutores;
    }

    public int getAlunos_Matricula() {
        return alunos_Matricula;
    }

    public void setAlunos_Matricula(int alunos_Matricula) {
        this.alunos_Matricula = alunos_Matricula;
    }

    public int getTurmas_Id() {
        return turmas_Id;
    }

    public void setTurmas_Id(int turmas_Id) {
        this.turmas_Id = turmas_Id;
    }

   
   

    

  
    
    public void cadastrar (instrutores pInstrutores,int pAlunos_Matricula,int pTurmas_Id ) throws SQLException
    {
        Connection con = Conexao.getConexaoMySQL();
        PreparedStatement st = null;
        st = con.prepareStatement("insert into aulas (instrutores_Id,alunos_Matricula,turmas_Id) values (?, ?,?)");
 
        st.setInt(1,pInstrutores.getId() );
        st.setInt(2,pAlunos_Matricula);
        st.setInt(3,pTurmas_Id);
       
        
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
    
    public void atualizar () throws SQLException
    {
       
        
        Connection con = Conexao.getConexaoMySQL();
        PreparedStatement st = null;
        try {
            st = con.prepareStatement("update aulas set instrutores_Id = ?, alunos_Matricula = ?, turmas_Id = ?  where turmas_Id =  ?");
  
            st.setInt(1, this.Instrutores.getId());
         
            st.setInt(2, this.getAlunos_Matricula());
            st.setInt(3, this.getTurmas_Id());
            st.setInt(4, this.getTurmas_Id());
          
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
    
    public void excluir (aulas pAulas) throws SQLException
    {
        Connection con = Conexao.getConexaoMySQL();
        PreparedStatement st = null;
        st = con.prepareStatement("delete from aulas where turmas_id = ?");
        st.setObject(1, getTurmas_Id());
        
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
        ArrayList Aulas = new ArrayList();
        Connection con = Conexao.getConexaoMySQL();
        
        try {
            PreparedStatement st = null;
            //Precisamos guardar o resultado em um resultset
            ResultSet rs = null;
            st = con.prepareStatement("SELECT * FROM aulas");
            rs = st.executeQuery();

            while (rs.next()) 
            {
                aulas mas = new aulas();

                instrutores ins = new instrutores();
                mas.setInstrutores(ins.ler(rs.getInt("instrutores_Id")));
                
              
                mas.setAlunos_Matricula(rs.getInt("alunos_Matricula"));
                
               
              mas.setTurmas_Id(rs.getInt("turmas_Id"));
              
               
                
                
                Aulas.add(mas);
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
        return Aulas;
    }
   
}

    


