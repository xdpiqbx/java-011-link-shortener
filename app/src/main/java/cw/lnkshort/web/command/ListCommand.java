package cw.lnkshort.web.command;

import cw.lnkshort.link.Link;
import cw.lnkshort.link.LinkService;
import cw.lnkshort.serviceprovider.ServiceProvider;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

public class ListCommand implements Command {
    @Override
    public void process(HttpServletRequest req, HttpServletResponse resp, TemplateEngine engine) throws IOException {
        resp.setContentType("text/html; charset=utf-8");

        LinkService linkService = ServiceProvider.get(LinkService.class);

//        Link link = new Link();
//        link.setShortLink("sdhg");
//        link.setLink("https://google.com");
//        linkService.save(link);

        Context context = new Context(
                req.getLocale(),
                Collections.singletonMap("links", linkService.listAll())
        );

        engine.process("list", context, resp.getWriter());
        resp.getWriter().close();
    }
}
