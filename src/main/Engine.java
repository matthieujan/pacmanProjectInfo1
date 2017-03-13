package main;

import controller.ControllerInterface;
import data.DataInterface;
import ressources.Buff;
import ressources.Event;
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

    int currentLevel;


    private Engine(GameHandlers g) {
        this.dat = g.getModel();
        this.ctrl = g.getCtr();
        this.view = g.getView();
        currentLevel = 0;
    }

    public void startView(){
        view.startView();
    }

    public void resetView() {
        view.resetView();
    }

    public void start(){
        dat.resetData();
        view.resetGame();

        while(true){
            view.startView();
            currentLevel++;
            resetData();
            resetView();
        }
    }

    public void resetGame() {
        dat.resetData();
        view.resetGame();
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public boolean isValidMove(String entityName, Pair<Float, Float> entityPosition, String entityDirection) {
        return ctrl.isValidMove(entityName, entityPosition, entityDirection);
    }

    public String getAMove(String oldDirection,String entityName, Pair<Float, Float> entityPosition) {
        return ctrl.getAMove(oldDirection,entityName,entityPosition);
    }

    @Override
    public Event whatHappen(String entityOne, String entityTwo) {
        return ctrl.whatHappen(entityOne,entityTwo);
    }

    public Buff[] getBuffOf(String entityName) {
        return ctrl.getBuffOf(entityName);
    }

    @Override
    public boolean endGame() {
        return ctrl.endGame();
    }

    @Override
    public void resetData() {
        dat.resetData();
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

    @Override
    public void setContent(Pair<Integer, Integer> position, String content) {
        dat.setContent(position,content);
    }

    @Override
    public int leftToEat() {
        return dat.leftToEat();
    }
}
