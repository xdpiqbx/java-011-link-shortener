package cw.lnkshort.web.command;

import cw.lnkshort.link.Link;
import cw.lnkshort.link.LinkService;
import cw.lnkshort.link.ShortLinkGenerator;
import cw.lnkshort.serviceprovider.ServiceProvider;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

public class PostCreateLinkCommand implements Command {
    @Override
    public void process(HttpServletRequest req, HttpServletResponse resp, TemplateEngine engine) throws IOException {
        String fullUrl = req.getParameter("fullUrl");
        String shortUrl;

        LinkService linkService = ServiceProvider.get(LinkService.class);

        do {
            shortUrl = new ShortLinkGenerator().generate();
        } while (linkService.getByShortLink(shortUrl) != null);

        Link link = new Link();
        link.setShortLink(shortUrl);
        link.setLink(fullUrl);
        linkService.save(link);

        resp.sendRedirect("/list");
//
//        resp.setContentType("text/html; charset=utf-8");
//
//        Context context = new Context(
//                req.getLocale(),
//                Collections.emptyMap()
//        );
//
//        engine.process("create-link", context, resp.getWriter());
//        resp.getWriter().close();
    }
}
