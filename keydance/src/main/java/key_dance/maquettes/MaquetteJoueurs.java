package key_dance.maquettes;

import java.util.List;

import ca.ntro.app.Ntro;
import key_dance.commun.valeurs.Joueur;

public class MaquetteJoueurs {

    public static Joueur creerJoueur(String id){
        Joueur joueur = new Joueur();

        if(id.equals("alice")){
            joueur = creerJoueur(id, "Alice", "NA");
        } else if(id.equals("bob")){
            joueur = creerJoueur(id, "Bob", "AS");

        }else if(id.equals("charlie")){
            joueur = creerJoueur(id, "Charlie", "EU");
        } else {
            joueur = joueurAleatoire(id);
        } 

        return joueur;
    }

    public static Joueur creerJoueur(String id, String username, String region){
        Joueur usager = new Joueur();

        usager.setId(id);
        usager.setUsername(username);
        usager.setRegion(region);

        return usager;
    }

    public static Joueur joueurAleatoire(String id) {
        Joueur usager = new Joueur();

        usager.setId(id);
        usager.setUsername(usernameAleatoire());
        usager.setRegion(regionAleatoire());

        return usager;
    }

    public static Joueur joueurAleatoire() {
        return joueurAleatoire(idAleatoire());
    }

    private static String idAleatoire(){
        return Ntro.random().nextId(4);
    }

    private static String usernameAleatoire(){
        List<String> choixDeUsernames = List.of("Alice",
                                                            "Bob",
                                                            "Chaaya",
                                                            "Dominic",
                                                            "Élisabeth",
                                                            "Firas",
                                                            "Gregson",
                                                            "Mehdi",
                                                            "Louis",
                                                            "Marcel",
                                                            "Ashwin",
                                                            "Ichiro",
                                                            "Jun");

    return Ntro.random().choice(choixDeUsernames);
    }

    private static String regionAleatoire(){
        List<String> choixDeRegions = List.of("NA", "EU", "SA", "AS", "OC");

        return Ntro.random().choice(choixDeRegions);
    }

}
