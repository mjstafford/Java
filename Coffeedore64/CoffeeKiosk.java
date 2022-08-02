//From Solutions in platform
import java.util.ArrayList;

public class CoffeeKiosk {
  private ArrayList<Item> menu = new ArrayList<Item>();
  private ArrayList<Order> orders = new ArrayList<Order>();

  public CoffeeKiosk() {
  }
  
  public void addMenuItem(String name, double price) {
    Item newItem = new Item(name, price);
    menu.add(newItem);
    int index = menu.indexOf(newItem);
    newItem.setIndex(index);
  }

  public void displayMenu() {
    for(Item item: this.menu) {
      System.out.println(item.getIndex() + " " + item.getName() + " -- $" + item.getPrice());
    }
  }

  public void newOrder() {
        
    // Shows the user a message prompt and then sets their input to a variable, name
      System.out.println("Please enter customer name for new order:");
      String name = System.console().readLine();
  
    // Your code:
      // Create a new order with the given input string
      // Show the user the menu, so they can choose items to add.
      Order newOrder = new Order(name);
      displayMenu();
      
    // Prompts the user to enter an item number
      System.out.println("Please enter a menu item index or q to quit:");
      String itemNumber = System.console().readLine();
      
      // Write a while loop to collect all user's order items
      while(!itemNumber.equals("q")) {
          
          // Get the item object from the menu, and add the item to the order
          int i = Integer.parseInt(itemNumber);
          if(i < this.menu.size()){
            Item orderItem = menu.get(i);
            newOrder.addItem(orderItem);
          } else {
            System.out.println("Sorry we do not have it");
          }
          // Ask them to enter a new item index or q again, and take their input
          System.out.println("Please enter the index of the coffee you would like to order, or press q to exit");
          itemNumber = System.console().readLine();
      }
      // After you have collected their order, print the order details 
      // as the example below. You may use the order's display method.
      newOrder.display();
      this.orders.add(newOrder);
      
  }

  public void addMenuItemByInput(){
    String isCompleted = "y";
    while(isCompleted.equals("y")) {
      System.out.println("Please enter the name of the product:");
      String itemName = System.console().readLine();
      while(itemName.isEmpty()){
        System.out.println("Please enter a valid name");
        itemName = System.console().readLine();
      } 
      System.out.println("Please enter the price of the product:");
      String itemPrice = System.console().readLine();
      while(itemPrice.isEmpty()){
        System.out.println("Please enter a valid price");
        itemPrice = System.console().readLine();
      }
      double price =  Double.parseDouble(itemPrice);
      
      addMenuItem(itemName, price);
      System.out.println("Do you want to add another product? y/n");
      isCompleted = System.console().readLine().toLowerCase();
    }
  }

}