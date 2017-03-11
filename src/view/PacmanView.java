import java.awt.geom.*;

public class PacmanView extends Figure {

  private Shape pacmanShape;

  public PacmanView(int size, int x, int y) {
    super(size, size, x, y, "yellow");
    this.pacmanShape = new Arc2D.Float(0.0F, 0.0F, BasicView.getMapSize()/500, BasicView.getMapSize()/500, 0.0F, 330.0F, 2);
  }

  public void draw() {
    BasicView.getCanvas.draw(this, "yellow", pacmanShape);
  }
}
