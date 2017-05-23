
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        /* 思路：
        维护两个指针，temp从0开始，prev从1开始，temp指向新数组的末端，prev扫描原数组，
        如果prev所指元素与temp不同，则temp加1，对应元素为prev所指元素，
        prev++继续扫描。
        */
        if (nums == null || nums.length == 0) return 0;
        
        int temp = 0;
        int prev = 1;
        int n = nums.length;
        
        while(prev < n) {
            if (nums[prev] != nums[temp]) nums[++temp] = nums[prev];
            prev++;
        }
        return temp + 1;
    }
}
