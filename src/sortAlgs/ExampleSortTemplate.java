package sortAlgs;

public class ExampleSortTemplate {
    
    /**
     * 【初级排序算法】
     *  - 选择排序 (SelectionSort)
     *  - 插入排序 (InsertionSort)
     *  - 希尔排序 (ShellSort)
     *  
     * 【较高级排序算法】
     * - 归并排序 (MergeSort)
     * - 快速排序 (QuickSort)
     * - 堆排序 (HeapSort)
     * **/
    
    /** ONLY MODIFY BELOW THIS LINE**/
    public static void sort(int[] a) {

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
