package src.main.assets.databases;

import src.main.assets.items.Weapon;
import src.main.assets.items.weapons.*;

import java.util.HashMap;
import java.util.Random;

public class WeaponDatabase 
{
    HashMap<String, Weapon> database = new HashMap<String, Weapon>(); // [Name, Weapon]

    // #region Constructors

    public WeaponDatabase() 
    {
        // FISTS
        database.put(Fists.name, Fists.weapon);

        // STICK
        database.put(Stick.name, Stick.weapon);
    }

    // #endregion

    // #region Get Methods

    public HashMap<String, Weapon> getDatabase()
    {
        return database;
    }

    public Weapon getWeapon()
    {
        Object[] databaseKeys = database.keySet().toArray();
        Object key = databaseKeys[new Random().nextInt(databaseKeys.length)];
        return database.get(key);
    }

    // #endregion
}
