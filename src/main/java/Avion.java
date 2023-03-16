public class Avion extends Vehicule {
    private String moteur;
    private int heuresVol;

    public Avion(String marque, int dateAchat, double prixAchat, String moteur, int heuresVol) {
        super(marque, dateAchat, prixAchat);
        this.moteur = moteur;
        this.heuresVol = heuresVol;
    }

    /**
     * Calcul et met à jour le prix courant d'une voiture selon les criteres suivants
     * le prix courant est égal au prix d'achat, moins :
     * 10 % pour chaque tranche de 100 heures de vol s'il s'agit d'un avion à hélices.
     * 10 % pour chaque tranche de 1000 heures de vol pour les autres types de moteurs.
     * Le prix courant est egale 0 lorsque les reductions depassent le prix d'achat
     * @param anneeCourant correspond à l'annee actuelle
     */
    @Override
    public void calculPrix(int anneeCourant) {
        int nbrTranchesHeure;
        if (this.moteur.equals("HELICES")) {
            nbrTranchesHeure = (int) this.heuresVol / 100;
        } else {
            nbrTranchesHeure = (int) this.heuresVol / 1000;
        }
//        System.out.println("nbrTranchesHeure= " + nbrTranchesHeure);
        double prix = (1 - nbrTranchesHeure * 0.1) * this.getPrixAchat();

//        System.out.println("Prix= " + prix);
        prix = prix > 0.0 ? prix : 0.0;
//        System.out.println("Prix= " + prix);
        this.prixCourant = prix;
    }

    @Override
    public void affiche() {
        System.out.print("Avion(");
        super.affiche();
        System.out.println("moteur= " + this.moteur + " nombre d'heures de vol= " + this.heuresVol + ")");
    }
}
