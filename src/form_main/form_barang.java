/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form_main;

import java.awt.Color;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.HeadlessException;
import java.sql.Connection;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class form_barang extends javax.swing.JPanel {

    private String jenis_barang, warna, harga;
    
    /**
     * Creates new form form_barang
     */
    public form_barang() {
        initComponents();
        kosongkan_form();
        otomatis();
        tampil_handphone();
        
        btnsimpan.setEnabled(true);
        btnedit.setEnabled(false);
        btnhapus.setEnabled(false);
    }
    
    NumberFormat nf = NumberFormat.getNumberInstance(new Locale("in","ID"));
    
    public void otomatis(){
        
        try{
            Connection conn = (Connection)koneksi.configDB();
            Statement stt = conn.createStatement();
            ResultSet rs = stt.executeQuery("Select Max(Right(kode_brg,3)) as no from barang");
            
            
            while (rs.next()) {
                if (rs.first() == false) {
                    txtkode.setText("BRG001");
                } else {
                    rs.last();
                    int auto_id = rs.getInt(1) + 1;
                    String no = String.valueOf(auto_id);
                    int NomorJual = no.length();
                    //MENGATUR jumlah 0
                    for (int j = 0; j < 3 - NomorJual; j++) {
                        no = "0" + no;
                    }
                    txtkode.setText("BRG" + no);
                }
            }
            rs.close();
            stt.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "ERROR: \n" + e.toString(),
                    "Kesalahan", JOptionPane.WARNING_MESSAGE);
        }
    }
                      
    
    private void combo(){
        jenis_barang = String.valueOf(cbjenis.getSelectedItem());
        
        if (jenis_barang == "Handphone"){
            //True
            txtprocesor.setEditable(true);
            txtprocesor.setBackground(Color.white);
            txtram.setEditable(true);
            txtram.setBackground(Color.white);
            txtmemori.setEditable(true);
            txtmemori.setBackground(Color.white);
            txtkamera.setEditable(true);
            txtkamera.setBackground(Color.white);
            txtlayar.setEditable(true);
            txtlayar.setBackground(Color.white);
            txtbaterai.setEditable(true);
            txtbaterai.setBackground(Color.white);
            txtketahanan.setEditable(true);
            txtketahanan.setBackground(Color.white);
            //False
            txtsistem.setEditable(false);
            txtsistem.setBackground(Color.gray);
            txtkapasitas.setEditable(false);
            txtkapasitas.setBackground(Color.gray);
            txtkonsumsidaya.setEditable(false);
            txtkonsumsidaya.setBackground(Color.gray);
            txtbluetooth.setEditable(false);
            txtbluetooth.setBackground(Color.gray);
            
        }else if (jenis_barang == "Laptop"){
            //True
            txtsistem.setEditable(true);
            txtsistem.setBackground(Color.white);
            txtprocesor.setEditable(true);
            txtprocesor.setBackground(Color.white);
            txtram.setEditable(true);
            txtram.setBackground(Color.white);
            txtmemori.setEditable(true);
            txtmemori.setBackground(Color.white);
            txtlayar.setEditable(true);
            txtlayar.setBackground(Color.white);
            txtbaterai.setEditable(true);
            txtbaterai.setBackground(Color.white);
            txtketahanan.setEditable(true);
            txtketahanan.setBackground(Color.white);
            txtkamera.setEditable(true);
            txtkamera.setBackground(Color.white);
            //False
            txtkapasitas.setEditable(false);
            txtkapasitas.setBackground(Color.gray);
            txtkonsumsidaya.setEditable(false);
            txtkonsumsidaya.setBackground(Color.gray);
            txtbluetooth.setEditable(false);
            txtbluetooth.setBackground(Color.gray);
        }else if (jenis_barang == "TV"){
            //True
            txtlayar.setEditable(true);
            txtlayar.setBackground(Color.white);
            txtkonsumsidaya.setEditable(true);
            txtkonsumsidaya.setBackground(Color.white);
            //False
            txtsistem.setEditable(false);
            txtsistem.setBackground(Color.gray);
            txtprocesor.setEditable(false);
            txtprocesor.setBackground(Color.gray);
            txtram.setEditable(false);
            txtram.setBackground(Color.gray);
            txtmemori.setEditable(false);
            txtmemori.setBackground(Color.gray);
            txtkamera.setEditable(false);
            txtkamera.setBackground(Color.gray);
            txtkapasitas.setEditable(false);
            txtkapasitas.setBackground(Color.gray);
            txtbluetooth.setEditable(false);
            txtbluetooth.setBackground(Color.gray);
            txtbaterai.setEditable(false);
            txtbaterai.setBackground(Color.gray);
            txtketahanan.setEditable(false);
            txtketahanan.setBackground(Color.gray);
        }else if (jenis_barang == "Speaker Bluetooth"){
            //True
            txtbluetooth.setEditable(true);
            txtbluetooth.setBackground(Color.white);
            txtbaterai.setEditable(true);
            txtbaterai.setBackground(Color.white);
            txtketahanan.setEditable(true);
            txtketahanan.setBackground(Color.white);
            //False
            txtsistem.setEditable(false);
            txtsistem.setBackground(Color.gray);
            txtprocesor.setEditable(false);
            txtprocesor.setBackground(Color.gray);
            txtram.setEditable(false);
            txtram.setBackground(Color.gray);
            txtmemori.setEditable(false);
            txtmemori.setBackground(Color.gray);
            txtkamera.setEditable(false);
            txtkamera.setBackground(Color.gray);
            txtkapasitas.setEditable(false);
            txtkapasitas.setBackground(Color.gray);
            txtlayar.setEditable(false);
            txtlayar.setBackground(Color.gray);
            txtkonsumsidaya.setEditable(false);
            txtkonsumsidaya.setBackground(Color.gray);
        }else if (jenis_barang == "Kipas Angin"){
            //true
            txtkonsumsidaya.setEditable(true);
            txtkonsumsidaya.setBackground(Color.white);
            //false
            txtsistem.setEditable(false);
            txtsistem.setBackground(Color.gray);
            txtprocesor.setEditable(false);
            txtprocesor.setBackground(Color.gray);
            txtram.setEditable(false);
            txtram.setBackground(Color.gray);
            txtmemori.setEditable(false);
            txtmemori.setBackground(Color.gray);
            txtkamera.setEditable(false);
            txtkamera.setBackground(Color.gray);
            txtkapasitas.setEditable(false);
            txtkapasitas.setBackground(Color.gray);
            txtlayar.setEditable(false);
            txtlayar.setBackground(Color.gray);
            txtbluetooth.setEditable(false);
            txtbluetooth.setBackground(Color.gray);
            txtbaterai.setEditable(false);
            txtbaterai.setBackground(Color.gray);
            txtketahanan.setEditable(false);
            txtketahanan.setBackground(Color.gray);
        }else if (jenis_barang == "AC"){
            //true
            txtkonsumsidaya.setEditable(true);
            txtkonsumsidaya.setBackground(Color.white);
            //false
            txtsistem.setEditable(false);
            txtsistem.setBackground(Color.gray);
            txtprocesor.setEditable(false);
            txtprocesor.setBackground(Color.gray);
            txtram.setEditable(false);
            txtram.setBackground(Color.gray);
            txtmemori.setEditable(false);
            txtmemori.setBackground(Color.gray);
            txtkamera.setEditable(false);
            txtkamera.setBackground(Color.gray);
            txtkapasitas.setEditable(false);
            txtkapasitas.setBackground(Color.gray);
            txtlayar.setEditable(false);
            txtlayar.setBackground(Color.gray);
            txtbluetooth.setEditable(false);
            txtbluetooth.setBackground(Color.gray);
            txtbaterai.setEditable(false);
            txtbaterai.setBackground(Color.gray);
            txtketahanan.setEditable(false);
            txtketahanan.setBackground(Color.gray);
        }else if (jenis_barang == "Kulkas 2 Pintu"){
            //true
            txtkonsumsidaya.setEditable(true);
            txtkonsumsidaya.setBackground(Color.white);
            txtkapasitas.setEditable(true);
            txtkapasitas.setBackground(Color.white);
            //false
            txtsistem.setEditable(false);
            txtsistem.setBackground(Color.gray);
            txtprocesor.setEditable(false);
            txtprocesor.setBackground(Color.gray);
            txtram.setEditable(false);
            txtram.setBackground(Color.gray);
            txtmemori.setEditable(false);
            txtmemori.setBackground(Color.gray);
            txtkamera.setEditable(false);
            txtkamera.setBackground(Color.gray);
            txtlayar.setEditable(false);
            txtlayar.setBackground(Color.gray);
            txtbluetooth.setEditable(false);
            txtbluetooth.setBackground(Color.gray);
            txtbaterai.setEditable(false);
            txtbaterai.setBackground(Color.gray);
            txtketahanan.setEditable(false);
            txtketahanan.setBackground(Color.gray);
        }else if (jenis_barang == "Microwave"){
            //true
            txtkonsumsidaya.setEditable(true);
            txtkonsumsidaya.setBackground(Color.white);
            txtkapasitas.setEditable(true);
            txtkapasitas.setBackground(Color.white);
            //false
            txtsistem.setEditable(false);
            txtsistem.setBackground(Color.gray);
            txtprocesor.setEditable(false);
            txtprocesor.setBackground(Color.gray);
            txtram.setEditable(false);
            txtram.setBackground(Color.gray);
            txtmemori.setEditable(false);
            txtmemori.setBackground(Color.gray);
            txtkamera.setEditable(false);
            txtkamera.setBackground(Color.gray);
            txtlayar.setEditable(false);
            txtlayar.setBackground(Color.gray);
            txtbluetooth.setEditable(false);
            txtbluetooth.setBackground(Color.gray);
            txtbaterai.setEditable(false);
            txtbaterai.setBackground(Color.gray);
            txtketahanan.setEditable(false);
            txtketahanan.setBackground(Color.gray);
        }else if (jenis_barang == "Dispanser"){
            //true
            txtkonsumsidaya.setEditable(true);
            txtkonsumsidaya.setBackground(Color.white);
            txtkapasitas.setEditable(true);
            txtkapasitas.setBackground(Color.white);
            //false
            txtsistem.setEditable(false);
            txtsistem.setBackground(Color.gray);
            txtprocesor.setEditable(false);
            txtprocesor.setBackground(Color.gray);
            txtram.setEditable(false);
            txtram.setBackground(Color.gray);
            txtmemori.setEditable(false);
            txtmemori.setBackground(Color.gray);
            txtkamera.setEditable(false);
            txtkamera.setBackground(Color.gray);
            txtlayar.setEditable(false);
            txtlayar.setBackground(Color.gray);
            txtbluetooth.setEditable(false);
            txtbluetooth.setBackground(Color.gray);
            txtbaterai.setEditable(false);
            txtbaterai.setBackground(Color.gray);
            txtketahanan.setEditable(false);
            txtketahanan.setBackground(Color.gray);
        }else if (jenis_barang == "Mesin Cuci"){
            //true
            txtkonsumsidaya.setEditable(true);
            txtkonsumsidaya.setBackground(Color.white);
            txtkapasitas.setEditable(true);
            txtkapasitas.setBackground(Color.white);
            //false
            txtsistem.setEditable(false);
            txtsistem.setBackground(Color.gray);
            txtprocesor.setEditable(false);
            txtprocesor.setBackground(Color.gray);
            txtram.setEditable(false);
            txtram.setBackground(Color.gray);
            txtmemori.setEditable(false);
            txtmemori.setBackground(Color.gray);
            txtkamera.setEditable(false);
            txtkamera.setBackground(Color.gray);
            txtlayar.setEditable(false);
            txtlayar.setBackground(Color.gray);
            txtbluetooth.setEditable(false);
            txtbluetooth.setBackground(Color.gray);
            txtbaterai.setEditable(false);
            txtbaterai.setBackground(Color.gray);
            txtketahanan.setEditable(false);
            txtketahanan.setBackground(Color.gray);
        }else if (jenis_barang == "Magic Com"){
            //true
            txtkonsumsidaya.setEditable(true);
            txtkonsumsidaya.setBackground(Color.white);
            txtkapasitas.setEditable(true);
            txtkapasitas.setBackground(Color.white);
            //false
            txtsistem.setEditable(false);
            txtsistem.setBackground(Color.gray);
            txtprocesor.setEditable(false);
            txtprocesor.setBackground(Color.gray);
            txtram.setEditable(false);
            txtram.setBackground(Color.gray);
            txtmemori.setEditable(false);
            txtmemori.setBackground(Color.gray);
            txtkamera.setEditable(false);
            txtkamera.setBackground(Color.gray);
            txtlayar.setEditable(false);
            txtlayar.setBackground(Color.gray);
            txtbluetooth.setEditable(false);
            txtbluetooth.setBackground(Color.gray);
            txtbaterai.setEditable(false);
            txtbaterai.setBackground(Color.gray);
            txtketahanan.setEditable(false);
            txtketahanan.setBackground(Color.gray);
        }
    }
    
    private void kosongkan_form(){
     //form barang
        cbjenis.setSelectedItem(this);
        txtmerek.setText("");
        txtdetail.setText("");
        txtharga.setText("");
        txtberat.setText("");
        txtdimensi.setText("");
        txtwarna.setText("");
        txtprocesor.setText("");
        txtram.setText("");
        txtmemori.setText("");
        txtsistem.setText("");
        txtkamera.setText("");
        txtlayar.setText("");
        txtbaterai.setText("");
        txtketahanan.setText("");
        txtkapasitas.setText("");
        txtkonsumsidaya.setText("");
        txtbluetooth.setText("");
        txtsupplier.setText("");
    }
    
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

        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        txtkode = new javax.swing.JTextField();
        txtmerek = new javax.swing.JTextField();
        cbjenis = new javax.swing.JComboBox<>();
        btnsimpan = new javax.swing.JButton();
        btnedit = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        txtharga = new javax.swing.JTextField();
        txtdetail = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        txtwarna = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtberat = new javax.swing.JTextField();
        txtdimensi = new javax.swing.JTextField();
        txtram = new javax.swing.JTextField();
        txtmemori = new javax.swing.JTextField();
        txtkamera = new javax.swing.JTextField();
        txtketahanan = new javax.swing.JTextField();
        txtbaterai = new javax.swing.JTextField();
        txtlayar = new javax.swing.JTextField();
        txtprocesor = new javax.swing.JTextField();
        txtsistem = new javax.swing.JTextField();
        txtbluetooth = new javax.swing.JTextField();
        txtkapasitas = new javax.swing.JTextField();
        txtkonsumsidaya = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        txtsupplier = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelbarang = new javax.swing.JTable();

        setBackground(new java.awt.Color(204, 255, 204));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel30.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel30.setText("DATA BARANG");
        add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 222, 43));

        jLabel31.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel31.setText("Kode Barang");
        add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, 32));

        jLabel32.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel32.setText("Jenis Barang");
        add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, -1, 32));

        jLabel33.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel33.setText("Spesifikasi Data Barang");
        add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, 32));

        txtkode.setEditable(false);
        txtkode.setBackground(new java.awt.Color(204, 255, 204));
        txtkode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtkodeActionPerformed(evt);
            }
        });
        add(txtkode, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 223, -1));

        txtmerek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmerekActionPerformed(evt);
            }
        });
        add(txtmerek, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 155, -1));

        cbjenis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Handphone", "Laptop", "TV", "Speaker Bluetooth", "Kipas Angin", "AC", "Kulkas 2 Pintu", "Microwave", "Dispanser", "Mesin Cuci", "Magic Com" }));
        cbjenis.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cbjenis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbjenisActionPerformed(evt);
            }
        });
        add(cbjenis, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 50, 472, -1));

        btnsimpan.setText("SIMPAN");
        btnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanActionPerformed(evt);
            }
        });
        add(btnsimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 430, 92, 33));

        btnedit.setText("EDIT");
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });
        add(btnedit, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 430, 92, 33));

        btnhapus.setText("HAPUS");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });
        add(btnhapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 430, 92, 33));

        jLabel36.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel36.setText("Harga");
        add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, 32));

        txtharga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthargaActionPerformed(evt);
            }
        });
        add(txtharga, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 155, -1));

        txtdetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdetailActionPerformed(evt);
            }
        });
        add(txtdetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 155, -1));

        jLabel37.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel37.setText("Detail Merek");
        add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, 32));

        jLabel38.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel38.setText("RAM");
        add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, -1, 32));

        txtwarna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtwarnaActionPerformed(evt);
            }
        });
        add(txtwarna, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 380, 155, -1));

        jLabel39.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel39.setText("Warna");
        add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, -1, 32));

        jLabel40.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel40.setText("Memori");
        add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 220, -1, 32));

        jLabel41.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel41.setText("Baterai");
        add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 140, -1, 32));

        jLabel42.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel42.setText("Kualitas Kamera");
        add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 330, -1, 32));

        jLabel43.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel43.setText("Dimensi");
        add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, -1, 32));

        jLabel44.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel44.setText("Ukuran Layar");
        add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 370, -1, 32));

        jLabel45.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel45.setText("Procesor");
        add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, -1, 32));

        jLabel46.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel46.setText("Sistem Operasi");
        add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 290, -1, 32));

        jLabel47.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel47.setText("Kapasitas");
        add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 220, -1, 32));

        jLabel48.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel48.setText("Konsumsi Daya");
        add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 260, -1, 32));

        jLabel49.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel49.setText("Versi Bluetooth");
        add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 330, -1, 32));

        jLabel50.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel50.setText("Ketahanan Baterai");
        add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 180, -1, 32));

        jLabel51.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel51.setText("Berat");
        add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, -1, 32));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 1243, 10));

        txtberat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtberatActionPerformed(evt);
            }
        });
        add(txtberat, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, 155, -1));

        txtdimensi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdimensiActionPerformed(evt);
            }
        });
        add(txtdimensi, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, 155, -1));

        txtram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtramActionPerformed(evt);
            }
        });
        add(txtram, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 190, 155, -1));

        txtmemori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmemoriActionPerformed(evt);
            }
        });
        add(txtmemori, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 230, 155, -1));

        txtkamera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtkameraActionPerformed(evt);
            }
        });
        add(txtkamera, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 340, 155, -1));

        txtketahanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtketahananActionPerformed(evt);
            }
        });
        add(txtketahanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 190, 155, -1));

        txtbaterai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbateraiActionPerformed(evt);
            }
        });
        add(txtbaterai, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 150, 155, -1));

        txtlayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtlayarActionPerformed(evt);
            }
        });
        add(txtlayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 380, 155, -1));

        txtprocesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtprocesorActionPerformed(evt);
            }
        });
        add(txtprocesor, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 150, 155, -1));

        txtsistem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsistemActionPerformed(evt);
            }
        });
        add(txtsistem, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 300, 155, -1));

        txtbluetooth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbluetoothActionPerformed(evt);
            }
        });
        add(txtbluetooth, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 340, 155, -1));

        txtkapasitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtkapasitasActionPerformed(evt);
            }
        });
        add(txtkapasitas, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 230, 155, -1));

        txtkonsumsidaya.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtkonsumsidayaActionPerformed(evt);
            }
        });
        add(txtkonsumsidaya, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 270, 155, -1));

        jLabel52.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel52.setText("Supplier");
        add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 370, 107, 32));
        add(txtsupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 380, 155, -1));

        jLabel34.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel34.setText("Merek");
        add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, 32));

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1243, 10));

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
        tabelbarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelbarangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelbarang);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 500, 970, 280));
    }// </editor-fold>//GEN-END:initComponents

    private void txtkodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtkodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtkodeActionPerformed

    private void txtmerekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmerekActionPerformed
    txtdetail.grabFocus();
    }//GEN-LAST:event_txtmerekActionPerformed

    private void cbjenisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbjenisActionPerformed
        btnsimpan.setEnabled(true);
        btnedit.setEnabled(false);
        btnhapus.setEnabled(false);
       
        tampil_tabel();
        combo();
        kosongkan_form();
        txtmerek.grabFocus();
    }//GEN-LAST:event_cbjenisActionPerformed

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
        try{
            String sql = "INSERT INTO barang VALUES ('"+txtkode.getText()+"','"+cbjenis.getSelectedItem()+"','"+txtmerek.getText()+"','"+txtdetail.getText()+"','"+txtharga.getText()+"','"
                    +txtberat.getText()+"','"+txtdimensi.getText()+"','"+txtwarna.getText()+"','"
                    +txtprocesor.getText()+"','"+txtram.getText()+"','"+txtmemori.getText()+"','"
                    +txtsistem.getText()+"','"+txtkamera.getText()+"','"+txtlayar.getText()+"','"
                    +txtbaterai.getText()+"','"+txtketahanan.getText()+"','"+txtkapasitas.getText()+"','"+txtkonsumsidaya.getText()+"','"
                    +txtbluetooth.getText()+"','"+txtsupplier.getText()+"')";
            java.sql.Connection conn = (Connection)koneksi.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Simpan Data Berhasil...");
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        tampil_tabel();
        kosongkan_form();
        otomatis();
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        try{
            String sql = "UPDATE barang SET kode_brg='"+txtkode.getText()+"',jenis_brg='"+cbjenis.getSelectedItem()+"',merek='"+txtmerek.getText()+"',detail='"+txtdetail.getText()
                    +"',harga='"+txtharga.getText()+"',berat='"+txtberat.getText()+"',dimensi='"+txtdimensi.getText()+"',warna='"+txtwarna.getText()
                    +"',processor='"+txtprocesor.getText()+"',ram='"+txtram.getText()+"',memori='"+txtmemori.getText()+"',sistem_operasi='"+txtsistem.getText()
                    +"',kualitas_kamera='"+txtkamera.getText()+"',ukuran_layar='"+txtlayar.getText()+"',baterai='"+txtbaterai.getText()+"',ketahanan_baterai='"+txtketahanan.getText()
                    +"',kapasitas='"+txtkapasitas.getText()+"',konsumsi_daya='"+txtkonsumsidaya.getText()+"',versi_bluetooth='"+txtbluetooth.getText()+"',supplier='"+txtsupplier.getText()+"' WHERE kode_brg = '"+txtkode.getText()+"'";
            java.sql.Connection conn = (Connection)koneksi.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Edit Data Berhasil...");
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        tampil_tabel();
        kosongkan_form();
        
        btnsimpan.setEnabled(true);
        btnedit.setEnabled(false);
        btnhapus.setEnabled(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_btneditActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        try{
            String sql = "DELETE FROM barang WHERE kode_brg='"+txtkode.getText()+"'";
            java.sql.Connection conn = (Connection)koneksi.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Hapus Data Berhasil...");
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        
        kosongkan_form();
        btnsimpan.setEnabled(true);
        btnedit.setEnabled(false);
        btnhapus.setEnabled(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnhapusActionPerformed

    private void txthargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthargaActionPerformed
        txtberat.grabFocus();
    }//GEN-LAST:event_txthargaActionPerformed

    private void txtdetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdetailActionPerformed
        txtharga.grabFocus();
    }//GEN-LAST:event_txtdetailActionPerformed

    private void txtwarnaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtwarnaActionPerformed
        jenis_barang = String.valueOf(cbjenis.getSelectedItem());

        if (jenis_barang == "Handphone"){
            txtprocesor.grabFocus();
        }else if (jenis_barang == "Laptop"){
            txtprocesor.grabFocus();
        }else if (jenis_barang == "TV"){
            txtlayar.grabFocus();
        }else if (jenis_barang == "Speaker Bluetooth"){
            txtbaterai.grabFocus();
        }else if (jenis_barang == "Kipas Angin"){
            txtkonsumsidaya.grabFocus();
        }else if (jenis_barang == "AC"){
            txtkonsumsidaya.grabFocus();
        }else if (jenis_barang == "Kulkas 2 Pintu"){
            txtkapasitas.grabFocus();
        }else if (jenis_barang == "Microwave"){
            txtkapasitas.grabFocus();
        }else if (jenis_barang == "Dispanser"){
            txtkapasitas.grabFocus();
        }else if (jenis_barang == "Mesin Cuci"){
            txtkapasitas.grabFocus();
        }else if (jenis_barang == "Magic Com"){
            txtkapasitas.grabFocus();
        }
        
    }//GEN-LAST:event_txtwarnaActionPerformed

    private void txtberatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtberatActionPerformed
        txtdimensi.grabFocus();
    }//GEN-LAST:event_txtberatActionPerformed

    private void txtdimensiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdimensiActionPerformed
        txtwarna.grabFocus();
    }//GEN-LAST:event_txtdimensiActionPerformed

    private void txtprocesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtprocesorActionPerformed
        txtram.grabFocus();
    }//GEN-LAST:event_txtprocesorActionPerformed

    private void txtramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtramActionPerformed
        txtmemori.grabFocus();
    }//GEN-LAST:event_txtramActionPerformed

    private void txtmemoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmemoriActionPerformed
        jenis_barang = String.valueOf(cbjenis.getSelectedItem());

        if (jenis_barang == "Handphone"){
            txtkamera.grabFocus();
        }else if (jenis_barang == "Laptop"){
            txtsistem.grabFocus();
        }
    }//GEN-LAST:event_txtmemoriActionPerformed

    private void txtsistemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsistemActionPerformed
        txtkamera.grabFocus();
    }//GEN-LAST:event_txtsistemActionPerformed

    private void txtkameraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtkameraActionPerformed
        txtlayar.grabFocus();
    }//GEN-LAST:event_txtkameraActionPerformed

    private void txtlayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtlayarActionPerformed
        jenis_barang = String.valueOf(cbjenis.getSelectedItem());

        if (jenis_barang == "Handphone"){
            txtbaterai.grabFocus();
        }else if (jenis_barang == "Laptop"){
            txtbaterai.grabFocus();
        }else if (jenis_barang == "TV"){
            txtkonsumsidaya.grabFocus();
        }
    }//GEN-LAST:event_txtlayarActionPerformed

    private void txtbateraiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbateraiActionPerformed
        txtketahanan.grabFocus();
    }//GEN-LAST:event_txtbateraiActionPerformed

    private void txtketahananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtketahananActionPerformed
        jenis_barang = String.valueOf(cbjenis.getSelectedItem());

        if (jenis_barang == "Handphone"){
            txtsupplier.grabFocus();
        }else if (jenis_barang == "Laptop"){
            txtsupplier.grabFocus();
        }else if (jenis_barang == "Speaker Bluetooth"){
            txtbluetooth.grabFocus();
        }
    }//GEN-LAST:event_txtketahananActionPerformed

    private void txtkapasitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtkapasitasActionPerformed
        txtkonsumsidaya.grabFocus();
    }//GEN-LAST:event_txtkapasitasActionPerformed

    private void txtkonsumsidayaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtkonsumsidayaActionPerformed
        txtsupplier.grabFocus();
    }//GEN-LAST:event_txtkonsumsidayaActionPerformed

    private void txtbluetoothActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbluetoothActionPerformed
        txtsupplier.grabFocus();
    }//GEN-LAST:event_txtbluetoothActionPerformed

    
    private void tabelbarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelbarangMouseClicked
        int baris = tabelbarang.rowAtPoint(evt.getPoint());
        
        btnsimpan.setEnabled(false);
        btnedit.setEnabled(true);
        btnhapus.setEnabled(true);
        
            String kode = tabelbarang.getValueAt(baris, 1).toString();
            txtkode.setText(kode);

            String merek = tabelbarang.getValueAt(baris, 3).toString();
            txtmerek.setText(merek);
            
            String detail = tabelbarang.getValueAt(baris, 4).toString();
            txtdetail.setText(detail);
            
            String berat = tabelbarang.getValueAt(baris, 5).toString();
            txtberat.setText(berat);
            
            String dimensi = tabelbarang.getValueAt(baris, 6).toString();
            txtdimensi.setText(dimensi);
        
        jenis_barang = String.valueOf(cbjenis.getSelectedItem());

        if (jenis_barang == "Handphone"){
            
            String processor = tabelbarang.getValueAt(baris, 7).toString();
            txtprocesor.setText(processor);
            
            String ram = tabelbarang.getValueAt(baris, 8).toString();
            txtram.setText(ram);
            
            String memori = tabelbarang.getValueAt(baris, 9).toString();
            txtmemori.setText(memori);
            
            String kamera = tabelbarang.getValueAt(baris, 10).toString();
            txtkamera.setText(kamera);
            
            String layar = tabelbarang.getValueAt(baris, 11).toString();
            txtlayar.setText(layar);
            
            String baterai = tabelbarang.getValueAt(baris, 12).toString();
            txtbaterai.setText(baterai);
            
            String tahan = tabelbarang.getValueAt(baris, 13).toString();
            txtketahanan.setText(tahan);
            
            String warna = tabelbarang.getValueAt(baris, 14).toString();
            txtwarna.setText(warna);
            
            String harga = tabelbarang.getValueAt(baris, 15).toString();
            txtharga.setText(harga);
            
            String spp = tabelbarang.getValueAt(baris, 16).toString();
            txtsupplier.setText(spp);
            
        }else if (jenis_barang == "Laptop"){
            
            String processor = tabelbarang.getValueAt(baris, 7).toString();
            txtprocesor.setText(processor);
            
            String ram = tabelbarang.getValueAt(baris, 8).toString();
            txtram.setText(ram);
            
            String memori = tabelbarang.getValueAt(baris, 9).toString();
            txtmemori.setText(memori);
            
            String sistem = tabelbarang.getValueAt(baris, 10).toString();
            txtsistem.setText(sistem);
            
            String kamera = tabelbarang.getValueAt(baris, 11).toString();
            txtkamera.setText(kamera);
            
            String layar = tabelbarang.getValueAt(baris, 12).toString();
            txtlayar.setText(layar);
            
            String baterai = tabelbarang.getValueAt(baris, 13).toString();
            txtbaterai.setText(baterai);
            
            String ketahanan = tabelbarang.getValueAt(baris, 14).toString();
            txtketahanan.setText(ketahanan);
           
            String warna = tabelbarang.getValueAt(baris, 15).toString();
            txtwarna.setText(warna);
            
            String harga = tabelbarang.getValueAt(baris, 16).toString();
            txtharga.setText(harga);
 
            String spp = tabelbarang.getValueAt(baris, 17).toString();
            txtsupplier.setText(spp);
            
        }else if (jenis_barang == "TV"){
            String layar = tabelbarang.getValueAt(baris, 7).toString();
            txtlayar.setText(layar);
            
            String konsumsi = tabelbarang.getValueAt(baris, 8).toString();
            txtkonsumsidaya.setText(konsumsi);
            
            String warna = tabelbarang.getValueAt(baris, 9).toString();
            txtwarna.setText(warna);
            
            String hrg = tabelbarang.getValueAt(baris, 10).toString();
            txtharga.setText(hrg);
            
            String sup = tabelbarang.getValueAt(baris, 11).toString();
            txtsupplier.setText(sup);
            
        }else if (jenis_barang == "Speaker Bluetooth"){
            String baterai = tabelbarang.getValueAt(baris, 7).toString();
            txtbaterai.setText(baterai);
            
            String tahan = tabelbarang.getValueAt(baris, 8).toString();
            txtketahanan.setText(tahan);
            
            String versi = tabelbarang.getValueAt(baris, 9).toString();
            txtbluetooth.setText(versi);
            
            String warna = tabelbarang.getValueAt(baris, 10).toString();
            txtwarna.setText(warna);
            
            String hrg = tabelbarang.getValueAt(baris, 11).toString();
            txtharga.setText(hrg);
            
            String sup = tabelbarang.getValueAt(baris, 12).toString();
            txtsupplier.setText(sup);
            
        }else if (jenis_barang == "Kipas Angin"){
            String konsumsi = tabelbarang.getValueAt(baris, 7).toString();
            txtkonsumsidaya.setText(konsumsi);
            
            String warna = tabelbarang.getValueAt(baris, 8).toString();
            txtwarna.setText(warna);
            
            String hrg = tabelbarang.getValueAt(baris, 9).toString();
            txtharga.setText(hrg);
            
            String sup = tabelbarang.getValueAt(baris, 10).toString();
            txtsupplier.setText(sup);
            
        }else if (jenis_barang == "AC"){
            String konsumsi = tabelbarang.getValueAt(baris, 7).toString();
            txtkonsumsidaya.setText(konsumsi);
            
            String warna = tabelbarang.getValueAt(baris, 8).toString();
            txtwarna.setText(warna);
            
            String hrg = tabelbarang.getValueAt(baris, 9).toString();
            txtharga.setText(hrg);
            
            String sup = tabelbarang.getValueAt(baris, 10).toString();
            txtsupplier.setText(sup);
            
        }else if (jenis_barang == "Kulkas 2 Pintu"){
            String kapasitas = tabelbarang.getValueAt(baris, 7).toString();
            txtkapasitas.setText(kapasitas);
            
            String konsumsi = tabelbarang.getValueAt(baris, 8).toString();
            txtkonsumsidaya.setText(konsumsi);
            
            String warna = tabelbarang.getValueAt(baris, 9).toString();
            txtwarna.setText(warna);
            
            String hrg = tabelbarang.getValueAt(baris, 10).toString();
            txtharga.setText(hrg);
            
            String sup = tabelbarang.getValueAt(baris, 11).toString();
            txtsupplier.setText(sup);
            
        }else if (jenis_barang == "Microwave"){
            String kapasitas = tabelbarang.getValueAt(baris, 7).toString();
            txtkapasitas.setText(kapasitas);
            
            String konsumsi = tabelbarang.getValueAt(baris, 8).toString();
            txtkonsumsidaya.setText(konsumsi);
            
            String warna = tabelbarang.getValueAt(baris, 9).toString();
            txtwarna.setText(warna);
            
            String hrg = tabelbarang.getValueAt(baris, 10).toString();
            txtharga.setText(hrg);
            
            String sup = tabelbarang.getValueAt(baris, 11).toString();
            txtsupplier.setText(sup);
            
        }else if (jenis_barang == "Dispanser"){
            String kapasitas = tabelbarang.getValueAt(baris, 7).toString();
            txtkapasitas.setText(kapasitas);
            
            String konsumsi = tabelbarang.getValueAt(baris, 8).toString();
            txtkonsumsidaya.setText(konsumsi);
            
            String warna = tabelbarang.getValueAt(baris, 9).toString();
            txtwarna.setText(warna);
            
            String hrg = tabelbarang.getValueAt(baris, 10).toString();
            txtharga.setText(hrg);
            
            String sup = tabelbarang.getValueAt(baris, 11).toString();
            txtsupplier.setText(sup);
            
        }else if (jenis_barang == "Mesin Cuci"){
            String kapasitas = tabelbarang.getValueAt(baris, 7).toString();
            txtkapasitas.setText(kapasitas);
            
            String konsumsi = tabelbarang.getValueAt(baris, 8).toString();
            txtkonsumsidaya.setText(konsumsi);
            
            String warna = tabelbarang.getValueAt(baris, 9).toString();
            txtwarna.setText(warna);
            
            String hrg = tabelbarang.getValueAt(baris, 10).toString();
            txtharga.setText(hrg);
            
            String sup = tabelbarang.getValueAt(baris, 11).toString();
            txtsupplier.setText(sup);
        }else if (jenis_barang == "Magic Com"){
            String kapasitas = tabelbarang.getValueAt(baris, 7).toString();
            txtkapasitas.setText(kapasitas);
            
            String konsumsi = tabelbarang.getValueAt(baris, 8).toString();
            txtkonsumsidaya.setText(konsumsi);
            
            String warna = tabelbarang.getValueAt(baris, 9).toString();
            txtwarna.setText(warna);
            
            String hrg = tabelbarang.getValueAt(baris, 10).toString();
            txtharga.setText(hrg);
            
            String sup = tabelbarang.getValueAt(baris, 11).toString();
            txtsupplier.setText(sup);
        }
        

    }//GEN-LAST:event_tabelbarangMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JComboBox<String> cbjenis;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tabelbarang;
    private javax.swing.JTextField txtbaterai;
    private javax.swing.JTextField txtberat;
    private javax.swing.JTextField txtbluetooth;
    private javax.swing.JTextField txtdetail;
    private javax.swing.JTextField txtdimensi;
    private javax.swing.JTextField txtharga;
    private javax.swing.JTextField txtkamera;
    private javax.swing.JTextField txtkapasitas;
    private javax.swing.JTextField txtketahanan;
    private javax.swing.JTextField txtkode;
    private javax.swing.JTextField txtkonsumsidaya;
    private javax.swing.JTextField txtlayar;
    private javax.swing.JTextField txtmemori;
    private javax.swing.JTextField txtmerek;
    private javax.swing.JTextField txtprocesor;
    private javax.swing.JTextField txtram;
    private javax.swing.JTextField txtsistem;
    private javax.swing.JTextField txtsupplier;
    private javax.swing.JTextField txtwarna;
    // End of variables declaration//GEN-END:variables
}
