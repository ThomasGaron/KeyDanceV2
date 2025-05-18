package key_dance.frontal.fragments;

import ca.ntro.app.Ntro;
import ca.ntro.app.frontend.ViewFx;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

public class FragmentLeaderboard extends ViewFx {

    private String idJoueur;

    @FXML
    private Label labelNomJoueur;
    @FXML
    private Label labelScoreJoueur;
    @FXML
    private CheckBox checkboxSelection;

    public void afficherNomJoueur(String nomJoueur) {
        labelNomJoueur.setText(nomJoueur);
    }

    public void afficherScoreJoueur(int score){
        labelScoreJoueur.setText(String.valueOf(score));
    }

    public boolean estSelectionne() {
        return checkboxSelection.isSelected();
    }

    @Override
    public void initialize() {
        Ntro.assertNotNull(labelNomJoueur);
        Ntro.assertNotNull(labelScoreJoueur);
        Ntro.assertNotNull(checkboxSelection);
    }



    public void setIdJoueur(String id) {
        this.idJoueur = id;
    }

    public String getIdJoueur() {
        return idJoueur;
    }




}
