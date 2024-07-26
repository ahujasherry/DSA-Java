//https://leetcode.com/problems/single-element-in-a-sorted-array/
class Solution {

    //T.C = O(LogN)
     public int singleNonDuplicateBinarySearch(int[] arr) 
    {
        int n = arr.length;
        if(n==1 )return arr[0];
        if(arr[0]!=arr[1]) return arr[0];
        if(arr[n-1]!=arr[n-2]) return arr[n-1];

        int low = 1;
        int high = n-2;

        while(low<=high)
        {
            int mid = (low+high)/2;

            //check for single element
            if(arr[mid-1]!=arr[mid] && arr[mid]!=arr[mid+1]) return arr[mid];

            //identify half and eliminate that

            //if mid is even
            if(mid%2==0)
            {   
                //we are in left half, go to right
                if(arr[mid+1] == arr[mid])
                {
                    low = mid+1;
                }else if(arr[mid-1] == arr[mid])
                {
                    high = mid-1;
                }

            }else{
                //if mid is odd

                //we are in right half, go to left
                if(arr[mid+1] == arr[mid])
                {
                     high = mid-1;
                    
                }else if(arr[mid-1] == arr[mid])
                {
                   low = mid+1;
                }
            }

        }

        return -1;
        
    }

     //T.C = O(N)
    public int singleNonDuplicate(int[] arr) 
    {
        int n = arr.length; 
        int ans = 0;
        // XOR all the elements:
        for (int i = 0; i < n; i++) {
            ans = ans ^ arr[i];
        }
        return ans;
        
    }
}
