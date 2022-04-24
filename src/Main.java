import Model.Modele;
import Vue.Vue;
import java.awt.*;

/**
 * Programme principal du jeu
 */
public class Main {

    public static void main(String[] args) {
       
        EventQueue.invokeLater(() -> {
            Modele modeleJeu = new Modele();
            Vue vueJeu = new Vue(modeleJeu);
        });

    }
}