public class IsPalindrome {
    public static void main(String[] args) {
        String str = "badadab";
        System.out.println(isPalindrome(str));
        str = "zxyyxz";
        System.out.println(isPalindrome(str));
    }
    public static boolean isPalindrome(String str){
        if(str == null || str.length() <= 1){
            return true;
        }

        str = str.toLowerCase();
        int n = str.length();

        for(int i = 0; i< n / 2; i++){
            char start = str.charAt(i);
            char end = str.charAt(n - 1 -i);
            if(start != end){
                return false;
            }
        }
        return true;
    }
}
