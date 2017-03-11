package ressources;

/**
 * Project pacmanProjectInfo1, Pair
 * Created on Thu 3/9/17
 *
 * @author Matthieu Jan - matthieu.jan56@gmail.com
 */
public class Pair<L,R> {

    private final L left;
    private final R right;

    public Pair(L left, R right) {
        this.left = left;
        this.right = right;
    }

    public L getX() { return left; }
    public R getY() { return right; }

    @Override
    public int hashCode() { return left.hashCode() ^ right.hashCode(); }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pair)) return false;
        Pair pairo = (Pair) o;
        return this.left.equals(pairo.getX()) &&
                this.right.equals(pairo.getY());
    }

}
