public class SlidingWindowMax {
    // Brute force solution. Time complexity O(nk) where 
    // n is nums.length
    // k is window size
    public static int[] maxSlidingWindowBruteForce(int[] nums, int k) {
        if (nums.length == 0) { return new int[0]; }
        int[] maxArr = new int[nums.length-k+1];

        for (int i = 0; i < maxArr.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                int num = nums[j];
                if (num > max) {
                    max = num;
                }
            }
            maxArr[i] = max;
        }
        return maxArr;
    }

    // More efficient O(nlog k)
    // But needs auxilary max heap
    public static int[] maxSlidingWindow(int[] nums, int k) {
        
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] sols = maxSlidingWindow(nums, k);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(i);
        }
    }
}
