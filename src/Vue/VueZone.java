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
    private Modele modele;
    private int x, y;

    public VueZone(Modele modele, int x, int y) {
        this.x = x;
        this.y = y;
        this.modele = modele;
        modele.getZone(x, y).addObserver(this);
        setBackground(Color.RED);
    }

    public void repaint() {
        super.repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        switch (modele.getZone(x, y).getNiveauEau()) {
            case Inondee:
                afficheInondee(g);
                break;
            case Submergee:
                afficheSubmergee(g);
            default:
                break;
        }
        if (modele.getZone(x, y).isHeliZone()) afficheHeliZone(g);
        // afficheJoueur(g, Color.GREEN);
    }

    private void afficheInondee(Graphics g) {
        g.setColor(EAU);
        int rectWidth = this.getWidth()/2, rectHeight = this.getHeight()/2;
        g.fillRect((this.getWidth()-rectWidth)/2, (this.getHeight()-rectHeight)/2, rectWidth, rectHeight);
    }
    

    private void afficheSubmergee(Graphics g) {
        g.setColor(EAU);
        int rectWidth = this.getWidth()-20, rectHeight = this.getHeight()-20;
        g.fillRect((this.getWidth()-rectWidth)/2, (this.getHeight()-rectHeight)/2, rectWidth, rectHeight);
    }

    private void afficheHeliZone(Graphics g) {
        int taille = this.getWidth()/6;
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, taille, taille);
        g.setColor(Color.BLACK);
        g.drawLine(0, 0, taille, taille);
        g.drawLine(taille, 0, 0, taille);
        g.drawLine(taille, 0, taille, taille);
        g.drawLine(0, taille, taille, taille);
    }

    private void afficheJoueur(Graphics g, Color color) {
        afficheJoueur(g, color, 10, 10);
    }

    private void afficheJoueur(Graphics g, Color color, int x, int y) {
        // On dessine la tête => cercle
        int tailleTete = this.getWidth()/20;
        g.setColor(color);
        g.fillOval(x, y, x+tailleTete, y+tailleTete);
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
