/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domaine.Statistiques;

import Domaine.BesoinsTransport.Itineraire;
import Domaine.Utilitaire.Temps;

/**
 *
 * @author ns222
 */
public class StatistiqueBesoin {
    private double m_precisionGlobal;
    private double m_sommeDesTemps;
    private double m_maxTempsDeplacement =0;
    private double m_minTempsDeplacement = Double.MAX_VALUE;
    private int m_nombreEchantion = 0;
    private String m_itineraire;
    public StatistiqueBesoin(String p_itineraire){
        m_itineraire = p_itineraire;
    }
    public StatistiqueBesoin(StatistiqueBesoin p_stat){
        m_sommeDesTemps = p_stat.m_sommeDesTemps;
        m_precisionGlobal = p_stat.m_precisionGlobal;
        m_maxTempsDeplacement = p_stat.m_maxTempsDeplacement;
        m_minTempsDeplacement = p_stat.m_minTempsDeplacement;
        m_nombreEchantion = p_stat.m_nombreEchantion;
        m_itineraire = p_stat.m_itineraire;
    }
    public String getNameItineraire(){
        return m_itineraire;
    }
    public double getprecisionGlobal(){
        return m_precisionGlobal;
    }
     public double getmaxTempsDeplacement(){
        return m_maxTempsDeplacement;
    }
      public double getminTempsDeplacement(){
        return m_minTempsDeplacement;
    }
       public double getMoyenne(){
        return m_sommeDesTemps/m_nombreEchantion;
    }

            
            
    public void miseAJourStat(Temps p_temps){
        m_nombreEchantion++;
        m_sommeDesTemps += p_temps.getTemps();
        if(p_temps.getTemps() >m_maxTempsDeplacement){
            m_maxTempsDeplacement = p_temps.getTemps();
        }
        if(p_temps.getTemps() < m_minTempsDeplacement){
            m_minTempsDeplacement =p_temps.getTemps(); 
        }
    }
}
