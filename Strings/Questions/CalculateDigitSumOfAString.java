package Questions;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/calculate-digit-sum-of-a-string
public class CalculateDigitSumOfAString {
//    public static String solve(String s, int k){
//        if (s.length() == k){
//            return s;
//        }
//        List<String> st = new ArrayList<>();
//
//        for (int i=0; i<s.length(); i+=k){
//            int end = Math.min(i+k, s.length());
//            st.add(s.substring(i, end));
//        }
//
//        StringBuilder newString = new StringBuilder();
//        for (String sub : st){
//            int count = 0;
//            for (char c : sub.toCharArray()){
//                count += c - '0';
//            }
//            newString.append(count);
//        }
//
//        return solve(newString.toString(), k);
//    }
//
//    public static String digitSum(String s, int k) {
//        return solve(s, k);
//    }

    public static String digitSum(String s, int k) {
        while (s.length() > k){
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<s.length(); i+=k){
                int end = Math.min(i+k, s.length());

                String str = s.substring(i, end);
                int sum =0;
                for (char c : str.toCharArray()){
                    sum += c - '0';
                }
                sb.append(sum);
            }
            s = sb.toString();
        }
        return s;
    }

    public static void main(String[] args) {
        String s = "11111222223";
        int k = 3;
        System.out.println(digitSum(s, k));
    }
}
