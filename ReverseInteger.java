class Solution {
    public int reverse(int x) 
    {
        boolean isNeg = x<0;

        String str = String.valueOf(Math.abs(x));

        String reversed = new StringBuilder(str).reverse().toString();

        try
        {
            int reverse = Integer.parseInt(reversed);
            return isNeg ? -reverse : reverse;
        }catch(Exception e)
        {
            return 0;
        }
        

    }

    public int reverseMath(int x) 
    {
        boolean isNeg = x<0;

        int reverse = 0;
        int temp=0;

        x = Math.abs(x);
        while(x!=0)
        {
            
            temp= x%10;

            //if we add temp and * by 10, it should not overflow afterwords
            if (reverse > (Integer.MAX_VALUE - temp) / 10) {
                return 0;
            }

            reverse = reverse*10 + temp;
            x/=10;
        } 

        return isNeg ? -reverse : reverse;

    }
}
