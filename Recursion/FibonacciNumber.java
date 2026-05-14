public class FibonacciNumber {
    public static void main(String[] args) {
        System.out.println(fibonacci(12));
        fibonacciSeries(15);
    }

    public static int fibonacci(int n){
        if(n < 2){
            return n;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void fibonacciSeries(int n){
        int first = 0, second = 1;

        for (int i = 1; i < n; i++){
            System.out.print(first + ", ");
            int temp = first + second;
            first = second;
            second = temp;
        }
    }
}
