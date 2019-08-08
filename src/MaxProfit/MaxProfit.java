package MaxProfit;

public class MaxProfit {

    public static void main(String[] args){

        System.out.println(new MaxProfit().max_profit(new int[]{7,1,5,3,6,4}));

    }

    public int max_profit(int[] prices){

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i = 0; i < prices.length; i++){
            if(minPrice < prices[i]){
                maxProfit = Math.max(prices[i] - minPrice, maxProfit);
            }else{
                minPrice = prices[i];
            }
        }

        return maxProfit;
    }
}
