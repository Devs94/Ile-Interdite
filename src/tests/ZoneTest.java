package tests;

import static org.junit.Assert.*;
import org.junit.*;

import Model.Modele;
import Model.Zone;
import outils.Element;

public class ZoneTest {
    @Test
    public void affichageZone() {
        Zone z = new Zone(new Modele(), Element.Air, 0, 0);
        System.out.println(z);
        
    }
}
