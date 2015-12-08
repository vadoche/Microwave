/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domaine.BesoinsTransport;

import Domaine.Reseau;

import Domaine.ReseauRoutier.Emplacement;
import Domaine.ReseauRoutier.Troncon;

import Domaine.ReseauTransport.ReseauTransport;

import Domaine.Statistiques.StatistiqueBesoin;
import Domaine.Statistiques.StatistiquesGeneral;

import Domaine.Utilitaire.Distribution;
import Domaine.Utilitaire.Distribution.Type;
import Domaine.Utilitaire.Temps;

import java.awt.geom.Point2D;
import java.awt.geom.Path2D;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 *
 * @author louis
 */
public class ReseauBesoins extends Reseau {
    
    private LinkedList<Individu> m_listeIndividus = new LinkedList<>();;
    private LinkedList<Itineraire> m_listeItineraires = new LinkedList<>();;
    private StatistiquesGeneral m_stat;
    private PileSelectionBesoins m_pileSelection = new PileSelectionBesoins();;
    private String m_nom;
    
    private Emplacement m_emplacementSourceTemp = null;
    
    private ReseauTransport m_reseauTransport;
    
    public ReseauBesoins(){
        m_stat = new StatistiquesGeneral();
    }
    
    public ReseauBesoins(LinkedList<Individu> p_listeIndividus, LinkedList<Itineraire> p_itineraire){
        m_listeIndividus = p_listeIndividus;
        m_listeItineraires = p_itineraire;
        m_stat = new StatistiquesGeneral();
    }
    public StatistiquesGeneral getStatistique(){
        return m_stat;
    }
    public LinkedList<Individu> getListIndividus(){
        m_listeIndividus.clear();
        for(Itineraire it : m_listeItineraires){
            for (Individu in : it.getListIndividu()){
                m_listeIndividus.add(in);
            }
        }  
        return m_listeIndividus;
    }
    public LinkedList<Itineraire> getListItineraire(){
         
        return m_listeItineraires;
    }

    public void setListIndividus(LinkedList<Individu> p_listeIndividus){
        m_listeIndividus = p_listeIndividus;
    }
    public void setListItineraire(LinkedList<Itineraire> p_itineraire){
        m_listeItineraires = p_itineraire;
    }

    public void initBesoinTransport(){
        for(Itineraire it : m_listeItineraires){
            it.initItineraire();
        }  
    }
            
    public PileSelectionBesoins getPileSelection(){
        return m_pileSelection;
    }
    

    public void deselectionnerTout(){
        m_pileSelection.vider();
    }
    public void setNom(String p_nom){
        m_nom = p_nom;
    }
    public void ajouterItineraire(Itineraire itn){
        if(itn != null){
            int number = m_listeItineraires.size();
            m_nom = "Itineraire".concat(Integer.toString(number +1));
            StatistiqueBesoin be = m_stat.creatStatBesoin(m_nom);
            Emplacement emplSrc;
            if(itn.getListPaireParcours().getFirst().getTrajet()!=null){
                emplSrc = itn.getListPaireParcours().getFirst().getTrajet().getEmplacementInitial();
            }
            else{
                emplSrc = itn.getListPaireParcours().getFirst().getParcoursBus().getArretDepart().getEmplacement();
            }
            SourceIndividus sour = new SourceIndividus(new Temps(0.0), new Distribution(Type.PIETON), emplSrc,"default"
                , itn, be);
            itn.asignerSource(sour);
            itn.setStat(be);
            m_listeItineraires.add(itn);
        }
    }
    
