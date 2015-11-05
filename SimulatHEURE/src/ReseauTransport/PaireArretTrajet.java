/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReseauTransport;
import ReseauRoutier.Trajet;

/**
 *
 * @author louis
 */
public class PaireArretTrajet {
    private Arret m_arret;
    private Trajet m_trajet;
    
    public PaireArretTrajet(Arret arret, Trajet trajet){
            m_arret = arret;
            m_trajet = trajet;
    }
    
    public Arret getArret(){
        return m_arret;
    }

    public Trajet getTrajet(){
        return m_trajet;
    }
}