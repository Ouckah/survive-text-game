package src.main.assets;

import java.util.ArrayList;

import src.main.assets.databases.WeaponDatabase;
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

    public int count() // returns the amount of items in inventory
    {
        return inventory.size();
    }

    public Item get (int index)
    {
        Item item = inventory.get(index);
        return item;
    } 

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

    public Item remove (int index)
    {
        return inventory.remove(index);
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
