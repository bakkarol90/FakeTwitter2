package hibernate.util;

import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

    private static HibernateUtil instance;
    private final EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyDatabase");
    private final EntityManager em = factory.createEntityManager();

    private HibernateUtil() {

    }

    public static HibernateUtil getInstance() {
        if (instance == null) {
            instance = new HibernateUtil();
        }
        return instance;
    }

    public void save(Object o) {
        em.getTransaction().begin();
        if (!em.contains(o)) {
            em.persist(o);
            em.flush();
        }
        em.getTransaction().commit();
    }

    public void delete(Class clazz, Long id) {
        em.getTransaction().begin();
        Object o = em.find(clazz, id);
        if (null != o) {
            em.remove(o);
        }
        em.getTransaction().commit();
    }

    public EntityManager getEm() {
        return em;
    }
}