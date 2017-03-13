package controller;

import ressources.Buff;
import ressources.Event;
import ressources.Pair;

/**
 * Project pacmanProjectInfo1, ControllerInterface
 * Created on Thu 3/9/17
 *
 * @author Matthieu Jan - matthieu.jan56@gmail.com
 */
public interface ControllerInterface {
    /**
     * Methode qui renvoie le niveau actuel
     * @return
     */
    int getCurrentLevel();

    /**
     * Verifie si un mouvemnt est valide
     * @param entityName l'entité qui bouge
     * @param entityPosition la position actuelle de l'entité, relative à la map
     * @param entityDirection la direction dans laquel l'ihm souhaite aller
     * @return
     */
    boolean isValidMove(String entityName, Pair<Float,Float> entityPosition, String entityDirection);

    /**
     * Obtient un mouvement sur demande
     * Renvoi null pour pacman, une direction pour un fantome (décide de son comportement)
     * @param entityName le nom de l'entité
     * @param entityPosition sa position actuelle (pour detecter d'eventuelle LOS)
     * @return
     */
    String getAMove(String oldDirection, String entityName,Pair<Float,Float> entityPosition);

    /**
     * Decrit l'action qui se produit en cas de rencontre entre deux objets
     * @param entityOne
     * @param entityTwo
     * @return
     */
    Event whatHappen(String entityOne,String entityTwo);

    /**
     * Recupere les buffs de l'entité (concretement, pour un fantome, "eatable", ou pour pacman, "superspeed")
     * @param entityName
     * @return
     */
    Buff[] getBuffOf(String entityName);


    boolean endGame();
}
