package model;

public class Product {
	private int id;
    private String name;
    private Amount publicPrice;
    private Amount wholesalerPrice;
    private boolean available;
    private int stock;
    private static int totalProducts;
    private String Currency;
    
    static double EXPIRATION_RATE=0.60;
    
    public Product(String name, double wholesalerPrice, boolean available, int stock) {
		super();
		this.id = totalProducts+1;
		this.name = name;
		this.publicPrice = new Amount(wholesalerPrice * 2);
        this.wholesalerPrice = new Amount(wholesalerPrice);
		this.available = available;
		this.stock = stock;
		totalProducts++;
	}
    
    //constructor for xml
    public Product(String name) {
    	this.name = name;
    }
    
	public void setCurrency(String Currency) {
		this.Currency = (Currency);
	}

	public String getCurrency() {
		return this.Currency;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Amount getPublicPrice() {
		return publicPrice;
	}

	public void setPublicPrice(Amount publicPrice) {
		this.publicPrice = publicPrice;
	}

	public Amount getWholesalerPrice() {
		return wholesalerPrice;
	}

	public void setWholesalerPrice(Amount wholesalerPrice) {
		this.wholesalerPrice = wholesalerPrice;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public static int getTotalProducts() {
		return totalProducts;
	}

	public static void setTotalProducts(int totalProducts) {
		Product.totalProducts = totalProducts;
	}

	
	public Amount expire() {
		double newPublicPriceValue = this.getPublicPrice().getValue() * EXPIRATION_RATE;
		this.publicPrice.setValue(newPublicPriceValue);
		return this.publicPrice;
	}

	@Override
	public String toString() {
		return "Product [name=" + this.name + ", stock=" + this.stock + "]";
	}


    
}
