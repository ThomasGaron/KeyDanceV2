package key_dance.dorsal;

import ca.ntro.app.backend.RemoteBackendNtro;
import ca.ntro.app.common.ServerRegistrar;
import key_dance.commun.Declarations;

public class DorsalKeydanceDistant extends RemoteBackendNtro {

    @Override
    public void registerServer(ServerRegistrar registrar) {
        Declarations.declarerServeur(registrar);
    }
}
