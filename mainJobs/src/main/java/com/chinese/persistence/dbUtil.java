package com.chinese.persistence;

/**
 * Created by xu_s on 1/5/16.
 */
import com.chinese.jobs.model.Job;
import com.chinese.jobs.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class dbUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    private static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void addDBObject(Object oj) {
        SessionFactory sf = getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        session.save(oj);
        session.getTransaction().commit();
        session.close();
    }

    public static void updateDBObject(Object oj){
        SessionFactory sf = getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        session.update(oj);
        session.getTransaction().commit();
        session.close();
    }

    public static List<Job> loadJobForUser(long userId){
        SessionFactory sf = getSessionFactory();
        Session session = sf.openSession();
        User user = (User)session.get(User.class, userId);
        return user.getJobs();
    }

    public static User loadUser(long userId){
        SessionFactory sf = getSessionFactory();
        Session session = sf.openSession();
        User user = (User)session.get(User.class, userId);
        return user;
    }

    public static boolean isUserNameUsed(String userName){
        SessionFactory sf = getSessionFactory();
        Session session = sf.openSession();
        Query query = session.createQuery("from User where userAccountName = :userNam");
        query.setParameter("userNam", userName);
        return query.executeUpdate() == 1;
    }
}
