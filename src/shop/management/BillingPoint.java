/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.management;

import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import static java.lang.Thread.sleep;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author RashedGtz
 */
public class BillingPoint extends javax.swing.JFrame {

    /**
     * Creates new form BillingPoint
     */
    public BillingPoint() {
        initComponents();
        SelectProduct();
        GetCategory();
        clock();
        SellerName.setText(new Login().SellerNameAccepted);
        CurSeller = SellerName.getText();
    }

    int MinusPerPrice = 0, MinusQuantity = 0, MinusTotalPrice = 0, chk = 0;

    int i = 0, TotalPrice = 0, GrandTotal = 0;
    String ProductId = "";
    int uprice, AvaiableQuantity;

    String CurSeller = "";

    String CustomerName = "";
    String CustomerAddress = "";
    String CustomerPhone = "";
    String GeneratedBillId = "";

    String url = "jdbc:mysql://localhost:3306/ShopManagement";
    String uname = "root";
    String pass = "239515amimysql";

    Connection con = null;
    Statement st = null;
    ResultSet rs = null;

    public void SelectProduct() {
        try {
            con = DriverManager.getConnection(url, uname, pass);
            st = con.createStatement();
            rs = st.executeQuery("Select * from shopmanagement.producttable");
            ProductTable.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void SelectCashMemo() {
        try {
            con = DriverManager.getConnection(url, uname, pass);
            st = con.createStatement();
            rs = st.executeQuery("Select * from shopmanagement.cashmemotable");
            CashMemoTable.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // Getting all the Category Name from Category Table set to Category Combo Box 
    public void GetCategory() {
        try {
            con = DriverManager.getConnection(url, uname, pass);
            st = con.createStatement();
            String Query = "Select * from shopmanagement.categorytable";

            rs = st.executeQuery(Query);

            while (rs.next()) {
                String MyCategory = rs.getString("CatName");
                Category.addItem(MyCategory);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DecreaseUpdate() {
        try {
            con = DriverManager.getConnection(url, uname, pass);

            String E_ProductName = ProductName.getText();
            int UpdatedQuantity = AvaiableQuantity - Integer.valueOf(Quantity.getText());

            String E_Quantity = String.valueOf(UpdatedQuantity);

            String Query = "Update shopmanagement.producttable set Quantity =" + E_Quantity + " where ProductId=" + ProductId;
            Statement Add = con.createStatement();
            Add.executeUpdate(Query);
            con.close();
            SelectProduct();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void IncreaseUpdateDeleteBut() {
        try {

            String ProName = AddedProductName.getText();

            con = DriverManager.getConnection(url, uname, pass);

            String Query = "select *from shopmanagement.producttable where ProductName = '" + ProName + "'";
            Statement Add = con.createStatement();
            ResultSet Rs = Add.executeQuery(Query);
            Rs.next();
            String MainTableQuantity = Rs.getString("Quantity");

            Add.close();
            con.close();

            int MTQuantity = Integer.valueOf(MainTableQuantity);

            MTQuantity += MinusQuantity;

            if (MTQuantity < 0) {
                chk = 0;
                JOptionPane.showMessageDialog(this, "Not Enough Stock Avaiable");
            } else {
                chk = 1;
                String E_Quantity = String.valueOf(MTQuantity);

                con = DriverManager.getConnection(url, uname, pass);
                String Query1 = "Update shopmanagement.producttable set Quantity =" + E_Quantity + " where ProductName = '" + ProName + "'";
                Statement Add1 = con.createStatement();
                Add1.executeUpdate(Query1);
                Add1.close();
                con.close();
                JOptionPane.showMessageDialog(this, "Cart Edited Successfully");
                SelectProduct();

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    int Day;
    int Month;
    int Year;
    int Second;
    int Minute;
    int Hour;

    public void clock() {

        Thread clock = new Thread() {
            public void run() {
                try {
                    while (true) {
                        Calendar cal = new GregorianCalendar();
                        Day = cal.get(Calendar.DAY_OF_MONTH);
                        Month = cal.get(Calendar.MONTH) + 1;
                        Year = cal.get(Calendar.YEAR);

                        Second = cal.get(Calendar.SECOND);
                        Minute = cal.get(Calendar.MINUTE);
                        Hour = cal.get(Calendar.HOUR);

                        Time.setText(" " + Hour + ":" + Minute + ":" + Second);
                        Date.setText(" " + Day + "/" + Month + "/" + Year);

                        sleep(1000);
                    }

                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        };

        clock.start();

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
        HomeBut = new javax.swing.JButton();
        SellerName = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        NewBillBut = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        Date = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Time = new javax.swing.JLabel();
        LogOut = new javax.swing.JButton();
        CloseBut = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        CustomerNameField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        AddressField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        PhoneNoField = new javax.swing.JTextField();
        ConfirmBut = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Category = new javax.swing.JComboBox<>();
        LoadBut = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        ProductTable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        BillId = new javax.swing.JLabel();
        ProductName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        AddBut = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        Quantity = new javax.swing.JTextField();
        ClearBut = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        CashMemoTable = new javax.swing.JTable();
        AddedProductName = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        EditBut = new javax.swing.JButton();
        AddedQuantity = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        DeleteBut = new javax.swing.JButton();
        GrandTaka = new javax.swing.JLabel();
        Print = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1440, 1024));
        setMinimumSize(new java.awt.Dimension(1440, 1024));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1440, 1024));

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));
        jPanel1.setLayout(null);

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
        HomeBut.setBounds(10, 40, 50, 40);

        SellerName.setBackground(new java.awt.Color(102, 102, 255));
        SellerName.setFont(new java.awt.Font("Candara", 1, 16)); // NOI18N
        SellerName.setForeground(new java.awt.Color(102, 102, 255));
        SellerName.setText("Seller_name");
        jPanel1.add(SellerName);
        SellerName.setBounds(90, 100, 84, 19);

        jLabel7.setBackground(new java.awt.Color(102, 102, 255));
        jLabel7.setFont(new java.awt.Font("Candara", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 255));
        jLabel7.setText("SELLER :");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(20, 100, 57, 20);

        NewBillBut.setBackground(new java.awt.Color(153, 153, 255));
        NewBillBut.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        NewBillBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/NewBillBut2.png"))); // NOI18N
        NewBillBut.setBorder(null);
        NewBillBut.setBorderPainted(false);
        NewBillBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NewBillButMouseClicked(evt);
            }
        });
        jPanel1.add(NewBillBut);
        NewBillBut.setBounds(30, 139, 150, 40);

        jLabel8.setBackground(new java.awt.Color(102, 102, 255));
        jLabel8.setFont(new java.awt.Font("Candara", 1, 28)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 255));
        jLabel8.setText("BILLING POINT");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(680, 90, 190, 35);

        Date.setBackground(new java.awt.Color(102, 102, 255));
        Date.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Date.setForeground(new java.awt.Color(102, 102, 255));
        Date.setText("DATE");
        jPanel1.add(Date);
        Date.setBounds(1080, 110, 120, 17);

        jLabel14.setBackground(new java.awt.Color(102, 102, 255));
        jLabel14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 102, 255));
        jLabel14.setText("DATE :");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(1023, 110, 50, 17);

        jLabel3.setBackground(new java.awt.Color(102, 102, 255));
        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 255));
        jLabel3.setText("TIME :");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(1021, 140, 50, 17);

        Time.setBackground(new java.awt.Color(102, 102, 255));
        Time.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Time.setForeground(new java.awt.Color(102, 102, 255));
        Time.setText("TIME");
        jPanel1.add(Time);
        Time.setBounds(1080, 140, 110, 17);

        LogOut.setBackground(new java.awt.Color(153, 153, 255));
        LogOut.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        LogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/LogoutBut2.png"))); // NOI18N
        LogOut.setBorder(null);
        LogOut.setBorderPainted(false);
        LogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogOutMouseClicked(evt);
            }
        });
        jPanel1.add(LogOut);
        LogOut.setBounds(1270, 100, 150, 40);

        CloseBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Close_BUT.png"))); // NOI18N
        CloseBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CloseButMouseClicked(evt);
            }
        });
        jPanel1.add(CloseBut);
        CloseBut.setBounds(1410, 0, 25, 30);

        jLabel10.setBackground(new java.awt.Color(102, 102, 255));
        jLabel10.setFont(new java.awt.Font("Candara", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 255));
        jLabel10.setText("Name");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(50, 250, 40, 20);

        CustomerNameField.setBackground(new java.awt.Color(204, 255, 255));
        CustomerNameField.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        CustomerNameField.setForeground(new java.awt.Color(51, 153, 255));
        CustomerNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomerNameFieldActionPerformed(evt);
            }
        });
        jPanel1.add(CustomerNameField);
        CustomerNameField.setBounds(110, 243, 230, 40);

        jLabel2.setBackground(new java.awt.Color(102, 102, 255));
        jLabel2.setFont(new java.awt.Font("Candara", 1, 28)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 255));
        jLabel2.setText("CUSTOMER INFORMATION");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(600, 180, 330, 35);

        jLabel11.setBackground(new java.awt.Color(102, 102, 255));
        jLabel11.setFont(new java.awt.Font("Candara", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 255));
        jLabel11.setText("Address");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(420, 250, 56, 20);

        AddressField.setBackground(new java.awt.Color(204, 255, 255));
        AddressField.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        AddressField.setForeground(new java.awt.Color(51, 153, 255));
        AddressField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddressFieldActionPerformed(evt);
            }
        });
        jPanel1.add(AddressField);
        AddressField.setBounds(500, 240, 230, 40);

        jLabel12.setBackground(new java.awt.Color(102, 102, 255));
        jLabel12.setFont(new java.awt.Font("Candara", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 255));
        jLabel12.setText("Phone No.");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(810, 250, 71, 20);

        PhoneNoField.setBackground(new java.awt.Color(204, 255, 255));
        PhoneNoField.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        PhoneNoField.setForeground(new java.awt.Color(51, 153, 255));
        PhoneNoField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PhoneNoFieldActionPerformed(evt);
            }
        });
        jPanel1.add(PhoneNoField);
        PhoneNoField.setBounds(900, 240, 230, 40);

        ConfirmBut.setBackground(new java.awt.Color(153, 153, 255));
        ConfirmBut.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        ConfirmBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/ConfirmBut.png"))); // NOI18N
        ConfirmBut.setBorder(null);
        ConfirmBut.setBorderPainted(false);
        ConfirmBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ConfirmButMouseClicked(evt);
            }
        });
        jPanel1.add(ConfirmBut);
        ConfirmBut.setBounds(1210, 240, 175, 40);

        jLabel4.setBackground(new java.awt.Color(102, 102, 255));
        jLabel4.setFont(new java.awt.Font("Candara", 1, 28)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 255));
        jLabel4.setText("PRODUCTS LIST");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(230, 340, 200, 35);

        jLabel9.setBackground(new java.awt.Color(102, 102, 255));
        jLabel9.setFont(new java.awt.Font("Candara", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 255));
        jLabel9.setText("Selected Category");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(30, 410, 124, 20);

        Category.setBackground(new java.awt.Color(51, 153, 255));
        Category.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Category.setForeground(new java.awt.Color(255, 255, 255));
        Category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CategoryActionPerformed(evt);
            }
        });
        jPanel1.add(Category);
        Category.setBounds(170, 400, 270, 40);

        LoadBut.setBackground(new java.awt.Color(153, 153, 255));
        LoadBut.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        LoadBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/LoadBut.png"))); // NOI18N
        LoadBut.setBorder(null);
        LoadBut.setBorderPainted(false);
        LoadBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LoadButMouseClicked(evt);
            }
        });
        jPanel1.add(LoadBut);
        LoadBut.setBounds(490, 400, 150, 40);

        ProductTable.setBackground(new java.awt.Color(255, 255, 255));
        ProductTable.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ProductTable.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        ProductTable.setForeground(new java.awt.Color(153, 153, 153));
        ProductTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Product ID", "Name", "Price Per Unit", "Quantity", "Category"
            }
        ));
        ProductTable.setGridColor(new java.awt.Color(204, 204, 204));
        ProductTable.setIntercellSpacing(new java.awt.Dimension(0, 0));
        ProductTable.setRowHeight(25);
        ProductTable.setSelectionBackground(new java.awt.Color(102, 204, 255));
        ProductTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        ProductTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        ProductTable.setShowGrid(true);
        ProductTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProductTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(ProductTable);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(20, 450, 690, 350);

        jLabel5.setBackground(new java.awt.Color(102, 102, 255));
        jLabel5.setFont(new java.awt.Font("Candara", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 255));
        jLabel5.setText("BILL ID");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(50, 860, 47, 20);

        BillId.setBackground(new java.awt.Color(102, 102, 255));
        BillId.setFont(new java.awt.Font("Candara", 1, 16)); // NOI18N
        BillId.setForeground(new java.awt.Color(102, 102, 255));
        jPanel1.add(BillId);
        BillId.setBounds(120, 850, 240, 40);

        ProductName.setEditable(false);
        ProductName.setBackground(new java.awt.Color(204, 255, 255));
        ProductName.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        ProductName.setForeground(new java.awt.Color(51, 153, 255));
        ProductName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductNameActionPerformed(evt);
            }
        });
        jPanel1.add(ProductName);
        ProductName.setBounds(120, 900, 230, 40);

        jLabel6.setBackground(new java.awt.Color(102, 102, 255));
        jLabel6.setFont(new java.awt.Font("Candara", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 255));
        jLabel6.setText("Name");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(50, 910, 40, 20);

        AddBut.setBackground(new java.awt.Color(153, 153, 255));
        AddBut.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        AddBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/ADD_But.png"))); // NOI18N
        AddBut.setBorder(null);
        AddBut.setBorderPainted(false);
        AddBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddButMouseClicked(evt);
            }
        });
        jPanel1.add(AddBut);
        AddBut.setBounds(160, 960, 150, 40);

        jLabel13.setBackground(new java.awt.Color(102, 102, 255));
        jLabel13.setFont(new java.awt.Font("Candara", 1, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 255));
        jLabel13.setText("Quantity");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(400, 910, 61, 20);

        Quantity.setBackground(new java.awt.Color(204, 255, 255));
        Quantity.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Quantity.setForeground(new java.awt.Color(51, 153, 255));
        Quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuantityActionPerformed(evt);
            }
        });
        jPanel1.add(Quantity);
        Quantity.setBounds(470, 900, 230, 40);

        ClearBut.setBackground(new java.awt.Color(153, 153, 255));
        ClearBut.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        ClearBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Clear_1.png"))); // NOI18N
        ClearBut.setBorder(null);
        ClearBut.setBorderPainted(false);
        ClearBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClearButMouseClicked(evt);
            }
        });
        jPanel1.add(ClearBut);
        ClearBut.setBounds(510, 959, 150, 40);

        jLabel15.setBackground(new java.awt.Color(102, 102, 255));
        jLabel15.setFont(new java.awt.Font("Candara", 1, 28)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 255));
        jLabel15.setText("ADDED PRODUCTS");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(990, 340, 250, 35);

        CashMemoTable.setBackground(new java.awt.Color(255, 255, 255));
        CashMemoTable.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CashMemoTable.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        CashMemoTable.setForeground(new java.awt.Color(153, 153, 153));
        CashMemoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Price Per Unit", "Quantity", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        CashMemoTable.setGridColor(new java.awt.Color(204, 204, 204));
        CashMemoTable.setIntercellSpacing(new java.awt.Dimension(0, 0));
        CashMemoTable.setRowHeight(25);
        CashMemoTable.setSelectionBackground(new java.awt.Color(102, 204, 255));
        CashMemoTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        CashMemoTable.setShowGrid(true);
        CashMemoTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CashMemoTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(CashMemoTable);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(790, 450, 630, 350);

        AddedProductName.setEditable(false);
        AddedProductName.setBackground(new java.awt.Color(204, 255, 255));
        AddedProductName.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        AddedProductName.setForeground(new java.awt.Color(51, 153, 255));
        AddedProductName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddedProductNameActionPerformed(evt);
            }
        });
        jPanel1.add(AddedProductName);
        AddedProductName.setBounds(860, 810, 230, 40);

        jLabel16.setBackground(new java.awt.Color(102, 102, 255));
        jLabel16.setFont(new java.awt.Font("Candara", 1, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 102, 255));
        jLabel16.setText("Name");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(800, 820, 40, 20);

        EditBut.setBackground(new java.awt.Color(153, 153, 255));
        EditBut.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        EditBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Edit_But.png"))); // NOI18N
        EditBut.setBorder(null);
        EditBut.setBorderPainted(false);
        EditBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EditButMouseClicked(evt);
            }
        });
        jPanel1.add(EditBut);
        EditBut.setBounds(900, 860, 150, 40);

        AddedQuantity.setBackground(new java.awt.Color(204, 255, 255));
        AddedQuantity.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        AddedQuantity.setForeground(new java.awt.Color(51, 153, 255));
        AddedQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddedQuantityActionPerformed(evt);
            }
        });
        jPanel1.add(AddedQuantity);
        AddedQuantity.setBounds(1180, 810, 230, 40);

        jLabel17.setBackground(new java.awt.Color(102, 102, 255));
        jLabel17.setFont(new java.awt.Font("Candara", 1, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 102, 255));
        jLabel17.setText("Quantity");
        jPanel1.add(jLabel17);
        jLabel17.setBounds(1110, 820, 61, 20);

        DeleteBut.setBackground(new java.awt.Color(153, 153, 255));
        DeleteBut.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        DeleteBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Dlelete_But.png"))); // NOI18N
        DeleteBut.setBorder(null);
        DeleteBut.setBorderPainted(false);
        DeleteBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeleteButMouseClicked(evt);
            }
        });
        jPanel1.add(DeleteBut);
        DeleteBut.setBounds(1230, 860, 150, 40);

        GrandTaka.setBackground(new java.awt.Color(102, 102, 255));
        GrandTaka.setFont(new java.awt.Font("Candara", 1, 16)); // NOI18N
        GrandTaka.setForeground(new java.awt.Color(102, 102, 255));
        GrandTaka.setText("TK.");
        jPanel1.add(GrandTaka);
        GrandTaka.setBounds(1070, 910, 180, 30);

        Print.setBackground(new java.awt.Color(153, 153, 255));
        Print.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/PrintBut.png"))); // NOI18N
        Print.setBorder(null);
        Print.setBorderPainted(false);
        Print.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PrintMouseClicked(evt);
            }
        });
        jPanel1.add(Print);
        Print.setBounds(1100, 950, 150, 40);

        jLabel1.setBackground(new java.awt.Color(102, 102, 255));
        jLabel1.setFont(new java.awt.Font("Candara", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bg(14-10)-Final.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 1480, 1024);

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

    private void NewBillButMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NewBillButMouseClicked
        BillId.setText("");
        ProductName.setText("");
        Quantity.setText("");
        CustomerNameField.setText("");
        AddressField.setText("");
        PhoneNoField.setText("");

        try {
            con = DriverManager.getConnection(url, uname, pass);
            String Query = "delete from shopmanagement.cashmemotable where ProductName != '1'";
            Statement Add = con.createStatement();
            Add.executeUpdate(Query);

            GrandTotal = 0;
            GrandTaka.setText("TK." + GrandTotal);

            con.close();
            SelectCashMemo();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_NewBillButMouseClicked

    private void LogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogOutMouseClicked
        int response = JOptionPane.showConfirmDialog(this, "Are you sure you want to log out?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (response == JOptionPane.YES_OPTION) {
            new Login().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_LogOutMouseClicked

    private void CloseButMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseButMouseClicked
        int response = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (response == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_CloseButMouseClicked

    private void CustomerNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustomerNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CustomerNameFieldActionPerformed

    private void AddressFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddressFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddressFieldActionPerformed

    private void PhoneNoFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PhoneNoFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PhoneNoFieldActionPerformed

    private void ConfirmButMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConfirmButMouseClicked
        CustomerName = CustomerNameField.getText();
        CustomerAddress = AddressField.getText();
        CustomerPhone = PhoneNoField.getText();
        GeneratedBillId = CustomerPhone + "-" + Day + "-" + Month + "-" + Year + "-" + Hour + "-" + Minute + "-" + Second;
        BillId.setText(GeneratedBillId);
    }//GEN-LAST:event_ConfirmButMouseClicked

    private void CategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CategoryActionPerformed

    private void LoadButMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoadButMouseClicked
        try {
            String SelectedCat = Category.getSelectedItem().toString();
            con = DriverManager.getConnection(url, uname, pass);
            st = con.createStatement();
            rs = st.executeQuery("Select * from shopmanagement.producttable where Category ='" + SelectedCat + "'");
            ProductTable.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_LoadButMouseClicked

    private void ProductTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductTableMouseClicked

        DefaultTableModel model = (DefaultTableModel) ProductTable.getModel();
        int Myindex = ProductTable.getSelectedRow();
        ProductId = model.getValueAt(Myindex, 0).toString();
        ProductName.setText(model.getValueAt(Myindex, 1).toString());
        uprice = Integer.valueOf(model.getValueAt(Myindex, 2).toString());
        AvaiableQuantity = Integer.valueOf(model.getValueAt(Myindex, 3).toString());

        //        Category.setSelectedItem(model.getValueAt(Myindex,4).toString());
    }//GEN-LAST:event_ProductTableMouseClicked

    private void ProductNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProductNameActionPerformed

    private void AddButMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddButMouseClicked

        int chk = 0;
        int UniqueChk = 0;
        int value = 10;
        int value2 = 10;
        String Product_Id = "";
        String Product_Name = "";

        if( BillId.getText().isEmpty() )
        {
            JOptionPane.showMessageDialog(this, "Confirm The Customer Information first");
        }
        else if (ProductName.getText().isEmpty() || Quantity.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Information missing");
        } else {
            chk = 1;
            Product_Name = ProductName.getText();
        }

        if (chk == 1) {

            try {
                con = DriverManager.getConnection(url, uname, pass);

                String Query = "select count(*) from cashmemotable where ProductName = '" + Product_Name+"'";
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

            if (value > 0) {
                JOptionPane.showMessageDialog(this, "This Product is already added in the cart");
            } else {
                UniqueChk = 1;
            }

        }

        if (UniqueChk == 1) {

            if (ProductName.getText().isEmpty() || Quantity.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Information missing");
            } else if (AvaiableQuantity < Integer.valueOf(Quantity.getText())) {
                JOptionPane.showMessageDialog(this, "Not Enough Stock Avaiable");
            } else {
                i++;

                String ProName = ProductName.getText();
                int QuantityAdded = Integer.valueOf(Quantity.getText());
                TotalPrice = uprice * Integer.valueOf(Quantity.getText());

                //adding to cashmemo table
                try {

                    con = DriverManager.getConnection(url, uname, pass);
                    PreparedStatement add = con.prepareStatement("insert into cashmemotable values(?,?,?,?)");
                    add.setString(1, ProName);
                    add.setInt(2, uprice);
                    add.setInt(3, QuantityAdded);
                    add.setInt(4, TotalPrice);
                    int row = add.executeUpdate();
                    con.close();
                    SelectCashMemo();

                } catch (Exception e) {
                    e.printStackTrace();
                }

                GrandTotal = GrandTotal + TotalPrice;
                GrandTaka.setText("TK." + GrandTotal);
                DecreaseUpdate();
                JOptionPane.showMessageDialog(this, "Product Added to Cart");
                //            BillId.setText("");
                ProductName.setText("");
                Quantity.setText("");
            }
        }


    }//GEN-LAST:event_AddButMouseClicked

    private void QuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_QuantityActionPerformed

    private void ClearButMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearButMouseClicked
        ProductName.setText("");
        Quantity.setText("");
        AddedProductName.setText("");
        AddedQuantity.setText("");
    }//GEN-LAST:event_ClearButMouseClicked

    private void CashMemoTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CashMemoTableMouseClicked
        DefaultTableModel model = (DefaultTableModel) CashMemoTable.getModel();
        int Myindex = CashMemoTable.getSelectedRow();
        AddedProductName.setText(model.getValueAt(Myindex, 0).toString());
        MinusPerPrice = Integer.valueOf(model.getValueAt(Myindex, 1).toString());
        MinusQuantity = Integer.valueOf(model.getValueAt(Myindex, 2).toString());
        AddedQuantity.setText(model.getValueAt(Myindex, 2).toString());
        MinusTotalPrice = Integer.valueOf(model.getValueAt(Myindex, 3).toString());
    }//GEN-LAST:event_CashMemoTableMouseClicked

    private void AddedProductNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddedProductNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddedProductNameActionPerformed

    private void EditButMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditButMouseClicked

        if (AddedProductName.getText().isEmpty() || AddedQuantity.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Information missing");
        } else {
            try {
                String ProName = AddedProductName.getText();

                int QuantityAdded = Integer.valueOf(AddedQuantity.getText());
                String E_Quantity = AddedQuantity.getText();

                MinusQuantity = MinusQuantity - QuantityAdded;

                IncreaseUpdateDeleteBut();

                if (chk == 1) {
                    MinusTotalPrice = MinusTotalPrice - MinusQuantity * MinusPerPrice;
                    String E_Total = String.valueOf(MinusTotalPrice);
                    con = DriverManager.getConnection(url, uname, pass);
                    String Query = "Update shopmanagement.cashmemotable set Quantity = " + E_Quantity + " , Total = " + E_Total + " where ProductName = '" + ProName + "'";
                    Statement Add = con.createStatement();
                    Add.executeUpdate(Query);
                    con.close();
                    GrandTotal = GrandTotal - MinusQuantity * MinusPerPrice;
                    GrandTaka.setText("TK." + GrandTotal);
                }

                SelectCashMemo();

                AddedProductName.setText("");
                AddedQuantity.setText("");
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_EditButMouseClicked

    private void AddedQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddedQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddedQuantityActionPerformed

    private void DeleteButMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteButMouseClicked
        if (AddedProductName.getText().isEmpty() || AddedQuantity.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Information missing");
        } else {
            try {
                con = DriverManager.getConnection(url, uname, pass);
                String ProName = AddedProductName.getText();

                int QuantityAdded = Integer.valueOf(AddedQuantity.getText());

                String Query = "delete from shopmanagement.cashmemotable where ProductName = '" + ProName + "'";
                Statement Add = con.createStatement();
                Add.executeUpdate(Query);

                GrandTotal = GrandTotal - MinusTotalPrice;
                GrandTaka.setText("TK." + GrandTotal);
                con.close();

                IncreaseUpdateDeleteBut();
                SelectCashMemo();

                AddedProductName.setText("");
                AddedQuantity.setText("");
                JOptionPane.showMessageDialog(this, "Product deleted from Cart Successfully");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }//GEN-LAST:event_DeleteButMouseClicked

    private void PrintMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrintMouseClicked

        String Description = "";
        //PDF CREATION START

        String path = "C:\\Users\\RashedGtz\\Documents\\NetBeansProjects\\Shop Management\\Billsself\\";
        com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(path + "" + GeneratedBillId + ".pdf"));
            doc.open();
            Paragraph paragraph1 = new Paragraph(" RS TECHNOLOGY\n 12/1 Motijheel,Dhaka-1000 \n Contact Number: 01621299293 , Email:RSTechnology@gmail.com \n www.rstechnology.com \n\n");
            paragraph1.setAlignment(Element.ALIGN_CENTER);
            doc.add(paragraph1);
            Paragraph paragraph2 = new Paragraph("Date : " + Date.getText() + "\nTime : " + Time.getText());
            paragraph2.setAlignment(Element.ALIGN_RIGHT);
            doc.add(paragraph2);

            Paragraph paragraph3 = new Paragraph("Bill Id :" + GeneratedBillId + " \n\nBuyer Details \nName: " + CustomerName + "\nAddress: " + CustomerAddress + " \nPhone No.: " + CustomerPhone + " \n\nSold by : " + CurSeller + "\n\n");
            paragraph3.setAlignment(Element.ALIGN_LEFT);
            doc.add(paragraph3);

            PdfPTable tbl = new PdfPTable(5);

            PdfPCell cell0 = new PdfPCell(new Paragraph("No."));
            cell0.setPadding(5);
            cell0.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell0.setVerticalAlignment(Element.ALIGN_MIDDLE);

            PdfPCell cell1 = new PdfPCell(new Paragraph("Name"));
            cell1.setPadding(5);
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);

            PdfPCell cell2 = new PdfPCell(new Paragraph("Per Unit Price"));
            cell2.setPadding(5);
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);

            PdfPCell cell3 = new PdfPCell(new Paragraph("Quantity"));
            cell3.setPadding(5);
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);

            PdfPCell cell4 = new PdfPCell(new Paragraph("Amount"));
            cell4.setPadding(5);
            cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);

            tbl.addCell(cell0);
            tbl.addCell(cell1);
            tbl.addCell(cell2);
            tbl.addCell(cell3);
            tbl.addCell(cell4);

            for (int index = 0; index < CashMemoTable.getRowCount(); index++) {
                String n = CashMemoTable.getValueAt(index, 0).toString();
                String ppu = CashMemoTable.getValueAt(index, 1).toString();
                String q = CashMemoTable.getValueAt(index, 2).toString();
                String t = CashMemoTable.getValueAt(index, 3).toString();

                PdfPCell cell00 = new PdfPCell(new Paragraph(String.valueOf(index + 1)));
                cell00.setPadding(5);
                cell00.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell00.setVerticalAlignment(Element.ALIGN_MIDDLE);

                PdfPCell cell11 = new PdfPCell(new Paragraph(n));
                cell11.setPadding(5);
                cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell11.setVerticalAlignment(Element.ALIGN_MIDDLE);

                PdfPCell cell22 = new PdfPCell(new Paragraph(ppu));
                cell22.setPadding(5);
                cell22.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell22.setVerticalAlignment(Element.ALIGN_MIDDLE);

                PdfPCell cell33 = new PdfPCell(new Paragraph(q));
                cell33.setPadding(5);
                cell33.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell33.setVerticalAlignment(Element.ALIGN_MIDDLE);

                PdfPCell cell44 = new PdfPCell(new Paragraph(t));
                cell44.setPadding(5);
                cell44.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell44.setVerticalAlignment(Element.ALIGN_MIDDLE);

                tbl.addCell(cell00);
                tbl.addCell(cell11);
                tbl.addCell(cell22);
                tbl.addCell(cell33);
                tbl.addCell(cell44);

                Description = Description + n + " X" + q + "pcs -- ";
            }

            PdfPCell cellL0 = new PdfPCell(new Paragraph(""));
            cellL0.setPadding(5);
            cellL0.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellL0.setVerticalAlignment(Element.ALIGN_MIDDLE);

            PdfPCell cellL1 = new PdfPCell(new Paragraph(""));
            cellL1.setPadding(5);
            cellL1.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellL1.setVerticalAlignment(Element.ALIGN_MIDDLE);

            PdfPCell cellL2 = new PdfPCell(new Paragraph(""));
            cellL2.setPadding(5);
            cellL2.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellL2.setVerticalAlignment(Element.ALIGN_MIDDLE);

            PdfPCell cellL3 = new PdfPCell(new Paragraph("Total :"));
            cellL3.setPadding(5);
            cellL3.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellL3.setVerticalAlignment(Element.ALIGN_MIDDLE);

            PdfPCell cellL4 = new PdfPCell(new Paragraph(String.valueOf(GrandTotal)));
            cellL4.setPadding(5);
            cellL4.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellL4.setVerticalAlignment(Element.ALIGN_MIDDLE);

            tbl.addCell(cellL0);
            tbl.addCell(cellL1);
            tbl.addCell(cellL2);
            tbl.addCell(cellL3);
            tbl.addCell(cellL4);

            doc.add(tbl);

