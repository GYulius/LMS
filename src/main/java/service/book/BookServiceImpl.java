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
    public void editBookRecord(Scanner scanner) {

        System.out.println("Please provide the number of the book record you want to edit: ");

        int bookId = Integer.parseInt(scanner.nextLine());

        Book foundBook = bookRepository.findBookById(bookId);

        if(foundBook != null) {
            System.out.println("The following record has been found:" + "\n" + foundBook.getId() + "\n" + foundBook.getTitle() + "\n" + foundBook.getAuthor() + "\n" + foundBook.getGenre() + "\n" + foundBook.getDescription());
            System.out.println("Please provide the new description: ");
            String newDescription = scanner.nextLine();

            foundBook.setDescription(newDescription);

            bookRepository.updateBook(foundBook);

            System.out.println("Book record updated successfully. The new description is: " + newDescription);

        } else {
            System.out.println("Book not found, please provide an new Book ID.");
        }
    }

    @Override
    public void viewBookRecord(Scanner scanner) {
        System.out.println("Please provide the number of the book record you want to view: ");

        int bookId = Integer.parseInt(scanner.nextLine());

        Book foundBook = bookRepository.findBookById(bookId);

        if(foundBook != null) {
            System.out.println(foundBook);
        } else {
            System.out.println("Book not found, please provide an new Book ID.");
        }

    }

    @Override
    public void deleteBookRecord(Scanner scanner) {
        System.out.println("Please provide the number of the book record you want to delete: ");

        int bookId = Integer.parseInt(scanner.nextLine());

        Book foundBook = bookRepository.findBookById(bookId);

        if(foundBook != null) {
            System.out.println("The following record has been found:" + "\n" + foundBook.getId() + "\n" + foundBook.getTitle() + "\n" + foundBook.getAuthor() + "\n" + foundBook.getGenre() + "\n" + foundBook.getDescription());

            bookRepository.deleteBook(foundBook.getId());

            System.out.println("Book record deleted successfully.");

        } else {
            System.out.println("Book not found, please provide an new Book ID.");
        }
    }
}
