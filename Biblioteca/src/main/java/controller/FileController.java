package controller;

import model.Libro;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileController {
    private static final String FILE_NAME = "favoritos.obj";

    public void exportarFavoritos(List<Libro> favoritos){
        ObjectOutputStream objectOutputStream = null;
        try {
           objectOutputStream  = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
            objectOutputStream.writeObject(favoritos);

        } catch (IOException e) {
            System.out.println("Error en la escritura del fichero");;
        } finally {
            try {
                objectOutputStream.close();
            } catch (IOException | NullPointerException e ) {
                System.out.println("Error en el cerrado");
            }
        }
    }

    public List<Libro> importarFavoritos(){
        ObjectInputStream objectInputStream = null;
        List<Libro> favoritos = new ArrayList<>();
        try {
           objectInputStream  = new ObjectInputStream(new FileInputStream(FILE_NAME));
              favoritos = (List<Libro>) objectInputStream.readObject();
        } catch (IOException e) {
            System.out.println("Fichero no encontrado");
        } catch (ClassNotFoundException e) {
            System.out.println("Clase no encontrada para la traducción");;
        } catch (ClassCastException e) {
            System.out.println("Tipos incompatibles");
        }
        finally {
            try {
                objectInputStream.close();
            } catch (IOException e) {
                System.out.println("Error en el cerrado");
            }

        }
        return favoritos;

    }
}
