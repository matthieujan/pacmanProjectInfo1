package view;

import main.*;
import ressources.Canvas;
import ressources.Event;
import ressources.Pair;

/**
 * Project pacmanProjectInfo1, BasicView
 * Created on Sat 3/11/17
 *
 * @author Matthieu Jan - matthieu.jan56@gmail.com
 */
public class View implements ViewInterface {

    private Block[][] viewContent;
    private Item[][] itemList;
    private Char[] charList;


    private int pacmanSpeed;
    private int ghostSpeed;
    private int size;

    private int score;


    private static boolean VERBOSE = true;


    public View() {
        this.setSpeeds(10,10);
    }

    public void setSpeeds(int pacmanSpeed, int ghostSpeed){
        this.pacmanSpeed = pacmanSpeed;
        this.ghostSpeed = ghostSpeed;
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
    }

    /**
     * Recupere les objets necessaires a la création de la fenetre
     * Instancie les objets de la vues
     * Dessine et lance le deroulement de la partie
     */
    public void startView(){
        // Getting new content
        char[][] walls = Engine.getInstance().getWalls();
        String[][] content = Engine.getInstance().getContent();
        String[] chars = Engine.getInstance().getCharacters();

        Canvas c = Canvas.getCanvas();
        size = 48;

        //Setting new contents
        BlockGenerator bg = new BlockGenerator(size,"black","blue");
        viewContent = bg.getBlockArray(walls);

        //Setting new items
        ItemGenerator ig = new ItemGenerator(size);
        itemList = ig.getItemList(content);

        //Setting Characters
        CharGenerator cg = new CharGenerator(size,content);
        charList = cg.getCharArray(chars);

        int speed = 2;

        this.setSpeeds(speed,speed);
        //Drawing it
        drawViewContent();
        drawCharsList();
        drawItemList();
        c.redraw();

        while(!Engine.getInstance().endGame()){
            gameLoop();
            c.redraw();
        }
    }

    /**
     * Modelise une iteration de la partie : un mouvemeent par personnage
     */
    private void gameLoop(){
        Char c;
        MoveManager mo = new MoveManager(viewContent,itemList,charList,pacmanSpeed,ghostSpeed,size);

        for(int i = 0;i<charList.length;i++){
            c = charList[i];
            if(c.getName() == "Pacman"){
                mo.pacmanMove(c);
                mo.isThereContact(c);
            }else{
                mo.ghostMove(c);
            }
        }
        didTheyGetHim();
    }
    /**
     * Methode qui verifie si il y a contact
     * Si oui, effectue la demande d'evenement et applique l'evenement
     */
    public void didTheyGetHim(){
        int x = charList[0].getX();
        int y = charList[0].getY();
        int gx,gy;
        Char g;
        for(int i = 1;i<charList.length;i++){
            g = charList[i];
            gx = Math.abs(g.getX()- x);
            gy = Math.abs(g.getY() -y );
            if(gx<size/2 && gy<size/2){
                eventDie(charList[0]);
            }
        }

    }

    private void eventDie(Char c) {
        c.erase();
        int x = 0;
        while (charList[x].getName() != c.getName()) {
            x++;
        }
        CharGenerator cg = new CharGenerator(size, Engine.getInstance().getContent());
        charList[x] = cg.getPacman();
        charList[x].draw();
    }
    /**
     * Methode permettant de preparer une nouvelle partie
     */
    @Override
    public void resetGame() {
        score = 0;
        resetView();
    }

    /**
     * Methode qui dessine les murs et couloirs
     */
    private void drawViewContent() {
        for (int i = 0; i < viewContent.length; i++) {
            for (int j = 0; j < viewContent[0].length; j++) {
                viewContent[i][j].draw();
            }
        }
    }

    /**
     * Methode qui dessine les items
     */
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

    /**
     * Methode qui dessine les personnages
     */
    private void drawCharsList(){
        if(charList != null) {
            for (int i = 0; i < charList.length;i++) {
                charList[i].draw();
            }
        }
    }

    /**
     * Methode qui reinit la partie mur et couloir de la view
     */
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

    /**
     * Methode qui reinit la partie contenu de la view
     */
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

    /**
     * Methode qui reinit les personnages de la view
     */
    private void cleanCharList(){
        if(charList != null) {
            for (int i = 0; i < charList.length;i++) {
                Canvas.getCanvas().erase(charList[i]);
            }
        }
        charList = null;
    }
}
