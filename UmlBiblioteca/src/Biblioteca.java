// Biblioteca.
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    // Lista de libros.
    private List<Libro> libros;

    // Constructor
    public Biblioteca() {
        libros = new ArrayList<>();
    }
    // Agregar libro
    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }
    // Consultar un libro por ISBN
    public Libro consultarLibro(String ISBN) {
        for(int i = 0; i < libros.size(); i++) {
            Libro libro = libros.get(i);
            String codigoLibro = libro.getISBN();
            if(codigoLibro.equals(ISBN)) {
                return libro;
            }
        }
        return null;
    }
    // Mostrar catálogo
    public List<Libro> consultarLibros() {
        return libros;
    }
    // Prestar libro
    public void prestarLibro(String ISBN) {
        Libro libro = consultarLibro(ISBN);
        if(libro != null) {
            if(libro.esDisponible()) {
                libro.cambiarDisponibilidad(false);
                System.out.println("¡El libro fue prestado correctamente!");
            } else {
                System.out.println("¡El libro no está disponible!");
            }
        } else {
            System.out.println("¡El libro no fue encontrado!");
        }
    }
    // Devolver libro
    public void devolverLibro(String ISBN, LocalDate fechaLimite) {
        Libro libro = consultarLibro(ISBN);
        if(libro != null) {
            libro.cambiarDisponibilidad(true);
            System.out.println("¡El libro fue devuelto correctamente!");
            LocalDate fechaActual = LocalDate.now();
            if(fechaLimite.isBefore(fechaActual)) {
                aplicarMulta();
            }
        } else {
            System.out.println("¡El libro no fue encontrado!");
        }
    }
    // Aplicar multa.
    public void aplicarMulta() {
        System.out.println("¡Se debe aplicar multa por el RETRASO!");
    }
}