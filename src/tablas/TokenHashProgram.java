/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tablas;

import java.util.HashMap;

import java.util.HashMap;
import java.util.Scanner;

import java.util.HashMap;
import java.util.Scanner;

public class TokenHashProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese varias líneas de texto:");
        StringBuilder codigoBuilder = new StringBuilder();
        while (true) {
            String linea = scanner.nextLine();
            if (linea.isEmpty()) {
                break;
            }
            codigoBuilder.append(linea).append("\n");
        }

        String codigo = codigoBuilder.toString();

        HashMap<String, String> tablaHash = new HashMap<>();
        String[] lineas = codigo.split("\n");

        int fila = 0;
        for (String linea : lineas) {
            String[] tokens = linea.split("(?<=[^a-zA-Z0-9])|(?=[^a-zA-Z0-9])");
            int columna = 0;
            for (String token : tokens) {
                token = token.trim();
                if (!token.isEmpty()) {
                    String posicion = "(" + fila + "," + columna + ")";
                    tablaHash.put(posicion, token);
                    columna++;
                }
            }
            fila++;
        }

        System.out.println("Tabla Hash generada:");
        for (String posicion : tablaHash.keySet()) {
            String token = tablaHash.get(posicion);
            System.out.println("Clave: " + posicion + ", Token: " + token);
        }

        System.out.println("Ingrese la clave de búsqueda (fila,columna):");
        String claveBusqueda = scanner.nextLine();
        String tokenEncontrado = tablaHash.get(claveBusqueda);
        if (tokenEncontrado != null) {
            System.out.println("Token encontrado: " + tokenEncontrado);
        } else {
            System.out.println("La clave no existe en la tabla hash.");
        }
    }
}
