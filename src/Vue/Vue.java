package Vue;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Model.Modele;
import Observing.Observer;
import outils.NiveauEau;

public class Vue implements Observer {
    private Modele modele;
    private JFrame frame;
    private VueZone[][] zones;
    private VueCommandes commandes;

    public Vue(Modele modele) {
        this.modele = modele;
        initGrille();
        JPanel panGrille = new JPanel();
        panGrille.setLayout(new GridLayout(Modele.LARGEUR, Modele.LARGEUR,  20, 20));
        addGrille(panGrille);
        frame = new JFrame();
        frame.setTitle("Ile Interdite");
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(50, 50, 50, 50));
        panel.add(panGrille);
        commandes = new VueCommandes(modele);
        panel.add(commandes);
        frame.setContentPane(panel);
        frame.setPreferredSize(new Dimension(800,600));
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void initGrille() {
        zones = new VueZone[Modele.LARGEUR][Modele.HAUTEUR];
        for (int i = 0; i < Modele.LARGEUR; i++) {
            for (int j = 0; j < Modele.HAUTEUR; j++) {
                zones[i][j] = new VueZone(modele, i, j);
            }
        }
    }

    private void addGrille(Container c) {
        for (int i = 0; i < Modele.LARGEUR; i++) {
            for (int j = 0; j < Modele.HAUTEUR; j++) {
                c.add(zones[i][j]);
            }
        }
    }

    public void update() {
        for (int i = 0; i < zones.length; i++) {
            for (int j = 0; j < zones.length; j++) {
                zones[i][j].repaint();
            }
        }
        
    }
}
