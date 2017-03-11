package ressources;

/**
 * Project pacmanProjectInfo1, Content
 * Created on Sat 3/11/17
 *
 * @author Matthieu Jan - matthieu.jan56@gmail.com
 */
public enum Content {
    GOMME("GOMME"),
    PACSPAWN("PACSPAWN"),
    GHOSTSPAWN("GHOSTSPAWN");

    String name;

    Content(String name){
        this.name = name;
    }

    public String toString(){
        return this.name;
    }
}
