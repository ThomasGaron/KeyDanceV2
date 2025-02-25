package key_dance.frontal.vues;

import ca.ntro.app.Ntro;
import ca.ntro.app.frontend.ViewFx;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import key_dance.frontal.evenements.EvtAfficherMenu;

public class VueLeaderboard extends ViewFx{

    @FXML
    private Button boutonAllerAuMenu;

    @Override
    public void initialize() {
        Ntro.assertNotNull(boutonAllerAuMenu);

        installerEvtAfficherMenu();
    }
        
    private void installerEvtAfficherMenu() {
        boutonAllerAuMenu.setOnAction(evtFx -> {
            Ntro.newEvent(EvtAfficherMenu.class).trigger();
        });
    }

}
