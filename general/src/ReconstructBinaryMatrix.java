import java.util.Arrays;

/**
 * Problem#1253
 * Reconstruct a 2-Row Binary Matrix
 * <p>
 * Given the following details of a matrix with n columns and 2 rows :
 * <p>
 * The matrix is a binary matrix, which means each element in the matrix can be
 * 0 or 1. The sum of elements of the 0-th(upper) row is given as upper. The sum
 * of elements of the 1-st(lower) row is given as lower. The sum of elements in
 * the i-th column(0-indexed) is colsum[i], where colsum is given as an integer
 * array with length n. Your task is to reconstruct the matrix with upper, lower
 * and colsum.
 * <p>
 * Return it as a 2-D integer array.
 * <p>
 * If there are more than one valid solution, any of them will be accepted.
 * <p>
 * If no valid solution exists, return an empty 2-D array.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: upper = 2, lower = 1, colsum = [1,1,1]
 * Output: [[1,1,0],[0,0,1]]
 * Explanation: [[1,0,1],[0,1,0]], and [[0,1,1],[1,0,0]] are also correct
 * answers. Example 2:
 * <p>
 * Input: upper = 2, lower = 3, colsum = [2,2,1,1]
 * Output: []
 * Example 3:
 * <p>
 * Input: upper = 5, lower = 5, colsum = [2,1,2,0,1,0,1,2,0,1]
 * Output: [[1,1,1,0,1,0,0,1,0,0],[1,0,1,0,0,0,1,1,0,1]]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= colsum.length <= 10^5
 * 0 <= upper, lower <= colsum.length
 * 0 <= colsum[i] <= 2
 */
public class ReconstructBinaryMatrix {

  public static int[][] reconstructMatrix(int upper, int lower, int[] colsum) {
    int[][] matrix = new int[2][colsum.length];
    int upperSum = 0;
    int lowerSum = 0;
    for (int i = 0; i < colsum.length; i++) {
      if (colsum[i] == 2) {
        matrix[0][i] = 1;
        matrix[1][i] = 1;
        upperSum++;
        lowerSum++;
        if (upper < upperSum || lower < lowerSum) {
          return new int[][] {};
        }
      } else if (colsum[i] == 0) {
        matrix[0][i] = 0;
        matrix[1][i] = 0;
      }
    }

    for (int i = 0; i < colsum.length; i++) {
      if (colsum[i] == 1) {
        if (upperSum < upper) {
          matrix[0][i] = 1;
          matrix[1][i] = 0;
          upperSum++;
        } else if (lowerSum < lower) {
          matrix[0][i] = 0;
          matrix[1][i] = 1;
          lowerSum++;
        } else {
          return new int[][] {};
        }
      }
    }
    return matrix;
  }

  public static void main(String[] args) {
    int[][] matrix1 = reconstructMatrix(2, 1, new int[] {1, 1, 1});
    System.out.println(Arrays.deepToString(matrix1));

    int[][] matrix2 = reconstructMatrix(5, 5, new int[] {2, 1, 2, 0, 1, 0, 1, 2, 0, 1});
    System.out.println(Arrays.deepToString(matrix2));
  }
}
