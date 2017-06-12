/***
 * 
 * @author Chi
 * 
 * 上述是最简单的解法，用扫描的方法，不过效率很低，有待改进！
 * 
 */
public class ProductOfArrayExceptSelf {
    public boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0) return true;
        
        int k = 0;      // 指向t的指针
        
        for (int i = 0; i < t.length(); i++) {
            if (k > s.length()) return true;
            if (k == s.length() - 1 && s.charAt(k) == t.charAt(i)) return true;
            if (s.charAt(k) == t.charAt(i)) k++;
        }
        return false;
    }
}
