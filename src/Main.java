import Model.Modele;
import Vue.Vue;

/**
 * Programme principal du jeu
 */
public class Main {

    public static void main(String[] args) {
        Modele modeleJeu = new Modele();
        Vue vueJeu = new Vue(modeleJeu);

    }
}