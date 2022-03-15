
package player;

import mygame.SpaceObject;

/**
 *
 * @author en
 */
public class Player extends SpaceObject{

    public Player(int x, int y,int model,int cellSize) {
        super(x, y,model,cellSize);
    }
    
    public void moveUp(int shift){
        if (y>10) {
           y -= shift; 
        }
    }
    public void moveDown(int shift){
        if (y<525) {
           y += shift; 
        } 
    }

    @Override
    public void move() {
    }
    
}
