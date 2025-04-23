# TP 2 UML - IVAN LEGUIZAMON


# Ejercicio 1:

# C) Muestre en dos scripts de código cómo instancia un escenario concreto en el cual se dispare: 

    #I) el cálculo del total de sueldos neto  
    #II) la liquidación de sueldo.

Se encuentra en la carpeta test >> ar.edu.leguizamon.tp2 >> EmpresaTest.java


# Ejercicio 2:
# C) Para realizar esta extensión del modelo, ¿necesitó modificar la clase Empresa? ¿Por qué?

No fue necesario modificar la clase Empresa para incorporar al empleado contratado, ya que el diseño del sistema ya contemplaba el uso de polimorfismo. La clase Empresa interactúa con los empleados de manera abstracta, sin necesidad de saber si se trata de un empleado permanente, temporario o contratado. Simplemente solicita las operaciones necesarias (como la generación del recibo o el cálculo del sueldo) y cada tipo de empleado responde con su propia lógica, respetando el principio de polimorfismo. Esto permitió que la integración del nuevo tipo de empleado fuera directa, sin afectar el funcionamiento general.
