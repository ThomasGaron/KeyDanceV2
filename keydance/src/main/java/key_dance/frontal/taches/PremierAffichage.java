package key_dance.frontal.taches;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import ca.ntro.app.services.Window;
import ca.ntro.app.tasks.frontend.FrontendTasks;

public class PremierAffichage {

    public static void creerTaches(FrontendTasks tasks) {
        tasks.taskGroup("PremierAffichage")
                .contains(subTasks -> {
                    afficherFenetre(subTasks);
                });
    }

    private static void afficherFenetre(FrontendTasks subTasks) {
        subTasks.task("afficherFenetre")
                .waitsFor(window())
                .executes(inputs -> {
                    Window window = inputs.get(window());
                    window.setTitle("Key Dance");
                    window.show();
                });
    }
}
