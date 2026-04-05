package controller;

import com.google.gson.Gson;
import model.Libro;
import model.LibrosResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class APIController {

    private static final String URL_LIBROS = "https://stephen-king-api.onrender.com/api/books";

    public List<Libro> obtenerLibros(){
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
            // Convierte el JSON completo a la clase raíz LibrosResponse
            LibrosResponse librosResponse = gson.fromJson(response.body(), LibrosResponse.class);
            return librosResponse.getData();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
