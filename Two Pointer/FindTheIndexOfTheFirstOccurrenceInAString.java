public class FindTheIndexOfTheFirstOccurrenceInAString {
    public static void main(String[] args) {
        String haystack = "leetcode";
        String needle = "cod";
        System.out.println(strStr(haystack, needle));
    }
    public static int strStr(String haystack, String needle) {
        int length = haystack.length() - needle.length() + 1;

        for(int i = 0; i < length; i++){
            if(haystack.charAt(i) == needle.charAt(0)){
                if(haystack.substring(i, needle.length() + i).equals(needle)){
                    return i;
                }
            }
        }
        return -1;
    }
}
