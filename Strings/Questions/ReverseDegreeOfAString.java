package Questions;

// https://leetcode.com/problems/reverse-degree-of-a-string
public class ReverseDegreeOfAString {
    public static int reverseDegree(String s) {
        int result = 0;
        int n = s.length();

        for (int i = 0; i < n; i++){
            int value = 'z' - s.charAt(i) + 1;
            result += value * (i + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(reverseDegree(s));
    }
}
