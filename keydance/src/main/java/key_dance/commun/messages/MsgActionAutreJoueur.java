package key_dance.commun.messages;

import javax.swing.Action;
import javax.swing.text.Position;

import ca.ntro.app.messages.Message;
import key_dance.frontal.donnees.DonneesVueMenu;

public class MsgActionAutreJoueur extends Message<MsgActionAutreJoueur> {

    private Position position;
    private Action action;

    public MsgActionAutreJoueur setPosition(Position position) {
        this.position = position;
        return this;
    }

    public MsgActionAutreJoueur setAction(Action action) {
        this.action = action;
        return this;
    }

    public MsgActionAutreJoueur() {

    }

    public void appliquerA(DonneesVueMenu donneesVueMenu) {
        donneesVueMenu.appliquerActionJoueur(position, action);
    }
}
