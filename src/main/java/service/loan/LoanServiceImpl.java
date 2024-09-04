package service.loan;

import entities.Book;
import entities.Loan;
import entities.Member;
import repositories.BookRepository;
import repositories.LoanRepository;
import repositories.MemberRepository;

import java.time.LocalDate;
import java.util.Scanner;

public class LoanServiceImpl implements LoanService {

    private final BookRepository bookRepository = new BookRepository();
    private final MemberRepository memberRepository = new MemberRepository();
    private final LoanRepository loanRepository = new LoanRepository();

    @Override
    public void loanBook(Scanner scanner) {

        System.out.println("Please provide your member record: ");
        int memberId = Integer.parseInt(scanner.nextLine());

        System.out.println("Please provide the number of the book record you want to loan: ");
        int bookId = Integer.parseInt(scanner.nextLine());

        Member foundMember = memberRepository.findMemberById(memberId);
        Book foundBook = bookRepository.findBookById(bookId);


        if (foundBook == null || foundMember == null) {
            System.out.println("Book/Member not found, please try again.");

        } else {
            System.out.println("Hello, " + "\n" + foundMember.getFirstName());
            System.out.println("The following book record has been found:" + "\n" + foundBook.toString());
        }

        if (foundBook.isLoaned() == true) {
            // posibilitate de imbunatatire
            System.out.println("Book already loaned.");
            return;
        }

        Loan loan = Loan.builder()
                .member(foundMember)
                .book(foundBook)
                .loanDate(LocalDate.now())
                .returnDate(LocalDate.now().plusDays(14))
                .build();

        loanRepository.saveLoan(loan);
        foundBook.setLoaned(true);
        bookRepository.updateBook(foundBook);

    }

    @Override
    public void returnBook(Scanner scanner) {

        System.out.println("Please provide the book id: ");
        int bookId = Integer.parseInt(scanner.nextLine());

        Book foundBook = bookRepository.findBookById(bookId);

        if (foundBook == null) {
            System.out.println("Book not found, please try again.");

        } else {

            System.out.println("The following book record has been found:" + "\n" + foundBook.toString());
        }


        Loan loan = loanRepository.findLoanById(int loanId);
        loan.setReturned(true);
        loanRepository.updateLoan(loan);

    }
}

/*
1. id membru
2. id book
3. verificare isLoaned pe Book (true/false) => a. true => se poate returna => update loan return date
                                               b. false => no books to return

querry => loanId unde book id = citit and loan.isReturned(false)

 */