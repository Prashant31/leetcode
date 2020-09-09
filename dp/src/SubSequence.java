import java.util.Arrays;

/**
 * 392. Is Subsequence
 *
 * Given a string s and a string t, check if s is subsequence of t.
 *
 * A subsequence of a string is a new string which is formed from the original
 * string by deleting some (can be none) of the characters without disturbing
 * the relative positions of the remaining characters. (ie, "ace" is a
 * subsequence of "abcde" while "aec" is not).
 *
 * Follow up:
 * If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you
 * want to check one by one to see if T has its subsequence. In this scenario,
 * how would you change your code?
 *
 * Example 1:
 *
 * Input: s = "abc", t = "ahbgdc"
 * Output: true
 *
 * Example 2:
 *
 * Input: s = "axc", t = "ahbgdc"
 * Output: false
 */
public class SubSequence {

  public static boolean isSubsequence(String s, String t) {
    int[][] distances = new int[t.length() + 1][s.length() + 1];
    for (int[] row : distances) {
      Arrays.fill(row, -1);
    }

    for (int i = 0; i <= t.length(); i++) {
      for (int j = 0; j <= s.length(); j++) {
        if (i == 0 || j == 0) {
          distances[i][j] = i + j;
        } else {
          if (t.charAt(i - 1) == s.charAt(j - 1)) {
            distances[i][j] = Math.min(distances[i - 1][j - 1], distances[i - 1][j] + 1);
          } else {
            distances[i][j] = distances[i - 1][j] + 1;
          }
        }
      }
    }

    return distances[t.length()][s.length()] == t.length() - s.length();
  }



  public static void main(String[] args) {
    System.out.println(isSubsequence("ahbgdc", "abc"));
    System.out.println(isSubsequence("ahbgdc", "axc"));
  }
}
