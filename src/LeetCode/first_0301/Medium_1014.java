package LeetCode.first_0301;

public class Medium_1014 {
    //首先想到，两层循环
//    public int maxScoreSightseeingPair(int[] A) {
//        int res = 0;
//        for (int i = 0; i < A.length; i++) {
//            for (int j = i + 1; j < A.length; j++) {
//                int sum = A[i] + A[j] + i - j;
//                res = Math.max(sum, res);
//            }
//        }
//        return res;
//    }
    //公式：A[i]+A[j]+i-j，可以先用O(n)时间求出B[j]=A[j]-j，再用一次循环不断更新最大值即可，整体时间复杂度O(n)
    public int maxScoreSightseeingPair(int[] A) {
        int res = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        //公式：A[i]+A[j]+i-j
        //设B[j]=A[j]-j
        int len = A.length;
        int[] B = new int[len];
        for (int j = 0; j < len; j++) {
            B[j] = A[j] - j;
        }
        for (int j = 1; j < len; j++) {
            max = Math.max(max, A[j - 1] + j - 1);
            res = Math.max(res, B[j] + max);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = new int[]{
                8,1,5,2,6
        };
        System.out.println(new Medium_1014().maxScoreSightseeingPair(A));
    }
}
