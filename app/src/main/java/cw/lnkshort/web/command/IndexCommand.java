package cw.lnkshort.web.command;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

public class IndexCommand implements Command {
    @Override
    public void process(HttpServletRequest req, HttpServletResponse resp, TemplateEngine engine) throws IOException {
        resp.setContentType("text/html; charset=utf-8");

        Context context = new Context(
                req.getLocale(),
                Collections.emptyMap()
        );

        engine.process("index", context, resp.getWriter());
        resp.getWriter().close();
    }
}
