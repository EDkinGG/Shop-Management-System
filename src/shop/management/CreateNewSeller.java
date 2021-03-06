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
public class CreateNewSeller extends javax.swing.JFrame {

    /**
     * Creates new form CreateNewSeller
     */
    public CreateNewSeller() {
        initComponents();
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
        FullName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Address = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Email = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        PhoneNo = new javax.swing.JTextField();
        Confirm_But = new javax.swing.JButton();
        Gender = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        UserName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        CloseBut = new javax.swing.JLabel();
        Back = new javax.swing.JButton();
        Password = new javax.swing.JPasswordField();
        ConfirmPassword = new javax.swing.JPasswordField();
        ShowPassword = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(960, 720));
        setMinimumSize(new java.awt.Dimension(960, 720));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Candara", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 255));
        jLabel2.setText("Fill in the Form to Register");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(360, 80, 270, 31);

        FullName.setBackground(new java.awt.Color(204, 255, 255));
        FullName.setForeground(new java.awt.Color(0, 0, 0));
        FullName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FullNameActionPerformed(evt);
            }
        });
        jPanel1.add(FullName);
        FullName.setBounds(320, 200, 350, 40);

        jLabel3.setFont(new java.awt.Font("Candara", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 255));
        jLabel3.setText("Gender");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(180, 150, 60, 20);

        jLabel8.setFont(new java.awt.Font("Candara", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 255));
        jLabel8.setText("Address");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(180, 270, 60, 20);

        Address.setBackground(new java.awt.Color(204, 255, 255));
        Address.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(Address);
        Address.setBounds(320, 260, 350, 40);

        jLabel4.setFont(new java.awt.Font("Candara", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 255));
        jLabel4.setText("Email");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(180, 330, 50, 20);

        Email.setBackground(new java.awt.Color(204, 255, 255));
        Email.setForeground(new java.awt.Color(0, 0, 0));
        Email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailActionPerformed(evt);
            }
        });
        jPanel1.add(Email);
        Email.setBounds(320, 320, 350, 40);

        jLabel5.setFont(new java.awt.Font("Candara", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 255));
        jLabel5.setText("Phone No");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(180, 390, 70, 20);

        PhoneNo.setBackground(new java.awt.Color(204, 255, 255));
        PhoneNo.setForeground(new java.awt.Color(0, 0, 0));
        PhoneNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PhoneNoActionPerformed(evt);
            }
        });
        jPanel1.add(PhoneNo);
        PhoneNo.setBounds(320, 380, 350, 40);

        Confirm_But.setBackground(new java.awt.Color(153, 153, 255));
        Confirm_But.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/SubmitBut2.png"))); // NOI18N
        Confirm_But.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Confirm_ButMouseClicked(evt);
            }
        });
        Confirm_But.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Confirm_ButActionPerformed(evt);
            }
        });
        jPanel1.add(Confirm_But);
        Confirm_But.setBounds(390, 660, 190, 40);

        Gender.setBackground(new java.awt.Color(51, 153, 255));
        Gender.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Gender.setForeground(new java.awt.Color(255, 255, 255));
        Gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        Gender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenderActionPerformed(evt);
            }
        });
        jPanel1.add(Gender);
        Gender.setBounds(320, 138, 350, 40);

        jLabel6.setFont(new java.awt.Font("Candara", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 255));
        jLabel6.setText("Full Name");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(180, 210, 80, 20);

        UserName.setBackground(new java.awt.Color(204, 255, 255));
        UserName.setForeground(new java.awt.Color(0, 0, 0));
        UserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserNameActionPerformed(evt);
            }
        });
        jPanel1.add(UserName);
        UserName.setBounds(320, 460, 350, 40);

        jLabel7.setFont(new java.awt.Font("Candara", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 255));
        jLabel7.setText("Confirm Password");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(180, 590, 130, 20);

        jLabel9.setFont(new java.awt.Font("Candara", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 255));
        jLabel9.setText("Password");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(180, 530, 70, 20);

        jLabel10.setFont(new java.awt.Font("Candara", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 255));
        jLabel10.setText("User Name");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(180, 470, 80, 20);

        CloseBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Close_BUT.png"))); // NOI18N
        CloseBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CloseButMouseClicked(evt);
            }
        });
        jPanel1.add(CloseBut);
        CloseBut.setBounds(930, 0, 25, 30);

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
        Back.setBounds(10, 70, 42, 26);

        Password.setBackground(new java.awt.Color(255, 255, 255));
        Password.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Password.setForeground(new java.awt.Color(0, 0, 0));
        Password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordActionPerformed(evt);
            }
        });
        jPanel1.add(Password);
        Password.setBounds(320, 520, 350, 40);

        ConfirmPassword.setBackground(new java.awt.Color(255, 255, 255));
        ConfirmPassword.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        ConfirmPassword.setForeground(new java.awt.Color(0, 0, 0));
        ConfirmPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmPasswordActionPerformed(evt);
            }
        });
        jPanel1.add(ConfirmPassword);
        ConfirmPassword.setBounds(320, 580, 350, 40);

        ShowPassword.setText("Show Password");
        ShowPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ShowPasswordMouseClicked(evt);
            }
        });
        ShowPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowPasswordActionPerformed(evt);
            }
        });
        jPanel1.add(ShowPassword);
        ShowPassword.setBounds(320, 630, 140, 23);

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

    private void PhoneNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PhoneNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PhoneNoActionPerformed

    private void EmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmailActionPerformed

    private void GenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GenderActionPerformed

    private void UserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserNameActionPerformed

    private void Confirm_ButMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Confirm_ButMouseClicked

        int chk = 0;
        int UniqueChk = 0;
        int value = 10;
        int value2 = 10;
        if (FullName.getText().isEmpty() || Address.getText().isEmpty() || Email.getText().isEmpty() || PhoneNo.getText().isEmpty() || UserName.getText().isEmpty() || Password.getText().isEmpty() || ConfirmPassword.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Information missing");
        } else {
            chk = 1;
            GenderValue = Gender.getSelectedItem().toString();
            FullNameValue = FullName.getText();
            AddressValue = Address.getText();
            EmailValue = Email.getText();
            PhoneNoValue = PhoneNo.getText();
            UserNameValue = UserName.getText();
            PasswordValue = Password.getText();
            ConfirmPasswordValue = ConfirmPassword.getText();
        }

        if (chk == 1) {
            if (!PasswordValue.equals(ConfirmPasswordValue)) {
                JOptionPane.showMessageDialog(this, "Wrong Confirm Password");
            } else {
                try {
                    con = DriverManager.getConnection(url, uname, pass);

                    String Query = "select count(*) from sellerinfo where UserName = '" + UserNameValue + "'";
                    Statement Add = con.createStatement();
                    ResultSet Rs = Add.executeQuery(Query);
                    Rs.next();
                    
                    value = Rs.getInt("count(*)");
//                    System.out.println(value);
                    Add.close();
                    con.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
                
                try {
                    con = DriverManager.getConnection(url, uname, pass);

                    String Query = "select count(*) from pending where UserName = '" + UserNameValue + "'";
                    Statement Add = con.createStatement();
                    ResultSet Rs = Add.executeQuery(Query);
                    Rs.next();
                    
                    value2 = Rs.getInt("count(*)");
//                    System.out.println(value);
                    Add.close();
                    con.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
                
                if( value > 0 || value2>0)
                {
                    JOptionPane.showMessageDialog(this, "User Name Already Taken");
                }
                else
                {
                    UniqueChk = 1;
                }

            }
        }
        
        if( UniqueChk == 1)
        {
            try {
                con = DriverManager.getConnection(url, uname, pass);
                PreparedStatement add = con.prepareStatement("insert into pending values(?,?,?,?,?,?,?)");
                add.setString(1,UserNameValue);
                add.setString(2,FullNameValue);
                add.setString(3,AddressValue);
                add.setString(4,EmailValue);
                add.setString(5,PhoneNoValue);
                add.setString(6,PasswordValue);
                add.setString(7,GenderValue);
                int row = add.executeUpdate();
                JOptionPane.showMessageDialog(this, "Your Account Request is Received Successfully, Wait for the Admin Approval");
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            FullName.setText("");
            Address.setText("");
            Email.setText("");
            PhoneNo.setText("");
            UserName.setText("");
            Password.setText("");
            ConfirmPassword.setText("");
        }

    }//GEN-LAST:event_Confirm_ButMouseClicked

    private void CloseButMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseButMouseClicked
       int response = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            
            if( response == JOptionPane.YES_OPTION)
            {
                System.exit(0);
            }
    }//GEN-LAST:event_CloseButMouseClicked

    private void FullNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FullNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FullNameActionPerformed

    private void BackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseClicked
        new AccountOption().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackMouseClicked

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BackActionPerformed

    private void PasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordActionPerformed

    private void ConfirmPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ConfirmPasswordActionPerformed

    private void ShowPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ShowPasswordMouseClicked

    }//GEN-LAST:event_ShowPasswordMouseClicked

    private void ShowPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowPasswordActionPerformed
        if(ShowPassword.isSelected())
        {
            Password.setEchoChar((char)0);
            ConfirmPassword.setEchoChar((char)0);
        }
        else
        {
            Password.setEchoChar('*');
            ConfirmPassword.setEchoChar('*');
        }
    }//GEN-LAST:event_ShowPasswordActionPerformed

    private void Confirm_ButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Confirm_ButActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Confirm_ButActionPerformed

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
            java.util.logging.Logger.getLogger(CreateNewSeller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateNewSeller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateNewSeller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateNewSeller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateNewSeller().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Address;
    private javax.swing.JButton Back;
    private javax.swing.JLabel CloseBut;
    private javax.swing.JPasswordField ConfirmPassword;
    private javax.swing.JButton Confirm_But;
    private javax.swing.JTextField Email;
    private javax.swing.JTextField FullName;
    private javax.swing.JComboBox<String> Gender;
    private javax.swing.JPasswordField Password;
    private javax.swing.JTextField PhoneNo;
    private javax.swing.JCheckBox ShowPassword;
    private javax.swing.JTextField UserName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
