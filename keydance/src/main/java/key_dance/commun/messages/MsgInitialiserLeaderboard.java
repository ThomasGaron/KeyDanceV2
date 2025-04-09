package key_dance.commun.messages;

import ca.ntro.app.messages.Message;
import key_dance.commun.enums.Region;
import key_dance.commun.modeles.ModeleLeaderboard;

public class MsgInitialiserLeaderboard extends Message<MsgInitialiserLeaderboard> {
    private Region region;

    public MsgInitialiserLeaderboard setRegion(Region region) {
        this.region = region;

        return this;
    }

    public MsgInitialiserLeaderboard() {

    }

    public void appliquerA(ModeleLeaderboard leaderboard) {
        leaderboard.initialiserRegion(region);
    }
}
