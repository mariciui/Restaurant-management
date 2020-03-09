package BusinessLayer;

public class BaseProd extends MenuItem {


    public BaseProd(double price, String name) {

       super.setPrice(price);
       super.setName(name);
    }



    public double computePrice() {

        return super.price;
    }

}
