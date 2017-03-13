package data;

import ressources.Pair;

/**
 * Project pacmanProjectInfo1, DataInterface
 * Created on Thu 3/9/17
 *
 * @author Matthieu Jan - matthieu.jan56@gmail.com
 */
public interface DataInterface {

    /**
     * Methode indiquant a data de reinitialiser son contenu (nouvelle partie)
     */
    void resetData();

    /**
     * Méthode permettant de recuperer la position des murs et des lanes du niveau actuel.
     *
     * Contrat : Les couloirs indiquent le plus court chemin pour retourner au spawn
     * Contrat : Les murs ont la lettre W, les couloirs U/D/L/R
     * Contrat : Un couloir à la case (0,x) implique un couloir à la case (ret.length,x) et inversement.
     * Contrat : Un couloir à la case (x,0) implique un couloir à la case (x,ret.[0].length)
     * Contrat : ret.length >= 3
     * Contrat : Pour tout <x,y>, ret[x].length == ret[y].length >= 3;
     * Contrat : Les couloirs forment un graphe non orienté avec une seule composante connexe.
     * Contrat : Les circuits du graphe contiennent au moins 8 elements
     *
     * @return un tableau de char a deux dimensions
     */

    char[][] getWalls();

    /**
     * Méthode renvoyant les personnages du niveau
     * @return
     */

    String[] getCharacters();

    /**
     * Méthode permettant de recuperer la position item et des spawns (ghost et pacman) du niveau actuel.
     * <p>
     * Contrat : Les couloirs indiquent le plus court chemin pour retourner au spawn
     * Contrat : Les murs ont la lettre M, les couloirs H/B/G/D
     * Contrat : Un couloir à la case (0,x) implique un couloir à la case (ret[].length,x) et inversement.
     * Contrat : Un couloir à la case (x,0) implique un couloir à la case (x,ret.[0].length)
     * Contrat : ret.length >= 3
     * Contrat : Pour tout <x,y>, ret[x].length == ret[y].length >= 3;
     *
     * @return un tableau de char a deux dimensions
     */
    String[][] getContent();

    /**
     * Methode permettant de récuperer le score d'un entité mangé par pacman.
     *
     * @param entityName
     * @return
     * @throws exceptions.UnknownItemException si l'entité demandé ne fait pas partie du niveau
     */

    int getScoreOf(String entityName);

    void setContent(Pair<Integer,Integer> position, String content);

    int leftToEat();
}

