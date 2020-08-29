package LeetCode.second_0628;
/*
557. 反转字符串中的单词 III
给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。

示例：

输入："Let's take LeetCode contest"
输出："s'teL ekat edoCteeL tsetnoc"
 
提示：

在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。

 */
public class Simple_557 {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        int n = words.length;
        for(int i=0;i<n;i++){
            sb.append(new StringBuilder(words[i]).reverse());
            if(i!=n-1){
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(new Simple_557().reverseWords(s));
    }
}
