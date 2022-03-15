
package mygame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author en
 */
public class MenuWindow extends javax.swing.JFrame {

    public MenuWindow() {
//        this.setUndecorated(true);//keretet leszed
//        this.setAlwaysOnTop(true);
        this.setResizable(false);
        this.setVisible(true);
        initComponents();
        //Toolkit tk = Toolkit.getDefaultToolkit();//ablakméret
        int xsize = 780;//(int) tk.getScreenSize().getWidth();
        int ysize = 500;//(int) tk.getScreenSize().getHeight();  
        this.setSize(xsize, ysize);
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();//középre jelenik meg
        int jfrrameWidth = this.getSize().width;
        int jfrrameHeight = this.getSize().height;
        
        int locationX = (dim.width-jfrrameWidth)/2;
        int locationY = (dim.height-jfrrameHeight)/2;
        this.setLocation(locationX,locationY);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jatekinditasa = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        toplista = new javax.swing.JButton();
        kilepes = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 800, 600));
        setSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(null);

        jatekinditasa.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jatekinditasa.setText("Játék indítása");
        jatekinditasa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jatekinditasaActionPerformed(evt);
            }
        });
        getContentPane().add(jatekinditasa);
        jatekinditasa.setBounds(90, 190, 200, 45);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Space Impact");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(272, 50, 217, 44);

        toplista.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        toplista.setText("Toplista");
        toplista.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        toplista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toplistaActionPerformed(evt);
            }
        });
        getContentPane().add(toplista);
        toplista.setBounds(510, 190, 200, 45);

        kilepes.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        kilepes.setText("Kilépés");
        kilepes.setDoubleBuffered(true);
        kilepes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kilepesActionPerformed(evt);
            }
        });
        getContentPane().add(kilepes);
        kilepes.setBounds(290, 320, 200, 45);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/menuhatter.jpg"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 780, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void toplistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toplistaActionPerformed
        // TODO add your handling code here:
        HighScoreWindow hsw = new HighScoreWindow();
//        new HighScoreWindow().setVisible(true);
        hsw.setVisible(true);
        hsw.beolvas();
    }//GEN-LAST:event_toplistaActionPerformed

    private void jatekinditasaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jatekinditasaActionPerformed

        String information = "Játék információ!"+"\n"+
                             "Irányítás: "+"\n"+
                             "Felfele haladás - W"+"\n"+
                             "Lefele haladás - S"+"\n"+
                             "Lövés - Space";
       JOptionPane.showMessageDialog(null, information);
       SpaceImpact spi= new SpaceImpact();
       spi.setResizable(false);
       
       spi.setDefaultCloseOperation(spi.DISPOSE_ON_CLOSE);       
       spi.addWindowListener(new java.awt.event.WindowAdapter() {
        @Override
    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
        spi.setKill(true);
       spi.dispose();
    }
    });

    }//GEN-LAST:event_jatekinditasaActionPerformed

    private void kilepesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kilepesActionPerformed
        this.setVisible(false);
        System.exit(0);
    }//GEN-LAST:event_kilepesActionPerformed

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
            java.util.logging.Logger.getLogger(MenuWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MenuWindow().setVisible(true);
            }
        });
        

    }//main

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jatekinditasa;
    private javax.swing.JButton kilepes;
    private javax.swing.JButton toplista;
    // End of variables declaration//GEN-END:variables
}
