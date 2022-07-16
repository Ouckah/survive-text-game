package src.main.assets;

import java.util.Random;

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

    private Player player; // [x, y]

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

            }

            else if (currentPosition == '/') // enemy
            {

            }
        }

        map[x][y] = 'X';
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