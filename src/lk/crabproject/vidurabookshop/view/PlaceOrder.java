package lk.crabproject.vidurabookshop.view;

import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import lk.crabproject.vidurabookshop.controller.BookController;
import lk.crabproject.vidurabookshop.controller.CustomerController;
import lk.crabproject.vidurabookshop.controller.OrderController;
import lk.crabproject.vidurabookshop.dto.BookDTO;
import lk.crabproject.vidurabookshop.dto.OrderDTO;

import lk.crabproject.vidurabookshop.entity.Book;
import lk.crabproject.vidurabookshop.entity.BookDetail;
import lk.crabproject.vidurabookshop.entity.Order;

public class PlaceOrder extends javax.swing.JFrame {

    public PlaceOrder() {
        initComponents();
        txtOrderDate.setText(LocalDate.now().toString());
        
        generateOrderID();
        generateCustomerID();
        generateBookID();
        cmbCustomerID.requestFocus();
        
    }
    private void generateOrderID() {
        try {
            lblOrderID.setText(OrderController.generateOrderID());
        } catch (Exception ex) {
            Logger.getLogger(PlaceOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void generateCustomerID() {
        try {
            cmbCustomerID.removeAllItems();
            List<String> customerIDs = CustomerController.getCustomerIDs();
            for (String customerID : customerIDs) {
                cmbCustomerID.addItem(customerID);
            }
        } catch (Exception ex) {
            Logger.getLogger(PlaceOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void generateBookID() {
        cmbCode.removeAllItems();
        try {
            List<String> bookIDs = BookController.getBookIDs();
            for (String bookID : bookIDs) {
                cmbCode.addItem(bookID);
            }
        } catch (Exception ex) {
            Logger.getLogger(PlaceOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private int isAlreadyExist(String bid){
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        
        for (int i = 0; i < dtm.getRowCount(); i++) {
            if(dtm.getValueAt(i, 0).toString().equals(cmbCode.getSelectedItem().toString())){
                return i;
            }
        }
        return -1;
    }
 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtQty = new javax.swing.JTextField();
        btnPlaceOrder = new javax.swing.JButton();
        lblName = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmbCustomerID = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblOrderID = new javax.swing.JLabel();
        cmbCode = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        lblPrice = new javax.swing.JLabel();
        lblQtyOnHand = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtOrderDate = new javax.swing.JTextField();
        btnNew = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        lblTotal = new javax.swing.JLabel();
        btnRemove = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lblCustomerName = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtQty.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        txtQty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQtyActionPerformed(evt);
            }
        });
        jPanel1.add(txtQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 430, 140, 40));

        btnPlaceOrder.setBackground(new java.awt.Color(255, 255, 255));
        btnPlaceOrder.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        btnPlaceOrder.setText("PlaceOrder");
        btnPlaceOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlaceOrderActionPerformed(evt);
            }
        });
        jPanel1.add(btnPlaceOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 600, 230, -1));

        lblName.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        lblName.setText("D001");
        lblName.setToolTipText("");
        lblName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 430, 410, 40));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/crabproject/vidurabookshop/images/home.png"))); // NOI18N
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 48)); // NOI18N
        jLabel3.setText("Place Order");
        jLabel3.setToolTipText("");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, 520, 60));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel4.setText("Name");
        jLabel4.setToolTipText("");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 390, 80, 40));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel5.setText("OrderID");
        jLabel5.setToolTipText("");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, 100, 40));

        cmbCustomerID.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        cmbCustomerID.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbCustomerIDItemStateChanged(evt);
            }
        });
        cmbCustomerID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCustomerIDActionPerformed(evt);
            }
        });
        cmbCustomerID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbCustomerIDKeyPressed(evt);
            }
        });
        jPanel1.add(cmbCustomerID, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 330, 130, 40));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel6.setText("CustomerID");
        jLabel6.setToolTipText("");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 150, 40));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel7.setText("Code");
        jLabel7.setToolTipText("");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, 80, 40));

        lblOrderID.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        lblOrderID.setText("D001");
        lblOrderID.setToolTipText("");
        lblOrderID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lblOrderID, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, 130, 40));

        cmbCode.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        cmbCode.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbCodeItemStateChanged(evt);
            }
        });
        cmbCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCodeActionPerformed(evt);
            }
        });
        cmbCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbCodeKeyPressed(evt);
            }
        });
        jPanel1.add(cmbCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, 130, 40));

        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel10.setText("Price");
        jLabel10.setToolTipText("");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 390, 140, 40));

        lblPrice.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        lblPrice.setText("D001");
        lblPrice.setToolTipText("");
        lblPrice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lblPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 430, 140, 40));

        lblQtyOnHand.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        lblQtyOnHand.setText("D001");
        lblQtyOnHand.setToolTipText("");
        lblQtyOnHand.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lblQtyOnHand, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 430, 150, 40));

        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel13.setText("Qty");
        jLabel13.setToolTipText("");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 390, 100, 40));

        jLabel14.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel14.setText("QtyOnHand");
        jLabel14.setToolTipText("");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 390, 150, 40));

        txtOrderDate.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jPanel1.add(txtOrderDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 270, 270, 40));

        btnNew.setBackground(new java.awt.Color(255, 255, 255));
        btnNew.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        jPanel1.add(btnNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 330, -1, -1));

        btnAdd.setBackground(new java.awt.Color(255, 255, 255));
        btnAdd.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        btnAdd.setText("ADD");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(835, 480, 90, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/crabproject/vidurabookshop/images/Header.png"))); // NOI18N
        jLabel1.setToolTipText("");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 1090, 240));

        table.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Code", "Name", "Price", "Qty", "Total"
            }
        ));
        jScrollPane1.setViewportView(table);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 480, 780, 160));

        lblTotal.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        lblTotal.setToolTipText("");
        lblTotal.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Total Rs.", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Century Gothic", 0, 24))); // NOI18N
        jPanel1.add(lblTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 530, 230, 60));

        btnRemove.setBackground(new java.awt.Color(255, 255, 255));
        btnRemove.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });
        jPanel1.add(btnRemove, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 480, 140, -1));

        jLabel15.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel15.setText("OrderDate");
        jLabel15.setToolTipText("");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 270, 130, 40));

        jLabel17.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel17.setText("CustomerName");
        jLabel17.setToolTipText("");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 320, 190, 40));

        lblCustomerName.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        lblCustomerName.setText("D001");
        lblCustomerName.setToolTipText("");
        lblCustomerName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lblCustomerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 320, 270, 40));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/crabproject/vidurabookshop/images/place order.png"))); // NOI18N
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 1100, 670));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPlaceOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlaceOrderActionPerformed
        String customerID=cmbCustomerID.getSelectedItem().toString();
        String orderID= lblOrderID.getText();
        String orderDate = txtOrderDate.getText();
        ArrayList<BookDetail> bookDetails = new ArrayList<>();
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        
        for (int i = 0; i < dtm.getRowCount(); i++) {
            String bookCode = (String) dtm.getValueAt(i, 0);
            String bookName = (String) dtm.getValueAt(i, 1);
            Double price = (Double) dtm.getValueAt(i, 2);
            int qty = (int) dtm.getValueAt(i, 3);
            BookDetail bookDetail = new BookDetail(bookCode, orderID, qty, price);
            bookDetails.add(bookDetail); 
        }
        
        OrderDTO order = new OrderDTO(orderID, customerID, orderDate, bookDetails);
        try {
            boolean isAdded = OrderController.addOrder(order);
            if(isAdded){
                JOptionPane.showMessageDialog(this, "Added Success");
                this.dispose();
                new Dashboard().setVisible(true);
            }else{
                JOptionPane.showMessageDialog(this, "Added failed");
            }
        } catch (Exception ex) {
            Logger.getLogger(PlaceOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnPlaceOrderActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        new ManageCustomer().setVisible(true);
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        
        int qty = Integer.parseInt(txtQty.getText());
        double price = Double.parseDouble(lblPrice.getText());
        double total = qty*price;
        
        int exist = isAlreadyExist(cmbCode.getSelectedItem().toString());
        if(exist==-1){
            Object[] rowData = {cmbCode.getSelectedItem().toString(),lblName.getText(),price,qty,total};
            dtm.addRow(rowData);
        }else{
            qty+=(int)dtm.getValueAt(exist, 3);
            total=qty*price;
            dtm.setValueAt(qty, exist, 3);
            dtm.setValueAt(total, exist, 4);
        }
        calculateTotalValue();
        cmbCode.requestFocus();
        txtQty.setText("");
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        int selectedRow = table.getSelectedRow();
        
        if(selectedRow!=-1){
            dtm.removeRow(selectedRow);
            calculateTotalValue();
        }else{
            return;
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        this.dispose();
        new Dashboard().setVisible(true);
    }//GEN-LAST:event_jLabel8MouseClicked

    private void cmbCustomerIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCustomerIDActionPerformed
        
    }//GEN-LAST:event_cmbCustomerIDActionPerformed

    private void cmbCustomerIDItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCustomerIDItemStateChanged
        try {
            lblCustomerName.setText(CustomerController.searchCustomer(cmbCustomerID.getSelectedItem().toString()).getName());
        } catch (Exception ex) {
            Logger.getLogger(PlaceOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmbCustomerIDItemStateChanged

    private void cmbCodeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCodeItemStateChanged
        try {
            BookDTO book = BookController.searchBook(cmbCode.getSelectedItem().toString());
            lblName.setText(book.getName());
            lblPrice.setText(book.getPrice()+"");
            lblQtyOnHand.setText(book.getQty()+"");
            
        } catch (Exception ex) {
            Logger.getLogger(PlaceOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_cmbCodeItemStateChanged

    private void txtQtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQtyActionPerformed
        btnAdd.doClick();
    }//GEN-LAST:event_txtQtyActionPerformed

    private void cmbCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCodeActionPerformed

    private void cmbCustomerIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbCustomerIDKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cmbCode.requestFocus();
        }
    }//GEN-LAST:event_cmbCustomerIDKeyPressed

    private void cmbCodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbCodeKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtQty.requestFocus();
        }
    }//GEN-LAST:event_cmbCodeKeyPressed

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
            java.util.logging.Logger.getLogger(PlaceOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlaceOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlaceOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlaceOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlaceOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnPlaceOrder;
    private javax.swing.JButton btnRemove;
    private javax.swing.JComboBox<String> cmbCode;
    private javax.swing.JComboBox<String> cmbCustomerID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCustomerName;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblOrderID;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblQtyOnHand;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtOrderDate;
    private javax.swing.JTextField txtQty;
    // End of variables declaration//GEN-END:variables

    private void calculateTotalValue() {
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        double finalTotal=0;
        for (int i = 0; i < dtm.getRowCount(); i++) {
            finalTotal+=(double)dtm.getValueAt(i, 4);
        }
        lblTotal.setText(finalTotal+"");
    }

    

    
}
