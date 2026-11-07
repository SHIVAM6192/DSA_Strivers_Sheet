// https://leetcode.com/problems/flip-string-to-monotone-increasing/
public class FlipStringToMonotoneIncreasing {
    public static int minFlipsMonoIncr(String s) {
        int countOfOnes = 0;
        int flip = 0;

        for (char c : s.toCharArray()){
            if (c == '1')
                countOfOnes++;
            else
                flip = Math.min(flip+1, countOfOnes);
        }

        return flip;
    }

    public static void main(String[] args) {
        String s = "010110";
        System.out.println(minFlipsMonoIncr(s));
    }
}
