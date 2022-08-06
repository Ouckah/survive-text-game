package src.main.assets;

import java.util.Random;

import src.main.assets.databases.*;
import src.main.assets.items.Item;
import src.main.assets.items.Weapon;

public class Map
{
    /*

        KEY:

        _ = blank
        o = event
        + = item
        / = enemy
        x = player

    */
    private Random rand = new Random();
    private char[][] map = new char[10][10];

    private Player player;

    private static WeaponDatabase weaponData = new WeaponDatabase();
    private static EnemyDatabase enemyData = new EnemyDatabase();
    private static UseableDatabase useableData = new UseableDatabase();

    // #region Constructors

    public Map()
    {
        generate();
    }

    // #endregion

    // #region Get Methods

    public char[][] getMap() 
    {
        return map;
    }

    // #endregion

    // #region Set Methods

    public void setPlayer (Player player)
    {
        this.player = player;
    }

    // #endregion

    private void generate()
    {
        for (int x = 0; x < map.length; x++)
        {
            for (int y = 0; y < map[x].length; y++)
            {
                /*

                    CHANCE KEY:
                    
                    70% - Blank
                    15% - Item
                    15% - Enemy

                */
                float chance = rand.nextFloat();

                if (chance <= 0.7)
                {
                    map[x][y] = '_';
                }
                else if (chance <= 0.85)
                {
                    map[x][y] = '+';
                }
                else
                {
                    map[x][y] = '/';
                }
            }
        }
    }

    public void update()
    {
        int x = player.getPosition()[0];
        int y = player.getPosition()[1];

        char currentPosition = map[x][y]; // '_' or '+' or '/'

        if (currentPosition != '_')
        {
            if (currentPosition == '+') // item
            {
                /*
                 * 50% chance of weapon
                 * 50% chance of useable
                 */
                float COIN_FLIP = 0.5f;

                float chance = rand.nextFloat();
                if (chance < COIN_FLIP)
                {
                    Weapon weapon = weaponData.getRandomWeapon();
                    player.addWeapon(weapon);
                }
                else
                {
                    Item useable = useableData.getRandomUseable();
                    player.addUseable(useable);
                }
            }

            else if (currentPosition == '/') // enemy
            {
                // simulate battle
                player.startBattle();

                Enemy enemy = enemyData.spawn(); // spawn enemy

                Weapon weapon = weaponData.getRandomWeapon(); // set enemy weapon
                enemy.setWeapon(weapon);

                enemy.setLevel(1); // set enemy level

                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                System.out.println("You ran into a " + enemy.getName() + "!");
                System.out.println("Info: " + enemy.getName() + " - " + enemy.getDescription() + "\n\n\n");

                player.battle(enemy);
            }
        }

        map[x][y] = 'X';
    }

    public void resetSlot(int[] pos)
    {
        int x = pos[0];
        int y = pos[1];

        map[x][y] = '_';
    }

    public void setSlot(int[] pos, char icon) // pos = [x, y] ; icon = '_' or '+' or '/'
    {
        int x = pos[0];
        int y = pos[1];

        map[x][y] = icon;
    }

    public String toString()
    {
        String str = 
        "MAP: \n-----\n";

        for (int x = 0; x < map.length; x++)
        {
            str += "\n";
            for (int y = 0; y < map[x].length; y++)
            {
                str += map[x][y] + "  ";
            }
        }

        return str;
    }
}