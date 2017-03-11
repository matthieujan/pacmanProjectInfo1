package ressources;

/**
 * Project pacmanProjectInfo1, Pair
 * Created on Thu 3/9/17
 *
 * @author Matthieu Jan - matthieu.jan56@gmail.com
 */
public class Pair<L,R> {

    public final L x;
    public final R y;

    public Pair(L x, R y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() { return x.hashCode() ^ y.hashCode(); }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pair)) return false;
        Pair pairo = (Pair) o;
        return this.x.equals(pairo.x) &&
                this.y.equals(pairo.y);
    }

}
