/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academia;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author victo
 */
public class Tela_Alunos extends javax.swing.JInternalFrame {

    /**
     * Creates new form Tela_alunos
     */
    public Tela_Alunos() throws SQLException {
        initComponents();
        LerJTable();
    }
     public void LerJTable () throws SQLException
    {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setNumRows(0);
        jTable1.setRowSorter(new TableRowSorter(modelo));
        //Preciso cadastrar o objeto que representa a linha da tabela e depois 
        //percorrer a lista com os clientes e pegar os dados e adicionar Ã  linha 
        //da tabela.
        Object linha[] = new Object[6];
        
        alunos alu = new alunos();
        ArrayList Alunos = new ArrayList();
        Alunos = alu.ler();
        
        for (int i = 0; i < Alunos.size(); i++) 
        {
            alu = (alunos)Alunos.get(i);
            linha[0] = alu.getMatricula();
            linha[1] = alu.getNome();
            linha[2]= alu.getTelefone();
            linha[3]= alu.getEndereco();
            linha[4]= alu.getBairro();
            linha[5] = alu.getData_Matricula();
           
            
            //Adicionando a linha no JTable
            modelo.addRow(linha);
          //jComboBox1.addItem(inse.toString());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDataMatricula = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setText("Nome:");

        jLabel2.setText("Telefone");

        jLabel3.setText("Endereço:");

        jLabel4.setText("Bairro:");

        jLabel5.setText("Data da Matricula:");

        jButton1.setText("Salvar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Alterar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Excluir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Matricula", "Nome", "Telefone", "Endereço", "Bairro", "Data Da Matricula"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDataMatricula))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNome))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEndereco)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBairro))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDataMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
          alunos alu = new alunos();
             SimpleDateFormat formatoData = new SimpleDateFormat("dd/mm/yyyy");
       Date data = null;
        try {
            data = formatoData.parse(txtDataMatricula.getText().trim());
        } catch (ParseException ex) {
            Logger.getLogger(Tela_Alunos.class.getName()).log(Level.SEVERE, null, ex);
        }
        java.sql.Date dataParaBanco = new java.sql.Date(data.getTime());    
       
        try {
           alu.cadastrar(txtNome.getText().trim(), Integer.parseInt(txtTelefone.getText().trim()), txtEndereco.getText().trim(),txtBairro.getText().trim(),dataParaBanco);
            JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso!");
            txtNome.setText("");
            txtTelefone.setText("");
            txtEndereco.setText("");
            txtBairro.setText("");
            txtDataMatricula.setText("");
            
            LerJTable();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Cadastrar: " + ex.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       alunos alu = new alunos();
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/mm/yyyy");
       Date data = null;
        try {
            data = formatoData.parse(txtDataMatricula.getText().trim());
        } catch (ParseException ex) {
            Logger.getLogger(Tela_Alunos.class.getName()).log(Level.SEVERE, null, ex);
        }
          java.sql.Date dataParaBanco = new java.sql.Date(data.getTime());    

        try {
       
         alu.atualizar(txtNome.getText().trim(), Integer.parseInt( txtTelefone.getText().trim()),txtEndereco.getText().trim(), txtBairro.getText().trim(), dataParaBanco, (int)jTable1.getValueAt
        (jTable1.getSelectedRow(), 0));
          
          
            JOptionPane.showMessageDialog(null, "Aluno atualizado com sucesso!");
            txtNome.setText("");
            txtTelefone.setText("");
            txtEndereco.setText("");
            txtBairro.setText("");
            txtDataMatricula.setText("");
            LerJTable();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex.getMessage());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
           alunos alu = new alunos();
        try {
            alu.setMatricula(
                    (int)jTable1.getValueAt
        (jTable1.getSelectedRow(), 0));
            alu.excluir(alu);
            JOptionPane.showMessageDialog(null, 
                    "Aluno excluido com sucesso!");
             txtNome.setText("");
            txtTelefone.setText("");
            txtEndereco.setText("");
            txtBairro.setText("");
            txtDataMatricula.setText("");
            LerJTable();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, 
                    "Erro ao excluir: " + ex.getMessage());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
   
         if(jTable1.getSelectedRow() != -1)
        {
            txtNome.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
            
           //Fazendo com que a formataÃ§Ã£o de data fique equivalente ao banco de dados
           SimpleDateFormat formatoData = new SimpleDateFormat("dd/mm/yyyy");
           Date data = null;
            try {
                //Convertendo a data do tipo aaaa-MM-dd para dd/MM/aaaa
                String dataAux = jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString();
                String[] dataFinal = dataAux.split("-");
                dataAux = dataFinal[2] +"/"+dataFinal[1]+"/"+dataFinal[0];

                data = formatoData.parse(dataAux);
            } catch (ParseException ex) {
                Logger.getLogger(Tela_Alunos.class.getName()).log(Level.SEVERE, null, ex);
            }
            java.sql.Date dataParaBanco = new java.sql.Date(data.getTime());

            txtDataMatricula.setText(dataParaBanco.toString());
           
        }
    }//GEN-LAST:event_jTable1KeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
      
      
           txtTelefone.setText(jTable1.getValueAt(
                jTable1.getSelectedRow(), 2).toString());
           txtEndereco.setText(jTable1.getValueAt(
                jTable1.getSelectedRow(), 3).toString());
     
           txtBairro.setText(jTable1.getValueAt(
                jTable1.getSelectedRow(), 4).toString());
             txtDataMatricula.setText(jTable1.getValueAt(
                jTable1.getSelectedRow(), 5).toString());
             
             txtNome.setText(jTable1.getValueAt(
                jTable1.getSelectedRow(), 1).toString());
        //Fazendo com que a formataÃ§Ã£o de data fique equivalente ao banco de dados
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");

        String dataAux = null;
        //Convertendo a data do tipo aaaa-MM-dd para dd/MM/aaaa
        dataAux = jTable1.getValueAt(jTable1.getSelectedRow(), 5).toString();
        String[] dataFinal = dataAux.split("-");
        dataAux = dataFinal[2] +"/"+dataFinal[1]+"/"+dataFinal[0];
        
        //Data convertida e agora colocando dentro da caixa de texto data de lanÃ§amento da tela
        txtDataMatricula.setText(dataAux);
        
        
        
      
 
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtDataMatricula;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}