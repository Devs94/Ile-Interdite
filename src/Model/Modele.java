package Model;
import java.util.ArrayList;
import java.util.Arrays;

import Observing.Observable;
import outils.Element;
import outils.NiveauEau;
import Model.Zone;
import outils.Direction;

import java.util.Random;

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
        int nBArt = 3;
        int nBKey = 3;
        ArrayList<Element> Type = new ArrayList<Element>(Arrays.asList(Element.values()));
        for(int i = 0; i < LARGEUR; i++){
            for(int j = 0; j < HAUTEUR; j++){
                zones[i][j].x = j;
                zones[i][j].y = i;
            }
        }
        zones[0][0].heliZone();
        
        for(int i = 0; i < LARGEUR; i++){
            for(int j = 0; j < HAUTEUR; j++){
                if(i > 0 || j > 0){ 
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
                else if (a < 0.7 & a >= 0.4 ){
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
            }
        }
                else if (a > 0.7){
                    zones[i][j].zoneType(NiveauEau.Submergee);
                }
                }
            }
            }
            
        }

    




        public void  EndtourInondation(){

            int nBInond = 3;
            Random rand = new Random();
            int upperbound = LARGEUR ;
       
           while ( nBInond > 0){
               int randW = rand.nextInt(upperbound);
               int randH = rand.nextInt(upperbound);
       
               
                   if (zones[randW][randH].caseSafe()) {
                       zones[randW][randH].modifNiveauEeau(NiveauEau.Inondee);
                       nBInond--;
                   }
               
                   else if (zones[randW][randH].caseInond()){ 
                       zones[randW][randH].modifNiveauEeau(NiveauEau.Submergee);
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
       

/**Place le joueur sur une zone non submergée de la carte */
public void initJoueur(){
int nBJoueur = 4;
while(nBJoueur > 0){ 
    for (int i = 1; i < LARGEUR; i++){
        for(int j = 0; j < HAUTEUR; j++){
            if(nBJoueur > 0){ 
                if (zones[i][j].caseSafe()){
                    Joueur a = new Joueur(zones[i][j]);
                    zones[i][j].listeJoueurs.add(a);           
                }
                nBJoueur --;
            }
        }
    }
}
}

public void DeplaceJoueur( Joueur perso, Zone[][] carte, Direction direct){
    int coor1 = perso.x;
    int coor2 = perso.y;

    perso.move(direct);
    if (perso.x == -1){
        perso.x = 0;
    }
    else if(perso.y == -1){
        perso.y = 0;
    }
    else if(perso.x == LARGEUR){
        perso.x = LARGEUR - 1;
    }
    else if(perso.y == HAUTEUR){
        perso.y = HAUTEUR - 1;
    }
    for(int i = 0; i < carte.length; i++){
        for(int j = 0; j < carte.length; j++){
            if(zones[i][j].getNiveauEau() != NiveauEau.Submergee){
            
                if (zones[i][j].x == perso.x & zones[i][j].y == perso.y){
                    zones[coor1][coor2].listeJoueurs.remove(perso);
                    zones[i][j].listeJoueurs.add(perso);
            }
            }
        }
    }
}

public void AssecheZone(Joueur perso, Zone[][]carte){
    if (carte[perso.y][perso.x].getNiveauEau() == NiveauEau.Inondee){
        carte[perso.y][perso.x].modifNiveauEeau(NiveauEau.Normale);
    }
}




}

