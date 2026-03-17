
import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
        System.out.println(coinChange(new int[] { 1, 5, 11 }, 15)); // 3 (5+5+5)
        System.out.println(coinChange(new int[] { 1, 2, 5 }, 11)); // 3 (5+5+1)
        System.out.println(coinChange(new int[] { 2 }, 3)); // -1 (impossible)
        System.out.println(coinChange(new int[] { 1 }, 0)); // 0
    }

    // ============================================
    // DP — PROBLEM 3: Coin Change
    // ============================================
    // Given coin denominations and a target amount,
    // return the fewest number of coins needed to
    // make that amount. Return -1 if impossible.
    //
    // Example: coins=[1,5,11], amount=15
    // 15 = 5+5+5 → 3 coins (not 11+1+1+1+1 = 5 coins)
    //
    // Think about it:
    // dp[i] = minimum coins to make amount i
    //
    // For each amount i, try every coin:
    // if coin <= i:
    // dp[i] = min(dp[i], dp[i - coin] + 1)
    //
    // Base case: dp[0] = 0 (0 coins for amount 0)
    // Initialize dp[1..amount] = something large (impossible)
    //
    // Rules:
    // - O(amount * coins.length) time
    // ============================================
    static int coinChange(int[] coins, int amount) {
        int[] minNumberOfCoinsRequired = new int[amount + 1];
        Arrays.fill(minNumberOfCoinsRequired, Integer.MAX_VALUE);
        minNumberOfCoinsRequired[0] = 0;
        // 1, 5, 11 amount 15
        // 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15
        // 0, 1, 2, 3, 4, 1, 2, 3, 4, 5, 2,
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i && minNumberOfCoinsRequired[i - coins[j]] != Integer.MAX_VALUE)
                    minNumberOfCoinsRequired[i] = Math.min(minNumberOfCoinsRequired[i],
                            minNumberOfCoinsRequired[i - coins[j]] + 1);
            }
        }
        if (minNumberOfCoinsRequired[amount] == Integer.MAX_VALUE)
            return -1;
        return minNumberOfCoinsRequired[amount];
    }
}
