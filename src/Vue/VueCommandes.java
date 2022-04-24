package Vue;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JButton;

import Model.Modele;
import Controller.Controleur;



class VueCommandes extends JPanel{
    private Modele modele;

    public VueCommandes(Modele modele){
        this.modele = modele;
        JButton boutonAvance = new JButton("fin de tour");
        this.add(boutonAvance);

        JButton boutonAvance2 = new JButton("Gagnée ?");

        Controleur ctrl = new Controleur(modele);
        boutonAvance.addActionListener(ctrl);

        Controleur ctrl2 = new Controleur(modele);
        boutonAvance2.addActionListener(ctrl2);

    }
}