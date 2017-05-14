import java.util.ArrayList;
import java.util.List;

public class NQueens {
    static boolean[] col;
    static boolean[] diag1;
    static boolean[] diag2;
    
    public static List<List<String>> solveQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        col = new boolean[n];
        diag1 = new boolean[2 * n];
        diag2 = new boolean[2 * n];
        
        backtrack(res, new ArrayList<String>(), 0, n);
        return res;
    }
    
    public static void backtrack(List<List<String>> res, List<String> list, int row, int n) {
        if (row == n) {
            res.add(new ArrayList<String>(list));
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (col[i] || diag1[row + i] || diag2[row - i + n]) {
                continue;
            }
            
            String tmp = new String();
            for (int j = 0; j < n; j++) {
                if (j == i) {
                    tmp += "Q";
                } else {
                    tmp += ".";
                }
            }
            
            list.add(tmp);
            col[i] = true;
            diag1[row + i] = true;
            diag2[row - i + n] = true;
            
            backtrack(res, list, row + 1, n);
            
            list.remove(tmp);
            col[i] = false;
            diag1[row + i] = false;
            diag2[row - i + n] = false;
        }
        
    }
    
    public static void main(String[] args) {
        System.out.println(solveQueens(4));
    }
}
