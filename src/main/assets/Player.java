package src.main.assets;

import java.util.Random;
import java.util.Scanner;

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

    private boolean isDead = false;
    private boolean isBattling = false;

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

        // initialize inventory + weapon
        inventory.add(weaponData.getWeapon("Fists"));
        setWeapon((Weapon)inventory.get(0));
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

    public boolean isDead() 
    {
        return isDead;
    }

    public boolean isBattling() 
    {
        return isBattling;
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

    public void kill()
    {
        isDead = true;
    }

    public void startBattle()
    {
        isBattling = true;
    }

    public void endBattle()
    {
        isBattling = false;
    }

    // #endregion

    public void addMove()
    {
        moveCount++;
    }

    // random weapon
    public void addWeapon(Weapon weapon)
    {
        Scanner scan = new Scanner(System.in);
        
        System.out.println();
        System.out.println("You picked up a " + weapon.getName() + "!");
        System.out.println("Info: " + weapon.getName() + " - " + weapon.getDescription());

        // possibility: ask whether player wants to keep it or not
        scan.nextLine();

        inventory.add(weapon);
    }

    public void damage(int damage)
    {
        health -= damage;
    }

    // #region Battle Functions

    public void battle(Enemy enemy)
    {
        Scanner scan = new Scanner(System.in);

        if (isBattling)
        {
            if (!isDead && !enemy.isDead())
            {
                battleButtons();

                // #region print health

                System.out.println("\nHealth: " + health + " / " + maxHealth);
                System.out.print("[ ");

                int healthBar = (int) Math.ceil(((float) health / maxHealth * 40));

                for (int i = 0; i < healthBar; i++)
                {
                    System.out.print("\\\\");
                }
                for (int i = 0; i < 40 - healthBar; i++)
                {
                    System.out.print("  ");
                }

                System.out.println(" ]");

                System.out.println("\n" + enemy.getName() + " health: " + enemy.getHealth() + " / " + enemy.getMaxHealth());
                System.out.print("[ ");

                int enemyHealthBar = (int) Math.ceil(((float) enemy.getHealth() / enemy.getMaxHealth() * 40));

                for (int i = 0; i < enemyHealthBar; i++)
                {
                    System.out.print("\\\\");
                }
                for (int i = 0; i < 40 - enemyHealthBar; i++)
                {
                    System.out.print("  ");
                }

                System.out.println(" ]");

                // #endregion

                String response = scan.nextLine();
        
                if (response.toUpperCase().equals("A") || response.toUpperCase().equals("ATTACK"))
                {
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("You attacked the " + enemy.getName() + " for " + weapon.getDamage() + " damage.");

                    enemy.damage(weapon.getDamage());
                    // possibility: stun effect, poison, etc.
                    // possibility: missing

                    scan.nextLine();
                    
                    if (!enemy.isDead()) // check if enemy died to attack
                    {
                        enemy.turn(this);
                    }
                }
                else if (response.toUpperCase().equals("U") || response.toUpperCase().equals("USE ITEM"))
                {
        
                }
                else if (response.toUpperCase().equals("F") || response.toUpperCase().equals("FLEE"))
                {
                    /*
                    * 60% chance of fleeing
                    * 40% chance of unsuccessfully fleeing
                    */

                    // possibility: unable to flee from certain enemies
                    Random rand = new Random();
                    float FLEE_CHANCE = 0.6f;

                    float chance = rand.nextFloat();
                    if (chance < FLEE_CHANCE)
                    {
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
                        System.out.println("You successfully fled from the " + enemy.getName() + "!");
                        
                        scan.nextLine();
            
                        endBattle();
                    }
                    else
                    {
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
                        System.out.println("The " + enemy.getName() + " stopped you from fleeing!");

                        scan.nextLine();

                        enemy.turn(this);
                    }
                }

                battle(enemy);
            }

            if (isDead)
            {
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
                System.out.println("You Died!");

                scan.nextLine();

                endBattle();
            }

            if (enemy.isDead())
            {
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
                System.out.println("You defeated the " + enemy.getName() + "!");

                scan.nextLine();

                endBattle();
            }
        }
    }

    private static void battleButtons() // buttons for inventory
    {
        System.out.print("[ (A)ttack ] \t---\t");
        System.out.print("[ (U)se Item ] \t---\t");
        System.out.print("[ (F)lee ]");
        System.out.println();
    }


    // #endregion
}
