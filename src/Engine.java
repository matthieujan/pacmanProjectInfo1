import controller.ControllerInterface;
import data.DataInterface;
import ressources.Pair;
import view.ViewInterface;

import javax.xml.crypto.Data;

/**
 * Project pacmanProjectInfo1, Engine
 * Created on Thu 3/9/17
 * Engine est la classe qui coordonne le comportement du logiciel. Il possede un objet de chaque package implementant les interfaces necessaires au fonctionnement du logiciel.
 * Chacun de ses objets est indépendant, mais les contrats des interfaces devront être respecté.
 * C'est Engine qui "répond" au différente classe, et pour simplifier le fonctionnement, il a une structure semblable a un singleton, mais avec un constructeur public, permettant a launcher de créer des Engines différents si besoin (Data différente, par exemple)
 * Engine implemente les 3 interfaces, et appelle l'objet approprié à chaque fois.
 * @author Matthieu Jan - matthieu.jan56@gmail.com
 */
public class Engine implements DataInterface,ViewInterface,ControllerInterface{
    private static Engine instance;

    public static Engine getInstance() {
        return instance;
    }

    private DataInterface dat;
    private ControllerInterface ctrl;
    private ViewInterface view;

    int currentLevel;


    public Engine(DataInterface dat, ControllerInterface ctrl, ViewInterface view) {
        this.dat = dat;
        this.ctrl = ctrl;
        this.view = view;
        currentLevel = 0;
        instance = this;
    }

    public void resetView() {
        view.resetView();
    }

    public void resetGame() {
        view.resetGame();
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public String[][] getCurrentContent() {
        return new String[0][];
    }

    public boolean isValidMove(String entityName, Pair<Float, Float> entityPosition, String entityDirection) {
        return false;
    }

    public String getAMove(String entityName, Pair<Float, Float> entityPosition) {
        return null;
    }

    public String whatHappen(String entityOne, String entityTwo) {
        return null;
    }

    public String[] getBuffOf(String entityName) {
        return new String[0];
    }

    public char[][] getWalls() {
        return new char[0][];
    }

    public String[][] getContent() {
        return new String[0][];
    }

    public int getScoreOf(String entityName) {
        return 0;
    }

    public boolean isGivingLife(String itemName) {
        return false;
    }

    public String isGivingPower(String itemName) {
        return null;
    }
}
