/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import Domaine.ReseauRoutier.Intersection;
import Domaine.Utilitaire.Temps;
import Domaine.Utilitaire.Distribution;
import Domaine.Simulatheure;
import Domaine.Simulatheure.Modes;
import Domaine.Utilitaire.*;
import Domaine.ReseauRoutier.*;

/**
 *
 * @author Vincent Martel
 */
public class MainWindow extends javax.swing.JFrame {

    public Simulatheure m_controleur;
    public Modes m_mode_courant;
    
    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        m_controleur = new Simulatheure();
        initComponents();
        
        this.m_controleur.m_reseauRoutier.ajouterIntersection(100.1f,40.055f);
        this.m_controleur.m_reseauRoutier.ajouterIntersection(1233,500);
        this.m_controleur.m_reseauRoutier.ajouterIntersection(.01f,1300);
        this.m_controleur.m_reseauRoutier.ajouterIntersection(2500.15f,1300);
        Intersection a = this.m_controleur.m_reseauRoutier.getIntersections().getFirst();
        Intersection b = this.m_controleur.m_reseauRoutier.getIntersections().get(1);
        this.m_controleur.m_reseauRoutier.getIntersections().getLast();
        Distribution d = new Distribution (new Temps(10), new Temps(11), new Temps(40));
        this.m_controleur.m_reseauRoutier.ajouterTroncon(a, b, d, new Temps(1));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupeModes = new javax.swing.ButtonGroup();
        mainPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        afficheur = new GUI.DrawingPanel(this);
        jPanel1 = new javax.swing.JPanel();
        boutonModes = new javax.swing.JPanel();
        routier = new javax.swing.JToggleButton();
        transport = new javax.swing.JToggleButton();
        besoins = new javax.swing.JToggleButton();
        simulation = new javax.swing.JToggleButton();
        menu = new javax.swing.JMenuBar();
        fichier = new javax.swing.JMenu();
        quitter = new javax.swing.JMenuItem();

        groupeModes.add(routier);
        groupeModes.add(transport);
        groupeModes.add(besoins);
        groupeModes.add(simulation);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setPreferredSize(new java.awt.Dimension(500, 400));
        jScrollPane1.setRequestFocusEnabled(false);

        afficheur.setPreferredSize(new java.awt.Dimension(5000, 5000));
        afficheur.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                afficheurMouseWheelMoved(evt);
            }
        });
        afficheur.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                afficheurMousePressed(evt);
            }
        });

        javax.swing.GroupLayout afficheurLayout = new javax.swing.GroupLayout(afficheur);
        afficheur.setLayout(afficheurLayout);
        afficheurLayout.setHorizontalGroup(
            afficheurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5000, Short.MAX_VALUE)
        );
        afficheurLayout.setVerticalGroup(
            afficheurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5000, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(afficheur);

        mainPanel.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.BorderLayout());

        boutonModes.setPreferredSize(new java.awt.Dimension(150, 400));
        boutonModes.setRequestFocusEnabled(false);
        boutonModes.setLayout(new java.awt.GridLayout(0, 1, 0, 5));

        routier.setText("Réseau routier");
        routier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                routierActionPerformed(evt);
            }
        });
        boutonModes.add(routier);

        transport.setText("Réseau transport");
        transport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transportActionPerformed(evt);
            }
        });
        boutonModes.add(transport);

        besoins.setText("Besoins transport");
        besoins.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                besoinsActionPerformed(evt);
            }
        });
        boutonModes.add(besoins);

        simulation.setText("Simulation");
        simulation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simulationActionPerformed(evt);
            }
        });
        boutonModes.add(simulation);

        jPanel1.add(boutonModes, java.awt.BorderLayout.PAGE_START);

        mainPanel.add(jPanel1, java.awt.BorderLayout.WEST);

        fichier.setText("Fichier");

        quitter.setText("Quitter");
        quitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitterActionPerformed(evt);
            }
        });
        fichier.add(quitter);

        menu.add(fichier);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 794, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void quitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitterActionPerformed
        System.exit(0);
    }//GEN-LAST:event_quitterActionPerformed

    private void routierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_routierActionPerformed
        this.setMode(Modes.ROUTIER);
    }//GEN-LAST:event_routierActionPerformed

    private void transportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transportActionPerformed
        this.setMode(Modes.TRANSPORT);
    }//GEN-LAST:event_transportActionPerformed

    private void besoinsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_besoinsActionPerformed
        this.setMode(Modes.BESOINS);
    }//GEN-LAST:event_besoinsActionPerformed

    private void simulationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simulationActionPerformed
        this.setMode(Modes.SIMULATION);
    }//GEN-LAST:event_simulationActionPerformed

    private void afficheurMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_afficheurMousePressed
        float x = (float)(evt.getPoint().getX() / afficheur.getEchelle());
        float y = (float)(evt.getPoint().getY() / afficheur.getEchelle());        
        this.m_controleur.m_reseauRoutier.ajouterIntersection(x, y);
        
        afficheur.repaint();
    }//GEN-LAST:event_afficheurMousePressed

    private void afficheurMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_afficheurMouseWheelMoved
        afficheur.setEchelle(evt.getUnitsToScroll());
        afficheur.repaint();
    }//GEN-LAST:event_afficheurMouseWheelMoved
    
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
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
        
        
    }
    
    public void setMode(Modes p_mode) 
    {
        this.m_mode_courant = p_mode;
        if (m_mode_courant == Modes.ROUTIER)
        {
            afficheur.setVisible(true);
        }
        else
        {
            afficheur.setVisible(false);
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.DrawingPanel afficheur;
    private javax.swing.JToggleButton besoins;
    private javax.swing.JPanel boutonModes;
    private javax.swing.JMenu fichier;
    private javax.swing.ButtonGroup groupeModes;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenuItem quitter;
    private javax.swing.JToggleButton routier;
    private javax.swing.JToggleButton simulation;
    private javax.swing.JToggleButton transport;
    // End of variables declaration//GEN-END:variables
}
