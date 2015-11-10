/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReseauTransport;

import Domaine.ReseauRoutier.Intersection;
import Domaine.ReseauRoutier.ReseauRoutier;
import Domaine.ReseauRoutier.Troncon;
import Domaine.Utilitaire.Distribution;
import Domaine.Utilitaire.Temps;
import Domaine.Utilitaire.Temps;
import java.util.LinkedList;
import java.util.ListIterator;
import junit.framework.TestCase;

/**
 *
 * @author Nathaniel
 */
public class AutobusTest extends TestCase {
    private LinkedList<Intersection> m_intersections = new LinkedList();
    private LinkedList<Troncon> m_troncons = new LinkedList();
    public AutobusTest(String testName) {
        super(testName);
        ReseauRoutier reseauRoutier = new ReseauRoutier();
        // Ajout des intersections
        Intersection intersection1 = reseauRoutier.ajouterIntersection(0.0f, 0.0f);
        Intersection intersection2 = reseauRoutier.ajouterIntersection(0.0f, 10.0f);
        Intersection intersection3 = reseauRoutier.ajouterIntersection(10.0f, 10.0f);
        Intersection intersection4 = reseauRoutier.ajouterIntersection(20.0f, 5.0f);
        //Ajout des Troncons Et deux distributions
        Distribution distribution1 =new Distribution(new Temps(10), new Temps(15), new Temps(20));
        Distribution distribution2 =new Distribution(new Temps(5), new Temps(10), new Temps(15));
        Troncon troncon1 = reseauRoutier.ajouterTroncon(intersection1, intersection4, distribution1, new Temps(4));
        Troncon troncon2 = reseauRoutier.ajouterTroncon(intersection1, intersection2, distribution2, new Temps(4));
        Troncon troncon3 = reseauRoutier.ajouterTroncon(intersection2, intersection3, distribution2, new Temps(4));
        Troncon troncon4 = reseauRoutier.ajouterTroncon(intersection3, intersection1, distribution2, new Temps(4));
        Troncon troncon5 = reseauRoutier.ajouterTroncon(intersection3, intersection4, distribution2, new Temps(4));
        //push dans les lists
        m_intersections.add(intersection1);
        m_intersections.add(intersection2);
        m_intersections.add(intersection3);
        m_intersections.add(intersection4);
        m_troncons.add(troncon1);
        m_troncons.add(troncon2);
        m_troncons.add(troncon3);
        m_troncons.add(troncon4);
        m_troncons.add(troncon5);
    }

    /**
     * Test of getPosition method, of class Autobus.
     */
    public void testGetPosition() {
       
    }

    /**
     * Test of getIterateur method, of class Autobus.
     */
    public void testGetIterateur() {
       
    }

    /**
     * Test of incrementerIterateur method, of class Autobus.
     */
    public void testIncrementerIterateur() {
        
    }

    /**
     * Test of assignerTrajet method, of class Autobus.
     */
    public void testAssignerTrajet() {
        
    }

    /**
     * Test of setID method, of class Autobus.
     */
    public void testSetID() {
        
    }

    /**
     * Test of getID method, of class Autobus.
     */
    public void testGetID() {
        
    }
    
}
