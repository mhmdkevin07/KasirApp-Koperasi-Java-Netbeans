/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form_main;


import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.HeadlessException;
import java.sql.Connection;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import com.sun.glass.events.KeyEvent;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Asus
 */
public class form_pengajuan extends javax.swing.JPanel {

    private String lama_cicilan,keterangan,kodebayar5,kodekredit5;
    private int diskon,diskon_next,hasil, nominal, harga,sisa,sisa2,uang_muka,cicilan,jumlah_unit
            ,total_bayar,bunga,angsuran,total,angsuran_tlh_byr,angsuran_next,pembayaran;  
    
    ResultSet rsanggota=null;
    ResultSet rsbarang=null;
    ResultSet rskredit=null;
    ResultSet rstunai=null;
    
    NumberFormat nf = NumberFormat.getNumberInstance(new Locale("in","ID"));
    
    /**
     * Creates new form form_pengajuan
     */
    public form_pengajuan() {
        initComponents();
        tampil_tenor();
        kosongkan_form();
        otomatis();
        
        setTanggal();
        
        btndiskon.setEnabled(false);
        btnsimpan.setEnabled(true);
        btnhapus.setEnabled(false);
        btncetak.setEnabled(false);
        btncek4.setEnabled(false);
        
        txtdiskon.setEnabled(false);
        txthasil.setEnabled(false);
        txtnominal.setEnabled(false);
        
        diskon = 0;
        txtdiskon.setText(String.valueOf(diskon));
       
        
    }
    
     public void setTanggal(){
      java.util.Date tgl = new java.util.Date();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        tanggall.setText(format.format(tgl));
    }
     
