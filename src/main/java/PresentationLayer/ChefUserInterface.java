package PresentationLayer;


import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class ChefUserInterface implements Observer {

    JFrame frame;

    public void update(Observable o, Object arg) {
     JOptionPane.showMessageDialog(this.frame,"NEW ORDER!");
    }
}
