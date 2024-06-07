import java.util.Arrays;
import java.util.EnumSet;

//https://leetcode.com/problems/remove-element/description/?envType=study-plan-v2&envId=top-interview-150
public class Main {


    public static void main(String[] args)
    {
            int nums[] = {3,2,2,3};
            int val = 2;
        System.out.println(removeElement(nums,val));

    }

    public static int removeElement(int[] nums, int val)
    {
        int n = nums.length;
        int k=0, i=0;



        //find first occurence of value
        for (i = 0; i <n ; i++)
        {
            if(nums[i]==val)
            {
                k= i;
                break;
            }
        }

        if(i==n){
            return i;
        }

        while(k<n )
        {
            if( val==nums[k]){
                k++;
            }else{
                nums[i++] = nums[k++];
            }
        }


        return i;

    }


}
