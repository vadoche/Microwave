/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domaine.Affichage;

import Domaine.Utilitaire.PaireFloats;
import Domaine.ReseauRoutier.Emplacement;
import Domaine.ReseauRoutier.Troncon;
import Domaine.ReseauTransport.*;

//import java.awt.Dimension;

import java.awt.BasicStroke;
import java.awt.Color;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;

import java.util.ListIterator;

/**
 *
 * @author Nathaniel
 */
public class DessinateurTransport {
    
    //private final Dimension m_dimensionInitiale;
    
    private final ReseauTransport m_reseau;
    private Boolean m_transparence;
    
    public DessinateurTransport(ReseauTransport p_reseau, Boolean transparence){//, Dimension p_dimensionInitiale){
        m_reseau = p_reseau;
        m_transparence = transparence;
    }
    
    public void dessinerArrets(Graphics2D p_g, float p_echelle)
    {
        for (Arret arret : m_reseau.getListeArrets()){

            Point2D.Float position = arret.getEmplacement().calculPosition(p_echelle);
            float x = position.x -   arret.RAYON / p_echelle;
            float y = position.y -   arret.RAYON / p_echelle;
            float diametre = 2 *   arret.RAYON / p_echelle;
            if (m_reseau.getPileSelection().contient(arret) || m_reseau.getElementCurseur()==arret){
                float grossisement = 1.35f;
                float sx = position.x -   grossisement*arret.RAYON / p_echelle;
                float sy = position.y -   grossisement*arret.RAYON / p_echelle;
                float sdiametre = grossisement*2 *   arret.RAYON / p_echelle;
                if(m_reseau.getPileSelection().contient(arret)){
                    p_g.setColor(new Color(50,200,255 , 200));
                    p_g.fill(new Ellipse2D.Float(sx, sy, sdiametre, sdiametre));
                }
                else{
                    p_g.setColor(new Color(255,200,0 , 130));
                    p_g.fill(new Ellipse2D.Float(sx, sy, sdiametre, sdiametre));
                }
                
            }
            p_g.setColor(new Color(0x70FF0000, m_transparence));
            p_g.fill(new Ellipse2D.Float(x, y, diametre, diametre));
            //p_g.fill(octogone(x,y,diametre*2/3));
        }
    }
    
    private Path2D.Float octogone(Float x, Float y, Float diametre){
        Path2D.Float octopath = new Path2D.Float();  
        x+=diametre;
        y+=diametre;
        Float angle1 = (float) Math.PI/8.0f;
        octopath.moveTo(x + diametre*Math.cos(angle1), y + diametre*Math.sin(angle1));
        angle1 += (float) Math.PI/4.0f;
        for(int i = 1; i <8; i++){
            octopath.lineTo(x + diametre*Math.cos(angle1), y + diametre*Math.sin(angle1));
            angle1 += (float) Math.PI/4.0f;
        }
        octopath.closePath();
        return octopath;
    }
    
