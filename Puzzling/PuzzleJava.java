import java.util.Random;
import java.util.ArrayList;
    
public class PuzzleJava{
    public static int[] getTenRolls(){
        Random randMachine = new Random();
        int[] randomRolls = new int[10];

        for(int i = 0; i <10; i++){
            randomRolls[i] = randMachine.nextInt(19)+1;
        }
        return randomRolls;
    }

    public static String getRandomLetter(){
        Random randMachine = new Random();
        String[] letters = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        int randInt = randMachine.nextInt(26);
        return letters[randInt];
    }

    public static String generatePassword(){
        String password = "";
        while (password.length() < 8){
            password += PuzzleJava.getTenRolls()[0];
            password += PuzzleJava.getRandomLetter();
            // System.out.println(password);
        }
        
        return password;
    }

    public static ArrayList<String> getNewPasswordSet(int length){
        ArrayList<String> passwordArray = new ArrayList<String>();

        for(int i=0; i < length; i++) {
            String password = "";
            while (password.length() < 8){
                password += PuzzleJava.getTenRolls()[0];
                password += PuzzleJava.getRandomLetter();
                // System.out.println(password);
            }
            passwordArray.add(password);
        }
        
        return passwordArray;
    }
}