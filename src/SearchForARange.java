
public class SearchForARange {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,4,5};
        int target = 3;
        System.out.println(searchRange(nums, target));
    }
    
    public static int searchRange(int[] nums, int target) {
        int a = search(nums, 0, nums.length - 1, target);
        return a;
    }
    
    public static int search(int[] nums, int left, int right, int target) {
        int mid = (left + right) / 2;
        if (left == mid) {
            if (target <= nums[mid]) {
                return mid;
            } else {
                return mid + 1;
            }
        }
        
        if (target != nums[mid]) {
            if (target < nums[mid]) {
                return search(nums, left, mid, target);
            } else {
                return search(nums, mid, right, target);
            }
        } else {
            return mid;
        }
    }
}
