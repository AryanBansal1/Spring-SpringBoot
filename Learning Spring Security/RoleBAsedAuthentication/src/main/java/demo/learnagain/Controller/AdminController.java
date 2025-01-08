package demo.learnagain.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import demo.learnagain.Entity.Booking;
import demo.learnagain.Service.UserService;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/Admin")
public class AdminController {
    
    @Autowired
    UserService ser;

    @GetMapping("/")
    public void Getbookingpage(HttpServletResponse response) throws IOException {
        List<Booking> bookings = ser.GetAllBooking();

        // Generate HTML content
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append("<html>")
                .append("<head><title>All Bookings</title></head>")
                .append("<body>")
                .append("<h1>All Bookings</h1>")
                .append("<table border='1'>")
                .append("<tr>")
                .append("<th>ID</th><th>Full Name</th><th>Email</th><th>Phone</th><th>Address</th>")
                .append("</tr>");

        for (Booking booking : bookings) {
            htmlBuilder.append("<tr>")
                    .append("<td>").append(booking.getId()).append("</td>")
                    .append("<td>").append(booking.getFullName()).append("</td>")
                    .append("<td>").append(booking.getEmail()).append("</td>")
                    .append("<td>").append(booking.getPhone()).append("</td>")
                    .append("<td>").append(booking.getAddress()).append("</td>")
                    .append("</tr>");
        }

        htmlBuilder.append("</table>")
                .append("</body>")
                .append("</html>");

        // Write the generated HTML directly to the response
        response.setContentType("text/html");
        response.getWriter().write(htmlBuilder.toString());
    }
}