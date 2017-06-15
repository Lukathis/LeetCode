import java.util.List;
import java.util.ArrayList;

/*** 
 * 
 * @author Chi
 *
 * 论上本题也是类似的，只不过每次新加一个字符，需要根据其能够跟前面的字符组成多长的回文字符串递推出此时有多少拆分可能。
 * 当没法与之前的字符串组成回文字符串的时候直接去前一个指标的值即可，当可以的时候，则取前一个状态+能够组成的回文字符串即可。
 * 程序实现如下：接下来要注意的无非是状态的记录。细节需要很注意。
 */
public class PalindromePartitioning {
    public static List<List<String>> partition(String s) {
        int len = s.length();
        
        // pal[i][j]用来存储si -> sj这串字符是否为回文字符串
        boolean[][] pal = new boolean[len][len];
        pal[0][0] = true;
        
        // 创建一个数组为每个字符保存它和在它之前的字符串所有的回文划分
        // result长度一定要是len + 1，因为0必须单独空出来，这样如果一开始出现"aa"这种情况，状态需要从空集开始加
        List<List<String>>[] result = new List[len + 1];
        result[0] = new ArrayList<List<String>>();
        result[0].add(new ArrayList<>());
        
        for (int i = 0; i < len; i++) {
            result[i + 1] = new ArrayList<List<String>>();
            for (int left = 0; left <=i; left++) {
                
                if (s.charAt(left) == s.charAt(i) && (i - left <= 1 || pal[left + 1][i - 1] == true)){
                    pal[left][i] = true;
                    // 新回文字符串
                    String subStr = s.substring(left, i + 1);
                    // 取出以left指针所指处结尾时有多少种回文字符子串，加上目前这个子串，构成以i指针所指处为结尾时总字串
                    for (List<String> str : result[left]) {
                        List<String> ri = new ArrayList<String>(str);
                        ri.add(subStr);
                        result[i + 1].add(ri);
                    }
                    
                }
            }
        }
        return result[len];
    }
}
