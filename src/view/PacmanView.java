import java.awt.geom.*;

public class PacmanView extends Figure {

  private Shape pacmanShape1, pacmanShape2, pacmanShape3;

  public PacmanView(int size, int x, int y) {
    super(size, size, x, y, "yellow");
    this.pacmanShape1 = new Arc2D.Float(getX(), getY(), getWidth(), getHeight(), 0.0F, 330.0F, 2);
    this.pacmanShape2 = new Arc2D.Float(getX(), getY(), getWidth(), getHeight(), 20.0F, 310.0F, 2);
    this.pacmanShape3 = new Arc2D.Float(getX(), getY(), getWidth(), getHeight(), 40.0F, 290.0F, 2);
  }

  public void draw() {
    BasicView.getCanvas.draw(this, "yellow", pacmanShape2);
  }
}
