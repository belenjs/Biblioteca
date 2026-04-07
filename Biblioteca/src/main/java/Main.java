import controller.APIController;
import controller.BibliotecaController;
import controller.FileController;
import model.Libro;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        APIController apiController = new APIController();
        BibliotecaController bibliotecaController = new BibliotecaController();
        FileController fileController = new FileController();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido a la Biblioteca Municipal DAW");
        int opcion;
        do {
            System.out.println("¿Qué te gustaría hacer hoy?. Elige una opción del 0 al 5:");
            System.out.println("1 - Importar libros");
            System.out.println("2 - Buscar libro por id");
            System.out.println("3 - Añadir libro a favoritos");
            System.out.println("4 - Exportar favoritos a fichero");
            System.out.println("5 - Importar favoritos desde fichero");
            System.out.println("0 - Salir");
            opcion = scanner.nextInt();
            switch (opcion){
                case 1 -> {
                    bibliotecaController.cargarLibros(apiController.obtenerLibrosAPI());
                    System.out.println("Libros importados correctamente");
                    System.out.println("Numero de libros cargados: " + bibliotecaController.obtenerLibros().size());
                    break;
                }
                case 2 -> {
                    System.out.println("Introduce el id del libro a buscar: ");
                    int idLibro = scanner.nextInt();
                    Libro libroBuscado = bibliotecaController.buscarLibroId(idLibro);
                    if (libroBuscado != null){
                        System.out.println(libroBuscado);
                    } else {
                        System.out.println("No se ha encontrado ningún libro con dicho id en el sistema");
                    }
                    break;
                }
                case 3 -> {
                    System.out.println("Introduce el id del libro que quieres agregar a favoritos: ");
                    int idFavorito = scanner.nextInt();
                    if(bibliotecaController.agregarFavorito(idFavorito)){
                        System.out.println("Libro agregado a favoritos correctamente");
                    } else {
                        System.out.println("No se ha podido agregar el libro a favoritos");
                    }
                    break;
                }
                case 4 -> {
                    fileController.exportarFavoritos(bibliotecaController.obtenerFavoritos());
                    System.out.println("Libros favoritos exportados correctamente");
                    break;
                }
                case 5 -> {
                    List<Libro> listaFavoritosImportados = fileController.importarFavoritos();
                    if(listaFavoritosImportados.isEmpty()){
                        System.out.println("No hay ningún libro guardado en favoritos");
                    } else {
                        System.out.println("Libros favoritos importados");
                        System.out.println(listaFavoritosImportados);
                    }
                    break;
                }
                case 0 -> {
                    System.out.println("Saliendo de la biblioteca...");
                }
                default -> {
                    System.out.println("Opción no contemplada. Introduce otro número");
                }
            }
        } while (opcion != 0);
        scanner.close();

    }
}
