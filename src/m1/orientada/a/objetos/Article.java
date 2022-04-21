package m1.orientada.a.objetos;

import java.util.Objects;

public class Article {
    private String author;
    private String title;
    private String resume;

    public Article(){}

    public Article(String author, String title, String resume) {
        this.author = author;
        this.title = title;
        this.resume = resume;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article)) return false;
        Article article = (Article) o;
        return Objects.equals(getAuthor(), article.getAuthor()) && Objects.equals(getTitle(), article.getTitle()) && Objects.equals(getResume(), article.getResume());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAuthor(), getTitle(), getResume());
    }

    @Override
    public String toString() {
        return "Article{" +
                "\n - author='" + author + '\'' +
                ",\n - title='" + title + '\'' +
                ",\n - resume='" + resume + '\'' +
                '}';
    }

    /**
     *  Unitary tests
     */
    public static void main(String[] args) {
        // Instancia objeto article da classe Article
        Article article = new Article("Leonardo Dario Borges","LA VIDA",
                "\nDecimos apreciar la vida y fumamos y bebemos y drogas y motos y autopistas inseguras y gastamos el tiempo de manera tan baja que parece odiar la vida y la naturaleza. \n" +
                        "Cualquiera hoy en día es profesor o maestro o especialista, siendo que saber un poquitín más que otros no te torna especialista. \n" +
                        "Si las personas se unieran serían tan fuertes y potentes pero no, los locos se pelean y dale guerras y corrupción. \n" +
                        "Por otro lado los que esperan que algún día pase algo tan hermoso y fantástico que le saque de su realidad y le lleve a otra vida o patamar, esperando algo tan esperando por la mayoría, algo especial, algo que le transforma.\n" +
                        "Transforma su belleza, su carácter y sus virtudes y también sus sueños y anhelos más profundos de un piscar de ojos. Pero en el fondo saben que si no mueven el culo no van a ninguna parte. \n" +
                        "Qué día!!\n" +
                        "Como los que más filosofan y saben y entienden y todo, eso dicen");

        // Imprime objeto article
        System.out.println("## Imprime objeto article/ artigo: ##");
        System.out.println(article);
    }
}
