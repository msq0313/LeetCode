package Array.杨辉三角;

import java.util.ArrayList;
import java.util.List;
/*
118. 杨辉三角
给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。

在杨辉三角中，每个数是它左上方和右上方的数的和。

示例:

输入: 5
输出:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 */
public class Simple_118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> line = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) {
                    line.add(1);
                } else {
                    List<Integer> last = res.get(res.size() - 1);
                    line.add(last.get(j - 1) + last.get(j));
                }
            }
            res.add(line);
        }
        return res;
    }

    public static void main(String[] args) {
        int numRows = 5;
        List<List<Integer>> res =new Simple_118().generate(numRows);
        for (List<Integer> re : res){
            for (Integer r : re) {
                System.out.print(r + " ");
            }
            System.out.println();
        }
    }
}
