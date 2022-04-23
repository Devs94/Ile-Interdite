package Vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Container;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Model.Modele;

public class Vue {
    private JFrame frame;
    private VueZone[][] zones;

    public Vue(Modele modele) {
        initGrille();
        JPanel panGrille = new JPanel();
        panGrille.setLayout(new GridLayout(Modele.LARGEUR, Modele.LARGEUR,  20, 20));
        addGrille(panGrille);
        frame = new JFrame();
        frame.setTitle("Ile Interdite");
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(50, 50, 50, 50));
        panel.add(panGrille);
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
                zones[i][j] = new VueZone(Color.RED);
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
}
