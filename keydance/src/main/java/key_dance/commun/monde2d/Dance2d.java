package key_dance.commun.monde2d;

import ca.ntro.app.Ntro;
import ca.ntro.app.fx.controls.World2dMouseEventFx;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.ArcType;

public class Dance2d extends ObjetKeydance2d {

    private static final double EPSILON = 1;

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

        setSpeedX(100 + Ntro.random().nextInt(100));
        setSpeedY(100 + Ntro.random().nextInt(100));
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

    @Override
    public void onTimePasses(double secondsElapsed) {
        super.onTimePasses(secondsElapsed);

        if (danceFrappeMurGauche()) {
            danceRebondiSurMurGauche();
        } else if (danceFrappeMurDroit()) {
            danceRebondiSurMurDroit();
        } else if (danceFrappePlafond()) {
            danceRebondiSurPlafond();
        } else if (danceFrappePlancher()) {
            danceRebondiSurPlancher();
        }
    }

    private void danceRebondiSurPlancher() {
        setTopLeftY(getWorld2d().getHeight() - this.getHeight() - EPSILON);
        setSpeedY(-getSpeedY());
    }

    private boolean danceFrappePlancher() {
        return getTopLeftY() + getHeight() >= getWorld2d().getHeight();
    }

    private void danceRebondiSurPlafond() {
        setTopLeftY(0 + EPSILON);
        setSpeedY(-getSpeedY());
    }

    private boolean danceFrappePlafond() {
        return getTopLeftY() <= 0;
    }

    private void danceRebondiSurMurDroit() {
        setTopLeftX(getWorld2d().getWidth() - this.getWidth() - EPSILON);
        setSpeedX(-getSpeedX());
    }

    private boolean danceFrappeMurDroit() {
        return getTopLeftX() + getWidth() >= getWorld2d().getWidth();
    }

    private void danceRebondiSurMurGauche() {
        setTopLeftX(0 + EPSILON);
        setSpeedX(-getSpeedX());
    }

    private boolean danceFrappeMurGauche() {
        return getTopLeftX() <= 0;
    }

}
