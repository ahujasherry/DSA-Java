import java.util.Arrays;
import java.util.Stack;

//https://www.geeksforgeeks.org/next-smaller-element/
public class BuyAndSell
{

    public static void main(String[] args) {
        int arr[]={4, 8, 5, 2, 25};
        int n = arr.length;
        getNextSmallerELement(arr,n);
    }

    private static void getNextSmallerELement(int[] arr, int n )
    {
        Stack<Integer> s = new Stack<>();
        int res[]=new int[n];



        for (int i = 0; i < n; i++)
        {
            int ele = arr[i];  //5
            while(!s.isEmpty() && ele < arr[s.peek()])
            {
                res[s.pop()] = ele;
            }
            s.push(i);
        }

       
       
        while(!s.isEmpty())
        {
            res[s.pop()] = -1;
        }

        for (int i = 0; i < n; i++) {
            System.out.println(arr[i] + " --> " + res[i]);
        }
        


    }


}