    public Boolean selectionnerItineraire(Float xReel, Float yReel, Float p_echelle, Troncon trc){
        if (trc!=null){
            Float pourcentageClic = trc.getPourcentageClic(xReel, yReel, p_echelle);
            Emplacement empl_deb = null;
            Emplacement empl_fin = null;
            Boolean itineraireSelectionne = false;
            for (Itineraire itn : m_listeItineraires){
                for (PaireParcours paireParc : itn.getListPaireParcours()){
                    if (paireParc.getTrajet() != null){
                        for (Troncon trc2 : paireParc.getTrajet().getListeTroncons()){
                            if (trc2.equals(trc)){
                                if (paireParc.getTrajet().getEmplacementInitial().estSurTroncon())
                                    empl_deb = paireParc.getTrajet().getEmplacementInitial();
                                if (paireParc.getTrajet().getEmplacementFinal().estSurTroncon())
                                    empl_fin = paireParc.getTrajet().getEmplacementFinal();
                                
                                if (empl_deb != null && empl_fin != null){
                                    if (empl_deb.getTroncon().equals(trc) && empl_fin.getTroncon().equals(trc)){
                                        if (empl_deb.getPourcentageParcouru() < empl_fin.getPourcentageParcouru()){
                                            //si entre
                                            if (pourcentageClic > empl_deb.getPourcentageParcouru() && 
                                                    pourcentageClic < empl_fin.getPourcentageParcouru()){
                                                itineraireSelectionne = true;
                                            }
                                        }
                                        else{
                                            //si avant ou apres
                                            if (pourcentageClic > empl_deb.getPourcentageParcouru() ||
                                                    pourcentageClic < empl_fin.getPourcentageParcouru()){
                                                itineraireSelectionne = true;
                                            }
                                        }
                                    }
                                    else if(empl_deb.getTroncon().equals(trc)){
                                        // si apres
                                        if (pourcentageClic > empl_deb.getPourcentageParcouru()){
                                            itineraireSelectionne = true;
                                        }
                                    }
                                    else if(empl_fin.getTroncon().equals(trc)){
                                        // si avant
                                        if (pourcentageClic < empl_fin.getPourcentageParcouru()){
                                            itineraireSelectionne = true;
                                        }
                                    }
                                    else{
                                        itineraireSelectionne = true;
                                    }
                                }
                                else if(empl_deb != null){
                                    if (empl_deb.getTroncon().equals(trc)){
                                        if (pourcentageClic > empl_deb.getPourcentageParcouru()){
                                            itineraireSelectionne = true;
                                        }
                                    }
                                    else{
                                        itineraireSelectionne = true;
                                    }
                                }
                                else if(empl_fin != null){
                                    if(empl_fin.getTroncon().equals(trc)){
                                        if (pourcentageClic < empl_fin.getPourcentageParcouru()){
                                            itineraireSelectionne = true;
                                        }
                                    }
                                    else{
                                        itineraireSelectionne = true;
                                    }
                                }
                                else{
                                    itineraireSelectionne = true;
                                }

                                if (itineraireSelectionne){
                                    m_pileSelection.ajouter(itn);
                                    return true;
                                }

                                empl_deb = null;
                                empl_fin = null;
                            }
                        }
                    }
                    if (paireParc.getParcoursBus() != null){
                        ParcoursBus parcoBus = paireParc.getParcoursBus();
                        LinkedList<Troncon> parcoBusTroncons = parcoBus.getTroncons();
                        for (Troncon trc2 : parcoBusTroncons){
                            if (trc2.equals(trc)){
                                if (parcoBus.getArretDepart().getEmplacement().estSurTroncon())
                                    empl_deb = parcoBus.getArretDepart().getEmplacement();
                                if (parcoBus.getArretFinal().getEmplacement().estSurTroncon())
                                    empl_fin = parcoBus.getArretFinal().getEmplacement();
                                
                                if (empl_deb != null && empl_fin != null){
                                    if (empl_deb.getTroncon().equals(trc) && empl_fin.getTroncon().equals(trc)){
                                        if (empl_deb.getPourcentageParcouru() < empl_fin.getPourcentageParcouru()){
                                            //si entre
                                            if (pourcentageClic > empl_deb.getPourcentageParcouru() && 
                                                    pourcentageClic < empl_fin.getPourcentageParcouru()){
                                                itineraireSelectionne = true;
                                            }
                                        }
                                        else{
                                            //si avant ou apres
                                            if (pourcentageClic > empl_deb.getPourcentageParcouru() ||
                                                    pourcentageClic < empl_fin.getPourcentageParcouru()){
                                                itineraireSelectionne = true;
                                            }
                                        }
                                    }
                                    else if(empl_deb.getTroncon().equals(trc)){
                                        // si apres
                                        if (pourcentageClic > empl_deb.getPourcentageParcouru()){
                                            itineraireSelectionne = true;
                                        }
                                    }
                                    else if(empl_fin.getTroncon().equals(trc)){
                                        // si avant
                                        if (pourcentageClic < empl_fin.getPourcentageParcouru()){
                                            itineraireSelectionne = true;
                                        }
                                    }
                                    else{
                                        itineraireSelectionne = true;
                                    }
                                }
                                else if(empl_deb != null){
                                    if (empl_deb.getTroncon().equals(trc)){
                                        if (pourcentageClic > empl_deb.getPourcentageParcouru()){
                                            itineraireSelectionne = true;
                                        }
                                    }
                                    else{
                                        itineraireSelectionne = true;
                                    }
                                }
                                else if(empl_fin != null){
                                    if(empl_fin.getTroncon().equals(trc)){
                                        if (pourcentageClic < empl_fin.getPourcentageParcouru()){
                                            itineraireSelectionne = true;
                                        }
                                    }
                                    else{
                                        itineraireSelectionne = true;
                                    }
                                }
                                else{
                                    itineraireSelectionne = true;
                                }

                                if (itineraireSelectionne){
                                    m_pileSelection.ajouter(itn);
                                    return true;
                                }

                                empl_deb = null;
                                empl_fin = null;
                            }
                        }
                    }
                }
            }
        }
        
        return false;
    }
    
