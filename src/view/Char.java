package view;

import ressources.Circle;

/**
 * Project pacmanProjectInfo1, Char
 * Created on Sun 3/12/17
 *
 * @author Matthieu Jan - matthieu.jan56@gmail.com
 */
public class Char extends Circle {

    String name;
    String oldDir;
    String newDir;

    Char(String name,int size,int x,int y,String color){
        super(size,x,y,color);
        this.name = name;
        oldDir = null;
        newDir = null;
    }

    public String getOldDir(){
        return oldDir;
    }

    public String getNewDir(){
        return newDir;
    }
    @Override
    protected void draw() {
        super.draw();
    }

    public String getName(){
        return name;
    }
}
