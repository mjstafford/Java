public class TestGreeting{
    public static void main(String[] args){
        //creates an instance of the greetings class, now you can use methods
        Greetings greeterApp = new Greetings();

        System.out.println(greeterApp.greetSpanish("michael"));

        String dateMessage = greeterApp.getCurrentDate();
        System.out.println(dateMessage);
    }
}