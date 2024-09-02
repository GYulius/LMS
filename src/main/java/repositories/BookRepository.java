package repositories;

import entities.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

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

    // TODO: Continue oon repository
}
