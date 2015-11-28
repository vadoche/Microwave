package Domaine.ReseauRoutier;

/**
 *
 * @author Nathaniel
 */
import Domaine.Utilitaire.*;
import java.awt.geom.Point2D;

public class Troncon extends ElementRoutier{
    private String m_nom = "";
    private Temps m_tempsTransitAutobus;
    private Distribution m_distribution;
    private Temps m_tempsTransitPieton;
    private final Intersection m_destination;
    private Boolean m_doubleSens = false;
    private Intersection m_origine;
    private double m_longueur;
    
    public final static float LARGEUR = 7;
    public final static float LARGEUR_TERREPLEIN = 5;
    public final static float GROSSEUR_FLECHE = 40;


    public Troncon(Intersection p_origine, Intersection p_destination)
    {
        m_origine = p_origine;
        m_destination =  p_destination;
        
        m_distribution = new Distribution();
        m_longueur = p_origine.getPosition().distance(p_destination.getPosition());
        m_tempsTransitPieton = new Temps(m_longueur / ReseauRoutier.VITESSE_PIETON);
       
    }
    public void updateTempsTransitPieton(){
        m_tempsTransitPieton = new Temps(m_longueur / ReseauRoutier.VITESSE_PIETON);
    }
    public void setTempsTransit(){
        m_tempsTransitAutobus = m_distribution.pigerTemps();
    }
    public void setDoubleSens(){
        Boolean doubleSens = false;
        for (Troncon trcDest: this.getDestination().getTroncons()){
            for (Troncon trcOrig: trcDest.getDestination().getTroncons()){
                if (trcOrig == this){
                    doubleSens = true;
                    break;
                }
            }
        }       
        m_doubleSens = doubleSens;
    }
    public Boolean estDoubleSens(){
        return m_doubleSens;
    }
    
    public Temps getTempsTransitAutobus(){
        return m_tempsTransitAutobus;
    }
    public Temps getTempsTransitPieton(){
        return m_tempsTransitPieton;
    }
    public void setDistribution(Distribution p_distribution){
        m_distribution = p_distribution;
    }
    public Distribution getDistribution(){
        return m_distribution;
    }
    public Intersection getDestination(){
        return m_destination;
    }
    public String getNom(){
        return m_nom;
    }
    public void setNom(String p_nom){
        m_nom = p_nom;
    }

    public void initTroncon(){
        m_tempsTransitAutobus = m_distribution.pigerTemps(); //nope !
    }

    public void setIntersectionOrigin(Intersection p_intersectionOrigin){
         m_origine =  p_intersectionOrigin;
    }
    
    public Intersection getOrigine(){
        return  m_origine;
    }
    public float getLongueurTroncon(){
        return (float)m_longueur;
    }
    
    public PaireFloats ajusterSiDoubleSens(Point2D.Float p1, Point2D.Float p2, Float p_echelle){
        float ajX = 0;
        float ajY = 0;
        
        if(this.estDoubleSens()){
            float d = (float)p2.distance(p1);
            float dx = p2.x - p1.x;
            float dy = p2.y - p1.y;

            ajX = (LARGEUR_TERREPLEIN * -dy / d) / p_echelle;
            ajY = (LARGEUR_TERREPLEIN * dx / d) / p_echelle;
        }
        
        return new PaireFloats(ajX, ajY);
    }
}
