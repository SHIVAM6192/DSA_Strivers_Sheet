package BinarySearch;

// https://takeuforward.org/arrays/find-out-how-many-times-the-array-has-been-rotated
public class FindArrayRotationCount {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2,3};
        System.out.println(findRotations(arr));
    }

    // We just need to find the pivot element from array and that pluse one will be our answer
    public static int findRotations(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while(left < right){
            int mid = left + (right - left) / 2;

            if(arr[mid] > arr[right]){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        return left;
    }
}
