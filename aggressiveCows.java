class Solution {
    public int maxDistance(int[] position, int m)
  {
        
        //Sort the position array first
        int n=position.length;
        Arrays.sort(position);

          
        int low=1, high= position[n-1]- position[0], ans=0;
        
        while(low<=high)
        {
            int mid= (low+high)/2;
            if(isPossible(mid,m,position))
            {
                //look for > position on right
                ans=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }

  public static boolean isPossible(int distance, int totalCows, int arr[])
  {
    int n = arr.length;
    int cowsCount = 1;
    int lastPosition = arr[0];
    
    for(int i=1;i<n;i++)
      {
        //try assigning cow
        if(arr[i] - arr[lastPosition] >= distance)
        {
            cowsCount++; 
            lastPosition =i;

           if (cowsCount == totalCows) {
                return true; // Successfully placed all cows
            }
          
        }
      }
    return false;
    
  }







  
    
}
