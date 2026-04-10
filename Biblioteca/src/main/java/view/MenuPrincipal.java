package view;

import controller.APIController;
import controller.BibliotecaController;
import controller.FileController;
import model.Libro;

import java.awt.*;
import java.util.List;
import java.util.Scanner;

public class MenuPrincipal {
    private APIController apiController;
    private BibliotecaController bibliotecaController;
    private FileController fileController;
    private Scanner scanner;

    public MenuPrincipal(){

    }

    public MenuPrincipal(APIController apiController, BibliotecaController bibliotecaController, FileController fileController) {
        this.apiController = apiController;
        this.bibliotecaController = bibliotecaController;
        this.fileController = fileController;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar(){
        int opcion;
        System.out.println("Bienvenido a la Biblioteca Municipal DAW");
        do {
            mostrarMenu();
            opcion = leerOpcion();
            System.out.println();

            switch (opcion){
                case 1 -> importarLibros();
                case 2 -> buscarLibroPorId();
                case 3 -> agregarLibroFavoritos();
                case 4 -> exportarFavoritos();
                case 5 -> importarFavoritos();
                case 0 -> System.out.println("Saliendo de la biblioteca...");
                default -> System.out.println("Opción no contemplada. Introduce otro número");
            }
        } while (opcion != 0);
        scanner.close();
    }

    public void mostrarMenu(){
        System.out.println("¿Qué te gustaría hacer hoy?. Elige una opción: ");
        System.out.println("1 - Importar libros");
        System.out.println("2 - Buscar libro por id");
        System.out.println("3 - Añadir libro a favoritos");
        System.out.println("4 - Exportar favoritos a fichero");
        System.out.println("5 - Importar favoritos desde fichero");
        System.out.println("0 - Salir");
    }

    public int leerOpcion(){
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        } else {
            System.out.println("Debes introducir un número.");
            scanner.next();
            return -1;
        }
    }

    public void importarLibros(){
        bibliotecaController.cargarLibros(apiController.obtenerLibrosAPI());
        System.out.println("Libros importados correctamente");
        System.out.println("Numero de libros cargados: " + bibliotecaController.obtenerLibros().size());
    }

    public void buscarLibroPorId(){
        if(bibliotecaController.obtenerLibros().isEmpty()){
            System.out.println("Primero es necesario importar los libros. Introduce el número 1");
            return;
        }
        System.out.println("Introduce el id del libro a buscar: ");
        if(scanner.hasNextInt()){
            int idLibro = scanner.nextInt();
            Libro libroBuscado = bibliotecaController.buscarLibroId(idLibro);
            if (libroBuscado != null){
                System.out.println("El libro con el id introducido es: "+libroBuscado);
            } else {
                System.out.println("No se ha encontrado ningún libro con dicho id en el sistema");
            }
        } else {
            System.out.println("Debes introducir un número");
            scanner.next();
        }
    }

    public void agregarLibroFavoritos(){
        if (bibliotecaController.obtenerLibros().isEmpty()) {
            System.out.println("Primero es necesario importar los libros. Introduce el número 1");
            return;
        }
        System.out.println("Introduce el id del libro que quieres agregar a favoritos: ");
        if(scanner.hasNextInt()){
            int idFavorito = scanner.nextInt();
            if(bibliotecaController.agregarFavorito(idFavorito)){
                System.out.println("Libro agregado a favoritos correctamente");
            } else {
                System.out.println("No se ha podido agregar el libro a favoritos");
            }
        } else {
            System.out.println("Debes introducir un número");
            scanner.next();
        }
    }

    public void exportarFavoritos(){
        if(bibliotecaController.obtenerFavoritos().isEmpty()){
            System.out.println("No hay libros favoritos que exportar. " +
                    "Primero agrega libros a la lista de favoritos.");
        } else{
            fileController.exportarFavoritos(bibliotecaController.obtenerFavoritos());
            System.out.println("Libros favoritos exportados correctamente");
        }
    }

    public void importarFavoritos(){
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
}
