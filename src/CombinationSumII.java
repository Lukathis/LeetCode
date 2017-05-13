import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public static void main(String[] args) {
        int[] candidates = new int[]{1, 1, 1, 1, 1, 1, 2};
        int target = 4;
        System.out.println(combinationSum2(candidates, target));
    }
    
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        /**思路：实际采用的方法还是回溯，只不过在每次状态转移的时候多加了一个判断。跟之前的主要有两个不同，
         * 1. backtrack的时候，最后一个参数，即下一次开始取值的开始坐标从i变成i + 1，表示不包括自己。
         * 2. 多在for循环里加了一个判断，如果往里添加的元素不是本次backtrack的第一个元素的时候，如果与前一个元素相同，则跳过，以免重复。
         * 注意，此处只是跳出本次循环元素并不是跳出整个循环，故而用continue。**/
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        
        backtrack(list, new ArrayList<Integer>(), candidates, target, 0);
        return list;
    }
    
    public static void backtrack(List<List<Integer>> list, List<Integer> tmp, int[] nums, int remain, int start) {
        if (remain < 0) return;
        if (remain == 0) {
            list.add(new ArrayList<>(tmp));
        } else {
            for (int i = start; i < nums.length; i++) {
                if (i > start && nums[i] == nums[i -1]) continue;
                tmp.add(nums[i]);
                backtrack(list, tmp, nums, remain - nums[i], i + 1);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
