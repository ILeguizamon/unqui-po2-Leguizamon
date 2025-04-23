package ar.edu.unq.po2.tp3;

// --------------------- EJERCICIOS 4 y 5 ---------------------

public class Prueba {
    public static void main(String[] args) {

        // --------------------- EJERCICIO 4 - Expresiones con String ---------------------

        String a = "abc";
        String s = a;
        String t;  // Declarada pero no inicializada

        System.out.println("s.length(): " + s.length());  // Devuelve 3, longitud de "abc"

        // System.out.println("t.length(): " + t.length());
        // Esta línea da error si se descomenta, porque 't' no fue inicializada

        System.out.println("1 + a: " + (1 + a));  // Concatenación: "1abc"
        System.out.println("a.toUpperCase(): " + a.toUpperCase());  // "ABC", convierte a mayúsculas
        System.out.println("\"Libertad\".indexOf(\"r\"): " + "Libertad".indexOf("r"));  // 4, posición de 'r'
        System.out.println("\"Universidad\".lastIndexOf('i'): " + "Universidad".lastIndexOf('i'));  // 7
        System.out.println("\"Quilmes\".substring(2,4): " + "Quilmes".substring(2,4));  // "il", subcadena
        System.out.println("(a.length() + a).startsWith(\"a\"): " + (a.length() + a).startsWith("a"));  // false
        System.out.println("s == a: " + (s == a));  // true, apuntan al mismo objeto
        System.out.println("a.substring(1,3).equals(\"bc\"): " + a.substring(1, 3).equals("bc"));  // true

        // --------------------- EJERCICIO 5 - Valores por defecto ---------------------

        // Simulación de valores por defecto de atributos de instancia
        mostrarValoresPorDefecto();

        // Variables locales de método
        int numeroIntMetodo = 5;  // Variable primitiva
        Integer numeroIntegerMetodo = 10;  // Wrapper de tipo objeto

        System.out.println("Valor de numeroIntMetodo (método): " + numeroIntMetodo);  // 5
        System.out.println("Valor de numeroIntegerMetodo (método): " + numeroIntegerMetodo);  // 10
    }

    // Método para simular los valores por defecto (como si fueran atributos de instancia)
    public static void mostrarValoresPorDefecto() {
        int numeroInt = 0;  // Simulación del valor por defecto (en realidad, las variables locales deben inicializarse)
        Integer numeroInteger = null;  // Simulación de valor por defecto de un objeto (Integer)

        System.out.println("Valor simulado por defecto de numeroInt (instancia): " + numeroInt);
        System.out.println("Valor simulado por defecto de numeroInteger (instancia): " + numeroInteger);
    }
}
