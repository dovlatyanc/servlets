package servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.*;

@WebServlet("/pizza-order")
public class PizzaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("""
            <!DOCTYPE html>
            <html>
            <head>
                <meta charset="UTF-8">
                <title>Заказ пиццы</title>
                <style>
                    body { font-family: Arial; padding: 20px; }
                    form { max-width: 500px; }
                    input, select { margin: 5px 0; padding: 8px; width: 100%; }
                    .pizza-options { display: flex; gap: 10px; flex-wrap: wrap; }
                    .pizza-option { border: 1px solid #ccc; padding: 10px; cursor: pointer; }
                    .pizza-option:hover { background: #f0f0f0; }
                </style>
            </head>
            <body>
                <h1> Заказ пиццы</h1>
                <a href="/web-app/">← На главную</a>
                <hr>
                
                <form method="POST">
                    <h3>Ваши данные:</h3>
                    <input type="text" name="name" placeholder="Ваше имя" required><br>
                    <input type="tel" name="phone" placeholder="Телефон" required><br>
                    <input type="email" name="email" placeholder="Email"><br>
                    <input type="text" name="address" placeholder="Адрес доставки" required><br>
                    
                    <h3>Выберите пиццу:</h3>
                    <div class="pizza-options">
                        <label class="pizza-option">
                            <input type="radio" name="pizza" value="Маргарита" checked>
                             Маргарита
                        </label>
                        <label class="pizza-option">
                            <input type="radio" name="pizza" value="Четыре сыра">
                             Четыре сыра
                        </label>
                        <label class="pizza-option">
                            <input type="radio" name="pizza" value="Капричоза">
                             Капричоза
                        </label>
                        <label class="pizza-option">
                            <input type="radio" name="pizza" value="Гавайская">
                             Гавайская
                        </label>
                    </div>
                    
                    <h3>Дополнительные топпинги:</h3>
                    <label><input type="checkbox" name="topping" value="оливки">  Оливки</label><br>
                    <label><input type="checkbox" name="topping" value="сыр">  Доп. сыр</label><br>
                    <label><input type="checkbox" name="topping" value="грибы">  Грибы</label><br>
                    <label><input type="checkbox" name="topping" value="помидоры">  Помидоры</label><br>
                    
                    <h3>Конструктор пиццы:</h3>
                    <label>
                        <input type="checkbox" name="custom" value="true">
                        Создать свою пиццу
                    </label><br>
                    
                    <h3>Карта доставки:</h3>
                    <div style="border: 2px solid blue; padding: 10px; text-align: center;">
                         Зона доставки (типо карта) 
                    </div>
                    <p style="color: gray; font-size: 12px;">
                        Доставляем только в центральный район
                    </p>
                    
                    <br>
                    <input type="submit" value="Заказать" style="background: #4CAF50; color: white; padding: 10px 20px;
                     border: none; cursor: pointer;">
                </form>
            </body>
            </html>
        """);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String pizza = request.getParameter("pizza");
        String[] toppings = request.getParameterValues("topping");
        String custom = request.getParameter("custom");

        boolean canDeliver = checkAddress(address);

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html><head><meta charset='UTF-8'><title>Результат заказа</title></head>");
        out.println("<body>");
        out.println("<h1>" + (canDeliver ? "Заказ принят!" : " Доставка невозможна") + "</h1>");
        out.println("<a href='/web-app/pizza-order'>← Новый заказ</a><br>");
        out.println("<a href='/web-app/'>← На главную</a>");
        out.println("<hr>");

        out.println("<h3>Данные заказа:</h3>");
        out.println("<p><strong>Имя:</strong> " + name + "</p>");
        out.println("<p><strong>Телефон:</strong> " + phone + "</p>");
        out.println("<p><strong>Адрес:</strong> " + address + "</p>");
        out.println("<p><strong>Пицца:</strong> " + pizza + "</p>");

        if (toppings != null && toppings.length > 0) {
            out.println("<p><strong>Топпинги:</strong> " + String.join(", ", toppings) + "</p>");
        }

        if ("true".equals(custom)) {
            out.println("<p><strong>Тип:</strong> Кастомная пицца</p>");
        }

        if (canDeliver) {
            out.println("<p style='color: green;'> Доставка по адресу возможна</p>");
            out.println("<p>Информация отправлена на email: " + email + "</p>");
            out.println("<p>Ожидайте курьера в течение часа</p>");
        } else {
            out.println("<p style='color: red;'> Доставка по адресу невозможна</p>");
            out.println("<p>Мы не доставляем в ваш район. Выберите другой адрес.</p>");
        }

        // Можно добавить сохранение в БД


        out.println("</body></html>");
    }

    private boolean checkAddress(String address) {
        // Простая проверка района
        address = address.toLowerCase();
        return address.contains("центр") ||
                address.contains("ул.") ||
                address.contains("улица") ||
                address.contains("проспект");
    }
}