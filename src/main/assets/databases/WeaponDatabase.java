package src.main.assets.databases;

import src.main.assets.*;
import java.util.HashMap;

public class WeaponDatabase {
    HashMap<String, Weapon> database = new HashMap<String, Weapon>(); // [Name, Weapon]

    public WeaponDatabase() 
    {
        // FISTS
        database.put
        (
            "Fists",

            new Weapon
            (
                "Fists",
                "The ol' fashioned way.",
                1,
                0,
                1
            )
        );

        // STICK
        database.put
        (
            "Stick",

            new Weapon
            (
                "Stick",
                "Just a regular stick.",
                2,
                60,
                1
            )
        );
    }

    public HashMap<String, Weapon> getDatabase()
    {
        return database;
    }
}
