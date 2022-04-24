package Model;

import java.awt.Color;
import Model.Ile;
import Model.Zone;
import outils.Direction;

public class Joueur {
    private Modele modele;
    public int x,y;
    private Direction direction;
 


    public Joueur( Zone zone){
        
        this.x = zone.x;
        this.y = zone.y;
    }

    public Direction getDirection(){
        return this.direction;
    }

    public void move(Direction key){
        this.direction = key;
        switch(this.direction){
            case down: this.y = y - 1;
                break;
            case up: this.y = y + 1;
                break;
            case left:this.x = x - 1;
                break;
            case right: this.x = x + 1;
                break;
            default:
                break;
        }
    }
    










}
