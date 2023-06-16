/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject2;

/**
 *
 * @author benja
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Mavenproject2 {
    public static void main(String[] args) {
        try {
            // Especifica la URL desde donde se desea consumir los datos
            String urlString = "https://api.gael.cloud/general/public/sismos";
            
            // Crea un objeto URL
            URL url = new URL(urlString);
            
            // Abre una conexión HTTP hacia la URL
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            
            // Establece el método de solicitud (GET por defecto)
            conn.setRequestMethod("GET");
            
            // Obtiene el código de respuesta HTTP
            int responseCode = conn.getResponseCode();
            
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Lee la respuesta del servidor línea por línea
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();
                
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                
                // Muestra la respuesta obtenida
                System.out.println(response.toString());
                reader.close();
            } else {
                System.out.println("Error en la conexión. Código de respuesta: " + responseCode);
            }
            
            // Cierra la conexión
            conn.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
