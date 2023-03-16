/**
 * Class Vehicule a deux subclass: Voiture et Avion
 * Class Vehicule implement definit les attributs et les methodes communes aux subclass
 */
public class Vehicule {
    private String marque;
    private int dateAchat;
    private double prixAchat;
    // Important de donner aux subclass l'acces au prixCourant car
    // son calcul est different pour chaque class(parent/fille)
    protected double prixCourant;


    public Vehicule(String marque, int dateAchat, double prixAchat) {
        this.marque = marque;
        this.dateAchat = dateAchat;
        this.prixAchat = prixAchat;
    }

    @Override
    public String toString() {
        return "marque:'" + marque + '\'' +
                ", dateAchat:" + dateAchat +
                ", prixAchat:" + prixAchat +
                ", prixCourant:" + prixCourant + " ";

    }

    public String getMarque() {
        return marque;
    }

    public int getDateAchat() {
        return dateAchat;
    }

    public double getPrixAchat() {
        return prixAchat;
    }

    /**
     * calcul le prix courant du vehicule selon son anciennete = anneeCourant - anneeAchat
     * @param anneeCourant correspond à l'annee actuelle
     * La reduction du prix d'achat est proportionnel à ancienneté de 10 %
     */
    public void calculPrix(int anneeCourant) {
        int anciennete = anneeCourant - this.dateAchat;
        double prix = (1 - anciennete * 0.01) * this.prixAchat;
        this.prixCourant = prix > 0.0 ? prix : 0.0;
    }

    /**
     * Affiche le status du vehicule
     */
    public void affiche() {
        System.out.print(this.toString());
    }

}
