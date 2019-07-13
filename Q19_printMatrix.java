import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字.
 * 例如，如果输入如下4×4矩阵：
 * 01 02 03 04
 * 05 06 07 08
 * 09 10 11 12
 * 13 14 15 16
 * 则依次打印出数字1，2，3，4，8，12，16，15，14，13，9，5，6，7，11，10。
 */
public class Q19_printMatrix {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return list;
        }
        printCircle(matrix, 0, matrix.length - 1, 0, matrix[0].length - 1, list);
        return list;
    }

    private void printCircle(int[][] matrix, int startRow, int endRow, int startCol, int endCol, ArrayList<Integer> list) {
        if (startRow < endRow && startCol < endCol) {
            // 从左往右
            for (int j = startCol; j <= endCol; j++) {
                list.add(matrix[startRow][j]);
            }
            // 从上到下
            for (int i = startRow + 1; i <= endRow - 1; i++) {
                list.add(matrix[i][endCol]);
            }
            // 从右往左
            for (int j = endCol; j >= startCol; j--) {
                list.add(matrix[endRow][j]);
            }
            // 从下到上
            for (int i = endRow - 1; i >= startRow + 1; i--) {
                list.add(matrix[i][startCol]);
            }
            // 循环内一圈
            printCircle(matrix, startRow + 1, endRow - 1, startCol + 1, endCol - 1, list);
        } else if (startRow == endRow && startCol < endCol) {
            // 如果最后只剩一行，则从左往右
            for (int j = startCol; j <= endCol; j++) {
                list.add(matrix[startRow][j]);
            }
        } else if (startRow < endRow && startCol == endCol) {
            // 如果最后只剩一列，则从上到下
            for (int i = startRow; i <= endRow; i++) {
                list.add(matrix[i][startCol]);
            }
        } else if (startRow == endRow && startCol == endCol) {
            // 如果最后只剩一个，则添加该元素
            list.add(matrix[startRow][startCol]);
        } else {
            return;
        }
    }
}
