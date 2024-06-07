import java.util.Arrays;
import java.util.EnumSet;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array/?envType=study-plan-v2&envId=top-interview-150
public class Main {


    public static void main(String[] args)
    {
            int nums[] = {1};
            System.out.println(removeDuplicates(nums));

    }

    public static int removeDuplicates(int[] nums)
    {
        int n = nums.length;
        int k =1;

        for (int i = 1; i <n ; i++)
        {
            if(nums[i]!=nums[i-1])
            {
                nums[k++]= nums[i];

            }
        }
        return k;
    }


}
