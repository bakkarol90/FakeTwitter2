package AppUserDAO;

import hibernate.util.HibernateUtil;
import org.hibernate.Hibernate;

import javax.persistence.EntityManager;

public class AbstractAppUserDao {

    protected final HibernateUtil hibernateUtil = HibernateUtil.getInstance();
    protected final EntityManager em = hibernateUtil.getEm();

}
