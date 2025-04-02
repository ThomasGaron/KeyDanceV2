package key_dance.frontal.controles;

import ca.ntro.app.fx.controls.ResizableWorld2dCanvasFx;
import key_dance.commun.monde2d.MondeKeydance2d;

public class CanvasMenu extends ResizableWorld2dCanvasFx {

    @Override
    protected void initialize() {
        setInitialWorldSize(MondeKeydance2d.LARGEUR_MONDE, MondeKeydance2d.HAUTEUR_MONDE);
    }

    public void afficherFps(String fps) {
        drawOnCanvas(gc -> {
            gc.fillText(fps, 0, 12);
        });
    }

}
