/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domaine.ReseauTransport;


/**
 *
 * @author louis
 */
import Domaine.ReseauRoutier.Troncon;
import Domaine.Utilitaire.AlternateurCouleurs;
import Domaine.Utilitaire.Temps;
import java.awt.geom.Point2D;

import java.awt.Font;
import java.awt.font.GlyphVector;
import java.awt.font.FontRenderContext;

import java.util.LinkedList;
import java.util.ListIterator;
import java.awt.Color;

public class Circuit extends ElementTransport{
    private LinkedList<PaireArretTrajet> m_listeArretTrajet;
    private String m_nom = "";
    private GlyphVector m_representationNom;
    private Boolean m_peutBoucler = false;
    private Boolean m_veutBoucler = false;
    private Color m_couleur = null;
    
    private LinkedList<SourceAutobus> m_listeSources = new LinkedList<>();
    
    private LinkedList<Autobus> m_listeAutobus = new LinkedList<>();
    
    public Circuit(LinkedList<PaireArretTrajet> listeArrTraj){
        //assert listeArrTraj doit avoir les 2 premiers
        m_listeArretTrajet = listeArrTraj;
    }
    
    public LinkedList<Autobus> getListeAutobus(){
        return m_listeAutobus;
    }
    public LinkedList<SourceAutobus> getListeSources(){
        return m_listeSources;
    }
    public void updateSourceAutobus(Temps deltatT){
         ListIterator<SourceAutobus> sourceAutobusItr = m_listeSources.listIterator();
        while (sourceAutobusItr.hasNext()) {
            SourceAutobus src = sourceAutobusItr.next();
            src.miseAJourTempsRestant(deltatT);
            src.genererAutobus(deltatT);
        }
    }
    public void setNom(String p_nom){
        m_nom = p_nom;       
    }
    
    public void initRepresentation(){
        Font a = new Font(null, Font.BOLD, 12);
        m_representationNom = a.createGlyphVector(new FontRenderContext(null, false, false), m_nom);
        double ajY = m_representationNom.getVisualBounds().getHeight();
        
        for (int i = 0 ; i< m_nom.length() ; i++)
        {
            Point2D position = m_representationNom.getGlyphPosition(i);
            position.setLocation(position.getX(), position.getY() + ajY);
            m_representationNom.setGlyphPosition(i, position);
        } 
    }
    
    public void clearRepresentation(){
        m_representationNom = null;
    }
    
    public String getNom(){
        return m_nom;
    }
    public GlyphVector getRepresentationNom(){
        return m_representationNom;
    }
    public void ajouterSource(SourceAutobus source){
        m_listeSources.add(source);
    }
    
    public void ajouterAutobus(Autobus autobus){
        m_listeAutobus.add(autobus);
    }
    

    public void ajouterPaire(Arret arr, Trajet traj){
        assert(m_listeArretTrajet.getLast().getArret().getEmplacement().equals(traj.getEmplacementInitial()));
        assert(arr.getEmplacement().equals(traj.getEmplacementFinal()));
        
        m_listeArretTrajet.add(new PaireArretTrajet(arr, traj));
    }
    
    public void calculCirculationGlobal(Temps deltatT){
        
        //pour chaque autobus on calcule la circulation
        ListIterator<Autobus> autobusItr = m_listeAutobus.listIterator();
        while (autobusItr.hasNext()) {
            Autobus aut = autobusItr.next();
            if (aut.asTerminer()){
                autobusItr.remove();
            }
            else{
                calculCirculation(deltatT, aut);
            }
        }
    }
    
    public void calculCirculation(Temps deltaT, Autobus bus){
        bus.miseAJourAutobus(deltaT);
    }
    
    public LinkedList<Point2D.Float> getPositionsDesAutobus(Float p_echelle){
        
        LinkedList<Point2D.Float> listePositionsAutobus = new LinkedList<>();
        ListIterator<Autobus> autobusItr = m_listeAutobus.listIterator();
        while (autobusItr.hasNext()) {
            listePositionsAutobus.add(autobusItr.next().getPosition(p_echelle));
        }
        
        return listePositionsAutobus;
    }
    
    public LinkedList<PaireArretTrajet> getListeArretTrajet(){
        return m_listeArretTrajet;
    }
    
    public void incrementerIterateurAutobus(Autobus bus){
        bus.incrementerIterateur();
    }
    
    public void assignerTrajetAutobus(Autobus bus){
        bus.assignerTrajet(m_listeArretTrajet, (m_peutBoucler && m_veutBoucler), this);
    }
    
    public void initCircuit(){
        ListIterator<SourceAutobus> sourceAutobusItr = m_listeSources.listIterator();
        while (sourceAutobusItr.hasNext()) {
            sourceAutobusItr.next().initSourceAutobus();
        }
        initRepresentation();
    }
    
    public void setPeutBoucler(Boolean boucle){
        m_peutBoucler = boucle;
    }
    public Boolean peutBoucler(){
        return m_peutBoucler;
    }
    public void setVeutBoucler(Boolean veutBoucler){
        m_veutBoucler = veutBoucler;
    }
    public Boolean veutBoucler(){
        return m_veutBoucler;
    }
    
    public LinkedList<Troncon> obtenirTroncons()
    {
        LinkedList<Troncon> tronconsCircuit = new LinkedList<>();
        for (PaireArretTrajet paire : m_listeArretTrajet)
        {
            if (paire.getTrajet() != null)
                tronconsCircuit.addAll(paire.getTrajet().getListeTroncons());  // Obtient certains troncons en double, mais on s'en calis.
        }
        return tronconsCircuit;
    }
    
    public Color getCouleur(){
        if(m_couleur==null){
            setCouleur(AlternateurCouleurs.getCouleurCircuit());
        }
        return m_couleur;
    }
    
    public void setCouleur(Color couleur){
        m_couleur = couleur;
    }
}
