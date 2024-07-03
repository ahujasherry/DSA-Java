import java.util.*;


public class Main {


    public static void main(String[] args)
    {

        int arr[]= {7,7,7,7};
        System.out.println("Maximum Obtainable Value is " + lengthOfLIS(arr));
    }

    public static  int lengthOfLIS(int[] nums)
    {
        int n = nums.length;
        int dp[] = new int[n+1];
        return lengthOfLISUtil(nums, 0, -1);
    }

    private static int lengthOfLISUtil(int[] nums, int index, int prev_index)
    {
        if(index==nums.length) return 0;

        int notTaken = lengthOfLISUtil(nums, index+1, prev_index);

        int taken = Integer.MIN_VALUE;

        if(prev_index==-1 || nums[index] >nums[prev_index])
            taken = 1 + lengthOfLISUtil(nums, index+1, index);

        return Math.max(taken,notTaken);
    }


}
