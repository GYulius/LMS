package util;

import repositories.MemberRepository;
import service.book.BookServiceImpl;
import service.member.MemberServiceImpl;

import java.util.Scanner;

public class LibraryCli {
    private final BookServiceImpl bookService = new BookServiceImpl();
    private final MemberServiceImpl memberService = new MemberServiceImpl();

    public void startLibraryCli() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            displayMenu();
            executeUserChoiceAction(scanner);
        }
    }
    public void displayMenu() {
        System.out.println("1. Add a book");
        System.out.println("2. Add a member");
        System.out.println("3. Edit a book record");
        System.out.println("4. Edit a member record");
        System.out.println("5. View a book record");
        System.out.println("6. View a member record");
        System.out.println("7. Delete a book record");
        System.out.println("8. Delete a member record");
        System.out.println("9. Exit menu");
    }
    private void executeUserChoiceAction(Scanner scanner) {
        int userChoice = Integer.parseInt(scanner.nextLine());
        switch(userChoice) {
            case 1:
                bookService.insertBook(scanner);
                break;
            case 2:
                memberService.insertMember(scanner);
                break;
            case 3:
                bookService.editBookRecord(scanner);
                break;
            case 4:
                memberService.editMemberRecord();
                break;
            case 5:
                bookService.viewBookRecord(scanner);
                break;
            case 6:
                memberService.viewMemberRecord();
                break;
            case 7:
                bookService.deleteBookRecord(scanner);
                break;
            case 8:
                memberService.deleteMemberRecord();
                break;
            case 9:
                System.out.println("Exiting the Library Application");
                System.exit(0);
                break;
            default:
                System.out.println("Not a valid option. Try again after checking command line available options");
        }
    }
}
