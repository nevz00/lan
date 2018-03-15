package ru.sarrz.lan.web;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.sarrz.lan.model.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping(value = "/users")
public class AdminRestController extends AbstractUserController{
//    static final String REST_URL="/rest/admin/users";


    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("user", new User("","","111@sss.ru"));
        return "userForm";
    }

    @GetMapping("/delete")
    public String delete(HttpServletRequest request) {
        super.delete(getId(request));
        return "redirect:/users";
    }

    @GetMapping("/update")
    public String update(HttpServletRequest request, Model model) {
        model.addAttribute("user", super.get(getId(request)));
        return "userForm";
    }

    @PostMapping
    public String updateOrCreate(HttpServletRequest request) {
        User user = new User(request.getParameter("firstName")
        ,request.getParameter("lastName")
        ,request.getParameter("email"));

        if (request.getParameter("id").isEmpty()) {
            super.create(user);
        } else {
            super.update(user, getId(request));
        }
        return "redirect:/users";
    }

    //@Override
//    @GetMapping(value = "/by",produces = MediaType.APPLICATION_JSON_VALUE)
//    public User getByMail(/*@RequestParam("email")*/ String email) {
//        return super.getByMail(email);
//    }

    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.valueOf(paramId);
    }
}
