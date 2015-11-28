package Domaine.Utilitaire;

/**
 *
 * @author vinny
 */
public class Distribution {
    private Temps m_tempsMinimum;
    private Temps m_tempsPlusFrequent;
    private Temps m_tempsMaximum;
    private Temps m_tempsMoyen;

    private double m_hauteur;
    private double m_penteGauche;
    private double m_aireGauche;
    private double m_penteDroite;
    //private double m_aireDroite;
    
    //private Temps m_tempsPige = new Temps(0);

    public Distribution()
    {
        setDistribution(new Temps(5 * 60), new Temps(5 * 60), new Temps(5 * 60));
    }
    
    public final void setDistribution(Temps p_tempsMinimum, Temps p_tempsPlusFrequent, Temps p_tempsMaximum)
    {
        double tMin = p_tempsMinimum.getTemps();
        double tFreq = p_tempsPlusFrequent.getTemps();
        double tMax = p_tempsMaximum.getTemps();
        
        if (tFreq > tMax)
        {
            throw new RuntimeException("Le temps maximal doit être supérieur ou égal au temps le plus fréquent.", new Throwable("Champs invalides"));
        }        
        else if (tFreq < tMin)
        {
            throw new RuntimeException("Le temps minimal doit être inférieur ou égal au temps le plus fréquent.", new Throwable("Champs invalides"));
        }        
        
        m_tempsMinimum = p_tempsMinimum;
        m_tempsPlusFrequent = p_tempsPlusFrequent;
        m_tempsMaximum = p_tempsMaximum;
        
        m_tempsMoyen = calculerTempsMoyen();
        
        m_hauteur = 2 / (tMax - tMin);
        m_penteGauche = m_hauteur / (tFreq - tMin);
        m_aireGauche = m_hauteur * (tFreq - tMin) / 2;
        m_penteDroite = m_hauteur / (tMax - tFreq);
        //m_aireDroite = m_hauteur * (tMax - tFreq) / 2;
        
        m_tempsMoyen = calculerTempsMoyen();
    }
    
    public Temps pigerTemps()
    {
        double aire = Math.random();
        Temps tempsPige;
        
        if (aire <= m_aireGauche)
        {
            tempsPige = new Temps(m_tempsMinimum.getTemps() + Math.sqrt(2 * aire / m_penteGauche));
        }
        else
        {
            tempsPige = new Temps(m_tempsMaximum.getTemps() - Math.sqrt(2 * (1 - aire) / m_penteDroite));
        }
        
        return tempsPige;
    }
    
    private Temps calculerTempsMoyen()
    {
        double aire = 0.5;
        Temps tempsMoyen;
        
        if (aire <= m_aireGauche)
        {
            tempsMoyen = new Temps(m_tempsMinimum.getTemps() + Math.sqrt(2 * aire / m_penteGauche));
        }
        else
        {
            tempsMoyen = new Temps(m_tempsMaximum.getTemps() - Math.sqrt(2 * (1 - aire) / m_penteDroite));
        }
        
        return tempsMoyen;
    }
    
    public Temps getTempsMin(){
        return m_tempsMinimum;
    }
    
    public Temps getTempsMax(){
        return m_tempsMaximum;
    }
    
    public Temps getTempsPlusFrequent(){
        return m_tempsPlusFrequent;
    }
    
    public Temps getTempsMoyen(){
        return m_tempsMoyen;
    }
}
