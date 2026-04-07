//basic logic is imagining everyday as aselling day and buy when prices are low and sell when prices are high
import java.util.*;
class Stockbuyandsell {
    public int maxProfit(int[] prices) {
        int maxprofit=0;
        int bestbuy=prices[0];
        for(int i=1;i<prices.length;i++){
            if(prices[i]>bestbuy){
                maxprofit=Math.max(maxprofit,prices[i]-bestbuy);
            }
            bestbuy=Math.min(prices[i],bestbuy);
        }
        return maxprofit;
    }
}
