package vinsetspiritueux.models;

/**
 * Modèle qui représente un local d'entreposage dans lequel on peut placer des armoires à vin.
 *
 * @author <a href="mailto:paul.friedli@edufr.ch">Paul Friedli</a>
 * @since 08.12.2023
 * @version 1.1.0
 */
public class Local {

    /**
     * Les armoires de ce local.
     */
    private Armoire[]armoires;

    /**
     * Le nom de ce local non modifiable.
     */
    private final String nom;

    /**
     * Le constructeur de la classe Local. Toujours initialiser TOUS les attributs ! Lors de la création d'un nouveau
     * local, il n'y a encore aucune armoire dans la liste.
     *
     * @param nom le nom de ce nouveau local
     */
    public Local( String nom ) {
        this.nom = nom;
        this.armoires = new Armoire[0];
    }

    /**
     * Ajoute une armoire à la liste des armoires de ce local. Le succès est garanti : cette méthode n'échoue jamais
     * dans sa tâche ! Pour parvenir à toujours être en mesure de rajouter une armoire dans la liste d'armoires de ce
     * local, cette méthode va aggrandir le tableau en conséquence.
     *
     * @param armoire l'armoire à rajouter
     */
    public void ajouterArmoire( Armoire armoire ) {
        int taille = armoires.length;
        taille += 1;
        Armoire[] newArmoires = new Armoire[taille];
        for(int i = 0; i< armoires.length; i++){
            newArmoires[i] = armoires[i];
        }
        newArmoires[taille-1] = armoire;
        armoires = newArmoires;
    }

    /**
     * Supprime une armoire de la liste des armoires de ce local. Cette méthode ne laissera pas traîner une position
     * inoccupée dans la liste des armoires du local, sa taille sera donc réadaptée.
     *
     * @param armoire l'armoire à supprimer de la liste des armoires de ce local
     * @return vrai si et seulement si cette armoire était présente dans la liste des armoires de ce local
     */
    public boolean enleverArmoire( Armoire armoire ) {
        int indexDelete = -1;
        boolean estPresent = false;
        for (int i = 0; i< armoires.length ; i++){
            
            if(armoires[i] == armoire){
                armoires[i] = null;
                indexDelete = i;
                estPresent = true;
            }
            if(i >= indexDelete && indexDelete!= -1 && i != armoires.length-1){
                armoires[i] = armoires[i+1];
                armoires[i+1] = null;
            }
            
        }
        armoires[armoires.length-1] = null;
        Armoire[] newArmoires = new Armoire[armoires.length-1];
        for(int i = 0; i < newArmoires.length; i++){
            newArmoires[i] = armoires[i];
        }
        armoires = newArmoires;
        return estPresent;
    }

    /**
     * Calcule la valeur totale des bouteilles contenues dans ce local.
     *
     * @return la valeur totale des bouteilles contenues dans ce local
     */
    public double valeurTotaleStock() {
        double prixTotal = 0;
        for(int i = 0; i < armoires.length; i++){
            int taille = armoires[i].getBouteilles().length;
            for(int j = 0; j < taille; j++){
                prixTotal += armoires[i].getBouteilles()[j].getPrix();
            }
        }
        return prixTotal;
    }

    /**
     * Calcule diverses statistiques sur ce local et les retourne sous forme d'un bean Statistique. Parmi ces
     * information retournées on trouve la bouteille la plus chère dans ce local, la bouteille la moins chère dans ce
     * local, le nombre de bouteilles dans ce local et le prix moyen des bouteilles de ce local.
     *
     * @return un objet Statistique transportant les informations précitées
     */
    public Statistique calculerStatistiques() {
        Bouteille plusGrand = null;
        Bouteille plusPetit = null;
        int nbresBouteilles = 0;
        for(int i = 0; i < armoires.length; i++){
            int taille = armoires[i].getBouteilles().length;
            for(int j = 0; j < taille; j++){
                nbresBouteilles ++;
                if(j == 0){
                    plusGrand = armoires[i].getBouteilles()[j];
                    plusPetit = armoires[i].getBouteilles()[j];
                }
                else{
                    if(plusGrand.getPrix() < armoires[i].getBouteilles()[j].getPrix()){
                        plusGrand = armoires[i].getBouteilles()[j];
                    }
                    if(plusPetit.getPrix() > armoires[i].getBouteilles()[j].getPrix()){
                        plusPetit = armoires[i].getBouteilles()[j];
                    }
                }
            }
        }
        double moyenne = valeurTotaleStock() / (double) nbresBouteilles;
        Statistique stat = new Statistique(plusGrand, plusPetit, nbresBouteilles, moyenne);
        return stat;
    }

    /**
     * Getter du nom de ce local.
     *
     * @return le nom de ce local
     */
    public String getNom() {
        return nom;
    }

    /**
     * Getter des armoires de ce local.
     *
     * @return les armoires de ce local
     */
    public Armoire[] getArmoires() {
        return armoires;
    }

}
