package key_dance.frontal.evenements;

import ca.ntro.app.events.Event;
import key_dance.frontal.SessionKeydance;

public class EvtSupprimerJoueur extends Event {

    private String idJoueur;

    public EvtSupprimerJoueur setIdJoueur(String idJoueur){
        this.idJoueur = idJoueur;
        return this;
    }

    public void appliquerA(SessionKeydance session){
        session.envoyerMsgSupprimerJoueur(idJoueur);
    }

}
