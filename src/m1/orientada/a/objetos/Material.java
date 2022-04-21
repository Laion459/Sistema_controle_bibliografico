package m1.orientada.a.objetos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Material {
    private String code;
    private String subject; // assunto
    private String title;
    private String publishingCompany; // editora
    private ArrayList<Reservation> reservation = new ArrayList<> ();

    public Material(){}

    public Material(String subject,String title){
        this.subject = subject;
        this.title = title;
    }

    public Material(String code, String subject, String title, String publishingCompany) {
        this.code = code;
        this.subject = subject;
        this.title = title;
        this.publishingCompany = publishingCompany;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishingCompany() {
        return publishingCompany;
    }


    public void setPublishingCompany(String publishingCompany) {
        this.publishingCompany = publishingCompany;
    }

    public ArrayList<Reservation> getReservation() {
        return reservation;
    }

    public void setReservation(ArrayList<Reservation> reservation) {
        this.reservation = reservation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Material)) return false;
        Material material = (Material) o;
        return Objects.equals(getCode(), material.getCode()) && Objects.equals(getSubject(), material.getSubject()) && Objects.equals(getTitle(), material.getTitle()) && Objects.equals(getPublishingCompany(), material.getPublishingCompany()) && Objects.equals(getReservation(), material.getReservation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCode(), getSubject(), getTitle(), getPublishingCompany(), getReservation());
    }

    @Override
    public String toString() {
        return "Material{" +
                "\n- code='" + code + '\'' +
                ", \n- subject='" + subject + '\'' +
                ", \n- title='" + title + '\'' +
                ", \n- publishingCompany='" + publishingCompany + '\'' +
                ", \n- reservation=" + reservation +
                '}';
    }

    /**
     * Métodos Públicos
     */

    /**
     *  Tem uma reserva
     * Reserva de material- adiciona reserva no array com a respectiva data
     * @param date data da reserva
     */
    public void tem(LocalDate date){
        Reservation aux = new Reservation(date);
        addReservation(aux);
    }

    /**
     * Reserva de material- adiciona reserva no array com a respectiva data
     * @param date data da reserva
     */
    public void addReservation(Reservation date){
        reservation.add(date);
    }



    /**
     *  Unitary tests
     */
    public static void main(String[] args) {
        // cria um objeto ficticio de data para teste da reserva
        LocalDate date = LocalDate.now();

        // Instancia objeto reservation da classe Reservation
        Reservation reservation = new Reservation(date);

        // Instancia objeto loan
        //Loan loan = new Loan(date,date,false);

        // Instancia objeto material da classe Material
        Material material = new Material("001","Programação orientada a objetos","Os poderes da Prof: Fernanda","Univali-Kobrasol");

        // Adiciona uma reservation/ reserva ao material
        material.addReservation(reservation);

        // Imprime objeto material
        System.out.println("## Imprime objeto material: ##\n" + material);
    }
}
