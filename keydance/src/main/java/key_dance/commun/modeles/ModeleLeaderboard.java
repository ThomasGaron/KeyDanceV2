package key_dance.commun.modeles;

import java.util.ArrayList;
import java.util.List;

import ca.ntro.app.models.Model;
import ca.ntro.app.models.WatchJson;
import ca.ntro.app.models.WriteObjectGraph;
import key_dance.commun.enums.Region;
import key_dance.commun.valeurs.Classement;
import key_dance.commun.valeurs.Joueur;
import key_dance.frontal.vues.VueLeaderboard;

public class ModeleLeaderboard implements Model, WatchJson, WriteObjectGraph {

    private long prochainIdJoueur = 1;
    private long prochainIdClassement = 1;
    private List<Classement> classementDansOrdre = new ArrayList<>();

    private Region region = null;
    

    public ModeleLeaderboard() {

    }

    public void initialiserRegion(Region region) {
        this.region = region;
    }

    public void afficherSur(VueLeaderboard vueLeaderboard) {
        vueLeaderboard.viderListeLeaderboard();
        for (Classement leaderboard : classementDansOrdre) {
            vueLeaderboard.ajouterLeaderboard(leaderboard);
        }

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

    public void ajouterClassement(Joueur premierJoueur) {
        String idClassement = genererIdClassement();

        Classement classement = new Classement(idClassement, premierJoueur);
        classementDansOrdre.add(classement);
    }

    public void supprimerClassement(String idJoueur) {
        classementDansOrdre.removeIf(classement ->
            classement.lIdJoueur(idJoueur)
        );
        
    }


    private String genererIdClassement() {
        String idClassement = String.valueOf(prochainIdClassement);
        prochainIdClassement++;

        if (region != null) {
            idClassement = region.name() + "*" + idClassement;
        }

        return idClassement;
    }

}
