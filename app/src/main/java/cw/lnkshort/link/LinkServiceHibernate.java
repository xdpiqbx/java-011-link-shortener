package cw.lnkshort.link;

import cw.lnkshort.storage.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class LinkServiceHibernate implements LinkService{
  @Override
  public Link getByShortLink(String shortLink) {
    try(Session session = openSession()){
      return session.get(Link.class, shortLink);
    }
  }

  @Override
  public void save(Link link) {
    try(Session session = openSession()){
      Transaction transaction = session.beginTransaction();
      session.persist(link);
      transaction.commit();
    }
  }

  @Override
  public void deleteByShortLink(String shortLink) {
    try(Session session = openSession()){
      Transaction transaction = session.beginTransaction();
      session.remove(getByShortLink(shortLink));
      transaction.commit();
    }
  }

  @Override
  public List<Link> listAll() {
    try(Session session = openSession()){
      return session.createQuery("from Link", Link.class).list();
    }
  }

  @Override
  public List<Link> search(String query) {
      String hql = "from Link where shortLink like '%"+query+ "%' or link like '%" + query+ "%'";
    try(Session session = openSession()){
      return session.createQuery(hql, Link.class).list();
    }
  }

  private Session openSession(){
    return HibernateUtil.getInstance().getSessionFactory().openSession();
  }
}
