package src.main.assets.databases;

import src.main.assets.items.Weapon;
import src.main.assets.items.weapons.*;

import java.util.HashMap;
import java.util.Random;

public class WeaponDatabase 
{
    HashMap<String, Weapon> database = new HashMap<String, Weapon>(); // [Name, Weapon]
    public HashMap<Integer, Weapon> ids = new HashMap<Integer, Weapon>(); // [ID, Weapon]
    public HashMap<Weapon, Integer> weapons = new HashMap<Weapon, Integer>();

    // #region Constructors

    public WeaponDatabase() 
    {
        // FISTS
        database.put(Fists.name, Fists.weapon);

        // STICK
        database.put(Stick.name, Stick.weapon);

        // initialize ids and weapons Dictionaries
        Object[] weaponNames = database.keySet().toArray(); // get an array of all weapon names

        for (int i = 0; i < weaponNames.length; i++)
        {
            ids.put(i, database.get(weaponNames[i]));
            weapons.put(database.get(weaponNames[i]), i);
        }
    }

    // #endregion

    // #region Get Methods

    public HashMap<String, Weapon> getDatabase()
    {
        return database;
    }

    public Weapon getWeapon (String key)
    {
        return database.get(key);
    }

    public Weapon getRandomWeapon()
    {
        Object[] databaseKeys = database.keySet().toArray();
        Object key = databaseKeys[new Random().nextInt(databaseKeys.length)];

        Weapon weapon = database.get(key);
        if (weapon.isObtainable()) // if weapon can be found in the wild return it
        {
            return database.get(key);
        }
        return getRandomWeapon();
    }

    // #endregion
}
