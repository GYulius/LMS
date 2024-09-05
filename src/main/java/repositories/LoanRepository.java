package repositories;

import entities.Book;
import entities.Loan;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.List;

public class LoanRepository {

    public void saveLoan (Loan loan) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Transaction transaction = session.getTransaction();

        session.save(loan);

        transaction.commit();
        session.close();
    }

    public void updateLoan (Loan loan) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Transaction transaction = session.getTransaction();

        session.update(loan);

        transaction.commit();
        session.close();
    }

    public Loan findLoanById(int id){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Loan loan = session.get(Loan.class,id);

        session.getTransaction().commit();
        session.close();

        return loan;
    }

    public Loan findActiveLoanByBookId(int bookId){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        String hql = "SELECT l FROM Loan l WHERE book_id = :parametru AND isReturned = false";
        Query<Loan> query = session.createQuery(hql, Loan.class);
        query.setParameter("parametru", bookId);

        Loan activeLoan = query.getSingleResult();

        session.getTransaction().commit();
        session.close();

        return activeLoan;
    }

    public List<Loan> showActiveLoansByMemberId(int memberId) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        String hql = "SELECT l FROM Loan l WHERE member_id = :parametru AND isReturned = false";
        Query<Loan> query = session.createQuery(hql, Loan.class);
        query.setParameter("parametru", memberId);
        List<Loan> activeLoansByMember = query.getResultList();

        // Loan activeLoan = query.getSingleResult();

        session.getTransaction().commit();
        session.close();

        return activeLoansByMember;

    }
}
