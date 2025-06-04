package ar.edu.unq.po2.tp5.colecciones;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MascotaPersonaInstancias {

    public static void main(String[] args) {

        // 2 Instancias de Persona y Mascota
        Persona persona1 = new Persona("Juan", LocalDate.of(2000, 5, 10));
        Persona persona2 = new Persona("Matias", LocalDate.of(2012, 10, 20));
        Mascota mascota1 = new Mascota("Mario", "Caniche");
        Mascota mascota2 = new Mascota("Melina", "Siamés");

        // ---------------- Primera implementación --------------------

        // Colección donde se guardarán las instancias creadas
        List<Object> coleccion = new ArrayList<>();

        // Agrego las personas y mascotas en la colección
        coleccion.add(persona1);
        coleccion.add(persona2);
        coleccion.add(mascota1);
        coleccion.add(mascota2);

        // Itera sobre la colección y verifica el tipo de cada objeto para poder imprimir el nombre
        for (Object elemento : coleccion) {
            if (elemento instanceof Persona) {
                Persona persona = (Persona) elemento;
                System.out.println("nombre persona: " + persona.getNombre());
            } else if (elemento instanceof Mascota) {
                Mascota mascota = (Mascota) elemento;
                System.out.println("nombre mascota: " + mascota.getNombre());
            }
        }

        // ---------------- Segunda implementación --------------------

        // Colección de tipo Nombrable, una interfaz que exige tener un método getNombre()
        List<Nombrable> lista = new ArrayList<>();

        // Agrego personas y mascotas, ya que ambas implementan Nombrable
        lista.add(persona1);
        lista.add(persona2);
        lista.add(mascota1);
        lista.add(mascota2);

        // Itera directamente, usando polimorfismo gracias a la interfaz
        for (Nombrable item : lista) {
            System.out.println("nombre: " + item.getNombre());
        }
    }
}
