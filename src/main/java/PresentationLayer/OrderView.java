package PresentationLayer;


import BusinessLayer.Order;
import BusinessLayer.Restaurant;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class OrderView {

    private List<Order> list;
    private JScrollPane jScrollPane;
    private JTable jTable;
    private JFrame jFrame;
    private DefaultTableModel defaultTableModel;


    public OrderView(List<Order> Orderlist, Restaurant restaurant) throws FileNotFoundException, UnsupportedEncodingException {


        list = new ArrayList<Order>();
        this.list = Orderlist;
        System.out.println(this.list.size());

        if(list.size()!=0)
        {

            jFrame = new JFrame("Order");
            jFrame.setSize(500,500);
            jFrame.setVisible(true);
            jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            jScrollPane = new JScrollPane();

            Object row[][] = new Object[list.size()][3];
            Object col[] = {"DATE", "TotalPrice", "Table"};

            int i = 0;

            for (Order c : list) {
                row[i][0] = c.getDate();
                row[i][1] = restaurant.computePriceOrder(c.getTable()) + " Lei";
                row[i][2] = c.getTable();
                i++;
                c.toString();
            }

            defaultTableModel = new DefaultTableModel(row, col);
            jTable = new JTable(defaultTableModel);
            jTable.setEnabled(false);

            jScrollPane = new JScrollPane(jTable);
            jFrame.add(jScrollPane);
        }
    }
}

