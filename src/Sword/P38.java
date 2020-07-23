package Sword;

public class P38 {
    // 数组大小及指针大小
    public static int GetSize(int data[]) {
        return data.length;
    }

    public static void main(String[] args) {
        int[] data1 = new int[]{1, 2, 3, 4, 5};
        int size1 = data1.length;
        int[] data2 = data1;
        int size2 = data2.length;
        int size3 = GetSize(data1);
        System.out.println(size1);
        System.out.println(size2);
        System.out.println(size3);
        // 结果相同，返回的都是长度
    }
}
