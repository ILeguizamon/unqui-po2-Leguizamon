package ar.edu.unq.po2.strategy.encriptacion;

import java.util.ArrayList;
import java.util.List;

public class EncriptarPorNumero implements Encriptacion {

    @Override
    public String encriptar(String texto) {
        texto = texto.toLowerCase(); // transformar a minúsculas
        List<String> numeros = new ArrayList<>();

        for (char c : texto.toCharArray()) {
            if (c == ' ') {
                numeros.add("0");
            } else if (c >= 'a' && c <= 'z') {
                int valor = c - 'a' + 1;  // 'a' -> 1, 'b' -> 2 ...
                numeros.add(String.valueOf(valor));
            }
           
        }

        return String.join(",", numeros);
    }

    @Override
    public String desencriptar(String texto) {
        String[] partes = texto.split(",");
        StringBuilder resultado = new StringBuilder();

        for (String numStr : partes) {
            int num = Integer.parseInt(numStr);
            if (num == 0) {
                resultado.append(' ');
            } else if (num >= 1 && num <= 26) {
                char letra = (char) ('a' + num - 1);
                resultado.append(letra);
            }
           
        }

        return resultado.toString();
    }
}

