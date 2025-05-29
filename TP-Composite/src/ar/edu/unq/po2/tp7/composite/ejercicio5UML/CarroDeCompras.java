package ar.edu.unq.po2.tp7.composite.ejercicio5UML;

import java.util.ArrayList;
import java.util.List;

public class CarroDeCompras {
	private List<Product> products;
	
	public CarroDeCompras() {
		this.products = new ArrayList<Product>();
	}
	
	public void setElements(List<Product> productos) {
		this.products = productos;
	}
	
	public List<Product> getElements(){
		return products;
	}
	
	public int totalRounded() {
		float montoTotal = 0;
		for(Product p : products) {
			montoTotal += p.getPrice();
		}
		return Math.round(montoTotal);
	}
	
	public float total() {
		float montoTotal = 0;
		for(Product p : products) {
			montoTotal += p.getPrice();
		}
		return montoTotal;
	}
}
