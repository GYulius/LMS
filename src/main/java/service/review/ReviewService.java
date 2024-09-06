package service.review;

import java.util.Scanner;

public interface ReviewService {
    void saveReview(Scanner scanner); // case 13
    // void updateReview(Scanner scanner); -- OOS
    void showReviewsByBookId(Scanner scanner); // case 14
    void searchBooksByRating(Scanner scanner); // case 15
    void showTopBooksByRating(Scanner scanner); // case 16
}
