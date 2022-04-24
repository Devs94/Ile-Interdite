package Vue;

import java.awt.*;
import javax.swing.JPanel;

import Model.Modele;
import Model.Zone;
import Observing.Observer;
import outils.NiveauEau;

import java.awt.Color;

public class VueZone extends JPanel implements Observer {
    public static final Color EAU = new Color(84,121,255);
    private Zone zone;

    public VueZone(Modele modele, int x, int y) {
        this.zone = modele.getZone(x, y);
        this.zone.addObserver(this);
        setBackground(Color.RED);
    }

    public void repaint() {
        super.repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        switch (this.zone.getNiveauEau()) {
            case Inondee:
                afficheInondee(g);
                break;
            case Submergee:
                afficheSubmergee(g);
            default:
                break;
        }
    }

    public void afficheInondee(Graphics g) {
        g.setColor(EAU);
        int rectWidth = this.getWidth()/2, rectHeight = this.getHeight()/2;
        g.fillRect((this.getWidth()-rectWidth)/2, (this.getHeight()-rectHeight)/2, rectWidth, rectHeight);
    }
    

    public void afficheSubmergee(Graphics g) {
        g.setColor(EAU);
        int rectWidth = this.getWidth()-20, rectHeight = this.getHeight()-20;
        g.fillRect((this.getWidth()-rectWidth)/2, (this.getHeight()-rectHeight)/2, rectWidth, rectHeight);
    }

    public void update() {
        super.repaint();
    }

    /* public void afficheCle(Graphics g, int posX, int posY) {
        int dixiemeX = this.getWidth()/10;
        int dixiemeY = this.getHeight()/10;
        g.setColor(new Color(237, 209, 2));
        int x[] = {posX-dixiemeX, posX, posX+dixiemeX, posX};
        int y[] = {posY, posY-dixiemeY, posY, posY+dixiemeY};
        g.fillPolygon(x, y, 4);
        
    } */

    
}
