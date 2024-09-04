package repositories;

import entities.Book;
import entities.Loan;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

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


}
