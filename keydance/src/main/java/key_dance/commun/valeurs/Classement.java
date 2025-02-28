package key_dance.commun.valeurs;

import ca.ntro.app.models.ModelValue;

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

    public Classement(String idClassement, Joueur premierJoueur){
        this.idClassement = idClassement;
        this.premierJoueur = premierJoueur;
    }

    
}
