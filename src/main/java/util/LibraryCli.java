package util;

import repositories.MemberRepository;
import service.book.BookServiceImpl;

import java.util.Scanner;

public class LibraryCli {
    private final BookServiceImpl bookService = new BookServiceImpl();
    private final MemberRepository memberRepository = new MemberRepository();

    public void startLibraryCli() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            displayMenu();
            executeUserChoiceAction(scanner);
        }
    }
    public void insertMember(){

    }
    public void editBookRecord(){

    }
    public void editMemberRecord(){

    }
    public void viewBookRecord(){

    }
    public void viewMemberRecord(){

    }
    public void deleteBookRecord(){

    }
    public void deleteMemberRecord(){
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
                insertMember();
                break;
            case 3:
                editBookRecord();
                break;
            case 4:
                editMemberRecord();
                break;
            case 5:
                viewBookRecord();
                break;
            case 6:
                viewMemberRecord();
                break;
            case 7:
                deleteBookRecord();
                break;
            case 8:
                deleteMemberRecord();
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
