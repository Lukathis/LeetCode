
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        int target = 8;
        
        int[] res = twoSum(nums, target);
        
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        
    }
    
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
}
