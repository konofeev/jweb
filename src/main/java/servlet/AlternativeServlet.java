package servlet;

import alternative.GenerateString;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet ("/alternative")
public class AlternativeServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    @Inject
    private GenerateString generateString;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    {
        try
        (
            PrintWriter out = new PrintWriter
            (
                new OutputStreamWriter
                (
                    response.getOutputStream(),
                    StandardCharsets.UTF_8
                ),
                true
            )
        )
        {
            response.setCharacterEncoding("utf8");
            response.setContentType("text/html; charset=utf8");
            out.println("<html><head>");
            out.println("<title>Тестовый сервлет</title>");
            out.println("</head><body>");
            out.println("<h2>Альтернативы</h2>");
            out.println("<p>" + generateString.generate() + "</p>");
            out.println("</body></html>");
        }
        catch (Exception exception)
        {
            System.out.println(exception.getMessage());
        }
    }
}
