package Domaine.Affichage;

import Domaine.Utilitaire.PaireFloats;
import Domaine.ReseauRoutier.*;

//import java.awt.Dimension;

import java.awt.Color;

import java.awt.BasicStroke;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Ellipse2D;

import java.awt.geom.Path2D;

import java.util.LinkedList;

/**
 *
 * @author Vinny
 */
public class DessinateurRoutier
{
    //private final Dimension m_dimensionInitiale;
    
    private final ReseauRoutier m_reseau;

    public DessinateurRoutier(ReseauRoutier p_reseau) //, Dimension p_dimensionInitiale)
    {
        m_reseau = p_reseau;
        //this.m_dimensionInitiale = p_dimensionInitiale;
    }

//    public void dessiner(Graphics2D p_g)
//    {
//        float echelle = (float)p_g.getTransform().getScaleX();
//        if (echelle > 1)
//        {
//            dessinerTroncons(p_g, echelle);
//            dessinerIntersections(p_g, echelle);
//        }
//        else
//        {
//            dessinerTroncons(p_g, 1);
//            dessinerIntersections(p_g, 1);
//        }
//    }

    public void dessinerIntersections(Graphics2D p_g, float p_echelle)
    {
        LinkedList<Intersection> intersections = m_reseau.getIntersections();
        for (Intersection intersection: intersections)
        {
            Point2D.Float position = intersection.getPosition();
            float x = position.x - Intersection.RAYON / p_echelle;
            float y = position.y - Intersection.RAYON / p_echelle;
            float diametre = 2 * Intersection.RAYON / p_echelle;
            if (m_reseau.getPileSelection().contient(intersection) || m_reseau.getElementCurseur()==intersection){
                float grossisement = 1.35f;
                float sx = position.x -   grossisement*Intersection.RAYON / p_echelle;
                float sy = position.y -   grossisement*Intersection.RAYON / p_echelle;
                float sdiametre = grossisement*2 *   Intersection.RAYON / p_echelle;
                if(m_reseau.getPileSelection().contient(intersection)){
                    p_g.setColor(new Color(50,200,255 , 200));
                    p_g.fill(new Ellipse2D.Float(sx, sy, sdiametre, sdiametre));
                }
                else{
                    p_g.setColor(new Color(255,200,0 , 130));
                    p_g.fill(new Ellipse2D.Float(sx, sy, sdiametre, sdiametre));
                }
            }
               p_g.setColor(Color.BLACK);
            p_g.fill(new Ellipse2D.Float(x, y, diametre, diametre));
        }
    }

    public void dessinerTroncons(Graphics2D p_g, float p_echelle)
    {
        Graphics2D select_g = (Graphics2D) p_g.create();
        select_g.setColor(Color.LIGHT_GRAY);
        select_g.setStroke(new BasicStroke(Troncon.LARGEUR / p_echelle));
        p_g.setStroke(new BasicStroke(Troncon.LARGEUR / p_echelle));

        LinkedList<Intersection> intersections = m_reseau.getIntersections();
        for (Intersection intersection: intersections)
        {
            Point2D.Float p1 = intersection.getPosition();
            
            for (Troncon troncon: intersection.getTroncons())
            {   
                p_g.setStroke(new BasicStroke(Troncon.LARGEUR / p_echelle));
                
                if (troncon.estSuggere())
                    p_g.setColor(Color.ORANGE);          
                else if (m_reseau.getPileSelection().contient(troncon)){
                    p_g.setColor(new Color(50,200,255 , 200));
                }
                else if (m_reseau.getElementCurseur()==troncon){
                    p_g.setColor(new Color(255,200,0 , 130));
                }
                else 
                    p_g.setColor(Color.LIGHT_GRAY);
                    
                Point2D.Float p2 = troncon.getDestination().getPosition();

                Path2D.Float fleche = new Path2D.Float();  
                
                PaireFloats pAj = troncon.ajusterSiDoubleSens(p1, p2, p_echelle);
                Float ajX = pAj.getFloat1();
                Float ajY = pAj.getFloat2();
                
                Float p1x = p1.x + ajX;
                Float p1y = p1.y + ajY;
                Float p2x = p2.x + ajX;
                Float p2y = p2.y + ajY;
                
                fleche.moveTo(p1x, p1y);
                fleche.lineTo(p2x, p2y);
                
                if(m_reseau.getPileSelection().contient(troncon) || m_reseau.getElementCurseur()==troncon){
                    p_g.setStroke(new BasicStroke(Troncon.LARGEUR*2.0f / p_echelle));
                }
                
                p_g.draw(fleche);
                if(m_reseau.getPileSelection().contient(troncon) || m_reseau.getElementCurseur()==troncon){
                    select_g.draw(fleche);
                }
                
                float d = (float)p2.distance(p1);
                float dx = p2x - p1x;
                float dy = p2y - p1y;

                if(troncon.estDoubleSens()){
                    fleche.moveTo(p1x + 0.5 * dx + (Troncon.GROSSEUR_FLECHE * dx / d) / p_echelle, 
                            p1y + 0.5 * dy + (Troncon.GROSSEUR_FLECHE * dy / d) / p_echelle);
                    fleche.lineTo(p1x + 0.5 * dx + (Troncon.GROSSEUR_FLECHE / 2 * -dy / d) / p_echelle, 
                            p1y + 0.5 * dy + (Troncon.GROSSEUR_FLECHE / 2 * dx / d) / p_echelle);
                    fleche.lineTo(p1x + 0.5 * dx, p1y + 0.5 * dy);                    
                }
                else{
                    fleche.moveTo(p1x + 0.5 * dx + (Troncon.GROSSEUR_FLECHE * dx / d) / p_echelle, 
                            p1y + 0.5 * dy + (Troncon.GROSSEUR_FLECHE * dy / d) / p_echelle);
                    fleche.lineTo(p1x + 0.5 * dx + (Troncon.GROSSEUR_FLECHE / 2 * -dy / d) / p_echelle, 
                            p1y + 0.5 * dy + (Troncon.GROSSEUR_FLECHE / 2 * dx / d) / p_echelle);
                    fleche.lineTo(p1x + 0.5 * dx + ((Troncon.GROSSEUR_FLECHE / 2) * (dy / d)) / p_echelle, 
                            p1y + 0.5 * dy + ((Troncon.GROSSEUR_FLECHE / 2) * (-dx / d)) / p_echelle);
                }
                fleche.closePath();
                
                p_g.fill(fleche);  
                if(m_reseau.getPileSelection().contient(troncon) || m_reseau.getElementCurseur()==troncon){
                    select_g.fill(fleche);
                }
            }
        }
    }
}
