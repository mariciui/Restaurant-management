package PresentationLayer;

import BusinessLayer.Order;
import BusinessLayer.Restaurant;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class WaiterUserInterface {

    private JFrame frame;

    private JPanel p;
    private JPanel p1;

    private JButton addButton;
    private JButton viewAllButton;
    private JButton computeBill;

    private JLabel table;
    private JTextField textField;

    public Restaurant r;
    public  Order o;


    public WaiterUserInterface(final Restaurant r) {

        frame = new JFrame();
        frame.setLayout(new GridLayout(1,1));
        frame.setVisible(true);
        frame.setSize(300,100);
        p = new JPanel();
        p1 = new JPanel();
        p.setLayout(new GridLayout(1,3));

        addButton = new JButton("ADD ");
        viewAllButton = new JButton("VIEW ALL ");
        computeBill = new JButton("BILL ");

        table = new JLabel("TABLE: ");
        textField = new JTextField(10);


        p.add(addButton);
        p.add(viewAllButton);
        p.add(computeBill);

        p1.add(table);
        p1.add(textField);

        frame.add(p);
        frame.add(p1);

        frame.setLayout(new GridLayout(2,2));


        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                OrderList orderList = new OrderList(r);
            }
        });

        viewAllButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    OrderView orderView = new OrderView(r.getOrders(), r);
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                } catch (UnsupportedEncodingException e1) {
                    e1.printStackTrace();
                }
            }
        });

        computeBill.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int text = Integer.parseInt(textField.getText());

                try {

                    r.generateBill(text);
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                } catch (UnsupportedEncodingException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
}
