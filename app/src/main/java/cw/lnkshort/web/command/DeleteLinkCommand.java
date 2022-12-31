package cw.lnkshort.web.command;

import cw.lnkshort.link.LinkService;
import cw.lnkshort.serviceprovider.ServiceProvider;
import org.thymeleaf.TemplateEngine;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteLinkCommand implements Command{
  @Override
  public void process(HttpServletRequest req, HttpServletResponse resp, TemplateEngine engine) throws IOException {
    String shortLink = req.getParameter("shortlink");
    LinkService linkService = ServiceProvider.get(LinkService.class);
    linkService.deleteByShortLink(shortLink);
    resp.sendRedirect("/list");
  }
}
