package LeetCode.second_0628;
/*
567. 字符串的排列
给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。

换句话说，第一个字符串的排列之一是第二个字符串的子串。

示例1:

输入: s1 = "ab" s2 = "eidbaooo"
输出: True
解释: s2 包含 s1 的排列之一 ("ba").

示例2:

输入: s1= "ab" s2 = "eidboaoo"
输出: False

注意：

输入的字符串只包含小写字母
两个字符串的长度都在 [1, 10,000] 之间
 */
public class Medium_567 {
    //滑动窗口，注意s1的排列可以理解为窗口中相应字符的个数与s1相等且长度与s1长度相等，即构成包含关系
    public boolean checkInclusion(String s1, String s2) {
        // 使用数组记录每种字符需要的个数，下标为字符对应的数值
        int[] freq = new int[128];
        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i)]++;
        }
        // 初始化边界值，以及有效计数valid
        int left = 0, right = 0;
        int valid = 0;
        // 遍历字符串
        while (right < s2.length()) {
            // 字符 c 进入窗口
            char c = s2.charAt(right);
            // 窗口右边界扩展
            right++;
            // 更新仍需要的 c 字符个数，更新有效计数valid
            if (--freq[c] >= 0) {
                valid++;
            }
            while (valid == s1.length()) {
                // 当左右边界差值与s1长度相等时，即构成包含关系
                if (right - left == s1.length())
                    return true;
                // 字符 d 弹出窗口
                char d = s2.charAt(left);
                // 窗口左边界收缩
                left++;
                // 更新仍需要的 d 字符个数，更新有效计数valid
                if (++freq[d] > 0) {
                    valid--;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbbbba";
        System.out.println(new Medium_567().checkInclusion(s1, s2));
    }
}
