import java.util.*;


//T.C = O(N^2)
//S.C = O(N)
public class Main {


    public static void main(String[] args)
    {
        int arr[] = {1, 5, 8, 9, 10, 17, 17, 20};
        int size = arr.length;
        int dp[][]=new int[size][size+1];
        for (int i = 0; i <size ; i++) {
            Arrays.fill(dp[i],-1);
        }
        System.out.println("Maximum Obtainable Value is " + cutRodDp(arr, size));
    }

    public static int cutRodDp(int prices[], int n)
    {
        int dp[]= new int[n+1];
        dp[0] =0;

        //check for every length
        for (int len = 1; len <=n ; len++)
        {
            //make cuts at every index till that length
            for (int i = 0; i <len ; i++)
            {
                //max of taken and not taken
                dp[len] = Math.max(dp[len],prices[i] + dp[len-i-1]);

            }

        }

        return dp[n];
    }

    public static int cutRod(int prices[], int n,int dp[][]) {
        return cutRodUtil(prices, n - 1, n,dp);
    }

    public static int cutRodUtil(int prices[], int cutIndex, int totalLength,int dp[][])
    {
        //index = where cut is to happen
        if(cutIndex==0)
        {
            return prices[cutIndex] * totalLength;
        }

        if(totalLength==0) return  0;

        if(dp[cutIndex][totalLength]!=-1) return  dp[cutIndex][totalLength];

        //maximize the price
        int notTaken = 0 + cutRodUtil(prices, cutIndex-1, totalLength,dp);

        //because we need to find max from remaining rod
        int taken = Integer.MIN_VALUE;
        int currRodLength = cutIndex+1;

        if(currRodLength <= totalLength){
            taken = prices[cutIndex] + cutRodUtil(prices,totalLength - currRodLength-1 ,totalLength - currRodLength ,dp);
        }

        return dp[cutIndex][totalLength] = Math.max(taken,notTaken);
    }


}
