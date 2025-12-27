package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/multiplication-table")
public class MultyTableServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h2>Таблица умножения</h2>");
        out.println("<form method='post'>");
        out.println("Выберите число: ");
        out.println("<select name='number' required>");
        for (int i = 0; i <= 20; i++) {
            out.println("<option value='" + i + "'>" + i + "</option>");
        }
        out.println("</select>");
        out.println("<input type='submit' value='Показать таблицу'>");
        out.println("<div></div>");
        out.println("<label>");
        out.println("<input type='checkbox' name='learned' value='true'>");
        out.println("Я выучил таблицу умножения");
        out.println("</label>");
        out.println("</form>");
        out.println("</body></html>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        int number = Integer.parseInt(req.getParameter("number"));
        String isLearned = Boolean.parseBoolean(req.getParameter("learned")) ?"Выучил таблицу умножения":"Не выучил таблицу умножения";
        out.println("<html><body>");
        out.println("<h2>Таблица умножения на " + number + "</h2>");

        for (int i = 1; i <= 10; i++) {
            int result = number * i;
            out.println("<div>");
            out.println("<div>" + number + " × " + i + "=" + result + "</div>");
            out.println("</div>");


        }
        out.println("<div> "+ isLearned + "<div/>");
        out.println("<a href='/web-app/'>Назад</a>");


    }


}

