package Strings.Till10;

import java.util.HashSet;
import java.util.Set;

public class UniqueCharacters {


    private static int uniqueChars(String str)
    {

        if(str==null || str.length()==0)
            return 0;

        Set<Character> characterSet = new HashSet<>();

        for(char c : str.toCharArray())
        {

            characterSet.add(c);
        }

        return characterSet.size();

    }


    public static void main(String[] args) {
        String str = "diff";
        System.out.println(uniqueChars(str));
    }
}
