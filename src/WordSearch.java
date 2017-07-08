/***
 * 
 * @author Chi
 * 
 * 思路：典型的回溯。
 * 最外层两层循环遍历board中所有格子，如果与第一个字符相等则进入，开始搜索。
 * 进入后，每次判断当前位置是否符合，不符合返回false,相等就继续搜索。
 * 搜索方向一共上下左右四个方向，搜索前判断下是否会溢出，不会的话就继续搜索。
 * 如果相等继续向下，直到搜索到指针指向word最后一个字符还相等，返回true，
 * 其他情况均返回false.
 */

public class WordSearch {
    public static void main(String[] args) {
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = new String("SEE");
        System.out.println(exist(board, word));
    }
    
    public static boolean exist(char[][] board, String word) {
        if (board.length == 0) return false;
        
        int row = board.length;
        int col = board[0].length;
        
        boolean[][] check = new boolean[row][col];
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (backtrack(board, check, i, j, word, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public static boolean backtrack(char[][] board, boolean[][] check, int cori, int corj, String word, int index) {
        if (!check[cori][corj] && board[cori][corj] == word.charAt(index)) {
            check[cori][corj] = true;
            index++;
            
            if (index == word.length()) return true;
            
            int row = board.length;
            int col = board[0].length;
            // top
            if (cori > 0) {
                if (backtrack(board, check, cori - 1, corj, word, index)) return true;
            }
            // right
            if (corj < col - 1) {
                if (backtrack(board, check, cori, corj + 1, word, index)) return true;
            }
            // down 
            if (cori < row - 1) {
                if (backtrack(board, check, cori + 1, corj, word, index)) return true;
            }
            // left
            if (corj > 0) {
                if (backtrack(board, check, cori, corj - 1, word, index)) return true;
            }
            
            // return the status
            check[cori][corj] = false;
            index--;
        }
        return false;
    }
}
