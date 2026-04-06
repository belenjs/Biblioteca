package controller;

import com.google.gson.Gson;
import model.Libro;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class APIController {

    private static final String URL_LIBROS = "https://stephen-king-api.onrender.com/api/books";

    public List<Libro> obtenerLibrosAPI() {
        List<Libro> listaLibros = new ArrayList<>();
        try {
            // Se crea el objeto que convierte JSON en objetos Java
            Gson gson = new Gson();
            // Crea el cliente HTTP para hacer la petición
            HttpClient client = HttpClient.newHttpClient();
            //Construye la petición GET a la API
            HttpRequest request = HttpRequest
                    .newBuilder()
                    .uri(URI.create(URL_LIBROS))
                    .GET()
                    .build();
            // Hace la petición y guarda la respuesta como String, como texto.
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            // Convierte la respuesta completa en un JSONObject
            JSONObject objectLibros = new JSONObject(response.body());
            // Obtiene el array "data" que contiene los libros
            JSONArray arrayLibros = objectLibros.getJSONArray("data");
            for (int i = 0; i < arrayLibros.length(); i++) {
                JSONObject libroJSON = arrayLibros.getJSONObject(i);
                Libro libro = gson.fromJson(libroJSON.toString(), Libro.class);
                listaLibros.add(libro);
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return listaLibros;
    }
}
