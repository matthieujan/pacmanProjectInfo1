package ressources;

import controller.ControllerInterface;
import data.DataInterface;
import view.ViewInterface;

/**
 * Project pacmanProjectInfo1, Pair
 * Created on Thu 3/9/17
 *
 * @author Matthieu Jan - matthieu.jan56@gmail.com
 */
public class GameHandlers{

    private final DataInterface mod;
    private final ViewInterface view;
    private final ControllerInterface ctr;

    public GameHandlers(DataInterface mod, ViewInterface view, ControllerInterface ctr) {
        this.mod = mod;
        this.view = view;
        this.ctr = ctr;
    }

    public DataInterface getModel() { return mod; }
    public ViewInterface getView() { return view; }
    public ControllerInterface getCtr() { return ctr; }
}
