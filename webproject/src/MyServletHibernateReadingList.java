import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datamodel.Book;
import util.UtilDB;

@WebServlet("/MyServletHibernateReadingList")
public class MyServletHibernateReadingList extends HttpServlet {
   private static final long serialVersionUID = 1L;

   public MyServletHibernateReadingList() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setContentType("text/html");
      // could be a source of problems
      retrieveDisplayData(response.getWriter());
   }

   void retrieveDisplayData(PrintWriter out) {
      String title = "Your Reading List";
      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + //
            "transitional//en\">\n"; //
      out.println(docType + //
            "<html>\n" + //
            "<head><title>" + title + "</title></head>\n" + //
            "<body bgcolor=\"#f0f0f0\">\n" + //
            "<h1 align=\"center\">" + title + "</h1>\n");
      out.println("<ul>");
      List<Book> listBooks = UtilDB.listBooks();
      for (Book book : listBooks) {
         System.out.println("[DBG] " + book.getId() + ", " //
               + book.getTitle() + ", "//
               + book.getAuthor() + ", "//
               + book.getGenre() + ", "//
               + book.getMood() + ", "//
               + book.getPriority());

         out.println("<h4>" + book.getTitle() + "</h4>" //
               + "<li>Id: " + book.getId() + "</li>" //
               + "<li>Author: " + book.getAuthor() + "</li>"//
               + "<li>Genre: " + book.getGenre() + "</li>"//
               + "<li>Mood: " + book.getMood() + "</li>"//
               + "<li>Priority: " + book.getPriority() + "</li>");
      }
      out.println("</ul>");
      out.println("<a href=/webproject/simpleSearchHB.html" + ">Search Reading List</a> <br>");
      out.println("<a href=/webproject/simpleInsertHB.html" + ">Insert to Reading List</a> <br>");
      out.println("</body></html>");
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}