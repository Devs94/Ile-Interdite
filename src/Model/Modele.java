package Model;
import java.util.ArrayList;
import java.util.Arrays;

import Observing.Observable;
import outils.Element;
import outils.NiveauEau;

import java.util.Random;

public class Modele extends Observable {
    public static final int LARGEUR = 3, HAUTEUR = 3;
    public static final int NbArtCle = 4;
    private Zone[][] zones;
    private Ile ile;
    private Joueur[] ListeJoueurs;
 

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
        int nBArt = 3;
        int nBKey = 3;
        ArrayList<Element> Type = new ArrayList<Element>(Arrays.asList(Element.values()));
        zones[0][0].heliZone();
        
        for(int i = 1; i < LARGEUR; i++){
            for(int j = 0; j < HAUTEUR; j++){
                double a = Math.random();
                double b = Math.random();
                double c = Math.random();
                if (a < 0.4){
                    zones[i][j].zoneType(NiveauEau.Normale);
                    if( b <= 0.3 & nBArt >= 0 ){
                        zones[i][j].addArtefact(Type.get(nBArt));
                        nBArt--;
                    }
                    if( c <= 0.5 & nBKey >= 0){
                        if(zones[i][j].contientArtef() == false){
                            zones[i][j].addCle(Type.get(nBKey));
                            nBKey--;
                        }
                    }
                }
                else if (a <= 0.5 & a < 0.8 ){
                    zones[i][j].zoneType(NiveauEau.Inondee);
                    if( b < 0.3 & nBArt >= 0){
                          zones[i][j].addArtefact(Type.get(nBArt));
                        nBArt--;
                    }
                    if( c <= 0.4 & nBKey >= 0){
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



public void  EndtourInondation(){

     int nBInond = 3;
     Random rand = new Random();
     int upperbound = LARGEUR;

    while ( nBInond > 0){
        int randW = rand.nextInt(upperbound);
        int randH = rand.nextInt(upperbound);

        if (zones[randW][randH].caseSafe()) {
            if (zones[randW][randH].caseSafe()) {
                zones[randW][randH].modifNiveauEeau(NiveauEau.Inondee);
            } else {
                zones[randW][randH].modifNiveauEeau(NiveauEau.Submergee);
            }
            nBInond--;
        }
    }
    notifyObservers();
    for (int i = 0; i < zones.length; i++) {
        for (int j = 0; j < zones[0].length; j++) {
            zones[i][j].notifyObservers();
        }
    }
}





}

