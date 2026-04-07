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
            System.out.println("¿Qué te gustaría hacer hoy?. Elige una opción: ");
            System.out.println("1 - Importar libros");
            System.out.println("2 - Buscar libro por id");
            System.out.println("3 - Añadir libro a favoritos");
            System.out.println("4 - Exportar favoritos a fichero");
            System.out.println("5 - Importar favoritos desde fichero");
            System.out.println("0 - Salir");
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
            } else {
                System.out.println("Debes introducir un número.");
                scanner.next();
                opcion = -1;
            }
            System.out.println();
            switch (opcion){
                case 1 -> {
                    bibliotecaController.cargarLibros(apiController.obtenerLibrosAPI());
                    System.out.println("Libros importados correctamente");
                    System.out.println("Numero de libros cargados: " + bibliotecaController.obtenerLibros().size());
                }
                case 2 -> {
                    if(bibliotecaController.obtenerLibros().isEmpty()){
                        System.out.println("Primero es necesario importar los libros. Introduce el número 1");
                    } else {
                        System.out.println("Introduce el id del libro a buscar: ");
                        int idLibro = scanner.nextInt();
                        Libro libroBuscado = bibliotecaController.buscarLibroId(idLibro);
                        if (libroBuscado != null){
                            System.out.println("El libro con el id introducido es: "+libroBuscado);
                        } else {
                            System.out.println("No se ha encontrado ningún libro con dicho id en el sistema");
                        }
                    }
                }
                case 3 -> {
                    if (bibliotecaController.obtenerLibros().isEmpty()) {
                        System.out.println("Primero es necesario importar los libros. Introduce el número 1");
                    } else {
                        System.out.println("Introduce el id del libro que quieres agregar a favoritos: ");
                        int idFavorito = scanner.nextInt();
                        if(bibliotecaController.agregarFavorito(idFavorito)){
                            System.out.println("Libro agregado a favoritos correctamente");
                        } else {
                            System.out.println("No se ha podido agregar el libro a favoritos");
                        }
                    }
                }
                case 4 -> {
                    if(bibliotecaController.obtenerFavoritos().isEmpty()){
                        System.out.println("No hay libros favoritos que exportar. " +
                                "Primero agrega libros a la lista de favoritos.");
                    } else{
                        fileController.exportarFavoritos(bibliotecaController.obtenerFavoritos());
                        System.out.println("Libros favoritos exportados correctamente");
                    }
                }
                case 5 -> {
                    List<Libro> listaFavoritosImportados = fileController.importarFavoritos();
                    if(listaFavoritosImportados.isEmpty()){
                        System.out.println("No hay ningún libro guardado en favoritos");
                    } else {
                        System.out.println("Libros favoritos importados: ");
                        for(Libro libro : listaFavoritosImportados){
                            System.out.println(libro);
                        }

                    }
                }
                case 0 -> System.out.println("Saliendo de la biblioteca...");
                default -> System.out.println("Opción no contemplada. Introduce otro número");
            }
        } while (opcion != 0);
        scanner.close();

    }
}
