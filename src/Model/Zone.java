package Model;

import Observing.Observable;
import outils.*;

public class Zone extends Observable {
    private NiveauEau niveauEau = NiveauEau.Inondee;
    private Element element; // null par défaut
    private boolean Heliport = false;
    private Element cle;
    public int x, y;

    public Zone(Modele modele, int x, int y) {
        this(modele, null, x, y);
    }

    public Zone(Modele modele, Element element, int x, int y) {
        this(modele, element, null, x, y);
    }

    public Zone (Modele modele, Element element, Element cle, int x, int y) {
        this.element = element;
        this.cle = cle;
        this.x = x;
        this.y = y;
    }

    public Zone(int x, int y){
        this.x = x;
        this.y = y;
    }


    public NiveauEau getNiveauEau() {
        return this.niveauEau;
    }
    
    public void zoneType(NiveauEau a){
        niveauEau = a;
    }

    public boolean contientArtef(){
        return element != null;
    }

    public void addArtefact(Element element){
        this.element = element;
    }

    public void addCle(Element element){
        this.cle = element;
    }

    public void heliZone(){
        Heliport = true;
    }

    public boolean caseSafe(){
        if(NiveauEau.Submergee == niveauEau){
            return false;
        } return true;
    }

    public void modifNiveauEeau( NiveauEau a){
        this.niveauEau = a;
    }

    


    @Override
    public String toString() {
        int taille = 7;
        String symbole = "*";
        String affichage = "";
        String[][] affTab = new String[taille][taille];
        /* On construie les bordures */
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                if (i == 0 || i == taille-1 || j == 0 || j == taille-1) affTab[i][j] = symbole;
            }
        }
        /* Affiche le symbole au centre si la zone contient un élément (quelconque) */
        if (this.element != null) affTab[(taille-1)/2][(taille-1)/2] = symbole;
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) affichage += (affTab[i][j]!=null) ? affTab[i][j] + " " : "  ";
            affichage += "\n";
        }
        return affichage;
    }

    
}