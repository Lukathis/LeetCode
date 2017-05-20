package sortAlgs;

public class HeapSort {
    /**快速排序基本思路：
     * 选定一个pivot
     * 实现partition方法，将a中的数根据pivot分开，较小的在左侧，较大的在右侧，并返回pivot的位置；
     * 实现sort方法，递归调用pivot左右两侧分别sort，直至只剩下单一元素。
     * **/
    
    /** ONLY MODIFY BELOW THIS LINE**/
    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }
    
    public static void sort(int[] a, int lo, int hi) {
        if (lo >= hi) return;
        int k = partition(a, lo, hi);
        sort(a, lo, k - 1);
        sort(a, k + 1, hi);
    }
    
    private static int partition(int[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        
        while (true) {
            while (less(a[++i], a[lo]))
                if (i == hi) break;
            
            while (less(a[lo], a[--j]))
                if (lo == j) break;
            
            if (j <= i) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
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
