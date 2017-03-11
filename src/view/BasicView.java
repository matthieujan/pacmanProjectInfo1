package view;

import main.*;

/**
 * Project pacmanProjectInfo1, BasicView
 * Created on Sat 3/11/17
 *
 * @author Matthieu Jan - matthieu.jan56@gmail.com
 */
public class BasicView implements ViewInterface {

    private Canvas canvas;
    private LevelView levelview;
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
      this.canvas = Canvas.getCanvas();
      this.levelView = new LeveView();
      this.pacman = new PacmanView();
      this.ghost1 = new GhostView();
      LevelView.draw();
    }

    /**
     * Methode permettant de preparer une nouvelle partie
     */
    @Override
    public void resetGame() {

    }

    public Canvas getCanvas() {
      return this.canvas;
    }

    public Figure[] getCharacters() {
      return this.characters;
    }

    public char[][] getWalls() {
      return this.walls;
    }

    public String[][] getContent() {
      return this.content;
    }

    public int getMapSize() {
      return this.mapSize;
    }

    public float getPas() {
      return this.mapSize/500;
    }
}
