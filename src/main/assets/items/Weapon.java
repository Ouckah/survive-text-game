package src.main.assets.items;

public class Weapon extends Item 
{
    private int damage;
    private int turnSpawn; // turn number that weapon will spawn as an item

    // #region Constructors

    public Weapon(String name, String description, int damage, float chance, int turnSpawn) 
    {
        // increment IDs
        id = instanceCount;
        instanceCount++;

        this.name = name;
        this.description = description;
        this.damage = damage;
        this.chance = chance;
        this.turnSpawn = turnSpawn;
    }

    // #endregion

    // #region Get Methods

    public int getDamage()
    {
        return damage;
    }
    
    // #endregion

    // #region Set Methods
    
    // #endregion

    public String toString()
    {
        return name + "\n\n" + 
        description + "\n\n" + 
        "Deals " + damage + " damage."+ "\n\n";
    }
}