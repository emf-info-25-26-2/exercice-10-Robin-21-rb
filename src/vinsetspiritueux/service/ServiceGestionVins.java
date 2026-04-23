package vinsetspiritueux.service;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 * Classe représentant le service GestionVins de l'application MVC "VinsEtSpiritueux" du module D400.
 *
 * @author <a href="mailto:paul.friedli@edufr.ch">Paul Friedli</a>
 * @since 08.12.2023
 * @version 1.1.0
 */

import vinsetspiritueux.ctrl.Controller;
import vinsetspiritueux.models.Local;
public class ServiceGestionVins {

    /**
     * La référence au contrôleur de l'application.
     */
    private Controller refController;

    /**
     * Constructeur de la classe Service. Comme toujours, le travail N°1 consiste à initialiser TOUS nos attributs :-).
     */
    public ServiceGestionVins() {
        this.refController = null;
    }

    /**
     * Affiche la valeur du stock de bouteilles présentes dans les locaux fournis. Pour les détails du format
     * d'affichage à respecter, référez-vous à la documentation reçue qui montre des exemples précis.
     *
     * @param locaux les locaux dont on veut afficher la valeur du stock
     */
    public void afficherValeurStock( Local[] locaux ) {
        System.out.println("=======================\r\n" + //
                        "Valeur totale du stock \r\n" + //
                        "=======================");
        DecimalFormat form = new DecimalFormat("0.00");
        DecimalFormatSymbols sym = form.getDecimalFormatSymbols();
        sym.setDecimalSeparator(',');
        form.setDecimalFormatSymbols(sym);
        double prix = 0;
        for(int i = 0; i < locaux.length; i++){
            String prixString = form.format(locaux[i].valeurTotaleStock());
            prix += locaux[i].valeurTotaleStock();
            System.out.println("Local : " + locaux[i].getNom() + " => " + prixString + " Frs");
        }
        System.out.println("-----------------------");
        String prixString2 = form.format(prix);
        System.out.println("Total : " + prixString2 + " Frs\n=======================");
    }

    /**
     * Affiche tous les détails disponibles pour les locaux fournis. Pour les détails du format d'affichage à respecter,
     * référez-vous à la documentation reçue qui montre des exemples précis.
     *
     * @param locaux les locaux dont on veut afficher tous les détails
     */
    public void afficherTout( Local[] locaux ) {
        System.out.println("=======================");
        for(int i = 0; i<locaux.length; i++){
            System.out.println("Contenu du local : " + locaux[i].getNom());
            for(int j = 0; j< locaux[i].getArmoires().length; j++){
                System.out.println("  Armoire : " + locaux[i].getArmoires()[j].getNom());
                for(int h = 0; h<locaux[i].getArmoires()[j].getBouteilles().length; h++){
                    System.out.println("    " + locaux[i].getArmoires()[j].getBouteilles()[h]);
                }
            }
        }
        System.out.println("=======================");
    }

    /**
     * Affiche des informations statistiques pour chacun des locaux fournis. Pour les détails du format d'affichage à
     * respecter, référez-vous à la documentation reçue qui montre des exemples précis.
     *
     * @param locaux les locaux pour lesquels on veut afficher tous les détails disponibles
     */
    public void afficherStatistiques( Local[] locaux ) {
        for(int i = 0; i<locaux.length; i++){
            System.out.println("Statistiques du local : " + locaux[i].getNom());
            System.out.println(" => plus cher   : " + locaux[i].calculerStatistiques().getLaPlusChere());
            System.out.println(" => moins cher  : " + locaux[i].calculerStatistiques().getLaMoinsChere());
            System.out.println(" => Nbre        : " + locaux[i].calculerStatistiques().getNbreBouteilles());
            System.out.println(" => Prix moyen  : " + locaux[i].calculerStatistiques().getPrixMoyen());
            for(int j = 0; j< locaux[i].getArmoires().length; j++){
                System.out.println("  Statistiques de l'armoire : " + locaux[i].getArmoires()[j].getNom());
                System.out.println("   => plus cher   : " + " => plus cher   : " + locaux[i].getArmoires()[j].calculerStatistiques().getLaPlusChere());
                System.out.println("   => moins cher  : " + locaux[i].getArmoires()[j].calculerStatistiques().getLaMoinsChere());
                System.out.println("   => Nbre        : " + locaux[i].getArmoires()[j].calculerStatistiques().getNbreBouteilles());
                System.out.println("   => Prix moyen  : " + locaux[i].getArmoires()[j].calculerStatistiques().getPrixMoyen());
            }
        }
    }

    /**
     * Getter de la référence au contrôleur de l'application.
     *
     * @return la référence au contrôleur de l'application
     */
    public Controller getRefCtrl() {
        return refController;
    }

    /**
     * Setter de la référence au contrôleur de l'application.
     *
     * @param ctrl la nouvelle référence au contrôleur de l'application
     */
    public void setRefCtrl( Controller ctrl ) {
        this.refController = ctrl;
    }


}
