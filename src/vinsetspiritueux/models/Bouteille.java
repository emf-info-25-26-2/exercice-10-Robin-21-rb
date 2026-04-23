package vinsetspiritueux.models;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 * Modèle qui représente une bouteille de vin.
 *
 * @author <a href="mailto:paul.friedli@edufr.ch">Paul Friedli</a>
 * @since 08.12.2023
 * @version 1.1.0
 */
public class Bouteille {

    /**
     * Le nom de cette bouteille de vin non modifiable.
     */
    private final String nom;

    /**
     * L'année de cette bouteille de vin non modifiable.
     */
    private final int annee;
    
    /**
     * Le prix de cette bouteille de vin non modifiable.
     */
    private final double prix;

    /**
     * Le constructeur de la classe Bouteille. Toujours initialiser TOUS les attributs !
     *
     * @param nom le nom de ce vin
     * @param annee l'année de ce vin
     * @param prix le prix de ce vin
     */
    public Bouteille( String nom, int annee, double prix ) {
        this.nom = nom;
        this.annee = annee;
        this.prix = prix;
    }

    /**
     * Surcharge de la méthode Java toString() afin présenter clairement et lisiblement cette bouteille à l'utilisateur.
     * Le format à produire est le nom de la bouteille, suivi du texte " de ", suivi de son année, suivi du texte " / ",
     * suivi du prix de la bouteille avec toujours deux chiffres après la virgule, suivi du texte " Frs".
     *
     * @return une chaîne de caractères contenant les informations formatées comme précité
     */
    @Override
    public String toString() {
        DecimalFormat form = new DecimalFormat("0.00");
        DecimalFormatSymbols sym = form.getDecimalFormatSymbols();
        sym.setDecimalSeparator('.');
        form.setDecimalFormatSymbols(sym);
        String prixString = form.format(prix);
        return nom + " de " + annee + " / " + prixString + " Frs";
    }

    /**
     * Getter du nom de la bouteille de vin.
     *
     * @return le nom de la bouteille de vin
     */
    public String getNom() {
        return nom;
    }

    /**
     * Getter de l'année de la bouteille de vin.
     *
     * @return l'année de la bouteille de vin
     */
    public int getAnnee() {
        return annee;
    }

    /**
     * Getter du prix de la bouteille de vin.
     *
     * @return le prix de la bouteille de vin
     */
    public double getPrix() {
        return prix;
    }

}
