package view;
import logic.Engine;
import java.util.List;

/**
 * Project pacmanProjectInfo1, ViewSimpleWindow
 * Created on Mon 2/27/17
 *
 * @author Matthieu Jan - matthieu.jan56@gmail.com
 */
public class ViewSimpleWindow extends ViewInterface{

  public Engine e;
  public List<String> characters;
  public String map;
  public int speed;

  /**
   * Create a simple window to display the game.
   * @param  Engine       e             [description]
   * @param  List<String> characters    [description]
   * @param  String[][]   map           [description]
   * @return              [description]
   */
  public ViewSimpleWindow(Engine e, List<String> characters, String[][] map) {
    super(e, characters, map);
  }

  /**
   * Draw a map on a canvas.
   * @param String[][] map The said map.
   * @pre For all (i,j) map[i][j]!=null
   */
  public void drawMap(String[][] map) {

  }

  /**
   * Process all the object on the map.
   */
  public void animate() {

  }

  /**
   * Set a new direction to an object.
   * @param String objectName The name of the object.
   * @param String direction  The direction the object is supposed to follow ("up", "right", "down", "left").
   */
  public void setDirection(String objectName, String direction) {

  }

  /**
   * Set a speed parameter to an object.
   * @param String objectName The name of the object.
   * @param String speed      The speed parameter.
   * @pre 1<speed<10
   */
  public void setSpeed(String objectName, String speed) {

  }

  /**
   * Set current score of the game.
   * @param int score The new score of the current game.
   */
  public void setScore(int score) {

  }

  /**
   * Handle an object until it get a direction.
   * @param String objectName The name of the object.
   */
  public void processObject(String objectName) {

  }
}
