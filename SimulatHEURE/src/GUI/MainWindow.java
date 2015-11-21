package GUI;

import Domaine.Simulatheure;
import Domaine.Simulatheure.Modes;
import Domaine.Simulatheure.Commandes;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import java.lang.Object;
import Domaine.Utilitaire.*;
import Domaine.ReseauRoutier.*;
import Domaine.ReseauTransport.*;
import java.awt.Color;
import java.util.LinkedList;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPopupMenu;
import java.util.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.UIManager;

/**
 *
 * @author Vinny
 */
public class MainWindow extends javax.swing.JFrame {

    public Simulatheure m_controleur;
    public Modes m_mode_courant;
    public Commandes m_commande_courante;
    private Boolean m_booleanCTRL = false;
    private Timer m_timer;
    private Chronometre m_crono = new Chronometre();
    private MainWindow m_this = this;
    private boolean m_simulationEstLancer = false;

    /**
     * Creates new form MainWindow
     */
    
    public MainWindow() {
        changeLookAndFeel();
        m_controleur = new Simulatheure();
        initComponents();
        routier.doClick();
        this.afficheurReseau.setDimension(false);         
        
        
        //test
    //this.afficheurReseau.setDimension(false);
        /*
    int x1 = 100;
    int y1 = 100;
    int x2 = 500;
    int y2 = 500;
    int x3 = 300;
    
    this.m_controleur.ajouterIntersection(x1, y1, 1f);
    Intersection inter1 = this.m_controleur.getRoutier().getIntersections().getLast();
    this.m_controleur.ajouterIntersection(x2, y1, 1f);
    Intersection inter2 = this.m_controleur.getRoutier().getIntersections().getLast();
    this.m_controleur.ajouterIntersection(x2, y2, 1f);
    Intersection inter3 = this.m_controleur.getRoutier().getIntersections().getLast();
    this.m_controleur.ajouterIntersection(x3, y2, 1f);
    Intersection inter4 = this.m_controleur.getRoutier().getIntersections().getLast();
    
    this.m_controleur.getRoutier().ajouterTroncon(inter1, inter2);
    Troncon troncon1 = this.m_controleur.getRoutier().getIntersections().get(0).getTroncons().getFirst();
    this.m_controleur.getRoutier().ajouterTroncon(inter2, inter3);
    Troncon troncon2 = this.m_controleur.getRoutier().getIntersections().get(1).getTroncons().getFirst();
    this.m_controleur.getRoutier().ajouterTroncon(inter3, inter4);
    Troncon troncon3 = this.m_controleur.getRoutier().getIntersections().get(2).getTroncons().getFirst();
    
    Emplacement emp1 = new Emplacement(false, 0, troncon2, inter1);
    this.m_controleur.getTransport().ajouterArret(new Arret(emp1, ""));
    Arret arret1 = this.m_controleur.getTransport().getListArrets().getLast();
    
    Emplacement emp2 = new Emplacement(true, 0.25f, troncon2, inter2);
    this.m_controleur.getTransport().ajouterArret(new Arret(emp2, ""));
    Arret arret2 = this.m_controleur.getTransport().getListArrets().getLast();
    
    Emplacement emp3 = new Emplacement(false, 0, troncon2, inter4);
    this.m_controleur.getTransport().ajouterArret(new Arret(emp3, ""));
    Arret arret3 = this.m_controleur.getTransport().getListArrets().getLast();
    
    LinkedList<Troncon> listeTroncons1 = new LinkedList<>();
    listeTroncons1.add(troncon1);
    listeTroncons1.add(troncon2);
    Trajet trajet1 = new Trajet(emp1, emp2, listeTroncons1);
    PaireArretTrajet paire1 = new PaireArretTrajet(arret1, trajet1);
    
    LinkedList<Troncon> listeTroncons2 = new LinkedList<>();
    listeTroncons2.add(troncon2);
    listeTroncons2.add(troncon3);
    Trajet trajet2 = new Trajet(emp2, emp3, listeTroncons2);
    PaireArretTrajet paire2 = new PaireArretTrajet(arret2, trajet2);
    
    PaireArretTrajet paire3 = new PaireArretTrajet(arret3, null);
    
    LinkedList<PaireArretTrajet> listePaires = new LinkedList<>();
    listePaires.add(paire1);
    listePaires.add(paire2);
    listePaires.add(paire3);
    
    Circuit circuit1 = new Circuit("Calis", listePaires, this.m_controleur.getRoutier());
    
    this.m_controleur.getTransport().ajouterCircuit(circuit1);
    
    Distribution distSource = new Distribution();
    distSource.setDistribution(new Temps(2), new Temps(2), new Temps(2));
    
    Emplacement empCalis = new Emplacement(true, 0, troncon1, inter1);
    this.m_controleur.getTransport().ajoutSource(empCalis, circuit1, "Ta mere", distSource, new Temps(0));
    this.m_controleur.getTransport().ajoutSource(emp2, circuit1, "Ta mere", distSource, new Temps(0));
    
    this.afficheurReseau.setDimension(true);
        */
    }
class MyTimerActionListener implements ActionListener {
  public void actionPerformed(ActionEvent e) {
      double deltatT = m_crono.getDeltatT();
     // System.out.println(deltatT);
      m_controleur.rafraichirSimulation(new Temps(deltatT));
      m_this.afficheurCommandes.repaint();
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

        groupeModes = new javax.swing.ButtonGroup();
        groupeRoutier = new javax.swing.ButtonGroup();
        groupeTransport = new javax.swing.ButtonGroup();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        mainPanel = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        boutonModes = new javax.swing.JPanel();
        routier = new javax.swing.JToggleButton();
        transport = new javax.swing.JToggleButton();
        besoins = new javax.swing.JToggleButton();
        simulation = new javax.swing.JToggleButton();
        jPanel5 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        wtf2 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        wtf = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        boutonsSelectionRoutier = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        comboBoxTroncons = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        comboBoxIntersections = new javax.swing.JComboBox();
        boutonsSelectionTransport = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        comboBoxArrets = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        comboBoxSources = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        selectionCircuit = new javax.swing.JComboBox();
        afficheurCommandes = new javax.swing.JLayeredPane();
        boutonsRoutier = new javax.swing.JPanel();
        selectionRoutier = new javax.swing.JToggleButton();
        ajoutIntersection = new javax.swing.JToggleButton();
        constructionTroncon = new javax.swing.JToggleButton();
        suppressionRoutier = new javax.swing.JButton();
        boutonsTransport = new javax.swing.JPanel();
        selectionTransport = new javax.swing.JToggleButton();
        ajoutSource = new javax.swing.JToggleButton();
        ajoutArret = new javax.swing.JToggleButton();
        ajoutCircuit = new javax.swing.JToggleButton();
        editerCircuit = new javax.swing.JButton();
        suppressionTransport = new javax.swing.JButton();
        boutonsSimulation = new javax.swing.JPanel();
        playPauseSimulation = new javax.swing.JToggleButton();
        pauseSimulation = new javax.swing.JButton();
        avancerSimulation = new javax.swing.JButton();
        defilementAfficheur = new javax.swing.JScrollPane();
        afficheurReseau = new GUI.AfficheurReseau(this);
        jPanel4 = new javax.swing.JPanel();
        menu = new javax.swing.JMenuBar();
        fichier = new javax.swing.JMenu();
        quitter = new javax.swing.JMenuItem();

        groupeModes.add(routier);
        groupeModes.add(transport);
        groupeModes.add(besoins);
        groupeModes.add(simulation);

        groupeModes.add(selectionRoutier);
        groupeModes.add(ajoutIntersection);
        groupeModes.add(constructionTroncon);

        groupeModes.add(selectionTransport);
        groupeModes.add(ajoutSource);
        groupeModes.add(ajoutArret);
        groupeModes.add(ajoutCircuit);
        groupeModes.add(suppressionTransport);

        jPopupMenu1.setName(""); // NOI18N

        jMenuItem1.setText("Éditer...");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        jMenuItem2.setText("Supprimer");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.OverlayLayout(getContentPane()));

