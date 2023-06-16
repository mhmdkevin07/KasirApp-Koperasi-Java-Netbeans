/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form_user;

import form_main.koneksi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class data_barang extends javax.swing.JPanel {

    /**
     * Creates new form data_anggota
     */
    public data_barang() {
        initComponents();
        tampil_tabel();
        
    }

    private String jenis_barang,warna,harga;
    private void tampil_handphone(){
          
           DefaultTableModel model = new DefaultTableModel();
           model.addColumn("No. ");
           model.addColumn("Kode Barang. ");
           model.addColumn("Jenis. ");
           model.addColumn("Merek. ");
           model.addColumn("Type. ");
           
           model.addColumn("Berat. ");
           model.addColumn("Dimensi. ");
           model.addColumn("Processor. ");
           model.addColumn("RAM. ");
           model.addColumn("Memori. ");
           model.addColumn("Kamera. ");
           model.addColumn("Layar. ");
           model.addColumn("Baterai. ");
           model.addColumn("Ketahanan. ");
           model.addColumn("Warna. ");
           model.addColumn("Harga. ");
           model.addColumn("Supplier. ");
           
           
           try{
            int no = 1;
            java.sql.Connection conn = (Connection)koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            ResultSet res = conn.createStatement().executeQuery("SELECT * FROM barang where jenis_brg like '%" + cbjenis.getSelectedItem() + "%'");
       
                    
            while(res.next()){
                
                model.addRow(new Object[]{no++,res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(6)
                        ,res.getString(7),res.getString(9),res.getString(10),res.getString(11),res.getString(13),res.getString(14)
                        ,res.getString(15),res.getString(16),res.getString(8),res.getString(5),res.getString(20)}); 
            
            tabelbarang.setModel(model); 
            }
                
           }catch (SQLException e){
               System.out.println("Error :"+ e.getMessage());
           }
       }
    
    private void tampil_laptop(){
          
           DefaultTableModel model = new DefaultTableModel();
           model.addColumn("No. ");
           model.addColumn("Kode Barang. ");
           model.addColumn("Jenis. ");
           model.addColumn("Merek. ");
           model.addColumn("Type. ");
           model.addColumn("Berat. ");
           model.addColumn("Dimensi. ");
           model.addColumn("Processor. ");
           model.addColumn("RAM. ");
           model.addColumn("Memori. ");
           model.addColumn("SO. ");
           model.addColumn("Kamera. ");
           model.addColumn("Layar. ");
           model.addColumn("Baterai. ");
           model.addColumn("Ketahanan. ");
           model.addColumn("Warna. ");
           model.addColumn("Harga. ");
           model.addColumn("Supplier. ");
           
           
           try{
            int no = 1;
            java.sql.Connection conn = (Connection)koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            ResultSet res = conn.createStatement().executeQuery("SELECT * FROM barang where jenis_brg like '%" + cbjenis.getSelectedItem() + "%'");
            
            while(res.next()){
                model.addRow(new Object[]{no++,res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(6),res.getString(7)
                        ,res.getString(9),res.getString(10),res.getString(11),res.getString(12),res.getString(13),res.getString(14),res.getString(15)
                         ,res.getString(16),res.getString(8),res.getString(5),res.getString(20)}); 
            
            tabelbarang.setModel(model); 
            }
                
           }catch (SQLException e){
               JOptionPane.showMessageDialog(this, e.getMessage());
           }
       }
    
    private void tampil_TV(){
          
           DefaultTableModel model = new DefaultTableModel();
           model.addColumn("No. ");
           model.addColumn("Kode Barang. ");
           model.addColumn("Jenis. ");
           model.addColumn("Merek. ");
           model.addColumn("Type. ");
           model.addColumn("Berat. ");
           model.addColumn("Dimensi. ");
           model.addColumn("Layar. ");
           model.addColumn("Daya(Watt). ");
           model.addColumn("Warna. ");
           model.addColumn("Harga. ");
           model.addColumn("Supplier. ");
           
           
           try{
            int no = 1;
            java.sql.Connection conn = (Connection)koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            ResultSet res = conn.createStatement().executeQuery("SELECT * FROM barang where jenis_brg like '%" + cbjenis.getSelectedItem() + "%'");
            
            while(res.next()){
                model.addRow(new Object[]{no++,res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(6),res.getString(7)
                        ,res.getString(14),res.getString(18),res.getString(8),res.getString(5),res.getString(20)}); 
            
            tabelbarang.setModel(model); 
            }
                
           }catch (SQLException e){
               System.out.println("Error :"+ e.getMessage());
           }
       }
    
    private void tampil_Speaker(){
          
           DefaultTableModel model = new DefaultTableModel();
           model.addColumn("No. ");
           model.addColumn("Kode Barang. ");
           model.addColumn("Jenis. ");
           model.addColumn("Merek. ");
           model.addColumn("Type. ");
           model.addColumn("Berat. ");
           model.addColumn("Dimensi. ");
           model.addColumn("Baterai. ");
           model.addColumn("Ketahanan. ");
           model.addColumn("Versi Bluetooth. ");
           model.addColumn("Warna. ");
           model.addColumn("Harga. ");
           model.addColumn("Supplier. ");
           
           try{
            int no = 1;
            java.sql.Connection conn = (Connection)koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            ResultSet res = conn.createStatement().executeQuery("SELECT * FROM barang where jenis_brg like '%" + cbjenis.getSelectedItem() + "%'");
            
            while(res.next()){
                
                model.addRow(new Object[]{no++,res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(6),res.getString(7)
                        ,res.getString(15),res.getString(16),res.getString(19),res.getString(8),res.getString(5),res.getString(20)}); 
            
            tabelbarang.setModel(model); 
            }
                
           }catch (SQLException e){
               System.out.println("Error :"+ e.getMessage());
           }
       }

    private void tampil_Kipas_AC(){
          
           DefaultTableModel model = new DefaultTableModel();
           model.addColumn("No. ");
           model.addColumn("Kode Barang. ");
           model.addColumn("Jenis. ");
           model.addColumn("Merek. ");
           model.addColumn("Type. ");
           model.addColumn("Berat. ");
           model.addColumn("Dimensi. ");
           model.addColumn("Daya(Watt). ");
           model.addColumn("Warna. ");
           model.addColumn("Harga. ");
           model.addColumn("Supplier. ");
           
           try{
            int no = 1;
            java.sql.Connection conn = (Connection)koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            ResultSet res = conn.createStatement().executeQuery("SELECT * FROM barang where jenis_brg like '%" + cbjenis.getSelectedItem() + "%'");
            
            while(res.next()){
                model.addRow(new Object[]{no++,res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(6),res.getString(7)
                        ,res.getString(18),res.getString(8),res.getString(5),res.getString(20)}); 
            
            tabelbarang.setModel(model); 
            }
                
           }catch (SQLException e){
               System.out.println("Error :"+ e.getMessage());
           }
       }
    
    private void tampil_Sisa(){
          
           DefaultTableModel model = new DefaultTableModel();
           model.addColumn("No. ");
           model.addColumn("Kode Barang. ");
           model.addColumn("Jenis. ");
           model.addColumn("Merek. ");
           model.addColumn("Type. ");
           model.addColumn("Berat. ");
           model.addColumn("Dimensi. ");
           model.addColumn("Kapasitas. ");
           model.addColumn("Daya(Watt). ");
           model.addColumn("Warna. ");
           model.addColumn("Harga. ");
           model.addColumn("Supplier. ");
           
           
           
           try{
            int no = 1;
            java.sql.Connection conn = (Connection)koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            ResultSet res = conn.createStatement().executeQuery("SELECT * FROM barang where jenis_brg like '%" + cbjenis.getSelectedItem() + "%'");
            
            while(res.next()){
                model.addRow(new Object[]{no++,res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(6),res.getString(7)
                        ,res.getString(17),res.getString(18),res.getString(8),res.getString(5),res.getString(20)}); 
            
            tabelbarang.setModel(model); 
            }
                
           }catch (SQLException e){
               System.out.println("Error :"+ e.getMessage());
           }
       }
    
    private void tampil_tabel(){
        jenis_barang = String.valueOf(cbjenis.getSelectedItem());

        if (jenis_barang == "Handphone"){
            tampil_handphone();
        }else if (jenis_barang == "Laptop"){
            tampil_laptop();
        }else if (jenis_barang == "TV"){
            tampil_TV();
        }else if (jenis_barang == "Speaker Bluetooth"){
            tampil_Speaker();
        }else if (jenis_barang == "Kipas Angin"){
            tampil_Kipas_AC();
        }else if (jenis_barang == "AC"){
            tampil_Kipas_AC();
        }else if (jenis_barang == "Kulkas 2 Pintu"){
            tampil_Sisa();
        }else if (jenis_barang == "Microwave"){
            tampil_Sisa();
        }else if (jenis_barang == "Dispanser"){
            tampil_Sisa();
        }else if (jenis_barang == "Mesin Cuci"){
            tampil_Sisa();
        }else if (jenis_barang == "Magic Com"){
            tampil_Sisa();
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

        kGradientPanel1 = new keeptoo.KGradientPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelbarang = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbjenis = new javax.swing.JComboBox<>();

        setLayout(new java.awt.BorderLayout());

        kGradientPanel1.setkEndColor(new java.awt.Color(204, 255, 204));
        kGradientPanel1.setkStartColor(new java.awt.Color(255, 255, 204));

        tabelbarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabelbarang);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("DAFTAR BARANG KOPERASI DUTA USAHA");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Pilih Jenis Barang Terlebih Dahulu :");

        cbjenis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Handphone", "Laptop", "TV", "Speaker Bluetooth", "Kipas Angin", "AC", "Kulkas 2 Pintu", "Microwave", "Dispanser", "Mesin Cuci", "Magic Com" }));
        cbjenis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbjenisActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGap(286, 286, 286)
                                .addComponent(jLabel1)
                                .addGap(52, 52, 52))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addComponent(cbjenis, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(224, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbjenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                .addGap(49, 49, 49))
        );

        add(kGradientPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void cbjenisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbjenisActionPerformed
    tampil_tabel();
    }//GEN-LAST:event_cbjenisActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbjenis;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JTable tabelbarang;
    // End of variables declaration//GEN-END:variables
}
