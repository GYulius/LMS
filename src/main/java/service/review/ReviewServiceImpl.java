package service.review;

import entities.Book;
import entities.Member;
import entities.Review;
import repositories.BookRepository;
import repositories.MemberRepository;
import repositories.ReviewRepository;
import java.util.Scanner;

public class ReviewServiceImpl implements ReviewService {

    private final BookRepository bookRepository = new BookRepository();
    private final MemberRepository memberRepository = new MemberRepository();
    private final ReviewRepository reviewRepository = new ReviewRepository();

    @Override
    public void saveReview(Scanner scanner) {
        System.out.println("Please provide your member record: ");
        int memberId = Integer.parseInt(scanner.nextLine());

        System.out.println("Please provide the number of the book record you want to review: ");
        int bookId = Integer.parseInt(scanner.nextLine());

        Member foundMember = memberRepository.findMemberById(memberId);
        Book foundBook = bookRepository.findBookById(bookId);

        if (foundBook == null || foundMember == null) {
            System.out.println("Book/Member not found, please try again.");
            return;
        } else {
            System.out.println("Hello, " + "\n" + foundMember.getFirstName());
            System.out.println("The following book record has been found:" + "\n" + foundBook);
        }

        System.out.println("Please provide your rating for this book you want to review (1 to 5): ");
        int yourRating = Integer.parseInt(scanner.nextLine());

        System.out.println("Please provide your comment for this book you want to review: ");
        String yourComment = scanner.nextLine();

        Review review = Review.builder()
                .member(foundMember)
                .book(foundBook)
                .rating(yourRating)
                .comment(yourComment)
                .build();

        reviewRepository.saveReview(review);
        foundBook.setReviewed(true);
        bookRepository.updateBook(foundBook);

        System.out.println("The book with ID: " + bookId + " was reviewed successfully.");
    }

//    @Override    -- OOS
//    public void updateReview(Scanner scanner) {
//
//    }

    @Override
    public void showReviewsByBookId(Scanner scanner) {

    }

    @Override
    public void searchBooksByRating(Scanner scanner) {

    }

    @Override
    public void showTopBooksByRating(Scanner scanner) {

    }
}

// must increment the rating