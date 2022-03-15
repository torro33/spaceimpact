
package graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JComponent;
import java.awt.Image;
import java.awt.Toolkit;
import mygame.ShipModels;
import mygame.SpaceImpact;
import mygame.SpaceObject;

/**
 *
 * @author Mef
 */
public class Canvas extends JComponent{
    private List<SpaceObject> playerObjects;
    private List<SpaceObject> shellObjects;
    private List<SpaceObject> enemyObjects;
    private String szoveg;

    Image contactBottom;	                  

    Image img = Toolkit.getDefaultToolkit().createImage("test2.jpg");

    private final static Color NON_OBJECT_COLOR = Color.black;
    private final static Color PLAYER_COLOR = Color.green;
    private final static Color ENEMY_COLOR = Color.red;
    private final static Color SHELL_COLOR = Color.yellow;

    public Canvas(List<SpaceObject> playerObjects, List<SpaceObject> shellObjects, List<SpaceObject> enemyObjects, int score) {
        this.playerObjects = playerObjects;
        this.shellObjects = shellObjects;
        this.enemyObjects = enemyObjects;
        this.szoveg="Talalat: "+score+" !";
    }

    public Canvas(){
        playerObjects = new LinkedList<>();
    }

    public void paintBackGround(Graphics g){
    g.drawImage(img, 0, 0, null);
    }
    
    public void paintScore(Graphics g,String szoveg, int x,int y){
    g.setColor(Color.YELLOW);
    int fontSize = 20;
        Font f = new Font("Comic Sans MS", Font.BOLD, fontSize);
        g.setFont(f);
        g.drawString(szoveg, x, y);
    }
    
    public void paintObjects( List<SpaceObject> list, Color color, Graphics g ){
        
        for(SpaceObject sp : list){
            byte[][] ship = ShipModels.shipCreep[sp.getModel()];
            for (int i = 0; i < ship.length; i++) {
                for (int j = 0; j < ship[0].length; j++) {
                    if (ship[i][j] == 1) {
                        g.setColor(color);//felveszi a háttér színt
                        g.fillRect(i * sp.getCellSize() + sp.getX(), j * sp.getCellSize() + sp.getY(), sp.getCellSize(), sp.getCellSize());
                    }
                }
            }
        }
    }
    
      
    @Override
    public void paint(Graphics g){
        g.drawImage(img, 0, 0, null);
        g.setColor(NON_OBJECT_COLOR);
        g.fillRect(0, 0, SpaceImpact.WIDTH, SpaceImpact.HEIGHT);
        paintBackGround(g);
        paintScore(g,szoveg,200,20);
        paintObjects(playerObjects,PLAYER_COLOR,g);
        paintObjects(shellObjects,SHELL_COLOR,g);
        paintObjects(enemyObjects,ENEMY_COLOR,g);
    }

    /**
     * @param szoveg the szoveg to set
     */
    public void setSzoveg(int score) {
        this.szoveg = "Talalat: "+String.valueOf(score);

    }

}

