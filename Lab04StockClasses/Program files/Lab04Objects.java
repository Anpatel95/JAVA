
public class Lab04Objects {

	private String ticker;// string ticker
	private double stockPrice;//double value of the stock price
	private double numstock;// double value of the number of stock
	private double dividend;// double vale of the dividend
	
	

	//constructors
	//constructor to create object and set all class fields
	public Lab04Objects(String ticker, double stockPrice, double numshares, double dividend){
		
		setTicker(ticker);
		setStockPrice(stockPrice);
		setNumStock(numshares);
		setDividend(dividend);
		
		
	}//ends
	//noArg constructor to create object and set all class fields to default values
	public Lab04Objects(){
		setTicker(null);
		setStockPrice(0.0);
		setNumStock(0.0);
		setDividend(0.0);
	}//ends
	
	
	//class methods to store values in class fields – “set” methods
	private void setTicker(String Ticker){ 
		ticker = Ticker;
		
	}
	//get the ticker
	public String getTicker(){
		return ticker;
		
	}
	//class methods to store values in class fields – “set” methods
	public void setStockPrice(double StockPrice){
		
		stockPrice = StockPrice;
		
		
	}
	//get the stock Price
	public double getStockPrice(){
		return stockPrice;
	}
	//class methods to store values in class fields – “set” methods
	public void setNumStock(double NumStock){
		numstock = NumStock;
	}
	//get the number of stock
	public double getNumStock(){
		return numstock;
	}
	
	
	//class methods to store values in class fields – “set” methods
	public void setDividend(double DiVidend){
		dividend = DiVidend;
	}
	//get the dividend
	public double getDividend(){
		return dividend;
	}
	
	//calculate the stock value
	public double calStockValue(){
		double Stockval ;
		Stockval = numstock * stockPrice;
		Stockval = Math.round (Stockval * 100.0) / 100.0;
		
		
		return Stockval;//return value
				
				
	}
	//calculate annual dividend
	public double calyielddivi(){
		
		double yield ;
		yield = dividend /stockPrice;
		double peryield;
		peryield = yield*100;
		peryield= Math.round (peryield * 100.0) / 100.0;
		
		
		return peryield;//return value
		
	}
	
	
	
	
	
}
