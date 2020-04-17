package Basic;

public class RecursiveFn {
    public static void main(String[] args) {
        RecursiveFn recursiveFn = new RecursiveFn();
        System.out.println(recursiveFn.recursiveFn(4));
    }
    private int recursiveFn(int n) {
        if (n == 0) {
            return 1;
        }
        return recursiveFn(n / 4) + recursiveFn(n / 4);
    }
}
