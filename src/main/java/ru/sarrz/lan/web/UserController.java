package ru.sarrz.lan.web;

import org.springframework.stereotype.Controller;
import ru.sarrz.lan.model.User;

@Controller
public class UserController extends AbstractUserController {

    public User get() {
        return super.get(AuthorizedUser.id());
    }

    public void delete() {
        super.delete(AuthorizedUser.id());
    }

    public void update(User user) {
        super.update(user, AuthorizedUser.id());
    }
}
