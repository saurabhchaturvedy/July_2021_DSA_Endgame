package Strings.Till10;

public class TrimTheString {

    public static void main(String[] args) {
        String str = " July DSA Blitz  ";
        int count=0;


        char[] chars = str.toCharArray();

        int start=0;
        int end= chars.length-1;

        for(int i=0; i< chars.length; i++)
        {
            if(chars[i]!=' ')
            {
                start=i;
                break;
            }
        }

        for(int i= chars.length-1; i>start-1; i--)
        {

            if(chars[i]!=' ')
            {
                end=i;
                break;
            }
        }

        count = end-start+1;

        String strr = new String(chars,start,count);

        System.out.println("Trimmed string is "+strr);
    }
}
