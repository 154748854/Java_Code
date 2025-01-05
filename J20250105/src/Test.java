import java.util.Locale;

class Solution {
       /* public boolean isPalindrome(String s) {
            s.toLowerCase();
        }
    }*/
    public static boolean isNumOrChar(char ch) {
        if(ch > '0' && ch < '9' || ch > 'a' && ch < 'z') return true;
        else return false;
    }
    public static void main1(String[] args) {
        String str = "hello";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("abc");
        str = stringBuilder.toString();
        System.out.println(str);
    }
}
