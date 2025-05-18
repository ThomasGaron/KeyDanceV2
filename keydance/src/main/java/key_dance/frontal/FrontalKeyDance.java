package key_dance.frontal;

import ca.ntro.app.Ntro;
import ca.ntro.app.events.EventRegistrar;
import ca.ntro.app.frontend.FrontendFx;
import ca.ntro.app.frontend.ViewRegistrarFx;
import ca.ntro.app.session.SessionRegistrar;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import key_dance.frontal.donnees.DonneesVueMenu;
import key_dance.frontal.evenements.EvtAfficherLeaderboard;
import key_dance.frontal.evenements.EvtAfficherMenu;
import key_dance.frontal.evenements.EvtChangerRegion;
import key_dance.frontal.evenements.EvtSupprimerJoueur;
import key_dance.frontal.fragments.FragmentLeaderboard;
import key_dance.frontal.taches.AfficherLeaderboard;
import key_dance.frontal.taches.AfficherMenu;
import key_dance.frontal.taches.CreerVues;
import key_dance.frontal.taches.Navigation;
import key_dance.frontal.taches.PremierAffichage;
import key_dance.frontal.vues.VueLeaderboard;
import key_dance.frontal.vues.VueMenu;
import key_dance.frontal.vues.VueRacine;

public class FrontalKeyDance implements FrontendFx {

    @Override
    public void registerEvents(EventRegistrar registrar) {
        registrar.registerEvent(EvtAfficherLeaderboard.class);
        registrar.registerEvent(EvtAfficherMenu.class);

        registrar.registerEvent(EvtChangerRegion.class);
        registrar.registerEvent(EvtSupprimerJoueur.class);
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

        registrar.registerFragment(FragmentLeaderboard.class, "/fragments/leaderboard.fxml");

        registrar.registerViewData(DonneesVueMenu.class);

    }

    @Override
    public void registerSessionClass(SessionRegistrar registrar) {
        registrar.registerSessionClass(SessionKeydance.class);
    }

    @Override
    public void createTasks(FrontendTasks tasks) {
        CreerVues.creerTaches(tasks);
        PremierAffichage.creerTaches(tasks);

        Navigation.creerTaches(tasks);

        AfficherLeaderboard.creerTaches(tasks);

        AfficherMenu.creerTaches(tasks);

    }

}
