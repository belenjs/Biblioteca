package controller;

import model.Biblioteca;
import model.Libro;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaController {

    private Biblioteca biblioteca;
    private List<Libro> librosFavoritos;

    public BibliotecaController() {
        this.biblioteca = new Biblioteca();
        this.librosFavoritos = new ArrayList<>();
    }

    public void cargarLibros(List<Libro> libros){
        biblioteca.setListaLibros(libros);
    }

    public List<Libro> obtenerLibros(){
        return  biblioteca.getListaLibros();
    }

    public Libro buscarLibroId(int id){
        for(Libro libro : biblioteca.getListaLibros()){
            if(libro.getId() == id) {
                return libro;
            }
        }
        return null;
    }

    public boolean agregarFavorito(int id){
        Libro libro = buscarLibroId(id);
        if((libro != null) && (!librosFavoritos.contains(libro))){
            librosFavoritos.add(libro);
            System.out.println("Libro añadido a favoritos");
            return true;
        } else{
            System.out.println("No se puede añadir el libro a la lista de favoritos");
            return false;
        }
    }

    public List<Libro> obtenerFavoritos(){
        return librosFavoritos;
    }
}

