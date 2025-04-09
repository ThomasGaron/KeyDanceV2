package key_dance.frontal.taches;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import ca.ntro.app.frontend.Tick;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import key_dance.commun.messages.MsgActionAutreJoueur;
import key_dance.frontal.donnees.DonneesVueMenu;
import key_dance.frontal.vues.VueMenu;

public class AfficherMenu {

    public static void creerTaches(FrontendTasks tasks) {
        creerDonneesVueMenu(tasks);

        tasks.taskGroup("AfficherMenu")
                .waitsFor(created(DonneesVueMenu.class))
                .waitsFor("afficherVueMenu")
                .contains(subTasks -> {
                    prochaineImageMenu(subTasks);
                    reagirActionAutreJoueur(subTasks);
                });
    }

    private static void creerDonneesVueMenu(FrontendTasks tasks) {
        tasks.task(create(DonneesVueMenu.class))
                .executesAndReturnsValue(inputs -> {
                    return new DonneesVueMenu();
                });
    }

    private static void prochaineImageMenu(FrontendTasks subTasks) {
        subTasks.task("prochaineImageMenu")
                .waitsFor("afficherVueMenu")
                .waitsFor(created(DonneesVueMenu.class))
                .waitsFor(created(VueMenu.class))
                .waitsFor(clock().nextTick())
                .executes(inputs -> {
                    DonneesVueMenu donneesVueMenu = inputs.get(created(DonneesVueMenu.class));
                    VueMenu vueMenu = inputs.get(created(VueMenu.class));
                    Tick tick = inputs.get(clock().nextTick());

                    donneesVueMenu.reagirTempsQuiPasse(tick.elapsedTime());

                    donneesVueMenu.afficherSur(vueMenu);
                });
    }

    private static void reagirActionAutreJoueur(FrontendTasks subTasks) {
        subTasks.task("reagirActionAutreJoueur")
                .waitsFor(created(DonneesVueMenu.class))
                .waitsFor(message(MsgActionAutreJoueur.class))
                .executes(inputs -> {
                    DonneesVueMenu donneesVueMenu = inputs.get(created(DonneesVueMenu.class));
                    MsgActionAutreJoueur msgActionAutreJoueur = inputs.get(message(MsgActionAutreJoueur.class));

                    msgActionAutreJoueur.appliquerA(donneesVueMenu);
                });
    }
}
