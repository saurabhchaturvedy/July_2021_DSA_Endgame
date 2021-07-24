package Strings.Till10;

import java.util.Stack;

public class ReverseEveryWordString {


    public static String reverseIndividualWord(String str) {

         String finalStr = "";
        String tempStr = "";

        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if(c == ' ') {
                finalStr = finalStr + tempStr + " ";
                tempStr = "";
            } else {
                tempStr = c + tempStr;
            }
        }

        finalStr = finalStr + tempStr;

        return finalStr;
    }


    private static void reverseIndividualStack(String str)
    {

        Stack<Character> characterStack = new Stack<>();

        for(int i=0; i<str.length(); i++)
        {

            if(str.charAt(i)!=' ')
            {
                characterStack.push(str.charAt(i));
            }
            else
            {
                while(!characterStack.isEmpty())
                    System.out.print(characterStack.pop());
                System.out.print(" ");
            }
        }

        while (!characterStack.isEmpty())
        {
            System.out.print(characterStack.pop());
        }


    }



    public static void main(String[] args) {

        String str = "July DSA Blitz";

        reverseIndividualStack(str);
    }
}
