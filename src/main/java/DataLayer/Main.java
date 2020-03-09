package DataLayer;

import BusinessLayer.Restaurant;
import PresentationLayer.AdministratorUserInterface;
import PresentationLayer.ChefUserInterface;
import PresentationLayer.MainInterace;

public class Main {

    public static void main(String[] args){
        Restaurant restaurant = new Restaurant();
        MainInterace m = new MainInterace(restaurant);

        ChefUserInterface chefUserInterface = new ChefUserInterface();
        restaurant.registerObserver(chefUserInterface);
}
}
