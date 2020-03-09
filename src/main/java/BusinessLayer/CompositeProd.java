package BusinessLayer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CompositeProd extends MenuItem{

    private ArrayList<MenuItem> menuItems;




    public CompositeProd(String nume) {

       super.setName(nume);
        menuItems = new ArrayList<>();
    }

    public CompositeProd() {

        menuItems = new ArrayList<>();

    }


    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(ArrayList<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public double computePrice() {
        double p = 0;
        for (MenuItem menuItem : menuItems)
            p+= menuItem.computePrice();

        this.price = p;
        return price;
    }
}
