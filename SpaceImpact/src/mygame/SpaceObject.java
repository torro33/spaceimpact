
package mygame;

import java.util.Arrays;

/**
 *
 * @author en
 */
public abstract class SpaceObject {
    protected int x;
    protected int y;
    protected int cellSize;
    protected int model;
    
    private int shipHeight;
    private int shipWidth;
    
     public SpaceObject(int x,int y,int model,int cellSize){
         this.x = x;
         this.y = y;
         this.model = model;
         this.cellSize = cellSize;
         
        this.shipHeight = ShipModels.shipCreep[model][0].length * cellSize;
        this.shipWidth = ShipModels.shipCreep[model].length * cellSize;
     }

    public int getX() {
        return x;
    }

    public int getModel() {
        return model;
    }

    public int getY() {
        return y;
    }

    public int getCellSize() {
        return cellSize;
    }

    public void setCellSize(int cellSize) {
        this.cellSize = cellSize;
    }

    public int getShipHeight() {
        return shipHeight;
    }

    public int getShipWidth() {
        return shipWidth;
    }
    
    public abstract void move();
    
    protected void setShip(int height,int width){
        this.shipHeight = height * cellSize;
        this.shipWidth = width * cellSize;
    }
    
    public boolean isCollision(SpaceObject sp){
        return x  < sp.getX() + sp.getShipWidth() &&
                x + shipWidth > sp.getX() &&
                y < sp.getY() + sp.getShipHeight() &&
                y + shipHeight > sp.getY();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.x;
        hash = 79 * hash + this.y;
        hash = 79 * hash + this.cellSize;
        hash = 79 * hash + this.shipHeight;
        hash = 79 * hash + this.shipWidth;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SpaceObject other = (SpaceObject) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        if (this.cellSize != other.cellSize) {
            return false;
        }
        if (this.shipHeight != other.shipHeight) {
            return false;
        }
        if (this.shipWidth != other.shipWidth) {
            return false;
        }
        return true;
    }

    
    
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    public void moveDown(int shift){
       x += shift; 
    }
    public void moveUp(int shift){
       x -= shift; 
    }
    
     
}
