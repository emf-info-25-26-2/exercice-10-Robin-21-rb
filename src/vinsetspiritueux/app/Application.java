package vinsetspiritueux.app;

/**
 * Classe principale de l'application permettant de démarrer le programme MVC "VinsEtSpiritueux".
 *
 * @author <a href="mailto:paul.friedli@edufr.ch">Paul Friedli</a>
 * @since 08.12.2023
 * @version 1.1.0
 */

import vinsetspiritueux.ctrl.Controller;
import vinsetspiritueux.service.ServiceGestionVins;
import vinsetspiritueux.view.View;
public class Application {

    /**
     * LA méthode main() de l'application, là où tout commence mais... tout se finit-il bien là ?
     *
     * @param args les arguments du programme passés sur la ligne de commande
     */
    public static void main( String[] args ) {
      Controller refCtrl = new Controller();
      ServiceGestionVins refServiceGestionVins = new ServiceGestionVins();
      refCtrl.setRefServiceGestionVins(refServiceGestionVins);
      View refView = new View();
      refCtrl.setRefView(refView);
      refView.setRefCtrl(refCtrl);
      refServiceGestionVins.setRefCtrl(refCtrl);
      refCtrl.start();
    }

}
