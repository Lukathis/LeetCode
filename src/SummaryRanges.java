/***
 * 
 * 这一题没什么难度，就是纯粹的向后扫描，关键是：
 * 1. 如果集合为空的时候需要特别处理
 * 2. 因为需要跟相邻元素比较，故需要注意数组的下标不能越界
 */

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> list=new ArrayList();
          
        if (nums.length == 0) return list;

          int k = 0;
          while (k < nums.length) {
              int flag = nums[k];
              
              while (k < nums.length - 1 && nums[k + 1] - nums[k] == 1) k++;
              if (flag == nums[k]) {
                  list.add(nums[k] + "");
              } else {
                  list.add(flag + "->" + nums[k]);
              }
              k++;
          }
          
          return list;
      }
}
