package BusinessLayer;


import java.time.LocalDate;


public class Order  {
    public int OderID;
    private LocalDate date;
    public int table;
    public double totalPrice;

    public Order (){

        date = LocalDate.now();
    }

    public double getTotalPrice() {

        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getOderID() {
        return OderID;
    }

    public void setOderID(int oderID) {
        OderID = oderID;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate()
    {
        date = LocalDate.now();
    }


    public int getTable() {
        return table;
    }

    public void setTable(int table) {
        this.table = table;
    }
    
    public int hashCode()
    {
        int prime = 31;
        int hashcode = prime * OderID;

        return hashcode;
    }

}
