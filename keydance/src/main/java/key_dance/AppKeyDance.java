package key_dance;

import ca.ntro.app.NtroAppFx;
import ca.ntro.app.backend.BackendRegistrar;
import ca.ntro.app.frontend.FrontendRegistrarFx;
import ca.ntro.app.messages.MessageRegistrar;
import ca.ntro.app.models.ModelRegistrar;
import key_dance.commun.messages.MsgAjouterClassement;
import key_dance.commun.modeles.ModeleLeaderboard;
import key_dance.commun.valeurs.Classement;
import key_dance.commun.valeurs.Joueur;
import key_dance.dorsal.DorsalKeydance;
import key_dance.frontal.FrontalKeyDance;

public class AppKeyDance implements NtroAppFx {

    public static void main(String[] args) {
        NtroAppFx.launch(args);
    }

    @Override
    public void registerFrontend(FrontendRegistrarFx registrar) {
        registrar.registerFrontend(FrontalKeyDance.class);
    }

    @Override
    public void registerModels(ModelRegistrar registrar) {
        registrar.registerModel(ModeleLeaderboard.class);
        registrar.registerValue(Joueur.class);
        registrar.registerValue(Classement.class);

    }

    @Override
    public void registerMessages(MessageRegistrar registrar) {
        registrar.registerMessage(MsgAjouterClassement.class);
    }

    @Override
    public void registerBackend(BackendRegistrar registrar) {
        registrar.registerBackend(DorsalKeydance.class);
    }

}
