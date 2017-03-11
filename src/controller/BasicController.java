package controller;

import main.Engine;
import ressources.Buff;
import ressources.Event;
import ressources.Pair;
/**
 * Project pacmanProjectInfo1, BasicController
 * Created on Sat 3/11/17
 *
 * @author Matthieu Jan - matthieu.jan56@gmail.com
 */
public class BasicController implements ControllerInterface{

    public BasicController(){
    }

    @Override
    public int getCurrentLevel() {
        return Engine.getInstance().getCurrentLevel();
    }

    @Override
    public boolean isValidMove(String entityName, Pair<Float, Float> entityPosition, String entityDirection) {
        boolean ret = true;
        if((entityDirection == "LEFT") || (entityDirection == "RIGHT")){
            if(Math.floor(entityPosition.y-0.5) != entityPosition.y){
                ret = false;
            }
        }else if((entityDirection == "DOWN") || (entityDirection == "UP")) {
            if(Math.floor(entityPosition.x-0.5) != entityPosition.x){
                ret = false;
            }
        } else {
            ret = isWall(entityPosition,entityDirection);
        }
        return ret;
    }

    private boolean isWall(Pair<Float,Float> entityPosition, String dir){
        boolean ret = false;
        // Recuperation de la case actuelle
        int xPos = (int)Math.floor(entityPosition.x);
        int yPos = (int)Math.floor(entityPosition.y);

        char[][] w = Engine.getInstance().getWalls();

        // Recuperation de la case a atteindre
        switch(dir){
            case "UP" :
                yPos -=1;
                break;
            case "DOWN" :
                yPos += 1;
                break;
            case "LEFT" :
                xPos -=1;
                break;
            case "RIGHT" :
                xPos +=1;
                break;
        }

        // Modification des valeurs en cas
        int xLength = w.length;
        int yLength = w[0].length;

        yPos+= yLength;
        yPos %= yLength;

        xPos += xLength;
        xPos %= xLength;

        return w[xPos][yPos] == 'W';
    }

    @Override
    public String getAMove(String olddirection, String entityName, Pair<Float, Float> entityPosition) {
        String ret = "";
        int r = (int)(Math.floor(Math.random()*4));
        switch (r){
            case 0 : ret = "UP"; break;
            case 1 : ret = "RIGHT"; break;
            case 2 : ret = "LEFT"; break;
            case 3 : ret = "DOWN"; break;
        }

        if(entityName.matches("(.*)Pacman(.*)")){
            ret = null;
        }
        return ret;
    }

    @Override
    public Event whatHappen(String entityOne,Pair<Float,Float>posOne, String entityTwo,Pair<Float,Float> posTwo) {
        Event ret = null;
        if(entityOne.matches("(.*)Ghost") && entityTwo.matches("(.*)Pacman(.*)")){
            ret = Event.DIE;
        } else if(entityTwo.matches("(.*)Ghost") && entityOne.matches("(.*)Pacman(.*)")) {
            ret = Event.DIE;
        }
        else if(entityOne.matches("(.*)Item") && entityTwo.matches("(.*)Pacman(.*)")){
            ret = Event.EAT;
        } else if(entityTwo.matches("(.*)Item") && entityOne.matches("(.*)Pacman(.*)")) {
            ret = Event.EAT;
        }
        return ret;
    }

    @Override
    public Buff[] getBuffOf(String entityName) {
        Buff[] ret = null;
        return ret;
    }
}
