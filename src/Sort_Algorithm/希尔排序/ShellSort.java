package Sort_Algorithm.希尔排序;

import java.util.Arrays;

public class ShellSort {
    public int[] sort(int[] sourceArray) {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        int gap = 1;
        while (gap < arr.length) {
            gap = gap * 3 + 1;
        }

        while (gap > 0) {
            for (int i = gap; i < arr.length; i++) {
                int tmp = arr[i];
                int j = i - gap;
                while (j >= 0 && arr[j] > tmp) {
                    arr[j + gap] = arr[j];
                    j -= gap;
                }
                arr[j + gap] = tmp;
            }
            gap = (int) Math.floor(gap / 3);
        }

        return arr;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();   //获取开始时间
        int[] nums = new int[]{
                2,1,4,7,4,8,3,6,4,7
        };
        System.out.println(Arrays.toString(new ShellSort().sort(nums)));
        long endTime = System.nanoTime(); //获取结束时间
        System.out.println("程序运行时间： "+ (endTime-startTime) +"ns");
    }
}
