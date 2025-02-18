package it.polimi.ingsw.model;

import it.polimi.ingsw.clientmodel.AmmoView;

import java.io.Serializable;

/**
 * This class represents the management of ammunitions that a player already has on his board, and can be used to pay for effects
 */
public class Ammunitions implements Serializable {
    private static final transient int AMMO_NUMBER_LIMIT = 3;

    /**
     * Number of red ammo
     */
    private int red;
    /**
     * Number of blue ammo
     */
    private int blue;
    /**
     * Number of yellow ammo
     */
    private int yellow;

    /**
     * Creation of the class with 1 ammo for every type
     */
    public Ammunitions()
    {
        this.red = 1;
        this.blue = 1;
        this.yellow = 1;
    }

    public Ammunitions(Ammunitions ammo)
    {
        this.red = ammo.red;
        this.blue = ammo.blue;
        this.yellow = ammo.yellow;
    }

    /**
     * Adds i ammunition of c color
     * @param c Color of the ammunition to add
     * @param i Number of ammo to add
     * @return False if the value of i is wrong
     */
    public boolean add(Color c, int i)
    {
        switch(c)
        {
            case RED:
                return addRed(i);
            case BLUE:
                return addBlue(i);
            case YELLOW:
                return addYellow(i);
            default:
                return false;
        }
    }

    /**
     * Adds red ammunition
     * @param i Number of ammo to add
     * @return False if the value of i is wrong
     */
    protected boolean addRed(int i)
    {
        if(i>=0 && i<= AMMO_NUMBER_LIMIT)
        {
            red = red + i;
            if (red > AMMO_NUMBER_LIMIT)
                red = AMMO_NUMBER_LIMIT;

            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Adds blue ammunition
     * @param i Number of ammo to add
     * @return False if the value of i is wrong
     */
    protected boolean addBlue(int i)
    {
        if(i>=0 && i<= AMMO_NUMBER_LIMIT)
        {
            blue = blue + i;
            if (blue > AMMO_NUMBER_LIMIT)
                blue = AMMO_NUMBER_LIMIT;

            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Adds yellow ammunition
     * @param i Number of ammo to add
     * @return False if the value of i is wrong
     */
    protected boolean addYellow(int i)
    {
        if(i>=0 && i<= AMMO_NUMBER_LIMIT)
        {
            yellow = yellow + i;
            if (yellow > AMMO_NUMBER_LIMIT)
                yellow = AMMO_NUMBER_LIMIT;

            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Uses red ammunition
     * @param i Number of ammo to be used
     * @return False if the value of i is more than the user currently has or is negative
     */
    public boolean useRed(int i)
    {
        if(i>=0 && i <= red)
        {
            red -= i;
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Uses blue ammunition
     * @param i Number of ammo to be used
     * @return False if the value of i is more than the user currently has or is negative
     */
    public boolean useBlue(int i)
    {
        if(i>=0 && i <= blue)
        {
            blue -= i;
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Uses yellow ammunition
     * @param i Number of ammo to be used
     * @return False if the value of i is more than the user currently has or is negative
     */
    public boolean useYellow(int i)
    {
        if(i>=0 && i <= yellow)
        {
            yellow -= i;
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     *
     * @return Number of red ammo
     */
    public int getRed()
    {
        return red;
    }

    /**
     *
     * @return Number of red ammo
     */
    public int getBlue()
    {
        return blue;
    }

    /**
     *
     * @return Number of red ammo
     */
    public int getYellow()
    {
        return yellow;
    }

    public AmmoView getView()
    {
        return new AmmoView(getRed(), getBlue(), getYellow());
    }
}
