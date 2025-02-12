package pong.frontal.taches;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import ca.ntro.app.services.Window;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import pong.frontal.vues.VueFileAttente;
import pong.frontal.vues.VueRacine;

public class PremierAffichage {

    public static void creerTaches(FrontendTasks tasks) {

        tasks.taskGroup("PremierAffichage")
                .waitsFor("CreerVues")
                .contains(subTasks -> {
                    installerVueRacine(subTasks);
                    afficherFenetre(subTasks);

                    choisirPremierVue(subTasks);
                });
    }

    private static void choisirPremierVue(FrontendTasks subTasks) {
        subTasks.task("choisirPremiereVue")
                .waitsFor(created(VueRacine.class))
                .waitsFor(created(VueFileAttente.class))
                .executes(inputs -> {
                    VueRacine vueRacine = inputs.get(created(VueRacine.class));
                    VueFileAttente vueFileAttente = inputs.get(created(VueFileAttente.class));

                    vueRacine.afficherSousVue(vueFileAttente);
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
                    window.setTitle("Pong");
                    window.show();
                });
    }

}
