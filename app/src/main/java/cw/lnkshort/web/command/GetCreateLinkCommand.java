package cw.lnkshort.web.command;

import cw.lnkshort.link.LinkService;
import cw.lnkshort.serviceprovider.ServiceProvider;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

public class GetCreateLinkCommand implements Command {
    @Override
    public void process(HttpServletRequest req, HttpServletResponse resp, TemplateEngine engine) throws IOException {
        resp.setContentType("text/html; charset=utf-8");

        Context context = new Context(
                req.getLocale(),
                Collections.emptyMap()
        );

        engine.process("create-link", context, resp.getWriter());
        resp.getWriter().close();
    }
}
