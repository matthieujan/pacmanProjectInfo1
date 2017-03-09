package data;

/**
 * Project pacmanProjectInfo1, DataInterface
 * Created on Thu 3/9/17
 *
 * @author Matthieu Jan - matthieu.jan56@gmail.com
 */
public interface DataInterface {

    /**
     * Méthode permettant de recuperer la position des murs et des lanes du niveau actuel.
     *
     * Contrat : Les couloirs indiquent le plus court chemin pour retourner au spawn
     * Contrat : Les murs ont la lettre M, les couloirs H/B/G/D
     * Contrat : Un couloir à la case (1,x) implique un couloir à la case (ret[].length,x) et inversement.
     * Contrat : Un couloir à la case (x,0) implique un couloir à la case (x,ret.[0].length)
     * Contrat : ret.length >= 3
     * Contrat : Pour tout <x,y>, ret[x].length == ret[y].length >= 3;
     * Contrat : Les couloirs forment un graphe non orienté avec une seule composante connexe.
     *
     * @return un tableau de char a deux dimensions
     */
    char[][] getWalls();

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

    /**
     * Methode permettant de savoir si un objet mangé par pacman lui donne une vie.
     *
     * @param itemName
     * @return
     * @throws exceptions.UnknownItemException si l'item demandé ne fait pas partie du niveau
     */
    boolean isGivingLife(String itemName);

    /**
     * Methode permettant de savoir si un objet mangé par pacman lui donne un pouvoir.
     *
     * @param itemName
     * @return Null si false, le nom du pouvoir sinon (ouverture vers des pouvoirs rigolos)
     * @throws exceptions.UnknownItemException si l'item demandé ne fait pas partie du niveau
     */
    String isGivingPower(String itemName);

}
