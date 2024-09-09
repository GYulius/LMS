package util;

import service.book.BookServiceImpl;
import service.loan.LoanServiceImpl;
import service.member.MemberServiceImpl;
import service.review.ReviewServiceImpl;

import java.util.Scanner;

public class LibraryCli {
    private final BookServiceImpl bookService = new BookServiceImpl();
    private final MemberServiceImpl memberService = new MemberServiceImpl();
    private final LoanServiceImpl loanService = new LoanServiceImpl();
    private final ReviewServiceImpl reviewService = new ReviewServiceImpl();

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
        System.out.println("9. Search book by genre");
        System.out.println("10. Loan book");
        System.out.println("11. Return book");
        System.out.println("12. Show active loans by member");
        System.out.println("13. Add a review for a book");
        System.out.println("14. Show the reviews for a book");
        System.out.println("15. Search books by rating");
        System.out.println("16. Show top 10 books with the best rating");
        System.out.println("17. Exit menu");
        System.out.println(" ");
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
                memberService.editMemberRecord(scanner);
                break;
            case 5:
                bookService.viewBookRecord(scanner);
                break;
            case 6:
                memberService.viewMemberRecord(scanner);
                break;
            case 7:
                bookService.deleteBookRecord(scanner);
                break;
            case 8:
                memberService.deleteMemberRecord(scanner);
                break;
            case 9:
                bookService.searchBookByGenre(scanner);
                break;
            case 10:
                loanService.loanBook(scanner);
                break;
            case 11:
                loanService.returnBook(scanner);
                break;
            case 12:
                loanService.showActiveLoansByMemberId(scanner);
                break;
            case 13:
                reviewService.saveReview(scanner);
                break;
            case 14:
                reviewService.showReviewsByBookId(scanner);
                break;
            case 15:
                bookService.searchBooksByRating(scanner);
                break;
            case 16:
                bookService.showTopBooksByRating();
                break;
            case 17:
                System.out.println("Exiting the Library Application");
                System.exit(0);
                break;
            default:
                System.out.println("Not a valid option. Try again after checking command line available options");
        }
    }
}
