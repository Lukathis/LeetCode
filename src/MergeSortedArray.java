/***
 * 
 * @author Chi
 *
 * 思路：这一题主要也是思路上的，没必要从头开始瞎折腾，尾巴那边空着呢！
 * 另外，考虑到是归并到第一个数组里，故而如果第一个数组长，最后多的那部分序列肯定还是留在最前端，
 * 但万一第二个数组长，那么在第一个数组比完了之后只需要把第二个数组最开头的部分再依次复制到第一组开头即可。
 * 
 */
public class MergeSortedArray {
    public void merge(int[] a, int m, int[] b, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        
        while(i >= 0 && j >= 0) {
            if (a[i] >= b[j]) 
                a[k--] = a[i--];
            else 
                a[k--] = b[j--];
        }
        
        while(j >= 0) {
            a[k--] = b[j--];
        }
    }
}
