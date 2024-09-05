package service.review;

import java.util.Scanner;

public interface ReviewService {
    void saveReview(Scanner scanner);
    void updateReview(Scanner scanner);
    void showReviewsByBookId(Scanner scanner);
    void showTopBooksByRating(Scanner scanner);
}
