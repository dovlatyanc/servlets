package servlets;



import jakarta.servlet.ServletException;
import model.Manufactures;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/manufacturer")

public class ManufacturerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();

        Manufactures manufactures = new Manufactures(
                1L,
                "Dell Technologies",
                "США",
                "/images/dell_logo.png",
                165000,
                "Компания Dell Technologies является одним" +
                        " из крупнейших мировых производителей компьютеров и IT-оборудования."
        );

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><meta charset='UTF-8'><title>О производителе</title></head>");
        out.println("<body style='font-family: Arial, sans-serif; padding: 30px;'>");
        out.println("<h1>Информация о производителе</h1>");
        out.println("<img src='" + manufactures.getLogoUrl() + "' alt='Логотип' style='max-width: 200px;'><br><br>");
        out.println("<p><strong>Название:</strong> " + manufactures.getName() + "</p>");
        out.println("<p><strong>Страна:</strong> " +manufactures.getCountry() + "</p>");
        out.println("<p><strong>Сотрудников:</strong> " + manufactures.getEmployeeCount() + "</p>");
        out.println("<p><strong>Описание:</strong><br>" + manufactures.getShortDescription() + "</p>");
        out.println("</body>");
        out.println("</html>");
    }
}