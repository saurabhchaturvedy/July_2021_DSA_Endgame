package Strings.Till10;

public class RevereWholeString {


    private static String reverse(String str)
    {

        String strx="";

        for(int i=0; i<str.length(); i++)
        {
            strx = str.charAt(i) + strx;
        }

        return strx;
    }


    public static String reverseWordsStringBuilder(String str) {

        StringBuilder finalStr = new StringBuilder();
        StringBuilder tempStr = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == ' ') {
                finalStr.insert(0, tempStr).insert(0, " ");
                tempStr.setLength(0);
            } else {
                tempStr.append(c);
            }
        }

        finalStr.insert(0, tempStr);

        return finalStr.toString();
    }

    public static void main(String[] args) {
        String str = "coding is simpleton";
        System.out.println(reverseWordsStringBuilder(str));
    }
}
