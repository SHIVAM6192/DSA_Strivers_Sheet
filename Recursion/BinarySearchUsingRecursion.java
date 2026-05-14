public class BinarySearchUsingRecursion {
    public static void main(String[] args) {
        int[] arr = {1, 4, 6, 8, 88, 95, 100, 101};
        int target = 95;
        System.out.println(binarySearch(arr, target, 0, arr.length - 1));
    }

    public static int binarySearch(int[] arr, int target, int s, int e){
        if(s > e){
            return -1;
        }
        int m = s + (e - s) / 2;
        if(arr[m] == target){
            return m;
        }
        if(arr[m] > target){
            return binarySearch(arr, target, s, m -1);
        }
        return binarySearch(arr, target, s + 1, e);
    }
}
