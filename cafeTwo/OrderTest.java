import java.util.ArrayList;

public class OrderTest {
    public static void main(String[] args) {
    
        // Menu items
        Item item1 = new Item();
        Item item2 = new Item();
        Item item3 = new Item();
        Item item4 = new Item();

        item1.name = "mocha";
        item2.name = "latte";
        item3.name = "drip coffe";
        item4.name = "capuccino";

        item1.price = 4.00;
        item2.price = 5.00;
        item3.price = 2.00;
        item4.price = 5.50;

        // Order variables -- order1, order2 etc.
        Order order1 = new Order();
        Order order2 = new Order();
        Order order3 = new Order();
        Order order4 = new Order();

        order1.name = "Cindhuri";
        order2.name = "Jimmy";
        order3.name = "Noah";
        order4.name = "Sam";
    
        // Application Simulations
        order2.items.add(item1);
        order2.total += item1.price;

        order3.items.add(item4);
        order3.total += item4.price;

        order4.items.add(item2);
        order4.total += item2.price;

        order1.ready = true;

        order2.items.add(item2);
        order2.items.add(item2);
        order2.total += item2.price;
        order2.total += item2.price;

        order2.ready = true;

        // Use this example code to test various orders' updates
        System.out.println(order1);
        System.out.printf("order1 total: %s\n", order1.total);
        System.out.printf("Name: %s\n", order1.name);

        System.out.println(order2);
        System.out.printf("order2 total: %s\n", order2.total);
        System.out.printf("Name: %s\n", order2.name);

        System.out.printf("Total: %s\n", order1.total);
        System.out.printf("Ready: %s\n", order1.ready);
    }
}