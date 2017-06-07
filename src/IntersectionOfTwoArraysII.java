/***
 * 
 * @author Chi
 *
 * 思路：与Intersection of Two Arrays 类似，只不过这里需要用到重复，故使用HashMap。
 * 注意：熟练操作HashMap的方法，map.containsKey(), map.get(), map.put()
 * 熟练操作ArrayList的方法，list.get(i)；即获得list里下标为i的元素，不可以使用list[i]
 * 另外，需要查一下一般如何将ArrayList转换为数组比较方便
 */

import java.util.ArrayList;
import java.util.HashMap;

public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] a, int[] b) {
        /* 思路：与Intersection of Two Arrays 类似，只不过这里需要用到重复，故使用HashMap */
              
              HashMap<Integer, Integer> map = new HashMap<>();
              ArrayList<Integer> resultList = new ArrayList<>();
              
              for (int i = 0; i < a.length; i++) {
                  if (map.containsKey(a[i])) {
                      map.put(a[i], map.get(a[i]) + 1);
                  } else {
                      map.put(a[i], 1);
                  }
              }
              
              for (int i = 0; i < b.length; i++) {
                  if (map.containsKey(b[i]) && map.get(b[i]) > 0) {
                      resultList.add(b[i]);
                      map.put(b[i], map.get(b[i]) - 1);
                  }
              }
              
              int[] result = new int[resultList.size()];
              for (int i = 0; i < resultList.size(); i++) {
                  result[i] = resultList.get(i);
              }
              
              return result;
          }
}
