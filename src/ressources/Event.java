package ressources;

/**
 * Decrit les differents evenements pouvant être traité
 * Project pacmanProjectInfo1, Event
 * Created on Thu 3/9/17
 *
 * @author Matthieu Jan - matthieu.jan56@gmail.com
 */
public enum Event {
    DIE("DIE"),
    EAT("EAT");

    String name;

    Event(String name){
        this.name = name;
    }

    public String toString(){
        return this.name;
    }

}
