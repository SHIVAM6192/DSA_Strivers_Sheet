package Questions;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/sequential-digits/description
public class SequentialDigits {
    public static List<Integer> sequentialDigits(int low, int high) {
        String s = "123456789";
        int minlen = String.valueOf(low).length();
        int maxlen = String.valueOf(high).length();

        List<Integer> ans = new ArrayList<>();

        for(int i = minlen; i<=maxlen; i++){
            for(int start=0; start+i<=9; start++){
                String subStr = s.substring(start, start+i);
                int num  = Integer.parseInt(subStr);

                if(num >= low && num <= high){
                    ans.add(num);
                }
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        List<Integer> result = sequentialDigits(100, 300);
        System.out.println(result.toString());
    }
}
