package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
                                                                           
/**
 * Фильтр кодировки
 * Читаем данные в кодировке UTF-8
 */
@WebFilter("/*")
public class CharacterEncodingFilter implements Filter 
{
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException 
    {
        request.setCharacterEncoding("UTF-8");
        chain.doFilter(request, response);
    }
}
