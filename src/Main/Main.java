/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;




import form_main.Tunai;
import report.laporan;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import menu.MenuItem;
import java.sql.Connection;
import form_main.form_anggota;
import form_main.form_barang;
import form_main.form_bayar_kredit;
import form_main.form_pegawai;
import form_main.form_pengajuan;
import java.awt.event.ActionEvent;


/**
 *
 * @author Asus
 */
public class Main extends javax.swing.JFrame {
    
    
     

    /**
     * Creates new form menu
     */
    public Main() {
    initComponents();
    this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    excute();
    }

    private void excute(){
        //create icon
        ImageIcon iconAdmin= new ImageIcon(getClass().getResource("/menu/user1.png"));
        ImageIcon iconUser= new ImageIcon(getClass().getResource("/menu/user2.png"));
        ImageIcon iconTenor= new ImageIcon(getClass().getResource("/menu/transaksi.png"));
        ImageIcon iconBox= new ImageIcon(getClass().getResource("/menu/box.png"));
        ImageIcon iconPay= new ImageIcon(getClass().getResource("/menu/payment.png"));
        ImageIcon iconSubMenu= new ImageIcon(getClass().getResource("/menu/next15.png"));
        ImageIcon iconLap= new ImageIcon(getClass().getResource("/menu/laporan (2).png"));
        //create submenu
        MenuItem menuKredit=new MenuItem(iconSubMenu,"Pembayaran Kredit",new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
            panelbody.removeAll();
            panelbody.repaint();
            panelbody.revalidate();

            panelbody.add(new form_bayar_kredit());
            panelbody.repaint();
            panelbody.revalidate();
            }
        });
        
        MenuItem menuCash=new MenuItem(iconSubMenu,"Pembelian Tunai",new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            panelbody.removeAll();
            panelbody.repaint();
            panelbody.revalidate();

            panelbody.add(new Tunai());
            panelbody.repaint();
            panelbody.revalidate();
            }      
        });
        
        MenuItem menuAdmin= new MenuItem(iconAdmin,"Pegawai Koperasi",new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            panelbody.removeAll();
            panelbody.repaint();
            panelbody.revalidate();

            panelbody.add(new form_pegawai());
            panelbody.repaint();
            panelbody.revalidate();
            }
        });
        MenuItem menuUser= new MenuItem(iconUser,"Anggota Koperasi",new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            panelbody.removeAll();
            panelbody.repaint();
            panelbody.revalidate();

            panelbody.add(new form_anggota());
            panelbody.repaint();
            panelbody.revalidate();
            }
        });
        MenuItem menuPengajuan= new MenuItem(iconTenor,"Pengajuan Kredit",new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            panelbody.removeAll();
            panelbody.repaint();
            panelbody.revalidate();

            panelbody.add(new form_pengajuan());
            panelbody.repaint();
            panelbody.revalidate();
            }
        });
        MenuItem menuBox= new MenuItem(iconBox,"Daftar Barang",new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            panelbody.removeAll();
            panelbody.repaint();
            panelbody.revalidate();

            panelbody.add(new form_barang());
            panelbody.repaint();
            panelbody.revalidate();
            }
        });
        MenuItem menuPay= new MenuItem(iconPay,"Pembayaran",null,menuKredit,menuCash);  
        MenuItem menuLaporan= new MenuItem(iconLap,"Laporan",new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            new laporan().setVisible(true);
            }
        });
        
        addMenu( menuAdmin,menuUser,menuBox, menuPengajuan, menuPay, menuLaporan);
    }
    
    private void addMenu(MenuItem... menu){
        for(int i=0;i<menu.length;i++){
            menus.add(menu[i]);
            ArrayList<MenuItem>subMenu=menu[i].getSubMenu();
            for(MenuItem m:subMenu){
                addMenu(m);
            }
        
    }
        menus.revalidate();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paneheader = new javax.swing.JPanel();
        panelmenu = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        menus = new javax.swing.JPanel();
        panelbody = new javax.swing.JPanel();
        beranda = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        paneheader.setBackground(new java.awt.Color(0, 153, 153));
        paneheader.setPreferredSize(new java.awt.Dimension(713, 50));

        javax.swing.GroupLayout paneheaderLayout = new javax.swing.GroupLayout(paneheader);
        paneheader.setLayout(paneheaderLayout);
        paneheaderLayout.setHorizontalGroup(
            paneheaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1519, Short.MAX_VALUE)
        );
        paneheaderLayout.setVerticalGroup(
            paneheaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        getContentPane().add(paneheader, java.awt.BorderLayout.PAGE_START);

        panelmenu.setBackground(new java.awt.Color(153, 255, 204));
        panelmenu.setPreferredSize(new java.awt.Dimension(250, 433));

        jScrollPane1.setBorder(null);

        menus.setBackground(new java.awt.Color(255, 255, 204));
        menus.setLayout(new javax.swing.BoxLayout(menus, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(menus);

        javax.swing.GroupLayout panelmenuLayout = new javax.swing.GroupLayout(panelmenu);
        panelmenu.setLayout(panelmenuLayout);
        panelmenuLayout.setHorizontalGroup(
            panelmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );
        panelmenuLayout.setVerticalGroup(
            panelmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
        );

        getContentPane().add(panelmenu, java.awt.BorderLayout.LINE_START);

        panelbody.setBackground(new java.awt.Color(255, 255, 255));
        panelbody.setLayout(new java.awt.CardLayout());

        beranda.setBackground(new java.awt.Color(102, 255, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("KOPERASI DUTA USAHA");

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Main/koperasi.png"))); // NOI18N

        jLabel21.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel21.setText("Jl Margasatwa GG Hankam Ragunan");

        javax.swing.GroupLayout berandaLayout = new javax.swing.GroupLayout(beranda);
        beranda.setLayout(berandaLayout);
        berandaLayout.setHorizontalGroup(
            berandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(berandaLayout.createSequentialGroup()
                .addContainerGap(501, Short.MAX_VALUE)
                .addGroup(berandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, berandaLayout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(394, 394, 394))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, berandaLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(330, 330, 330))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, berandaLayout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(386, 386, 386))))
        );
        berandaLayout.setVerticalGroup(
            berandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, berandaLayout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addComponent(jLabel20)
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21)
                .addGap(192, 192, 192))
        );

        panelbody.add(beranda, "card2");

        getContentPane().add(panelbody, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(1535, 730));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    

    
       
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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

  
    
     
     
    
     
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel beranda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel menus;
    private javax.swing.JPanel paneheader;
    private javax.swing.JPanel panelbody;
    private javax.swing.JPanel panelmenu;
    // End of variables declaration//GEN-END:variables
}
