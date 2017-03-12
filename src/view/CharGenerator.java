package view;

import ressources.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * Project pacmanProjectInfo1, CharGenerator
 * Created on Sun 3/12/17
 *
 * @author Matthieu Jan - matthieu.jan56@gmail.com
 */
public class CharGenerator{

    private final int blockSize;
    private final String[][] content;

    CharGenerator(int blockSize, String[][] content){
        this.blockSize = blockSize;
        this.content = content;
    }

    Char[] getCharArray(String[] chars){
        Char[] ret = new Char[chars.length];
        Pair<Integer,Integer> pos;
        for(int i = 0;i<ret.length;i++){
           if(chars[i] == "Pacman"){
               pos = getSmthg("PACSPAWN").get(0);
               ret[i] = new Char(chars[i],blockSize,pos.x*blockSize,pos.y*blockSize,"yellow");
           }else{
               pos = getSmthg("GHOSTSPAWN").get(0);
               ret[i] = new Char(chars[i],blockSize,pos.x*blockSize,pos.y*blockSize,"green");

           }
        }
        return ret;
    }

    List <Pair<Integer,Integer>> getSmthg(String toSearch){
        List<Pair<Integer,Integer>> s = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i<content.length){
            while(j<content[0].length){
                if(content[i][j] == toSearch){
                    s.add(new Pair<>(i, j));
                }
                j++;
            }
            j=0;
            i++;
        }
        return s;
    }
}
