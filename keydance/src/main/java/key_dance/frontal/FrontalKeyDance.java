package key_dance.frontal;

import ca.ntro.app.Ntro;
import ca.ntro.app.events.EventRegistrar;
import ca.ntro.app.frontend.FrontendFx;
import ca.ntro.app.frontend.ViewRegistrarFx;
import ca.ntro.app.session.SessionRegistrar;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import key_dance.frontal.evenements.EvtAfficherLeaderboard;
import key_dance.frontal.evenements.EvtAfficherMenu;
import key_dance.frontal.taches.CreerVues;
import key_dance.frontal.taches.PremierAffichage;
import key_dance.frontal.vues.VueLeaderboard;
import key_dance.frontal.vues.VueMenu;
import key_dance.frontal.vues.VueRacine;

public class FrontalKeyDance implements FrontendFx {

    @Override
    public void registerEvents(EventRegistrar registrar) {
        registrar.registerEvent(EvtAfficherLeaderboard.class);
        registrar.registerEvent(EvtAfficherMenu.class);
    }

    @Override
    public void registerViews(ViewRegistrarFx registrar) {
        registrar.registerView(VueRacine.class, "/vues/racine.fxml");
        registrar.registerView(VueLeaderboard.class, "/vues/leaderboard.fxml");
        registrar.registerView(VueMenu.class, "/vues/menu.fxml");

        registrar.registerStylesheet("/style/dev.css");
        registrar.registerStylesheet("/style/prod.css");

        registrar.registerDefaultLocale(Ntro.buildLocale("fr"));
        registrar.registerTranslations(Ntro.buildLocale("fr"), "/traductions/fr.properties");
        registrar.registerTranslations(Ntro.buildLocale("en"), "/traductions/en.properties");


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
