import java.util.ArrayList;
import java.util.List;

/***
 * 
 * @author Chi
 * 
 * 思路：这道题很简单，因为其实每天时间表达到分其实就12*60种，故只要穷举出来，然后把符合条件的加到结果里就可以了。
 * 
 */

public class BinaryWatch {
    public List<String> readBinaryWatch(int num) {
        int[] map = new int[60];
        ArrayList<String> list = new ArrayList<>();
        
        for (int i = 0; i < 60; i++) {
            int n = i;
            int r = 0;
            while(n > 0) {
                r += n % 2;
                n = n / 2;
            }
            map[i] = r;
        }
        
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (map[i] + map[j] == num) {
                    if (j >= 10) {
                        list.add(i + ":" + j);
                    } else {
                        list.add(i + ":0" + j);
                    }
                }
            }
        }
        
        return list;
    }
}
