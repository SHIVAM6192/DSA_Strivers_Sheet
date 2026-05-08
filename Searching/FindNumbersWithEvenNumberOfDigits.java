public class FindNumbersWithEvenNumberOfDigits {
    public static void main(String[] args) {
        System.out.println(((int)Math.log10(4596) + 1) % 2 == 0);
        System.out.println(Math.log10(8569));
        int[] nums = {12,345,2,6,7896};
        System.out.println(findNumbers(nums));

    }

    public static int findNumbers(int[] nums) {
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if((int)(Math.log10(nums[i]) + 1) % 2 == 0){
                count++;
            }
        }
        return count;
    }
}
