/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.management;

import javax.mail.PasswordAuthentication;
import java.sql.*;
import java.util.Properties;
import javax.mail.*;
import javax.mail.Authenticator;
//import java.net.Authenticator;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author RashedGtz
 */
public class Pending extends javax.swing.JFrame {

    /**
     * Creates new form Pending
     */
    public Pending() {
        initComponents();
        SelectPending();
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

    //ACCEPT MAIL>>>>>>>>>>>>>>>>>>>>
    public void sendmailAcc(String recipient) throws Exception {

        Properties properties = new Properties();

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        String MyAccount = "rashedtestingproject@gmail.com";
        String MyAccountPassword = "11229800project";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(MyAccount, MyAccountPassword);
            }
        });

        Message message = prepareMessage1(session, MyAccount, recipient);
        Transport.send(message);
    }

    private Message prepareMessage1(Session session, String MyAccount, String recepient) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(MyAccount));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("You are Ready to Use your Seller Account");
            message.setText("Hey there, \nYour Request has been Accepted by the Admin. Now you can login into your RS Technology Seller's Account by using the Username :" + UserNameValue + " and you can update your profile from there. \n\nGreetings from, \nAdmin");
            return message;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    //ACCEPT MAIL<<<<<<<<<<<<<<<<

    //REJECT MAIL>>>>>>>>>>>>>>
    public void sendmailRej(String recipient) throws Exception {
        Properties properties = new Properties();

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        String MyAccount = "rashedtestingproject@gmail.com";
        String MyAccountPassword = "11229800project";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(MyAccount, MyAccountPassword);
            }
        });

        Message message = prepareMessage2(session, MyAccount, recipient);
        Transport.send(message);
    }

    private Message prepareMessage2(Session session, String MyAccount, String recepient) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(MyAccount));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("You are Ready to Use your Seller Account");
            message.setText("Hey there, \nYour Request has been Rejected by the Admin. You can contact the manager of RS Technolgy for any inquire. Manager Email Addres : r23ghani@gmail.com. \n\nGreetings from, \nAdmin ");
            return message;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    //REJECT MAIL<<<<<<<<<<<<<<<

    public void SelectPending() {
        try {
            con = DriverManager.getConnection(url, uname, pass);
            st = con.createStatement();
            rs = st.executeQuery("Select * from shopmanagement.pending");
            PendingTable.setModel(DbUtils.resultSetToTableModel(rs));

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
        SellerBut = new javax.swing.JButton();
        HomeBut = new javax.swing.JButton();
        ProductBut = new javax.swing.JButton();
        CategoryBut = new javax.swing.JButton();
        TransactionBut = new javax.swing.JButton();
        PendingBut = new javax.swing.JButton();
        LogOut = new javax.swing.JButton();
        CloseIcon = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        PendingTable = new javax.swing.JTable();
        Email = new javax.swing.JTextField();
        UserName = new javax.swing.JTextField();
        Address = new javax.swing.JTextField();
        Gender = new javax.swing.JTextField();
        FullName = new javax.swing.JTextField();
        PhoneNo = new javax.swing.JTextField();
        ClearBut = new javax.swing.JButton();
        Accept = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        RejectBut1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1100, 600));
        setMinimumSize(new java.awt.Dimension(1100, 600));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));
        jPanel1.setLayout(null);

        SellerBut.setBackground(new java.awt.Color(153, 153, 255));
        SellerBut.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        SellerBut.setForeground(new java.awt.Color(255, 255, 255));
        SellerBut.setText("SELLER");
        SellerBut.setBorder(null);
        SellerBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SellerButMouseClicked(evt);
            }
        });
        jPanel1.add(SellerBut);
        SellerBut.setBounds(60, 70, 171, 40);

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

        ProductBut.setBackground(new java.awt.Color(153, 153, 255));
        ProductBut.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        ProductBut.setForeground(new java.awt.Color(255, 255, 255));
        ProductBut.setText("PRODUCT");
        ProductBut.setBorder(null);
        ProductBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProductButMouseClicked(evt);
            }
        });
        jPanel1.add(ProductBut);
        ProductBut.setBounds(230, 70, 171, 40);

        CategoryBut.setBackground(new java.awt.Color(153, 153, 255));
        CategoryBut.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        CategoryBut.setForeground(new java.awt.Color(255, 255, 255));
        CategoryBut.setText("CATEGORY");
        CategoryBut.setBorder(null);
        CategoryBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CategoryButMouseClicked(evt);
            }
        });
        jPanel1.add(CategoryBut);
        CategoryBut.setBounds(400, 70, 171, 40);

        TransactionBut.setBackground(new java.awt.Color(153, 153, 255));
        TransactionBut.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        TransactionBut.setForeground(new java.awt.Color(255, 255, 255));
        TransactionBut.setText("TRANSACTION");
        TransactionBut.setBorder(null);
        TransactionBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TransactionButMouseClicked(evt);
            }
        });
        jPanel1.add(TransactionBut);
        TransactionBut.setBounds(570, 70, 171, 40);

        PendingBut.setBackground(new java.awt.Color(102, 102, 255));
        PendingBut.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        PendingBut.setForeground(new java.awt.Color(255, 255, 255));
        PendingBut.setText("PENDING");
        PendingBut.setBorder(null);
        PendingBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PendingButMouseClicked(evt);
            }
        });
        PendingBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PendingButActionPerformed(evt);
            }
        });
        jPanel1.add(PendingBut);
        PendingBut.setBounds(740, 70, 171, 40);

        LogOut.setBackground(new java.awt.Color(153, 153, 255));
        LogOut.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        LogOut.setForeground(new java.awt.Color(255, 255, 255));
        LogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/LogoutBut2.png"))); // NOI18N
        LogOut.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        LogOut.setBorderPainted(false);
        LogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogOutMouseClicked(evt);
            }
        });
        LogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOutActionPerformed(evt);
            }
        });
        jPanel1.add(LogOut);
        LogOut.setBounds(910, 70, 180, 40);

        CloseIcon.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        CloseIcon.setForeground(new java.awt.Color(255, 255, 255));
        CloseIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Close_BUT.png"))); // NOI18N
        CloseIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CloseIconMouseClicked(evt);
            }
        });
        jPanel1.add(CloseIcon);
        CloseIcon.setBounds(1070, 0, 25, 30);

        jLabel2.setFont(new java.awt.Font("Candara", 1, 28)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 255));
        jLabel2.setText("PENDING REQUEST");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(440, 130, 240, 30);

        PendingTable.setBackground(new java.awt.Color(255, 255, 255));
        PendingTable.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PendingTable.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        PendingTable.setForeground(new java.awt.Color(153, 153, 153));
        PendingTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "User Name", "Full Name", "Address", "Email", "Phone No", "Password", "Gender"
            }
        ));
        PendingTable.setGridColor(new java.awt.Color(204, 204, 204));
        PendingTable.setIntercellSpacing(new java.awt.Dimension(0, 0));
        PendingTable.setRowHeight(25);
        PendingTable.setSelectionBackground(new java.awt.Color(102, 204, 255));
        PendingTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        PendingTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        PendingTable.setShowGrid(true);
        PendingTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PendingTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(PendingTable);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(20, 170, 1060, 150);

        Email.setEditable(false);
        Email.setBackground(new java.awt.Color(204, 255, 255));
        Email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailActionPerformed(evt);
            }
        });
        jPanel1.add(Email);
        Email.setBounds(780, 340, 250, 40);

        UserName.setEditable(false);
        UserName.setBackground(new java.awt.Color(204, 255, 255));
        UserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserNameActionPerformed(evt);
            }
        });
        jPanel1.add(UserName);
        UserName.setBounds(180, 340, 250, 40);

        Address.setEditable(false);
        Address.setBackground(new java.awt.Color(204, 255, 255));
        Address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddressActionPerformed(evt);
            }
        });
        jPanel1.add(Address);
        Address.setBounds(180, 460, 250, 40);

        Gender.setEditable(false);
        Gender.setBackground(new java.awt.Color(204, 255, 255));
        Gender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenderActionPerformed(evt);
            }
        });
        jPanel1.add(Gender);
        Gender.setBounds(780, 460, 250, 40);

        FullName.setEditable(false);
        FullName.setBackground(new java.awt.Color(204, 255, 255));
        FullName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FullNameActionPerformed(evt);
            }
        });
        jPanel1.add(FullName);
        FullName.setBounds(180, 400, 250, 40);

        PhoneNo.setEditable(false);
        PhoneNo.setBackground(new java.awt.Color(204, 255, 255));
        PhoneNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PhoneNoActionPerformed(evt);
            }
        });
        jPanel1.add(PhoneNo);
        PhoneNo.setBounds(780, 400, 250, 40);

        ClearBut.setBackground(new java.awt.Color(153, 153, 255));
        ClearBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Clear_1.png"))); // NOI18N
        ClearBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClearButMouseClicked(evt);
            }
        });
        jPanel1.add(ClearBut);
        ClearBut.setBounds(480, 520, 180, 40);

        Accept.setBackground(new java.awt.Color(153, 153, 255));
        Accept.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/AcceptBut.png"))); // NOI18N
        Accept.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AcceptMouseClicked(evt);
            }
        });
        jPanel1.add(Accept);
        Accept.setBounds(210, 520, 180, 40);

        jLabel9.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 255));
        jLabel9.setText("Gender");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(660, 470, 80, 22);

        jLabel10.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 255));
        jLabel10.setText("User Name");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(60, 350, 100, 22);

        jLabel11.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 255));
        jLabel11.setText("Full Name");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(60, 410, 90, 22);

        jLabel12.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 255));
        jLabel12.setText("Address");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(60, 470, 80, 22);

        jLabel13.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 255));
        jLabel13.setText("Email");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(660, 350, 80, 22);

        jLabel14.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 102, 255));
        jLabel14.setText("Phone No");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(660, 410, 80, 22);

        RejectBut1.setBackground(new java.awt.Color(153, 153, 255));
        RejectBut1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/RejectBut.png"))); // NOI18N
        RejectBut1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RejectBut1MouseClicked(evt);
            }
        });
        jPanel1.add(RejectBut1);
        RejectBut1.setBounds(730, 520, 180, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/BackGround(11-6).jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 1100, 600);

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
        new AdminConsol().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_HomeButMouseClicked

    private void HomeButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeButActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HomeButActionPerformed

    private void PendingButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PendingButActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PendingButActionPerformed

    private void LogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogOutMouseClicked
        int response = JOptionPane.showConfirmDialog(this, "Are you sure you want to log out?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (response == JOptionPane.YES_OPTION) {
            new Login().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_LogOutMouseClicked

    private void LogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LogOutActionPerformed

    private void CloseIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseIconMouseClicked
        int response = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (response == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_CloseIconMouseClicked

    private void PendingTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PendingTableMouseClicked

        DefaultTableModel model = (DefaultTableModel) PendingTable.getModel();
        int Myindex = PendingTable.getSelectedRow();
        UserName.setText(model.getValueAt(Myindex, 0).toString());
        FullName.setText(model.getValueAt(Myindex, 1).toString());
        Address.setText(model.getValueAt(Myindex, 2).toString());
        Email.setText(model.getValueAt(Myindex, 3).toString());
        PhoneNo.setText(model.getValueAt(Myindex, 4).toString());
        Gender.setText(model.getValueAt(Myindex, 6).toString());

    }//GEN-LAST:event_PendingTableMouseClicked

    private void EmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmailActionPerformed

    private void UserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserNameActionPerformed

    private void AddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddressActionPerformed

    private void GenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GenderActionPerformed

    private void FullNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FullNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FullNameActionPerformed

    private void PhoneNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PhoneNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PhoneNoActionPerformed

    private void AcceptMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AcceptMouseClicked

        if (UserName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Information Missing");
        } else {
            int response = JOptionPane.showConfirmDialog(this, "Do you really want to accept the request ?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (response == JOptionPane.YES_OPTION) {
                DefaultTableModel model = (DefaultTableModel) PendingTable.getModel();
                int Myindex = PendingTable.getSelectedRow();

                UserNameValue = model.getValueAt(Myindex, 0).toString();
                FullNameValue = model.getValueAt(Myindex, 1).toString();
                AddressValue = model.getValueAt(Myindex, 2).toString();
                EmailValue = model.getValueAt(Myindex, 3).toString();
                PhoneNoValue = model.getValueAt(Myindex, 4).toString();
                PasswordValue = model.getValueAt(Myindex, 5).toString();
                GenderValue = model.getValueAt(Myindex, 6).toString();

                try {
                    con = DriverManager.getConnection(url, uname, pass);
                    PreparedStatement add = con.prepareStatement("insert into sellerinfo values(?,?,?,?,?,?,?)");
                    add.setString(1, UserNameValue);
                    add.setString(2, FullNameValue);
                    add.setString(3, AddressValue);
                    add.setString(4, EmailValue);
                    add.setString(5, PhoneNoValue);
                    add.setString(6, PasswordValue);
                    add.setString(7, GenderValue);
                    int row = add.executeUpdate();

                    sendmailAcc(EmailValue);

                    JOptionPane.showMessageDialog(this, "Seller Added and Email Sent");
                    con.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                try {
                    con = DriverManager.getConnection(url, uname, pass);
                    String Del_UserName = UserName.getText();
                    String Query = "Delete from shopmanagement.pending where UserName = '" + Del_UserName + "'";
                    Statement Add = con.createStatement();
                    Add.executeUpdate(Query);
                    con.close();
                    SelectPending();
//                JOptionPane.showMessageDialog(this, "Seller Rejected");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                UserName.setText("");
                FullName.setText("");
                Address.setText("");
                Email.setText("");
                PhoneNo.setText("");
                Gender.setText("");

                SelectPending();

            } else {
                UserName.setText("");
                FullName.setText("");
                Address.setText("");
                Email.setText("");
                PhoneNo.setText("");
                Gender.setText("");
            }
        }


    }//GEN-LAST:event_AcceptMouseClicked

    private void ClearButMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearButMouseClicked
        // TODO add your handling code here:
        UserName.setText("");
        FullName.setText("");
        Address.setText("");
        Email.setText("");
        PhoneNo.setText("");
        Gender.setText("");
    }//GEN-LAST:event_ClearButMouseClicked

    private void RejectBut1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RejectBut1MouseClicked
        if (UserName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Information Missing");
        } else {

            int response = JOptionPane.showConfirmDialog(this, "Do you really want to reject the request ?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (response == JOptionPane.YES_OPTION) {
                try {
                    con = DriverManager.getConnection(url, uname, pass);

                    String Del_UserName = UserName.getText();
                    EmailValue = Email.getText();

                    String Query = "Delete from shopmanagement.pending where UserName = '" + Del_UserName + "'";

                    Statement Add = con.createStatement();
                    Add.executeUpdate(Query);
                    con.close();
                    SelectPending();

                    sendmailRej(EmailValue);

                    JOptionPane.showMessageDialog(this, "Seller Rejected and Email Sent ");
                } catch (Exception e) {
                    e.printStackTrace();
                }

                UserName.setText("");
                FullName.setText("");
                Address.setText("");
                Email.setText("");
                PhoneNo.setText("");
                Gender.setText("");
            } else {
                UserName.setText("");
                FullName.setText("");
                Address.setText("");
                Email.setText("");
                PhoneNo.setText("");
                Gender.setText("");
            }

        }


    }//GEN-LAST:event_RejectBut1MouseClicked

    private void SellerButMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SellerButMouseClicked
        new SellerBG().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_SellerButMouseClicked

    private void ProductButMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductButMouseClicked
        new ProductBG().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ProductButMouseClicked

    private void CategoryButMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CategoryButMouseClicked
        new CategoryBG().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CategoryButMouseClicked

    private void TransactionButMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TransactionButMouseClicked
        new Transaction().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_TransactionButMouseClicked

    private void PendingButMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PendingButMouseClicked
        new Pending().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_PendingButMouseClicked

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
            java.util.logging.Logger.getLogger(Pending.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pending.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pending.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pending.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pending().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Accept;
    private javax.swing.JTextField Address;
    private javax.swing.JButton CategoryBut;
    private javax.swing.JButton ClearBut;
    private javax.swing.JLabel CloseIcon;
    private javax.swing.JTextField Email;
    private javax.swing.JTextField FullName;
    private javax.swing.JTextField Gender;
    private javax.swing.JButton HomeBut;
    private javax.swing.JButton LogOut;
    private javax.swing.JButton PendingBut;
    private javax.swing.JTable PendingTable;
    private javax.swing.JTextField PhoneNo;
    private javax.swing.JButton ProductBut;
    private javax.swing.JButton RejectBut1;
    private javax.swing.JButton SellerBut;
    private javax.swing.JButton TransactionBut;
    private javax.swing.JTextField UserName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
