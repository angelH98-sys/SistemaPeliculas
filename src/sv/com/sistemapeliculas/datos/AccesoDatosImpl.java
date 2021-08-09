package sv.com.sistemapeliculas.datos;

import sv.com.sistemapeliculas.domain.Pelicula;
import sv.com.sistemapeliculas.excepciones.AccesoDatosEx;
import sv.com.sistemapeliculas.excepciones.EscrituraDatosEx;
import sv.com.sistemapeliculas.excepciones.LecturaDatosEx;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AccesoDatosImpl implements AccesoDatos{

    private File archivo;
    private BufferedReader entrada;

    @Override
    public boolean existe(String nombreArchivo) {
        this.archivo = new File(nombreArchivo);
        return this.archivo.exists();
    }

    @Override
    public List<Pelicula> listar(String nombre) {
        archivo = new File(nombre);
        List listaPeliculas = new ArrayList<Pelicula>();
        try {
            this.entrada = new BufferedReader(new FileReader(this.archivo));
            var linea = entrada.readLine();
            while(linea != null){
                listaPeliculas.add(new Pelicula(linea));
                linea = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new LecturaDatosEx("Excepcion al listar peliculas: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            throw new LecturaDatosEx("Excepcion al listar peliculas: " + e.getMessage());
        }
        return listaPeliculas;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) {
        this.archivo = new File(nombreArchivo);
        try {
            PrintWriter salida;
            salida = new PrintWriter(new FileWriter(this.archivo, anexar));
            salida.print(pelicula);
            salida.close();
            System.out.println("Se ha registrado la película");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new EscrituraDatosEx("Excepción al escribir películas: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            throw new EscrituraDatosEx("Excepción al escribir películas: " + e.getMessage());
        }
    }

    @Override
    public String buscar(String nombreArchivo, String buscar) {
        this.archivo = new File(nombreArchivo);
        var resultado = "";
        try {
            this.entrada = new BufferedReader(new FileReader(this.archivo));
            var linea = entrada.readLine();
            var i = 1;
            while(linea != null){
                if (buscar != null && buscar.equalsIgnoreCase(linea))
                    return "Pelicula " + linea + ", encontrada en el indice " + i;
                else
                    linea = entrada.readLine();
                i++;
            }
            entrada.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new EscrituraDatosEx("Excepción al buscar películas: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            throw new EscrituraDatosEx("Excepción al buscar películas: " + e.getMessage());
        }
        return null;
    }

    @Override
    public void crear(String nombreArchivo) {
        this.archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(this.archivo));
            salida.close();
            System.out.println("Se ha creado el archivo");
        } catch (IOException e) {
            e.printStackTrace();
            throw new EscrituraDatosEx("Excepción al crear archivo: " + e.getMessage());
        }
    }

    @Override
    public void borrar(String nombreArchivo) {
        this.archivo = new File(nombreArchivo);
        if(this.archivo.exists())
            this.archivo.delete();

    }
}
