package key_dance.frontal.evenements;

import ca.ntro.app.events.Event;
import key_dance.frontal.SessionKeydance;
import key_dance.frontal.vues.VueMenu;
import key_dance.frontal.vues.VueRacine;

public class EvtAfficherMenu extends Event{

    public EvtAfficherMenu appliquerA(VueRacine vueRacine, VueMenu vueMenu){
        vueRacine.afficherSousVue(vueMenu);
        return this;
    }

    public EvtAfficherMenu appliquerA(SessionKeydance session){
        session.memoriserVueCourante(VueMenu.class);
        return this;
    }
}
