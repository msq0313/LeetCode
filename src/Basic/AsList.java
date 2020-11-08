package Basic;

import java.util.Arrays;
import java.util.List;

public class AsList {
    public static void main(String[] args) {
        String[] str = new String[]{"hello","world"};
        List<String> list = Arrays.asList(str);
        list.add("you");

        String[] array = (String[]) list.toArray();
    }
}
