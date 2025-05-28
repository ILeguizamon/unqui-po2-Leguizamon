package ar.edu.unq.po2.tp7.composite.sistemaDeArchivos;

import java.time.LocalDate;

public interface FyleSystem {
    
    /**
     * Retorna el total ocupado en disco del receptor.
     * Expresado en cantidad de bytes.
     */
    public int totalSize();

    /**
     * Imprime en consola el contenido indicando el nombre del elemento 
     * e indentándolo con tantos espacios como profundidad en la estructura.
     */
    public void printStructure();

    /**
     * Elemento más nuevo.
     */
    public FyleSystem lastModified();

    /**
     * Elemento más antiguo.
     */
    public FyleSystem oldestElement();
    
    
    
    //Nuevo Método que sirve para comparar fechas (usado en la clase Directorio)
    public LocalDate getFechaDeModificacion();
}

