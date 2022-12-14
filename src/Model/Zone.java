package Model;

import java.util.ArrayList;

import Observing.Observable;
import outils.*;

public class Zone extends Observable {
    public static final String ListeArtefact = null;
	private NiveauEau niveauEau = NiveauEau.Normale;
    private Element element; // null par défaut
    private boolean Heliport = false;
    private Element cle;
    public int x, y;
    public ArrayList<Joueur> listeJoueurs = new ArrayList<Joueur>();

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

    public boolean isHeliZone() {
        return Heliport;
    }

    public boolean caseSafe(){
        if(NiveauEau.Normale == niveauEau){
         return true;
    }
    return false;
    }
    
    public boolean caseInond(){
        if(NiveauEau.Inondee == niveauEau){
            return true;
        }
        return false;
    }

    public void modifNiveauEeau( NiveauEau a){
        this.niveauEau = a;
    }

    public Element getArtefact(){
        return this.element;
    }

    public void removeArtefact(){
        this.element = null;
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