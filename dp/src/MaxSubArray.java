/**
 * Problem#53 Maximum Subarray
 * Given an integer array nums, find the contiguous subarray (containing at
 * least one number) which has the largest sum and return its sum.
 * <p>
 * Follow up: If you have figured out the O(n) solution, try coding another
 * solution using the divide and conquer approach, which is more subtle.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Example 2:
 * <p>
 * Input: nums = [1]
 * Output: 1
 * Example 3:
 * <p>
 * Input: nums = [0]
 * Output: 0
 * Example 4:
 * <p>
 * Input: nums = [-1]
 * Output: -1
 * Example 5:
 * <p>
 * Input: nums = [-2147483647]
 * Output: -2147483647
 */
public class MaxSubArray {

  public static int maxSubArray(int[] nums) {
    int maxSum = Integer.MIN_VALUE;

    for (int i = 0; i < nums.length; i++) {
      int windowSum = nums[i];
      for (int j = i + 1; j < nums.length; j++) {
        windowSum = windowSum + nums[j];
        maxSum = Math.max(windowSum, maxSum);
      }
    }
    return maxSum;
  }

  public static int maxSubArraySum(int[] nums) {
    int max_so_far = Integer.MIN_VALUE, max_ending_here = 0, start = 0, end = 0, s = 0;

    for (int i = 0; i < nums.length; i++) {
      max_ending_here += nums[i];

      if (max_so_far < max_ending_here) {
        max_so_far = max_ending_here;
        start = s;
        end = i;
      }

      if (max_ending_here < 0) {
        max_ending_here = 0;
        s = i + 1;
      }
    }
    System.out.println("Maximum contiguous sum is " + max_so_far);
    System.out.println("Starting index " + start);
    System.out.println("Ending index " + end);
    return max_so_far;
  }

  public static void main(String[] args) {
    //    System.out.println(maxSubArray(new int[] {-2, 1, -3, 4, -1, 2, 1, -5,
    //    4}));
    System.out.println(maxSubArraySum(new int[] {-2, -3, -4}));
  }
}
