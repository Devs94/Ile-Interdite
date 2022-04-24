package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Joueur;
import Model.Modele;

public class ActionCtrler implements ActionListener {
    private Modele modele;
    private ActionJoueur action;

    public ActionCtrler(Modele modele, Joueur joueur, ActionJoueur action) {
        this.modele = modele;
        this.action = action;
    }

    public void actionPerformed(ActionEvent e) {
        action.faireAction();
    }
    
}

interface ActionJoueur {
    public void faireAction();
}