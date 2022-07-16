package src.main;

import java.util.Scanner;
import java.util.Random;
import java.util.HashMap;

import src.main.assets.*;
import src.main.assets.databases.WeaponDatabase;

public class Game
{
    // game assets
    private static Player player = new Player();
    private static Map map = new Map();
    private static HashMap<String, Weapon> weaponData = new WeaponDatabase().getDatabase();

    private static int moves = 0;
    
    public static void main(String[] args)
    {
        clear();

        welcome();
        enter();

        init();

        System.out.println("[" + player.getPosition()[0] + ", " + player.getPosition()[1] + "] - Pos");

        turn();
    }

    private static void init() // initializes game
    {
        // initialize player
        player.setMap(map); // set the map
        player.setWeapon(weaponData.get("Fists")); // set weapon to fists
        player.setRandomPosition(); // sets a random position in the map

        // initialize map
        map.setPlayer(player);
        map.update(); 
    }

    private static void clear() // clears the console
    {
        for (int i = 0; i < 20; i++)
        {
            System.out.println();
        }
    }

    private static void welcome() // welcomes the player
    {
        System.out.println("WELCOME TO SURVIVE");
        System.out.println("------------------");
        System.out.println();
        System.out.println("Are you ready to play?");
        System.out.println();
        System.out.println("[Y] \t \t [N]");
        System.out.println();
    }

    private static void enter() // asks if the player is ready (Y or N)
    {
        Scanner scan = new Scanner(System.in);

        String response = scan.nextLine();

        if (response.toUpperCase().equals("Y") || response.toUpperCase().equals("YES"))
        {
            return;
        }

        else if (response.toUpperCase().equals("N") || response.toUpperCase().equals("NO"))
        {
            System.exit(0);
            return;
        }

        else
        {
            System.out.println();
            System.out.println("Please enter a valid response.");
            System.out.println();
            enter();
        }
    }

    private static void buttons() // buttons for actions
    {
        clear();
        System.out.print("[ (M)ove ] \t---\t");
        System.out.print("[ (I)tems ] \t---\t");
        System.out.print("[ (S)tats ] \t---\t");
        System.out.println("[ (C)heck Map ]");
        System.out.println();
    }

    private static void turn() // asks the player what action
    {
        Scanner scan = new Scanner(System.in);

        buttons();

        String response = scan.nextLine();

        clear();

        if (response.toUpperCase().equals("M") || response.toUpperCase().equals("MOVE"))
        {
            move();
        }

        else if (response.toUpperCase().equals("I") || response.toUpperCase().equals("ITEMS"))
        {

        }

        else if (response.toUpperCase().equals("S") || response.toUpperCase().equals("STATS"))
        {
            printStats();

            turn();
        }

        else if (response.toUpperCase().equals("C") || response.toUpperCase().equals("CHECK MAP"))
        {
            printMap();

            turn();
        }

        else
        {
            turn();
        }
    }

    private static void move()
    {
        Scanner scan = new Scanner(System.in);

        System.out.println("Where would you like to move?");
        System.out.println();

        String response = scan.nextLine();

        int x = player.getPosition()[0];
        int y = player.getPosition()[1];

        char[][] map_ = map.getMap();

        map.resetSlot(new int[] { x, y }); // reset current player pos on map

        // UP
        if (response.toUpperCase().equals("W"))
        {
            if (x > 0)
            {
                player.setPosition(new int[] { x - 1, y });
            }

            else
            {
                System.out.println("Map Border Reached!");
                System.out.println();

                move();
            }
        }
        
        // DOWN
        else if (response.toUpperCase().equals("S"))
        {
            if (x <= map_.length - 1)
            {
                player.setPosition(new int[] { x + 1, y });
            }

            else
            {
                System.out.println("Map Border Reached!");
                System.out.println();

                move();
            }
        }

        // LEFT
        else if (response.toUpperCase().equals("A"))
        {
            if (y > 0)
            {
                player.setPosition(new int[] { x, y - 1 });
            }

            else
            {
                System.out.println("Map Border Reached!");
                System.out.println();

                move();
            }
        }

        // RIGHT
        else if (response.toUpperCase().equals("D"))
        {
            if (y <= map_.length - 1)
            {
                player.setPosition(new int[] { x, y + 1 });
            }

            else
            {
                System.out.println("Map Border Reached!");
                System.out.println();

                move();
            }
        }

        else
        {
            move();
        }

        map.update();

        turn();

    }

    private static void printStats()
    {
        System.out.println("STATS:");
        System.out.println("------");
        System.out.println();
        System.out.println();

    }

    private static void printMap()
    {
        Scanner scan = new Scanner(System.in);

        System.out.println(map);
        scan.nextLine();
    }
}