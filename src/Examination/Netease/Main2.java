package Examination.Netease;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*
2. 对1~N一共N个数，初始时各自有一个集合，对这些集合可以采取如下几种操作：
- （1）如果x,y不在一个集合里，则将x和y所在的集合合并
- （2）如果x所在集合中除了x还有别的数字，则将x提出单独成立一个集合
- （3）输出x所在集合的元素个数

1
3 7
3 1
1 1 2
3 1
1 2 3
3 1
2 1
3 1
*/
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int N = sc.nextInt();
        int M = sc.nextInt();
        ArrayList<Integer> res = new ArrayList<>();
        for (int t = 0; t < T; t++) {
            ArrayList<ArrayList<Integer>> vec = new ArrayList<>(N);
            //key为数字，value为所在集合
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for (int i = 0; i < N; i++) {
                ArrayList<Integer> list = new ArrayList<>();
                vec.add(list);
                //vec与hashMap初始化
                vec.get(i).add(i + 1);
                hashMap.put(i + 1, i);
//            System.out.println(hashMap.get(i + 1));
//            System.out.println(vec.get(i).toString());
            }

            for (int i = 0; i < M; i++) {
                int p = sc.nextInt();
                if (p == 1) {
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    //若x，y不属于同一集合，合并
                    int x_vec = hashMap.get(x);
                    int y_vec = hashMap.get(y);
                    if (x_vec != y_vec) {
                        for (int num : vec.get(y_vec)) {
                            vec.get(x_vec).add(num);
                            hashMap.put(num, x_vec);
                        }
                        vec.get(y_vec).clear();
                    }
                }
                if (p == 2) {
                    int x = sc.nextInt();
                    int x_vec = hashMap.get(x);
                    if (vec.get(x_vec).size() > 1) {
                        for (int j = 0; j < vec.get(x_vec).size(); j++) {
                            if (vec.get(x_vec).get(j) == x) {
                                vec.get(x_vec).remove(j);
                                break;
                            }
                        }
                        for (int j = 0; j < N; j++) {
                            if (vec.get(j).size() == 0) {
                                vec.get(j).add(x);
                                hashMap.put(x, j);
                                break;
                            }
                        }
                    }
                }
                if (p == 3) {
                    int x = sc.nextInt();
                    res.add(vec.get(hashMap.get(x)).size());
                }
            }
        }
        for (int num : res) {
            System.out.println(num);
        }
    }
}
