import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datamodel.Book;
import util.Info;
import util.UtilDB;

@WebServlet("/SimpleSearchHB")
public class SimpleSearchHB extends HttpServlet implements Info {
   private static final long serialVersionUID = 1L;

   public SimpleSearchHB() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String keyword = request.getParameter("keyword").trim();

      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      String title = "Database Result";
      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">\n"; //
      out.println(docType + //
            "<html>\n" + //
            "<head><title>" + title + "</title></head>\n" + //
            "<body bgcolor=\"#f0f0f0\">\n" + //
            "<h1 align=\"center\">" + title + "</h1>\n");
      out.println("<ul>");

      List<Book> listBooks = null;
      if (keyword != null && !keyword.isEmpty()) {
         listBooks = UtilDB.listBooks(keyword);
      } else {
         listBooks = UtilDB.listBooks();
      }
      display(listBooks, out);
      out.println("</ul>");
      out.println("<a href=/" + projectName + "/" + searchWebName + ">Search Data</a> <br>");
      out.println("</body></html>");
   }

   void display(List<Book> listBooks, PrintWriter out) {
      for (Book book : listBooks) {
         System.out.println("[DBG] " + book.getId() + ", " //
               + book.getTitle() + ", " //
               + book.getAuthor() + ", "//
               + book.getGenre() + ", "//
               + book.getMood() + ", "//
               + book.getPriority());

         out.println("<li>" + book.getId() + ", " //
               + book.getTitle() + ", " //
               + book.getAuthor() + ", "//
               + book.getGenre() + ", "//
               + book.getMood() + ", "//
               + book.getPriority() + "</li>");
      }
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}
