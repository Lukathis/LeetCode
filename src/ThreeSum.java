import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;


public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }
    
    public static List<List<Integer>> threeSum(int[] nums) {
        /** 思路: 先把元素都排序，扫描一次，每次在剩下的元素中利用已排序的2Sum方法，
         * 寻找剩下的元素中是否有两个元素的和等于0 - nums[i]。
       **/
       Arrays.sort(nums);
       List<List<Integer>> result = new ArrayList<>();
       
       for (int i = 0; i < nums.length - 2; i++) {
           if (i > 0 && nums[i] == nums[i-1]) continue;                              //如果下一个元素与前一个元素相同，跳过重复
           
           int low = i + 1;
           int high = nums.length - 1;
           int complement = 0 - nums[i];
           int pairSum = 0;
           while (low < high) {
               pairSum = nums[low] + nums[high];
               if (pairSum < complement) low++;
               if (pairSum > complement) high--;
               if (pairSum == complement) {
                   result.add(Arrays.asList(nums[i], nums[low++], nums[high--]));
                   while(low < high && nums[low] == nums[low - 1]) low++;            //如果下一个元素与前一个元素相同，跳过重复
                   while(high > low && nums[high] == nums[high + 1]) high--;         //如果下一个元素与后一个元素相同，跳过重复，千万注意这边是递减！
               }
           }
       }
       return result;
    }
}
