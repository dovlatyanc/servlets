package servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/quote")
public class QuoteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h1>Цитата Линуса Торвальдса</h1>");
        out.println("<p>Bad programmers worry about the code. " +
                "Good programmers worry about data structures and their relationships</p>");
        out.println("<a href='/servlets-maven-tomcat-1.0-SNAPSHOT/'>Назад</a>");
        out.println("</body></html>");
    }
}