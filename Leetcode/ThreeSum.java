public class ThreeSum {
	// O(n^2) runtime
	// O(1) space
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> results = new ArrayList<>();
		Arrays.sort(nums);
		int i = 0;
		while (i < nums.length) {
			if (i > 0 && nums[i] == nums[i-1]) {
				i++;
				continue;
			}
			int sum = - nums[i];
			int lo = i+1;
			int hi = nums.length - 1;
			while (lo < hi) {
				if (nums[lo] + nums[hi] == sum) {
					int num1 = nums[lo];
					int num2 = nums[hi];
					while (lo < hi && nums[lo] == num1) lo++;
					while (lo < hi && nums[hi] == num2) hi--;
				} else if (nums[lo] + nums[hi] < sum) {
					lo++;
				} else {
					hi--;
				}
			}

			i++;
		}
		return results;
	}
}