package view;

import logic.Engine;

import java.util.List;

/**
 * Project pacmanProjectInfo1, ViewInterface
 * Created on Mon 2/27/17
 *
 * @author Matthieu Jan - matthieu.jan56@gmail.com
 */
public abstract class ViewInterface {

    protected Engine engine;

    public abstract void drawMap(String[][] map);
    public abstract void refresh();
    public abstract void animate();
    public abstract void setDirection(String objectName, String direction);
    public abstract void setScore(int score);

    public ViewInterface(Engine e, List<String> characters, String[][] map){
        engine = e;
    }



}
