package m1.orientada.a.objetos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class User {
    private String name;
    private Integer password;
    private Integer phone;

    public User(){}

    public User(String name, Integer password, Integer phone) {
        this.name = name;
        this.password = password;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getName(), user.getName()) && Objects.equals(getPassword(), user.getPassword()) && Objects.equals(getPhone(), user.getPhone());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPassword(), getPhone());
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password=" + password +
                ", phone=" + phone +
                '}';
    }

    /**
     * Unitary tests
     */
    public static void main(String[] args) {
        // Instancia data ficticia para testes
        LocalDate date = LocalDate.now();
        LocalDate date1 = LocalDate.now().plusDays(5);

        // Instancia objeto loan
        //Loan loan = new Loan(date,date1,false);

        // Instancia objeto user da classe User
        User user = new User("Leonardo",12345,48999999);

        // Imprime objeto user
        System.out.println("## Imprime objeto user: ##\n" + user);
        System.out.println("\n-------------\n");

        // Cria um objeto material
        Material material = new Material("001","Programação orientada a objetos","Os poderes da Prof: Fernanda","Univali-Kobrasol");

        // Adiciona o material ao array de materiais dentro da objeto user
        //user.addMatrialInArrayList(material);

        // Cria data de reserva para teste
        material.addReservation(new Reservation(date));

        // Consulta pelo assunto
        System.out.println(" ## Imprime o materia consultado pelo assunto: test I ##\n");
        //user.consultMaterial("Programação orientada a objetos");
        System.out.println();
        System.out.println(" ## Imprime o materia consultado pelo assunto: test I ##\n");
        //user.consultMaterial("Asunto test II: ");
        System.out.println();

        // Imprime objeto user
        System.out.println("## Imprime objeto user com todos os campos preenchidos: ##\n" + user);
    }
}
