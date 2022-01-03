/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.management;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author RashedGtz
 */
public class SellerProfileUpdate extends javax.swing.JFrame {

    /**
     * Creates new form SellerProfileUpdate
     */
    public SellerProfileUpdate() {
        initComponents();
        LoadData();

    }

    String url = "jdbc:mysql://localhost:3306/ShopManagement";
    String uname = "root";
    String pass = "239515amimysql";

    Connection con = null;
    Statement st = null;
    ResultSet rs = null;

    String GenderValue;
    String FullNameValue;
    String AddressValue;
    String EmailValue;
    String PhoneNoValue;

    String UserNameValue;
    String PasswordValue;
    String ConfirmPasswordValue;

    String SellerUserName = new Login().SellerNameAccepted;

    public void LoadData() {
        try {
            con = DriverManager.getConnection(url, uname, pass);

            String Query = "Select * from shopmanagement.sellerinfo where UserName = '" + SellerUserName + "'";
            Statement Add = con.createStatement();
            ResultSet Rs = Add.executeQuery(Query);
            Rs.next();

            FullNameValue = Rs.getString("FullName");
            AddressValue = Rs.getString("Address");
            EmailValue = Rs.getString("Email");
            PhoneNoValue = Rs.getString("PhoneNo");
            GenderValue = Rs.getString("Gender");
            PasswordValue = Rs.getString("Password");
            
            UserName.setText(SellerUserName);
            Gender.setText(GenderValue);
            FullName.setText(FullNameValue);
            Address.setText(AddressValue);
            PhoneNo.setText(PhoneNoValue);
            Email.setText(EmailValue);
            
            

            Add.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
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
        Gender = new javax.swing.JTextField();
        Email = new javax.swing.JTextField();
        UserName = new javax.swing.JTextField();
        PhoneNo = new javax.swing.JTextField();
        FullName = new javax.swing.JTextField();
        Address = new javax.swing.JTextField();
        ChangePassword = new javax.swing.JButton();
        CloseBut = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        HomeBut = new javax.swing.JButton();
        Update1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(960, 720));
        setMinimumSize(new java.awt.Dimension(960, 720));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(960, 720));

        jPanel1.setLayout(null);

