package DataLayer;

import BusinessLayer.MenuItem;
import BusinessLayer.Restaurant;

import java.io.*;
import java.util.HashSet;

public class RestaurantSerializator {
    //Restaurant res = new Restaurant();
    public void serialize(HashSet<MenuItem> menuItems)  {

        try{
            FileOutputStream file = new FileOutputStream("restaurant.ser");
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(menuItems);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HashSet<MenuItem> deserialize()
    {
        HashSet<MenuItem> menuItems = new HashSet<>();
        try{
            FileInputStream file = new FileInputStream("restaurant.ser");
            ObjectInputStream in = new ObjectInputStream(file);

            menuItems = (HashSet<MenuItem>) in.readObject();

            in.close();
            file.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return menuItems;
    }
}
