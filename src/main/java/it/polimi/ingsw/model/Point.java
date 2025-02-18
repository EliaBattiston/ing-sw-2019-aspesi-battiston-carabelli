package it.polimi.ingsw.model;

import it.polimi.ingsw.exceptions.WrongPointException;

import java.io.Serializable;

/**
 * Coordinates of a Player in the Map. Because of its use X values have to be between 0 and 2, Y values between 0 and 3
 */
public class Point implements Serializable {
    private static final transient int MAP_WIDTH = 4;
    private static final transient int MAP_HEIGHT = 3;

    /**
     * X coordinate
     */
    private int x;
    /**
     * Y coordinate
     */
    private int y;

    /**
     * Creates a new point
     * @param x Has to be between 0 and 2
     * @param y Has to be between 0 and 3
     */
    public Point(int x, int y)
    {
        set(x, y);
    }

    public Point(Point x)
    {
        set(x.getX(), x.getY());
    }

    /**
     * Sets the two coordinates
     * @param x X coordinate
     * @param y Y coordinate
     */
    public void set(int x, int y)
    {
        if(x>=0 && x < MAP_WIDTH && y>=0 && y < MAP_HEIGHT)
        {
            this.x = x;
            this.y = y;
        }
        else
        {
            throw new WrongPointException();
        }
    }
    /**
     * Sets the two coordinates
     * @param x the point what contains the same coordinates
     */
    public void set(Point x){
        set(x.getX(), x.getY());
    }

    /**
     *
     * @return X coordinate
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @return Y coordinate
     */
    public int getY() {
        return y;
    }

    public boolean samePoint(Point x)
    {
        return x.getX() == this.getX() && x.getY() == this.getY();
    }
}
