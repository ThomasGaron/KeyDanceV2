package key_dance.frontal;

import ca.ntro.app.Ntro;
import ca.ntro.app.session.Session;
import key_dance.commun.messages.MsgAjouterClassement;
import key_dance.frontal.evenements.EvtAfficherLeaderboard;
import key_dance.frontal.evenements.EvtAfficherMenu;
import key_dance.frontal.vues.VueLeaderboard;
import key_dance.frontal.vues.VueMenu;
import key_dance.maquettes.MaquetteJoueurs;

public class SessionKeydance extends Session<SessionKeydance> {

    private Class<?> vueCourante = VueLeaderboard.class;

    public SessionKeydance(){
        super();
    }

    public SessionKeydance memoriserVueCourante(Class<?> vueCourante){
        this.vueCourante = vueCourante;
        return this;
    }

    public void envoyerEvtPourAfficherVueCourante(){
        if(vueCourante.equals(VueMenu.class)){
            Ntro.newEvent(EvtAfficherMenu.class).trigger();
        } else {
            Ntro.newEvent(EvtAfficherLeaderboard.class).trigger();
        }
    }

    public void envoyerMsgAjouterClassement(){
        Ntro.newMessage(MsgAjouterClassement.class)
            .setPremierJoueur(MaquetteJoueurs.joueurAleatoire(this.sessionId()))
            .send();
    }
}
