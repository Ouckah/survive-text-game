package src.main.assets.databases;

import src.main.assets.items.Item;
import src.main.assets.items.potions.HealthPotion;

import java.util.HashMap;
import java.util.Random;

public class UseableDatabase 
{
    HashMap<String, Item> database = new HashMap<String, Item>(); // [Name, Useable]
    public HashMap<Integer, Item> ids = new HashMap<Integer, Item>(); // [ID, Useable]
    public HashMap<Item, Integer> useables = new HashMap<Item, Integer>();

    // #region Constructors

    public UseableDatabase() 
    {
        // HEALTH POTION
        database.put(HealthPotion.name, HealthPotion.useable);

        // initialize ids and useables Dictionaries
        Object[] useableNames = database.keySet().toArray(); // get an array of all useable names

        for (int i = 0; i < useableNames.length; i++)
        {
            ids.put(i, database.get(useableNames[i]));
            useables.put(database.get(useableNames[i]), i);
        }
    }

    // #endregion

    // #region Get Methods

    public HashMap<String, Item> getDatabase()
    {
        return database;
    }

    public Item getUseable (String key)
    {
        return database.get(key);
    }

    public Item getRandomUseable()
    {
        Object[] databaseKeys = database.keySet().toArray();
        Object key = databaseKeys[new Random().nextInt(databaseKeys.length)];

        Item useable = database.get(key);
        return useable;
    }

    // #endregion
    

}
