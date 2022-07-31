// holds all the quotes
import java.util.Date;
public class AlfredQuotes {
    
    public String basicGreeting() {
        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name) {
        return String.format("Hello Master %s!", name);
    }

    public String guestGreeting(String name, String dayPeriod) {
        return String.format("Good %s Master %s!",dayPeriod, name);
    }
    
    public String dateAnnouncement() {
        Date date = new Date();
        return "The current date and time is " + date;
    }
    
    public String respondBeforeAlexis(String conversation) {
        if(conversation.indexOf("Alexis") != -1){
            return "Alexis is in the conversation.";
        } else if (conversation.indexOf("Alfred") != -1){
            return "Alfred is in the conversation.";
        } else {
            return "Right, and with that I shall retire";
        }
    }
    
	// NINJA BONUS
	// See the specs to overload the guessGreeting method
    // SENSEI BONUS
    // Write your own AlfredQuote method using any of the String methods you have learned!
}

