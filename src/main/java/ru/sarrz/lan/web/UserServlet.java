package ru.sarrz.lan.web;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.sarrz.lan.model.Role;
import ru.sarrz.lan.model.User;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class UserServlet extends HttpServlet {

    private ConfigurableApplicationContext springContext;
    private AbstractUserController userController;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        springContext = new ClassPathXmlApplicationContext("spring/spring-app.xml", "spring/spring-db.xml");
        userController = springContext.getBean(AbstractUserController.class);
    }

    @Override
    public void destroy() {
        springContext.close();
        super.destroy();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            User user = new User(
                    req.getParameter("firstName"),
                    req.getParameter("lastName"),
                    req.getParameter("email"));
            if (req.getParameter("id").isEmpty()) {
                userController.create(user);
            } else {
                userController.update(user, getId(req));
            }
            resp.sendRedirect("users");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action==null?"all":action){
            case "delete":
                int id = getId(req);
                userController.delete(id);
                resp.sendRedirect("users");
                break;
            case "create":
            case "update":
                final User user = "create".equals(action)?
                        new User("","","111@sss.ru"): userController.get(getId(req));
                req.setAttribute("user",user);
                req.getRequestDispatcher("/userForm.jsp").forward(req,resp);
                break;
            case "all":
            default:
                req.setAttribute("users", userController.getAll());
                req.getRequestDispatcher("/users.jsp").forward(req,resp);
                break;

        }


    }
    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.parseInt(paramId);
    }
}
