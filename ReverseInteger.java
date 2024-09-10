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
}
