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
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author victo
 */
public class turmas {
    private int Id;
    private int Duracao;
    private Time Hora_Inicio;
    private diasemana Diasemana;
    private modalidades Modalidade;

    public turmas(int Id, int Duracao, Time Hora_Inicio, diasemana Diasemana, modalidades Modalidade) {
        this.Id = Id;
        this.Duracao = Duracao;
        this.Hora_Inicio = Hora_Inicio;
        this.Diasemana = Diasemana;
        this.Modalidade = Modalidade;
    }

    public turmas() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
    

  

    public int getDuracao() {
        return Duracao;
    }

    public void setDuracao(int Duracao) {
        this.Duracao = Duracao;
    }

    public Time getHora_Inicio() {
        return Hora_Inicio;
    }

    public void setHora_Inicio(Time Hora_Inicio) {
        this.Hora_Inicio = Hora_Inicio;
    }

    public diasemana getDiasemana() {
        return Diasemana;
    }

    public void setDiasemana(diasemana Diasemana) {
        this.Diasemana = Diasemana;
    }

    public modalidades getModalidade() {
        return Modalidade;
    }

    public void setModalidade(modalidades Modalidade) {
        this.Modalidade = Modalidade;
    }
    public void cadastrar (int pDuracao,Time pHora_Inicio,diasemana pDiasemana,modalidades pModalidades ) throws SQLException
    {
        Connection con = Conexao.getConexaoMySQL();
        PreparedStatement st = null;
        st = con.prepareStatement("insert into turmas (Duracao, Hora_Inicio,atividades_Id,diasemana_iddiasemana) values (?, ?,?,?)");
 
        st.setInt(1, pDuracao);
        st.setTime(2,pHora_Inicio);
        st.setInt(4,pDiasemana.getIddiasemana());
        st.setInt(3,pModalidades.getId());
        
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
            st = con.prepareStatement("update turmas set Duracao = ?, Hora_Inicio = ?, atividades_Id = ?, diasemana_iddiasemana = ?  where Id = ?");
  
            st.setInt(1, this.getDuracao());
            st.setTime(2, this.getHora_Inicio());
            st.setInt(4, this.Diasemana.getIddiasemana());
            st.setInt(3, this.Modalidade.getId());
            st.setInt(5, this.getId());
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
    
    public void excluir (turmas pTurmas) throws SQLException
    {
        Connection con = Conexao.getConexaoMySQL();
        PreparedStatement st = null;
        st = con.prepareStatement("delete from turmas where Id = ?");
        st.setInt(1, pTurmas.getId());
        
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
        ArrayList tur = new ArrayList();
        Connection con = Conexao.getConexaoMySQL();
        
        try {
            PreparedStatement st = null;
            //Precisamos guardar o resultado em um resultset
            ResultSet rs = null;
            st = con.prepareStatement("SELECT * FROM turmas");
            rs = st.executeQuery();

            while (rs.next()) 
            {
                turmas mas = new turmas();

                mas.setId(rs.getInt("Id"));
                mas.setDuracao(rs.getInt("Duracao"));
                mas.setHora_Inicio(rs.getTime("Hora_Inicio"));
                
                diasemana sem = new diasemana();
                mas.setDiasemana(sem.ler(rs.getInt("diasemana_iddiasemana")));
                
            
               modalidades moda = new modalidades();
               mas.setModalidade(moda.ler(rs.getInt("atividades_Id")));
                
                
                tur.add(mas);
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
        return tur;
    }

   public turmas ler(int pId) throws SQLException
    {
        Connection con = Conexao.getConexaoMySQL();
       turmas mod = new turmas();
        try {
            PreparedStatement st = null;
            //Precisamos guardar o resultado em um resultset
            ResultSet rs = null;
            st = con.prepareStatement("SELECT * FROM turmas where Id = ?");
            st.setInt(1, pId);
            rs = st.executeQuery();

            while (rs.next()) 
            {
               turmas mas = new turmas();

                mas.setId(rs.getInt("Id"));
                mas.setDuracao(rs.getInt("Duracao"));
                mas.setHora_Inicio(rs.getTime("Hora_Inicio"));
                
                diasemana sem = new diasemana();
                mas.setDiasemana(sem.ler(rs.getInt("diasemana_iddiasemana")));
                
            
               modalidades moda = new modalidades();
               mas.setModalidade(moda.ler(rs.getInt("atividades_Id")));
                
                
               
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
   
   public int i (){
   return getId();
   }
   
}

    
