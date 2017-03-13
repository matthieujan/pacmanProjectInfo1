package view;

import main.Engine;
import ressources.Canvas;
import ressources.Event;
import ressources.Pair;

/**
 * Project pacmanProjectInfo1, MoveManager
 * Created on Mon 3/13/17
 *
 * @author Matthieu Jan - matthieu.jan56@gmail.com
 */
public class MoveManager {
    private int size;
    private int xLength;
    private int yLength;

    private int pacSpeed;
    private int ghostSpeed;

    private Block[][] viewContent;
    private Item[][] itemList;
    private Char[] charList;

    public MoveManager(Block[][] viewContent, Item[][] itemList,Char[] charList,int pacSpeed, int ghostSpeed){
        this.viewContent=viewContent;
        this.itemList = itemList;
        this.charList = charList;
        this.pacSpeed = pacSpeed;
        this.ghostSpeed = ghostSpeed;
        size = Math.min(Canvas.WIDTH /viewContent.length, Canvas.HEIGHT /viewContent[0].length);
        xLength = size*viewContent.length;
        yLength = size*viewContent[0].length;
    }


    public void pacmanMove(Char c){
        Canvas can = Canvas.getCanvas();
        if(can.isUpPressed()){
            c.setNewDirection("UP");
        }else if(can.isDownPressed()){
            c.setNewDirection("DOWN");
        }else if(can.isLeftPressed()){
            c.setNewDirection("LEFT");
        }else if(can.isRightPressed()){
            c.setNewDirection("RIGHT");
        }

        if(c.getOldDir() == null){
            c.setOldDirection(c.getNewDir());
        }

        Pair<Float,Float> pos;
        float x = ((float)c.getX())/size;
        float y = ((float)c.getY())/size;
        pos = new Pair<>(x,y);

        if(c.getNewDir() != null && Engine.getInstance().isValidMove(c.name,pos,c.getNewDir())){
            c.setOldDirection(c.getNewDir());
            c.setNewDirection(null);
        }
        if(Engine.getInstance().isValidMove(c.name,pos,c.getOldDir())) {
            Pair<Integer, Integer> mv = new Pair<>(0, 0);

            if (c.getOldDir() != null) {
                switch (c.getOldDir()) {
                    case "UP":
                        mv = new Pair<>(0, -pacSpeed);
                        break;
                    case "DOWN":
                        mv = new Pair<>(0, pacSpeed);
                        break;
                    case "RIGHT":
                        mv = new Pair<>(pacSpeed, 0);
                        break;
                    case "LEFT":
                        mv = new Pair<>(-pacSpeed, 0);
                        break;
                }
            }
            c.move(mv.x,mv.y);
            if(c.getX()>(xLength-(size/2))){
                mv = new Pair<>(-xLength, 0);
            }else if (c.getX()<-size/2){
                mv = new Pair<>(xLength, 0);
            }else if (c.getY()<-size/2){
                mv = new Pair<>(0, yLength);
            }else if (c.getY()>(yLength-(size/2))){
                mv = new Pair<>(0, -yLength);
            }
            c.move(mv.x,mv.y);
        }
    }

    public void ghostMove(Char c) {
        //getAMoveInfo
        String od = c.getOldDir();
        Pair<Float,Float> p = new Pair<>(((float)c.getX())/size,((float)c.getY())/size);
        if (c.getOldDir() == null) {
           c.setOldDirection(Engine.getInstance().getAMove(od, c.getName(), p));
        } else if(Math.random()>0.9){
            c.setNewDirection(Engine.getInstance().getAMove(od, c.getName(), p));
        }

        Pair<Float, Float> pos;
        float x = ((float) c.getX()) / size;
        float y = ((float) c.getY()) / size;
        pos = new Pair<>(x, y);

        if (c.getNewDir() != null && Engine.getInstance().isValidMove(c.name, pos, c.getNewDir())) {
            c.setOldDirection(c.getNewDir());
            c.setNewDirection(null);
        }
        if (Engine.getInstance().isValidMove(c.name, pos, c.getOldDir())) {
            Pair<Integer, Integer> mv = new Pair<>(0, 0);

            if (c.getOldDir() != null) {
                switch (c.getOldDir()) {
                    case "UP":
                        mv = new Pair<>(0, -ghostSpeed);
                        break;
                    case "DOWN":
                        mv = new Pair<>(0, ghostSpeed);
                        break;
                    case "RIGHT":
                        mv = new Pair<>(ghostSpeed, 0);
                        break;
                    case "LEFT":
                        mv = new Pair<>(-ghostSpeed, 0);
                        break;
                }
            }
            c.move(mv.x, mv.y);
            if (c.getX() > (viewContent.length * size - (size / 2))) {
                mv = new Pair<>(-viewContent.length * size, 0);
            } else if (c.getX() < -size / 2) {
                mv = new Pair<>(viewContent.length * size, 0);
            } else if (c.getY() < -size / 2) {
                mv = new Pair<>(0, viewContent[0].length * size);
            } else if (c.getY() > (viewContent[0].length * size - (size / 2))) {
                mv = new Pair<>(0, -viewContent[0].length * size);
            }
            c.move(mv.x, mv.y);
        }else{
           c.setOldDirection(null);
           ghostMove(c);
        }
    }

    public void isThereContact(Char c){
        int x = c.getX()/size;
        int y = c.getY()/size;

        if(itemList[x][y] != null){
            Event e = Engine.getInstance().whatHappen(c.getName(),itemList[x][y].getName()+"Item");
            switch (e){
                case EAT:
                    Engine.getInstance().setContent(new Pair(x,y), null);
                    Canvas.getCanvas().erase(itemList[x][y]);
                    itemList[x][y] = null;
                    break;
                default :
                    break;
            }

        }

    }
}
