package util;

import entities.Book;
import enums.Genre;
import repositories.BookRepository;
import repositories.MemberRepository;

import java.util.Scanner;

public class LibraryCli {
    private final BookRepository bookRepository = new BookRepository();
    private final MemberRepository memberRepository = new MemberRepository();

    public void startLibraryCli() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add a book");
            System.out.println("2. Add a member");
            System.out.println("3. Edit a book record");
            System.out.println("4. Edit a member record");
            System.out.println("5. View a book record");
            System.out.println("6. View a member record");
            System.out.println("7. Delete a book record");
            System.out.println("8. Delete a member record");
            System.out.println("9. Exit menu");

            int userChoice = Integer.parseInt(scanner.nextLine());

            switch(userChoice) {
                case 1:
                    insertBook(scanner);
                    break;
                case 2:
                    insertMember();
                    break;
                case 3:
                    editBookRecord();
                    break;
                case 4:
                    editMemberRecord();
                    break;
                case 5:
                    viewBookRecord();
                    break;
                case 6:
                    viewMemberRecord();
                    break;
                case 7:
                    deleteBookRecord();
                    break;
                case 8:
                    deleteMemberRecord();
                    break;
                case 9:
                    System.out.println("Exiting the Library Application");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Not a valid option. Try again after checking our manual");
            }

        }
    }

    public void insertBook(Scanner scanner){

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
                System.out.println("Review our genre list" + "\n");

            }
        }
        Book addedBook = Book.builder()
                .title(title)
                .author(author)
                .genre(genre)
                .build();
        bookRepository.saveBook(addedBook);
        System.out.println("Book " + addedBook.getTitle() + " inserted succesfully");

    }

    public static void displayAllGenres() {

        for (Genre genre : Genre.values()){
            System.out.println(genre.toString());
        }
    }

    public void insertMember(){

    }

    public void editBookRecord(){

    }

    public void editMemberRecord(){

    }

    public void viewBookRecord(){

    }

    public void viewMemberRecord(){

    }

    public void deleteBookRecord(){

    }

    public void deleteMemberRecord(){

    }
}
