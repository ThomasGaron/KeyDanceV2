package key_dance.frontal.taches;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import ca.ntro.app.Ntro;
import ca.ntro.app.modified.Modified;
import ca.ntro.app.session.Session;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import key_dance.commun.modeles.ModeleLeaderboard;
import key_dance.frontal.SessionKeydance;
import key_dance.frontal.evenements.EvtChangerRegion;
import key_dance.frontal.evenements.EvtSupprimerJoueur;
import key_dance.frontal.vues.VueLeaderboard;

public class AfficherLeaderboard {

    public static void creerTaches(FrontendTasks tasks) {
        tasks.taskGroup("AfficherLeaderboard")
                .waitsFor("afficherVueLeaderboard")
                .contains(subTasks -> {
                    afficherLeaderboard(subTasks);
                    changerRegion(subTasks);
                    supprimerJoueur(subTasks);
                });
    }

    private static void changerRegion(FrontendTasks subTasks) {
        subTasks.task("changerRegion")
                .waitsFor(event(EvtChangerRegion.class))
                .executes(inputs -> {
                    SessionKeydance session = Ntro.session();
                    EvtChangerRegion evtChangerRegion = inputs.get(event(EvtChangerRegion.class));

                    evtChangerRegion.appliquerA(session);
                });
    }

    private static void supprimerJoueur(FrontendTasks subTasks) {
    subTasks.task("supprimerJoueur")
        .waitsFor(event(EvtSupprimerJoueur.class))
        .executes(inputs -> {
            SessionKeydance session = Ntro.session();
            EvtSupprimerJoueur evtSupprimerJoueur = inputs.get(event(EvtSupprimerJoueur.class));

            evtSupprimerJoueur.appliquerA(session);
        });
}

    private static void afficherLeaderboard(FrontendTasks subTasks) {
        subTasks.task("afficherLeaderboard")
                .waitsFor(created(VueLeaderboard.class))
                .waitsFor(modified(ModeleLeaderboard.class))
                .executes(inputs -> {
                    SessionKeydance session = Ntro.session();
                    VueLeaderboard VueLeaderboard = inputs.get(created(VueLeaderboard.class));
                    Modified<ModeleLeaderboard> leaderboard = inputs.get(modified(ModeleLeaderboard.class));

                    ModeleLeaderboard ancienLeaderboard = leaderboard.previousValue();
                    ModeleLeaderboard leaderboardCourant = leaderboard.currentValue();

                    leaderboardCourant.afficherSur(VueLeaderboard);

                    session.afficherRegionCourante(VueLeaderboard);
                });
    }
}
