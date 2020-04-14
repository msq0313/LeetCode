package LeetCode;

/**
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */
public class Hard_42 {
    //双指针，不断记录左区和右区最大值
    public int trap(int[] height) {
        int res = 0;
        int leftmax = 0;
        int rightmax = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            if (height[left] < height[right]) {
                if (leftmax <= height[left]) {
                    leftmax = height[left];
                } else res += leftmax - height[left];
                left = left + 1;
            } else {
                if (rightmax <= height[right]) {
                    rightmax = height[right];
                } else res += rightmax - height[right];
                right = right - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new Hard_42().trap(height));
    }
}
