package cw.lnkshort.storage;

import lombok.Getter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.*;

public class HibernateUtil {
  private static final HibernateUtil INSTANCE;
  static {
    INSTANCE = new HibernateUtil();
  }
  @Getter
  private final SessionFactory sessionFactory;
  private HibernateUtil(){
    sessionFactory = new Configuration()
      .setProperty("hibernate.connection.url", StorageConstants.CONNECTION_URL)
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
