package view;

import main.*;

/**
 * Project pacmanProjectInfo1, BasicView
 * Created on Sat 3/11/17
 *
 * @author Matthieu Jan - matthieu.jan56@gmail.com
 */
public class BasicView implements ViewInterface {

    public BasicView() {

    }

    /**
     * Construit une nouvelle fenetre vierge, puis la rempli avec les elements actuels
     * Utilisé une seule fois pour construire la fenetre
     */
    @Override
    public void resetView() {
        int size = 20;
        char[][] walls = Engine.getInstance().getWalls();
        for(int i = 0;i<walls.length;i++){
            for(int j = 0;j<walls[0].length;j++){
                if(walls[i][j] == 'W'){
                    Figure b = new WallBlock(size,i*size,j*size,"Red");
                    b.draw();
                }
            }
        }
        Canvas.getCanvas().redraw();
    }

    /**
     * Methode permettant de preparer une nouvelle partie
     */
    @Override
    public void resetGame() {
        resetView();
    }
}
