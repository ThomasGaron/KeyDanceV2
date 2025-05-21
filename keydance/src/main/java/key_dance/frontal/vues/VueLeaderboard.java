package key_dance.frontal.vues;

import static ca.ntro.app.tasks.frontend.FrontendTasks.viewLoader;

import java.util.HashMap;
import java.util.Map;

import ca.ntro.app.Ntro;
import ca.ntro.app.frontend.ViewFx;
import ca.ntro.app.frontend.ViewLoader;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
// import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import key_dance.commun.enums.Region;
import key_dance.commun.messages.MsgAjouterClassement;
import key_dance.commun.valeurs.Classement;
import key_dance.commun.valeurs.Joueur;
import key_dance.frontal.SessionKeydance;
import key_dance.frontal.evenements.EvtAfficherMenu;
import key_dance.frontal.evenements.EvtAjouterJoueur;
import key_dance.frontal.evenements.EvtChangerRegion;
import key_dance.frontal.evenements.EvtSupprimerJoueur;
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
    @FXML
    private ComboBox<String> comboRegion;
    @FXML
    private Button boutonSupprimer;
    @FXML
    private TextField champUsername;
    @FXML
    private TextField champScore;
    @FXML
    private Button boutonAjouter;

    private Map<Region, String> nomRegionParRegion = new HashMap<>();
    private Map<String, Region> regionParNomRegion = new HashMap<>();

    @Override
    public void initialize() {
        Ntro.assertNotNull(boutonAllerAuMenu);
        Ntro.assertNotNull(boutonSimuler);
        // Ntro.assertNotNull(labelClassement);
        Ntro.assertNotNull(conteneurLeaderboard);
        Ntro.assertNotNull(comboRegion);
        Ntro.assertNotNull(boutonSupprimer);

        installerEvtAfficherMenu();
        initialiserBoutonSimuler();
        initialiserRegions();
        initialiserComboRegion();
        initialiserBoutonSupprimer();
        initialiserBoutonAjouter();
    }

    private void initialiserBoutonAjouter() {
         boutonAjouter.setOnAction(evtFx -> actionBoutonAjouter());
    }

    private void actionBoutonAjouter() {
    String nom = champUsername.getText();
    String scoreStr = champScore.getText();
    String nomRegion = comboRegion.getSelectionModel().getSelectedItem();

    if (nom == null || nom.isEmpty() || scoreStr == null || scoreStr.isEmpty() || nomRegion == null) {
        return;
    }

    try {
        int score = Integer.parseInt(scoreStr);
        Region region = regionParNomRegion.get(nomRegion);

        Joueur joueur = new Joueur();
        joueur.setId(Ntro.random().nextId(4));
        joueur.setUsername(nom);
        joueur.setScore(score);
        joueur.setRegion(region.name());

        Ntro.newEvent(EvtAjouterJoueur.class)
            .setJoueur(joueur)
            .trigger();

        champUsername.clear();
        champScore.clear();

        } catch (NumberFormatException e) {
        // CATCH erreur
        }
    }




    private void initialiserBoutonSupprimer() {
        boutonSupprimer.setOnAction(evtFx -> supprimerJoueursSelectionnes());
    }

    private void supprimerJoueursSelectionnes() {
        conteneurLeaderboard.getChildren().forEach(node -> {
            Object userData = node.getUserData();
    
            if (userData instanceof FragmentLeaderboard) {
                FragmentLeaderboard fragment = (FragmentLeaderboard) userData;
    
                if (fragment.estSelectionne()) {
                    String idJoueur = fragment.getIdJoueur();
    
                    Ntro.newEvent(EvtSupprimerJoueur.class)
                        .setIdJoueur(idJoueur)
                        .trigger();
                }
            }
        });
    }
    
    

    private void initialiserComboRegion() {
        comboRegion.setFocusTraversable(false);

        for (Region region : Region.values()) {
            comboRegion.getItems().add(nomRegionParRegion.get(region));
        }

        comboRegion.setOnAction(evtFx -> actionComboRegion());
    }

    private void actionComboRegion() {
        String nomRegion = comboRegion.getSelectionModel().getSelectedItem();

        Region region = regionParNomRegion.get(nomRegion);

        if (region != null) {
            Ntro.newEvent(EvtChangerRegion.class)
                    .setRegion(region)
                    .trigger();
        }
    }

    private void initialiserRegions() {
        for (Region region : Region.values()) {
            String nomRegion = resources().getString(region.name());
            nomRegionParRegion.put(region, nomRegion);
            regionParNomRegion.put(nomRegion, region);
        }
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

        fragment.setIdJoueur(leaderboard.idDuJoueur());

        conteneurLeaderboard.getChildren().add(fragment.rootNode());

        fragment.rootNode().setUserData(fragment);

    }

    public void viderListeLeaderboard() {
        conteneurLeaderboard.getChildren().clear();
    }

    public void afficherRegionCourante(String idRegion) {
        Region region = null;

        if (idRegion != null) {
            region = Region.valueOf(idRegion);
        }
        if (region == null) {
            comboRegion.getSelectionModel().clearSelection();
        } else {
            comboRegion.getSelectionModel().select(nomRegionParRegion.get(region));
        }
    }


}
