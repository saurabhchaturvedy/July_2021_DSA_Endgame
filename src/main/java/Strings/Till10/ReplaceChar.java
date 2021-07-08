package Strings.Till10;

public class ReplaceChar {

    public static void main(String[] args) {

        String str = "tajmahal";

        char[]ch = str.toCharArray();

        for(int i=0; i< ch.length; i++)
        {
            if(ch[i]=='a')
            {
                ch[i]='o';
            }
        }

        System.out.println(String.valueOf(ch));
    }
}
