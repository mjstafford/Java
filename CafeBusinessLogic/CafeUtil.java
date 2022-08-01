import java.util.ArrayList;

public class CafeUtil {

    public int getStreakGoal(int numWeeks){
        int sum = 0;
        for(int i = 1; i <= numWeeks; i++){
            sum += i;
        }
        return sum;
    }

    public double getOrderTotal(double[] prices){
        double sum = 0;
        for(double price : prices){
            sum += price;
        }
        return sum;
    }

    public void displayMenu(ArrayList<String> menuItems){
        for(int i = 0 ; i < menuItems.size(); i++){
            // System.out.println(menuItems[i]);    bracket notation doesnt work on ArrayList :(
            System.out.println(i+ " " + menuItems.get(i));
        }
    }

    public void addCustomer(ArrayList<String> customers){
        System.out.println("Please enter your name");
        String userName = System.console().readLine();  //this line will break terminal in vsCode but work on cmdr/bash/etc


        System.out.println(String.format("Hello, %s!", userName));

        int numInLine = customers.size();

        System.out.println(String.format("There are %s people in front of you", numInLine));
        customers.add(userName);

        System.out.println(customers);
    }

    public void printPriceChart(String product, double price, int maxQuantity){
        System.out.println(product);

        for(int i = 1; i < maxQuantity+ 1; i++){
            double multiPrice = price;

            if(i != 1){
                multiPrice += (price*(i-1)) - 0.5*(i-1);
            }
            System.out.println(String.format("%d - $%.2f", i, multiPrice));
        }
    }
}