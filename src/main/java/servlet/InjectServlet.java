package servlet;

import entity.Book;
import inject.MyInject;
import inject.NumberGenerator;
import inject.QualifierInjectTest;
import inject.ThirteenDigits;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.BookService;

/**
 * Сервлет - внедрение зависимостей
 */
@WebServlet (urlPatterns = {"/inject"})
public class InjectServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * Внедрение ресурса с использование квалификатора
     */
    @Inject @QualifierInjectTest
    private MyInject injectTest;

    @Inject @ThirteenDigits
    private NumberGenerator numberGenerator2;

    @Inject
    private BookService service;

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
            out.println("<h2>Тестовый сервлет</h2>");
            try
            {
                print(out, "Test Inject: " + injectTest);
                print(out, "NumberGenerator: " + numberGenerator2);
                print(out, "NumberGenerator: " + numberGenerator2.generateNumber());
                print(out, "BookService: " + service);
                out.println("Book: " + createBook());
            }
            catch (Exception exception)
            {
                print(out, "Book: exception");
                print(out, "Exception: " + exception.getMessage());
                print(out, "Exception: " + exception.toString());
            }
            out.println("</br><a href=\"./\">Home</a>");
            out.println("</body></html>");

        }
        catch (Exception exception)
        {
            System.out.println(exception.getMessage());
        }
    }

    private void print(PrintWriter out, String line)
    {
        out.println("<p>" + line + "</p>");
    }

    private Book createBook() throws Exception
    {
        Book book = service.createBook("H2G2", 12.5f, "Интересная книга на тему высоких технологий");
        return book;
    }
}
