package controller;

import main.Engine;
import ressources.Pair;
/**
 * Project pacmanProjectInfo1, BasicController
 * Created on Sat 3/11/17
 *
 * @author Matthieu Jan - matthieu.jan56@gmail.com
 */
public class BasicController implements ControllerInterface{

    String[][] content;


    public BasicController(){

    }

    @Override
    public int getCurrentLevel() {
        return Engine.getInstance().getCurrentLevel();
    }

    @Override
    public String[][] getCurrentContent() {
        return new String[0][];
    }

    @Override
    public boolean isValidMove(String entityName, Pair<Float, Float> entityPosition, String entityDirection) {
        return false;
    }

    @Override
    public String getAMove(String entityName, Pair<Float, Float> entityPosition) {
        return null;
    }

    @Override
    public String whatHappen(String entityOne, String entityTwo) {
        return null;
    }

    @Override
    public String[] getBuffOf(String entityName) {
        return new String[0];
    }
}
