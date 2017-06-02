/***
 * 
 * @author Chi
 *
 * 思路：
 * 我们先选定最外侧两个柱，形成面积记为maxArea（我们假设左边短一些，右边长一些），
 * 那么如果还有面积更大的话，如果移动较长的那根的话，宽度变短了，但是最大容量还是由刚刚长度较短的那根来决定，这就很蛋疼了，
 * 所以说明把长的那根向中间移动无论如何都不会再有更大的面积了。
 * 那么，在这种情况下，我们将两根中较短的一根向中间移动，还可能获得更大的面积。
 * 以此类推，最终两者重合。在这样一个扫描过程中，一定会遇到一个最大的面积，
 * 而此时，只是扫描了数组一整遍，故复杂度为O(n)。
 */

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = new int[]{1, 2, 3, 4};
        int max = maxArea(height);
        System.out.println(max);
    }
    
    public static int maxArea(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n - 1;
        int maxArea = 0;
        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
