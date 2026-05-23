// Main. principal del programa. Andrea Giovanna Tapia Lira. 3°A - IRD.
/* Desarrollen en  el sistema de biblioteca. Las guías del diseño son los dos diagramas construidos en clase:
el programa debe cumplirlos y usarlos como mapa del qué hacer y cómo organizarlo.*/
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Biblioteca biblioteca = new Biblioteca();
        // Libros de ejemplo.
        biblioteca.agregarLibro(new Libro("101", "Harry Potter", true));
        biblioteca.agregarLibro(new Libro("102", "El Principito", true));
        biblioteca.agregarLibro(new Libro("103", "Cien Años de Soledad", true));

        int opcion = 0;

        while(opcion != 5) {

            System.out.println("\n...Bienvenido al Menú...");
            System.out.println("1. Consultar libro");
            System.out.println("2. Ver catálogo");
            System.out.println("3. Prestar libro");
            System.out.println("4. Devolver libro");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            // Consultar el libro.
            if(opcion == 1) {

                System.out.print("Ingrese el ISBN: ");
                String ISBN = sc.nextLine();
                Libro libro = biblioteca.consultarLibro(ISBN);

                if(libro != null) {
                    libro.mostrarInfo();
                } else {
                    System.out.println("¡El libro no fue encontrado!");
                }
            }
            // Ver el catálogo.
            else if(opcion == 2) {
                System.out.println("\nCATÁLOGO:");

                for(int i = 0; i < biblioteca.consultarLibros().size(); i++) {
                    Libro libro = biblioteca.consultarLibros().get(i);
                    libro.mostrarInfo();
                    System.out.println("----------------");
                }
            }
            // Prestar el libro.
            else if(opcion == 3) {
                System.out.print("Ingrese el ISBN del libro: ");
                String ISBN = sc.nextLine();
                biblioteca.prestarLibro(ISBN);
            }
            // Devolver el libro.
            else if(opcion == 4) {
                System.out.print("Ingrese el ISBN del libro: ");
                String ISBN = sc.nextLine();
                System.out.print("Ingrese la fecha límite (AAAA-MM-DD): ");
                String fechaTexto = sc.nextLine();
                LocalDate fechaLimite = LocalDate.parse(fechaTexto);
                biblioteca.devolverLibro(ISBN, fechaLimite);
            }
            // Salir.
            else if(opcion == 5) {
                System.out.println("¡Hasta luego! :D");
            }
            // Por si se ingresa algo erroneo.
            else {
                System.out.println("¡Opción inválida!");
            }
        }sc.close();
    }
}