package Model;
import java.util.ArrayList;
import java.util.Arrays;

import Observing.Observable;
import outils.Element;
import outils.NiveauEau;

public class Modele extends Observable {
    public static final int LARGEUR = 7, HAUTEUR = 7;
    public static final int NbArtCle = 4;
    private Zone[][] zones;
    private Ile ile;

    public Modele() {
        zones = new Zone[LARGEUR][HAUTEUR];
        for (int i = 0; i < LARGEUR; i++) {
            for (int j = 0; j < HAUTEUR; j++) {
                zones[i][j] = new Zone(this, i, j);
            }
        }
        init();
        ile = new Ile(this);
    }

    public Zone[][] getGrilleZones() {
        return this.zones;
    }

    public Zone getZone(int x, int y) {
        return this.zones[x][y];
    }
    
    public void init(){
        int nBArt = 4;
        int nBKey = 4;
        ArrayList<Element> Type = new ArrayList<Element>(Arrays.asList(Element.values()));
        zones[0][0].heliZone();
        
        for(int i = 1; i < LARGEUR; i++){
            for(int j = 0; j < HAUTEUR; j++){
                double a = Math.random();
                double b = Math.random();
                double c = Math.random();
                if (a < 0.4){
                    zones[i][j].zoneType(NiveauEau.Normale);
                    if( b <= 0.3 & nBArt > 0 ){
                        zones[i][j].addArtefact(Type.get(nBArt));
                        nBArt--;
                    }
                    if( c <= 0.5 & nBKey > 0){
                        if(zones[i][j].contientArtef() == false){
                            zones[i][j].addCle(Type.get(nBKey));
                            nBKey--;
                        }
                    }
                }
                else if (a <= 0.5 & a < 0.8 ){
                    zones[i][j].zoneType(NiveauEau.Inondee);
                    if( b < 0.3 & nBArt > 0){
                          zones[i][j].addArtefact(Type.get(nBArt));
                        nBArt--;
                    }
                    if( c <= 0.4 & nBKey > 0){
                        if(zones[i][j].contientArtef() == false){
                            zones[i][j].addCle(Type.get(nBKey));
                            nBKey--;
                }
                else {
                    zones[i][j].zoneType(NiveauEau.Submergee);
                }
                }
            }
        }

    }
}
}

