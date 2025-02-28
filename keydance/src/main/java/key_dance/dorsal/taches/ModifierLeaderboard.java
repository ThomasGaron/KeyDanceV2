package key_dance.dorsal.taches;

import static ca.ntro.app.tasks.backend.BackendTasks.*;

import ca.ntro.app.tasks.backend.BackendTasks;
import key_dance.commun.messages.MsgAjouterClassement;
import key_dance.commun.modeles.ModeleLeaderboard;

public class ModifierLeaderboard {

    public static void creerTaches(BackendTasks tasks){
        tasks.taskGroup("ModifierLeaderboard")
            .waitsFor(model(ModeleLeaderboard.class))
            .contains(subTasks -> {
            ajouterClassement(subTasks);
        });
    }

    private static void ajouterClassement(BackendTasks subTasks) {
       subTasks.task("ajouterClassement")
                .waitsFor(model(ModeleLeaderboard.class))
                .waitsFor(message(MsgAjouterClassement.class))
                .executes(inputs -> {
                    MsgAjouterClassement msgAjouterClassement = inputs.get(message(MsgAjouterClassement.class));
                    ModeleLeaderboard leaderboard = inputs.get(model(ModeleLeaderboard.class));

                    msgAjouterClassement.ajouterA(leaderboard);
                });
    }
                
                   


}
