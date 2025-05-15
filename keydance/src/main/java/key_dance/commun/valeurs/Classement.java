package key_dance.commun.valeurs;

import ca.ntro.app.frontend.ViewLoader;
import ca.ntro.app.models.ModelValue;
import key_dance.frontal.fragments.FragmentLeaderboard;

public class Classement implements ModelValue {

    // a modifier
    private String idClassement;
    private Joueur premierJoueur;

    protected Joueur premierJoueur() {
        return premierJoueur;
    }

    @Override
    public String toString() {
        return premierJoueur().usernameClassement();
    }

    public Classement() {

    }

    public Classement(String idClassement, Joueur premierJoueur) {
        this.idClassement = idClassement;
        this.premierJoueur = premierJoueur;
    }

    public FragmentLeaderboard creerFragment(ViewLoader<FragmentLeaderboard> viewLoaderLeaderboard) {
        return viewLoaderLeaderboard.createView();
    }

    public void afficherSur(FragmentLeaderboard fragmentLeaderboard) {
        fragmentLeaderboard.afficherNomJoueur(premierJoueur.usernameClassement());
        fragmentLeaderboard.afficherScoreJoueur(premierJoueur.scoreClassement());
    }

}
