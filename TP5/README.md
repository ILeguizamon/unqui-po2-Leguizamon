#La caja del Mercado Central - Parte 1

1) UML (basado en la primera parte del ejericio) dentro de la carpeta "UML - Imagenes"

#La caja del Mercado Central - Parte 2

**¿Es posible diseñar una nueva solución al problema de cobrar en las cajas tanto productos como servicio alterando lo menos posible la solucion existente? ¿Cómo?**

Sí, es posible diseñar una nueva solución sin modificar demasiado el sistema existente.
Para lograrlo, se puede crear una interfaz llamada Cobrable, que tenga el método getMonto().
Luego, tanto los Productos como las Facturas (de servicio o de impuesto) pueden implementar la interfaz Cobrable.

De esta manera, la Caja puede trabajar de forma polimórfica: no necesita saber si está cobrando un Producto o una Factura, solo le pide el monto a través del método getMonto().
Así, se extiende el comportamiento para soportar nuevos tipos de cobrables sin romper el código ya existente.

#De Smalltalk a Java: Personas y Mascotas

** 4. durante la iteración, ¿fue necesario distinguir si el objeto era una Persona o una Mascota para poder imprimir su nombre? ¿Cómo se llama el macanismo de abstracción que permite eso?**

En mi primera implementación utilicé una colección de tipo Object, lo que permite almacenar cualquier tipo de objeto (ya sea Persona, Mascota, o cualquier otro).
Sin embargo, al usar Object, no pude aprovechar el polimorfismo de forma natural, porque Object no define un método getNombre().
Por eso, fue necesario hacer un instanceof y un casteo para distinguir entre Persona y Mascota, y así poder acceder a sus métodos específicos.

En la segunda implementación, utilicé una interfaz llamada Nombrable que es implementada tanto por Persona como por Mascota. Esto me permitió trabajar directamente sobre una colección de tipo List<Nombrable>.
El mecanismo de abstracción aplicado es el polimorfismo, lo que permite interactuar con distintos tipos de objetos a través de una interfaz común (Nombrable), sin necesidad de conocer su tipo concreto.

** 5. ¿Podría asegurar que tanto mascotas como personas respondan al mensaje getName() mediante herencia? ¿Cómo? ¿Qué ocurre si Persona es subclase de otra clase que no puede ser modificada por usted?¿De qué otra manera puede asegurar el polimorfismo, teniendo en cuentra que stá implementada en Java? **

**- ¿Podría asegurar que tanto mascotas como personas respondan al mensaje getName() mediante herencia? ¿Cómo?**

Sí, podrías hacerlo si creás una superclase abstracta (por ejemplo Ser) que tenga un método getNombre(), y hacés que tanto Persona como Mascota hereden de esa clase Ser.

**- ¿Qué ocurre si Persona es subclase de otra clase que no puede ser modificada por usted?¿De qué otra manera puede asegurar el polimorfismo, teniendo en cuentra que stá implementada en Java? **

Si Persona ya es subclase de otra clase que no podés modificar, no podrías usar herencia para asegurar el polimorfismo, pero sí podrías usar una interfaz para garantizar que implemente el método necesario.