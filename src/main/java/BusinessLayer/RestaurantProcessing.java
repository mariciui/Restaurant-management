package BusinessLayer;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public interface RestaurantProcessing {

    public void createMenuItemBase(MenuItem menuItem) throws AssertionError;

    public void createMenuItemComposite(MenuItem menuItem) throws AssertionError;

    public void deleteMenuItem(String nume) throws AssertionError;

    public void editMenuItem(String nume, double price) throws AssertionError ;

    public void createNewOrder(Order order, ArrayList<MenuItem> menuItem) throws AssertionError;

    public double computePriceOrder(int orderId) throws AssertionError, FileNotFoundException, UnsupportedEncodingException;

    public void generateBill(int orderId) throws AssertionError, FileNotFoundException, UnsupportedEncodingException;


}
