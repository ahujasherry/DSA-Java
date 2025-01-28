
import java.util.*;
import java.io.*;

class GFG{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0){
			int n = sc.nextInt();
			int[][] a = new int[n][n];
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					a[i][j] = sc.nextInt();
			Solution T = new Solution();
			ArrayList<Integer> arr= T.mergeKArrays(a, n);
			for(int i = 0; i < n*n ; i++)
			    System.out.print(arr.get(i)+" ");
		    System.out.println();
		    
		    t--;
		}
	}
}


// } Driver Code Ends


//User function Template for Java

class Pair implements Comparable<Pair>
{
    int val;
    int row;
    int col;
    
    public Pair(int val, int row,int col)
    {
        this.val = val;
        this.row= row;
        this.col = col;
    }
    
    @Override
    public int compareTo(Pair o)
    {
        return Integer.compare(this.val,o.val);
    }
}
class Solution
{
    //Function to merge k sorted arrays.
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int k) 
    {
        PriorityQueue<Pair> q = new PriorityQueue<>(k);
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        for(int i=0;i<k;i++) 
        { 
            if(arr[i].length>0)
                q.offer(new Pair(arr[i][0],i,0));
        }
        
        while(!q.isEmpty())
        {
            Pair front = q.poll();
            if(front!=null ) res.add(front.val);
            
            if(front.col+1 < arr[front.row].length)
                q.offer(new Pair(arr[front.row][front.col+1], front.row, front.col+1));
        }
        
        return res;
    }
}
