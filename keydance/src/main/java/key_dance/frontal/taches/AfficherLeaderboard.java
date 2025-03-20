package key_dance.frontal.taches;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import ca.ntro.app.modified.Modified;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import key_dance.commun.modeles.ModeleLeaderboard;
import key_dance.frontal.vues.VueLeaderboard;

public class AfficherLeaderboard {

    public static void creerTaches(FrontendTasks tasks) {
        tasks.taskGroup("AfficherLeaderboard")
                .waitsFor("afficherVueLeaderboard")
                .contains(subTasks -> {
                    afficherLeaderboard(subTasks);

                });
    }

    private static void afficherLeaderboard(FrontendTasks subTasks) {
        subTasks.task("afficherLeaderboard")
                .waitsFor(created(VueLeaderboard.class))
                .waitsFor(modified(ModeleLeaderboard.class))
                .executes(inputs -> {
                    VueLeaderboard VueLeaderboard = inputs.get(created(VueLeaderboard.class));
                    Modified<ModeleLeaderboard> leaderboard = inputs.get(modified(ModeleLeaderboard.class));

                    ModeleLeaderboard ancienLeaderboard = leaderboard.previousValue();
                    ModeleLeaderboard leaderboardCourant = leaderboard.currentValue();

                    leaderboardCourant.afficherSur(VueLeaderboard);
                });
    }
}
