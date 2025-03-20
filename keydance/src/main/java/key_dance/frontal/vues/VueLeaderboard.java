package key_dance.frontal.vues;

import static ca.ntro.app.tasks.frontend.FrontendTasks.viewLoader;

import ca.ntro.app.Ntro;
import ca.ntro.app.frontend.ViewFx;
import ca.ntro.app.frontend.ViewLoader;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
// import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import key_dance.commun.valeurs.Classement;
import key_dance.frontal.SessionKeydance;
import key_dance.frontal.evenements.EvtAfficherMenu;
import key_dance.frontal.fragments.FragmentLeaderboard;

public class VueLeaderboard extends ViewFx {

    private ViewLoader<FragmentLeaderboard> ViewLoaderLeaderboard;

    public ViewLoader<FragmentLeaderboard> getViewLoaderLeaderboard() {
        return ViewLoaderLeaderboard;
    }

    public void setViewLoaderLeaderboard(ViewLoader<FragmentLeaderboard> viewLoaderLeaderboard) {
        ViewLoaderLeaderboard = viewLoaderLeaderboard;
    }

    @FXML
    private Button boutonAllerAuMenu;
    @FXML
    private Button boutonSimuler;
    // @FXML
    // private Label labelClassement;
    @FXML
    private VBox conteneurLeaderboard;

    @Override
    public void initialize() {
        Ntro.assertNotNull(boutonAllerAuMenu);
        Ntro.assertNotNull(boutonSimuler);
        // Ntro.assertNotNull(labelClassement);
        Ntro.assertNotNull(conteneurLeaderboard);

        installerEvtAfficherMenu();
        initialiserBoutonSimuler();
    }

    private void initialiserBoutonSimuler() {
        SessionKeydance session = Ntro.session();

        boutonSimuler.setOnAction(evtFx -> {
            session.envoyerMsgAjouterClassement();
        });
    }

    private void installerEvtAfficherMenu() {
        boutonAllerAuMenu.setOnAction(evtFx -> {
            Ntro.newEvent(EvtAfficherMenu.class).trigger();
        });
    }

    public void afficherClassementEnTexte(String string) {
        // labelClassement.setText(texteClassement);
    }

    public void ajouterLeaderboard(Classement leaderboard) {
        FragmentLeaderboard fragment = leaderboard.creerFragment(ViewLoaderLeaderboard);
        leaderboard.afficherSur(fragment);

        conteneurLeaderboard.getChildren().add(fragment.rootNode());
    }

    public void viderListeLeaderboard() {
        conteneurLeaderboard.getChildren().clear();
    }

}
