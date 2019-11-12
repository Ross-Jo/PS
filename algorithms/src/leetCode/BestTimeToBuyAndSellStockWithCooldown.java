package leetCode;

// 참고 : https://engkimbs.tistory.com/699

public class BestTimeToBuyAndSellStockWithCooldown {
	static int maxProfit(int[] prices) {
		if (prices == null || prices.length <= 1) return 0;
		
		int sell=0, prev_sell=0, buy=Integer.MIN_VALUE, prev_buy;
		
		for (int i=0; i<prices.length; i++) {
			prev_buy = buy;
			buy = Math.max(prev_sell - prices[i], prev_buy);
			prev_sell = sell;
			sell = Math.max(prev_buy + prices[i], prev_sell);
		}
		
		return sell;
	}
	
	public static void main(String[] args) {
		System.out.println(maxProfit(new int[] {1,2,3,0,2}));
	}
}
