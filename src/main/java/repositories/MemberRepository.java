package repositories;

import entities.Book;
import entities.Member;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class MemberRepository {
    public void saveMember (Member member) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Transaction transaction = session.getTransaction();

        session.save(member);

        transaction.commit();
        session.close();
    }

    public void updateMember (Member member) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Transaction transaction = session.getTransaction();

        session.update(member);

        transaction.commit();
        session.close();
    }

    public Member findMemberById(int id){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Member member = session.get(Member.class,id);

        session.getTransaction().commit();
        session.close();

        return member;
    }

    public void deleteMember(int id){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Member member = findMemberById(id);
        if(member != null) {
            session.delete(member);
        }
        session.getTransaction().commit();
        session.close();
    }
}
