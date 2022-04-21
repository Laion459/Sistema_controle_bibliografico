package m1.orientada.a.objetos;

import java.time.LocalDate;
import java.util.Objects;

public class Book extends Material{
    private String isbn;
    private String author;

    public Book(){}

    public Book(String code, String subject, String title, String publishingCompany, String isbn, String author) {
        super(code, subject, title, publishingCompany);
        this.isbn = isbn;
        this.author = author;
    }

    public Book(String code, String subject, String title, String publishingCompany) {
        super(code, subject, title, publishingCompany);
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return Objects.equals(getIsbn(), book.getIsbn()) && Objects.equals(getAuthor(), book.getAuthor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getIsbn(), getAuthor());
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    /**
     *  Unitary tests
     */
    public static void main(String[] args) {
        // Instancia data ficticia
        LocalDate date = LocalDate.now();
        LocalDate date1 = LocalDate.now().plusDays(5);

        // Instancia objeto loan
        Loan loan = new Loan(date,date1,false);

        // Instancia objeto material da classe Material
        Material material = new Material("001","Programação orientada a objetos","Os poderes da Prof: Fernanda","Univali-Kobrasol");

        // Imprime objeto material
        System.out.println("## Imprime objeto material que foi criado para teste do objeto book: ##");
        System.out.println(material);
        System.out.println();

        // Instancia objeto book da classe Book
        Book book = new Book(material.getCode(), material.getSubject(), material.getTitle(), material.getPublishingCompany(),"10","Leonardo D Borges");

        // Imprime objeto book
        System.out.println("## Imprime objeto book/ livro: ##");
        System.out.println(book);


    }
}
