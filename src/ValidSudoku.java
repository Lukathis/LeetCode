import java.util.HashSet;

/***
 * 
 * @author Chi
 *
 * 思路：写得比较简单，就是判断行，判断列，判断3*3小格子
 * 
 */

public class ValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            HashSet<Integer> map = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' ) {
                    int tmp = Integer.valueOf(board[i][j]);
                    if (map.contains(tmp)) return false;
                    map.add(tmp);
                }
            }
        }
        
        for (int i = 0; i < 9; i++) {
            HashSet<Integer> map = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.' ) {
                    int tmp = Integer.valueOf(board[j][i]);
                    if (map.contains(tmp)) return false;
                    map.add(tmp);
                }
            }
        }
        
        // check each 3*3 board, m and n means the top-left grid of every 3*3 board
        for (int m = 0; m < 9; m += 3) {
            for (int n = 0; n < 9; n += 3) {
                HashSet<Integer> map = new HashSet<>();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        int ii = i + m;
                        int jj = j + n;
                        if (board[ii][jj] != '.' ) {
                            int tmp = Integer.valueOf(board[ii][jj]);
                            if (map.contains(tmp)) return false;
                            map.add(tmp);
                        }
                    }
                }
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
    }
}
