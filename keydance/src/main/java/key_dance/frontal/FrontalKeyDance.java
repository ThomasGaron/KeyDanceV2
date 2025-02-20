package key_dance.frontal;

import ca.ntro.app.events.EventRegistrar;
import ca.ntro.app.frontend.FrontendFx;
import ca.ntro.app.frontend.ViewRegistrarFx;
import ca.ntro.app.session.SessionRegistrar;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import key_dance.frontal.taches.PremierAffichage;

public class FrontalKeyDance implements FrontendFx {

    @Override
    public void registerEvents(EventRegistrar registrar) {

    }

    @Override
    public void registerViews(ViewRegistrarFx registrar) {

    }

    @Override
    public void registerSessionClass(SessionRegistrar registrar) {

    }

    @Override
    public void createTasks(FrontendTasks tasks) {
        PremierAffichage.creerTaches(tasks);
    }

}
