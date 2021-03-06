/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domaine.ReseauTransport;

/**
 *
 * @author Nathaniel
 */
import Domaine.ReseauRoutier.Emplacement;
import Domaine.ReseauRoutier.Troncon;
import java.util.LinkedList;
import java.util.ListIterator;

public class Trajet implements java.io.Serializable {
    private Emplacement m_emplacementInitial;
    private Emplacement m_emplacementFinal;
    private LinkedList<Troncon> m_listTroncons;
    
    public Trajet(Emplacement emplacementInitial, Emplacement emplacementFinal, LinkedList<Troncon> listTroncons){
        m_emplacementInitial = emplacementInitial;
        m_emplacementFinal = emplacementFinal;
        m_listTroncons = listTroncons;
    }
    
//    public Trajet(){
//        m_listTroncons = new LinkedList<>();
//    }
    
    public Emplacement getEmplacementInitial(){
        return m_emplacementInitial;
    }
    
    public Emplacement getEmplacementFinal(){
        return m_emplacementFinal;
    }
    
    public void setEmplacementInitial(Emplacement empl){
        m_emplacementInitial = empl;
    }
    
    public void setEmplacementFinal(Emplacement empl){
        m_emplacementFinal = empl;
    }
    
    public Troncon getNextTroncon(Emplacement emplacement) {
        if (!emplacement.estSurTroncon()) {
            ListIterator<Troncon> troncon1 = m_listTroncons.listIterator();
            while (troncon1.hasNext()) {
                ListIterator<Troncon> troncon2 = emplacement.getIntersection().getTroncons().listIterator();
                Troncon tr1 = troncon1.next();
                while (troncon2.hasNext()) {
                    if (troncon2.next().equals(tr1)) {
                        return tr1;
                    }
                }
            }

        }
        boolean trg= false;
        ListIterator<Troncon> troncon_it = m_listTroncons.listIterator();
        while (troncon_it.hasNext()) {

            Troncon tr = troncon_it.next();
            if (trg){
                return tr;
            }
            if(tr.equals(emplacement.getTroncon())){
                trg = true;
            }
        }
        return null;
    }
    
    public LinkedList<Troncon> getListeTroncons(){
        return m_listTroncons;
    }
    
    public void setListeTroncons(LinkedList<Troncon> listeTroncons){
        m_listTroncons = listeTroncons;
    }
}
