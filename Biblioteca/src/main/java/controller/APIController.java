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
            Gson gson = new Gson();
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest
                    .newBuilder()
                    .uri(URI.create(URL_LIBROS))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JSONObject objectLibros = new JSONObject(response.body());
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

    public Libro buscarLibroPorIdAPI(int id) {
        String urlLibro = "https://stephen-king-api.onrender.com/api/book/" + id;

        try {
            Gson gson = new Gson();
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest
                    .newBuilder()
                    .uri(URI.create(urlLibro))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JSONObject objectLibro = new JSONObject(response.body());
            JSONObject libroJSON = objectLibro.getJSONObject("data");

            return gson.fromJson(libroJSON.toString(), Libro.class);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
