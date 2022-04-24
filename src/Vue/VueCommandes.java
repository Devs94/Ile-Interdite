package Vue;

import javax.swing.*;
import java.awt.*;

import Model.Modele;
import Controller.Controleur;
import Controller.JoueurCtrler;



class VueCommandes extends JPanel{
    private Modele modele;

    public VueCommandes(Modele modele){
        this.modele = modele;
        JButton boutonAvance = new JButton("fin de tour");
        this.add(boutonAvance);

        JButton boutonAvance2 = new JButton("Gagnée ?");
        this.add(boutonAvance2);

        
        // Boutons de déplacement
        JPanel nav = new JPanel();
        JButton haut = new JButton("N");
        nav.add(haut);
        JButton bas = new JButton("S");
        nav.add(bas);
        JButton droite = new JButton("E");
        nav.add(droite);
        JButton gauche = new JButton("O");
        nav.add(gauche);

        nav.setLayout(new GridLayout(2,2));
        JButton recup = new JButton("Récupérer");
        this.add(recup);

        JButton assecher = new JButton("Assecher");
        this.add(assecher);

        JButton actSpec = new JButton("Action spéciale");
        this.add(actSpec);

        this.add(nav);


        Controleur ctrl = new Controleur(modele);
        boutonAvance.addActionListener(ctrl);

        Controleur ctrl2 = new Controleur(modele);
        boutonAvance2.addActionListener(ctrl2);

    }
}