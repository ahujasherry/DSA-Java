//https://leetcode.com/problems/merge-sorted-array/?envType=study-plan-v2&envId=top-interview-150
public class Main {


    public static void main(String[] args)
    {
            int num1[] = {1,2,3,0,0,0};
            int num2[] = {4,5,6};
            int m = 6;
            int n = 3;
            mergeSortedArray(num1,num2,m,n);

    }

    private static void mergeSortedArray(int[] num1, int[] num2, int m, int n)
    {
        //init 2 pointers
        int p = m-1;
        int q = n-1;   //0
        int k = m+n-1; //0

        //compare both values in arrays, whichever is large, push to last of num1
        while(p>=0 && q>=0)
        {
            if(num1[p] >= num2[q])
            {
                num1[k--] = num1[p--];
            }else
            {
                num1[k--] = num2[q--];
            }
        }

        //merge remaining values
        while(q >=0 ){
            num1[k--] = num2[q--];
        }

        while(p>=0 ){
            num1[k--] = num1[p--];
        }

        //print
        for (int i = 0; i <m+n ; i++)
        {
            System.out.print(num1[i]+" ");
        }
    }

    //O(min(m,n) + mlogm + nlogn)
     public static void merge(long[] arr1, long[] arr2, int m, int n) 
    {

        // Declare 2 pointers:
        int left = m - 1;
        int right = 0;

        // Swap the elements until arr1[left] is
        // smaller than arr2[right]:
        while (left >= 0 && right < n) 
        {
            //lower values - arr1
            //higher values - arr2
            //segregate like quick sort
            if (arr1[left] > arr2[right])
            {
                long temp = arr1[left];
                arr1[left] = arr2[right];
                arr2[right] = temp;
                left--;
                right++;
            } else  //no need to check as left values from in array1 from [0,left] < values in arr2 from [right.n]
            {
                break;
            }
        }

        // Sort arr1[] and arr2[] individually:
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
}