    public Boolean selectionnerSourceIndividus(Float p_x, Float p_y, Float p_echelle){
        Path2D.Float zoneSelection = new Path2D.Float();
        Float largeur = SourceIndividus.LARGEUR;
        
        zoneSelection.moveTo(p_x, p_y - largeur / 2 / p_echelle);
        zoneSelection.lineTo(p_x + largeur / 2 / p_echelle, p_y);
        zoneSelection.lineTo(p_x, p_y + largeur / 2 / p_echelle);
        zoneSelection.lineTo(p_x - largeur / 2 / p_echelle, p_y);
        zoneSelection.closePath();

        for (Itineraire itn : m_listeItineraires){
            Emplacement em = null;
            if(itn.getListPaireParcours().getFirst()!=null){
                if(itn.getListPaireParcours().getFirst().getTrajet()!=null){
                    em = itn.getListPaireParcours().getFirst().getTrajet().getEmplacementInitial();
                }
                else{
                    em = itn.getListPaireParcours().getFirst().getParcoursBus().getArretDepart().getEmplacement();
                }
            }
            Point2D.Float p = em.calculPosition(p_echelle);
            
            if(em!=null){
                if (zoneSelection.contains(p))
                {
                    m_pileSelection.ajouter(itn);
                    return true;
                }
            }
                
        }
       
        return false;
    }

    public void calculEtatReseauBesoin(Temps p_deltaT) {
       for(Itineraire it : m_listeItineraires){
            it.updateSourceIndividus(p_deltaT);
            ListIterator<Individu> individusItr = it.getListIndividu().listIterator();
        while (individusItr.hasNext()) {
            Individu ind = individusItr.next();
            if (ind.asTerminer()){
                individusItr.remove();
            }
            else{
                ind.miseAJourIndividu(p_deltaT);
            }
         }
       }
    }
    
    public Emplacement getEmplacementSourceTemp(){
        return m_emplacementSourceTemp;
    }
    
    public void setEmplacementSourceTemp(Emplacement empl){
        m_emplacementSourceTemp = empl;
    }
}
