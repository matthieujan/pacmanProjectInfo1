package view;

import main.*;

/**
 * Project pacmanProjectInfo1, BasicView
 * Created on Sat 3/11/17
 *
 * @author Matthieu Jan - matthieu.jan56@gmail.com
 */
public class BasicView implements ViewInterface {

    private static Canvas canvas;
    private LevelView levelView;
    private PacmanView pacman;
    private GhostView ghost1;
    private int mapSize;
    public static float pas;

    public BasicView() {

    }

    /**
     * Construit une nouvelle fenetre vierge, puis la remplie avec les elements actuels
     * Utilisé une seule fois pour construire la fenetre
     */
    @Override
    public void resetView() {
      canvas = Canvas.getCanvas();
      this.levelView = new LevelView();
      this.levelView.draw();
    }

    /**
     * Methode permettant de preparer une nouvelle partie
     */
    @Override
    public void resetGame() {

    }

    public float getPas() {
      return this.mapSize/500;
    }
}
