package cw.lnkshort.web.command;

import org.thymeleaf.TemplateEngine;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CommandService implements Command{
  private Command defaultCommand;
  private Map<String, Command> commands;
  public CommandService(){
    commands = new HashMap<>();
    commands.put("GET /", new IndexCommand());
    commands.put("GET /list", new ListCommand());
    commands.put("GET /link/delete", new DeleteLinkCommand());
    commands.put("GET /link/create", new GetCreateLinkCommand());
    commands.put("POST /link/create", new PostCreateLinkCommand());

    defaultCommand = new RedirectCommand();
  }
  @Override
  public void process(HttpServletRequest req, HttpServletResponse resp, TemplateEngine engine) throws IOException{
    String requestURI = req.getRequestURI();
    String requestMethod = req.getMethod();

    String commandKey = requestMethod + " " + requestURI;

    System.out.println("commandKey = " + commandKey);

    Command command = commands.get(commandKey);
    if(command != null){
      command.process(req, resp, engine);
    }else{
      defaultCommand.process(req, resp, engine);
    }
  }
}
