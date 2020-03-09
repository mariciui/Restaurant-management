package BusinessLayer;

import java.io.Serializable;


public abstract class MenuItem implements Serializable {

    String name;
    double price;
    int id;

    public MenuItem(int id,String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price)
    {
        this.price = price;

    }

    public MenuItem() {

    }

    public abstract double computePrice();




}
