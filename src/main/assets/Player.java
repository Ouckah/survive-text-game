package src.main.assets;

import java.util.Random;

public class Player 
{
    private int[] pos = new int[2]; // [x, y]

    private int maxHealth;
    private int health;
    private Weapon weapon;

    private Map map;

    // #region Constructors

    public Player()
    {
        pos = new int[] { 0, 0 };

        maxHealth = 10;
        health = 10;

        weapon = null;

        map = null;
    }

    // #endregion

    // #region Get Methods

    public int[] getPosition()
    {
        return pos;
    }

    // #endregion

    // #region Set Methods

    public void setWeapon (Weapon weapon)
    {
        this.weapon = weapon;
    }

    public void setPosition (int[] pos)
    {
        this.pos = pos;
    }

    public void setRandomPosition()
    {
        Random rand = new Random();

        int x = rand.nextInt(map.getMap().length);
        int y = rand.nextInt(map.getMap()[0].length);  
        
        if (map.getMap()[x][y] != '_') // if map spot selected is not blank
        {
            setRandomPosition();
        }

        else
        {
            pos = new int[] { x, y };
        }
    }

    public void setMap (Map map)
    {
        this.map = map;
    }

    // #endregion
}
