package ar.edu.unq.po2.tp5.colecciones;

import java.util.Collection;
import java.util.List;

public class ColeccionadorDeObjetos {

	public Object getFirstFrom(List<Object> collection) {
		return collection.get(0);
	}

	public void addLast(Object element, List<Object> collection) {
		collection.add(element);
	}

	public Collection<Object> getSubCollection(List<Object> collection, int x, int y) {
		return collection.subList(x, y);
	}
	
	// Verifica si una colección de cualquier tipo contiene un elemento específico <?>.
	public Boolean containsElement(Collection<?> collection, Object element) {
		return collection.contains(element);
	}

}
