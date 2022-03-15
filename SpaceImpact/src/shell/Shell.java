
package shell;

import mygame.SpaceObject;

/**
 *
 * @author en
 */
public class Shell extends SpaceObject{
    private int speed;

    public Shell(int speed, int x, int y, int model, int cellSize) {
        super(x, y, model, cellSize);
        this.speed = speed;
    }

    @Override
    public void move() {
        x += speed;
    }
    
}
