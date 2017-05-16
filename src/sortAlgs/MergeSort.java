package sortAlgs;

public class MergeSort {
    /**归并排序基本思路：
     * 用分治法的思路来做进行排序。
     * 实现merge方法
     * 利用分治，把数组分为两部分，并不断递归，直到分至单元素
     * 返回，利用merge方法将排序好的部分合并起来。
     * **/
    
    /** ONLY MODIFY BELOW THIS LINE**/
    
    private static int[] aux;
    
    public static void sort(int[] a) {
        aux = new int[a.length];
        sort(a, 0, a.length - 1);
    }
    
    public static void sort(int[] a, int lo, int hi) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }
    
    // 实现基本的归并
    public static void merge(int[] a, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        
        for (int k = lo; k <= hi; k++) {
            if (i > mid)                    a[k] = aux[j++];    // 左侧用完
            else if (j > hi)                a[k] = aux[i++];    // 右侧用完
            else if (less(aux[j], aux[i]))  a[k] = aux[j++];    // i比较小
            else                            a[k] = aux[i++];    // j比较小
        }
        
    }
    /** ONLY MODIFY ABOVE THIS LINE**/
    
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
    
    private static void exch(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    
    private static void show(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    
    public static boolean isSorted(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        int[] a = new int[]{132, 1, 4, 5, 12, 56, 2, 4, 81, 9};
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
