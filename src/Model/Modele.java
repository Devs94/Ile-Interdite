package Model;
import Observing.Observable;

public class Modele extends Observable {
    private static final int LONGUEUR = 4, LARGEUR = 4;
    private Zone[][] zones;
    private Ile ile;

    public Modele() {
        zones = new Zone[LONGUEUR][LARGEUR];
        for (int i = 0; i < LONGUEUR; i++) {
            for (int j = 0; j < LARGEUR; j++) {
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
