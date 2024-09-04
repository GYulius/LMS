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

        Book book = session.get(Book.class,id);

        session.getTransaction().commit();
        session.close();

        return book;
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

        session.getTransaction().commit();
        session.close();

        return returnedBooks;
    }


}





