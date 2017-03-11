import java.awt.geom.*;

import main.*;

public class LevelView extends Figure {

  private Shape wallShape;
  private Shape laneShape;

  public LevelView() {
    super(500, 500, 0, 0, "white");
  }

  public void draw() {
    for (int i=0; i<BasicView.getMapSize(); i++) {
      for (int j=0; j<BasicView.getMapSize(); j++) {
        if (Engine.getInstance().getWalls()[i][j]=='W') {
          BasicView.getCanvas.draw(this, "black", new Recangle2D.Float(i*BasicView.getMapSize()/500, j*BasicView.getMapSize()/500, BasicView.getMapSize()/500, BasicView.getMapSize()/500));
        } else if (Engine.getInstance().getWalls()[i][j]=='L') {
          BasicView.getCanvas.draw(this, "white", new Recangle2D.Float(i*BasicView.getMapSize()/500, j*BasicView.getMapSize()/500, BasicView.getMapSize()/500, BasicView.getMapSize()/500));
        }
        if (Engine.getInstance().getContent()[i][j]=="GOMME") {
          GumView.draw();
        }
      }
    }
    for (int i=0; i<BasicView.getCharacters().length(); i++) {
    }
  }
}
