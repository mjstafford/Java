import java.util.HashMap;
import java.util.Set;

public class HashMatique {
    public static void main(String[] args){

        HashMap<String, String> trackList = new HashMap<String, String>();
        trackList.put("song A", "adf asd fasd fasdf asd fasdf asdf sdf ");
        trackList.put("song B", "o zxcvzxcvzxcv zxcv zxc vzxc  zxcv zx");
        trackList.put("song C", "ti  ty ui tyui tyui tyui");
        trackList.put("song D", "nfghasgzxfg j rtyiufghjfngh dsfgh ");

        String songLyrics = trackList.get("song B");
        System.out.println("Song B: " + songLyrics +"\n");

        Set<String> keys = trackList.keySet();
        System.out.println(keys + "\n");

        for(String key : keys){
            System.out.println(key + ": " + trackList.get(key));
        }
    }
}