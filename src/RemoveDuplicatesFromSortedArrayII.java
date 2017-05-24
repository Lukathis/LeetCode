
public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        /* 思路：
        基本与Remove Duplicates from Sorted Array差不多，只是加了一个计数器counter，
        保证每个元素出现次数不会超过两次。
        */
        if (nums.length < 2) return nums.length;
        
        int counter = 1;
        int temp = 0;
        int prev = 1;
        int n = nums.length;
        
        while(prev < n) {
            if (nums[prev] == nums[temp] && counter < 2) {
                nums[++temp] = nums[prev];
                counter++;
            }
            if (nums[prev] != nums[temp]) {
                nums[++temp] = nums[prev];
                counter = 1;
            }
            prev++;
        }
        return temp + 1;
    }
}
