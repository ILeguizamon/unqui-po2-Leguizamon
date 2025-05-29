package ar.edu.unq.po2.tp7.composite.ejercicio5UML;

public class SpecialProduct extends Product {
	private float specialPrice;

	public SpecialProduct(float specialPrice, String name) {
		super(specialPrice, name);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public float getPrice() {
		return specialPrice;
	}
	
}
