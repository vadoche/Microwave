/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Domaine.Simulatheure;
import Domaine.Simulatheure.Modes;
import Domaine.Simulatheure.Commandes;

import javax.swing.SwingUtilities;

import Domaine.Utilitaire.*;
import Domaine.ReseauRoutier.*;

/**
 *
 * @author Vincent Martel
 */
public class MainWindow extends javax.swing.JFrame {

    public Simulatheure m_controleur;
    public Modes m_mode_courant;
    public Commandes m_commande_courante;
    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        m_controleur = new Simulatheure();
        initComponents();
        routier.doClick();
        
        this.m_controleur.m_reseauRoutier.ajouterIntersection(733,0);
        this.m_controleur.m_reseauRoutier.ajouterIntersection(1233,500);
        this.m_controleur.m_reseauRoutier.ajouterIntersection(0,1300);
        this.m_controleur.m_reseauRoutier.ajouterIntersection(1600,900);
        Intersection a = this.m_controleur.m_reseauRoutier.getIntersections().getFirst();
        Intersection b = this.m_controleur.m_reseauRoutier.getIntersections().get(1);
        this.m_controleur.m_reseauRoutier.getIntersections().getLast();
        Distribution d = new Distribution (new Temps(10), new Temps(11), new Temps(40));
        this.m_controleur.m_reseauRoutier.ajouterTroncon(a, b, d);
        this.afficheurReseau.setDimension(false);
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
        groupeRoutier = new javax.swing.ButtonGroup();
        mainPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        boutonModes = new javax.swing.JPanel();
        routier = new javax.swing.JToggleButton();
        transport = new javax.swing.JToggleButton();
        besoins = new javax.swing.JToggleButton();
        simulation = new javax.swing.JToggleButton();
        wtf = new javax.swing.JLabel();
        wtf2 = new javax.swing.JLabel();
        afficheurCommandes = new javax.swing.JLayeredPane();
        boutonsRoutier = new javax.swing.JPanel();
        selectionnerRoutier = new javax.swing.JToggleButton();
        intersection = new javax.swing.JToggleButton();
        troncon = new javax.swing.JToggleButton();
        supprimerRoutier = new javax.swing.JToggleButton();
        defilementAfficheur = new javax.swing.JScrollPane();
        afficheurReseau = new GUI.AfficheurReseau(this);
        menu = new javax.swing.JMenuBar();
        fichier = new javax.swing.JMenu();
        quitter = new javax.swing.JMenuItem();

        groupeModes.add(routier);
        groupeModes.add(transport);
        groupeModes.add(besoins);
        groupeModes.add(simulation);

