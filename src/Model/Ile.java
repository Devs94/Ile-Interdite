package Model;


public class Ile {
    private Modele modele;
    private Zone[][] zones;
    
    public Ile (Modele modele) {
        this.modele = modele;
        zones = modele.getGrilleZones();
    }
    
    
}
