package view;
import java.awt.*;
import java.awt.geom.*;

public class GhostView extends Figure {

  private Shape ghostShape;


  public GhostView(int size, int x, int y, String color) {
    super(size, size, x, y, color);
    this.ghostShape = new Arc2D.Float(getX(), getY(), getWidth(), getHeight(), 30.0F, 300.0F, 2);
  }

  public void draw() {
  }
}
