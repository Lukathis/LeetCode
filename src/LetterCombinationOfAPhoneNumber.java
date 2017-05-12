import java.util.LinkedList;
import java.util.List;

public class LetterCombinationOfAPhoneNumber {
    public static void main(String[] args) {
        String digits = "234";
        System.out.println(letterCombinations(digits));
    }
    
    public static List<String> letterCombinations(String digits) {
        /**思路：
         * 最后实现的思路是借鉴discussion中的一个思路，利用先进先出队列。
         * 根据输入的digits长度决定循环次数，每次进来新的数字，则从头部把之前的字符串拿出来，记为t，
         * 根据目前的数字情况，向t的尾部加入新的字符串后从尾部加入刚刚的队列中，
         * 直到之前的字符串全部都已经被取出并添加了尾巴后为止。**/
        LinkedList<String> res = new LinkedList<String>();
        String[] map = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        if (digits == null || digits.length() < 1) return res;
        res.add("");
        
        for (int i = 0; i < digits.length(); i++) {
            int x = Integer.valueOf(digits.charAt(i)) - 48;
            while(res.peek().length() == i) {
                String t = res.remove();
                for (char s : map[x].toCharArray()) {
                    res.add(t + s);
                }
            }
        }
        return res;
    }
}