     public void otomatis(){
        
        try{
            Connection conn = (Connection)koneksi.configDB();
            Statement stt = conn.createStatement();
            ResultSet rs = stt.executeQuery("Select Max(Right(kode_kredit,4)) as no from tenor");
            
            
            while (rs.next()) {
                if (rs.first() == false) {
                    txtkodekredit4.setText("KPK-0001");
                } else {
                    rs.last();
                    int auto_id = rs.getInt(1) + 1;
                    String no = String.valueOf(auto_id);
                    int NomorJual = no.length();
                    //MENGATUR jumlah 0
                    for (int j = 0; j < 4 - NomorJual; j++) {
                        no = "0" + no;
                    }
                    txtkodekredit4.setText("KPK-" + no);
                }
            }
            rs.close();
            stt.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "ERROR: \n" + e.toString(),
                    "Kesalahan", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private void tampil_tenor(){
          
           DefaultTableModel model = new DefaultTableModel();
           model.addColumn("No. ");
           model.addColumn("Kode Kredit. ");
           model.addColumn("Kode Anggota. ");
           model.addColumn("Kode Barang. ");
           model.addColumn("Waktu Angsur. ");
           model.addColumn("Uang Muka. ");
           model.addColumn("Tanggal. ");
           model.addColumn("Keterangan. ");
           model.addColumn("Total Kredeit. ");
           model.addColumn("Sisa. ");
           model.addColumn("Diskon. ");
           model.addColumn("Bunga. ");
           model.addColumn("Cicilan. ");
           model.addColumn("Angsuran. ");
           
           try{
            int no = 1;
            String sql = "SELECT * FROM tenor";
            java.sql.Connection conn = (Connection)koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            
            while(res.next()){
                model.addRow(new Object[]{no++,res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7),res.getString(8),res.getString(9),res.getString(10),res.getString(11),res.getString(12),res.getString(13)}); 
            
            tabeltenor.setModel(model); 
            }
                
           }catch (SQLException e){
               System.out.println("Error :"+ e.getMessage());
           }
       }
    
   
    
  
    private void kosongkan_form(){
        
        //form tenor
        txtkodeanggota4.setText(null);
        txtnama4.setText(null);
        txtkodebarang4.setText(null);
        txtjenisbarang4.setText(null);
        txtmerek4.setText(null);
        txtharga4.setText(null);
        cbcicilan4.setSelectedItem(this);
        txtuangmuka4.setText(null);
        txtketerangan4.setText(null);
        txtsisa4.setText(null);
        txtcicilan4.setText(null);
        txtangsuran4.setText(null);
        txtjabatan.setText(null);
        txtdivisi.setText(null);
        txtwarna.setText(null);
        txtnamabrg.setText(null);
        txtbunga.setText(null);
        txttotal.setText(null);
        txtdiskon.setText(null);
        txthasil.setText(null);
        txtnominal.setText(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtkodeanggota4 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        txtkodebarang4 = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        txtmerek4 = new javax.swing.JTextField();
        txtjenisbarang4 = new javax.swing.JTextField();
        txtnama4 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtharga4 = new javax.swing.JTextField();
        txtwarna = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtnamabrg = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtjabatan = new javax.swing.JTextField();
        txtdivisi = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        txtuangmuka4 = new javax.swing.JTextField();
        cbcicilan4 = new javax.swing.JComboBox<>();
        btncek4 = new javax.swing.JButton();
        jLabel70 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        txtketerangan4 = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        txtsisa4 = new javax.swing.JTextField();
        txtcicilan4 = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        txtangsuran4 = new javax.swing.JTextField();
        txtbunga = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        txttotal = new javax.swing.JTextField();
        btnsimpan = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabeltenor = new javax.swing.JTable();
        jLabel47 = new javax.swing.JLabel();
        txtkodekredit4 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        tanggall = new javax.swing.JLabel();
        btncetak = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        txtnominal = new javax.swing.JTextField();
        txtdiskon = new javax.swing.JTextField();
        jLabel72 = new javax.swing.JLabel();
        txthasil = new javax.swing.JTextField();
        btndiskon = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 255, 204));

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));

        jLabel36.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel36.setText("DATA ANGGOTA");

        jLabel16.setText("Kode Anggota");

        txtkodeanggota4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtkodeanggota4ActionPerformed(evt);
            }
        });
        txtkodeanggota4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtkodeanggota4KeyPressed(evt);
            }
        });

        jLabel17.setText("Nama");

        jLabel37.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel37.setText("DATA BARANG");

        jLabel18.setText("Kode Barang");

        jLabel38.setText("Jenis Barang");

        txtkodebarang4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtkodebarang4ActionPerformed(evt);
            }
        });
        txtkodebarang4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtkodebarang4KeyPressed(evt);
            }
        });

        jLabel39.setText("Merek");

        txtmerek4.setEditable(false);
        txtmerek4.setBackground(new java.awt.Color(204, 204, 204));
        txtmerek4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtmerek4KeyPressed(evt);
            }
        });

        txtjenisbarang4.setEditable(false);
        txtjenisbarang4.setBackground(new java.awt.Color(204, 204, 204));

        txtnama4.setEditable(false);
        txtnama4.setBackground(new java.awt.Color(204, 204, 204));
        txtnama4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnama4ActionPerformed(evt);
            }
        });

        jLabel14.setText("Harga");

        txtharga4.setEditable(false);
        txtharga4.setBackground(new java.awt.Color(204, 204, 204));
        txtharga4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtharga4KeyPressed(evt);
            }
        });

        txtwarna.setEditable(false);
        txtwarna.setBackground(new java.awt.Color(204, 204, 204));
        txtwarna.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtwarnaKeyPressed(evt);
            }
        });

        jLabel19.setText("Warna");

        txtnamabrg.setEditable(false);
        txtnamabrg.setBackground(new java.awt.Color(204, 204, 204));
        txtnamabrg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnamabrgKeyPressed(evt);
            }
        });

        jLabel20.setText("Type");

        jLabel21.setText("Jabatan");

        txtjabatan.setEditable(false);
        txtjabatan.setBackground(new java.awt.Color(204, 204, 204));
        txtjabatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtjabatanActionPerformed(evt);
            }
        });

        txtdivisi.setEditable(false);
        txtdivisi.setBackground(new java.awt.Color(204, 204, 204));
        txtdivisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdivisiActionPerformed(evt);
            }
        });

        jLabel22.setText("Divisi");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel38)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtjenisbarang4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                .addComponent(txtkodebarang4, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel39)
                                .addComponent(txtmerek4)
                                .addComponent(txtnamabrg, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel20))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(txtwarna, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtharga4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(114, 114, 114)
                        .addComponent(jLabel14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel16)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addComponent(txtkodeanggota4)
                                .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtnama4))
                            .addComponent(jLabel17))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel22)
                            .addComponent(jLabel21)
                            .addComponent(txtjabatan, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                            .addComponent(txtdivisi))))
                .addGap(22, 22, 22))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(41, 41, 41))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtkodeanggota4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtjabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(30, 30, 30))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtnama4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdivisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(27, 27, 27)
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel39)
                            .addComponent(jLabel18))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtkodebarang4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtharga4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtmerek4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel38)
                            .addComponent(jLabel20)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtnamabrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtwarna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtjenisbarang4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(44, 44, 44))
        );

        jLabel35.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel35.setText("DATA PENGAJUAN KREDIT");

        jPanel3.setBackground(new java.awt.Color(255, 255, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));

        jLabel40.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel40.setText("PILIH TENOR");

        jLabel41.setText("Cicilan");

        jLabel42.setText("Uang Muka");

        cbcicilan4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "3", "6", "12", " " }));
        cbcicilan4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbcicilan4ActionPerformed(evt);
            }
        });

        btncek4.setText("Cek >>");
        btncek4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncek4ActionPerformed(evt);
            }
        });

        jLabel70.setText("BULAN");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel42)
                            .addComponent(jLabel41))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btncek4)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtuangmuka4, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbcicilan4, 0, 110, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel70)))))
                .addGap(32, 32, 32))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(cbcicilan4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel70))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(txtuangmuka4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btncek4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));

        jLabel44.setText("Keterangan");

        txtketerangan4.setEditable(false);
        txtketerangan4.setBackground(new java.awt.Color(204, 204, 204));
        txtketerangan4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtketerangan4ActionPerformed(evt);
            }
        });

        jLabel46.setText("Sisa");

        txtsisa4.setEditable(false);
        txtsisa4.setBackground(new java.awt.Color(204, 204, 204));
        txtsisa4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsisa4ActionPerformed(evt);
            }
        });

        txtcicilan4.setEditable(false);
        txtcicilan4.setBackground(new java.awt.Color(204, 204, 204));
        txtcicilan4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcicilan4ActionPerformed(evt);
            }
        });

        jLabel43.setText("Cicilan /Bulan");

        jLabel45.setText("Angsuran");

        txtangsuran4.setEditable(false);
        txtangsuran4.setBackground(new java.awt.Color(204, 204, 204));
        txtangsuran4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtangsuran4ActionPerformed(evt);
            }
        });

        txtbunga.setEditable(false);
        txtbunga.setBackground(new java.awt.Color(204, 204, 204));
        txtbunga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbungaActionPerformed(evt);
            }
        });

        jLabel48.setText("Bunga");

        jLabel49.setText("Total Kredit");

        txttotal.setEditable(false);
        txttotal.setBackground(new java.awt.Color(204, 204, 204));
        txttotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttotalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel46)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtketerangan4, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                        .addComponent(txtsisa4)
                        .addComponent(txtcicilan4)
                        .addComponent(txtangsuran4)
                        .addComponent(txtbunga)
                        .addComponent(jLabel48)
                        .addComponent(jLabel44)
                        .addComponent(jLabel49)
                        .addComponent(jLabel43)
                        .addComponent(jLabel45)
                        .addComponent(txttotal)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel44)
                .addGap(5, 5, 5)
                .addComponent(txtketerangan4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel49)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel46)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtsisa4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel48)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtbunga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel43)
                .addGap(5, 5, 5)
                .addComponent(txtcicilan4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel45)
                .addGap(5, 5, 5)
                .addComponent(txtangsuran4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnsimpan.setText("SIMPAN");
        btnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanActionPerformed(evt);
            }
        });

        btnhapus.setText("HAPUS");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });

        tabeltenor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "KODE KREDIT", "KODE ANGGOTA", "TANGGAL", "KODE BARANG", "LAMA ANGSURAN", "UANG MUKA", "SISA", "CICILAN", "KETERANGAN"
            }
        ));
        tabeltenor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabeltenorMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tabeltenor);

        jLabel47.setText("Kode Kredit");

        txtkodekredit4.setEditable(false);
        txtkodekredit4.setBackground(new java.awt.Color(204, 255, 204));
        txtkodekredit4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtkodekredit4ActionPerformed(evt);
            }
        });

        jLabel15.setText("Tanggal Kredit");

        tanggall.setText("jLabel1");

        btncetak.setText("CETAK");
        btncetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncetakActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(255, 255, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));

        jLabel50.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel50.setText("TAMBAHKAN DISKON");

        jLabel51.setText("Diskon");

        jLabel52.setText("Hasil Diskon");

        txtnominal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnominalActionPerformed(evt);
            }
        });

        txtdiskon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdiskonActionPerformed(evt);
            }
        });

        jLabel72.setText("%    RP.");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel52)
                            .addComponent(jLabel51))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(txtdiskon, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel72)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtnominal, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txthasil))
                        .addGap(0, 10, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(txtdiskon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel72)
                    .addComponent(txtnominal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(txthasil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btndiskon.setText("TAMBAH DISKON");
        btndiskon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndiskonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel47)
                                .addGap(18, 18, 18)
                                .addComponent(txtkodekredit4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btndiskon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(btncetak, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(18, 18, 18)
                                .addComponent(tanggall, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane5))
                .addContainerGap(270, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tanggall)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel47))
                            .addComponent(txtkodekredit4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(btndiskon)
                                .addGap(6, 6, 6)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btncetak, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(24, 24, 24)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtkodeanggota4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtkodeanggota4ActionPerformed
        txtkodebarang4.grabFocus();
    }//GEN-LAST:event_txtkodeanggota4ActionPerformed

    private void tampildataanggota(String key) {try{
   // Statement stt=Connection.createStatement();
   Connection conn=(Connection)koneksi.configDB();
            Statement stt=conn.createStatement();
           rsanggota=stt.executeQuery("SELECT * from anggota WHERE kode_agt LIKE '%"+key+"%'");  
            if(rsanggota.next()){
                
                   
        String nama = rsanggota.getString("nama_agt");
        txtnama4.setText(nama);
        
        String jabatan = rsanggota.getString("jabatan_agt");
        txtjabatan.setText(jabatan);
        
        String divisi = rsanggota.getString("divisi");
        txtdivisi.setText(divisi);
        
            }
            else{
                JOptionPane.showMessageDialog(null, "Data Tidak Ada");
            }
    }catch (Exception ex) {
        System.err.println(ex.getMessage());
        }
    }
    
    private void txtkodeanggota4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtkodeanggota4KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            String key=txtkodeanggota4.getText();
            System.out.println(key);

            if(key!=""){
                tampildataanggota(key);
            }else{
                JOptionPane.showMessageDialog(null, "Data Tidak Ada");
            }
        }
    }//GEN-LAST:event_txtkodeanggota4KeyPressed

    private void txtkodebarang4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtkodebarang4ActionPerformed
        cbcicilan4.grabFocus();
        btncek4.setEnabled(true);
    }//GEN-LAST:event_txtkodebarang4ActionPerformed

    
    private void tampildatabarang(String key) {try{
       // Statement stt=Connection.createStatement();
    Connection conn=(Connection)koneksi.configDB();
            Statement stt=conn.createStatement();
           rsbarang=stt.executeQuery("SELECT * from barang WHERE kode_brg LIKE '%"+key+"%'");  
            if(rsbarang.next()){
                
                   
        String jenisbarang_tenor = rsbarang.getString("jenis_brg");
        txtjenisbarang4.setText(jenisbarang_tenor);
        
        String merekbarang_tenor = rsbarang.getString("merek");
        txtmerek4.setText(merekbarang_tenor);
        
        String nama = rsbarang.getString("nama");
        txtnamabrg.setText(nama);
        
        Integer hargabarang_tenor = rsbarang.getInt("harga");
        txtharga4.setText(nf.format(hargabarang_tenor));
        
        String warna = rsbarang.getString("warna");
        txtwarna.setText(warna);
            }
            else{
                JOptionPane.showMessageDialog(null, "Data Tidak Ada");
            }
    }catch (Exception ex) {
        System.err.println(ex.getMessage());
        }
    }
     
    
    
    
     
     
    private void txtkodebarang4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtkodebarang4KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            String key=txtkodebarang4.getText();
            System.out.println(key);

            if(key!=""){
                tampildatabarang(key);
                
            }else{
                JOptionPane.showMessageDialog(null, "Data Tidak Ada");
            }
        }
    }//GEN-LAST:event_txtkodebarang4KeyPressed

    private void txtmerek4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmerek4KeyPressed

    }//GEN-LAST:event_txtmerek4KeyPressed

    private void txtnama4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnama4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnama4ActionPerformed

    private void txtharga4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtharga4KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtharga4KeyPressed

    private void btncek4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncek4ActionPerformed
        // TODO add your handling code here:
        harga = Integer.parseInt(txtharga4.getText().replace(".", ""));
        uang_muka = Integer.parseInt(txtuangmuka4.getText());
        
        bunga = harga*20/100;
        total = harga+bunga;
        sisa = total-uang_muka;
        
        txtsisa4.setText(nf.format(sisa));
        angsuran = 0;
        txtangsuran4.setText(String.valueOf(angsuran));
        txtbunga.setText(nf.format(bunga));
        txttotal.setText(nf.format(total));

        /////

        lama_cicilan = String.valueOf(cbcicilan4.getSelectedItem());

        if (lama_cicilan == "3"){
            cicilan = sisa/3;
        }else if (lama_cicilan == "6"){
            cicilan = sisa/6;
        }else if (lama_cicilan == "12"){
            cicilan = sisa/12;
        }

        txtcicilan4.setText(nf.format(cicilan));

        //////
        if (sisa >= 100) {
            keterangan = "Belum Lunas";
        }else{
            keterangan = "Lunas";
        }
