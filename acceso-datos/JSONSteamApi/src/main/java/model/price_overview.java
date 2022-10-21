package model;

public class price_overview {
	private String currency;
	private Long final_formatted;
	
	public String getCurrency() {
		return currency;
	}
	public Long getFinal_formatted() {
		return final_formatted;
	}
	
	@Override
	public String toString() {
		return "price_overview [currency=" + currency + ", final_formatted=" + final_formatted + "]";
	}
	
	
	
}