        groupeModes.add(selectionnerRoutier);
        groupeModes.add(intersection);
        groupeModes.add(troncon);
        groupeModes.add(supprimerRoutier);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.OverlayLayout(getContentPane()));

        mainPanel.setPreferredSize(new java.awt.Dimension(1600, 900));
        mainPanel.setLayout(new java.awt.BorderLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(150, 400));
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

        wtf.setText("jLabel1");
        jPanel1.add(wtf, java.awt.BorderLayout.CENTER);

        wtf2.setText("jLabel1");
        jPanel1.add(wtf2, java.awt.BorderLayout.PAGE_END);

        mainPanel.add(jPanel1, java.awt.BorderLayout.WEST);

        afficheurCommandes.setPreferredSize(new java.awt.Dimension(1300, 800));

        boutonsRoutier.setAlignmentX(1.0F);
        boutonsRoutier.setAlignmentY(1.0F);
        boutonsRoutier.setOpaque(false);
        boutonsRoutier.setPreferredSize(new java.awt.Dimension(90, 120));
        boutonsRoutier.setLayout(new java.awt.GridLayout(0, 1, 0, 10));

        selectionnerRoutier.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        selectionnerRoutier.setText("Sélectionner");
        selectionnerRoutier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectionnerRoutierActionPerformed(evt);
            }
        });
        boutonsRoutier.add(selectionnerRoutier);

        intersection.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        intersection.setText("Intersection");
        intersection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                intersectionActionPerformed(evt);
            }
        });
        boutonsRoutier.add(intersection);

        troncon.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        troncon.setText("Tronçon");
        troncon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tronconActionPerformed(evt);
            }
        });
        boutonsRoutier.add(troncon);

        supprimerRoutier.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        supprimerRoutier.setText("Supprimer");
        supprimerRoutier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimerRoutierActionPerformed(evt);
            }
        });
        boutonsRoutier.add(supprimerRoutier);

        defilementAfficheur.setPreferredSize(new java.awt.Dimension(1300, 800));
        defilementAfficheur.setWheelScrollingEnabled(false);

        afficheurReseau.setEnabled(false);
        afficheurReseau.setPreferredSize(new java.awt.Dimension(1600, 900));
        afficheurReseau.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                afficheurReseauMouseMoved(evt);
            }
        });
        afficheurReseau.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                afficheurReseauMouseWheelMoved(evt);
            }
        });
        afficheurReseau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                afficheurReseauMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                afficheurReseauMousePressed(evt);
            }
        });

        javax.swing.GroupLayout afficheurReseauLayout = new javax.swing.GroupLayout(afficheurReseau);
        afficheurReseau.setLayout(afficheurReseauLayout);
        afficheurReseauLayout.setHorizontalGroup(
            afficheurReseauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1600, Short.MAX_VALUE)
        );
        afficheurReseauLayout.setVerticalGroup(
            afficheurReseauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );

        defilementAfficheur.setViewportView(afficheurReseau);

        javax.swing.GroupLayout afficheurCommandesLayout = new javax.swing.GroupLayout(afficheurCommandes);
        afficheurCommandes.setLayout(afficheurCommandesLayout);
        afficheurCommandesLayout.setHorizontalGroup(
            afficheurCommandesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(defilementAfficheur, javax.swing.GroupLayout.DEFAULT_SIZE, 1450, Short.MAX_VALUE)
            .addGroup(afficheurCommandesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, afficheurCommandesLayout.createSequentialGroup()
                    .addContainerGap(1333, Short.MAX_VALUE)
                    .addComponent(boutonsRoutier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(27, 27, 27)))
        );
        afficheurCommandesLayout.setVerticalGroup(
            afficheurCommandesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(defilementAfficheur, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
            .addGroup(afficheurCommandesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(afficheurCommandesLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(boutonsRoutier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(767, Short.MAX_VALUE)))
        );
        afficheurCommandes.setLayer(boutonsRoutier, javax.swing.JLayeredPane.DEFAULT_LAYER);
        afficheurCommandes.setLayer(defilementAfficheur, javax.swing.JLayeredPane.DEFAULT_LAYER);

        mainPanel.add(afficheurCommandes, java.awt.BorderLayout.CENTER);

        getContentPane().add(mainPanel);

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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void quitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitterActionPerformed
        System.exit(0);
    }//GEN-LAST:event_quitterActionPerformed

    private void routierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_routierActionPerformed
        
        this.setMode(Modes.ROUTIER);
        boutonsRoutier.setVisible(true);
        selectionnerRoutier.doClick();
        
    }//GEN-LAST:event_routierActionPerformed

    private void transportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transportActionPerformed
        this.setMode(Modes.TRANSPORT);
        //boutonsTransport.setVisible(true);
    }//GEN-LAST:event_transportActionPerformed

    private void besoinsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_besoinsActionPerformed
        this.setMode(Modes.BESOINS);
        //boutonsBesoins.setVisible(true);
    }//GEN-LAST:event_besoinsActionPerformed

    private void simulationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simulationActionPerformed
        this.setMode(Modes.SIMULATION);
        //boutonsSimulation.setVisible(true);
    }//GEN-LAST:event_simulationActionPerformed

    private void afficheurReseauMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_afficheurReseauMousePressed
        if (SwingUtilities.isLeftMouseButton(evt)) {
            switch (m_mode_courant){
                
                case ROUTIER:
                    float x;
                    float y;
                    float echelle = afficheurReseau.getEchelle();                    
                    switch (m_commande_courante){
                        
                        case SELECTIONNER:                                    
                            if (afficheurReseau.selectionnerIntersection(evt.getX(), evt.getY()))
                            {
                                break;
                            }
                            else
                            {
                                afficheurReseau.selectionnerTroncon(evt.getX(), evt.getY());
                                break;
                            }
                        
                        case INTERSECTION:
                            x = evt.getX() / echelle;
                            y = evt.getY() / echelle;
                            this.m_controleur.m_reseauRoutier.ajouterIntersection(x, y);
                            boolean ajoutIntersection = true;
                            afficheurReseau.setDimension(ajoutIntersection);
                            
                            break;
                            
                        case TRONCON:
                            //float x = (float)(evt.getPoint().getX() / afficheur.getEchelle());
                            //float y = (float)(evt.getPoint().getY() / afficheur.getEchelle());        
                            //this.m_controleur.m_reseauRoutier.ajouterIntersection(x, y);          
                            //jScrollPane1.setViewportView(afficheur);

                            break;

                        default:
                            break;
                    }
                    break;

                default:
                    break;
            }
        }
        
        this.afficheurCommandes.repaint();
    }//GEN-LAST:event_afficheurReseauMousePressed

    private void afficheurReseauMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_afficheurReseauMouseWheelMoved
        
        float echelleInitiale = afficheurReseau.getEchelle();
        afficheurReseau.setEchelle(evt.getWheelRotation());
        float rapportEchelles = afficheurReseau.getEchelle() / echelleInitiale;
        
        int x = defilementAfficheur.getViewport().getViewPosition().x;
        x = (int)(evt.getX() * (rapportEchelles  - 1)) + x;
        
        int y = defilementAfficheur.getViewport().getViewPosition().y;
        y = (int)(evt.getY() * (rapportEchelles  - 1)) + y;
        
        defilementAfficheur.getViewport().setViewPosition(new java.awt.Point(x, y));
        wtf2.setText(Integer.toString((int)(afficheurReseau.getEchelle() * 100)) + " %");
        
        this.afficheurCommandes.repaint();
    }//GEN-LAST:event_afficheurReseauMouseWheelMoved

    private void afficheurReseauMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_afficheurReseauMouseMoved
        
        float x = evt.getX() / afficheurReseau.getEchelle();
        float y = evt.getY() / afficheurReseau.getEchelle();
        wtf.setText(Integer.toString((int)x) + "  " + Integer.toString((int)y));
    }//GEN-LAST:event_afficheurReseauMouseMoved

    private void afficheurReseauMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_afficheurReseauMouseExited
        wtf.setText("");
    }//GEN-LAST:event_afficheurReseauMouseExited

    private void intersectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_intersectionActionPerformed
        this.setCommande(Commandes.INTERSECTION);
    }//GEN-LAST:event_intersectionActionPerformed

    private void selectionnerRoutierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectionnerRoutierActionPerformed
        this.setCommande(Commandes.SELECTIONNER);
    }//GEN-LAST:event_selectionnerRoutierActionPerformed

    private void tronconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tronconActionPerformed
        this.setCommande(Commandes.TRONCON);
    }//GEN-LAST:event_tronconActionPerformed

    private void supprimerRoutierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimerRoutierActionPerformed
        this.setCommande(Commandes.SUPPRIMER);
    }//GEN-LAST:event_supprimerRoutierActionPerformed
    
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
        boutonsRoutier.setVisible(false);
        //boutonsTransport.setVisible(false);
        //boutonsBesoins.setVisible(false);
        //boutonsSimulation.setVisible(false);
    }
    
    public void setCommande(Commandes p_commande) 
    {
        this.m_commande_courante = p_commande;
    }
    
    public javax.swing.JScrollPane getDefilementAfficheur() 
    {
        return defilementAfficheur;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane afficheurCommandes;
    private GUI.AfficheurReseau afficheurReseau;
    private javax.swing.JToggleButton besoins;
    private javax.swing.JPanel boutonModes;
    private javax.swing.JPanel boutonsRoutier;
    private javax.swing.JScrollPane defilementAfficheur;
    private javax.swing.JMenu fichier;
    private javax.swing.ButtonGroup groupeModes;
    private javax.swing.ButtonGroup groupeRoutier;
    private javax.swing.JToggleButton intersection;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenuItem quitter;
    private javax.swing.JToggleButton routier;
    private javax.swing.JToggleButton selectionnerRoutier;
    private javax.swing.JToggleButton simulation;
    private javax.swing.JToggleButton supprimerRoutier;
    private javax.swing.JToggleButton transport;
    private javax.swing.JToggleButton troncon;
    private javax.swing.JLabel wtf;
    private javax.swing.JLabel wtf2;
    // End of variables declaration//GEN-END:variables
}
