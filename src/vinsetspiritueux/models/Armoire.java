package vinsetspiritueux.models;

/**
 * Modèle qui représente une armoire à vin dans laquelle on peut mettre des bouteilles de vin.
 *
 * @author <a href="mailto:paul.friedli@edufr.ch">Paul Friedli</a>
 * @since 08.12.2023
 * @version 1.1.0
 */
public class Armoire {


    /**
     * Le contenu de cette armoire à bouteilles.
     */
    private Bouteille[] contenu;
    
    /**
     * Le nom de cette armoire à bouteilles.
     */
    private String nom;

    /**
     * Le constructeur de la classe Armoire.Toujours initialiser TOUS les attributs !
     *
     * @param nom le nom de cette nouvelle armoire
     * @param nbreMaxBouteilles le nombre maximum de bouteilles que cette nouvelle armoire pourra stocker
     */
    public Armoire( String nom, int nbreMaxBouteilles ) {
        this.nom = nom;
        this.contenu = new Bouteille[nbreMaxBouteilles];
    }

    /**
     * Indique si cette armoire est totalement remplie de bouteilles.
     *
     * @return vrai si et seulement si il n'y a plus de place pour rajouter une bouteille dans cette armoire
     */
    public boolean armoireEstPleine() {
        boolean estPlein = true;
        for(int i = 0; i < contenu.length; i++){
            if(contenu[i] == null){
                estPlein = false;
            }
        }
        return estPlein;
    }

    /**
     * Tente d'ajouter une bouteille à la liste des bouteilles de cette armoire. Chaque armoire à une taille différente
     * et ne peux accueillir qu'un nombre limité de bouteilles défini lors de sa création.
     *
     * @param bouteille bouteille à ajouter
     * @return vrai si et seulement si une bouteille est fournie et qu'il y avait encore une place dans cette armoire
     */
    public boolean ajouterBouteille( Bouteille bouteille ) {
        boolean peutAjouter = false;     
        for(int i = 0; i< contenu.length; i++){
            if(contenu[i] == null){
                contenu[i] = bouteille;
                peutAjouter = true;
                break;
            }
        }
        return peutAjouter;
    }

    /**
     * Tente de supprimer une bouteille de la liste des bouteilles de cette armoire. Si celle-ci est trouvée, la place
     * que cette bouteille occupait sera désormais libre pour une autre bouteille.
     *
     * @param bouteille bouteille à supprimer
     * @return vrai si et seulement si une bouteille est fournie et que celle-ci a été trouvée dans cette armoire
     */
    public boolean enleverBouteille( Bouteille bouteille ) {
        boolean peutSupprimer = false;
        for(int i = 0; i < contenu.length; i++){
            if(contenu[i] == bouteille){
                contenu[i] = null;
                peutSupprimer = true;
            }
        }
        return peutSupprimer;
    }

    /**
     * Calcule la valeur totale des bouteilles contenues dans cette armoire.
     *
     * @return la valeur totale des bouteilles contenues dans cette armoire
     */
    public double valeurTotaleStock() {
        double compteurPrix = 0;
        for (int i = 0; i<contenu.length; i++){
            compteurPrix += contenu[i].getPrix();
        }
        return compteurPrix;
    }

    /**
     * Produit une liste de toutes les bouteilles présentes dans cette armoire sans "trous" (pas de cellules vides).
     *
     * @return liste de toutes les bouteilles de cette armoire sans "trous"
     */
    public Bouteille[] getBouteilles() {
        int taille = 0;
        
        for(int i = 0; i < contenu.length; i++){
            if(contenu[i] != null){
                taille ++;
            }
        }
        Bouteille[] newBouteille = new Bouteille[taille];
        int index = 0;
        for(int i = 0; i < contenu.length; i++){
            if(contenu[i] != null){
                newBouteille[index] = contenu[i];
                index ++;
            }
        }
        return newBouteille;
    }

    /**
     * Calcule diverses statistiques sur cette armoire et les retourne sous forme d'un bean Statistique. Parmi ces
     * information retournées on trouve la bouteille la plus chère dans cette armoire, la bouteille la moins chère dans
     * cette armoire, le nombre de bouteilles dans cette armoire et le prix moyen des bouteilles de cette armoire.
     *
     * @return un objet Statistique transportant les informations précitées
     */
    public Statistique calculerStatistiques() {
        Bouteille plusGrand = null;
        Bouteille plusPetit = null;
        double prixTotal = 0;
        int nbresBouteilles = 0;
        
            int taille = getBouteilles().length;
            for(int j = 0; j < taille; j++){
                prixTotal += getBouteilles()[j].getPrix();
                nbresBouteilles ++;
                if(j == 0){
                    plusGrand = getBouteilles()[j];
                    plusPetit = getBouteilles()[j];
                }
                else{
                    if(plusGrand.getPrix() < getBouteilles()[j].getPrix()){
                        plusGrand = getBouteilles()[j];
                    }
                    if(plusPetit.getPrix() > getBouteilles()[j].getPrix()){
                        plusPetit = getBouteilles()[j];
                    }
                }
            }
        double moyenne = prixTotal / (double) nbresBouteilles;
        Statistique stat = new Statistique(plusGrand, plusPetit, nbresBouteilles, moyenne);
        return stat;
    }

    /**
     * Getter du nom de cette armoire à bouteilles.
     *
     * @return nom de cette armoire à bouteilles
     */
    public String getNom() {
        return nom;
    }

}
