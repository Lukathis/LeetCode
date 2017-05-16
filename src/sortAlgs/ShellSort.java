package sortAlgs;

public class ShellSort {
    /**希尔排序基本思路：
     * 希尔排序是对插入排序的改进。主要原因是如果用插入排序，每次元素必须从数组的一端慢慢移动到另一端。
     * 希尔排序把每隔h个元素分为一组，h从较大的值递减，有助于把一些排在后面的较小元素快速前移。
     * h的取值可以有很多选择，一般可以用3 * h + 1的序列，逐次递减。
     * **/
    
    /** ONLY MODIFY BELOW THIS LINE**/
    public static void sort(int[] a) {
        int n = a.length;
        int h = 1;
        
        while (h < n / 3) {
            h = 3 * h + 1;
        }
        
        while (h > 0) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j = j - h) {
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
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
