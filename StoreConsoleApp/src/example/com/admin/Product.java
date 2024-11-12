package example.com.admin;

public class Product {
	public String name;
	double price;
	String description;
	String category;
	
	public Product(String name, double price, String description, String category) {
		this.name = name;
		this.price = price;
		this.description = description;
		this.category = category;
	}
	

    public String toCSV() {
        return name + "," + price + "," + description + "," + category;
    }
	
	@Override
	public String toString() {
		return "🛍️ Продукт: " + name + ", Цена: " + price + " руб." + ", Описание: " + description + ", Категория: " + category;
	}
}
