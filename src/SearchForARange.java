/***
 * 
 * @author Chi
 *
 * 要在升序数列中找到目标元素的起始位置和终止位置。利用函数firstGreaterThan,找出数组中第一个比目标元素大的数。
 * 具体方法就是用二分查找。由于要招第一个大于target的元素位置，故当nums[mid] < target的时候，left = mid + 1。
 * 否则，right = mid。包括等于的情况，此时让right左移，直到left取到第一个>=target的值，如果仅有一个此元素，
 * 那么最终left会与right重合，如果有多个，left与right仍会逼近，且由于right在相等的情况下仍会左移，故会在
 * left==right的判断条件下跳出，从而保证是最左边那个相等或第一个大于目标值的元素。如果目标值不在nums中，那么
 * 最后返回的left值要么就溢出，即逼近right到nums.length，要么就nums[mid]!=target，此时返回[-1, 1]。
 */
public class SearchForARange {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int target = 11;
        int[] res = searchRange(nums, target);
        System.out.println(res[0]+ " " + res[1]);
    }
    
    public static int[] searchRange(int[] nums, int target) {
        int a = firstGreaterThan(nums, 0, nums.length, target);
        int b = firstGreaterThan(nums, 0, nums.length, target + 1);
        int[] c = new int[]{a, b - 1};
        if (a == nums.length || nums[a] != target) return new int[]{-1, -1};
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
