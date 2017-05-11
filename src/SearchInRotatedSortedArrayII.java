
public class SearchInRotatedSortedArrayII {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 1};
        System.out.println(search(nums, 3));
    }
    
    public static boolean search(int[] nums, int target) {
        /**思路：这道题思路比较难，其实如果没有重复值的时候，如果选定了mid之后，
         * mid左侧和右侧必有一边是严格排序的，故而搜索有顺序的那一边，
         * 如果可以搜到，结束；
         * 如果搜不到，按照上述方法处理未排序的一边
         * 这种方法可以用来解决SearchSortedRotatedArray
         * 那么有重复值，会出现nums[left] == nums[mid]，只要自增left就可以了
         * **/
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // 每次循环都要比较以确保不会漏掉mid处值刚好target的情况
            if (nums[mid] == target) return true;
            
            // 如果左边是准确排序的
            if (nums[left] < nums[mid]) {
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[left] > nums[mid]) {   
                // 此处表示右侧部分是rotated，那么下个部分就循环这一块
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                // 到了这里，表示nums[left] == nums[mid]，有重复值
                // 所以，为了除去重复值，我们让left指针自增
                left++;
            }
        }
        
        return false;
    }
    
}
