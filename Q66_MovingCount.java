/**
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7=18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8=19。请问该机器人能够达到多少个格子？
 */
public class Q66_MovingCount {
    public int movingCount(int threshold, int rows, int cols) {
        boolean[] visited = new boolean[rows * cols];
        return movingCountCore(threshold, rows, cols, 0, 0, visited);
    }

    private int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return 0;
        }
        int i = row * cols + col;
        // 如果已经经过或者坐标和大于要求的k值则返回0
        if (visited[i] || !checkSum(threshold, row, col)) {
            return 0;
        }
        visited[i] = true;
        // 往当前位置上下左右四个方向移动
        return 1 + movingCountCore(threshold, rows, cols, row, col + 1, visited) +
                movingCountCore(threshold, rows, cols, row, col - 1, visited) +
                movingCountCore(threshold, rows, cols, row + 1, col, visited) +
                movingCountCore(threshold, rows, cols, row - 1, col, visited);
    }

    // 判断当前位置坐标和是否小于等于要求的k值
    private boolean checkSum(int threshold, int row, int col) {
        int sum = 0;
        while (row != 0) {
            sum += row % 10;
            row = row / 10;
        }
        while (col != 0) {
            sum += col % 10;
            col = col / 10;
        }
        return sum <= threshold;
    }
}
