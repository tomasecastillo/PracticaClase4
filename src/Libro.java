public class Libro {

    private String titulo;
    private long isbn;
    private String autor;
    private String editorial;
    private int cantidadCopias;

    public int getCantidadCopias() {
        return cantidadCopias;
    }

    public void setCantidadCopias(int cantidadCopias) {
        this.cantidadCopias = cantidadCopias;
    }

    public Libro(String titulo, long isbn, String autor, String editorial, int cantidadCopias) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.editorial = editorial;
        this.cantidadCopias = cantidadCopias;
    }

    public Libro() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public boolean prestamo() {
        if (this.getCantidadCopias() <= 0) {
            System.out.println("No se puede prestar, cantidad insuficiente");
            return false;
        } else {
            this.setCantidadCopias(this.getCantidadCopias() - 1);
        }
        return true;
    }

    public boolean devolucion( ) {

        this.setCantidadCopias(this.getCantidadCopias() + 1);

        return true;
    }

    @Override
    public String toString() {
        return titulo + ", " +
                isbn +
                ", " + autor +
                ", " + editorial +", cantidad: " + cantidadCopias;
    }

    public static void main(String[] args) {
        Libro libro1 = new Libro("Harry Potter",123,"JK Rowling","test",5);
        Libro libro2 = new Libro("Star Wars",332,"Test","test",0);

        libro1.devolucion();
        libro2.prestamo();
        libro2.devolucion();
        libro2.prestamo();
        System.out.println(libro1);
        System.out.println(libro2);
    }
}