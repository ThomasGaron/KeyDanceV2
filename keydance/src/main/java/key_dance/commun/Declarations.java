package key_dance.commun;

import ca.ntro.app.common.ServerRegistrar;
import ca.ntro.app.messages.MessageRegistrar;
import ca.ntro.app.models.ModelRegistrar;
import key_dance.commun.messages.MsgActionAutreJoueur;
import key_dance.commun.messages.MsgAjouterClassement;
import key_dance.commun.modeles.ModeleLeaderboard;
import key_dance.commun.valeurs.Classement;
import key_dance.commun.valeurs.Joueur;

public class Declarations {

    public static void declarerMessages(MessageRegistrar registrar) {
        registrar.registerMessage(MsgAjouterClassement.class);

        registrar.registerMessage(MsgActionAutreJoueur.class);
    }

    public static void declarerModeles(ModelRegistrar registrar) {
        registrar.registerModel(ModeleLeaderboard.class);
        registrar.registerValue(Joueur.class);
        registrar.registerValue(Classement.class);
    }

    public static void declarerServeur(ServerRegistrar registrar) {
        registrar.registerName("localHost");
        registrar.registerPort(8002);
    }

}
