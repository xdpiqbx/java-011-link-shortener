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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListCommand implements Command {
    @Override
    public void process(HttpServletRequest req, HttpServletResponse resp, TemplateEngine engine) throws IOException {
        resp.setContentType("text/html; charset=utf-8");

        LinkService linkService = ServiceProvider.get(LinkService.class);
        List<Link> links = null;

        if(req.getParameterMap().containsKey("query")){
            links = linkService.search(req.getParameter("query"));
        }else{
            links = linkService.listAll();
        }

        Map<String, Object> params = new HashMap<>();
        params.put("links", links);
        params.put("query", req.getParameter("query"));

        Context context = new Context(req.getLocale(), params);

        engine.process("list", context, resp.getWriter());
        resp.getWriter().close();
    }
}
