/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao.Excluir;

import DAO.*;
import Modelo.*;
import java.sql.Connection;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author crisl
 */
public class ExcluirCategoria extends javax.swing.JFrame {
    
    private void AtualizaCombo(){
        Connection con = Conexao.AbrirConexao();
        CategoriaDAO sql = new CategoriaDAO(con);
        List<Categoria> lista = new ArrayList<>();
        
        lista = sql.ListarComboCategoria();
        jCB_Nome.addItem("");
        
        for (Categoria b : lista){
        jCB_Nome.addItem(b.getNome());
        }
    
        Conexao.FecharConexao(con);
        
    }

    /**
     * Creates new form ExcluirCategoria
     */
    public ExcluirCategoria() {
        initComponents();
        setLocationRelativeTo(this);
        AtualizaCombo();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTF_Codigo = new javax.swing.JTextField();
        jTF_odigo = new javax.swing.JButton();
        jCB_Nome = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Agency FB", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Excluir Categoria");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Nome:");

        jTF_Codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTF_CodigoActionPerformed(evt);
            }
        });

        jTF_odigo.setText("OK");
        jTF_odigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTF_odigoActionPerformed(evt);
            }
        });

        jCB_Nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCB_NomeActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jTF_Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCB_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jTF_odigo, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTF_Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCB_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTF_odigo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTF_CodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTF_CodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTF_CodigoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jCB_NomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCB_NomeActionPerformed
      
    Connection con = Conexao.AbrirConexao();
    CategoriaDAO sql = new CategoriaDAO(con);
    List<Categoria> lista = new ArrayList<>();
    String nome =jCB_Nome.getSelectedItem().toString();
    
    lista = sql.ConsultaCodigoCategoria(nome);
    
    for (Categoria b : lista) {
        int a = b.getCodigo();
        jTF_Codigo.setText("" + a);
    }
    Conexao.FecharConexao(con);
    }//GEN-LAST:event_jCB_NomeActionPerformed

    private void jTF_odigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTF_odigoActionPerformed
        String codigo = jTF_Codigo.getText();
     String nome = jCB_Nome.getSelectedItem(). toString();
     
     Connection con = Conexao.AbrirConexao();
     CategoriaDAO sql = new CategoriaDAO(con);
     Categoria a = new Categoria();
     if (nome.equals("")) {
         JOptionPane.showConfirmDialog(null, "Nenhum Nome Selecionado",
                 "Video Locadora", JOptionPane.WARNING_MESSAGE);
     } else {
         int b = JOptionPane.showConfirmDialog(null, "Deseja realmente Excluir"
         + " \n ("+ codigo + ") ( " + nome + ")", "Video Locadora",
         JOptionPane.YES_NO_OPTION,JOptionPane. QUESTION_MESSAGE);
      if (b == 0) {
          int cod = Integer.parseInt(codigo);
          a.setNome(nome);
          a.setCodigo(cod);
          sql.Excluir_Categoria(a);
          Conexao.FecharConexao(con);}
    }//GEN-LAST:event_jTF_odigoActionPerformed

    }
    public static void main(String args[]) {
    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExcluirCategoria().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jCB_Nome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTF_Codigo;
    private javax.swing.JButton jTF_odigo;
    // End of variables declaration//GEN-END:variables

   
}
