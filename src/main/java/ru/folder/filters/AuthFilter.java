package ru.folder.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/home")
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //пишем false чтобы не создал сессию
        //        if (request.getSession(false).getAttribute("user") == null){
        //        }
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user")==null){
//            response.sendRedirect(request.getContextPath() + "/login");//нельзя тк мы не работаем в рамках одной страницы
            servletRequest.getServletContext().getRequestDispatcher("/login").forward(request,response);
        } else {
            filterChain.doFilter(request,response);//фильтруй дальше
        }
    }

    @Override
    public void destroy() {

    }
}