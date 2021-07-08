package Strings.Till10;

public class ReverseString
{

    private static String reverse(String str)
    {

        char[] chars = str.toCharArray();
        int low=0;
        int high=chars.length-1;

        while(low<high)
        {

            char temp = chars[low];
            chars[low] = chars[high];
            chars[high] = temp;
            low++;
            high--;
        }

        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        String str = "database";

        System.out.println(reverse(str));
    }
}
