package m1.orientada.a.objetos;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        System.out.println("#################################################################");
        System.out.println("                BIENVENDIDOS");
        System.out.println("#################################################################");
        System.out.println("    TRABALHO M1 22/1 – POO em Java, Prof. Fernanda Cunha.");
        System.out.println("    Aluno: Leonardo Dario Borges.");
        System.out.println("#################################################################");
        System.out.println();

        // Cria todos os objetos para fins de implementação da atividade
        /**
         *      -   User
         *      -   Loan
         *      -   Material
         *      -   Book
         *      -   Magazine
         *      -   Article
         *      -   Reservatio
         */

        User user = new User();
        Loan loan = new Loan();
        Material material = new Material();
        Book book = new Book();
        Magazine magazine = new Magazine();
        Article article = new Article();

        // Imprime todos os objetos
        System.out.println("    ## - Imprime todos os objetos: ##");
        System.out.println("-----------------------------------------");

        System.out.println("- Imprime objeto user: \n" + "- " + user);
        System.out.println("\n-----------------------------------------\n");

        // Imprime objeto loan
        System.out.println("    - Imprime objeto loan: \n" + "- " + loan);
        System.out.println("\n-----------------------------------------\n");

        // Imprime objeto material:
        System.out.println("    - Imprime objeto material: \n" + "- " + material);
        System.out.println("\n-----------------------------------------\n");

        // Imprime objeto book
        System.out.println("    - Imprime objeto book: \n" + "- " + book);
        System.out.println("\n-----------------------------------------\n");

        // Imprime objeto magazine
        System.out.println("    - Imprime objeto magazine: \n" + "- " + magazine);
        System.out.println("\n-----------------------------------------\n");

        // Iprime objeto article
        System.out.println("    - Imprime objeto article: \n" + "- " + article);
        System.out.println("\n-----------------------------------------\n");


        // Cria as datas para usar nos testes
        LocalDate date = LocalDate.now();                           // Data atual
        LocalDate date1 = LocalDate.now().plusDays(15);             // Data atual + 15 dias
        LocalDate date2 = LocalDate.now().minusDays(10);            // Data atual - 10 dias

        System.out.println("    - Imprime as datas para teste: ");
        System.out.println("Data atual          : " + date);
        System.out.println("Data atual + 15 dias: " + date1);
        System.out.println("Data atual - 10 dias: " + date2);
        System.out.println("\n-----------------------------------------\n");

        // Preenche os atributos dos objetos:

        // Objeto da classe User
        user.setName("Leonardo Borges");
        user.setPassword(1234);
        user.setPhone(48999999);
        User user2 = new User("Faniela",5555,800800);

        System.out.println("- Imprime objeto user: \n" + "- " + user);
        System.out.println("\n-----------------------------------------\n");

        // Objeto da classe Material
        material.setCode("001");
        material.setSubject("Programação e boas práticas");
        material.setTitle("Clean code");
        material.setPublishingCompany("Prof. Fernanda Cunha - Univali");

        // Instancia objeto reservation da classe Reservation
        Reservation reservation = new Reservation(date);

        // Adiciona reserva no objeto material
        material.addReservation(reservation);

        // Imprime objeto material:
        System.out.println("    - Imprime objeto material: \n" + "- " + material);
        System.out.println("\n-----------------------------------------\n");

        // Objeto da classe Loan
        loan.setLoanDate(date);
        loan.setReturnDate(date1);
        loan.setDelay(false);
        loan.setMaterial(material);
        loan.setUser(user);

        // Imprime objeto loan
        System.out.println("    - Imprime objeto loan: \n" + "- " + loan);
        System.out.println("\n-----------------------------------------\n");

        // Objeto da classe Book
        //System.out.println(book);
        book.setAuthor("Leonardo D. Borges");
        //book.setTitle("A VIDA PREFERIDA");
        //System.out.println(book);
        //book.setSubject("Agora uma breve introdução sobre como a vida e impresionantemente perfeita até os minimos detalhes");
        //book.setPublishingCompany("Editora Prof. Fernanda Cunha - Univali 2022");
        book.setIsbn("2022/01");
        //book.setCode("000000053");

        // Imprime objeto book
        System.out.println("    - Imprime objeto book: \n" + "- " + book);
        System.out.println("\n-----------------------------------------\n");

        // Objeto da classe Article, para publicação na magazine/ revista
        article.setAuthor("Leonardo D. Borges");
        article.setTitle("Apreciando o caminho é sem dúvida a melhor escolha");
        article.setResume("Decimos apreciar la vida y fumamos y bebemos y drogas y motos y autopistas inseguras y gastamos el tiempo de manera tan baja que parece odiar la vida y la naturaleza. \\n\" +\n" +
                "       \"Cualquiera hoy en día es profesor o maestro o especialista, siendo que saber un poquitín más que otros no te torna especialista. \\n\" +\n" +
                "       \"Si las personas se unieran serían tan fuertes y potentes pero no, los locos se pelean y dale guerras y corrupción. \\n\" +\n" +
                "       \"Por otro lado los que esperan que algún día pase algo tan hermoso y fantástico que le saque de su realidad y le lleve a otra vida o patamar, esperando algo tan esperando por la mayoría, algo especial, algo que le transforma.\\n\" +\n" +
                "       \"Transforma su belleza, su carácter y sus virtudes y también sus sueños y anhelos más profundos de un piscar de ojos. Pero en el fondo saben que si no mueven el culo no van a ninguna parte. \\n\" +\n" +
                "       \"Qué día!!\\n\" +\n" +
                "       \"Como los que más filosofan y saben y entienden y todo, eso dicen" +
                "           Algo si se! que de esta vida no sale nadie vivo....\n"
        );

        // Iprime objeto article
        System.out.println("    - Imprime objeto article: \n" + "- " + article);
        System.out.println("\n-----------------------------------------\n");


        // Objeto da classe Magazine
        magazine.addPublication(article);
        magazine.setColection("PREMIUM");
        magazine.setIssn("2022-01");
        magazine.setNumber(0001);

        // Imprime objeto magazine
        System.out.println("    - Imprime objeto magazine: \n" + "- " + magazine);
        System.out.println("\n-----------------------------------------\n");

        // Objeto da classe Reservation
        reservation.setReservationDate(date);

        // Imprime objeto reservation
        System.out.println("    - Imprime objeto reservation: \n" + "- " + reservation);
        System.out.println("\n-----------------------------------------\n");


        System.out.println("########################################################");
        System.out.println("#            - TESTES DE FUNCIONALIDAES  -             #");
        System.out.println("########################################################\n");

        // Consulta material por asunto
        System.out.println("- Consulta material por asunto: ");
        System.out.println("  Caso exista material do assunto retorna o objeto material, caso contrário mensagem de inexistente. \n");

        // Cria um objeto material
        Material material1 = new Material("001","Programação orientada a objetos","Os poderes da Prof: Fernanda","Univali-Kobrasol");
        Material material2 = new Material("progamação","CLAEN CODE");

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

        loan.reserveMaterial(user,material1);
        //loan.showReservationList(loan);
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
