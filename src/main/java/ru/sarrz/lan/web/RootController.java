package ru.sarrz.lan.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;
import ru.sarrz.lan.service.UserService;
import ru.sarrz.lan.to.UserTo;
import ru.sarrz.lan.util.UserUtil;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class RootController extends AbstractUserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String root() {
        return "login";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/users")
    public String users() {
        return "users";
    }

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    @GetMapping("/profile")
    public String profile() {
        return "profile";
    }

    @PostMapping("/profile")
    public String updateProfile(@Valid UserTo userTo, BindingResult result, SessionStatus status) {
        if (result.hasErrors()) {
            return "profile";
        } else {
            super.update(userTo, AuthorizedUser.id());
            AuthorizedUser.get().update(userTo);
            status.setComplete();
            return "redirect:profile";
        }
    }

    @GetMapping("/register")
    public String register(ModelMap model) {
        model.addAttribute("userTo", new UserTo());
        model.addAttribute("register", true);
        return "profile";
    }

    @PostMapping("/register")
    public String saveRegister(@Valid UserTo userTo, BindingResult result, SessionStatus status, ModelMap model) {
        if (result.hasErrors()) {
            model.addAttribute("register", true);
            return "profile";
        } else {
            super.create(UserUtil.createNewFromTo(userTo));
            status.setComplete();
            return "redirect:login?message=app.registered&username=" + userTo.getEmail();
        }
    }

//    @PostMapping("/users")
//    public String setUser(HttpServletRequest request) {
//        int userId = Integer.valueOf(request.getParameter("userId"));
//        AuthorizedUser.setId(userId);
//        return "redirect:meals";
//    }
}
