package src.main.assets;

public class Weapon 
{
    private int id;
    static int instanceCount = 0;

    private String name;
    private String description;
    private int damage;
    private float chance; // out of 100
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
    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }

    public int getDamage()
    {
        return damage;
    }
    // #endregion

    // #region Set Methods
    
    // #endregion
}