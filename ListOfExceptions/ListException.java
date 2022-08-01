import java.util.ArrayList;

public class ListException{
    public static void main(String[] args){
        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add("13");
        myList.add("hello world");
        myList.add(48);
        myList.add("Goodbye World");

        for(int i = 0; i < myList.size(); i++) {    //on outside to have access to index!
            try{
                Integer castedValue = (Integer) myList.get(i);
            } catch(ClassCastException e){
                System.out.println(e);
                System.out.println("Index: " + i + "\nValue: " + myList.get(i) + "\n");
            }
        }

    }
}