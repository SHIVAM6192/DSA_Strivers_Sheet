// https://leetcode.com/problems/count-commas-in-range
public class CountCommasInRange {
    public static int countCommas(int n) {
        return n < 1000 ? 0 : (n - 999);
    }

    public static void main(String[] args) {
        System.out.println(countCommas(15623));
    }
}
