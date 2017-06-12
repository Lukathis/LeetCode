import java.util.HashSet;

/***
 * 
 * @author Chi
 *
 * 思路：这类关于重复啊集合啊这一类的可以直接使用集合类，方便快速，尤其是HashSet，直接用来解决重复这类问题很方便。
 */
public class IntersectionOfTwoArrays {
    public int[] intersection(int[] a, int[] b) {
        /* 思路：利用HashSet+泛型即可 */
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        
        for (int i = 0; i < a.length; i++) {
            set1.add(a[i]);
        }
        
        for (int i = 0; i < b.length; i++) 
            if (set1.contains(b[i]))
                set2.add(b[i]);
                
        int i = 0;
        int n = set2.size();
        int[] result = new int[n];
        for (int k : set2) {
            result[i++] = k;
        }
        return result;
    }
}
