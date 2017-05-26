
public class MoveZeros {
    public void moveZeroes(int[] nums) {
        /* 思路：
        类似27. Remove Element，先删掉重复元素0，
        最后原数组有多少个0补多少个0。
        */
        int p = 0;
            int count = 0;
            int l = nums.length;
        
        for (int i = 0; i < l; i++){
            if (nums[i] == 0){
                count += 1;
            }else{
                nums[p] = nums[i];
                p++;
            }
        }
        //补0
        for (int j = 0; j < count; j++){
            nums[j + p] = 0;
        }
        
    }
}
