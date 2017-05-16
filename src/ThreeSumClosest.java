import java.util.Arrays;

/**思路基本思路就是3Sum的思路，先排序，然后一次扫描，在接下来的序列中用两个指针，像目标和靠拢。
 * 过程中记录最接近target的sum值，并在最后输出。
 * **/

public class ThreeSumClosest {
    public static void main(String[] args) {
        int nums[] = new int[]{-1, 2, 1, -4};
        int target = 1;
        System.out.println(threeSumClosest(nums, target));
    }

    public static int threeSumClosest(int[] nums, int target) {

        int result = 0;
        int num = nums.length;
        int sum = 0;
        
        // 初始化，对nums排序
        Arrays.sort(nums);
        result = nums[0] + nums[1] + nums[2];
        
        for (int i = 0; i < num - 2; i++) {
            int low = i + 1;
            int high = num - 1;
            while(low < high) {
                sum = nums[i] + nums[low] + nums[high];
                if (sum == target) return target;
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                    if (sum == target) return result;
                }
                if (sum < target) {
                    low++;
                } else {
                    high--;
                }
            }
        }
        return result;
    }
}
