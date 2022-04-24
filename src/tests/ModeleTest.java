package tests;

import static org.junit.Assert.*;
import org.junit.*;

import Model.Modele;
import Model.Zone;

public class ModeleTest {
    Modele mTest;

    @Before
    public void initialisation() {
        mTest = new Modele();
    }

    @Test
    public void zoneNiveauNotNull() {
        Assert.assertNotNull(mTest.getZone(0, 0).getNiveauEau());
    }

    @Test
    public void compteZonesNiveauEau() {
        int sec = 0, inond = 0, sub = 0;
        Zone[][] zones = mTest.getGrilleZones();
        for (int i = 0; i < zones.length; i++) {
            for (int j = 0; j < zones[0].length; j++) {
                switch (zones[i][j].getNiveauEau()) {
                    case Normale: sec++;
                        break;
                    case Inondee: inond++;
                        break;
                    case Submergee: sub++;
                    default:
                        break;
                }
            }
        }
        System.out.printf("%d, %d, %d sur %d au total", sec, inond, sub, zones.length*zones[0].length);
    }

    @Test
    public void compteArtefacts() {
        int compte = 0;
        Zone[][] zones = mTest.getGrilleZones();
        for (int i = 0; i < zones.length; i++) {
            for (int j = 0; j < zones[0].length; j++) {
                if (zones[i][j].contientArtef()) compte++;
            }
        }
        assertEquals(compte, 4);
    }
}
