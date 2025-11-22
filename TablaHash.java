import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TablaHash {
    public static void main(String[] args) {

        String archivoEntrada = "victor.txt";
        String archivoSalida = "nombresTablaHash_ordenados.txt";

        HashMap<Integer, String> tablaHash = new HashMap<>();


        try (BufferedReader br = new BufferedReader(new FileReader(archivoEntrada))) {
            String linea;
            int id = 1;

            while ((linea = br.readLine()) != null) {
                tablaHash.put(id, linea.trim());
                id++;
            }
        } 
        catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return;
        }

        System.out.println("Datos originales en la tabla Hash:");
        for (Map.Entry<Integer, String> entry : tablaHash.entrySet()) {
            System.out.println("ID " + entry.getKey() + ": " + entry.getValue());
        }

       


        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoSalida))) {
            for (String nombre : listaOrdenada) {
                bw.write(nombre);
                bw.newLine(); 
            }
            System.out.println("\n Archivo generado exitosamente: " + archivoSalida);
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo ordenado: " + e.getMessage());
        }
    }
}
