public class ReverseNumber {
    static int sum = 0;
    static int reverseNumber(int n){
        if(n == 0){
            return 0;
        }
        int rem = n % 10;
        sum = sum * 10 + rem;
        return reverseNumber(n / 10);
    }

    public static void main(String[] args) {
        int n = 5432;
        reverseNumber(n);
        System.out.println(sum);
    }
}
