package sistemapeliculas;

import sv.com.sistemapeliculas.negocio.CatalogoPeliculas;
import sv.com.sistemapeliculas.negocio.CatalogoPeliculasImpl;

import java.util.Scanner;

public class SistemaPeliculas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;
        var nombrePelicula = "";
        CatalogoPeliculas catalogoPeliculas = new CatalogoPeliculasImpl();

        while(opcion != 0){

            mostrarMenu();
            opcion = obtenerOpcion(scanner.nextLine());
            System.out.println("\n----------------------------------------");

            switch (opcion){
                case 1:
                    catalogoPeliculas.iniciarArchivo();
                    break;
                case 2:
                    System.out.println("Escriba el nombre de la película (al dejar vacío el campo, " +
                            "saldrás al menú principal)");
                    nombrePelicula = scanner.nextLine();
                    if(!nombrePelicula.isEmpty())
                        catalogoPeliculas.agregarPelicula(nombrePelicula.trim());
                    opcion = -1;
                    break;
                case 3:
                    System.out.println("Películas registradas");
                    catalogoPeliculas.listarPeliculas();
                    opcion = -1;
                    break;
                case 4:
                    System.out.println("Buscador de películas");
                    System.out.println("-> Escriba el nombre de la película (al dejar vacío el campo, " +
                            "saldrás al menú principal)");
                    nombrePelicula = scanner.nextLine();
                    if(!nombrePelicula.isEmpty())
                        catalogoPeliculas.buscarPelicula(nombrePelicula);
                    opcion = -1;
                    break;
                case 0:
                    System.out.println("Hasta luego...");
                    break;
            }

        }

    }

    public static void mostrarMenu(){
        System.out.println("Catalogo películas");
        System.out.println("------------------------");
        System.out.println("Elige una opción:");
        System.out.println("-> 1. Iniciar catalogo peliculas");
        System.out.println("-> 2. Agregar película");
        System.out.println("-> 3. Listar películas");
        System.out.println("-> 4. Buscar películas");
        System.out.println("\n-> 0. Salir");
    }

    public static int obtenerOpcion(String linea){
        try{
            return Integer.parseInt(linea);
        }catch(Exception e){
            System.out.println("ERROR: favor, ingresa una opción válida");
            return -1;
        }
    }

}
