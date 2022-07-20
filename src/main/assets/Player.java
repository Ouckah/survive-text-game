package src.main.assets;

import java.util.Random;
import java.util.HashMap;

import src.main.assets.databases.WeaponDatabase;
import src.main.assets.items.Weapon;

public class Player 
{
    private int[] pos = new int[2]; // [x, y]

    private int moveCount;

    private int maxHealth;
    private int health;
    private Weapon weapon;
    private Inventory inventory = new Inventory();

    public static WeaponDatabase weaponData = new WeaponDatabase();

    private Map map;

    // #region Constructors

    public Player()
    {
        pos = new int[] { 0, 0 };

        moveCount = 0;

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

    public int getMoveCount()
    {
        return moveCount;
    }

    public int getMaxHealth()
    {
        return maxHealth;
    }

    public int getHealth()
    {
        return health;
    }

    public Weapon getWeapon()
    {
        return weapon;
    }

    public Inventory getInventory()
    {
        return inventory;
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

    public void addMove()
    {
        moveCount++;
    }

    // random weapon
    public void addWeapon()
    {
        Weapon weapon = weaponData.getWeapon();
        inventory.add(weapon);
    }
}
