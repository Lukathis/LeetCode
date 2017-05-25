
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        /* 思路：只有非val值要向前移动，而移动的步数即是其前面有多少个val值
        */
        int valCount = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == val) {
                valCount++;
            } else {
                nums[i - valCount] = nums[i];
            }
        }
        return n - valCount; 
    }
}
