package key_dance.commun.messages;

import ca.ntro.app.messages.Message;
import key_dance.commun.modeles.ModeleLeaderboard;

public class MsgSupprimerJoueur extends Message<MsgSupprimerJoueur> {

    private String idJoueur;

    public MsgSupprimerJoueur setIdJoueur(String idJoueur){
        this.idJoueur = idJoueur;
        return this;
    }

    public String getIdJoueur() {
        return idJoueur;
    }

    public void supprimerDe(ModeleLeaderboard leaderboard) {
        leaderboard.supprimerClassement(idJoueur);
    }
}
