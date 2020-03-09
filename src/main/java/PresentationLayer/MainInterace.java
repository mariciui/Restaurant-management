package PresentationLayer;

import BusinessLayer.Restaurant;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainInterace {

    public JFrame frame;
    public JPanel panel;

    public JButton admin;
    public JButton waiter;

    public MainInterace(final Restaurant restaurant) {

        frame = new JFrame("RESTAURANT");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(300,100);

        admin = new JButton("ADMIN");
        waiter = new JButton("WAITER");

        panel = new JPanel();

        frame.setVisible(true);
        panel.add(admin);
        panel.add(waiter);
        frame.add(panel);

        admin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdministratorUserInterface a = new AdministratorUserInterface(restaurant);
            }
        });

        waiter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WaiterUserInterface w = new WaiterUserInterface(restaurant);
            }
        });
    }
}
