package Examination.Tencent.exam0823;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        // Array转List
        String[] s = new String[]{"A", "B", "C", "D","E"};
        List<String> list = Arrays.asList(s);
        s[0] ="AA";
        System.out.println("list: " + list);
        // List转Array
        String[] dest = list.toArray(new String[0]);//new String[0]是指定返回数组的类型
        System.out.println("dest: " + Arrays.toString(dest));
        // 注意这里的dest里面的元素不是list里面的元素，换句话就是说：对list中关于元素的修改，不会影响dest。
        list.set(0, "Z");
        System.out.println("modified list: " + list);
        System.out.println("dest: " + Arrays.toString(dest));

        //List转Set
        Set<String> set = new HashSet<>(list);
        System.out.println("set: " + set);
        //Set转List
        List<String> list_1 = new ArrayList<>(set);
        System.out.println("list_1: " + list_1);

        //array转set
        s = new String[]{"A", "B", "C", "D","E"};
        set = new HashSet<>(Arrays.asList(s));
        System.out.println("set: " + set);
        //set转array
        dest = set.toArray(new String[0]);
        System.out.println("dest: " + Arrays.toString(dest));
    }
}
