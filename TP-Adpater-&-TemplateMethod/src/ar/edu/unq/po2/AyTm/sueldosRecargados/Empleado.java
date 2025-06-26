package ar.edu.unq.po2.AyTm.sueldosRecargados;

public abstract class Empleado {
	
	public Empleado() {};
	
	/*
	 método final, no se puede sobrescribir (override) en las subclases porque el propósito del patrón Template Method es definir un algoritmo con pasos fijos,
	 donde solo algunos pasos pueden variar y ser definidos por las subclases (los métodos abstractos o hooks).
	*/
	
    public final double sueldoFinal() { // Template Method -> Estructura general: Calcular sueldo, aplicar descuento, devolver el sueldo final.
        double sueldo = this.sueldo(); // sueldo(): cada tipo de empleado implementa su lógica.
        double descuentoDeConceptos = this.descuentoEnConceptosAportesYObraSocial();
        return sueldo - descuentoDeConceptos;
    }
    
    protected double descuentoEnConceptosAportesYObraSocial() {
		return (this.sueldo() * 13) / 100;
	};

	public abstract double sueldo();
	
}
