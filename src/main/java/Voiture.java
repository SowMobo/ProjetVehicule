public class Voiture extends Vehicule {
    private double cylindree;
    private int nbrPortes;
    private double puissance;
    private double kilometrage;

    public Voiture(String marque, int dateAchat, double prixAchat, double cylindree, int nbrPortes, double puissance, double kilometrage) {
        super(marque, dateAchat, prixAchat);
        this.cylindree = cylindree;
        this.nbrPortes = nbrPortes;
        this.puissance = puissance;
        this.kilometrage = kilometrage;
    }

    /**
     * Calcul et met à jour le prix courant d'une voiture selon les criteres suivants
     * le prix courant est égal au prix d'achat, moins :
     * 2% pour chaque année depuis l'achat jusqu'à la date actuelle
     * 5% pour chaque tranche de 10000km parcourus (on arrondit à la tranche la plus proche)
     * 10% s'il s'agit d'un véhicule de marque "Renault" ou "Fiat" (ou d'autres marques de votre choix)
     * et plus 20% s'il s'agit d'un véhicule de marque "Ferrari" ou "Porsche" (idem).
     * Le prix courant est egale 0 lorsque les reductions depassent le prix d'achat
     * @param anneeCourant correspond à l'annee actuelle
     */
    @Override
    public void calculPrix(int anneeCourant) {
        int anciennete = anneeCourant - this.getDateAchat();
        double coefAnciennete = anciennete * 0.02;
        double coefKilometrage = (int) this.kilometrage / 10000 * 0.05;

        double decote = (coefAnciennete + coefKilometrage) * this.getPrixAchat();

        double coefMarqueMoinsFiable;
        if (this.getMarque().equals("Renault") || this.getMarque().equals("Fiat")) {
            coefMarqueMoinsFiable = 0.1;
        } else {
            coefMarqueMoinsFiable = 0;
        }

        decote = decote + decote * coefMarqueMoinsFiable;

        double coefMarqueLuxe;

        if (this.getMarque().equals("Ferrari") || this.getMarque().equals("Porsche")) {
            coefMarqueLuxe = 0.2;
        } else {
            coefMarqueLuxe = 0;
        }
        decote = decote  - decote * coefMarqueLuxe;

        double prix = this.getPrixAchat() - decote;
        prix = prix > 0.0 ? prix : 0.0;
        this.prixCourant = prix;
    }

    /**
     * Affiche le status d'une voiture
     */
    @Override
    public void affiche() {
        System.out.print("Voiture(");
        super.affiche();
        System.out.println("cyclindree= " + this.cylindree + " nombre de portes= " + this.nbrPortes +
                " puissance= " + this.puissance + " kilométrage= " + this.kilometrage + ")");
    }
}