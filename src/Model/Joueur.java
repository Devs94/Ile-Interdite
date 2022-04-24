package Model;

import java.awt.Color;
import java.util.ArrayList;

import Model.Ile;
import Model.Zone;
import outils.*;

public class Joueur {
    private Modele modele;
    public int x,y;
    private Direction direction;
    private ArrayList<Element> ListeArtefact;
 


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
    
    public void AjoutArtefact(Element Artefact){
        this.ListeArtefact.add(Artefact);
    }




}
