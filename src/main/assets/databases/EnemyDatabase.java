package src.main.assets.databases;

import src.main.assets.Enemy;
import src.main.assets.enemies.*;

import java.util.HashMap;
import java.util.Random;

public class EnemyDatabase 
{
    HashMap<String, Enemy> database = new HashMap<String, Enemy>(); // [Name, Enemy]
    public HashMap<Integer, Enemy> ids = new HashMap<Integer, Enemy>(); // [ID, Enemy]
    public HashMap<Enemy, Integer> enemies = new HashMap<Enemy, Integer>(); // [Enemy, ID]

    public EnemyDatabase()
    {
        // GOBLIN
        database.put(Goblin.name, Goblin.enemy);

        // initialize ids and enemies Dictionaries
        Object[] enemyNames = database.keySet().toArray(); // get an array of all enemy names

        for (int i = 0; i < enemyNames.length; i++)
        {
            ids.put(i, database.get(enemyNames[i]));
            enemies.put(database.get(enemyNames[i]), i);
        }
    }

    public HashMap<String, Enemy> getDatabase()
    {
        return database;
    }

    public Enemy getEnemy (String key)
    {
        return database.get(key);
    }

    public Enemy spawn() // spawn random enemy
    {
        Object[] databaseKeys = database.keySet().toArray();
        Object key = databaseKeys[new Random().nextInt(databaseKeys.length)];

        Enemy enemy = database.get(key);
        enemy.setLevel(1);

        return enemy;
    }
}
