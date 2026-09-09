// https://leetcode.com/problems/count-commas-in-range-ii
public class CountCommasInRangeII {
    public static long countCommas(long n) {
        long result = 0;
        long start = 1000;

        while(start <= n){
            result += (n - start +1);
            start *= 1000;
        }

        return result;
    }

    public static void main(String[] args) {
        long num = 1005;
        System.out.println(countCommas(num));
    }
}
