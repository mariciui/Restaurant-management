package PresentationLayer;

import BusinessLayer.MenuItem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.lang.reflect.Field;
import java.util.List;

public class MenuView {

    private Class type;
    private List<MenuItem> list;
    private JScrollPane jScrollPane;
    private JTable jTable;
    private JFrame jFrame;
    private DefaultTableModel defaultTableModel;


    public MenuView(List<MenuItem> list) {


        this.list = list;
        System.out.println(list.size());

                if(list.size()!=0)
        {
            jFrame = new JFrame("Menu ");
            jFrame.setSize(500,500);
            jFrame.setVisible(true);
            jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            jScrollPane = new JScrollPane();

        Object row[][] = new Object[list.size()][3];
        Object col[] = {"Name", "Price", "Id"};

        int i = 0;

        for (MenuItem c : list) {
            row[i][0] = c.getName();
            row[i][1] = c.computePrice() + " Lei";
            row[i][2] = c.getId();
            i++;
            c.toString();
        }

        //JTable menuTable=new JTable(row,col);
        defaultTableModel = new DefaultTableModel(row, col);
        jTable = new JTable(defaultTableModel);
        jTable.setEnabled(false);

        jScrollPane = new JScrollPane(jTable);
        jFrame.add(jScrollPane);
    }
}
//        if(list.size()!=0)
//        {
//            System.out.println("A");
//            jFrame = new JFrame("Meniu");
//            jFrame.setSize(500,500);
//            jFrame.setVisible(true);
//            jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
//
//
//
//            type=list.get(0).getClass();
//            Object[][] data = new Object[list.size()][type.getDeclaredFields().length];
//            Object[] colName = new Object[type.getDeclaredFields().length];
//
//            int i =0, j=0;
//            for (MenuItem c : list)
//            {
//
//                for (Field field : type.getDeclaredFields())
//                {
//                    field.setAccessible(true);
//                    try{
//                        data[i][j] = field.get(c);
//                    } catch(IllegalAccessException e)
//                    {
//                        e.printStackTrace();
//                    }
//                    j++;
//                }
//                j=0;
//                i++;
//
//            }
//            i=0;
//
//            for (Field f : type.getDeclaredFields())
//            {
//                colName[i]=f.getName();
//                i++;
//            }
//            defaultTableModel=new DefaultTableModel(data,colName);
//            jTable=new JTable(defaultTableModel);
//            jTable.setEnabled(false);
//
//            jScrollPane = new JScrollPane(jTable);
//            jFrame.add(jScrollPane);
//        }
//
//    }
    }

