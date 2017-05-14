import java.util.ArrayList;
import java.util.List;

    /**思路：比较典型的八皇后问题，可以用回溯法来解。按行循环，关键是判断某一格是否可以放置皇后。那么显然的我们要进行如下判断：
     * 用HashSet来保存每一行已经占用的列号，如果我们填入的位置之前已经有皇后放入这一列，肯定不行。
     * 用另外一个HashSet来存放对角线信息。其实就是把格子投影到对角线上，落在右上到左下投影上同一个格子的计算方法是如果col + row相同，
     * 类似的，落在左上到右下的对角线上同一个格子的计算方法是col - row相同。
     * 第二次改进的时候直接用数组来解决，查询效率更高，故而表现也比HashSet更好。
    因此我们只要保存三个HashSet或者三个Array来记录之前已经放置的信息即可。其他，就交给回溯来解决吧！**/

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
