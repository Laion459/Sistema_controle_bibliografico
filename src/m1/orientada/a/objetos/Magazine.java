package m1.orientada.a.objetos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Magazine extends Material{

    private String colection;
    private String issn;
    private Integer number;
    private ArrayList<Article> articles = new ArrayList<>();

    public Magazine(){}

    public Magazine(String code, String subject, String title, String publishingCompany, String colection, String issn, Integer number) {
        super(code, subject, title, publishingCompany);
        this.colection = colection;
        this.issn = issn;
        this.number = number;
    }

    public Magazine(String code, String subject, String title, String publishingCompany) {
        super(code, subject, title, publishingCompany);
    }

    public String getColection() {
        return colection;
    }

    public void setColection(String colection) {
        this.colection = colection;
    }

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public ArrayList<Article> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<Article> articles) {
        this.articles = articles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Magazine)) return false;
        if (!super.equals(o)) return false;
        Magazine magazine = (Magazine) o;
        return Objects.equals(getColection(), magazine.getColection()) && Objects.equals(getIssn(), magazine.getIssn()) && Objects.equals(getNumber(), magazine.getNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getColection(), getIssn(), getNumber());
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "colection='" + colection + '\'' +
                ", issn='" + issn + '\'' +
                ", number=" + number +
                '}';
    }

    /**
     * Adiciona um artigo ao array de publicações de artigos
     * @param article artigo a ser adicionado as publicações
     */
    public void addPublication(Article article){
        articles.add(article);
    }

    /**
     * Remove um artigo pelo indice/ index do array de artigos/ articles
     * @param index indice/ index onde sera removido o artigo/ article
     */
    public void removePublication(int index){
        articles.remove(index);
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

        // Adiciona uma reserva ficticia para teste
        Reservation reservation = new Reservation(date);
        material.addReservation(reservation);
        Reservation reservation1 = new Reservation(date1);
        material.addReservation(reservation1);

        // Imprime objeto material
        System.out.println("## Imprime obeto material: ##");
        System.out.println("- " + material);
        System.out.println();

        // Instancia objeto magazine da classe Magazine
        Magazine magazine = new Magazine("001","Programação ","Os poderes ","Univali","Premium","999",5);


        // Imprime objeto magazine
        System.out.println("## Imprime obeto magazine/ revista: ##");
        System.out.println("- " + magazine);
        System.out.println();

        // Cria um artigo teste
        Article article = new Article("Leonardo Borges", "Nunca desista","Use a cabeça");
        magazine.addPublication(article);
        System.out.println("## Imprime obeto magazine.articles / que é o artigo adicionado ao array de artigos: ##");
        System.out.println("- " + magazine.articles.toString());
    }
}
