package key_dance.commun.messages;

import ca.ntro.app.messages.Message;
import key_dance.commun.modeles.ModeleLeaderboard;
import key_dance.commun.valeurs.Joueur;

public class MsgAjouterClassement extends Message<MsgAjouterClassement>{

    private Joueur premierJoueur;

    public MsgAjouterClassement setPremierJoueur(Joueur premierJoueur){
        this.premierJoueur = premierJoueur;

        return this;
    }

    public void ajouterA(ModeleLeaderboard leaderboard){
        leaderboard.ajouterClassement(premierJoueur);
    }

}
