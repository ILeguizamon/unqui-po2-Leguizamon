package ar.edu.unq.po2.tp5.mercadoCentral;

import java.util.ArrayList;
import java.util.List;

public class Mercado {

    private Inventario inventario;
    private AgenciaRecaudadora agencia;
    private List<Caja> cajas; // Nueva implementación de diseño con multiples cajas para un mercado.


    // Constructor
    public Mercado(Inventario inventario, AgenciaRecaudadora agencia) {
        this.inventario = inventario;
        this.agencia = agencia;
        this.cajas = new ArrayList<>(); // Nuevo.
    }

    // Métodos getter
    public Inventario getInventario() {
        return inventario;
    }

    public AgenciaRecaudadora getAgencia() {
        return agencia;
    }

    // Método para buscar una línea en el inventario
    public LineaInventario buscarLinea(String nombre) {
        return inventario.buscarLinea(nombre);
    }

    // Método para registrar el pago en la agencia
    public void registrarPagoEnAgencia(Factura factura) {
        agencia.registrarPago(factura);
    }
}

