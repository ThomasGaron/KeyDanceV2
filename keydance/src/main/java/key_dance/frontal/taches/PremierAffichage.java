package key_dance.frontal.taches;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import ca.ntro.app.services.Window;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import key_dance.frontal.vues.VueRacine;

public class PremierAffichage {

    public static void creerTaches(FrontendTasks tasks) {
        tasks.taskGroup("PremierAffichage")
                .waitsFor("CreerVues")
                .contains(subTasks -> {
                    installerVueRacine(subTasks);
                    afficherFenetre(subTasks);
                });
    }

    private static void installerVueRacine(FrontendTasks subTasks) {
        subTasks.task("installerVueRacine")
                .waitsFor(window())
                .waitsFor(created(VueRacine.class))
                .executes(inputs -> {
                    VueRacine vueRacine = inputs.get(created(VueRacine.class));
                    Window window = inputs.get(window());
                    window.installRootView(vueRacine);
                });
    }

    private static void afficherFenetre(FrontendTasks subTasks) {
        subTasks.task("afficherFenetre")
                .waitsFor(window())
                .executes(inputs -> {
                    Window window = inputs.get(window());
                    window.setTitle("KeyDance");
                    window.show();
                });
    }
}
