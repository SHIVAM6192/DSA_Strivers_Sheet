package BinarySearch;

public class SqrtOfx {
    public static void main(String[] args) {
        System.out.println(mySqrt(4));
    }
    public static int mySqrt(int x) {
        if(x < 2) return x;

        int left = 0;
        int right = x / 2;

        while(left <= right){
            int mid = left + (right - left) / 2;
            long sqrt = (long) mid * mid;

            if(sqrt == x){
                return mid;
            }
            else if(sqrt < x){
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return right;
    }
}
