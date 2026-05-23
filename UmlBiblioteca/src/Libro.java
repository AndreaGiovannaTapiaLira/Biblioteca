// Libro.

public class Libro {
    // Atributos del libro.
    private String ISBN;
    private String nombre;
    private boolean disponible;

    // Constructor.
    public Libro(String ISBN, String nombre, boolean disponible) {
        this.ISBN = ISBN;
        this.nombre = nombre;
        this.disponible = disponible;
    }
    // Métod-o para obtener ISBN.
    public String getISBN() {
        return ISBN;
    }
    // Métod-o para cambiar disponibilidad.
    public void cambiarDisponibilidad(boolean disponible) {
        this.disponible = disponible;
    }
    // Métod-o para saber si está disponible.
    public boolean esDisponible() {
        return disponible;
    }
    // Métod-o para mostrar información.
    public void mostrarInfo() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Nombre: " + nombre);
        System.out.println("Disponible: " + disponible);
    }
}