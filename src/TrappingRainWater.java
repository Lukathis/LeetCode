/***
 * 
 * @author Chi
 *
 * 思路：两个指针从外侧往里扫描，记录外围两个指针较小的那个值，记为count，并且移动较小侧的指针往里移动，
 * 每往里移动一个，如果比count小，必然可以积水，则+count-height[i]，如果比count高，则重复上述步骤。
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        if (height.length < 3) return 0;
        
        int result = 0;
        int n = height.length;
        int l = 0;                  // l和r分别为指向height头尾的指针
        int r = n - 1;
        int count = 0;
        
        while (l < r && height[l] < height[l + 1]) l++;
        while (r > l && height[r] < height[r - 1]) r--;
        
        while (l < r) {
            int hl = height[l];
            int hr = height[r];

            if (hl <= hr) {
                if (hl <= count) {
                    result += count - hl;
                    l++;
                } else {
                    count = hl;
                    l++;
                }
                
            } else {
                if (hr <= count) {
                    result += count - hr;
                    r--;
                } else {
                    count = Math.min(hl, hr);
                    r--;
                }
            }
        }
        return result;
    }
}
