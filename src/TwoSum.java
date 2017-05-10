
public class TwoSum {
    public static void main(String[] args) {
        
    }
    
    public static int[] towSum(int[] nums, int target) {
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
}
