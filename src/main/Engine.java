package main;

import controller.ControllerInterface;
import data.DataInterface;
import ressources.GameHandlers;
import ressources.Pair;
import view.ViewInterface;

/**
 * Project pacmanProjectInfo1, main.Engine
 * Created on Thu 3/9/17
 * main.Engine est la classe qui coordonne le comportement du logiciel. Il possede un objet de chaque package implementant les interfaces necessaires au fonctionnement du logiciel.
 * Chacun de ses objets est indépendant, mais les contrats des interfaces devront être respecté.
 * C'est main.Engine qui "répond" au différente classe, et pour simplifier le fonctionnement, il a une structure semblable a un singleton, mais avec un constructeur public, permettant a launcher de créer des Engines différents si besoin (Data différente, par exemple)
 * main.Engine implemente les 3 interfaces, et appelle l'objet approprié à chaque fois.
 * @author Matthieu Jan - matthieu.jan56@gmail.com
 */
public class Engine implements DataInterface,ViewInterface,ControllerInterface {
    private static Engine instance = null;

    public static Engine getInstance() {
        if (instance == null) {
            instance = new Engine(Launcher.getConfig());
        }
        return instance;
    }

    private DataInterface dat;
    private ControllerInterface ctrl;
    private ViewInterface view;

    String[][] currentContent;

    int currentLevel;


    private Engine(GameHandlers g) {
        this.dat = g.getModel();
        this.ctrl = g.getCtr();
        this.view = g.getView();
        currentLevel = 0;
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
        return ctrl.getCurrentContent();
    }

    public boolean isValidMove(String entityName, Pair<Float, Float> entityPosition, String entityDirection) {
        return ctrl.isValidMove(entityName, entityPosition, entityDirection);
    }

    public String getAMove(String entityName, Pair<Float, Float> entityPosition) {
        return ctrl.getAMove(entityName,entityPosition);
    }

    public String whatHappen(String entityOne, String entityTwo) {
        return ctrl.whatHappen(entityOne, entityTwo);
    }

    public String[] getBuffOf(String entityName) {
        return ctrl.getBuffOf(entityName);
    }

    public char[][] getWalls() {
        return dat.getWalls();
    }

    public String[] getCharacters() {
        return dat.getCharacters();
    }

    public String[][] getContent() {
        return dat.getContent();
    }

    public int getScoreOf(String entityName) {
        return dat.getScoreOf(entityName);
    }

    public String isGivingPower(String itemName) {
        return dat.isGivingPower(itemName);
    }
}
