package Controller;

import java.awt.event.*;
import javax.swing.*;

import Model.Modele;

public class Controleur implements ActionListener {
    Modele modele;
    public Controleur(Modele modele){
        this.modele = modele;
    }

    public void actionPerformed(ActionEvent e) {
        

        modele.EndtourInondation();   
        
        
        
        String actionCommand = ((JButton) e.getSource()).getActionCommand();
		boolean actionValide = false;

        if( actionCommand == "Gagnée?" ){
            modele.PartieGagnee();
        }
        else if ( actionCommand == "Récupérer"){
            modele.RecupArtefact(modele.tourget(), modele.getGrilleZones());
        }

    }
    
}