txtketerangan4.setText(keterangan);
        
        btndiskon.setEnabled(true);
        btnsimpan.setEnabled(true);
        btnhapus.setEnabled(false);
        btncetak.setEnabled(false);

    }//GEN-LAST:event_btncek4ActionPerformed

    private void txtketerangan4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtketerangan4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtketerangan4ActionPerformed

    private void txtsisa4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsisa4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsisa4ActionPerformed

    private void txtcicilan4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcicilan4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcicilan4ActionPerformed

    private void txtangsuran4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtangsuran4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtangsuran4ActionPerformed

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
        // TODO add your handling code here:
        
        String tampilan ="dd-MM-yyyy";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);

        bunga = Integer.parseInt(txtbunga.getText().replace(".", ""));
        cicilan = Integer.parseInt(txtcicilan4.getText().replace(".", ""));
        diskon = Integer.parseInt(txtdiskon.getText());
        uang_muka = Integer.parseInt(txtuangmuka4.getText());
        
        if(diskon > 0){
            total = Integer.parseInt(txthasil.getText().replace(".", ""));
            sisa = total - uang_muka;
        }else if(diskon <= 0){
            total = Integer.parseInt(txttotal.getText().replace(".", ""));
            sisa = Integer.parseInt(txtsisa4.getText().replace(".", ""));
        }
        
           try{
                String sql = "INSERT INTO tenor VALUES ('"+txtkodekredit4.getText()+"','"+txtkodeanggota4.getText()+"','"+txtkodebarang4.getText()+"','"
                        +cbcicilan4.getSelectedItem()+"','"+txtuangmuka4.getText()+"','"+tanggall.getText()+"','"+txtketerangan4.getText()+"','"
                        +total+"','"+sisa+"','"+txtdiskon.getText()+"','"+bunga+"','"+cicilan+"','"+txtangsuran4.getText()+"')";
                java.sql.Connection conn = (Connection)koneksi.configDB();
                java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                pstm.execute();
                JOptionPane.showMessageDialog(null, "Simpan Data Berhasil...");

            }catch(HeadlessException | SQLException e){
                JOptionPane.showMessageDialog(this, e.getMessage());
            
        }
            tampil_tenor();
            kosongkan_form();
            otomatis();
            setTanggal();
        txtdiskon.setEnabled(false);
        txthasil.setEnabled(false);
        txtnominal.setEnabled(false);
        btndiskon.setEnabled(false);
        txtkodeanggota4.grabFocus();
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        try{
            String sql = "DELETE FROM tenor WHERE kode_kredit='"+txtkodekredit4.getText()+"'";
            java.sql.Connection conn = (Connection)koneksi.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Hapus Data Berhasil...");
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        tampil_tenor();
        kosongkan_form();
    }//GEN-LAST:event_btnhapusActionPerformed

    private java.util.Date getTanggalFromTableTenor(JTable tabeltenor, int a) {
        JTable tabel = tabeltenor;
        String str_tgl = String.valueOf(tabel.getValueAt(tabel.getSelectedRow(), a));
        java.util.Date tanggal = null;
        try {
            tanggal = new SimpleDateFormat("dd-MM-yyyy").parse(str_tgl);
        } catch (ParseException ex) {
            Logger.getLogger(form_pengajuan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tanggal;
    }
    
    private void tabeltenorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabeltenorMouseClicked
        // TODO add your handling code here:
        int baris = tabeltenor.rowAtPoint(evt.getPoint());
        String kodekredit = tabeltenor.getValueAt(baris, 1).toString();
        txtkodekredit4.setText(kodekredit);

        ///
        String kodeanggota = tabeltenor.getValueAt(baris, 2).toString();
        txtkodeanggota4.setText(kodeanggota);

        ///
        String kodebarang = tabeltenor.getValueAt(baris, 3).toString();
        txtkodebarang4.setText(kodebarang);

        ///
        String lamacicilan4 = tabeltenor.getValueAt(baris, 4).toString();
        cbcicilan4.setSelectedItem(lamacicilan4);

        String uangmuka4 = tabeltenor.getValueAt(baris, 5).toString();
        txtuangmuka4.setText(uangmuka4);
        
        String tanggal = tabeltenor.getValueAt(baris, 6).toString();
        tanggall.setText(tanggal);

        ///
        String keterangan4 = tabeltenor.getValueAt(baris, 7).toString();
        txtketerangan4.setText(keterangan4);
        
        String total = tabeltenor.getValueAt(baris, 8).toString();
        txttotal.setText(total);

        String hasil = tabeltenor.getValueAt(baris, 8).toString();
        txthasil.setText(hasil);
        
        String sisa4 = tabeltenor.getValueAt(baris, 9).toString();
        txtsisa4.setText(sisa4);
        
        String diskon = tabeltenor.getValueAt(baris, 10).toString();
        txtdiskon.setText(diskon);

        String bunga = tabeltenor.getValueAt(baris, 11).toString();
        txtbunga.setText(bunga);
        
        String cicilan4 = tabeltenor.getValueAt(baris, 12).toString();
        txtcicilan4.setText(cicilan4);

        String angsuran4 = tabeltenor.getValueAt(baris, 13).toString();
        txtangsuran4.setText(angsuran4);
        
        btnsimpan.setEnabled(false);
        btnhapus.setEnabled(true);
        btncetak.setEnabled(true);
    }//GEN-LAST:event_tabeltenorMouseClicked

    private void txtkodekredit4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtkodekredit4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtkodekredit4ActionPerformed

    private void cbcicilan4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbcicilan4ActionPerformed
        txtuangmuka4.grabFocus();
    }//GEN-LAST:event_cbcicilan4ActionPerformed

    private void txtwarnaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtwarnaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtwarnaKeyPressed

    private void txtnamabrgKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnamabrgKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnamabrgKeyPressed

    private void txtjabatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtjabatanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtjabatanActionPerformed

    private void txtdivisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdivisiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdivisiActionPerformed

    private void txtbungaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbungaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbungaActionPerformed

    private void txttotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttotalActionPerformed

    private void btncetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncetakActionPerformed

        if (!tabeltenor.getSelectionModel().isSelectionEmpty()){
            int getRow = tabeltenor.getSelectedRow();
            int modelRow = tabeltenor.convertRowIndexToModel(getRow);
            String getId =tabeltenor.getModel().getValueAt(modelRow, 1).toString();

            try{
                String path="src/report/Bukti_Pengajuan.jasper";
                HashMap parameter = new HashMap();
                java.sql.Connection conn = (Connection)koneksi.configDB();
                parameter.put("kode", getId);
                JasperPrint print = JasperFillManager.fillReport(path, parameter, conn);
                JasperViewer.viewReport(print, false);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"dokumen tidak ada"+e);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Pilih baris data terlebih dahulu!");
        }
    }//GEN-LAST:event_btncetakActionPerformed

    private void btndiskonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndiskonActionPerformed
        txtdiskon.setEnabled(true);
        txthasil.setEnabled(true);
        txtnominal.setEnabled(true);
        
        txtdiskon.setText("");
        txtdiskon.grabFocus();
        
    }//GEN-LAST:event_btndiskonActionPerformed

    private void txtnominalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnominalActionPerformed
        diskon = Integer.parseInt(txtdiskon.getText());
        nominal = Integer.parseInt(txtnominal.getText());
        
        hasil = nominal - (nominal * diskon /100) ;
        
        txthasil.setText(nf.format(hasil));
        txthasil.grabFocus();
    }//GEN-LAST:event_txtnominalActionPerformed

    private void txtdiskonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdiskonActionPerformed
        txtnominal.grabFocus();
    }//GEN-LAST:event_txtdiskonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncek4;
    private javax.swing.JButton btncetak;
    private javax.swing.JButton btndiskon;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JComboBox<String> cbcicilan4;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel35;
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
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable tabeltenor;
    private javax.swing.JLabel tanggall;
    private javax.swing.JTextField txtangsuran4;
    private javax.swing.JTextField txtbunga;
    private javax.swing.JTextField txtcicilan4;
    private javax.swing.JTextField txtdiskon;
    private javax.swing.JTextField txtdivisi;
    private javax.swing.JTextField txtharga4;
    private javax.swing.JTextField txthasil;
    private javax.swing.JTextField txtjabatan;
    private javax.swing.JTextField txtjenisbarang4;
    private javax.swing.JTextField txtketerangan4;
    private javax.swing.JTextField txtkodeanggota4;
    private javax.swing.JTextField txtkodebarang4;
    private javax.swing.JTextField txtkodekredit4;
    private javax.swing.JTextField txtmerek4;
    private javax.swing.JTextField txtnama4;
    private javax.swing.JTextField txtnamabrg;
    private javax.swing.JTextField txtnominal;
    private javax.swing.JTextField txtsisa4;
    private javax.swing.JTextField txttotal;
    private javax.swing.JTextField txtuangmuka4;
    private javax.swing.JTextField txtwarna;
    // End of variables declaration//GEN-END:variables
}
