
public class SearchForARange {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] res = searchRange(nums, target);
        System.out.println(res[0]+ " " + res[1]);
    }
    
    public static int[] searchRange(int[] nums, int target) {
        int a = firstGreaterThan(nums, 0, nums.length, target);
        int b = firstGreaterThan(nums, 0, nums.length, target + 1);
        int[] c = new int[]{a, b - 1};
        if (nums[a] != target || nums[b] != target) return new int[]{-1, -1};
        return c;
    }
    
    public static int firstGreaterThan(int[] nums, int left, int right, int target) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
