package vinsetspiritueux.ctrl;

import vinsetspiritueux.models.Armoire;
import vinsetspiritueux.models.Bouteille;
import vinsetspiritueux.models.Local;
import vinsetspiritueux.view.View;
import vinsetspiritueux.service.ServiceGestionVins;

/**
 * Classe représentant le contrôleur de l'application MVC "VinsEtSpiritueux" du
 * module D400.
 *
 * @author <a href="mailto:paul.friedli@edufr.ch">Paul Friedli</a>
 * @since 08.12.2023
 * @version 1.1.0
 */
public class Controller {

    /**
     * Référence au worker principal de l'application.
     */
    private ServiceGestionVins refService;

    /**
     * Référence à l'ihm principale de l'application.
     */
    private View refView;

    /**
     * Attribut qui va contenir les locaux de l'entreprise.
     */
    private Local[] locaux;

    /**
     * Le constructeur de la classe Ctrl. Au démarrage, la liste de locaux est vide.
     */
    public Controller() {
        this.locaux = new Local[0];
        this.refService = null;
        this.refView = null;
    }

    /**
     * Méthode de démarrage de l'application MVC2. La méthode commence par appeler
     * la méthode ihmStart() de l'ihm afin
     * de la démarrer.
     */
    public void start() {
        refView.viewStart();
    }

    /**
     * Cette méthode est appelée par la vue pour indiquer que l'application est en
     * train de se fermer. Cela permettrait
     * de sauvegarder l'état de l'application, mais ici il n'y a rien à faire..
     */
    public void viewExiting() {
    }

    /**
     * Charge la situation propre à l'entreprise A, c'est-à-dire ses locaux, les
     * armoires présentes dans ces locaux et
     * les bouteilles de vin présentes dans ces armoires. Pour plus de détails,
     * référez-vous à la documentation reçue
     * pour ce projet.
     */
    public void actionChargerEntrepriseA() {
        Local l1 = new Local("Salle A01");
        Local [] newLocaux = new Local[1];
        locaux = newLocaux;
        locaux[0]= l1;
        Armoire a1 = new Armoire("A01A", 100);
        Armoire a2 = new Armoire("A01B", 50);
        Bouteille b1 = new Bouteille("Leroy Chambertin Grand Cru", 2003, 3900);
        Bouteille b2 = new Bouteille("Montrachet Grand Cru", 2004, 1499);
        Bouteille b3 = new Bouteille("Château Lafite-Rothschild", 2006, 989.5);
        Bouteille b4 = new Bouteille("Romanée Conti Grand Cru", 2001, 14000);
        Bouteille b5 = new Bouteille("Montrachet Grand Cru", 2004, 5100);
        Bouteille b6 = new Bouteille("Petrus", 2005, 2350);
        l1.ajouterArmoire(a2);
        l1.ajouterArmoire(a1);
        a1.ajouterBouteille(b1);
        a1.ajouterBouteille(b2);
        a1.ajouterBouteille(b3);
        a2.ajouterBouteille(b4);
        a2.ajouterBouteille(b5);
        a2.ajouterBouteille(b6);
    }

    /**
     * Charge la situation propre à l'entreprise B, c'est-à-dire ses locaux, les
     * armoires présentes dans ces locaux et
     * les bouteilles de vin présentes dans ces armoires. Pour plus de détails,
     * référez-vous à la documentation reçue
     * pour ce projet.
     */
    public void actionChargerEntrepriseB() {
        Local l1 = new Local("Cave en pierre");
        Local l2 = new Local("Halle de stockage");
        Local [] newLocaux = new Local[2];
        locaux = newLocaux;
        locaux[0] = l1;
        locaux[1] = l2;
        // Armoires
        Armoire a1 = new Armoire("C-01", 100);
        Armoire a2 = new Armoire("H-01", 100);
        Armoire a3 = new Armoire("H-02", 100);

        // Bouteilles pour C-01
        Bouteille b1 = new Bouteille("Montrachet Grand Cru", 2004, 1499);
        Bouteille b2 = new Bouteille("Château Lafite-Rothschild", 2006, 989.5);
        Bouteille b3 = new Bouteille("Romanée Conti Grand Cru", 2001, 14000);
        Bouteille b4 = new Bouteille("Petrus", 2005, 2350);

        // Bouteilles pour H-01
        Bouteille b5 = new Bouteille("Dôle de Salquenen", 2010, 39.90);
        Bouteille b6 = new Bouteille("Dôle blanche", 2019, 29.90);
        Bouteille b7 = new Bouteille("Malvoisie", 2018, 24.90);

        // Bouteilles pour H-02
        Bouteille b8 = new Bouteille("Pinot noir", 2016, 19.90);
        l1.ajouterArmoire(a1);
        l2.ajouterArmoire(a2);
        l2.ajouterArmoire(a3);
        a1.ajouterBouteille(b1);
        a1.ajouterBouteille(b2);
        a1.ajouterBouteille(b3);
        a1.ajouterBouteille(b4);
        a2.ajouterBouteille(b5);
        a2.ajouterBouteille(b6);
        a2.ajouterBouteille(b7);
        a3.ajouterBouteille(b8);
    }

    /**
     * Charge la situation propre à l'entreprise C, c'est-à-dire ses locaux, les
     * armoires présentes dans ces locaux et
     * les bouteilles de vin présentes dans ces armoires. Pour plus de détails,
     * référez-vous à la documentation reçue
     * pour ce projet.
     */
    public void actionChargerEntrepriseC() {
        Local [] newLocaux = new Local[0];
        locaux = newLocaux;
    }

    /**
     * Affiche la valeur du stock de bouteilles présentes dans les locaux de
     * l'entreprise.
     */
    public void actionAfficherValeurStock() {
        refService.afficherValeurStock(locaux);
    }

    /**
     * Affiche tous les détails disponibles pour les locaux de l'entreprise.
     */
    public void actionAfficherTout() {
        refService.afficherTout(locaux);
    }

    /**
     * Affiche des informations statistiques pour chacun des locaux de l'entreprise.
     */
    public void actionAfficherStatistiques() {
        refService.afficherStatistiques(locaux);
    }

    /**
     * Getter de la référence au service GestionVins de l'application.
     *
     * @return la référence au worker de l'application
     */
    public ServiceGestionVins getRefServiceGestionVins() {
        return refService;
    }

    /**
     * Setter de la référence au service GestionVins  de l'application.
     *
     * @param service la référence au service GestionVins de l'application
     */
    public void setRefServiceGestionVins(ServiceGestionVins service) {
        this.refService = service;
    }

    /**
     * Getter de la référence à la vue de l'application.
     *
     * @return la référence à la vue de l'application
     */
    public View getReView() {
        return refView;
    }

    /**
     * Setter de la référence à la vue de l'application.
     *
     * @param view la référence à la vue de l'application
     */
    public void setRefView(View view) {
        this.refView = view;
    }

}
