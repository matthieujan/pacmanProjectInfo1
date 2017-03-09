package controller;

import ressources.Pair;

/**
 * Project pacmanProjectInfo1, ControllerInterface
 * Created on Thu 3/9/17
 *
 * @author Matthieu Jan - matthieu.jan56@gmail.com
 */
public interface ControllerInterface {
    int getCurrentLevel();
    String[][] getCurrentContent();
    boolean isValidMove(String entityName, Pair<Float,Float> entityPosition, String enityDirection);
    String getAMove(String entityName,Pair<Float,Float> entityPosition);
    String whatHappen(String entityOne, String entityTwo);
    String[] getBuffOf(String entityName);
}
