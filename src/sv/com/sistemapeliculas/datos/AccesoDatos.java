package sv.com.sistemapeliculas.datos;

import sv.com.sistemapeliculas.domain.Pelicula;
import sv.com.sistemapeliculas.excepciones.AccesoDatosEx;
import sv.com.sistemapeliculas.excepciones.EscrituraDatosEx;
import sv.com.sistemapeliculas.excepciones.LecturaDatosEx;

import java.util.List;

public interface AccesoDatos {

    boolean existe(String nombreArchivo) throws AccesoDatosEx;

    List<Pelicula> listar(String nombre) throws LecturaDatosEx;

    void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx;

    String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx;

    void crear(String nombreArchivo) throws AccesoDatosEx;

    void borrar(String nombreArchivo) throws AccesoDatosEx;

}
