package Strings.Till10;

public class FirstLetterOfEveryWord {


    public static void main(String[] args) {
        String str = "July DSA Blitz";
        char[] chars = str.toCharArray();
        for(int i=0; i<chars.length; i++)
        {
            if(chars[i]!=' ' && (i==0 || chars[i-1]==' '))
            {
                System.out.println(chars[i]);
            }
        }
    }
}
