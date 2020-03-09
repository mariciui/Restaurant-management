package BusinessLayer;

import DataLayer.RestaurantSerializator;

import java.io.*;
import java.util.*;
import java.util.List;

public class Restaurant extends Observable implements RestaurantProcessing, Serializable {

    public HashMap<Order, Collection<MenuItem>> res;
    public HashSet<MenuItem> menuItemHashSet;
    public HashSet<MenuItem> menu;
    public Observer observer = null;

    RestaurantSerializator restaurantSerializator;

//    public Restaurant(ChefUserInterface chef) {
//        res = new HashMap<Order, Collection<MenuItem>>();
//        addObserver(chef);
//        restaurantSerializator.deserialize();
//        //menuItemHashSet = new HashSet<MenuItem>();
//        menu = new HashSet<MenuItem>();
//
//    }

    public Restaurant() {

        res = new HashMap<Order, Collection<MenuItem>>();
        restaurantSerializator = new RestaurantSerializator();
        menu = new HashSet<MenuItem>();
        menu = restaurantSerializator.deserialize();

    }

    private boolean isWellFormed()
    {
        Set<Order> set = res.keySet();

        for(Order order : set)
        {
            if (res.get(order) == null)
                return false;
        }
        return true;
    }

public void deleteAll()
{
    menu.clear();
    restaurantSerializator.serialize(menu);
}

    public void createMenuItemBase(MenuItem menuItem)
    {
        assert isWellFormed();
        int iSize=menu.size();

        menu.add(menuItem);

        assert iSize == menu.size() -1 ;
        assert isWellFormed();
        restaurantSerializator.serialize(menu);
        menu = restaurantSerializator.deserialize();

    }
    public void createMenuItemComposite(MenuItem menuItem)
    {
        assert isWellFormed();
        int iSize=menu.size();

        menu.add(menuItem);

        assert iSize == menu.size() -1 ;
        assert isWellFormed();
        restaurantSerializator.serialize(menu);
        menu = restaurantSerializator.deserialize();
    }
    public void editMenuItem(String nume, double price) throws AssertionError {

        assert isWellFormed();

        int iSize = menu.size();

        for (MenuItem m :  menu )
        {
            if (m instanceof BaseProd) {
                if (nume.equals(m.getName())) {
                    m.setPrice(price);
                    break;
                }
            }
            else System.out.println("Only base-products can be edited");
        }

        assert iSize == menu.size();
        assert isWellFormed();

        restaurantSerializator.serialize(menu);
        menu = restaurantSerializator.deserialize();
    }

    public void deleteMenuItem(String nume) throws AssertionError {
        assert isWellFormed();
        int iSize = menu.size();

//        Iterator<MenuItem> itemIterator = menu.iterator();
//        while (itemIterator.hasNext())
//        {
//                MenuItem m1 = null;
//                m1 = itemIterator.next();
//
//                if(m1 instanceof BaseProd)
//                {
//                    BaseProd baseProd;// = new BaseProd();
//                    baseProd = (BaseProd) m1;
//
//                    if(baseProd.getName().equals(nume))
//                    {
//                        itemIterator.remove();
//                    }
//
//                } else if (m1 instanceof CompositeProd)
//                {
//                    CompositeProd compositeProd;// = new CompositeProd();
//                    compositeProd = (CompositeProd) m1;
//
//                    if(compositeProd.getName().equals(nume))
//                    {
//                        itemIterator.remove();
//                    }
//                }
//
//        }
        for (MenuItem m : menu)
        {
            if (nume.equals(m.getName()))
            {
                menu.remove(m);
                break;
            }
        }

        assert iSize == menu.size()+1;
        assert isWellFormed();

        restaurantSerializator.serialize(menu);
        menu = restaurantSerializator.deserialize();
    }

    public void createNewOrder(Order order, ArrayList<MenuItem> menuItem) throws AssertionError {

        assert isWellFormed();
        int iSize = res.size();

        for (MenuItem m : menuItem)
        {
            System.out.println(m.getName());
        }

        res.put(order,addMenuItem(menuItem));
        notify(this,menuItem);

        for (Order r : res.keySet())
        {
            System.out.println(r.getTable());
        }

        //System.out.println("AICI2");
        assert iSize == res.size() -1;
        assert isWellFormed();

    }



    public HashSet<MenuItem> addMenuItem(ArrayList<MenuItem> menuItem) throws AssertionError {

        HashSet<MenuItem> toOrder = new HashSet<>();
        System.out.println("AICI");
        for (MenuItem m : menuItem)
        toOrder.add(m);
        return toOrder;
    }

    public double computePriceOrder(int orderId) throws AssertionError, FileNotFoundException, UnsupportedEncodingException {

        double totalPrice = 0;
        for (Map.Entry<Order, Collection<MenuItem>> list : res.entrySet())
        {
            for (MenuItem menuItem : list.getValue())
            {
                if (menuItem.getId() == orderId) {
                    totalPrice += menuItem.computePrice();
                }
            }
        }

        return totalPrice;
    }

    public void generateBill(int orderId) throws AssertionError, FileNotFoundException, UnsupportedEncodingException {
        File file = new File("bills.txt");
        PrintWriter writer = new PrintWriter(file,"UTF-8");
        writer.println("Order: " + orderId);

       // ArrayList<MenuItem> menuItemArrayList = new ArrayList<MenuItem>();

        try {
            for (Map.Entry<Order, Collection<MenuItem>> list : res.entrySet()) {
             if (list.getKey().getTable() == orderId)
             {
                 writer.println("Data: " + list.getKey().getDate());
                 writer.println("Table: " + list.getKey().getTable());
                 writer.println("Total Price: " + computePriceOrder(orderId));

                 for (MenuItem menuItem : list.getValue())
                 {
                     writer.println("Name: " + menuItem.getName() + "price: " + menuItem.computePrice() + "LEI");
                 }

                 writer.close();
             }
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }


    public List<MenuItem> getMenu()
    {
        List<MenuItem> list = new ArrayList<MenuItem>();

            for (MenuItem menuItem : menu)
            {
                list.add(menuItem);
            }

        return list;
    }

    public ArrayList<Order> getOrders(){
        assert isWellFormed();

       List<Order> list = new ArrayList<>();

       list.addAll(res.keySet());
        assert isWellFormed();

        return (ArrayList<Order>) list;
    }
    public void notify(Observable o, List<MenuItem> menuItems) {

        observer.update(o, menuItems);
    }

    public void registerObserver(Observer obs) {
        this.observer = obs;
    }

}
