import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(generateParenthesis(n));
    }
    
    public static List<String> generateParenthesis(int n) {
        /**那么其实这道题就是一个状态空间的搜索。
         * 深度优先，先优先添加左括号，
         * 当左括号用完后加右括号，
         * 只要右括号比左括号少就添加，
         * 直到左括号和右括号都添加完毕后，
         * 到底，回溯，自然地就拿掉了最后添加的左括号，
         * 开始添加右括号，从而完成整个状态空间的搜索。**/
        List<String> res = new ArrayList<>();
        return(backTrace(n, 0, 0, "", res));
    }
    
    public static List<String> backTrace(int n, int left, int right, String s, List<String> res) {
        
        if (left < n) {
            backTrace(n, left + 1, right, s + "(", res);
        } 
        
        if (right < left){
            backTrace(n, left, right + 1, s + ")", res);
        } 
        
        if (s.length() == n * 2){
            res.add(s);
        }
        return res;
    }
    
}
