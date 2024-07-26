//https://www.interviewbit.com/problems/allocate-books/
//T.C =  O(N * (sum(arr[])-max(arr[])+1)), where N = size of the array, sum(arr[]) = sum of all array elements, max(arr[]) = maximum of all array elements.
public class Solution {

    //T.C =  O(N * log(sum(arr[])-max(arr[])+1)),
      public int booksBS(int[] pages, int totalStudents)
    {
        
        int n = pages.length;
        int finalAns = 0;
        
        if(totalStudents> n ) return -1;
        
        int low = 0;    //max pages
        long high = 0;  // sum of pages
        
        for(int ele : pages)
        {
            low = Math.max(low, ele);
            high = high + ele;
        }
        
        while (low <= high)
        {
            int mid = (int) ((low + high) / 2);
            if (allocationPossible(pages, mid,totalStudents, n)) 
            {
                finalAns = mid;
                high = mid-1;  // Try for a smaller max page count
            } else {
                low = mid + 1;  // Increase the max page count
            }
        }
        
        return finalAns;
       
        
    }

    //T.C =  O(N * (sum(arr[])-max(arr[])+1)), where N = size of the array, sum(arr[]) = sum of all array elements, max(arr[]) = maximum of all array elements
    public int books(int[] pages, int totalStudents)
    {
        
        int n = pages.length;
        
        if(totalStudents> n ) return -1;
        
        int low = 0;    //max pages
        long high = 0;  // sum of pages
        
        for(int ele : pages)
        {
            low = Math.max(low, ele);
            high = high + ele;
        }
        
        for(int currentMaxPage=low; currentMaxPage<=high ; currentMaxPage++)
        {
                
              boolean ans = allocationPossible(pages, currentMaxPage,totalStudents, n) ;
              if(ans) return currentMaxPage;
            
        }
        return -1;
        
    }
    
    public static boolean allocationPossible(int pages[], int currentMaxPage,int totalStudents,  int n )
    {
       int student =1;
       int currentPages = 0;
       
       for(int i=0;i<n;i++)
       {
           if(currentPages + pages[i] <= currentMaxPage)
           {
               currentPages += pages[i];
           }else{
               student++;
               currentPages = pages[i];
               
               //all students got it, but stil books are left
               if(student >totalStudents) return false;
           }
       }
        
        return true;
    }
    
}
