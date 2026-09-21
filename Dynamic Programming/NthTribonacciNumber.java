// https://leetcode.com/problems/n-th-tribonacci-number
public class NthTribonacciNumber {
    public static int tribonacci(int n) {
        if(n <= 2){
            return (n==0)?0:1;
        }
        int p0 = 0;
        int p1 = 1;
        int p2 = 1;
        int sum = 0;

        for(int i=3; i<=n; i++){
            sum = p0 + p1 + p2;
            p0 = p1;
            p1 = p2;
            p2 = sum;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(4);
    }
}
