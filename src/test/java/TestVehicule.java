import com.beust.ah.A;
import org.testng.annotations.Test;

public class TestVehicule {

    @Test
    public void test01(){
        /**
         * Test les classes Vehicule, Voiture et Avion
         */
        int ANNEE_ACTUELLE = 2050;
        Voiture[] garage = new Voiture[4];
        Avion[] hangar = new Avion[2];

        garage[0] = new Voiture("Pegeot", 2005, 147325.79, 2.5, 5,
                180.0, 12000);
        garage[1] = new Voiture("Porsche", 1999, 250000.0, 6.5,
                2, 280.0, 81320.0);
        garage[2] = new Voiture("Fiat", 2001, 7327.30, 1.6, 3,
                65.0, 3000);
        garage[3] = new Voiture("Ford", 2018, 200000, 3.5, 5,
                250,300);

        hangar[0] = new Avion("Cessna", 1982, 1230673.90, "HELICES", 250);
        hangar[1] = new Avion("Nain Connu", 1993, 4321098.00, "REACTION", 1300);

        for(Voiture voiture : garage) {
            voiture.calculPrix(ANNEE_ACTUELLE);
            voiture.affiche();
        }

        for (Avion avion : hangar) {
            avion.calculPrix(ANNEE_ACTUELLE);
            avion.affiche();
        }

    }
}
