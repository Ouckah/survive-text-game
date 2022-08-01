package src.main.assets;

import java.util.ArrayList;

import src.main.assets.items.Item;

public class Inventory 
{
    private ArrayList<Item> inventory;
    private int space;

    // #region Constructors

    public Inventory()
    {
        inventory = new ArrayList<Item>();
        space = 5;
    }

    // #endregion

    // #region Get Methods

    public ArrayList<Item> getInventory()
    {
        return inventory;
    }

    public int getSpace()
    {
        return space;
    }

    // #endregion

    // #region Set Methods

    public void setSpace (int space)
    {
        this.space = space;
    }

    // #endregion

    public void add (Item item)
    {
        inventory.add(item);
    }

    public String toString()
    {
        System.out.println(inventory.size() + " / " + space + "\n");
        inventory.forEach
        (
            (item) -> System.out.println(item)
        );

        return "";
    }
}
