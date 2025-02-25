package key_dance.frontal.taches;

import ca.ntro.app.tasks.frontend.FrontendTasks;
import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import ca.ntro.app.frontend.ViewLoader;
import key_dance.frontal.vues.VueLeaderboard;
import key_dance.frontal.vues.VueRacine;

public class CreerVues {

    public static void creerTaches(FrontendTasks tasks) {
        tasks.taskGroup("CreerVues")
                .waitsFor("ViewLoaders")
                .contains(subTasks -> {
                    creerVueRacine(subTasks);

                    creerVueLeaderboard(subTasks);
                });
    }

    private static void creerVueRacine(FrontendTasks subTasks) {
        subTasks.task(create(VueRacine.class))
                .waitsFor(viewLoader(VueRacine.class))
                .executesAndReturnsValue(inputs -> {
                    ViewLoader<VueRacine> viewLoader = inputs.get(viewLoader(VueRacine.class));
                    VueRacine vueRacine = viewLoader.createView();
                    return vueRacine;
                });
    }

    private static void creerVueLeaderboard(FrontendTasks subTasks) {
        subTasks.task(create(VueLeaderboard.class))
            .waitsFor(viewLoader(VueLeaderboard.class))
            .executesAndReturnsValue(inputs ->{
                ViewLoader<VueLeaderboard> viewLoader = inputs.get(viewLoader(VueLeaderboard.class));
                VueLeaderboard vueLeaderboard = viewLoader.createView();
                return vueLeaderboard;
            });
    }
}
