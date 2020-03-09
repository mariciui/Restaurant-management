package PresentationLayer;

import BusinessLayer.MenuItem;
import BusinessLayer.Order;
import BusinessLayer.Restaurant;
import DataLayer.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.RescaleOp;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class OrderList {

    public JFrame frame;
    public JPanel p;
    public JPanel panel;
    public JButton addButton;
    List<JCheckBox> checkBoxList;

    public JLabel table;

    public JTextField textField;


    public ArrayList<MenuItem> menuItems;
    public Order o;

    //public Restaurant restaurant;

    public OrderList(final Restaurant restaurant) {

        frame= new JFrame("Order");
        frame.setSize(400,400);
        frame.setVisible(true);
        frame.setLayout(new GridLayout(2,2));

        o = new Order();
        p = new JPanel();
        panel = new JPanel();

        addButton = new JButton("ADD");
        checkBoxList = new ArrayList<>();
        menuItems = new ArrayList<>();
        //restaurant = new Restaurant();

        panel.add(addButton);

        frame.add(p);
        frame.add(panel);

        table = new JLabel("Table");
        textField = new JTextField(10);
        panel.add(table);
        panel.add(textField);


        for (MenuItem menuItem : restaurant.getMenu())
        {
            System.out.println("meniu: " + menuItem.getName());
            JCheckBox box = new JCheckBox(String.valueOf(menuItem.getName()));
            checkBoxList.add(box);
            p.add(box);
        }
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int tableNr = Integer.parseInt(textField.getText());
                for (JCheckBox checkBox : checkBoxList)
                {
                    if (checkBox.isSelected())
                    {
                        for (MenuItem menuItem : restaurant.getMenu()) {
                            if (checkBox.getText().equals(menuItem.getName()))
                                 menuItems.add(menuItem);
                               // restaurant.createNewOrder(o, menuItem);
                        }
                    }
                }

                for (MenuItem m : menuItems)
                {
                    System.out.println(m.getName());
                    m.setId(tableNr);
                }
                o.setTable(tableNr);
                restaurant.createNewOrder(o,menuItems);
            }
        });


    }
}
