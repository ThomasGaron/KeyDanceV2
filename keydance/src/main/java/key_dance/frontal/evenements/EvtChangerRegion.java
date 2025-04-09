package key_dance.frontal.evenements;

import ca.ntro.app.events.Event;
import key_dance.commun.enums.Region;
import key_dance.frontal.SessionKeydance;

public class EvtChangerRegion extends Event {
    private Region region;

    public EvtChangerRegion setRegion(Region region) {
        this.region = region;

        return this;
    }

    public void appliquerA(SessionKeydance session) {
        session.memoriserRegionCourante(region)
                .observerRegionCourante();
    }

}
