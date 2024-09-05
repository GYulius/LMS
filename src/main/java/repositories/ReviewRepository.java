package repositories;

import entities.Book;
import entities.Loan;
import entities.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.List;

public class ReviewRepository {
            public void saveReview (Review review) {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Transaction transaction = session.getTransaction();

            session.save(review);

            transaction.commit();
            session.close();
        }

    public void updateReview (Review review) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Transaction transaction = session.getTransaction();

        session.update(review);

        transaction.commit();
        session.close();
    }

    public List<Review> showReviewsByBookId(int bookId) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        String hql = "SELECT r FROM Review r WHERE book_id = :parametru";
        Query<Review> query = session.createQuery(hql, Review.class);
        query.setParameter("parametru", bookId);
        List<Review> reviewsByBookId = query.getResultList();

        session.getTransaction().commit();
        session.close();

        return reviewsByBookId;
    }

    public List<Book> showTopBooksByRating(int rating) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        String hql = "SELECT b FROM Book b WHERE review.rating = 5 ORDER BY book.title LIMIT 10";
        Query<Book> query = session.createQuery(hql, Book.class);
        List<Book> bestRatedBooks = query.getResultList();

        session.getTransaction().commit();
        session.close();

        return bestRatedBooks;
    }

}
