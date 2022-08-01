import java.util.ArrayList;

public class Order{
    private String name;
    private boolean ready;
    private ArrayList<Item> items;

    public Order(){
        this.name = "Guest";
        this.items = new ArrayList<Item>();
    }

    public Order(String name){
        this.name = name;
        this.items = new ArrayList<Item>();
    }

    public String getName(){
        return this.name;
    }

    public ArrayList<Item> getItems(){
        return this.items;
    }

    public boolean isReady(){
        return this.ready;
    }
    public void setIsReady(){
        this.ready = true;
    }

    public void addItem(Item item){
        this.items.add(item);
    }

    public String getStatusMessage(){
        return this.ready ? "Your order is ready." : "Thank you for waiting. Your order will be ready soon.";
    }

    public double getOrderTotal(){
        double sum = 0;
        for(Item item : this.items ){
            sum += item.getPrice();
        }
        return sum;
    }

    public void display(){
        System.out.println("Customer Name: " + this.name);
        for(Item item : this.items ){
            System.out.println(item.getName() + " - " + item.getPrice());  
        }
        
        System.out.println("Total: " + this.getOrderTotal());
    }
}