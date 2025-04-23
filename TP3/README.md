#*Ejercicio 4) Examinar las expresiones:*

**Demostración en la clase Prueba**.

---
---
#*Ejercicio 5) Tipos primitivos:*
<br>

# 1. ¿Qué son los tipos de datos primitivos?

En Java, los tipos de datos primitivos son los tipos más simples de datos que existen y están integrados en el lenguaje. Representan valores literales y no son objetos. Java define 8 tipos de datos primitivos, que se utilizan para almacenar valores de diferentes categorías de datos:

- **byte**: 8 bits (rango de -128 a 127).
- **short**: 16 bits (rango de -32,768 a 32,767).
- **int**: 32 bits (rango de -2³¹ a 2³¹ - 1).
- **long**: 64 bits (rango de -2⁶³ a 2⁶³ - 1).
- **float**: 32 bits (números de coma flotante, precisión de 6-7 dígitos decimales).
- **double**: 64 bits (números de coma flotante, precisión de 15-16 dígitos decimales).
- **char**: 16 bits (representa un solo carácter Unicode).
- **boolean**: 1 bit (valores `true` o `false`).


# 2. ¿Cuál es la diferencia entre un int y un Integer?

- **int**: Es un tipo de dato primitivo que representa un número entero de 32 bits. No tiene métodos asociados ni permite ser nulo.

- **Integer**: Es una clase envolvente (*wrapper class*) de Java que envuelve el tipo primitivo `int` en un objeto. La clase `Integer` proporciona métodos útiles como `parseInt`, `valueOf`, entre otros, y permite trabajar con valores nulos. Es parte del paquete `java.lang`.

**Diferencias clave:**

- `int` es un tipo primitivo, mientras que `Integer` es una clase.
- `Integer` puede ser `null` (ya que es un objeto), mientras que `int` no puede.
- `Integer` ofrece métodos adicionales para trabajar con números enteros.

#3. ¿Si se define una variable de instancia de tipo int cual sería su valor predeterminado? ¿Y si se define una de tipo Integer? Haga la prueba en Eclipse.

- **int**: Las variables de instancia de tipo primitivo tienen un valor predeterminado. Si no se les asigna ningún valor, el valor predeterminado para un int es 0.

- **Integer**: Las variables de instancia de tipo Integer (como es una clase) tienen un valor predeterminado de null.

**Demostración de las variables de instancia de tipo int e Integer en la clase Prueba**.


# 4. Responder la pregunta del punto anterior (3), pero ahora en lugar de definir una variable de instancia se define una variable de método.

**Demostración en la clase Prueba**.

---
---
#*Ejercicio 7) Jerarquía de paquetes:*
<br>

# 1. ¿Cómo están organizadas en el sistema de archivos?
En el sistema de archivos, los paquetes se representan como directorios dentro de la carpeta raíz del proyecto (en este caso model).

**Dentro de la carpeta `Images` hay una imagen llamada `directorio2.0` donde se puede observar la estructura de directorio**
            
El archivo MainAPP.java está en la carpeta model.

El archivo ColeccionElementos.java está en la subcarpeta model/stack.

El archivo InterfazUsuario.java está en la subcarpeta model/gui.

# 2. ¿Encuentra alguna relación entre el nombre del paquete y la ubicación de los archivos fuentes de las clases (.java) y los archivos compilados (.class)?

Sí, la estructura de los paquetes en Java refleja directamente la ubicación de los archivos en el sistema de archivos. Por ejemplo, el paquete model.stack tiene sus clases en el directorio model/stack/, y cuando se compilan, los archivos .class se colocan en la misma estructura de directorios.

---
---
#*Ejercicio 10) Encapsulamiento:*
<br>

# 1. Responder: Si un objeto cualquiera que le pide la edad a una Persona: ¿Conoce cómo ésta calcula u obtiene tal valor? ¿Cómo se llama el mecanismo de abstracción que permite esto?

No, el objeto que le pide la edad a la Persona no necesita conocer cómo se calcula internamente. Solo sabe que la Persona le puede responder ese mensaje (getEdad()), pero no necesita saber que lo calcula usando la fecha de nacimiento.
Esto es posible gracias a un principio de la Programación Orientada a Objetos llamado: encapsulamiento.




