package src.main.assets;

import java.util.ArrayList;

import src.main.assets.items.Item;
import src.main.assets.items.Weapon;

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

    public void printItems()
    {
        for (int i = 0; i < inventory.size(); i++)
        {
            if (inventory.get(i) instanceof Item && !(inventory.get(i) instanceof Weapon)) // if item is not a weapon
            {
                System.out.print("[" + i + "]: ");
                System.out.println(inventory.get(i));    
            }
        }
    }

    public String toString()
    {
        System.out.println(inventory.size() + " / " + space + "\n");

        for (int i = 0; i < inventory.size(); i++)
        {
            System.out.print("[" + i + "]: ");
            System.out.println(inventory.get(i));
        }

        return "";
    }
}