        Gender.setEditable(false);
        Gender.setBackground(new java.awt.Color(204, 255, 255));
        Gender.setForeground(new java.awt.Color(0, 0, 0));
        Gender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenderActionPerformed(evt);
            }
        });
        jPanel1.add(Gender);
        Gender.setBounds(320, 290, 420, 40);

        Email.setBackground(new java.awt.Color(204, 255, 255));
        Email.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(Email);
        Email.setBounds(320, 570, 420, 40);

        UserName.setEditable(false);
        UserName.setBackground(new java.awt.Color(204, 255, 255));
        UserName.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(UserName);
        UserName.setBounds(320, 220, 420, 40);

        PhoneNo.setBackground(new java.awt.Color(204, 255, 255));
        PhoneNo.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(PhoneNo);
        PhoneNo.setBounds(320, 500, 420, 40);

        FullName.setBackground(new java.awt.Color(204, 255, 255));
        FullName.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(FullName);
        FullName.setBounds(320, 360, 420, 40);

        Address.setBackground(new java.awt.Color(204, 255, 255));
        Address.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(Address);
        Address.setBounds(320, 430, 420, 40);

        ChangePassword.setBackground(new java.awt.Color(153, 153, 255));
        ChangePassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/ChangePassBUt.png"))); // NOI18N
        ChangePassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ChangePasswordMouseClicked(evt);
            }
        });
        jPanel1.add(ChangePassword);
        ChangePassword.setBounds(700, 70, 250, 40);

        CloseBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Close_BUT.png"))); // NOI18N
        CloseBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CloseButMouseClicked(evt);
            }
        });
        jPanel1.add(CloseBut);
        CloseBut.setBounds(930, 0, 25, 30);

        jLabel2.setFont(new java.awt.Font("Candara", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 255));
        jLabel2.setText("PROFILE INFORMATION");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(380, 150, 250, 31);

        jLabel6.setFont(new java.awt.Font("Candara", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 255));
        jLabel6.setText("Email");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(170, 580, 80, 20);

        jLabel7.setFont(new java.awt.Font("Candara", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 255));
        jLabel7.setText("Phone No");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(170, 510, 80, 20);

        jLabel8.setFont(new java.awt.Font("Candara", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 255));
        jLabel8.setText("Address");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(170, 440, 80, 20);

        jLabel9.setFont(new java.awt.Font("Candara", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 255));
        jLabel9.setText("Full Name");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(170, 370, 80, 20);

        jLabel10.setFont(new java.awt.Font("Candara", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 255));
        jLabel10.setText("Gender");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(170, 300, 80, 20);

        jLabel13.setFont(new java.awt.Font("Candara", 1, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 255));
        jLabel13.setText("User Name");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(170, 230, 80, 20);

        HomeBut.setBackground(new java.awt.Color(153, 153, 255));
        HomeBut.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        HomeBut.setIcon(new javax.swing.ImageIcon("D:\\Icon\\25h\\HOME_BUT.png")); // NOI18N
        HomeBut.setBorder(null);
        HomeBut.setBorderPainted(false);
        HomeBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeButMouseClicked(evt);
            }
        });
        HomeBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeButActionPerformed(evt);
            }
        });
        jPanel1.add(HomeBut);
        HomeBut.setBounds(10, 70, 50, 40);

        Update1.setBackground(new java.awt.Color(153, 153, 255));
        Update1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/UpdateBut.png"))); // NOI18N
        Update1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Update1MouseClicked(evt);
            }
        });
        Update1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Update1ActionPerformed(evt);
            }
        });
        jPanel1.add(Update1);
        Update1.setBounds(400, 640, 180, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/BG(96-72).jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 960, 720);

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

    private void HomeButMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeButMouseClicked
        new SellerConsol().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_HomeButMouseClicked

    private void HomeButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeButActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HomeButActionPerformed

    private void ChangePasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChangePasswordMouseClicked
        new SellerPasswordUpdate().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ChangePasswordMouseClicked

    private void CloseButMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseButMouseClicked
        int response = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            
            if( response == JOptionPane.YES_OPTION)
            {
                System.exit(0);
            }
    }//GEN-LAST:event_CloseButMouseClicked

    private void GenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GenderActionPerformed

    private void Update1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Update1MouseClicked
        
        if ( UserName.getText().isEmpty() || Gender.getText().isEmpty() || FullName.getText().isEmpty() || Address.getText().isEmpty() || PhoneNo.getText().isEmpty() || Email.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Information Missing");
        } else {
            try {
                con = DriverManager.getConnection(url, uname, pass);

                String E_FullName = FullName.getText();
                String E_Address = Address.getText();
                String E_PhoneNo = PhoneNo.getText();
                String E_Email = Email.getText();

                String Query = "Update shopmanagement.sellerinfo set FullName = '"+E_FullName+"'"+" , Address = '"+E_Address+"'"+" , Email = '"+E_Email+"'"+" , PhoneNo = '"+E_PhoneNo+"'"+" where UserName ='"+SellerUserName+"'";
                Statement Add = con.createStatement();
                Add.executeUpdate(Query);
                con.close();
                JOptionPane.showMessageDialog(this, "Profile Information Updated Successfully");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_Update1MouseClicked

    private void Update1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Update1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Update1ActionPerformed

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
            java.util.logging.Logger.getLogger(SellerProfileUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SellerProfileUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SellerProfileUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SellerProfileUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SellerProfileUpdate().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Address;
    private javax.swing.JButton ChangePassword;
    private javax.swing.JLabel CloseBut;
    private javax.swing.JTextField Email;
    private javax.swing.JTextField FullName;
    private javax.swing.JTextField Gender;
    private javax.swing.JButton HomeBut;
    private javax.swing.JTextField PhoneNo;
    private javax.swing.JButton Update1;
    private javax.swing.JTextField UserName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}