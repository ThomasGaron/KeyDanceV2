package key_dance.frontal.fragments;

import ca.ntro.app.Ntro;
import ca.ntro.app.frontend.ViewFx;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class FragmentLeaderboard extends ViewFx {
    @FXML
    private Label labelNomJoueur;
    @FXML
    private Label labelScoreJoueur;

    public void afficherNomJoueur(String nomJoueur) {
        labelNomJoueur.setText(nomJoueur);
    }

    public void afficherScoreJoueur(int score){
        labelScoreJoueur.setText(String.valueOf(score));
    }

    @Override
    public void initialize() {
        Ntro.assertNotNull(labelNomJoueur);
        Ntro.assertNotNull(labelScoreJoueur);
    }

}
