package vinsetspiritueux.models;

/**
 * Modèle qui représente les statistiques sur des bouteilles de vin.
 *
 * @author <a href="mailto:paul.friedli@edufr.ch">Paul Friedli</a>
 * @since 08.12.2023
 * @version 1.1.0
 */
public class Statistique {

    /**
     * La bouteille la plus chère non modifiable.
     */
    private final Bouteille laPlusChere;

    /** 
     * La bouteille la moins chère non modifiable.
     */
    private final Bouteille laMoinsChere;

    /**
     * Le nombre de bouteilles non modifiable.
     */
    private final int nbreBouteilles;
    
    /**
     * Le prix moyen des bouteilles non modifiable.
     */
    private final double prixMoyen;
    /**
     * Le constructeur de la classe Statistique. Toujours initialiser TOUS les attributs !
     *
     * @param laPlusChere la plus chère des bouteilles trouvée
     * @param laMoinsChere la moins chère des bouteilles trouvée
     * @param nbreBouteilles le nombre de bouteilles trouvées
     * @param prixMoyen le prix moyen de l'ensemble des bouteilles trouvées
     */
    public Statistique( Bouteille laPlusChere, Bouteille laMoinsChere, int nbreBouteilles, double prixMoyen ) {
        this.laMoinsChere = laMoinsChere;
        this.laPlusChere = laPlusChere;
        this.nbreBouteilles = nbreBouteilles;
        this.prixMoyen = prixMoyen;
    }

    /**
     * Getter de la bouteille la plus chère.
     *
     * @return la bouteille la plus chère
     */
    public Bouteille getLaPlusChere() {
        return laPlusChere;
    }

    /**
     * Getter de la bouteille la moins chère.
     *
     * @return la bouteille la moins chère
     */
    public Bouteille getLaMoinsChere() {
        return laMoinsChere;
    }

    /**
     * Getter du nombre de bouteilles.
     *
     * @return le nombre de bouteilles
     */
    public int getNbreBouteilles() {
        return nbreBouteilles;
    }

    /**
     * Getter du prix moyen des bouteilles.
     *
     * @return le prix moyen des bouteilles
     */
    public double getPrixMoyen() {
        return prixMoyen;
    }

}
