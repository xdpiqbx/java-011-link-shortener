package cw.lnkshort.web;

import cw.lnkshort.storage.DatabaseInitService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/*")
public class FronController extends HttpServlet {
  @Override
  public void init(){
    DatabaseInitService.initDb();
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.getWriter().write("Success!");
    resp.getWriter().close();
  }
}
