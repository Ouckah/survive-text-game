package src.main.assets.items;

public class Potion extends Item
{
    private String effects;
    // #region Constructors

    public Potion (String name, String description, String effects)
    {
        this.name = name;
        this.description = description;
        this.effects = effects;
    }

    // #endregion

    // #region Get Methods

    public String getEffects() 
    {
        return effects;
    }

    // #endregion

    // #region Set Methods

        

    // #endregion

    public String toString()
    {
        return name + "\n\n" + 
        description + "\n\n" + 
        effects + "\n\n";
    }
}
