/**
 * Problem # 72
 * Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
 * <p>
 * You have the following 3 operations permitted on a word:
 * <p>
 * Insert a character
 * Delete a character
 * Replace a character
 * Example 1:
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * <p>
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 * <p>
 * Example 2:
 * <p>
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 */

public class EditDistance {

  public static int editDistance(String word1, String word2) {
    int[][] distances = new int[word1.length() + 1][word2.length() + 1];

    for (int i = 0; i <= word1.length(); i++) {
      for (int j = 0; j <= word2.length(); j++) {
        if (i == 0 || j == 0) {
          distances[i][j] = i + j;
        } else {
          int insertion = distances[i][j - 1] + 1;
          int deletion = distances[i - 1][j] + 1;
          if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
            distances[i][j] = Math.min(distances[i - 1][j - 1], Math.min(insertion, deletion));
          } else {
            distances[i][j] = Math.min(distances[i - 1][j - 1] + 1, Math.min(insertion, deletion));
          }
        }
      }
    }

    return distances[word1.length()][word2.length()];
  }

  public static void main(String[] args) {
    System.out.println(editDistance("horse", "ros"));
    System.out.println(editDistance("intention", "execution"));
  }
}
