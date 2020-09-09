package Basic;
/*
42. 接雨水
给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。

示例:

输入: [0,1,0,2,1,0,1,3,2,1,2,1]
输出: 6
 */
public class Rain {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int len = height.length;
        int res = 0;
        int[] l_max = new int[len];
        int[] r_max = new int[len];
        l_max[0] = height[0];
        r_max[len - 1] = height[len - 1];
        for (int i = 1; i < len; i++) {
            l_max[i] = Math.max(l_max[i - 1], height[i]);
        }
        for (int i = len - 2; i >= 0; i--) {
            r_max[i] = Math.max(r_max[i + 1], height[i]);
        }
        for (int i = 0; i < len; i++) {
            res += Math.min(l_max[i], r_max[i]) - height[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = new int[]{
                0,1,0,2,1,0,1,3,2,1,2,1
        };
        System.out.println(new Rain().trap(height));
    }
}
