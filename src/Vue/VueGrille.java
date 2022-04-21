package Vue;

import java.awt.*;
import javax.swing.JPanel;

import Model.Modele;
import Model.Zone;
import Observing.Observer;

public class VueGrille extends JPanel implements Observer {
    private Modele modele;
    private final static int TAILLE = 20;

    public VueGrille(Modele modele) {
        this.modele = modele;
        modele.addObserver(this);
        Dimension dim = new Dimension(
            TAILLE*Modele.LARGEUR, TAILLE*Modele.LARGEUR
        );
    }

    public void update() {
        super.repaint();
    }

    public void paintComponent(Graphics g) {
        super.repaint();
        for (int i = 0; i < Modele.LARGEUR; i++) {
            for (int j = 0; j < Modele.HAUTEUR; j++) {
                this.paint(
                    g, modele.getZone(i, j), i*TAILLE, j*TAILLE
                    );
            }
        }
    }

    private void paint(Graphics g, Zone zone, int i, int j) {
        // Choix du style à compléter pour une zone...
    }
    
}
