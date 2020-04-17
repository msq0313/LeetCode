package Basic;
//不用加减乘除做加法
public class Add {
    public static void main(String[] args) {
        Add add = new Add();
        System.out.println(add.add(5,7));
    }
    public int add(int num1,int num2) {
        while (num2 != 0) {
            int temp = num1 ^ num2;
            num2 = (num1 & num2) << 1;
            num1 = temp;
        }
        return num1;
    }
}
