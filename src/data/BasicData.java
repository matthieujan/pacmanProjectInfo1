package data;

import main.Engine;
import ressources.Content;
import ressources.Pair;

/**
 * Project pacmanProjectInfo1, BasicData
 * Created on Sat 3/11/17
 *
 * @author Matthieu Jan - matthieu.jan56@gmail.com
 */
public class BasicData implements DataInterface{

    char[][] currentWalls;
    String[][] currentContent;
    String[] currentCharacters;
    int toEat;
    public void resetData(){
        if(true){
            currentContent = createBasicContent();
            currentCharacters = createBasicCharacter();
            currentWalls = createBasicWall();
            toEat = 0;
            for(String[] i : currentContent){
                for(String j : i){
                    if(j == "GOMME"){
                        toEat++;
                    }
                }
            }

        }
    }

    public char[][] getWalls() {
        return currentWalls;
    }

    public String[] getCharacters() {
        return currentCharacters;
    }

    public String[][] getContent() {
        return currentContent;
    }

    public int getScoreOf(String entityName) {
        return 100;
    }

    public void setContent(Pair<Integer, Integer> position, String content) {
        if("GOMME".equals(currentContent[position.x][position.y])){
            toEat--;
        }
        if("GOMME".equals(content)){
            toEat++;
        }
        currentContent[position.x][position.y] = content;

    }

    @Override
    public int leftToEat() {
        System.out.println(toEat);
        return toEat;
    }

    private String[][] createBasicContent(){
        String[][] ret = {
                {null,null,"GOMME",null,null},
                {null,"GOMME","GOMME","GOMME",null},
                {null,"GOMME","GHOSTSPAWN","GOMME",null},
                {null,"GOMME","PACSPAWN","GOMME",null},
                {null,null,"GOMME",null,null},
                };

        return ret;
    }

    private char[][] createBasicWall(){
        char[][] ret ={
                {'W','W','D','W','W'},
                {'W','R','D','L','W'},
                {'W','R','D','L','W'},
                {'W','R','U','L','W'},
                {'W','W','U','W','W'},

                };
        return ret;
    }

    private String[] createBasicCharacter(){
        String[] ret = {"Pacman","Ghost"};
        return ret;
    }
}
