import controller.APIController;
import model.Libro;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        APIController apiController = new APIController();
        List<Libro> libros = apiController.obtenerLibros();

        System.out.println("Número de libros: " + libros.size());
        System.out.println(libros.get(0));
    }
}
