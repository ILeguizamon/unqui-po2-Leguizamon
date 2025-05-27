##1. Que impacto genera su diseño el hecho de compartir instancias de parcelas entre composiciones? Es decir, que la misma instancia se encuentre en más de una composición

La misma parcela cambia su valor interno (subDivisiones) cada vez que se la usa en una porción compuesta distinta, lo que puede provocar resultados incorrectos o inconsistentes en el cálculo de la ganancia anual.

##3. Describa las alternativas que puede utilizar para calcular la ganancia anual.

- 1) Usar un atributo mutable (subDivisiones): Cada porción guarda internamente cuántas subdivisiones tiene.
- 2) Pasar la cantidad de divisiones como parámetro:El método gananciaAnual(int divisiones) recibe cuántas divisiones tiene desde afuera.

##4. Explique la discusión sobre quiénes deben implementar las operaciones de agregado y borrado de hijos.

Solo las composiciones implementen esas operaciones (PorcionCompuesta) y las hojas (PorcionDeSoja, PorcionDeTrigo) no deberían tener métodos para agregar o eliminar hijos, porque no tienen hijos. Esto respeta el principio de responsabilidad única y evita errores.

##5. Sobre su implementación, indique los roles que desempeñan cada una de las clases diseñadas en relación al patrón Composite.

- Component: Porcion
- Composite: PorcionCompuesta
- leaf: PorcionDeSoja, PorcionDeTrigo