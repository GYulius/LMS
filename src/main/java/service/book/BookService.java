package service.book;

import java.util.Scanner;

public interface BookService {
    void insertBook(Scanner scanner);
    void editBookRecord(Scanner scanner);
    void viewBookRecord(Scanner scanner);
    void deleteBookRecord(Scanner scanner);
    void searchBookByGenre(Scanner scanner);
    void searchBooksByRating(Scanner scanner);
    void showTopBooksByRating();

}
