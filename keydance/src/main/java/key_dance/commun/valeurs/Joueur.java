package key_dance.commun.valeurs;

import ca.ntro.app.models.ModelValue;

public class Joueur implements ModelValue {

    private String id;
    private String username;
    private String region;
    // private int score;

    public Joueur() {

    }

    public String usernameClassement() {
        return username;
    }
}
