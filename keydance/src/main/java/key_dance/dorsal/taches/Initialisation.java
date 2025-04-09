package key_dance.dorsal.taches;

import ca.ntro.app.Ntro;
import ca.ntro.app.tasks.backend.BackendTasks;
import key_dance.commun.enums.Region;
import key_dance.commun.messages.MsgInitialiserLeaderboard;
import key_dance.commun.modeles.ModeleLeaderboard;

public class Initialisation {

    public static void creerTaches(BackendTasks tasks) {
        tasks.taskGroup("Initialisation")
                .contains(subTasks -> {
                    initialiserLeaderboards(subTasks);
                });
    }

    private static void initialiserLeaderboards(BackendTasks subTasks) {
        subTasks.task("initialiserLeaderboards")
                .executes(inputs -> {
                    for (Region region : Region.values()) {
                        Ntro.newMessage(MsgInitialiserLeaderboard.class)
                                .setModelSelection(ModeleLeaderboard.class, region.name())
                                .setRegion(region)
                                .send();
                    }
                });
    }
}
