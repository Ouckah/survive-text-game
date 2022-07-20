package src.main.assets.items;

public abstract class Item 
{
    int id;
    static int instanceCount = 0;

    String name;
    String description;
    float chance; // out of 100

    // #region Get Methods

    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }

    public float getChance()
    {
        return chance;
    }

    // #endregion
}
