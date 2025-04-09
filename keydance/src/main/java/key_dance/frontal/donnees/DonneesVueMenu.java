package key_dance.frontal.donnees;

import javax.swing.Action;
import javax.swing.text.Position;

import ca.ntro.app.frontend.ViewData;
import ca.ntro.core.NtroCore;
import key_dance.commun.monde2d.MondeKeydance2d;
import key_dance.frontal.vues.VueMenu;

public class DonneesVueMenu implements ViewData {

    private MondeKeydance2d mondeKeydance2d = new MondeKeydance2d();
    private String fpsCourant = "0";
    private static long CALCULER_FPS_A_CHAQUE_X_MILISECONDES = 200;

    private long horodatageDernierCalculFps = NtroCore.time().nowMilliseconds();
    private long imagesAfficheesDepuisDernierCalculFps = 0;

    public void afficherSur(VueMenu vueMenu) {
        calculerFpsSiNecessaire();

        vueMenu.viderCanvas();
        vueMenu.afficherImagesParSeconde("FPS " + fpsCourant);
        vueMenu.afficherDance2d(mondeKeydance2d);

        imagesAfficheesDepuisDernierCalculFps++;
    }

    private void calculerFpsSiNecessaire() {
        long horodatageMaintenant = NtroCore.time().nowMilliseconds();
        long millisecondesEcoulees = horodatageMaintenant - horodatageDernierCalculFps;

        if (millisecondesEcoulees > CALCULER_FPS_A_CHAQUE_X_MILISECONDES) {
            calculerFpsMaintenant(millisecondesEcoulees);

            imagesAfficheesDepuisDernierCalculFps = 0;
            horodatageDernierCalculFps = horodatageMaintenant;
        }

    }

    private void calculerFpsMaintenant(long millisecondesEcoulees) {
        double secondesEcoulees = millisecondesEcoulees / 1E3;
        double fps = imagesAfficheesDepuisDernierCalculFps / secondesEcoulees;
        fpsCourant = String.valueOf(Math.round(fps));
    }

    public void reagirTempsQuiPasse(double elapsedTime) {
        mondeKeydance2d.onTimePasses(elapsedTime);
    }

    public void appliquerActionJoueur(Position position, Action action) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'appliquerActionJoueur'");
    }

}
