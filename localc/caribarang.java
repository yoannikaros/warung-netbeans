/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import control.koneksicari;
import java.sql.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author ASUS
 */
public class caribarang extends javax.swing.JFrame {
DefaultTableModel tabModel;
ResultSet RsProduk=null;


private void tampilData(){
        try{
            Object[] judul_kolom = {"kode_item", "barang", "barcode", "jenis", "hargagrosir", "hargaumum", "qty"};
            tabModel=new DefaultTableModel(null,judul_kolom);
            jTableProduk.setModel(tabModel);
            
            Connection conn=(Connection)koneksicari.koneksiDB();
            Statement stt=conn.createStatement();
            tabModel.getDataVector().removeAllElements();
            
            RsProduk=stt.executeQuery("SELECT * from barang ");  
            while(RsProduk.next()){
                Object[] data={
                    RsProduk.getString("kode_item"),
                    RsProduk.getString("barang"),
                    RsProduk.getString("barcode"),
                    RsProduk.getString("jenis"),
                    RsProduk.getString("hargagrosir"),
                    RsProduk.getString("hargaumum"),
                    RsProduk.getString("qty")         
                };
               tabModel.addRow(data);
            }                
        } catch (Exception ex) {
        System.err.println(ex.getMessage());
        }
    }

private void cariData(String key){
        try{
               Object[] judul_kolom = {"kode_item", "barang", "barcode", "jenis", "hargagrosir", "hargaumum", "qty"};
            tabModel=new DefaultTableModel(null,judul_kolom);
            jTableProduk.setModel(tabModel);
            
            Connection conn=(Connection)koneksicari.koneksiDB();
            Statement stt=conn.createStatement();
            tabModel.getDataVector().removeAllElements();
            
            RsProduk=stt.executeQuery("SELECT * from barang WHERE kode_item LIKE '%"+key+"%' OR barang LIKE '%"+key+"%' OR jenis LIKE '%"+key+"%'");  
            while(RsProduk.next()){
                Object[] data={
                    RsProduk.getString("kode_item"),
                    RsProduk.getString("barang"),
                    RsProduk.getString("barcode"),
                    RsProduk.getString("jenis"),
                    RsProduk.getString("hargagrosir"),
                    RsProduk.getString("hargaumum"),
                    RsProduk.getString("qty")         
                };
               tabModel.addRow(data);
            }                
        } catch (Exception ex) {
        System.err.println(ex.getMessage());
        }
    }

    /**
     * Creates new form caribarang
     */
    public caribarang() {
        initComponents();
        tampilData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextCari = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProduk = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(500, 500));
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);

        jTextCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextCariKeyReleased(evt);
            }
        });

        jTableProduk.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTableProduk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ));
        jScrollPane1.setViewportView(jTableProduk);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("CARI");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jTextCari)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextCari))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextCariKeyReleased
        // TODO add your handling code here:
        String key=jTextCari.getText();
        System.out.println(key);  
        
        if(key!=""){
            cariData(key);
        }else{
            tampilData();
        }
        
        
    }//GEN-LAST:event_jTextCariKeyReleased

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
            java.util.logging.Logger.getLogger(caribarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(caribarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(caribarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(caribarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new caribarang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProduk;
    private javax.swing.JTextField jTextCari;
    // End of variables declaration//GEN-END:variables
}