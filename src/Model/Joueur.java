package Model;

import java.awt.Color;
import Model.Ile;
import Model.Zone;
import outils.Direction;

public class Joueur {
    private Modele modele;
    private int id;
    private Zone position;
    private Direction direction;
    private Color couleur;


    public Joueur(Modele modele, Zone zone){
        this.modele = modele;
        this.position = zone;
    }

    public Direction getDirection(){
        return this.direction;
    }

    public void move(Direction key){
        this.direction = key;
        switch(this.direction){
            case down: this.position = new Zone(this.position.x, this.position.y -1);
                break;
            case up: this.position = new Zone(this.position.x, this.position.y + 1);
                break;
            case left: this.position = new Zone(this.position.x - 1, this.position.y);
                break;
            case right: this.position = new Zone(this.position.x + 1, this.position.y);
                break;
            default:
                break;
        }
    }
    











}