    public void dessinerCircuit(Graphics2D p_g, float p_echelle)
    {        
        Graphics2D select_g = (Graphics2D) p_g.create();
        
        select_g.setStroke(new BasicStroke(Troncon.LARGEUR*1.35f/p_echelle));
        
        for (Circuit circuit: m_reseau.getListeCircuits())
        {
            p_g.setColor(new Color(0x70FFFFFF & circuit.getCouleur().getRGB(), m_transparence));
            p_g.setStroke(new BasicStroke(Troncon.LARGEUR / p_echelle, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{10 / p_echelle}, 0));
            
            if(m_reseau.getPileSelection().contient(circuit)){
                select_g.setColor(new Color(50,200,255 , 200));
            }
            else if(m_reseau.getElementCurseur()==circuit){
                select_g.setColor(new Color(255,200,0 , 130));
            }
            
            
            Path2D.Float chemin = new Path2D.Float();
            for (ListIterator<PaireArretTrajet> itPaire = circuit.getListeArretTrajet().listIterator() ; itPaire.hasNext() ; )
            {
                PaireArretTrajet paire = itPaire.next();
                if (paire.getArret().getEmplacement().estSurTroncon())
                {
                    Point2D.Float positionArret = paire.getArret().getEmplacement().calculPosition(p_echelle);
                    chemin.moveTo(positionArret.x, positionArret.y);
                }
                
                if (paire.getTrajet() != null)
                {
                    ListIterator<Troncon> itTroncon = paire.getTrajet().getListeTroncons().listIterator();
                    while (itTroncon.hasNext())
                    {
                        Troncon troncon = itTroncon.next();
                        Point2D.Float p1 = troncon.getOrigine().getPosition();
                        Point2D.Float p2 = troncon.getDestination().getPosition();
                        
                        PaireFloats pAj = troncon.ajusterSiDoubleSens(p1, p2, p_echelle);
                        Float ajX = pAj.getFloat1();
                        Float ajY = pAj.getFloat2();
                        
                        if (itTroncon.previousIndex() != 0 || !paire.getArret().getEmplacement().estSurTroncon())
                            chemin.moveTo(p1.x + ajX, p1.y + ajY);
                        
                        if (itTroncon.hasNext())
                            chemin.lineTo(p2.x + ajX, p2.y + ajY);

                        else if (itPaire.hasNext())
                        {
                            Emplacement emplacementProchainArret = itPaire.next().getArret().getEmplacement();
                            Point2D.Float positionProchainArret = emplacementProchainArret.calculPosition(p_echelle);
                            if (emplacementProchainArret.estSurTroncon())
                            {
                                chemin.lineTo(positionProchainArret.x, positionProchainArret.y);
                            }
                            else
                            {
                                chemin.lineTo(positionProchainArret.x + ajX, positionProchainArret.y + ajY);
                            }
                            itPaire.previous();
                        }
                    }
                }
            }
            if(m_reseau.getPileSelection().contient(circuit) || m_reseau.getElementCurseur()==circuit)
                select_g.draw(chemin);
            p_g.draw(chemin); 
            
        }

    }
      public void dessinerSourceAutobus(Graphics2D p_g, float p_echelle)
    {
          for (ListIterator<Circuit> circuits = m_reseau.getListeCircuits().listIterator() ; circuits.hasNext() ; ){
            Circuit circuit = circuits.next();
                for (ListIterator<SourceAutobus> sources =circuit.getListeSources().listIterator(); sources.hasNext() ; ){
                    SourceAutobus source  = sources.next();
                Path2D.Float losange = new Path2D.Float();  

                Emplacement em = source.getEmplacement();                
                Point2D.Float position = em.calculPosition(p_echelle);
                if (m_reseau.getPileSelection().contient(source) || m_reseau.getElementCurseur()==source){
                    Path2D.Float slosange = new Path2D.Float();  
                    float grossisement = 1.4f;
                    float sy1 = position.y - grossisement*SourceAutobus.LARGEUR / 2 / p_echelle;
                    float sx1 = position.x + grossisement*SourceAutobus.LARGEUR / 2 / p_echelle;
                    float sy2 = sy1 + grossisement*SourceAutobus.LARGEUR / p_echelle;
                    float sx2 = sx1 - grossisement*SourceAutobus.LARGEUR / p_echelle;
                    
                    slosange.moveTo(position.x, sy1);
                    slosange.lineTo(sx1, position.y);
                    slosange.lineTo(position.x, sy2);
                    slosange.lineTo(sx2, position.y);
                    slosange.closePath();
                
                    if(m_reseau.getPileSelection().contient(source)){
                        p_g.setColor(new Color(50,200,255 , 200));
                    }
                    else{
                        p_g.setColor(new Color(255,200,0 , 130));
                    }
                    p_g.fill(slosange);
                    
                }
                p_g.setColor(new Color(0x70FFFFFF & circuit.getCouleur().getRGB(), m_transparence));
                float y1 = position.y - SourceAutobus.LARGEUR / 2 / p_echelle;
                float x1 = position.x + SourceAutobus.LARGEUR / 2 / p_echelle;
                float y2 = y1 + SourceAutobus.LARGEUR / p_echelle;
                float x2 = x1 - SourceAutobus.LARGEUR / p_echelle;
                
                losange.moveTo(position.x, y1);
                losange.lineTo(x1, position.y);
                losange.lineTo(position.x, y2);
                losange.lineTo(x2, position.y);
                losange.closePath();
                
                p_g.fill(losange);
                
            }
        }
    }
    }


