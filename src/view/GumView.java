package view;

import java.awt.geom.*;

public class GumView extends Figure {

  private Shape gumShape;

  public GumView(int size, int x, int y) {
    super(size, size, x, y, "white");
    this.gumShape = new Ellipse2D.Double(i*1.4*BasicView.getMapSize()/500, j*1.4*BasicView.getMapSize()/500, 0.2*BasicView.getMapSize()/500, 0.2*BasicView.getMapSize()/500);
  }

  public void draw() {
    BasicView.getCanvas.draw(this, color, ghostShape);
  }
}
