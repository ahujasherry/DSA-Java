class Solution {
    public int largestRectangleArea(int[] heights)
    {

        
        int n = heights.length;
        int maxArea = Integer.MIN_VALUE;


        int nextLeftSmaller[] = getNextSmallerELement(heights,n,false);
        int nextRightSmaller[] = getNextSmallerELement(heights,n,true);

        for (int i = 0; i <n ; i++)
        {

            maxArea = Math.max(maxArea, (nextRightSmaller[i]- nextLeftSmaller[i]-1)*heights[i]);
        }

        return maxArea;

        
    }

     private static int[] getNextSmallerELement(int[] arr, int n,boolean leftToRight )
    {
        Stack<Integer> s = new Stack<>();
        int res[]=new int[n];

        if(leftToRight)
        {
            for (int i = 0; i < n; i++)
            {
                int ele = arr[i];
                while(!s.isEmpty() && ele < arr[s.peek()])
                {
                    res[s.pop()] = i;
                }
                s.push(i);
            }
            while(!s.isEmpty())
            {
                res[s.pop()] = n;
            }

        }else
        {
            for (int i = n-1; i >= 0; i--)
            {
                int ele = arr[i];
                while(!s.isEmpty() && ele < arr[s.peek()])
                {
                    res[s.pop()] = i;
                }
                s.push(i);
            }
            while(!s.isEmpty())
            {
                res[s.pop()] = -1;
            }
        }

       return res;


    }
}
