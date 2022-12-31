package cw.lnkshort.web.command;

import cw.lnkshort.link.Link;
import cw.lnkshort.link.LinkService;
import cw.lnkshort.serviceprovider.ServiceProvider;
import org.thymeleaf.TemplateEngine;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RedirectCommand implements Command{
  @Override
  public void process(HttpServletRequest req, HttpServletResponse resp, TemplateEngine engine) throws IOException {
    String shortLink = req.getRequestURI().replace("/", "");

    LinkService linkService = ServiceProvider.get(LinkService.class);
    Link link = linkService.getByShortLink(shortLink);

    System.out.println("req.getRequestURI() = " + req.getRequestURI());
    System.out.println("link = " + link);

    // TODO What if link not exists
    link.setOpenCount(link.getOpenCount() + 1);
    linkService.save(link);

    String fullLink = link.getLink();
    resp.sendRedirect(fullLink);
  }
}
