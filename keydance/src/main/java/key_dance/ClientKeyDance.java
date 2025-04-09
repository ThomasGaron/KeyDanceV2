package key_dance;

import ca.ntro.app.NtroClientFx;
import ca.ntro.app.backend.BackendRegistrar;
import ca.ntro.app.frontend.FrontendRegistrarFx;
import ca.ntro.app.messages.MessageRegistrar;
import ca.ntro.app.models.ModelRegistrar;
import key_dance.commun.Declarations;
import key_dance.dorsal.DorsalKeydanceDistant;
import key_dance.frontal.FrontalKeyDance;

public class ClientKeyDance implements NtroClientFx {

    public static void main(String[] args) {
        NtroClientFx.launch(args);
    }

    @Override
    public void registerFrontend(FrontendRegistrarFx registrar) {
        registrar.registerFrontend(FrontalKeyDance.class);
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
        registrar.registerBackend(DorsalKeydanceDistant.class);
    }

}
