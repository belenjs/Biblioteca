import controller.APIController;
import controller.BibliotecaController;
import controller.FileController;
import view.MenuPrincipal;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        APIController apiController = new APIController();
        BibliotecaController bibliotecaController = new BibliotecaController();
        FileController fileController = new FileController();

        MenuPrincipal menuPrincipal = new MenuPrincipal(apiController, bibliotecaController, fileController);
        menuPrincipal.iniciar();

    }
}
