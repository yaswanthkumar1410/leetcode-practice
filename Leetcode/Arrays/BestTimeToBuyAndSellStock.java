
public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4})); // 5
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));   // 0
        System.out.println(maxProfit(new int[]{2,4,1}));        // 2
    }

    // ============================================
    // LC 121 — Best Time to Buy and Sell Stock
    // ============================================
    // Given prices[i] = price on day i.
    // Choose one day to buy, one later day to sell.
    // Return max profit. If no profit, return 0.
    //
    // Rules: O(n) time
    // ============================================
    static int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;
        for(int i = 0; i < prices.length; i++) {
            if(minPrice > prices[i]) {
                minPrice = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }
        }
        return maxProfit;
    }
}
