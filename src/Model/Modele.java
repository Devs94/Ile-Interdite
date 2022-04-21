package Model;
import Observing.Observable;

public class Modele extends Observable {
    public static final int LARGEUR = 4, HAUTEUR = 4;
    private Zone[][] zones;
    private Ile ile;

    public Modele() {
        zones = new Zone[LARGEUR][HAUTEUR];
        for (int i = 0; i < LARGEUR; i++) {
            for (int j = 0; j < HAUTEUR; j++) {
                zones[i][j] = new Zone(this, i, j);
            }
        }
        ile = new Ile(this);
    }

    public Zone[][] getGrilleZones() {
        return this.zones;
    }

    public Zone getZone(int x, int y) {
        return this.zones[x][y];
    }
    
    
}
