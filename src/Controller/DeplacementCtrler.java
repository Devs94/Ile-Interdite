package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Joueur;
import Model.Modele;
import outils.Direction;

public class DeplacementCtrler implements ActionListener {
    private Modele modele;
    private Joueur joueur;
    private Direction direction;

    public DeplacementCtrler(Modele modele, Joueur joueur, Direction direction) {
        this.modele = modele;
        this.joueur = joueur;
        this.direction = direction;
    }

    public void actionPerformed(ActionEvent e) {
        modele.DeplaceJoueur(this.joueur, modele.getGrilleZones(), direction);
    }
    
}
