package pong.frontal;

import ca.ntro.app.tasks.frontend.FrontendTasks;
import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import ca.ntro.app.frontend.ViewLoader;
import pong.frontal.vues.VueRacine;

public class CreerVues {

    public static void creerTaches(FrontendTasks tasks) {

        tasks.taskGroup("CreerVues")
                .waitsFor("ViewLoaders")
                .contains(subTasks -> {
                    creerVueRacine(subTasks);
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

}
