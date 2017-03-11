package main;

import controller.BasicController;
import data.BasicData;
import ressources.GameHandlers;
import view.BasicView;

/**
 * Project pacmanProjectInfo1, main.Launcher
 * Created on Thu 3/9/17
 *
 * @author Matthieu Jan - matthieu.jan56@gmail.com
 */
public class Launcher {


    public static GameHandlers getConfig(){
        return new GameHandlers(new BasicData(), new BasicView(), new BasicController());
    }

    public static void main(String[] args){
        Engine e = Engine.getInstance();
        e.resetGame();
    }
}
