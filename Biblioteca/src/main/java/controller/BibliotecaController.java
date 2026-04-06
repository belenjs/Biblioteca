package controller;

import model.Biblioteca;
import model.Libro;

import java.util.List;

public class BibliotecaController {

    private Biblioteca biblioteca;

    public BibliotecaController() {
        this.biblioteca = new Biblioteca();
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
}
