package sv.com.sistemapeliculas.negocio;

public interface CatalogoPeliculas {
    String NOMBRE_ARCHIVO = "Peliculas.txt";
    void agregarPelicula(String nombrePelicula);
    void listarPeliculas();
    void buscarPelicula(String buscar);
    void iniciarArchivo();
    void elminarArchivo();
}
