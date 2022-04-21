package m1.orientada.a.objetos;

import java.time.LocalDate;
import java.util.Objects;

public class Reservation {
    private LocalDate reservationDate;

    public Reservation(){}

    public Reservation(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reservation)) return false;
        Reservation that = (Reservation) o;
        return Objects.equals(getReservationDate(), that.getReservationDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getReservationDate());
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationDate='" + reservationDate + '\'' +
                '}';
    }


    /**
     * Métodos Públicos
     */


    /**
     * Unitary tests
     */
    public static void main(String[] args) {
        // cria um objeto ficticio de data para teste da reserva
        LocalDate date = LocalDate.now();

        // Instancia objeto reservation da classe Reservation
        Reservation reservation = new Reservation(date);

        // Imprime objeto reservation/ reserva
        System.out.println("## Imprime objeto reservatio/ reserva: ##\n" + reservation);
    }
}
