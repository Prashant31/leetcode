import java.util.Arrays;

/**
 * Problem#70
 * You are climbing a stair case. It takes n steps to reach to the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 * <p>
 * Example 1:
 * <p>
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 * <p>
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */
public class ClimbingStairs {

  public static int maxWays(int stairs) {
    int[] dp = new int[stairs + 1];
    Arrays.fill(dp, -1);
    return maxWays(0, stairs, dp);
  }

  private static int maxWays(int start, int stairs, int[] dp) {
    if (start > stairs) {
      return 0;
    }

    if (start == stairs) {
      return 1;
    }
    if (dp[start] == -1) {
      dp[start] = maxWays(start + 1, stairs, dp) + maxWays(start + 2, stairs, dp);
    }
    return dp[start];
  }

  public static int maxWaysBottomUp(int stairs) {
    if (stairs < 3) {
      return stairs;
    }
    int[] dp = new int[stairs + 1];
    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 2;

    for (int i = 3; i < stairs + 1; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[stairs];
  }

  public static void main(String[] args) {
    System.out.println(maxWays(6));
    System.out.println(maxWaysBottomUp(6));
  }
}
