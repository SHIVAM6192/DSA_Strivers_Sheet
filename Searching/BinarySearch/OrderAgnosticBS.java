package BinarySearch;

public class OrderAgnosticBS {
    public static void main(String[] args) {
        int[] arr = {-18, -12, -4, 0, 2, 5, 9, 26,78,99};
        int[] arr2 = {101, 91, 76, 55, 50, 3, 1, 0, -5, -10};
        System.out.println(orderAgnosticBS(arr, 9));
        System.out.println(orderAgnosticBS(arr2, 0));
    }

    public static int orderAgnosticBS(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;

        boolean isAsc = arr[start] < arr[end];

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(target == arr[mid]){
                return mid;
            }

            if(isAsc){
                if(target < arr[mid]){
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }
            }
            else{
                if(target > arr[mid]){
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }
            }
        }

        return -1;
    }
}
