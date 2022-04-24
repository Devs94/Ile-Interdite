package Vue;

import java.awt.*;
import javax.swing.JPanel;

import Model.Joueur;
import Model.Modele;
import Model.Zone;
import Observing.Observer;
import outils.NiveauEau;

import java.awt.Color;
import java.util.ArrayList;

public class VueZone extends JPanel implements Observer {
    public static final Color EAU = new Color(84,121,255);
    private Modele modele;
    private int x, y;

    public VueZone(Modele modele, int x, int y) {
        this.x = x;
        this.y = y;
        this.modele = modele;
        modele.getZone(x, y).addObserver(this);
        setBackground(Color.BLACK);
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
        afficheAllArtef(g);
        afficheJoueurs(g, Color.YELLOW);
        // afficheArtef(g, Color.MAGENTA,this.getWidth()/2+10, this.getHeight()/2+10);
        // afficheJoueur(g, Color.GREEN);
    }

    private void afficheInondee(Graphics g) {
        g.setColor(EAU);
        int rectWidth = this.getWidth()/2, rectHeight = this.getHeight()/2;
        g.fillRect((this.getWidth()-rectWidth)/2, (this.getHeight()-rectHeight)/2, rectWidth, rectHeight);
    }
    

    private void afficheSubmergee(Graphics g) {
        g.setColor(EAU);
        int rectWidth = this.getWidth()-10, rectHeight = this.getHeight()-10;
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

    private void afficheJoueurs(Graphics g, Color color) {
        ArrayList<Joueur> listeJ =  modele.getZone(x, y).listeJoueurs;
        for (int i = 0; i < listeJ.size(); i++) {
                afficheJoueur(g, color, getWidth()/10*i, 0);
        }
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

    private void afficheAllArtef(Graphics g) {
        if (modele.getZone(x, y).contientArtef()) {
            switch (modele.getZone(x, y).getArtefact()) {
                case Air:
                    afficheArtef(
                        g, new Color(133, 247, 232),
                        this.getWidth()/2+10,
                        this.getHeight()/2+10
                    );
                    break;
                case Terre:
                    afficheArtef(
                    g, new Color(198, 151, 93),
                    this.getWidth()/2-10,
                    this.getHeight()/2-10
                );
                    break;
                case Eau:
                    afficheArtef(
                    g, new Color(62, 80, 221),
                    this.getWidth()/2+10,
                    this.getHeight()/2-10
                );
                    break;
                case Feu:
                    afficheArtef(
                    g, new Color(247, 86, 12),
                    this.getWidth()/2-10,
                    this.getHeight()/2+10
                );
                default:
                    break;
            }
        }
    }

    private void afficheArtef(Graphics g, Color c, int x, int y) {
        g.setColor(c);
        g.fillRect(x, y, this.getWidth()/10, this.getWidth()/10);
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
