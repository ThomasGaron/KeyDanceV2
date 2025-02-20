package key_dance.frontal;

import ca.ntro.app.events.EventRegistrar;
import ca.ntro.app.frontend.FrontendFx;
import ca.ntro.app.frontend.ViewRegistrarFx;
import ca.ntro.app.session.SessionRegistrar;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import key_dance.frontal.taches.CreerVues;
import key_dance.frontal.taches.PremierAffichage;
import key_dance.frontal.vues.VueRacine;

public class FrontalKeyDance implements FrontendFx {

    @Override
    public void registerEvents(EventRegistrar registrar) {

    }

    @Override
    public void registerViews(ViewRegistrarFx registrar) {
        registrar.registerView(VueRacine.class, "/vues/racine.fxml");
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
