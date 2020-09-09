import java.util.Arrays;

/**
 * Problem#746.
 *
 * Min Cost Climbing Stairs
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0
 * indexed).
 *
 * Once you pay the cost, you can either climb one or two steps. You need to
 * find minimum cost to reach the top of the floor, and you can either start
 * from the step with index 0, or the step with index 1.
 *
 * Example 1:
 * Input: cost = [10, 15, 20]
 * Output: 15
 * Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
 *
 * Example 2:
 * Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * Output: 6
 * Explanation: Cheapest is start on cost[0], and only step on 1s, skipping
 * cost[3].
 */
public class ClimbingStairsCost {

  public static int minCostClimbingStairs(int[] cost) {
    int[] dp = new int[cost.length];
    Arrays.fill(dp, -1);
    return Math.min(calculateCost(cost, 0, dp), calculateCost(cost, 1, dp));
  }

  public static int calculateCost(int[] cost, int stair, int[] dp) {

    if (stair >= cost.length) {
      return 0;
    }

    if (stair == cost.length - 1) {
      return cost[cost.length - 1];
    }

    if (dp[stair] == -1) {
      dp[stair] = cost[stair] + Math.min(calculateCost(cost, stair + 1, dp),
                                         calculateCost(cost, stair + 2, dp));
    }
    return dp[stair];
  }

  public static void main(String[] args) {
    System.out.println(
        minCostClimbingStairs(new int[] {1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
  }
}
