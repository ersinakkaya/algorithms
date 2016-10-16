package com.interview.cake;

public class GetMaxProfit {
	
	public static int getMaxProfit(int[] yesterdayPrices){
		if (yesterdayPrices.length < 2) {
		    throw new IllegalArgumentException("Getting a profit requires at least 2 prices");
		}
		
		int profit = yesterdayPrices[1] - yesterdayPrices[0];
		int minPrice = yesterdayPrices[0];
		for(int i = 1; i < yesterdayPrices.length; i++){
			int current = yesterdayPrices[i];
			int potentialProfit = current - minPrice;
			profit = Math.max(potentialProfit, profit);
			minPrice = Math.min(minPrice, current);
		}
		return profit;
	}
	
	public static void main (String[] args){
		int[] yesterdayPrices = {16, 14, 12, 8, 5, 3, 17};
		int maxPrice = getMaxProfit(yesterdayPrices);
		System.out.println(maxPrice);
	}
}

//O(n) time O(1) space