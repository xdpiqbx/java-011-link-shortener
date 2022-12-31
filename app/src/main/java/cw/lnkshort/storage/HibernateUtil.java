package cw.lnkshort.storage;

import cw.lnkshort.link.Link;
import lombok.Getter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.*;

public class HibernateUtil {
  private static final HibernateUtil INSTANCE;
  @Getter
  private final SessionFactory sessionFactory;

  static {
    INSTANCE = new HibernateUtil();
  }

  private HibernateUtil(){
    sessionFactory = new Configuration()
      .setProperty("hibernate.connection.url", StorageConstants.CONNECTION_URL)
      .addAnnotatedClass(Link.class)
      .buildSessionFactory();
  }

  public static HibernateUtil getInstance(){
    return INSTANCE;
  }
  public void close(){
    sessionFactory.close();
  }

  public static void main(String[] args) {
//    DatabaseInitService.initDb();
    HibernateUtil util = HibernateUtil.getInstance();
//    Session session = util.getSessionFactory().openSession();
//
//    session.close();
  }
}
