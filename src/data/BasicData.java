package data;

import ressources.Pair;

/**
 * Project pacmanProjectInfo1, BasicData
 * Created on Sat 3/11/17
 *
 * @author Matthieu Jan - matthieu.jan56@gmail.com
 */
public class BasicData implements DataInterface{
    @Override
    public void resetData() {
        }

    @Override
    public char[][] getWalls() {
        return new char[0][];
    }

    @Override
    public String[] getCharacters() {
        return new String[0];
    }

    @Override
    public String[][] getContent() {
        return new String[0][];
    }

    @Override
    public int getScoreOf(String entityName) {
        return 0;
    }

    @Override
    public void setContent(Pair<Integer, Integer> position, String content) {

    }

}
