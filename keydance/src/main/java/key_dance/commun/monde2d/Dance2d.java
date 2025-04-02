package key_dance.commun.monde2d;

import ca.ntro.app.fx.controls.World2dMouseEventFx;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.ArcType;

public class Dance2d extends ObjetKeydance2d {

    @Override
    public String id() {
        return "dance";
    }

    @Override
    public void initialize() {
        setWidth(10);
        setHeight(10);
        setTopLeftX(100);
        setTopLeftY(100);
    }

    @Override
    public void drawOnWorld(GraphicsContext gc) {
        gc.fillArc(getTopLeftX(),
                getTopLeftY(),
                getWidth(),
                getHeight(),
                0,
                360,
                ArcType.CHORD);
    }

    @Override
    protected boolean onMouseEvent(World2dMouseEventFx mouseEvent) {
        return false;
    }

}
