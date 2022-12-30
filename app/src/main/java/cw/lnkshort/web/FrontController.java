package cw.lnkshort.web;

import cw.lnkshort.storage.DatabaseInitService;
import cw.lnkshort.web.command.CommandService;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/*")
public class FrontController extends HttpServlet {
  private TemplateEngine engine;
  private CommandService commandService;
  @Override
  // Цей метод викликає Tomcat.
  // init() виступає в ролі конструктора
  public void init(){
    DatabaseInitService.initDb();

    engine = new TemplateEngine();

    ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
    resolver.setPrefix("templates/");
    resolver.setSuffix(".html");
    resolver.setTemplateMode("HTML5");
    resolver.setCharacterEncoding("UTF-8");
    resolver.setCacheable(false);
    engine.addTemplateResolver(resolver);

    commandService = new CommandService();
  }

  // Кожен запит який надходить, буде перенаправлено у service
  // у CommandService на кожен запит буде свій обробник
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    commandService.process(req, resp, engine);
  }
}
