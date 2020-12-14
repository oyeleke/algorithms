package elements_of_programming_interviews;

import java.util.ArrayList;
import java.util.List;

public class BuyAndSellStockTwice {

    public static double buyAndSellStockTwice(List<Double> prices){
        double maxProfit = 0.0;
        List<Double> firstBuySellProfits = new ArrayList<>();
        double minPricesSoFar = Double.MAX_VALUE;

        for (int i = 0; i < prices.size(); ++i){
            System.out.println(i);
            minPricesSoFar = Math.min(minPricesSoFar, prices.get(i));
            maxProfit = Math.max(maxProfit, prices.get(i) - minPricesSoFar);
            firstBuySellProfits.add(maxProfit);
        }

        double maxPriceSoFar = Double.MIN_VALUE;
        for (int i = prices.size() - 1; i>0;  --i){
            maxPriceSoFar = Math.max(maxPriceSoFar, prices.get(i));
            maxProfit = Math.max(maxProfit, maxPriceSoFar - prices.get(i) + firstBuySellProfits.get(i-1));
        }


        return maxProfit;
    }

    public static double buyAndSellStockTwice2(List<Double> prices){
        double minPrices = Double.MAX_VALUE;
        double maxProfitAFterSecondBuy = Double.MIN_VALUE;
        double maxProfitAfterFirstSell = 0.0;
        double maxProfitAfterSecondSell = 0.0;

        for (int i = 0; i < prices.size(); i++){
            double p = prices.get(i);
            minPrices = Math.min(p, minPrices);
            maxProfitAfterFirstSell = Math.max(maxProfitAfterFirstSell, p - minPrices);
            maxProfitAFterSecondBuy = Math.max(maxProfitAFterSecondBuy, maxProfitAfterFirstSell - p);
            maxProfitAfterSecondSell = Math.max(maxProfitAfterSecondSell, maxProfitAFterSecondBuy + p);
        }

        return maxProfitAfterSecondSell;
    }
}
