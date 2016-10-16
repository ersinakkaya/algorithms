package com.interview.cake;

public class GetMaxProfit {
	
	public static int getMaxProfit(int[] yesterdayPrices){
		int profit = 0;
		
		int initial = 0;
		int compared = 0;
		for(int i = 0; i < yesterdayPrices.length; i++){
			initial = yesterdayPrices[i];
			for(int j = i+1; j < yesterdayPrices.length; j++){
				compared = yesterdayPrices[j];
				if(compared > initial && (compared - initial) > profit){
					profit = compared - initial;
				}
			}
		}
		return profit;
	}
	
	public static void main (String[] args){
		int[] yesterdayPrices = {16, 14, 12, 8, 5, 3};
		int maxPrice = getMaxProfit(yesterdayPrices);
		System.out.println(maxPrice);
	}
}