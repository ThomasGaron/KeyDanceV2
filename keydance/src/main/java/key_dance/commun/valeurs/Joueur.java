package key_dance.commun.valeurs;

import ca.ntro.app.models.ModelValue;

public class Joueur implements ModelValue {

    private String id;
    private String username;
    private String region;
    private int score = 0;

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

    public int scoreClassement(){
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getId() {
        return id;
    }

}
