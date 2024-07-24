public class Solution {
   
    public int[] repeatedNumber(final int[] A)
    {
       int n  = A.length;
       int xr = 0;
       
        for(int i=0;i<n;i++)
        {
            xr = xr ^ A[i];
            xr = xr ^ (i+1);
        }
        
        //xr = X ^ Y ( repeating and missing)
        
        
        //find difference bit
        int number  = (xr & ~(xr - 1));
       
        
        //group in 1/0 based on set bit
        int zero =0;   //0
        int one = 0;   //1
        
        for(int i=0;i<n;i++)
        {
            if( (number & A[i]) !=0){
                one = one^ A[i];
            }else{
                zero = zero^ A[i];
            }
        }
        
        //1 to n
         for(int i=1;i<=n;i++)
        {
            if((i&number)!=0){
                one = one^ i;
            }else{
                zero = zero^ i;
            }
        }
        
        
      // Last step: Identify the numbers:
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] == zero) cnt++;
        }

        if (cnt == 2) return new int[] {zero, one};
        return new int[] {one, zero};
        
       
    }
}
