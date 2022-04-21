package m1.orientada.a.objetos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Loan {
    private LocalDate loanDate;
    private LocalDate returnDate;
    private boolean delay;
    private Material material;
    private User user;
    private ArrayList<Material> materialArrayList = new ArrayList<>();
    private ArrayList<Loan> reservationArrayList = new ArrayList<>();
    private ArrayList<Loan> loanArrayList = new ArrayList<>();

    public Loan(){}

    public Loan(LocalDate loanDate, LocalDate returnDate){
        this.loanDate = loanDate;
        this.returnDate = returnDate;
    }

    public Loan(LocalDate loanDate, LocalDate returnDate, boolean delay){
        this.loanDate = loanDate;
        this.returnDate = returnDate;
        this.delay = delay;
    }

    public Loan(LocalDate loanDate, LocalDate returnDate, Material material, User user) {
        this.loanDate = loanDate;
        this.returnDate = returnDate;
        this.material = material;
        this.user = user;
    }

    public Loan(LocalDate reservationDate, Material material, User user) {
        this.loanDate = reservationDate;
        this.material = material;
        this.user = user;
    }

    public Loan(LocalDate loanDate, LocalDate returnDate, boolean delay, Material material, User user) {
        this.loanDate = loanDate;
        this.returnDate = returnDate;
        this.delay = delay;
        this.material = material;
        this.user = user;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isDelay() {
        return delay;
    }

    public void setDelay(boolean delay) {
        this.delay = delay;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Loan)) return false;
        Loan loan = (Loan) o;
        return isDelay() == loan.isDelay() && Objects.equals(getLoanDate(), loan.getLoanDate()) && Objects.equals(getReturnDate(), loan.getReturnDate()) && Objects.equals(getMaterial(), loan.getMaterial()) && Objects.equals(getUser(), loan.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLoanDate(), getReturnDate(), isDelay(), getMaterial(), getUser());
    }


    @Override
    public String toString() {
        return "Loan{" +
                "loanDate=" + loanDate +
                ", returnDate=" + returnDate +
                ", delay=" + delay +
                ", material=" + material +
                ", user=" + user +
                '}';
    }

    // Remove material do da lista pelo elemento
    public void removeMatrialInArrayListByElement(Material material){
        materialArrayList.remove(material);
    }

    // Remove material do da lista pelo index
    public void removeMatrialInArrayListByIndex(int index){
        materialArrayList.remove(index);
    }

    // adiciona material a lista
    public void addMatrialInArrayList(Material material){
        materialArrayList.add(material);
    }

    /**
     * Altera data de devolução do livro/ book
     * @param plusDays dias a serem adicionados a data atual de devolução
     */
    public void returnAfterDateMaterial(int plusDays){
        LocalDate plusDate = LocalDate.now().plusDays(plusDays);
        setReturnDate(plusDate);
    }


    /**
     * Valida a data, cria data atual para validações de atraso
     * @param date data a ser comprada com atual
     * @return true se parametro data esta depois de data atual
     */
    public boolean validateDelay(LocalDate date){
        // cria now = dia atual para comparação se esta ou não em atraso
        LocalDate now = LocalDate.now();
        return now.isAfter(date);
    }


    /**
     * Cunsulta se material existe pelo asunto
     * @param subject asunto a ser comparado a existencia
     *                Caso encontre asunto, retorna True
     *                caso contrario false
     */
    public boolean consultMaterial(String subject) {
        for(int i = 0; i < materialArrayList.size(); i++) {
            if (materialArrayList.get(i).getSubject().equals(subject)) {
                //System.out.println("    *****   SIM existe esse asunto!!  ***** : " + materialArrayList.get(i).getSubject());
                return true;
            }
        }
        //System.out.println("    *****   Não existe esse asunto!!  ***** : " + subject);
        return false;
    }

    /**
     * Reserva material
     *                asunto do material a ser reservado
     *                consultMaterial(subjet) - consulta se esse asunto existe, caso true reserva.
     *                caso contrário menssagem que asunto não existe.
     */
    public void reserveMaterial(User user, Material material){
        if (consultMaterial(material.getSubject())){
            System.out.println(" - Usuário: " + user.getName() + "    -Telefone N°: " + user.getPhone());
            System.out.println(" - RESERVADO PARA VOCÊ O MATERIAl- Título: " + material.getTitle() + "   - Código: " + material.getCode());
            Loan newReservation = new Loan(getLoanDate(),material,user);
            reservationArrayList.add(newReservation);
        }
    }

    /**
     * Consulta se pode realizar empréstimo, se estiver reservado não sera permitido o emprestimo
     * @param title titulo do livro para pesquisa nas reservas
     * @return true se esta disponível, false caso contrario e exibe mensagem que material está reservado
     */
    public boolean consultReservation(String title){
        boolean aux = true;
        for (int i = 0; i < reservationArrayList.size(); i++){
            if (reservationArrayList.get(i).getMaterial().getTitle().equals(title)){
                aux = false;
            }
        }

        // fora do laço se estiver reservado mostra mensagem
        if (!aux){
            System.out.println("Material reservado, não pode ser emprestado no momento ");
            return false;
        }
        return true;
    }

    /**
     * empresta material caso esteja disponível
     * @param user usuário quem vai pegar o empréstimo
     * @param material material que será emprstado
     */
    public void emprestaMaterial(User user, Material material){
        //&& consultMaterial(material.getSubject())
        if (consultReservation(material.getTitle())){
            System.out.println(" - Usuário: " + user.getName() + "    -Telefone N°: " + user.getPhone());
            System.out.println(" - EMPRESTIMO DE MATERIAl REALIZADO   - Título: " + material.getTitle() + "   - Código: " + material.getCode());
            Loan newReservation = new Loan(getLoanDate(),getReturnDate(),material,user);
            // adiciona ao arraay de empréstimos ativos
            loanArrayList.add(newReservation);
            // Remove de array de reservas
            reservationArrayList.remove(newReservation);
            // Remove do array de material
            materialArrayList.remove(newReservation.material);
        }
    }

    // Devolução de material
    public Loan returnMaterial(User user, Material material){
        Loan newReturn = new Loan(getLoanDate(),getReturnDate(),material,user);
        // Adiciona o material a lista
        materialArrayList.add(material);
        // Remove de lista de emprestimos
        loanArrayList.remove(newReturn);
        return newReturn;
    }

    // Imprime Loan list
    public void showLoanList(Loan loan){
        System.out.println("\n    **** Imprime Loan list  ****");
        for (int i = 0; i < loan.loanArrayList.size(); i++){
            System.out.println("Element ["+ (i + 1) + "] " + loan.loanArrayList.get(i));

        }
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
    }

    // Imprime Material list
    public void showMaterialList(Loan loan){
        System.out.println("    **** Imprime Material list    ****");
        for (int i = 0; i < loan.materialArrayList.size(); i++){
            System.out.println("Element ["+ (i + 1) + "] " + loan.materialArrayList.get(i));
        }
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
    }

    // Imprime Reservation list
    public void showReservationList(Loan loan){
        System.out.println("    **** Imprime Reservation list   ****");
        for (int i = 0; i < loan.reservationArrayList.size(); i++){
            System.out.println("Element ["+ (i + 1) + "] " + loan.reservationArrayList.get(i));
        }
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
    }

    // Imprime todas as listas/ show all lists
    public void showAllList(Loan loan){
        showLoanList(loan);
        showMaterialList(loan);
        showReservationList(loan);
    }
    /**
     * Unitary tests
     */
    public static void main(String[] args) {
        // Inicia hora atual
        LocalDate date = LocalDate.now();

        // Declara variavel auxiliar para teste data posterior a atual
        LocalDate date1;

        // date = formato ano/mes/dia
        date = LocalDate.of(date.getYear(), date.getMonth(), date.getDayOfMonth());

        // date1 = data ficticia para teste devolução //
        date1 = LocalDate.from(LocalDate.of(2022, 4, 9));

        // cria um usuario
        User user = new User("Leonardo", 12345, 48999999);

        // Imprime objeto user
        System.out.println("## Imprime objeto user: ##\n" + user);
        System.out.println("\n-------------\n");

        // Cria um objetos material
        Loan loan = new Loan();
        Material material = new Material("001", "Programação orientada a objetos", "Os poderes da Prof: Fernanda", "Univali-Kobrasol");
        Material material2 = new Material("progamação","CLAEN CODE");

        // Adiciona o objeto material o array de materiais dentro da objeto loan
        loan.addMatrialInArrayList(material);

        // Cria data de reserva para teste
        material.addReservation(new Reservation(date));


        // Instancia e aloca objeto loan da classe Loan para teste
        //loan = new Loan(date, date1, true, material, user);
        loan.setLoanDate(date);
        loan.setReturnDate(date1);
        loan.setDelay(false);
        loan.setMaterial(material);
        loan.setUser(user);

        // Imprime objeto loan
        System.out.println(" ## Imprime objeto loan/ emprestimo: ##\n" + loan);
        System.out.println();

        // Cria data ficticia para comparação de atraso
        LocalDate date2 = LocalDate.of(2000, 11, 25);

        System.out.println("## Comparação 01 de atraso no loan/ emprestimo: ##");
        System.out.println("- Empréstrimo está em atraso? : " + loan.validateDelay(date2));
        System.out.println();

        System.out.println("## Comparação 02 de atraso no loan/ emprestimo: ##");
        System.out.println("- Empréstrimo está em atraso? : " + loan.validateDelay(date));
        System.out.println();

        // Testa data de devolução alterada
        System.out.println("## Testa alteração data de devolução: ##");
        System.out.println("- Data de devolução 01: " + loan.returnDate);
        System.out.println("  Será alterada para '2022, 11, 1' ");

        LocalDate date3 = LocalDate.of(2022, 11, 1);
        loan.setReturnDate(date3);

        System.out.println("    + Seta mais tempo para devolução do book: ");
        System.out.println("- Nova data para devolução: " + loan.returnDate);

        System.out.println();
        System.out.println("***************************************************************\n\n");

        // Cria um objeto material
        Material material1 = new Material("001","Programação orientada a objetos","Os poderes da Prof: Fernanda","Univali-Kobrasol");

        // Adiciona o material ao array de materiais dentro da objeto user
        loan.addMatrialInArrayList(material1);

        // Cria data de reserva para teste
        material.addReservation(new Reservation(date));

        System.out.println("    CONSULTA DE MATERIAL \n");

        // Consulta pelo assunto
        System.out.println(" ## - Test I. (existente) ## ");
        System.out.println("        Material está na lista? " + loan.consultMaterial("Programação orientada a objetos"));
        System.out.println();
        System.out.println(" ## - Test II. (Não existente) ## ");
        System.out.println("        Material está na lista? " + loan.consultMaterial("Asunto test II: "));
        System.out.println();

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");

        System.out.println("    - RESERVA DE MATERIAL \n");

        loan.reserveMaterial(user,material);
        //System.out.println(loan.loanArrayList);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");

        System.out.println("    - EMPRÉSTIMO DE MATERIAL \n");
        System.out.println(" ## - Test I. (material reservado) ## ");
        loan.emprestaMaterial(user,material);
        System.out.println();

        System.out.println(" ## - Test II. (material disponível) ## ");
        loan.emprestaMaterial(user,material2);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");

        System.out.println("    DEVOLUÇÃO DE MATERIAL  \n");

        // Mostra devolução de material
        System.out.println(loan.returnMaterial(user,material));
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");

        // Mostra todas as listas
        //loan.showAllList(loan);

        //**** Testes de reserva/ emprestimo/ devolução  ****
        //loan.reserveMaterial(user,material);
        //loan.emprestaMaterial(user,material2);
        //loan.returnMaterial(user,material);

        //loan.showLoanList(loan);
        //loan.showMaterialList(loan);
        //loan.showReservationList(loan);
    }
}
