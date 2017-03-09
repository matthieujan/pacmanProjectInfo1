package view;

/**
 * Project pacmanProjectInfo1, ViewInterface
 * Created on Mon 2/27/17
 *
 * @author Matthieu Jan - matthieu.jan56@gmail.com
 */
public interface ViewInterface {
    /**
     * Construit une nouvelle fenetre vierge, puis la remplie avec les elements actuels
     * Utilisé une seule fois pour construire la fenetre
     */
    void resetView();

    /**
     * Methode permettant de preparer une nouvelle partie
     */
    void resetGame();
}
