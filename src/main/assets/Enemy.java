package src.main.assets;

import java.util.Scanner;

import src.main.assets.databases.WeaponDatabase;
import src.main.assets.items.Weapon;

public class Enemy 
{
    int id;
    static int instanceCount = 0;

    private String name;
    private String description;

    private int level;
    private int maxHealth;
    private int health;

    private boolean isDead;

    private Weapon weapon;
    
    private WeaponDatabase weaponData = new WeaponDatabase();

    public Enemy (String name, String description)
    {
        // increment IDs
        id = instanceCount;
        instanceCount++;

        this.name = name;
        this.description = description;
    }

    public String getName() 
    {
        return name;
    }

    public String getDescription() 
    {
        return description;
    }

    public int getHealth() 
    {
        return health;
    }

    public int getMaxHealth() 
    {
        return maxHealth;
    }

    public boolean isDead() 
    {
        return isDead;
    }
    
    public void setLevel (int level) 
    {
        this.level = level;

        // TEMP: set health with level
        maxHealth = level * 5;
        health = maxHealth;
    }

    public void setWeapon (Weapon weapon)
    {
        this.weapon = weapon;
    }

    public void turn (Player player)
    {
        Scanner scan = new Scanner(System.in);

        System.out.println("\n\n\n\n\n\n\n\n\n\n");
        System.out.println(name + " hit you for " + weapon.getDamage() + " damage!");
        player.damage(weapon.getDamage());

        scan.nextLine();

        player.battle(this);
    }

    public void kill()
    {
        isDead = true;
    }
    
    public void damage (int damage)
    {
        health -= damage;

        if (health <= 0) // if enemy dies
        {
            kill();   
        }
    }
}
