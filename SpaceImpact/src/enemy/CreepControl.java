
package enemy;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import mygame.SpaceImpact;
import mygame.SpaceObject;

/**
 *
 * @author en
 */
public class CreepControl {
    
    private List<SpaceObject> creepList;
    
    private Random random;
    int timeToSpawn = 0;
    int gyorsito = 0;
    
    public CreepControl( List <SpaceObject> creepList,Random random){
        this.creepList = creepList;
        this.random = random;
    }
    
    public void updateCreeps(){

        if(SpaceImpact.score <= 10){//50 után gyorsabban jönnek a hajók
            gyorsito = 1;
        }else if(SpaceImpact.score > 10){
            gyorsito = 2;
        }
        
        if (timeToSpawn <= 0) {
            Creep creep = new Creep( SpaceImpact.WIDTH, 0, 0, gyorsito, 3);
            if (creepList.isEmpty()) {
               creep.setY(random.nextInt(SpaceImpact.HEIGHT - creep.getShipHeight()));
            }else{
                boolean collids;
                do{
                    collids = false;
                    creep.setY(random.nextInt(SpaceImpact.HEIGHT - creep.getShipHeight()));
                    for (SpaceObject sp : creepList){
                        if (creep.isCollision(sp)) {
                             collids = true;
                             break;
                        }     
                    }   
                } while(collids);  
            }
            timeToSpawn = random.nextInt(150) + 50;
            creepList.add(creep);
        }
        timeToSpawn--;
    }
    
    public boolean update(){   
        for (int i = 0; i < creepList.size(); i++) {

            if (creepList.get(i).getX() <= 0) {
                return false;
            }else{
                creepList.get(i).move();
            }
        }
        return true;
    }
}
