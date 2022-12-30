package cw.lnkshort.link;

import java.util.List;

public interface LinkService {
    public Link getByShortLink(String shortLink);
    public void save(Link link);
    public void deleteByShortLink(String shortLink);
    List<Link> listAll();
    List<Link> search(String query);
}
