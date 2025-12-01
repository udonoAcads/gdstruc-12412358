package com.gdstruc.quiz4;

import javax.lang.model.type.NullType;
import java.awt.*;

public class SimpleHashtable
{
    private StoredPlayer[] hashtable;

    public SimpleHashtable()
    {
        hashtable = new StoredPlayer[10];
    }

    private int hashKey(String key)
    {
        return key.length() % hashtable.length;
    }

    public void put(String key, Player value)
    {
        int hashedKey = hashKey(key);

        if (isOccupied(hashedKey))
        {
            //Do linear probing
            int stoppingIndex = hashedKey;

            if (hashedKey == hashtable.length - 1)
            {
                hashedKey = 0;
            }
            else
            {
                hashedKey++;
            }

            while(isOccupied(hashedKey) && hashedKey != stoppingIndex)
            {
                hashedKey = (hashedKey + 1) % hashtable.length;
            }
        }

        if (isOccupied(hashedKey))
        {
            System.out.println("The hash table is already full.");
        }
        else
        {
            hashtable[hashedKey] = new StoredPlayer(key, value);
        }
    }

    public Player get(String key)
    {
        int hashedKey = findKey(key);

        if (hashedKey == -1)
        {
            return null;
        }

        return hashtable[hashedKey].value;
    }

    // Works like the pop function
    public Player remove(String key)
    {
        int hashedKey = findKey(key);

        if (hashedKey == -1)
        {
            System.out.println("Cannot remove " + key + " as " + key + " does not exist.");
            return null;
        }

        System.out.println("Removed " + key + ".");

        StoredPlayer removedPlayer = hashtable[hashedKey];

        //Removes the both the key and the value stored to make way for other players with the same hashedkey
        hashtable[hashedKey] = null;

        return removedPlayer.value;
    }

    private int findKey(String key)
    {
        int hashedKey = hashKey(key);

        //for finding the right key (which is a String)
        if (hashtable[hashedKey] != null && hashtable[hashedKey].key.equals(key))
        {
            return hashedKey;
        }
        else
        {
            //Do linear probing
            int stoppingIndex = hashedKey;

            if (hashedKey == hashtable.length - 1)
            {
                hashedKey = 0;
            }
            else
            {
                hashedKey++;
            }

            while(hashtable[hashedKey] != null
                    && hashedKey != stoppingIndex
                    && !hashtable[hashedKey].key.equals(key))
            {
                hashedKey = (hashedKey + 1) % hashtable.length;
            }
        }

        if (hashtable[hashedKey] != null && hashtable[hashedKey].key.equals(key))
        {
            return hashedKey;
        }
        return -1;
    }

    private boolean isOccupied(int index)
    {
        return hashtable[index] != null;
    }

    public void printHashtable()
    {
        for (int i = 0; i < hashtable.length; i++)
        {
            if (isOccupied(i))
            {
                System.out.println("Element " + i + " of Hashtable: " + hashtable[i]);
            }
            else
            {
                System.out.println("Element " + i + " is null. ");
            }
        }
    }
}
