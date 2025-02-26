package key_dance.frontal.taches;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import ca.ntro.app.Ntro;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import key_dance.frontal.SessionKeydance;
import key_dance.frontal.evenements.EvtAfficherLeaderboard;
import key_dance.frontal.evenements.EvtAfficherMenu;
import key_dance.frontal.vues.VueLeaderboard;
import key_dance.frontal.vues.VueMenu;
import key_dance.frontal.vues.VueRacine;

public class Navigation {

    public static void creerTaches(FrontendTasks tasks) {
        tasks.taskGroup("Navigation")
                .waitsFor("PremierAffichage")
                .contains(subTasks -> {
                    afficherVueLeaderboard(subTasks);
                    afficherVueMenu(subTasks);
                });
    }

    private static void afficherVueMenu(FrontendTasks subTasks) {
        subTasks.task("afficherVueMenu")
                .waitsFor(event(EvtAfficherMenu.class))
                .waitsFor(created(VueRacine.class))
                .waitsFor(created(VueMenu.class))
                .executes(inputs -> {
                    SessionKeydance session = Ntro.session();

                    VueRacine vueRacine = inputs.get(created(VueRacine.class));
                    VueMenu vueMenu = inputs.get(created(VueMenu.class));
                    EvtAfficherMenu evtAfficherMenu = inputs.get(event(EvtAfficherMenu.class));

                    evtAfficherMenu.appliquerA(session)
                            .appliquerA(vueRacine, vueMenu);
                });
    }

    private static void afficherVueLeaderboard(FrontendTasks subTasks) {
        subTasks.task("afficherVueLeaderboard")
                .waitsFor(event(EvtAfficherLeaderboard.class))
                .waitsFor(created(VueRacine.class))
                .waitsFor(created(VueLeaderboard.class))
                .executes(inputs -> {
                    SessionKeydance session = Ntro.session();

                    VueRacine vueRacine = inputs.get(created(VueRacine.class));
                    VueLeaderboard vueLeaderboard = inputs.get(created(VueLeaderboard.class));
                    EvtAfficherLeaderboard evtAfficherLeaderboard = inputs.get(event(EvtAfficherLeaderboard.class));

                    evtAfficherLeaderboard.appliquerA(session)
                            .appliquerA(vueRacine, vueLeaderboard);
                });
    }
}
