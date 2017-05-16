package sortAlgs;

public class SelectionSort {
    /**选择排序基本思路：
     * 循环n轮，每一轮找出最小的元素，依次往后排。
     * **/
    
    /** ONLY MODIFY BELOW THIS LINE**/
    public static void sort(int[] a) {
        int n = a.length;
        
        // 每次扫描数组里最小的元素
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, i, min);
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
//        assert isSorted(a);
        show(a);
    }
}
