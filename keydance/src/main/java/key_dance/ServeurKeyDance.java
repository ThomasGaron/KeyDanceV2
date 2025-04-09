package key_dance;

import ca.ntro.app.NtroServerFx;
import ca.ntro.app.backend.BackendRegistrar;
import ca.ntro.app.common.ServerRegistrar;
import ca.ntro.app.messages.MessageRegistrar;
import ca.ntro.app.models.ModelRegistrar;
import key_dance.commun.Declarations;
import key_dance.dorsal.DorsalKeydance;

public class ServeurKeyDance implements NtroServerFx {

    public static void main(String[] args) {
        NtroServerFx.launch(args);
    }

    @Override
    public void registerServer(ServerRegistrar registrar) {
        Declarations.declarerServeur(registrar);
    }

    @Override
    public void registerModels(ModelRegistrar registrar) {
        Declarations.declarerModeles(registrar);
    }

    @Override
    public void registerMessages(MessageRegistrar registrar) {
        Declarations.declarerMessages(registrar);
    }

    @Override
    public void registerBackend(BackendRegistrar registrar) {
        registrar.registerBackend(DorsalKeydance.class);
    }

}