//            Paragraph paragraph4 = new Paragraph("\nGrand Total = " + GrandTotal + "\n");
//            Description = Description + "GrandTotal :" + GrandTotal;
//            doc.add(paragraph4);
            JOptionPane.showMessageDialog(this, "Bill Generated");
            doc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        //PDF CREATION END
        try {
            con = DriverManager.getConnection(url, uname, pass);
            PreparedStatement add = con.prepareStatement("insert into transactiontable values(?,?,?,?)");

            add.setString(1, GeneratedBillId);
            add.setString(2, CustomerName);
            add.setString(3, CurSeller);
            add.setString(4, Description);

            int row = add.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        BillId.setText("");
        ProductName.setText("");
        Quantity.setText("");
        CustomerNameField.setText("");
        AddressField.setText("");
        PhoneNoField.setText("");

        try {
            con = DriverManager.getConnection(url, uname, pass);
            String Query = "delete from shopmanagement.cashmemotable where ProductName != '1'";
            Statement Add = con.createStatement();
            Add.executeUpdate(Query);

            GrandTotal = 0;
            GrandTaka.setText("TK." + GrandTotal);

            con.close();
            SelectCashMemo();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_PrintMouseClicked

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
            java.util.logging.Logger.getLogger(BillingPoint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BillingPoint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BillingPoint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BillingPoint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BillingPoint().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBut;
    private javax.swing.JTextField AddedProductName;
    private javax.swing.JTextField AddedQuantity;
    private javax.swing.JTextField AddressField;
    private javax.swing.JLabel BillId;
    private javax.swing.JTable CashMemoTable;
    private javax.swing.JComboBox<String> Category;
    private javax.swing.JButton ClearBut;
    private javax.swing.JLabel CloseBut;
    private javax.swing.JButton ConfirmBut;
    private javax.swing.JTextField CustomerNameField;
    private javax.swing.JLabel Date;
    private javax.swing.JButton DeleteBut;
    private javax.swing.JButton EditBut;
    private javax.swing.JLabel GrandTaka;
    private javax.swing.JButton HomeBut;
    private javax.swing.JButton LoadBut;
    private javax.swing.JButton LogOut;
    private javax.swing.JButton NewBillBut;
    private javax.swing.JTextField PhoneNoField;
    private javax.swing.JButton Print;
    private javax.swing.JTextField ProductName;
    private javax.swing.JTable ProductTable;
    private javax.swing.JTextField Quantity;
    private javax.swing.JLabel SellerName;
    private javax.swing.JLabel Time;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
