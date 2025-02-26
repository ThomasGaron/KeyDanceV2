package key_dance.frontal.evenements;

import ca.ntro.app.events.Event;
import key_dance.frontal.SessionKeydance;
import key_dance.frontal.vues.VueLeaderboard;
import key_dance.frontal.vues.VueRacine;

public class EvtAfficherLeaderboard extends Event{
    
    public EvtAfficherLeaderboard appliquerA(VueRacine vueRacine, VueLeaderboard vueLeaderboard){
        vueRacine.afficherSousVue(vueLeaderboard);
        return this;
    }

    public EvtAfficherLeaderboard appliquerA(SessionKeydance session){
        session.memoriserVueCourante(VueLeaderboard.class);
        return this;
    }
}
