package key_dance.frontal.vues;

import ca.ntro.app.Ntro;
import ca.ntro.app.frontend.ViewFx;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import key_dance.frontal.evenements.EvtAfficherMenu;

public class VueLeaderboard extends ViewFx {

    @FXML
    private Button boutonAllerAuMenu;
    @FXML
    private Button boutonSimuler;
    @FXML
    private Label labelClassement;

    @Override
    public void initialize() {
        Ntro.assertNotNull(boutonAllerAuMenu);
        Ntro.assertNotNull(boutonSimuler);
        Ntro.assertNotNull(labelClassement);

        installerEvtAfficherMenu();
    }

    private void installerEvtAfficherMenu() {
        boutonAllerAuMenu.setOnAction(evtFx -> {
            Ntro.newEvent(EvtAfficherMenu.class).trigger();
        });
    }

    public void afficherClassementEnTexte(String texteClassement) {
        labelClassement.setText(texteClassement);
    }

}
