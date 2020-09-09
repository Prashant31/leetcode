import java.util.Arrays;

/**
 * 198. House Robber
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed, the only constraint stopping you
 * from robbing each of them is that adjacent houses have security system
 * connected and it will automatically contact the police if two adjacent houses
 * were broken into on the same night.
 * <p>
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight without
 * alerting the police.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 * <p>
 * Input: nums = [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5
 * (money = 1). Total amount you can rob = 2 + 9 + 1 = 12.
 */
public class HouseRobber {

  public static int maxLoot(int[] nums) {
    int[] dp = new int[nums.length];
    Arrays.fill(dp, -1);
    return lootHouse(nums, 0, dp);
  }

  private static int lootHouse(int[] nums, int i, int[] dp) {
    if (i >= nums.length) {
      return 0;
    }
    if (dp[i] == -1) {
      dp[i] = Math.max(nums[i] + lootHouse(nums, i + 2, dp), lootHouse(nums, i + 1, dp));
    }
    return dp[i];
  }

  public static int maxLootBottomUp(int[] nums) {

    if (nums.length == 0) {
      return 0;
    }

    if (nums.length == 1) {
      return nums[0];
    }
    int[] dp = new int[nums.length + 1];
    dp[0] = 0;
    dp[1] = nums[0];

    for (int i = 2; i <= nums.length; i++) {
      dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
    }
    printHouseRobbed(nums, dp);
    return dp[nums.length];
  }

  private static void printHouseRobbed(int[] nums, int[] dp) {
    int i = nums.length;
    while (i - 2 > 0) {
      if (dp[i] == dp[i - 2] + nums[i - 1]) {
        System.out.println("House Robbed :" + nums[i - 1]);
        i = i - 2;
      } else {
        i = i - 1;
      }
    }
    System.out.println("House Robbed :" + nums[i - 1]);
  }



  public static void main(String[] args) {
    //    System.out.println(maxLoot(new int[]{2,7,9,3,1}));
    System.out.println(maxLootBottomUp(new int[] {1, 2, 3, 1}));
  }

}
