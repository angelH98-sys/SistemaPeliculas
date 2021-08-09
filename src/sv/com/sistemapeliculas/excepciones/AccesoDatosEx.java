package sv.com.sistemapeliculas.excepciones;

public class AccesoDatosEx extends RuntimeException{

    public AccesoDatosEx(String mensaje){
        super(mensaje);
    }
}
