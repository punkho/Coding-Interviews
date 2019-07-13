/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Q01_MatrixFind {
    public boolean matrixFind(int target, int[][] array) {
        int row = 0;
        int col = array[0].length - 1;
        while (row < array.length && col >= 0) {
            if (array[row][col] == target) {
                // 如果右上角的数等于target，返回true
                return true;
            } else if (array[row][col] > target) {
                // 如果大于target，向左移动
                col--;
            } else {
                // 如果小于target，向下移动
                row++;
            }
        }
        return false;
    }
}
