package servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calc")
public class CalcServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("""
            <html>
            <body>
                <h1>Калькулятор трех чисел</h1>
                <form method="post">
                    Число 1: <input type="text" name="num1"><br>
                    Число 2: <input type="text" name="num2"><br>
                    Число 3: <input type="text" name="num3"><br>
                    <input type="radio" name="operation" value="max" checked> Максимум<br>
                    <input type="radio" name="operation" value="min"> Минимум<br>
                    <input type="radio" name="operation" value="avg"> Среднее<br>
                    <input type="submit" value="Вычислить">
                </form>
                   out.println("<a href='/web-app/'>Назад</a>");
            </body>
            </html>
            """);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            double n1 = Double.parseDouble(request.getParameter("num1"));
            double n2 = Double.parseDouble(request.getParameter("num2"));
            double n3 = Double.parseDouble(request.getParameter("num3"));
            String op = request.getParameter("operation");

            double result = 0;
            String opName = "";

            if ("max".equals(op)) {
                result = Math.max(Math.max(n1, n2), n3);
                opName = "Максимум";
            } else if ("min".equals(op)) {
                result = Math.min(Math.min(n1, n2), n3);
                opName = "Минимум";
            } else if ("avg".equals(op)) {
                result = (n1 + n2 + n3) / 3;
                opName = "Среднее";
            }

            out.println("<html><body>");
            out.println("<h1>Результат</h1>");
            out.println("<p>Числа: " + n1 + ", " + n2 + ", " + n3 + "</p>");
            out.println("<p><b>" + opName + ": " + result + "</b></p>");
            out.println("<a href='/servlets-maven-tomcat-1.0-SNAPSHOT/calc'>Еще раз</a><br>");
            out.println("<a href='/servlets-maven-tomcat-1.0-SNAPSHOT/'>На главную</a>");
            out.println("</body></html>");

        } catch (NumberFormatException e) {
            out.println("<html><body>");
            out.println("<h2>Ошибка! Введите числа</h2>");
            out.println("<a href='/servlets-maven-tomcat-1.0-SNAPSHOT/calc'>Назад</a>");
            out.println("</body></html>");
        }
    }
}