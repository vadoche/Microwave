/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domaine.ReseauTransport;
import Domaine.ReseauRoutier.Emplacement;
import Domaine.Utilitaire.Distribution;
import Domaine.Utilitaire.Distribution.Type;
import Domaine.Utilitaire.Temps;

/**
 *
 * @author louis
 */
public class SourceAutobus extends ElementTransport{
    private Emplacement m_emplacement;
    private final Circuit m_circuit;
    private String m_nomSource = "";
    private Distribution m_distribution = new Distribution(Type.AUTOBUS);
    private Temps m_tempsAttenteInitial = new Temps(0);
    private Temps m_tempsAvantApparition;
    private int m_nbMaxAutobus = Integer.MAX_VALUE;
    private int m_capaciteAutobus = 50;
    
    private int m_nbAutobusGeneres = 0;    
    
    private Temps m_frequence;
    
    public final static float LARGEUR = 20;
    
    public SourceAutobus(Emplacement p_emplacement, Circuit p_circuit){
        m_emplacement = p_emplacement;
        m_circuit = p_circuit;
        m_tempsAvantApparition = m_tempsAttenteInitial;
    }
    
    public void miseAJourTempsRestant(Temps p_deltatT){
        // Le temps avant le prochain ajout d'autobus diminu selon le deltatT
        double tmp = m_tempsAvantApparition.getTemps() - p_deltatT.getTemps();
        m_tempsAvantApparition = new Temps(tmp);       
    }
    public void genererAutobus(Temps p_deltatT){
        //Tant que le temps est négatif ou égale a zéro on pop des autobus pour remettre le temps d'apparition > 0;
        while(m_tempsAvantApparition.getTemps() <= 0 && (m_nbMaxAutobus > m_nbAutobusGeneres )){
            miseAjourAvantAjout();
            Emplacement em = new Emplacement(m_emplacement.estSurTroncon(), m_emplacement.getPourcentageParcouru(),m_emplacement.getTroncon(), m_emplacement.getIntersection());
            String ID = genererBusID();
            Temps tempsAvantApparition = new Temps ( p_deltatT.getTemps() + m_tempsAvantApparition.getTemps());
            Autobus nouvelAutobus = new Autobus(em, m_capaciteAutobus, ID, tempsAvantApparition ,estSurArret());
            m_circuit.ajouterAutobus(nouvelAutobus);
            m_circuit.assignerTrajetAutobus(nouvelAutobus);
            //On update le temps avant apparition. On l'addition de la frequence.
            double tmp = m_tempsAvantApparition.getTemps() + m_frequence.getTemps();
            m_tempsAvantApparition = new Temps(tmp);
            initSourceAutobus();
        }
    }
    public int getNbAutobus(){
        return m_nbAutobusGeneres;
    }
    private String genererBusID(){
        m_nbAutobusGeneres++;
        String tmp = m_nomSource.concat("AU" +Integer.toString(m_nbAutobusGeneres));
        return tmp;
    }
        
    public Boolean estSurArret(){
        return m_emplacement.equals(m_circuit.getListeArretTrajet().getFirst().getArret().getEmplacement()); 
    }
    
    
    public void setCapaciteAutobus(int capacite){
        m_capaciteAutobus = capacite;
    }
    
    public int getCapaciteAutobus(){
        return m_capaciteAutobus;
    }
    
    public void initSourceAutobus(){
        m_frequence  = m_distribution.pigerTemps();
    }
    private void miseAjourAvantAjout(){
        //met à jour le nombre d'autobus et on pige un nouveau temps de distribution
       // m_frequence  = m_distibutionFrequence.pigerTemps();
    }
    public Emplacement getEmplacement(){
        return m_emplacement ;
    }
    public void setNbMaxAutobus(int p_max){
        m_nbMaxAutobus = p_max;
    }
    public int getNbMaxAutobus(){
        return m_nbMaxAutobus;
    }
    public void setNom(String nom){
        m_nomSource = nom;
    }
    public String getNom(){
        return m_nomSource;
    }
    public void setDistribution(Distribution p_distribution){
        m_distribution.setDistribution(p_distribution.getTempsMin(), p_distribution.getTempsFreq(), p_distribution.getTempsMax());
    }
    public Distribution getDistribution(){
        return m_distribution;
    }

    public void setDefault() {
       m_nbAutobusGeneres = 0;
       m_tempsAvantApparition = m_tempsAttenteInitial;
    }
    
    public void setTempsAttenteInitial(Temps temps){
        m_tempsAttenteInitial.setTemps(temps.getTemps());
        setDefault() ;
    }
    
    public Temps getTempsAttenteInitial(){
        return m_tempsAttenteInitial;
    }
}
