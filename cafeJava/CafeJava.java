public class CafeJava {
    public static void main(String[] args){
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";
        
        // Menu variables (add yours below)
        double mochaPrice = 3.5;
        double dripPrice = 3.5;
        double lattePrice = 3.5;
        double cappuccinoPrice = 3.5;

        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";

        // Order completions (add yours below)
        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = false;
        boolean isReadyOrder3 = true;
        boolean isReadyOrder4 = false;

        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
        System.out.println(generalGreeting + customer1); // Displays "Welcome to Cafe Java, Cindhuri"
        System.out.println(customer1 + pendingMessage + "." + displayTotalMessage + dripPrice + ".");
        System.out.println("\n");

        //Sam
        System.out.println(generalGreeting + customer2);
        if(isReadyOrder2){
            System.out.println(customer2 + readyMessage + "." + displayTotalMessage + cappuccinoPrice + ".");
        } else {
            System.out.println(customer2 + pendingMessage + ".");
        }
        System.out.println("\n");

        //Jimmy
        System.out.println(generalGreeting + customer3);
        if(isReadyOrder3){
            System.out.println(customer3 + readyMessage + "." + displayTotalMessage + lattePrice*2 + ".");
        } else {
            System.out.println(customer3 + pendingMessage + ".");
        }
        System.out.println("\n");

        //Noah
        System.out.println(generalGreeting + customer4);
        if(isReadyOrder4){
            System.out.println(customer4 + readyMessage + "." + displayTotalMessage + lattePrice + ".");
        } else {
            System.out.println(customer4 + pendingMessage + ".");
        }
        System.out.println("\n");
    }
}