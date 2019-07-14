/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
 * 例如
 * a b c e
 * s f c s
 * a d e e
 * 这样的3×4矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */
public class Q65_HasPath {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        int[] flag = new int[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (hasPathCore(matrix, rows, cols, i, j, str, 0, flag)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasPathCore(char[] matrix, int rows, int cols, int i, int j, char[] str, int k, int[] flag) {
        // 当前位置在char[]数组中的索引
        int index = i * cols + j;
        if (i < 0 || i >= rows || j < 0 || j >= cols || matrix[index] != str[k] || flag[index] == 1) {
            return false;
        }
        // 查找完路径返回true
        if (k == str.length - 1) {
            return true;
        }
        // 将经过的字符标志置1
        flag[index] = 1;
        // 判断当前位置上下左右四个方向的字符与路径下一个字符是否匹配
        if (hasPathCore(matrix, rows, cols, i - 1, j, str, k + 1, flag) ||
                hasPathCore(matrix, rows, cols, i + 1, j, str, k + 1, flag) ||
                hasPathCore(matrix, rows, cols, i, j - 1, str, k + 1, flag) ||
                hasPathCore(matrix, rows, cols, i, j + 1, str, k + 1, flag)) {
            return true;
        }
        // 不匹配则将当前字符标志置0，回退重新查找其他字符
        flag[index] = 0;
        return false;
    }
}
