package ar.edu.unq.po2.tp7.composite.ejercicio5UML;

public class Product {
	private float price;
	private String name;
	
	public Product(float price, String name) {
		super();
		this.price = price;
		this.name = name;
	}
	
	public float getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}

}
