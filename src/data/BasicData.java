package data;

import ressources.Pair;

/**
 * Project pacmanProjectInfo1, BasicData
 * Created on Sat 3/11/17
 *
 * @author Matthieu Jan - matthieu.jan56@gmail.com
 */
public class BasicData implements DataInterface{


   public void resetData() {
   }

    public char[][] getWalls() {
        return new char[0][];
    }

    public String[] getCharacters() {
        return new String[0];
    }

    public String[][] getContent() {
        return new String[0][];
    }

    public int getScoreOf(String entityName) {
        return 0;
    }

    public void setContent(Pair<Integer, Integer> position, String content) {

    }

}
