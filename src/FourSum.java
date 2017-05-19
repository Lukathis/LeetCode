import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        /** 思路: 在3Sum的基础上进行修改,
         * 4Sum基本思路是在3Sum的基础上再套一层循环，
         * 然后在右边剩下的元素中寻找3Sum，难度不大，
         * 但是要特别注意元素重复这种情况的处理。
        **/
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        
        for (int k = 0; k < nums.length - 3; k++) {
            if (k > 0 && nums[k] == nums[k - 1]) continue;                                //如果下一个元素与前一个元素相同，跳过重复，注意k>0，即第一次不检查
            
            for (int i = k + 1; i < nums.length - 2; i++) {
                if (i > k + 1 && nums[i] == nums[i - 1]) continue;                        //如果下一个元素与前一个元素相同，跳过重复，注意i>k+1，即第一次不检查
                
                int low = i + 1;
                int high = nums.length - 1;
                int complement = target - nums[k] - nums[i];
                int pairSum = 0;
                
                while (low < high) {
                    pairSum = nums[low] + nums[high];
                    if (pairSum < complement) low++;
                    if (pairSum > complement) high--;
                    if (pairSum == complement) {
                        result.add(Arrays.asList(nums[k], nums[i], nums[low++], nums[high--]));
                        while(low < high && nums[low] == nums[low - 1]) low++;            //如果下一个元素与前一个元素相同，跳过重复
                        while(high > low && nums[high] == nums[high + 1]) high--;         //如果下一个元素与后一个元素相同，跳过重复，千万注意这边是递减！
                    }
                }
            }
        }
        return result;
    }
}
