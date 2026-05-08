import java.util.HashSet;

public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(isHappy(199));
    }
    public static boolean isHappy(int n) {
        HashSet<Integer> usedNumber = new HashSet<>();

        while(true){
            int sum = 0;
            while(n!=0){
                sum += Math.pow(n % 10, 2.0);
                n = n / 10;
            }
            if(sum == 1) return true;

            n = sum;
            if(usedNumber.contains(sum)){
                return false;
            }
            usedNumber.add(sum);
        }
    }
}
