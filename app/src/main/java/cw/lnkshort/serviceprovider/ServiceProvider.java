package cw.lnkshort.serviceprovider;

import cw.lnkshort.link.LinkService;
import cw.lnkshort.link.LinkServiceHibernate;

import java.util.HashMap;
import java.util.Map;

public class ServiceProvider {
  private static final Map<Class<? extends Object>, Object> SERVICES = new HashMap<>();

  static{
    SERVICES.put(LinkService.class, new LinkServiceHibernate());
  }
  @SuppressWarnings("unchecked")
  public static <T>T get(Class<T> tClass){
    return (T)SERVICES.get(tClass);
  }
}
