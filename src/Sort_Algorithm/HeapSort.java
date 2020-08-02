package Sort_Algorithm;

import java.util.Arrays;
/*
    堆的初始化，时间复杂度为O(n)。
    在堆排序中一次进行堆的初始化操作，其时间复杂度为O(n)，n-1次进行堆的调整，每次调整的时间复杂度为O(logn)，
    所以，堆排序的时间复杂度为O(nlogn)。
    因为堆的每次插入、删除元素均需要重新调整堆，所以插入语删除元素的时间复杂度为O(logn).
 */
public class HeapSort {

    private void heapSort(int[] nums) {
        //创建大顶堆
        for (int i = (nums.length - 1) / 2; i >= 0; i--) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(nums, i, nums.length);
        }
        System.out.println(Arrays.toString(nums));

        //调整堆，升序排序，堆顶元素是最大的，放在相应位置
        for (int i = nums.length - 1; i > 0; i--) {
            //将堆顶元素与末尾元素进行交换
            int temp = nums[i];
            nums[i] = nums[0];
            nums[0] = temp;
            //重新对堆进行调整
            adjustHeap(nums, 0, i);
        }
    }

    private void adjustHeap(int[] nums, int parent, int length) {
        //将temp作为父节点
        int temp = nums[parent];
        //左孩子
        int lChild = 2 * parent + 1;

        while (lChild < length) {
            //右孩子
            int rChild = lChild + 1;
            // 如果有右孩子结点，并且右孩子结点的值大于左孩子结点，则选取右孩子结点
            if (rChild < length && nums[lChild] < nums[rChild]) {
                lChild++;
            }
            // 如果父结点的值已经大于孩子结点的值，则直接结束
            if (temp >= nums[lChild]) {
                break;
            }
            // 把孩子结点的值赋给父结点
            nums[parent] = nums[lChild];

            //选取孩子结点的左孩子结点,继续向下筛选
            parent = lChild;
            lChild = 2 * lChild + 1;
        }
        nums[parent] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{
                16, 7, 3, 20, 17, 8
        };
        new HeapSort().heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