        mainPanel.setPreferredSize(new java.awt.Dimension(1600, 900));
        mainPanel.setLayout(new java.awt.BorderLayout());

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(150, 400));
        jPanel1.setLayout(new java.awt.BorderLayout());

        boutonModes.setPreferredSize(new java.awt.Dimension(150, 400));
        boutonModes.setRequestFocusEnabled(false);
        boutonModes.setLayout(new java.awt.GridLayout(4, 1));

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

        jPanel1.add(boutonModes, java.awt.BorderLayout.NORTH);

        jPanel5.setLayout(new java.awt.GridLayout(3, 2));

        jButton1.setText("Annuler");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton1);

        jButton2.setText("Revenir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton2);

        jLabel1.setText("Zoom :");
        jPanel5.add(jLabel1);

        wtf2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        wtf2.setText("100 %");
        wtf2.setRequestFocusEnabled(false);
        jPanel5.add(wtf2);

        jLabel2.setText("Position :");
        jPanel5.add(jLabel2);
        jPanel5.add(wtf);

        jPanel1.add(jPanel5, java.awt.BorderLayout.SOUTH);

        jPanel2.add(jPanel1, java.awt.BorderLayout.WEST);

        jPanel3.add(jPanel2, java.awt.BorderLayout.WEST);

        jPanel6.setLayout(new java.awt.BorderLayout());

        jPanel7.setPreferredSize(new java.awt.Dimension(130, 56));

        boutonsSelectionRoutier.setAlignmentX(1.0F);
        boutonsSelectionRoutier.setAlignmentY(1.0F);
        boutonsSelectionRoutier.setOpaque(false);
        boutonsSelectionRoutier.setPreferredSize(new java.awt.Dimension(90, 120));
        boutonsSelectionRoutier.setLayout(new java.awt.GridLayout(0, 1, 0, 10));

        jLabel4.setText("Troncons :");
        boutonsSelectionRoutier.add(jLabel4);

        comboBoxTroncons.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Aucun" }));
        comboBoxTroncons.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxTronconsActionPerformed(evt);
            }
        });
        boutonsSelectionRoutier.add(comboBoxTroncons);

        jLabel5.setText("Intersections :");
        boutonsSelectionRoutier.add(jLabel5);

        comboBoxIntersections.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Aucun" }));
        comboBoxIntersections.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxIntersectionsActionPerformed(evt);
            }
        });
        boutonsSelectionRoutier.add(comboBoxIntersections);

        boutonsSelectionTransport.setAlignmentX(1.0F);
        boutonsSelectionTransport.setAlignmentY(1.0F);
        boutonsSelectionTransport.setOpaque(false);
        boutonsSelectionTransport.setPreferredSize(new java.awt.Dimension(90, 120));
        boutonsSelectionTransport.setLayout(new java.awt.GridLayout(0, 1, 0, 10));

        jLabel8.setText("Arrets :");
        boutonsSelectionTransport.add(jLabel8);

        comboBoxArrets.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Aucun" }));
        boutonsSelectionTransport.add(comboBoxArrets);

        jLabel9.setText("Sources :");
        boutonsSelectionTransport.add(jLabel9);

        comboBoxSources.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Aucun" }));
        boutonsSelectionTransport.add(comboBoxSources);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel3.setText("Selection Circuit:");
        boutonsSelectionTransport.add(jLabel3);

        selectionCircuit.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Aucun" }));
        selectionCircuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectionCircuitActionPerformed(evt);
            }
        });
        boutonsSelectionTransport.add(selectionCircuit);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(boutonsSelectionRoutier, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(boutonsSelectionTransport, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(boutonsSelectionRoutier, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 636, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addComponent(boutonsSelectionTransport, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel6.add(jPanel7, java.awt.BorderLayout.EAST);

        afficheurCommandes.setPreferredSize(new java.awt.Dimension(1300, 800));
        afficheurCommandes.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                afficheurReseauMouseMoved(evt);
            }
        });
        afficheurCommandes.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                afficheurReseauMouseWheelMoved(evt);
            }
        });
        afficheurCommandes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                afficheurReseauMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                afficheurReseauMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                afficheurReseauMousePressed(evt);
            }
        });

        boutonsRoutier.setAlignmentX(1.0F);
        boutonsRoutier.setAlignmentY(1.0F);
        boutonsRoutier.setOpaque(false);
        boutonsRoutier.setPreferredSize(new java.awt.Dimension(90, 120));
        boutonsRoutier.setLayout(new java.awt.GridLayout(0, 1, 0, 10));

        selectionRoutier.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        selectionRoutier.setText("Sélectionner");
        selectionRoutier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectionRoutierActionPerformed(evt);
            }
        });
        boutonsRoutier.add(selectionRoutier);

        ajoutIntersection.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        ajoutIntersection.setText("Intersection");
        ajoutIntersection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajoutIntersectionActionPerformed(evt);
            }
        });
        boutonsRoutier.add(ajoutIntersection);

        constructionTroncon.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        constructionTroncon.setText("Tronçon");
        constructionTroncon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                constructionTronconActionPerformed(evt);
            }
        });
        boutonsRoutier.add(constructionTroncon);

        suppressionRoutier.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        suppressionRoutier.setText("Supprimer");
        suppressionRoutier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suppressionRoutierActionPerformed(evt);
            }
        });
        boutonsRoutier.add(suppressionRoutier);

        boutonsTransport.setAlignmentX(1.0F);
        boutonsTransport.setAlignmentY(1.0F);
        boutonsTransport.setOpaque(false);
        boutonsTransport.setPreferredSize(new java.awt.Dimension(140, 160));
        boutonsTransport.setLayout(new java.awt.GridLayout(0, 1, 0, 10));

        selectionTransport.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        selectionTransport.setText("Sélectionner");
        selectionTransport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectionTransportActionPerformed(evt);
            }
        });
        boutonsTransport.add(selectionTransport);

        ajoutSource.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        ajoutSource.setText("Source");
        ajoutSource.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajoutSourceActionPerformed(evt);
            }
        });
        boutonsTransport.add(ajoutSource);

        ajoutArret.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        ajoutArret.setText("Arret");
        ajoutArret.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajoutArretActionPerformed(evt);
            }
        });
        boutonsTransport.add(ajoutArret);

        ajoutCircuit.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        ajoutCircuit.setText("Circuit");
        ajoutCircuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajoutCircuitActionPerformed(evt);
            }
        });
        boutonsTransport.add(ajoutCircuit);

        editerCircuit.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        editerCircuit.setText("Editer Circuit");
        editerCircuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editerCircuitActionPerformed(evt);
            }
        });
        boutonsTransport.add(editerCircuit);

        suppressionTransport.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        suppressionTransport.setText("Supprimer");
        suppressionTransport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suppressionTransportActionPerformed(evt);
            }
        });
        boutonsTransport.add(suppressionTransport);

        boutonsSimulation.setAlignmentX(1.0F);
        boutonsSimulation.setAlignmentY(1.0F);
        boutonsSimulation.setOpaque(false);
        boutonsSimulation.setPreferredSize(new java.awt.Dimension(140, 160));
        boutonsSimulation.setLayout(new java.awt.GridLayout(1, 3, 20, 10));

        playPauseSimulation.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        playPauseSimulation.setText("Play / Pause");
        playPauseSimulation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playPauseSimulationActionPerformed(evt);
            }
        });
        boutonsSimulation.add(playPauseSimulation);

        pauseSimulation.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        pauseSimulation.setText("Avancer X 2");
        pauseSimulation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauseSimulationActionPerformed(evt);
            }
        });
        boutonsSimulation.add(pauseSimulation);

        avancerSimulation.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        avancerSimulation.setText("Ralentir / 2");
        avancerSimulation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                avancerSimulationActionPerformed(evt);
            }
        });
        boutonsSimulation.add(avancerSimulation);

        defilementAfficheur.setPreferredSize(new java.awt.Dimension(1300, 800));
        defilementAfficheur.setWheelScrollingEnabled(false);

        afficheurReseau.setEnabled(false);
        afficheurReseau.setPreferredSize(new java.awt.Dimension(1600, 900));
        afficheurReseau.setBackground(Color.WHITE);
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
            .addComponent(defilementAfficheur, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(afficheurCommandesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, afficheurCommandesLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(boutonsRoutier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(27, 27, 27)))
            .addGroup(afficheurCommandesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, afficheurCommandesLayout.createSequentialGroup()
                    .addContainerGap(1184, Short.MAX_VALUE)
                    .addComponent(boutonsTransport, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(26, 26, 26)))
            .addGroup(afficheurCommandesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(afficheurCommandesLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(boutonsSimulation, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        afficheurCommandesLayout.setVerticalGroup(
            afficheurCommandesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(defilementAfficheur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(afficheurCommandesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(afficheurCommandesLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(boutonsRoutier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(668, Short.MAX_VALUE)))
            .addGroup(afficheurCommandesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(afficheurCommandesLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(boutonsTransport, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(609, Short.MAX_VALUE)))
            .addGroup(afficheurCommandesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, afficheurCommandesLayout.createSequentialGroup()
                    .addContainerGap(745, Short.MAX_VALUE)
                    .addComponent(boutonsSimulation, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(28, 28, 28)))
        );
        afficheurCommandes.setLayer(boutonsRoutier, javax.swing.JLayeredPane.DEFAULT_LAYER);
        afficheurCommandes.setLayer(boutonsTransport, javax.swing.JLayeredPane.DEFAULT_LAYER);
        afficheurCommandes.setLayer(boutonsSimulation, javax.swing.JLayeredPane.DEFAULT_LAYER);
        afficheurCommandes.setLayer(defilementAfficheur, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jPanel6.add(afficheurCommandes, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel6, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("SimulatHEURE", jPanel3);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 631, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 473, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Statistiques", jPanel4);

        mainPanel.add(jTabbedPane1, java.awt.BorderLayout.CENTER);
        jTabbedPane1.getAccessibleContext().setAccessibleName("SimulatHeure");

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
        boutonsSelectionRoutier.setVisible(true);
        selectionRoutier.doClick();        
    }//GEN-LAST:event_routierActionPerformed

    private void transportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transportActionPerformed
        this.setMode(Modes.TRANSPORT);
        boutonsTransport.setVisible(true);
        boutonsSelectionTransport.setVisible(true);
    }//GEN-LAST:event_transportActionPerformed

    private void besoinsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_besoinsActionPerformed
        this.setMode(Modes.BESOINS);
        //boutonsBesoins.setVisible(true);
    }//GEN-LAST:event_besoinsActionPerformed

    private void simulationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simulationActionPerformed
        this.setMode(Modes.SIMULATION);
        
        boutonsSimulation.setVisible(true);
    }//GEN-LAST:event_simulationActionPerformed

    private void lancerSimulation(){
        boutonsSimulation.setVisible(true);
        m_timer= new Timer(0, new MyTimerActionListener());     
        m_timer.setDelay(1);
        m_controleur.demarrerSimulation();
        m_crono.start();
        m_timer.start();
    }
    private void afficheurReseauMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_afficheurReseauMousePressed
        float echelle = afficheurReseau.getEchelle();
        if (SwingUtilities.isLeftMouseButton(evt))
        {
            
            switch (m_mode_courant)
            {                
                case ROUTIER:
                                        
                    switch (m_commande_courante)
                    {                        
                        case SELECTIONNER:
                            if(evt.isControlDown())
                            {
                                System.out.println("Pressed");
                                ElementRoutier plusieursEr = m_controleur.selectionnerPlusieursElementRoutier(evt.getX(), evt.getY(), echelle);
                            }
                            else{
                            ElementRoutier er = m_controleur.selectionnerElementRoutier(evt.getX(), evt.getY(), echelle);
                            }
                               
                            break;
                        
                        case INTERSECTION:
                            m_controleur.ajouterIntersection(evt.getX(), evt.getY(), echelle);
                            boolean intersectionAjoutee = true;
                            afficheurReseau.setDimension(intersectionAjoutee);
                            defilementAfficheur.setViewportView(afficheurReseau);   
                            miseAjourSelectionIntersectionsAjout();
                            break;
                            
                        case TRONCON:
                            m_controleur.construireTroncon(evt.getX(), evt.getY(), echelle);
                            break;
                            
                        default:
                            break;
                    }
                break;
                case TRANSPORT:                   
                    switch (m_commande_courante)
                    {                        
                        
                        case SELECTIONNER:
                            m_controleur.deselectionnerRoutier();
                            ElementTransport et = m_controleur.selectionnerElementTransport(evt.getX(), evt.getY(), echelle);
                            break;
                        
                        case AJOUTERCIRCUIT:
                            m_controleur.ajouterCircuit(evt.getX(), evt.getY(), echelle);
                            miseAjourSelectionCrcuitsAjout();
                            break;
                            
                        case EDITERCIRCUIT:
                            Circuit circ = m_controleur.obtenirCircuitSelectionne();
                            if (circ!=null){
                                m_controleur.editerCircuit(circ,evt.getX(), evt.getY(), echelle);
                            }
                            break;
                            
                        case SOURCE:
                            ElementRoutier elemRoutie = m_controleur.selectionnerElementRoutier(evt.getX(), evt.getY(), echelle);
                            if (elemRoutie != null){
                                if (elemRoutie.getClass() == Troncon.class){
                                    m_controleur.ajouterSource(evt.getX(), evt.getY(), echelle);
                                    m_controleur.deselectionnerRoutier();
                                }
                            }                                
                            break;                  
                        case ARRET:
                            ElementRoutier elemRoutier = m_controleur.selectionnerElementRoutier(evt.getX(), evt.getY(), echelle);
                            if (elemRoutier != null){
                                if (elemRoutier.getClass() == Troncon.class || elemRoutier.getClass() == Intersection.class){
                                    m_controleur.ajouterArret(evt.getX(), evt.getY(), echelle);
                                    m_controleur.deselectionnerRoutier();
                                }
                                else if (elemRoutier.getClass() == Intersection.class){
                                    m_controleur.ajouterArret(evt.getX(), evt.getY(), echelle);
                                m_controleur.deselectionnerRoutier();
                                }   
                            }
                            break;
                            
                        default:
                            break;
                    }
                case SIMULATION:
                    
                    break;
                    
                    
                default:
                    break;
            }
        }
        else if (SwingUtilities.isRightMouseButton(evt))
        {
            switch (m_mode_courant)
            {                
                case ROUTIER:                  
                    m_controleur.deselectionnerRoutier();
                    ElementRoutier elemRoutier = m_controleur.selectionnerElementRoutier(evt.getX(), evt.getY(), echelle);
                    if (elemRoutier!=null){
                        jPopupMenu1.show(this.afficheurReseau,evt.getX(),evt.getY());
                    }
                    break;
                    
                case TRANSPORT:
                    switch (m_commande_courante)
                    {                                              
                        case AJOUTERCIRCUIT:
                            m_controleur.cancellerCircuit();
                            break;
                    
                        default:
                            break;
                    }
            }
        }
        this.afficheurCommandes.repaint();
    }//GEN-LAST:event_afficheurReseauMousePressed

    private void miseAjourSelectionCrcuitsAjout(){
        for (ListIterator<Circuit> circuits =m_controleur.getTransport().getListeCircuits().listIterator() ; circuits.hasNext() ; ){
                boolean add = true;
                Circuit circuit = circuits.next();
                String name = circuit.getNom();
                for (int i = 0 ; i < selectionCircuit.getItemCount();i++ ){
                    String tmp = (String)selectionCircuit.getItemAt(i);
                    if(tmp == name){
                     add = false;
                    }
                }
                if(add){
                     selectionCircuit.addItem(circuit.getNom());
                 }
              }
    }
    
    private void miseAjourSelectionIntersectionsAjout(){
        System.out.println("yoyoyoyo");
        for (ListIterator<Intersection> intersections = m_controleur.getRoutier().getIntersections().listIterator() ;intersections.hasNext() ; ){
            Intersection intersection= intersections.next();
            boolean add = true;
            String name = intersection.getName();
            for (int i =0; i<comboBoxIntersections.getItemCount();i++ ){
                String tmp = (String)comboBoxIntersections.getItemAt(i);
                if(tmp == name){
                     add = false;
                    }
            }
            if(add){
                     comboBoxIntersections.addItem(intersection.getName());
                 }
        }
    }
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

    private void selectionRoutierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectionRoutierActionPerformed
        this.setCommande(Commandes.SELECTIONNER);
    }//GEN-LAST:event_selectionRoutierActionPerformed

    private void ajoutIntersectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajoutIntersectionActionPerformed
        
        this.setCommande(Commandes.INTERSECTION);
        m_controleur.deselectionnerRoutier();
        
        this.afficheurCommandes.repaint();
    }//GEN-LAST:event_ajoutIntersectionActionPerformed

  
    private void constructionTronconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_constructionTronconActionPerformed
        
        this.setCommande(Commandes.TRONCON);
        m_controleur.deselectionnerRoutier();
        
        this.afficheurCommandes.repaint();
    }//GEN-LAST:event_constructionTronconActionPerformed

    private void suppressionRoutierActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        
        boolean intersectionSupprimee = false;
        switch (m_commande_courante)
        {
            case SELECTIONNER:
                intersectionSupprimee = m_controleur.supprimerSelectionRoutier();
                break;
                
            default:
                break;
        }
        
        //afficheurReseau.setDimension(intersectionSupprimee);
        //defilementAfficheur.setViewportView(afficheurReseau);
        this.afficheurCommandes.repaint();
    }                                                

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        LinkedList<ElementRoutier> elementsSelectionnes = m_controleur.getElementsSelectionnesRoutier();
        assert(elementsSelectionnes.size() == 1);
        ElementRoutier elem = elementsSelectionnes.getFirst();
        
        //ouvrir une fenetre contextuelle qui agit sur elem, dependamment du type d'elem
        if(elem.getClass() == Intersection.class){
            EditerIntersection fenetre = new EditerIntersection();
            fenetre.setIntersection((Intersection) elem);
            fenetre.setResizable(false);
            fenetre.setLocationRelativeTo(null); //pour centrer
            fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            fenetre.setVisible(true);
        }
        else if (elem.getClass() == Troncon.class){
            EditerTroncon fenetre = new EditerTroncon();
            fenetre.setTroncon((Troncon) elem);
            fenetre.setResizable(false);
            fenetre.setLocationRelativeTo(null); //pour centrer
            fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            fenetre.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        LinkedList<ElementRoutier> elementsSelectionnes = m_controleur.getElementsSelectionnesRoutier();
        assert(elementsSelectionnes.size() == 1);
        ElementRoutier elem = elementsSelectionnes.getFirst();
        
        m_controleur.supprimerSelectionRoutier();
        this.afficheurCommandes.repaint();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void selectionTransportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectionTransportActionPerformed
        this.setCommande(Commandes.SELECTIONNER);
    }//GEN-LAST:event_selectionTransportActionPerformed

    private void ajoutArretActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajoutArretActionPerformed
        this.setCommande(Commandes.ARRET);
        m_controleur.deselectionnerTransport();
        m_controleur.deselectionnerRoutier();
        this.afficheurCommandes.repaint();
    }//GEN-LAST:event_ajoutArretActionPerformed

    private void ajoutCircuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajoutCircuitActionPerformed
        this.setCommande(Commandes.AJOUTERCIRCUIT);
    }//GEN-LAST:event_ajoutCircuitActionPerformed

    private void suppressionTransportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suppressionTransportActionPerformed

    }//GEN-LAST:event_suppressionTransportActionPerformed

    private void ajoutSourceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajoutSourceActionPerformed
         this.setCommande(Commandes.SOURCE);
    }//GEN-LAST:event_ajoutSourceActionPerformed

    private void afficheurReseauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_afficheurReseauMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_afficheurReseauMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void selectionCircuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectionCircuitActionPerformed
        int index = selectionCircuit.getSelectedIndex();
        String name =(String) selectionCircuit.getItemAt(index);
        m_controleur.deselectionnerTout();
        for (ListIterator<Circuit> circuits =m_controleur.getTransport().getListeCircuits().listIterator() ; circuits.hasNext() ; ){
            Circuit circuit = circuits.next();
              if (circuit.getNom().equals(name)){
                  for(PaireArretTrajet ArretTrajet : circuit.getListeArretTrajet()){
                  ElementTransport arret = ArretTrajet.getArret();
                  arret.changerStatutSelection();
                  }
                  circuit.changerStatutSelection();
                  break;
              }
          }
        this.afficheurCommandes.repaint();
    }//GEN-LAST:event_selectionCircuitActionPerformed

    private void comboBoxIntersectionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxIntersectionsActionPerformed
        int index = comboBoxIntersections.getSelectedIndex();
        String name =(String) comboBoxIntersections.getItemAt(index);
        m_controleur.deselectionnerTout();
        for (ListIterator<Intersection> intersections = m_controleur.getRoutier().getIntersections().listIterator() ;intersections.hasNext() ; ){
            Intersection intersection= intersections.next();
            System.out.println("Compare");
            System.out.println(name);
            System.out.println(intersection.getName());
              if (intersection.getName().equals(name)){
                      intersection.changerStatutSelection();
                      break;
              }
          }
        this.afficheurCommandes.repaint();
    }//GEN-LAST:event_comboBoxIntersectionsActionPerformed

    private void editerCircuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editerCircuitActionPerformed
       this.setCommande(Commandes.EDITERCIRCUIT);
    }//GEN-LAST:event_editerCircuitActionPerformed

    private void comboBoxTronconsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxTronconsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxTronconsActionPerformed

    private void playPauseSimulationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playPauseSimulationActionPerformed
        if(!m_simulationEstLancer ){
             lancerSimulation();
            m_simulationEstLancer = true;
         }
        else if (m_crono.estEnPause()){
            m_crono.start();
        }
        else{
            m_crono.pause();
        }
    }//GEN-LAST:event_playPauseSimulationActionPerformed

    private void pauseSimulationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pauseSimulationActionPerformed
        m_crono.avancerX2();
    }//GEN-LAST:event_pauseSimulationActionPerformed

    private void avancerSimulationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_avancerSimulationActionPerformed
        m_crono.ralentirX2();
    }//GEN-LAST:event_avancerSimulationActionPerformed
    
    /**
     * @param args the command line arguments
     */
    private void changeLookAndFeel(){
         try {
             for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if("javax.swing.plaf.nimbus.NimbusLookAndFeel".equals(info.getClassName())){
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
        
        
    }
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
        boutonsSelectionRoutier.setVisible(false);
        boutonsTransport.setVisible(false);
        boutonsSelectionTransport.setVisible(false);
        //boutonsBesoins.setVisible(false);
        boutonsSimulation.setVisible(false);
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
    private javax.swing.JToggleButton ajoutArret;
    private javax.swing.JToggleButton ajoutCircuit;
    private javax.swing.JToggleButton ajoutIntersection;
    private javax.swing.JToggleButton ajoutSource;
    private javax.swing.JButton avancerSimulation;
    private javax.swing.JToggleButton besoins;
    private javax.swing.JPanel boutonModes;
    private javax.swing.JPanel boutonsRoutier;
    private javax.swing.JPanel boutonsSelectionRoutier;
    private javax.swing.JPanel boutonsSelectionTransport;
    private javax.swing.JPanel boutonsSimulation;
    private javax.swing.JPanel boutonsTransport;
    private javax.swing.JComboBox comboBoxArrets;
    private javax.swing.JComboBox comboBoxIntersections;
    private javax.swing.JComboBox comboBoxSources;
    private javax.swing.JComboBox comboBoxTroncons;
    private javax.swing.JToggleButton constructionTroncon;
    private javax.swing.JScrollPane defilementAfficheur;
    private javax.swing.JButton editerCircuit;
    private javax.swing.JMenu fichier;
    private javax.swing.ButtonGroup groupeModes;
    private javax.swing.ButtonGroup groupeRoutier;
    private javax.swing.ButtonGroup groupeTransport;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menu;
    private javax.swing.JButton pauseSimulation;
    private javax.swing.JToggleButton playPauseSimulation;
    private javax.swing.JMenuItem quitter;
    private javax.swing.JToggleButton routier;
    private javax.swing.JComboBox selectionCircuit;
    private javax.swing.JToggleButton selectionRoutier;
    private javax.swing.JToggleButton selectionTransport;
    private javax.swing.JToggleButton simulation;
    private javax.swing.JButton suppressionRoutier;
    private javax.swing.JButton suppressionTransport;
    private javax.swing.JToggleButton transport;
    private javax.swing.JLabel wtf;
    private javax.swing.JLabel wtf2;
    // End of variables declaration//GEN-END:variables
}

