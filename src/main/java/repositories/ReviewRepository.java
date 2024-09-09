package repositories;

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


}
