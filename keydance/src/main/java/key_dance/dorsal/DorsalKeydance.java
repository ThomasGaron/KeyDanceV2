package key_dance.dorsal;

import ca.ntro.app.backend.LocalBackendNtro;
import ca.ntro.app.tasks.backend.BackendTasks;
import key_dance.dorsal.taches.ModifierLeaderboard;

public class DorsalKeydance extends LocalBackendNtro{

    @Override
    public void createTasks(BackendTasks tasks) {
        ModifierLeaderboard.creerTaches(tasks);
    }

}
