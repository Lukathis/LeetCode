/***
 * 
 * @author Chi
 * 思路：
 * 1. 先统计下第一行、第一列是否有0，并记录
 * 2. 扫描除了第一行和第一列的所有内容，如果有0，则把它对应的在第一行和第一列处元素设为0，可以避免边扫描边改变元素导致的重复
 * 3. 根据上一遍扫面标记的第一行和第一列的所有0元素，把对应的行/列设为0
 * 4. 根据第一次的记录，如果第一行、第一列本来就有0，把第一行/第一列全部设置为0
 */
public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 0}};
        setZeroes(matrix);
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static void setZeroes(int[][] matrix) {
        // count the number of rows and columns
        int row = matrix.length;
        if (row == 0) return;
        int col = matrix[0].length;
        if (col == 0) return;
        
        // identify whether there's zeroes in the first row
        boolean rowzero = false, colzero = false;
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) {
                colzero = true;
                break;
            }
        }
        for (int i = 0; i < col; i++) {
            if (matrix[0][i] == 0) {
                rowzero = true;       
                break;
            }
        }
        
        // find out the zeroes inside the matrix
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        // set zeroes
        for (int i = 1; i < row; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < col; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        for (int i = 1; i < col; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < row; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        
        // set the first row/col
        if (colzero) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
        
        if (rowzero) {
            for (int i = 0; i < col; i++) {
                matrix[0][i] = 0;
            }
        }
    }
}
