
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 5, 1, 2};
        System.out.println(search(nums, 5));
    }
    
    public static int search(int[] nums, int target) {
        /**思路：这道题可以直接先找到最小值，二分查找，
         * 然后用一个映射把它变成严格的升序数组，还是二分查找，
         * 按照以上可以做到O(n lgn)
         * 在做二分查找这类题目时，一定要注意
         * - mid如何取值
         * - 判断后取mid还是mid + 1还是mid - 1
         * - 边界条件如何确定
         * - 目标值在哪里
         * **/
        
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int mid = 0;
        
        while(left < right) {
            mid = (left + right) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;                
            }
        }
        // 获得最小值坐标
        int minIndex = right;
        
        // 除了映射下，其他还是实现了二分查找
        left = 0;
        right = n - 1;
        mid = 0;
        
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (target < nums[map(n, minIndex, mid)]) right = mid - 1;
            else if (target > nums[map(n, minIndex, mid)]) left = mid + 1;
            else return map(n, minIndex, mid);
        }
        
        return -1;
    }
    
    public static int map(int n, int minIndex, int index) {
        int tmp = index + minIndex;
        if (tmp < n) {
            return tmp;
        } else {
            return (tmp - n);
        }
    }
}
