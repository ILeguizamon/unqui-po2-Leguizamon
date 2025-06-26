package ar.edu.unq.po2.strategy.encriptacion;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class EncriptacionTest {

    @Test
    public void testCambioOrden() {
        Encriptacion cambioOrden = new EncriptarPorCambioDeOrden();
        String textoOriginal = "hola mundo que tal";
        String textoEncriptado = cambioOrden.encriptar(textoOriginal);
        String textoDesencriptado = cambioOrden.desencriptar(textoEncriptado);

        assertEquals("tal que mundo hola", textoEncriptado);
        assertEquals(textoOriginal, textoDesencriptado);
    }

    @Test
    public void testEncriptarPorCambioDeVocales() {
        Encriptacion cambioVocales = new EncriptarPorCambioDeVocales();
        String textoOriginal = "casa abierta";

        String textoEncriptadoEsperado = "cese eboirte"; // resultado correcto según reglas
        String textoEncriptado = cambioVocales.encriptar(textoOriginal);
        String textoDesencriptado = cambioVocales.desencriptar(textoEncriptado);

        assertEquals(textoEncriptadoEsperado, textoEncriptado);
        assertEquals(textoOriginal, textoDesencriptado);
    }

    @Test
    public void testEncriptarPorNumero() {
        Encriptacion encriptarPorNumero = new EncriptarPorNumero();
        String textoOriginal = "Diego";
        String textoEncriptado = encriptarPorNumero.encriptar(textoOriginal);
        String textoDesencriptado = encriptarPorNumero.desencriptar(textoEncriptado);

        assertEquals("4,9,5,7,15", textoEncriptado);
        assertEquals("diego", textoDesencriptado);
    }
}
