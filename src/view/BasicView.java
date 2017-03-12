package view;

import main.*;
import ressources.Canvas;

/**
 * Project pacmanProjectInfo1, BasicView
 * Created on Sat 3/11/17
 *
 * @author Matthieu Jan - matthieu.jan56@gmail.com
 */
public class BasicView implements ViewInterface {

    private Block[][] viewContent;
    private Item[][] itemList;
    private Char[] charList;

    private static boolean VERBOSE = true;

    public BasicView() {

    }

    /**
     * Construit une nouvelle fenetre vierge, puis la rempli avec les elements actuels
     * Utilisé une seule fois pour construire la fenetre
     */
    @Override
    public void resetView() {
        //Reseting view
        cleanItemList();
        cleanCharList();
        cleanViewContent();

        // Getting new content
        char[][] walls = Engine.getInstance().getWalls();
        String[][] content = Engine.getInstance().getContent();
        String[] chars = Engine.getInstance().getCharacters();

        Canvas c = Canvas.getCanvas();
        int size = Math.min(Canvas.WIDTH /walls.length, Canvas.HEIGHT /walls[0].length);

        //Setting new contents
        BlockGenerator bg = new BlockGenerator(size,"black","blue");
        viewContent = bg.getBlockArray(walls);

        //Setting new items
        ItemGenerator ig = new ItemGenerator(size);
        itemList = ig.getItemList(content);

        //Setting Characters
        CharGenerator cg = new CharGenerator(size,content);
        charList = cg.getCharArray(chars);

        //Drawing it
        drawViewContent();
        drawItemList();
        drawCharsList();
        Canvas.getCanvas().redraw();

        gameLoop();
    }


    private void gameLoop(){
        Char c;
        for(int i = 0;i<charList.length;i++){
            c = charList[i];
            if(c.getName() == "Pacman"){
                pacmanMove(c);
                isThereContact(c);
            }else{
                ghostMove(c);
            }
        }
    }

    private void pacmanMove(Char c){

    }

    private void ghostMove(Char c){

    }

    private void isThereContact(Char c){

    }




    /**
     * Methode permettant de preparer une nouvelle partie
     */
    @Override
    public void resetGame() {
        resetView();
    }

    private void drawViewContent() {
        for (int i = 0; i < viewContent.length; i++) {
            for (int j = 0; j < viewContent[0].length; j++) {
                viewContent[i][j].draw();
            }
        }
    }

    private void drawItemList(){
        if(itemList != null) {
            for (int i = 0; i < itemList.length;i++) {
                for (int j = 0; j < itemList[0].length;j++) {
                    if(itemList[i][j] != null){
                        itemList[i][j].draw();
                    }
                }
            }
        }
    }

    private void drawCharsList(){
        if(charList != null) {
            for (int i = 0; i < charList.length;i++) {
                trace("Drawing char " + charList[i].getName());
                charList[i].draw();
            }
        }
    }

    private void cleanViewContent(){
        if(viewContent != null){
            for (int i = 0; i < viewContent.length; i++) {
                for (int j = 0; j < viewContent[0].length; j++) {
                    Canvas.getCanvas().erase(viewContent[i][j]);
                }
            }
            viewContent = null;
        }
    }

    private void cleanItemList(){
        if(itemList != null) {
            for (int i = 0; i < itemList.length;i++) {
                for (int j = 0; j < itemList[0].length; j++) {
                    Canvas.getCanvas().erase(itemList[i][j]);
                }
            }
            itemList = null;
        }
    }

    private void cleanCharList(){
        if(charList != null) {
            for (int i = 0; i < charList.length;i++) {
                Canvas.getCanvas().erase(charList[i]);
            }
        }
        charList = null;
    }

    public static void trace(String s){
        if(VERBOSE){
            System.out.println(s);
        }
    }
}
