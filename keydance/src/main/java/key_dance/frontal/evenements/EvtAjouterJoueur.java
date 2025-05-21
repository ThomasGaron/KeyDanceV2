package key_dance.frontal.evenements;

import ca.ntro.app.events.Event;
import key_dance.commun.valeurs.Joueur;
import key_dance.frontal.SessionKeydance;

public class EvtAjouterJoueur extends Event{

    private Joueur joueur;

    public Joueur getJoueur() {
        return joueur;
    }

    public EvtAjouterJoueur setJoueur(Joueur joueur) {
        this.joueur = joueur;
        return this;
    }

    public void appliquerA(SessionKeydance session) {
        session.envoyerMsgAjouterClassement(joueur);
    }
}
