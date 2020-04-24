package Basic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
现有一些随机生成的数字要将其依次传入，请设计一个高效算法，对于每次传入一个数字后，
算出当前所有传入数字的中位数。(若传入了偶数个数字则令中位数为第n/2小的数字，n为已传入数字个数)。

给定一个int数组A，为传入的数字序列，同时给定序列大小n，
请返回一个int数组，代表每次传入后的中位数。保证n小于等于1000。

测试样例：
[1,2,3,4,5,6],
6
返回：[1,1,2,2,3,3]
 */
public class Heap {
    static Comparator<Integer> cmp = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    };

    public int[] getMiddle(int[] A, int n) {
        int[] res = new int[n];
        if (n == 0) {
            return A;
        }
        PriorityQueue<Integer> max = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> min = new PriorityQueue<>();
        max.add(A[0]);
        res[0] = A[0];
        for (int i = 1; i < n; i++) {
            if (A[i] <= res[i - 1]) {
                max.add(A[i]);
            } else
                min.add(A[i]);
            if (min.size() > max.size()) {
                max.add(min.poll());
            }
            if (max.size() - 1 > min.size()) {
                min.add(max.poll());
            }
            res[i] = max.peek();
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] A = new int[]{6, 5, 4, 3, 2, 1};
        int[] A = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(new Heap().getMiddle(A, A.length)));
    }
}
