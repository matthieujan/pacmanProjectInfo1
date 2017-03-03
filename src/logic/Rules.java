package logic;

/**
 * Project pacmanProjectInfo1, Rules
 * Created on Thu 2/23/17
 *
 * @author Matthieu Jan - matthieu.jan56@gmail.com
 *
 * La classe Rules modelise les regles de déplacement des personnages.
 */
public abstract class Rules {

    CharacterState charState;

    /**
     * Constructeur de la classe Rules
     * @param charState un objet CharacterState conservant l'emplacement de l'objet.
     */
    public Rules (CharacterState charState){
        this.charState = charState;
    }

    /**
     * Cette méthode renvoie vrai si une direction est valide pour un mouvement donné.
     * Elle renvoie faux si un changement de direction s'effectue (hors de coordonéees "entières")
     * Elle renvoie faux si la prochaine case est un mur
     * Si la méthode renvoie vrai, elle actualise
     * @param newX la nouvelle position en x
     * @param newY la nouvelle mposition en y
     * @param map l'état actuelle de la map
     * @return
     */
    //TODO Clean it up !!
    public boolean isValideMove(double newX, double newY, Map map){
        boolean valid = true;

        double x = charState.getX();
        double y = charState.getY();

        int ix = (int) charState.getX();
        int iy = (int) charState.getY();

        String dir;
        if(newX - x > 0){
            dir = "right";
        } else if( newX - x < 0){
            dir = "left";
        } else if (newY - y > 0){
            dir = "down";
        } else {
            dir = "up";
        }

        switch(dir){
            case "left" :
                if(x == ix && iy == y){
                    if(map.get(ix-1,iy) == "C"){
                        valid = false;
                    }
                } else if(iy != y){
                    valid = false;
                }
                break;
            case "right" :
                if(x == ix && iy == y){
                    if(map.get(ix+1,iy) == "C"){
                        valid = false;
                    }
                } else if(iy != y){
                    valid = false;
                }
                break;
             case "up" :
                if(x == ix && iy == y){
                    if(map.get(ix,iy-1) == "C"){
                        valid = false;
                    }
                } else if(ix != x){
                    valid = false;
                }
                break;
             case "down" :
               if(x == ix && iy == y){
                    if(map.get(ix,iy+1) == "C"){
                        valid = false;
                    }
                } else if(ix != x){
                    valid = false;
                }
                break;
        }
        return valid;
    }

    /**
     * Si un personnage se retrouve bloqué, il peut demander une nouvelle direction.
     * Les fantomes obtiennent une direction plus ou moins aléatoire suivant leur configuration.
     * Pacman les instructions clavier.
     * @return
     */
    public abstract String getDirection();

}
