/***
 * 
 * @author Chi
 *
 * 思路：典型八皇后问题，用回溯解决。
 * 但是有一点比较奇怪的是把代码复制到LeetCode之后结果错误，比如n=2时返回1。
 * 如果删掉所有的static修饰，答案就对了，没有搞清楚为什么。
 * 
 */
public class NQueensII {
    static int count = 0;
    
    public static int totalNQueens(int n) {
        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[n * 2];
        boolean[] diag2 = new boolean[n * 2];
        backtrack(0, cols, diag1, diag2, n);
        return count;
    }
    
    public static void backtrack(int row, boolean[] cols, boolean[] diag1, boolean[] diag2, int n) {
        if (row == n) count++;
        
        for (int i = 0; i < n; i++) {
            int d1 = i + row;
            int d2 = i - row + n;
            if (cols[i] || diag1[d1] || diag2[d2]) continue;
            
            cols[i] = true;
            diag1[d1] = true;
            diag2[d2] = true;
            
            backtrack(row + 1, cols, diag1, diag2, n);
            
            cols[i] = false;
            diag1[d1] = false;
            diag2[d2] = false;
        }
    }
    
    public static void main(String[] args) {
        int n = 2;
        System.out.println(totalNQueens(n));
    }
}
