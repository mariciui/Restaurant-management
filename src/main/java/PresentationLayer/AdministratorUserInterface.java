package PresentationLayer;

import BusinessLayer.Restaurant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RectangularShape;

public class AdministratorUserInterface {

    private JFrame frame;

    private JButton addButton;
    private JButton viewAllButton;
    private JButton editButton;
    private JButton deleteButton;
    private JButton deleteAll;

    private JTextField id;
    private JTextField price;
    private JTextField name;

    private JLabel idLabel;
    private JLabel priceLabel;
    private JLabel nameLabel;

    private JPanel jPanel;
    private JPanel p;

    public AdministratorUserInterface(Restaurant restaurant) {

        frame = new JFrame();

        id =new  JTextField();
        price = new JTextField();
        name = new JTextField();

        idLabel = new JLabel("ID: ");
        priceLabel = new JLabel("PRICE: ");
        nameLabel = new JLabel("NAME: ");

        addButton = new JButton("ADD");
        viewAllButton = new JButton("VIEW ALL");
        editButton = new JButton("EDIT");
        deleteButton = new JButton("DELETE");
        deleteAll = new JButton("DELETE ALL");

        jPanel = new JPanel();
        p = new JPanel();

        p.add(idLabel);
        p.add(id);
        p.add(priceLabel);
        p.add(price);
        p.add(nameLabel);
        p.add(name);

        p.setLayout(new GridLayout(3,1));

        jPanel.add(addButton);
        jPanel.add(viewAllButton);
        jPanel.add(editButton);
        jPanel.add(deleteButton);
        jPanel.add(deleteAll);

        frame.add(jPanel);
        frame.add(p);
        frame.setLayout(new GridLayout(2,2));
        frame.setSize(400,400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);


        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               MenuItemList menuItemList = new MenuItemList();
            }
        });
        viewAllButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Restaurant restaurant = new Restaurant();

                MenuView menuView = new MenuView(restaurant.getMenu());
            }
        });
        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int ID = Integer.parseInt(id.getText());
                String nume = name.getText();
                int pret = Integer.parseInt(price.getText());
                Restaurant restaurant = new Restaurant();
                restaurant.editMenuItem(nume, pret);
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nume = name.getText();
                Restaurant restaurant = new Restaurant();
                restaurant.deleteMenuItem(nume);
            }
        });

        deleteAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Restaurant restaurant = new Restaurant();
                restaurant.deleteAll();
            }
        });
    }

}
