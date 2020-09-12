package Examination.Tencent.exam0908.q3;
/*
输出前k多和前k少的字符串。AC
4 2
1
1
2
3

1 2
2 3
 */
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("1", 1);
        map.put("2", 2);
        map.put("3", 1);
        Set<String> strings = map.keySet();
        List<String> list = new ArrayList<>(strings);
        System.out.println(list);
    }
}
