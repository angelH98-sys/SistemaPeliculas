package sv.com.sistemapeliculas.negocio;

import sv.com.sistemapeliculas.datos.AccesoDatos;
import sv.com.sistemapeliculas.datos.AccesoDatosImpl;
import sv.com.sistemapeliculas.domain.Pelicula;

public class CatalogoPeliculasImpl implements CatalogoPeliculas{

    private final AccesoDatos datos;

    public CatalogoPeliculasImpl() {
        this.datos = new AccesoDatosImpl();
    }

    @Override
    public void agregarPelicula(String nombrePelicula) {
        Pelicula pelicula = new Pelicula(nombrePelicula);
        boolean anexar = false;
        anexar = datos.existe(NOMBRE_ARCHIVO);
        datos.escribir(pelicula, NOMBRE_ARCHIVO, anexar);
    }

    @Override
    public void listarPeliculas() {
        var peliculas = datos.listar(NOMBRE_ARCHIVO);
        for(Pelicula pelicula: peliculas){
            System.out.println("pelicula = " + pelicula);
        }
    }

    @Override
    public void buscarPelicula(String buscar) {
        var resultado = datos.buscar(NOMBRE_ARCHIVO, buscar);
        System.out.println(resultado);
    }

    @Override
    public void iniciarArchivo() {

        if(!datos.existe(NOMBRE_ARCHIVO))
            datos.crear(NOMBRE_ARCHIVO);
        else
            System.out.println("Archivo ya existe");
    }

    @Override
    public void elminarArchivo() {

        if(!datos.existe(NOMBRE_ARCHIVO))
            datos.borrar(NOMBRE_ARCHIVO);
        else
            System.out.println("No se encontró el archivo");
    }
}
