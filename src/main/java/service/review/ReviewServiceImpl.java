package service.review;

import entities.Book;
import entities.Member;
import entities.Review;
import enums.RatedAt;
import repositories.BookRepository;
import repositories.MemberRepository;
import repositories.ReviewRepository;

import java.util.List;
import java.util.Scanner;

public class ReviewServiceImpl implements ReviewService {

    private final BookRepository bookRepository = new BookRepository();
    private final MemberRepository memberRepository = new MemberRepository();
    private final ReviewRepository reviewRepository = new ReviewRepository();

    @Override
    public void saveReview(Scanner scanner) {
        System.out.println("Please provide your member ID: ");
        int memberId = Integer.parseInt(scanner.nextLine());

        System.out.println("Please provide the ID of the book you want to review: ");
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

        System.out.println("Please provide your rating for this book you want to review (I, II, III, IV, or V): ");
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

        System.out.println("Please provide the ID of the book you want to se the reviews for: ");
        int bookId = Integer.parseInt(scanner.nextLine());

        Book foundBook = bookRepository.findBookById(bookId);

        if (foundBook == null) {
            System.out.println("Book not found, please try again.");
            return;
        } else {
            System.out.println("The following book record has been found:" + "\n" + foundBook);
        }

        System.out.println("The reviews for the book with ID: " + bookId + " are as follows: ");

        List<Review> reviewsFound = reviewRepository.showReviewsByBookId(bookId);

        if(reviewsFound.isEmpty()) {
            System.out.println("Presently no reviews yet for this book.");
            return;
        }

        System.out.println();
        System.out.printf("+------------+---------+---------------------------------------------------------------------------------------------------------------+-----%n");
        System.out.printf("%-12s | %-7s | %-90s |%n", "Review ID", "Rating", "Comments");
        System.out.printf("+------------+---------+---------------------------------------------------------------------------------------------------------------+----%n");

        reviewsFound.forEach(System.out::println);

    }


}
// for cases 15 and 16:
// must increment the reviews / ratings number - isReviewed to be changed from boolean to int
// OR
// rating as enum -> returns int ( as I = 1, II = 2...) so top rating is numbersOfMembersWhoRatedTheBook multiplied by 5 :), also the new rating value should add to current rating status