#Ejercicio Caso 1:
## Cambios realizados para cumplir con los principios SOLID

### SRP - Responsabilidad Única

cambios, separar responsabilidades:  
- `ClienteEmail` ahora solo gestiona su bandeja de entrada y conexión.  
- `ServidorPop` se ocupa exclusivamente de enviar, conectar y recibir.  
- `Correo` representa un único mensaje, encapsulando sus datos (asunto, destinatario y cuerpo). 

---

### OCP - Abierto/Cerrado

cambio:
Hice que `ClienteEmail` dependa de una **interfaz (`IServidor`)** en lugar de una clase concreta. Así se puede usar cualquier otro servidor sin tocar el cliente.

---

### LSP - Sustitución de Liskov

cambio:
Me aseguré de que `ServidorPop` implemente correctamente todos los métodos definidos en `IServidor`, lo que permite cambiar una implementación por otra sin romper nada.

---

### ISP - Segregación de Interfaces

cambios:
Simplifiqué la interfaz, dejando solo los métodos realmente útiles para el cliente: `enviar()`, `recibirNuevos()` y `conectar()`.

---

### DIP - Inversión de Dependencias

cambios:
Ahora `ClienteEmail` trabaja con la abstracción `IServidor`, lo que permite inyectar cualquier tipo de servidor sin cambiar el código del cliente.

***
***
***
 
#Ejercicio Banco y Préstamos

## 2. Justificación según los principios SOLID

###Principio de Responsabilidad Única (SRP)

Cada clase del modelo tiene una única responsabilidad clara:

- **`Cliente`**: representa a una persona que solicita un crédito, encapsulando sus datos personales y financieros.
- **`Banco`**: gestiona clientes y solicitudes de crédito, encargándose del registro y desembolso.
- **`SolicitudDeCredito`** (y sus subclases): encapsulan la lógica de validación de los distintos tipos de crédito.

**Cómo se aplicó:**  
Se separaron las responsabilidades entre clases para evitar mezclar lógica de distintos dominios, facilitando el mantenimiento y la evolución del sistema.

---

###Principio de Abierto/Cerrado (OCP)

El modelo está abierto a la extensión pero cerrado a la modificación:

- **`SolicitudDeCredito`** es una clase abstracta que define el comportamiento común.
- Se pueden agregar nuevas subclases (como `SolicitudDeCreditoHipotecario`) sin modificar el resto del sistema (`Banco`, `Cliente`).

**Cómo se aplicó:**  
Se utilizó una clase abstracta como base, delegando el comportamiento específico a las subclases mediante **polimorfismo**.

---

###Principio de Sustitución de Liskov (LSP)

Las subclases pueden reemplazar a su clase padre sin alterar la funcionalidad del sistema:

- Todas las subclases de **`SolicitudDeCredito`** implementan correctamente el método `esAceptable()` y funcionan de manera coherente al ser utilizadas por `Banco`.

**Cómo se aplicó:**  
Se garantizó que todas las subclases respeten la interfaz definida por la clase abstracta `SolicitudDeCredito`, implementando su método abstracto de manera consistente.

---

###Principio de Segregación de Interfaces (ISP)

Las clases no se ven forzadas a implementar métodos que no utilizan:

- El modelo no define interfaces con métodos innecesarios.
- Cada clase implementa solo lo que necesita, evitando dependencias artificiales.

**Cómo se aplicó:**  
Se diseñaron clases simples y enfocadas en su propósito, sin obligarlas a implementar funcionalidades que no requieren.

---

###Principio de Inversión de Dependencias (DIP)

El modelo depende de **abstracciones**, no de implementaciones concretas:

- `Banco` trabaja con la abstracción **`SolicitudDeCredito`**, sin conocer detalles de las subclases específicas (personal, hipotecaria, etc.).

**Cómo se aplicó:**  
Se diseñó el sistema para que `Banco` interactúe con la clase abstracta `SolicitudDeCredito`, permitiendo la incorporación de nuevas solicitudes sin modificar su lógica interna.

---
