package hw2;

/*
 * 1. String data field named Symbol for the Stock's symbol
 * 2. String data field named name for the Stock's name
 * 3. double data field named previousClosingPrice that stores the stock price the previous day
 * 4. double data field named currentPrice that stores the stock price for the current time
 * 5. A constructor that creates a stock with the specified symbol and name
 * 6. a method named getChangePercent() that returns the percentage changed from 
 * the previousStockPrice to the currentStockPrice
 * 
 * Test:
 * 1. creates a stock object with stock symbol ORCL
 * 2. the name oracle corporation
 * 3. previous price of 34.5
 * 4. current price of 34.35
 * 5. display the price-change percentage
 *
 */

public class Stock {
	String symbol;
	String name;
	static double previousClosingPrice;
	double currentPrice;
	
	Stock(String sym, String compname) {
		this.symbol= sym;
		this.name= compname;
	}
	public String returnName() {
		return symbol + name;
	}
	public double closingPrice(double price) {
		Stock.previousClosingPrice= price; //since this is static, access needs to be class.datafield
		return previousClosingPrice;
	}
	public double currPrice(double curprice) {
		this.currentPrice= curprice;
		return currentPrice;
	}
	public double pricePercent() {
		return ((currentPrice- previousClosingPrice)*100)/100;
		
	}
	
	public static void main(String[] args) {
		Stock stock1= new Stock("ORCL", "Oracle Corporation");
		System.out.println("current price stock is: "+stock1.currPrice(34.5));
		System.out.println("Closing price for this stock is: "+stock1.closingPrice(34.35));
		System.out.println("percentage:"+ stock1.pricePercent()+ "%");
	
	}

}
