import java.util.ArrayList;

public class OrderTest {
    public static void main(String[] args) {
    
        // Menu items
        Item item1 = new Item("mocha", 4.00);
        Item item2 = new Item("latte", 5.00);
        Item item3 = new Item("drip coffee", 2.00);
        Item item4 = new Item("capuccino", 5.50);


        // Order variables -- order1, order2 etc.
        Order order1 = new Order();
        Order order2 = new Order();
        Order order3 = new Order("Michael");
        Order order4 = new Order("Sara");
        Order order5 = new Order("Butternut");
    
        // Application Simulations
        order1.addItem(item1);
        order1.addItem(item2);
        order2.addItem(item1);
        order2.addItem(item1);
        order3.addItem(item3);
        order3.addItem(item4);
        order4.addItem(item4);
        order4.addItem(item1);
        order5.addItem(item4);
        order5.addItem(item4);

        System.out.println(order1.getStatusMessage());
        order1.setIsReady();
        System.out.println(order1.getStatusMessage());
        order1.display();
        order2.display();
        order3.display();
        order4.display();
        order5.display();
    }
}