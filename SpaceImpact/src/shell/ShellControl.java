
package shell;

import enemy.Creep;
import java.util.List;
import java.util.Random;
import mygame.SpaceImpact;
import mygame.SpaceObject;
import player.Player;

/**
 *
 * @author en
 */
public class ShellControl {
    
    private List<SpaceObject> shellList;
    
    private Player player;
    
    public ShellControl( List <SpaceObject> creepList,Player player){
        this.shellList = creepList;
        this.player = player;
        
    }
    
    public void addShell(){
        Shell shell = new Shell(3,player.getX() + player.getShipWidth(),0,2,3);
        shell.setY((player.getY() + player.getShipHeight() / 2) - shell.getShipHeight() / 2);
        shellList.add(shell);
    }
    
    public void update(){    
        for (int i = 0; i < shellList.size(); i++) {
            if (shellList.get(i).getX() > SpaceImpact.WIDTH) {
                shellList.remove(i);
            }else{
                shellList.get(i).move();
            }
        }
    }
}
