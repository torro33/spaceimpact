
package enemy;

import mygame.ShipModels;
import mygame.SpaceObject;

/**
 *
 * @author en
 */
public class Creep extends SpaceObject{

    private int speed;

    public Creep(int x, int y,int model,int speed,int cellSize) {
        super(x, y,model,cellSize);
        this.speed = speed;
    }
    
    @Override
    public void move(){
        x -= speed;
    }
}
