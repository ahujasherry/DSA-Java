//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int maxProfit = 0;

        for(int i =1;i<prices.length;i++)
        {
            if(prices[i]- buy> maxProfit){
                maxProfit  = prices[i]- buy;
            }else if(prices[i] < buy){
                buy = prices[i];
            }
            
            
            
        }

        return maxProfit;
    }
}
