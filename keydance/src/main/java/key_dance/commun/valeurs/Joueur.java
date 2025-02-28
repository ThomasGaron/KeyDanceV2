package key_dance.commun.valeurs;

import ca.ntro.app.models.ModelValue;

public class Joueur implements ModelValue {

    private String id;
    private String username;
    private String region;
    // private int score;

    public void setId(String id){
        this.id = id;
    }

    public void setUsername(String username){
        this.username = username;
    }
    
    public void setRegion(String region){
        this.region = region;
    }

    public Joueur() {

    }

    public String usernameClassement() {
        return username;
    }
}
