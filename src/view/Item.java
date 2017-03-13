package view;

import ressources.Circle;

/**
 * Project pacmanProjectInfo1, Item
 * Created on Sun 3/12/17
 *
 * @author Matthieu Jan - matthieu.jan56@gmail.com
 */
public class Item extends Circle {

    private String name;

    Item(String name,int size, int x, int y , String color){
        super(size, x, y, color);
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void draw(){
        super.draw();
    }

}
