package ressources;

/**
 *
 * Decrit les différents buff utilisables par le logiciel
 * Project pacmanProjectInfo1, Buff
 * Created on Thu 3/9/17
 *
 * @author Matthieu Jan - matthieu.jan56@gmail.com
 */
public enum Buff {

    EATABLE("EATABLE");

    String name;

    Buff(String name){
        this.name = name;
    }

    public String toString(){
        return this.name;
    }

}
