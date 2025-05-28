##Ejercicio 2 - Cultivos
###1. Que impacto genera su diseño el hecho de compartir instancias de parcelas entre composiciones? Es decir, que la misma instancia se encuentre en más de una composición

La misma parcela cambia su valor interno (subDivisiones) cada vez que se la usa en una porción compuesta distinta, lo que puede provocar resultados incorrectos o inconsistentes en el cálculo de la ganancia anual.

###3. Describa las alternativas que puede utilizar para calcular la ganancia anual.

- 1) Usar un atributo mutable (subDivisiones): Cada porción guarda internamente cuántas subdivisiones tiene.
- 2) Pasar la cantidad de divisiones como parámetro:El método gananciaAnual(int divisiones) recibe cuántas divisiones tiene desde afuera.

###4. Explique la discusión sobre quiénes deben implementar las operaciones de agregado y borrado de hijos.

Solo las composiciones implementen esas operaciones (PorcionCompuesta) y las hojas (PorcionDeSoja, PorcionDeTrigo) no deberían tener métodos para agregar o eliminar hijos, porque no tienen hijos. Esto respeta el principio de responsabilidad única y evita errores.

###5. Sobre su implementación, indique los roles que desempeñan cada una de las clases diseñadas en relación al patrón Composite.

- Component: Porcion
- Composite: PorcionCompuesta
- leaf: PorcionDeSoja, PorcionDeTrigo

***
***
***

##Ejercicio 3 - Juego de estrategia

###(Strategy): Este patrón se utiliza porque el comportamiento del movimiento de los personajes (como el movimiento en zigzag para el caballero o la colocación de laja para el ingeniero) se puede variar sin modificar la estructura de las clases base. Cada tipo de personaje implementa su propia estrategia de movimiento, lo que permite que el comportamiento varíe de manera flexible.

###Participantes:

- Contexto (Soldado): La clase base que solicita la estrategia.
- Estrategias concretas (Caballero, Ingeniero): Clases que implementan diferentes formas de mover a los personajes.

###(Composite): El Ejercito es un ejemplo de patrón compuesto, ya que se comporta como una colección de personajes, pero también puede manipularlos como una sola entidad. El ejército puede mover todos sus soldados a un destino sin necesidad de saber el tipo de cada soldado.

###Participantes:

- Componente (Soldado): Clase base.
- Hoja (Caballero, Ingeniero): Las subclases que implementan los comportamientos específicos.
- Componente compuesta (Ejercito): La clase que contiene a varios personajes y gestiona sus acciones.