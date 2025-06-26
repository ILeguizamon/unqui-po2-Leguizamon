##Ejercicio 1 - Lea el pattern Template Method y...
###2. Responda:
### A) ¿Dónde se define el esqueleto del algoritmo?
El esqueleto del algoritmo se define en la clase abstracta, mediante un método concreto (el template method) que organiza la secuencia de pasos. Algunos de esos pasos pueden estar implementados (concretos), y otros declarados como métodos abstractos que se implementan en las subclases.

### B) ¿Se puede redefinir el esqueleto?
No debería redefinirse el esqueleto en las subclases.
La idea del patrón es que el template method defina una estructura fija del algoritmo. Lo que sí se redefine son los pasos del algoritmo, no su estructura general.

### C) ¿Qué es lo que se puede redefinir?
Se pueden redefinir los pasos del algoritmo, es decir, los métodos abstractos.
Estos métodos se llaman también "operaciones primitivas".

### D) ¿Qué es un hook method?
Un hook method es un método definido en la clase abstracta que,tiene una implementación por defecto (vacía o mínima),
pero puede ser redefinido por las subclases para modificar o extender el comportamiento del algoritmo.

##Ejercicio 2 - Sueldos recargado
###Participantes:

- Cliente: Empresa
- AbstractClass: Empleado
- ConcreteClass: EmpleadoDePlanta, EmpleadoPasante, EmpleadoTemporario

- Template Method: sueldoFinal() -> define la estructura para calcular el sueldo total.
- Abastract Method: sueldo() -> cada clase concreta debe implementar para definir su lógica específica de cálculo de sueldo.
- Concrete Method: descuentoEnConceptosAportesYObraSocial() -> aplica un descuento estándar.

###Aclaración:
Para evitar que la clase abstracta tenga atributos innecesarios o que no apliquen para todas las subclases, cada subclase define sus propios atributos necesarios para calcular su sueldo de forma específica, haciendo que el diseño sea más limpio, modular y respetando el principio de responsabilidad única.

##Ejercicio 4 - Llamadas telefónicas
- Template Method: costoFinal()
- Operaciones primitivas: esHoraPico(), 
- Operaciones concretas: getTiempo(), getHoraDelDia()
- Hook Method: costoNeto()

##Ejercicio 5 - Ayudando al soberano
- Clase abstracta: CuentaBancaria.
- Clase concreta: CuentaCorriente, CajaDeAhorro.
- Template method: extraer(int monto).
- Operaciones primitivas: puedeExtraer(int monto).
- Operaciones concretas: setSaldo(int monto), getSaldo(), getTitular(), agregarMovimientos(String movimiento)
- Hook methods: No hay.

##Ejercicio 6 – Contestar y justificar las respuestas
###1. Existe más de un tipo de adaptadores, mencione y explique cada uno de ellos.

- 1) Adaptador por clase (usa herencia)  
El adaptador por clase extiende (hereda) de la clase que se quiere adaptar (Adaptee) e implementa la interfaz esperada (Target). Es decir, el adaptador actúa como un puente entre lo que el cliente espera (la interfaz Target) y lo que realmente tiene disponible (la clase Adaptee).
- 2) Adaptador por objeto (usa delegación)  
En vez de heredar del Adaptee, este tipo de adaptador lo contiene como un atributo (composición). Implementa la interfaz Target, pero en lugar de llamar directamente a métodos heredados, le delega las llamadas al Adaptee.

###2. ¿En qué se diferencia un tipo de adaptador del otro?
El adaptador por clase usa herencia, mientras que el adaptador por objeto usa delegación (composición).

###3. ¿Se pueden utilizar ambas alternativas de implementación del patrón en java?.Justifique la respuesta
Sí, en Java se pueden utilizar ambas alternativas de implementación del patrón Adapter: por clase y por objeto.
Sin embargo, en la práctica solo la implementación por objeto (delegación) es completamente flexible y recomendada.

- Java no admite herencia múltiple de clases, por lo tanto, el adaptador por clase solo funciona si el adaptador hereda de una sola clase, lo cual limita su uso.
- En cambio, el adaptador por objeto usa composición (tiene una instancia del objeto que quiere adaptar), lo que es más flexible y reusable.

###4. Ver la interface Enumeration de java y la clase Vector, preste atención a que dicha clase contiene un método "elements()". Explique cómo funciona el patrón adaptery cuáles son los roles de los participantes entre la interface y clase mencionada.Mencione qué tipo de implementación del patrón se utiliza.

El método elements() actúa como un Adaptador:
Convierte una instancia de Vector a una interfaz Enumeration

Roles del Patrón Adapter:
- Target (objetivo): la interfaz que se espera → Enumeration
- Adaptee (adaptado): la clase que ya existe y tiene funcionalidad diferente → Vector
- Adapter (adaptador): el objeto devuelto por elements(), que adapta el Vector al Enumeration

Tipo de implementación utilizada:
- Este es un adaptador por objeto, ya que el objeto devuelto por elements() contiene una referencia al Vector y le delega las llamadas a sus métodos.

###5. Realice el mismo análisis del punto 3, pero con la interface Iterator, la clase ArrayList (preste atención al método "iterator()"). Muestre un ejemplo de funcionamiento y especifique los roles de cada participante

El objeto devuelto por iterator() actúa como un Adapter que permite recorrer un ArrayList usando la interfaz Iterator.

Roles del Patrón Adapter:
- Target (objetivo): la interfaz esperada → Iterator
- Adaptee (adaptado): ArrayList, que tiene internamente una estructura basada en arrays
- Adapter (adaptador): el objeto devuelto por iterator(), que traduce la forma de recorrer el array a la interfaz Iterator

Tipo de implementación utilizada:
- Se trata de un adaptador por objeto, ya que el Iterator devuelto contiene una referencia al ArrayList y le delega las llamadas a sus elementos internamente.