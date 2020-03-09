package PresentationLayer;

import BusinessLayer.BaseProd;
import BusinessLayer.CompositeProd;
import BusinessLayer.MenuItem;


import javax.swing.*;
import BusinessLayer.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MenuItemList {



    private JButton insertBase;
    private JButton insertComposite;
    private JButton addButton;

    private JLabel namel;
    private JLabel pricel;

    private JPanel p1;
    private JPanel p2;
    private JPanel p3;

    private JFrame frame;

    private JTextField nameText;
    private JTextField priceText;

    private Restaurant restaurant;
    public ArrayList<MenuItem> m;
    public ArrayList<MenuItem> compProd;

    List<JCheckBox> checkBoxList;

    public BaseProd baseProd;

    public MenuItemList() {

        insertBase = new JButton("BASE PRODUCT");
        insertComposite = new JButton("COMPOSITE PRODUCT");
        namel = new JLabel("NAME: ");
        pricel = new JLabel("PRICE: ");
        addButton = new JButton("ADD Composite");

        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        frame = new JFrame();

        insertComposite.setSize(10,10);
        insertBase.setSize(10,10);

        nameText = new JTextField(10);


        priceText = new JTextField(10);


        restaurant = new Restaurant();
        m= new ArrayList<MenuItem>();


        checkBoxList = new ArrayList<>();

        p1.add(insertBase);
        p1.add(insertComposite);
        p1.add(addButton);


        p2.add(namel);
        p2.add(nameText);
        p2.add(pricel);
        p2.add(priceText);

        frame.add(p1);
        frame.add(p2);
        frame.add(p3);

        frame.setLayout(new GridLayout(1,1));
        frame.setSize(600,200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);


        insertBase.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double price = Double.parseDouble(priceText.getText());
                String nume = nameText.getText();

                System.out.println( "nume: " + nume + "pret: " + price);
                baseProd = new BaseProd(price,nume);


                restaurant.createMenuItemBase(baseProd);
                m.add(baseProd);
            }
        });

        insertComposite.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


                for (MenuItem menuItem : restaurant.getMenu()) {

                    if (menuItem instanceof BaseProd)
                    {JCheckBox box = new JCheckBox(String.valueOf(menuItem.getName()));
                    checkBoxList.add(box);
                    p3.add(box);}

                }
                compProd = new ArrayList<MenuItem>();

                addButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String nume = nameText.getText();
                        CompositeProd compositeProd = new CompositeProd(nume);
                        for (JCheckBox checkBox : checkBoxList)
                        {
                            if (checkBox.isSelected()){
                                for (MenuItem menuItem : restaurant.getMenu()){
                                if (checkBox.getText().equals(menuItem.getName())  )
                                    compProd.add(menuItem);
                                }
                            }
                        }
                        compositeProd.setMenuItems(compProd);
                        compositeProd.computePrice();

                        restaurant.createMenuItemComposite(compositeProd);
                    }
                });

            }
        });
    }
}
