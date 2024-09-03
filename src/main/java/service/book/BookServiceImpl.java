package service.book;

import entities.Book;
import enums.Genre;
import repositories.BookRepository;

import java.util.Scanner;


public class BookServiceImpl implements BookService{
    private final BookRepository bookRepository = new BookRepository();
    public static void displayAllGenres() {
        for (Genre genre : Genre.values()){
            System.out.println(genre.toString());
        }
    }

    @Override
    public void insertBook(Scanner scanner) {

        System.out.println("Please provide a title");
        String title = scanner.nextLine();

        System.out.println("Please enter the author of the book");
        String author = scanner.nextLine();

        displayAllGenres();
        System.out.println("Please check our genre list and then choose the genre for your book.");

        Genre genre = null;

        while (genre == null) {
            String chosenGenre = scanner.nextLine();
            try {
                genre = Genre.valueOf(chosenGenre);
                System.out.println(genre + " chosen as genre" + "\n");

            } catch (IllegalArgumentException e) {
                System.out.println(" Invalid genre. Review our genre list and provide a new one" + "\n");

            }
        }

        System.out.println("Please enter the description");
        String description = scanner.nextLine();

        Book addedBook = Book.builder()
                .title(title)
                .author(author)
                .genre(genre)
                .description(description)
                .build();
        bookRepository.saveBook(addedBook);
        System.out.println("Book " + addedBook.getTitle() + " inserted successfully");

    }

    @Override
    public void editBookRecord() {

    }

    @Override
    public void viewBookRecord() {

    }

    @Override
    public void deleteBookRecord() {

    }
}
