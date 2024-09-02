package util;

import repositories.BookRepository;
import repositories.MemberRepository;

import java.util.Scanner;

public class LibraryCli {
    private final BookRepository bookRepository = new BookRepository();
    private final MemberRepository memberRepository = new MemberRepository();

    public void startLibraryCli() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. TO DO");
            System.out.println("2. TO DO");
            System.out.println("3. Iesire din aplicatie");

            int userChoice = scanner.nextInt();

            switch(userChoice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    System.out.println("Exiting the Library Application");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Optiunea aleasa nu este valida");
            }
        }
    }
}
