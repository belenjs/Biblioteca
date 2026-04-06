import controller.APIController;
import controller.BibliotecaController;
import model.Libro;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        APIController apiController = new APIController();
        BibliotecaController bibliotecaController = new BibliotecaController();
        bibliotecaController.cargarLibros(apiController.obtenerLibrosAPI());
        System.out.println("Número de libros cargados " + bibliotecaController.obtenerLibros().size());
        Libro libro = bibliotecaController.buscarLibroId(11);
        System.out.println(libro);
        bibliotecaController.agregarFavorito(5);
        bibliotecaController.agregarFavorito(99);
        bibliotecaController.agregarFavorito(1);
        bibliotecaController.agregarFavorito(1);
        System.out.println(bibliotecaController.obtenerFavoritos());
        /*List<Libro> libros = apiController.obtenerLibros();

        System.out.println("Número de libros: " + libros.size());
        System.out.println(libros.get(0));*/
    }
}
