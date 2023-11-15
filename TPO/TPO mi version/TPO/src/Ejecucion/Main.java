package Ejecucion;
import Negocio.*;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CatalogoProductos catalogoProductos = new CatalogoProductos();

        do {
            System.out.println("Ingrese 'usuario' o 'admin' (o 'salir' para salir): ");
            String tipoUsuario = scanner.nextLine().toLowerCase();

            if (tipoUsuario.equals("usuario")) {
                MenuUsuario menuUsuario = new MenuUsuario(catalogoProductos);
                menuUsuario.opcionesUsuario();
            } else if (tipoUsuario.equals("admin")) {
                MenuAdmin menuAdmin = new MenuAdmin(catalogoProductos);
                menuAdmin.opcionesAdmin();
            }

          scanner.close();
            
        } while (true);
    }
}

