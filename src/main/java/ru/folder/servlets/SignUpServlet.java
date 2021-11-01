package ru.folder.servlets;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.folder.dao.UsersDao;
import ru.folder.dao.UsersDaoImpl;
import ru.folder.dao.UsersDaoJdbcTemplateImpl;
import ru.folder.models.User;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Properties;

@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {
    private UsersDao usersDao;

    @Override
    public void init() throws ServletException {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream(getServletContext().getRealPath("WEB-INF/classes/db.properties")));

            String dbURL = properties.getProperty("db.url");
            String dbUserName = properties.getProperty("db.username");
            String dbPassword = properties.getProperty("db.password");
            String driverClassName = properties.getProperty("db.driverClassName");

            dataSource.setUsername(dbUserName);
            dataSource.setPassword(dbPassword);
            dataSource.setUrl(dbURL);
            dataSource.setDriverClassName(driverClassName);

            usersDao = new UsersDaoJdbcTemplateImpl(dataSource);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> ourUsers = usersDao.findAll();
        request.setAttribute("usersFromOurPostgreSQL", ourUsers);
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/jsp/signUp-jstl.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String firstName = request.getParameter("first_name");
//        String lastName = request.getParameter("last_name");
//        String password = request.getParameter("password");
//
//        User user = new User(firstName, lastName, password);
//
//        usersDao.save(user);
//
//        doGet(request, response);
    }
}
