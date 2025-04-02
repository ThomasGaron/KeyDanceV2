package key_dance.frontal.vues;

import ca.ntro.app.Ntro;
import ca.ntro.app.frontend.ViewFx;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import key_dance.frontal.controles.CanvasMenu;
import key_dance.frontal.evenements.EvtAfficherLeaderboard;

public class VueMenu extends ViewFx {

    @FXML
    private Button boutonAllerAuLeaderboard;
    @FXML
    private CanvasMenu canvasMenu;

    @Override
    public void initialize() {
        Ntro.assertNotNull(boutonAllerAuLeaderboard);

        installerEvtAfficherLeaderboard();

        Ntro.assertNotNull(canvasMenu);
    }

    private void installerEvtAfficherLeaderboard() {
        boutonAllerAuLeaderboard.setOnAction(evtFx -> {
            Ntro.newEvent(EvtAfficherLeaderboard.class).trigger();
        });
    }

}
