/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author RashedGtz
 */
public class UpdateAdmin extends javax.swing.JFrame {

    /**
     * Creates new form UpdateAdmin
     */
    public UpdateAdmin() {
        initComponents();
    }
    
    String url = "jdbc:mysql://localhost:3306/ShopManagement";
    String uname = "root";
    String pass = "239515amimysql";

    Connection con = null;
    Statement st = null;
    ResultSet rs = null;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        AdminPass = new javax.swing.JTextField();
        AdminName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Back = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        Clear = new javax.swing.JButton();
        CloseBut = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(640, 360));
        setMinimumSize(new java.awt.Dimension(640, 360));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(640, 360));

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Candara", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 255));
        jLabel2.setText("ADMIN UPDATE");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(350, 60, 198, 43);

        AdminPass.setBackground(new java.awt.Color(255, 255, 255));
        AdminPass.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        AdminPass.setForeground(new java.awt.Color(51, 153, 255));
        AdminPass.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.add(AdminPass);
        AdminPass.setBounds(360, 175, 240, 37);

        AdminName.setBackground(new java.awt.Color(255, 255, 255));
        AdminName.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        AdminName.setForeground(new java.awt.Color(51, 153, 255));
        AdminName.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.add(AdminName);
        AdminName.setBounds(360, 120, 240, 37);

        jLabel4.setFont(new java.awt.Font("Candara", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 255));
        jLabel4.setText("Password");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(262, 186, 86, 20);

        jLabel5.setFont(new java.awt.Font("Candara", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 255));
        jLabel5.setText("Name");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(262, 131, 86, 20);

        Back.setBackground(new java.awt.Color(153, 153, 255));
        Back.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Back.setForeground(new java.awt.Color(0, 204, 255));
        Back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/BackBut.png"))); // NOI18N
        Back.setBorder(null);
        Back.setBorderPainted(false);
        Back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackMouseClicked(evt);
            }
        });
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        jPanel1.add(Back);
        Back.setBounds(12, 10, 42, 26);

        Update.setBackground(new java.awt.Color(153, 153, 255));
        Update.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Update.setForeground(new java.awt.Color(0, 204, 255));
        Update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/UpdateBut.png"))); // NOI18N
        Update.setBorder(null);
        Update.setBorderPainted(false);
        Update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UpdateMouseClicked(evt);
            }
        });
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });
        jPanel1.add(Update);
        Update.setBounds(260, 283, 150, 40);

        Clear.setBackground(new java.awt.Color(153, 153, 255));
        Clear.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Clear.setForeground(new java.awt.Color(0, 204, 255));
        Clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Clear_1.png"))); // NOI18N
        Clear.setBorder(null);
        Clear.setBorderPainted(false);
        Clear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClearMouseClicked(evt);
            }
        });
        jPanel1.add(Clear);
        Clear.setBounds(450, 283, 150, 40);

        CloseBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Close_BUT.png"))); // NOI18N
        CloseBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CloseButMouseClicked(evt);
            }
        });
        jPanel1.add(CloseBut);
        CloseBut.setBounds(610, 0, 25, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/LogIn.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 640, 360);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void UpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateMouseClicked
       if (AdminName.getText().isEmpty() || AdminPass.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Information Missing");
        } else {
            try {
                con = DriverManager.getConnection(url, uname, pass);
                
                String E_AdminName = AdminName.getText();
                String E_AdminPass = AdminPass.getText();
                
                String Query = "Update shopmanagement.admintable set AdminName='"+E_AdminName+"'"+",AdminPass='"+E_AdminPass+"'"+"where IdNo="+1;
                Statement Add = con.createStatement();
                Add.executeUpdate(Query);
                con.close();
                JOptionPane.showMessageDialog(this, "Admin Information Edited Successfully");
            } catch (SQLException e) {
                e.printStackTrace();
            }
       }
    }//GEN-LAST:event_UpdateMouseClicked

    private void BackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseClicked
        new AdminConsol().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackMouseClicked

    private void ClearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearMouseClicked
       AdminName.setText("");
       AdminPass.setText("");
    }//GEN-LAST:event_ClearMouseClicked

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BackActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateActionPerformed

    private void CloseButMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseButMouseClicked
       int response = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            
            if( response == JOptionPane.YES_OPTION)
            {
                System.exit(0);
            }
    }//GEN-LAST:event_CloseButMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UpdateAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AdminName;
    private javax.swing.JTextField AdminPass;
    private javax.swing.JButton Back;
    private javax.swing.JButton Clear;
    private javax.swing.JLabel CloseBut;
    private javax.swing.JButton Update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
