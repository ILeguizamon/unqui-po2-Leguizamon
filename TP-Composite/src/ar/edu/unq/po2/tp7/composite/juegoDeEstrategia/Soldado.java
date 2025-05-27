package ar.edu.unq.po2.tp7.composite.juegoDeEstrategia;

public abstract class Soldado {
    protected Punto ubicacion;
    protected Mapa mapaActual;
    
    public Soldado(Punto ubicacion, Mapa mapaActual) {
        this.ubicacion = ubicacion;
        this.mapaActual = mapaActual;
    }
    
    
    public Punto getUbicacion() {
		return ubicacion;
	}


	public Mapa getMapaActual() {
		return mapaActual;
	}


	public Punto ubicacionActual() {
        return this.ubicacion;
    }

    // Método para iniciar la caminata
    public void caminar(Punto destino) {
        while (!this.ubicacion.equals(destino)) {
            moverA(destino); // Llama al método específico para mover de acuerdo al tipo de soldado
        }
    }

    // Método abstracto que será implementado por cada tipo de soldado
    public abstract void moverA(Punto destino);
}

/*

(Strategy): Este patrón se utiliza porque el comportamiento del movimiento de los personajes (como el movimiento en zigzag para el caballero o la colocación de laja para el ingeniero) se puede variar sin modificar la estructura de las clases base. Cada tipo de personaje implementa su propia estrategia de movimiento, lo que permite que el comportamiento varíe de manera flexible.

Participantes:

Contexto (Soldado): La clase base que solicita la estrategia.

Estrategias concretas (Caballero, Ingeniero): Clases que implementan diferentes formas de mover a los personajes.

-----------------------------------------------------------------------------------------------------------------------------------------------
(Composite): El Ejercito es un ejemplo de patrón compuesto, ya que se comporta como una colección de personajes, pero también puede manipularlos como una sola entidad. 
El ejército puede mover todos sus soldados a un destino sin necesidad de saber el tipo de cada soldado.

Participantes:

Componente (Soldado): Clase base.

Hoja (Caballero, Ingeniero): Las subclases que implementan los comportamientos específicos.

Componente compuesta (Ejercito): La clase que contiene a varios personajes y gestiona sus acciones.

-----------------------------------------------------------------------------------------------------------------------------------------------
(Abstract Method): Se utiliza el método moverA en la clase Personaje para que cada tipo de personaje implemente su propia lógica de movimiento. Esto proporciona un comportamiento polimórfico donde el tipo de personaje define el comportamiento de movimiento.

Participantes:

Clase abstracta (Personaje): Define el método abstracto moverA.

Subclases (Caballero, Ingeniero): Implementan su propia lógica para el movimiento



Conclusión:
Esta solución permite modelar soldados con comportamientos distintos, pero comunes en cuanto a la acción de moverse dentro de un mapa. Los patrones de diseño utilizados aseguran flexibilidad y escalabilidad, permitiendo añadir más tipos de personajes o comportamientos sin afectar el sistema central del juego.



*/