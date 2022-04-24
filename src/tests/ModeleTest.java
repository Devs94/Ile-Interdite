package tests;

import static org.junit.Assert.*;
import org.junit.*;

import Model.Modele;

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
}
