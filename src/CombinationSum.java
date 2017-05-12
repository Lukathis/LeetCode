import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = new int[]{2, 3, 6, 7};
        int target = 7;
        System.out.println(combinationSum(candidates, target));
    }
    
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        /**思路：
         * 这题的思路和很多求组合的题目其实是类似的，也类似于之前的generate parenthesis，
         * 说白了就是状态空间的探索，不断向下深入，每次新加入元素之后同时改变目标参数，然后回溯即可。
         * 但是这样做效率其实偏低，搜索太多无用状态空间，只能排到前75%，应该可以用DP解提高效率。**/
        
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        
        // 这里backtrack的时候直接设置为void返回类型，由于list是引用变量，故而是“全局”的，直接在方法中改变即可。
        backtrack(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }
    
    public static void backtrack(List<List<Integer>> list, List<Integer> tmp, int[] nums, int target, int start) {
        if (target < 0) return;
        if (target == 0) {
            list.add(new ArrayList<>(tmp)); 
            // 为何上面这里一定要重新定义一个new ArrayList<>()才可以，不可以直接用tmp？
        } else {
            for (int i = start; i < nums.length; i++) {
                tmp.add(nums[i]);
                backtrack(list, tmp, nums, target - nums[i], i);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
