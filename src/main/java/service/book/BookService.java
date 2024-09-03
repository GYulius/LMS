package service.book;

import java.util.Scanner;

public interface BookService {
    void insertBook(Scanner scanner);
    void editBookRecord();
    void viewBookRecord();
    void deleteBookRecord();
}
