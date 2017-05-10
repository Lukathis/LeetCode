import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        int target = 8;
        
        int[] res = twoSumWithHashMap(nums, target);
        
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        
    }
    
    /** 两重循环暴力求解 **/
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int len = nums.length;
        
        result[0] = 0;
        result[1] = 0;
        
        if (nums == null || len < 2)
            return result;

        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1;j < len; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }
    
    /** 用HashMap求解效率更高 **/
    public static int[] twoSumWithHashMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);        
        } throw new IllegalArgumentException("No solution");
    }
}
