package ar.edu.unq.po2.tp3;

import java.util.ArrayList;
import java.util.List;

public class EquipoDeTrabajo {
    private String nombre;
    private List<Persona> equipo;
    
    // ---------------- CONSTRUCTOR -----------------------------
    public EquipoDeTrabajo(String nombre) {
        this.nombre = nombre;
        this.equipo = new ArrayList<Persona>();
    }
    
    // ---------------- GETTERS & SETTERS -----------------------------
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Persona> getEquipo() {
        return equipo;
    }

    public void setEquipo(List<Persona> equipo) {
        this.equipo = equipo;
    }
    
    // ---------------- MÉTODOS -----------------------------
    public void agregarPersona(Persona persona) {
        getEquipo().add(persona);
    }
    
    public double promedioEdad() {
        int sumaEdades = 0;
        
        if (equipo.isEmpty()) {
            return 0;
        } else {
            for (Persona persona : equipo) {
                sumaEdades += persona.getEdad();
            }
        }
        return (double) (sumaEdades / equipo.size());
    }

    public void presentacion() {
        System.out.println("El equipo de trabajo se llama: " + this.getNombre());
        for (Persona persona : equipo) {
            System.out.println(persona.getNombre() + " - Edad: " + persona.getEdad());
        }
        System.out.println("Promedio de edad: " + this.promedioEdad());
    }
}
