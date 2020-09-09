/**
 * Problem #1047
 * <p>
 * Given a string S of lowercase letters, a duplicate removal consists of
 * choosing two adjacent and equal letters, and removing them. We repeatedly
 * make duplicate removals on S until we no longer can. Return the final string
 * after all such duplicate removals have been made.  It is guaranteed the
 * answer is unique.
 */
public class RemoveAdjacentDuplicates {

  public static String removeDuplicates(String s) {
    String result = s;
    int pointer = 0;
    while (pointer + 1 < result.length()) {
      if (result.charAt(pointer) == result.charAt(pointer + 1)) {
        result = result.substring(0, pointer) + result.substring(pointer + 2);
        pointer = 0;
      } else {
        pointer++;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(removeDuplicates("abbaca"));
  }
}
