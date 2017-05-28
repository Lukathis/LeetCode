
public class Candy {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) return 0;
        
        int n = ratings.length;
        int result = 0;
        
        // 此处数组初始化为最少可以拿0颗糖，最后输出的时候只要再+1即可。
        int[] nums = new int[n];
        
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                nums[i] = nums[i - 1] + 1;
            }
        }
        
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                nums[i] = Math.max(nums[i + 1] + 1, nums[i]);
            }
        }
        
        for (int i = 0; i < n; i++) {
            result += nums[i];
        }
        
        result += n;
        return result;
    }
}
