package data;

/**
 * Project pacmanProjectInfo1, BasicData
 * Created on Sat 3/11/17
 *
 * @author Matthieu Jan - matthieu.jan56@gmail.com
 */
public class BasicData implements DataInterface{
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
    public String isGivingPower(String itemName) {
        return null;
    }
}
