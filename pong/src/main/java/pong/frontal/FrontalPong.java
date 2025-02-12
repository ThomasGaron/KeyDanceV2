package pong.frontal;

import ca.ntro.app.events.EventRegistrar;
import ca.ntro.app.frontend.FrontendFx;
import ca.ntro.app.frontend.ViewRegistrarFx;
import ca.ntro.app.session.SessionRegistrar;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import pong.frontal.taches.CreerVues;
import pong.frontal.taches.PremierAffichage;
import pong.frontal.vues.VueFileAttente;
import pong.frontal.vues.VueRacine;

public class FrontalPong implements FrontendFx {

    @Override
    public void registerEvents(EventRegistrar registrar) {

    }

    @Override
    public void registerViews(ViewRegistrarFx registrar) {
        registrar.registerView(VueRacine.class, "/vues/racine.fxml");
        registrar.registerView(VueFileAttente.class, "/vues/file_attente.fxml");
    }

    @Override
    public void registerSessionClass(SessionRegistrar registrar) {

    }

    @Override
    public void createTasks(FrontendTasks tasks) {

        CreerVues.creerTaches(tasks);
        PremierAffichage.creerTaches(tasks);
    }

}
