package Strings.Till10;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingChar {


    private static Character firstNonRepeating(String str)
    {
        Character firstNonRepeating=null;
        char[] chars = str.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0; i<chars.length; i++)
        {
            map.put(chars[i],map.getOrDefault(chars[i],0)+1);
        }

        for (int i=0; i<str.length(); i++)
        {
            if(map.get(str.charAt(i))==1)
            {
                firstNonRepeating = str.charAt(i);
                break;  // remove for getting last non-repeating char
            }
        }

        return firstNonRepeating;

    }


    public static void main(String[] args) {
        String str="babble moon";
        System.out.println(firstNonRepeating(str));
    }
}
