package view;

import java.util.ArrayList;
import java.util.List;

/**
 * Project pacmanProjectInfo1, ItemGenerator
 * Created on Sun 3/12/17
 *
 * @author Matthieu Jan - matthieu.jan56@gmail.com
 */
public class ItemGenerator {

    private final int blockSize;

    ItemGenerator(int blockSize){
        this.blockSize = blockSize;
    }

    public Item[][] getItemList(String[][] itemList){
        Item[][] ret = new Item[itemList.length][itemList[0].length];
        for(int i = 0;i<itemList.length;i++){
            for(int j = 0;j<itemList[0].length;j++){
                if(itemList[i][j] == "GOMME"){
                    ret[i][j] = getItemGomme(i,j);
                }else{
                    ret[i][j] = null;
                }
            }
        }
        return ret;
    }

    private Item getItemGomme(int x, int y){
        return new Item(blockSize,x*blockSize,y*blockSize,"red");
    }


}
