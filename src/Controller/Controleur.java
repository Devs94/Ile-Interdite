package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Modele;

public class Controleur implements ActionListener {
    Modele modele;
    public Controleur(Modele modele){
        this.modele = modele;
    }

    public void actionPerformed(ActionEvent e) {
        

        modele.EndtourInondation();       
        
        



    }
    
}
