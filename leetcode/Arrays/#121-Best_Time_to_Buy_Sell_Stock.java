logic  :

    +---------------------------------------------------------------------+
    |              BEST TIME TO BUY/SELL STOCKS CHEAT SHEET               |
    +---------------------------------------------------------------------+
    |                                                                     |
    |   +-------------------------------------------------------------+   |
    |   |                     Initial Setup                           |   |
    |   +-------------------------------------------------------------+   |
    |                                |                                    |
    |                                v                                    |
    |              +------------------------------------------+          |
    |              | minprice = prices[0]                     |          |
    |              | max_profit = - infinity                  |          |
    |              +------------------------------------------+          |
    |                                |                                    |
    |                                v                                    |
    |                        +------------------+                        |
    |                        | for (i from 1 to |                        |
    |                        | prices.length) |                        |
    |                        +------------------+                        |
    |                                |                                    |
    |                                v                                    |
    |           +--------------------------------------------+           |
    |           |              Check Conditions              |           |
    |           +--------------------------------------------+           |
    |               |                                    |                |
    |               v                                    v                |
    |   +---------------------+                +---------------------+    |
    |   | if prices[i] <      |                | else:               |    |
    |   | minprice:           |                | profit = prices[i]  |    |
    |   |   minprice =        |                |       - minprice    |    |
    |   |   prices[i]         |                | max_profit =        |    |
    |   +---------------------+                | max(max_profit,     |    |
    |                                          |        profit)      |    |
    |                                          +---------------------+    |
    |                                |                                    |
    |                                v                                    |
    |                        +------------------+                        |
    |                        | return           |                        |
    |                        | max_profit       |                        |
    |                        +------------------+                        |
    |                                                                     |
    +---------------------------------------------------------------------+
    |                        KEY VARIABLES                                |
    +---------------------------------------------------------------------+
    |                                                                     |
    |  minprice   = lowest price seen so far (best buy day)               |
    |  max_profit = maximum profit achievable                             |
    |                                                                     |
    +---------------------------------------------------------------------+
    |                        EXAMPLE CASES                                |
    +---------------------------------------------------------------------+
    |                                                                     |
    |  prices = [7,1,5,3,6,4] → max_profit = 5 (buy at 1, sell at 6)     |
    |  prices = [7,6,4,3,1]   → max_profit = 0 (no transaction)          |
    |  prices = [3]           → max_profit = 0 (must buy before sell)     |
    |                                                                     |
    +---------------------------------------------------------------------+
    |  Time Complexity: O(n)     Space Complexity: O(1)                   |
    +---------------------------------------------------------------------+



121. Best Time to Buy and Sell Stock

    You are given an array prices where prices[i] is the price of a given stock on the ith day.

    You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

    Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

    

    Example 1:

        Input: prices = [7,1,5,3,6,4]
        Output: 5
        Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
        Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

    Example 2:
        Input: prices = [7,6,4,3,1]
        Output: 0
    Explanation: In this case, no transactions are done and the max profit = 0.

    Constraints:

        1 <= prices.length <= 105
        0 <= prices[i] <= 104

code : 

    class Solution {
    public int maxProfit(int[] prices) {
        int max_profit = 0;
        int minprice = prices[0];

        for(int i = 1;i<prices.length;i++){
            minprice = Math.min(prices[i],minprice);
            int profit = prices[i] - minprice;
            max_profit = Math.max(profit,max_profit);

        }
        return max_profit;
    }
}


explanation :

my : 
    2 variables intialized with
    int max_profit = 0,minprice = prices[0]
    and run a loop from i = 1 till prices.length 
    minprice = Math.min(prices[i],minprice)
    int profit = prices[i] - minprice
    max_profit = Math.max(profit,max_profit)
    at last return the max_profit

time complexity : O(n)
spcae Complexity : O(1)

chat gpt : 
        
    Start with two variables:

    minprice = prices[0] → the lowest price so far (best day to buy)

    max_profit = 0 → the best profit found so far

    Loop through the prices starting from day 1:

    If todays price is lower than minprice, update minprice

    Else:

    Calculate profit = prices[i] - minprice

    Update max_profit if profit is greater than the previous one

    Return the max_profit at the end

