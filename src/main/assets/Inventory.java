package src.main.assets;

import java.util.ArrayList;

import src.main.assets.items.Item;

public class Inventory 
{
    private ArrayList<Item> inventory;

    // #region Constructors

    public Inventory()
    {
        inventory = new ArrayList<Item>();
    }

    // #endregion

    // #region Get Methods

    public ArrayList<Item> getInventory()
    {
        return inventory;
    }

    // #endregion

    // #region Set Methods

        

    // #endregion

    public void add (Item item)
    {
        inventory.add(item);
    }

    public String toString()
    {
        inventory.forEach
        (
            (item) -> System.out.println(item)
        );

        return "";
    }
}
