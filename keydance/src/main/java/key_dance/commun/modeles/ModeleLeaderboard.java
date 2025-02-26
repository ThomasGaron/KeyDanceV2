package key_dance.commun.modeles;

import java.util.ArrayList;
import java.util.List;

import ca.ntro.app.models.Model;
import ca.ntro.app.models.WatchJson;
import ca.ntro.app.models.WriteObjectGraph;
import key_dance.commun.valeurs.Classement;
import key_dance.frontal.vues.VueLeaderboard;

public class ModeleLeaderboard implements Model, WatchJson, WriteObjectGraph {

    private long prochainIdJoueur = 1;

    public ModeleLeaderboard() {

    }

    private List<Classement> classementDansOrdre = new ArrayList<>();

    public void afficherSur(VueLeaderboard vueLeaderboard) {
        vueLeaderboard.afficherClassementEnTexte(this.toString());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        int numeroClassement = 1;

        for (Classement classement : classementDansOrdre) {
            builder.append(numeroClassement);
            builder.append(". ");
            builder.append(classement.toString());
            builder.append("\n");

            numeroClassement++;
        }
        return builder.toString();
    }

}
