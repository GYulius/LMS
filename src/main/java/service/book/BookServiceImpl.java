package service.book;

import entities.Book;
import enums.Genre;
import enums.RatedAt;
import repositories.BookRepository;

import java.util.List;
import java.util.Scanner;


public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository = new BookRepository();

    public static void displayAllGenres() {
        for (Genre genre : Genre.values()) {
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
        System.out.println("Please check our genre list above and then pick (copy and paste) the genre for your book.");

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

        if (foundBook != null) {
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

        if (foundBook != null) {
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

        if (foundBook != null) {
            System.out.println("The following record has been found:" + "\n" + foundBook.getId() + "\n" + foundBook.getTitle() + "\n" + foundBook.getAuthor() + "\n" + foundBook.getGenre() + "\n" + foundBook.getDescription());

            bookRepository.deleteBook(foundBook.getId());

            System.out.println("Book record deleted successfully.");

        } else {
            System.out.println("Book not found, please provide an new Book ID.");
        }


    }

    @Override
    public void searchBookByGenre(Scanner scanner) {
        System.out.println("Please choose the desired genre of the book from below to get search results.");

        displayAllGenres();
        System.out.println("Please check our genre list and then choose the genre for your book.");

        Genre desiredGenre = null;

        while (desiredGenre == null) {
            String chosenGenre = scanner.nextLine();
            try {
                desiredGenre = Genre.valueOf(chosenGenre);
                System.out.println(desiredGenre + " chosen as genre" + "\n");

            } catch (IllegalArgumentException e) {
                System.out.println("No books on selected genre. Review our genre list and provide a new one" + "\n");

            }
        }
        List<Book> retrievedBooks = bookRepository.filteredBooksByGenre(desiredGenre);
        System.out.println("test");
        retrievedBooks.forEach(System.out::println);

    }


    @Override
    public void searchBooksByRating(Scanner scanner) {
        System.out.println("Please provide the rating (as I, II, III, IV or V) to see which books got it: ");


        RatedAt ratedNow = null;

        while (ratedNow == null) {
            RatedAt chosenRating = RatedAt.valueOf(scanner.nextLine());
            try {
                ratedNow = RatedAt.valueOf(String.valueOf(chosenRating));
                System.out.println(ratedNow + " chosen as rating" + "\n");

            } catch (IllegalArgumentException e) {
                System.out.println("No books on selected rating. Review our rating options list and try again." + "\n");

            }
        }
        List<Book> showBooks = bookRepository.searchBooksByRating(ratedNow);
        System.out.println("test");
        showBooks.forEach(System.out::println);

        System.out.println();
        System.out.printf("+------------+---------+---------------------------------------------------------------------------------------------------------------+-----%n");
        System.out.printf("%-12s | %-7s | %-90s |%n", "Book ID", "Title", "Comments");
        System.out.printf("+------------+---------+---------------------------------------------------------------------------------------------------------------+----%n");

        showBooks.forEach(System.out::println);

    }

    @Override
    public void showTopBooksByRating(Scanner scanner) {

    }
}