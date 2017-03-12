package view;

/**
 * Project pacmanProjectInfo1, BlockGenerator
 * Created on Sun 3/12/17
 *
 * @author Matthieu Jan - matthieu.jan56@gmail.com
 */
public class BlockGenerator {

    private final int blockSize;
    private final String wallColor;
    private final String laneColor;

    BlockGenerator(int blockSize,String wallColor, String laneColor){
        this.blockSize = blockSize;
        this.wallColor = wallColor;
        this.laneColor = laneColor;
    }

    Block[][] getBlockArray(char[][] walls){
        Block[][] ret = new Block[walls.length][walls[0].length];
        for(int i = 0;i<walls.length;i++){
            for(int j = 0;j<walls[0].length;j++){
                if(walls[i][j] == 'W'){
                    ret[i][j] = getWall(i*blockSize,j*blockSize);
                }else{
                    ret[i][j] = getLane(i*blockSize,j*blockSize);
                }
            }
        }
        return ret;
    }

    public Block getWall(int x, int y){
        Block ret = new Block(blockSize, x, y, wallColor);
        return ret;
    }

    public Block getLane(int x, int y){
        Block ret = new Block(blockSize, x, y, laneColor);
        return ret;
    }
}
