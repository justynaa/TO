/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package to_projekt_v2;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Justyna
 */
public class CarsManager extends javax.swing.JFrame {
    String userName = "";
    String userType = "";
    Connection connection = null;
    //PreparedStatement ptmt = null; //chyba do usuniecia
    ResultSet resultSet = null;
    Car car; //v3_6
    CarDAO carDAO = new CarDAO();

    public CarsManager() throws SQLException {
        initComponents();
        showCarsInJTable();
    }
    public CarsManager(String userName, String userType) throws SQLException {
        initComponents();
        this.userName = userName;
        this.userType = userType;
        jLabelUserName.setText(userName);   //zmienna zalogowanego
        showCarsInJTable();
    }

    //Wyswietlenie w JTable
    public void showCarsInJTable() throws SQLException{
        ArrayList<Car> carsList = carDAO.getCarsList();
        DefaultTableModel model = (DefaultTableModel)jTableDisplayCars.getModel();
        Object[] row = new Object[6];       //6 kolumn
        for(int i=0; i < carsList.size(); i++){
            row[0] = carsList.get(i).getID();
            row[1] = carsList.get(i).getBrand();
            row[2] = carsList.get(i).getModel();
            row[3] = carsList.get(i).getRegistrationNumber();
            row[4] = carsList.get(i).getProductionYear();
            row[5] = carsList.get(i).getClientID();
            model.addRow(row);
        }
        
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelUserName = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldID = new javax.swing.JTextField();
        jTextFieldMarka = new javax.swing.JTextField();
        jTextFieldModel = new javax.swing.JTextField();
        jTextFieldNrRej = new javax.swing.JTextField();
        jTextFieldRokProd = new javax.swing.JTextField();
        jTextFieldIDKlient = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDisplayCars = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Zalogowany jako:");

        jLabelUserName.setText("jLabel2");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("ID:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Marka:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Model:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Numer rejestracyjny:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Rok produkcji:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("ID Klienta");

        jTextFieldID.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jTextFieldMarka.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jTextFieldModel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jTextFieldNrRej.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jTextFieldRokProd.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jTextFieldIDKlient.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jTableDisplayCars.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Marka", "Model", "Numer rejestracyjny", "Rok produkcji", "Właściciel ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableDisplayCars.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDisplayCarsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableDisplayCars);
        if (jTableDisplayCars.getColumnModel().getColumnCount() > 0) {
            jTableDisplayCars.getColumnModel().getColumn(0).setMaxWidth(40);
            jTableDisplayCars.getColumnModel().getColumn(1).setPreferredWidth(110);
            jTableDisplayCars.getColumnModel().getColumn(1).setMaxWidth(160);
            jTableDisplayCars.getColumnModel().getColumn(2).setPreferredWidth(110);
            jTableDisplayCars.getColumnModel().getColumn(2).setMaxWidth(160);
            jTableDisplayCars.getColumnModel().getColumn(3).setPreferredWidth(110);
            jTableDisplayCars.getColumnModel().getColumn(4).setPreferredWidth(60);
            jTableDisplayCars.getColumnModel().getColumn(5).setPreferredWidth(60);
        }

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N
        jButton1.setText("Dodaj");
        jButton1.setToolTipText("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/update.png"))); // NOI18N
        jButton2.setText("Aktualizuj");
        jButton2.setToolTipText("");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/return.png"))); // NOI18N
        jButton3.setText("Wstecz");
        jButton3.setToolTipText("");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/remove.png"))); // NOI18N
        jButton4.setText("Usuń");
        jButton4.setToolTipText("");

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/look.png"))); // NOI18N
        jButton5.setText("Podgląd właścicieli");
        jButton5.setToolTipText("");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelUserName))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextFieldRokProd)
                                    .addComponent(jTextFieldNrRej, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldModel, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldMarka, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldID)
                                    .addComponent(jTextFieldIDKlient, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGap(17, 17, 17)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton2)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabelUserName))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldMarka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldNrRej, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldRokProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldIDKlient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableDisplayCarsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDisplayCarsMouseClicked
        // Wyswietlenie wybranego rekordu w JTextFields
        int i = jTableDisplayCars.getSelectedRow();
        TableModel model = jTableDisplayCars.getModel();
        jTextFieldID.setText(model.getValueAt(i, 0).toString().trim());
        jTextFieldMarka.setText(model.getValueAt(i, 1).toString().trim());
        jTextFieldModel.setText(model.getValueAt(i, 2).toString().trim());
        jTextFieldNrRej.setText(model.getValueAt(i, 3).toString().trim());
        jTextFieldRokProd.setText(model.getValueAt(i, 4).toString().trim());
        jTextFieldIDKlient.setText(model.getValueAt(i, 5).toString().trim()); 
        
        
    }//GEN-LAST:event_jTableDisplayCarsMouseClicked
    //Wstawianie nowego klienta do bazy
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            car = new Car(jTextFieldMarka.getText(), jTextFieldModel.getText(),  
                        jTextFieldNrRej.getText(), Integer.parseInt(jTextFieldRokProd.getText()), Integer.parseInt(jTextFieldIDKlient.getText()));
            carDAO.addNewCarDAO(car);
                //odswiezenie danych widocznych w JTable
            DefaultTableModel model = (DefaultTableModel)jTableDisplayCars.getModel();
            model.setRowCount(0);
            showCarsInJTable();
        } catch (SQLException ex) {
            Logger.getLogger(CarsManager.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            car = new Car(Integer.parseInt(jTextFieldID.getText()),jTextFieldMarka.getText(), jTextFieldModel.getText(), jTextFieldNrRej.getText(), 
                        Integer.parseInt(jTextFieldRokProd.getText()), Integer.parseInt(jTextFieldIDKlient.getText()));
            carDAO.updateCarDataDAO(car);
                //odswiezenie danych widocznych w JTable
            DefaultTableModel model = (DefaultTableModel)jTableDisplayCars.getModel();
            model.setRowCount(0);
            showCarsInJTable();
            } catch (SQLException ex) {
                Logger.getLogger(CarsManager.class.getName()).log(Level.SEVERE, null, ex);
            }
    
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(userType == "A"){
            AdminStartPanel asp = new AdminStartPanel(userName, userType);
            asp.setVisible(true);
            setVisible(false);
        }
        else if(userType == "B"){
            BOKStartPanel bsp = new BOKStartPanel(userName, userType);
            bsp.setVisible(true);
            setVisible(false);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String userName2 = "";
        userName2 = this.userName;
        ClientsManager clm;
        try {
            clm = new ClientsManager(userName2, userType);
            clm.setVisible(true);
            //setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(BOKStartPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(CarsManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CarsManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CarsManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CarsManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
 
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new CarsManager().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(CarsManager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelUserName;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableDisplayCars;
    private javax.swing.JTextField jTextFieldID;
    private javax.swing.JTextField jTextFieldIDKlient;
    private javax.swing.JTextField jTextFieldMarka;
    private javax.swing.JTextField jTextFieldModel;
    private javax.swing.JTextField jTextFieldNrRej;
    private javax.swing.JTextField jTextFieldRokProd;
    // End of variables declaration//GEN-END:variables
}
