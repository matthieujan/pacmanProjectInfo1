import java.awt.geom.*;

public class GumView extends Figure {

  private Shape gumShape;

  public GumView(int size, int x, int y) {
    super(size, size, x, y, "white");
    this.gumShape = new Arc2D.Float(getX(), getY(), getWidth(), getHeight(), 30.0F, 300.0F, 2);
  }

  public void draw() {
    BasicView.getCanvas.draw(this, color, ghostShape);
  }
}
