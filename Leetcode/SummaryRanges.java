/**
 *
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 *
 */

public class SummaryRanges {
  public List<String> summaryRanges(int[] nums) {
    List<String> ranges = new ArrayList<String>();

    if (nums.length == 0) {
      return ranges;
    }

    String str = Integer.toString(nums[0]);

    if (nums.length == 1) {
      ranges.add(str);
      return ranges;
    }

    for (int i = 1; i < nums.length; i++) {
      if (nums[i] != nums[i-1] + 1) {
        String lastStr = Integer.toString(nums[i-1]);
        if (lastStr.compareTo(str) != 0)
          str = str + "->" + lastStr;
        ranges.add(str);
        str = Integer.toString(nums[i]);
      }

      if (i == nums.length - 1) {
        String lastStr = Integer.toString(nums[i]);
        if (lastStr.compareTo(str) != 0)
          str = str + "->" + lastStr;
        ranges.add(str);
      }
    }
    return ranges;
  }
}