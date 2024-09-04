package repositories;

import entities.Book;
import enums.Genre;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.List;

public class BookRepository {
    public void saveBook (Book book) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Transaction transaction = session.getTransaction();

        session.save(book);

        transaction.commit();
        session.close();
    }

    public void updateBook (Book book) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Transaction transaction = session.getTransaction();

        session.update(book);

        transaction.commit();
        session.close();
    }

    public Book findBookById(int id){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Book Book = session.get(Book.class,id);

        session.getTransaction().commit();
        session.close();

        return Book;
    }

    public void deleteBook(int id){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Book book = findBookById(id);
        if(book != null) {
            session.delete(book);
        }
        session.getTransaction().commit();
        session.close();
    }

    public List<Book> filteredBooksByGenre(Genre desiredGenre){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        String hql = "SELECT b FROM Book b WHERE Genre = :parametru";
        Query<Book> query = session.createQuery(hql, Book.class);
        query.setParameter("parametru", desiredGenre.name());
        List<Book> returnedBooks = query.getResultList();
//            try {
//                desiredGenre = Genre.valueOf(chosenGenre);
//                System.out.println(desiredGenre + " chosen as genre" + "\n");
//
//            } catch (IllegalArgumentException e) {
//                System.out.println("No books on selected genre. Review our genre list and provide a new one" + "\n");
//
//            }

        session.getTransaction().commit();
        session.close();

        return returnedBooks;
    }


}





