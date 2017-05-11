
public class TwoSumII {
    public static void main(String[] args) {
        int[] numbers = new int[]{1, 2, 3, 4, 5, 6};
        int target = 9;
        int[] res = new int[2];
        res = twoSum(numbers, target);
        
        System.out.print(res[0] + " " +  res[1]);
    }
    public static int[] twoSum(int[] numbers, int target) {
        /** 与Two Sum的区别在于给定的是升序排列好的数组，需要寻求目标解，
         * 由于排序只需要NlogN的复杂度，按道理这个的复杂度不应该超过NlogN，否则不优。
         * 思路：low取数列开头，high取最后，如果和小于目标，增加low坐标，和变大，
         * 如果和大于目标，增加high坐标，和变小，依次扫描，不会遗漏。
         **/
       if (numbers == null || numbers.length == 0)
            return null;
                
        // 注意点，数组上标为长度-1        
        int num = numbers.length;
        int low = 0;
        int high = num - 1;
        int total = 0;
            
        while(low < high) {
            total = numbers[low] + numbers[high];
            if (total < target) low++;
            if (total > target) high--;
            if (total == target) return new int[]{low + 1, high + 1};
        }
        return null;
    }
}
