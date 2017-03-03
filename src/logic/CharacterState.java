package logic;

/**
 * Project pacmanProjectInfo1, CharacterState
 * Created on Fri 3/3/17
 *
 * @author Matthieu Jan - matthieu.jan56@gmail.com
 */
public class CharacterState {

    private final String name;
    private double x;
    private double y;
    private boolean isEdible;

    public CharacterState(String name, double xStart, double yStart,boolean isEdible){
        this.name = name;
        this.x = xStart;
        this.y = yStart;
        this.isEdible = isEdible;
    }

    public String getName(){ return name; }
    public double getX(){ return x; }
    public double getY(){ return y; }
    public boolean isEdible(){return isEdible;}


    public void setX(double x){ this.x = x;}
    public void setY(double y){ this.y = y;}
    public void setEdible(boolean edible){ this.isEdible = edible;}

}
